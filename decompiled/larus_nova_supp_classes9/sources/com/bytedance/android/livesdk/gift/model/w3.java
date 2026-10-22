package com.bytedance.android.livesdk.gift.model;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R*\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R&\u0010\u0012\u001a\u00060\u000bj\u0002`\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0011\u0010\t\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0016\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0015\u0010\t\u001a\u0004\b\u0013\u0010\u0005\"\u0004\b\u0014\u0010\u0007R\"\u0010\u001d\u001a\u00020\u00178&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\t\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR&\u0010!\u001a\u00060\u000bj\u0002`\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b \u0010\t\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010R\"\u0010(\u001a\u00020\"8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b'\u0010\t\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010,\u001a\u00020\u00178&@&X§\u000e¢\u0006\u0012\u0012\u0004\b+\u0010\t\u001a\u0004\b)\u0010\u0019\"\u0004\b*\u0010\u001b¨\u0006-"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/w3;", "Lvh7/c;", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getPreEffectImg", "()Lpy/k;", "setPreEffectImg", "(Lpy/k;)V", "getPreEffectImg$annotations", "()V", "preEffectImg", BuildConfig.FLAVOR, "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getTrayStartTime", "()J", "setTrayStartTime", "(J)V", "getTrayStartTime$annotations", "trayStartTime", "getTrayRipple", "setTrayRipple", "getTrayRipple$annotations", "trayRipple", BuildConfig.FLAVOR, "getPreSchema", "()Ljava/lang/String;", "setPreSchema", "(Ljava/lang/String;)V", "getPreSchema$annotations", "preSchema", "getPreDuration", "setPreDuration", "getPreDuration$annotations", "preDuration", BuildConfig.FLAVOR, "getPreEffectSource", "()I", "setPreEffectSource", "(I)V", "getPreEffectSource$annotations", "preEffectSource", "getExtra", "setExtra", "getExtra$annotations", "extra", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface w3 extends vh7.c<w3> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "extra")
    String getExtra();

    @FieldName(name = "pre_duration")
    long getPreDuration();

    @FieldName(name = "pre_effect_img")
    py.k getPreEffectImg();

    @FieldName(name = "pre_effect_source")
    int getPreEffectSource();

    @FieldName(name = "pre_schema")
    String getPreSchema();

    @FieldName(name = "tray_ripple")
    py.k getTrayRipple();

    @FieldName(name = "tray_start_time")
    long getTrayStartTime();

    @FieldName(name = "extra#setter")
    void setExtra(String r1);

    @FieldName(name = "pre_duration#setter")
    void setPreDuration(long r1);

    @FieldName(name = "pre_effect_img#setter")
    void setPreEffectImg(py.k r1);

    @FieldName(name = "pre_effect_source#setter")
    void setPreEffectSource(int r1);

    @FieldName(name = "pre_schema#setter")
    void setPreSchema(String r1);

    @FieldName(name = "tray_ripple#setter")
    void setTrayRipple(py.k r1);

    @FieldName(name = "tray_start_time#setter")
    void setTrayStartTime(long r1);
}
