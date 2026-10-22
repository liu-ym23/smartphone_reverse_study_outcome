package com.larus.asr.session.component;

import com.larus.im.bean.message.Message;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class j0 {
    public final String a;
    public final Message b;
    public final boolean c;
    public long d;
    public long e;
    public boolean f;
    public boolean g;
    public Function2<? super String, ? super Boolean, Boolean> h;

    public j0(String r2, Message r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.h = new i0();
    }
}
