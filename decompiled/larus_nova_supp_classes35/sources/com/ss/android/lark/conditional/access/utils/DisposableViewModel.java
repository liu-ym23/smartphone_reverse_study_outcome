package com.ss.android.lark.conditional.access.utils;

import androidx.lifecycle.ViewModel;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0014R\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/conditional/access/utils/DisposableViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "onCleared", BuildConfig.FLAVOR, "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class DisposableViewModel extends ViewModel {
    private final CompositeDisposable disposables;

    public DisposableViewModel() {
        this.disposables = new CompositeDisposable();
    }

    public void onCleared() {
        super.onCleared();
        this.disposables.dispose();
    }

    public final CompositeDisposable getDisposables() {
        return this.disposables;
    }
}
