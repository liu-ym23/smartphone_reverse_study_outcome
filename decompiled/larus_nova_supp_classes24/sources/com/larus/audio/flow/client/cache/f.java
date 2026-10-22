package com.larus.audio.flow.client.cache;

import com.larus.audio.audiov3.task.tts.TtsEventEnum;
import com.larus.audio.audiov3.task.tts.TtsState;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f {
    public static final MutableSharedFlow<TtsEventEnum> a = null;
    public static final MutableSharedFlow<TtsState> b = null;
    public static final MutableSharedFlow<byte[]> c = null;

    static {
        BufferOverflow r0 = BufferOverflow.DROP_OLDEST;
        a = SharedFlowKt.MutableSharedFlow(1, 1, r0);
        b = SharedFlowKt.MutableSharedFlow(1, 1, r0);
        c = SharedFlowKt.MutableSharedFlow(0, 2, BufferOverflow.SUSPEND);
    }
}
