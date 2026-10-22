package com.bytedance.android.live.profit.dress.config;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.api.dress.PropConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR.\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001b\u0010\u001a\u001a\u00020\u00158VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/IPropConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/dress/config/s;", "", "", "Lpy/k;", "playValueIcon", "Ljava/util/Map;", "getPlayValueIcon", "()Ljava/util/Map;", "setPlayValueIcon", "(Ljava/util/Map;)V", "linkmicEffect", "Lpy/k;", "getLinkmicEffect", "()Lpy/k;", "setLinkmicEffect", "(Lpy/k;)V", "staticLinkmicImg", "getStaticLinkmicImg", "setStaticLinkmicImg", "", "beautyEffectId$delegate", "Ljava/lang/Object;", "getBeautyEffectId", "()Ljava/lang/String;", "beautyEffectId", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IPropConfigFlexImpl extends FlexModelBase<s> implements s, vh7.h {

    @SerializedName("beauty_effect_id")
    protected String _$$beautyEffectId;

    @SerializedName("linkmic_effect")
    protected py.k linkmicEffect;

    @SerializedName("play_value_icon")
    protected Map<Long, ? extends py.k> playValueIcon;

    @SerializedName("static_linkmic_img")
    protected py.k staticLinkmicImg;

    public IPropConfigFlexImpl() {
        super(s.class);
        this.playValueIcon = com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.b();
        this._$$beautyEffectId = "";
    }

    @Override // com.bytedance.android.live.profit.dress.config.s
    public final String getBeautyEffectId() {
        return this._$$beautyEffectId;
    }

    @Override // com.bytedance.android.live.profit.dress.config.s
    public py.k getLinkmicEffect() {
        return this.linkmicEffect;
    }

    @Override // com.bytedance.android.live.profit.dress.config.s
    public Map<Long, py.k> getPlayValueIcon() {
        return this.playValueIcon;
    }

    @Override // com.bytedance.android.live.profit.dress.config.s
    public py.k getStaticLinkmicImg() {
        return this.staticLinkmicImg;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, py.k] */
    public IPropConfigFlexImpl(am3.g r12) {
        super(s.class);
        this.playValueIcon = new HashMap();
        setThreadSafe(false);
        long r0 = r12.c();
    L3:
        int r2 = r12.f();
        if (r2 == (-1)) goto L32;
        am3.g.a r5 = decodeExtensionFields(r2, r12);
        if (r2 != 1) goto L7;
        long r7 = r12.c();
        Long r3 = null;
        Object r6 = null;
    L17:
        int r9 = r12.f();
        if (r9 == (-1)) goto L24;
        if (r9 != 1) goto L20;
        r3 = Long.valueOf(r12.j());
        goto L17
    L20:
        if (r9 != 2) goto L21;
        r6 = vh7.f.a(r12, py.k.class);
        goto L17
    L21:
        am3.h.e(r12);
        goto L17
    L24:
        r12.d(r7);
        Map<Long, ? extends py.k> r4 = this.playValueIcon;
        if (r3 == null) goto L31;
        if (r6 == null) goto L29;
        r4.put(r3, r6);
        goto L3
    L29:
        throw new IllegalStateException("Value must not be null");
    L31:
        throw new IllegalStateException("Key must not be null");
    L7:
        if (r2 != 2) goto L9;
        this.linkmicEffect = vh7.f.a(r12, py.k.class);
        goto L3
    L9:
        if (r2 != 3) goto L11;
        this._$$beautyEffectId = am3.h.c(r12);
        goto L3
    L11:
        if (r2 != 4) goto L12;
        this.staticLinkmicImg = vh7.f.a(r12, py.k.class);
        goto L3
    L12:
        am3.h.d(r5, r12);
        goto L3
    L32:
        r12.d(r0);
        setThreadSafe(true);
        if (this.playValueIcon != null) goto L36;
        this.playValueIcon = com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.b();
    L36:
        if (this._$$beautyEffectId != null) goto L65;
        this._$$beautyEffectId = "";
        return;
    }

    public void setLinkmicEffect(py.k r1) {
        this.linkmicEffect = r1;
    }

    public void setPlayValueIcon(Map<Long, ? extends py.k> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.playValueIcon = r2;
    }

    public void setStaticLinkmicImg(py.k r1) {
        this.staticLinkmicImg = r1;
    }
}
