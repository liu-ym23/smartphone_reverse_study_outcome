package com.obric.assistant.window;

import com.obric.assistant.n4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class w0 implements n4 {
    public final /* synthetic */ ObricPageStateComponent a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Float c;

    public final void onAuthenticationCancelled() {
        ObricPageStateComponent r0 = this.a;
        boolean r1 = this.b;
        Float r2 = this.c;
        int r3 = ObricPageStateComponent.Z;
        r0.c4(r1, r2, false);
    }

    public final void onAuthenticationFailed() {
        ObricPageStateComponent r0 = this.a;
        boolean r1 = this.b;
        Float r2 = this.c;
        int r3 = ObricPageStateComponent.Z;
        r0.c4(r1, r2, true);
    }

    public final void onAuthenticationNotAvailable() {
        ObricPageStateComponent r0 = this.a;
        boolean r1 = this.b;
        Float r2 = this.c;
        int r3 = ObricPageStateComponent.Z;
        r0.c4(r1, r2, true);
    }

    public final void onAuthenticationPass() {
        final ObricPageStateComponent r0 = this.a;
        final boolean r1 = this.b;
        final Float r2 = this.c;
        com.larus.utils.t0.e(new v0(r0, r1, r2));
    }

    public final void onAuthenticationTimeout() {
        ObricPageStateComponent r0 = this.a;
        boolean r1 = this.b;
        Float r2 = this.c;
        int r3 = ObricPageStateComponent.Z;
        r0.c4(r1, r2, false);
    }

    public w0(ObricPageStateComponent r1, boolean r2, Float r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
