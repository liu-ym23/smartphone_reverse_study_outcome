package com.bytedance.ai.viewmodel;

import androidx.lifecycle.ViewModel;
import com.lynx.tasm.t;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m3.a;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ai/viewmodel/AISharedViewModel;", "Landroidx/lifecycle/ViewModel;", "Lm3/a;", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AISharedViewModel extends ViewModel implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f2909b;

    public AISharedViewModel(String r5) {
        Intrinsics.checkNotNullParameter(r5, "appGroupId");
        this.f2909b = new t(true, r5);
    }

    @Override // m3.a
    public final t a() {
        return this.f2909b;
    }

    @Override // androidx.lifecycle.ViewModel
    public final void onCleared() {
        super.onCleared();
        this.f2909b.a();
    }
}
