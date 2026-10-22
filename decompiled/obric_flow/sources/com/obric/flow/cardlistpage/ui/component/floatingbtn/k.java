package com.obric.flow.cardlistpage.ui.component.floatingbtn;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements com.obric.flow.cardlistpage.mvi.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableState f11639a;

    public k() {
        this.f11639a = SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.flow.cardlistpage.mvi.k
    public final String a() {
        return "FloatingBtnState(isVisible=" + ((Boolean) this.f11639a.getValue()).booleanValue() + ")";
    }
}
