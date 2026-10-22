package com.bytedance.apm.config;

import com.bytedance.services.apm.api.IHttpService;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private final com.bytedance.apm.d.b A;
    private final com.bytedance.apm.d.a B;
    private final com.bytedance.apm.d.f C;
    private final ExecutorService D;
    private final com.bytedance.services.apm.api.e E;
    private final String F;
    private final com.bytedance.apm.d.g G;
    private final com.bytedance.apm.d.e H;
    private final com.bytedance.apm.d.c I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<String> f1252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<String> f1253b;
    private List<String> c;
    private List<String> d;
    private com.bytedance.apm.d.d e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private final long m;
    private final boolean n;
    private final boolean o;
    private final boolean p;
    private final boolean q;
    private final boolean r;
    private final boolean s;
    private final boolean t;
    private final JSONObject u;
    private final com.bytedance.apm.core.b v;
    private final com.bytedance.apm.core.d w;
    private final IHttpService x;
    private final Set<Object> y;
    private final long z;

    public boolean a() {
        return this.j;
    }

    public boolean b() {
        return this.k;
    }

    public boolean c() {
        return this.l;
    }

    public long d() {
        return this.m;
    }

    public boolean e() {
        return this.o;
    }

    public boolean f() {
        return this.p;
    }

    public boolean g() {
        return this.q;
    }

    public com.bytedance.apm.d.c h() {
        return this.I;
    }

    public String toString() {
        return "ApmStartConfig{mSlardarConfigUrls=" + this.f1252a + ", mDefaultLogReportUrls=" + this.f1253b + ", mExceptionLogReportUrls=" + this.c + ", mTraceReportUrls=" + this.d + ", mMemoryReachTopListener=" + this.e + ", mWithExceptionTrafficDetect=" + this.f + ", mEnableTrafficDetect=" + this.g + ", mWithWebViewTrafficDetect=" + this.h + ", mWithBlockDetect=" + this.i + ", mEnableBlockOnlySampled=" + this.j + ", mWithSeriousBlockDetect=" + this.k + ", mBlockThresholdMs=" + this.m + ", mWithTemperatureDetect=" + this.n + ", mWithBatteryDetect=" + this.o + ", mEnableBatteryLocalRecord=" + this.p + ", mEnableTemperatureLocalRecord=" + this.q + ", mForceUpdateSlardarSetting=" + this.r + ", mEnableMultiProcessRequestSetting=" + this.s + ", mNetMonitorWithDisconnected=" + this.t + ", mHeader=" + this.u + ", mDynamicParams=" + this.v + ", mQueryParams=" + this.w + ", mHttpService=" + this.x + ", mWidgets=" + this.y + ", mDelayNetRequestSeconds=" + this.z + ", mApmStartListener=" + this.A + ", mApmLogListener=" + this.B + ", mStorageCheckListener=" + this.C + ", mExecutor=" + this.D + ", mEncryptor=" + this.E + ", mAlogFilesDir='" + this.F + "', mCallback=" + this.G + ", mNtpTimeService=" + this.H + '}';
    }
}
