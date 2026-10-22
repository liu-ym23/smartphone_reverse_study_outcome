package com.obric.assistant.interaction.impl.window;

import android.view.View;
import android.view.ViewTreeObserver;
import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class o0 implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ WindowAnimationType b;
    public final /* synthetic */ View c;
    public final /* synthetic */ Ref.ObjectRef d;
    public final /* synthetic */ Ref.ObjectRef e;
    public final /* synthetic */ Ref.BooleanRef f;
    public final /* synthetic */ AssistantChatDialog g;
    public final /* synthetic */ boolean h;

    public /* synthetic */ o0(String r1, WindowAnimationType r2, View r3, Ref.ObjectRef r4, Ref.ObjectRef r5, Ref.BooleanRef r6, AssistantChatDialog r7, boolean r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        return WindowHost.G(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
    }
}
