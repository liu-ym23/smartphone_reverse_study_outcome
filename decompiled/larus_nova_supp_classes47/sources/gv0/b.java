package gv0;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.profit.taskcenter.panel.model.PanelInfo;
import com.bytedance.android.livesdk.e;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements ev0.b {
    public static final CompositeDisposable a = null;
    public static final b b = null;

    public static final class a<T> implements Predicate {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final boolean test(Object r2) {
            Boolean r3 = (Boolean) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return !r3.booleanValue();
        }
    }

    /* JADX INFO: renamed from: gv0.b$b, reason: collision with other inner class name */
    public static final class C0245b<T> implements Consumer {
        public final /* synthetic */ ev0.c a;

        public C0245b(ev0.c r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Boolean r2 = (Boolean) r1;
            this.a.e();
        }
    }

    public b() {
    }

    static {
        b = new b();
        a = new CompositeDisposable();
    }

    @Override // ev0.b
    public final void a(ev0.c r3) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        RxUtilKt.c(e.b().b.filter(a.a).subscribe(new C0245b(r3)), a);
    }

    @Override // ev0.b
    public final void b(ev0.c r2) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        a.clear();
    }

    @Override // ev0.b
    public final boolean c(PanelInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "panelInfo");
        if (r2.h == false) goto L8;
        e.b().getClass();
        if (e.c() == false) goto L8;
        return false;
    L8:
        return true;
    }
}
