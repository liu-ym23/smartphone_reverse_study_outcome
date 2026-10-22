package com.larus.community.impl.publish;

import com.larus.bmhome.view.NovaTitleBarEx;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "enable", "", "isPublishing"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.publish.CreationPublishTitleComponent$initView$5", f = "CreationPublishTitleComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CreationPublishTitleComponent$initView$5 extends SuspendLambda implements Function3<Boolean, Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ CreationPublishTitleComponent this$0;

    public CreationPublishTitleComponent$initView$5(CreationPublishTitleComponent r1, Continuation<? super CreationPublishTitleComponent$initView$5> r2) {
        this.this$0 = r1;
        super(3, r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke(((Boolean) r1).booleanValue(), ((Boolean) r2).booleanValue(), (Continuation) r3);
    }

    public final Object invoke(boolean r2, boolean r3, Continuation<? super Unit> r4) {
        CreationPublishTitleComponent$initView$5 r5 = new CreationPublishTitleComponent$initView$5(this.this$0, r4);
        r5.Z$0 = r2;
        return r5.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r4);
        if (this.Z$0 == false) goto L12;
        CreationPublishTitleComponent r5 = this.this$0;
        NovaTitleBarEx r0 = r5.o;
        if (r0 == null) goto L9;
        String r6 = r5.getContext().getString(2131901168);
        final CreationPublishTitleComponent r1 = this.this$0;
        NovaTitleBarEx.o6(r0, r6, new x(r1));
    L9:
        NovaTitleBarEx r7 = this.this$0.o;
        if (r7 == null) goto L16;
        r7.setRightTextEnable(true);
    L16:
        return Unit.INSTANCE;
    L12:
        NovaTitleBarEx r8 = this.this$0.o;
        if (r8 == null) goto L16;
        NovaTitleBarEx.o6(r8, "", new dg5.d());
        goto L16
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
