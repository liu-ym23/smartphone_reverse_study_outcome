package com.ss.android.lark.message.lynxcard.message;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.larksuite.component.ui.layout.LKUIRoundLinearLayout;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.message.lynxcard.entity.LynxCardContentVO;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ LynxCardViewHolder b;
    public final /* synthetic */ String c;
    public final /* synthetic */ long d;
    public final /* synthetic */ List e;
    public final /* synthetic */ LynxCardMessageCell f;
    public final /* synthetic */ float[] g;
    public final /* synthetic */ boolean h;

    /* JADX WARN: Multi-variable type inference failed */
    public l(LynxCardRoundLinearLayout r1, LynxCardViewHolder r2, String r3, long r4, List r6, LynxCardMessageCell r7, float[] r8, boolean r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }

    public final void a() {
        v5b.c<LynxCardContentVO> r0 = this.b.k;
        LKUIRoundLinearLayout r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getId();
    L7:
        if (Intrinsics.areEqual(r2, this.c) == true) goto L9;
        return;
    L9:
        if (this.b.b != this.d) goto L58;
        Iterator r3 = this.e.iterator();
    L13:
        if (r3.hasNext() == false) goto L20;
        Object r4 = r3.next();
        Pair r5 = (Pair) r4;
        View r6 = (View) r5.component1();
        if (r6.getBackground() == ((Drawable) r5.component2())) goto L17;
        boolean r7 = true;
    L18:
        if (r7 == false) goto L13;
    L21:
        Pair r8 = (Pair) r4;
        if (r8 == null) goto L56;
        LKUIRoundLinearLayout r9 = (View) r8.getFirst();
        if (r9 == null) goto L57;
        LynxCardMessageCell r10 = this.f;
        float[] r11 = this.g;
        if (this.h == true) goto L33;
        r10.getClass();
        if ((r9 instanceof LKUIRoundLinearLayout) == false) goto L31;
        r9.setBorderWidth(0.0f);
    L45:
        LynxCardViewHolder r12 = this.b;
        if (this.h == false) goto L48;
        r1 = r9;
    L48:
        r12.a = r1;
        return;
    L31:
        if ((r9 instanceof LKUIRoundableLayout) == false) goto L45;
        ((LKUIRoundableLayout) r9).setBorderWidth(0.0f);
        goto L45
    L33:
        r10.getClass();
        if ((r9 instanceof com.larksuite.component.ui.layout.b) == false) goto L36;
        com.larksuite.component.ui.layout.b r13 = (com.larksuite.component.ui.layout.b) r9;
    L37:
        if (r13 == null) goto L39;
        r13.setRadius(r11[0], r11[1], r11[2], r11[3]);
    L39:
        int r14 = UDColorUtils.getColor(r9.getContext(), 2131102450);
        if ((r9 instanceof LKUIRoundLinearLayout) == false) goto L43;
        LKUIRoundLinearLayout r15 = r9;
        r15.setBorderMode(0);
        r15.setBorderColor(r14);
        r15.setBorderWidth(1.0f);
        goto L45
    L43:
        if ((r9 instanceof LKUIRoundableLayout) == false) goto L45;
        LKUIRoundableLayout r16 = (LKUIRoundableLayout) r9;
        r16.setBorderMode(0);
        r16.setBorderColor(r14);
        r16.setBorderWidth(1.0f);
        goto L45
    L36:
        r13 = null;
        goto L37
    L57:
        return;
    L56:
        return;
    L17:
        r7 = false;
        goto L18
    L20:
        r4 = null;
        goto L21
    L58:
        return;
    L5:
        r2 = null;
        goto L7
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
