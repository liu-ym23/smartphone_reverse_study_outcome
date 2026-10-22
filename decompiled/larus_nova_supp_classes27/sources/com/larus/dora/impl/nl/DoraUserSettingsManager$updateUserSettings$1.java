package com.larus.dora.impl.nl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.nl.DoraUserSettingsManager", f = "DoraUserSettingsManager.kt", i = {0}, l = {375}, m = "updateUserSettings", n = {"updatedSettings"}, s = {"L$0"})
final class DoraUserSettingsManager$updateUserSettings$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraUserSettingsManager this$0;

    public DoraUserSettingsManager$updateUserSettings$1(DoraUserSettingsManager r1, Continuation<? super DoraUserSettingsManager$updateUserSettings$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return DoraUserSettingsManager.d(this.this$0, null, this);
    }
}
