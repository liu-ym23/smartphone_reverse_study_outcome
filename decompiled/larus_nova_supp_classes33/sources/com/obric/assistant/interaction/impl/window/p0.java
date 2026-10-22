package com.obric.assistant.interaction.impl.window;

import android.view.View;
import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class p0 implements Runnable {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ String b;
    public final /* synthetic */ WindowAnimationType c;
    public final /* synthetic */ View d;
    public final /* synthetic */ Ref.ObjectRef e;
    public final /* synthetic */ AssistantChatDialog f;
    public final /* synthetic */ boolean g;
    public final /* synthetic */ Ref.ObjectRef h;

    public /* synthetic */ p0(Ref.BooleanRef r1, String r2, WindowAnimationType r3, View r4, Ref.ObjectRef r5, AssistantChatDialog r6, boolean r7, Ref.ObjectRef r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WindowHost.q(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
    }
}
