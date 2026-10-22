package com.larksuite.component.blockit.entity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final enum GrantRecordType extends Enum<GrantRecordType> {
    public static final GrantRecordType AppAdmin = null;
    public static final GrantRecordType Brother = null;
    public static final GrantRecordType Department = null;
    public static final GrantRecordType Entity = null;
    public static final GrantRecordType Group = null;
    public static final GrantRecordType Leader = null;
    public static final GrantRecordType None = null;
    public static final GrantRecordType TenantAdmin = null;
    public static final GrantRecordType User = null;
    public static final GrantRecordType VGroup = null;
    public static final /* synthetic */ GrantRecordType[] a = null;
    private int value;

    static {
        GrantRecordType r0 = new GrantRecordType("None", 0, 0);
        None = r0;
        GrantRecordType r1 = new GrantRecordType("User", 1, 1);
        User = r1;
        GrantRecordType r3 = new GrantRecordType("Department", 2, 2);
        Department = r3;
        GrantRecordType r5 = new GrantRecordType("Leader", 3, 3);
        Leader = r5;
        GrantRecordType r7 = new GrantRecordType("Brother", 4, 4);
        Brother = r7;
        GrantRecordType r9 = new GrantRecordType("TenantAdmin", 5, 5);
        TenantAdmin = r9;
        GrantRecordType r11 = new GrantRecordType("AppAdmin", 6, 6);
        AppAdmin = r11;
        GrantRecordType r13 = new GrantRecordType("VGroup", 7, 7);
        VGroup = r13;
        GrantRecordType r15 = new GrantRecordType("Group", 8, 101);
        Group = r15;
        GrantRecordType r12 = new GrantRecordType("Entity", 9, 102);
        Entity = r12;
        a = new GrantRecordType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r12};
    }

    public static GrantRecordType[] values() {
        return (GrantRecordType[]) a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static GrantRecordType forNumber(int r1) {
        if (r1 == 101) goto L28;
        if (r1 == 102) goto L26;
        switch(r1) {
            case 0: goto L24;
            case 1: goto L22;
            case 2: goto L20;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L14;
            case 6: goto L12;
            case 7: goto L10;
            default: goto L7;
        };
    L7:
        return null;
    L10:
        return VGroup;
    L12:
        return AppAdmin;
    L14:
        return TenantAdmin;
    L16:
        return Brother;
    L18:
        return Leader;
    L20:
        return Department;
    L22:
        return User;
    L24:
        return None;
    L26:
        return Entity;
    L28:
        return Group;
    }

    public static GrantRecordType valueOf(String r1) {
        return (GrantRecordType) r27.a.a(GrantRecordType.class, r1);
    }

    public static GrantRecordType valueOf(int r0) {
        return forNumber(r0);
    }

    public GrantRecordType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
