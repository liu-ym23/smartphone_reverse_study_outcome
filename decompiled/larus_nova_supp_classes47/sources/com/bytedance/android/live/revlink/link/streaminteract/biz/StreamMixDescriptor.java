package com.bytedance.android.live.revlink.link.streaminteract.biz;

import android.graphics.RectF;
import com.bytedance.android.live.revlink.impl.pk.mixer.mapping.LayoutMode;
import com.bytedance.android.livesdk.revenue.service.livecore.IConfig;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class StreamMixDescriptor implements k41.a<String> {
    public static final /* synthetic */ int i = 0;
    public final Map<String, RectF> a;
    public final float b;
    public final float c;
    public final Lazy d;
    public final Map<String, t51.b> e;
    public final Map<String, t51.b> f;
    public final IConfig.e g;
    public final float h;

    public static final class a {
        public static k41.b a(StreamMixDescriptor r6, IConfig.e r7) {
            Intrinsics.checkNotNullParameter(r6, "descriptor");
            IConfig.e.f1.getClass();
            float r1 = 1.0f;
            if (Intrinsics.areEqual(r7, IConfig.e.a.g) == false) goto L5;
        L15:
            k41.c r0 = new k41.c(r6);
            r0.a = true;
            int r8 = StreamMixDescriptor.i;
            if (r7 == null) goto L18;
            float r9 = r7.getWidth();
        L19:
            if (r7 == null) goto L21;
            r1 = r7.getHeight();
        L21:
            r0.b = Float.valueOf(r9 / r1);
            LayoutMode[] r10 = {LayoutMode.Center};
            Intrinsics.checkNotNullParameter(r10, "layoutMode");
            r0.c = r10;
            return r0.a();
        L18:
            r9 = 1.0f;
            goto L19
        L5:
            if (Intrinsics.areEqual(r7, IConfig.e.a.f) == true) goto L15;
            k41.c r2 = new k41.c(r6);
            r2.a = false;
            int r5 = StreamMixDescriptor.i;
            if (r7 == null) goto L10;
            float r12 = r7.getWidth();
        L11:
            if (r7 == null) goto L13;
            r1 = r7.getHeight();
        L13:
            r2.b = Float.valueOf(r12 / r1);
            LayoutMode[] r13 = {LayoutMode.CenterHorizontal};
            Intrinsics.checkNotNullParameter(r13, "layoutMode");
            r2.c = r13;
            r2.d = r6.b;
            return r2.a();
        L10:
            r12 = 1.0f;
            goto L11
        }
    }

    static {
    }

    public final List<RectF> d() {
        return (List) this.d.getValue();
    }

    @Override // k41.a
    public final float a() {
        return (f() + h()) + 0.0f;
    }

    @Override // k41.a
    public final float c() {
        return (g() + e()) + 0.0f;
    }

    public final float e() {
        if (d().isEmpty() == false) goto L5;
        return 0.0f;
    L5:
        Iterator<T> r0 = d().iterator();
        if (r0.hasNext() == false) goto L22;
        float r1 = ((RectF) r0.next()).bottom;
    L9:
        if (r0.hasNext() == false) goto L11;
        r1 = Math.max(r1, ((RectF) r0.next()).bottom);
        goto L9
    L11:
        Iterator<T> r2 = d().iterator();
        if (r2.hasNext() == false) goto L20;
        float r3 = ((RectF) r2.next()).top;
    L15:
        if (r2.hasNext() == false) goto L18;
        r3 = Math.min(r3, ((RectF) r2.next()).top);
        goto L15
    L18:
        return r1 - r3;
    L20:
        throw new NoSuchElementException();
    L22:
        throw new NoSuchElementException();
    }

    public final float f() {
        Iterator<T> r0 = d().iterator();
        if (r0.hasNext() == true) goto L5;
        Float r1 = null;
    L10:
        if (r1 != null) goto L15;
        return 0.0f;
    L15:
        return r1.floatValue();
    L5:
        float r2 = ((RectF) r0.next()).left;
    L7:
        if (r0.hasNext() == false) goto L9;
        r2 = Math.min(r2, ((RectF) r0.next()).left);
        goto L7
    L9:
        r1 = Float.valueOf(r2);
        goto L10
    }

    public final float g() {
        Iterator<T> r0 = d().iterator();
        if (r0.hasNext() == true) goto L5;
        Float r1 = null;
    L10:
        if (r1 != null) goto L15;
        return 0.0f;
    L15:
        return r1.floatValue();
    L5:
        float r2 = ((RectF) r0.next()).top;
    L7:
        if (r0.hasNext() == false) goto L9;
        r2 = Math.min(r2, ((RectF) r0.next()).top);
        goto L7
    L9:
        r1 = Float.valueOf(r2);
        goto L10
    }

    public final float h() {
        if (d().isEmpty() == false) goto L5;
        return 0.0f;
    L5:
        Iterator<T> r0 = d().iterator();
        if (r0.hasNext() == false) goto L22;
        float r1 = ((RectF) r0.next()).right;
    L9:
        if (r0.hasNext() == false) goto L11;
        r1 = Math.max(r1, ((RectF) r0.next()).right);
        goto L9
    L11:
        Iterator<T> r2 = d().iterator();
        if (r2.hasNext() == false) goto L20;
        float r3 = ((RectF) r2.next()).left;
    L15:
        if (r2.hasNext() == false) goto L18;
        r3 = Math.min(r3, ((RectF) r2.next()).left);
        goto L15
    L18:
        return r1 - r3;
    L20:
        throw new NoSuchElementException();
    L22:
        throw new NoSuchElementException();
    }

    @Override // k41.a
    public final RectF b(String r2) {
        LinkedHashMap r0 = (LinkedHashMap) this.a;
        return (RectF) r0.get(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StreamMixDescriptor(Map<String, ? extends t51.b> r7, Map<String, ? extends t51.b> r8, IConfig.e r9, t51.c r10, float r12) {
        Intrinsics.checkNotNullParameter(r7, "mixStreamRegionMap");
        Intrinsics.checkNotNullParameter(r8, "audienceMixStreamRegionMap");
        Intrinsics.checkNotNullParameter(r10, "canvasTransform");
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r12;
        LinkedHashMap r13 = new LinkedHashMap();
        r13.putAll(r7);
        r13.putAll(r8);
        LinkedHashMap r14 = new LinkedHashMap(MapsKt.mapCapacity(r13.size()));
        Iterator r15 = r13.entrySet().iterator();
    L4:
        if (r15.hasNext() == false) goto L6;
        Map.Entry r16 = (Map.Entry) r15.next();
        Object r17 = r16.getKey();
        t51.b r18 = (t51.b) r16.getValue();
        r14.put(r17, new RectF(r18.e(), r18.f(), r18.e() + r18.d(), r18.f() + r18.a()));
        goto L4
    L6:
        List r19 = CollectionsKt.toList(r14.values());
        Iterator r20 = r19.iterator();
        if (r20.hasNext() == false) goto L43;
        float r110 = ((RectF) r20.next()).left;
    L10:
        if (r20.hasNext() == false) goto L12;
        r110 = Math.min(r110, ((RectF) r20.next()).left);
        goto L10
    L12:
        Iterator r22 = r19.iterator();
        if (r22.hasNext() == false) goto L41;
        float r111 = ((RectF) r22.next()).top;
    L16:
        if (r22.hasNext() == false) goto L18;
        r111 = Math.min(r111, ((RectF) r22.next()).top);
        goto L16
    L18:
        Iterator r23 = r19.iterator();
        if (r23.hasNext() == false) goto L39;
        float r0 = ((RectF) r23.next()).right;
    L22:
        if (r23.hasNext() == false) goto L24;
        r0 = Math.max(r0, ((RectF) r23.next()).right);
        goto L22
    L24:
        Iterator r24 = r19.iterator();
        if (r24.hasNext() == false) goto L37;
        float r25 = ((RectF) r24.next()).bottom;
    L28:
        if (r24.hasNext() == false) goto L30;
        r25 = Math.max(r25, ((RectF) r24.next()).bottom);
        goto L28
    L30:
        RectF r26 = new RectF(r110, r111, r0, r25);
        this.b = r111;
        this.c = r110;
        LinkedHashMap r27 = new LinkedHashMap(MapsKt.mapCapacity(r14.size()));
        Iterator r28 = r14.entrySet().iterator();
    L32:
        if (r28.hasNext() == false) goto L34;
        Map.Entry r112 = (Map.Entry) r28.next();
        r27.put(r112.getKey(), new RectF(((RectF) r112.getValue()).left - r26.left, (((RectF) r112.getValue()).top - r26.top) / this.h, (((RectF) r112.getValue()).left - r26.left) + ((RectF) r112.getValue()).width(), ((((RectF) r112.getValue()).top - r26.top) + ((RectF) r112.getValue()).height()) / this.h));
        goto L32
    L34:
        this.a = r27;
        this.d = LazyKt.lazy(new StreamMixDescriptor$grids$2(this));
        return;
    L37:
        throw new NoSuchElementException();
    L39:
        throw new NoSuchElementException();
    L41:
        throw new NoSuchElementException();
    L43:
        throw new NoSuchElementException();
    }
}
