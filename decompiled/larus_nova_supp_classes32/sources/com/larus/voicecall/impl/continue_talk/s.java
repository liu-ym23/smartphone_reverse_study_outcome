package com.larus.voicecall.impl.continue_talk;

import androidx.lifecycle.LifecycleOwnerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class s implements Function0 {
    public final /* synthetic */ ChatContinuousTalkComponent a;
    public final /* synthetic */ xa8.e b;

    public /* synthetic */ s(ChatContinuousTalkComponent r1, xa8.e r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        ChatContinuousTalkComponent r0 = this.a;
        xa8.e r1 = this.b;
        int r2 = ChatContinuousTalkComponent.M;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r0), null, null, new ChatContinuousTalkComponent$prepareAndOpenContinuousTalk$2$1(r0, r1, null), 3, null);
        return Unit.INSTANCE;
    }
}
