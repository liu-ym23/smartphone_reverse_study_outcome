package com.bytedance.android.livesdk.interactivity.like.controller;

import com.bytedance.android.live.core.utils.rxutils.j;
import com.bytedance.android.livesdk.config.kn;
import com.bytedance.android.livesdk.interactivity.like.DiggWidget;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import u32.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends m {
    public Disposable b;
    public int c;
    public boolean d;
    public final float e;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ d a;

        public b(d r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Long r4 = (Long) r3;
            d r5 = this.a;
            if (r5.c > 0) goto L5;
            r5.e();
            return;
        L5:
            float r6 = Random.Default.nextInt(1, 100);
            d r0 = this.a;
            if (r6 < r0.e) goto L11;
            r0.c--;
            r0.a.a().a();
            return;
        }
    }

    static {
    }

    @Override // u32.b
    public final void c() {
        throw null;
    }

    public final void e() {
        Disposable r0 = this.b;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.b = null;
    }

    public d(DiggWidget.o r2) {
        Intrinsics.checkNotNullParameter(r2, "initializer");
        super(r2);
        this.e = ((Number) kn.a.getValue()).floatValue() * 100;
    }

    public final void d(int r1, long r2) {
        this.c = r1;
        if (this.d == true) goto L5;
        return;
    L5:
        if (this.b != null) goto L10;
        j.a r3 = j.a;
        this.b = j.c(r2, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
        return;
    }
}
