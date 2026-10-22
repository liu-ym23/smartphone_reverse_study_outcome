package com.ttnet.org.chromium.base;

/* JADX INFO: renamed from: com.ttnet.org.chromium.base.-$$Lambda$EZnZNrcCA72vS8z3mA_yvnO1EPY, reason: invalid class name */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class $$Lambda$EZnZNrcCA72vS8z3mA_yvnO1EPY implements Callback {
    public final /* synthetic */ Promise f$0;

    public /* synthetic */ $$Lambda$EZnZNrcCA72vS8z3mA_yvnO1EPY(Promise r1) {
        this.f$0 = r1;
    }

    @Override // com.ttnet.org.chromium.base.Callback
    public final void onResult(Object r1) {
        this.f$0.reject((Exception) r1);
    }
}
