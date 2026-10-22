package com.bytedance.ai.applet.app.foundation;

import android.content.Context;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.lynx.AppletLynxViewApi;
import com.bytedance.ai.model.objects.Page;
import com.bytedance.ai.resource.AIManager;
import com.bytedance.ai.resource.AppletResourceTool;
import com.lynx.tasm.TemplateBundle;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AppletAppResourceLoader implements w {
    public static final /* synthetic */ int f = 0;
    public final AppletApplication a;
    public final com.bytedance.ai.applet.base.log.d b;
    public final ConcurrentHashMap<String, TemplateBundle> c;
    public final ConcurrentHashMap<String, kotlinx.coroutines.sync.a> d;
    public volatile boolean e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void onDestroy() {
        this.e = true;
        this.b.c("onDestroy: clear " + this.c.size() + " cached template bundles");
        this.c.clear();
        this.d.clear();
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void d() {
        com.bytedance.ai.settings.a<Integer> r0 = com.bytedance.ai.settings.b.a;
        List<String> r1 = com.bytedance.ai.settings.b.j.a().b();
        if (r1 != null) goto L6;
        r1 = CollectionsKt.emptyList();
    L6:
        if (r1.contains(this.a.getAppId()) == true) goto L8;
        return;
    L8:
        this.b.c("onAttached: appId = " + this.a.getAppId() + " matched preload list");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.a), null, null, new AppletAppResourceLoader$onAttached$1(this, null), 3, null);
    }

    public AppletAppResourceLoader(AppletApplication r10) {
        Intrinsics.checkNotNullParameter(r10, "app");
        this.a = r10;
        this.b = new com.bytedance.ai.applet.base.log.d("AppletAppResourceLoader", r10.getAppId());
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void a(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void g(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void h(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
    }

    public static final Object b(AppletAppResourceLoader r10, Continuation r11) {
        r10.getClass();
        if ((r11 instanceof AppletAppResourceLoader$preloadHomePageTemplateBundle$1) == false) goto L7;
        AppletAppResourceLoader$preloadHomePageTemplateBundle$1 r0 = (AppletAppResourceLoader$preloadHomePageTemplateBundle$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        Page r15 = (Page) r0.L$0;
        ResultKt.throwOnFailure(r12);
        Object r16 = ((Result) r12).unbox-impl();
    L25:
        if (Result.isSuccess-impl(r16) == false) goto L27;
        TemplateBundle r17 = (TemplateBundle) r16;
        r10.b.c("preloadHomePageTemplateBundle: success, page = " + r15.pageId());
    L27:
        Throwable r18 = Result.exceptionOrNull-impl(r16);
        if (r18 == null) goto L34;
        com.bytedance.ai.applet.base.log.d r19 = r10.b;
        StringBuilder r20 = new StringBuilder("preloadHomePageTemplateBundle: failed, page = ");
        r20.append(r15.pageId());
        r20.append(", reason = ");
        String r21 = r18.getMessage();
        if (r21 != null) goto L32;
        r21 = "unknown";
    L32:
        r20.append(r21);
        com.bytedance.ai.applet.base.log.d.d(r19, r20.toString());
    L34:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        String r22 = r10.a.j().O;
        if (StringsKt.isBlank(r22) == false) goto L17;
        r22 = "index";
    L17:
        Page r23 = r10.a.j().q(r22);
        if (r23 != null) goto L20;
        AtomicInteger r24 = com.bytedance.ai.applet.base.log.d.d;
        r10.b.a("preloadHomePageTemplateBundle: home page is null, path = " + r22, null);
        return Unit.INSTANCE;
    L20:
        r10.b.c("preloadHomePageTemplateBundle: start, page = " + r23.pageId());
        r0.L$0 = r23;
        r0.label = 1;
        r16 = r10.e(r23, r0);
        if (r16 == r13) goto L36;
        r15 = r23;
        goto L25
    L36:
        return r13;
    L7:
        r0 = new AppletAppResourceLoader$preloadHomePageTemplateBundle$1(r10, r11);
        goto L8
    }

    public final Object e(Page r12, Continuation<? super Result<TemplateBundle>> r13) {
        if ((r13 instanceof AppletAppResourceLoader$loadPageTemplateBundle$1) == false) goto L7;
        AppletAppResourceLoader$loadPageTemplateBundle$1 r0 = (AppletAppResourceLoader$loadPageTemplateBundle$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = r0.label;
        boolean r15 = false;
        if (r11 == 0) goto L16;
        if (r11 == 1) goto L15;
        if (r11 != 2) goto L14;
        String r16 = (String) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L59:
        TemplateBundle r17 = (TemplateBundle) r14;
        if (r17 != null) goto L64;
        String r18 = "templateBundle is null, url = " + r16;
        AtomicInteger r19 = com.bytedance.ai.applet.base.log.d.d;
        this.b.a("loadPageTemplateBundle: " + r18, null);
        Result.Companion r110 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException(r18)));
    L64:
        return Result.constructor-impl(r17);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r111 = (String) r0.L$1;
        Page r20 = (Page) r0.L$0;
        ResultKt.throwOnFailure(r14);
        String r112 = r111;
        r12 = r20;
        Object r21 = r14;
    L38:
        AIManager.a r22 = (AIManager.a) r21;
        if ((r22 instanceof AIManager.a.b) == false) goto L41;
        String r23 = AppletResourceTool.l(AppletResourceTool.a, this.a.j(), r12.getEntry());
        if (r23.length() != 0) goto L52;
        r15 = true;
    L52:
        if (r15 == false) goto L55;
        String r113 = "resUrl is null, page = " + r12.pageId();
        AtomicInteger r24 = com.bytedance.ai.applet.base.log.d.d;
        this.b.a("loadPageTemplateBundle: " + r113, null);
        Result.Companion r114 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException(r113)));
    L55:
        r0.L$0 = r23;
        r0.L$1 = null;
        r0.label = 2;
        r14 = c(r12, r112, r23, r0);
        if (r14 != r10) goto L58;
        return r10;
    L58:
        r16 = r23;
        goto L59
    L41:
        if ((r22 instanceof AIManager.a.C0046a) == false) goto L48;
        StringBuilder r115 = new StringBuilder("ensureAppletFullReady failed, errorCode = ");
        AIManager.a.C0046a r25 = (AIManager.a.C0046a) r22;
        r115.append(r25.a);
        r115.append(", errorMsg = ");
        String r116 = r25.b;
        if (r116 != null) goto L45;
        r116 = "Applet page resources are not ready";
    L45:
        r115.append(r116);
        String r117 = r115.toString();
        AtomicInteger r26 = com.bytedance.ai.applet.base.log.d.d;
        this.b.a("loadPageTemplateBundle: " + r117, null);
        Result.Companion r118 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException(r117)));
    L48:
        throw new NoWhenBranchMatchedException();
    L16:
        ResultKt.throwOnFailure(r14);
        r112 = r12.getPath();
        if (r112 != null) goto L19;
    L26:
        r112 = r12.pageId();
    L28:
        if (this.e == false) goto L31;
        String r119 = "page resource loader is destroyed, page = " + r12.pageId();
        com.bytedance.ai.applet.base.log.d.d(this.b, "loadPageTemplateBundle: " + r119);
        Result.Companion r120 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException(r119)));
    L31:
        TemplateBundle r27 = this.c.get(r112);
        if (r27 == null) goto L35;
        this.b.c("loadPageTemplateBundle: hit memory cache, page = " + r12.pageId());
        return Result.constructor-impl(r27);
    L35:
        AIManager r28 = AIManager.a;
        String r29 = this.a.j().K;
        long r30 = this.a.j().c;
        r0.L$0 = r12;
        r0.L$1 = r112;
        r0.label = 1;
        r21 = AIManager.h(r29, r30, r0);
        if (r21 != r10) goto L38;
        return r10;
    L19:
        if (r112.length() <= 0) goto L21;
        boolean r31 = true;
    L22:
        if (r31 == true) goto L25;
        r112 = null;
    L25:
        if (r112 != null) goto L28;
    L21:
        r31 = false;
    L7:
        r0 = new AppletAppResourceLoader$loadPageTemplateBundle$1(this, r13);
        goto L8
    }

    public final Object c(Page r11, String r12, String r13, Continuation<? super TemplateBundle> r14) {
        if ((r14 instanceof AppletAppResourceLoader$loadAndCachePageTemplateBundle$1) == false) goto L7;
        AppletAppResourceLoader$loadAndCachePageTemplateBundle$1 r10 = (AppletAppResourceLoader$loadAndCachePageTemplateBundle$1) r14;
        int r15 = r10.label;
        if ((r15 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r15 - Integer.MIN_VALUE;
    L8:
        AppletAppResourceLoader$loadAndCachePageTemplateBundle$1 r16 = r10;
        Object r17 = r16.result;
        Object r18 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r19 = r16.label;
        boolean r20 = true;
        if (r19 == 0) goto L18;
        if (r19 == 1) goto L17;
        if (r19 != 2) goto L16;
        kotlinx.coroutines.sync.a r110 = (kotlinx.coroutines.sync.a) r16.L$1;
        r12 = (String) r16.L$0;
        ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L56
    L46:
        TemplateBundle r111 = (TemplateBundle) r17;     // Catch: Throwable -> L56
        if (r111 != null) goto L49;
    L54:
        r110.unlock(null);
        return r111;
    L49:
        if (this.e == true) goto L54;
        TemplateBundle r112 = this.c.putIfAbsent(r12, r111);     // Catch: Throwable -> L56
        if (r112 == null) goto L54;
        r111 = r112;
        goto L54
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r110 = (kotlinx.coroutines.sync.a) r16.L$3;
        r13 = (String) r16.L$2;
        r12 = (String) r16.L$1;
        Page r21 = (Page) r16.L$0;
        ResultKt.throwOnFailure(r17);
    L31:
        if (this.e == false) goto L33;
        com.bytedance.ai.applet.base.log.d.d(this.b, "loadPageTemplateBundle: loader is destroyed, page = " + r12);     // Catch: Throwable -> L56
        r111 = null;
        goto L54
    L33:
        r111 = this.c.get(r12);     // Catch: Throwable -> L56
        if (r111 == null) goto L36;
        this.b.c("loadPageTemplateBundle: hit memory cache after waiting, page = " + r12);     // Catch: Throwable -> L56
        goto L54
    L36:
        int r113 = AppletLynxViewApi.a;     // Catch: Throwable -> L56
        String r114 = this.a.j().x;     // Catch: Throwable -> L56
        if (r114 != null) goto L40;
        r114 = "";
    L40:
        if (this.a.j().E == 1) goto L43;
        r20 = false;
    L43:
        String r22 = this.a.j().b;     // Catch: Throwable -> L56
        String r23 = r21.getId();     // Catch: Throwable -> L56
        r16.L$0 = r12;     // Catch: Throwable -> L56
        r16.L$1 = r110;     // Catch: Throwable -> L56
        r16.L$2 = null;     // Catch: Throwable -> L56
        r16.L$3 = null;     // Catch: Throwable -> L56
        r16.label = 2;     // Catch: Throwable -> L56
        r17 = AppletLynxViewApi.b(r114, r13, r20, r22, r23, r16);     // Catch: Throwable -> L56
        if (r17 != r18) goto L46;
        return r18;
    L18:
        ResultKt.throwOnFailure(r17);
        TemplateBundle r115 = this.c.get(r12);
        if (r115 == null) goto L22;
        this.b.c("loadPageTemplateBundle: hit memory cache, page = " + r12);
        return r115;
    L22:
        kotlinx.coroutines.sync.a r116 = kotlinx.coroutines.sync.b.a();
        kotlinx.coroutines.sync.a r24 = this.d.putIfAbsent(r12, r116);
        if (r24 == null) goto L26;
        r116 = r24;
    L26:
        r16.L$0 = r11;
        r16.L$1 = r12;
        r16.L$2 = r13;
        r16.L$3 = r116;
        r16.label = 1;
        if (r116.a(null, r16) != r18) goto L29;
        return r18;
    L29:
        r21 = r11;
        r110 = r116;
    L56:
        th = move-exception;
        r11.unlock(null);
        throw th;
    L7:
        r10 = new AppletAppResourceLoader$loadAndCachePageTemplateBundle$1(this, r14);
        goto L8
    }
}
