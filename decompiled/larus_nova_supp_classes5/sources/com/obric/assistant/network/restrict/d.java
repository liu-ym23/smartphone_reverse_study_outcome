package com.obric.assistant.network.restrict;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class d implements uea.a {
    public final /* synthetic */ e a;

    public d(e r1) {
        this.a = r1;
    }

    @Override // uea.a
    public final void a(boolean r5) {
        FLogger.a.i(this.a.c, "onObricStatusChanged: " + r5);
        this.a.b.set(r5);
        hm9.j r6 = hm9.j.a;
        hm9.j.h.d(false);
    }
}
