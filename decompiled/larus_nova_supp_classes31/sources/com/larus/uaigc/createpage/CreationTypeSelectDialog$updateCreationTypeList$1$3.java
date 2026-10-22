package com.larus.uaigc.createpage;

import com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarInfoManager;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.CreationTypeSelectDialog$updateCreationTypeList$1$3", f = "CreationTypeSelectDialog.kt", i = {}, l = {241}, m = "invokeSuspend", n = {}, s = {})
public final class CreationTypeSelectDialog$updateCreationTypeList$1$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationTypeSelectDialog this$0;

    public CreationTypeSelectDialog$updateCreationTypeList$1$3(CreationTypeSelectDialog r1, Continuation<? super CreationTypeSelectDialog$updateCreationTypeList$1$3> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationTypeSelectDialog$updateCreationTypeList$1$3(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        String r5 = (String) r4;
        if (r5 == null) goto L22;
        CreationTypeSelectDialog r3 = this.this$0;
        if (r5.length() > 0) goto L17;
        r2 = false;
    L17:
        if (r2 == false) goto L22;
        CreationTypeItemView r6 = r3.j;
        if (r6 == null) goto L22;
        r6.setAvatarUrl(r5);
    L22:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        DigitalAvatarInfoManager r7 = DigitalAvatarInfoManager.a;
        this.label = 1;
        r4 = DigitalAvatarInfoManager.d(r7, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
