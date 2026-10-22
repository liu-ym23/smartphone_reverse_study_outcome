package com.obric.miniapp.view;

import com.bytedance.ai.view.input.FloatingSpeakerView;
import com.bytedance.applet.utils.MessageUtils;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.utils.logger.FLogger;
import com.obric.miniapp.databinding.MiniAppFragmentBinding;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.view.MiniAppFragment$initFloatingSpeaker$3", f = "MiniAppFragment.kt", i = {}, l = {828, 833}, m = "invokeSuspend", n = {}, s = {})
final class MiniAppFragment$initFloatingSpeaker$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ MiniAppFragment this$0;

    public MiniAppFragment$initFloatingSpeaker$3(MiniAppFragment r1, Continuation<? super MiniAppFragment$initFloatingSpeaker$3> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MiniAppFragment$initFloatingSpeaker$3(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r6);
    L22:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        MiniAppFragment r2 = (MiniAppFragment) this.L$0;
        ResultKt.throwOnFailure(r6);
    L13:
        r2.i = (String) r6;
        FLogger.a.d("FloatingSpeaker", "initFloatingSpeaker updateBotId " + this.this$0.h + ' ' + this.this$0.i);
        MiniAppFragment r7 = this.this$0;
        MiniAppFragmentBinding r3 = r7.f;
        if (r3 == null) goto L18;
        FloatingSpeakerView r4 = r3.c;
        if (r4 == null) goto L18;
        String r5 = r7.h;
        String r8 = r7.i;
        Intrinsics.checkNotNullParameter(r5, "botId");
        r4.d = r5;
        r4.e = r8;
    L18:
        this.this$0.l = RepoDispatcherDelegate.b.e().x1().a();
        MiniAppFragment r9 = this.this$0;
        this.L$0 = null;
        this.label = 2;
        if (r9.da0(this) != r0) goto L22;
        return r0;
    L10:
        ResultKt.throwOnFailure(r6);
        r2 = this.this$0;
        MessageUtils r10 = MessageUtils.a;
        String r11 = r2.h;
        this.L$0 = r2;
        this.label = 1;
        r6 = r10.d(r11, this);
        if (r6 != r0) goto L13;
        return r0;
    }
}
