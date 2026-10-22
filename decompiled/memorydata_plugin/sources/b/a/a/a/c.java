package b.a.a.a;

import android.app.Application;
import com.obric.eventkit.apphost.AppHost;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0014\u0010\u0018\u001a\u00020\u0019X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u0019X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u0019X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u0019X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\fR\u0014\u0010 \u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0010R\u0014\u0010\"\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\fR\u0014\u0010$\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\fR\u0014\u0010&\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0010¨\u0006("}, d2 = {"Lcom/obric/eventkit/apphost/AppHostImpl;", "Lcom/obric/eventkit/apphost/AppHost;", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "appClock", "Lcom/obric/eventkit/apphost/AppClock;", "getAppClock", "()Lcom/obric/eventkit/apphost/AppClock;", "appId", "", "getAppId", "()I", "appName", "", "getAppName", "()Ljava/lang/String;", "appStringName", "getAppStringName", "application", "getApplication", "()Landroid/app/Application;", "buildChannel", "getBuildChannel", "isDebug", "", "()Z", "isDebugChannel", "isOversea", "isTestChannel", "manifestVersionCode", "getManifestVersionCode", "manifestVersionName", "getManifestVersionName", "updateVersionCode", "getUpdateVersionCode", "versionCode", "getVersionCode", "versionName", "getVersionName", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class c implements AppHost {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f89a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f90b;
    public final int c;
    public final a d;
    public final int e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final int j;
    public final int k;

    public c(Application r3) {
        Application r4 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "app");
        this.f89a = r4;
        this.f90b = "160";
        this.c = 160;
        this.d = new b();
        this.e = 498349;
        this.f = "obric_assistant";
        this.g = "OGrace";
        this.h = "sdk";
        this.i = "0.0.1";
        this.j = 1;
        this.k = 1;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public a getAppClock() {
        return this.d;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public int getAppId() {
        return this.e;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public String getAppName() {
        return this.f;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public String getAppStringName() {
        return this.g;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public Application getApplication() {
        return this.f89a;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public String getBuildChannel() {
        return this.h;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public int getManifestVersionCode() {
        return this.c;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public String getManifestVersionName() {
        return this.f90b;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public int getUpdateVersionCode() {
        return this.k;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public int getVersionCode() {
        return this.j;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public String getVersionName() {
        return this.i;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public boolean isDebug() {
        return false;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public boolean isDebugChannel() {
        return false;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public boolean isOversea() {
        return false;
    }

    @Override // com.obric.eventkit.apphost.AppHost
    public boolean isTestChannel() {
        return false;
    }
}
