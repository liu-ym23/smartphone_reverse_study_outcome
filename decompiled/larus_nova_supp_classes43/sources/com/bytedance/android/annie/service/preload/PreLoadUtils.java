package com.bytedance.android.annie.service.preload;

import android.net.Uri;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.resource.AnnieResType;
import com.bytedance.android.annie.ng.g;
import com.bytedance.android.annie.resource.n;
import com.bytedance.android.annie.resource.o;
import com.bytedance.android.annie.service.resource.RequestConfig;
import com.bytedance.android.annie.service.resource.d;
import com.bytedance.android.annie.service.resource.h;
import com.bytedance.android.ec.core.utils.FontWeight;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.schedulers.Schedulers;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import k9.e;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import o8.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class PreLoadUtils {
    public static final PreLoadUtils a = null;
    public static final Lazy b = null;
    public static final List<String> c = null;

    public static final class a implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Long d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;

        public a(int r1, String r10, String r11, Long r12, String r13, String r14) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
        }

        public final void a() {
            int r1 = this.a;
            String r10 = this.b;
            String r11 = this.c;
            Long r12 = this.d;
            String r13 = this.e;
            String r14 = this.f;
            Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L20
            int r16 = x8.a.a;     // Catch: Throwable -> L20
            x8.a.b("preload", "error_code:" + r1 + " error_msg " + r10 + " url " + r11 + " version " + r12 + " monitorID " + r13, false);     // Catch: Throwable -> L20
            j9.b r0 = ((e) Annie.getService$default(e.class, null, 2, null)).H0();     // Catch: Throwable -> L20
            JSONObject r17 = new JSONObject();     // Catch: Throwable -> L20
            if (r11 == null) goto L6;
            r17.put(com.bytedance.android.ec.core.event.a.KEY_URL, r11);     // Catch: Throwable -> L20
        L6:
            if (r13 == null) goto L8;
            r17.put("container_trace_id", r13);     // Catch: Throwable -> L20
        L8:
            r17.put(com.bytedance.android.ec.core.event.a.KEY_ERROR_CODE, r1);     // Catch: Throwable -> L20
            r17.put(com.bytedance.android.ec.core.event.a.KEY_ERROR_MSG, r10);     // Catch: Throwable -> L20
            if (r12 == null) goto L11;
            r17.put("package_version", r12.longValue());     // Catch: Throwable -> L20
        L11:
            Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L20
            JSONObject r19 = new JSONObject();     // Catch: Throwable -> L20
            com.bytedance.android.annie.ng.a r20 = g.c.get(r14);     // Catch: Throwable -> L20
            if (r20 == null) goto L17;
            f r21 = r20.b;     // Catch: Throwable -> L20
            if (r21 == null) goto L17;
            String r22 = r21.a;     // Catch: Throwable -> L20
            if (r22 == null) goto L17;
        L18:
            r19.put("virtual_aid", r22);     // Catch: Throwable -> L20
            r0.b(null, "ttlive_container_preload_error", r11, r17, null, null, r19, 0, r13);     // Catch: Throwable -> L20
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L20
            return;
        L17:
            r22 = "88888";
        L20:
            th = move-exception;
            Result.Companion r23 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
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

    public PreLoadUtils() {
    }

    static {
        a = new PreLoadUtils();
        b = LazyKt.lazy(PreLoadUtils$preloadResourceHolder$2.INSTANCE);
        c = CollectionsKt.listOf(new String[]{"main", "all"});
    }

    public static void b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "src");
        b r0 = (b) b.getValue();
        monitor-enter(r0);
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);     // Catch: Throwable -> L12
        if (r0.b.size() < r0.a) goto L9;
        String r1 = (String) CollectionsKt.firstOrNull(r0.b);     // Catch: Throwable -> L12
        if (r1 == null) goto L9;
        r0.b.remove(r1);     // Catch: Throwable -> L12
    L9:
        r0.b.add(r10);     // Catch: Throwable -> L12
        monitor-exit(r0);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static final Pair a(PreLoadUtils r16, String r17, com.bytedance.android.annie.param.a r18, String r19) {
        r16.getClass();
        Uri r1 = UriProtector.parse(r17);
        String r10 = r1.getPath();
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        d r11 = n.b(r17, r10);
        String r12 = r1.buildUpon().path(r10.substring(0, r10.length() - r11.c.length()) + "preload.json").build().toString();
        RequestConfig r13 = new RequestConfig(AnnieResType.PRELOAD_CONFIG);
        r13.d = true;
        r13.c = true;
        if (r18 == null) goto L10;
        String r14 = r18.getMonitorID();
        if (r14 == null) goto L10;
        r13.a().put("rl_container_uuid", r14);
    L10:
        if (r19 == null) goto L12;
        r13.h = r19;
    L12:
        h r0 = n.h(r12, r13);
        if (r0 == null) goto L15;
        o r15 = r0.b();
    L16:
        if (r15 == null) goto L18;
        InputStream r20 = r15.c();
    L19:
        if (r20 != null) goto L67;
    L62:
        d(r16, 200, "file read failed  url " + r17 + " preload file url " + r12 + " geckoInfo " + r11, r17, null, r18.getMonitorID(), r18.getBizKey(), 8);
        Unit r21 = Unit.INSTANCE;
    L64:
        return new Pair(null, null);
    L67:
        Reader r22 = new InputStreamReader(r20, Charsets.UTF_8);     // Catch: Throwable -> L53
        if ((r22 instanceof BufferedReader) == false) goto L24;
        BufferedReader r23 = (BufferedReader) r22;     // Catch: Throwable -> L53
    L69:
        String r110 = TextStreamsKt.readText(r23);     // Catch: Throwable -> L46
        CloseableKt.closeFinally(r23, null);     // Catch: Throwable -> L53
        String r24 = (String) ListProtector.get(StringsKt.split$default((CharSequence) ListProtector.get(StringsKt.split$default(r17, new String[]{"?"}, false, 0, 6, null), 0), new String[]{"#"}, false, 0, 6, null), 0);     // Catch: Throwable -> L53
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L36
        JSONObject r26 = JSONObjectProtectorUtils.getJSONObject(new JSONObject(r110), r24);     // Catch: Throwable -> L36
        if (r26 != null) goto L71;
        PreLoadUtils r27 = a;     // Catch: Throwable -> L36
        String r28 = "can't get config url = " + r24;     // Catch: Throwable -> L36
        if (r15 == null) goto L33;
        Long r29 = Long.valueOf(r15.f);     // Catch: Throwable -> L36
    L34:
        String r30 = r18.getMonitorID();     // Catch: Throwable -> L36
        String r31 = r18.getBizKey();     // Catch: Throwable -> L36
        r27.getClass();     // Catch: Throwable -> L36
        c(301, r28, r17, r29, r30, r31);     // Catch: Throwable -> L36
        Object r32 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L36
    L38:
        Throwable r33 = Result.exceptionOrNull-impl(r32);     // Catch: Throwable -> L53
        if (r33 == null) goto L61;
        PreLoadUtils r34 = a;     // Catch: Throwable -> L53
        String r35 = "parse preload json failed msg = " + r33.getMessage();     // Catch: Throwable -> L53
        if (r15 == null) goto L43;
        Long r36 = Long.valueOf(r15.f);     // Catch: Throwable -> L53
    L44:
        String r37 = r18.getMonitorID();     // Catch: Throwable -> L53
        String r38 = r18.getBizKey();     // Catch: Throwable -> L53
        r34.getClass();     // Catch: Throwable -> L53
        c(FontWeight.WEIGHT_300, r35, r17, r36, r37, r38);     // Catch: Throwable -> L53
        goto L61
    L43:
        r36 = null;
    L61:
        if (r110 != null) goto L64;
    L33:
        r29 = null;
        goto L34
    L71:
        return new Pair(Long.valueOf(r15.f), r26);
    L36:
        th = move-exception;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L53
        r32 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L53
        goto L38
    L46:
        th = move-exception;
        throw th;     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        CloseableKt.closeFinally(r23, th);     // Catch: Throwable -> L53
        throw th;     // Catch: Throwable -> L53
    L24:
        r23 = new BufferedReader(r22, 8192);     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        PreLoadUtils r40 = a;
        String r41 = th.getMessage();
        if (r41 != null) goto L57;
        r41 = "file read failed";
    L57:
        if (r15 == null) goto L59;
        Long r42 = Long.valueOf(r15.f);
    L60:
        String r43 = r18.getMonitorID();
        String r44 = r18.getBizKey();
        r40.getClass();
        c(201, r41, r17, r42, r43, r44);
        r110 = Unit.INSTANCE;
        goto L61
    L59:
        r42 = null;
        goto L60
    L18:
        r20 = null;
        goto L19
    L15:
        r15 = null;
        goto L16
    }

    public static void c(int r10, String r11, String r12, Long r13, String r14, String r15) {
        Schedulers.computation().scheduleDirect(new a(r10, r11, r12, r13, r14, r15));
    }

    public static /* synthetic */ void d(PreLoadUtils r10, int r11, String r12, String r13, Long r14, String r15, String r16, int r17) {
        if ((r17 & 4) == 0) goto L5;
        String r18 = null;
    L7:
        if ((r17 & 8) == 0) goto L9;
        Long r19 = null;
    L11:
        if ((r17 & 16) == 0) goto L13;
        String r20 = null;
    L15:
        if ((r17 & 32) == 0) goto L17;
        r16 = "host";
    L17:
        r10.getClass();
        c(r11, r12, r18, r19, r20, r16);
        return;
    L13:
        r20 = r15;
        goto L15
    L9:
        r19 = r14;
        goto L11
    L5:
        r18 = r13;
        goto L7
    }
}
