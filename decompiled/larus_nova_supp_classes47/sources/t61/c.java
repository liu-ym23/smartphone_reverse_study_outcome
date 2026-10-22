package t61;

import android.animation.ValueAnimator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public static final /* synthetic */ int f = 0;
    public Function0<Unit> a;
    public Function0<Unit> b;
    public Function0<Unit> c;
    public Function0<Unit> d;
    public Function1<? super ValueAnimator, Unit> e;

    public static final class a {
        public static c a(Function1 r1) {
            Intrinsics.checkNotNullParameter(r1, "listener");
            c r0 = new c();
            r1.invoke(r0);
            return r0;
        }
    }

    static {
    }

    public c() {
    }
}
