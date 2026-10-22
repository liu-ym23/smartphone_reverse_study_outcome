package com.bytedance.android.live.profit.dress.config;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.api.dress.LinkmicRealTimeChorusStage")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b8\u00109R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00108\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR$\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\tR$\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\tR$\u0010 \u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b \u0010\u0005\u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010\tR\u001d\u0010(\u001a\u0004\u0018\u00010#8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001d\u0010-\u001a\u0004\u0018\u00010)8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b+\u0010,R\u001d\u00102\u001a\u0004\u0018\u00010.8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b/\u0010%\u001a\u0004\b0\u00101R\u001d\u00107\u001a\u0004\u0018\u0001038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b4\u0010%\u001a\u0004\b5\u00106¨\u0006:"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/ILinkmicRealTimeChorusStageFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/dress/config/n;", "Lpy/k;", "songTitleBgImage", "Lpy/k;", "getSongTitleBgImage", "()Lpy/k;", "setSongTitleBgImage", "(Lpy/k;)V", "joinChorusBtnImage", "getJoinChorusBtnImage", "setJoinChorusBtnImage", "closeEffectImage", "getCloseEffectImage", "setCloseEffectImage", "", "voiceWaveImages", "Ljava/util/List;", "getVoiceWaveImages", "()Ljava/util/List;", "setVoiceWaveImages", "(Ljava/util/List;)V", "shareBgImage", "getShareBgImage", "setShareBgImage", "bgImage", "getBgImage", "setBgImage", "leadSingerIconImage", "getLeadSingerIconImage", "setLeadSingerIconImage", "enterBtnImage", "getEnterBtnImage", "setEnterBtnImage", "Lcom/bytedance/android/live/profit/dress/config/IChorusMidiConfigFlexImpl;", "midiConfig$delegate", "Ljava/lang/Object;", "getMidiConfig", "()Lcom/bytedance/android/live/profit/dress/config/IChorusMidiConfigFlexImpl;", "midiConfig", "Lcom/bytedance/android/live/profit/dress/config/IChorusEvaluateEffectConfigFlexImpl;", "evaluateConfig$delegate", "getEvaluateConfig", "()Lcom/bytedance/android/live/profit/dress/config/IChorusEvaluateEffectConfigFlexImpl;", "evaluateConfig", "Lcom/bytedance/android/live/profit/dress/config/IChorusStageEffectConfigFlexImpl;", "stageEffectConfig$delegate", "getStageEffectConfig", "()Lcom/bytedance/android/live/profit/dress/config/IChorusStageEffectConfigFlexImpl;", "stageEffectConfig", "", "themeColor$delegate", "getThemeColor", "()Ljava/lang/String;", "themeColor", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkmicRealTimeChorusStageFlexImpl extends FlexModelBase<n> implements n, vh7.h {

    @SerializedName("evaluate_config")
    protected IChorusEvaluateEffectConfigFlexImpl _$$evaluateConfig;

    @SerializedName("midi_config")
    protected IChorusMidiConfigFlexImpl _$$midiConfig;

    @SerializedName("stage_effect_config")
    protected IChorusStageEffectConfigFlexImpl _$$stageEffectConfig;

    @SerializedName("theme_color")
    protected String _$$themeColor;

    @SerializedName("bg_image")
    protected py.k bgImage;

    @SerializedName("close_effect_image")
    protected py.k closeEffectImage;

    @SerializedName("enter_btn_image")
    protected py.k enterBtnImage;

    @SerializedName("join_chorus_btn_image")
    protected py.k joinChorusBtnImage;

    @SerializedName("lead_singer_icon_image")
    protected py.k leadSingerIconImage;

    @SerializedName("share_bg_image")
    protected py.k shareBgImage;

    @SerializedName("song_title_bg_image")
    protected py.k songTitleBgImage;

    @SerializedName("voice_wave_images")
    protected List<? extends py.k> voiceWaveImages;

    public ILinkmicRealTimeChorusStageFlexImpl() {
        super(n.class);
    }

    /* JADX WARN: Type inference failed for: r2v12, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v17, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v19, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object, py.k] */
    public ILinkmicRealTimeChorusStageFlexImpl(am3.g r5) {
        super(n.class);
        this.voiceWaveImages = new ArrayList();
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L20;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            case 11: goto L9;
            case 12: goto L8;
            default: goto L7;
        };
    L8:
        this.enterBtnImage = vh7.f.a(r5, py.k.class);
        goto L3
    L9:
        this.leadSingerIconImage = vh7.f.a(r5, py.k.class);
        goto L3
    L10:
        this._$$themeColor = am3.h.c(r5);
        goto L3
    L11:
        this.bgImage = vh7.f.a(r5, py.k.class);
        goto L3
    L12:
        this.shareBgImage = vh7.f.a(r5, py.k.class);
        goto L3
    L13:
        this._$$stageEffectConfig = new IChorusStageEffectConfigFlexImpl(r5);
        goto L3
    L14:
        this.voiceWaveImages.add(vh7.f.a(r5, py.k.class));
        goto L3
    L15:
        this._$$evaluateConfig = new IChorusEvaluateEffectConfigFlexImpl(r5);
        goto L3
    L16:
        this.closeEffectImage = vh7.f.a(r5, py.k.class);
        goto L3
    L17:
        this.joinChorusBtnImage = vh7.f.a(r5, py.k.class);
        goto L3
    L18:
        this.songTitleBgImage = vh7.f.a(r5, py.k.class);
        goto L3
    L19:
        this._$$midiConfig = new IChorusMidiConfigFlexImpl(r5);
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L20:
        r5.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.profit.dress.config.n
    public /* bridge */ /* synthetic */ e getEvaluateConfig() {
        return getEvaluateConfig();
    }

    @Override // com.bytedance.android.live.profit.dress.config.n
    public /* bridge */ /* synthetic */ f getMidiConfig() {
        return getMidiConfig();
    }

    @Override // com.bytedance.android.live.profit.dress.config.n
    public /* bridge */ /* synthetic */ g getStageEffectConfig() {
        return getStageEffectConfig();
    }

    @Override // com.bytedance.android.live.profit.dress.config.n
    public py.k getBgImage() {
        return this.bgImage;
    }

    @Override // com.bytedance.android.live.profit.dress.config.n
    public py.k getCloseEffectImage() {
        return this.closeEffectImage;
    }

    @Override // com.bytedance.android.live.profit.dress.config.n
    public py.k getEnterBtnImage() {
        return this.enterBtnImage;
    }

    @Override // com.bytedance.android.live.profit.dress.config.n
    public py.k getJoinChorusBtnImage() {
        return this.joinChorusBtnImage;
    }

    @Override // com.bytedance.android.live.profit.dress.config.n
    public py.k getLeadSingerIconImage() {
        return this.leadSingerIconImage;
    }

    @Override // com.bytedance.android.live.profit.dress.config.n
    public py.k getShareBgImage() {
        return this.shareBgImage;
    }

    @Override // com.bytedance.android.live.profit.dress.config.n
    public py.k getSongTitleBgImage() {
        return this.songTitleBgImage;
    }

    @Override // com.bytedance.android.live.profit.dress.config.n
    public final String getThemeColor() {
        return this._$$themeColor;
    }

    @Override // com.bytedance.android.live.profit.dress.config.n
    public List<py.k> getVoiceWaveImages() {
        return this.voiceWaveImages;
    }

    @Override // com.bytedance.android.live.profit.dress.config.n
    public final IChorusEvaluateEffectConfigFlexImpl getEvaluateConfig() {
        return this._$$evaluateConfig;
    }

    @Override // com.bytedance.android.live.profit.dress.config.n
    public final IChorusMidiConfigFlexImpl getMidiConfig() {
        return this._$$midiConfig;
    }

    @Override // com.bytedance.android.live.profit.dress.config.n
    public final IChorusStageEffectConfigFlexImpl getStageEffectConfig() {
        return this._$$stageEffectConfig;
    }

    public void setBgImage(py.k r1) {
        this.bgImage = r1;
    }

    public void setCloseEffectImage(py.k r1) {
        this.closeEffectImage = r1;
    }

    public void setEnterBtnImage(py.k r1) {
        this.enterBtnImage = r1;
    }

    public void setJoinChorusBtnImage(py.k r1) {
        this.joinChorusBtnImage = r1;
    }

    public void setLeadSingerIconImage(py.k r1) {
        this.leadSingerIconImage = r1;
    }

    public void setShareBgImage(py.k r1) {
        this.shareBgImage = r1;
    }

    public void setSongTitleBgImage(py.k r1) {
        this.songTitleBgImage = r1;
    }

    public void setVoiceWaveImages(List<? extends py.k> r1) {
        this.voiceWaveImages = r1;
    }
}
