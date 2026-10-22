package com.larus.bmhome.clarification;

import android.view.View;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class b1 implements Runnable {
    public final /* synthetic */ ClarificationComponent a;
    public final /* synthetic */ int b;

    public /* synthetic */ b1(ClarificationComponent r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ClarificationComponent r0 = this.a;
        int r1 = this.b;
        d2 r2 = r0.n.a;
        if (r2 != null) goto L6;
        return;
    L6:
        if (r2.j != r1) goto L40;
        ze8.b r3 = r2.k;
        if (r3 != null) goto L11;
    L13:
        boolean r4 = false;
    L14:
        if (r4 == false) goto L18;
        View r5 = r0.A;
        if (r5 == null) goto L34;
        r5.postOnAnimation(new b1(r0, r1));
        return;
    L34:
        return;
    L18:
        z1 r6 = (z1) CollectionsKt.getOrNull(r2.l, r1);
        Boolean r7 = null;
        if (r6 == null) goto L22;
        r7 = Boolean.valueOf(y1.a(r6, null).d);
    L22:
        if (Intrinsics.areEqual(r7, Boolean.FALSE) == false) goto L36;
        ICoreInputAbility r8 = r0.H3();
        if (r8 != null) goto L26;
    L28:
        boolean r9 = false;
    L29:
        if (r9 == false) goto L37;
        ICoreInputAbility r10 = r0.H3();
        if (r10 == null) goto L38;
        r10.C1(false, true, "clarification_switch");
        return;
    L38:
        return;
    L37:
        return;
    L26:
        if (r8.E50() != true) goto L28;
        r9 = true;
        goto L29
    L36:
        return;
    L11:
        if (r3.f() != true) goto L13;
        r4 = true;
        goto L14
    }
}
