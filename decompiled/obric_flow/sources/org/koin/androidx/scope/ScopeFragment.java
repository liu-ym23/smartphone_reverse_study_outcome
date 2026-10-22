package org.koin.androidx.scope;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lorg/koin/androidx/scope/ScopeFragment;", "Landroidx/fragment/app/Fragment;", "Lorg/koin/android/scope/a;", "koin-android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class ScopeFragment extends Fragment implements org.koin.android.scope.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f20993a;

    public ScopeFragment() {
        super(0);
        Intrinsics.checkNotNullParameter(this, "<this>");
        final boolean r5 = true;
        this.f20993a = LazyKt.lazy(new FragmentExtKt$fragmentScope$1(this, r5));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r5, Bundle r10) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super.onViewCreated(r5, r10);
        if (t() == null) goto L6;
        return;
    L6:
        throw new IllegalStateException("Required value was null.");
    }

    @Override // org.koin.android.scope.a
    public final org.koin.core.scope.a t() {
        return (org.koin.core.scope.a) this.f20993a.getValue();
    }
}
