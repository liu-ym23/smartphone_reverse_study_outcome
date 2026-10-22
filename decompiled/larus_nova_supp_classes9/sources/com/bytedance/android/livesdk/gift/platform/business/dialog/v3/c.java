package com.bytedance.android.livesdk.gift.platform.business.dialog.v3;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.live.core.utils.rxutils.j;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public long a;
    public Disposable b;
    public boolean c;
    public boolean d;
    public final Function0<Unit> e;
    public final Function0<Unit> f;
    public final Function0<Unit> g;
    public final Function0<Unit> h;

    public static final class a {
    }

    public static final class b implements Observer<Long> {
        public final /* synthetic */ c a;
        public final /* synthetic */ int b;

        public final void onComplete() {
            this.a.a();
        }

        public final void onError(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            this.a.a();
        }

        public final void onNext(Object r6) {
            ((Number) r6).longValue();
            c r7 = this.a;
            long r0 = r7.a + ((long) this.b);
            r7.a = r0;
            if (r0 >= 500) goto L5;
            return;
        L5:
            if (r7.d == true) goto L7;
            r7.d = true;
            r7.f.invoke();
            return;
        L7:
            r7.g.invoke();
        }

        public final void onSubscribe(Disposable r2) {
            Intrinsics.checkNotNullParameter(r2, "d");
            this.a.b = r2;
        }

        public b(c r1, int r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public final void a() {
        this.d = false;
        Disposable r0 = this.b;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public final boolean b(View r10, MotionEvent r11) {
        Intrinsics.checkNotNullParameter(r10, "v");
        Intrinsics.checkNotNullParameter(r11, "event");
        if (r11.getAction() != 0) goto L11;
        this.a = 0;
        this.c = false;
        if (b02.a.e() == false) goto L7;
        int r13 = 150;
    L8:
        j.a r14 = j.a;
        long r0 = r13;
        j.a(r0, r0, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r13));
        return true;
    L7:
        r13 = 100;
        goto L8
    L11:
        if (this.c == false) goto L14;
        return false;
    L14:
        if (r11.getAction() != 2) goto L28;
        if (this.a < 500) goto L28;
        float r1 = r11.getX();
        float r3 = r11.getY();
        float r5 = 0;
        if (r1 >= r5) goto L20;
    L25:
        this.c = true;
        this.h.invoke();
        a();
        return true;
    L20:
        if (r1 > r10.getWidth()) goto L25;
        if (r3 < r5) goto L25;
        if (r3 > r10.getHeight()) goto L25;
    L28:
        if (r11.getAction() != 1) goto L36;
        if (this.a >= 500) goto L33;
        this.e.invoke();
        this.c = true;
        a();
        return true;
    L33:
        this.c = true;
        this.h.invoke();
        a();
        return true;
    L36:
        if (r11.getAction() != 3) goto L38;
        a();
    L38:
        return false;
    }

    public c(Function0 r2, Function0 r3, Function0 r4, Function0 r5) {
        Intrinsics.checkNotNullParameter(r2, "singleClickAction");
        Intrinsics.checkNotNullParameter(r3, "longClickAction");
        Intrinsics.checkNotNullParameter(r4, "longClickContinueAction");
        Intrinsics.checkNotNullParameter(r5, "longClickFinishAction");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.c = true;
    }
}
