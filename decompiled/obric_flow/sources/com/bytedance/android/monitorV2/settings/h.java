package com.bytedance.android.monitorV2.settings;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0005\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u0015\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010$\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u000e\u001a\u0004\b\r\u0010\u0010\"\u0004\b#\u0010\u0012R(\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u001d\u001a\u0004\b&\u0010\u001e\"\u0004\b'\u0010 ¨\u0006)"}, d2 = {"Lcom/bytedance/android/monitorV2/settings/h;", "", "<init>", "()V", "", "a", "Z", "d", "()Z", "setUseMonitorDetect", "(Z)V", "useMonitorDetect", "", "b", "J", "getMonitorDetectTime", "()J", "setMonitorDetectTime", "(J)V", "monitorDetectTime", "", "c", "I", "()I", "setMonitorDetectType", "(I)V", "monitorDetectType", "", "", "[Ljava/lang/String;", "()[Ljava/lang/String;", "setUrlBlockList", "([Ljava/lang/String;)V", "urlBlockList", "e", "setStayDuration", "stayDuration", "f", "getUrlAppInfoList", "setUrlAppInfoList", "urlAppInfoList", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class h {
    public static final h g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("use_monitor_detect")
    private boolean f3731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("monitor_detect_time")
    private long f3732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("detect_type")
    private int f3733c;

    @SerializedName("url_blocklist")
    private String[] d;

    @SerializedName("stay_duration")
    private long e;

    @SerializedName("url_appinfo_list")
    private String[] f;

    static {
        g = new h();
    }

    public h() {
        this.f3731a = true;
        this.f3732b = 6000;
        this.d = new String[0];
        this.e = 4000;
        this.f = new String[0];
    }

    public final int a() {
        return this.f3733c;
    }

    public final long b() {
        return this.e;
    }

    public final String[] c() {
        return this.d;
    }

    public final boolean d() {
        return this.f3731a;
    }
}
