package g32;

import f32.f;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {

    public static final class a implements Action {
        public final /* synthetic */ h32.c a;
        public final /* synthetic */ h32.d b;

        public a(h32.c r1, h32.d r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void run() {
            this.a.a(this.b);
        }
    }

    public static final <T extends f> Disposable a(h32.c<T> r1, h32.d<T> r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$listen");
        Intrinsics.checkNotNullParameter(r2, "listener");
        r1.b(r2);
        return Disposables.fromAction(new a(r1, r2));
    }
}
