package com.bytedance.android.ec.core.utils;

import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.widget.TextView;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.ECRitTag;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class p1 {
    public static final float a = 0.0f;
    public static final com.bytedance.frameworks.baselib.network.http.util.g<String, SoftReference<Bitmap>> b = null;
    public static final com.bytedance.frameworks.baselib.network.http.util.g<String, Bitmap> c = null;
    public static final p1 d = null;

    public static final class a<T, R> implements Function {
        public final /* synthetic */ List a;

        public a(List r1) {
            this.a = r1;
        }

        public final Object apply(Object r10) {
            Object[] r11 = (Object[]) r10;
            Intrinsics.checkNotNullParameter(r11, "rets");
            Iterator<T> r12 = ArraysKt.sortedWith(r11, new o1()).iterator();
        L4:
            if (r12.hasNext() == false) goto L12;
            T r0 = r12.next();
            if ((r0 instanceof m1) == true) goto L8;
            r0 = (T) null;
        L8:
            m1 r1 = r0;
            if (r1 == null) goto L4;
            this.a.add(r1.b);
            goto L4
        L12:
            return Unit.INSTANCE;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ List a;
        public final /* synthetic */ String b;
        public final /* synthetic */ float c;
        public final /* synthetic */ float d;
        public final /* synthetic */ TextView e;
        public final /* synthetic */ Float f;

        public b(List r1, String r10, float r11, float r12, TextView r13, Float r14) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
        }

        public final void accept(Object r10) {
            Unit r11 = (Unit) r10;
            p1 r12 = p1.d;
            List r0 = this.a;
            String r1 = this.b;
            float r13 = this.c;
            float r14 = this.d;
            TextView r15 = this.e;
            Float r16 = this.f;
            r12.getClass();
            p1.g(r0, r1, r13, r14, r15, r16);
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r10) {
            Throwable r11 = (Throwable) r10;
            String r0 = r11.getMessage();
            if (r0 != null) goto L5;
            r0 = "";
        L5:
            ECExceptionMonitor.f(r11, r0);
        }
    }

    public static final class d<T, R> implements Function {
        public final /* synthetic */ List a;

        public d(List r1) {
            this.a = r1;
        }

        public final Object apply(Object r10) {
            Object[] r11 = (Object[]) r10;
            Intrinsics.checkNotNullParameter(r11, "rets");
            Iterator<T> r12 = ArraysKt.sortedWith(r11, new q1()).iterator();
        L4:
            if (r12.hasNext() == false) goto L12;
            T r0 = r12.next();
            if ((r0 instanceof m1) == true) goto L8;
            r0 = (T) null;
        L8:
            m1 r1 = r0;
            if (r1 == null) goto L4;
            this.a.add(r1.b);
            goto L4
        L12:
            return Unit.INSTANCE;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ List a;
        public final /* synthetic */ String b;
        public final /* synthetic */ float c;
        public final /* synthetic */ float d;
        public final /* synthetic */ TextView e;

        public e(List r1, String r10, float r11, float r12, TextView r13) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
        }

        public final void accept(Object r10) {
            Unit r11 = (Unit) r10;
            p1.h(p1.d, this.a, this.b, this.c, this.d, this.e);
        }
    }

    public static final class f<T> implements Consumer {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final void accept(Object r10) {
            Throwable r11 = (Throwable) r10;
            String r0 = r11.getMessage();
            if (r0 != null) goto L5;
            r0 = "";
        L5:
            ECExceptionMonitor.f(r11, r0);
        }
    }

    public static final class g<T, R> implements Function {
        public final /* synthetic */ List a;

        public g(List r1) {
            this.a = r1;
        }

        public final Object apply(Object r10) {
            Object[] r11 = (Object[]) r10;
            Intrinsics.checkNotNullParameter(r11, "tasks");
            Iterator<T> r12 = ArraysKt.sortedWith(r11, new v1()).iterator();
        L4:
            if (r12.hasNext() == false) goto L16;
            T r0 = r12.next();
            if ((r0 instanceof m1) == true) goto L8;
            r0 = (T) null;
        L8:
            m1 r1 = r0;
            if (r1 == null) goto L4;
            this.a.add(r1.b);
            String r13 = r1.c;
            if (r13 == null) goto L4;
            if ((!StringsKt.isBlank(r13)) != true) goto L4;
            p1.b.d(r1.c, new SoftReference(r1.b));
            goto L4
        L16:
            return Unit.INSTANCE;
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ List a;
        public final /* synthetic */ String b;
        public final /* synthetic */ float c;
        public final /* synthetic */ float d;
        public final /* synthetic */ TextView e;

        public h(List r1, String r10, float r11, float r12, TextView r13) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
        }

        public final void accept(Object r10) {
            Unit r11 = (Unit) r10;
            p1.h(p1.d, this.a, this.b, this.c, this.d, this.e);
        }
    }

    public static final class i<T> implements Consumer {
        public static final i a = null;

        static {
            a = new i();
        }

        public i() {
        }

        public final void accept(Object r10) {
            Throwable r11 = (Throwable) r10;
            String r0 = r11.getMessage();
            if (r0 != null) goto L5;
            r0 = "";
        L5:
            ECExceptionMonitor.f(r11, r0);
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public j(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            Function1 r0 = this.a;
            r0.invoke((Integer) r10);
        }
    }

    public static final class k<T, R> implements Function {
        public static final k a = null;

        static {
            a = new k();
        }

        public k() {
        }

        public final Object apply(Object r12) {
            m1 r13 = (m1) r12;
            Intrinsics.checkNotNullParameter(r13, "it");
            p1 r0 = p1.d;
            Bitmap r14 = r13.b;
            r0.getClass();
            int r1 = r14.getHeight() - 1;
            int r10 = r14.getWidth();
            int r11 = r10 - 1;
            int r15 = 0;
            int r16 = 0;
            int r17 = 0;
            int r18 = 0;
            int r19 = 0;
        L3:
            if (r15 >= r11) goto L6;
            int r20 = r14.getPixel(r15, r1);
            r16 = r16 + ((r20 & ((int) 4278190080L)) >> 24);
            r19 = r19 + ((16711680 & r20) >> 16);
            r17 = r17 + ((65280 & r20) >> 8);
            r18 = r18 + (r20 & 255);
            r15 = r15 + 1;
            goto L3
        L6:
            return Integer.valueOf(((((r16 / r10) << 24) | ((r19 / r10) << 16)) | ((r17 / r10) << 8)) | (r18 / r10));
        }
    }

    public static final class l<T> implements Consumer {
        public static final l a = null;

        static {
            a = new l();
        }

        public l() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r10 = (Throwable) r1;
        }
    }

    public p1() {
    }

    static {
        d = new p1();
        a = 2.0f;
        b = new com.bytedance.frameworks.baselib.network.http.util.g(20);
        c = new com.bytedance.frameworks.baselib.network.http.util.g(20);
    }

    public static void f(String r10, Function1 r11) {
        Intrinsics.checkNotNullParameter(r11, "getColor");
        if (r10 == null) goto L6;
        d.getClass();
        Observable.create(new x1(r10, 0)).map(k.a).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(r11), l.a);
        return;
    }

    public final Disposable c(Map r10, List r11, String r12, TextView r13) {
        Intrinsics.checkNotNullParameter("ecom_shop_product_shop_sellpoint", "ritTagKey");
        Intrinsics.checkNotNullParameter(r13, "tv");
        if (r10 == null) goto L5;
        List r0 = (List) r10.get("ecom_shop_product_shop_sellpoint");
    L6:
        if (r0 == null) goto L12;
        if ((!r0.isEmpty()) != true) goto L12;
        return d("ecom_shop_product_shop_sellpoint", r10, r12, 3.0f, 14.0f, r13);
    L12:
        return a(r11, r12, 3.0f, 14.0f, r13, null);
    L5:
        r0 = null;
        goto L6
    }

    public static Disposable a(List r10, String r11, float r12, float r13, TextView r14, Float r15) {
        Intrinsics.checkNotNullParameter(r14, "tv");
        r14.setText(r11);
        List r0 = r10;
        int r1 = 0;
        if (r0 != null) goto L5;
    L8:
        boolean r16 = true;
    L9:
        if (r16 == false) goto L12;
        g(CollectionsKt.emptyList(), r11, r12, r13, r14, r15);
        return null;
    L12:
        ArrayList r17 = new ArrayList();
        List r18 = CollectionsKt.filterNotNull(r10);
        ArrayList r19 = new ArrayList();
        Iterator r20 = r18.iterator();
    L14:
        if (r20.hasNext() == false) goto L23;
        Object r21 = r20.next();
        int r22 = r1 + 1;
        if (r1 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        d.getClass();
        Observable r23 = Observable.create(new w1((ECUrlModel) r21, r1));
        if (r23 == null) goto L21;
        r19.add(r23);
    L21:
        r1 = r22;
        goto L14
    L23:
        return Observable.zip(r19, new a(r17)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(r17, r11, r12, r13, r14, r15), c.a);
    L5:
        if (r0.isEmpty() == true) goto L8;
        r16 = false;
        goto L9
    }

    public static /* synthetic */ Disposable b(p1 r10, List r11, String r12, float r13, float r14, TextView r15) {
        r10.getClass();
        return a(r11, r12, r13, r14, r15, null);
    }

    public static void g(List r10, String r11, float r12, float r13, TextView r14, Float r15) {
        SpannableStringBuilder r0 = new SpannableStringBuilder();
        Iterator r1 = r10.iterator();
    L3:
        boolean r16 = false;
        if (r1.hasNext() == false) goto L15;
        Bitmap r17 = (Bitmap) r1.next();
        if (r17.isRecycled() == true) goto L3;
        int r18 = (int) com.bytedance.common.utility.UIUtils.dip2Px(r14.getContext(), r13);
        Bitmap r19 = Bitmap.createScaledBitmap(r17, (int) (((r18 * 1.0f) / r17.getHeight()) * r17.getWidth()), r18, true);
        SpannableString r20 = new SpannableString(" ");
        com.bytedance.android.ec.core.widget.a r21 = new com.bytedance.android.ec.core.widget.a(r14.getContext(), r19);
        if (r10.indexOf(r17) != (r10.size() - 1)) goto L10;
        r21.a = vf4.a.b(Float.valueOf(r12));
    L14:
        r20.setSpan(r21, 0, 1, 17);
        r0.append(r20);
        goto L3
    L10:
        if (r15 == null) goto L12;
        int r22 = vf4.a.b(r15);
    L13:
        r21.a = r22;
        goto L14
    L12:
        r22 = vf4.a.b(Float.valueOf(a));
        goto L13
    L15:
        if (r11 != null) goto L17;
    L21:
        r14.setText(r0);
        return;
    L17:
        if (r11.length() <= 0) goto L19;
        r16 = true;
    L19:
        if (r16 != true) goto L21;
        r0.append(r11);
        goto L21
    }

    public static /* synthetic */ void h(p1 r10, List r11, String r12, float r13, float r14, TextView r15) {
        r10.getClass();
        g(r11, r12, r13, r14, r15, null);
    }

    public final Disposable d(String r11, Map<String, ? extends List<ECRitTag>> r12, String r13, float r14, float r15, TextView r16) {
        Intrinsics.checkNotNullParameter(r11, "ritTagKey");
        Intrinsics.checkNotNullParameter(r16, "tv");
        r16.setText(r13);
        if (r12 == null) goto L5;
        List<ECRitTag> r0 = r12.get(r11);
    L6:
        List<ECRitTag> r1 = r0;
        int r10 = 0;
        if (r1 != null) goto L9;
    L12:
        boolean r17 = true;
    L13:
        if (r17 == false) goto L16;
        h(this, CollectionsKt.emptyList(), r13, r14, r15, r16);
        return null;
    L16:
        ArrayList r18 = new ArrayList();
        ArrayList r19 = new ArrayList();
        Iterator r20 = r0.iterator();
    L18:
        if (r20.hasNext() == false) goto L30;
        Object r21 = r20.next();
        int r22 = r10 + 1;
        if (r10 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        String r23 = ((ECRitTag) r21).getFirstIconUrl();
        if (r23 == null) goto L25;
        d.getClass();
        Observable r24 = Observable.create(new x1(r23, r10));
    L26:
        if (r24 == null) goto L28;
        r19.add(r24);
    L28:
        r10 = r22;
        goto L18
    L25:
        r24 = null;
        goto L26
    L30:
        return Observable.zip(r19, new d(r18)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(r18, r13, r14, r15, r16), f.a);
    L9:
        if (r1.isEmpty() == true) goto L12;
        r17 = false;
        goto L13
    L5:
        r0 = null;
        goto L6
    }

    public final Disposable e(String r12, Map<String, ? extends List<ECRitTag>> r13, String r14, float r15, float r16, TextView r17) {
        Intrinsics.checkNotNullParameter(r12, "ritTagKey");
        Intrinsics.checkNotNullParameter(r17, "tv");
        r17.setText(r14);
        if (r13 == null) goto L5;
        List<ECRitTag> r0 = r13.get(r12);
    L6:
        List<ECRitTag> r1 = r0;
        int r10 = 0;
        if (r1 != null) goto L9;
    L12:
        boolean r11 = true;
    L13:
        if (r11 == false) goto L16;
        h(this, CollectionsKt.emptyList(), r14, r15, r16, r17);
        return null;
    L16:
        List<ECRitTag> r18 = r0;
        ArrayList r19 = new ArrayList();
        Iterator r20 = r18.iterator();
    L18:
        if (r20.hasNext() == false) goto L22;
        String r21 = ((ECRitTag) r20.next()).getFirstIconUrl();
        if (r21 == null) goto L18;
        r19.add(r21);
        goto L18
    L22:
        ArrayList r22 = new ArrayList();
        Iterator r23 = r19.iterator();
    L24:
        if (r23.hasNext() == false) goto L36;
        SoftReference r24 = (SoftReference) b.b((String) r23.next());
        if (r24 == null) goto L32;
        Bitmap r25 = (Bitmap) r24.get();
        if (r25 == null) goto L32;
        if ((!r25.isRecycled()) == false) goto L32;
    L33:
        if (r25 == null) goto L24;
        r22.add(r25);
    L32:
        r25 = null;
        goto L33
    L36:
        if (r22.size() != r19.size()) goto L39;
        h(this, r22, r14, r15, r16, r17);
        return null;
    L39:
        ArrayList r26 = new ArrayList();
        ArrayList r27 = new ArrayList();
        Iterator r28 = r18.iterator();
    L41:
        if (r28.hasNext() == false) goto L53;
        Object r29 = r28.next();
        int r30 = r10 + 1;
        if (r10 >= 0) goto L45;
        CollectionsKt.throwIndexOverflow();
    L45:
        String r31 = ((ECRitTag) r29).getFirstIconUrl();
        if (r31 == null) goto L48;
        d.getClass();
        Observable r32 = Observable.create(new x1(r31, r10));
    L49:
        if (r32 == null) goto L51;
        r27.add(r32);
    L51:
        r10 = r30;
        goto L41
    L48:
        r32 = null;
        goto L49
    L53:
        return Observable.zip(r27, new g(r26)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(r26, r14, r15, r16, r17), i.a);
    L9:
        if (r1.isEmpty() == true) goto L12;
        r11 = false;
        goto L13
    L5:
        r0 = null;
        goto L6
    }
}
