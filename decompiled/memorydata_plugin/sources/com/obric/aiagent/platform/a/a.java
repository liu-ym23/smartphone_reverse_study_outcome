package com.obric.aiagent.platform.a;

import android.app.Application;
import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\bg\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0007H&J\b\u0010\u0011\u001a\u00020\nH&J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016¨\u0006\u001c"}, d2 = {"Lcom/obric/aiagent/platform/depend/IAppContext;", "", "getApplication", "Landroid/app/Application;", "getContext", "Landroid/content/Context;", "getAppId", "", "getOldAiagentAppId", "getMsSdkLicense", "", "getAppName", "getAppStringName", "getPackageName", "isDebug", "", "getVersionCode", "getVersionName", "getManifestVersionCode", "getManifestVersionName", "getUpdateVersionCode", "getCurrentTimeMillis", "", "getBuildChannel", "isTestChannel", "isDebugChannel", "isReleaseChannel", "Companion", "platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0241a f5948a = null;

    /* JADX INFO: renamed from: com.obric.aiagent.platform.a.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u000bH\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\b\u0010\u001a\u001a\u00020\u000bH\u0016J\b\u0010\u001b\u001a\u00020\u000eH\u0016J\b\u0010\u001c\u001a\u00020\u000bH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u000eH\u0016J\b\u0010 \u001a\u00020\u0017H\u0016J\b\u0010!\u001a\u00020\u0017H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006#"}, d2 = {"Lcom/obric/aiagent/platform/depend/IAppContext$Companion;", "Lcom/obric/aiagent/platform/depend/IAppContext;", "<init>", "()V", "cachedImpl", "impl", "getImpl", "()Lcom/obric/aiagent/platform/depend/IAppContext;", "impl$delegate", "Lkotlin/Lazy;", "getAppId", "", "getOldAiagentAppId", "getMsSdkLicense", "", "getApplication", "Landroid/app/Application;", "getContext", "Landroid/content/Context;", "getAppName", "getAppStringName", "getPackageName", "isDebug", "", "getVersionCode", "getVersionName", "getManifestVersionCode", "getManifestVersionName", "getUpdateVersionCode", "getCurrentTimeMillis", "", "getBuildChannel", "isTestChannel", "isDebugChannel", "isReleaseChannel", "platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0241a implements a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ C0241a f5949b = null;
        private static final Lazy<a> c = null;

        static {
            f5949b = new C0241a();
            c = LazyKt.lazy($$Lambda$a$a$GeF46PzfNjK8n2KhQuWRMUvo.INSTANCE);
        }

        private C0241a() {
        }

        private final a g() {
            return (a) ZeusTransformUtils.preCheckCast(c.getValue(), a.class, "com.obric.memorydata.plugin");
        }

        private static final a h() {
            com.obric.aiagent.platform.b r0 = com.obric.aiagent.platform.a.f5946a.a();
            if (r0 == null) goto L7;
            a r1 = r0.a();
            if (r1 == null) goto L7;
            return r1;
        L7:
            return (a) ZeusTransformUtils.preCheckCast(com.ss.android.ugc.aweme.framework.services.f.a().a(a.class), a.class, "com.obric.memorydata.plugin");
        }

        /* JADX INFO: renamed from: lambda$GeF46-PzfNjK8n-2KhQuWRMUv-o, reason: not valid java name */
        public static /* synthetic */ a m150lambda$GeF46PzfNjK8n2KhQuWRMUvo() {
            return h();
        }

        @Override // com.obric.aiagent.platform.a.a
        public Application a() {
            a r2 = g();
            if (r2 == null) goto L8;
            Application r3 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
            if (r3 == null) goto L8;
            return r3;
        L8:
            throw new RuntimeException("IAppContext not initialized");
        }

        @Override // com.obric.aiagent.platform.a.a
        public String b() {
            a r0 = g();
            if (r0 == null) goto L7;
            String r1 = r0.b();
            if (r1 == null) goto L7;
            return r1;
        L7:
            return b.a(this);
        }

        @Override // com.obric.aiagent.platform.a.a
        public int c() {
            a r0 = g();
            if (r0 == null) goto L6;
            return r0.c();
        L6:
            return ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getPackageManager().getPackageInfo(b(), 0).versionCode;
        }

        @Override // com.obric.aiagent.platform.a.a
        public String d() {
            a r0 = g();
            if (r0 == null) goto L6;
            String r1 = r0.d();
            if (r1 == null) goto L6;
            return r1;
        L6:
            String r2 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getPackageManager().getPackageInfo(b(), 0).versionName;
            if (r2 != null) goto L11;
            return "";
        L11:
            return r2;
        }

        @Override // com.obric.aiagent.platform.a.a
        public boolean e() {
            a r0 = g();
            if (r0 == null) goto L6;
            return r0.e();
        L6:
            return b.b(this);
        }

        @Override // com.obric.aiagent.platform.a.a
        public boolean f() {
            a r0 = g();
            if (r0 == null) goto L6;
            return r0.f();
        L6:
            return b.c(this);
        }

        @Override // com.obric.aiagent.platform.a.a
        public Context getContext() {
            a r0 = g();
            if (r0 == null) goto L7;
            Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L7;
            return r1;
        L7:
            return (Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b {
        public static String a(a r2) {
            String r3 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin")).a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getPackageName();
            Intrinsics.checkNotNullExpressionValue(r3, "getPackageName(...)");
            return r3;
        }

        public static boolean b(a r2) {
            a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            return false;
        }

        public static boolean c(a r2) {
            a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            return false;
        }

        public static Context getContext(a r2) {
            return (Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin")).a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f5948a = C0241a.f5949b;
    }

    Application a();

    String b();

    int c();

    String d();

    boolean e();

    boolean f();

    Context getContext();
}
