package je0;

import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {

    public static final class a extends BaseAnimationListener {
        public int a;
        public final /* synthetic */ AnimatedDrawable2 b;
        public final /* synthetic */ Function0 c;

        public final void onAnimationStop(AnimatedDrawable2 r2) {
            Intrinsics.checkNotNullParameter(r2, "drawable");
            Function0 r3 = this.c;
            if (r3 == null) goto L6;
            Unit r4 = (Unit) r3.invoke();
            return;
        }

        public a(AnimatedDrawable2 r1, Function0 r2) {
            this.b = r1;
            this.c = r2;
            this.a = -1;
        }

        public final void onAnimationFrame(AnimatedDrawable2 r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "drawable");
            if (r3 >= this.a) goto L5;
            this.b.stop();
        L5:
            this.a = r3;
        }
    }

    public static final void a(AnimatedDrawable2 r1, Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$playOnce");
        r1.setAnimationListener(new a(r1, r2));
    }
}
