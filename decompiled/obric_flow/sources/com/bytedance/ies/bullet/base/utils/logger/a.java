package com.bytedance.ies.bullet.base.utils.logger;

import android.os.Handler;
import com.bytedance.ies.bullet.core.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import xc.d;
import xc.e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f5258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f5259b = null;

    static {
        ConcurrentHashMap r5 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(e.class, "cls");
        e r10 = (e) yc.a.a(e.class, "default_bid");
        if (r10 == null) goto L7;
        d r11 = (d) r10.a(d.class);
        if (r11 == null) goto L7;
        int r12 = r11.p();
    L8:
        f5258a = r12;
        f5259b = LazyKt.lazy(HybridLogger$logHandler$2.f5254a);
        return;
    L7:
        r12 = 4;
        goto L8
    }

    public static final String a(String r5) {
        StringBuilder r10 = new StringBuilder("HybridLogger");
        if (r5 == null) goto L9;
        if (StringsKt.isBlank(r5) == true) goto L9;
        r10.append("_");
        r10.append(r5);
    L9:
        return r10.toString();
    }

    public static final String b(String r5, Map r10, b r11) {
        if (r10 != null) goto L4;
    L5:
        if (r11 != null) goto L7;
        return r5;
    L7:
        StringBuffer r12 = new StringBuffer(r5);
        if (r10 != null) goto L10;
    L13:
        if (r11 == null) goto L15;
        ArrayList r13 = r11.f5260a;
    L16:
        if (r13 == null) goto L30;
        if (r13.isEmpty() == true) goto L30;
        JSONObject r14 = new JSONObject();
        if (r11 == null) goto L28;
        ArrayList r15 = r11.f5260a;
        if (r15 == null) goto L28;
        Iterator r16 = r15.iterator();
    L26:
        if (r16.hasNext() == false) goto L28;
        c r17 = (c) r16.next();
        r14.put(r17.f5261a, r17.f5262b);
    L28:
        r12.append("|xContext:");
        r12.append(r14.toString());
    L30:
        return r12.toString();
    L15:
        r13 = null;
        goto L16
    L10:
        if (r10.isEmpty() == true) goto L13;
        r12.append("|xParam:");
        r12.append(new JSONObject(r10).toString());
        goto L13
    L4:
        if (r10.isEmpty() == false) goto L7;
        goto L5
    }

    public static void c(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "moduleTag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        e(true, r5, r10, null, null);
    }

    public static void d(String r5, String r10, Map r11, int r12) {
        if ((r12 & 4) == 0) goto L5;
        r11 = null;
    L5:
        Intrinsics.checkNotNullParameter(r5, "moduleTag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        h(true, r5, r10, r11, null);
    }

    public static void e(final boolean r10, final String r11, final String r12, final Map r13, final b r14) {
        Intrinsics.checkNotNullParameter(r11, "moduleTag");
        Intrinsics.checkNotNullParameter(r12, "msg");
        if (f5258a > 3) goto L5;
    L8:
        Function0<Unit> r5 = new HybridLogger$d$1(r10, r11, r12, r13, r14);
        ((Handler) f5259b.getValue()).post(new com.bytedance.android.anniex.monitor.b(4, r5));
        return;
    L5:
        if (h.g.f5315a == true) goto L8;
    }

    public static void f(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "moduleTag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        j(true, r5, r10, null, null);
    }

    public static void g(String r5, String r10, Map r11, int r12) {
        if ((r12 & 4) == 0) goto L5;
        r11 = null;
    L5:
        Intrinsics.checkNotNullParameter(r5, "moduleTag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        i(true, r5, r10, r11, null);
    }

    public static void h(final boolean r10, final String r11, final String r12, final Map r13, final b r14) {
        Intrinsics.checkNotNullParameter(r11, "moduleTag");
        Intrinsics.checkNotNullParameter(r12, "msg");
        if (f5258a > 6) goto L5;
    L8:
        Function0<Unit> r5 = new HybridLogger$e$1(r10, r11, r12, r13, r14);
        ((Handler) f5259b.getValue()).post(new com.bytedance.android.anniex.monitor.b(4, r5));
        return;
    L5:
        if (h.g.f5315a == true) goto L8;
    }

    public static void i(final boolean r10, final String r11, final String r12, final Map r13, final b r14) {
        Intrinsics.checkNotNullParameter(r11, "moduleTag");
        Intrinsics.checkNotNullParameter(r12, "msg");
        if (f5258a > 4) goto L5;
    L8:
        Function0<Unit> r5 = new HybridLogger$i$1(r10, r11, r12, r13, r14);
        ((Handler) f5259b.getValue()).post(new com.bytedance.android.anniex.monitor.b(4, r5));
        return;
    L5:
        if (h.g.f5315a == true) goto L8;
    }

    public static void j(final boolean r10, final String r11, final String r12, final Map r13, final b r14) {
        Intrinsics.checkNotNullParameter(r11, "moduleTag");
        Intrinsics.checkNotNullParameter(r12, "msg");
        if (f5258a > 5) goto L5;
    L8:
        Function0<Unit> r5 = new HybridLogger$w$1(r10, r11, r12, r13, r14);
        ((Handler) f5259b.getValue()).post(new com.bytedance.android.anniex.monitor.b(4, r5));
        return;
    L5:
        if (h.g.f5315a == true) goto L8;
    }
}
