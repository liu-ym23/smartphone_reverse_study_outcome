package com.obric.assistant.interaction.impl;

import android.os.Bundle;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ AssistantChatWindowImpl b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ Map d;
    public final /* synthetic */ String e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ Boolean g;
    public final /* synthetic */ Bundle h;
    public final /* synthetic */ boolean i;
    public final /* synthetic */ Integer j;
    public final /* synthetic */ boolean k;

    public /* synthetic */ d(String r1, AssistantChatWindowImpl r2, boolean r3, Map r4, String r5, boolean r6, Boolean r7, Bundle r8, boolean r9, Integer r10, boolean r11) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AssistantChatWindowImpl.a(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k);
    }
}
