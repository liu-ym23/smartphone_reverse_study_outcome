package com.obric.assistant.interaction.impl.window;

import android.view.View;
import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class n0 implements Runnable {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ String b;
    public final /* synthetic */ WindowAnimationType c;
    public final /* synthetic */ View d;
    public final /* synthetic */ AssistantChatDialog e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ Ref.ObjectRef g;

    public /* synthetic */ n0(Ref.BooleanRef r1, String r2, WindowAnimationType r3, View r4, AssistantChatDialog r5, boolean r6, Ref.ObjectRef r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WindowHost.a(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
    }
}
