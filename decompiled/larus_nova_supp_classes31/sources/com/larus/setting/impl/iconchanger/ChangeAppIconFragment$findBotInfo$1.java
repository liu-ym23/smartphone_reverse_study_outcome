package com.larus.setting.impl.iconchanger;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.setting.impl.iconchanger.ChangeAppIconFragment", f = "ChangeAppIconFragment.kt", i = {0, 0}, l = {813, 812}, m = "findBotInfo", n = {"scene", "forceNew"}, s = {"L$0", "Z$0"})
final class ChangeAppIconFragment$findBotInfo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChangeAppIconFragment this$0;

    public ChangeAppIconFragment$findBotInfo$1(ChangeAppIconFragment r1, Continuation<? super ChangeAppIconFragment$findBotInfo$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        ChangeAppIconFragment r4 = this.this$0;
        int r0 = ChangeAppIconFragment.B;
        return r4.W90(null, false, null, this);
    }
}
