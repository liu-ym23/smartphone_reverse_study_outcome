package com.bytedance.android.live.base.model.message;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\r8&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00178&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010 \u001a\u0004\u0018\u00010\u001c8&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010#\u001a\u0004\u0018\u00010\u001c8&X§\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0006\u001a\u0004\b!\u0010\u001e¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/base/model/message/s2;", "Lvh7/c;", "", "getOrderSingItemId", "()Ljava/lang/String;", "getOrderSingItemId$annotations", "()V", "orderSingItemId", "", "getOrderSingItemAction", "()I", "getOrderSingItemAction$annotations", "orderSingItemAction", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getOrderUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getOrderUser$annotations", "orderUser", "", "getTimestamp", "()J", "getTimestamp$annotations", "timestamp", "Lcom/bytedance/android/livesdk/chatroom/model/interact/t;", "getCurrentOrderSingItem", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/t;", "getCurrentOrderSingItem$annotations", "currentOrderSingItem", "Lpy/k;", "getOrderSingGiftIcon", "()Lpy/k;", "getOrderSingGiftIcon$annotations", "orderSingGiftIcon", "getAuditionGiftIcon", "getAuditionGiftIcon$annotations", "auditionGiftIcon", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface s2 extends vh7.c<s2> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "audition_gift_icon")
    py.k getAuditionGiftIcon();

    @FieldName(name = "current_order_sing_item")
    com.bytedance.android.livesdk.chatroom.model.interact.t getCurrentOrderSingItem();

    @FieldName(name = "order_sing_gift_icon")
    py.k getOrderSingGiftIcon();

    @FieldName(name = "order_sing_item_action")
    int getOrderSingItemAction();

    @FieldName(name = "order_sing_item_id")
    String getOrderSingItemId();

    @FieldName(name = "order_user")
    IBaseUser getOrderUser();

    @FieldName(name = "timestamp")
    long getTimestamp();
}
