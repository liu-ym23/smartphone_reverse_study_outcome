package com.bytedance.android.btm.api.inner;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.View;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmPageLifecycle;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.btm.api.model.j;
import com.bytedance.android.btm.api.model.k;
import com.bytedance.android.btm.api.model.m;
import com.bytedance.android.btm.api.model.o;
import com.bytedance.android.btm.api.model.p;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;
import zc.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements com.bytedance.android.btm.api.inner.e {
    public static final C0107a a = null;
    public static final e b = null;
    public static final d c = null;
    public static final f d = null;
    public static final c e = null;
    public static final b f = null;
    public static final a g = null;

    /* JADX INFO: renamed from: com.bytedance.android.btm.api.inner.a$a, reason: collision with other inner class name */
    public static final class C0107a implements com.bytedance.android.btm.api.inner.d {
        public C0107a() {
        }

        public void onEventV1(j r1) {
        }

        public void onEventV3(k r1) {
        }
    }

    public static final class b implements i {
        public b() {
        }

        public final void callback() {
        }
    }

    public static final class c implements com.bytedance.android.btm.api.c {
        public c() {
        }
    }

    public static final class d implements BtmPageLifecycle {
        public d() {
        }

        @Override // com.bytedance.android.btm.api.BtmPageLifecycle
        public final void a(Object r1) {
        }

        @Override // com.bytedance.android.btm.api.BtmPageLifecycle
        public final void b(Object r1, boolean r10) {
        }

        @Override // com.bytedance.android.btm.api.BtmPageLifecycle
        public final void c(Object r1, BtmPageLifecycle.State r10) {
        }

        @Override // com.bytedance.android.btm.api.BtmPageLifecycle
        public final boolean d(Object r1, boolean r10) {
            return false;
        }

        @Override // com.bytedance.android.btm.api.BtmPageLifecycle
        public final void e(Object r1, Boolean r10, m r11) {
        }

        @Override // com.bytedance.android.btm.api.BtmPageLifecycle
        public final BtmPageLifecycle.State f(Object r1) {
            return null;
        }

        @Override // com.bytedance.android.btm.api.BtmPageLifecycle
        public final void g(Object r1, Boolean r10, o r11) {
        }
    }

    public static final class e implements com.bytedance.android.btm.api.inner.g {
        public e() {
        }

        public final void a(int r1, String r10, Object r11, Throwable r12, boolean r13) {
        }

        public final void b(boolean r1, Function0<? extends Object> r10) {
        }

        public final void c(int r1, String r10, Object r11, Throwable r12, boolean r13, Function1<? super JSONObject, Unit> r14) {
        }
    }

    public static final class f implements com.bytedance.android.btm.api.g {
        public f() {
        }

        public final void a(Runnable r1, boolean r10) {
        }

        public final void b(Runnable r1, boolean r10) {
        }
    }

    public static final class g implements com.bytedance.android.btm.api.k {
        public g() {
        }

        @Override // com.bytedance.android.btm.api.k
        public final void a(String r1, View r10, String r11, String r12) {
        }
    }

    public a() {
    }

    public final void checkEventParam(j r1) {
    }

    public final boolean checkPageBtmFormat(String r1, String r10, boolean r11, String r12, String r13) {
        return true;
    }

    public final String createBtmId(com.bytedance.android.btm.api.model.c r1) {
        return "";
    }

    public final String createExternalEvokeBtmToken(String r1, String r10, BcmParams r11) {
        return null;
    }

    public final String createJumpSourceBtmToken(com.bytedance.android.btm.api.model.d r1, boolean r10) {
        return null;
    }

    public final boolean delayEventHook() {
        return false;
    }

    public final boolean enableDeepLinkProcess(String r1) {
        return false;
    }

    public final boolean enableRouterMonitor() {
        return false;
    }

    public final boolean fixBcmValueNotConvert() {
        return false;
    }

    public final boolean fixSourceTokenError() {
        return false;
    }

    public final com.bytedance.android.btm.api.inner.b getALogWriter() {
        return null;
    }

    public final com.bytedance.android.btm.api.model.e getBtmPageInfo(PageFinder r1) {
        return null;
    }

    public final Object getCurrentResumedPage() {
        return null;
    }

    public final Object getLastCreatedPage() {
        return null;
    }

    public final String getLastPageBtm() {
        return null;
    }

    public final com.bytedance.android.btm.api.inner.f getLogWriter() {
        return null;
    }

    public final String getPageId(PageFinder r1) {
        return null;
    }

    public final Object getReportParamsByKey(String r1, String r10, PageFinder r11) {
        return null;
    }

    public final void init() {
    }

    public final boolean isHybridContainer(View r1) {
        return false;
    }

    public final void minimizeInit(Application r1) {
    }

    public final boolean onEventHook(Context r1, String r10, String r11, String r12, Long r13, Long r14, Boolean r15, JSONObject r16, boolean r17) {
        return false;
    }

    public final void onLowMemory() {
    }

    public final void onRegisterHybridContainer(com.bytedance.android.btm.api.i r1) {
    }

    public final void onRegisterPage(com.bytedance.android.btm.api.d r1) {
    }

    public final void onRegisterPage(com.bytedance.android.btm.api.e r1) {
    }

    public final void onUnregisterPage(com.bytedance.android.btm.api.e r1) {
    }

    public final boolean processEventModel(j r1) {
        return false;
    }

    public final boolean registerBtmPage(View r1, String r10, String r11, Map<String, ? extends Object> r12) {
        return false;
    }

    public final void registerBtmPageCallback(bd.b r1) {
    }

    public final void registerEventChecker(com.bytedance.android.btm.api.model.i r1) {
    }

    public final boolean registerFEBtmPage(View r1, String r10, String r11, Boolean r12, Map<String, ? extends Object> r13) {
        return false;
    }

    public final void registerPageBtmWithSchemaAsync(String r1, Object r10, String r11, String r12) {
    }

    public final boolean removeBcmChainPageId() {
        return false;
    }

    public final boolean removeSearchTokenC() {
        return false;
    }

    public final boolean removeSourceBtmTokenInQueue(String r1) {
        return false;
    }

    public final void setInitInActivity(Activity r1) {
    }

    public final void setInitTag(String r1) {
    }

    public final void setStartNode(p r1) {
    }

    public final void unregisterBtmPageCallback(bd.b r1) {
    }

    public final void updateBtmPage(Object r1, String r10) {
    }

    public final void updateLazyDataSettings() {
    }

    public final boolean useV2Api() {
        return false;
    }

    public final boolean useV2ApiMall() {
        return false;
    }

    static {
        g = new a();
        a = new C0107a();
        b = new e();
        c = new d();
        d = new f();
        e = new c();
        f = new b();
    }

    public final com.bytedance.android.btm.api.k getHybridContainerLoadSchemaCallback() {
        return new g();
    }

    public final com.bytedance.android.btm.api.inner.d getAppLog() {
        return a;
    }

    public final com.bytedance.android.btm.api.c getLaunchApi() {
        return e;
    }

    public final com.bytedance.android.btm.api.inner.g getMonitor() {
        return b;
    }

    public final BtmPageLifecycle getPageLifecycle() {
        return c;
    }

    public final i getSchemaSettingCallback() {
        return f;
    }

    public final com.bytedance.android.btm.api.g getThreadExecutor() {
        return d;
    }

    public final j addBtmEventParam(j r10) {
        JSONObject r0 = r10.h;
        if (r0 == null) goto L5;
        r0.remove("btm_id");
    L5:
        return r10;
    }

    public final JSONObject createBtmChain(com.bytedance.android.btm.api.model.c r1) {
        return new JSONObject();
    }

    public final k addBtmEventParam(k r10) {
        JSONObject r0 = r10.b;
        if (r0 == null) goto L5;
        r0.remove("btm_id");
    L5:
        return r10;
    }

    public final Map<String, Object> createFullyReportParams(String r1, PageFinder r10) {
        return new LinkedHashMap();
    }

    public final void getPageBtmWithSchemaAsync(String r10, h r11) {
        r11.call("", null);
    }

    public final Map<String, Object> createReportParams(String r1, PageFinder r10, Set<String> r11) {
        return new LinkedHashMap();
    }

    public final Map<String, Object> generateBtmEventParams(String r1, int r10, String r11) {
        return new LinkedHashMap();
    }
}
