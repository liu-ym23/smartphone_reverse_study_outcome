package com.larksuite.arch.jack;

import android.os.Handler;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.larksuite.arch.jack.j;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\n\u001a\u00028\u0000H$¢\u0006\u0002\u0010\u000bJ\u001f\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0017¢\u0006\u0002\b\u0018J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002J\b\u0010\u001a\u001a\u00020\u0015H\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0015J\u001a\u0010\u001c\u001a\u00020\u00152\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u0017J!\u0010\u001e\u001a\u00020\u00152\u0017\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0017¢\u0006\u0002\b\u0018H\u0004J9\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u0017H\u0000¢\u0006\u0002\b'JY\u0010(\u001a\u00020!\"\u0004\b\u0001\u0010)2\u0006\u0010\"\u001a\u00020#2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H)0+2\u0014\b\u0002\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H)0,0%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u0017H\u0000¢\u0006\u0002\b-J\u0093\u0001\u0010.\u001a\u00020!\"\u0004\b\u0001\u0010/2\u0006\u0010\"\u001a\u00020#2\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H/000+2\u001a\b\u0002\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H/000,0%2\u0016\b\u0002\u00101\u001a\u0010\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00172\u0010\b\u0002\u00103\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001042\u0016\b\u0002\u00105\u001a\u0010\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0017H\u0000¢\u0006\u0002\b6Jy\u0010(\u001a\u00020!\"\u0004\b\u0001\u0010)\"\u0004\b\u0002\u001072\u0006\u0010\"\u001a\u00020#2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H)0+2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H70+2\u001a\b\u0002\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H)\u0012\u0004\u0012\u0002H7090%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u0017H\u0000¢\u0006\u0002\b-J\u0099\u0001\u0010(\u001a\u00020!\"\u0004\b\u0001\u0010)\"\u0004\b\u0002\u00107\"\u0004\b\u0003\u0010:2\u0006\u0010\"\u001a\u00020#2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H)0+2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H70+2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H:0+2 \b\u0002\u0010$\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H)\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u0002H:0<0%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u0017H\u0000¢\u0006\u0002\b-J¹\u0001\u0010(\u001a\u00020!\"\u0004\b\u0001\u0010)\"\u0004\b\u0002\u00107\"\u0004\b\u0003\u0010:\"\u0004\b\u0004\u0010=2\u0006\u0010\"\u001a\u00020#2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H)0+2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H70+2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H:0+2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H=0+2&\b\u0002\u0010$\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u0002H)\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u0002H=0?0%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u0017H\u0000¢\u0006\u0002\b-JÙ\u0001\u0010(\u001a\u00020!\"\u0004\b\u0001\u0010)\"\u0004\b\u0002\u00107\"\u0004\b\u0003\u0010:\"\u0004\b\u0004\u0010=\"\u0004\b\u0005\u0010@2\u0006\u0010\"\u001a\u00020#2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H)0+2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H70+2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H:0+2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H=0+2\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H@0+2,\b\u0002\u0010$\u001a&\u0012\"\u0012 \u0012\u0004\u0012\u0002H)\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u0002H=\u0012\u0004\u0012\u0002H@0B0%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u0017H\u0000¢\u0006\u0002\b-JL\u0010C\u001a\u00020!\"\u0004\b\u0001\u0010D2\u0006\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002HD0%2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002HD0\u00172\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u0017H\u0002J\f\u0010F\u001a\u00020!*\u00020!H\u0004R\u0012\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006G"}, d2 = {"Lcom/larksuite/arch/jack/JackViewModel;", "S", "Lcom/larksuite/arch/jack/State;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "initialState", "Lcom/larksuite/arch/jack/State;", "liveData", "Landroidx/lifecycle/MutableLiveData;", "defaultState", "()Lcom/larksuite/arch/jack/State;", "disposables", "Lcom/larksuite/arch/jack/CompositeDisposable;", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "mainHandler$delegate", "Lkotlin/Lazy;", "initialize", "", "argsAcceptor", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "getLiveData", "onPrepared", "onCleared", "withState", "block", "setState", "reducer", "subscribeInternal", "Lcom/larksuite/arch/jack/Disposable;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "config", "Lcom/larksuite/arch/jack/SubscriptionConfig;", "subscriber", "subscribeInternal$jack_release", "selectSubscribeInternal", "A", "prop1", "Lkotlin/reflect/KProperty1;", "Lcom/larksuite/arch/jack/Tuple1;", "selectSubscribeInternal$jack_release", "asyncSubscribeInternal", "T", "Lcom/larksuite/arch/jack/Async;", "onError", "", "onLoading", "Lkotlin/Function0;", "onSuccess", "asyncSubscribeInternal$jack_release", "B", "prop2", "Lcom/larksuite/arch/jack/Tuple2;", "C", "prop3", "Lcom/larksuite/arch/jack/Tuple3;", "D", "prop4", "Lcom/larksuite/arch/jack/Tuple4;", "E", "prop5", "Lcom/larksuite/arch/jack/Tuple5;", "selectSubscribeMapped", "R", "mapper", "disposeOnClear", "jack_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public abstract class JackViewModel<S extends j> extends ViewModel {
    private final com.larksuite.arch.jack.b disposables;
    private S initialState;
    private MutableLiveData<S> liveData;
    private final Lazy mainHandler$delegate;

    public static final class a implements k<S> {
        public final /* synthetic */ JackViewModel<S> a;
        public final /* synthetic */ LifecycleOwner b;

        @Override // com.larksuite.arch.jack.k
        public final void a(Observer<S> r2) {
            Intrinsics.checkNotNullParameter(r2, "observer");
            JackViewModel.access$getLiveData(this.a).removeObserver(r2);
        }

        @Override // com.larksuite.arch.jack.k
        public final void b(StateFlow r3) {
            Intrinsics.checkNotNullParameter(r3, "observer");
            JackViewModel.access$getLiveData(this.a).observe(this.b, r3);
        }

        public a(JackViewModel<S> r1, LifecycleOwner r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ JackViewModel<S> a;
        public final /* synthetic */ Function1<S, S> b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(JackViewModel<S> r1, Function1<? super S, ? extends S> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MutableLiveData r0 = JackViewModel.access$getLiveData(this.a);     // Catch: Throwable -> L4
            Function1<S, S> r1 = this.b;     // Catch: Throwable -> L4
            Object r2 = JackViewModel.access$getLiveData(this.a).getValue();     // Catch: Throwable -> L4
            Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L4
            r0.setValue(r1.invoke(r2));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ Function1<S, Unit> a;
        public final /* synthetic */ JackViewModel<S> b;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function1<? super S, Unit> r1, JackViewModel<S> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Function1<S, Unit> r0 = this.a;     // Catch: Throwable -> L4
            Object r1 = JackViewModel.access$getLiveData(this.b).getValue();     // Catch: Throwable -> L4
            Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L4
            r0.invoke(r1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public abstract S defaultState();

    public void onPrepared() {
    }

    private final MutableLiveData<S> getLiveData() {
        if (this.liveData != null) goto L5;
        initialize(AnonymousClass1.INSTANCE);
    L5:
        MutableLiveData<S> r0 = this.liveData;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("liveData");
        return null;
    L9:
        return r0;
    }

    private final Handler getMainHandler() {
        return (Handler) this.mainHandler$delegate.getValue();
    }

    public void onCleared() {
        this.disposables.dispose();
        getMainHandler().removeCallbacksAndMessages(null);
    }

    public JackViewModel() {
        this.disposables = new com.larksuite.arch.jack.b();
        this.mainHandler$delegate = LazyKt.lazy(JackViewModel$mainHandler$2.INSTANCE);
    }

    public static final /* synthetic */ MutableLiveData access$getLiveData(JackViewModel r0) {
        return r0.getLiveData();
    }

    public final com.larksuite.arch.jack.c disposeOnClear(com.larksuite.arch.jack.c r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        com.larksuite.arch.jack.b r0 = this.disposables;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "d");
        if (r0.b == true) goto L16;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L6:
        if (r0.b == true) goto L10;
        r0.a.add(r3);     // Catch: Throwable -> L13
        monitor-exit(r0);
    L17:
        return r3;
    L10:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r0);
    L16:
        r3.dispose();
        goto L17
    }

    public final synchronized void initialize(Function1<? super S, ? extends S> r3) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r3, "argsAcceptor");     // Catch: Throwable -> L10
        if (this.initialState != null) goto L7;
        S r4 = (S) r3.invoke(defaultState());     // Catch: Throwable -> L10
        this.liveData = new MutableLiveData(r4);     // Catch: Throwable -> L10
        this.initialState = r4;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return;
    L7:
        g.a.a("init state again, will be ignore, model:" + this);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public final void setState(Function1<? super S, ? extends S> r3) {
        Intrinsics.checkNotNullParameter(r3, "reducer");
        Handler r0 = getMainHandler();
        Runnable r1 = new b(this, r3);
        g.a r4 = g.a;
        Function<? super Runnable, ? extends Runnable> r5 = g.b;
        if (r5 == null) goto L8;
        Runnable r6 = (Runnable) r5.apply(r1);
        if (r6 == null) goto L8;
        r1 = r6;
    L8:
        r0.post(r1);
    }

    public final void withState(Function1<? super S, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "block");
        Handler r0 = getMainHandler();
        Runnable r1 = new c(r3, this);
        g.a r4 = g.a;
        Function<? super Runnable, ? extends Runnable> r5 = g.b;
        if (r5 == null) goto L8;
        Runnable r6 = (Runnable) r5.apply(r1);
        if (r6 == null) goto L8;
        r1 = r6;
    L8:
        r0.post(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final com.larksuite.arch.jack.c subscribeInternal$jack_release(LifecycleOwner r2, l<S> r3, Function1<? super S, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r4, "subscriber");
        return selectSubscribeMapped(r2, r3, JackViewModel$subscribeInternal$2.INSTANCE, r4);
    }

    private final <R> com.larksuite.arch.jack.c selectSubscribeMapped(LifecycleOwner r3, l<R> r4, Function1<? super S, ? extends R> r5, Function1<? super S, Unit> r6) {
        int r0 = StateFlow.h;
        a r1 = new a(this, r3);
        Intrinsics.checkNotNullParameter(r3, "owner");
        Intrinsics.checkNotNullParameter(r1, "observable");
        StateFlow r2 = new StateFlow(r3, r1);
        Intrinsics.checkNotNullParameter(r5, "mapper");
        r2.c = r5;
        boolean r7 = r4.b;
        r2.f = r4.a;
        Intrinsics.checkNotNullParameter(r6, "subscriber");
        r2.d = r6;
        LifecycleOwner r8 = r2.a;
        if (r8 == null) goto L11;
        r8.getLifecycle().addObserver(r2);
        k<S> r9 = r2.b;
        if (r9 == 0) goto L9;
        r9.b(r2);
        return disposeOnClear(r2);
    L9:
        throw new IllegalArgumentException("cannot access observable after destroy".toString());
    L11:
        throw new IllegalArgumentException("cannot access owner after destroy".toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <A> com.larksuite.arch.jack.c selectSubscribeInternal$jack_release(LifecycleOwner r2, final KProperty1<S, ? extends A> r3, l<n<A>> r4, Function1<? super S, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "prop1");
        Intrinsics.checkNotNullParameter(r4, "config");
        Intrinsics.checkNotNullParameter(r5, "subscriber");
        return selectSubscribeMapped(r2, r4, new JackViewModel$selectSubscribeInternal$1(r3), r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <A, B> com.larksuite.arch.jack.c selectSubscribeInternal$jack_release(LifecycleOwner r2, final KProperty1<S, ? extends A> r3, final KProperty1<S, ? extends B> r4, l<o<A, B>> r5, Function1<? super S, Unit> r6) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "prop1");
        Intrinsics.checkNotNullParameter(r4, "prop2");
        Intrinsics.checkNotNullParameter(r5, "config");
        Intrinsics.checkNotNullParameter(r6, "subscriber");
        return selectSubscribeMapped(r2, r5, new JackViewModel$selectSubscribeInternal$2(r3, r4), r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ com.larksuite.arch.jack.c subscribeInternal$jack_release$default(JackViewModel r0, LifecycleOwner r1, l r2, Function1 r3, int r4, Object r5) {
        if (r5 != null) goto L9;
        if ((r4 & 2) == 0) goto L7;
        r2 = new l();
    L7:
        return r0.subscribeInternal$jack_release(r1, r2, r3);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: subscribeInternal");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> com.larksuite.arch.jack.c asyncSubscribeInternal$jack_release(LifecycleOwner r3, final KProperty1<S, ? extends com.larksuite.arch.jack.a<? extends T>> r4, l<n<com.larksuite.arch.jack.a<T>>> r5, final Function1<? super Throwable, Unit> r6, final Function0<Unit> r7, final Function1<? super T, Unit> r8) {
        Intrinsics.checkNotNullParameter(r3, "owner");
        Intrinsics.checkNotNullParameter(r4, "prop1");
        Intrinsics.checkNotNullParameter(r5, "config");
        return selectSubscribeMapped(r3, r5, new JackViewModel$asyncSubscribeInternal$1(r4), new JackViewModel$asyncSubscribeInternal$2(r4, r7, r6, r8));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <A, B, C> com.larksuite.arch.jack.c selectSubscribeInternal$jack_release(LifecycleOwner r2, final KProperty1<S, ? extends A> r3, final KProperty1<S, ? extends B> r4, final KProperty1<S, ? extends C> r5, l<p<A, B, C>> r6, Function1<? super S, Unit> r7) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "prop1");
        Intrinsics.checkNotNullParameter(r4, "prop2");
        Intrinsics.checkNotNullParameter(r5, "prop3");
        Intrinsics.checkNotNullParameter(r6, "config");
        Intrinsics.checkNotNullParameter(r7, "subscriber");
        return selectSubscribeMapped(r2, r6, new JackViewModel$selectSubscribeInternal$3(r3, r4, r5), r7);
    }

    public static com.larksuite.arch.jack.c selectSubscribeInternal$jack_release$default(JackViewModel r0, LifecycleOwner r1, KProperty1 r2, l r3, Function1 r4, int r5, Object r6) {
        if (r6 != null) goto L9;
        if ((r5 & 4) == 0) goto L7;
        r3 = new l();
    L7:
        return r0.selectSubscribeInternal$jack_release(r1, r2, r3, r4);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectSubscribeInternal");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <A, B, C, D> com.larksuite.arch.jack.c selectSubscribeInternal$jack_release(LifecycleOwner r2, final KProperty1<S, ? extends A> r3, final KProperty1<S, ? extends B> r4, final KProperty1<S, ? extends C> r5, final KProperty1<S, ? extends D> r6, l<q<A, B, C, D>> r7, Function1<? super S, Unit> r8) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "prop1");
        Intrinsics.checkNotNullParameter(r4, "prop2");
        Intrinsics.checkNotNullParameter(r5, "prop3");
        Intrinsics.checkNotNullParameter(r6, "prop4");
        Intrinsics.checkNotNullParameter(r7, "config");
        Intrinsics.checkNotNullParameter(r8, "subscriber");
        return selectSubscribeMapped(r2, r7, new JackViewModel$selectSubscribeInternal$4(r3, r4, r5, r6), r8);
    }

    public static com.larksuite.arch.jack.c selectSubscribeInternal$jack_release$default(JackViewModel r6, LifecycleOwner r7, KProperty1 r8, KProperty1 r9, l r10, Function1 r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 8) == 0) goto L7;
        r10 = new l();
    L7:
        return r6.selectSubscribeInternal$jack_release(r7, r8, r9, r10, r11);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectSubscribeInternal");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <A, B, C, D, E> com.larksuite.arch.jack.c selectSubscribeInternal$jack_release(LifecycleOwner r8, final KProperty1<S, ? extends A> r9, final KProperty1<S, ? extends B> r10, final KProperty1<S, ? extends C> r11, final KProperty1<S, ? extends D> r12, final KProperty1<S, ? extends E> r13, l<r<A, B, C, D, E>> r14, Function1<? super S, Unit> r15) {
        Intrinsics.checkNotNullParameter(r8, "owner");
        Intrinsics.checkNotNullParameter(r9, "prop1");
        Intrinsics.checkNotNullParameter(r10, "prop2");
        Intrinsics.checkNotNullParameter(r11, "prop3");
        Intrinsics.checkNotNullParameter(r12, "prop4");
        Intrinsics.checkNotNullParameter(r13, "prop5");
        Intrinsics.checkNotNullParameter(r14, "config");
        Intrinsics.checkNotNullParameter(r15, "subscriber");
        return selectSubscribeMapped(r8, r14, new JackViewModel$selectSubscribeInternal$5(r9, r10, r11, r12, r13), r15);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static com.larksuite.arch.jack.c asyncSubscribeInternal$jack_release$default(JackViewModel r7, LifecycleOwner r8, KProperty1 r9, l r10, Function1 r11, Function0 r12, Function1 r13, int r14, Object r15) {
        if (r15 != null) goto L21;
        if ((r14 & 4) == 0) goto L6;
        r10 = new l();
    L6:
        l r3 = r10;
        if ((r14 & 8) == 0) goto L9;
        Function1 r4 = null;
    L11:
        if ((r14 & 16) == 0) goto L13;
        Function0 r5 = null;
    L15:
        if ((r14 & 32) == 0) goto L17;
        Function1 r6 = null;
    L19:
        return r7.asyncSubscribeInternal$jack_release(r8, r9, r3, r4, r5, r6);
    L17:
        r6 = r13;
        goto L19
    L13:
        r5 = r12;
        goto L15
    L9:
        r4 = r11;
        goto L11
    L21:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: asyncSubscribeInternal");
    }

    public static com.larksuite.arch.jack.c selectSubscribeInternal$jack_release$default(JackViewModel r7, LifecycleOwner r8, KProperty1 r9, KProperty1 r10, KProperty1 r11, l r12, Function1 r13, int r14, Object r15) {
        if (r15 != null) goto L9;
        if ((r14 & 16) == 0) goto L7;
        r12 = new l();
    L7:
        return r7.selectSubscribeInternal$jack_release(r8, r9, r10, r11, r12, r13);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectSubscribeInternal");
    }

    public static com.larksuite.arch.jack.c selectSubscribeInternal$jack_release$default(JackViewModel r9, LifecycleOwner r10, KProperty1 r11, KProperty1 r12, KProperty1 r13, KProperty1 r14, l r15, Function1 r16, int r17, Object r19) {
        if (r19 != null) goto L10;
        if ((r17 & 32) == 0) goto L6;
        l r7 = new l();
    L8:
        return r9.selectSubscribeInternal$jack_release(r10, r11, r12, r13, r14, r7, r16);
    L6:
        r7 = r15;
        goto L8
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectSubscribeInternal");
    }

    public static com.larksuite.arch.jack.c selectSubscribeInternal$jack_release$default(JackViewModel r10, LifecycleOwner r11, KProperty1 r12, KProperty1 r13, KProperty1 r14, KProperty1 r15, KProperty1 r16, l r17, Function1 r19, int r110, Object r20) {
        if (r20 != null) goto L10;
        if ((r110 & 64) == 0) goto L6;
        l r8 = new l();
    L8:
        return r10.selectSubscribeInternal$jack_release(r11, r12, r13, r14, r15, r16, r8, r19);
    L6:
        r8 = r17;
        goto L8
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: selectSubscribeInternal");
    }
}
