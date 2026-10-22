package com.bytedance.android.livesdk.dsl.util;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/dsl/util/DSLActionEnum;", "", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "CardUpdate", "Scheme", "SendTrackLog", "LiveToast", "LiveLocalALogger", "SubscribeAnchorPlay", "JSBInvoke", "ListItemRefresh", "CustomProfileCardDismiss", "CustomOpenShopOrDismiss", "dslservice-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum DSLActionEnum extends Enum<DSLActionEnum> {
    public static final DSLActionEnum CardUpdate = null;
    public static final DSLActionEnum CustomOpenShopOrDismiss = null;
    public static final DSLActionEnum CustomProfileCardDismiss = null;
    public static final DSLActionEnum JSBInvoke = null;
    public static final DSLActionEnum ListItemRefresh = null;
    public static final DSLActionEnum LiveLocalALogger = null;
    public static final DSLActionEnum LiveToast = null;
    public static final DSLActionEnum Scheme = null;
    public static final DSLActionEnum SendTrackLog = null;
    public static final DSLActionEnum SubscribeAnchorPlay = null;
    public static final /* synthetic */ DSLActionEnum[] a = null;
    private final String text;

    public static DSLActionEnum valueOf(String r1) {
        return (DSLActionEnum) r27.a.a(DSLActionEnum.class, r1);
    }

    public static DSLActionEnum[] values() {
        return (DSLActionEnum[]) a.clone();
    }

    static {
        DSLActionEnum r1 = new DSLActionEnum("CardUpdate", 0, "card_data_update");
        CardUpdate = r1;
        DSLActionEnum r2 = new DSLActionEnum("Scheme", 1, "scheme");
        Scheme = r2;
        DSLActionEnum r3 = new DSLActionEnum("SendTrackLog", 2, "send_track_log");
        SendTrackLog = r3;
        DSLActionEnum r4 = new DSLActionEnum("LiveToast", 3, "live_toast_action");
        LiveToast = r4;
        DSLActionEnum r5 = new DSLActionEnum("LiveLocalALogger", 4, "live_local_logger");
        LiveLocalALogger = r5;
        DSLActionEnum r6 = new DSLActionEnum("SubscribeAnchorPlay", 5, "live_subscribe_anchor_play");
        SubscribeAnchorPlay = r6;
        DSLActionEnum r7 = new DSLActionEnum("JSBInvoke", 6, "jsb_invoke");
        JSBInvoke = r7;
        DSLActionEnum r8 = new DSLActionEnum("ListItemRefresh", 7, "live_list_item_refresh");
        ListItemRefresh = r8;
        DSLActionEnum r9 = new DSLActionEnum("CustomProfileCardDismiss", 8, "live_custom_profile_card_dismiss");
        CustomProfileCardDismiss = r9;
        DSLActionEnum r10 = new DSLActionEnum("CustomOpenShopOrDismiss", 9, "shop_custom_method");
        CustomOpenShopOrDismiss = r10;
        a = new DSLActionEnum[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10};
    }

    public final String getText() {
        return this.text;
    }

    public DSLActionEnum(String r1, int r2, String r3) {
        super(r1, r2);
        this.text = r3;
    }
}
