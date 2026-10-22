package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.data.GiftAudienceReceiverItem")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00138V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/GiftAudienceReceiverItemFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/d0;", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "<set-?>", "user$delegate", "Ljava/lang/Object;", "getUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "user", BuildConfig.FLAVOR, "score$delegate", "getScore", "()J", "setScore", "(J)V", "score", BuildConfig.FLAVOR, "giftAuth$delegate", "getGiftAuth", "()Z", "setGiftAuth", "(Z)V", "giftAuth", "<init>", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftAudienceReceiverItemFlexImpl extends FlexModelBase<d0> implements d0, vh7.h {

    @SerializedName("gift_auth")
    protected boolean _$$giftAuth;

    @SerializedName("score")
    protected long _$$score;

    @SerializedName("user")
    protected IBaseUser _$$user;

    public GiftAudienceReceiverItemFlexImpl() {
        super(d0.class);
        this._$$giftAuth = false;
    }

    @Override // com.bytedance.android.livesdk.gift.model.d0
    public final boolean getGiftAuth() {
        return this._$$giftAuth;
    }

    @Override // com.bytedance.android.livesdk.gift.model.d0
    public final long getScore() {
        return this._$$score;
    }

    @Override // com.bytedance.android.livesdk.gift.model.d0
    public final IBaseUser getUser() {
        return this._$$user;
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [com.bytedance.android.live.base.model.user.IBaseUser, java.lang.Object] */
    public GiftAudienceReceiverItemFlexImpl(am3.g r9) {
        super(d0.class);
        setThreadSafe(false);
        long r1 = r9.c();
        int r3 = 0;
    L3:
        int r4 = r9.f();
        if (r4 == (-1)) goto L14;
        am3.g.a r5 = decodeExtensionFields(r4, r9);
        if (r4 != 1) goto L7;
        this._$$user = vh7.f.a(r9, IBaseUser.class);
        goto L3
    L7:
        if (r4 != 2) goto L9;
        this._$$score = r9.j();
        r3 = r3 | 1;
        goto L3
    L9:
        if (r4 != 3) goto L10;
        this._$$giftAuth = am3.h.a(r9);
        r3 = r3 | 2;
        goto L3
    L10:
        am3.h.d(r5, r9);
        goto L3
    L14:
        r9.d(r1);
        setThreadSafe(true);
        if ((r3 & 2) != 0) goto L30;
        this._$$giftAuth = false;
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.model.d0
    public final void setGiftAuth(boolean r1) {
        this._$$giftAuth = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.d0
    public final void setScore(long r1) {
        this._$$score = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.d0
    public final void setUser(IBaseUser r1) {
        this._$$user = r1;
    }
}
