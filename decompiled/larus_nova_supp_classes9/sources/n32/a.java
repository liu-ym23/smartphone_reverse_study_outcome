package n32;

import com.bytedance.live.datacontext.j;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import sh6.b;
import sh6.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {

    /* JADX INFO: renamed from: n32.a$a, reason: collision with other inner class name */
    public static final class C0253a<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public C0253a(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Function1 r0 = this.a;
            Object r3 = c.b((b) r2);
            if (r3 == null) goto L6;
            r0.invoke(r3);
            return;
        }
    }

    public static final <T> Disposable a(j<T> r2, Function1<? super T, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$safeUse");
        Intrinsics.checkNotNullParameter(r3, "action");
        Object r0 = r2.getValue();
        if (r2.hasValue() == false) goto L7;
        if (r0 == null) goto L7;
        r3.invoke(r0);
        return null;
    L7:
        return r2.b().subscribe(new C0253a(r3));
    }
}
