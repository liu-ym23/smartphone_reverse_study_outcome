package com.bytedance.android.live.profit.dress.config;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.api.dress.GuestBattleGradeConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/IGuestBattleThemeElementConfig_IGuestBattleGradeConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/dress/config/j$c;", "Lpy/k;", "playValueIcon", "Lpy/k;", "getPlayValueIcon", "()Lpy/k;", "setPlayValueIcon", "(Lpy/k;)V", "linkMicEffect", "getLinkMicEffect", "setLinkMicEffect", "resultEffect", "getResultEffect", "setResultEffect", "", "name$delegate", "Ljava/lang/Object;", "getName", "()Ljava/lang/String;", "name", "beautyEffectId$delegate", "getBeautyEffectId", "beautyEffectId", "decorationId$delegate", "getDecorationId", "decorationId", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IGuestBattleThemeElementConfig_IGuestBattleGradeConfigFlexImpl extends FlexModelBase<j.c> implements j.c, vh7.h {

    @SerializedName("beauty_effect_id")
    protected String _$$beautyEffectId;

    @SerializedName("decoration_id")
    protected String _$$decorationId;

    @SerializedName("name")
    protected String _$$name;

    @SerializedName("linkmic_effect")
    protected py.k linkMicEffect;

    @SerializedName("play_value_icon")
    protected py.k playValueIcon;

    @SerializedName("result_effect")
    protected py.k resultEffect;

    public IGuestBattleThemeElementConfig_IGuestBattleGradeConfigFlexImpl() {
        super(j.c.class);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Object, py.k] */
    public IGuestBattleThemeElementConfig_IGuestBattleGradeConfigFlexImpl(am3.g r5) {
        super(j.c.class);
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L14;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        this._$$decorationId = am3.h.c(r5);
        goto L3
    L9:
        this.resultEffect = vh7.f.a(r5, py.k.class);
        goto L3
    L10:
        this._$$beautyEffectId = am3.h.c(r5);
        goto L3
    L11:
        this.linkMicEffect = vh7.f.a(r5, py.k.class);
        goto L3
    L12:
        this.playValueIcon = vh7.f.a(r5, py.k.class);
        goto L3
    L13:
        this._$$name = am3.h.c(r5);
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L14:
        r5.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.profit.dress.config.j.c
    public final String getBeautyEffectId() {
        return this._$$beautyEffectId;
    }

    @Override // com.bytedance.android.live.profit.dress.config.j.c
    public final String getDecorationId() {
        return this._$$decorationId;
    }

    @Override // com.bytedance.android.live.profit.dress.config.j.c
    public py.k getLinkMicEffect() {
        return this.linkMicEffect;
    }

    @Override // com.bytedance.android.live.profit.dress.config.j.c
    public final String getName() {
        return this._$$name;
    }

    @Override // com.bytedance.android.live.profit.dress.config.j.c
    public py.k getPlayValueIcon() {
        return this.playValueIcon;
    }

    @Override // com.bytedance.android.live.profit.dress.config.j.c
    public py.k getResultEffect() {
        return this.resultEffect;
    }

    public void setLinkMicEffect(py.k r1) {
        this.linkMicEffect = r1;
    }

    public void setPlayValueIcon(py.k r1) {
        this.playValueIcon = r1;
    }

    public void setResultEffect(py.k r1) {
        this.resultEffect = r1;
    }
}
