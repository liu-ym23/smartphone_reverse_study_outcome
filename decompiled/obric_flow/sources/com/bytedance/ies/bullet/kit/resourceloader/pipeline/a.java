package com.bytedance.ies.bullet.kit.resourceloader.pipeline;

import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.bytedance.ies.bullet.base.utils.logger.b;
import com.bytedance.ies.bullet.base.utils.logger.c;
import com.bytedance.ies.bullet.kit.resourceloader.e;
import com.bytedance.ies.bullet.kit.resourceloader.h;
import com.bytedance.ies.bullet.kit.resourceloader.j;
import com.bytedance.ies.bullet.service.base.a0;
import com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import wc.g;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f5469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f5470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5471c;
    public int d;
    public boolean e;
    public boolean f;
    public IXResourceLoader g;

    public a(ArrayList r5, h r10) {
        Intrinsics.checkNotNullParameter(r5, "processors");
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_SERVICE);
        this.f5469a = r5;
        this.f5470b = r10;
        this.d = -1;
    }

    public final ArrayList a() {
        ArrayList r5 = new ArrayList();
        Iterator r10 = this.f5469a.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r5.add(((Class) r10.next()).getName());
        goto L4
    L6:
        return r5;
    }

    public final void b(final e r24, final Iterator r25, final Function1 r26, final Function1 r27, final j r28, final int r29) {
        b r10 = new b();
        String r5 = r24.f5449b.f22848q;
        Intrinsics.checkNotNullParameter("resourceSession", "name");
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        r10.f5260a.add(new c("resourceSession", r5));
        if (r25.hasNext() == false) goto L36;
        final Class r11 = (Class) r25.next();
        final boolean r16 = r25.hasNext();
        final IXResourceLoader r12 = (IXResourceLoader) r11.newInstance();
        r12.setService(this.f5470b);
        this.g = r12;
        SystemClock.elapsedRealtime();
        int r13 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Map r14 = MapsKt.mapOf(TuplesKt.to("loader", r11.toString()));
        Intrinsics.checkNotNullParameter("XResourceLoader", "moduleTag");
        Intrinsics.checkNotNullParameter("ResourceLoader chain start load", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XResourceLoader", "ResourceLoader chain start load", r14, r10);
    L14:
        th = th;
        String r17 = "XResourceLoader";
    L13:
        String r21 = "moduleTag";
        String r20 = "msg";
    L31:
        int r15 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Map r18 = MapsKt.mapOf(new Pair[]{TuplesKt.to("url", r24.f5448a.f5932a.toString()), TuplesKt.to("error", th.getMessage()), TuplesKt.to("hasNex", Boolean.valueOf(r16))});
        String r19 = r17;
        Intrinsics.checkNotNullParameter(r19, r21);
        Intrinsics.checkNotNullParameter("ResourceLoader chain catch error", r20);
        com.bytedance.ies.bullet.base.utils.logger.a.h(true, r19, "ResourceLoader chain catch error", r18, r10);
        if (r16 == false) goto L34;
        b(r24, r25, r26, r27, r28, r29 + 1);
        return;
    L34:
        r27.invoke(new Throwable(androidx.room.jarjarred.org.antlr.runtime.a.x(th, new StringBuilder("ResourceLoaderChain# "))));
        return;
    L6:
        if (r29 != this.f5471c) goto L16;
        JSONObject r22 = (JSONObject) r24.f5448a.f5950x.d;     // Catch: Throwable -> L14
        if (r22 == null) goto L16;
        r17 = "XResourceLoader";
        long r23 = SystemClock.uptimeMillis();     // Catch: Throwable -> L12
        long r30 = r23 - r28.f5459b;     // Catch: Throwable -> L12
        r28.f5459b = r23;     // Catch: Throwable -> L12
        r22.put("high_processor_total", r30);     // Catch: Throwable -> L12
    L18:
        if (r29 != this.d) goto L20;
        boolean r31 = true;
        this.f = true;     // Catch: Throwable -> L12
        r28.f5459b = SystemClock.uptimeMillis();     // Catch: Throwable -> L12
    L21:
        String r110 = r17;
        r20 = "msg";
        r17 = r110;
        r21 = "moduleTag";
        r12.loadAsync(r24.f5448a, r24.f5449b, new ResourceLoaderChain$loadAsyncInner$1(this, r27, r24, r11, r28, r26, r12), new ResourceLoaderChain$loadAsyncInner$2(r24, this, r27, r16, r25, r26, r28, r29, r12));     // Catch: Throwable -> L27
        return;
    L27:
        th = th;
    L29:
        th = th;
        r17 = r110;
        r21 = "moduleTag";
        goto L31
    L20:
        r31 = true;
    L12:
        th = th;
    L16:
        r17 = "XResourceLoader";
        goto L18
    L36:
        int r32 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Pair r33 = TuplesKt.to("url", r24.f5448a.f5932a.toString());
        ArrayList r34 = this.f5469a;
        Map r35 = MapsKt.mapOf(new Pair[]{r33, TuplesKt.to("processors", r34.toString()), TuplesKt.to("processors size", Integer.valueOf(r34.size()))});
        Intrinsics.checkNotNullParameter("XResourceLoader", "moduleTag");
        Intrinsics.checkNotNullParameter("ResourceLoader chain no Element for load", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.h(true, "XResourceLoader", "ResourceLoader chain no Element for load", r35, r10);
        r27.invoke(new Throwable("ResourceLoaderChain# no Element for " + r24.f5448a.f5932a));
    }

    public final void c(e r21, Function1 r22, Function1 r23) {
        Intrinsics.checkNotNullParameter(r21, "input");
        Intrinsics.checkNotNullParameter(r22, "resolve");
        Intrinsics.checkNotNullParameter(r23, "reject");
        b r5 = new b();
        String r10 = r21.f5449b.f22848q;
        Intrinsics.checkNotNullParameter("resourceSession", "name");
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        r5.f5260a.add(new c("resourceSession", r10));
        g r11 = new g(r21.f5449b.f22836a);
        r11.a(r21.f5449b);
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r21.f5449b = r11;
        ArrayList r12 = this.f5469a;
        if (r12.isEmpty() == false) goto L6;
        r23.invoke(new Throwable("ResourceLoaderChain# no processor for " + r21.f5448a.f5932a));
        return;
    L6:
        int r13 = com.bytedance.ies.bullet.base.utils.logger.a.f5258a;
        Map r14 = MapsKt.mapOf(new Pair[]{TuplesKt.to("url", r21.f5448a.f5932a.toString()), TuplesKt.to("processors", r12.toString()), TuplesKt.to("processors size", Integer.valueOf(r12.size()))});
        Intrinsics.checkNotNullParameter("XResourceLoader", "moduleTag");
        Intrinsics.checkNotNullParameter("ResourceLoader chain info", "msg");
        com.bytedance.ies.bullet.base.utils.logger.a.i(true, "XResourceLoader", "ResourceLoader chain info", r14, r5);
        if (r21.f5450c == false) goto L9;
        b(r21, r12.iterator(), r22, r23, new j(), 0);
    L71:
        dc.b.a("Load url = " + r21.f5448a.f5932a + ", message = " + r21.f5448a.f5951y);
        return;
    L9:
        long r15 = SystemClock.uptimeMillis();
        Iterator r16 = r12.iterator();
        long r17 = r15;
        int r18 = 0;
    L11:
        if (r16.hasNext() == false) goto L71;
        int r19 = r18 + 1;
        Class r20 = (Class) r16.next();
        if (r18 != this.f5471c) goto L27;
        JSONObject r110 = (JSONObject) r21.f5448a.f5950x.d;     // Catch: Throwable -> L24
        if (r110 == null) goto L27;
        long r111 = SystemClock.uptimeMillis();     // Catch: Throwable -> L24
        r110.put("high_processor_total", r111 - r17);     // Catch: Throwable -> L21
        r17 = r111;
    L21:
        th = th;
        r17 = r111;
    L23:
        int r112 = r19;
    L59:
        boolean r113 = true;
        if (r18 != (r12.size() - 1)) goto L68;
        if (this.f == false) goto L66;
        JSONObject r24 = (JSONObject) r21.f5448a.f5950x.d;
        if (r24 == null) goto L66;
        long r114 = SystemClock.uptimeMillis();
        r24.put("low_processor_total", r114 - r17);
        r17 = r114;
    L66:
        r23.invoke(th);
    L68:
        if (this.e == true) goto L69;
        r18 = r112;
        goto L11
    L69:
        r23.invoke(new Throwable("ResourceLoaderChain# on cancel load"));
    L27:
        if (r18 != this.d) goto L29;
        r17 = SystemClock.uptimeMillis();     // Catch: Throwable -> L24
        this.f = true;     // Catch: Throwable -> L24
    L29:
        IXResourceLoader r25 = (IXResourceLoader) r20.newInstance();     // Catch: Throwable -> L24
        r25.setService(this.f5470b);     // Catch: Throwable -> L24
        this.g = r25;     // Catch: Throwable -> L24
        r112 = r19;
        a0 r26 = r25.loadSync(r21.f5448a, r21.f5449b);     // Catch: Throwable -> L45
        if (r26 != null) goto L49;
        Throwable r27 = new Throwable(r20.getCanonicalName() + " return null");     // Catch: Throwable -> L45
        if (r18 == (r12.size() - 1)) goto L36;
    L48:
        Intrinsics.checkNotNullParameter("rl load sync failed", "msg");     // Catch: Throwable -> L45
        Intrinsics.checkNotNullParameter(r27, "tr");     // Catch: Throwable -> L45
        dc.b.f16633a.a("[ResourceLoader] ".concat("rl load sync failed"), r27);     // Catch: Throwable -> L45
        r113 = true;
        goto L68
    L36:
        if (this.f == false) goto L47;
        JSONObject r28 = (JSONObject) r21.f5448a.f5950x.d;     // Catch: Throwable -> L45
        if (r28 == null) goto L47;
        long r115 = SystemClock.uptimeMillis();     // Catch: Throwable -> L45
        r28.put("low_processor_total", r115 - r17);     // Catch: Throwable -> L43
        r17 = r115;
    L43:
        th = th;
        r17 = r115;
    L47:
        r23.invoke(r27);     // Catch: Throwable -> L45
        goto L48
    L49:
        Intrinsics.checkNotNullParameter(r26, "<set-?>");     // Catch: Throwable -> L45
        r21.f5448a = r26;     // Catch: Throwable -> L45
        Intrinsics.checkNotNullParameter(r20.getSimpleName(), "<set-?>");     // Catch: Throwable -> L45
        if (this.f == false) goto L57;
        JSONObject r29 = (JSONObject) r21.f5448a.f5950x.d;     // Catch: Throwable -> L45
        if (r29 == null) goto L57;
        r115 = SystemClock.uptimeMillis();     // Catch: Throwable -> L45
        r29.put("low_processor_total", r115 - r17);     // Catch: Throwable -> L43
        r17 = r115;
    L57:
        r22.invoke(r21);     // Catch: Throwable -> L45
    L45:
        th = th;
    L24:
        th = th;
        goto L23
    }
}
