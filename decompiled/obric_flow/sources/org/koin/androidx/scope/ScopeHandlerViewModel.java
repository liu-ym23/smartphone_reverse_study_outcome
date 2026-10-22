package org.koin.androidx.scope;

import androidx.lifecycle.ViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lorg/koin/androidx/scope/ScopeHandlerViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "koin-android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ScopeHandlerViewModel extends ViewModel {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public org.koin.core.scope.a f20994b;

    public ScopeHandlerViewModel() {
    }

    @Override // androidx.lifecycle.ViewModel
    public final void onCleared() {
        super.onCleared();
        org.koin.core.scope.a r5 = this.f20994b;
        if (r5 != null) goto L5;
    L7:
        this.f20994b = null;
        return;
    L5:
        if (r5.f21027i == true) goto L7;
        r5.d.f21001c.o("Closing scope " + this.f20994b);
        r5.a();
        goto L7
    }
}
