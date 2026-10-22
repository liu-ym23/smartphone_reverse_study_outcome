package com.bytedance.badger.collect.impl.constants;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final enum NetworkMethodEnum extends Enum<NetworkMethodEnum> {
    private static final /* synthetic */ NetworkMethodEnum[] $VALUES = null;
    public static final NetworkMethodEnum GET = null;
    public static final NetworkMethodEnum POST = null;
    public static final NetworkMethodEnum POST_FOR_WIFI_TO_CELLULAR = null;

    static {
        NetworkMethodEnum r0 = new NetworkMethodEnum(Constants.Keys.METHOD_GET, 0);
        GET = r0;
        NetworkMethodEnum r1 = new NetworkMethodEnum(Constants.Keys.METHOD_POST, 1);
        POST = r1;
        NetworkMethodEnum r3 = new NetworkMethodEnum("POST_FOR_WIFI_TO_CELLULAR", 2);
        POST_FOR_WIFI_TO_CELLULAR = r3;
        $VALUES = new NetworkMethodEnum[]{r0, r1, r3};
    }

    public static NetworkMethodEnum[] values() {
        return (NetworkMethodEnum[]) $VALUES.clone();
    }

    public static NetworkMethodEnum valueOf(String r1) {
        return (NetworkMethodEnum) a.a(NetworkMethodEnum.class, r1);
    }

    private NetworkMethodEnum(String r1, int r2) {
        super(r1, r2);
    }
}
