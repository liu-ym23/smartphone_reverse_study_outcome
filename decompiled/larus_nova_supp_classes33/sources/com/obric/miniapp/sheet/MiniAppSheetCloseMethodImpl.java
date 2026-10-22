package com.obric.miniapp.sheet;

import android.app.Activity;
import android.content.Context;
import com.bytedance.ai.bridge.service.IHostContextDepend;
import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J.\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00160\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J8\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00160\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001c\u001a\u00020\u000eH\u0016J\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0002\u0010 R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00040\u00040\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/miniapp/sheet/MiniAppSheetCloseMethodImpl;", "Lcom/ivy/ivykit/api/bridge/inject/IRouterBridgeDependInject;", "Lcom/bytedance/ai/bridge/service/IHostRouterDepend;", "host", "Lcom/obric/miniapp/sheet/MiniAppSheetHost;", "<init>", "(Lcom/obric/miniapp/sheet/MiniAppSheetHost;)V", "hostRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "install", "", "restore", "closeView", "", "context", "Landroid/content/Context;", "openSchema", "schema", "", "extraInfo", "", "", "aiBridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "extraParams", "bridgeContext", "containerID", "animated", "close", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)Ljava/lang/Boolean;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiniAppSheetCloseMethodImpl implements hx7.f, r4.j {
    public static final Companion Companion = null;
    private static r4.j baseHostRouterDepend;
    private static hx7.f baseRouterDepend;
    private static final Object companionLock = null;
    private static final List<MiniAppSheetCloseMethodImpl> installedHooks = null;
    private static final r4.j originalHostRouterDepend = null;
    private static final hx7.f originalRouterDepend = null;
    private final WeakReference<MiniAppSheetHost> hostRef;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/miniapp/sheet/MiniAppSheetCloseMethodImpl$Companion;", "", "<init>", "()V", "companionLock", "originalRouterDepend", "Lcom/ivy/ivykit/api/bridge/inject/IRouterBridgeDependInject;", "originalHostRouterDepend", "Lcom/bytedance/ai/bridge/service/IHostRouterDepend;", "installedHooks", "", "Lcom/obric/miniapp/sheet/MiniAppSheetCloseMethodImpl;", "baseRouterDepend", "baseHostRouterDepend", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    public r4.b provideRouteOpenExceptionHandler(e3.d r1) {
        return null;
    }

    static {
        Companion = new Companion(null);
        companionLock = new Object();
        Map r0 = com.ivy.ivykit.api.bridge.b.a;
        originalRouterDepend = (hx7.f) com.ivy.ivykit.api.bridge.b.a(hx7.f.class);
        originalHostRouterDepend = r4.a.j;
        installedHooks = new ArrayList();
    }

    public final void install() {
        Object r0 = companionLock;
        monitor-enter(r0);
        List<MiniAppSheetCloseMethodImpl> r1 = installedHooks;     // Catch: Throwable -> L10
        if (r1.isEmpty() == false) goto L7;
        Map r2 = com.ivy.ivykit.api.bridge.b.a;     // Catch: Throwable -> L10
        baseRouterDepend = (hx7.f) com.ivy.ivykit.api.bridge.b.a(hx7.f.class);     // Catch: Throwable -> L10
        baseHostRouterDepend = r4.a.j;     // Catch: Throwable -> L10
    L7:
        r1.remove(this);     // Catch: Throwable -> L10
        r1.add(0, this);     // Catch: Throwable -> L10
        Map r3 = com.ivy.ivykit.api.bridge.b.a;     // Catch: Throwable -> L10
        com.ivy.ivykit.api.bridge.b.b(hx7.f.class, this);     // Catch: Throwable -> L10
        IHostContextDepend r4 = r4.a.a;     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(this, "hostRouterDepend");     // Catch: Throwable -> L10
        r4.a.j = this;     // Catch: Throwable -> L10
        monitor-exit(r0);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void restore() {
        Object r0 = companionLock;
        monitor-enter(r0);
        List<MiniAppSheetCloseMethodImpl> r1 = installedHooks;     // Catch: Throwable -> L24
        r1.remove(this);     // Catch: Throwable -> L24
        MiniAppSheetCloseMethodImpl r2 = (MiniAppSheetCloseMethodImpl) CollectionsKt.firstOrNull(r1);     // Catch: Throwable -> L24
        if (r2 == null) goto L9;
        Map r3 = com.ivy.ivykit.api.bridge.b.a;     // Catch: Throwable -> L24
        com.ivy.ivykit.api.bridge.b.b(hx7.f.class, r2);     // Catch: Throwable -> L24
        IHostContextDepend r4 = r4.a.a;     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r2, "hostRouterDepend");     // Catch: Throwable -> L24
        r4.a.j = r2;     // Catch: Throwable -> L24
        monitor-exit(r0);
        return;
    L9:
        hx7.f r5 = baseRouterDepend;     // Catch: Throwable -> L24
        if (r5 == null) goto L12;
        Map r6 = com.ivy.ivykit.api.bridge.b.a;     // Catch: Throwable -> L24
        com.ivy.ivykit.api.bridge.b.b(hx7.f.class, r5);     // Catch: Throwable -> L24
    L15:
        r4.j r7 = baseHostRouterDepend;     // Catch: Throwable -> L24
        if (r7 == null) goto L18;
        IHostContextDepend r8 = r4.a.a;     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r7, "hostRouterDepend");     // Catch: Throwable -> L24
        r4.a.j = r7;     // Catch: Throwable -> L24
    L21:
        baseRouterDepend = null;     // Catch: Throwable -> L24
        baseHostRouterDepend = null;     // Catch: Throwable -> L24
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L24
        monitor-exit(r0);
        return;
    L18:
        r4.j r10 = originalHostRouterDepend;     // Catch: Throwable -> L24
        if (r10 == null) goto L21;
        IHostContextDepend r11 = r4.a.a;     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r10, "hostRouterDepend");     // Catch: Throwable -> L24
        r4.a.j = r10;     // Catch: Throwable -> L24
        goto L21
    L12:
        hx7.f r12 = originalRouterDepend;     // Catch: Throwable -> L24
        if (r12 == null) goto L15;
        Map r13 = com.ivy.ivykit.api.bridge.b.a;     // Catch: Throwable -> L24
        com.ivy.ivykit.api.bridge.b.b(hx7.f.class, r12);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    public MiniAppSheetCloseMethodImpl(MiniAppSheetHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        this.hostRef = new WeakReference(r2);
    }

    private final Boolean close(Activity r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        MiniAppSheetHost r1 = this.hostRef.get();
        if (r1 != null) goto L9;
        return null;
    L9:
        if (r1.activityMatches(r4) == true) goto L11;
        return null;
    L11:
        FLogger.a.i("MiniAppSheetHost", "close(activity) matched host=".concat(r4.getClass().getSimpleName()));
        r1.dismiss();
        return Boolean.TRUE;
    }

    public boolean closeView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        FLogger.a.i("MiniAppSheetHost", "closeView(context) called");
        Boolean r0 = close(MiniAppSheetHostKt.access$findActivity(r4));
        if (r0 != null) goto L5;
        hx7.f r1 = baseRouterDepend;
        if (r1 != null) goto L14;
        hx7.f r2 = originalRouterDepend;
        if (r2 != null) goto L15;
        return false;
    L15:
        return r2.closeView(r4);
    L14:
        return r1.closeView(r4);
    L5:
        return r0.booleanValue();
    }

    public boolean interceptClose(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return false;
    }

    public List<r4.b> provideRouteOpenHandlerList(e3.d r1) {
        return CollectionsKt.emptyList();
    }

    public boolean closeView(e3.d r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "bridgeContext");
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("closeView(bridgeContext) called, containerID=");
        r1.append(r5);
        r1.append(", activity=");
        Activity r2 = r4.getOwnerActivity();
        if (r2 == null) goto L5;
        String r3 = r2.getClass().getSimpleName();
    L6:
        r1.append(r3);
        r0.i("MiniAppSheetHost", r1.toString());
        Activity r7 = r4.getOwnerActivity();
        if (r5 != null) goto L9;
    L11:
        Boolean r8 = close(r7);
        if (r8 == null) goto L16;
        return r8.booleanValue();
    L16:
        if (MiniAppSheetRegistry.INSTANCE.dismissLatestWithViewId(r7) == null) goto L18;
        return true;
    L18:
        r4.j r9 = baseHostRouterDepend;
        if (r9 != null) goto L26;
        r4.j r10 = originalHostRouterDepend;
        if (r10 != null) goto L27;
        return false;
    L27:
        return r10.closeView(r4, r5, r6);
    L26:
        return r9.closeView(r4, r5, r6);
    L9:
        if (MiniAppSheetRegistry.INSTANCE.dismissWithViewId(r5, r7) == null) goto L11;
        return true;
    L5:
        r3 = null;
        goto L6
    }

    public boolean openSchema(String r2, Map<String, ? extends Object> r3, Context r4) {
        Intrinsics.checkNotNullParameter(r2, "schema");
        Intrinsics.checkNotNullParameter(r3, "extraInfo");
        hx7.f r0 = originalRouterDepend;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.openSchema(r2, r3, r4);
    }

    public boolean openSchema(e3.d r2, String r3, Map<String, ? extends Object> r4, Context r5) {
        Intrinsics.checkNotNullParameter(r3, "schema");
        Intrinsics.checkNotNullParameter(r4, "extraParams");
        r4.j r0 = originalHostRouterDepend;
        if (r0 != null) goto L10;
        hx7.f r6 = originalRouterDepend;
        if (r6 != null) goto L11;
        return false;
    L11:
        return r6.openSchema(r3, r4, r5);
    L10:
        return r0.openSchema(r2, r3, r4, r5);
    }
}
