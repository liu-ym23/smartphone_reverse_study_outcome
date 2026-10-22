package com.larus.uaigc.creation.gallery.providers;

import com.larus.im.bean.message.Message;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.creation.gallery.providers.CreationBottomView$publishCreation$1", f = "CreationBottomView.kt", i = {}, l = {346, 350, 352}, m = "invokeSuspend", n = {}, s = {})
final class CreationBottomView$publishCreation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationBottomView this$0;

    public CreationBottomView$publishCreation$1(CreationBottomView r1, Continuation<? super CreationBottomView$publishCreation$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationBottomView$publishCreation$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r4 = null;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 == 3) goto L10;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r8);
    L45:
        return Unit.INSTANCE;
    L11:
        ResultKt.throwOnFailure(r8);
    L25:
        UserCreationFromIM r9 = (UserCreationFromIM) r8;
        if (r9 == null) goto L28;
        r4 = r9.getCreationId();
    L28:
        if (r4 != null) goto L31;
        r4 = "";
    L31:
        if (o0.d(r4) == false) goto L41;
        sz9.a r10 = this.this$0.d;
        if (r10 == null) goto L35;
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r10.p = r4;
    L35:
        CreationBottomView r11 = this.this$0;
        sz9.a r2 = r11.d;
        if (r2 == null) goto L38;
        r2.m = 2;
    L38:
        this.label = 2;
        if (CreationBottomView.V5(r11, false, this) != r0) goto L45;
        return r0;
    L41:
        CreationBottomView r12 = this.this$0;
        this.label = 3;
        if (CreationBottomView.R5(r12, this) != r0) goto L45;
        return r0;
    L12:
        ResultKt.throwOnFailure(r8);
        CreationGalleryUtil r13 = CreationGalleryUtil.a;
        sz9.a r3 = this.this$0.d;
        if (r3 == null) goto L17;
        Message r5 = r3.v;
        if (r5 == null) goto L17;
        String r6 = r5.getMessageId();
    L18:
        sz9.a r7 = this.this$0.d;
        if (r7 == null) goto L21;
        String r14 = r7.e;
    L22:
        this.label = 1;
        r8 = r13.e(r6, r14, this);
        if (r8 != r0) goto L25;
        return r0;
    L21:
        r14 = null;
    L17:
        r6 = null;
        goto L18
    }
}
