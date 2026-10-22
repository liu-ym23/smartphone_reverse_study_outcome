package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R2\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/config/l21;", "", "", "enable", "Z", "a", "()Z", "setEnable", "(Z)V", "enableCheckPriority", "getEnableCheckPriority", "setEnableCheckPriority", "enableReloadPriority", "getEnableReloadPriority", "setEnableReloadPriority", "enableLoadOptimization", "getEnableLoadOptimization", "digg_animation_delay", "getDigg_animation_delay", "disable_p0_post", "getDisable_p0_post", "", "", "Lcom/bytedance/android/livesdk/config/x1;", "config", "Ljava/util/Map;", "getConfig", "()Ljava/util/Map;", "setConfig", "(Ljava/util/Map;)V", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l21 {
    public static final /* synthetic */ int a = 0;

    @SerializedName("config")
    private Map<String, x1> config;

    @SerializedName("digg_animation_delay")
    private final boolean digg_animation_delay;

    @SerializedName("disable_p0_post")
    private final boolean disable_p0_post;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_check_priority")
    private boolean enableCheckPriority;

    @SerializedName("enable_load_optimization")
    private final boolean enableLoadOptimization;

    @SerializedName("enable_reload_priority")
    private boolean enableReloadPriority;

    public static final class a {
    }

    static {
    }

    public l21() {
    }

    public final boolean a() {
        return this.enable;
    }

    public final Map<String, Double> b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "roomType");
        Map<String, x1> r0 = this.config;
        if (r0 == null) goto L8;
        x1 r3 = r0.get(r2);
        if (r3 == null) goto L8;
        Map<String, Double> r4 = r3.a();
        if (r4 == null) goto L8;
        return r4;
    L8:
        Map<String, x1> r5 = this.config;
        if (r5 == null) goto L13;
        x1 r6 = r5.get("default");
        if (r6 == null) goto L13;
        return r6.a();
    L13:
        return null;
    }

    public final o91 c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "roomType");
        Map<String, x1> r0 = this.config;
        if (r0 == null) goto L8;
        x1 r3 = r0.get(r2);
        if (r3 == null) goto L8;
        o91 r4 = r3.b();
        if (r4 == null) goto L8;
        return r4;
    L8:
        Map<String, x1> r5 = this.config;
        if (r5 == null) goto L13;
        x1 r6 = r5.get("default");
        if (r6 == null) goto L13;
        return r6.b();
    L13:
        return null;
    }
}
