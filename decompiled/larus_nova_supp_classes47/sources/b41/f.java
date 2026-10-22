package b41;

import android.graphics.RectF;
import android.view.View;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public final b41.a a;
    public final a b;
    public IRenderView c;
    public Float d;
    public final c41.a e;
    public final View f;
    public final Function1<RectF, Unit> g;
    public final Function1<Float, Unit> h;

    public static final class a<T> implements Observer {
        public final /* synthetic */ f a;

        public a(f r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Unit r2 = (Unit) r1;
            this.a.a();
        }
    }

    public final void a() {
        IRenderView r0 = this.c;
        if (r0 == null) goto L15;
        View r1 = r0.getSelfView();
        if (r1 == null) goto L16;
        float r2 = r1.getScaleX();
        if (r2 == r1.getScaleY()) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r2, this.d) == false) goto L13;
        return;
    L13:
        this.h.invoke(Float.valueOf(r2));
        this.d = Float.valueOf(r2);
        return;
    L16:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(c41.a r2, View r3, Function1<? super RectF, Unit> r4, Function1<? super Float, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "container");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(r5, "pkScaleCallback");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.a = new b41.a(r3, r4);
        this.b = new a(this);
    }
}
