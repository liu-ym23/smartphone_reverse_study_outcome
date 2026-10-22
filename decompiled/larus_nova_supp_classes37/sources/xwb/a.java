package xwb;

import android.os.Handler;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.alibaba.fastjson.JSON;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.utils.di.ThreadUtil;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.bridge.Message;
import com.ss.android.lark.officewebview.bridge.Status;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import oxb.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public final OfficeWebView a;
    public final i b;
    public final Scheduler c;
    public final CopyOnWriteArrayList<k> d;
    public final g e;
    public final boolean f;
    public final boolean g;
    public final Map<String, JSONObject> h;
    public volatile xwb.e i;

    /* JADX INFO: renamed from: xwb.a$a, reason: collision with other inner class name */
    public static final class C0204a {
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ String a;
        public final /* synthetic */ a b;

        public b(String r1, a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r14) {
            String r15 = (String) r14;
            Intrinsics.checkNotNullParameter(r15, "it");
            com.ss.android.lark.officesdk.utils.di.j.a("CML_TAG_JSBridge", "jsapi invokeNative start, jsMessage length: " + this.a.length());
            boolean r2 = true;
            if (r15.length() != 0) goto L5;
            boolean r0 = true;
        L7:
            if (r0 == false) goto L11;
            int r16 = h.a;
            h.a(this.b.a, 10002, "message isEmpty");
            zwb.e r17 = new zwb.e("message isEmpty", 2);
            int r1 = com.ss.android.lark.officewebview.util.a.a;
            Intrinsics.checkNotNullParameter(this.b.a, "webView");
            Intrinsics.checkNotNullParameter(r17, "error");
            zwb.a r18 = com.ss.android.lark.officewebview.util.a.C0081a.a();
            if (r18 == null) goto L134;
            r18.N();
        L134:
            return Unit.INSTANCE;
        L11:
            xwb.e r3 = this.b.i;
            String r6 = this.a;
            r3.getClass();
            Intrinsics.checkNotNullParameter(r6, "data");
            Message r10 = (Message) JSON.parseObject(r6, Message.class);
            if (r15.length() <= 2097152) goto L16;
            int r4 = h.a;
            h.b(this.b.a, 10007, "apiName = " + r10.getApiName() + " and message.length = " + r15.length() + ", is larger than TRANSFER_MAX_SIZE", r10.getApiName());
            StringBuilder r7 = new StringBuilder("message.length = ");
            r7.append(r15.length());
            r7.append(", is larger than TRANSFER_MAX_SIZE");
            zwb.e r5 = new zwb.e(r7.toString(), r10.getApiName());
            int r19 = com.ss.android.lark.officewebview.util.a.a;
            Intrinsics.checkNotNullParameter(this.b.a, "webView");
            Intrinsics.checkNotNullParameter(r5, "error");
            zwb.a r110 = com.ss.android.lark.officewebview.util.a.C0081a.a();
            if (r110 == null) goto L16;
            r110.N();
        L16:
            xwb.e r111 = this.b.i;
            OfficeWebView r8 = this.b.a;
            Intrinsics.checkNotNull(r10);
            String r9 = "";
            if (r111.a(r8, r10) == true) goto L26;
            a r112 = this.b;
            String r11 = r10.getApiName();
            if (r11 != null) goto L21;
            r11 = "null";
        L21:
            String r12 = r10.getCallbackID();
            String r13 = r10.getExtra();
            if (r13 == null) goto L25;
            r9 = r13;
        L25:
            r112.getClass();
            new xwb.d(r12, r112, r11, r9).a(Status.FAILURE, MapsKt.mapOf(new Pair("errMsg", "api has no auth")));
            int r113 = h.a;
            h.b(this.b.a, 10003, "reqAuthWith fail! apiName = " + r10.getApiName(), r10.getApiName());
            goto L134
        L26:
            a r114 = this.b;
            r114.getClass();
            String r115 = r10.getApiName();
            com.ss.android.lark.officesdk.utils.di.j.a("CML_TAG_JSBridge", "dispatchMsgFromJS, handlerName: " + r115);
            if (r115 != null) goto L29;
        L32:
            boolean r20 = true;
        L34:
            if (r20 == false) goto L36;
            int r116 = h.a;
            h.a(r114.a, 10004, "handlerName.isNullOrBlank()");
            goto L134
        L36:
            Object r21 = null;
            if (r114.f == false) goto L49;
            int r22 = h.a;
            OfficeWebView r23 = r114.a;
            Map<String, Object> r24 = r23.getCommonParams();
            Intrinsics.checkNotNullParameter(r23, "webView");
            Intrinsics.checkNotNullParameter("wb_lark_webview_bridge_call", "event");     // Catch: Throwable -> L47
            dxb.g r25 = r23.m("wb_lark_webview_bridge_call", null);     // Catch: Throwable -> L47
            r25.a("api_name", r115);     // Catch: Throwable -> L47
            if (r24 == null) goto L45;
            Iterator<Map.Entry<String, Object>> r26 = r24.entrySet().iterator();     // Catch: Throwable -> L47
        L43:
            if (r26.hasNext() == false) goto L45;
            Map.Entry<String, Object> r27 = r26.next();     // Catch: Throwable -> L47
            r25.a(r27.getKey(), r27.getValue());     // Catch: Throwable -> L47
        L45:
            r25.b();     // Catch: Throwable -> L47
        L47:
            th = move-exception;
            com.ss.android.lark.officesdk.utils.di.j.d("JSBridge", th);
        L49:
            f r28 = (f) ((ConcurrentHashMap) r114.b.a).get(r115);
            String r29 = r10.getCallbackID();
            String r30 = r10.getExtra();
            if (r30 == null) goto L53;
            r9 = r30;
        L53:
            xwb.d r31 = new xwb.d(r29, r114, r115, r9);
            Iterator<k> r32 = r114.d.iterator();
        L55:
            if (r32.hasNext() == false) goto L59;
            k r33 = r32.next();
            if (r33.p(r10, r31) == false) goto L55;
        L60:
            if (r33 == null) goto L62;
            boolean r34 = true;
        L63:
            if (r34 == false) goto L65;
            com.ss.android.lark.officesdk.utils.di.j.a("CML_TAG_JSBridge", "msg " + r115 + " onInterceptJSMsg");
            goto L134
        L65:
            if (r28 != null) goto L74;
            String r35 = r10.getData();
            if (r35 == null) goto L69;
            JSONObject r36 = new JSONObject(r35);
        L70:
            r114.a.o(r115, r36, new xwb.c()).getClass();
            r31.a(Status.FAILURE, MapsKt.mapOf(new Pair("errMsg", "find no handler")));
            int r37 = h.a;
            h.b(r114.a, 10004, "handler not found handlerName = ".concat(r115), r115);
            if (r114.g == false) goto L73;
            com.ss.android.lark.officesdk.utils.di.j.b("CML_TAG_JSBridge", "handler not found: " + r115 + "  web info :" + r114.a.getBizType() + ", scene: " + r114.a.getBizScene$webview_release());
            goto L134
        L73:
            com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_JSBridge", "fg close, not log web info");
            goto L134
        L69:
            r36 = new JSONObject();
            goto L70
        L74:
            int r38 = l.a;
            Type r39 = r28.getClass().getGenericSuperclass();
            if ((r39 instanceof ParameterizedType) == false) goto L85;
            Type[] r40 = ((ParameterizedType) r39).getActualTypeArguments();
            Intrinsics.checkNotNull(r40);
            if (r40.length != 0) goto L79;
            boolean r41 = true;
        L80:
            if (r41 == true) goto L85;
            Type r42 = r40[0];
            if ((r42 instanceof Class) == false) goto L85;
            Class r43 = (Class) r42;
        L86:
            if (r43 != null) goto L115;
            Class<?> r44 = r28.getClass();
        L88:
            if (r44 == null) goto L95;
            if (r44.getGenericInterfaces().length != 0) goto L92;
            boolean r45 = true;
        L93:
            if (r45 == false) goto L95;
            r44 = r44.getSuperclass();
            goto L88
        L92:
            r45 = false;
        L95:
            if (r44 == null) goto L114;
            Type[] r46 = r44.getGenericInterfaces();
            if (r46.length <= 0) goto L103;
            Type r47 = r46[0];
            if ((r47 instanceof ParameterizedType) == false) goto L103;
            Intrinsics.checkNotNull(r47, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
            Type[] r48 = ((ParameterizedType) r47).getActualTypeArguments();
        L104:
            if (r48 == null) goto L114;
            if (r48.length != 0) goto L108;
            boolean r49 = true;
        L109:
            if (r49 == true) goto L114;
            Type r50 = r48[0];
            if ((r50 instanceof Class) == false) goto L114;
            r43 = (Class) r50;
            goto L115
        L108:
            r49 = false;
        L103:
            r48 = null;
        L114:
            r43 = null;
        L115:
            if (r43 == null) goto L130;
            String r51 = r10.getData();
            if (r51 != null) goto L119;
        L122:
            if (r2 == true) goto L130;
            if (Intrinsics.areEqual(r43, String.class) == false) goto L127;
            Object r52 = r10.getData();
        L128:
            r21 = r52;
            goto L130
        L127:
            r52 = JSON.parseObject(r10.getData(), r43);
            goto L128
        L119:
            if (StringsKt.isBlank(r51) == true) goto L122;
            r2 = false;
        L130:
            if (r28.shouldRunInUIThread() == false) goto L132;
            com.ss.android.lark.officesdk.utils.di.j.a("CML_TAG_JSBridge", r115 + " handled on UIThread");
            com.ss.android.lark.officewebview.util.i.a.a.b(new xwb.b(r28, r21, r31, r10, r114));
            goto L134
        L132:
            com.ss.android.lark.officesdk.utils.di.j.a("CML_TAG_JSBridge", r115 + " not handled on UIThread");
            r28.a(r21, r31, r10.getExtra(), r114.a);
            goto L134
        L79:
            r41 = false;
        L85:
            r43 = null;
            goto L86
        L62:
            r34 = false;
            goto L63
        L59:
            r33 = null;
            goto L60
        L29:
            if (StringsKt.isBlank(r115) == true) goto L32;
            r20 = false;
            goto L34
        L5:
            r0 = false;
            goto L7
        }
    }

    public static final class c<T> implements Consumer {
        public static final c<T> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Unit r2 = (Unit) r1;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ a a;

        public d(a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            com.ss.android.lark.officesdk.utils.di.j.d("CML_TAG_JSBridge", r3);
            int r0 = com.ss.android.lark.officesdk.utils.di.e.a;
            if (com.ss.android.lark.officesdk.utils.di.e.a.a(this.a.a.getContext()) == true) goto L5;
            return;
        L5:
            throw r3;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ a a;

        public e(a r1, String r2, String r3) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            n r0 = this.a.a.getServiceManager();     // Catch: Throwable -> L8
            if (r0 == null) goto L11;
            wwb.a r1 = (wwb.a) r0.a(wwb.a.class);     // Catch: Throwable -> L8
            if (r1 == null) goto L15;
            r1.b();     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    static {
    }

    public a(OfficeWebView r3) {
        Intrinsics.checkNotNullParameter(r3, "webView");
        this.a = r3;
        this.b = new i();
        this.c = Schedulers.from(PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("bridge/Bridge")));
        this.d = new CopyOnWriteArrayList();
        int r0 = com.ss.android.lark.officesdk.utils.di.g.a;
        this.f = com.ss.android.lark.officesdk.utils.di.g.a.a("larkwebview.jsb.call_report");
        this.g = com.ss.android.lark.officesdk.utils.di.g.a.a("openplatform.webview.jsb.find_no_handler_log_web");
        this.h = new ConcurrentHashMap();
        this.i = new xwb.e();
        Intrinsics.checkNotNullParameter("Lark_Bridge", "bridgeName");
        r3.addJavascriptInterface(this, "Lark_Bridge");
        this.e = new g();
    }

    public final void c(String r3) {
        Intrinsics.checkNotNullParameter(r3, "handlerName");
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_JSBridge", "unRegisterHandler handlerName = " + r3);
        ((ConcurrentHashMap) this.b.a).remove(r3);
    }

    @JavascriptInterface
    public final void invokeNative(String r3) {
        Intrinsics.checkNotNullParameter(r3, "jsMessage");
        Flowable.just(r3).subscribeOn(this.c).map(new b(r3, this)).subscribe(c.a, new d(this));
    }

    public final void b(String r3, f<?, OfficeWebView> r4) {
        Intrinsics.checkNotNullParameter(r3, "handlerName");
        Intrinsics.checkNotNullParameter(r4, "handler");
        if (StringsKt.isBlank(r3) == true) goto L7;
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_JSBridge", "registerHandler handlerName = " + r3);
        ((ConcurrentHashMap) this.b.a).put(r3, r4);
        return;
    L7:
        throw new IllegalArgumentException("handlerName should not blank");
    }

    @JavascriptInterface
    public final void onWebViewTextSelected(String r2, String r3) {
        Lazy<Handler> r0 = ThreadUtil.a;
        ThreadUtil.a.g(new e(this, r2, r3));
    }

    public final void a(String r3, Serializable r4, ValueCallback<String> r5) {
        Intrinsics.checkNotNullParameter(r3, "apiName");
        int r0 = l.a;
        StringBuilder r1 = new StringBuilder();
        r1.append(r3);
        r1.append('(');
        if (r4 != null) goto L6;
        String r6 = "";
    L19:
        r1.append(r6);
        r1.append(')');
        String r7 = r1.toString();
        String r8 = new Regex("\n").replace(r7, "\\\\n");
        this.a.evaluateJavascript(r8, r5);
        return;
    L6:
        if ((r4 instanceof com.alibaba.fastjson.JSONObject) == false) goto L8;
    L18:
        r6 = r4.toString();
        goto L19
    L8:
        if ((r4 instanceof JSONObject) == true) goto L18;
        boolean r9 = r4 instanceof Map;
        if (r9 == true) goto L13;
        r6 = JSON.toJSONString(r4);
        goto L19
    L13:
        if (r9 == false) goto L15;
        Map r10 = (Map) r4;
    L16:
        r6 = new com.alibaba.fastjson.JSONObject(r10).toString();
        goto L19
    L15:
        r10 = null;
        goto L16
    }
}
