package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0006\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b*\u0010+R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR0\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR0\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\"\u0010\u001e\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010\u000fR0\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0013\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\"\u0010$\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u000b\u001a\u0004\b%\u0010\r\"\u0004\b&\u0010\u000fR0\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0013\u001a\u0004\b(\u0010\u0015\"\u0004\b)\u0010\u0017¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdk/config/o91;", "", "", "loadStrategy", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setLoadStrategy", "(Ljava/lang/String;)V", "", "loadP0DelayTime", "J", "b", "()J", "setLoadP0DelayTime", "(J)V", "", "", "p0InnerDelayTime", "Ljava/util/Map;", "g", "()Ljava/util/Map;", "setP0InnerDelayTime", "(Ljava/util/Map;)V", "loadP1DelayTime", "c", "setLoadP1DelayTime", "p1InnerDelayTime", "h", "setP1InnerDelayTime", "loadP2DelayTime", "d", "setLoadP2DelayTime", "p2InnerDelayTime", "i", "setP2InnerDelayTime", "loadOtherDelayTime", "a", "setLoadOtherDelayTime", "otherInnerDelayTime", "f", "setOtherInnerDelayTime", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o91 {

    @SerializedName("load_other_delay_time")
    private long loadOtherDelayTime;

    @SerializedName("load_p0_delay_time")
    private long loadP0DelayTime;

    @SerializedName("load_p1_delay_time")
    private long loadP1DelayTime;

    @SerializedName("load_p2_delay_time")
    private long loadP2DelayTime;

    @SerializedName("load_strategy")
    private String loadStrategy;

    @SerializedName("other_inner_delay_time")
    private Map<Double, Long> otherInnerDelayTime;

    @SerializedName("p0_inner_delay_time")
    private Map<Double, Long> p0InnerDelayTime;

    @SerializedName("p1_inner_delay_time")
    private Map<Double, Long> p1InnerDelayTime;

    @SerializedName("p2_inner_delay_time")
    private Map<Double, Long> p2InnerDelayTime;

    public o91() {
    }

    public final long a() {
        return this.loadOtherDelayTime;
    }

    public final long b() {
        return this.loadP0DelayTime;
    }

    public final long c() {
        return this.loadP1DelayTime;
    }

    public final long d() {
        return this.loadP2DelayTime;
    }

    public final String e() {
        return this.loadStrategy;
    }

    public final Map<Double, Long> f() {
        return this.otherInnerDelayTime;
    }

    public final Map<Double, Long> g() {
        return this.p0InnerDelayTime;
    }

    public final Map<Double, Long> h() {
        return this.p1InnerDelayTime;
    }

    public final Map<Double, Long> i() {
        return this.p2InnerDelayTime;
    }
}
