package com.larus.bmhome.chat.component.fastsend;

import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.platform.api.b0;
import com.larus.utils.logger.FLogger;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c0 implements b0 {
    public final /* synthetic */ FastSendImageComponent a;

    public final void b() {
    }

    public final boolean d() {
        return true;
    }

    public final void f() {
    }

    public final void onPageShow() {
    }

    public final void c() {
        FastSendImageComponent r0 = this.a;
        KProperty[] r1 = FastSendImageComponent.M;
        va8.o r2 = (va8.o) r0.l.getValue();
        if (r2 == null) goto L5;
        r2.ra();
    L5:
        ICoreInputAbility r3 = this.a.P2();
        if (r3 == null) goto L9;
        r3.C1(false, false, "");
        return;
    }

    public c0(FastSendImageComponent r1) {
        this.a = r1;
    }

    public final void a(int r4) {
        FLogger.a.i("FastSendImageComponent", "[showAlbumFragment]: onPageStateChange, state=" + r4);
        if (r4 != 3) goto L5;
        FastSendImageComponent r5 = this.a;
        KProperty[] r0 = FastSendImageComponent.M;
        r5.X2(true);
        return;
    L5:
        if (r4 != 4) goto L11;
        FastSendImageComponent r6 = this.a;
        KProperty[] r1 = FastSendImageComponent.M;
        r6.X2(false);
        return;
    }

    public final void e(int r3) {
        if (r3 <= 0) goto L20;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r4 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.a.o.getValue();
        boolean r0 = false;
        if (r4 != null) goto L6;
    L8:
        boolean r5 = false;
    L9:
        if (r5 == false) goto L21;
        f0 r6 = (f0) this.a.y.getValue();
        if (r6 != null) goto L13;
    L15:
        if (r0 == true) goto L22;
        FLogger.a.i("FastSendImageComponent", "[showAlbumFragment]: onPageSlide, performCancel speaker");
        com.larus.bmhome.chat.component.bottom.core.speaker.l r7 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.a.o.getValue();
        if (r7 == null) goto L23;
        r7.A9();
        return;
    L23:
        return;
    L22:
        return;
    L13:
        if (r6.ox() != true) goto L15;
        r0 = true;
        goto L15
    L21:
        return;
    L6:
        if (r4.m0() != true) goto L8;
        r5 = true;
        goto L9
    }
}
