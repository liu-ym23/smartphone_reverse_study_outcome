package com.ss.android.lark.passportc.impl.v2.state;

import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class StateModel<State> {
    public State a;
    public final List<Function2<State, State, Unit>> b;

    public final State a() {
        return (State) b(StateModel$getState$1.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StateModel(AllUserState r2) {
        Intrinsics.checkNotNullParameter(r2, "initState");
        this.a = r2;
        this.b = new ArrayList();
    }

    public final <T> T b(Function1<? super State, ? extends T> r2) {
        Intrinsics.checkNotNullParameter(r2, "mapper");
        monitor-enter(this);
        T r3 = (T) r2.invoke(this.a);
        monitor-exit(this);
        return r3;
    L7:
        th = move-exception;
        throw th;
    }
}
