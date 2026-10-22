package com.ss.android.lark.chat.api.service.impl;

import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chat.entity.chatter.UserPrivateDescription;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.api.service.impl.PrivateDescriptionService", f = "PrivateDescriptionService.kt", i = {0}, l = {59}, m = "pullPrivateDescription-BWLJW6A", n = {"userId"}, s = {"L$0"})
final class PrivateDescriptionService$pullPrivateDescription$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PrivateDescriptionService this$0;

    public PrivateDescriptionService$pullPrivateDescription$1(PrivateDescriptionService r1, Continuation<? super PrivateDescriptionService$pullPrivateDescription$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r6) {
        this.result = r6;
        this.label |= PluginList.LEVEL_NOT_SET;
        PrivateDescriptionService r7 = this.this$0;
        r7.getClass();
        int r1 = this.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L5;
        this.label = r1 - PluginList.LEVEL_NOT_SET;
        PrivateDescriptionService$pullPrivateDescription$1 r0 = this;
    L6:
        Object r2 = r0.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r0.label;
        if (r4 == 0) goto L12;
        if (r4 != 1) goto L11;
        String r8 = (String) r0.L$0;
        ResultKt.throwOnFailure(r2);
        Object r5 = ((Result) r2).unbox-impl();
    L17:
        if (Result.isSuccess-impl(r5) == false) goto L19;
        Object r9 = Result.constructor-impl((UserPrivateDescription) ((Map) r5).get(r8));
    L20:
        r3 = r9;
    L22:
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
        return r3;
    L25:
        return Result.box-impl(r3);
    L19:
        r9 = Result.constructor-impl(r5);
        goto L20
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r2);
        List<String> r10 = CollectionsKt.listOf(null);
        r0.L$0 = null;
        r0.label = 1;
        r5 = r7.S0(r10, null, null, r0);
        if (r5 == r3) goto L22;
        r8 = null;
        goto L17
    L5:
        r0 = new PrivateDescriptionService$pullPrivateDescription$1(r7, this);
        goto L6
    }
}
