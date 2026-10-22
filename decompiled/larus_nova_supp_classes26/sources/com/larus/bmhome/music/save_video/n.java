package com.larus.bmhome.music.save_video;

import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class n<T> implements FlowCollector {
    public final /* synthetic */ Function1<Boolean, Unit> a;
    public final /* synthetic */ String b;

    public n(com.larus.bmhome.bigimg.download.c r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object emit(Object r2, Continuation r3) {
        List r4 = (List) r2;
        this.a.invoke(Boxing.boxBoolean(((List) MusicVideoSaver.b.getValue()).contains(this.b)));
        return Unit.INSTANCE;
    }
}
