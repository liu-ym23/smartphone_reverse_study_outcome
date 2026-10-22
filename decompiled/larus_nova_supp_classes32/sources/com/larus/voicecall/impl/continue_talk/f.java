package com.larus.voicecall.impl.continue_talk;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class f implements Function0 {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ FrameLayout b;

    public /* synthetic */ f(ViewGroup r1, FrameLayout r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        final ViewGroup r0 = this.a;
        final FrameLayout r1 = this.b;
        int r2 = ChatContinuousTalkComponent.M;
        r0.post(new v(r0, r1));
        return Unit.INSTANCE;
    }
}
