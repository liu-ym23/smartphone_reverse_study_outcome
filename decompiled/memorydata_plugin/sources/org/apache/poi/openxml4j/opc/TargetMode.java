package org.apache.poi.openxml4j.opc;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum TargetMode extends Enum<TargetMode> {
    private static final /* synthetic */ TargetMode[] $VALUES = null;
    public static final TargetMode EXTERNAL = null;
    public static final TargetMode INTERNAL = null;

    static {
        TargetMode r0 = new TargetMode("INTERNAL", 0);
        INTERNAL = r0;
        TargetMode r1 = new TargetMode("EXTERNAL", 1);
        EXTERNAL = r1;
        $VALUES = new TargetMode[]{r0, r1};
    }

    private TargetMode(String r1, int r2) {
        super(r1, r2);
    }

    public static TargetMode valueOf(String r2) {
        return (TargetMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(TargetMode.class, r2), TargetMode.class, "com.obric.memorydata.plugin");
    }

    public static TargetMode[] values() {
        return (TargetMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TargetMode[].class, "com.obric.memorydata.plugin");
    }
}
