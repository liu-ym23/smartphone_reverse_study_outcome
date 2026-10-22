package org.apache.commons.codec;

/* JADX INFO: loaded from: classes3.dex */
public final enum CodecPolicy extends Enum<CodecPolicy> {
    public static final CodecPolicy LENIENT = null;
    public static final CodecPolicy STRICT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CodecPolicy[] f20941a = null;

    static {
        CodecPolicy r5 = new CodecPolicy("STRICT", 0);
        STRICT = r5;
        CodecPolicy r10 = new CodecPolicy("LENIENT", 1);
        LENIENT = r10;
        f20941a = new CodecPolicy[]{r5, r10};
    }

    public static CodecPolicy valueOf(String r5) {
        return (CodecPolicy) Enum.valueOf(CodecPolicy.class, r5);
    }

    public static CodecPolicy[] values() {
        return (CodecPolicy[]) f20941a.clone();
    }
}
