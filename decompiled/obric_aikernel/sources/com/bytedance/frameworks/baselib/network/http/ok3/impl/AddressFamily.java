package com.bytedance.frameworks.baselib.network.http.ok3.impl;

/* JADX INFO: loaded from: classes.dex */
final enum AddressFamily extends Enum<AddressFamily> {
    private static final /* synthetic */ AddressFamily[] $VALUES = null;
    public static final AddressFamily ADDRESS_FAMILY_IPV4 = null;
    public static final AddressFamily ADDRESS_FAMILY_IPV6 = null;
    public static final AddressFamily ADDRESS_FAMILY_UNSPECIFIED = null;

    static {
        AddressFamily r10 = new AddressFamily("ADDRESS_FAMILY_UNSPECIFIED", 0);
        ADDRESS_FAMILY_UNSPECIFIED = r10;
        AddressFamily r11 = new AddressFamily("ADDRESS_FAMILY_IPV4", 1);
        ADDRESS_FAMILY_IPV4 = r11;
        AddressFamily r12 = new AddressFamily("ADDRESS_FAMILY_IPV6", 2);
        ADDRESS_FAMILY_IPV6 = r12;
        $VALUES = new AddressFamily[]{r10, r11, r12};
    }

    private AddressFamily(String r10, int r11) {
        super(r10, r11);
    }

    public static AddressFamily valueOf(String r10) {
        return (AddressFamily) Enum.valueOf(AddressFamily.class, r10);
    }

    public static AddressFamily[] values() {
        return (AddressFamily[]) $VALUES.clone();
    }
}
