package com.obric.assistant.settings.provider;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.provider.VoicePrintManagementSettingProvider", f = "VoicePrintManagementSettingProvider.kt", i = {0, 1, 1, 1, 1}, l = {43, 59}, m = "getSettingItems", n = {"context", "context", "headset", "isVoicePrintExisted", "isAccessoryVoicePrintEntryEnabled"}, s = {"L$0", "L$0", "L$1", "Z$0", "I$0"})
public final class VoicePrintManagementSettingProvider$getSettingItems$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VoicePrintManagementSettingProvider this$0;

    public VoicePrintManagementSettingProvider$getSettingItems$1(VoicePrintManagementSettingProvider r1, Continuation<? super VoicePrintManagementSettingProvider$getSettingItems$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, this);
    }
}
