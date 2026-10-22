package com.ss.android.lark.chameleonv2.container.webcontainer.plugin;

import android.webkit.WebView;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chameleon.pluginapi.IChameleonLoader;
import com.ss.android.lark.chameleonv2.container.webcontainer.util.RenderGoneHelper;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Deprecated;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class UIThreadCallbackAdapter implements IChameleonLoader.LoadingCallback, IChameleonLoader.IChameleonTitleBarCallback, k.a {
    public final CopyOnWriteArrayList<IChameleonLoader.LoadingCallback> a;
    public final CopyOnWriteArrayList<IChameleonLoader.IChameleonTitleBarCallback> b;
    public final CopyOnWriteArrayList<k.a> c;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ UIThreadCallbackAdapter a;

        public b(UIThreadCallbackAdapter r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.UIThreadCallbackAdapter.TAG, "onLeftBackAndCloseChange execute");     // Catch: Throwable -> L11
            Iterator<IChameleonLoader.IChameleonTitleBarCallback> r0 = this.a.b.iterator();     // Catch: Throwable -> L8
        L5:
            if (r0.hasNext() == false) goto L22;
            r0.next().onLeftBackAndCloseChange();     // Catch: Throwable -> L8
        L22:
            return;
        L8:
            th = move-exception;
            j.d(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.UIThreadCallbackAdapter.TAG, th);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L15;
            return;
        L15:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ Throwable b;
        public final /* synthetic */ UIThreadCallbackAdapter c;

        public c(int r1, Throwable r2, UIThreadCallbackAdapter r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.UIThreadCallbackAdapter.TAG, "onLoadFail execute code=" + this.a + ", e=" + this.b);
            Iterator<IChameleonLoader.LoadingCallback> r0 = this.c.a.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().onLoadFail(this.a, this.b);
            goto L4
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ UIThreadCallbackAdapter a;

        public d(UIThreadCallbackAdapter r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.UIThreadCallbackAdapter.TAG, "onLoadFailByJS execute");     // Catch: Throwable -> L7
            Iterator<IChameleonLoader.LoadingCallback> r0 = this.a.a.iterator();     // Catch: Throwable -> L7
        L4:
            if (r0.hasNext() == false) goto L16;
            r0.next().onLoadSuccessByJS();     // Catch: Throwable -> L7
            goto L4
        L16:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ UIThreadCallbackAdapter a;

        public e(UIThreadCallbackAdapter r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.UIThreadCallbackAdapter.TAG, "onLoadStart execute");     // Catch: Throwable -> L7
            Iterator<IChameleonLoader.LoadingCallback> r0 = this.a.a.iterator();     // Catch: Throwable -> L7
        L4:
            if (r0.hasNext() == false) goto L16;
            r0.next().onLoadStart();     // Catch: Throwable -> L7
            goto L4
        L16:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ UIThreadCallbackAdapter a;

        public f(UIThreadCallbackAdapter r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.UIThreadCallbackAdapter.TAG, "onLoadSuccess execute");     // Catch: Throwable -> L7
            Iterator<IChameleonLoader.LoadingCallback> r0 = this.a.a.iterator();     // Catch: Throwable -> L7
        L4:
            if (r0.hasNext() == false) goto L16;
            r0.next().onLoadSuccess();     // Catch: Throwable -> L7
            goto L4
        L16:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ UIThreadCallbackAdapter a;

        public g(UIThreadCallbackAdapter r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.UIThreadCallbackAdapter.TAG, "onLoadSuccess execute");     // Catch: Throwable -> L7
            Iterator<IChameleonLoader.LoadingCallback> r0 = this.a.a.iterator();     // Catch: Throwable -> L7
        L4:
            if (r0.hasNext() == false) goto L16;
            r0.next().onLoadSuccessByJS();     // Catch: Throwable -> L7
            goto L4
        L16:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class h implements Runnable {
        public final /* synthetic */ UIThreadCallbackAdapter a;
        public final /* synthetic */ String b;

        public h(UIThreadCallbackAdapter r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.UIThreadCallbackAdapter.TAG, "onPageStart execute");     // Catch: Throwable -> L7
            Iterator<IChameleonLoader.LoadingCallback> r0 = this.a.a.iterator();     // Catch: Throwable -> L7
        L4:
            if (r0.hasNext() == false) goto L16;
            r0.next().onPageStarted(this.b);     // Catch: Throwable -> L7
            goto L4
        L16:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class i implements Runnable {
        public final /* synthetic */ UIThreadCallbackAdapter a;
        public final /* synthetic */ WebView b;
        public final /* synthetic */ String c;

        public i(UIThreadCallbackAdapter r1, WebView r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.UIThreadCallbackAdapter.TAG, "onReceivedTitle execute");     // Catch: Throwable -> L11
            Iterator<IChameleonLoader.LoadingCallback> r0 = this.a.a.iterator();     // Catch: Throwable -> L8
        L5:
            if (r0.hasNext() == false) goto L23;
            r0.next().onReceivedTitle(this.b, this.c);     // Catch: Throwable -> L8
        L23:
            return;
        L8:
            th = move-exception;
            j.d(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.UIThreadCallbackAdapter.TAG, th);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L15;
            return;
        L15:
            throw th;
        }
    }

    static {
    }

    public final /* synthetic */ void a(boolean r1, int r2) {
    }

    public final void b() {
        Iterator<k.a> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        k.a r1 = r0.next();
        CopyOnWriteArrayList<k.a> r2 = RenderGoneHelper.a;
        Intrinsics.checkNotNull(r1);
        Intrinsics.checkNotNullParameter(r1, "cb");
        RenderGoneHelper.a.remove(r1);
        goto L4
    L6:
        CollectionsKt.removeAll(this.a, UIThreadCallbackAdapter$release$1.INSTANCE);
        this.b.clear();
        this.c.clear();
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.IChameleonTitleBarCallback
    public final void onLeftBackAndCloseChange() {
        j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.UIThreadCallbackAdapter.TAG, "onLeftBackAndCloseChange");
        UICallbackExecutor.execute(new b(this));
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    public final void onLoadStart() {
        j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.UIThreadCallbackAdapter.TAG, "onLoadStart");
        UICallbackExecutor.execute(new e(this));
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    public final void onLoadSuccess() {
        j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.UIThreadCallbackAdapter.TAG, "onLoadSuccess");
        UICallbackExecutor.execute(new f(this));
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    public final void onLoadSuccessByJS() {
        j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.UIThreadCallbackAdapter.TAG, "onLoadSuccess");
        UICallbackExecutor.execute(new g(this));
    }

    public UIThreadCallbackAdapter() {
        this.a = new CopyOnWriteArrayList();
        this.b = new CopyOnWriteArrayList();
        this.c = new CopyOnWriteArrayList();
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    public final boolean getKeepOnRelease() {
        return IChameleonLoader.LoadingCallback.DefaultImpls.getKeepOnRelease(this);
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    @Deprecated(message = "已废弃，使用IRenderGoneListener")
    public final void onRenderProcessGone() {
        IChameleonLoader.LoadingCallback.DefaultImpls.onRenderProcessGone(this);
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    public final void onPageStarted(String r3) {
        j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.UIThreadCallbackAdapter.TAG, "onPageStart");
        UICallbackExecutor.execute(new h(this, r3));
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    public final void onLoadFail(int r3, Throwable r4) {
        j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.UIThreadCallbackAdapter.TAG, "onLoadFail code=" + r3 + ", e=" + r4);
        UICallbackExecutor.execute(new c(r3, r4, this));
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    public final void onLoadFailByJS(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, IPortraitService.TYPE);
        j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.UIThreadCallbackAdapter.TAG, "onLoadFailByJS type=" + r3 + ", code=" + r4);
        UICallbackExecutor.execute(new d(this));
    }

    @Override // com.ss.android.lark.chameleon.pluginapi.IChameleonLoader.LoadingCallback
    public final void onReceivedTitle(WebView r3, String r4) {
        j.e(com.ss.android.lark.chameleon.container.webcontainer.plugin.core.UIThreadCallbackAdapter.TAG, "onReceivedTitle");
        UICallbackExecutor.execute(new i(this, r3, r4));
    }
}
