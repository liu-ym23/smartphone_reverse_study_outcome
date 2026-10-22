package com.ss.android.lark.message.lynxcard.entity;

import com.ss.android.lark.chat.base.view.vo.message.b;
import com.ss.android.lark.chat.base.view.vo.message.f;
import com.ss.android.lark.chat.entity.message.content.CardContent;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.widget.EllipsizeFrameLayout;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import v5b.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class LynxCardContentVO extends f<CardContent> implements b {
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public boolean l;
    public EllipsizeFrameLayout.a m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public transient CharSequence w;

    public final boolean a() {
        return ((a) this).a.resourceIsCleaned();
    }

    public final ResourceCleanScene b() {
        return ((a) this).a.firstResourceScene();
    }

    public final int f() {
        return ((Number) this.p.getValue()).intValue();
    }

    public final String g() {
        return (String) this.n.getValue();
    }

    public final String h() {
        return (String) this.r.getValue();
    }

    public final String i() {
        return (String) this.t.getValue();
    }

    public final boolean j() {
        return ((Boolean) this.q.getValue()).booleanValue();
    }

    public LynxCardContentVO(final CardContent r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        super(r2);
        this.h = LazyKt.lazy(new LynxCardContentVO$cardType$2(r2));
        this.i = LazyKt.lazy(new LynxCardContentVO$extraType$2(r2));
        this.j = LazyKt.lazy(new LynxCardContentVO$extraInfo$2(r2));
        this.k = LazyKt.lazy(new LynxCardContentVO$enableForward$2(r2));
        this.m = new EllipsizeFrameLayout.a();
        this.n = LazyKt.lazy(new LynxCardContentVO$dslJsonString$2(r2));
        this.o = LazyKt.lazy(new LynxCardContentVO$jsonAttachment$2(r2));
        this.p = LazyKt.lazy(new LynxCardContentVO$contentVersion$2(r2));
        this.q = LazyKt.lazy(new LynxCardContentVO$isForward$2(r2));
        this.r = LazyKt.lazy(new LynxCardContentVO$messageId$2(r2));
        this.s = LazyKt.lazy(new LynxCardContentVO$cardHeader$2(r2));
        this.t = LazyKt.lazy(new LynxCardContentVO$universalCardId$2(r2));
        this.u = LazyKt.lazy(new LynxCardContentVO$universalCardVersion$2(r2));
        this.v = LazyKt.lazy(new LynxCardContentVO$dataSource$2(r2));
    }

    public final boolean d(a<?> r6) {
        if ((r6 instanceof LynxCardContentVO) == false) goto L46;
        LynxCardContentVO r0 = (LynxCardContentVO) r6;
        String r2 = h();
        if (r2 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == true) goto L43;
        String r4 = r0.h();
        if (r4 != null) goto L15;
    L18:
        boolean r5 = true;
    L19:
        if (r5 == true) goto L43;
        if (super.d(r0) == false) goto L43;
        if (Intrinsics.areEqual(h(), r0.h()) == false) goto L43;
        if (((CardContent.Type) this.h.getValue()) != ((CardContent.Type) r0.h.getValue())) goto L43;
        if (Intrinsics.areEqual(g(), g()) == false) goto L43;
        if (f() != r0.f()) goto L43;
        if (Intrinsics.areEqual(i(), r0.i()) == false) goto L43;
        if (Intrinsics.areEqual((String) this.u.getValue(), (String) r0.u.getValue()) == false) goto L43;
        if (j() != r0.j()) goto L43;
        if (this.l != r0.l) goto L43;
        if (Intrinsics.areEqual(this.m, r0.m) == false) goto L43;
        boolean r1 = true;
    L44:
        if (r1 == false) goto L46;
        return true;
    L15:
        if (r4.length() == 0) goto L18;
        r5 = false;
    L43:
        r1 = false;
        goto L44
    L7:
        if (r2.length() == 0) goto L10;
        r3 = false;
    L46:
        super.d(r6);
        return false;
    }
}
