package com.bytedance.ai.applet.app;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.applet.app.base.RouteOptions;
import com.bytedance.ai.applet.domain.AppletDomainPolicyManager;
import com.bytedance.ai.applet.page.AppletPageFragment;
import com.bytedance.ai.applet.page.AppletPageTimelineTracker;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.service.IHostUserDepend;
import com.bytedance.ai.file.AppletFileManager;
import com.bytedance.ai.model.LynxWorkerRuntime;
import com.bytedance.ai.monitor.AppletErrorCode;
import com.bytedance.ai.widget.contianer.AppletWidgetContainer;
import com.bytedance.android.ec.base.api.ai.conversation.ConversationConstants;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ivy.ivykit.api.plugin.IIvyPageService;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.TemplateData;
import d3.w;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import m5.i1;
import m5.y0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 B2\u00020\u0001:\u0001BB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010(\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0016J$\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010%\u001a\u00020&2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J/\u0010/\u001a\b\u0012\u0004\u0012\u00020#002\u0006\u00101\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016¢\u0006\u0004\b2\u00103J\b\u00104\u001a\u00020#H\u0016J\b\u00105\u001a\u00020\u0012H\u0014J\u0010\u00106\u001a\u00020#2\u0006\u00107\u001a\u000208H\u0016J\u0010\u00109\u001a\u00020#2\u0006\u0010:\u001a\u000208H\u0016J\n\u0010;\u001a\u00060<j\u0002`=J\u000e\u0010>\u001a\n\u0018\u00010<j\u0004\u0018\u0001`=J\u0010\u0010?\u001a\u00020#2\u0006\u0010@\u001a\u00020\u000eH\u0007J\u0010\u0010A\u001a\u00020#2\u0006\u0010@\u001a\u00020\u000eH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\bR2\u0010\f\u001a&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e\u0018\u00010\u00100\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\u001a\u0004\b \u0010!*\u0004\b\u001e\u0010\u001f¨\u0006C"}, d2 = {"Lcom/bytedance/ai/applet/app/OnlineAppletApplication;", "Lcom/bytedance/ai/applet/app/AppletApplication;", "<init>", "()V", "_lynxGroup", "Lcom/lynx/tasm/LynxGroup;", "lynxGroup", "getLynxGroup", "()Lcom/lynx/tasm/LynxGroup;", "_widgetLynxGroup", "widgetLynxGroup", "getWidgetLynxGroup", "showingWidgets", "", "Lcom/bytedance/ai/widget/contianer/AppletWidgetContainer;", "kotlin.jvm.PlatformType", "", "isSavedInstanceState", "", "_files", "Lcom/bytedance/ai/file/AppletFileManager;", "filesLock", "", "files", "getFiles", "()Lcom/bytedance/ai/file/AppletFileManager;", "runtimeDelegate", "Lkotlin/Lazy;", "Lcom/bytedance/ai/model/LynxWorkerRuntime;", "runtime", "getRuntime$delegate", "(Lcom/bytedance/ai/applet/app/OnlineAppletApplication;)Ljava/lang/Object;", "getRuntime", "()Lcom/bytedance/ai/model/LynxWorkerRuntime;", "onAttached", "", "onCreate", "context", "Landroid/content/Context;", "onResume", "onStop", "onCreateView", "Landroidx/fragment/app/Fragment;", com.bytedance.android.ec.core.event.a.KEY_URL, "", "options", "Lcom/bytedance/ai/applet/app/base/RouteOptions;", "onUpdateView", "Lkotlin/Result;", "fragment", "onUpdateView-0E7RQCE", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Lcom/bytedance/ai/applet/app/base/RouteOptions;)Ljava/lang/Object;", "onDestroy", "canDestroy", "onSaveInstanceState", "outState", "Lcom/bytedance/ai/applet/app/AppletApplication$StateStore;", "onRestoreInstanceState", "savedState", "weakUpRuntime", "Lcom/bytedance/ai/model/AppletRuntime;", "Lcom/bytedance/ai/model/WorkerRuntime;", "runningRuntimeOrNull", "attachWidget", "widget", "detachWidget", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OnlineAppletApplication extends AppletApplication {
    public static final /* synthetic */ int w = 0;
    public LynxGroup p;
    public LynxGroup q;
    public final Set<AppletWidgetContainer> r;
    public boolean s;
    public volatile AppletFileManager t;
    public final Object u;
    public final Lazy<LynxWorkerRuntime> v;

    public static final class a {
    }

    static {
    }

    public final AppletFileManager J() {
        AppletFileManager r0 = this.t;
        char[] r1 = AppletFileManager.j;
        IHostUserDepend r10 = r4.a.i;
        if (r10 == null) goto L5;
        String r11 = r10.getUserId();
    L6:
        if (r11 != null) goto L8;
        r11 = "";
    L8:
        if (r0 != null) goto L10;
    L12:
        Object r12 = this.u;
        monitor-enter(r12);
        AppletFileManager r13 = this.t;     // Catch: Throwable -> L23
        if (r13 != null) goto L17;
    L20:
        AppletFileManager r14 = new AppletFileManager(o2.a.a(), getAppId(), r11);     // Catch: Throwable -> L23
        this.t = r14;     // Catch: Throwable -> L23
        monitor-exit(r12);
        return r14;
    L17:
        if (Intrinsics.areEqual(r13.c, r11) == false) goto L20;
        monitor-exit(r12);
        return r13;
    L23:
        th = move-exception;
        throw th;
    L10:
        if (Intrinsics.areEqual(r0.c, r11) == false) goto L12;
        return r0;
    L5:
        r11 = null;
        goto L6
    }

    public final void onDestroy() {
        if (this.v.isInitialized() == false) goto L5;
        ((LynxWorkerRuntime) this.v.getValue()).G();
    L5:
        LynxGroup r1 = null;
        if (this.s == true) goto L11;
        i().c("onDestroy: not saved instance state, destroy widget lynx group");
        LynxGroup r0 = this.q;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("_widgetLynxGroup");
        r0 = null;
    L10:
        r0.destroy();
    L12:
        LynxGroup r10 = this.p;
        if (r10 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("_lynxGroup");
    L16:
        r1.destroy();
        this.s = false;
        super.onDestroy();
        return;
    L15:
        r1 = r10;
        goto L16
    L11:
        i().c("onDestroy: saved instance state, keep widget lynx group");
        goto L12
    }

    public final void p() {
        LynxGroup.a r0 = new LynxGroup.a();
        r0.a = getAppId();
        r0.d = true;
        this.p = new LynxGroup(r0);
        LynxGroup.a r1 = new LynxGroup.a();
        r1.a = getAppId() + "_widget";
        r1.d = true;
        this.q = new LynxGroup(r1);
        super.p();
        AppletDomainPolicyManager.a.n(getAppId());
    }

    public OnlineAppletApplication() {
        this.r = Collections.newSetFromMap(new WeakHashMap());
        this.u = new Object();
        this.v = LazyKt.lazy(new u(this));
    }

    public final LynxWorkerRuntime K() {
        i().c("weakUpRuntime: try to weak up runtime");
        if (e() == false) goto L6;
        G();
    L6:
        return (LynxWorkerRuntime) this.v.getValue();
    }

    public final boolean e() {
        i().c("canDestroy: check if can destroy, widgetCount = " + this.r.size());
        if (super.e() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.r.isEmpty() == false) goto L7;
        return true;
    }

    public final void B(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        w r0 = ((LynxWorkerRuntime) this.v.getValue()).B;
        if (r0 == null) goto L5;
        r0.a("onBackground", null);
    L5:
        super.B(r10);
    }

    public final void r(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super.r(r10);
        K();
    }

    public final void x(AppletApplication$b r10) {
        Intrinsics.checkNotNullParameter(r10, "savedState");
        i().c("onRestoreInstanceState: try to restore instance state");
        Intrinsics.checkNotNullParameter(r10, "savedState");
        r10.getClass();
        Intrinsics.checkNotNullParameter("showingWidgets", "key");
        Object r0 = ((LinkedHashMap) r10.a).get("showingWidgets");
        LynxGroup r11 = null;
        if ((r0 instanceof Collection) == true) goto L5;
        r0 = null;
    L5:
        Collection<? extends AppletWidgetContainer> r1 = (Collection) r0;
        if (r1 == null) goto L8;
        i().c("onRestoreInstanceState: restore showing widgets success, widgetCount = " + r1.size());
        this.r.addAll(r1);
    L8:
        Intrinsics.checkNotNullParameter("widgetLynxGroup", "key");
        Object r12 = ((LinkedHashMap) r10.a).get("widgetLynxGroup");
        if ((r12 instanceof LynxGroup) == true) goto L11;
        r12 = null;
    L11:
        LynxGroup r13 = (LynxGroup) r12;
        if (r13 == null) goto L18;
        i().c("onRestoreInstanceState: restore widget lynx group success");
        LynxGroup r14 = this.q;
        if (r14 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("_widgetLynxGroup");
    L17:
        r11.destroy();
        this.q = r13;
        return;
    L16:
        r11 = r14;
        goto L17
    L18:
        i().a("onRestoreInstanceState: widget lynx group is null", null);
    }

    public final void y(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        w r0 = ((LynxWorkerRuntime) this.v.getValue()).B;
        if (r0 == null) goto L5;
        r0.a("onForeground", null);
    L5:
        super.y(r10);
    }

    public final void z(AppletApplication$b r10) {
        Intrinsics.checkNotNullParameter(r10, "outState");
        i().c("onSaveInstanceState: try to save instance state");
        Intrinsics.checkNotNullParameter(r10, "outState");
        this.s = true;
        Set<AppletWidgetContainer> r0 = this.r;
        Intrinsics.checkNotNullParameter("showingWidgets", "key");
        r10.a.put("showingWidgets", r0);
        LynxGroup r1 = this.q;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_widgetLynxGroup");
        r1 = null;
    L5:
        Intrinsics.checkNotNullParameter("widgetLynxGroup", "key");
        r10.a.put("widgetLynxGroup", r1);
    }

    public final Object D(Fragment r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
        if ((r10 instanceof AppletPageFragment) == false) goto L5;
        AppletPageFragment r1 = (AppletPageFragment) r10;
    L6:
        if (r1 != null) goto L9;
        Result.Companion r12 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new UnsupportedOperationException("Updating " + r10.getClass().getSimpleName() + " is not supported")));
    L9:
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
        r1.f = r11;
        Bundle r13 = r1.getArguments();
        if (r13 == null) goto L12;
        r13.putString(com.bytedance.android.ec.core.event.a.KEY_URL, r11);
    L12:
        com.bytedance.ai.lynx.g r14 = r1.i;
        if (r14 == null) goto L23;
        r14.updateGlobalProps(TemplateData.fromMap(MapsKt.mapOf(TuplesKt.to("__LOCATION__", r11))));
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L17
        r14.sendGlobalEvent("globalPropsUpdated", new JavaOnlyArray());     // Catch: Throwable -> L17
        Object r16 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L22;
        com.bytedance.ai.applet.base.log.d r0 = r1.d;
        String r18 = "sendGlobalEvent globalPropsUpdated error: " + r17.getMessage();
        AtomicInteger r19 = com.bytedance.ai.applet.base.log.d.d;
        r0.a(r18, null);
    L22:
        Result.box-impl(r16);
    L17:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
    L23:
        Result.Companion r21 = Result.Companion;
        return Result.constructor-impl(Unit.INSTANCE);
    L5:
        r1 = null;
        goto L6
    }

    public final Fragment t(Context r12, String r13, RouteOptions r14) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, com.bytedance.android.ec.core.event.a.KEY_URL);
        Uri r1 = UriProtector.parse(r13);
        Long r10 = null;
        if (r1.isHierarchical() == true) goto L6;
        r1 = null;
    L6:
        if (r1 == null) goto L8;
        String r11 = UriProtector.getQueryParameter(r1, "anniex_url");
    L9:
        if (r11 != null) goto L11;
    L14:
        boolean r15 = true;
    L15:
        if (r15 == true) goto L21;
        i().c("onCreateView: anniexUrl = " + r11);
        Parcelable.Creator<AppletPageTimelineTracker> r16 = AppletPageTimelineTracker.CREATOR;
        AppletPageTimelineTracker r17 = AppletPageTimelineTracker.a.a(getAppId(), r13, "anniex");
        Activity r18 = (Activity) r12;
        com.bytedance.ai.applet.page.b.a.getClass();
        Intrinsics.checkNotNullParameter(r18, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r17, "pageTimelineTracker");
        i1 r19 = y0.a;
        y0.g(r17.a, "applet_page_timeline_full");
        Fragment r110 = IIvyPageService.a.a(r18, r11, new com.bytedance.ai.applet.page.a(r17));
        if (r110 != null) goto L20;
        r17.a("Ivy page service is unavailable", AppletErrorCode.WEB_VIEW_LOAD_ERROR.getType());
        return null;
    L20:
        return r110;
    L21:
        Parcelable.Creator<AppletPageTimelineTracker> r111 = AppletPageTimelineTracker.CREATOR;
        AppletPageTimelineTracker r112 = AppletPageTimelineTracker.a.a(getAppId(), r13, "lynx");
        if (j().q(r13) != null) goto L25;
        AtomicInteger r0 = com.bytedance.ai.applet.base.log.d.d;
        i().a("onCreateView: page is null, url = " + r13, null);
        r112.a("PageNotFound", AppletErrorCode.PAGE_NOT_FOUND.getType());
        return null;
    L25:
        AppletPageFragment.a r20 = AppletPageFragment.s;
        String r21 = getAppId();
        if (r14 == null) goto L28;
        String r22 = r14.a;
    L29:
        if (r14 == null) goto L31;
        r10 = r14.b;
    L31:
        r20.getClass();
        Intrinsics.checkNotNullParameter(r21, BdpAwemeConstant.KEY_APP_ID);
        Intrinsics.checkNotNullParameter(r13, com.bytedance.android.ec.core.event.a.KEY_URL);
        if (r10 == null) goto L34;
        long r23 = r10.longValue();
    L37:
        AppletPageFragment r113 = new AppletPageFragment();
        Bundle r24 = new Bundle();
        r24.putString(com.bytedance.android.ec.core.event.a.KEY_APP_ID, r21);
        r24.putString(com.bytedance.android.ec.core.event.a.KEY_URL, r13);
        r24.putParcelable("page_timeline_tracker", r112);
        r24.putString(ConversationConstants.KEY_CONVERSATION_ID, r22);
        r113.setArguments(r24);
        Long r114 = Long.valueOf(r23);
        Intrinsics.checkNotNullParameter(r113, "<this>");
        if (r114 != null) goto L40;
        t2.b.a(r113).remove("trace_id");
    L41:
        return r113;
    L40:
        t2.b.a(r113).putLong("trace_id", r114.longValue());
        goto L41
    L34:
        AppletAppManagerService.INSTANCE.getClass();
        AppletApplication r115 = AppletAppManagerService.a(r21);
        if (r115 == null) goto L43;
        com.bytedance.ai.applet.app.foundation.performance.r r116 = r115.h().c().b(new com.bytedance.ai.applet.app.foundation.performance.p(System.currentTimeMillis(), t2.c.a(r13), null, 28));
        r116.t();
        r23 = r116.c;
        goto L37
    L43:
        throw new IllegalArgumentException("AppletApplication not found for appId: ".concat(r21).toString());
    L28:
        r22 = null;
        goto L29
    L11:
        if (r11.length() == 0) goto L14;
        r15 = false;
        goto L15
    L8:
        r11 = null;
        goto L9
    }
}
