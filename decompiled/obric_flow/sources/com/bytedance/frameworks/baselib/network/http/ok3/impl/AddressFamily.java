package com.bytedance.frameworks.baselib.network.http.ok3.impl;

/* JADX INFO: loaded from: classes2.dex */
final enum AddressFamily extends Enum<AddressFamily> {
    public static final AddressFamily ADDRESS_FAMILY_IPV4 = null;
    public static final AddressFamily ADDRESS_FAMILY_IPV6 = null;
    public static final AddressFamily ADDRESS_FAMILY_UNSPECIFIED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AddressFamily[] f4675a = null;

    static {
        AddressFamily r5 = new AddressFamily("ADDRESS_FAMILY_UNSPECIFIED", 0);
        ADDRESS_FAMILY_UNSPECIFIED = r5;
        AddressFamily r10 = new AddressFamily("ADDRESS_FAMILY_IPV4", 1);
        ADDRESS_FAMILY_IPV4 = r10;
        AddressFamily r11 = new AddressFamily("ADDRESS_FAMILY_IPV6", 2);
        ADDRESS_FAMILY_IPV6 = r11;
        f4675a = new AddressFamily[]{r5, r10, r11};
    }

    public static AddressFamily valueOf(String r5) {
        return (AddressFamily) Enum.valueOf(AddressFamily.class, r5);
    }

    public static AddressFamily[] values() {
        return (AddressFamily[]) f4675a.clone();
    }
}
