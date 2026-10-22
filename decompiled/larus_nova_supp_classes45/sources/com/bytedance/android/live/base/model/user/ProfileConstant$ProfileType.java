package com.bytedance.android.live.base.model.user;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final enum ProfileConstant$ProfileType extends Enum<ProfileConstant$ProfileType> {
    public static final ProfileConstant$ProfileType HONOUR = null;
    public static final ProfileConstant$ProfileType SHOP = null;
    public static final ProfileConstant$ProfileType WINDOW = null;
    public static final /* synthetic */ ProfileConstant$ProfileType[] a = null;
    private int type;

    static {
        ProfileConstant$ProfileType r0 = new ProfileConstant$ProfileType("HONOUR", 0, 0);
        HONOUR = r0;
        ProfileConstant$ProfileType r1 = new ProfileConstant$ProfileType("SHOP", 1, 1);
        SHOP = r1;
        ProfileConstant$ProfileType r3 = new ProfileConstant$ProfileType("WINDOW", 2, 2);
        WINDOW = r3;
        a = new ProfileConstant$ProfileType[]{r0, r1, r3};
    }

    public static ProfileConstant$ProfileType[] values() {
        return (ProfileConstant$ProfileType[]) a.clone();
    }

    public int getType() {
        return this.type;
    }

    public static ProfileConstant$ProfileType valueOf(String r1) {
        return (ProfileConstant$ProfileType) r27.a.a(ProfileConstant$ProfileType.class, r1);
    }

    public ProfileConstant$ProfileType(String r1, int r2, int r3) {
        super(r1, r2);
        this.type = r3;
    }
}
