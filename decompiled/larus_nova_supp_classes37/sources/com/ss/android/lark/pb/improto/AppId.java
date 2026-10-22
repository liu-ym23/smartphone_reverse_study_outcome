package com.ss.android.lark.pb.improto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum AppId extends Enum<AppId> implements WireEnum {
    private static final /* synthetic */ AppId[] $VALUES = null;
    public static final ProtoAdapter<AppId> ADAPTER = null;
    public static final AppId APP_ID_DOUBAO = null;
    public static final AppId APP_ID_FEISHU = null;
    public static final AppId APP_ID_NONE = null;
    private final int value;

    static {
        AppId r0 = new AppId("APP_ID_NONE", 0, 0);
        APP_ID_NONE = r0;
        AppId r1 = new AppId("APP_ID_FEISHU", 1, 1);
        APP_ID_FEISHU = r1;
        AppId r3 = new AppId("APP_ID_DOUBAO", 2, 176);
        APP_ID_DOUBAO = r3;
        $VALUES = new AppId[]{r0, r1, r3};
        ADAPTER = ProtoAdapter.newEnumAdapter(AppId.class);
    }

    public static AppId[] values() {
        return (AppId[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static AppId fromValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 176) goto L10;
        return null;
    L10:
        return APP_ID_DOUBAO;
    L12:
        return APP_ID_FEISHU;
    L14:
        return APP_ID_NONE;
    }

    public static AppId valueOf(String r1) {
        return (AppId) a.a(AppId.class, r1);
    }

    private AppId(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
