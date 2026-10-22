package com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ PkStateMachineController a;

    public f(PkStateMachineController r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        Long r8 = (Long) r7;
        PkStateMachineController.e(this.a, PkBaseStateMachine.Source.PKTimeUp, "audience_no_finish_im", 0, 60);
    }
}
