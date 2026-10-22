package com.bytedance.crash.protector;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
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
            AbiType r0 = new AbiType("BOTH", 0, 0);
            BOTH = r0;
            AbiType r1 = new AbiType("ARM64_V8A", 1, 1);
            ARM64_V8A = r1;
            AbiType r3 = new AbiType("ARMEABI_V7A", 2, 2);
            ARMEABI_V7A = r3;
            $VALUES = new AbiType[]{r0, r1, r3};
        }

        private AbiType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        static /* synthetic */ int access$000(AbiType r0) {
            return r0.value;
        }

        public static AbiType valueOf(String r2) {
            return (AbiType) ZeusTransformUtils.preCheckCast(Enum.valueOf(AbiType.class, r2), AbiType.class, "com.obric.memorydata.plugin");
        }

        public static AbiType[] values() {
            return (AbiType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AbiType[].class, "com.obric.memorydata.plugin");
        }

        int getValue() {
            return this.value;
        }
    }

    public ProtectorConfigBuilder(String r3) {
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
        if (r3 == null) goto L9;
        if (CrashProtectorConfig.isValidScopeName(r3) == false) goto L9;
        this.mScope = r3;
        return;
    L9:
        throw new IllegalArgumentException("invalid scope: " + r3);
    }

    public ProtectorConfigBuilder addFrame(String r3) {
        return addFrame(r3, null, false);
    }

    public ProtectorConfigBuilder addFrame(String r2, String r3) {
        return addFrame(r2, r3, false);
    }

    public ProtectorConfigBuilder addFrame(String r3, String r4, boolean r5) {
        if (this.mBacktraces != null) goto L5;
        this.mBacktraces = new JSONArray();
    L5:
        JSONObject r0 = new JSONObject();
        r0.put("elf_name", r3);
        if (r4 != null) goto L8;
    L11:
        r0.put("redacted_match", 1);
    L12:
        if (r5 == false) goto L14;
        r0.put("return_from_current_stack", 1);
    L14:
        this.mBacktraces.put(r0);
        return this;
    L8:
        if (r4.isEmpty() == true) goto L11;
        r0.put("symbol_name", r4);
        goto L12
    }

    public ProtectorConfigBuilder addRegister(String r2, long r3) {
        if (this.mRegs != null) goto L6;
        this.mRegs = new JSONObject();
    L6:
        if (CrashProtectorConfig.isValidRegLabel(r2) == false) goto L10;
        this.mRegs.put(r2, r3);
        return this;
    L10:
        throw new IllegalArgumentException("invalid register label: " + r2);
    }

    public ProtectorConfigBuilder addSignal(String r3) {
        if (this.mSignals != null) goto L6;
        this.mSignals = new JSONArray();
    L6:
        if (CrashProtectorConfig.signalStringToNumber(r3) == 0) goto L10;
        this.mSignals.put(r3);
        return this;
    L10:
        throw new IllegalArgumentException("invalid signal: " + r3);
    }

    public JSONObject build() {
        JSONObject r0 = new JSONObject();
        r0.put("scope", this.mScope);
        JSONArray r1 = this.mSignals;
        if (r1 == null) goto L39;
        if (r1.length() == 0) goto L39;
        r0.put("signals", this.mSignals);
        JSONArray r2 = this.mBacktraces;
        if (r2 == null) goto L37;
        if (r2.length() == 0) goto L37;
        r0.put("backtraces", this.mBacktraces);
        JSONObject r3 = this.mRegs;
        if (r3 != null) goto L13;
    L15:
        int r4 = this.mMaxIgnoreDepth;
        if (r4 == (-1)) goto L18;
        r0.put("max_ignore_depth_before_meet_first_match", r4);
    L18:
        int r5 = this.mMaxResumeCount;
        if (r5 == (-1)) goto L21;
        r0.put("max_resume_count", r5);
    L21:
        int r6 = this.mIntervalTimeMs;
        if (r6 == (-1)) goto L24;
        r0.put("interval_time_ms", r6);
    L24:
        int r7 = this.mMinApiLevel;
        if (r7 == (-1)) goto L27;
        r0.put("min_api_level", r7);
    L27:
        int r8 = this.mMaxApiLevel;
        if (r8 == (-1)) goto L30;
        r0.put("max_api_level", r8);
    L30:
        String r9 = this.mAbi;
        if (r9 != null) goto L33;
    L35:
        return r0;
    L33:
        if (r9.isEmpty() == true) goto L35;
        r0.put("abi", this.mAbi);
        goto L35
    L13:
        if (r3.length() <= 0) goto L15;
        r0.put("registers", this.mRegs);
    L37:
        throw new Exception("empty backtraces");
    L39:
        throw new Exception("empty signals");
    }

    public ProtectorConfigBuilder setAbiType(AbiType r2) {
        int r3 = r2.getValue();
        if (r3 != AbiType.access$000(AbiType.BOTH)) goto L7;
        String r4 = "both";
    L5:
        this.mAbi = r4;
    L12:
        return this;
    L7:
        if (r3 != AbiType.access$000(AbiType.ARM64_V8A)) goto L10;
        r4 = "arm64-v8a";
        goto L5
    L10:
        if (r3 != AbiType.access$000(AbiType.ARMEABI_V7A)) goto L12;
        r4 = "armeabi-v7a";
        goto L5
    }

    public ProtectorConfigBuilder setIntervalTimeMs(int r1) {
        this.mIntervalTimeMs = r1;
        return this;
    }

    public ProtectorConfigBuilder setMaxApiLevel(int r1) {
        this.mMaxApiLevel = r1;
        return this;
    }

    public ProtectorConfigBuilder setMaxIgnoreDepthBeforeMeetFirstMatch(int r1) {
        this.mMaxIgnoreDepth = r1;
        return this;
    }

    public ProtectorConfigBuilder setMaxResumeCount(int r1) {
        this.mMaxResumeCount = r1;
        return this;
    }

    public ProtectorConfigBuilder setMinApiLevel(int r1) {
        this.mMinApiLevel = r1;
        return this;
    }
}
