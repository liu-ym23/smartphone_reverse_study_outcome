package org.threeten.bp.format;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes8.dex */
public final enum ResolverStyle extends Enum<ResolverStyle> {
    private static final /* synthetic */ ResolverStyle[] $VALUES = null;
    public static final ResolverStyle LENIENT = null;
    public static final ResolverStyle SMART = null;
    public static final ResolverStyle STRICT = null;

    static {
        ResolverStyle r0 = new ResolverStyle("STRICT", 0);
        STRICT = r0;
        ResolverStyle r1 = new ResolverStyle("SMART", 1);
        SMART = r1;
        ResolverStyle r3 = new ResolverStyle("LENIENT", 2);
        LENIENT = r3;
        $VALUES = new ResolverStyle[]{r0, r1, r3};
    }

    private ResolverStyle(String r1, int r2) {
        super(r1, r2);
    }

    public static ResolverStyle valueOf(String r2) {
        return (ResolverStyle) ZeusTransformUtils.preCheckCast(Enum.valueOf(ResolverStyle.class, r2), ResolverStyle.class, "com.obric.memorydata.plugin");
    }

    public static ResolverStyle[] values() {
        return (ResolverStyle[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ResolverStyle[].class, "com.obric.memorydata.plugin");
    }
}
