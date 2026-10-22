package com.obric.mcpclient.complextasksdk.a;

import android.app.Application;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\bf\u0018\u0000 *2\u00020\u0001:\u0001*R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0011R\u0012\u0010\u001a\u001a\u00020\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001cR\u0012\u0010\u001d\u001a\u00020\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001cR\u0012\u0010\u001e\u001a\u00020\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0012\u0010\u001f\u001a\u00020\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001cR\u0012\u0010 \u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\rR\u0012\u0010\"\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0011R\u0012\u0010$\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\rR\u0012\u0010&\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\rR\u0012\u0010(\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0011¨\u0006+"}, d2 = {"Lcom/obric/mcpclient/complextasksdk/apphost/AppHost;", "", "activityStackManager", "Lcom/obric/mcpclient/complextasksdk/apphost/ActivityStackManager;", "getActivityStackManager", "()Lcom/obric/mcpclient/complextasksdk/apphost/ActivityStackManager;", "appClock", "Lcom/obric/mcpclient/complextasksdk/apphost/AppClock;", "getAppClock", "()Lcom/obric/mcpclient/complextasksdk/apphost/AppClock;", "appId", "", "getAppId", "()I", "appName", "", "getAppName", "()Ljava/lang/String;", "appStringName", "getAppStringName", "application", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "buildChannel", "getBuildChannel", "isDebug", "", "()Z", "isDebugChannel", "isOversea", "isTestChannel", "manifestVersionCode", "getManifestVersionCode", "manifestVersionName", "getManifestVersionName", "updateVersionCode", "getUpdateVersionCode", "versionCode", "getVersionCode", "versionName", "getVersionName", "Companion", "complextasksdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0409a f8278a = null;

    /* JADX INFO: renamed from: com.obric.mcpclient.complextasksdk.a.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0001R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0013R\u0014\u0010\u001c\u001a\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010!R\u0014\u0010\"\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010!R\u0014\u0010#\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010!R\u0014\u0010$\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010!R\u0014\u0010%\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u000fR\u0014\u0010'\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0013R\u0014\u0010)\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u000fR\u0014\u0010+\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u000fR\u0014\u0010-\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0013¨\u00062"}, d2 = {"Lcom/obric/mcpclient/complextasksdk/apphost/AppHost$Companion;", "Lcom/obric/mcpclient/complextasksdk/apphost/AppHost;", "()V", "_inst", "activityStackManager", "Lcom/obric/mcpclient/complextasksdk/apphost/ActivityStackManager;", "getActivityStackManager", "()Lcom/obric/mcpclient/complextasksdk/apphost/ActivityStackManager;", "appClock", "Lcom/obric/mcpclient/complextasksdk/apphost/AppClock;", "getAppClock", "()Lcom/obric/mcpclient/complextasksdk/apphost/AppClock;", "appId", "", "getAppId", "()I", "appName", "", "getAppName", "()Ljava/lang/String;", "appStringName", "getAppStringName", "application", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "buildChannel", "getBuildChannel", "inst", "getInst", "()Lcom/obric/mcpclient/complextasksdk/apphost/AppHost;", "isDebug", "", "()Z", "isDebugChannel", "isOversea", "isTestChannel", "manifestVersionCode", "getManifestVersionCode", "manifestVersionName", "getManifestVersionName", "updateVersionCode", "getUpdateVersionCode", "versionCode", "getVersionCode", "versionName", "getVersionName", "setAppHost", "", "impl", "complextasksdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C0409a implements a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ C0409a f8279b = null;
        private static a c;

        static {
            f8279b = new C0409a();
        }

        private C0409a() {
        }

        private final a b() {
            a r1 = c;
            if (r1 == null) goto L6;
            return r1;
        L6:
            throw new IllegalStateException("app module must call Apphost.setApphost()");
        }

        @Override // com.obric.mcpclient.complextasksdk.a.a
        public Application a() {
            return (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b().a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f8278a = C0409a.f8279b;
    }

    Application a();
}
