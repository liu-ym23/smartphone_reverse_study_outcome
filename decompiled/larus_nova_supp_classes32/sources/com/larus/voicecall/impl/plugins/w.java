package com.larus.voicecall.impl.plugins;

import com.larus.voicecall.impl.bean.RealtimeVlmLimitStatus;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface w extends com.larus.audio.call.arch.e {
    void A1(Function1<? super RealtimeVlmLimitStatus, Unit> r1);

    RealtimeVlmLimitStatus W1();
}
