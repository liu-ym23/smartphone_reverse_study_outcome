package com.obric.cae.smartNfc.event;

import android.os.Bundle;
import android.os.SystemClock;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class TransitEventFilter {
    private static final long DUPLICATE_EVENT_WINDOW_MS = 500;
    private static final int MAX_PAYLOAD_LENGTH = 4096;
    private static final int MIN_TRANSIT_CARD_PAYLOAD_LENGTH = 20;
    private volatile int mAllowedAidTypeMask;
    private final Object mDedupLock;
    private byte[] mLastAid;
    private String mLastDataUri;
    private long mLastEventTimeMs;
    private byte[] mLastPayload;
    private String mLastSeName;

    public static final class ParsedAid {
        final int aidType;
        final String label;

        public ParsedAid(int r8, String r10) {
            this.aidType = r8;
            this.label = r10;
        }
    }

    public static final class ParsedPayload {
        public ParsedPayload() {
        }
    }

    public static final enum Result extends Enum<Result> {
        private static final /* synthetic */ Result[] $VALUES = null;
        public static final Result ALLOW = null;
        public static final Result DUPLICATE = null;
        public static final Result FILTERED_AID_TYPE = null;
        public static final Result INVALID_PAYLOAD = null;
        public static final Result SHORT_TRANSIT_PAYLOAD = null;

        private static /* synthetic */ Result[] $values() {
            return new Result[]{ALLOW, INVALID_PAYLOAD, DUPLICATE, SHORT_TRANSIT_PAYLOAD, FILTERED_AID_TYPE};
        }

        static {
            ALLOW = new Result("ALLOW", 0);
            INVALID_PAYLOAD = new Result("INVALID_PAYLOAD", 1);
            DUPLICATE = new Result("DUPLICATE", 2);
            SHORT_TRANSIT_PAYLOAD = new Result("SHORT_TRANSIT_PAYLOAD", 3);
            FILTERED_AID_TYPE = new Result("FILTERED_AID_TYPE", 4);
            $VALUES = $values();
        }

        private Result(String r8, int r10) {
            super(r8, r10);
        }

        public static Result valueOf(String r8) {
            return (Result) Enum.valueOf(Result.class, r8);
        }

        public static Result[] values() {
            return (Result[]) $VALUES.clone();
        }
    }

    public TransitEventFilter() {
        this.mDedupLock = new Object();
        this.mAllowedAidTypeMask = 0;
    }

    private static String bytesToHex(byte[] r8) {
        if (r8 != null) goto L4;
        return "";
    L4:
        if (r8.length == 0) goto L14;
        char[] r10 = "0123456789ABCDEF".toCharArray();
        StringBuilder r11 = new StringBuilder(r8.length * 2);
        int r12 = r8.length;
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L10;
        byte r14 = r8[r13];
        r11.append(r10[(r14 >> 4) & 15]);
        r11.append(r10[r14 & 15]);
        r13 = r13 + 1;
        goto L7
    L10:
        return r11.toString();
    L14:
        return "";
    }

    private static byte[] copyOf(byte[] r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        return Arrays.copyOf(r8, r8.length);
    }

    private static boolean dataUriEqualsEmpty(String r8) {
        if (r8 != null) goto L4;
    L7:
        return true;
    L4:
        if (r8.isEmpty() == true) goto L7;
        return false;
    }

    private int getEffectiveAllowedAidTypeMask() {
        if (this.mAllowedAidTypeMask != 0) goto L6;
        return TransitAidConstants.getSupportedExternalAidTypeMask();
    L6:
        return this.mAllowedAidTypeMask;
    }

    private boolean isSameAsLastEvent(String r8, String r10, byte[] r11, byte[] r12) {
        if (r8 == null) goto L14;
        if (r8.isEmpty() == true) goto L14;
        if (r8.equals(this.mLastDataUri) == false) goto L12;
        if (Arrays.equals(r12, this.mLastPayload) == false) goto L12;
        return true;
    L12:
        return false;
    L14:
        if (dataUriEqualsEmpty(this.mLastDataUri) == false) goto L23;
        if (r10.equals(this.mLastSeName) == false) goto L23;
        if (Arrays.equals(r11, this.mLastAid) == false) goto L23;
        if (Arrays.equals(r12, this.mLastPayload) == false) goto L23;
        return true;
    L23:
        return false;
    }

    private static boolean matchesAidRule(String r8, TransitAidConstants.AidRule r10) {
        if (r8 == null) goto L13;
        if (r10 == null) goto L13;
        String r11 = r10.aid;
        if (r11 == null) goto L13;
        if (r10.matchType == 1) goto L12;
        return false;
    L12:
        return r8.equals(r11);
    L13:
        return false;
    }

    private static ParsedAid parseAidByType(String r8, int r10) {
        TransitAidConstants.AidRule[] r11 = TransitAidConstants.AID_RULES;
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L12;
        TransitAidConstants.AidRule r14 = r11[r13];
        if (r14.aidType != r10) goto L10;
        if (matchesAidRule(r8, r14) == false) goto L10;
        return new ParsedAid(r14.aidType, r14.label);
    L10:
        r13 = r13 + 1;
        goto L3
    L12:
        return new ParsedAid(0, null);
    }

    private static ParsedAid parseBankAid(String r8) {
        TransitAidConstants.AidPrefixRule[] r10 = TransitAidConstants.BANK_AID_PREFIX_RULES;
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L10;
        TransitAidConstants.AidPrefixRule r13 = r10[r12];
        if (r8.startsWith(r13.aidPrefix) == true) goto L7;
        r12 = r12 + 1;
        goto L3
    L7:
        return new ParsedAid(r13.aidType, r13.label);
    L10:
        return parseAidByType(r8, 4);
    }

    private static ParsedAid parseTransitAid(String r8) {
        if (r8.startsWith("A000000632010105") == false) goto L7;
        return new ParsedAid(2, "公交通卡AID前缀");
    L7:
        return parseAidByType(r8, 2);
    }

    public Result filter(Bundle r8) {
        if (isValidPayload(r8) == false) goto L5;
        byte[] r10 = r8.getByteArray("android.nfc.extra.AID");
        byte[] r11 = r8.getByteArray("android.nfc.extra.DATA");
        int r12 = parseAllowedAid(r10).aidType;
        if (r12 != 0) goto L11;
        return Result.FILTERED_AID_TYPE;
    L11:
        if (r12 != 2) goto L17;
        if (r11.length >= 20) goto L17;
        return Result.SHORT_TRANSIT_PAYLOAD;
    L17:
        if (isDuplicateEvent(r8) == false) goto L21;
        return Result.DUPLICATE;
    L21:
        return Result.ALLOW;
    L5:
        return Result.INVALID_PAYLOAD;
    }

    public int getAllowedAidTypes() {
        return this.mAllowedAidTypeMask;
    }

    public boolean isDuplicateEvent(Bundle r11) {
        long r8 = SystemClock.elapsedRealtime();
        String r10 = r11.getString("data_uri");
        String r12 = r11.getString("android.nfc.extra.SECURE_ELEMENT_NAME", "");
        byte[] r13 = r11.getByteArray("android.nfc.extra.AID");
        byte[] r14 = r11.getByteArray("android.nfc.extra.DATA");
        Object r15 = this.mDedupLock;
        monitor-enter(r15);
    L15:
        th = move-exception;
        throw th;
    L5:
        if ((r8 - this.mLastEventTimeMs) < DUPLICATE_EVENT_WINDOW_MS) goto L7;
    L11:
        this.mLastDataUri = r10;     // Catch: Throwable -> L15
        this.mLastSeName = r12;     // Catch: Throwable -> L15
        this.mLastAid = copyOf(r13);     // Catch: Throwable -> L15
        this.mLastPayload = copyOf(r14);     // Catch: Throwable -> L15
        this.mLastEventTimeMs = r8;     // Catch: Throwable -> L15
        monitor-exit(r15);     // Catch: Throwable -> L15
        return false;
    L7:
        if (isSameAsLastEvent(r10, r12, r13, r14) == false) goto L11;
        monitor-exit(r15);     // Catch: Throwable -> L15
        return true;
    }

    public boolean isValidPayload(Bundle r8) {
        if (r8 != null) goto L5;
        return false;
    L5:
        byte[] r10 = r8.getByteArray("android.nfc.extra.AID");
        if (r10 != null) goto L8;
        return false;
    L8:
        if (r10.length == 0) goto L25;
        byte[] r11 = r8.getByteArray("android.nfc.extra.DATA");
        if (r11 != null) goto L13;
        return false;
    L13:
        if (r11.length > 4096) goto L26;
        String r12 = r8.getString("android.nfc.extra.SECURE_ELEMENT_NAME");
        if (r12 != null) goto L18;
        return false;
    L18:
        if (r12.isEmpty() == true) goto L24;
        return true;
    L24:
        return false;
    L26:
        return false;
    L25:
        return false;
    }

    public ParsedAid parseAllowedAid(byte[] r8) {
        String r10 = bytesToHex(r8);
        int r11 = getEffectiveAllowedAidTypeMask();
        if ((r11 & 2) == 0) goto L8;
        ParsedAid r12 = parseTransitAid(r10);
        if (r12.aidType == 0) goto L8;
        return r12;
    L8:
        if ((r11 & 1) == 0) goto L13;
        ParsedAid r13 = parseAidByType(r10, 1);
        if (r13.aidType == 0) goto L13;
        return r13;
    L13:
        if ((r11 & 4) == 0) goto L18;
        ParsedAid r14 = parseBankAid(r10);
        if (r14.aidType == 0) goto L18;
        return r14;
    L18:
        return new ParsedAid(0, null);
    }

    public ParsedAid parseAnyAid(byte[] r8) {
        String r10 = bytesToHex(r8);
        ParsedAid r11 = parseTransitAid(r10);
        if (r11.aidType == 0) goto L5;
        return r11;
    L5:
        ParsedAid r12 = parseBankAid(r10);
        if (r12.aidType == 0) goto L8;
        return r12;
    L8:
        TransitAidConstants.AidRule[] r13 = TransitAidConstants.AID_RULES;
        int r14 = r13.length;
        int r15 = 0;
    L9:
        if (r15 >= r14) goto L16;
        TransitAidConstants.AidRule r16 = r13[r15];
        if (matchesAidRule(r10, r16) == true) goto L13;
        r15 = r15 + 1;
        goto L9
    L13:
        return new ParsedAid(r16.aidType, r16.label);
    L16:
        return new ParsedAid(0, null);
    }

    public ParsedPayload parsePayload(byte[] r8) {
        return null;
    }

    public void reset() {
        Object r8 = this.mDedupLock;
        monitor-enter(r8);
        this.mLastDataUri = null;     // Catch: Throwable -> L8
        this.mLastSeName = null;     // Catch: Throwable -> L8
        this.mLastAid = null;     // Catch: Throwable -> L8
        this.mLastPayload = null;     // Catch: Throwable -> L8
        this.mLastEventTimeMs = 0;     // Catch: Throwable -> L8
        monitor-exit(r8);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public boolean setAllowedAidTypes(int r8) {
        if (TransitAidConstants.isValidAidTypeMask(r8) == true) goto L7;
        return false;
    L7:
        if (this.mAllowedAidTypeMask == r8) goto L11;
        this.mAllowedAidTypeMask = r8;
        reset();
        return true;
    L11:
        return true;
    }
}
