package com.larus.chat.gallery.impl.preview.toolbar.action;

import android.content.Context;
import com.larus.platform.api.creation.UserCreation;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import zp9.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.toolbar.action.PublishAction$addCreation$2", f = "PublishAction.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PublishAction$addCreation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ l0 $context;
    final /* synthetic */ a $result;
    int label;
    final /* synthetic */ PublishAction this$0;

    public PublishAction$addCreation$2(a r1, l0 r2, PublishAction r3, Continuation<? super PublishAction$addCreation$2> r4) {
        this.$result = r1;
        this.$context = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new PublishAction$addCreation$2(this.$result, this.$context, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L38;
        ResultKt.throwOnFailure(r7);
        a r8 = this.$result;
        boolean r0 = false;
        if (r8 != null) goto L7;
    L9:
        boolean r9 = false;
    L10:
        String r3 = null;
        if (r9 == false) goto L20;
        FLogger r10 = FLogger.a;
        StringBuilder r1 = new StringBuilder("addCreation success: creationId=");
        UserCreation r2 = this.$result.b;
        if (r2 == null) goto L15;
        String r4 = r2.a;
    L16:
        r1.append(r4);
        r10.i("PublishAction", r1.toString());
        t19.s r11 = t19.s.a;
        Context r5 = this.$context.getContext();
        r11.getClass();
        t19.s.p(r5, "已添加到作品");
        PublishAction r12 = this.this$0;
        l0 r6 = this.$context;
        UserCreation r13 = this.$result.b;
        if (r13 == null) goto L19;
        r3 = r13.a;
    L19:
        PublishAction.b(r12, r6, r3);
    L36:
        return Unit.INSTANCE;
    L15:
        r4 = null;
        goto L16
    L20:
        FLogger r14 = FLogger.a;
        StringBuilder r15 = new StringBuilder("addCreation failed: ");
        a r16 = this.$result;
        if (r16 == null) goto L23;
        String r17 = r16.d;
    L24:
        r15.append(r17);
        r14.w("PublishAction", r15.toString());
        a r18 = this.$result;
        if (r18 == null) goto L33;
        String r19 = r18.d;
        if (r19 == null) goto L33;
        if (r19.length() <= 0) goto L31;
        r0 = true;
    L31:
        if (r0 == false) goto L33;
        r3 = r19;
    L33:
        if (r3 == null) goto L36;
        t19.s r20 = t19.s.a;
        Context r21 = this.$context.getContext();
        r20.getClass();
        t19.s.t(r21, r3);
        goto L36
    L23:
        r17 = null;
        goto L24
    L7:
        if (r8.a != true) goto L9;
        r9 = true;
        goto L10
    L38:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
