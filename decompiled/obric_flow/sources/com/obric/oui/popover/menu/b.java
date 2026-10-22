package com.obric.oui.popover.menu;

import android.content.Context;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f14148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1 f14149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f14150c;
    public final int d;
    public boolean e;

    public b(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.f14148a = r5;
        this.f14149b = OPopoverEntranceMenuView$Builder$itemLayoutProcess$1.INSTANCE;
        this.f14150c = new ArrayList();
        int r10 = OPopoverEntranceMenuView.f14129n;
        this.d = com.lynx.tasm.utils.a.p(184, r5);
    }

    public static void a(b r5, Integer r10, String r11, boolean r12, Function2 r13, int r14) {
        Integer r15 = 0;
        if ((r14 & 64) == 0) goto L5;
        r12 = false;
    L5:
        ArrayList r16 = r5.f14150c;
        int r17 = r15.intValue();
        int r18 = r10.intValue();
        int r19 = r15.intValue();
        c r20 = new c();
        r20.f14151a = 0;
        r20.f14152b = false;
        r20.f14153c = r17;
        r20.d = r18;
        r20.e = r19;
        r20.f = r11;
        r20.g = null;
        r20.f14154h = null;
        r20.f14155i = r12;
        r20.f14156j = r13;
        r20.f14157k = null;
        r16.add(r20);
    }

    public final OPopoverEntranceMenuView b() {
        OPopoverEntranceMenuView r5 = new OPopoverEntranceMenuView(this.f14148a, null, 6, 0);
        r5.f = this.f14150c;
        r5.setPressedWithArrow(false);
        r5.setForceDark(false);
        r5.e = (Lambda) this.f14149b;
        r5.f14134l = this.e;
        r5.g = this.d;
        r5.c();
        return r5;
    }
}
