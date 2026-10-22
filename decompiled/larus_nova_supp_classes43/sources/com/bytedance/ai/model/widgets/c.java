package com.bytedance.ai.model.widgets;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.core.os.HandlerCompat;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.Page;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.PageStatus;
import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMapKeySetIterator;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class c implements k2.j {
    public static final a Companion = null;
    private static final String TAG = "AIContainerViewBase";
    private final String _renderType;
    private final AppletRuntime appletRuntime;
    private HashMap<String, Object> eventCommonParams;
    private boolean isPageLoadFinish;
    private final Lazy mMainHandler$delegate;
    private final String pageId;
    private PageInfo pageInfo;
    private PageStatus pageStatus;
    private boolean pendingOnShow;
    private KClass<?> renderClass;
    private String selectionContent;
    private String uiContext;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        public final void a() {
            if (this.a.getPageStatus() == PageStatus.RE_CREATE) goto L5;
            AppletRuntimeManager r0 = AppletRuntimeManager.INSTANCE;
            String r1 = this.a.getPageID();
            r0.getClass();
            AppletRuntimeManager.m(r1);
        L5:
            AppletRuntime r10 = this.a.getAppletRuntime();
            r10.h.g();
            r10.f();
            this.a.setPageStatus(PageStatus.DESTROY);
            d3.b0 r11 = this.a.getAIBridge();
            if (r11 == null) goto L9;
            JsonObject r12 = new JsonObject();
            r12.addProperty("eventName", this.a.getPageInfo().toViewContext());
            Unit r13 = Unit.INSTANCE;
            r11.a("onDestroy", r12);
            return;
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

    /* JADX INFO: renamed from: com.bytedance.ai.model.widgets.c$c, reason: collision with other inner class name */
    public static final class C0044c implements k5.j {
        public final /* synthetic */ c a;

        public C0044c(c r1) {
            this.a = r1;
        }

        @Override // k5.j
        public final void a(AppletMonitorableEvent r10) {
            Intrinsics.checkNotNullParameter(r10, "event");
            r10.f = this.a.getAppletRuntime().h.b;
            r10.g = this.a.getAppletRuntime().h.o();
            r10.f("renderType", this.a.getRenderType());
            r10.h(this.a.getPageInfo().buildMonitorEvent());
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ Handler f() {
        return mMainHandler_delegate$lambda$1();
    }

    public static /* synthetic */ void g(c r0) {
        onViewFinish$lambda$8(r0);
    }

    @Override // k2.k
    public k2.m getContainerViewService() {
        return null;
    }

    @Override // k2.j
    public k2.t getFloatingSpeakerController() {
        return null;
    }

    @Override // k2.j
    public void handleContentSizeChange(double r1, double r10) {
    }

    @Override // k2.o
    public void handleWebViewDrawEnd(long r1, long r10) {
    }

    public void onFocusChange(boolean r1) {
    }

    public void sendUIAction(String r10) {
        Intrinsics.checkNotNullParameter(r10, "action");
    }

    @Override // k2.j
    public void setFloatingSpeakerController(k2.t r1) {
    }

    private final Handler getMMainHandler() {
        return (Handler) this.mMainHandler$delegate.getValue();
    }

    private static final Handler mMainHandler_delegate$lambda$1() {
        return new Handler(Looper.getMainLooper());
    }

    @Override // k2.j
    public void doRefresh() {
        if (f2.k.b == false) goto L6;
        AppletRuntime r0 = this.appletRuntime;
        AtomicInteger r1 = AppletRuntime.x;
        r0.B(null, null);
        return;
    }

    @Override // k2.i
    public String getAppletId() {
        return this.appletRuntime.h.K;
    }

    @Override // k2.i
    public void onDestroy() {
        com.bytedance.ai.utils.g.a.i(TAG, "onDestroy");
        this.isPageLoadFinish = false;
        getMMainHandler().removeCallbacksAndMessages(this);
        HandlerCompat.postDelayed(getMMainHandler(), new b(this), this, 100);
    }

    @Override // k2.i
    public void onHostDestroy() {
        com.bytedance.ai.utils.g.a.i(TAG, "onHostDestroy");
    }

    @Override // k2.i
    public void onHostHide() {
        com.bytedance.ai.utils.g.a.i(TAG, "onHostHide");
    }

    @Override // k2.i
    public void onHostShow() {
        com.bytedance.ai.utils.g.a.i(TAG, "onHostShow");
    }

    @Override // k2.i
    public String getBotId() {
        return getPageInfo().getBotId();
    }

    @Override // k2.i
    public void onHide() {
        getMMainHandler().removeCallbacksAndMessages(this);
        com.bytedance.ai.utils.g.a.i(TAG, "onHide");
        this.pendingOnShow = false;
        this.pageStatus = PageStatus.INVISIABLE;
        d3.b0 r0 = getAIBridge();
        if (r0 == null) goto L6;
        JsonObject r1 = new JsonObject();
        r1.addProperty("eventName", getPageInfo().toViewContext());
        Unit r10 = Unit.INSTANCE;
        r0.a("onHide", r1);
        return;
    }

    @Override // k2.i
    public void onShow() {
        getMMainHandler().removeCallbacksAndMessages(this);
        com.bytedance.ai.utils.g r0 = com.bytedance.ai.utils.g.a;
        r0.i(TAG, "onShow");
        this.pageStatus = PageStatus.VISIABLE;
        if (this.isPageLoadFinish == true) goto L6;
        this.pendingOnShow = true;
        return;
    L6:
        r0.d(TAG, "widget " + getPageID() + " onShow send");
        d3.b0 r1 = getAIBridge();
        if (r1 == null) goto L10;
        JsonObject r10 = new JsonObject();
        r10.addProperty("eventName", getPageInfo().toViewContext());
        Unit r11 = Unit.INSTANCE;
        r1.a("onShow", r10);
        return;
    }

    @Override // k2.j
    public String viewContext() {
        getPageInfo().setPageId(getPageID());
        return getPageInfo().toViewContext();
    }

    @Override // k2.j
    public final AppletRuntime getAppletRuntime() {
        return this.appletRuntime;
    }

    @Override // k2.i
    public HashMap<String, Object> getEventCommonParams() {
        return this.eventCommonParams;
    }

    @Override // k2.i
    public String getPageID() {
        return this.pageId;
    }

    @Override // k2.j
    public PageInfo getPageInfo() {
        return this.pageInfo;
    }

    public final PageStatus getPageStatus() {
        return this.pageStatus;
    }

    @Override // k2.k
    public KClass<?> getRenderClass() {
        return this.renderClass;
    }

    public String getRenderType() {
        return this._renderType;
    }

    public final String selectionContent() {
        return this.selectionContent;
    }

    public final String uiContext() {
        return this.uiContext;
    }

    private static final void onViewFinish$lambda$8(c r10) {
        d3.w r0 = r10.appletRuntime.u();
        if (r0 == null) goto L6;
        JsonObject r11 = new JsonObject();
        r11.addProperty("viewId", r10.getPageID());
        Unit r12 = Unit.INSTANCE;
        r0.a("onPageOpened", r11);
    L6:
        if (r10.pendingOnShow == false) goto L11;
        d3.b0 r1 = r10.getAIBridge();
        if (r1 == null) goto L12;
        JsonObject r13 = new JsonObject();
        r13.addProperty("viewId", r10.getPageID());
        r13.addProperty("eventName", r10.getPageInfo().toViewContext());
        Unit r14 = Unit.INSTANCE;
        r1.a("onShow", r13);
        return;
    L12:
        return;
    }

    private final void reportAppletEvent(String r10) {
        com.bytedance.ai.monitor.b.d(r10, new C0044c(this));
    }

    public final String getTargetUrl(PageInfo r10) {
        Intrinsics.checkNotNullParameter(r10, "pageInfo");
        String r0 = r10.getPageUrl();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return r0;
    L12:
        return getLoadUrl(r0, r10.getPageSettings());
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    @Override // k2.i
    public void onViewError(String r10) {
        com.bytedance.ai.utils.g.a.i(TAG, "onViewError");
        this.pageStatus = PageStatus.LOADING_ERROR;
    }

    @Override // k2.i
    public void onViewFinish(String r10) {
        com.bytedance.ai.utils.g.a.i(TAG, "onViewFinish");
        this.isPageLoadFinish = true;
        this.pageStatus = PageStatus.LOADING_FINISH;
        p2.c.e(new com.bytedance.ai.model.widgets.a(this), 100);
        reportAppletEvent("applet_view_load_finish");
    }

    @Override // k2.i
    public void onViewStart(String r10) {
        com.bytedance.ai.utils.g.a.i(TAG, "onViewStart");
        this.isPageLoadFinish = false;
        this.pageStatus = PageStatus.LOADING_START;
        reportAppletEvent("applet_view_start");
    }

    @Override // k2.i
    public void setEventCommonParams(HashMap<String, Object> r1) {
        this.eventCommonParams = r1;
    }

    public void setPageInfo(PageInfo r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.pageInfo = r10;
    }

    public final void setPageStatus(PageStatus r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.pageStatus = r10;
    }

    public void setRenderClass(KClass<?> r1) {
        this.renderClass = r1;
    }

    public void setSelectionContent(String r10) {
        Intrinsics.checkNotNullParameter(r10, "selection");
        if (r10.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.selectionContent = r10;
        String r11 = this.appletRuntime.h.N;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r1 = AppletRuntimeManager.d;
        if (r1 == null) goto L15;
        if (r11 == null) goto L12;
        String r12 = x4.a.a(r11);
    L13:
        r1.k(r12, r11);
        return;
    L12:
        r12 = null;
        goto L13
    L15:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // k2.j
    public void setUiContext(String r10) {
        this.uiContext = r10;
        String r0 = getPageInfo().getMessageId();
        if (r0 == null) goto L7;
        r4.h r1 = r4.a.l;
        if (r1 == null) goto L7;
        r1.b(r0, r10);
    L7:
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r11 = AppletRuntimeManager.d;
        if (r11 == null) goto L15;
        String r12 = this.appletRuntime.h.N;
        if (r12 == null) goto L12;
        String r13 = x4.a.a(r12);
    L13:
        r11.k(r13, this.appletRuntime.h.N);
        return;
    L12:
        r13 = null;
        goto L13
    }

    public c(AppletRuntime r10, PageInfo r11) {
        Intrinsics.checkNotNullParameter(r10, "appletRuntime");
        Intrinsics.checkNotNullParameter(r11, "pageInfo");
        this.appletRuntime = r10;
        this.pageInfo = r11;
        Companion.getClass();
        String r12 = UUID.randomUUID().toString();
        getPageInfo().setPageId(r12);
        this.pageId = r12;
        this.mMainHandler$delegate = LazyKt.lazy(new com.bytedance.ai.model.widgets.b());
        this.pageStatus = PageStatus.NONE;
        List<Page> r13 = r10.h.L;
        Page r14 = null;
        Object r15 = null;
        if (r13 == null) goto L11;
        Iterator<T> r16 = r13.iterator();
    L6:
        if (r16.hasNext() == false) goto L10;
        Object r0 = r16.next();
        if (Intrinsics.areEqual(((Page) r0).pageId(), getPageInfo().getPageName()) == false) goto L6;
        r15 = r0;
    L10:
        r14 = (Page) r15;
    L11:
        if (r14 == null) goto L14;
        String r17 = r14.getRenderType();
        if (r17 == null) goto L14;
    L15:
        this._renderType = r17;
        AppletRuntimeManager.INSTANCE.getClass();
        Intrinsics.checkNotNullParameter(this, AIStateLogRequest.SOURCE_PAGE);
        AppletRuntimeManager.b.put(getPageID(), this);
        Iterator<T> r18 = AppletRuntimeManager.g.iterator();
    L17:
        if (r18.hasNext() == false) goto L19;
        ((AppletRuntimeManager.b) r18.next()).b();
        goto L17
    L19:
        this.pageStatus = PageStatus.STARTED;
        reportAppletEvent("applet_create_container");
        return;
    L14:
        r17 = this.appletRuntime.h.o;
        goto L15
    }

    private final String getLoadUrl(String r10, ReadableMap r11) {
        AtomicBoolean r0 = f2.b.a;
        h2.a r1 = f2.b.c;
        boolean r12 = false;
        if (r1 != null) goto L5;
    L7:
        if (r12 == false) goto L9;
        return r10;
    L9:
        if (r11 == null) goto L17;
        Uri.Builder r13 = UriProtector.parse(r10).buildUpon();
        ReadableMapKeySetIterator r14 = r11.keySetIterator();
    L12:
        if (r14.hasNextKey() == false) goto L15;
        String r15 = r14.nextKey();
        r13.appendQueryParameter(r15, r11.getString(r15));
        goto L12
    L15:
        return r13.build().toString();
    L17:
        return r10;
    L5:
        if (r1.j != true) goto L7;
        r12 = true;
        goto L7
    }

    public View createPage(PageInfo r1, Context r10, Function1<? super Integer, Unit> r11, Function1<? super String, Unit> r12) {
        Intrinsics.checkNotNullParameter(r1, "pageInfo");
        AppletRuntime r13 = this.appletRuntime;
        r13.h.e();
        r13.g();
        com.bytedance.ai.utils.g.a.i(TAG, "onHostCreate");
        return null;
    }

    public static /* synthetic */ String getLoadUrl$default(c r0, String r1, ReadableMap r10, int r11, Object r12) {
        if (r12 != null) goto L9;
        if ((r11 & 2) == 0) goto L7;
        r10 = null;
    L7:
        return r0.getLoadUrl(r1, r10);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLoadUrl");
    }
}
