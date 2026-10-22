package com.bytedance.android.live.core.arch.mvvm;

import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&R\u0014\u0010\t\u001a\u00028\u00008$X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/core/arch/mvvm/AbsViewModel;", "D", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/android/live/core/arch/mvvm/a;", "view", "Lio/reactivex/disposables/Disposable;", "subscribe", "getData", "()Ljava/lang/Object;", "data", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsViewModel<D> extends ViewModel {
    public abstract D getData();

    public abstract Disposable subscribe(a<D> r1);

    public AbsViewModel() {
    }
}
