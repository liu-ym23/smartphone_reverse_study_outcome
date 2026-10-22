package com.bytedance.ai.resource;

import android.graphics.Bitmap;
import android.net.Uri;
import android.util.LruCache;
import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.ai.debug.IAISDKDebugService$DebugMode;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AppletResourceTool {
    public static final AppletResourceTool a = null;
    public static final LruCache<String, String> b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final int e = 0;
    public static volatile r5.c f;
    public static final Object g = null;
    public static final CompletableDeferred<Boolean> h = null;
    public static String i;

    public static final class a implements Function1<Throwable, Unit> {
        public final /* synthetic */ AtomicReference<kotlinx.coroutines.i<Bitmap>> a;

        public a(AtomicReference<kotlinx.coroutines.i<Bitmap>> r1) {
            this.a = r1;
        }

        public final Object invoke(Object r10) {
            Throwable r11 = (Throwable) r10;
            this.a.set(null);
            return Unit.INSTANCE;
        }
    }

    public AppletResourceTool() {
    }

    static {
        a = new AppletResourceTool();
        b = new LruCache(20);
        c = LazyKt.lazy(new l());
        d = LazyKt.lazy(new t());
        com.bytedance.ai.settings.a<Integer> r0 = com.bytedance.ai.settings.b.a;
        e = com.bytedance.ai.settings.b.f.a().intValue();
        g = new Object();
        h = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        String r1 = com.bytedance.ai.resource.core.a.a;
        i = com.bytedance.ai.resource.core.a.a;
    }

    public static Keva i() {
        return (Keva) c.getValue();
    }

    public static void a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        com.bytedance.ai.utils.g.a.d("AIManager", "closeSession: " + r10);
        IIvyAIPackageResourceService.a.h(r10);
    }

    public static void b(String r10) {
        if (f == null) goto L5;
        return;
    L5:
        Object r0 = g;
        monitor-enter(r0);
    L22:
        th = move-exception;
        throw th;
    L8:
        if (f == null) goto L11;
        monitor-exit(r0);
        return;
    L11:
        f = new r5.c(r10);     // Catch: Throwable -> L22
        r5.d r11 = r5.f.a;     // Catch: Throwable -> L22
        if (r11 != null) goto L14;
    L15:
        r5.d r12 = r5.f.a;     // Catch: Throwable -> L22
        if (r12 == null) goto L18;
        r12.evictAll();     // Catch: Throwable -> L22
    L18:
        r5.f.b.clear();     // Catch: Throwable -> L22
        r5.f.a = new r5.d();     // Catch: Throwable -> L22
    L19:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r0);
        return;
    L14:
        if (r11.maxSize() <= 5242880) goto L19;
        goto L15
    }

    public static String c(String r10) {
        if (StringsKt.startsWith$default(r10, ".", false, 2, null) == false) goto L6;
        r10 = StringsKt.substringAfter$default(r10, ".", null, 2, null);
    L6:
        if (StringsKt.startsWith$default(r10, "/", false, 2, null) == true) goto L8;
        return r10;
    L8:
        return StringsKt.substringAfter$default(r10, "/", null, 2, null);
    }

    public static String h(String r10) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        LruCache<String, String> r0 = b;
        String r1 = r0.get(r10);
        boolean r11 = true;
        if (r1 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        if (r12 == false) goto L18;
        r1 = i().getString(r10, null);
        if (r1 != null) goto L13;
    L16:
        if (r11 == true) goto L18;
        r0.put(r10, r1);
        goto L18
    L13:
        if (r1.length() == 0) goto L16;
        r11 = false;
    L18:
        return r1;
    L5:
        if (r1.length() == 0) goto L8;
        r12 = false;
        goto L9
    }

    public static String s(AppletResourceTool r1) {
        r1.getClass();
        return IIvyAIPackageResourceService.a.b(null);
    }

    public static void v(Function0 r10) {
        if (h.isCompleted() == false) goto L6;
        r10.invoke();
        Unit r11 = Unit.INSTANCE;
        return;
    L6:
        if (p2.c.b() == false) goto L8;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.a), null, null, new AppletResourceTool$runAfterEnsureInitialized$1(r10, null), 3, null);
        return;
    L8:
        BuildersKt.runBlocking$default(null, new AppletResourceTool$runAfterEnsureInitialized$2(r10, null), 1, null);
    }

    public static IIvyAIPackageResourceService.a w(p5.a r10) {
        String r1 = r10.a;
        long r11 = r10.b;
        String r12 = r10.c;
        String r13 = r10.d;
        p5.b r14 = r10.e;
        if (r14 == null) goto L5;
        IIvyAIPackageResourceService.a.a r15 = new IIvyAIPackageResourceService.a.a(r14.a);
    L7:
        return new IIvyAIPackageResourceService.a(r1, r11, r12, r13, r15);
    L5:
        r15 = null;
        goto L7
    }

    public static IIvyAIPackageResourceService.a t(Uri r10, IIvyAIPackageResourceService.a r11) {
        if (Intrinsics.areEqual(q5.a.a(r10, "local_debug"), "1") == true) goto L5;
        return r11;
    L5:
        IIvyAIPackageResourceService.a.a r0 = r11.e;
        if (r0 == null) goto L47;
        byte[] r1 = r0.a;
        if (r1 == null) goto L47;
        String r12 = q5.a.a(r10, "packageName");
        if (r12 == null) goto L46;
        String r13 = q5.a.a(r10, "packageVersion");
        if (r13 == null) goto L17;
        Long r14 = StringsKt.toLongOrNull(r13);
        if (r14 == null) goto L17;
        long r15 = r14.longValue();
    L18:
        String r16 = r10.buildUpon().clearQuery().build().getLastPathSegment();
        com.bytedance.ai.resource.security.e.a.getClass();
        Intrinsics.checkNotNullParameter(r12, "packageName");
        Intrinsics.checkNotNullParameter(r1, "rawBytes");
        if (com.bytedance.ai.resource.security.e.c(r16) == false) goto L39;
        boolean r17 = false;
        if (r1.length >= 4) goto L24;
    L26:
        if (r17 == false) goto L39;
        com.bytedance.ai.resource.security.h.a.getClass();
        Intrinsics.checkNotNullParameter(r12, "packageName");
        byte[] r18 = com.bytedance.ai.resource.security.h.h.get(r12 + '_' + r15);
        if (r18 == null) goto L30;
        byte[] r19 = Arrays.copyOf(r18, r18.length);
    L31:
        if (r19 == null) goto L38;
        com.bytedance.lynx.service.security.decrypt.a.b r20 = com.bytedance.lynx.service.security.decrypt.b.b(r1, r19, (byte[]) com.bytedance.ai.resource.security.e.b.invoke(r12));
        if ((r20 instanceof com.bytedance.lynx.service.security.decrypt.a.b) == false) goto L36;
        ByteBuffer r21 = r20.c;
        byte[] r22 = new byte[r21.remaining()];
        r21.get(r22);
    L41:
        if (Arrays.equals(r22, r1) == false) goto L44;
        return r11;
    L44:
        return new IIvyAIPackageResourceService.a(r11.a, r11.b, r11.c, r11.d, new IIvyAIPackageResourceService.a.a(r22));
    L36:
        throw new IllegalStateException("decrypt debug template errorCode: " + r20.a() + ", message: " + r20.b());
    L38:
        throw new IllegalStateException("missing debug DEK in memory: " + r12 + ' ' + r15);
    L30:
        r19 = null;
        goto L31
    L24:
        if (com.bytedance.ai.resource.security.a.a(r1) != (-1524879472)) goto L26;
        r17 = true;
    L39:
        r22 = r1;
    L17:
        r15 = 0;
        goto L18
    L46:
        throw new IllegalArgumentException("packageName is required for local debug resource decrypt");
    L47:
        return r11;
    }

    public final String g(String r14, String r15) {
        Intrinsics.checkNotNullParameter(r14, "<this>");
        Intrinsics.checkNotNullParameter(r15, "packageName");
        String r10 = c(r14);
        Uri r0 = UriProtector.parse(c(r14));
        AIManager r1 = AIManager.a;
        d0 r11 = AIManager.m(r15);
        if (r11 != null) goto L6;
        com.bytedance.ai.utils.g.a.e("AppletResourceLoader", "getCommonResourceUrl exception: package: " + r15 + " is NOT Found");
        return r14;
    L6:
        String r12 = r0.getHost();
        boolean r13 = true;
        if (r12 != null) goto L9;
    L12:
        boolean r16 = true;
    L13:
        if (r16 == false) goto L45;
        IAISDKDebugService.Companion r17 = IAISDKDebugService.a;
        String r18 = r17.G(r15);
        Applet r19 = r11.g(r15);
        if (r19 == null) goto L17;
        int r20 = r19.E;
    L18:
        if (r19 == null) goto L20;
        int r21 = r19.D;
    L21:
        long r110 = r11.i;
        if (r11.b == false) goto L31;
        if (com.bytedance.ai.utils.f.g(r18) == true) goto L26;
    L28:
        String r22 = "base_" + r11.i;
        n5.a.a.getClass();
        return d(r15, "base", r22, r10, r20, r21, r110, null);
    L26:
        if (r17.getDebugMode() != IAISDKDebugService$DebugMode.LOCAL_DEBUG) goto L28;
        return n(r18 + '/' + r10, r20, r21, r110, r15);
    L31:
        if (AIManager.g(r15) == false) goto L43;
        String r111 = h(r15);
        if (r111 != null) goto L35;
    L38:
        if (r13 == false) goto L41;
        return r10;
    L41:
        return o(r111 + '/' + r15 + '/' + r10, r11.e, false);
    L35:
        if (r111.length() == 0) goto L38;
        r13 = false;
        goto L38
    L43:
        return e(this, r15, "base", "base_" + r11.i, r10, r20, r21, r110);
    L20:
        r21 = 0;
        goto L21
    L17:
        r20 = 0;
        goto L18
    L45:
        if (r11.b == false) goto L47;
        n5.a.a.getClass();
    L47:
        return r14;
    L9:
        if (r12.length() == 0) goto L12;
        r16 = false;
        goto L13
    }

    public final String j(Applet r12, String r13) {
        String r10 = c(r13);
        IAISDKDebugService.Companion r14 = IAISDKDebugService.a;
        String r0 = r14.G(r12.b);
        int r11 = r12.E;
        int r15 = r12.D;
        if (r12.A == false) goto L13;
        if (com.bytedance.ai.utils.f.g(r0) == true) goto L7;
    L10:
        String r16 = "base_" + r12.c;
        n5.a.a.getClass();
        return d(r12.b, r12.K, r16, r10, r11, r15, r12.c, null);
    L7:
        if (r14.getDebugMode() != IAISDKDebugService$DebugMode.LOCAL_DEBUG) goto L10;
        return n(r0 + '/' + r10, r11, r15, r12.c, r12.b);
    L13:
        return e(this, r12.b, r12.K, "base_" + r12.c, r10, r11, r15, r12.c);
    }

    public static String k(String r10, String r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r11, "baseUrl");
        if (StringsKt.endsWith$default(r11, "/", false, 2, null) == false) goto L6;
        r11 = r11.substring(0, r11.length() - 1);
    L6:
        return o(r11 + '/' + r10 + "/base/manifest.json", null, r12);
    }

    public static String l(AppletResourceTool r1, Applet r10, String r11) {
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "filePath");
        return r1.f(r10, r11, true);
    }

    public static String m(AppletResourceTool r12, Widget r13, String r14) {
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "<this>");
        Intrinsics.checkNotNullParameter(r14, "filePath");
        String r10 = c(r14);
        IAISDKDebugService.Companion r15 = IAISDKDebugService.a;
        String r0 = r15.G(r13.b);
        int r11 = r13.E;
        int r16 = r13.D;
        long r17 = r13.c;
        boolean r18 = false;
        boolean r19 = true;
        if (r13.A == true) goto L5;
        AIManager r110 = AIManager.a;
        if (AIManager.g(r13.b) == false) goto L29;
        String r111 = h(r13.b);
        if (r111 != null) goto L21;
    L24:
        if (r19 == true) goto L32;
        r10 = o(r111 + '/' + r13.b + '/' + r10, r13.x, false);
    L32:
        return r10;
    L21:
        if (r111.length() == 0) goto L24;
        r19 = false;
        goto L24
    L29:
        return e(r12, r13.b, r13.K, r13.K + '_' + r13.n, r10, r11, r16, r17);
    L5:
        if (com.bytedance.ai.utils.f.g(r0) == true) goto L7;
    L15:
        String r20 = r13.K + '_' + r13.n;
        n5.a.a.getClass();
        return d(r13.b, r13.K, r20, r10, r11, r16, r17, null);
    L7:
        if (r15.getDebugMode() != IAISDKDebugService$DebugMode.LOCAL_DEBUG) goto L15;
        if (h5.e.a(r13.h, "3.0") < 0) goto L11;
        r18 = true;
    L11:
        if (r18 == true) goto L30;
        r10 = "widgets/" + r10;
    L30:
        return n(r0 + '/' + r10, r11, r16, r17, r13.b);
    }

    public static String o(String r10, String r11, boolean r12) {
        Uri.Builder r13 = UriProtector.parse(r10).buildUpon();
        r13.appendQueryParameter("loader_name", "forest");
        r13.appendQueryParameter("dynamic", "1");
        r13.appendQueryParameter("enable_memory_cache", "0");
        if (r11 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        r13.appendQueryParameter("forest_session_id", r11);
    L11:
        if (r12 == false) goto L14;
        r13.appendQueryParameter("dynamic", "2");
    L14:
        return r13.build().toString();
    L5:
        if (r11.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public static Object r(String r10, String r11, Continuation r12) {
        kotlinx.coroutines.j r0 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r12), 1);
        r0.C();
        AtomicReference r1 = new AtomicReference(r0);
        r0.i(new a(r1));
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(r0.getContext()), com.bytedance.ai.infra.thread_pool.b.a, null, new AppletResourceTool$loadImage$2$2(r10, r11, r1, null), 2, null);
        Object r13 = r0.B();
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r12);
    L5:
        return r13;
    }

    public final String f(Applet r15, String r16, boolean r17) {
        String r10 = c(r16);
        IAISDKDebugService.Companion r1 = IAISDKDebugService.a;
        String r11 = r1.G(r15.b);
        int r12 = r15.E;
        int r13 = r15.D;
        boolean r14 = true;
        if (r15.A == true) goto L5;
        AIManager r18 = AIManager.a;
        if (AIManager.g(r15.b) == false) goto L38;
        String r19 = h(r15.b);
        if (r19 != null) goto L27;
    L30:
        if (r14 == false) goto L33;
        return r10;
    L33:
        if (StringsKt.endsWith$default(r19, "/", false, 2, null) == false) goto L35;
        String r20 = r19 + r15.b + '/' + r10;
    L37:
        return o(r20, r15.x, false);
    L35:
        r20 = r19 + '/' + r15.b + '/' + r10;
        goto L37
    L27:
        if (r19.length() == 0) goto L30;
        r14 = false;
        goto L30
    L38:
        if (r17 == false) goto L40;
        String r21 = r15.K + '_' + r15.n;
    L42:
        return e(this, r15.b, r15.K, r21, r10, r12, r13, r15.c);
    L40:
        r21 = r15.K;
        goto L42
    L5:
        if (com.bytedance.ai.utils.f.g(r11) == true) goto L7;
    L17:
        if (r17 == false) goto L19;
        String r22 = r15.K + '_' + r15.n;
    L20:
        String r23 = r22;
        n5.a.a.getClass();
        return d(r15.b, r15.K, r23, r10, r12, r13, r15.c, null);
    L19:
        r22 = r15.K;
        goto L20
    L7:
        if (r1.getDebugMode() != IAISDKDebugService$DebugMode.LOCAL_DEBUG) goto L17;
        if (h5.e.a(r15.h, "3.0") >= 0) goto L12;
        r14 = false;
    L12:
        if (r14 == true) goto L16;
        r10 = StringsKt.replaceFirst$default(r10, r15.K, "applet", false, 4, null);
    L16:
        return n(r11 + '/' + r10, r12, r13, r15.c, r15.b);
    }

    public static void u(Uri r10, IIvyAIPackageResourceService.a r11, Function1 r12, Function1 r13) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r14 = Result.constructor-impl(t(r10, r11));     // Catch: Throwable -> L4
    L7:
        if (Result.isSuccess-impl(r14) == false) goto L9;
        r12.invoke((IIvyAIPackageResourceService.a) r14);
    L9:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L15;
        com.bytedance.ai.utils.g.a.e("AppletResourceLoader", "process debug resource failed. url:" + r10 + ", error:" + r15.getMessage());
        r13.invoke(r15);
        return;
    L15:
        return;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static String n(String r10, int r11, int r12, long r13, String r14) {
        return UriProtector.parse(r10).buildUpon().appendQueryParameter("loader_name", "forest").appendQueryParameter("disable_gecko", "1").appendQueryParameter("disable_builtin", "1").appendQueryParameter("disable_gecko_update", "1").appendQueryParameter("disable_offline", "1").appendQueryParameter("disable_cdn_cache", "1").appendQueryParameter("enable_memory_cache", "0").appendQueryParameter("local_debug", "1").appendQueryParameter("verifySignature", String.valueOf(r11)).appendQueryParameter("hasKeyStore", String.valueOf(r12)).appendQueryParameter("packageVersion", String.valueOf(r13)).appendQueryParameter("packageName", r14).build().toString();
    }

    public static void p(final String r10, final String r11, final boolean r12, final Function1 r13, final Function1 r14) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r11, "fileName");
        Intrinsics.checkNotNullParameter(r13, "resolve");
        Intrinsics.checkNotNullParameter(r14, "reject");
        v(new y(r10, r11, r12, r14, r13));
    }

    public static void q(final String r10, final String r11, final Function1 r12, final Function1 r13, final boolean r14) {
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r12, "resolve");
        Intrinsics.checkNotNullParameter(r13, "reject");
        v(new v(r10, r11, r14, r12, r13));
    }

    public static String d(String r10, String r11, String r12, String r13, int r14, int r15, long r16, String r17) {
        Uri.Builder r18 = UriProtector.parse("https://app.aisdk.local/" + r10 + '/' + r12 + '/' + r13).buildUpon().appendQueryParameter("packageName", r10);
        h2.a r19 = f2.b.c;
        if (r19 == null) goto L6;
        String r20 = r19.m;
        if (r20 == null) goto L6;
    L7:
        Uri.Builder r21 = r18.appendQueryParameter("bid", r20).appendQueryParameter("storeDir", r11).appendQueryParameter("intercept_request", "1").appendQueryParameter("verifySignature", String.valueOf(r14)).appendQueryParameter("hasKeyStore", String.valueOf(r15)).appendQueryParameter("packageVersion", String.valueOf(r16));
        if (r17 == null) goto L11;
        r21.appendQueryParameter("debugInfo", r17);
    L11:
        return r21.build().toString();
    L6:
        r20 = "";
        goto L7
    }

    public static /* synthetic */ String e(AppletResourceTool r10, String r11, String r12, String r13, String r14, int r15, int r16, long r17) {
        r10.getClass();
        return d(r11, r12, r13, r14, r15, r16, r17, null);
    }
}
