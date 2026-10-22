package com.obric.flow.cardlistpage.ui.component.topgradient;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import com.obric.flow.cardlistpage.mvi.k;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableState f11765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableState f11766b;

    public f() {
        Boolean r5 = Boolean.FALSE;
        this.f11765a = SnapshotStateKt.mutableStateOf$default(r5, null, 2, null);
        this.f11766b = SnapshotStateKt.mutableStateOf$default(r5, null, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.flow.cardlistpage.mvi.k
    public final String a() {
        return "TopGradientState(isVisible=" + ((Boolean) this.f11765a.getValue()).booleanValue() + ", isBlurNeeded=" + ((Boolean) this.f11766b.getValue()).booleanValue() + ")";
    }
}
