package com.ss.android.lark.chat.chatwindow.biz.component.keyboard;

import android.animation.Animator;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.MessageListAnimationContainer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public final Function0<MessageListAnimationContainer> a;
    public final Function1<Integer, Unit> b;
    public boolean c;
    public boolean d;
    public float e;
    public Animator f;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(Function0<MessageListAnimationContainer> r2, Function1<? super Integer, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "animContainerProvider");
        Intrinsics.checkNotNullParameter(r3, "marginHandler");
        this.a = r2;
        this.b = r3;
    }
}
