package com.bytedance.android.live.profit.dress.config;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.api.dress.LinkmicDecorationConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b2\u00103R\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0012\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u001b\u0010\u0015\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000eR\u001b\u0010\u0018\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u000eR\u001b\u0010\u001b\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u001a\u0010\u000eR\u001b\u0010 \u001a\u00020\u001c8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\f\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010#\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\f\u001a\u0004\b\"\u0010\u000eR\u001b\u0010&\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\f\u001a\u0004\b%\u0010\u000eR!\u0010,\u001a\b\u0012\u0004\u0012\u00020(0'8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\f\u001a\u0004\b*\u0010+R\u001d\u00101\u001a\u0004\u0018\u00010-8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\f\u001a\u0004\b/\u00100¨\u00064"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/ILinkmicDecorationConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/dress/config/k;", "Lpy/k;", "honorIcon", "Lpy/k;", "getHonorIcon", "()Lpy/k;", "setHonorIcon", "(Lpy/k;)V", "", "name$delegate", "Ljava/lang/Object;", "getName", "()Ljava/lang/String;", "name", "playValueIcon$delegate", "getPlayValueIcon", "playValueIcon", "linkmicDynamicEffect$delegate", "getLinkmicDynamicEffect", "linkmicDynamicEffect", "beautyEffectId$delegate", "getBeautyEffectId", "beautyEffectId", "linkmicStaticEffect$delegate", "getLinkmicStaticEffect", "linkmicStaticEffect", "", "showFlymicEffect$delegate", "getShowFlymicEffect", "()Z", "showFlymicEffect", "valueBgColor$delegate", "getValueBgColor", "valueBgColor", "valueNumberColor$delegate", "getValueNumberColor", "valueNumberColor", "", "", "playType$delegate", "getPlayType", "()Ljava/util/List;", "playType", "Lcom/bytedance/android/live/profit/dress/config/ILinkmicPlayModeStarWishConfigFlexImpl;", "starWishConfig$delegate", "getStarWishConfig", "()Lcom/bytedance/android/live/profit/dress/config/ILinkmicPlayModeStarWishConfigFlexImpl;", "starWishConfig", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ILinkmicDecorationConfigFlexImpl extends FlexModelBase<k> implements k, vh7.h {

    @SerializedName("beauty_effect_ID")
    protected String _$$beautyEffectId;

    @SerializedName("linkmic_dynamic_effect")
    protected String _$$linkmicDynamicEffect;

    @SerializedName("linkmic_static_effect")
    protected String _$$linkmicStaticEffect;

    @SerializedName("name")
    protected String _$$name;

    @SerializedName("play_type")
    protected List<Integer> _$$playType;

    @SerializedName("play_value_icon")
    protected String _$$playValueIcon;

    @SerializedName("show_fly_mic_effect")
    protected boolean _$$showFlymicEffect;

    @SerializedName("star_wish_config")
    protected ILinkmicPlayModeStarWishConfigFlexImpl _$$starWishConfig;

    @SerializedName("value_BG_color")
    protected String _$$valueBgColor;

    @SerializedName("value_number_color")
    protected String _$$valueNumberColor;

    @SerializedName("honor_icon")
    protected py.k honorIcon;

    public ILinkmicDecorationConfigFlexImpl() {
        super(k.class);
        this._$$name = "";
        this._$$playValueIcon = "";
        this._$$linkmicDynamicEffect = "";
        this._$$beautyEffectId = "";
        this._$$linkmicStaticEffect = "";
        this._$$showFlymicEffect = false;
        this._$$valueBgColor = "";
        this._$$valueNumberColor = "";
        this.honorIcon = (py.k) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(py.k.class);
        this._$$playType = $defaultValue_playType$();
    }

    public final List<Integer> $defaultValue_playType$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.live.profit.dress.config.k
    public /* bridge */ /* synthetic */ l getStarWishConfig() {
        return getStarWishConfig();
    }

    @Override // com.bytedance.android.live.profit.dress.config.k
    public final String getBeautyEffectId() {
        return this._$$beautyEffectId;
    }

    @Override // com.bytedance.android.live.profit.dress.config.k
    public py.k getHonorIcon() {
        return this.honorIcon;
    }

    @Override // com.bytedance.android.live.profit.dress.config.k
    public final String getLinkmicDynamicEffect() {
        return this._$$linkmicDynamicEffect;
    }

    @Override // com.bytedance.android.live.profit.dress.config.k
    public final String getLinkmicStaticEffect() {
        return this._$$linkmicStaticEffect;
    }

    @Override // com.bytedance.android.live.profit.dress.config.k
    public final String getName() {
        return this._$$name;
    }

    @Override // com.bytedance.android.live.profit.dress.config.k
    public final List<Integer> getPlayType() {
        return this._$$playType;
    }

    @Override // com.bytedance.android.live.profit.dress.config.k
    public final String getPlayValueIcon() {
        return this._$$playValueIcon;
    }

    @Override // com.bytedance.android.live.profit.dress.config.k
    public final boolean getShowFlymicEffect() {
        return this._$$showFlymicEffect;
    }

    @Override // com.bytedance.android.live.profit.dress.config.k
    public final String getValueBgColor() {
        return this._$$valueBgColor;
    }

    @Override // com.bytedance.android.live.profit.dress.config.k
    public final String getValueNumberColor() {
        return this._$$valueNumberColor;
    }

    @Override // com.bytedance.android.live.profit.dress.config.k
    public final ILinkmicPlayModeStarWishConfigFlexImpl getStarWishConfig() {
        return this._$$starWishConfig;
    }

    /* JADX WARN: Type inference failed for: r4v12, types: [java.lang.Object, py.k] */
    public ILinkmicDecorationConfigFlexImpl(am3.g r8) {
        super(k.class);
        this._$$playType = new ArrayList();
        setThreadSafe(false);
        long r1 = r8.c();
        boolean r3 = false;
    L3:
        int r4 = r8.f();
        if (r4 == (-1)) goto L24;
        am3.g.a r5 = decodeExtensionFields(r4, r8);
        if (r4 != 10) goto L8;
        this.honorIcon = vh7.f.a(r8, py.k.class);
        goto L3
    L8:
        if (r4 != 20) goto L10;
        this._$$playType.add(Integer.valueOf(r8.i()));
        goto L3
    L10:
        if (r4 != 21) goto L11;
        this._$$starWishConfig = new ILinkmicPlayModeStarWishConfigFlexImpl(r8);
        goto L3
    L11:
        switch(r4) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L13;
            default: goto L12;
        };
    L13:
        this._$$valueNumberColor = am3.h.c(r8);
        goto L3
    L14:
        this._$$valueBgColor = am3.h.c(r8);
        goto L3
    L15:
        this._$$showFlymicEffect = am3.h.a(r8);
        r3 = r3 | true;
        goto L3
    L16:
        this._$$linkmicStaticEffect = am3.h.c(r8);
        goto L3
    L17:
        this._$$beautyEffectId = am3.h.c(r8);
        goto L3
    L18:
        this._$$linkmicDynamicEffect = am3.h.c(r8);
        goto L3
    L19:
        this._$$playValueIcon = am3.h.c(r8);
        goto L3
    L20:
        this._$$name = am3.h.c(r8);
        goto L3
    L12:
        am3.h.d(r5, r8);
        goto L3
    L24:
        r8.d(r1);
        setThreadSafe(true);
        if (this._$$name != null) goto L28;
        this._$$name = "";
    L28:
        if (this._$$playValueIcon != null) goto L31;
        this._$$playValueIcon = "";
    L31:
        if (this._$$linkmicDynamicEffect != null) goto L34;
        this._$$linkmicDynamicEffect = "";
    L34:
        if (this._$$beautyEffectId != null) goto L37;
        this._$$beautyEffectId = "";
    L37:
        if (this._$$linkmicStaticEffect != null) goto L40;
        this._$$linkmicStaticEffect = "";
    L40:
        if ((true & r3) == true) goto L43;
        this._$$showFlymicEffect = false;
    L43:
        if (this._$$valueBgColor != null) goto L46;
        this._$$valueBgColor = "";
    L46:
        if (this._$$valueNumberColor != null) goto L49;
        this._$$valueNumberColor = "";
    L49:
        if (this.honorIcon != null) goto L52;
        this.honorIcon = (py.k) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(py.k.class);
    L52:
        if (this._$$playType.isEmpty() == false) goto L84;
        this._$$playType = $defaultValue_playType$();
        return;
    }

    public void setHonorIcon(py.k r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.honorIcon = r2;
    }
}
