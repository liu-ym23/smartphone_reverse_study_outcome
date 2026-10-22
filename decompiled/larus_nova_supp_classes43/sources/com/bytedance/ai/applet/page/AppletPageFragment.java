package com.bytedance.ai.applet.page;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.applet.app.AppletAppActivity;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.app.foundation.AppletModelContextProvider;
import com.bytedance.ai.applet.app.foundation.performance.AppletPerformanceErrorCode;
import com.bytedance.ai.applet.app.foundation.performance.AppletPerformanceOutcome;
import com.bytedance.ai.applet.app.foundation.performance.r;
import com.bytedance.ai.applet.app.foundation.v;
import com.bytedance.ai.applet.app.t;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.model.objects.Page;
import com.bytedance.ai.model.objects.PageChatConfig;
import com.bytedance.ai.monitor.AppletErrorCode;
import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import com.bytedance.android.ec.base.api.ai.conversation.ConversationConstants;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxView;
import d3.w;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import m5.i1;
import m5.y0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000¥\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u001a\u0018\u0000 H2\u00020\u0001:\u0001HB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001fH\u0002J\u0012\u0010!\u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u001fH\u0016J&\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010+\u001a\u00020\u001fH\u0016J\u0010\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020\nH\u0016J\b\u0010.\u001a\u00020\u001fH\u0016J\b\u0010/\u001a\u00020\u001fH\u0016J\b\u00100\u001a\u00020\u001fH\u0016J\u0015\u00101\u001a\u00020\u001f2\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0002\b2J \u00103\u001a\u00020\r2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0002J \u0010:\u001a\u00020;2\u0006\u0010)\u001a\u00020*2\u0006\u00106\u001a\u0002072\u0006\u0010<\u001a\u00020=H\u0002J\u001a\u0010>\u001a\u00020\u001f2\u0006\u0010?\u001a\u00020\u00072\b\b\u0002\u0010@\u001a\u00020AH\u0002J\u0010\u0010B\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020DH\u0002J\b\u0010E\u001a\u00020\u001fH\u0002J\u0012\u0010F\u001a\u00020\u001f2\b\b\u0002\u0010G\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/bytedance/ai/applet/page/AppletPageFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "logger", "Lcom/bytedance/ai/applet/base/log/InstanceLogger;", BdpAwemeConstant.KEY_APP_ID, "", com.bytedance.android.ec.core.event.a.KEY_URL, "isPageForeground", "", "chatInputEnabled", "lynxView", "Lcom/bytedance/ai/lynx/AppletLynxView;", "lynxViewShowed", "pageContentReady", "keyboardHeightChangeObserver", "Lcom/bytedance/ai/bridge/method/event/KeyboardHeightChangeObserver;", "pageTimelineTracker", "Lcom/bytedance/ai/applet/page/AppletPageTimelineTracker;", "conversationId", "bridge", "Lcom/bytedance/ai/bridge/AIBridge;", "performanceTracker", "Lcom/bytedance/ai/applet/app/foundation/performance/PagePerformanceTracker;", "lifeCycleListener", "com/bytedance/ai/applet/page/AppletPageFragment$lifeCycleListener$1", "Lcom/bytedance/ai/applet/page/AppletPageFragment$lifeCycleListener$1;", "backStackListener", "Landroidx/fragment/app/FragmentManager$OnBackStackChangedListener;", "checkVisibility", "", "applyChatInputVisibility", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onResume", "onHiddenChanged", "hidden", "onPause", "onStop", "onDestroyView", "updatePage", "updatePage$ai_sdk_release", "createLynxView", "context", "Landroid/content/Context;", "app", "Lcom/bytedance/ai/applet/app/OnlineAppletApplication;", "manifest", "Lcom/bytedance/ai/model/objects/Applet;", "loadLynxView", "Lkotlinx/coroutines/Job;", AIStateLogRequest.SOURCE_PAGE, "Lcom/bytedance/ai/model/objects/Page;", "reportPerformanceError", "errorMessage", "errorCode", "", "updateHostContentState", "state", "Lcom/bytedance/ai/applet/app/AppletPageContentState;", "attachKeyboardHeightChangeObserver", "detachKeyboardHeightChangeObserver", "release", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletPageFragment extends Fragment {
    public static final a s = null;
    public final com.bytedance.ai.applet.base.log.d d;
    public String e;
    public String f;
    public boolean g;
    public boolean h;
    public com.bytedance.ai.lynx.g i;
    public boolean j;
    public boolean k;
    public w3.b l;
    public AppletPageTimelineTracker m;
    public String n;
    public final w o;
    public r p;
    public final b q;
    public final h r;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements com.bytedance.ai.lynx.r {
        public final /* synthetic */ AppletPageFragment a;

        @Override // com.bytedance.ai.lynx.r
        public final void onDetachedFromWindow(com.bytedance.ai.lynx.g r1) {
        }

        @Override // com.bytedance.ai.lynx.r
        public final void onFirstScreen(com.bytedance.ai.lynx.g r1) {
        }

        @Override // com.bytedance.ai.lynx.r
        public final void onPageUpdate(com.bytedance.ai.lynx.g r1) {
        }

        @Override // com.bytedance.ai.lynx.r
        public final void onRuntimeReady(com.bytedance.ai.lynx.g r1) {
        }

        @Override // com.bytedance.ai.lynx.r
        public final void onTimingUpdate(com.bytedance.ai.lynx.g r1, Map<String, Object> r10, Map<String, Long> r11, String r12) {
        }

        public b(AppletPageFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ai.lynx.r
        public final void onLoadUriSuccess(Uri r10, com.bytedance.ai.lynx.g r11) {
            this.a.d.c("onLoadUriSuccess: uri = " + r10 + ", annieXLynxView = " + r11);
            AppletPageTimelineTracker r12 = this.a.m;
            if (r12 != null) goto L5;
        L8:
            AppletPageFragment r13 = this.a;
            r13.k = true;
            r13.V90(t.a.a);
            return;
        L5:
            if (r12.b == true) goto L8;
            i1 r0 = y0.a;
            y0.f(r12.a, "applet_page_timeline_full");
            r12.b = true;
            goto L8
        }

        @Override // com.bytedance.ai.lynx.r
        public final void onPageStart(com.bytedance.ai.lynx.g r10, String r11) {
            this.a.d.c("onPageStart: url = " + r11 + ", annieXLynxView = " + r10);
            AppletPageFragment r12 = this.a;
            r12.j = true;
            r12.S90();
        }

        @Override // com.bytedance.ai.lynx.r
        public final void onReceivedError(com.bytedance.ai.lynx.g r10, LynxError r11) {
            AtomicInteger r1 = com.bytedance.ai.applet.base.log.d.d;
            this.a.d.a("onReceivedError: annieXLynxView = " + r10 + ", error = " + r11, null);
            AppletPageFragment r12 = this.a;
            if (r11 == null) goto L6;
            String r0 = r11.toString();
            if (r0 == null) goto L6;
        L7:
            if (r11 == null) goto L9;
            int r13 = r11.getErrorCode();
        L10:
            r12.U90(r0, r13);
            return;
        L9:
            r13 = AppletErrorCode.WEB_VIEW_LOAD_ERROR.getType();
        L6:
            r0 = "unknown Lynx error";
            goto L7
        }

        @Override // com.bytedance.ai.lynx.r
        public final void onTimingSetup(com.bytedance.ai.lynx.g r10, Map<String, Object> r11) {
            this.a.d.c("onTimingSetup: timingInfo = " + r11);
            AppletPageTimelineTracker r12 = this.a.m;
            if (r12 == null) goto L5;
            i1 r0 = y0.a;
            y0.n(r12.a, r11, "applet_page_timeline_full");
        L5:
            if (r11 == null) goto L9;
            r r13 = this.a.p;
            if (r13 == null) goto L9;
            r13.o(r11);
        L9:
            AppletPageFragment r14 = this.a;
            r14.p = null;
            if (r14.k == true) goto L13;
            r14.k = true;
            r14.V90(t.a.a);
            return;
        }
    }

    static {
        s = new a();
    }

    public final void S90() {
        if (this.g == true) goto L5;
        return;
    L5:
        AppletAppManagerService r0 = AppletAppManagerService.INSTANCE;
        String r1 = this.e;
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        r0.getClass();
        AppletApplication r10 = AppletAppManagerService.a(r1);
        if (r10 == null) goto L25;
        v r11 = r10.h();
        if (r11 == null) goto L26;
        com.bytedance.ai.applet.app.foundation.a r12 = r11.b();
        if (r12 != null) goto L15;
        return;
    L15:
        if (this.h == true) goto L17;
        AppletAppActivity r13 = r12.a.d;
        if (r13 == null) goto L31;
        r13.O1();
        return;
    L31:
        return;
    L17:
        if (this.j == false) goto L28;
        AppletAppActivity r14 = r12.a.d;
        if (r14 == null) goto L29;
        r14.Z1();
        return;
    L29:
        return;
    L28:
        return;
    L26:
        return;
    }

    public final void onDestroyView() {
        this.d.c("onDestroyView");
        AppletPageTimelineTracker r0 = this.m;
        if (r0 != null) goto L5;
    L8:
        r r10 = this.p;
        if (r10 == null) goto L11;
        com.bytedance.ai.applet.app.foundation.performance.k.d(r10, AppletPerformanceOutcome.CANCELLED, 0, AppletPerformanceErrorCode.CANCELLED, "closed_before_complete", 2);
    L11:
        this.p = null;
        w3.b r11 = this.l;
        if (r11 == null) goto L14;
        r11.a();
    L14:
        this.l = null;
        com.bytedance.ai.lynx.g r12 = this.i;
        if (r12 == null) goto L17;
        r12.destroy();
    L17:
        this.i = null;
        this.j = false;
        this.k = false;
        super.onDestroyView();
        return;
    L5:
        if (r0.c == true) goto L8;
        i1 r13 = y0.a;
        y0.p(r0.a, "applet_page_timeline_full", false);
        y0.o(r0.a, "applet_page_timeline_full");
        r0.c = true;
        goto L8
    }

    public final void onPause() {
        this.d.c("onPause");
        super.onPause();
        T90();
    }

    /* JADX WARN: Type inference failed for: r2v9, types: [com.bytedance.ai.applet.page.g] */
    public final void onResume() {
        this.d.c("onResume");
        super.onResume();
        LynxView r0 = this.i;
        if (r0 == null) goto L20;
        w3.b r1 = this.l;
        if (r1 != null) goto L8;
        r1 = new w3.b(new g(this));
        this.l = r1;
    L8:
        Intrinsics.checkNotNullParameter(r0, "anchorView");
        WeakReference<View> r10 = r1.b;
        if (r10 == null) goto L11;
        LynxView r11 = (View) r10.get();
    L12:
        if (r11 != r0) goto L14;
        r1.b();
        goto L20
    L14:
        r1.a();
        r1.b = new WeakReference(r0);
        r0.addOnAttachStateChangeListener(r1);
        if (r0.isAttachedToWindow() == false) goto L20;
        ViewTreeObserver r12 = r0.getViewTreeObserver();
        if (r12.isAlive() == false) goto L19;
        r12.addOnGlobalLayoutListener(r1);
    L19:
        r1.b();
        goto L20
    L11:
        r11 = null;
    L20:
        T90();
    }

    public final void onStop() {
        this.d.c("onStop");
        w3.b r0 = this.l;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        T90();
        super.onStop();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.ai.applet.page.h] */
    public AppletPageFragment() {
        this.d = new com.bytedance.ai.applet.base.log.d("AppletPageFragment", null);
        w r0 = new w();
        this.o = r0;
        r0.d(new q4.a());
        this.q = new b(this);
        this.r = new h(this);
    }

    public final void T90() {
        if (isResumed() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        List r10 = getParentFragmentManager().getFragments();
        ListIterator r11 = r10.listIterator(r10.size());
    L10:
        if (r11.hasPrevious() == false) goto L17;
        Object r12 = r11.previous();
        if (((Fragment) r12).getId() != 2131363104) goto L14;
        boolean r13 = true;
    L15:
        if (r13 == false) goto L10;
    L18:
        if (r12 != this) goto L20;
        boolean r14 = true;
    L21:
        if (r0 == false) goto L24;
        if (r14 == false) goto L24;
        boolean r1 = true;
    L25:
        if (r1 == true) goto L27;
    L32:
        if (r1 == false) goto L34;
        return;
    L34:
        if (this.g == false) goto L46;
        this.g = false;
        this.d.c("notifyPageHide");
        this.o.a("onHide", null);
        com.bytedance.ai.lynx.g r15 = this.i;
        if (r15 == null) goto L47;
        r15.onEnterBackground();
        return;
    L47:
        return;
    L46:
        return;
    L27:
        if (this.g == true) goto L32;
        this.g = true;
        S90();
        this.d.c("notifyPageShow");
        com.bytedance.ai.lynx.g r16 = this.i;
        if (r16 == null) goto L31;
        r16.onEnterForeground();
    L31:
        this.o.a("onShow", null);
        return;
    L24:
        r1 = false;
        goto L25
    L20:
        r14 = false;
        goto L21
    L14:
        r13 = false;
        goto L15
    L17:
        r12 = null;
        goto L18
    L5:
        if (isHidden() == true) goto L7;
        r0 = true;
        goto L8
    }

    public final void onDestroy() {
        getParentFragmentManager().removeOnBackStackChangedListener(this.r);
        Long r0 = t2.b.b(this);
        if (r0 == null) goto L11;
        long r1 = r0.longValue();
        AppletAppManagerService r10 = AppletAppManagerService.INSTANCE;
        String r11 = this.e;
        if (r11 != null) goto L7;
        r11 = "";
    L7:
        r10.getClass();
        AppletApplication r12 = AppletAppManagerService.a(r11);
        if (r12 == null) goto L11;
        AppletModelContextProvider r13 = (AppletModelContextProvider) r12.h().n.getValue();
        r13.b.remove(Long.valueOf(r1));
        com.bytedance.ai.utils.g.a.i("AppletModelContextProvider", "removePageContext, traceId=" + r1 + ", totalPages=" + r13.b.size());
        r12.h().d().k(r1);
    L11:
        super.onDestroy();
    }

    public final void V90(t r10) {
        AppletAppActivity r0 = getActivity();
        if ((r0 instanceof AppletAppActivity) == false) goto L5;
        AppletAppActivity r1 = r0;
    L6:
        if (r1 == null) goto L11;
        Intrinsics.checkNotNullParameter(this, "fragment");
        Intrinsics.checkNotNullParameter(r10, "state");
        if (r1.i != this) goto L12;
        r1.S1(r10);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onCreate(Bundle r10) {
        this.d.c("onCreate");
        super.onCreate(r10);
        Bundle r11 = getArguments();
        if (r11 == null) goto L24;
        String r0 = r11.getString(com.bytedance.android.ec.core.event.a.KEY_APP_ID);
        if (r0 != null) goto L7;
        return;
    L7:
        this.e = r0;
        String r1 = r11.getString(com.bytedance.android.ec.core.event.a.KEY_URL);
        if (r1 != null) goto L10;
        return;
    L10:
        this.f = r1;
        this.m = (AppletPageTimelineTracker) r11.getParcelable("page_timeline_tracker");
        this.n = r11.getString(ConversationConstants.KEY_CONVERSATION_ID);
        Long r12 = t2.b.b(this);
        if (r12 == null) goto L24;
        long r13 = r12.longValue();
        AppletAppManagerService r14 = AppletAppManagerService.INSTANCE;
        String r15 = this.e;
        if (r15 != null) goto L15;
        r15 = "";
    L15:
        r14.getClass();
        AppletApplication r16 = AppletAppManagerService.a(r15);
        if (r16 == null) goto L22;
        v r17 = r16.h();
        if (r17 == null) goto L22;
        com.bytedance.ai.applet.app.foundation.performance.c r18 = r17.c();
        if (r18 == null) goto L22;
        r r19 = r18.f(r13);
    L23:
        this.p = r19;
    L22:
        r19 = null;
    L24:
        getParentFragmentManager().addOnBackStackChangedListener(this.r);
    }

    public final void onHiddenChanged(boolean r10) {
        super.onHiddenChanged(r10);
        this.d.c("onHiddenChanged: " + r10);
        T90();
    }

    public final void U90(String r10, int r11) {
        if (this.k == true) goto L5;
        V90(new t.b(r10));
    L5:
        AppletPageTimelineTracker r0 = this.m;
        if (r0 == null) goto L8;
        r0.a(r10, r11);
    L8:
        r r1 = this.p;
        boolean r12 = false;
        if (r1 != null) goto L11;
    L13:
        if (r12 == false) goto L16;
        this.p = null;
        return;
    L16:
        return;
    L11:
        if (r1.c(AppletPerformanceErrorCode.PAGE_RENDER_ERROR, r10 + ", sourceErrorCode=" + r11) != true) goto L13;
        r12 = true;
        goto L13
    }

    public final View onCreateView(LayoutInflater r13, ViewGroup r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r13, "inflater");
        this.d.c("onCreateView");
        String r16 = this.e;
        String r17 = this.f;
        boolean r18 = false;
        if (r17 != null) goto L5;
    L8:
        boolean r19 = true;
    L10:
        if (r19 == true) goto L37;
        if (r16 != null) goto L13;
    L16:
        boolean r110 = true;
    L17:
        if (r110 == true) goto L37;
        AppletAppManagerService.INSTANCE.getClass();
        AppletApplication r111 = AppletAppManagerService.a(r16);
        if ((r111 instanceof OnlineAppletApplication) == false) goto L22;
        OnlineAppletApplication r10 = (OnlineAppletApplication) r111;
    L23:
        if (r10 != null) goto L26;
        this.d.a("onCreateView: app is null, appId = ".concat(r16), null);
        U90("app is null, appId = ".concat(r16), AppletErrorCode.LYNX_VIEW_CREATE_ERROR.getType());
        return null;
    L26:
        Page r11 = r10.j().q(this.f);
        if (r11 != null) goto L30;
        this.d.a("onCreateView: page is null, url = " + this.f, null);
        U90("page is null, url = " + this.f, AppletErrorCode.PAGE_NOT_FOUND.getType());
        return null;
    L30:
        PageChatConfig r112 = r11.getChatConfig();
        if (r112 != null) goto L33;
    L35:
        this.h = r18;
        FrameLayout r113 = new FrameLayout(requireContext());
        r113.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AppletPageFragment$loadLynxView$1(this, r11, r10, r113, null), 3, null);
        return r113;
    L33:
        if (r112.getEnabled() != true) goto L35;
        r18 = true;
        goto L35
    L22:
        r10 = null;
        goto L23
    L13:
        if (r16.length() == 0) goto L16;
        r110 = false;
    L37:
        this.d.a("onCreateView: url or appId is null", null);
        U90("url or appId is null", AppletErrorCode.LYNX_VIEW_CREATE_ERROR.getType());
        return null;
    L5:
        if (r17.length() == 0) goto L8;
        r19 = false;
        goto L10
    }
}
