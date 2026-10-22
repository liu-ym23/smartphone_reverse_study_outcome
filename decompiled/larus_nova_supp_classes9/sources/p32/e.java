package p32;

import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.tetris.layer.core.element.Element;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import j70.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class e extends p32.a {
    public Element<?> d;
    public final CompositeDisposable e;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public a(Function1 r1) {
            this.a = r1;
        }

        public final void accept(T r2) {
            this.a.invoke(r2);
        }
    }

    public abstract o q();

    @Override // p32.d
    public final boolean j() {
        if (this.d == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // p32.d
    public void onDestroy() {
        this.e.clear();
    }

    public e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        super(r2, 0);
        this.e = new CompositeDisposable();
    }

    @Override // p32.d
    public final void f(b r2) {
        Intrinsics.checkNotNullParameter(r2, "loader");
        Element<?> r0 = this.d;
        if (r0 == null) goto L6;
        r2.B(this, r0);
        this.d = null;
        return;
    }

    @Override // p32.d
    public void l(b r2) {
        Intrinsics.checkNotNullParameter(r2, "loader");
        if (this.d == null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        this.d = r2.A(this, q());
        return;
    L8:
        SafetyGuard.a(null, null, "load module twice. HighlightProcessorId=" + getId());
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final <T> void r(Class<T> r2, Function1<? super T, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "eventType");
        Intrinsics.checkNotNullParameter(r3, "onEvent");
        RxUtilKt.c(xs2.b.a().b(r2).subscribe(new a(r3)), this.e);
    }
}
