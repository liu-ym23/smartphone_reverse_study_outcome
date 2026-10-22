package com.obric.miniapp.view;

import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.resource.AIManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.view.MiniAppAboutFragment$initView$1", f = "MiniAppAboutFragment.kt", i = {}, l = {63, 65}, m = "invokeSuspend", n = {}, s = {})
final class MiniAppAboutFragment$initView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appletId;
    int label;
    final /* synthetic */ MiniAppAboutFragment this$0;

    public MiniAppAboutFragment$initView$1(String r1, MiniAppAboutFragment r2, Continuation<? super MiniAppAboutFragment$initView$1> r3) {
        this.$appletId = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MiniAppAboutFragment$initView$1(this.$appletId, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r7);
    L19:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L13:
        Applet r8 = (Applet) r7;
        if (r8 == null) goto L19;
        MiniAppAboutFragment r2 = this.this$0;
        MainCoroutineDispatcher r4 = Dispatchers.getMain();
        MiniAppAboutFragment$initView$1$1$1 r5 = new MiniAppAboutFragment$initView$1$1$1(r2, r8, null);
        this.label = 2;
        if (BuildersKt.withContext(r4, r5, this) != r0) goto L19;
        return r0;
    L10:
        ResultKt.throwOnFailure(r7);
        AIManager r9 = AIManager.a;
        String r3 = this.$appletId;
        this.label = 1;
        r7 = r9.C(r3, null, this);
        if (r7 != r0) goto L13;
        return r0;
    }
}
