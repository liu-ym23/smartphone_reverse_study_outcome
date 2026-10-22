package com.bytedance.android.live.schema.api;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.live.core.utils.m2;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.schema.IAnnieXRedirectService;
import com.bytedance.android.live.schema.api.utils.OptimizeMainThreadScheduler;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jc1.k;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class WebcastRedirect {
    public static final /* synthetic */ int d = 0;
    public final List<c> a;
    public final e b;
    public final Map<String, String> c;

    public final class WebcastRedirectProcessorImpl implements com.bytedance.android.live.schema.api.d {
        public final WebcastRedirectReportInfo a;
        public volatile Disposable b;
        public final int c;
        public final int d;
        public final /* synthetic */ WebcastRedirect e;

        public static final class a implements n26.a.a {
            public final /* synthetic */ com.bytedance.android.live.schema.api.d.a a;

            public a(com.bytedance.android.live.schema.api.d.a r1) {
                this.a = r1;
            }

            public final void onSuccess(String r2) {
                Intrinsics.checkNotNullParameter(r2, "finalSchema");
                com.bytedance.android.live.schema.api.d.a r0 = this.a;
                if (r0 == null) goto L6;
                r0.onSuccess(r2);
                return;
            }

            public final void onFail(int r2, String r3) {
                Intrinsics.checkNotNullParameter(r3, Constants.OperatorKey.MSG);
                com.bytedance.android.live.schema.api.d.a r0 = this.a;
                if (r0 == null) goto L6;
                r0.onFail(r2, r3);
                return;
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ WebcastRedirectProcessorImpl a;

            public b(WebcastRedirectProcessorImpl r1) {
                this.a = r1;
            }

            public final void accept(Object r2) {
                Disposable r3 = (Disposable) r2;
                WebcastRedirectProcessorImpl r4 = this.a;
                if (r4.d >= r4.c) goto L5;
                boolean r5 = true;
            L6:
                if (r5 == false) goto L9;
                return;
            L9:
                throw new IllegalStateException(("redirect recursion must less than " + this.a.c + " depth").toString());
            L5:
                r5 = false;
                goto L6
            }
        }

        public static final class c<T> implements Consumer {
            public final /* synthetic */ WebcastRedirectProcessorImpl a;
            public final /* synthetic */ com.bytedance.android.live.schema.api.b b;
            public final /* synthetic */ long c;
            public final /* synthetic */ com.bytedance.android.live.schema.api.d.a d;

            public c(WebcastRedirectProcessorImpl r1, com.bytedance.android.live.schema.api.b r2, long r3, com.bytedance.android.live.schema.api.d.a r5) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r5;
            }

            public final void accept(Object r30) {
                com.bytedance.android.live.schema.api.a r1 = (com.bytedance.android.live.schema.api.a) r30;
                long r2 = SystemClock.uptimeMillis();
                WebcastRedirect r4 = this.a.e;
                com.bytedance.android.live.schema.api.b r5 = this.b;
                String r6 = r1.a;
                int r7 = WebcastRedirect.d;
                r4.getClass();
                Uri r8 = UriProtector.parse(r5.b);
                Uri r9 = UriProtector.parse(r6);
                if (TextUtils.equals(r9.getHost(), "webcast_redirect") == false) goto L32;
                Uri.Builder r10 = r9.buildUpon().clearQuery();
                Set r12 = UriProtector.getQueryParameterNames(r9);
                if (r12 == null) goto L17;
                ArrayList r13 = new ArrayList();
                Iterator<T> r14 = r12.iterator();
            L8:
                if (r14.hasNext() == false) goto L13;
                T r15 = r14.next();
                Iterator<T> r17 = r14;
                if (m2.a((String) r15, new Object[]{"entry", "default_schema"}) == false) goto L12;
                r13.add(r15);
            L12:
                r14 = r17;
                goto L8
            L13:
                Iterator r16 = r13.iterator();
            L15:
                if (r16.hasNext() == false) goto L17;
                String r18 = (String) r16.next();
                r10.appendQueryParameter(r18, UriProtector.getQueryParameter(r9, r18));
            L17:
                if (r8 == null) goto L31;
                Set r19 = UriProtector.getQueryParameterNames(r8);
                if (r19 == null) goto L31;
                ArrayList r20 = new ArrayList();
                Iterator<T> r22 = r19.iterator();
            L22:
                if (r22.hasNext() == false) goto L27;
                T r23 = r22.next();
                if ((!m2.a((String) r23, new Object[]{"entry", "default_schema", "url"})) == false) goto L22;
                r20.add(r23);
                goto L22
            L27:
                Iterator r24 = r20.iterator();
            L29:
                if (r24.hasNext() == false) goto L31;
                String r25 = (String) r24.next();
                r10.appendQueryParameter(r25, UriProtector.getQueryParameter(r8, r25));
            L31:
                String r26 = r10.toString();
                com.bytedance.android.live.schema.api.a r110 = r1;
                long r27 = r2;
            L106:
                com.bytedance.android.live.schema.api.utils.a.d("processor", "redirect SUCCESS: schema {" + this.b.b + "} to {" + r26 + '}');
                WebcastRedirect r3 = this.a.e;
                com.bytedance.android.live.schema.api.b r28 = this.b;
                r3.getClass();
                if ((!r28.equals(com.bytedance.android.live.schema.api.utils.b.a)) == false) goto L132;
                WebcastRedirectProcessorImpl r29 = this.a;
                WebcastRedirect r32 = r29.e;
                com.bytedance.android.live.schema.api.b r33 = this.b;
                WebcastRedirectReportInfo r34 = r29.a;
                long r35 = r27 - this.c;
                r32.getClass();
                JSONObject r111 = new JSONObject();
                Iterator<Map.Entry<String, String>> r36 = r34.b().entrySet().iterator();
            L110:
                if (r36.hasNext() == false) goto L112;
                Map.Entry<String, String> r37 = r36.next();
                r111.put(r37.getKey(), r37.getValue());
                goto L110
            L112:
                r111.put("status_code", 0);
                if (r33.c.length() != 0) goto L115;
                int r112 = 1;
            L116:
                r111.put("entry_value", r112 ^ 1);
                String r113 = r33.f;
                if (r113 != null) goto L119;
            L122:
                int r114 = 1;
            L123:
                r111.put("default_schema_value", r114 ^ 1);
                r111.put("entry_key", r33.c);
                r111.put("poll_config", la1.a.a());
                JSONObject r115 = new JSONObject();
                Iterator r38 = ((Map) r34.c.getValue()).entrySet().iterator();
            L125:
                if (r38.hasNext() == false) goto L127;
                Map.Entry r116 = (Map.Entry) r38.next();
                r115.put((String) r116.getKey(), ((Number) r116.getValue()).longValue());
                goto L125
            L127:
                r115.put(Constants.Keys.duration, r35);
                JSONObject r117 = new JSONObject();
                Iterator<Map.Entry<String, String>> r39 = r34.c().entrySet().iterator();
            L129:
                if (r39.hasNext() == false) goto L131;
                Map.Entry<String, String> r40 = r39.next();
                r117.put(r40.getKey(), r40.getValue());
                goto L129
            L131:
                r117.put("origin_schema", r33.b);
                r117.put("setting_value", r110.a);
                r117.put("final_schema", r26);
                r117.put("entry_key", r33.c);
                JSONObject r118 = new JSONObject();
                r118.put("virtual_aid", "88888");
                JSONObject r42 = new JSONObject();
                r42.put("event", "ttlive_url_redirect_status");
                r42.put("category", r111);
                r42.put("metric", r115);
                r42.put("extra", r117);
                com.bytedance.android.live.schema.api.utils.a.a("processor", r42.toString());
                r32.b.a("ttlive_url_redirect_status", r111, r115, r117, r118);
                goto L132
            L119:
                if (r113.length() == 0) goto L122;
                r114 = 0;
                goto L123
            L115:
                r112 = 0;
            L132:
                com.bytedance.android.live.schema.api.b r43 = com.bytedance.android.live.schema.api.utils.b.b(r26);
                if (r43 == null) goto L135;
                WebcastRedirectProcessorImpl r44 = this.a;
                new WebcastRedirectProcessorImpl(r44.e, r44.d + 1).a(r43, this.d);
                return;
            L135:
                com.bytedance.android.live.schema.api.d.a r45 = this.d;
                if (r45 == null) goto L169;
                r45.onSuccess(r26);
                return;
            L169:
                return;
            L32:
                u6 r46 = new u6(r6);
                u6 r47 = null;
                if (r46.a("url") == null) goto L35;
                u6 r48 = r46.d("url");
            L37:
                if (r46.a("fallback_url") == null) goto L44;
                u6 r119 = r46.d("fallback_url");
                if (r119 != null) goto L41;
            L43:
                u6 r120 = r47;
                r47 = r119;
            L45:
                if (r8 == null) goto L61;
                Set r121 = UriProtector.getQueryParameterNames(r8);
                if (r121 == null) goto L61;
                ArrayList r122 = new ArrayList();
                Iterator<T> r123 = r121.iterator();
            L50:
                if (r123.hasNext() == false) goto L55;
                com.bytedance.android.live.schema.api.a r124 = r1;
                T r49 = r123.next();
                Iterator<T> r125 = r123;
                long r210 = r2;
                if ((!m2.a((String) r49, new Object[]{"entry", "default_schema", "scheme_query", "url_query", "url", "fallback_url"})) == false) goto L54;
                r122.add(r49);
            L54:
                r1 = r124;
                r123 = r125;
                r2 = r210;
                goto L50
            L55:
                r110 = r1;
                r27 = r2;
                Iterator r50 = r122.iterator();
            L57:
                if (r50.hasNext() == false) goto L62;
                String r52 = (String) r50.next();
                r46.b(r52, UriProtector.getQueryParameter(r8, r52));
                if (r47 == null) goto L57;
                r47.b(r52, UriProtector.getQueryParameter(r8, r52));
            L62:
                String r53 = r5.d;
                if (r53 == null) goto L83;
                Object[] r54 = StringsKt.split$default(r53, new String[]{"&"}, false, 0, 6, null).toArray(new String[0]);
                if (r54 == null) goto L82;
                String[] r55 = (String[]) r54;
                int r56 = r55.length;
                int r126 = 0;
            L67:
                if (r126 >= r56) goto L83;
                Object[] r127 = StringsKt.split$default(r55[r126], new String[]{"="}, false, 0, 6, null).toArray(new String[0]);
                if (r127 == null) goto L80;
                String[] r128 = (String[]) r127;
                if (r128.length != 2) goto L78;
                String r129 = r128[0];
                String r130 = r128[1];
                if (r5.a == false) goto L75;
                r130 = Uri.decode(r130);
            L75:
                r46.b(r129, r130);
                if (r47 == null) goto L78;
                r47.b(r129, r130);
            L78:
                r126 = r126 + 1;
                goto L67
            L80:
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            L82:
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            L83:
                String r57 = r5.e;
                if (r57 == null) goto L105;
                Object[] r58 = StringsKt.split$default(r57, new String[]{"&"}, false, 0, 6, null).toArray(new String[0]);
                if (r58 == null) goto L104;
                String[] r59 = (String[]) r58;
                int r60 = r59.length;
                int r62 = 0;
            L88:
                if (r62 >= r60) goto L105;
                Object[] r63 = StringsKt.split$default(r59[r62], new String[]{"="}, false, 0, 6, null).toArray(new String[0]);
                if (r63 == null) goto L102;
                String[] r64 = (String[]) r63;
                if (r64.length != 2) goto L100;
                String r131 = r64[0];
                String r65 = r64[1];
                if (r5.a == false) goto L96;
                r65 = Uri.decode(r65);
            L96:
                if (r48 == null) goto L98;
                r48.b(r131, r65);
            L98:
                if (r120 == null) goto L100;
                r120.b(r131, r65);
            L100:
                r62 = r62 + 1;
                goto L88
            L102:
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            L104:
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            L105:
                r26 = r46.toString();
            L61:
                r110 = r1;
                r27 = r2;
                goto L62
            L41:
                if (r119.a("url") == null) goto L43;
                r47 = r119.d("url");
                goto L43
            L44:
                r120 = null;
                goto L45
            L35:
                r48 = null;
                goto L37
            }
        }

        public static final class d<T> implements Consumer {
            public final /* synthetic */ WebcastRedirectProcessorImpl a;
            public final /* synthetic */ com.bytedance.android.live.schema.api.d.a b;
            public final /* synthetic */ com.bytedance.android.live.schema.api.b c;

            public d(WebcastRedirectProcessorImpl r1, com.bytedance.android.live.schema.api.d.a r2, com.bytedance.android.live.schema.api.b r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            public final void accept(Object r12) {
                Throwable r13 = (Throwable) r12;
                if ((r13 instanceof WebcastRedirectException) == false) goto L22;
                StringWriter r0 = new StringWriter();
                WebcastRedirect r7 = this.a.e;
                PrintWriter r8 = new PrintWriter(r0);
                int r9 = WebcastRedirect.d;
                r7.getClass();
                Throwable r10 = r13;
            L5:
                if (r10 == null) goto L6;
                String r14 = r10.getMessage();
                if (r14 != null) goto L15;
            L18:
                boolean r15 = true;
            L19:
                if (r15 == true) goto L21;
                r8.print(" | ");
                r8.print(r10.getMessage());
            L21:
                r10 = r10.getCause();
                goto L5
            L15:
                if (r14.length() == 0) goto L18;
                r15 = false;
                goto L19
            L6:
                String r1 = r0.toString();
                com.bytedance.android.live.schema.api.d.a r16 = this.b;
                if (r16 == null) goto L9;
                r16.onFail(((WebcastRedirectException) r13).getCode(), "not match any redirect rule for " + this.c.b);
            L9:
                com.bytedance.android.live.schema.api.utils.a.b("processor", "redirect FAILED: schema " + this.c.b + ", reason " + r1, null);
                this.a.a.b().put("error", DataType.FALSE);
                this.a.a.b().put("failed_reason", r1);
                this.a.a.b().put("poll_config", la1.a.a());
                this.a.a.c().put("reason", r1);
                WebcastRedirect r17 = this.a.e;
                com.bytedance.android.live.schema.api.b r2 = this.c;
                r17.getClass();
                if ((!r2.equals(com.bytedance.android.live.schema.api.utils.b.a)) == false) goto L42;
                WebcastRedirectProcessorImpl r18 = this.a;
                WebcastRedirect.b(r18.e, this.c, r18.a);
                WebcastRedirectProcessorImpl r19 = this.a;
                WebcastRedirect.a(r19.e, this.c, r19.a);
                return;
            L42:
                return;
            L22:
                StringWriter r3 = new StringWriter();
                r13.printStackTrace(new PrintWriter(r3));
                String r4 = r3.toString();
                com.bytedance.android.live.schema.api.d.a r20 = this.b;
                String r22 = "";
                if (r20 == null) goto L28;
                String r23 = r13.getMessage();
                if (r23 != null) goto L27;
                r23 = "";
            L27:
                r20.onFail(WebcastRedirectException.UNKNOWN, r23);
            L28:
                com.bytedance.android.live.schema.api.utils.a.b("processor", "unknown error, schema " + this.c.b, r13);
                this.a.a.b().put("error", DataType.TRUE);
                Map<String, String> r5 = this.a.a.b();
                String r6 = r13.getMessage();
                if (r6 != null) goto L31;
                r6 = "";
            L31:
                r5.put("failed_reason", r6);
                this.a.a.b().put("poll_config", la1.a.a());
                Map<String, String> r24 = this.a.a.c();
                String r110 = r13.getMessage();
                if (r110 == null) goto L35;
                r22 = r110;
            L35:
                r24.put("reason", r22);
                this.a.a.c().put("stackTrace", r4);
                WebcastRedirect r111 = this.a.e;
                com.bytedance.android.live.schema.api.b r25 = this.c;
                int r26 = WebcastRedirect.d;
                r111.getClass();
                if ((!r25.equals(com.bytedance.android.live.schema.api.utils.b.a)) == false) goto L44;
                WebcastRedirectProcessorImpl r112 = this.a;
                WebcastRedirect.b(r112.e, this.c, r112.a);
                WebcastRedirectProcessorImpl r113 = this.a;
                WebcastRedirect.a(r113.e, this.c, r113.a);
                return;
            }
        }

        public WebcastRedirectProcessorImpl(WebcastRedirect r2, int r3) {
            this.e = r2;
            this.d = r3;
            WebcastRedirectReportInfo r4 = new WebcastRedirectReportInfo();
            r4.b().putAll(r2.c);
            Unit r5 = Unit.INSTANCE;
            this.a = r4;
            this.c = 3;
        }

        @Override // com.bytedance.android.live.schema.api.d
        public final void a(final com.bytedance.android.live.schema.api.b r10, com.bytedance.android.live.schema.api.d.a r12) {
            Intrinsics.checkNotNullParameter(r10, "info");
            if (((Boolean) xa1.a.e.getValue()).booleanValue() == false) goto L12;
            Context r0 = k.n(IMiddleWareHostContext.class).context();
            IAnnieXRedirectService r1 = (IAnnieXRedirectService) k.n(IAnnieXRedirectService.class);
            Context r2 = r0.getApplicationContext();
            if (r2 == null) goto L11;
            n26.a r3 = r1.getRedirectProcessor((Application) r2);
            if (r3 == null) goto L19;
            r3.a(r10.b, new a(r12));
            return;
        L19:
            return;
        L11:
            throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
        L12:
            com.bytedance.android.live.schema.api.utils.a.d("processor", "start redirect: " + r10 + ", loop " + this.d);
            this.a.b().put("loop_index", String.valueOf(this.d));
            long r6 = SystemClock.uptimeMillis();
            final Ref.ObjectRef r4 = new Ref.ObjectRef();
            r4.element = null;
            la1.a.c();
            List<com.bytedance.android.live.schema.api.c> r5 = this.e.a;
            ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
            Iterator<T> r8 = r5.iterator();
        L14:
            if (r8.hasNext() == false) goto L16;
            final com.bytedance.android.live.schema.api.c r9 = (com.bytedance.android.live.schema.api.c) r8.next();
            r7.add(Observable.create(new WebcastRedirect$WebcastRedirectProcessorImpl$redirect$$inlined$map$lambda$1(r9, this, r10, r4)));
            goto L14
        L16:
            this.b = Observable.concat(r7).firstOrError().doOnSubscribe(new b(this)).observeOn((Scheduler) OptimizeMainThreadScheduler.a.getValue()).subscribe(new c(this, r10, r6, r12), new d(this, r12, r10));
        }
    }

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WebcastRedirect(List<? extends c> r2, e r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r2, "interceptors");
        Intrinsics.checkNotNullParameter(r3, "report");
        Intrinsics.checkNotNullParameter(r4, "globalCategory");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public static final void a(WebcastRedirect r8, b r9, WebcastRedirectReportInfo r10) {
        r8.getClass();
        JSONObject r2 = new JSONObject();
        Iterator<Map.Entry<String, String>> r0 = r10.b().entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry<String, String> r1 = r0.next();
        r2.put(r1.getKey(), r1.getValue());
        goto L4
    L6:
        r2.put("status_code", 1);
        if (r9.c.length() != 0) goto L9;
        int r3 = 1;
    L10:
        r2.put("entry_value", r3 ^ 1);
        String r4 = r9.f;
        if (r4 != null) goto L13;
    L16:
        int r5 = 1;
    L17:
        r2.put("default_schema_value", r5 ^ 1);
        r2.put("entry_key", r9.c);
        JSONObject r6 = new JSONObject();
        Iterator r7 = ((Map) r10.c.getValue()).entrySet().iterator();
    L19:
        if (r7.hasNext() == false) goto L21;
        Map.Entry r12 = (Map.Entry) r7.next();
        r6.put((String) r12.getKey(), ((Number) r12.getValue()).longValue());
        goto L19
    L21:
        r6.put(Constants.Keys.duration, 0);
        JSONObject r13 = new JSONObject();
        Iterator<Map.Entry<String, String>> r14 = r10.c().entrySet().iterator();
    L23:
        if (r14.hasNext() == false) goto L25;
        Map.Entry<String, String> r15 = r14.next();
        r13.put(r15.getKey(), r15.getValue());
        goto L23
    L25:
        r13.put("origin_schema", r9.b);
        r13.put("setting_value", "");
        JSONObject r16 = new JSONObject();
        r16.put("virtual_aid", "88888");
        JSONObject r17 = new JSONObject();
        r17.put("event", "ttlive_url_redirect_fail");
        r17.put("category", r2);
        r17.put("extra", r13);
        com.bytedance.android.live.schema.api.utils.a.a("processor", r17.toString());
        r8.b.a("ttlive_url_redirect_fail", r2, r6, r13, r16);
        return;
    L13:
        if (r4.length() == 0) goto L16;
        r5 = 0;
        goto L17
    L9:
        r3 = 0;
        goto L10
    }

    public static final void b(WebcastRedirect r8, b r9, WebcastRedirectReportInfo r10) {
        r8.getClass();
        JSONObject r2 = new JSONObject();
        Iterator<Map.Entry<String, String>> r0 = r10.b().entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry<String, String> r1 = r0.next();
        r2.put(r1.getKey(), r1.getValue());
        goto L4
    L6:
        r2.put("status_code", 1);
        if (r9.c.length() != 0) goto L9;
        int r3 = 1;
    L10:
        r2.put("entry_value", r3 ^ 1);
        String r4 = r9.f;
        if (r4 != null) goto L13;
    L16:
        int r5 = 1;
    L17:
        r2.put("default_schema_value", r5 ^ 1);
        r2.put("entry_key", r9.c);
        JSONObject r6 = new JSONObject();
        Iterator r7 = ((Map) r10.c.getValue()).entrySet().iterator();
    L19:
        if (r7.hasNext() == false) goto L21;
        Map.Entry r12 = (Map.Entry) r7.next();
        r6.put((String) r12.getKey(), ((Number) r12.getValue()).longValue());
        goto L19
    L21:
        r6.put(Constants.Keys.duration, 0);
        JSONObject r13 = new JSONObject();
        Iterator<Map.Entry<String, String>> r14 = r10.c().entrySet().iterator();
    L23:
        if (r14.hasNext() == false) goto L25;
        Map.Entry<String, String> r15 = r14.next();
        r13.put(r15.getKey(), r15.getValue());
        goto L23
    L25:
        r13.put("origin_schema", r9.b);
        r13.put("setting_value", "");
        JSONObject r16 = new JSONObject();
        r16.put("virtual_aid", "88888");
        JSONObject r17 = new JSONObject();
        r17.put("event", "ttlive_url_redirect_status");
        r17.put("category", r2);
        r17.put("extra", r13);
        com.bytedance.android.live.schema.api.utils.a.a("processor", r17.toString());
        r8.b.a("ttlive_url_redirect_status", r2, r6, r13, r16);
        return;
    L13:
        if (r4.length() == 0) goto L16;
        r5 = 0;
        goto L17
    L9:
        r3 = 0;
        goto L10
    }
}
