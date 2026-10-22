package com.obric.assistant.activation.presentation.runtime.manager;

import android.os.IBinder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class v1 implements IBinder.DeathRecipient {
    public final /* synthetic */ Ref.ObjectRef a;

    public /* synthetic */ v1(Ref.ObjectRef r1) {
        this.a = r1;
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        Ref.ObjectRef r0 = this.a;
        ObricMainProcessStateManager r1 = ObricMainProcessStateManager.a;
        Object r2 = r0.element;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("registration");
        ObricMainProcessStateManager.a r3 = null;
    L6:
        r1.getClass();
        ObricMainProcessStateManager.a(r3, "binder_died");
        return;
    L5:
        r3 = (ObricMainProcessStateManager.a) r2;
        goto L6
    }
}
