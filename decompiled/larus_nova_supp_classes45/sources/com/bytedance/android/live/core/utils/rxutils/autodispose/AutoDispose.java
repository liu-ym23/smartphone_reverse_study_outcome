package com.bytedance.android.live.core.utils.rxutils.autodispose;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.utils.rxutils.CommonTransformer;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class AutoDispose {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class a<T> implements AutoDisposeConverter<T> {
        public final /* synthetic */ CompletableSource a;
        public final /* synthetic */ CommonTransformer b;

        @Override // com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDisposeConverter
        public final Object apply(Completable r2) {
            CommonTransformer r0 = this.b;
            if (r0 == null) goto L6;
            r2 = r2.compose(r0);
        L6:
            return new f(this, r2);
        }

        @Override // com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDisposeConverter
        public final Object apply(Flowable r2) {
            CommonTransformer r0 = this.b;
            if (r0 == null) goto L6;
            r2 = r2.compose(r0);
        L6:
            return new g(this, r2);
        }

        @Override // com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDisposeConverter
        public final Object apply(Maybe r2) {
            CommonTransformer r0 = this.b;
            if (r0 == null) goto L6;
            r2 = r2.compose(r0);
        L6:
            return new h(this, r2);
        }

        @Override // com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDisposeConverter
        public final Object apply(Observable r2) {
            CommonTransformer r0 = this.b;
            if (r0 == null) goto L6;
            r2 = r2.compose(r0);
        L6:
            return new i(this, r2);
        }

        @Override // com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDisposeConverter
        public final Object apply(Single r2) {
            CommonTransformer r0 = this.b;
            if (r0 == null) goto L6;
            r2 = r2.compose(r0);
        L6:
            return new j(this, r2);
        }

        @Override // com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDisposeConverter
        public final Object apply(wtc.a r2) {
            final CompletableSource r3 = this.a;
            return new e(r3);
        }

        public a(CompletableSource r1, CommonTransformer r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static /* synthetic */ CompletableSource a(ScopeProvider r0) {
        return lambda$autoDisposable$0(r0);
    }

    public static /* synthetic */ CompletableSource b(ScopeProvider r0) {
        return lambda$autoDisposable$1(r0);
    }

    private AutoDispose() {
        throw new AssertionError("No instances");
    }

    public static <T> AutoDisposeConverter<T> autoDisposable(final ScopeProvider r1) {
        q.a(r1, "provider == null");
        return autoDisposable(Completable.defer(new c(r1)), null);
    }

    public static <T> AutoDisposeConverter<T> bind(Fragment r1) {
        if (r1 != null) goto L6;
        return autoDisposable(new b());
    L6:
        return autoDisposable(AndroidLifecycleScopeProvider.from(r1, Lifecycle.Event.ON_DESTROY));
    }

    private static /* synthetic */ CompletableSource lambda$autoDisposable$0(ScopeProvider r0) throws Exception {
        return r0.requestScope();
    L4:
        e = move-exception;
        return Completable.error(e);
    }

    private static /* synthetic */ CompletableSource lambda$autoDisposable$1(ScopeProvider r0) throws Exception {
        return r0.requestScope();
    L4:
        e = move-exception;
        return Completable.error(e);
    }

    public static <T> AutoDisposeConverter<T> bind(FragmentActivity r1) {
        if (r1 != null) goto L6;
        return autoDisposable(new b());
    L6:
        return autoDisposable(AndroidLifecycleScopeProvider.from(r1, Lifecycle.Event.ON_DESTROY));
    }

    public static <T> AutoDisposeConverter<T> bind(LifecycleOwner r1) {
        if (r1 != null) goto L6;
        return autoDisposable(new b());
    L6:
        return autoDisposable(AndroidLifecycleScopeProvider.from(r1, Lifecycle.Event.ON_DESTROY));
    }

    public static <T> AutoDisposeConverter<T> bind(View r1) {
        if (r1 != null) goto L6;
        return autoDisposable(new b());
    L6:
        return autoDisposable(new k80.b(r1));
    }

    public static <T> AutoDisposeConverter<T> autoDisposable(final ScopeProvider r1, CommonTransformer<T> r2) {
        q.a(r1, "provider == null");
        return autoDisposable(Completable.defer(new d(r1)), r2);
    }

    public static <T> AutoDisposeConverter<T> autoDisposable(CompletableSource r1, CommonTransformer<T> r2) {
        q.a(r1, "scope == null");
        return new a(r1, r2);
    }
}
