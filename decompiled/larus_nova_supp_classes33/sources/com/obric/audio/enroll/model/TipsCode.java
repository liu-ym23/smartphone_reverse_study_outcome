package com.obric.audio.enroll.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/obric/audio/enroll/model/TipsCode;", "", "v", "", "<init>", "(Ljava/lang/String;II)V", "getV", "()I", "TIPS_CODE_CHECKING_ENROLL", "TIPS_CODE_SAY_it", "TIPS_CODE_FASTER_SAY_it", "TIPS_CODE_CHECK_SENTENCE_ERROR", "TIPS_CODE_ERROR_TEXT_SIMILARITY", "TIPS_CODE_CHECK_SENTENCE_NETWORK", "TIPS_CODE_VAD_END_AND_NOT_ENOUGH_SIZE", "TIPS_CODE_ASR_TASK_START_FAILED", "TIPS_CODE_ASR_SESSION_START_FAILED", "TIPS_CODE_ASR_NETWORK_ERROR", "TIPS_CODE_ASR_TIMEOUT_RETRY", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TipsCode extends Enum<TipsCode> {
    public static final TipsCode TIPS_CODE_ASR_NETWORK_ERROR = null;
    public static final TipsCode TIPS_CODE_ASR_SESSION_START_FAILED = null;
    public static final TipsCode TIPS_CODE_ASR_TASK_START_FAILED = null;
    public static final TipsCode TIPS_CODE_ASR_TIMEOUT_RETRY = null;
    public static final TipsCode TIPS_CODE_CHECKING_ENROLL = null;
    public static final TipsCode TIPS_CODE_CHECK_SENTENCE_ERROR = null;
    public static final TipsCode TIPS_CODE_CHECK_SENTENCE_NETWORK = null;
    public static final TipsCode TIPS_CODE_ERROR_TEXT_SIMILARITY = null;
    public static final TipsCode TIPS_CODE_FASTER_SAY_it = null;
    public static final TipsCode TIPS_CODE_SAY_it = null;
    public static final TipsCode TIPS_CODE_VAD_END_AND_NOT_ENOUGH_SIZE = null;
    public static final /* synthetic */ TipsCode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int v;

    public static EnumEntries<TipsCode> getEntries() {
        return b;
    }

    static {
        TipsCode r0 = new TipsCode("TIPS_CODE_CHECKING_ENROLL", 0, 1);
        TIPS_CODE_CHECKING_ENROLL = r0;
        TipsCode r1 = new TipsCode("TIPS_CODE_SAY_it", 1, 0);
        TIPS_CODE_SAY_it = r1;
        TipsCode r4 = new TipsCode("TIPS_CODE_FASTER_SAY_it", 2, 2);
        TIPS_CODE_FASTER_SAY_it = r4;
        TipsCode r5 = new TipsCode("TIPS_CODE_CHECK_SENTENCE_ERROR", 3, -2);
        TIPS_CODE_CHECK_SENTENCE_ERROR = r5;
        TipsCode r7 = new TipsCode("TIPS_CODE_ERROR_TEXT_SIMILARITY", 4, -5);
        TIPS_CODE_ERROR_TEXT_SIMILARITY = r7;
        TipsCode r8 = new TipsCode("TIPS_CODE_CHECK_SENTENCE_NETWORK", 5, -6);
        TIPS_CODE_CHECK_SENTENCE_NETWORK = r8;
        TipsCode r10 = new TipsCode("TIPS_CODE_VAD_END_AND_NOT_ENOUGH_SIZE", 6, -7);
        TIPS_CODE_VAD_END_AND_NOT_ENOUGH_SIZE = r10;
        TipsCode r12 = new TipsCode("TIPS_CODE_ASR_TASK_START_FAILED", 7, -8);
        TIPS_CODE_ASR_TASK_START_FAILED = r12;
        TipsCode r14 = new TipsCode("TIPS_CODE_ASR_SESSION_START_FAILED", 8, -9);
        TIPS_CODE_ASR_SESSION_START_FAILED = r14;
        TipsCode r13 = new TipsCode("TIPS_CODE_ASR_NETWORK_ERROR", 9, -10);
        TIPS_CODE_ASR_NETWORK_ERROR = r13;
        TipsCode r11 = new TipsCode("TIPS_CODE_ASR_TIMEOUT_RETRY", 10, -11);
        TIPS_CODE_ASR_TIMEOUT_RETRY = r11;
        TipsCode[] r9 = {r0, r1, r4, r5, r7, r8, r10, r12, r14, r13, r11};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static TipsCode[] values() {
        return (TipsCode[]) a.clone();
    }

    public final int getV() {
        return this.v;
    }

    public static TipsCode valueOf(String r1) {
        return (TipsCode) a.a(TipsCode.class, r1);
    }

    public TipsCode(String r1, int r2, int r3) {
        super(r1, r2);
        this.v = r3;
    }
}
