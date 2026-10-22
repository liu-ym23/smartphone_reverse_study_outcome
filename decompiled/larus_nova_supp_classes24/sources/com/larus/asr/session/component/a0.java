package com.larus.asr.session.component;

import com.larus.im.bean.message.Message;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a0 {
    public final f0 a;
    public final Function1<Message, Unit> b;

    public final f0 getContext() {
        return this.a;
    }

    public a0(f0 r2, com.larus.asr.session.j r3) {
        Intrinsics.checkNotNullParameter(r3, "beforeSendAudioMessage");
        this.a = r2;
        this.b = r3;
    }
}
