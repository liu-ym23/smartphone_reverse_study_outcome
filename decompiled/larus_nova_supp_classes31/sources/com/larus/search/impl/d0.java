package com.larus.search.impl;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d0 implements com.larus.common_ui.dialog.u {
    public final /* synthetic */ a0 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Function0<Unit> c;

    public final void cancel() {
        this.a.b.put(this.b, Boolean.FALSE);
        this.c.invoke();
    }

    public d0(a0 r1, String r2, y r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
