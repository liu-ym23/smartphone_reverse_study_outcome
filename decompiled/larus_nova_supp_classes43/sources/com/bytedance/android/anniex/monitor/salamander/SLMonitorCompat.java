package com.bytedance.android.anniex.monitor.salamander;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import com.bytedance.android.monitorV2.webview.ttweb.TTUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.salamander.anniex.AccessLayerStringField;
import com.bytedance.salamander.anniex.SLAnnieXMonitor;
import com.bytedance.salamander.anniex.SLContainerErrorCode;
import com.bytedance.salamander.anniex.SLContainerTiming;
import com.bytedance.salamander.anniex.SLEndToEndErrorCode;
import com.bytedance.salamander.anniex.SLEndToEndStage;
import com.bytedance.salamander.anniex.SLEndToEndStatus;
import com.bytedance.salamander.anniex.i1;
import com.bytedance.salamander.anniex.i5;
import com.bytedance.salamander.anniex.i7;
import com.bytedance.salamander.anniex.k7;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxView;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class SLMonitorCompat {
    public static final SLMonitorCompat a = null;
    public static boolean b;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/anniex/monitor/salamander/SLMonitorCompat$ContainerType;", "", "", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Lynx", "Web", "Unknown", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final enum ContainerType extends Enum<ContainerType> {
        public static final ContainerType Lynx = null;
        public static final ContainerType Unknown = null;
        public static final ContainerType Web = null;
        public static final /* synthetic */ ContainerType[] a = null;
        private final String value;

        public static ContainerType valueOf(String r1) {
            return (ContainerType) r27.a.a(ContainerType.class, r1);
        }

        public static ContainerType[] values() {
            return (ContainerType[]) a.clone();
        }

        static {
            ContainerType r0 = new ContainerType("Lynx", 0, "lynx");
            Lynx = r0;
            ContainerType r1 = new ContainerType("Web", 1, "webview");
            Web = r1;
            ContainerType r10 = new ContainerType("Unknown", 2, "unknown");
            Unknown = r10;
            a = new ContainerType[]{r0, r1, r10};
        }

        public final String getValue() {
            return this.value;
        }

        public ContainerType(String r1, int r10, String r11) {
            super(r1, r10);
            this.value = r11;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/anniex/monitor/salamander/SLMonitorCompat$NativeErrorScene;", "", "", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "WebError", "WebProcessTerminate", "LynxError", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final enum NativeErrorScene extends Enum<NativeErrorScene> {
        public static final NativeErrorScene LynxError = null;
        public static final NativeErrorScene WebError = null;
        public static final NativeErrorScene WebProcessTerminate = null;
        public static final /* synthetic */ NativeErrorScene[] a = null;
        private final String value;

        public static NativeErrorScene valueOf(String r1) {
            return (NativeErrorScene) r27.a.a(NativeErrorScene.class, r1);
        }

        public static NativeErrorScene[] values() {
            return (NativeErrorScene[]) a.clone();
        }

        static {
            NativeErrorScene r0 = new NativeErrorScene("WebError", 0, "web_error");
            WebError = r0;
            NativeErrorScene r1 = new NativeErrorScene("WebProcessTerminate", 1, "web_process_terminate");
            WebProcessTerminate = r1;
            NativeErrorScene r10 = new NativeErrorScene("LynxError", 2, "lynx_error");
            LynxError = r10;
            a = new NativeErrorScene[]{r0, r1, r10};
        }

        public final String getValue() {
            return this.value;
        }

        public NativeErrorScene(String r1, int r10, String r11) {
            super(r1, r10);
            this.value = r11;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/anniex/monitor/salamander/SLMonitorCompat$ViewType;", "", "", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Card", "Popup", "Page", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final enum ViewType extends Enum<ViewType> {
        public static final ViewType Card = null;
        public static final ViewType Page = null;
        public static final ViewType Popup = null;
        public static final /* synthetic */ ViewType[] a = null;
        private final String value;

        public static ViewType valueOf(String r1) {
            return (ViewType) r27.a.a(ViewType.class, r1);
        }

        public static ViewType[] values() {
            return (ViewType[]) a.clone();
        }

        static {
            ViewType r0 = new ViewType("Card", 0, "card");
            Card = r0;
            ViewType r1 = new ViewType("Popup", 1, com.bytedance.android.ec.core.event.a.VALUE_SHOW_POPUP);
            Popup = r1;
            ViewType r10 = new ViewType("Page", 2, AIStateLogRequest.SOURCE_PAGE);
            Page = r10;
            a = new ViewType[]{r0, r1, r10};
        }

        public final String getValue() {
            return this.value;
        }

        public ViewType(String r1, int r10, String r11) {
            super(r1, r10);
            this.value = r11;
        }
    }

    public static final class a implements Runnable {
        public final /* synthetic */ WebView a;
        public final /* synthetic */ SLAnnieXMonitor b;

        public a(WebView r1, SLAnnieXMonitor r10) {
            this.a = r1;
            this.b = r10;
        }

        public final void a() {
            SLMonitorCompat r0 = SLMonitorCompat.a;
            WebView r1 = this.a;
            r0.getClass();
            String r10 = "";
            String r11 = r1.getSettings().getUserAgentString();     // Catch: Throwable -> L15
            if (r11 != null) goto L6;
            r11 = "";
        L6:
            int r12 = StringsKt.indexOf$default(r11, "Chrome/", 0, false, 6, null);     // Catch: Throwable -> L15
            if (r12 == (-1)) goto L9;
            r12 = r12 + 7;     // Catch: Throwable -> L15
        L9:
            List r13 = StringsKt.split$default(r11.substring(r12), new String[]{" "}, false, 0, 6, null);     // Catch: Throwable -> L15
            if ((!r13.isEmpty()) == false) goto L13;
            r10 = (String) ListProtector.get(r13, 0);     // Catch: Throwable -> L15
        L13:
            String r14 = com.bytedance.android.anniex.monitor.salamander.a.a;
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            com.bytedance.android.anniex.monitor.salamander.a.c = r10;
            this.b.h(AccessLayerStringField.WebEngineVersion, r10);
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

    public static final class b implements Runnable {
        public final /* synthetic */ WebView a;
        public final /* synthetic */ SLAnnieXMonitor b;

        public b(WebView r1, SLAnnieXMonitor r10) {
            this.a = r1;
            this.b = r10;
        }

        public final void a() {
            Lazy r0 = TTUtils.a;
            WebView r1 = this.a;
            boolean r10 = false;
            Method r11 = (Method) TTUtils.c.getValue();     // Catch: Exception -> L7
            if (r11 == null) goto L9;
            Object r12 = r11.invoke(null, new Object[]{r1});     // Catch: Exception -> L7
            Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Boolean");     // Catch: Exception -> L7
            r10 = ((Boolean) r12).booleanValue();     // Catch: Exception -> L7
        L9:
            if (r10 == false) goto L11;
            String r13 = "ttwebview";
        L12:
            String r14 = com.bytedance.android.anniex.monitor.salamander.a.a;
            Intrinsics.checkNotNullParameter(r13, "<set-?>");
            com.bytedance.android.anniex.monitor.salamander.a.b = r13;
            this.b.h(AccessLayerStringField.WebViewType, r13);
            return;
        L11:
            r13 = "system";
        L7:
            e = move-exception;
            com.bytedance.android.monitorV2.util.f.b(e);
            goto L9
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

    static {
        a = new SLMonitorCompat();
    }

    public SLMonitorCompat() {
    }

    private final Activity getActivity(Context r10) {
    L3:
        if (r10 == null) goto L11;
        if ((r10 instanceof Activity) == true) goto L7;
        if ((r10 instanceof ContextWrapper) == false) goto L11;
        r10 = ((ContextWrapper) r10).getBaseContext();
        goto L3
    L7:
        return (Activity) r10;
    L11:
        return null;
    }

    public static void k(jz2.d r10) {
        Intrinsics.checkNotNullParameter(r10, "customInfo");
        if (b == true) goto L5;
        return;
    L5:
        String r0 = r10.b;
        if (r0 != null) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r0, "") == true) goto L13;
        int r1 = i5.a;
        String r11 = r10.c;
        int r12 = r10.k;
        String r13 = r10.b;
        JSONObject r14 = r10.d;
        JSONObject r15 = r10.e;
        JSONObject r16 = r10.f;
        String r17 = r10.a;
        Intrinsics.checkNotNullParameter(r11, "eventName");
        Intrinsics.checkNotNullParameter(r13, "bid");
        i1.a(r11, r13, Integer.valueOf(r12), r14, r15, r16, r17);
        return;
    }

    public static String m(Uri r10) {
        String r0 = r10.getScheme();
        boolean r11 = true;
        if (r0 == null) goto L30;
        int r12 = r0.hashCode();
        if (r12 == (-1772600516)) goto L27;
        if (r12 == 3213448) goto L15;
        if (r12 != 99617003) goto L30;
        if (r0.equals("https") == false) goto L30;
    L17:
        String r13 = r10.getPath();
        if (r13 != null) goto L20;
    L22:
        r11 = false;
    L23:
        if (r11 == false) goto L49;
        return ContainerType.Lynx.getValue();
    L49:
        return ContainerType.Web.getValue();
    L20:
        if (StringsKt.endsWith$default(r13, ".js", false, 2, null) != true) goto L22;
    L15:
        if (r0.equals("http") == true) goto L17;
    L27:
        if (r0.equals("lynxview") == false) goto L30;
        return ContainerType.Lynx.getValue();
    L30:
        String r1 = r10.getHost();
        if (r1 != null) goto L33;
    L35:
        boolean r14 = false;
    L36:
        if (r14 == true) goto L51;
        String r15 = r10.getHost();
        if (r15 != null) goto L41;
    L43:
        r11 = false;
    L44:
        if (r11 == false) goto L47;
        return ContainerType.Web.getValue();
    L47:
        return ContainerType.Lynx.getValue();
    L41:
        if (StringsKt.contains$default(r15, "web", false, 2, null) != true) goto L43;
    L51:
        return ContainerType.Lynx.getValue();
    L33:
        if (StringsKt.contains$default(r1, "lynx", false, 2, null) != true) goto L35;
        r14 = true;
        goto L36
    }

    public final String n(View r10) {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        Activity r11 = getActivity(r10.getContext());     // Catch: Throwable -> L9
        if (r11 == null) goto L6;
        String r12 = r11.getClass().getName();     // Catch: Throwable -> L9
    L7:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r13) == true) goto L15;
        r0 = r13;
    L15:
        String r14 = (String) r0;
        if (r14 != null) goto L21;
        return "";
    L21:
        return r14;
    L6:
        r12 = null;
    L9:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public static void c(String r1, Function1 r10) {
        Intrinsics.checkNotNullParameter(r1, "sessionId");
        Intrinsics.checkNotNullParameter(r10, "block");
        if (b == true) goto L5;
        return;
    L5:
        r10.invoke(c.a.a(r1));
    }

    public static void d(String r1, SLEndToEndStage r10) {
        Intrinsics.checkNotNullParameter(r1, "sessionId");
        Intrinsics.checkNotNullParameter(r10, "stage");
        if (b == true) goto L5;
        return;
    L5:
        c.a.a(r1).l(r10);
    }

    public static void f(String r10, LynxView r11) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        Intrinsics.checkNotNullParameter(r11, "lynxView");
        if (b == true) goto L5;
        return;
    L5:
        SLAnnieXMonitor r12 = c.a.a(r10);
        r12.h(AccessLayerStringField.ContainerType, ContainerType.Lynx.getValue());
        if (Intrinsics.areEqual(com.bytedance.android.anniex.monitor.salamander.a.a, "unknown") == false) goto L8;
        String r0 = LynxEnv.inst().getLynxVersion();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        com.bytedance.android.anniex.monitor.salamander.a.a = r0;
    L8:
        r12.h(AccessLayerStringField.LynxVersion, com.bytedance.android.anniex.monitor.salamander.a.a);
        r12.h(AccessLayerStringField.NativePage, a.n(r11));
    }

    public static void i(String r10, WebView r11) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        Intrinsics.checkNotNullParameter(r11, "webView");
        if (b == true) goto L5;
        return;
    L5:
        SLAnnieXMonitor r12 = c.a.a(r10);
        r12.h(AccessLayerStringField.ContainerType, ContainerType.Web.getValue());
        if (Intrinsics.areEqual(com.bytedance.android.anniex.monitor.salamander.a.c, "unknown") == false) goto L8;
    L11:
        com.bytedance.android.monitorV2.executor.a.c(new a(r11, r12));
    L13:
        if (Intrinsics.areEqual(com.bytedance.android.anniex.monitor.salamander.a.b, "unknown") == false) goto L15;
        com.bytedance.android.monitorV2.executor.a.c(new b(r11, r12));
    L16:
        r12.h(AccessLayerStringField.NativePage, a.n(r11));
        return;
    L15:
        r12.h(AccessLayerStringField.WebViewType, com.bytedance.android.anniex.monitor.salamander.a.b);
        goto L16
    L8:
        if (StringsKt.isBlank(com.bytedance.android.anniex.monitor.salamander.a.c) == true) goto L11;
        r12.h(AccessLayerStringField.WebEngineVersion, com.bytedance.android.anniex.monitor.salamander.a.c);
        goto L13
    }

    public static void j(View r1, jz2.d r10) {
        Intrinsics.checkNotNullParameter(r10, "customInfo");
        if (b == true) goto L6;
        return;
    L6:
        if (r10.c != null) goto L8;
        return;
    L8:
        String r0 = r10.i;
        if (r0 == null) goto L12;
    L18:
        if (r0 == null) goto L21;
        l(r0, r10);
        return;
    L21:
        if (r10.b == null) goto L25;
        k(r10);
        return;
    L25:
        return;
    L12:
        if ((r1 instanceof WebView) == false) goto L15;
        sz2.a r11 = sz2.a.a;
        r0 = (String) CollectionsKt.first(sz2.a.d(r1));
        goto L18
    L15:
        if ((r1 instanceof LynxView) == false) goto L17;
        sz2.a r12 = sz2.a.a;
        r0 = (String) CollectionsKt.first(sz2.a.d(r1));
        goto L18
    L17:
        r0 = null;
        goto L18
    }

    public static void l(String r10, jz2.d r11) {
        Intrinsics.checkNotNullParameter(r11, "customInfo");
        if (b == true) goto L5;
        return;
    L5:
        if (r10 != null) goto L7;
        return;
    L7:
        int r0 = i5.a;
        String r1 = r11.c;
        int r12 = r11.k;
        JSONObject r13 = r11.d;
        JSONObject r14 = r11.e;
        JSONObject r15 = r11.f;
        String r16 = r11.a;
        String r17 = r11.b;
        Intrinsics.checkNotNullParameter(r1, "eventName");
        Intrinsics.checkNotNullParameter(r10, "containerId");
        i1.b(r1, r10, Integer.valueOf(r12), r13, r14, r15, r16, r17);
    }

    public static void o(String r1, i7 r10) {
        Intrinsics.checkNotNullParameter(r1, "sessionId");
        Intrinsics.checkNotNullParameter(r10, "eventInfo");
        if (b == true) goto L5;
        return;
    L5:
        c.a.a(r1).D(r10);
    }

    public static void r(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        if (b == true) goto L5;
        return;
    L5:
        Uri r12 = UriProtector.parse(r11);
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        if (b == false) goto L17;
        String r0 = com.bytedance.android.anniex.utils.c.getType(r12);
        if (Intrinsics.areEqual(r0, "_popup") == false) goto L12;
        String r1 = ViewType.Popup.getValue();
    L15:
        q(r10, r12, m(r12), r1);
        return;
    L12:
        if (Intrinsics.areEqual(r0, "_page") == false) goto L14;
        r1 = ViewType.Page.getValue();
        goto L15
    L14:
        r1 = ViewType.Card.getValue();
        goto L15
    }

    public static void a(View r1, String r10, Object r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        if (b == true) goto L6;
        return;
    L6:
        if ((r1 instanceof WebView) == false) goto L9;
        sz2.a r0 = sz2.a.a;
        String r12 = (String) CollectionsKt.firstOrNull(sz2.a.d(r1));
    L12:
        if (r12 == null) goto L15;
        SLMonitorCompat r13 = a;
        String r14 = r11.toString();
        r13.getClass();
        b(r12, r10, r14);
        return;
    L15:
        return;
    L9:
        if ((r1 instanceof LynxView) == false) goto L11;
        sz2.a r15 = sz2.a.a;
        r12 = (String) CollectionsKt.firstOrNull(sz2.a.d(r1));
        goto L12
    L11:
        r12 = null;
        goto L12
    }

    public static void b(String r1, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r1, "sessionId");
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        if (b == true) goto L5;
        return;
    L5:
        c.a.a(r1).f(r10, r11);
    }

    public static void g(String r1, SLContainerTiming r10, long r11) {
        Intrinsics.checkNotNullParameter(r1, "sessionId");
        Intrinsics.checkNotNullParameter(r10, "key");
        if (b == true) goto L5;
        return;
    L5:
        c.a.a(r1).p(r10, r11);
    }

    public static void h(String r1, long r10, String r11) {
        Intrinsics.checkNotNullParameter(r1, "sessionId");
        Intrinsics.checkNotNullParameter(r11, "resFrom");
        if (b == true) goto L5;
        return;
    L5:
        SLAnnieXMonitor r12 = c.a.a(r1);
        r12.h(AccessLayerStringField.GeckoId, String.valueOf(r10));
        String r13 = "unknown";
        switch(r11.hashCode()) {
            case -1994413639: goto L35;
            case -1848962670: goto L31;
            case -1785310379: goto L27;
            case -1548612125: goto L22;
            case -318613945: goto L20;
            case -284840886: goto L18;
            case 98349: goto L15;
            case 98230121: goto L12;
            case 230943795: goto L9;
            default: goto L38;
        };
    L12:
        String r14 = "gecko";
        if (r11.equals("gecko") == false) goto L38;
    L25:
        r13 = r14;
        goto L38
    L15:
        r14 = "cdn";
        if (r11.equals("cdn") == true) goto L25;
    L18:
        r11.equals("unknown");
        goto L38
    L22:
        r14 = "offline";
        if (r11.equals("offline") == true) goto L25;
    L38:
        r12.h(AccessLayerStringField.TemplateResType, r13);
        return;
    L9:
        if (r11.equals("buildIn") == false) goto L38;
        r13 = "builtin";
        goto L38
    L20:
        if (r11.equals("externalTemplateBundle") == false) goto L38;
    L37:
        r13 = "template_bundle";
        goto L38
    L27:
        if (r11.equals("cdnCache") == false) goto L38;
        r13 = "cdn_cache";
        goto L38
    L31:
        if (r11.equals("geckoUpdate") == false) goto L38;
        r13 = "gecko_update";
        goto L38
    L35:
        if (r11.equals("internalTemplateBundle") == true) goto L37;
        goto L37
    }

    public static void p(String r1, Uri r10, String r11) {
        Intrinsics.checkNotNullParameter(r1, "sessionId");
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "viewType");
        if (b == true) goto L5;
        return;
    L5:
        q(r1, r10, m(r10), r11);
    }

    public static void q(String r1, final Uri r10, final String r11, final String r12) {
        Intrinsics.checkNotNullParameter(r1, "sessionId");
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r11, "containerType");
        if (b == true) goto L5;
        return;
    L5:
        Function0<Map<AccessLayerStringField, String>> r0 = new SLMonitorCompat$reportPV$fieldsMaker$1(r10, r11, r12);
        c.a.a(r1).E(new k7(), r0);
    }

    public static void e(String r1, SLEndToEndStage r10, SLEndToEndStatus r11, SLEndToEndErrorCode r12, String r13) {
        Intrinsics.checkNotNullParameter(r1, "sessionId");
        Intrinsics.checkNotNullParameter(r10, "stage");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_STATUS);
        if (b == true) goto L5;
        return;
    L5:
        if (r12 == null) goto L15;
        if (r13 == null) goto L15;
        if (r10 != SLEndToEndStage.LoadContainerFail) goto L14;
        SLAnnieXMonitor r14 = c.a.a(r1);
        if (StringsKt.contains$default(r13, "uri parse failed", false, 2, null) == false) goto L12;
        SLContainerErrorCode r15 = SLContainerErrorCode.Schema;
    L13:
        r14.j(r13, r15);
        return;
    L12:
        r15 = SLContainerErrorCode.Common;
        goto L13
    L14:
        c.a.a(r1).k(r10, r11, r12, r13);
        return;
    L15:
        c.a.a(r1).i(r10, r11);
    }

    public static void s(SLMonitorCompat r10, String r11, String r12, String r13, int r14) {
        if ((r14 & 2) == 0) goto L6;
        r12 = null;
    L6:
        if ((r14 & 4) == 0) goto L8;
        r13 = null;
    L8:
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "sessionId");
        if (b == false) goto L13;
        c.a.a(r11).G(new k7(), r13, r12);
        return;
    }
}
