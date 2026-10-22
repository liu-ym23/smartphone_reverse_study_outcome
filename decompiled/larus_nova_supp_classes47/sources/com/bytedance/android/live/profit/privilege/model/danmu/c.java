package com.bytedance.android.live.profit.privilege.model.danmu;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import py.k;
import vh7.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R&\u0010\n\u001a\u00060\u0002j\u0002`\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u0011\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0015\u001a\u00060\u0002j\u0002`\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\t\u001a\u0004\b\u0012\u0010\u0005\"\u0004\b\u0013\u0010\u0007R$\u0010\u0019\u001a\u0004\u0018\u00010\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\t\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR&\u0010\u001d\u001a\u00060\u0002j\u0002`\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\t\u001a\u0004\b\u001a\u0010\u0005\"\u0004\b\u001b\u0010\u0007R\"\u0010$\u001a\u00020\u001e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b#\u0010\t\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R*\u0010,\u001a\n\u0018\u00010%j\u0004\u0018\u0001`&8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b+\u0010\t\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R*\u00104\u001a\n\u0018\u00010-j\u0004\u0018\u0001`.8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b3\u0010\t\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u00065"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/danmu/c;", "Lvh7/c;", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getLeftDiamond", "()J", "setLeftDiamond", "(J)V", "getLeftDiamond$annotations", "()V", "leftDiamond", "", "getOrderId", "()Ljava/lang/String;", "setOrderId", "(Ljava/lang/String;)V", "getOrderId$annotations", "orderId", "getMsgId", "setMsgId", "getMsgId$annotations", "msgId", "getToast", "setToast", "getToast$annotations", "toast", "getSkin", "setSkin", "getSkin$annotations", "skin", "", "getShowIdentity", "()I", "setShowIdentity", "(I)V", "getShowIdentity$annotations", "showIdentity", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getIdentityLabel", "()Lpy/k;", "setIdentityLabel", "(Lpy/k;)V", "getIdentityLabel$annotations", "identityLabel", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Lcom/bytedance/android/live/base/model/user/IBaseUserKt;", "getUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "getUser$annotations", "user", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface c extends vh7.c<c> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ e castTo(Class r1);

    /* synthetic */ e castToOrNull(Class r1);

    @FieldName(name = "identity_label")
    k getIdentityLabel();

    @FieldName(name = "left_diamond")
    long getLeftDiamond();

    @FieldName(name = "msg_id")
    long getMsgId();

    @FieldName(name = "order_id")
    String getOrderId();

    @FieldName(name = "show_identity")
    int getShowIdentity();

    @FieldName(name = "activity_danmu_background")
    long getSkin();

    @FieldName(name = "toast")
    String getToast();

    @FieldName(name = "user")
    IBaseUser getUser();

    @FieldName(name = "identity_label#setter")
    void setIdentityLabel(k r1);

    @FieldName(name = "left_diamond#setter")
    void setLeftDiamond(long r1);

    @FieldName(name = "msg_id#setter")
    void setMsgId(long r1);

    @FieldName(name = "order_id#setter")
    void setOrderId(String r1);

    @FieldName(name = "show_identity#setter")
    void setShowIdentity(int r1);

    @FieldName(name = "activity_danmu_background#setter")
    void setSkin(long r1);

    @FieldName(name = "toast#setter")
    void setToast(String r1);

    @FieldName(name = "user#setter")
    void setUser(IBaseUser r1);
}
