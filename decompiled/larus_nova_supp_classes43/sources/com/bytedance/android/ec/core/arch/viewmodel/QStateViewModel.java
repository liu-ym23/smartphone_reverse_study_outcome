package com.bytedance.android.ec.core.arch.viewmodel;

import androidx.lifecycle.LiveData;
import com.bytedance.android.ec.core.arch.state.StateRepository;
import com.bytedance.android.ec.core.arch.state.b;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModel;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010$\u001a\u00028\u0000¢\u0006\u0004\b%\u0010&J\r\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006J\u0013\u0010\n\u001a\u00028\u0000H\u0084@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000e\u001a\u00020\u00072\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\b\fH\u0004R'\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00178\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR \u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00028\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Lcom/bytedance/android/ec/core/arch/viewmodel/QStateViewModel;", "Lcom/bytedance/android/ec/core/arch/state/b;", "S", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModel;", "getState", "()Lcom/bytedance/android/ec/core/arch/state/b;", "Lkotlin/Function1;", "", "consumer", "withState", "awaitState", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/ExtensionFunctionType;", "producer", "setState", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/bytedance/android/ec/core/arch/event/a;", "eventMap$delegate", "Lkotlin/Lazy;", "getEventMap$ec_core_saasRelease", "()Ljava/util/concurrent/ConcurrentHashMap;", "eventMap", "Lcom/bytedance/android/ec/core/arch/state/StateRepository;", "repository", "Lcom/bytedance/android/ec/core/arch/state/StateRepository;", "getRepository$ec_core_saasRelease", "()Lcom/bytedance/android/ec/core/arch/state/StateRepository;", "Landroidx/lifecycle/LiveData;", "uiState", "Landroidx/lifecycle/LiveData;", "getUiState$ec_core_saasRelease", "()Landroidx/lifecycle/LiveData;", "state", "Lcom/bytedance/android/ec/core/arch/state/b;", "getState$ec_core_saasRelease", "initializeState", "<init>", "(Lcom/bytedance/android/ec/core/arch/state/b;)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class QStateViewModel<S extends com.bytedance.android.ec.core.arch.state.b> extends QViewModel {
    private final Lazy eventMap$delegate;
    private final StateRepository<S> repository;
    private final S state;
    private final LiveData<S> uiState;

    public final ConcurrentHashMap<String, com.bytedance.android.ec.core.arch.event.a> getEventMap$ec_core_saasRelease() {
        return (ConcurrentHashMap) this.eventMap$delegate.getValue();
    }

    public final S getState() {
        return this.repository.a.d;
    }

    public final StateRepository<S> getRepository$ec_core_saasRelease() {
        return this.repository;
    }

    public final S getState$ec_core_saasRelease() {
        return this.state;
    }

    public final LiveData<S> getUiState$ec_core_saasRelease() {
        return this.uiState;
    }

    public QStateViewModel(S r10) {
        Intrinsics.checkNotNullParameter(r10, "initializeState");
        this.eventMap$delegate = LazyKt.lazy(QStateViewModel$eventMap$2.INSTANCE);
        StateRepository<S> r0 = new StateRepository(r10, mg.b.a(this));
        this.repository = r0;
        com.bytedance.android.ec.core.arch.state.a<S> r11 = r0.a;
        this.uiState = r11.e;
        this.state = r11.d;
    }

    public final Object awaitState(Continuation<? super S> r10) {
        return this.repository.a(r10);
    }

    public final void setState(Function1<? super S, ? extends S> r10) {
        Intrinsics.checkNotNullParameter(r10, "producer");
        StateRepository<S> r0 = this.repository;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r10, "reducer");
        com.bytedance.android.ec.core.arch.state.a<S> r1 = r0.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, "stateReducer");
        r1.a.offer(r10);
    }

    public final void withState(Function1<? super S, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "consumer");
        StateRepository<S> r0 = this.repository;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r10, "action");
        com.bytedance.android.ec.core.arch.state.a<S> r1 = r0.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, "block");
        r1.b.offer(r10);
    }
}
