package k0c;

import com.ss.android.lark.passportc.api.ExecuteStrategy;
import com.ss.android.lark.passportc.api.Scene;
import com.ss.android.lark.passportc.task.f;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements d {
    public final f a;
    public final int b;
    public final j0c.c c;
    public final l0c.d d;
    public final List<d> e;
    public final List<d> f;

    /* JADX INFO: renamed from: k0c.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0157a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ExecuteStrategy.values().length];
            r0[ExecuteStrategy.NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ExecuteStrategy.ROLLBACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ExecuteStrategy.RETRY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ ExecuteStrategy b;
        public final /* synthetic */ j0c.e c;

        public b(a r1, ExecuteStrategy r2, j0c.e r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            Disposable r5 = (Disposable) r4;
            a r6 = this.a;
            l0c.d r0 = r6.d;
            if (r0 == null) goto L6;
            j0c.b r7 = r6.a.F();
            String r1 = this.b.name();
            Scene r2 = this.c.b;
            r0.a(r7, r1);
            return;
        }
    }

    public static final class c implements Action {
        public final /* synthetic */ a a;
        public final /* synthetic */ ExecuteStrategy b;
        public final /* synthetic */ j0c.e c;

        public c(a r1, ExecuteStrategy r2, j0c.e r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void run() {
            a r0 = this.a;
            l0c.d r1 = r0.d;
            if (r1 == null) goto L6;
            r1.b(r0.a.F(), this.b.name(), this.c.b);
            return;
        }
    }

    @Override // k0c.d
    public final j0c.b c() {
        return this.a.F();
    }

    @Override // k0c.d
    public final List<d> children() {
        return this.f;
    }

    @Override // k0c.d
    public final int getOrder() {
        return this.b;
    }

    @Override // k0c.d
    public final f getTask() {
        return this.a;
    }

    @Override // k0c.d
    public final List<d> parents() {
        return this.e;
    }

    @Override // k0c.d
    public final void b(d r2) {
        Intrinsics.checkNotNullParameter(r2, "task");
        ((ArrayList) this.f).add(r2);
    }

    @Override // k0c.d
    public final void d(d r2) {
        Intrinsics.checkNotNullParameter(r2, "task");
        ((ArrayList) this.e).add(r2);
    }

    @Override // k0c.d
    public final Observable<j0c.c> a(j0c.e r3, ExecuteStrategy r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "executeStrategy");
        int r0 = C0157a.a[r4.ordinal()];
        if (r0 != 1) goto L5;
        Observable<j0c.c> r1 = this.a.I(r3);
    L16:
        Observable<j0c.c> r5 = r1.doOnSubscribe(new b(this, r4, r3)).doOnTerminate(new c(this, r4, r3));
        Intrinsics.checkNotNull(r5);
        return r5;
    L5:
        if (r0 != 2) goto L7;
        r1 = this.a.H(r3);
        goto L16
    L7:
        if (r0 != 3) goto L13;
        j0c.c r2 = this.c;
        if (r2 == null) goto L11;
        r1 = Observable.just(r2);
        goto L16
    L11:
        r1 = this.a.I(r3);
        goto L16
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public a(f r2, int r3, j0c.c r4, l0c.d r5) {
        Intrinsics.checkNotNullParameter(r2, "task");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = new ArrayList();
        this.f = new ArrayList();
    }
}
