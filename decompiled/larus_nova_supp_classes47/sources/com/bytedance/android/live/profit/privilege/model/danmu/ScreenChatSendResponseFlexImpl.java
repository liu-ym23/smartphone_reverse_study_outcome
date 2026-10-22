package com.bytedance.android.live.profit.privilege.model.danmu;

import am3.g;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.api.privilege.ScreenChatSendResponse.Data")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b4\u00105R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\nR/\u0010\u001a\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R+\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001c\u0010\b\"\u0004\b\u001d\u0010\nR+\u0010%\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u001f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b \u0010\u0006\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R/\u0010,\u001a\u0004\u0018\u00010&2\b\u0010\u0004\u001a\u0004\u0018\u00010&8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b'\u0010\u0006\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R/\u00103\u001a\u0004\u0018\u00010-2\b\u0010\u0004\u001a\u0004\u0018\u00010-8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010\u0006\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u00066"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/danmu/ScreenChatSendResponseFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/privilege/model/danmu/c;", "", "<set-?>", "leftDiamond$delegate", "Ljava/lang/Object;", "getLeftDiamond", "()J", "setLeftDiamond", "(J)V", "leftDiamond", "", "orderId$delegate", "getOrderId", "()Ljava/lang/String;", "setOrderId", "(Ljava/lang/String;)V", "orderId", "msgId$delegate", "getMsgId", "setMsgId", "msgId", "toast$delegate", "getToast", "setToast", "toast", "skin$delegate", "getSkin", "setSkin", "skin", "", "showIdentity$delegate", "getShowIdentity", "()I", "setShowIdentity", "(I)V", "showIdentity", "Lpy/k;", "identityLabel$delegate", "getIdentityLabel", "()Lpy/k;", "setIdentityLabel", "(Lpy/k;)V", "identityLabel", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "user$delegate", "getUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "user", "<init>", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ScreenChatSendResponseFlexImpl extends FlexModelBase<c> implements c, h {

    @SerializedName("identity_label")
    protected k _$$identityLabel;

    @SerializedName("left_diamond")
    protected long _$$leftDiamond;

    @SerializedName("msg_id")
    protected long _$$msgId;

    @SerializedName("order_id")
    protected String _$$orderId;

    @SerializedName("show_identity")
    protected int _$$showIdentity;

    @SerializedName("activity_danmu_background")
    protected long _$$skin;

    @SerializedName("toast")
    protected String _$$toast;

    @SerializedName("user")
    protected IBaseUser _$$user;

    public ScreenChatSendResponseFlexImpl() {
        super(c.class);
    }

    @Override // com.bytedance.android.live.profit.privilege.model.danmu.c
    public final k getIdentityLabel() {
        return this._$$identityLabel;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.danmu.c
    public final long getLeftDiamond() {
        return this._$$leftDiamond;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.danmu.c
    public final long getMsgId() {
        return this._$$msgId;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.danmu.c
    public final String getOrderId() {
        return this._$$orderId;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.danmu.c
    public final int getShowIdentity() {
        return this._$$showIdentity;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.danmu.c
    public final long getSkin() {
        return this._$$skin;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.danmu.c
    public final String getToast() {
        return this._$$toast;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.danmu.c
    public final IBaseUser getUser() {
        return this._$$user;
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Object, py.k] */
    public ScreenChatSendResponseFlexImpl(g r5) {
        super(c.class);
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L16;
        g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L7;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            default: goto L7;
        };
    L8:
        this._$$user = f.a(r5, IBaseUser.class);
        goto L3
    L9:
        this._$$identityLabel = f.a(r5, k.class);
        goto L3
    L10:
        this._$$showIdentity = r5.i();
        goto L3
    L11:
        this._$$skin = r5.j();
        goto L3
    L12:
        this._$$toast = am3.h.c(r5);
        goto L3
    L13:
        this._$$msgId = r5.j();
        goto L3
    L14:
        this._$$leftDiamond = r5.j();
        goto L3
    L15:
        this._$$orderId = am3.h.c(r5);
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L16:
        r5.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.profit.privilege.model.danmu.c
    public final void setIdentityLabel(k r1) {
        this._$$identityLabel = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.danmu.c
    public final void setLeftDiamond(long r1) {
        this._$$leftDiamond = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.danmu.c
    public final void setMsgId(long r1) {
        this._$$msgId = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.danmu.c
    public final void setOrderId(String r1) {
        this._$$orderId = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.danmu.c
    public final void setShowIdentity(int r1) {
        this._$$showIdentity = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.danmu.c
    public final void setSkin(long r1) {
        this._$$skin = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.danmu.c
    public final void setToast(String r1) {
        this._$$toast = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.danmu.c
    public final void setUser(IBaseUser r1) {
        this._$$user = r1;
    }
}
