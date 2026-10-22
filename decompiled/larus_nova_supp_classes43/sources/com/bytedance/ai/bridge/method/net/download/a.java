package com.bytedance.ai.bridge.method.net.download;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.app.foundation.w;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.method.net.core.IHostNetworkRuntimeApi;
import com.bytedance.ai.bridge.network.AbsDownloadFileMethodIDL;
import com.bytedance.ai.bridge.service.IAppletRetrofit;
import com.bytedance.ai.bridge.service.IHostNetworkDepend;
import com.bytedance.ai.file.AppletFileError;
import com.bytedance.ai.file.AppletFileManager;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.ttnet.http.RequestContext;
import d3.a0;
import java.net.URI;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements w {
    public static final Regex c = null;
    public static final Executor d = null;
    public static final CoroutineScope e = null;
    public final Object a;
    public final Map<f, Map<String, b>> b;

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.net.download.a$a, reason: collision with other inner class name */
    public static final class C0027a {
    }

    public final class b {
        public final String a;
        public final f b;
        public final String c;
        public final e3.d d;
        public final AppletFileManager e;
        public final String f;
        public final Map<String, String> g;
        public final long h;
        public final String i;
        public final IHostNetworkDepend j;
        public final f3.h<AbsDownloadFileMethodIDL.b> k;
        public final h l;
        public i m;
        public Long n;
        public Long o;
        public Job p;
        public final String q;
        public final /* synthetic */ a r;

        public final String b() {
            Intrinsics.checkNotNullParameter("downloadFile:fail abort", com.bytedance.android.ec.core.event.a.KEY_MSG);
            return (String) this.l.a(new com.bytedance.ai.bridge.method.net.download.b(this));
        }

        public final String g() {
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
            Object r1 = Result.constructor-impl(new URI(this.f).getHost());     // Catch: Throwable -> L4
        L7:
            if (Result.isFailure-impl(r1) == false) goto L9;
            r1 = null;
        L9:
            String r10 = (String) r1;
            if (r10 != null) goto L15;
            return "unknown";
        L15:
            return r10;
        L4:
            th = move-exception;
            Result.Companion r11 = Result.Companion;
            r1 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L7
        }

        public final com.bytedance.ai.file.a c(final Call<TypedInput> r10) {
            return (com.bytedance.ai.file.a) this.l.a(new com.bytedance.ai.bridge.method.net.download.h(this, r10));
        }

        public final void d(final d r10) {
            this.l.execute(new com.bytedance.ai.bridge.method.net.download.c(this, r10));
        }

        public final void f(List<? extends c> r23) {
            a r10 = this.r;
            Iterator<T> r11 = r23.iterator();
        L4:
            if (r11.hasNext() == false) goto L119;
            c r0 = (c) r11.next();
            if (Intrinsics.areEqual(r0, c.m.a) == true) goto L7;
            boolean r12 = false;
            if (Intrinsics.areEqual(r0, c.g.a) == true) goto L10;
            if (Intrinsics.areEqual(r0, c.l.a) == true) goto L47;
            if ((r0 instanceof c.d) == true) goto L50;
            if ((r0 instanceof c.C0028a) == true) goto L53;
            if ((r0 instanceof c.k) == true) goto L56;
            if ((r0 instanceof c.j) == true) goto L63;
            if (Intrinsics.areEqual(r0, c.h.a) == true) goto L66;
            if ((r0 instanceof c.C0029c) == true) goto L87;
            if ((r0 instanceof c.b) == true) goto L94;
            if ((r0 instanceof c.i) == true) goto L110;
            if ((r0 instanceof c.e) == true) goto L113;
            if ((r0 instanceof c.f) == false) goto L118;
            com.bytedance.ai.utils.g.a.w("AppletDownloadFileManager", this.q + ' ' + ((c.f) r0).a);
            goto L4
        L118:
            throw new NoWhenBranchMatchedException();
        L113:
            com.bytedance.ai.utils.g.a.i("AppletDownloadFileManager", this.q + ' ' + ((c.e) r0).a);
            goto L4
        L110:
            c.i r1 = (c.i) r0;
            com.bytedance.ai.monitor.b.b("flow_applet_download_file_success", new k(r1.a, r1.b, this));
            goto L4
        L94:
            e r13 = ((c.b) r0).a;
            if (r13.b != null) goto L100;
            if (r13.c != null) goto L100;
            f3.h.a.a(this.k, a.e(this.r, r13.a), null, null, 14);
        L100:
            f3.h<AbsDownloadFileMethodIDL.b> r14 = this.k;
            String r15 = a.e(this.r, r13.a);
            Intrinsics.checkNotNullParameter(AbsDownloadFileMethodIDL.b.class, "<this>");
            AbsDownloadFileMethodIDL.b r16 = (AbsDownloadFileMethodIDL.b) k3.c.a(AbsDownloadFileMethodIDL.b.class);
            Integer r17 = r13.b;
            if (r17 == null) goto L103;
            int r18 = r17.intValue();
        L104:
            r16.setStatusCode(r18);
            Map<String, String> r19 = r13.c;
            if (r19 != null) goto L107;
            r19 = MapsKt.emptyMap();
        L107:
            r16.setHeader(r19);
            Unit r20 = Unit.INSTANCE;
            f3.h.a.a(r14, r15, null, r16.toJson(), 6);
            goto L4
        L103:
            r18 = -1;
            goto L104
        L87:
            c.C0029c r21 = (c.C0029c) r0;
            g r22 = r21.a;
            j r24 = r21.b;
            Intrinsics.checkNotNullParameter(AbsDownloadFileMethodIDL.b.class, "<this>");
            AbsDownloadFileMethodIDL.b r25 = (AbsDownloadFileMethodIDL.b) k3.c.a(AbsDownloadFileMethodIDL.b.class);
            r25.setStatusCode(r24.a);
            r25.setHeader(r24.b);
            if (r22.b == false) goto L90;
            r25.setFilePath(r22.a.a());
        L91:
            f3.h.a.b(this.k, r25);
            goto L4
        L90:
            r25.setTempFilePath(r22.a.a());
            goto L91
        L66:
            String r26 = this.a;
            f r27 = this.b;
            Object r28 = r10.a;
            monitor-enter(r28);
            Map r29 = (Map) ((LinkedHashMap) r10.b).get(r27);     // Catch: Throwable -> L82
            if (r29 == null) goto L70;
            if (r29.get(r26) != this) goto L74;
            r29.remove(r26);     // Catch: Throwable -> L82
            if (r29.isEmpty() == false) goto L79;
            r10.b.remove(r27);     // Catch: Throwable -> L82
        L79:
            Unit r30 = Unit.INSTANCE;     // Catch: Throwable -> L82
            monitor-exit(r28);
            goto L4
        L74:
            monitor-exit(r28);
            goto L4
        L70:
            monitor-exit(r28);
        L82:
            th = move-exception;
            throw th;
        L63:
            e3.d r31 = this.d;
            String r32 = this.a;
            Map<String, String> r33 = ((c.j) r0).a;
            Regex r110 = a.c;
            r10.getClass();
            Lazy r111 = com.bytedance.ai.applet.base.gson.e.a;
            r31.a("downloadFileHeadersReceived", com.bytedance.ai.applet.base.gson.e.d(MapsKt.mapOf(new Pair[]{TuplesKt.to("downloadTaskId", r32), TuplesKt.to("downloadTaskID", r32), TuplesKt.to("header", r33)})));
            goto L4
        L56:
            e3.d r34 = this.d;
            String r35 = this.a;
            c.k r36 = (c.k) r0;
            long r112 = r36.a;
            long r113 = r36.b;
            Regex r37 = a.c;
            r10.getClass();
            if (r113 <= 0) goto L59;
            int r38 = (int) RangesKt.coerceIn((100 * r112) / r113, 0, 100);
        L60:
            Lazy r114 = com.bytedance.ai.applet.base.gson.e.a;
            r34.a("downloadProgressUpdate", com.bytedance.ai.applet.base.gson.e.d(MapsKt.mapOf(new Pair[]{TuplesKt.to("downloadTaskId", r35), TuplesKt.to("downloadTaskID", r35), TuplesKt.to("progress", Integer.valueOf(r38)), TuplesKt.to("totalBytesWritten", Long.valueOf(r112)), TuplesKt.to("totalBytesExpectedToWrite", Long.valueOf(r113))})));
            goto L4
        L59:
            r38 = 0;
            goto L60
        L53:
            ((c.C0028a) r0).a.cancel();
            goto L4
        L50:
            BuildersKt.launch$default(a.e, null, null, new AppletDownloadFileManager$DownloadTask$executeTransport$1(this, ((c.d) r0).a, null), 3, null);
            goto L4
        L47:
            BuildersKt.launch$default(a.e, null, null, new AppletDownloadFileManager$DownloadTask$startTransport$1(this, this.r, null), 3, null);
            goto L4
        L10:
            a r39 = this.r;
            AppletFileManager r40 = this.e;
            String r41 = this.i;
            Regex r42 = a.c;
            r39.getClass();
            Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L29
            if (r41 != null) goto L14;
        L17:
            boolean r44 = true;
        L18:
            if (r44 == false) goto L20;
            r40.getClass();     // Catch: Throwable -> L29
            com.bytedance.ai.file.a r45 = r40.e(new PolarisFileWrapper(r40.e, "download_" + System.currentTimeMillis() + '_' + UUID.randomUUID()));     // Catch: Throwable -> L29
        L27:
            Object r46 = Result.constructor-impl(r45);     // Catch: Throwable -> L29
        L32:
            if (Result.isSuccess-impl(r46) == false) goto L39;
            com.bytedance.ai.file.a r47 = (com.bytedance.ai.file.a) r46;
            String r48 = this.i;
            if (r48 != null) goto L36;
        L37:
            r12 = true;
        L38:
            d(new d.i(new g(r47, !r12)));
            goto L39
        L36:
            if (StringsKt.isBlank(r48) == false) goto L38;
        L39:
            a r49 = this.r;
            Throwable r50 = Result.exceptionOrNull-impl(r46);
            if (r50 == null) goto L4;
            String r51 = r50.getMessage();
            if (r51 != null) goto L44;
            r51 = "invalid filePath";
        L44:
            d(new d.h(a.e(r49, r51)));
            goto L4
        L20:
            int r52 = com.bytedance.ai.file.a.b;     // Catch: Throwable -> L29
            r45 = com.bytedance.ai.file.a.C0040a.a(r41);     // Catch: Throwable -> L29
            if (r45.c() == true) goto L27;
            if (r45.b() == true) goto L27;
            throw AppletFileError.InvalidUri.INSTANCE;     // Catch: Throwable -> L29
        L14:
            if (StringsKt.isBlank(r41) == true) goto L17;
            r44 = false;
        L29:
            th = move-exception;
            Result.Companion r53 = Result.Companion;
            r46 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L32
        L7:
            BuildersKt.launch$default(a.e, null, null, new AppletDownloadFileManager$DownloadTask$validateDomain$1(this, this.r, null), 3, null);
            goto L4
        }

        public final List<c> h(d r14) {
            i r0 = this.m;
            i.e r1 = i.e.b;
            if (r0 == r1) goto L5;
        L17:
            i.h r10 = i.h.b;
            if (r0 == r10) goto L20;
        L22:
            c.C0028a r11 = null;
            if (r0 == r10) goto L25;
        L27:
            i.c r12 = i.c.b;
            if (r0 == r12) goto L30;
        L32:
            if (r0 == r12) goto L34;
        L36:
            boolean r13 = r0 instanceof i.f;
            if (r13 == true) goto L39;
        L41:
            i.g r15 = i.g.b;
            if (r0 == r15) goto L44;
        L46:
            boolean r16 = r0 instanceof i.b;
            if (r16 == true) goto L49;
        L53:
            if (r16 == true) goto L55;
        L68:
            if (r16 == true) goto L70;
        L74:
            if (r16 == true) goto L76;
        L85:
            boolean r17 = r0 instanceof i.d;
            if (r17 == true) goto L88;
        L93:
            if (r17 == true) goto L95;
        L99:
            boolean r18 = r0 instanceof i.C0033a;
            if (r18 == true) goto L102;
        L110:
            if (r17 == true) goto L112;
        L114:
            if (r16 == true) goto L116;
        L118:
            if (r18 == false) goto L123;
            if ((r14 instanceof d.c) == false) goto L123;
            this.m = r15;
            return k(((d.c) r14).a, r0.a, new c.C0028a(((i.C0033a) r0).c));
        L123:
            if ((r14 instanceof d.l) == false) goto L126;
            if (r13 == false) goto L126;
            this.m = r15;
            return k(((d.l) r14).a, r0.a, null);
        L126:
            boolean r19 = r14 instanceof d.C0030a;
            if (r19 == false) goto L133;
            if (r0 == r1) goto L132;
            if (r0 == r10) goto L132;
            if (r0 == r12) goto L132;
            if (r13 == false) goto L133;
        L132:
            this.m = r15;
            return j(((d.C0030a) r14).a, r0.a, null);
        L133:
            if (r19 == false) goto L136;
            if (r16 == false) goto L136;
            this.m = r15;
            return j(((d.C0030a) r14).a, r0.a, ((i.b) r0).c);
        L136:
            if (r19 == false) goto L139;
            if (r17 == false) goto L139;
            this.m = r15;
            return j(((d.C0030a) r14).a, r0.a, ((i.d) r0).c);
        L139:
            if (r19 == false) goto L144;
            if (r18 == true) goto L181;
            if (r0 != r15) goto L144;
        L181:
            return CollectionsKt.emptyList();
        L144:
            if (r14 != d.j.a) goto L158;
            if (r0 == r15) goto L158;
            if (r18 == true) goto L158;
            this.m = r15;
            if (r16 == false) goto L150;
            Call<TypedInput> r110 = ((i.b) r0).c;
        L153:
            e r20 = new e("downloadFile:fail timeout", null, null);
            String r21 = r0.a;
            if (r110 == null) goto L182;
            r11 = new c.C0028a(r110);
        L182:
            return k(r20, r21, r11);
        L150:
            if (r17 == false) goto L152;
            r110 = ((i.d) r0).c;
            goto L153
        L152:
            r110 = null;
        L158:
            return CollectionsKt.emptyList();
        L116:
            if ((r14 instanceof d.c) == false) goto L118;
            this.m = r15;
            return k(((d.c) r14).a, r0.a, new c.C0028a(((i.b) r0).c));
        L112:
            if ((r14 instanceof d.c) == false) goto L114;
            this.m = r15;
            return k(((d.c) r14).a, r0.a, new c.C0028a(((i.d) r0).c));
        L102:
            if ((r14 instanceof d.C0031d) == false) goto L110;
            this.m = r15;
            Long r22 = this.o;
            long r23 = 0;
            if (r22 == null) goto L106;
            r23 = RangesKt.coerceAtLeast(SystemClock.elapsedRealtime() - r22.longValue(), 0);
        L106:
            ArrayList r24 = new ArrayList();
            d.C0031d r111 = (d.C0031d) r14;
            j r25 = r111.a;
            c.k r26 = i(r25.c, r25.d, true);
            if (r26 == null) goto L109;
            r24.add(r26);
        L109:
            r24.add(new c.e("success statusCode=" + r111.a.a + " bytes=" + r111.a.c + " duration=" + r23));
            r24.add(new c.i(r111.a, r23));
            r24.add(c.h.a);
            r24.add(new c.C0029c(((i.C0033a) r0).b, r111.a));
        L171:
            return r24;
        L95:
            if ((r14 instanceof d.b) == false) goto L99;
            i.d r27 = (i.d) r0;
            Call<TypedInput> r112 = r27.c;
            if (r112 != ((d.b) r14).a) goto L99;
            this.m = new i.C0033a(r27.b, r112);
            return CollectionsKt.listOf(new c.e("commit acquired phase=commit"));
        L88:
            if ((r14 instanceof d.l) == false) goto L93;
            this.m = r15;
            d.l r113 = (d.l) r14;
            e r28 = r113.a;
            String r29 = r0.a;
            Call<TypedInput> r114 = r113.b;
            if (r114 == null) goto L172;
            r11 = new c.C0028a(r114);
        L172:
            return k(r28, r29, r11);
        L76:
            if ((r14 instanceof d.l) == false) goto L85;
            this.m = r15;
            r24 = new ArrayList();
            d.l r115 = (d.l) r14;
            Map<String, String> r30 = r115.a.c;
            if (r30 == null) goto L80;
            r24.add(new c.j(r30));
        L80:
            e r31 = r115.a;
            String r32 = r0.a;
            Call<TypedInput> r116 = r115.b;
            if (r116 == null) goto L83;
            r11 = new c.C0028a(r116);
        L83:
            CollectionsKt.addAll(r24, k(r31, r32, r11));
            goto L171
        L70:
            if ((r14 instanceof d.k) == false) goto L74;
            i.b r33 = (i.b) r0;
            Call<TypedInput> r34 = r33.c;
            if (r34 != ((d.k) r14).a) goto L74;
            this.m = new i.d(r33.b, r34);
            return CollectionsKt.emptyList();
        L55:
            if ((r14 instanceof d.e) == false) goto L68;
            d.e r117 = (d.e) r14;
            long r35 = r117.a;
            if (r35 > 209715200) goto L67;
            long r118 = r117.b;
            if (r118 > 209715200) goto L67;
            c.k r119 = i(r35, r118, false);
            if (r119 == null) goto L64;
            List<c> r120 = CollectionsKt.listOf(r119);
        L65:
            if (r120 == null) goto L168;
            return r120;
        L168:
            return CollectionsKt.emptyList();
        L64:
            r120 = null;
        L67:
            this.m = r15;
            return k(new e("downloadFile:fail size exceeds 200MB", null, null), r0.a, new c.C0028a(((i.b) r0).c));
        L49:
            if ((r14 instanceof d.f) == false) goto L53;
            d.f r36 = (d.f) r14;
            if (((i.b) r0).c != r36.a) goto L53;
            return CollectionsKt.listOf(new c.j(r36.b));
        L44:
            if ((r14 instanceof d.m) == false) goto L46;
            return CollectionsKt.listOf(new c.C0028a(((d.m) r14).a));
        L39:
            if ((r14 instanceof d.m) == false) goto L41;
            d.m r121 = (d.m) r14;
            this.m = new i.b(((i.f) r0).b, r121.a);
            return CollectionsKt.listOf(new c.d(r121.a));
        L34:
            if ((r14 instanceof d.h) == false) goto L36;
            this.m = i.g.b;
            return k(new e(((d.h) r14).a, null, null), r0.a, null);
        L30:
            if ((r14 instanceof d.i) == false) goto L32;
            this.m = new i.f(((d.i) r14).a);
            return CollectionsKt.listOf(new c[]{new c.e("transport start phase=transport host=".concat(g())), c.l.a});
        L25:
            if ((r14 instanceof d.o) == false) goto L27;
            this.m = i.g.b;
            return k(new e(((d.o) r14).a, null, null), r0.a, null);
        L20:
            if (r14 != d.n.a) goto L22;
            this.m = i.c.b;
            return CollectionsKt.listOf(c.g.a);
        L5:
            if (r14 != d.g.a) goto L17;
            this.m = i.h.b;
            c[] r122 = new c[2];
            StringBuilder r37 = new StringBuilder("start phase=validating host=");
            r37.append(g());
            r37.append(" timeoutMs=");
            r37.append(this.h);
            r37.append(" target=");
            String r38 = this.i;
            if (r38 != null) goto L9;
        L12:
            boolean r39 = true;
        L13:
            if (r39 == false) goto L15;
            String r40 = "temporary";
        L16:
            r37.append(r40);
            r122[0] = new c.e(r37.toString());
            r122[1] = c.m.a;
            return CollectionsKt.listOf(r122);
        L15:
            r40 = "explicit";
            goto L16
        L9:
            if (StringsKt.isBlank(r38) == true) goto L12;
            r39 = false;
            goto L13
        }

        public final boolean a(final Call<TypedInput> r10, final Map<String, String> r11) {
            return ((Boolean) this.l.a(new com.bytedance.ai.bridge.method.net.download.g(this, r10, r11))).booleanValue();
        }

        public static List j(String r10, String r11, Call r12) {
            List r13 = CollectionsKt.mutableListOf(new c[]{new c.e("cancel phase=" + r11)});
            if (r12 == null) goto L5;
            r13.add(new c.C0028a(r12));
        L5:
            List r14 = r13;
            r14.add(c.h.a);
            r14.add(new c.b(new e(r10, null, null)));
            return r13;
        }

        public static List k(e r10, String r11, c r12) {
            c[] r0 = new c[1];
            StringBuilder r13 = new StringBuilder("failure phase=");
            r13.append(r11);
            r13.append(" statusCode=");
            Integer r14 = r10.b;
            if (r14 == null) goto L5;
            int r15 = r14.intValue();
        L6:
            r13.append(r15);
            r13.append(" reason=");
            String r16 = r10.a;
            r13.append(StringsKt.take(a.c.replace(StringsKt.replace$default(r16, '\n', ' ', false, 4, null), "<url>"), 256));
            r0[0] = new c.f(r13.toString());
            List r17 = CollectionsKt.mutableListOf(r0);
            if (r12 == null) goto L9;
            r17.add(r12);
        L9:
            List r18 = r17;
            r18.add(c.h.a);
            r18.add(new c.b(r10));
            return r17;
        L5:
            r15 = -1;
            goto L6
        }

        public final void e(Call<TypedInput> r1, boolean r10, e r11) {
            if (r10 == false) goto L4;
            d(new d.c(r11));
            return;
        L4:
            d(new d.l(r11, r1));
        }

        public final c.k i(long r10, long r11, boolean r12) {
            Long r0 = this.n;
            if (r0 != null) goto L5;
        L7:
            if (r0 == null) goto L9;
            long r13 = r0.longValue();
        L10:
            long r14 = r10 - r13;
            if (r12 == false) goto L13;
        L15:
            this.n = Long.valueOf(r10);
            return new c.k(r10, r11);
        L13:
            if (r14 >= 262144) goto L15;
            return null;
        L9:
            r13 = 0;
            goto L10
        L5:
            if (r10 > r0.longValue()) goto L7;
            return null;
        }

        public b(a r10, String r11, f r12, String r13, e3.d r14, AppletFileManager r15, String r16, Map<String, String> r17, long r18, String r19, IHostNetworkDepend r110, f3.h<AbsDownloadFileMethodIDL.b> r111) {
            Intrinsics.checkNotNullParameter(r11, "downloadTaskId");
            Intrinsics.checkNotNullParameter(r12, "ownerKey");
            Intrinsics.checkNotNullParameter(r13, "containerType");
            Intrinsics.checkNotNullParameter(r14, "bridgeContext");
            Intrinsics.checkNotNullParameter(r15, "fileManager");
            Intrinsics.checkNotNullParameter(r16, com.bytedance.android.ec.core.event.a.KEY_URL);
            Intrinsics.checkNotNullParameter(r17, "headers");
            Intrinsics.checkNotNullParameter(r110, "hostNetworkDepend");
            Intrinsics.checkNotNullParameter(r111, "callback");
            this.r = r10;
            this.a = r11;
            this.b = r12;
            this.c = r13;
            this.d = r14;
            this.e = r15;
            this.f = r16;
            this.g = r17;
            this.h = r18;
            this.i = r19;
            this.j = r110;
            this.k = r111;
            this.l = new h(a.d);
            this.m = i.e.b;
            this.q = "[AppletDownload] applet=" + r12.a + " containerType=" + r13 + " task=" + r11;
        }
    }

    public static abstract class c {

        /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.net.download.a$c$a, reason: collision with other inner class name */
        public static final class C0028a extends c {
            public final Call<TypedInput> a;

            public final boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof C0028a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((C0028a) r10).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "CancelTransport(call=" + this.a + ')';
            }

            public C0028a(Call<TypedInput> r10) {
                Intrinsics.checkNotNullParameter(r10, "call");
                this.a = r10;
            }
        }

        public static final class b extends c {
            public final e a;

            public final boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((b) r10).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "CompleteFailure(failure=" + this.a + ')';
            }

            public b(e r10) {
                Intrinsics.checkNotNullParameter(r10, "failure");
                this.a = r10;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.net.download.a$c$c, reason: collision with other inner class name */
        public static final class C0029c extends c {
            public final g a;
            public final j b;

            public final boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof C0029c) == true) goto L8;
                return false;
            L8:
                C0029c r11 = (C0029c) r10;
                if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.a.hashCode() * 31) + this.b.hashCode();
            }

            public final String toString() {
                return "CompleteSuccess(target=" + this.a + ", result=" + this.b + ')';
            }

            public C0029c(g r10, j r11) {
                Intrinsics.checkNotNullParameter(r10, "target");
                Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_RESULT);
                this.a = r10;
                this.b = r11;
            }
        }

        public static final class d extends c {
            public final Call<TypedInput> a;

            public final boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof d) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((d) r10).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "ExecuteTransport(call=" + this.a + ')';
            }

            public d(Call<TypedInput> r10) {
                Intrinsics.checkNotNullParameter(r10, "call");
                this.a = r10;
            }
        }

        public static final class e extends c {
            public final String a;

            public final boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof e) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((e) r10).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "LogInfo(message=" + this.a + ')';
            }

            public e(String r10) {
                Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
                this.a = r10;
            }
        }

        public static final class f extends c {
            public final String a;

            public final boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof f) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((f) r10).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "LogWarning(message=" + this.a + ')';
            }

            public f(String r10) {
                Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
                this.a = r10;
            }
        }

        public static final class g extends c {
            public static final g a = null;

            static {
                a = new g();
            }

            public g() {
            }
        }

        public static final class h extends c {
            public static final h a = null;

            static {
                a = new h();
            }

            public h() {
            }
        }

        public static final class i extends c {
            public final j a;
            public final long b;

            public final boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof i) == true) goto L8;
                return false;
            L8:
                i r11 = (i) r10;
                if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
                return false;
            L12:
                if (this.b == r11.b) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                int r0 = this.a.hashCode() * 31;
                long r1 = this.b;
                return r0 + ((int) (r1 ^ (r1 >>> 32)));
            }

            public final String toString() {
                return "ReportSuccess(result=" + this.a + ", duration=" + this.b + ')';
            }

            public i(j r10, long r11) {
                Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_RESULT);
                this.a = r10;
                this.b = r11;
            }
        }

        public static final class j extends c {
            public final Map<String, String> a;

            public final boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof j) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((j) r10).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "SendHeaders(headers=" + this.a + ')';
            }

            public j(Map<String, String> r10) {
                Intrinsics.checkNotNullParameter(r10, "headers");
                this.a = r10;
            }
        }

        public static final class k extends c {
            public final long a;
            public final long b;

            public final boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof k) == true) goto L8;
                return false;
            L8:
                k r11 = (k) r10;
                if (this.a == r11.a) goto L12;
                return false;
            L12:
                if (this.b == r11.b) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                long r0 = this.a;
                int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
                long r10 = this.b;
                return r1 + ((int) (r10 ^ (r10 >>> 32)));
            }

            public final String toString() {
                return "SendProgress(written=" + this.a + ", total=" + this.b + ')';
            }

            public k(long r1, long r10) {
                this.a = r1;
                this.b = r10;
            }
        }

        public static final class l extends c {
            public static final l a = null;

            static {
                a = new l();
            }

            public l() {
            }
        }

        public static final class m extends c {
            public static final m a = null;

            static {
                a = new m();
            }

            public m() {
            }
        }

        public c() {
        }
    }

    public static abstract class d {

        /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.net.download.a$d$a, reason: collision with other inner class name */
        public static final class C0030a extends d {
            public final String a;

            public final boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof C0030a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((C0030a) r10).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Cancel(message=" + this.a + ')';
            }

            public C0030a(String r10) {
                Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
                this.a = r10;
            }
        }

        public static final class b extends d {
            public final Call<TypedInput> a;

            public final boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((b) r10).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "CommitRequested(call=" + this.a + ')';
            }

            public b(Call<TypedInput> r10) {
                Intrinsics.checkNotNullParameter(r10, "call");
                this.a = r10;
            }
        }

        public static final class c extends d {
            public final e a;

            public final boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof c) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((c) r10).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "FileMoveFailed(failure=" + this.a + ')';
            }

            public c(e r10) {
                Intrinsics.checkNotNullParameter(r10, "failure");
                this.a = r10;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.net.download.a$d$d, reason: collision with other inner class name */
        public static final class C0031d extends d {
            public final j a;

            public final boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof C0031d) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((C0031d) r10).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "FileMoveSucceeded(result=" + this.a + ')';
            }

            public C0031d(j r10) {
                Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_RESULT);
                this.a = r10;
            }
        }

        public static final class e extends d {
            public final long a;
            public final long b;

            public final boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof e) == true) goto L8;
                return false;
            L8:
                e r11 = (e) r10;
                if (this.a == r11.a) goto L12;
                return false;
            L12:
                if (this.b == r11.b) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                long r0 = this.a;
                int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
                long r10 = this.b;
                return r1 + ((int) (r10 ^ (r10 >>> 32)));
            }

            public final String toString() {
                return "Progress(written=" + this.a + ", total=" + this.b + ')';
            }

            public e(long r1, long r10) {
                this.a = r1;
                this.b = r10;
            }
        }

        public static final class f extends d {
            public final Call<TypedInput> a;
            public final Map<String, String> b;

            public final boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof f) == true) goto L8;
                return false;
            L8:
                f r11 = (f) r10;
                if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.a.hashCode() * 31) + this.b.hashCode();
            }

            public final String toString() {
                return "ResponseAccepted(call=" + this.a + ", headers=" + this.b + ')';
            }

            public f(Call<TypedInput> r10, Map<String, String> r11) {
                Intrinsics.checkNotNullParameter(r10, "call");
                Intrinsics.checkNotNullParameter(r11, "headers");
                this.a = r10;
                this.b = r11;
            }
        }

        public static final class g extends d {
            public static final g a = null;

            static {
                a = new g();
            }

            public g() {
            }
        }

        public static final class h extends d {
            public final String a;

            public final boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof h) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((h) r10).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "TargetPreparationFailed(message=" + this.a + ')';
            }

            public h(String r10) {
                Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
                this.a = r10;
            }
        }

        public static final class i extends d {
            public final g a;

            public final boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof i) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((i) r10).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "TargetPrepared(target=" + this.a + ')';
            }

            public i(g r10) {
                Intrinsics.checkNotNullParameter(r10, "target");
                this.a = r10;
            }
        }

        public static final class j extends d {
            public static final j a = null;

            static {
                a = new j();
            }

            public j() {
            }
        }

        public static final class k extends d {
            public final Call<TypedInput> a;

            public final boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof k) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((k) r10).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "TransportCompleted(call=" + this.a + ')';
            }

            public k(Call<TypedInput> r10) {
                Intrinsics.checkNotNullParameter(r10, "call");
                this.a = r10;
            }
        }

        public static final class l extends d {
            public final e a;
            public final Call<TypedInput> b;

            public final boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof l) == true) goto L8;
                return false;
            L8:
                l r11 = (l) r10;
                if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                int r0 = this.a.hashCode() * 31;
                Call<TypedInput> r1 = this.b;
                if (r1 != null) goto L5;
                int r10 = 0;
            L7:
                return r0 + r10;
            L5:
                r10 = r1.hashCode();
                goto L7
            }

            public final String toString() {
                return "TransportFailed(failure=" + this.a + ", call=" + this.b + ')';
            }

            public l(e r10, Call<TypedInput> r11) {
                Intrinsics.checkNotNullParameter(r10, "failure");
                this.a = r10;
                this.b = r11;
            }
        }

        public static final class m extends d {
            public final Call<TypedInput> a;

            public final boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof m) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((m) r10).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "TransportStarted(call=" + this.a + ')';
            }

            public m(Call<TypedInput> r10) {
                Intrinsics.checkNotNullParameter(r10, "call");
                this.a = r10;
            }
        }

        public static final class n extends d {
            public static final n a = null;

            static {
                a = new n();
            }

            public n() {
            }
        }

        public static final class o extends d {
            public final String a;

            public final boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof o) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((o) r10).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "WhitelistRejected(message=" + this.a + ')';
            }

            public o(String r10) {
                Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
                this.a = r10;
            }
        }

        public d() {
        }
    }

    public static final class e {
        public final String a;
        public final Integer b;
        public final Map<String, String> c;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof e) == true) goto L8;
            return false;
        L8:
            e r11 = (e) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            Integer r1 = this.b;
            int r10 = 0;
            if (r1 != null) goto L5;
            int r11 = 0;
        L6:
            int r12 = (r0 + r11) * 31;
            Map<String, String> r13 = this.c;
            if (r13 == null) goto L11;
            r10 = r13.hashCode();
        L11:
            return r12 + r10;
        L5:
            r11 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "Failure(message=" + this.a + ", statusCode=" + this.b + ", headers=" + this.c + ')';
        }

        public e(String r10, Integer r11, Map<String, String> r12) {
            Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
            this.a = r10;
            this.b = r11;
            this.c = r12;
        }
    }

    public static final class f {
        public static final /* synthetic */ int c = 0;
        public final String a;
        public final String b;

        /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.net.download.a$f$a, reason: collision with other inner class name */
        public static final class C0032a {
        }

        static {
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof f) == true) goto L8;
            return false;
        L8:
            f r11 = (f) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "OwnerKey(appletId=" + this.a + ", containerId=" + this.b + ')';
        }

        public f(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "appletId");
            Intrinsics.checkNotNullParameter(r11, "containerId");
            this.a = r10;
            this.b = r11;
        }
    }

    public static final class g {
        public final com.bytedance.ai.file.a a;
        public final boolean b;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof g) == true) goto L8;
            return false;
        L8:
            g r11 = (g) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r11.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "PreparedTarget(file=" + this.a + ", isExplicit=" + this.b + ')';
        }

        public g(com.bytedance.ai.file.a r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r10, "file");
            this.a = r10;
            this.b = r11;
        }
    }

    public static final class h implements Executor {
        public final Executor a;
        public final ArrayDeque<Runnable> b;
        public final ThreadLocal<Boolean> c;
        public Runnable d;

        public final void b() {
            ArrayDeque<Runnable> r0 = this.b;
            monitor-enter(r0);
            Runnable r1 = this.b.pollFirst();     // Catch: Throwable -> L10
            this.d = r1;     // Catch: Throwable -> L10
            if (r1 == null) goto L7;
            this.a.execute(r1);     // Catch: Throwable -> L10
        L7:
            Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L10
            monitor-exit(r0);
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public h(Executor r10) {
            Intrinsics.checkNotNullParameter(r10, "executor");
            this.a = r10;
            this.b = new ArrayDeque();
            this.c = new ThreadLocal();
        }

        public final <T> T a(final Function0<? extends T> r10) {
            Intrinsics.checkNotNullParameter(r10, "block");
            if (Intrinsics.areEqual(this.c.get(), Boolean.TRUE) == true) goto L5;
            FutureTask r0 = new FutureTask(new m(r10));
            execute(r0);
            return (T) r0.get();
        L5:
            return (T) r10.invoke();
        }

        @Override // java.util.concurrent.Executor
        public final void execute(final Runnable r10) {
            Intrinsics.checkNotNullParameter(r10, "command");
            ArrayDeque<Runnable> r0 = this.b;
            monitor-enter(r0);
            this.b.addLast(new l(this, r10));     // Catch: Throwable -> L12
            if (this.d != null) goto L9;
            Runnable r11 = this.b.pollFirst();     // Catch: Throwable -> L12
            this.d = r11;     // Catch: Throwable -> L12
            if (r11 == null) goto L9;
            this.a.execute(r11);     // Catch: Throwable -> L12
        L9:
            Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L12
            monitor-exit(r0);
            return;
        L12:
            th = move-exception;
            throw th;
        }
    }

    public static abstract class i {
        public final String a;

        /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.net.download.a$i$a, reason: collision with other inner class name */
        public static final class C0033a extends i {
            public final g b;
            public final Call<TypedInput> c;

            public final boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof C0033a) == true) goto L8;
                return false;
            L8:
                C0033a r11 = (C0033a) r10;
                if (Intrinsics.areEqual(this.b, r11.b) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.c, r11.c) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.b.hashCode() * 31) + this.c.hashCode();
            }

            public final String toString() {
                return "Committing(target=" + this.b + ", call=" + this.c + ')';
            }

            public C0033a(g r10, Call<TypedInput> r11) {
                Intrinsics.checkNotNullParameter(r10, "target");
                Intrinsics.checkNotNullParameter(r11, "call");
                super("committing");
                this.b = r10;
                this.c = r11;
            }
        }

        public static final class b extends i {
            public final g b;
            public final Call<TypedInput> c;

            public final boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof b) == true) goto L8;
                return false;
            L8:
                b r11 = (b) r10;
                if (Intrinsics.areEqual(this.b, r11.b) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.c, r11.c) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.b.hashCode() * 31) + this.c.hashCode();
            }

            public final String toString() {
                return "Downloading(target=" + this.b + ", call=" + this.c + ')';
            }

            public b(g r10, Call<TypedInput> r11) {
                Intrinsics.checkNotNullParameter(r10, "target");
                Intrinsics.checkNotNullParameter(r11, "call");
                super("downloading");
                this.b = r10;
                this.c = r11;
            }
        }

        public static final class c extends i {
            public static final c b = null;

            static {
                b = new c();
            }

            public c() {
                super("preparing");
            }
        }

        public static final class d extends i {
            public final g b;
            public final Call<TypedInput> c;

            public final boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof d) == true) goto L8;
                return false;
            L8:
                d r11 = (d) r10;
                if (Intrinsics.areEqual(this.b, r11.b) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.c, r11.c) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.b.hashCode() * 31) + this.c.hashCode();
            }

            public final String toString() {
                return "ProcessingResult(target=" + this.b + ", call=" + this.c + ')';
            }

            public d(g r10, Call<TypedInput> r11) {
                Intrinsics.checkNotNullParameter(r10, "target");
                Intrinsics.checkNotNullParameter(r11, "call");
                super("processingResult");
                this.b = r10;
                this.c = r11;
            }
        }

        public static final class e extends i {
            public static final e b = null;

            static {
                b = new e();
            }

            public e() {
                super("registered");
            }
        }

        public static final class f extends i {
            public final g b;

            public final boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof f) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.b, ((f) r10).b) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.b.hashCode();
            }

            public final String toString() {
                return "Starting(target=" + this.b + ')';
            }

            public f(g r10) {
                Intrinsics.checkNotNullParameter(r10, "target");
                super("starting");
                this.b = r10;
            }
        }

        public static final class g extends i {
            public static final g b = null;

            static {
                b = new g();
            }

            public g() {
                super("terminal");
            }
        }

        public static final class h extends i {
            public static final h b = null;

            static {
                b = new h();
            }

            public h() {
                super("validating");
            }
        }

        public i(String r1) {
            this.a = r1;
        }
    }

    public static final class j {
        public final int a;
        public final Map<String, String> b;
        public final long c;
        public final long d;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof j) == true) goto L8;
            return false;
        L8:
            j r11 = (j) r10;
            if (this.a == r11.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r11.c) goto L18;
            return false;
        L18:
            if (this.d == r11.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a * 31) + this.b.hashCode()) * 31;
            long r1 = this.c;
            int r10 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
            long r11 = this.d;
            return r10 + ((int) (r11 ^ (r11 >>> 32)));
        }

        public final String toString() {
            return "SuccessResult(statusCode=" + this.a + ", headers=" + this.b + ", downloadedBytes=" + this.c + ", expectedBytes=" + this.d + ')';
        }

        public j(int r10, Map<String, String> r11, long r12, long r13) {
            Intrinsics.checkNotNullParameter(r11, "headers");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r13;
        }
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void d() {
    }

    static {
        c = new Regex("https?://\\S+", RegexOption.IGNORE_CASE);
        d = TTExecutors.getNormalExecutor();
        e = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void onDestroy() {
        Object r0 = this.a;
        monitor-enter(r0);
        Collection r1 = ((LinkedHashMap) this.b).values();     // Catch: Throwable -> L15
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L15
        Iterator r11 = r1.iterator();     // Catch: Throwable -> L15
    L6:
        if (r11.hasNext() == false) goto L8;
        CollectionsKt.addAll(r10, ((Map) r11.next()).values());     // Catch: Throwable -> L15
        goto L6
    L8:
        ((LinkedHashMap) this.b).clear();     // Catch: Throwable -> L15
        monitor-exit(r0);
        Iterator r12 = r10.iterator();
    L12:
        if (r12.hasNext() == false) goto L14;
        ((b) r12.next()).b();
        goto L12
    L14:
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public a() {
        this.a = new Object();
        this.b = new LinkedHashMap();
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

    public final void i(e3.a r10) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        int r0 = f.c;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        a0 r11 = r10.getContainerContext();
        List r1 = null;
        if (r11 == null) goto L8;
        Intrinsics.checkNotNullParameter(r11, "containerContext");
        String r12 = r11.getAppletId();
        if (r12 != null) goto L7;
        r12 = "";
    L7:
        f r13 = new f(r12, r11.getContainerId());
    L9:
        if (r13 != null) goto L11;
        return;
    L11:
        Object r14 = this.a;
        monitor-enter(r14);
        Map<String, b> r15 = this.b.remove(r13);     // Catch: Throwable -> L26
        if (r15 == null) goto L18;
        Collection<b> r16 = r15.values();     // Catch: Throwable -> L26
        if (r16 == null) goto L18;
        r1 = CollectionsKt.toList(r16);     // Catch: Throwable -> L26
    L18:
        if (r1 != null) goto L20;
        r1 = CollectionsKt.emptyList();     // Catch: Throwable -> L26
    L20:
        monitor-exit(r14);
        Iterator r17 = r1.iterator();
    L23:
        if (r17.hasNext() == false) goto L25;
        ((b) r17.next()).b();
        goto L23
    L25:
        return;
    L26:
        th = move-exception;
        throw th;
    L8:
        r13 = null;
        goto L9
    }

    public static final long c(a r10, Map r11) {
        r10.getClass();
        Iterator r12 = ((LinkedHashMap) r11).entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Object r13 = r12.next();
        if (StringsKt.equals((String) ((Map.Entry) r13).getKey(), "content-length", true) == false) goto L4;
    L9:
        Map.Entry r14 = (Map.Entry) r13;
        if (r14 == null) goto L16;
        String r15 = (String) r14.getValue();
        if (r15 == null) goto L16;
        Long r16 = StringsKt.toLongOrNull(r15);
        if (r16 == null) goto L16;
        return r16.longValue();
    L16:
        return -1;
    L8:
        r13 = null;
        goto L9
    }

    public static final String e(a r10, String r11) {
        r10.getClass();
        if (r11 != null) goto L5;
    L9:
        r11 = "downloadFile failed";
    L11:
        if (StringsKt.startsWith$default(r11, "downloadFile:fail", false, 2, null) == false) goto L14;
        return r11;
    L14:
        return "downloadFile:fail ".concat(r11);
    L5:
        if ((!StringsKt.isBlank(r11)) == true) goto L8;
        r11 = null;
    L8:
        if (r11 != null) goto L11;
        goto L9
    }

    public static void j(String r10, String r11, String r12, String r13) {
        com.bytedance.ai.utils.g.a.w("AppletDownloadFileManager", "[AppletDownload] applet=" + r10 + " containerType=" + r11 + " task=" + r12 + " reason=" + r13);
    }

    public static final Call b(a r10, String r11, Map r12, long r13, IHostNetworkDepend r14) {
        r10.getClass();
        LinkedHashMap r15 = new LinkedHashMap();
        android.util.Pair r16 = UrlUtils.parseUrl(new UrlBuilder(r11).build(), r15);
        String r17 = (String) r16.first;
        String r18 = (String) r16.second;
        RequestContext r19 = new RequestContext();
        ((BaseRequestContext) r19).timeout_connect = r13;
        ((BaseRequestContext) r19).timeout_read = r13;
        ((BaseRequestContext) r19).timeout_write = r13;
        ((BaseRequestContext) r19).force_handle_response = true;
        ((BaseRequestContext) r19).followRedirectInternal = false;
        Boolean r0 = Boolean.FALSE;
        Map<String, ? extends Object> r110 = MapsKt.mapOf(new Pair[]{TuplesKt.to("isCustomizedCookie", r0), TuplesKt.to("needAddCommonParams", r0)});
        Intrinsics.checkNotNull(r17);
        IAppletRetrofit r111 = r14.createRetrofit(r17, false, r110);
        if (r111 == null) goto L31;
        IHostNetworkRuntimeApi r1 = (IHostNetworkRuntimeApi) r111.create(IHostNetworkRuntimeApi.class);
        if (r1 == null) goto L32;
        ArrayList r20 = new ArrayList();
        Iterator r112 = r12.entrySet().iterator();
    L8:
        if (r112.hasNext() == false) goto L25;
        Map.Entry r113 = (Map.Entry) r112.next();
        String r114 = (String) r113.getKey();
        String r115 = (String) r113.getValue();
        String r116 = StringsKt.trim(r114).toString();
        String r21 = r116.toLowerCase(Locale.ROOT);
        if ((!StringsKt.isBlank(r116)) == true) goto L12;
    L21:
        Header r22 = null;
    L22:
        if (r22 == null) goto L8;
        r20.add(r22);
        goto L8
    L12:
        if (r115.length() <= 0) goto L14;
        boolean r23 = true;
    L15:
        if (r23 == false) goto L21;
        if (Intrinsics.areEqual(r21, "referer") == true) goto L21;
        if (Intrinsics.areEqual(r21, "user-agent") == true) goto L21;
        r22 = new Header(r116, r115);
        goto L22
    L14:
        r23 = false;
        goto L15
    L25:
        return r1.streamGet(false, -1, r18, r15, r20, r19);
    L32:
        return null;
    L31:
        return null;
    }

    public final String f(e3.d r24, String r25, Map<String, ? extends Object> r26, Long r27, String r28, String r29, f3.h<AbsDownloadFileMethodIDL.b> r30) {
        Intrinsics.checkNotNullParameter(r24, "bridgeContext");
        Intrinsics.checkNotNullParameter(r25, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r29, "downloadTaskId");
        Intrinsics.checkNotNullParameter(r30, "callback");
        a0 r0 = r24.getContainerContext();
        if (r0 != null) goto L6;
        j("unknown", "unknown", r29, "bridge context is unavailable");
        return "downloadFile:fail bridge context is unavailable";
    L6:
        int r1 = f.c;
        Intrinsics.checkNotNullParameter(r0, "containerContext");
        String r10 = r0.getAppletId();
        if (r10 != null) goto L9;
        r10 = "";
    L9:
        f r12 = new f(r10, r0.getContainerId());
        String r11 = r0.getContainerType().getTypeName();
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L12
        Object r14 = Result.constructor-impl(new URI(r25));     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r14) == false) goto L17;
        r14 = null;
    L17:
        URI r15 = (URI) r14;
        if (r15 == null) goto L22;
        String r16 = r15.getScheme();
        if (r16 == null) goto L22;
        String r17 = r16.toLowerCase(Locale.ROOT);
    L24:
        if (Intrinsics.areEqual(r17, "https") == true) goto L27;
        j(r12.a, r11, r29, "url is invalid");
        return "downloadFile:fail url is invalid";
    L27:
        String r18 = r12.a;
        AppletAppManagerService.INSTANCE.getClass();
        OnlineAppletApplication r19 = AppletAppManagerService.b(r18);
        if (r19 == null) goto L30;
        AppletFileManager r20 = r19.J();
    L31:
        if (r20 != null) goto L34;
        j(r12.a, r11, r29, "file manager is unavailable");
        return "downloadFile:fail file manager is unavailable";
    L34:
        if (r26 != null) goto L36;
        Map<String, ? extends Object> r21 = MapsKt.emptyMap();
    L37:
        ArrayList r22 = new ArrayList();
        Iterator<Map.Entry<String, ? extends Object>> r23 = r21.entrySet().iterator();
    L38:
        boolean r110 = false;
        if (r23.hasNext() == false) goto L70;
        Map.Entry<String, ? extends Object> r31 = r23.next();
        String r32 = r31.getKey();
        Object r33 = r31.getValue();
        String r34 = StringsKt.trim(r32).toString();
        if (r33 != null) goto L44;
        String r35 = "";
    L60:
        if (StringsKt.isBlank(r34) == false) goto L62;
    L67:
        Pair r36 = null;
    L68:
        if (r36 == null) goto L38;
        r22.add(r36);
        goto L38
    L62:
        if (r35.length() != 0) goto L64;
        r110 = true;
    L64:
        if (r110 == true) goto L67;
        r36 = TuplesKt.to(r34, r35);
        goto L68
    L44:
        if ((r33 instanceof String) == false) goto L47;
        r35 = (String) r33;
        goto L60
    L47:
        if ((r33 instanceof Number) == false) goto L49;
    L58:
        r35 = r33.toString();
        goto L60
    L49:
        if ((r33 instanceof Boolean) == true) goto L58;
        if ((r33 instanceof Map) == false) goto L55;
        r35 = new JSONObject((Map) r33).toString();
        goto L60
    L55:
        if ((r33 instanceof List) == false) goto L57;
        r35 = new JSONArray((Collection) r33).toString();
        goto L60
    L57:
        r35 = r33.toString();
        goto L60
    L70:
        Map r37 = MapsKt.toMap(r22);
        if (r27 != null) goto L73;
    L81:
        long r38 = 60000;
    L82:
        long r111 = r38;
        IHostNetworkDepend r39 = r4.a.c;
        if (r39 != null) goto L85;
        r39 = new b4.a();
    L85:
        b r40 = new b(this, r29, r12, r11, r24, r20, r25, r37, r111, r28, r39, r30);
        Object r41 = this.a;
        monitor-enter(r41);
        Map r42 = (Map) ((LinkedHashMap) this.b).get(r12);     // Catch: Throwable -> L115
        if (r42 == null) goto L92;
        String r43 = r29;
        if (r42.containsKey(r43) != true) goto L93;
        boolean r44 = true;
    L94:
        if (r44 == false) goto L99;
        com.bytedance.ai.utils.g.a.w("AppletDownloadFileManager", "[AppletDownload] applet=" + r12.a + " containerType=" + r11 + " task=" + r43 + " reason=duplicate");     // Catch: Throwable -> L115
        monitor-exit(r41);
        return "downloadFile:fail downloadTaskId already exists";
    L99:
        Iterator r45 = ((LinkedHashMap) this.b).values().iterator();     // Catch: Throwable -> L115
        int r46 = 0;
    L101:
        if (r45.hasNext() == false) goto L104;
        r46 = r46 + ((Map) r45.next()).size();     // Catch: Throwable -> L115
        goto L101
    L104:
        if (r46 < 10) goto L108;
        com.bytedance.ai.utils.g.a.w("AppletDownloadFileManager", "[AppletDownload] applet=" + r12.a + " containerType=" + r11 + " task=" + r43 + " reason=task_limit limit=10");     // Catch: Throwable -> L115
        monitor-exit(r41);
        return "downloadFile:fail exceed max download connection count 10";
    L108:
        LinkedHashMap r47 = (LinkedHashMap) this.b;     // Catch: Throwable -> L115
        Object r48 = r47.get(r12);     // Catch: Throwable -> L115
        if (r48 != null) goto L111;
        r48 = new LinkedHashMap();     // Catch: Throwable -> L115
        r47.put(r12, r48);     // Catch: Throwable -> L115
    L111:
        ((Map) r48).put(r43, r40);     // Catch: Throwable -> L115
        Unit r49 = Unit.INSTANCE;     // Catch: Throwable -> L115
        monitor-exit(r41);
        long r50 = SystemClock.elapsedRealtime();
        r40.o = Long.valueOf(r50);
        r40.p = BuildersKt.launch$default(e, null, null, new AppletDownloadFileManager$DownloadTask$start$1(r50 + r40.h, r40, null), 3, null);
        r40.d(d.g.a);
        return null;
    L93:
        r44 = false;
        goto L94
    L92:
        r43 = r29;
    L115:
        th = move-exception;
        throw th;
    L73:
        if (r27.longValue() <= 0) goto L75;
        boolean r51 = true;
    L76:
        if (r51 == false) goto L78;
        Long r52 = r27;
    L79:
        if (r52 == null) goto L81;
        r38 = RangesKt.coerceAtMost(r52.longValue(), 300000);
        goto L82
    L78:
        r52 = null;
        goto L79
    L75:
        r51 = false;
        goto L76
    L36:
        r21 = r26;
        goto L37
    L30:
        r20 = null;
    L22:
        r17 = null;
    L12:
        th = move-exception;
        Result.Companion r53 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }
}
