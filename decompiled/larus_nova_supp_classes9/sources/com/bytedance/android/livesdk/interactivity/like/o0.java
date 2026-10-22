package com.bytedance.android.livesdk.interactivity.like;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.like.view.BottomSelfDiggOptimizeView;
import com.bytedance.android.livesdk.message.model.d4;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o0 implements u32.l.a {
    public final /* synthetic */ DiggWidget a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ o0 a;

        public a(o0 r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Bitmap r4 = (Bitmap) r3;
            DiggWidget r0 = this.a.a;
            int r1 = DiggWidget.M1;
            Bitmap r2 = r0.Qq();
            if (r2 == null) goto L6;
            this.a.a.i.e(r4, r2);
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r4) {
            com.bytedance.android.livesdk.interactivity.like.utils.d.a.a("onUserRankShowError, throwable info is " + ((Throwable) r4));
        }
    }

    public static final class c<T1, T2, R> implements BiFunction {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final Object apply(Object r2, Object r3) {
            Bitmap r4 = (Bitmap) r2;
            Intrinsics.checkNotNullParameter(r4, "t1");
            Intrinsics.checkNotNullParameter((Long) r3, "t2");
            return r4;
        }
    }

    public o0(DiggWidget r1) {
        this.a = r1;
    }

    @Override // u32.l.a
    public final void b(u32.l r9, com.bytedance.android.livesdk.interactivity.api.like.model.a r10) {
        Intrinsics.checkNotNullParameter(r9, "vm");
        Intrinsics.checkNotNullParameter(r10, "detail");
        DiggWidget r11 = this.a;
        r11.h.a = true;
        r11.i.c(true, (int) r10.d());
        DiggWidget r13 = this.a;
        r13.k0 = true;
        DiggWidget.c r14 = r13.i;
        Bitmap r2 = BitmapFactory.decodeResource(((Widget) r13).context.getResources(), 2131250341);
        r14.getClass();
        Intrinsics.checkNotNullParameter(r2, "sourceBitmap");
        if (r14.b() == false) goto L8;
        float r15 = s1.f(34.0f) + (Random.Default.nextInt(-32, 32) / 2);
        PointF r3 = new PointF(r15, s1.f(192.0f));
        PointF r4 = new PointF(r15, s1.f(112.0f));
        BottomSelfDiggOptimizeView r1 = r14.a();
        if (r1 == null) goto L8;
        r1.d(r2, r3, r4, 6, 200);
    L8:
        com.bytedance.android.live.core.utils.i0.c().postDelayed(this.a.p0, 3000);
        DiggWidget r16 = this.a;
        if (r16.x <= 0) goto L12;
        r16.x = 0;
        return;
    }

    @Override // u32.l.a
    public final void e(u32.l r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "vm");
        Disposable r5 = this.a.k;
        if (r5 == null) goto L5;
        r5.dispose();
    L5:
        DiggWidget r6 = this.a;
        r6.h.a = false;
        r6.i.c(false, 0);
        DiggWidget r7 = this.a;
        int r0 = r7.x;
        if (r0 <= 0) goto L9;
        r7.x = r0 + Math.min(r4, r0);
        return;
    }

    @Override // u32.l.a
    public final void k(u32.l r3, List<d4> r4) {
        Intrinsics.checkNotNullParameter(r3, "vm");
        Intrinsics.checkNotNullParameter(r4, "userRank");
        if (r4.isEmpty() == false) goto L5;
        return;
    L5:
        Disposable r0 = this.a.k;
        if (r0 == null) goto L8;
        r0.dispose();
    L8:
        int r1 = com.bytedance.android.livesdk.interactivity.like.utils.j.a;
        Intrinsics.checkNotNullParameter(r4, "userRank");
        Observable r5 = Observable.zip(Observable.fromIterable(r4).filter(com.bytedance.android.livesdk.interactivity.like.utils.f.a).flatMap(com.bytedance.android.livesdk.interactivity.like.utils.h.a).map(com.bytedance.android.livesdk.interactivity.like.utils.i.a), Observable.interval(800, TimeUnit.MILLISECONDS), c.a);
        DiggWidget r6 = this.a;
        r6.k = r5.observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this), b.a);
        DiggWidget r7 = this.a;
        Disposable r8 = r7.k;
        if (r8 == null) goto L12;
        r7.Bq(r8);
        return;
    }

    @Override // u32.l.a
    public final void l(u32.l r3, com.bytedance.android.livesdk.interactivity.api.like.model.a r4) {
        Intrinsics.checkNotNullParameter(r3, "vm");
        Intrinsics.checkNotNullParameter(r4, "detail");
        Intrinsics.checkNotNullParameter(r3, "vm");
        Intrinsics.checkNotNullParameter(r4, "detail");
    }

    @Override // u32.l.a
    public final void d(u32.l r1, int r2, int r3, Text r4, Text r5) {
        Intrinsics.checkNotNullParameter(r1, "vm");
        Intrinsics.checkNotNullParameter(r4, "normalText");
        Intrinsics.checkNotNullParameter(r5, "joinText");
        Bitmap r6 = this.a.i.a;
        if (r2 <= 0) goto L9;
        if (r6 == null) goto L10;
        Bitmap r7 = com.bytedance.android.livesdk.interactivity.like.utils.j.a(r6, r2 * 2);
        Bitmap r8 = this.a.Qq();
        if (r8 == null) goto L11;
        this.a.i.e(r7, r8);
        return;
    L11:
        return;
    L10:
        return;
    }
}
