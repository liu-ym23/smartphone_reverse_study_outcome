package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.data.TrayPreEffect")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b-\u0010.R/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R/\u0010\u0016\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\nR+\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00178V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR+\u0010!\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R+\u0010(\u001a\u00020\"2\u0006\u0010\u0004\u001a\u00020\"8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010\u0006\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R+\u0010,\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00178V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b)\u0010\u0006\u001a\u0004\b*\u0010\u001a\"\u0004\b+\u0010\u001c¨\u0006/"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/TrayPreEffectFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/w3;", "Lpy/k;", "<set-?>", "preEffectImg$delegate", "Ljava/lang/Object;", "getPreEffectImg", "()Lpy/k;", "setPreEffectImg", "(Lpy/k;)V", "preEffectImg", BuildConfig.FLAVOR, "trayStartTime$delegate", "getTrayStartTime", "()J", "setTrayStartTime", "(J)V", "trayStartTime", "trayRipple$delegate", "getTrayRipple", "setTrayRipple", "trayRipple", BuildConfig.FLAVOR, "preSchema$delegate", "getPreSchema", "()Ljava/lang/String;", "setPreSchema", "(Ljava/lang/String;)V", "preSchema", "preDuration$delegate", "getPreDuration", "setPreDuration", "preDuration", BuildConfig.FLAVOR, "preEffectSource$delegate", "getPreEffectSource", "()I", "setPreEffectSource", "(I)V", "preEffectSource", "extra$delegate", "getExtra", "setExtra", "extra", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TrayPreEffectFlexImpl extends FlexModelBase<w3> implements w3, vh7.h {

    @SerializedName("extra")
    protected String _$$extra;

    @SerializedName("pre_duration")
    protected long _$$preDuration;

    @SerializedName("pre_effect_img")
    protected py.k _$$preEffectImg;

    @SerializedName("pre_effect_source")
    protected int _$$preEffectSource;

    @SerializedName("pre_schema")
    protected String _$$preSchema;

    @SerializedName("tray_ripple")
    protected py.k _$$trayRipple;

    @SerializedName("tray_start_time")
    protected long _$$trayStartTime;

    public TrayPreEffectFlexImpl() {
        super(w3.class);
        this._$$preSchema = BuildConfig.FLAVOR;
        this._$$extra = BuildConfig.FLAVOR;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w3
    public final String getExtra() {
        return this._$$extra;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w3
    public final long getPreDuration() {
        return this._$$preDuration;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w3
    public final py.k getPreEffectImg() {
        return this._$$preEffectImg;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w3
    public final int getPreEffectSource() {
        return this._$$preEffectSource;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w3
    public final String getPreSchema() {
        return this._$$preSchema;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w3
    public final py.k getTrayRipple() {
        return this._$$trayRipple;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w3
    public final long getTrayStartTime() {
        return this._$$trayStartTime;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, py.k] */
    public TrayPreEffectFlexImpl(am3.g r5) {
        super(w3.class);
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L7;
        };
    L8:
        this._$$extra = am3.h.c(r5);
        goto L3
    L9:
        this._$$preEffectSource = r5.i();
        goto L3
    L10:
        this._$$preDuration = r5.j();
        goto L3
    L11:
        this._$$preSchema = am3.h.c(r5);
        goto L3
    L12:
        this._$$trayRipple = vh7.f.a(r5, py.k.class);
        goto L3
    L13:
        this._$$trayStartTime = r5.j();
        goto L3
    L14:
        this._$$preEffectImg = vh7.f.a(r5, py.k.class);
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L15:
        r5.d(r0);
        setThreadSafe(true);
        if (this._$$preSchema != null) goto L19;
        this._$$preSchema = BuildConfig.FLAVOR;
    L19:
        if (this._$$extra != null) goto L40;
        this._$$extra = BuildConfig.FLAVOR;
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w3
    public final void setExtra(String r1) {
        this._$$extra = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w3
    public final void setPreDuration(long r1) {
        this._$$preDuration = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w3
    public final void setPreEffectImg(py.k r1) {
        this._$$preEffectImg = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w3
    public final void setPreEffectSource(int r1) {
        this._$$preEffectSource = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w3
    public final void setPreSchema(String r1) {
        this._$$preSchema = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w3
    public final void setTrayRipple(py.k r1) {
        this._$$trayRipple = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w3
    public final void setTrayStartTime(long r1) {
        this._$$trayStartTime = r1;
    }
}
