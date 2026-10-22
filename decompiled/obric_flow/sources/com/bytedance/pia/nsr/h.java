package com.bytedance.pia.nsr;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.core.view.PointerIconCompat;
import com.bytedance.pia.core.metrics.PvEventType;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.utils.m;
import com.google.common.reflect.w;
import com.google.gson.Gson;
import com.lynx.tasm.p;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import ko.r;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f7194a = null;

    static {
        f7194a = new r(5);
    }

    public static WebResourceResponse a(String r12, nh.d r13) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Gson r5 = yg.b.g;
        yg.b r10 = com.lynx.tasm.utils.j.e(r12, r13);
        if (r10 != null) goto L5;
    L36:
        return null;
    L5:
        if (r10.f != true) goto L36;
        r13.f20239j.a(PvEventType.d, 0);
        Lazy r11 = Settings.B;
        boolean r14 = p.a().p();
        kh.c r15 = r13.f20239j;
        if (r14 == true) goto L10;
        r15.b(PointerIconCompat.TYPE_CROSSHAIR, "nsr_render", "");
        return null;
    L10:
        r r16 = f7194a;
        r16.i();
        i r17 = com.lynx.tasm.base.a.c(r12);
        if (r17 == null) goto L31;
        HashMap r18 = (HashMap) r16.f18728b;
        Iterator r19 = r18.keySet().iterator();
    L15:
        if (r19.hasNext() == false) goto L21;
        Object r20 = r19.next();
        i r21 = (i) r20;
        if (Intrinsics.areEqual(r21.f7195a, r17.f7195a) == false) goto L15;
        if (r17.f7196b.containsAll(r21.f7196b) == false) goto L15;
    L22:
        i r22 = (i) r20;
        if (r22 == null) goto L31;
        j r23 = (j) r18.get(r22);
        if (r23 != null) goto L27;
    L29:
        if (r23 == null) goto L31;
        String r24 = r23.f7199b;
    L32:
        if (r24 == null) goto L35;
        com.bytedance.pia.core.utils.j.C("[NSR] Get NSR HTML (URL: " + r12 + ')', null);
        r15.a(PvEventType.d, 1);
        return new WebResourceResponse("text/html", "utf-8", new ByteArrayInputStream(r24.getBytes(Charsets.UTF_8)));
    L35:
        r15.b(PointerIconCompat.TYPE_TEXT, "nsr_render", "");
        goto L36
    L27:
        if (r23.f7198a != true) goto L29;
        Intrinsics.checkNotNullParameter(r22, "entry");
        r18.remove(r22);
        CollectionsKt.x((PriorityQueue) r16.f18729c, new RecordsCache$remove$1(r22));
        goto L29
    L21:
        r20 = null;
    L31:
        r24 = null;
        goto L32
    }

    public static void b(String r16, long r17, String r19, boolean r20, nh.d r21, Function2 r22, Function1 r23) {
        Intrinsics.checkNotNullParameter(r16, "url");
        Intrinsics.checkNotNullParameter(r21, "runtime");
        Gson r5 = yg.b.g;
        yg.b r10 = com.lynx.tasm.utils.j.e(r16, r21);
        if (r10 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L9;
        ((Handler) m.f7157c.getValue()).post(new b(r16, r17, r19, r20, r21, r22, r23));
        return;
    L9:
        View r11 = r21.c();
        if ((r11 instanceof WebView) == false) goto L12;
        WebView r12 = (WebView) r11;
    L13:
        if (r12 == null) goto L17;
        WebSettings r13 = r12.getSettings();
        if (r13 == null) goto L17;
        String r14 = r13.getUserAgentString();
    L18:
        com.bytedance.pia.core.utils.j.y(sj.g.j("[NSR] Starting renderInternal NSR, script: null, userAgent: ", r17, r14, ", expires: "), null);
        a r15 = new a();
        w r18 = r21.f20247r;
        r18.getClass();
        m.b(new a2.b(11, r18, r15));
        AtomicBoolean r24 = new AtomicBoolean(false);
        g r110 = new g(r24, r10, r21, r15, r22);
        f r111 = new f(r24, r21, r10, r15, r23);
        Lazy r25 = Settings.B;
        if (p.a().p() == true) goto L22;
        r21.f20239j.b(PointerIconCompat.TYPE_CROSSHAIR, "nsr_worker", "");
        r111.a("disabled by setting.");
        return;
    L22:
        AtomicBoolean r26 = rh.h.f21759a;
        String r27 = r10.f23260a.toString();
        r r28 = f7194a;
        r28.i();
        i r29 = com.lynx.tasm.base.a.c(r27);
        if (r29 != null) goto L25;
        String r30 = null;
    L41:
        String r31 = r30;
    L42:
        if (r31 == null) goto L68;
        r110.a(r31, true);
        return;
    L68:
        Result.Companion r32 = Result.Companion;     // Catch: Throwable -> L51
        rh.f r33 = new rh.f();     // Catch: Throwable -> L51
        r33.f21750h = "NSR";     // Catch: Throwable -> L51
        r33.f21747a = r21.g.toString();     // Catch: Throwable -> L51
        r33.d = r21.f20240k;     // Catch: Throwable -> L51
        r33.f21749c = r21;     // Catch: Throwable -> L51
        r33.f21748b = Uri.withAppendedPath(r10.f23262c, "assets/js/" + r10.f23261b + ".pia.nsr.js").toString();     // Catch: Throwable -> L51
        r33.g = false;     // Catch: Throwable -> L51
        f r112 = r111;
        r33.e = new e(r111, r10, r17, r20, r110);     // Catch: Throwable -> L49
        Object r34 = Result.m124constructorimpl(r33.a());     // Catch: Throwable -> L49
    L54:
        Throwable r35 = Result.m127exceptionOrNullimpl(r34);
        if (r35 == null) goto L58;
        r112.a(r35.toString());
    L58:
        if (Result.m130isFailureimpl(r34) == false) goto L60;
        Object r113 = r30;
    L61:
        rh.g r114 = (rh.g) r113;
        if (r114 == null) goto L75;
        ((Handler) m.f7156b.getValue()).post(new ab.b(14, r114, r112));
        return;
    L75:
        return;
    L60:
        r113 = r34;
    L49:
        th = th;
    L53:
        Result.Companion r36 = Result.Companion;
        r34 = Result.m124constructorimpl(ResultKt.createFailure(th));
    L51:
        th = th;
        r112 = r111;
        goto L53
    L25:
        HashMap r37 = (HashMap) r28.f18728b;
        Iterator r115 = r37.keySet().iterator();
    L27:
        if (r115.hasNext() == false) goto L34;
        Object r116 = r115.next();
        i r117 = (i) r116;
        if (Intrinsics.areEqual(r117.f7195a, r29.f7195a) == false) goto L27;
        if (r29.f7196b.containsAll(r117.f7196b) == false) goto L27;
    L35:
        final i r118 = (i) r116;
        if (r118 != null) goto L38;
    L37:
        r30 = null;
        goto L41
    L38:
        j r38 = (j) r37.get(r118);
        if (r38 == null) goto L37;
        PriorityQueue r39 = (PriorityQueue) r28.f18729c;
        CollectionsKt.x(r39, new RecordsCache$tryUpdateExistRecord$1$1(r118));
        r38.f7198a = r20;
        r39.add(new Pair(Long.valueOf(System.currentTimeMillis() + r17), r118));
        r30 = null;
        com.bytedance.pia.core.utils.j.y("Update nsr record, url=" + r27 + ", once=" + r20 + ", expire=" + r17, null);
        r31 = r38.f7199b;
        goto L42
    L34:
        r116 = null;
    L17:
        r14 = null;
        goto L18
    L12:
        r12 = null;
        goto L13
    }
}
