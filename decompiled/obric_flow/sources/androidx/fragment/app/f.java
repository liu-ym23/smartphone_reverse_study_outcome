package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.savedstate.SavedStateRegistry;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements SavedStateRegistry.SavedStateProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f536b;

    public /* synthetic */ f(Object r5, int r10) {
        this.f535a = r10;
        this.f536b = r5;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle saveState() {
        int r5 = this.f535a;
        Object r10 = this.f536b;
        switch(r5) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return SavedStateHandle.a((SavedStateHandle) r10);
    L7:
        return FragmentManager.b((FragmentManager) r10);
    L9:
        return FragmentActivity.f((FragmentActivity) r10);
    }
}
