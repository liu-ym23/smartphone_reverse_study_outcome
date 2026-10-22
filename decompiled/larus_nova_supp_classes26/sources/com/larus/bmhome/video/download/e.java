package com.larus.bmhome.video.download;

import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.FlowCollector;
import nr9.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e<T> implements FlowCollector {
    public final /* synthetic */ Function1<Boolean, Unit> a;
    public final /* synthetic */ VideoDownloadLoadingMgr b;
    public final /* synthetic */ g c;

    public e(com.larus.bmhome.bigimg.download.b r1, VideoDownloadLoadingMgr r2, g r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object emit(Object r2, Continuation r3) {
        List r4 = (List) r2;
        this.a.invoke(Boxing.boxBoolean(((List) this.b.k.getValue()).contains(this.c)));
        return Unit.INSTANCE;
    }
}
