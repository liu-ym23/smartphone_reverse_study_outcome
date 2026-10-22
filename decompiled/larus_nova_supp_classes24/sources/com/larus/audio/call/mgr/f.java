package com.larus.audio.call.mgr;

import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface f extends com.larus.audio.call.arch.e {

    public interface a {
        void Q(MajorState r1, MajorState r2);
    }

    MajorState A0();

    void F2(DownStateReducer r1, ReducerPosition r2);

    void M0(a r1);

    void V(a r1);

    boolean a1(MajorState r1, String r2);

    void error(int r1, String r2);

    void n2(StateTriggerEvent r1);

    MajorState s1();

    void t();

    void t1(u68.c r1);

    i1<AVKitDuplexState> y();

    void z();
}
