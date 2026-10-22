package org.apache.poi.openxml4j.opc;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum PackageAccess extends Enum<PackageAccess> {
    private static final /* synthetic */ PackageAccess[] $VALUES = null;
    public static final PackageAccess READ = null;
    public static final PackageAccess READ_WRITE = null;
    public static final PackageAccess WRITE = null;

    static {
        PackageAccess r0 = new PackageAccess("READ", 0);
        READ = r0;
        PackageAccess r1 = new PackageAccess("WRITE", 1);
        WRITE = r1;
        PackageAccess r3 = new PackageAccess("READ_WRITE", 2);
        READ_WRITE = r3;
        $VALUES = new PackageAccess[]{r0, r1, r3};
    }

    private PackageAccess(String r1, int r2) {
        super(r1, r2);
    }

    public static PackageAccess valueOf(String r2) {
        return (PackageAccess) ZeusTransformUtils.preCheckCast(Enum.valueOf(PackageAccess.class, r2), PackageAccess.class, "com.obric.memorydata.plugin");
    }

    public static PackageAccess[] values() {
        return (PackageAccess[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PackageAccess[].class, "com.obric.memorydata.plugin");
    }
}
