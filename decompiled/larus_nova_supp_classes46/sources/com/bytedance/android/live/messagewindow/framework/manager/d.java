package com.bytedance.android.live.messagewindow.framework.manager;

import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ a.e a;

    public d(a.e r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Unit r4 = (Unit) r3;
        a r5 = this.a.c;
        String r0 = "getTargetViewLayoutEvent " + this.a.hashCode();
        int r1 = a.d;
        r5.getClass();
        a.a(r0);
    }
}
