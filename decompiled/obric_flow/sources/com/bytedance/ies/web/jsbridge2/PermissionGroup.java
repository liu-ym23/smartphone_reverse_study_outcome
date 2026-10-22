package com.bytedance.ies.web.jsbridge2;

/* JADX INFO: loaded from: classes2.dex */
public final enum PermissionGroup extends Enum<PermissionGroup> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PermissionGroup f6261a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PermissionGroup f6262b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final PermissionGroup f6263c = null;
    public static final PermissionGroup d = null;
    public static final /* synthetic */ PermissionGroup[] e = null;

    static {
        PermissionGroup r5 = new PermissionGroup("PUBLIC", 0);
        f6261a = r5;
        PermissionGroup r10 = new PermissionGroup("PROTECTED", 1);
        f6262b = r10;
        PermissionGroup r11 = new PermissionGroup("PRIVATE", 2);
        f6263c = r11;
        PermissionGroup r12 = new PermissionGroup("SECURE", 3);
        d = r12;
        e = new PermissionGroup[]{r5, r10, r11, r12};
    }

    public PermissionGroup(String r5, int r10) {
        super(r5, r10);
    }

    public static PermissionGroup valueOf(String r5) {
        return (PermissionGroup) Enum.valueOf(PermissionGroup.class, r5);
    }

    public static PermissionGroup[] values() {
        return (PermissionGroup[]) e.clone();
    }

    @Override // java.lang.Enum
    public final String toString() {
        if (this != f6263c) goto L7;
        return "private";
    L7:
        if (this != f6262b) goto L11;
        return "protected";
    L11:
        if (this != d) goto L14;
        return "secure";
    L14:
        return "public";
    }
}
