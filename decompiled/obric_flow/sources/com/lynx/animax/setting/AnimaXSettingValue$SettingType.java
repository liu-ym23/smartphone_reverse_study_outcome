package com.lynx.animax.setting;

/* JADX INFO: loaded from: classes2.dex */
final enum AnimaXSettingValue$SettingType extends Enum<AnimaXSettingValue$SettingType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AnimaXSettingValue$SettingType f9697a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AnimaXSettingValue$SettingType f9698b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AnimaXSettingValue$SettingType[] f9699c = null;

    static {
        AnimaXSettingValue$SettingType r5 = new AnimaXSettingValue$SettingType("STRING", 0);
        f9697a = r5;
        AnimaXSettingValue$SettingType r10 = new AnimaXSettingValue$SettingType("COLLECTION", 1);
        f9698b = r10;
        f9699c = new AnimaXSettingValue$SettingType[]{r5, r10, new AnimaXSettingValue$SettingType("BOOLEAN", 2), new AnimaXSettingValue$SettingType("LONG", 3), new AnimaXSettingValue$SettingType("DOUBLE", 4)};
    }

    public AnimaXSettingValue$SettingType(String r5, int r10) {
        super(r5, r10);
    }

    public static AnimaXSettingValue$SettingType valueOf(String r5) {
        return (AnimaXSettingValue$SettingType) Enum.valueOf(AnimaXSettingValue$SettingType.class, r5);
    }

    public static AnimaXSettingValue$SettingType[] values() {
        return (AnimaXSettingValue$SettingType[]) f9699c.clone();
    }
}
