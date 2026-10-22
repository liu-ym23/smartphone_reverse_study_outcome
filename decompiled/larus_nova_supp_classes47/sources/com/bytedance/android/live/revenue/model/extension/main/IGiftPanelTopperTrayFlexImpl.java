package com.bytedance.android.live.revenue.model.extension.main;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.data.GiftPanelTopperTray")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0019\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b&\u0010'R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0016\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007R\u001b\u0010\u0019\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007R\u001b\u0010\u001c\u001a\u00020\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0012R\u001b\u0010\u001f\u001a\u00020\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001e\u0010\u0012R\u001b\u0010\"\u001a\u00020\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0005\u001a\u0004\b!\u0010\u0012R\u001b\u0010%\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0005\u001a\u0004\b$\u0010\u0007¨\u0006("}, d2 = {"Lcom/bytedance/android/live/revenue/model/extension/main/IGiftPanelTopperTrayFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/revenue/model/extension/main/b;", "", "panelSchema$delegate", "Ljava/lang/Object;", "getPanelSchema", "()Ljava/lang/String;", "panelSchema", "", "Lcom/bytedance/android/live/revenue/model/extension/main/IPeriodTextFlexImpl;", "periodTexts$delegate", "getPeriodTexts", "()Ljava/util/List;", "periodTexts", "", "displayDuration$delegate", "getDisplayDuration", "()I", "displayDuration", "jumpSchema$delegate", "getJumpSchema", "jumpSchema", "animationType$delegate", "getAnimationType", "animationType", "animationGap$delegate", "getAnimationGap", "animationGap", "animationFreq$delegate", "getAnimationFreq", "animationFreq", "textRoundPeriod$delegate", "getTextRoundPeriod", "textRoundPeriod", "extra$delegate", "getExtra", "extra", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IGiftPanelTopperTrayFlexImpl extends FlexModelBase<b> implements b, h {

    @SerializedName("animation_freq")
    protected int _$$animationFreq;

    @SerializedName("animation_gap")
    protected int _$$animationGap;

    @SerializedName("animation_type")
    protected String _$$animationType;

    @SerializedName("display_duration")
    protected int _$$displayDuration;

    @SerializedName("extra")
    protected String _$$extra;

    @SerializedName("jump_schema")
    protected String _$$jumpSchema;

    @SerializedName("panel_schema")
    protected String _$$panelSchema;

    @SerializedName("period_texts")
    protected List<IPeriodTextFlexImpl> _$$periodTexts;

    @SerializedName("text_round_period")
    protected int _$$textRoundPeriod;

    public IGiftPanelTopperTrayFlexImpl() {
        super(b.class);
        this._$$panelSchema = "";
        this._$$periodTexts = $defaultValue_periodTexts$();
        this._$$jumpSchema = "";
        this._$$animationType = "";
        this._$$animationGap = $defaultValue_animationGap$();
        this._$$animationFreq = $defaultValue_animationFreq$();
        this._$$textRoundPeriod = $defaultValue_textRoundPeriod$();
        this._$$extra = "";
    }

    public final int $defaultValue_animationFreq$() {
        return 1;
    }

    public final int $defaultValue_animationGap$() {
        return 1;
    }

    public final int $defaultValue_textRoundPeriod$() {
        return 1;
    }

    public final List<IPeriodTextFlexImpl> $defaultValue_periodTexts$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.live.revenue.model.extension.main.b
    public final int getAnimationFreq() {
        return this._$$animationFreq;
    }

    @Override // com.bytedance.android.live.revenue.model.extension.main.b
    public final int getAnimationGap() {
        return this._$$animationGap;
    }

    @Override // com.bytedance.android.live.revenue.model.extension.main.b
    public final String getAnimationType() {
        return this._$$animationType;
    }

    @Override // com.bytedance.android.live.revenue.model.extension.main.b
    public final int getDisplayDuration() {
        return this._$$displayDuration;
    }

    @Override // com.bytedance.android.live.revenue.model.extension.main.b
    public final String getExtra() {
        return this._$$extra;
    }

    @Override // com.bytedance.android.live.revenue.model.extension.main.b
    public final String getJumpSchema() {
        return this._$$jumpSchema;
    }

    @Override // com.bytedance.android.live.revenue.model.extension.main.b
    public final String getPanelSchema() {
        return this._$$panelSchema;
    }

    @Override // com.bytedance.android.live.revenue.model.extension.main.b
    public final List<IPeriodTextFlexImpl> getPeriodTexts() {
        return this._$$periodTexts;
    }

    @Override // com.bytedance.android.live.revenue.model.extension.main.b
    public final int getTextRoundPeriod() {
        return this._$$textRoundPeriod;
    }

    public IGiftPanelTopperTrayFlexImpl(g r6) {
        super(b.class);
        this._$$periodTexts = new ArrayList();
        int r0 = 0;
        setThreadSafe(false);
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L17;
        g.a r4 = decodeExtensionFields(r3, r6);
        switch(r3) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            default: goto L7;
        };
    L8:
        this._$$extra = am3.h.c(r6);
        goto L3
    L9:
        this._$$textRoundPeriod = r6.i();
        r0 = r0 | 8;
        goto L3
    L10:
        this._$$animationFreq = r6.i();
        r0 = r0 | 4;
        goto L3
    L11:
        this._$$animationGap = r6.i();
        r0 = r0 | 2;
        goto L3
    L12:
        this._$$animationType = am3.h.c(r6);
        goto L3
    L13:
        this._$$jumpSchema = am3.h.c(r6);
        goto L3
    L14:
        this._$$displayDuration = r6.i();
        r0 = r0 | 1;
        goto L3
    L15:
        this._$$periodTexts.add(new IPeriodTextFlexImpl(r6));
        goto L3
    L16:
        this._$$panelSchema = am3.h.c(r6);
        goto L3
    L7:
        am3.h.d(r4, r6);
        goto L3
    L17:
        r6.d(r1);
        setThreadSafe(true);
        if (this._$$panelSchema != null) goto L21;
        this._$$panelSchema = "";
    L21:
        if (this._$$periodTexts.isEmpty() == false) goto L24;
        this._$$periodTexts = $defaultValue_periodTexts$();
    L24:
        if (this._$$jumpSchema != null) goto L27;
        this._$$jumpSchema = "";
    L27:
        if (this._$$animationType != null) goto L30;
        this._$$animationType = "";
    L30:
        if ((r0 & 2) != 0) goto L33;
        this._$$animationGap = $defaultValue_animationGap$();
    L33:
        if ((r0 & 4) != 0) goto L36;
        this._$$animationFreq = $defaultValue_animationFreq$();
    L36:
        if ((r0 & 8) != 0) goto L39;
        this._$$textRoundPeriod = $defaultValue_textRoundPeriod$();
    L39:
        if (this._$$extra != null) goto L64;
        this._$$extra = "";
        return;
    }
}
