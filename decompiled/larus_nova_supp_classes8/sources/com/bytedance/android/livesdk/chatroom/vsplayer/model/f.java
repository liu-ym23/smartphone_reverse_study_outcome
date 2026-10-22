package com.bytedance.android.livesdk.chatroom.vsplayer.model;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ VSSeekBarMarkRepelStack a;
    public final /* synthetic */ Function2 b;

    public f(VSSeekBarMarkRepelStack r1, Function2 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r3) {
        VSSeekBarMarkRepelStack r4 = (VSSeekBarMarkRepelStack) r3;
        Function2 r5 = this.b;
        VSSeekBarMarkRepelStack r0 = this.a;
        r5.invoke(r0, r0.a);
    }
}
