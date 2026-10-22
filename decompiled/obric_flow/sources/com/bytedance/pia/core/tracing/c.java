package com.bytedance.pia.core.tracing;

import android.os.Bundle;
import com.google.common.reflect.w;
import com.zte.miboard.recommend.RecommendProvider;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import m.l;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f7120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f7121c;
    public final /* synthetic */ Object d;

    public /* synthetic */ c(w r5, d r10, boolean r11) {
        this.f7119a = 0;
        this.f7121c = r5;
        this.d = r10;
        this.f7120b = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f7119a) {
            case 0: goto L8;
            default: goto L4;
        };
    L4:
        l r5 = (l) this.f7121c;
        if (r5 == null) goto L34;
        RecommendProvider.b(r5.f19883b, this.f7120b, (Bundle) this.d);
        return;
    L34:
        return;
    L8:
        w r10 = (w) this.f7121c;
        r10.getClass();
        d r11 = (d) this.d;
        if (r11.e == true) goto L25;
        r11.e = true;
        ArrayList r12 = (ArrayList) r10.f9377c;
        if (this.f7120b == true) goto L19;
        Iterator r13 = r12.iterator();
    L15:
        if (r13.hasNext() == false) goto L19;
        if (((d) r13.next()).f7123b != r11.f7123b) goto L15;
        return;
    L19:
        r12.add(r11);
        Iterator r14 = ((HashSet) r10.f9376b).iterator();
    L21:
        if (r14.hasNext() == false) goto L36;
        yg.d r15 = (yg.d) ((e) r14.next());
        r15.accept(r11);
        if (r15.f23266b.isEmpty() == false) goto L21;
        r14.remove();
        goto L21
    L36:
        return;
    }

    public /* synthetic */ c(l r5, boolean r10, Bundle r11) {
        this.f7119a = 1;
        this.f7121c = r5;
        this.f7120b = r10;
        this.d = r11;
    }
}
