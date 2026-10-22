package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.data.GiftBuffInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bU\u0010VR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR+\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R/\u0010\u001a\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR/\u0010\u001e\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u0007\"\u0004\b\u001d\u0010\tR/\u0010\"\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\r\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR+\u0010)\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020#8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b$\u0010\r\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R+\u00100\u001a\u00020*2\u0006\u0010\u000b\u001a\u00020*8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010\r\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R+\u00104\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020#8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b1\u0010\r\u001a\u0004\b2\u0010&\"\u0004\b3\u0010(R+\u00108\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020#8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b5\u0010\r\u001a\u0004\b6\u0010&\"\u0004\b7\u0010(R'\u0010=\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020#098VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\r\u001a\u0004\b;\u0010<R+\u0010A\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b>\u0010\r\u001a\u0004\b?\u0010\u000f\"\u0004\b@\u0010\u0011R/\u0010H\u001a\u0004\u0018\u00010B2\b\u0010\u000b\u001a\u0004\u0018\u00010B8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bC\u0010\r\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR+\u0010L\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020#8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bI\u0010\r\u001a\u0004\bJ\u0010&\"\u0004\bK\u0010(R/\u0010P\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bM\u0010\r\u001a\u0004\bN\u0010\u0007\"\u0004\bO\u0010\tR)\u0010T\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020Q\u0018\u0001098VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bR\u0010\r\u001a\u0004\bS\u0010<¨\u0006W"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/IGiftBuffInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/l1;", "Lpy/k;", "dynamicGiftIcon", "Lpy/k;", "getDynamicGiftIcon", "()Lpy/k;", "setDynamicGiftIcon", "(Lpy/k;)V", BuildConfig.FLAVOR, "<set-?>", "text$delegate", "Ljava/lang/Object;", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "text", "textColor$delegate", "getTextColor", "setTextColor", "textColor", "bgImg$delegate", "getBgImg", "setBgImg", "bgImg", "sweepLightImg$delegate", "getSweepLightImg", "setSweepLightImg", "sweepLightImg", "buffDescribeImg$delegate", "getBuffDescribeImg", "setBuffDescribeImg", "buffDescribeImg", BuildConfig.FLAVOR, "buffGiftId$delegate", "getBuffGiftId", "()J", "setBuffGiftId", "(J)V", "buffGiftId", BuildConfig.FLAVOR, "buffLevel$delegate", "getBuffLevel", "()I", "setBuffLevel", "(I)V", "buffLevel", "buffDiamondCount$delegate", "getBuffDiamondCount", "setBuffDiamondCount", "buffDiamondCount", "defaultChose$delegate", "getDefaultChose", "setDefaultChose", "defaultChose", BuildConfig.FLAVOR, "pageTypeToDefaultChoseActionMap$delegate", "getPageTypeToDefaultChoseActionMap", "()Ljava/util/Map;", "pageTypeToDefaultChoseActionMap", "lockToast$delegate", "getLockToast", "setLockToast", "lockToast", "Lcom/bytedance/android/livesdk/gift/model/i;", "lockInfo$delegate", "getLockInfo", "()Lcom/bytedance/android/livesdk/gift/model/i;", "setLockInfo", "(Lcom/bytedance/android/livesdk/gift/model/i;)V", "lockInfo", "startTime$delegate", "getStartTime", "setStartTime", "startTime", "bgImgV2$delegate", "getBgImgV2", "setBgImgV2", "bgImgV2", "Lcom/bytedance/android/livesdk/gift/model/IGiftTextInfoFlexImpl;", "defaultGiftTextMap$delegate", "getDefaultGiftTextMap", "defaultGiftTextMap", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IGiftBuffInfoFlexImpl extends FlexModelBase<l1> implements l1, vh7.h {

    @SerializedName("bg_img")
    protected py.k _$$bgImg;

    @SerializedName("bg_img_v2")
    protected py.k _$$bgImgV2;

    @SerializedName("buff_gift_describe_img")
    protected py.k _$$buffDescribeImg;

    @SerializedName("buff_diamond_count")
    protected long _$$buffDiamondCount;

    @SerializedName("buff_gift_id")
    protected long _$$buffGiftId;

    @SerializedName("buff_level")
    protected int _$$buffLevel;

    @SerializedName("default_chose_action")
    protected long _$$defaultChose;

    @SerializedName("default_gift_text")
    protected Map<Integer, IGiftTextInfoFlexImpl> _$$defaultGiftTextMap;

    @SerializedName("buff_lock_info")
    protected i _$$lockInfo;

    @SerializedName("lock_toast")
    protected String _$$lockToast;

    @SerializedName("tab_chose_action")
    protected Map<Integer, Long> _$$pageTypeToDefaultChoseActionMap;

    @SerializedName("start_time")
    protected long _$$startTime;

    @SerializedName("sweep_light_img")
    protected py.k _$$sweepLightImg;

    @SerializedName("text")
    protected String _$$text;

    @SerializedName("text_color")
    protected String _$$textColor;

    @SerializedName("gift_icon_asset_img")
    protected py.k dynamicGiftIcon;

    public IGiftBuffInfoFlexImpl() {
        super(l1.class);
        this._$$text = BuildConfig.FLAVOR;
        this._$$textColor = BuildConfig.FLAVOR;
        this._$$pageTypeToDefaultChoseActionMap = $defaultValue_pageTypeToDefaultChoseActionMap$();
        this._$$lockToast = BuildConfig.FLAVOR;
    }

    public final Map<Integer, Long> $defaultValue_pageTypeToDefaultChoseActionMap$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.b();
    }

    @Override // com.bytedance.android.livesdk.gift.model.l1
    public final py.k getBgImg() {
        return this._$$bgImg;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l1
    public final py.k getBgImgV2() {
        return this._$$bgImgV2;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l1
    public final py.k getBuffDescribeImg() {
        return this._$$buffDescribeImg;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l1
    public final long getBuffDiamondCount() {
        return this._$$buffDiamondCount;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l1
    public final long getBuffGiftId() {
        return this._$$buffGiftId;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l1
    public final int getBuffLevel() {
        return this._$$buffLevel;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l1
    public final long getDefaultChose() {
        return this._$$defaultChose;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l1
    public final Map<Integer, IGiftTextInfoFlexImpl> getDefaultGiftTextMap() {
        return this._$$defaultGiftTextMap;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l1
    public py.k getDynamicGiftIcon() {
        return this.dynamicGiftIcon;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l1
    public final i getLockInfo() {
        return this._$$lockInfo;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l1
    public final String getLockToast() {
        return this._$$lockToast;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l1
    public final Map<Integer, Long> getPageTypeToDefaultChoseActionMap() {
        return this._$$pageTypeToDefaultChoseActionMap;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l1
    public final long getStartTime() {
        return this._$$startTime;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l1
    public final py.k getSweepLightImg() {
        return this._$$sweepLightImg;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l1
    public final String getText() {
        return this._$$text;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l1
    public final String getTextColor() {
        return this._$$textColor;
    }

    /* JADX WARN: Type inference failed for: r2v16, types: [com.bytedance.android.livesdk.gift.model.i, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v18, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v24, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Object, py.k] */
    public IGiftBuffInfoFlexImpl(am3.g r15) {
        super(l1.class);
        this._$$pageTypeToDefaultChoseActionMap = new HashMap();
        this._$$defaultGiftTextMap = new HashMap();
        setThreadSafe(false);
        long r0 = r15.c();
    L3:
        int r2 = r15.f();
        if (r2 == (-1)) goto L54;
        am3.g.a r5 = decodeExtensionFields(r2, r15);
        Integer r9 = null;
        switch(r2) {
            case 1: goto L53;
            case 2: goto L52;
            case 3: goto L51;
            case 4: goto L50;
            case 5: goto L49;
            case 6: goto L48;
            case 7: goto L47;
            case 8: goto L7;
            case 9: goto L46;
            case 10: goto L45;
            case 11: goto L44;
            case 12: goto L43;
            case 13: goto L42;
            case 14: goto L41;
            case 15: goto L25;
            case 16: goto L7;
            case 17: goto L7;
            case 18: goto L7;
            case 19: goto L24;
            case 20: goto L8;
            default: goto L7;
        };
    L8:
        long r10 = r15.c();
        Object r3 = null;
    L9:
        int r6 = r15.f();
        if (r6 == (-1)) goto L16;
        if (r6 != 1) goto L12;
        r9 = Integer.valueOf(r15.i());
        goto L9
    L12:
        if (r6 != 2) goto L13;
        r3 = new IGiftTextInfoFlexImpl(r15);
        goto L9
    L13:
        am3.h.e(r15);
        goto L9
    L16:
        r15.d(r10);
        Map r4 = this._$$defaultGiftTextMap;
        if (r9 == null) goto L23;
        if (r3 == null) goto L21;
    L36:
        r4.put(r9, r3);
        goto L3
    L21:
        throw new IllegalStateException("Value must not be null");
    L23:
        throw new IllegalStateException("Key must not be null");
    L24:
        this.dynamicGiftIcon = vh7.f.a(r15, py.k.class);
        goto L3
    L25:
        long r11 = r15.c();
        r3 = null;
    L26:
        int r7 = r15.f();
        if (r7 == (-1)) goto L33;
        if (r7 != 1) goto L29;
        r9 = Integer.valueOf(r15.i());
        goto L26
    L29:
        if (r7 != 2) goto L30;
        r3 = Long.valueOf(r15.j());
        goto L26
    L30:
        am3.h.e(r15);
        goto L26
    L33:
        r15.d(r11);
        r4 = this._$$pageTypeToDefaultChoseActionMap;
        if (r9 == null) goto L40;
        if (r3 != null) goto L36;
        throw new IllegalStateException("Value must not be null");
    L40:
        throw new IllegalStateException("Key must not be null");
    L41:
        this._$$bgImgV2 = vh7.f.a(r15, py.k.class);
        goto L3
    L42:
        this._$$lockInfo = vh7.f.a(r15, i.class);
        goto L3
    L43:
        this._$$startTime = r15.j();
        goto L3
    L44:
        this._$$defaultChose = r15.j();
        goto L3
    L45:
        this._$$lockToast = am3.h.c(r15);
        goto L3
    L46:
        this._$$buffDiamondCount = r15.j();
        goto L3
    L47:
        this._$$buffLevel = r15.i();
        goto L3
    L48:
        this._$$buffGiftId = r15.j();
        goto L3
    L49:
        this._$$buffDescribeImg = vh7.f.a(r15, py.k.class);
        goto L3
    L50:
        this._$$sweepLightImg = vh7.f.a(r15, py.k.class);
        goto L3
    L51:
        this._$$bgImg = vh7.f.a(r15, py.k.class);
        goto L3
    L52:
        this._$$textColor = am3.h.c(r15);
        goto L3
    L53:
        this._$$text = am3.h.c(r15);
        goto L3
    L7:
        am3.h.d(r5, r15);
        goto L3
    L54:
        r15.d(r0);
        setThreadSafe(true);
        if (this._$$text != null) goto L58;
        this._$$text = BuildConfig.FLAVOR;
    L58:
        if (this._$$textColor != null) goto L61;
        this._$$textColor = BuildConfig.FLAVOR;
    L61:
        if (this._$$pageTypeToDefaultChoseActionMap != null) goto L64;
        this._$$pageTypeToDefaultChoseActionMap = $defaultValue_pageTypeToDefaultChoseActionMap$();
    L64:
        if (this._$$lockToast != null) goto L124;
        this._$$lockToast = BuildConfig.FLAVOR;
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l1
    public final void setBgImg(py.k r1) {
        this._$$bgImg = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l1
    public final void setBgImgV2(py.k r1) {
        this._$$bgImgV2 = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l1
    public final void setBuffDescribeImg(py.k r1) {
        this._$$buffDescribeImg = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l1
    public final void setBuffDiamondCount(long r1) {
        this._$$buffDiamondCount = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l1
    public final void setBuffGiftId(long r1) {
        this._$$buffGiftId = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l1
    public final void setBuffLevel(int r1) {
        this._$$buffLevel = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l1
    public final void setDefaultChose(long r1) {
        this._$$defaultChose = r1;
    }

    public void setDynamicGiftIcon(py.k r1) {
        this.dynamicGiftIcon = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l1
    public final void setLockInfo(i r1) {
        this._$$lockInfo = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l1
    public final void setLockToast(String r1) {
        this._$$lockToast = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l1
    public final void setStartTime(long r1) {
        this._$$startTime = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l1
    public final void setSweepLightImg(py.k r1) {
        this._$$sweepLightImg = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l1
    public final void setText(String r1) {
        this._$$text = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l1
    public final void setTextColor(String r1) {
        this._$$textColor = r1;
    }
}
