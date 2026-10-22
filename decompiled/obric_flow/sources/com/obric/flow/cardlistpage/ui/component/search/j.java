package com.obric.flow.cardlistpage.ui.component.search;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import com.obric.flow.cardlistpage.mvi.k;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableState f11762a;

    public j() {
        this.f11762a = SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.flow.cardlistpage.mvi.k
    public final String a() {
        return "SearchState(isVisible=" + ((Boolean) this.f11762a.getValue()).booleanValue() + ")";
    }
}
