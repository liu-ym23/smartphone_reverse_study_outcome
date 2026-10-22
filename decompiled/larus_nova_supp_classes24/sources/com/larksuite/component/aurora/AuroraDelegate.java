package com.larksuite.component.aurora;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class AuroraDelegate {
    public final AuroraView a;
    public final Lazy b;
    public final Lazy c;

    public abstract void b(Canvas r1, AuroraView.a r2, Function1<? super RectF, Unit> r3, Function1<? super Integer, Integer> r4);

    public void e() {
    }

    public abstract void f();

    public Paint a() {
        Paint r0 = new Paint();
        r0.setAntiAlias(true);
        return r0;
    }

    public final Paint c() {
        return (Paint) this.b.getValue();
    }

    public final RectF d() {
        return (RectF) this.c.getValue();
    }

    public AuroraDelegate(AuroraView r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.a = r2;
        this.b = LazyKt.lazy(new AuroraDelegate$paint$2(this));
        this.c = LazyKt.lazy(AuroraDelegate$rect$2.INSTANCE);
    }
}
