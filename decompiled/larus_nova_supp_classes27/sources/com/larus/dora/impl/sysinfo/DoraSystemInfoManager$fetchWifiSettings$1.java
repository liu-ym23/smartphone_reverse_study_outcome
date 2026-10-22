package com.larus.dora.impl.sysinfo;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.sysinfo.DoraSystemInfoManager", f = "DoraSystemInfoManager.kt", i = {0}, l = {489}, m = "fetchWifiSettings", n = {"convertor$iv"}, s = {"L$0"})
final class DoraSystemInfoManager$fetchWifiSettings$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraSystemInfoManager this$0;

    public DoraSystemInfoManager$fetchWifiSettings$1(DoraSystemInfoManager r1, Continuation<? super DoraSystemInfoManager$fetchWifiSettings$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return DoraSystemInfoManager.a(this.this$0, this);
    }
}
