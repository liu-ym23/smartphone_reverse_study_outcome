package com.bytedance.android.live.base.model.message;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H&R\u001a\u0010\t\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00198&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\b\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\"\u001a\u0004\u0018\u00010\u001e8&X§\u0004¢\u0006\f\u0012\u0004\b!\u0010\b\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/bytedance/android/live/base/model/message/x2;", "Lvh7/c;", "", "getMessageId", "", "getMessageType", "()I", "getMessageType$annotations", "()V", "messageType", "Lcom/bytedance/android/live/base/model/message/u2;", "getOrderSingCreateContent", "()Lcom/bytedance/android/live/base/model/message/u2;", "getOrderSingCreateContent$annotations", "orderSingCreateContent", "Lcom/bytedance/android/live/base/model/message/v2;", "getOrderSingFinishContent", "()Lcom/bytedance/android/live/base/model/message/v2;", "getOrderSingFinishContent$annotations", "orderSingFinishContent", "Lcom/bytedance/android/live/base/model/message/t2;", "getOrderSingActionToastContent", "()Lcom/bytedance/android/live/base/model/message/t2;", "getOrderSingActionToastContent$annotations", "orderSingActionToastContent", "Lcom/bytedance/android/live/base/model/message/s2;", "getOrderSingActionContent", "()Lcom/bytedance/android/live/base/model/message/s2;", "getOrderSingActionContent$annotations", "orderSingActionContent", "Lcom/bytedance/android/live/base/model/message/w2;", "getOrderSingMVActionContent", "()Lcom/bytedance/android/live/base/model/message/w2;", "getOrderSingMVActionContent$annotations", "orderSingMVActionContent", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface x2 extends vh7.c<x2> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    long getMessageId();

    @FieldName(name = "message_type")
    int getMessageType();

    @FieldName(name = "order_sing_action_content")
    s2 getOrderSingActionContent();

    @FieldName(name = "order_sing_action_toast_content")
    t2 getOrderSingActionToastContent();

    @FieldName(name = "order_sing_create_content")
    u2 getOrderSingCreateContent();

    @FieldName(name = "order_sing_finish_content")
    v2 getOrderSingFinishContent();

    @FieldName(name = "order_sing_mv_action_content")
    w2 getOrderSingMVActionContent();
}
