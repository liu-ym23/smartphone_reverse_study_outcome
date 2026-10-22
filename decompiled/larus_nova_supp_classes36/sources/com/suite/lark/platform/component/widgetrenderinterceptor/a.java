package com.suite.lark.platform.component.widgetrenderinterceptor;

import android.content.Context;
import com.ss.android.lark.log.Log;
import com.suite.lark.platform.component.widgetrenderinterceptor.entity.BizInterceptorType;
import com.suite.lark.platform.component.widgetrenderinterceptor.interceptor.CSAMImageRenderInterceptor;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final Context a;
    public IMBizImageRenderInterceptor.a b;
    public kpc.a c;
    public d d;
    public c e;
    public final Map<BizInterceptorType, IMBizImageRenderInterceptor> f;

    /* JADX INFO: renamed from: com.suite.lark.platform.component.widgetrenderinterceptor.a$a, reason: collision with other inner class name */
    public static class C0244a<T extends C0244a<T>> {
        public final Context a;
        public final IMBizImageRenderInterceptor.a b;
        public final kpc.a c;
        public final Map<BizInterceptorType, IMBizImageRenderInterceptor> d;
        public final List<BizInterceptorType> e;

        /* JADX INFO: renamed from: com.suite.lark.platform.component.widgetrenderinterceptor.a$a$a, reason: collision with other inner class name */
        public static final class C0245a<T> implements Comparator {
            public C0245a() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T r1, T r2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((BizInterceptorType) r2).getPriority()), Integer.valueOf(((BizInterceptorType) r1).getPriority()));
            }
        }

        public final Context getContext() {
            return this.a;
        }

        public final void b(Function0 r2) {
            Intrinsics.checkNotNullParameter(r2, "used");
            List<BizInterceptorType> r0 = this.e;
            ArrayList r1 = (ArrayList) r0;
            r1.addAll(ArraysKt.toList((Object[]) r2.invoke()));
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.suite.lark.platform.component.widgetrenderinterceptor.ImBizImageRender.BaseRender");
        }

        public final Map<BizInterceptorType, IMBizImageRenderInterceptor> a(Map<BizInterceptorType, IMBizImageRenderInterceptor> r5, IMBizImageRenderInterceptor.Scene r6) {
            Intrinsics.checkNotNullParameter(r5, "<this>");
            Map<BizInterceptorType, IMBizImageRenderInterceptor> r7 = this.d;
            LinkedHashMap r0 = new LinkedHashMap();
            Iterator<Map.Entry<BizInterceptorType, IMBizImageRenderInterceptor>> r8 = r7.entrySet().iterator();
        L4:
            if (r8.hasNext() == false) goto L13;
            Map.Entry<BizInterceptorType, IMBizImageRenderInterceptor> r1 = r8.next();
            boolean r2 = true;
            if (r6 != null) goto L8;
        L11:
            if (r2 == false) goto L4;
            r0.put(r1.getKey(), r1.getValue());
            goto L4
        L8:
            if (r1.getValue().c() == r6) goto L11;
            r2 = false;
            goto L11
        L13:
            SortedMap r9 = MapsKt.toSortedMap(r0, new C0245a());
            LinkedHashMap r10 = new LinkedHashMap();
            Iterator r11 = r9.entrySet().iterator();
        L15:
            if (r11.hasNext() == false) goto L20;
            Map.Entry r3 = (Map.Entry) r11.next();
            BizInterceptorType r4 = (BizInterceptorType) r3.getKey();
            if (((ArrayList) this.e).contains(r4) == false) goto L15;
            r10.put(r3.getKey(), r3.getValue());
            goto L15
        L20:
            return MapsKt.toMutableMap(r10);
        }

        public C0244a(Context r2, IMBizImageRenderInterceptor.a r3, kpc.a r4, Map<BizInterceptorType, IMBizImageRenderInterceptor> r5) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "viewProvider");
            Intrinsics.checkNotNullParameter(r4, "interceptData");
            Intrinsics.checkNotNullParameter(r5, "imageRenderInterceptors");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = new ArrayList();
        }
    }

    public static final class b {
    }

    public static final class c extends C0244a<c> {
        public Function0<Unit> f;

        public c(Context r2, IMBizImageRenderInterceptor.a r3, kpc.a r4, Map<BizInterceptorType, IMBizImageRenderInterceptor> r5) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "viewProvider");
            Intrinsics.checkNotNullParameter(r4, "interceptData");
            Intrinsics.checkNotNullParameter(r5, "imageRenderInterceptors");
            super(r2, r3, r4, r5);
        }
    }

    public static final class d extends C0244a<d> {
        public Function0<Unit> f;
        public IMBizImageRenderInterceptor.b g;

        public d(Context r2, IMBizImageRenderInterceptor.a r3, kpc.a r4, Map<BizInterceptorType, IMBizImageRenderInterceptor> r5) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "viewProvider");
            Intrinsics.checkNotNullParameter(r4, "interceptData");
            Intrinsics.checkNotNullParameter(r5, "imageRenderInterceptors");
            super(r2, r3, r4, r5);
            new ArrayList();
        }
    }

    static {
    }

    public final void a() {
        c r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.f != null) goto L7;
        Log.e("ImBizImageRender", "no image click setup!");
        return;
    L7:
        Iterator<Map.Entry<BizInterceptorType, IMBizImageRenderInterceptor>> r1 = r0.a(r0.d, null).entrySet().iterator();
        boolean r3 = false;
    L9:
        if (r1.hasNext() == false) goto L13;
        IMBizImageRenderInterceptor r4 = r1.next().getValue();
        if (((Boolean) r4.a(r0.getContext(), r0.b, r0.c).invoke()).booleanValue() == false) goto L9;
        Log.i("ImBizImageRender", "image click by renderInterceptor: " + r4.getType());
        r3 = true;
        goto L9
    L13:
        if (r3 == true) goto L25;
        Function0<Unit> r2 = r0.f;
        if (r2 == null) goto L26;
        r2.invoke();
        return;
    L26:
        return;
    }

    public final void d() {
        d r0 = this.d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.f != null) goto L7;
        Log.e("ImBizImageRender", "no image render setup!");
        return;
    L7:
        Iterator<Map.Entry<BizInterceptorType, IMBizImageRenderInterceptor>> r1 = r0.a(r0.d, IMBizImageRenderInterceptor.Scene.BeforeRender).entrySet().iterator();
        boolean r3 = false;
    L9:
        if (r1.hasNext() == false) goto L13;
        IMBizImageRenderInterceptor r4 = r1.next().getValue();
        if (((Boolean) r4.b(r0.getContext(), r0.b, r0.c, r0.g).invoke()).booleanValue() == false) goto L9;
        Log.i("ImBizImageRender", "image render by renderInterceptor: " + r4.getType());
        r3 = true;
        goto L9
    L13:
        if (r3 == true) goto L25;
        Function0<Unit> r2 = r0.f;
        if (r2 == null) goto L26;
        r2.invoke();
        return;
    L26:
        return;
    }

    public final Context getContext() {
        return this.a;
    }

    public a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = r3;
        EnumMap r4 = new EnumMap(BizInterceptorType.class);
        this.f = r4;
        r4.put(BizInterceptorType.CSAM_DELETE, new CSAMImageRenderInterceptor());
    }

    public final void b(Function1 r6) {
        Intrinsics.checkNotNullParameter(r6, "imageClick");
        IMBizImageRenderInterceptor.a r0 = this.b;
        if (r0 == null) goto L9;
        kpc.a r1 = this.c;
        if (r1 == null) goto L9;
        c r2 = new c(this.a, r0, r1, this.f);
        r6.invoke(r2);
        this.e = r2;
        return;
    L9:
        Log.e("ImBizImageRender", "render not build complete");
    }

    public final void c(Function1 r6) {
        Intrinsics.checkNotNullParameter(r6, "imageRender");
        IMBizImageRenderInterceptor.a r0 = this.b;
        if (r0 == null) goto L9;
        kpc.a r1 = this.c;
        if (r1 == null) goto L9;
        d r2 = new d(this.a, r0, r1, this.f);
        r6.invoke(r2);
        this.d = r2;
        return;
    L9:
        Log.e("ImBizImageRender", "render not build complete");
    }
}
