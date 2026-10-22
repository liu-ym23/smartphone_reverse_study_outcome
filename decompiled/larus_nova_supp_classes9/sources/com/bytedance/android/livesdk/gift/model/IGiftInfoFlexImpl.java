package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.im.GiftInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/IGiftInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/s1;", BuildConfig.FLAVOR, "<set-?>", "giftId$delegate", "Ljava/lang/Object;", "getGiftId", "()J", "setGiftId", "(J)V", "giftId", "Lpy/k;", "giftIcon$delegate", "getGiftIcon", "()Lpy/k;", "setGiftIcon", "(Lpy/k;)V", "giftIcon", "diamondCount$delegate", "getDiamondCount", "setDiamondCount", "diamondCount", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IGiftInfoFlexImpl extends FlexModelBase<s1> implements s1, vh7.h {

    @SerializedName("diamond_count")
    protected long _$$diamondCount;

    @SerializedName("gift_icon")
    protected py.k _$$giftIcon;

    @SerializedName("gift_id")
    protected long _$$giftId;

    public IGiftInfoFlexImpl() {
        super(s1.class);
    }

    @Override // com.bytedance.android.livesdk.gift.model.s1
    public final long getDiamondCount() {
        return this._$$diamondCount;
    }

    @Override // com.bytedance.android.livesdk.gift.model.s1
    public final py.k getGiftIcon() {
        return this._$$giftIcon;
    }

    @Override // com.bytedance.android.livesdk.gift.model.s1
    public final long getGiftId() {
        return this._$$giftId;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
    public IGiftInfoFlexImpl(am3.g r6) {
        super(s1.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L15;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$giftId = r6.j();
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$giftIcon = vh7.f.a(r6, py.k.class);
        goto L3
    L10:
        if (r2 != 3) goto L11;
        this._$$diamondCount = r6.j();
        goto L3
    L11:
        am3.h.d(r3, r6);
        goto L3
    L15:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.gift.model.s1
    public final void setDiamondCount(long r1) {
        this._$$diamondCount = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.s1
    public final void setGiftIcon(py.k r1) {
        this._$$giftIcon = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.s1
    public final void setGiftId(long r1) {
        this._$$giftId = r1;
    }
}
