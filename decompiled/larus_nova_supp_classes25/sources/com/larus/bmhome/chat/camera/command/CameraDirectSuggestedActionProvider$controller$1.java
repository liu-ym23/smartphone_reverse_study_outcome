package com.larus.bmhome.chat.camera.command;

import com.larus.im.bean.bot.BotModel;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class CameraDirectSuggestedActionProvider$controller$1 implements l {
    public final CoroutineScope a;
    public final /* synthetic */ i b;

    @Override // com.larus.bmhome.chat.camera.command.l
    public final boolean c1() {
        return false;
    }

    @Override // com.larus.bmhome.chat.camera.command.l
    public final BotModel a() {
        i r0 = this.b;
        BotModel r1 = r0.c.a();
        if (r1 == null) goto L5;
        return r1;
    L5:
        return r0.d;
    }

    @Override // com.larus.bmhome.chat.camera.command.l
    public final CoroutineScope getScope() {
        return this.a;
    }

    public CameraDirectSuggestedActionProvider$controller$1(i r1) {
        this.b = r1;
        this.a = r1.a;
    }

    @Override // com.larus.bmhome.chat.camera.command.l
    public final Object b(Continuation<? super BotModel> r5) {
        if ((r5 instanceof CameraDirectSuggestedActionProvider$controller$1$awaitBot$1) == false) goto L7;
        CameraDirectSuggestedActionProvider$controller$1$awaitBot$1 r0 = (CameraDirectSuggestedActionProvider$controller$1$awaitBot$1) r5;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r6);
    L17:
        BotModel r4 = (BotModel) r6;
        this.b.d = r4;
        return r6;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        Deferred<BotModel> r7 = this.b.b;
        r0.label = 1;
        r6 = r7.await(r0);
        if (r6 != r2) goto L17;
        return r2;
    L7:
        r0 = new CameraDirectSuggestedActionProvider$controller$1$awaitBot$1(this, r5);
        goto L8
    }
}
