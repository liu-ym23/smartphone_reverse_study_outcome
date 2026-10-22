package com.bytedance.ai.viewmodel;

import a6.a;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import u4.b;
import u4.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/viewmodel/AISharedViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/ai/viewmodel/IAIViewModel;", "appGroupId", "", "<init>", "(Ljava/lang/String;)V", "sharedStorage", "Lcom/bytedance/ai/datamanager/IStorage;", "getIStorage", "onCleared", "", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AISharedViewModel extends ViewModel implements a {
    private final b sharedStorage;

    public void onCleared() {
        super.onCleared();
        this.sharedStorage.cleanup();
    }

    @Override // a6.a
    public b getIStorage() {
        return this.sharedStorage;
    }

    public AISharedViewModel(String r10) {
        Intrinsics.checkNotNullParameter(r10, "appGroupId");
        this.sharedStorage = new g(true, r10);
    }
}
