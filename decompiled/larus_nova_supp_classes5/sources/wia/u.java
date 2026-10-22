package wia;

import android.app.Application;
import com.obric.capabilitykit.apphost.AppHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class u implements AppHost {
    public final Application a;
    public final String b;
    public final int c;
    public final t d;
    public final int e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final int j;
    public final int k;

    public u(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "app");
        this.a = r2;
        this.b = "160";
        this.c = 160;
        this.d = new t();
        this.e = 498349;
        this.f = "obric_assistant";
        this.g = "OGrace";
        this.h = "sdk";
        this.i = "0.0.1";
        this.j = 1;
        this.k = 1;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public final s getAppClock() {
        return this.d;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public final int getAppId() {
        return this.e;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public final String getAppName() {
        return this.f;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public final String getAppStringName() {
        return this.g;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public final Application getApplication() {
        return this.a;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public final String getBuildChannel() {
        return this.h;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public final int getManifestVersionCode() {
        return this.c;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public final String getManifestVersionName() {
        return this.b;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public final int getUpdateVersionCode() {
        return this.k;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public final int getVersionCode() {
        return this.j;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public final String getVersionName() {
        return this.i;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public final boolean isDebug() {
        return false;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public final boolean isDebugChannel() {
        return false;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public final boolean isOversea() {
        return false;
    }

    @Override // com.obric.capabilitykit.apphost.AppHost
    public final boolean isTestChannel() {
        return false;
    }
}
