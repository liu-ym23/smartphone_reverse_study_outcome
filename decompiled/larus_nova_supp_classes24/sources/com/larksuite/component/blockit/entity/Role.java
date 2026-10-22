package com.larksuite.component.blockit.entity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final enum Role extends Enum<Role> {
    public static final Role Member = null;
    public static final Role None = null;
    public static final Role Owner = null;
    public static final Role Viewer = null;
    public static final /* synthetic */ Role[] a = null;
    private int value;

    static {
        Role r0 = new Role("None", 0, 0);
        None = r0;
        Role r1 = new Role("Owner", 1, 1);
        Owner = r1;
        Role r3 = new Role("Member", 2, 2);
        Member = r3;
        Role r5 = new Role("Viewer", 3, 3);
        Viewer = r5;
        a = new Role[]{r0, r1, r3, r5};
    }

    public static Role[] values() {
        return (Role[]) a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static Role forNumber(int r1) {
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L16;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L12;
        return null;
    L12:
        return Viewer;
    L14:
        return Member;
    L16:
        return Owner;
    L18:
        return None;
    }

    public static Role valueOf(String r1) {
        return (Role) r27.a.a(Role.class, r1);
    }

    public static Role valueOf(int r0) {
        return forNumber(r0);
    }

    public Role(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
