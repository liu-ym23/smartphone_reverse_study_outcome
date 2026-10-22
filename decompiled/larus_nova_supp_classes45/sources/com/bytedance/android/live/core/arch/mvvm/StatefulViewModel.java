package com.bytedance.android.live.core.arch.mvvm;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00010\u0002B\u000f\u0012\u0006\u0010\u001b\u001a\u00028\u0001¢\u0006\u0004\b\u001c\u0010\u0012J\u000f\u0010\u0005\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007H\u0016J\u0016\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016R*\u0010\u000e\u001a\u00028\u00012\u0006\u0010\r\u001a\u00028\u00018\u0004@DX\u0084\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\u0012R$\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00018\u00018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00178&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/core/arch/mvvm/StatefulViewModel;", "D", "", "S", "Lcom/bytedance/android/live/core/arch/mvvm/AbsViewModel;", "state", "()Ljava/lang/Object;", "Lio/reactivex/Observable;", "stateChanged", "Lcom/bytedance/android/live/core/arch/mvvm/a;", "view", "Lio/reactivex/disposables/Disposable;", "subscribe", "value", "currentState", "Ljava/lang/Object;", "getCurrentState", "setCurrentState", "(Ljava/lang/Object;)V", "Lio/reactivex/subjects/BehaviorSubject;", "kotlin.jvm.PlatformType", "stateChangedSubject", "Lio/reactivex/subjects/BehaviorSubject;", "", "getTag", "()Ljava/lang/String;", "tag", "initialState", "<init>", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class StatefulViewModel<D, S> extends AbsViewModel<D> {
    private S currentState;
    private BehaviorSubject<S> stateChangedSubject;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ StatefulViewModel a;
        public final /* synthetic */ com.bytedance.android.live.core.arch.mvvm.a b;

        public a(StatefulViewModel r1, com.bytedance.android.live.core.arch.mvvm.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(S r2) {
            this.b.Pd(this.a.getData());
        }
    }

    public abstract String getTag();

    public final S getCurrentState() {
        return this.currentState;
    }

    public S state() {
        return this.currentState;
    }

    public Observable<S> stateChanged() {
        return this.stateChangedSubject;
    }

    public StatefulViewModel(S r2) {
        Intrinsics.checkNotNullParameter(r2, "initialState");
        this.currentState = r2;
        this.stateChangedSubject = BehaviorSubject.createDefault(r2);
    }

    public final void setCurrentState(S r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.currentState = r2;
        this.stateChangedSubject.onNext(r2);
    }

    @Override // com.bytedance.android.live.core.arch.mvvm.AbsViewModel
    public Disposable subscribe(com.bytedance.android.live.core.arch.mvvm.a<D> r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        return this.stateChangedSubject.subscribe(new a(this, r3));
    }
}
