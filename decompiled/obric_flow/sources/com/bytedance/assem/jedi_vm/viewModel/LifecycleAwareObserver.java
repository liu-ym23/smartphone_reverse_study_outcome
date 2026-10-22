package com.bytedance.assem.jedi_vm.viewModel;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import mt.u;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\u00020\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/assem/jedi_vm/viewModel/LifecycleAwareObserver;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/concurrent/atomic/AtomicReference;", "Lio/reactivex/disposables/Disposable;", "Landroidx/lifecycle/LifecycleEventObserver;", "Lmt/u;", "ext_rx_view_model_release"}, k = 1, mv = {1, 4, 0})
public final class LifecycleAwareObserver<T> extends AtomicReference<Disposable> implements LifecycleEventObserver, u, Disposable {
    @Override // mt.u
    public abstract /* synthetic */ void onComplete();

    @Override // mt.u
    public abstract /* synthetic */ void onError(Throwable r5);

    @Override // mt.u
    public abstract /* synthetic */ void onNext(Object r5);

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner r5, Lifecycle.Event r10) {
        if (r5.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L5;
        throw null;
    L5:
        throw null;
    }

    @Override // mt.u
    public abstract /* synthetic */ void onSubscribe(Disposable r5);
}
