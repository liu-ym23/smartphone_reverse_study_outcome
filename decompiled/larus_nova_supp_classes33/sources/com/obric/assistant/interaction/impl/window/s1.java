package com.obric.assistant.interaction.impl.window;

import com.obric.assistant.interaction.api.window.animation.IWindowAnimator;
import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class s1 implements Function1 {
    public final /* synthetic */ IWindowAnimator a;
    public final /* synthetic */ Ref.BooleanRef b;
    public final /* synthetic */ AtomicInteger c;
    public final /* synthetic */ com.obric.assistant.common.utils.i.a d;
    public final /* synthetic */ Function1 e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ WindowAnimationType g;

    public /* synthetic */ s1(IWindowAnimator r1, Ref.BooleanRef r2, AtomicInteger r3, com.obric.assistant.common.utils.i.a r4, Function1 r5, boolean r6, WindowAnimationType r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    public final Object invoke(Object r9) {
        return WindowHost.e(this.a, this.b, this.c, this.d, this.e, this.f, this.g, ((Boolean) r9).booleanValue());
    }
}
