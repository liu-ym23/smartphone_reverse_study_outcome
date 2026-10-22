package com.ss.android.lark.pb.security_event;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum AppDetail extends Enum<AppDetail> implements WireEnum {
    private static final /* synthetic */ AppDetail[] $VALUES = null;
    public static final ProtoAdapter<AppDetail> ADAPTER = null;
    public static final AppDetail AppDetailUnknown = null;
    public static final AppDetail Others = null;
    public static final AppDetail QQ = null;
    public static final AppDetail WeChat = null;
    public static final AppDetail WeChatMoments = null;
    public static final AppDetail Weibo = null;
    private final int value;

    static {
        AppDetail r0 = new AppDetail("AppDetailUnknown", 0, 0);
        AppDetailUnknown = r0;
        AppDetail r1 = new AppDetail("WeChat", 1, 1);
        WeChat = r1;
        AppDetail r3 = new AppDetail("WeChatMoments", 2, 2);
        WeChatMoments = r3;
        AppDetail r5 = new AppDetail("QQ", 3, 3);
        QQ = r5;
        AppDetail r7 = new AppDetail("Weibo", 4, 4);
        Weibo = r7;
        AppDetail r9 = new AppDetail("Others", 5, 5);
        Others = r9;
        $VALUES = new AppDetail[]{r0, r1, r3, r5, r7, r9};
        ADAPTER = ProtoAdapter.newEnumAdapter(AppDetail.class);
    }

    public static AppDetail[] values() {
        return (AppDetail[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static AppDetail fromValue(int r1) {
        if (r1 == 0) goto L26;
        if (r1 == 1) goto L24;
        if (r1 == 2) goto L22;
        if (r1 == 3) goto L20;
        if (r1 == 4) goto L18;
        if (r1 == 5) goto L16;
        return null;
    L16:
        return Others;
    L18:
        return Weibo;
    L20:
        return QQ;
    L22:
        return WeChatMoments;
    L24:
        return WeChat;
    L26:
        return AppDetailUnknown;
    }

    public static AppDetail valueOf(String r1) {
        return (AppDetail) a.a(AppDetail.class, r1);
    }

    private AppDetail(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
