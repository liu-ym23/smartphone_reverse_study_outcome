package com.bytedance.crash.protector;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ProtectorConfigBuilder {
    private String mAbi;
    private JSONArray mBacktraces;
    private int mIntervalTimeMs;
    private int mMaxApiLevel;
    private int mMaxIgnoreDepth;
    private int mMaxResumeCount;
    private int mMinApiLevel;
    private JSONObject mRegs;
    private String mScope;
    private JSONArray mSignals;

    public static final enum AbiType extends Enum<AbiType> {
        private static final /* synthetic */ AbiType[] $VALUES = null;
        public static final AbiType ARM64_V8A = null;
        public static final AbiType ARMEABI_V7A = null;
        public static final AbiType BOTH = null;
        private final int value;

        static {
            AbiType r10 = new AbiType("BOTH", 0, 0);
            BOTH = r10;
            AbiType r11 = new AbiType("ARM64_V8A", 1, 1);
            ARM64_V8A = r11;
            AbiType r12 = new AbiType("ARMEABI_V7A", 2, 2);
            ARMEABI_V7A = r12;
            $VALUES = new AbiType[]{r10, r11, r12};
        }

        private AbiType(String r10, int r11, int r12) {
            super(r10, r11);
            this.value = r12;
        }

        static /* synthetic */ int access$000(AbiType r10) {
            return r10.value;
        }

        public static AbiType valueOf(String r10) {
            return (AbiType) Enum.valueOf(AbiType.class, r10);
        }

        public static AbiType[] values() {
            return (AbiType[]) $VALUES.clone();
        }

        int getValue() {
            return this.value;
        }
    }

    public ProtectorConfigBuilder(String r10) {
        this.mScope = null;
        this.mAbi = null;
        this.mSignals = null;
        this.mBacktraces = null;
        this.mRegs = null;
        this.mMaxIgnoreDepth = -1;
        this.mMaxResumeCount = -1;
        this.mIntervalTimeMs = -1;
        this.mMinApiLevel = -1;
        this.mMaxApiLevel = -1;
        if (r10 == null) goto L9;
        if (CrashProtectorConfig.isValidScopeName(r10) == false) goto L9;
        this.mScope = r10;
        return;
    L9:
        throw new IllegalArgumentException("invalid scope: " + r10);
    }

    public ProtectorConfigBuilder addFrame(String r10) {
        return addFrame(r10, null, false);
    }

    public ProtectorConfigBuilder addFrame(String r10, String r11) {
        return addFrame(r10, r11, false);
    }

    public ProtectorConfigBuilder addFrame(String r10, String r11, boolean r12) {
        if (this.mBacktraces != null) goto L5;
        this.mBacktraces = new JSONArray();
    L5:
        JSONObject r13 = new JSONObject();
        r13.put("elf_name", r10);
        if (r11 != null) goto L8;
    L11:
        r13.put("redacted_match", 1);
    L12:
        if (r12 == false) goto L14;
        r13.put("return_from_current_stack", 1);
    L14:
        this.mBacktraces.put(r13);
        return this;
    L8:
        if (r11.isEmpty() == true) goto L11;
        r13.put("symbol_name", r11);
        goto L12
    }

    public ProtectorConfigBuilder addRegister(String r10, long r11) {
        if (this.mRegs != null) goto L6;
        this.mRegs = new JSONObject();
    L6:
        if (CrashProtectorConfig.isValidRegLabel(r10) == false) goto L10;
        this.mRegs.put(r10, r11);
        return this;
    L10:
        throw new IllegalArgumentException("invalid register label: " + r10);
    }

    public ProtectorConfigBuilder addSignal(String r10) {
        if (this.mSignals != null) goto L6;
        this.mSignals = new JSONArray();
    L6:
        if (CrashProtectorConfig.signalStringToNumber(r10) == 0) goto L10;
        this.mSignals.put(r10);
        return this;
    L10:
        throw new IllegalArgumentException("invalid signal: " + r10);
    }

    public JSONObject build() {
        JSONObject r10 = new JSONObject();
        r10.put("scope", this.mScope);
        JSONArray r11 = this.mSignals;
        if (r11 == null) goto L39;
        if (r11.length() == 0) goto L39;
        r10.put("signals", this.mSignals);
        JSONArray r12 = this.mBacktraces;
        if (r12 == null) goto L37;
        if (r12.length() == 0) goto L37;
        r10.put("backtraces", this.mBacktraces);
        JSONObject r13 = this.mRegs;
        if (r13 != null) goto L13;
    L15:
        int r14 = this.mMaxIgnoreDepth;
        if (r14 == (-1)) goto L18;
        r10.put("max_ignore_depth_before_meet_first_match", r14);
    L18:
        int r15 = this.mMaxResumeCount;
        if (r15 == (-1)) goto L21;
        r10.put("max_resume_count", r15);
    L21:
        int r16 = this.mIntervalTimeMs;
        if (r16 == (-1)) goto L24;
        r10.put("interval_time_ms", r16);
    L24:
        int r17 = this.mMinApiLevel;
        if (r17 == (-1)) goto L27;
        r10.put("min_api_level", r17);
    L27:
        int r18 = this.mMaxApiLevel;
        if (r18 == (-1)) goto L30;
        r10.put("max_api_level", r18);
    L30:
        String r19 = this.mAbi;
        if (r19 != null) goto L33;
    L35:
        return r10;
    L33:
        if (r19.isEmpty() == true) goto L35;
        r10.put("abi", this.mAbi);
        goto L35
    L13:
        if (r13.length() <= 0) goto L15;
        r10.put("registers", this.mRegs);
    L37:
        throw new Exception("empty backtraces");
    L39:
        throw new Exception("empty signals");
    }

    public ProtectorConfigBuilder setAbiType(AbiType r10) {
        int r11 = r10.getValue();
        if (r11 != AbiType.access$000(AbiType.BOTH)) goto L7;
        String r12 = "both";
    L5:
        this.mAbi = r12;
    L12:
        return this;
    L7:
        if (r11 != AbiType.access$000(AbiType.ARM64_V8A)) goto L10;
        r12 = "arm64-v8a";
        goto L5
    L10:
        if (r11 != AbiType.access$000(AbiType.ARMEABI_V7A)) goto L12;
        r12 = "armeabi-v7a";
        goto L5
    }

    public ProtectorConfigBuilder setIntervalTimeMs(int r10) {
        this.mIntervalTimeMs = r10;
        return this;
    }

    public ProtectorConfigBuilder setMaxApiLevel(int r10) {
        this.mMaxApiLevel = r10;
        return this;
    }

    public ProtectorConfigBuilder setMaxIgnoreDepthBeforeMeetFirstMatch(int r10) {
        this.mMaxIgnoreDepth = r10;
        return this;
    }

    public ProtectorConfigBuilder setMaxResumeCount(int r10) {
        this.mMaxResumeCount = r10;
        return this;
    }

    public ProtectorConfigBuilder setMinApiLevel(int r10) {
        this.mMinApiLevel = r10;
        return this;
    }
}
