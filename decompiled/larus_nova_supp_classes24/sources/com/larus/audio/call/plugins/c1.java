package com.larus.audio.call.plugins;

import com.larus.audio.call.mgr.AVKitDuplexState;
import kotlin.Pair;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface c1 extends com.larus.audio.call.arch.e {
    MutableSharedFlow W();

    MutableSharedFlow i1();

    kotlinx.coroutines.flow.i1<Pair<AVKitDuplexState, Integer>> y();
}
