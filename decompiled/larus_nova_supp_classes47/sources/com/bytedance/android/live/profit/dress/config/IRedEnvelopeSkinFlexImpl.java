package com.bytedance.android.live.profit.dress.config;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.api.dress.RedEnvelopeSkin")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b<\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bP\u0010QR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR$\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR$\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR$\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR$\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR$\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0005\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR$\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0005\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR$\u0010\"\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0005\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR$\u0010%\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0005\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR$\u0010(\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0005\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR$\u0010+\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0005\u001a\u0004\b,\u0010\u0007\"\u0004\b-\u0010\tR$\u0010.\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0005\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR$\u00101\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b1\u0010\u0005\u001a\u0004\b2\u0010\u0007\"\u0004\b3\u0010\tR$\u00104\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0005\u001a\u0004\b5\u0010\u0007\"\u0004\b6\u0010\tR$\u00107\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b7\u0010\u0005\u001a\u0004\b8\u0010\u0007\"\u0004\b9\u0010\tR$\u0010:\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b:\u0010\u0005\u001a\u0004\b;\u0010\u0007\"\u0004\b<\u0010\tR$\u0010=\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b=\u0010\u0005\u001a\u0004\b>\u0010\u0007\"\u0004\b?\u0010\tR\u001b\u0010E\u001a\u00020@8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u001b\u0010H\u001a\u00020@8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bF\u0010B\u001a\u0004\bG\u0010DR'\u0010O\u001a\u000e\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020K0I8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bL\u0010B\u001a\u0004\bM\u0010N¨\u0006R"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/IRedEnvelopeSkinFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/dress/config/t;", "Lpy/k;", "shortTouchWaiting", "Lpy/k;", "getShortTouchWaiting", "()Lpy/k;", "setShortTouchWaiting", "(Lpy/k;)V", "shortTouchOutNoMore", "getShortTouchOutNoMore", "setShortTouchOutNoMore", "shortTouchOutWithMore", "getShortTouchOutWithMore", "setShortTouchOutWithMore", "enterSkin", "getEnterSkin", "setEnterSkin", "upperCover", "getUpperCover", "setUpperCover", "lowerCover", "getLowerCover", "setLowerCover", "backgroud", "getBackgroud", "setBackgroud", "border", "getBorder", "setBorder", "blessIcon", "getBlessIcon", "setBlessIcon", "leftBannerBackground", "getLeftBannerBackground", "setLeftBannerBackground", "rightBannerBackground", "getRightBannerBackground", "setRightBannerBackground", "counterImg", "getCounterImg", "setCounterImg", "cardImg", "getCardImg", "setCardImg", "leftGiftRedEnvelope", "getLeftGiftRedEnvelope", "setLeftGiftRedEnvelope", "rightGiftRedEnvelope", "getRightGiftRedEnvelope", "setRightGiftRedEnvelope", "leftDiamondRedEnvelope", "getLeftDiamondRedEnvelope", "setLeftDiamondRedEnvelope", "rightDiamondRedEnvelope", "getRightDiamondRedEnvelope", "setRightDiamondRedEnvelope", "saleTitle", "getSaleTitle", "setSaleTitle", "dressCenterIcon", "getDressCenterIcon", "setDressCenterIcon", "", "name$delegate", "Ljava/lang/Object;", "getName", "()Ljava/lang/String;", "name", "blessWord$delegate", "getBlessWord", "blessWord", "", "", "Lcom/bytedance/android/live/profit/dress/config/ISurpriseGiftFlexImpl;", "surpriseGifts$delegate", "getSurpriseGifts", "()Ljava/util/Map;", "surpriseGifts", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IRedEnvelopeSkinFlexImpl extends FlexModelBase<t> implements t, vh7.h {

    @SerializedName("bless_word")
    protected String _$$blessWord;

    @SerializedName("name")
    protected String _$$name;

    @SerializedName("surprise_gifts")
    protected Map<Long, ISurpriseGiftFlexImpl> _$$surpriseGifts;

    @SerializedName("backgroud")
    protected py.k backgroud;

    @SerializedName("bless_icon")
    protected py.k blessIcon;

    @SerializedName("border")
    protected py.k border;

    @SerializedName("card_img")
    protected py.k cardImg;

    @SerializedName("counter_img")
    protected py.k counterImg;

    @SerializedName("dress_center_icon")
    protected py.k dressCenterIcon;

    @SerializedName("enter_skin")
    protected py.k enterSkin;

    @SerializedName("left_banner_background")
    protected py.k leftBannerBackground;

    @SerializedName("left_diamond_red_envelope")
    protected py.k leftDiamondRedEnvelope;

    @SerializedName("left_gift_red_envelope")
    protected py.k leftGiftRedEnvelope;

    @SerializedName("lower_cover")
    protected py.k lowerCover;

    @SerializedName("right_banner_background")
    protected py.k rightBannerBackground;

    @SerializedName("right_diamond_red_envelope")
    protected py.k rightDiamondRedEnvelope;

    @SerializedName("right_gift_red_envelope")
    protected py.k rightGiftRedEnvelope;

    @SerializedName("sale_title")
    protected py.k saleTitle;

    @SerializedName("short_touch_out_no_more")
    protected py.k shortTouchOutNoMore;

    @SerializedName("short_touch_out_with_more")
    protected py.k shortTouchOutWithMore;

    @SerializedName("short_touch_waiting")
    protected py.k shortTouchWaiting;

    @SerializedName("upper_cover")
    protected py.k upperCover;

    public IRedEnvelopeSkinFlexImpl() {
        super(t.class);
        this._$$name = "";
        this._$$blessWord = "";
        this._$$surpriseGifts = $defaultValue_surpriseGifts$();
    }

    public final Map<Long, ISurpriseGiftFlexImpl> $defaultValue_surpriseGifts$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.b();
    }

    @Override // com.bytedance.android.live.profit.dress.config.t
    public py.k getBackgroud() {
        return this.backgroud;
    }

    @Override // com.bytedance.android.live.profit.dress.config.t
    public py.k getBlessIcon() {
        return this.blessIcon;
    }

    @Override // com.bytedance.android.live.profit.dress.config.t
    public final String getBlessWord() {
        return this._$$blessWord;
    }

    @Override // com.bytedance.android.live.profit.dress.config.t
    public py.k getBorder() {
        return this.border;
    }

    @Override // com.bytedance.android.live.profit.dress.config.t
    public py.k getCardImg() {
        return this.cardImg;
    }

    @Override // com.bytedance.android.live.profit.dress.config.t
    public py.k getCounterImg() {
        return this.counterImg;
    }

    @Override // com.bytedance.android.live.profit.dress.config.t
    public py.k getDressCenterIcon() {
        return this.dressCenterIcon;
    }

    @Override // com.bytedance.android.live.profit.dress.config.t
    public py.k getEnterSkin() {
        return this.enterSkin;
    }

    @Override // com.bytedance.android.live.profit.dress.config.t
    public py.k getLeftBannerBackground() {
        return this.leftBannerBackground;
    }

    @Override // com.bytedance.android.live.profit.dress.config.t
    public py.k getLeftDiamondRedEnvelope() {
        return this.leftDiamondRedEnvelope;
    }

    @Override // com.bytedance.android.live.profit.dress.config.t
    public py.k getLeftGiftRedEnvelope() {
        return this.leftGiftRedEnvelope;
    }

    @Override // com.bytedance.android.live.profit.dress.config.t
    public py.k getLowerCover() {
        return this.lowerCover;
    }

    @Override // com.bytedance.android.live.profit.dress.config.t
    public final String getName() {
        return this._$$name;
    }

    @Override // com.bytedance.android.live.profit.dress.config.t
    public py.k getRightBannerBackground() {
        return this.rightBannerBackground;
    }

    @Override // com.bytedance.android.live.profit.dress.config.t
    public py.k getRightDiamondRedEnvelope() {
        return this.rightDiamondRedEnvelope;
    }

    @Override // com.bytedance.android.live.profit.dress.config.t
    public py.k getRightGiftRedEnvelope() {
        return this.rightGiftRedEnvelope;
    }

    @Override // com.bytedance.android.live.profit.dress.config.t
    public py.k getSaleTitle() {
        return this.saleTitle;
    }

    @Override // com.bytedance.android.live.profit.dress.config.t
    public py.k getShortTouchOutNoMore() {
        return this.shortTouchOutNoMore;
    }

    @Override // com.bytedance.android.live.profit.dress.config.t
    public py.k getShortTouchOutWithMore() {
        return this.shortTouchOutWithMore;
    }

    @Override // com.bytedance.android.live.profit.dress.config.t
    public py.k getShortTouchWaiting() {
        return this.shortTouchWaiting;
    }

    @Override // com.bytedance.android.live.profit.dress.config.t
    public final Map<Long, ISurpriseGiftFlexImpl> getSurpriseGifts() {
        return this._$$surpriseGifts;
    }

    @Override // com.bytedance.android.live.profit.dress.config.t
    public py.k getUpperCover() {
        return this.upperCover;
    }

    /* JADX WARN: Type inference failed for: r2v11, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v17, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v19, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v26, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v28, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v30, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v32, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v34, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v36, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v38, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v40, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v42, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v44, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object, py.k] */
    public IRedEnvelopeSkinFlexImpl(am3.g r12) {
        super(t.class);
        this._$$surpriseGifts = new HashMap();
        setThreadSafe(false);
        long r0 = r12.c();
    L3:
        int r2 = r12.f();
        if (r2 == (-1)) goto L46;
        am3.g.a r5 = decodeExtensionFields(r2, r12);
        switch(r2) {
            case 1: goto L45;
            case 2: goto L44;
            case 3: goto L43;
            case 4: goto L42;
            case 5: goto L41;
            case 6: goto L40;
            case 7: goto L39;
            case 8: goto L38;
            case 9: goto L37;
            case 10: goto L36;
            case 11: goto L35;
            case 12: goto L18;
            case 13: goto L17;
            case 14: goto L16;
            case 15: goto L15;
            case 16: goto L14;
            case 17: goto L13;
            case 18: goto L12;
            case 19: goto L11;
            case 20: goto L10;
            case 21: goto L9;
            case 22: goto L8;
            default: goto L7;
        };
    L8:
        this.dressCenterIcon = vh7.f.a(r12, py.k.class);
        goto L3
    L9:
        this.saleTitle = vh7.f.a(r12, py.k.class);
        goto L3
    L10:
        this.rightDiamondRedEnvelope = vh7.f.a(r12, py.k.class);
        goto L3
    L11:
        this.leftDiamondRedEnvelope = vh7.f.a(r12, py.k.class);
        goto L3
    L12:
        this.rightGiftRedEnvelope = vh7.f.a(r12, py.k.class);
        goto L3
    L13:
        this.leftGiftRedEnvelope = vh7.f.a(r12, py.k.class);
        goto L3
    L14:
        this.cardImg = vh7.f.a(r12, py.k.class);
        goto L3
    L15:
        this.counterImg = vh7.f.a(r12, py.k.class);
        goto L3
    L16:
        this.rightBannerBackground = vh7.f.a(r12, py.k.class);
        goto L3
    L17:
        this.leftBannerBackground = vh7.f.a(r12, py.k.class);
        goto L3
    L18:
        long r6 = r12.c();
        Long r3 = null;
        ISurpriseGiftFlexImpl r7 = null;
    L19:
        int r8 = r12.f();
        if (r8 == (-1)) goto L27;
        if (r8 != 1) goto L23;
        r3 = Long.valueOf(r12.j());
        goto L19
    L23:
        if (r8 != 2) goto L24;
        r7 = new ISurpriseGiftFlexImpl(r12);
        goto L19
    L24:
        am3.h.e(r12);
        goto L19
    L27:
        r12.d(r6);
        Map<Long, ISurpriseGiftFlexImpl> r4 = this._$$surpriseGifts;
        if (r3 == null) goto L34;
        if (r7 == null) goto L32;
        r4.put(r3, r7);
        goto L3
    L32:
        throw new IllegalStateException("Value must not be null");
    L34:
        throw new IllegalStateException("Key must not be null");
    L35:
        this._$$blessWord = am3.h.c(r12);
        goto L3
    L36:
        this.blessIcon = vh7.f.a(r12, py.k.class);
        goto L3
    L37:
        this.border = vh7.f.a(r12, py.k.class);
        goto L3
    L38:
        this.backgroud = vh7.f.a(r12, py.k.class);
        goto L3
    L39:
        this.lowerCover = vh7.f.a(r12, py.k.class);
        goto L3
    L40:
        this.upperCover = vh7.f.a(r12, py.k.class);
        goto L3
    L41:
        this.enterSkin = vh7.f.a(r12, py.k.class);
        goto L3
    L42:
        this.shortTouchOutWithMore = vh7.f.a(r12, py.k.class);
        goto L3
    L43:
        this.shortTouchOutNoMore = vh7.f.a(r12, py.k.class);
        goto L3
    L44:
        this.shortTouchWaiting = vh7.f.a(r12, py.k.class);
        goto L3
    L45:
        this._$$name = am3.h.c(r12);
        goto L3
    L7:
        am3.h.d(r5, r12);
        goto L3
    L46:
        r12.d(r0);
        setThreadSafe(true);
        if (this._$$name != null) goto L50;
        this._$$name = "";
    L50:
        if (this._$$blessWord != null) goto L53;
        this._$$blessWord = "";
    L53:
        if (this._$$surpriseGifts != null) goto L115;
        this._$$surpriseGifts = $defaultValue_surpriseGifts$();
        return;
    }

    public void setBackgroud(py.k r1) {
        this.backgroud = r1;
    }

    public void setBlessIcon(py.k r1) {
        this.blessIcon = r1;
    }

    public void setBorder(py.k r1) {
        this.border = r1;
    }

    public void setCardImg(py.k r1) {
        this.cardImg = r1;
    }

    public void setCounterImg(py.k r1) {
        this.counterImg = r1;
    }

    public void setDressCenterIcon(py.k r1) {
        this.dressCenterIcon = r1;
    }

    public void setEnterSkin(py.k r1) {
        this.enterSkin = r1;
    }

    public void setLeftBannerBackground(py.k r1) {
        this.leftBannerBackground = r1;
    }

    public void setLeftDiamondRedEnvelope(py.k r1) {
        this.leftDiamondRedEnvelope = r1;
    }

    public void setLeftGiftRedEnvelope(py.k r1) {
        this.leftGiftRedEnvelope = r1;
    }

    public void setLowerCover(py.k r1) {
        this.lowerCover = r1;
    }

    public void setRightBannerBackground(py.k r1) {
        this.rightBannerBackground = r1;
    }

    public void setRightDiamondRedEnvelope(py.k r1) {
        this.rightDiamondRedEnvelope = r1;
    }

    public void setRightGiftRedEnvelope(py.k r1) {
        this.rightGiftRedEnvelope = r1;
    }

    public void setSaleTitle(py.k r1) {
        this.saleTitle = r1;
    }

    public void setShortTouchOutNoMore(py.k r1) {
        this.shortTouchOutNoMore = r1;
    }

    public void setShortTouchOutWithMore(py.k r1) {
        this.shortTouchOutWithMore = r1;
    }

    public void setShortTouchWaiting(py.k r1) {
        this.shortTouchWaiting = r1;
    }

    public void setUpperCover(py.k r1) {
        this.upperCover = r1;
    }
}
