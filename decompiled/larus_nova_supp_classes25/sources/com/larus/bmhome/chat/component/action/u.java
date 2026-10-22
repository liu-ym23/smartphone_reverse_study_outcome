package com.larus.bmhome.chat.component.action;

import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.im.bean.bot.BotModel;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class u implements com.larus.bmhome.chat.camera.command.l {
    public final /* synthetic */ SuggestedActionComponent a;

    @Override // com.larus.bmhome.chat.camera.command.l
    public final BotModel a() {
        return SuggestedActionComponent.m3(this.a);
    }

    @Override // com.larus.bmhome.chat.camera.command.l
    public final boolean c1() {
        ICoreInputAbility r0 = this.a.B3();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.c1() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.larus.bmhome.chat.camera.command.l
    public final CoroutineScope getScope() {
        return LifecycleOwnerKt.getLifecycleScope(this.a);
    }

    public u(SuggestedActionComponent r1) {
        this.a = r1;
    }

    @Override // com.larus.bmhome.chat.camera.command.l
    public final Object b(Continuation<? super BotModel> r5) {
        SuggestedActionComponent r0 = this.a;
        int r1 = SuggestedActionComponent.G;
        r0.getClass();
        kotlinx.coroutines.j r2 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r5), 1);
        r2.C();
        w r3 = new w(r0, r2);
        y r4 = r0.u0();
        if (r4 == null) goto L5;
        r4.ll(v.a, r3);
    L5:
        Object r6 = r2.B();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L8:
        return r6;
    }
}
