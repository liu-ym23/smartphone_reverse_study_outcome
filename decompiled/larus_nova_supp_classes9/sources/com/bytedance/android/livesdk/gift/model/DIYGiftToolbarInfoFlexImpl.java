package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.data.DIYGiftToolbarInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b.\u0010/R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u0014R!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u0014R\u001b\u0010\u001d\u001a\u00020\u00198VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010 \u001a\u00020\u00198VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001f\u0010\u001cR+\u0010(\u001a\u00020!2\u0006\u0010\"\u001a\u00020!8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001b\u0010-\u001a\u00020)8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\f\u001a\u0004\b+\u0010,¨\u00060"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/DIYGiftToolbarInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/p;", "Lpy/k;", "defaultGiftDescribeImg", "Lpy/k;", "getDefaultGiftDescribeImg", "()Lpy/k;", "setDefaultGiftDescribeImg", "(Lpy/k;)V", "Lcom/bytedance/android/livesdk/gift/model/DIYPageEnterButtonFlexImpl;", "button$delegate", "Ljava/lang/Object;", "getButton", "()Lcom/bytedance/android/livesdk/gift/model/DIYPageEnterButtonFlexImpl;", "button", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/DIYGiftCardInfoFlexImpl;", "cards$delegate", "getCards", "()Ljava/util/List;", "cards", "forceIndexCards$delegate", "getForceIndexCards", "forceIndexCards", BuildConfig.FLAVOR, "maxTotalCardNumber$delegate", "getMaxTotalCardNumber", "()I", "maxTotalCardNumber", "maxLocalCardNumber$delegate", "getMaxLocalCardNumber", "maxLocalCardNumber", BuildConfig.FLAVOR, "<set-?>", "configId$delegate", "getConfigId", "()J", "setConfigId", "(J)V", "configId", BuildConfig.FLAVOR, "giftShowName$delegate", "getGiftShowName", "()Ljava/lang/String;", "giftShowName", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DIYGiftToolbarInfoFlexImpl extends FlexModelBase<p> implements p, vh7.h {

    @SerializedName("button")
    protected DIYPageEnterButtonFlexImpl _$$button;

    @SerializedName("cards")
    protected List<DIYGiftCardInfoFlexImpl> _$$cards;

    @SerializedName("config_id")
    protected long _$$configId;

    @SerializedName("force_index_cards")
    protected List<DIYGiftCardInfoFlexImpl> _$$forceIndexCards;

    @SerializedName("gift_show_name")
    protected String _$$giftShowName;

    @SerializedName("max_local_card_number")
    protected int _$$maxLocalCardNumber;

    @SerializedName("max_total_card_number")
    protected int _$$maxTotalCardNumber;

    @SerializedName("default_gift_describe_img")
    protected py.k defaultGiftDescribeImg;

    public DIYGiftToolbarInfoFlexImpl() {
        super(p.class);
        this._$$cards = $defaultValue_cards$();
        this._$$forceIndexCards = $defaultValue_forceIndexCards$();
        this._$$giftShowName = BuildConfig.FLAVOR;
    }

    public final List<DIYGiftCardInfoFlexImpl> $defaultValue_cards$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    public final List<DIYGiftCardInfoFlexImpl> $defaultValue_forceIndexCards$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.livesdk.gift.model.p
    public /* bridge */ /* synthetic */ q getButton() {
        return getButton();
    }

    @Override // com.bytedance.android.livesdk.gift.model.p
    public final List<DIYGiftCardInfoFlexImpl> getCards() {
        return this._$$cards;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p
    public final long getConfigId() {
        return this._$$configId;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p
    public py.k getDefaultGiftDescribeImg() {
        return this.defaultGiftDescribeImg;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p
    public final List<DIYGiftCardInfoFlexImpl> getForceIndexCards() {
        return this._$$forceIndexCards;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p
    public final String getGiftShowName() {
        return this._$$giftShowName;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p
    public final int getMaxLocalCardNumber() {
        return this._$$maxLocalCardNumber;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p
    public final int getMaxTotalCardNumber() {
        return this._$$maxTotalCardNumber;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p
    public final DIYPageEnterButtonFlexImpl getButton() {
        return this._$$button;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    public DIYGiftToolbarInfoFlexImpl(am3.g r5) {
        super(p.class);
        this._$$cards = new ArrayList();
        this._$$forceIndexCards = new ArrayList();
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L17;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            default: goto L7;
        };
    L8:
        this._$$giftShowName = am3.h.c(r5);
        goto L3
    L9:
        this._$$configId = r5.j();
        goto L3
    L10:
        this._$$maxLocalCardNumber = r5.i();
        goto L3
    L11:
        this._$$maxTotalCardNumber = r5.i();
        goto L3
    L12:
        List<DIYGiftCardInfoFlexImpl> r4 = this._$$forceIndexCards;
        DIYGiftCardInfoFlexImpl r6 = new DIYGiftCardInfoFlexImpl(r5);
    L16:
        r4.add(r6);
        goto L3
    L13:
        this.defaultGiftDescribeImg = vh7.f.a(r5, py.k.class);
        goto L3
    L14:
        this._$$button = new DIYPageEnterButtonFlexImpl(r5);
        goto L3
    L15:
        r4 = this._$$cards;
        r6 = new DIYGiftCardInfoFlexImpl(r5);
        goto L16
    L7:
        am3.h.d(r3, r5);
        goto L3
    L17:
        r5.d(r0);
        setThreadSafe(true);
        if (this._$$cards.isEmpty() == false) goto L21;
        this._$$cards = $defaultValue_cards$();
    L21:
        if (this._$$forceIndexCards.isEmpty() == false) goto L24;
        this._$$forceIndexCards = $defaultValue_forceIndexCards$();
    L24:
        if (this._$$giftShowName != null) goto L46;
        this._$$giftShowName = BuildConfig.FLAVOR;
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.model.p
    public final void setConfigId(long r1) {
        this._$$configId = r1;
    }

    public void setDefaultGiftDescribeImg(py.k r1) {
        this.defaultGiftDescribeImg = r1;
    }
}
