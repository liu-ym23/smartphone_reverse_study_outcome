package com.larus.bmhome.view.actionbar.custom;

import androidx.lifecycle.LifecycleCoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class p1 implements ts8.b {
    public final /* synthetic */ CustomActionBar a;
    public final /* synthetic */ LifecycleCoroutineScope b;

    @Override // ts8.b
    public final void onClick() {
        CustomActionBarViewModel r0 = this.a.o;
        if (r0 == null) goto L6;
        r0.updateConfigFromRemote(this.b);
        return;
    }

    public p1(CustomActionBar r1, LifecycleCoroutineScope r2) {
        this.a = r1;
        this.b = r2;
    }
}
