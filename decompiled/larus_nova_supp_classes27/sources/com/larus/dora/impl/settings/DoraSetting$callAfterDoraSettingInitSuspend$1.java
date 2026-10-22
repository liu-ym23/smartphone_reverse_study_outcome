package com.larus.dora.impl.settings;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.settings.DoraSetting", f = "DoraSetting.kt", i = {0, 0}, l = {129}, m = "callAfterDoraSettingInitSuspend", n = {"tag", "callback"}, s = {"L$0", "L$1"})
public final class DoraSetting$callAfterDoraSettingInitSuspend$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraSetting this$0;

    public DoraSetting$callAfterDoraSettingInitSuspend$1(DoraSetting r1, Continuation<? super DoraSetting$callAfterDoraSettingInitSuspend$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r9) {
        this.result = r9;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(0, 0, null, null, this);
    }
}
