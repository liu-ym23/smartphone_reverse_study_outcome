package com.obric.assistant.component;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e1 implements com.obric.assistant.n4 {
    public final /* synthetic */ ObricChatPageStateComponent a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Float c;

    public final void onAuthenticationCancelled() {
        ObricChatPageStateComponent r0 = this.a;
        boolean r1 = this.b;
        Float r2 = this.c;
        com.larus.bmhome.view.b r3 = ObricChatPageStateComponent.v2;
        r0.k4(r1, r2, false);
    }

    public final void onAuthenticationFailed() {
        ObricChatPageStateComponent r0 = this.a;
        boolean r1 = this.b;
        Float r2 = this.c;
        com.larus.bmhome.view.b r3 = ObricChatPageStateComponent.v2;
        r0.k4(r1, r2, true);
    }

    public final void onAuthenticationNotAvailable() {
        ObricChatPageStateComponent r0 = this.a;
        boolean r1 = this.b;
        Float r2 = this.c;
        com.larus.bmhome.view.b r3 = ObricChatPageStateComponent.v2;
        r0.k4(r1, r2, true);
    }

    public final void onAuthenticationPass() {
        final ObricChatPageStateComponent r0 = this.a;
        final boolean r1 = this.b;
        final Float r2 = this.c;
        Function0<Unit> r3 = new d1(r0, r1, r2);
        com.larus.bmhome.view.b r4 = ObricChatPageStateComponent.v2;
        r0.W4(r3);
    }

    public final void onAuthenticationTimeout() {
        ObricChatPageStateComponent r0 = this.a;
        boolean r1 = this.b;
        Float r2 = this.c;
        com.larus.bmhome.view.b r3 = ObricChatPageStateComponent.v2;
        r0.k4(r1, r2, false);
    }

    public e1(ObricChatPageStateComponent r1, boolean r2, Float r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
