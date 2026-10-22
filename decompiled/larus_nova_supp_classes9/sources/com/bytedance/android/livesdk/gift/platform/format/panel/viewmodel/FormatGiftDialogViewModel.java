package com.bytedance.android.livesdk.gift.platform.format.panel.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdk.gift.model.z3;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/format/panel/viewmodel/FormatGiftDialogViewModel;", "Landroidx/lifecycle/ViewModel;", BuildConfig.FLAVOR, "onCleared", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/android/livesdk/gift/model/z3;", "info", "Landroidx/lifecycle/MutableLiveData;", "getInfo", "()Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", BuildConfig.FLAVOR, "fadingEdge", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "getFadingEdge", "()Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FormatGiftDialogViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final NextLiveData<Boolean> fadingEdge;
    private final MutableLiveData<z3> info;

    public FormatGiftDialogViewModel() {
        this.compositeDisposable = new CompositeDisposable();
        this.info = new MutableLiveData();
        this.fadingEdge = new NextLiveData();
    }

    public void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }

    public final CompositeDisposable getCompositeDisposable() {
        return this.compositeDisposable;
    }

    public final NextLiveData<Boolean> getFadingEdge() {
        return this.fadingEdge;
    }

    public final MutableLiveData<z3> getInfo() {
        return this.info;
    }
}
