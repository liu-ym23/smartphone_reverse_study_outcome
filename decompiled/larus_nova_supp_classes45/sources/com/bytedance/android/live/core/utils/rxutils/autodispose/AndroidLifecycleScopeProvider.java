package com.bytedance.android.live.core.utils.rxutils.autodispose;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.utils.rxutils.autodispose.lifecycle.LifecycleEndedException;
import com.bytedance.android.live.core.utils.rxutils.autodispose.lifecycle.LifecycleScopeProvider;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class AndroidLifecycleScopeProvider implements LifecycleScopeProvider<Lifecycle.Event> {
    private static final m80.a<Lifecycle.Event> DEFAULT_CORRESPONDING_EVENTS = null;
    private final m80.a<Lifecycle.Event> boundaryResolver;
    private final w lifecycleObservable;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Lifecycle.Event.values().length];
            a = r0;
            r0[Lifecycle.Event.ON_CREATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            a[Lifecycle.Event.ON_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            a[Lifecycle.Event.ON_RESUME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            a[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            a[Lifecycle.Event.ON_STOP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            a[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public static class b implements m80.a<Lifecycle.Event> {
        public final Lifecycle.Event a;

        public b(Lifecycle.Event r1) {
            this.a = r1;
        }

        @Override // m80.a
        public final Lifecycle.Event apply(Lifecycle.Event r1) throws OutsideScopeException {
            return this.a;
        }
    }

    public static /* synthetic */ Lifecycle.Event a(Lifecycle.Event r0) {
        return lambda$static$0(r0);
    }

    static {
        DEFAULT_CORRESPONDING_EVENTS = new com.bytedance.android.live.core.utils.rxutils.autodispose.a();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.android.live.core.utils.rxutils.autodispose.lifecycle.LifecycleScopeProvider
    public Lifecycle.Event peekLifecycle() {
        w r0 = this.lifecycleObservable;
        r0.getClass();
        int r1 = w.a.a[r0.a.getCurrentState().ordinal()];
        if (r1 != 1) goto L5;
        Lifecycle.Event r2 = Lifecycle.Event.ON_CREATE;
    L14:
        r0.b.onNext(r2);
        return (Lifecycle.Event) this.lifecycleObservable.b.getValue();
    L5:
        if (r1 != 2) goto L7;
        r2 = Lifecycle.Event.ON_START;
        goto L14
    L7:
        if (r1 != 3) goto L9;
    L11:
        r2 = Lifecycle.Event.ON_RESUME;
        goto L14
    L9:
        if (r1 == 4) goto L11;
        r2 = Lifecycle.Event.ON_DESTROY;
        goto L14
    }

    @Override // com.bytedance.android.live.core.utils.rxutils.autodispose.lifecycle.LifecycleScopeProvider, com.bytedance.android.live.core.utils.rxutils.autodispose.ScopeProvider
    public CompletableSource requestScope() {
        return m80.e.a(this);
    }

    @Override // com.bytedance.android.live.core.utils.rxutils.autodispose.lifecycle.LifecycleScopeProvider
    public m80.a<Lifecycle.Event> correspondingEvents() {
        return this.boundaryResolver;
    }

    @Override // com.bytedance.android.live.core.utils.rxutils.autodispose.lifecycle.LifecycleScopeProvider
    public Observable<Lifecycle.Event> lifecycle() {
        return this.lifecycleObservable;
    }

    @Override // com.bytedance.android.live.core.utils.rxutils.autodispose.lifecycle.LifecycleScopeProvider
    public /* bridge */ /* synthetic */ Lifecycle.Event peekLifecycle() {
        return peekLifecycle();
    }

    private static /* synthetic */ Lifecycle.Event lambda$static$0(Lifecycle.Event r3) throws OutsideScopeException {
        int r0 = a.a[r3.ordinal()];
        if (r0 == 1) goto L19;
        if (r0 == 2) goto L17;
        if (r0 == 3) goto L15;
        if (r0 != 4) goto L13;
        return Lifecycle.Event.ON_STOP;
    L13:
        throw new LifecycleEndedException("Lifecycle has ended! Last event was " + r3);
    L15:
        return Lifecycle.Event.ON_PAUSE;
    L17:
        return Lifecycle.Event.ON_STOP;
    L19:
        return Lifecycle.Event.ON_DESTROY;
    }

    private AndroidLifecycleScopeProvider(Lifecycle r2, m80.a<Lifecycle.Event> r3) {
        this.lifecycleObservable = new w(r2);
        this.boundaryResolver = r3;
    }

    public static AndroidLifecycleScopeProvider from(Lifecycle r1, Lifecycle.Event r2) {
        return from(r1, new b(r2));
    }

    public static AndroidLifecycleScopeProvider from(LifecycleOwner r0, Lifecycle.Event r1) {
        return from(r0.getLifecycle(), r1);
    }

    public static AndroidLifecycleScopeProvider from(LifecycleOwner r0, m80.a<Lifecycle.Event> r1) {
        return from(r0.getLifecycle(), r1);
    }

    public static AndroidLifecycleScopeProvider from(Lifecycle r1, m80.a<Lifecycle.Event> r2) {
        return new AndroidLifecycleScopeProvider(r1, r2);
    }
}
