package com.larus.profile.impl.creation;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.creation.CreationTemplateComponent", f = "CreationTemplateComponent.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {664, 665}, m = "buildCreationSendMessageConfig", n = {"sendParam", "userCreation", "hitPointData", "mainBotId", "actionBarCreationType", "targetCvsId", "sendParam", "userCreation", "hitPointData", "mainBotId", "actionBarCreationType", "targetCvsId"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
final class CreationTemplateComponent$buildCreationSendMessageConfig$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ u1 this$0;

    public CreationTemplateComponent$buildCreationSendMessageConfig$1(u1 r1, Continuation<? super CreationTemplateComponent$buildCreationSendMessageConfig$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        return u1.a(this.this$0, null, null, null, null, null, this);
    }
}
