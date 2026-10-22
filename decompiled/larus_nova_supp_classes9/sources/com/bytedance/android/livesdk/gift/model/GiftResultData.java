package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bY\u0010ZR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8V@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118V@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00118V@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\"\u0010\u001b\u001a\u00020\u00118V@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\"\u0010\u001e\u001a\u00020\u00118V@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R\"\u0010!\u001a\u00020\u00118V@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0013\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R$\u0010$\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0005\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\tR$\u0010(\u001a\u0004\u0018\u00010'8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010/\u001a\u0004\u0018\u00010.8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00105\u001a\u0004\u0018\u00010\n8V@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b5\u0010\f\u001a\u0004\b6\u0010\u000e\"\u0004\b7\u0010\u0010R$\u00109\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010@\u001a\u0004\u0018\u00010?8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010F\u001a\u00020\u00118V@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bF\u0010\u0013\u001a\u0004\bG\u0010\u0015\"\u0004\bH\u0010\u0017R\"\u0010J\u001a\u00020I8V@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR$\u0010Q\u001a\u0004\u0018\u00010P8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u0014\u0010X\u001a\u0002088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bW\u0010<¨\u0006["}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/GiftResultData;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/y1;", "Lcom/bytedance/android/live/base/model/message/a5;", "displayText", "Lcom/bytedance/android/live/base/model/message/a5;", "getDisplayText", "()Lcom/bytedance/android/live/base/model/message/a5;", "setDisplayText", "(Lcom/bytedance/android/live/base/model/message/a5;)V", BuildConfig.FLAVOR, "describe", "Ljava/lang/String;", "getDescribe", "()Ljava/lang/String;", "setDescribe", "(Ljava/lang/String;)V", BuildConfig.FLAVOR, "giftId", "J", "getGiftId", "()J", "setGiftId", "(J)V", "groupCount", "getGroupCount", "setGroupCount", "repeatCount", "getRepeatCount", "setRepeatCount", "comboCount", "getComboCount", "setComboCount", "msgId", "getMsgId", "setMsgId", "trayDisplayText", "getTrayDisplayText", "setTrayDisplayText", "Lcom/bytedance/android/livesdk/gift/model/e0;", "giftBanner", "Lcom/bytedance/android/livesdk/gift/model/e0;", "getGiftBanner", "()Lcom/bytedance/android/livesdk/gift/model/e0;", "setGiftBanner", "(Lcom/bytedance/android/livesdk/gift/model/e0;)V", "Lcom/bytedance/android/livesdk/gift/model/o0;", "giftTrayInfo", "Lcom/bytedance/android/livesdk/gift/model/o0;", "getGiftTrayInfo", "()Lcom/bytedance/android/livesdk/gift/model/o0;", "setGiftTrayInfo", "(Lcom/bytedance/android/livesdk/gift/model/o0;)V", "topBarText", "getTopBarText", "setTopBarText", "Lcom/bytedance/android/livesdk/gift/model/p1;", "_giftExtra", "Lcom/bytedance/android/livesdk/gift/model/p1;", "get_giftExtra", "()Lcom/bytedance/android/livesdk/gift/model/p1;", "set_giftExtra", "(Lcom/bytedance/android/livesdk/gift/model/p1;)V", "Lcom/bytedance/android/livesdk/gift/model/c;", "assetEffectMixInfo", "Lcom/bytedance/android/livesdk/gift/model/c;", "getAssetEffectMixInfo", "()Lcom/bytedance/android/livesdk/gift/model/c;", "setAssetEffectMixInfo", "(Lcom/bytedance/android/livesdk/gift/model/c;)V", "originGiftId", "getOriginGiftId", "setOriginGiftId", BuildConfig.FLAVOR, "buffLevel", "I", "getBuffLevel", "()I", "setBuffLevel", "(I)V", "Lcom/bytedance/android/livesdk/gift/model/c2;", "giftTip", "Lcom/bytedance/android/livesdk/gift/model/c2;", "getGiftTip", "()Lcom/bytedance/android/livesdk/gift/model/c2;", "setGiftTip", "(Lcom/bytedance/android/livesdk/gift/model/c2;)V", "getGiftExtra", "giftExtra", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftResultData extends FlexModelBase<y1> implements y1, vh7.h {

    @SerializedName("gift_extra")
    protected p1 _giftExtra;

    @SerializedName("asset_effect_mix_info")
    protected c assetEffectMixInfo;

    @SerializedName("buff_level")
    protected int buffLevel;

    @SerializedName("combo_count")
    protected long comboCount;

    @SerializedName("describe")
    protected String describe;

    @SerializedName("display_text")
    protected a5 displayText;

    @SerializedName("gift_banner")
    protected e0 giftBanner;

    @SerializedName("gift_id")
    protected long giftId;

    @SerializedName("gift_tip")
    protected c2 giftTip;

    @SerializedName("tray_info")
    protected o0 giftTrayInfo;

    @SerializedName("group_count")
    protected long groupCount;

    @SerializedName("msg_id")
    protected long msgId;

    @SerializedName("origin_gift_id")
    protected long originGiftId;

    @SerializedName("repeat_count")
    protected long repeatCount;

    @SerializedName("top_bar_text")
    protected String topBarText;

    @SerializedName("tray_display_text")
    protected a5 trayDisplayText;

    public GiftResultData() {
        super(y1.class);
    }

    @Override // com.bytedance.android.livesdk.gift.model.y1
    public c getAssetEffectMixInfo() {
        return this.assetEffectMixInfo;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y1
    public int getBuffLevel() {
        return this.buffLevel;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y1
    public long getComboCount() {
        return this.comboCount;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y1
    public String getDescribe() {
        return this.describe;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y1
    public a5 getDisplayText() {
        return this.displayText;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y1
    public e0 getGiftBanner() {
        return this.giftBanner;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y1
    public p1 getGiftExtra() {
        return this._giftExtra;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y1
    public long getGiftId() {
        return this.giftId;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y1
    public c2 getGiftTip() {
        return this.giftTip;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y1
    public o0 getGiftTrayInfo() {
        return this.giftTrayInfo;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y1
    public long getGroupCount() {
        return this.groupCount;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y1
    public long getMsgId() {
        return this.msgId;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y1
    public long getOriginGiftId() {
        return this.originGiftId;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y1
    public long getRepeatCount() {
        return this.repeatCount;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y1
    public String getTopBarText() {
        return this.topBarText;
    }

    @Override // com.bytedance.android.livesdk.gift.model.y1
    public a5 getTrayDisplayText() {
        return this.trayDisplayText;
    }

    public final p1 get_giftExtra() {
        return this._giftExtra;
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v13, types: [com.bytedance.android.livesdk.gift.model.c, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v17, types: [com.bytedance.android.livesdk.gift.model.o0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v20, types: [com.bytedance.android.livesdk.gift.model.p1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v22, types: [com.bytedance.android.livesdk.gift.model.c2, java.lang.Object] */
    public GiftResultData(am3.g r5) {
        super(y1.class);
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L24;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L17;
            case 8: goto L16;
            case 9: goto L15;
            case 10: goto L14;
            case 11: goto L13;
            case 12: goto L12;
            case 13: goto L11;
            case 14: goto L10;
            case 15: goto L9;
            case 16: goto L8;
            default: goto L7;
        };
    L8:
        this.giftTip = vh7.f.a(r5, c2.class);
        goto L3
    L9:
        this._giftExtra = vh7.f.a(r5, p1.class);
        goto L3
    L10:
        this.topBarText = am3.h.c(r5);
        goto L3
    L11:
        this.giftTrayInfo = vh7.f.a(r5, o0.class);
        goto L3
    L12:
        this.buffLevel = r5.i();
        goto L3
    L13:
        this.originGiftId = r5.j();
        goto L3
    L14:
        this.assetEffectMixInfo = vh7.f.a(r5, c.class);
        goto L3
    L15:
        this.giftBanner = new e0(r5);
        goto L3
    L16:
        this.trayDisplayText = vh7.f.a(r5, a5.class);
        goto L3
    L17:
        this.msgId = r5.j();
        goto L3
    L18:
        this.comboCount = r5.j();
        goto L3
    L19:
        this.repeatCount = r5.j();
        goto L3
    L20:
        this.groupCount = r5.j();
        goto L3
    L21:
        this.giftId = r5.j();
        goto L3
    L22:
        this.describe = am3.h.c(r5);
        goto L3
    L23:
        this.displayText = vh7.f.a(r5, a5.class);
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L24:
        r5.d(r0);
        setThreadSafe(true);
    }

    public void setAssetEffectMixInfo(c r1) {
        this.assetEffectMixInfo = r1;
    }

    public void setBuffLevel(int r1) {
        this.buffLevel = r1;
    }

    public void setComboCount(long r1) {
        this.comboCount = r1;
    }

    public void setDescribe(String r1) {
        this.describe = r1;
    }

    public void setDisplayText(a5 r1) {
        this.displayText = r1;
    }

    public void setGiftBanner(e0 r1) {
        this.giftBanner = r1;
    }

    public void setGiftId(long r1) {
        this.giftId = r1;
    }

    public void setGiftTip(c2 r1) {
        this.giftTip = r1;
    }

    public void setGiftTrayInfo(o0 r1) {
        this.giftTrayInfo = r1;
    }

    public void setGroupCount(long r1) {
        this.groupCount = r1;
    }

    public void setMsgId(long r1) {
        this.msgId = r1;
    }

    public void setOriginGiftId(long r1) {
        this.originGiftId = r1;
    }

    public void setRepeatCount(long r1) {
        this.repeatCount = r1;
    }

    public void setTopBarText(String r1) {
        this.topBarText = r1;
    }

    public void setTrayDisplayText(a5 r1) {
        this.trayDisplayText = r1;
    }

    public final void set_giftExtra(p1 r1) {
        this._giftExtra = r1;
    }
}
