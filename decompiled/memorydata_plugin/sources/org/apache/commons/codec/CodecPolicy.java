package org.apache.commons.codec;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum CodecPolicy extends Enum<CodecPolicy> {
    private static final /* synthetic */ CodecPolicy[] $VALUES = null;
    public static final CodecPolicy LENIENT = null;
    public static final CodecPolicy STRICT = null;

    static {
        CodecPolicy r0 = new CodecPolicy("STRICT", 0);
        STRICT = r0;
        CodecPolicy r1 = new CodecPolicy("LENIENT", 1);
        LENIENT = r1;
        $VALUES = new CodecPolicy[]{r0, r1};
    }

    private CodecPolicy(String r1, int r2) {
        super(r1, r2);
    }

    public static CodecPolicy valueOf(String r2) {
        return (CodecPolicy) ZeusTransformUtils.preCheckCast(Enum.valueOf(CodecPolicy.class, r2), CodecPolicy.class, "com.obric.memorydata.plugin");
    }

    public static CodecPolicy[] values() {
        return (CodecPolicy[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CodecPolicy[].class, "com.obric.memorydata.plugin");
    }
}
