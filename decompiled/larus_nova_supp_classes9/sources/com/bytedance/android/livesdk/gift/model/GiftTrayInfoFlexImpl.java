package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.data.GiftTrayInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b \b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\ba\u0010bR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R$\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R$\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R$\u0010\u001a\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R$\u0010\u001d\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\f\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010R$\u0010 \u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b \u0010\f\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010R\u001b\u0010(\u001a\u00020#8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001d\u0010-\u001a\u0004\u0018\u00010)8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b+\u0010,R\u001b\u00102\u001a\u00020.8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b/\u0010%\u001a\u0004\b0\u00101R\u001d\u00105\u001a\u0004\u0018\u00010)8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b3\u0010%\u001a\u0004\b4\u0010,R\u001b\u00108\u001a\u00020#8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b6\u0010%\u001a\u0004\b7\u0010'R\u001b\u0010=\u001a\u0002098VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b:\u0010%\u001a\u0004\b;\u0010<R\u001d\u0010B\u001a\u0004\u0018\u00010>8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b?\u0010%\u001a\u0004\b@\u0010AR/\u0010J\u001a\u0004\u0018\u00010C2\b\u0010D\u001a\u0004\u0018\u00010C8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bE\u0010%\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001b\u0010M\u001a\u00020.8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bK\u0010%\u001a\u0004\bL\u00101R\u001b\u0010P\u001a\u00020#8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bN\u0010%\u001a\u0004\bO\u0010'R\u001b\u0010S\u001a\u00020)8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010%\u001a\u0004\bR\u0010,R\u001b\u0010V\u001a\u00020#8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bT\u0010%\u001a\u0004\bU\u0010'R\u001b\u0010Y\u001a\u00020.8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bW\u0010%\u001a\u0004\bX\u00101R\u001d\u0010]\u001a\u0004\u0018\u00010.8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010%\u001a\u0004\b[\u0010\\R\u001d\u0010`\u001a\u0004\u0018\u00010.8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b^\u0010%\u001a\u0004\b_\u0010\\¨\u0006c"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/GiftTrayInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/o0;", "Lcom/bytedance/android/live/base/model/message/a5;", "trayDisplayText", "Lcom/bytedance/android/live/base/model/message/a5;", "getTrayDisplayText", "()Lcom/bytedance/android/live/base/model/message/a5;", "setTrayDisplayText", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "Lpy/k;", "trayBaseImg", "Lpy/k;", "getTrayBaseImg", "()Lpy/k;", "setTrayBaseImg", "(Lpy/k;)V", "trayBaseWebpImg", "getTrayBaseWebpImg", "setTrayBaseWebpImg", "trayHeadImg", "getTrayHeadImg", "setTrayHeadImg", "trayRightImg", "getTrayRightImg", "setTrayRightImg", "trayDynamicImg", "getTrayDynamicImg", "setTrayDynamicImg", "trayBaseImgV2", "getTrayBaseImgV2", "setTrayBaseImgV2", "trayRightImgV2", "getTrayRightImgV2", "setTrayRightImgV2", BuildConfig.FLAVOR, "trayLevel$delegate", "Ljava/lang/Object;", "getTrayLevel", "()J", "trayLevel", BuildConfig.FLAVOR, "traySchemaUrl$delegate", "getTraySchemaUrl", "()Ljava/lang/String;", "traySchemaUrl", BuildConfig.FLAVOR, "trayType$delegate", "getTrayType", "()I", "trayType", "toast$delegate", "getToast", "toast", "duration$delegate", "getDuration", "duration", BuildConfig.FLAVOR, "userHighLayer$delegate", "getUserHighLayer", "()Z", "userHighLayer", "Lcom/bytedance/android/livesdk/gift/model/TrayPreEffectFlexImpl;", "trayPreEffect$delegate", "getTrayPreEffect", "()Lcom/bytedance/android/livesdk/gift/model/TrayPreEffectFlexImpl;", "trayPreEffect", "Lcom/bytedance/android/livesdk/gift/model/u3;", "<set-?>", "trayPostEffect$delegate", "getTrayPostEffect", "()Lcom/bytedance/android/livesdk/gift/model/u3;", "setTrayPostEffect", "(Lcom/bytedance/android/livesdk/gift/model/u3;)V", "trayPostEffect", "traySlideRate$delegate", "getTraySlideRate", "traySlideRate", "buffLevel$delegate", "getBuffLevel", "buffLevel", "toolbarCardName$delegate", "getToolbarCardName", "toolbarCardName", "originGiftId$delegate", "getOriginGiftId", "originGiftId", "trayGroupMode$delegate", "getTrayGroupMode", "trayGroupMode", "expensiveTrayGroupNum$delegate", "getExpensiveTrayGroupNum", "()Ljava/lang/Integer;", "expensiveTrayGroupNum", "regularTrayGroupNum$delegate", "getRegularTrayGroupNum", "regularTrayGroupNum", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftTrayInfoFlexImpl extends FlexModelBase<o0> implements o0, vh7.h {

    @SerializedName("buff_level")
    protected long _$$buffLevel;

    @SerializedName("duration")
    protected long _$$duration;

    @SerializedName("expensive_tray_group_num")
    protected Integer _$$expensiveTrayGroupNum;

    @SerializedName("origin_gift_id")
    protected long _$$originGiftId;

    @SerializedName("regular_tray_group_num")
    protected Integer _$$regularTrayGroupNum;

    @SerializedName("toast")
    protected String _$$toast;

    @SerializedName("toolbar_card_name")
    protected String _$$toolbarCardName;

    @SerializedName("tray_group_mode")
    protected int _$$trayGroupMode;

    @SerializedName("tray_level")
    protected long _$$trayLevel;

    @SerializedName("tray_post_effect")
    protected u3 _$$trayPostEffect;

    @SerializedName("tray_pre_effect")
    protected TrayPreEffectFlexImpl _$$trayPreEffect;

    @SerializedName("tray_schema_url")
    protected String _$$traySchemaUrl;

    @SerializedName("tray_slide_rate")
    protected int _$$traySlideRate;

    @SerializedName("tray_type")
    protected int _$$trayType;

    @SerializedName("use_high_layer")
    protected boolean _$$userHighLayer;

    @SerializedName("tray_base_img")
    protected py.k trayBaseImg;

    @SerializedName("tray_base_img_v2")
    protected py.k trayBaseImgV2;

    @SerializedName("tray_base_webp_img")
    protected py.k trayBaseWebpImg;

    @SerializedName("tray_display_text")
    protected a5 trayDisplayText;

    @SerializedName("tray_dynamic_img")
    protected py.k trayDynamicImg;

    @SerializedName("tray_head_img")
    protected py.k trayHeadImg;

    @SerializedName("tray_right_img")
    protected py.k trayRightImg;

    @SerializedName("tray_right_img_v2")
    protected py.k trayRightImgV2;

    public GiftTrayInfoFlexImpl() {
        super(o0.class);
        this._$$userHighLayer = false;
        this._$$toolbarCardName = BuildConfig.FLAVOR;
    }

    @Override // com.bytedance.android.livesdk.gift.model.o0
    public /* bridge */ /* synthetic */ w3 getTrayPreEffect() {
        return getTrayPreEffect();
    }

    @Override // com.bytedance.android.livesdk.gift.model.o0
    public final long getBuffLevel() {
        return this._$$buffLevel;
    }

    @Override // com.bytedance.android.livesdk.gift.model.o0
    public final long getDuration() {
        return this._$$duration;
    }

    @Override // com.bytedance.android.livesdk.gift.model.o0
    public final Integer getExpensiveTrayGroupNum() {
        return this._$$expensiveTrayGroupNum;
    }

    @Override // com.bytedance.android.livesdk.gift.model.o0
    public final long getOriginGiftId() {
        return this._$$originGiftId;
    }

    @Override // com.bytedance.android.livesdk.gift.model.o0
    public final Integer getRegularTrayGroupNum() {
        return this._$$regularTrayGroupNum;
    }

    @Override // com.bytedance.android.livesdk.gift.model.o0
    public final String getToast() {
        return this._$$toast;
    }

    @Override // com.bytedance.android.livesdk.gift.model.o0
    public final String getToolbarCardName() {
        return this._$$toolbarCardName;
    }

    @Override // com.bytedance.android.livesdk.gift.model.o0
    public py.k getTrayBaseImg() {
        return this.trayBaseImg;
    }

    @Override // com.bytedance.android.livesdk.gift.model.o0
    public py.k getTrayBaseImgV2() {
        return this.trayBaseImgV2;
    }

    @Override // com.bytedance.android.livesdk.gift.model.o0
    public py.k getTrayBaseWebpImg() {
        return this.trayBaseWebpImg;
    }

    @Override // com.bytedance.android.livesdk.gift.model.o0
    public a5 getTrayDisplayText() {
        return this.trayDisplayText;
    }

    @Override // com.bytedance.android.livesdk.gift.model.o0
    public py.k getTrayDynamicImg() {
        return this.trayDynamicImg;
    }

    @Override // com.bytedance.android.livesdk.gift.model.o0
    public final int getTrayGroupMode() {
        return this._$$trayGroupMode;
    }

    @Override // com.bytedance.android.livesdk.gift.model.o0
    public py.k getTrayHeadImg() {
        return this.trayHeadImg;
    }

    @Override // com.bytedance.android.livesdk.gift.model.o0
    public final long getTrayLevel() {
        return this._$$trayLevel;
    }

    @Override // com.bytedance.android.livesdk.gift.model.o0
    public final u3 getTrayPostEffect() {
        return this._$$trayPostEffect;
    }

    @Override // com.bytedance.android.livesdk.gift.model.o0
    public py.k getTrayRightImg() {
        return this.trayRightImg;
    }

    @Override // com.bytedance.android.livesdk.gift.model.o0
    public py.k getTrayRightImgV2() {
        return this.trayRightImgV2;
    }

    @Override // com.bytedance.android.livesdk.gift.model.o0
    public final String getTraySchemaUrl() {
        return this._$$traySchemaUrl;
    }

    @Override // com.bytedance.android.livesdk.gift.model.o0
    public final int getTraySlideRate() {
        return this._$$traySlideRate;
    }

    @Override // com.bytedance.android.livesdk.gift.model.o0
    public final int getTrayType() {
        return this._$$trayType;
    }

    @Override // com.bytedance.android.livesdk.gift.model.o0
    public final boolean getUserHighLayer() {
        return this._$$userHighLayer;
    }

    @Override // com.bytedance.android.livesdk.gift.model.o0
    public final TrayPreEffectFlexImpl getTrayPreEffect() {
        return this._$$trayPreEffect;
    }

    /* JADX WARN: Type inference failed for: r4v11, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r4v15, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r4v17, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.bytedance.android.live.base.model.message.a5, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v24, types: [com.bytedance.android.livesdk.gift.model.u3, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v29, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.Object, py.k] */
    public GiftTrayInfoFlexImpl(am3.g r7) {
        super(o0.class);
        setThreadSafe(false);
        long r1 = r7.c();
        int r3 = 0;
    L3:
        int r4 = r7.f();
        if (r4 == (-1)) goto L31;
        am3.g.a r5 = decodeExtensionFields(r4, r7);
        switch(r4) {
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L28;
            case 4: goto L27;
            case 5: goto L26;
            case 6: goto L25;
            case 7: goto L24;
            case 8: goto L23;
            case 9: goto L22;
            case 10: goto L21;
            case 11: goto L20;
            case 12: goto L19;
            case 13: goto L18;
            case 14: goto L17;
            case 15: goto L16;
            case 16: goto L15;
            case 17: goto L14;
            case 18: goto L13;
            case 19: goto L12;
            case 20: goto L11;
            case 21: goto L10;
            case 22: goto L9;
            case 23: goto L8;
            default: goto L7;
        };
    L8:
        this._$$regularTrayGroupNum = Integer.valueOf(r7.i());
        goto L3
    L9:
        this._$$expensiveTrayGroupNum = Integer.valueOf(r7.i());
        goto L3
    L10:
        this._$$trayGroupMode = r7.i();
        r3 = r3 | 128;
        goto L3
    L11:
        this.trayBaseWebpImg = vh7.f.a(r7, py.k.class);
        goto L3
    L12:
        this._$$toolbarCardName = am3.h.c(r7);
        goto L3
    L13:
        this._$$buffLevel = r7.j();
        r3 = r3 | 32;
        goto L3
    L14:
        this._$$originGiftId = r7.j();
        r3 = r3 | 64;
        goto L3
    L15:
        this._$$trayPostEffect = vh7.f.a(r7, u3.class);
        goto L3
    L16:
        this._$$trayPreEffect = new TrayPreEffectFlexImpl(r7);
        goto L3
    L17:
        this._$$traySlideRate = r7.i();
        r3 = r3 | 16;
        goto L3
    L18:
        this._$$toast = am3.h.c(r7);
        goto L3
    L19:
        this._$$duration = r7.j();
        r3 = r3 | 4;
        goto L3
    L20:
        this._$$userHighLayer = am3.h.a(r7);
        r3 = r3 | 8;
        goto L3
    L21:
        this.trayRightImgV2 = vh7.f.a(r7, py.k.class);
        goto L3
    L22:
        this.trayBaseImgV2 = vh7.f.a(r7, py.k.class);
        goto L3
    L23:
        this._$$trayType = r7.i();
        r3 = r3 | 2;
        goto L3
    L24:
        this._$$traySchemaUrl = am3.h.c(r7);
        goto L3
    L25:
        this.trayDynamicImg = vh7.f.a(r7, py.k.class);
        goto L3
    L26:
        this._$$trayLevel = r7.j();
        r3 = r3 | 1;
        goto L3
    L27:
        this.trayRightImg = vh7.f.a(r7, py.k.class);
        goto L3
    L28:
        this.trayHeadImg = vh7.f.a(r7, py.k.class);
        goto L3
    L29:
        this.trayBaseImg = vh7.f.a(r7, py.k.class);
        goto L3
    L30:
        this.trayDisplayText = vh7.f.a(r7, a5.class);
        goto L3
    L7:
        am3.h.d(r5, r7);
        goto L3
    L31:
        r7.d(r1);
        setThreadSafe(true);
        if ((r3 & 8) != 0) goto L35;
        this._$$userHighLayer = false;
    L35:
        if (this._$$toolbarCardName != null) goto L88;
        this._$$toolbarCardName = BuildConfig.FLAVOR;
        return;
    }

    public void setTrayBaseImg(py.k r1) {
        this.trayBaseImg = r1;
    }

    public void setTrayBaseImgV2(py.k r1) {
        this.trayBaseImgV2 = r1;
    }

    public void setTrayBaseWebpImg(py.k r1) {
        this.trayBaseWebpImg = r1;
    }

    public void setTrayDisplayText(a5 r1) {
        this.trayDisplayText = r1;
    }

    public void setTrayDynamicImg(py.k r1) {
        this.trayDynamicImg = r1;
    }

    public void setTrayHeadImg(py.k r1) {
        this.trayHeadImg = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.o0
    public final void setTrayPostEffect(u3 r1) {
        this._$$trayPostEffect = r1;
    }

    public void setTrayRightImg(py.k r1) {
        this.trayRightImg = r1;
    }

    public void setTrayRightImgV2(py.k r1) {
        this.trayRightImgV2 = r1;
    }
}
