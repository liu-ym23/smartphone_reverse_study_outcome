package im0;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.messagewindow.framework.schedule.action.AbsAction;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class a extends AbsAction<Integer> {
    public final CompositeDisposable d;

    /* JADX INFO: renamed from: im0.a$a, reason: collision with other inner class name */
    public static final class C0222a<T> implements Consumer {
        public static final C0222a a = null;

        static {
            a = new C0222a();
        }

        public C0222a() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Integer r2 = (Integer) r1;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class c implements Action {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        public final void run() {
            this.a.d.clear();
        }
    }

    public static final class d {
    }

    static {
    }

    public a(j71.a r5) {
        Intrinsics.checkNotNullParameter(r5, "cmd");
        super(r5, 1);
        CompositeDisposable r6 = new CompositeDisposable();
        this.d = r6;
        RxUtilKt.c(this.b.subscribe(C0222a.a, b.a, new c(this)), r6);
    }

    public final void a(int r3) {
        Integer r0 = Integer.valueOf(r3);
        Intrinsics.checkNotNullParameter(r0, "newState");
        this.a.a(r0);
        if (r3 != 3) goto L6;
        this.a.onComplete();
        return;
    }
}
