package com.bytedance.android.annie.business.lynx;

import android.content.Context;
import android.view.View;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.business.container.AnnieXLiveHybridComponent;
import com.bytedance.android.annie.lynx.f;
import com.bytedance.ies.bullet.service.base.o;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxView;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.xml.transform.Transformer;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements u26.b {
    public final CopyOnWriteArrayList<f> a;

    public final void a(o r1, Context r10, String r11, String r12, float r13, float r14, Transformer r15, Function2<Object, ? super Throwable, Unit> r16) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r16, "handler");
    }

    public final void j(o r1) {
    }

    public final void k(d36.e r1) {
    }

    public final void m(d36.e r1) {
    }

    public final void onTimingSetup(Map<String, Object> r1) {
    }

    public final void onTimingUpdate(Map<String, Object> r1, Map<String, Long> r10, String r11) {
    }

    public final String shouldRedirectImageUrl(String r1) {
        return null;
    }

    public c(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "providerFactory");
        Object r11 = r10.c(IHybridComponent.class);
        if ((r11 instanceof AnnieXLiveHybridComponent) == false) goto L5;
        AnnieXLiveHybridComponent r12 = (AnnieXLiveHybridComponent) r11;
    L6:
        if (r12 == null) goto L9;
        CopyOnWriteArrayList<f> r13 = r12.q;
        if (r13 == null) goto L9;
    L10:
        this.a = r13;
        return;
    L9:
        r13 = new CopyOnWriteArrayList();
        goto L10
    L5:
        r12 = null;
        goto L6
    }

    public final void b(o r10) {
        LynxView r0 = null;
        if (r10 == null) goto L5;
        View r11 = r10.realView();
    L7:
        if ((r11 instanceof LynxView) == false) goto L9;
        r0 = (LynxView) r11;
    L9:
        if (r0 == null) goto L14;
        Iterator<T> r12 = this.a.iterator();
    L12:
        if (r12.hasNext() == false) goto L16;
        ((f) r12.next()).n(r0);
        goto L12
    L16:
        return;
    L14:
        return;
    L5:
        r11 = null;
        goto L7
    }

    public final void c(o r10) {
        LynxView r0 = null;
        if (r10 == null) goto L5;
        View r11 = r10.realView();
    L7:
        if ((r11 instanceof LynxView) == false) goto L9;
        r0 = (LynxView) r11;
    L9:
        if (r0 == null) goto L14;
        Iterator<T> r12 = this.a.iterator();
    L12:
        if (r12.hasNext() == false) goto L16;
        ((f) r12.next()).o(r0);
        goto L12
    L16:
        return;
    L14:
        return;
    L5:
        r11 = null;
        goto L7
    }

    public final void d(o r10) {
        LynxView r0 = null;
        if (r10 == null) goto L5;
        View r11 = r10.realView();
    L7:
        if ((r11 instanceof LynxView) == false) goto L9;
        r0 = (LynxView) r11;
    L9:
        if (r0 == null) goto L14;
        Iterator<T> r12 = this.a.iterator();
    L12:
        if (r12.hasNext() == false) goto L16;
        ((f) r12.next()).e(r0);
        goto L12
    L16:
        return;
    L14:
        return;
    L5:
        r11 = null;
        goto L7
    }

    public final void h(o r10) {
        Iterator<T> r11 = this.a.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((f) r11.next()).getClass();
        goto L4
    }

    public final void e(o r10, JSONObject r11) {
        if (r10 == null) goto L5;
        View r12 = r10.realView();
    L7:
        if ((r12 instanceof LynxView) == false) goto L9;
        LynxView r13 = (LynxView) r12;
    L10:
        if (r13 == null) goto L15;
        Iterator<T> r0 = this.a.iterator();
    L13:
        if (r0.hasNext() == false) goto L17;
        ((f) r0.next()).d(r13, null);
        goto L13
    L17:
        return;
    L15:
        return;
    L9:
        r13 = null;
        goto L10
    L5:
        r12 = null;
        goto L7
    }

    public final void f(o r10, String r11) {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        f r1 = (f) r0.next();
        if (r10 == null) goto L8;
        View r12 = r10.realView();
    L9:
        r1.k(r12, r11, null, false);
        goto L4
    L8:
        r12 = null;
        goto L9
    }

    public final void g(o r10, String r11) {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        f r1 = (f) r0.next();
        if (r10 == null) goto L8;
        View r12 = r10.realView();
    L9:
        r1.j(r12, null, r11);
        goto L4
    L8:
        r12 = null;
        goto L9
    }

    public final void i(o r10, JSONObject r11) {
        LynxView r12 = null;
        if (r10 == null) goto L5;
        View r13 = r10.realView();
    L7:
        if ((r13 instanceof LynxView) == false) goto L9;
        r12 = (LynxView) r13;
    L9:
        if (r12 == null) goto L14;
        Iterator<T> r14 = this.a.iterator();
    L12:
        if (r14.hasNext() == false) goto L16;
        ((f) r14.next()).getClass();
        Intrinsics.checkNotNullParameter(r12, "lynxView");
        goto L12
    L16:
        return;
    L14:
        return;
    L5:
        r13 = null;
        goto L7
    }

    public final void l(o r10, u26.e r11) {
        LynxView r0 = null;
        if (r10 == null) goto L5;
        View r12 = r10.realView();
    L7:
        if ((r12 instanceof LynxView) == false) goto L9;
        r0 = (LynxView) r12;
    L9:
        if (r0 == null) goto L16;
        Iterator<T> r13 = this.a.iterator();
    L12:
        if (r13.hasNext() == false) goto L22;
        f r1 = (f) r13.next();
        if (r11 == null) goto L12;
        r1.q(r0, new LynxError(r11.a, r11.b));
        goto L12
    L22:
        return;
    L16:
        return;
    L5:
        r12 = null;
        goto L7
    }

    public final void n(o r10, String r11) {
        LynxView r12 = null;
        if (r10 == null) goto L5;
        View r13 = r10.realView();
    L7:
        if ((r13 instanceof LynxView) == false) goto L9;
        r12 = (LynxView) r13;
    L9:
        if (r12 == null) goto L14;
        Iterator<T> r14 = this.a.iterator();
    L12:
        if (r14.hasNext() == false) goto L16;
        ((f) r14.next()).p(r12);
        goto L12
    L16:
        return;
    L14:
        return;
    L5:
        r13 = null;
        goto L7
    }
}
