package com.obric.assistant.interaction.impl.window;

import android.view.View;
import android.view.Window;
import android.view.WindowInsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class o1 implements View.OnApplyWindowInsetsListener {
    public final /* synthetic */ Window a;
    public final /* synthetic */ AssistantChatDialog b;
    public final /* synthetic */ View c;

    public /* synthetic */ o1(Window r1, AssistantChatDialog r2, View r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View r4, WindowInsets r5) {
        return WindowHost.F(this.a, this.b, this.c, r4, r5);
    }
}
