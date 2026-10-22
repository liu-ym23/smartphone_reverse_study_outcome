package com.bytedance.ies.bullet.ui.common;

import android.content.Context;
import com.bytedance.ies.bullet.core.n;
import com.bytedance.ies.bullet.lynx.h;
import com.google.common.reflect.w;
import java.util.Iterator;
import java.util.Map;
import javax.xml.transform.Transformer;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements vc.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BulletCardView f6199a;

    public c(BulletCardView r5) {
        this.f6199a = r5;
    }

    @Override // vc.c
    public final void a(Map r5) {
        Iterator r10 = this.f6199a.f6186y.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        vc.c r11 = ((n) r10.next()).getLynxClient();
        if (r11 == null) goto L4;
        r11.a(r5);
        goto L4
    }

    @Override // vc.c
    public final void b(h r5) {
        Iterator r10 = this.f6199a.f6186y.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        vc.c r11 = ((n) r10.next()).getLynxClient();
        if (r11 == null) goto L4;
        r11.b(r5);
        goto L4
    }

    @Override // vc.c
    public final void c(w r5) {
        Iterator r10 = this.f6199a.f6186y.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        vc.c r11 = ((n) r10.next()).getLynxClient();
        if (r11 == null) goto L4;
        r11.c(r5);
        goto L4
    }

    @Override // vc.c
    public final void d(h r5) {
        Iterator r10 = this.f6199a.f6186y.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        vc.c r11 = ((n) r10.next()).getLynxClient();
        if (r11 == null) goto L4;
        r11.d(r5);
        goto L4
    }

    @Override // vc.c
    public final void e(h r5, com.bytedance.salamander.anniex.n r10) {
        Iterator r11 = this.f6199a.f6186y.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        vc.c r12 = ((n) r11.next()).getLynxClient();
        if (r12 == null) goto L4;
        r12.e(r5, r10);
        goto L4
    }

    @Override // vc.c
    public final void f(h r5) {
        Iterator r10 = this.f6199a.f6186y.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        vc.c r11 = ((n) r10.next()).getLynxClient();
        if (r11 == null) goto L4;
        r11.f(r5);
        goto L4
    }

    @Override // vc.c
    public final void g(h r5, String r10) {
        Iterator r11 = this.f6199a.f6186y.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        vc.c r12 = ((n) r11.next()).getLynxClient();
        if (r12 == null) goto L4;
        r12.g(r5, r10);
        goto L4
    }

    @Override // vc.c
    public final void h(h r5) {
        Iterator r10 = this.f6199a.f6186y.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        vc.c r11 = ((n) r10.next()).getLynxClient();
        if (r11 == null) goto L4;
        r11.h(r5);
        goto L4
    }

    @Override // vc.c
    public final void i(Map r5, Map r10, String r11) {
        Iterator r12 = this.f6199a.f6186y.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        vc.c r13 = ((n) r12.next()).getLynxClient();
        if (r13 == null) goto L4;
        r13.i(r5, r10, r11);
        goto L4
    }

    @Override // vc.c
    public final void j(h r5, String r10) {
        Iterator r11 = this.f6199a.f6186y.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        vc.c r12 = ((n) r11.next()).getLynxClient();
        if (r12 == null) goto L4;
        r12.j(r5, r10);
        goto L4
    }

    @Override // vc.c
    public final void k(w r5) {
        Iterator r10 = this.f6199a.f6186y.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        vc.c r11 = ((n) r10.next()).getLynxClient();
        if (r11 == null) goto L4;
        r11.k(r5);
        goto L4
    }

    @Override // vc.c
    public final void l(h r5) {
        Iterator r10 = this.f6199a.f6186y.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        vc.c r11 = ((n) r10.next()).getLynxClient();
        if (r11 == null) goto L4;
        r11.l(r5);
        goto L4
    }

    @Override // vc.c
    public final void m(h r5) {
        Iterator r10 = this.f6199a.f6186y.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        vc.c r11 = ((n) r10.next()).getLynxClient();
        if (r11 == null) goto L4;
        r11.m(r5);
        goto L4
    }

    @Override // vc.c
    public final void n(h r5) {
        Iterator r10 = this.f6199a.f6186y.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        vc.c r11 = ((n) r10.next()).getLynxClient();
        if (r11 == null) goto L4;
        r11.n(r5);
        goto L4
    }

    @Override // vc.c
    public final void o(h r5) {
        com.bytedance.android.anniex.container.g r10 = new com.bytedance.android.anniex.container.g();
        Intrinsics.checkNotNullParameter(r10, "event");
        BulletCardView r11 = this.f6199a;
        com.bytedance.ies.bullet.service.base.h r12 = r11.g;
        if (r12 == null) goto L5;
        r12.a("perf", (JSONObject) r10.f3144b);
    L5:
        Iterator r13 = r11.f6186y.iterator();
    L7:
        if (r13.hasNext() == false) goto L11;
        vc.c r14 = ((n) r13.next()).getLynxClient();
        if (r14 == null) goto L7;
        r14.o(r5);
        goto L7
    }

    @Override // vc.c
    public final void p(h r13, Context r14, String r15, String r16, float r17, float r18, Transformer r19, Function2 r20) {
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r20, "handler");
        Iterator r5 = this.f6199a.f6186y.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        vc.c r10 = ((n) r5.next()).getLynxClient();
        if (r10 == null) goto L4;
        r10.p(r13, r14, r15, r16, r17, r18, r19, r20);
        goto L4
    }

    @Override // vc.c
    public final String shouldRedirectImageUrl(String r5) {
        Iterator r10 = this.f6199a.f6186y.iterator();
    L3:
        String r11 = null;
        if (r10.hasNext() == false) goto L9;
        vc.c r12 = ((n) r10.next()).getLynxClient();
        if (r12 == null) goto L8;
        r11 = r12.shouldRedirectImageUrl(r5);
    L8:
        if (r11 == null) goto L3;
    L9:
        return r11;
    }
}
