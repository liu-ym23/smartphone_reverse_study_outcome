package com.larksuite.arch.jack;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0000\u0018\u0000 #*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u00042\u00020\u0005:\u0001#B#\b\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f0\rH\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002J\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0012\u001a\u00020\u0013J\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0014\u001a\u00020\u0013J&\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\rJ\u001a\u0010\u001a\u001a\u00020\u00052\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f0\rJ\u0015\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u0007H\u0016J\b\u0010 \u001a\u00020\u000fH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\rX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/larksuite/arch/jack/StateFlow;", "S", "R", "Landroidx/lifecycle/Observer;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Lcom/larksuite/arch/jack/Disposable;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observable", "Lcom/larksuite/arch/jack/StateObservable;", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Lcom/larksuite/arch/jack/StateObservable;)V", "mapper", "Lkotlin/Function1;", "realSubscriber", "", "lastValue", "Ljava/lang/Object;", "distinctUntilChanged", "", "skipInit", "disposed", "requireSourceObserver", "requireOwner", "requireObserable", "map", "subscriber", "onChanged", "newValue", "(Ljava/lang/Object;)V", "onDestroy", "lifecycleOwner", "dispose", "isDisposed", "()Z", "Companion", "jack_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class StateFlow<S, R> implements Observer<S>, DefaultLifecycleObserver, c {
    public static final /* synthetic */ int h = 0;
    public LifecycleOwner a;
    public k<S> b;
    public Function1<? super S, ? extends R> c;
    public Function1<? super S, Unit> d;
    public S e;
    public boolean f;
    public volatile boolean g;

    public static final class a {
    }

    static {
    }

    public StateFlow() {
        throw null;
    }

    public final /* synthetic */ void onCreate(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onCreate(this, r1);
    }

    public final /* synthetic */ void onPause(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onPause(this, r1);
    }

    public final /* synthetic */ void onResume(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onResume(this, r1);
    }

    public final /* synthetic */ void onStart(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onStart(this, r1);
    }

    public final /* synthetic */ void onStop(LifecycleOwner r1) {
        DefaultLifecycleObserver.-CC.$default$onStop(this, r1);
    }

    @Override // com.larksuite.arch.jack.c
    public final void dispose() {
        if (this.g == true) goto L13;
        this.g = true;
        LifecycleOwner r0 = this.a;
        if (r0 == null) goto L12;
        r0.getLifecycle().removeObserver(this);
        k<S> r1 = this.b;
        if (r1 == null) goto L10;
        r1.a(this);
        goto L13
    L10:
        throw new IllegalArgumentException("cannot access observable after destroy".toString());
    L12:
        throw new IllegalArgumentException("cannot access owner after destroy".toString());
    L13:
        this.a = null;
        this.b = null;
        this.d = null;
    }

    public final void onChanged(S r5) {
        if (this.f == false) goto L17;
        S r0 = this.e;
        Function1<? super S, ? extends R> r2 = null;
        if (r0 == null) goto L10;
        Function1<? super S, ? extends R> r3 = this.c;
        if (r3 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mapper");
        r3 = null;
    L9:
        Object r1 = r3.invoke(r0);
    L11:
        Function1<? super S, ? extends R> r4 = this.c;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mapper");
    L16:
        if (Objects.equals(r1, r2.invoke(r5)) == false) goto L17;
        return;
    L14:
        r2 = r4;
        goto L16
    L10:
        r1 = null;
    L17:
        this.e = r5;
        Function1<? super S, Unit> r6 = this.d;
        if (r6 == null) goto L22;
        r6.invoke(r5);
        return;
    L22:
        throw new IllegalArgumentException("cannot access observer after destroy".toString());
    }

    public final void onDestroy(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        dispose();
    }

    public StateFlow(LifecycleOwner r1, JackViewModel.a r2) {
        this.a = r1;
        this.b = r2;
    }
}
