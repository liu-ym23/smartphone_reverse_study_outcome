package com.obric.capability.schedulekit.a;

import android.app.Application;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0014\u0010\u0018\u001a\u00020\u0019X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u0019X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u0019X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u0019X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\fR\u0014\u0010 \u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0010R\u0014\u0010\"\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\fR\u0014\u0010$\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\fR\u0014\u0010&\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0010¨\u0006("}, d2 = {"Lcom/obric/capability/schedulekit/apphost/AppHostImpl;", "Lcom/obric/capability/schedulekit/apphost/AppHost;", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "appClock", "Lcom/obric/capability/schedulekit/apphost/AppClock;", "getAppClock", "()Lcom/obric/capability/schedulekit/apphost/AppClock;", "appId", "", "getAppId", "()I", "appName", "", "getAppName", "()Ljava/lang/String;", "appStringName", "getAppStringName", "application", "getApplication", "()Landroid/app/Application;", "buildChannel", "getBuildChannel", "isDebug", "", "()Z", "isDebugChannel", "isOversea", "isTestChannel", "manifestVersionCode", "getManifestVersionCode", "manifestVersionName", "getManifestVersionName", "updateVersionCode", "getUpdateVersionCode", "versionCode", "getVersionCode", "versionName", "getVersionName", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class d implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Application f7380b;
    private final String c;
    private final int d;
    private final a e;
    private final int f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final int k;
    private final int l;

    public d(Application r3) {
        Application r4 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "app");
        this.f7380b = r4;
        this.c = "160";
        this.d = 160;
        this.e = (a) ZeusTransformUtils.preCheckCast(new b(), a.class, "com.obric.memorydata.plugin");
        this.f = 498349;
        this.g = "obric_assistant";
        this.h = "OGrace";
        this.i = "sdk";
        this.j = "0.0.1";
        this.k = 1;
        this.l = 1;
    }

    @Override // com.obric.capability.schedulekit.a.c
    public Application a() {
        return this.f7380b;
    }
}
