package com.larus.asr.session.component;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface q0 extends o0 {
    void b(Function1<? super String, com.larus.bmhome.chat.component.bottom.core.speaker.a> r1);

    void g(Function2<? super String, ? super Boolean, Unit> r1);

    void k(Function2<? super String, ? super String, Boolean> r1);

    void m(Function1<? super com.larus.audio.b, Boolean> r1, Function1<? super com.larus.audio.a, Boolean> r2, Function2<? super String, ? super byte[], Unit> r3, Function1<? super String, Boolean> r4);
}
