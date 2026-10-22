package com.larus.e_commerce.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import com.larus.common.apphost.AppHost;
import com.larus.e_commerce.impl.applet.PageState;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class j implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ ECommerceServiceImpl b;
    public final /* synthetic */ jj.a c;
    public final /* synthetic */ Uri d;

    public /* synthetic */ j(Context r1, ECommerceServiceImpl r2, jj.a r3, Uri r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        Context r0 = this.a;
        ECommerceServiceImpl r1 = this.b;
        jj.a r2 = this.c;
        Uri r3 = this.d;
        int r4 = ECommerceServiceImpl.d;
        if ((r0 instanceof Application) == false) goto L5;
        r0 = AppHost.a.a().getCurrentActivity();
    L5:
        Class<? extends Activity> r5 = 0;
        if (r3 == null) goto L8;
        String r6 = r3.toString();
    L9:
        r1.getClass();
        Activity r7 = AppHost.a.a().getCurrentActivity();
        AtomicBoolean r8 = o89.q.a;
        if (o89.q.f(r7) == false) goto L12;
        r2.openSchema(r0, r6);
        return;
    L12:
        if (r7 != null) goto L14;
    L151:
        r2.openSchema(r0, r6);
        return;
    L14:
        if (o89.q.d() == true) goto L151;
        if (o89.b.d() == false) goto L151;
        if (o89.b.d() == false) goto L49;
        String r9 = r7.getClass().getName();
        if (r9.length() <= 0) goto L23;
        boolean r10 = true;
    L24:
        if (r10 == false) goto L49;
        List r11 = o89.b.a().d();
        if (r11 != null) goto L28;
        r11 = CollectionsKt.emptyList();
    L28:
        List r12 = r11;
        if ((r12 instanceof Collection) == true) goto L31;
    L33:
        Iterator r13 = r12.iterator();
    L35:
        if (r13.hasNext() == false) goto L46;
        String r14 = (String) r13.next();
        if (r14 != null) goto L39;
    L43:
        boolean r15 = false;
    L44:
        if (r15 == false) goto L35;
        boolean r16 = true;
    L47:
        if (r16 == false) goto L49;
        boolean r17 = true;
    L50:
        if (r17 == false) goto L151;
        if (o89.b.d() == false) goto L99;
        List r18 = o89.b.a().b();
        if (r18 == null) goto L70;
        List r20 = r18;
        if ((r20 instanceof Collection) == true) goto L59;
    L61:
        Iterator r21 = r20.iterator();
    L63:
        if (r21.hasNext() == false) goto L67;
        if (Intrinsics.areEqual((String) r21.next(), "*") == false) goto L63;
        boolean r22 = true;
    L68:
        if (r22 != true) goto L70;
        boolean r23 = true;
    L71:
        if (r23 == false) goto L73;
        boolean r24 = true;
    L100:
        if (r24 == false) goto L151;
        AtomicBoolean r25 = o89.q.a;
        if (o89.q.a.getAndSet(true) == true) goto L145;
        o89.q.d = System.currentTimeMillis();
        o89.q.b = PageState.GOING;
        if (o89.b.d() == true) goto L107;
        boolean r26 = false;
    L139:
        if (r26 == false) goto L141;
        r5 = r7.getClass();
    L144:
        o89.q.c = r5;
        o89.q.e = r6;
        o89.p.a(true);
        o89.q.h("init");
        AppHost.a.getApplication().registerActivityLifecycleCallbacks(o89.q.m);
        goto L145
    L141:
        Activity r27 = AppHost.a.a().a(r7, null);
        if (r27 == null) goto L144;
        r5 = r27.getClass();
        goto L144
    L107:
        String r28 = r7.getClass().getName();
        if (r28.length() != 0) goto L110;
        boolean r30 = true;
    L111:
        if (r30 == true) goto L137;
        List r31 = o89.b.a().c();
        if (r31 != null) goto L115;
        r31 = CollectionsKt.emptyList();
    L115:
        List r32 = r31;
        if ((r32 instanceof Collection) == true) goto L118;
    L120:
        Iterator r33 = r32.iterator();
    L122:
        if (r33.hasNext() == false) goto L133;
        String r110 = (String) r33.next();
        if (r110 != null) goto L126;
    L130:
        boolean r111 = false;
    L131:
        if (r111 == false) goto L122;
        boolean r34 = true;
    L134:
        if (r34 == true) goto L137;
        boolean r35 = false;
    L138:
        r26 = !r35;
        goto L139
    L126:
        if ((!StringsKt.isBlank(r110)) == false) goto L130;
        if (StringsKt.contains$default(r28, r110, false, 2, null) == false) goto L130;
        r111 = true;
    L133:
        r34 = false;
        goto L134
    L118:
        if (r32.isEmpty() == false) goto L120;
    L137:
        r35 = true;
        goto L138
    L110:
        r30 = false;
    L145:
        r2.openSchema(r0, r6);
        int r36 = o89.c.a;
        if (o89.q.f(r7) == false) goto L149;
        return;
    L149:
        if (o89.b.c() == false) goto L172;
        r7.overridePendingTransition(2130772626, 0);
        return;
    L172:
        return;
    L73:
        String r37 = o89.b.b(r6);
        if (r37 == null) goto L99;
        List r38 = o89.b.a().b();
        if (r38 == null) goto L97;
        List r40 = r38;
        if ((r40 instanceof Collection) == true) goto L80;
    L82:
        Iterator r41 = r40.iterator();
    L84:
        if (r41.hasNext() == false) goto L95;
        String r112 = (String) r41.next();
        if (r112 != null) goto L88;
    L92:
        boolean r113 = false;
    L93:
        if (r113 == false) goto L84;
        boolean r42 = true;
    L96:
        Boolean r43 = Boolean.valueOf(r42);
    L98:
        r24 = Intrinsics.areEqual(r43, Boolean.TRUE);
        goto L100
    L88:
        if ((!StringsKt.isBlank(r112)) == false) goto L92;
        if (StringsKt.contains$default(r37, r112, false, 2, null) == false) goto L92;
        r113 = true;
    L95:
        r42 = false;
        goto L96
    L80:
        if (r40.isEmpty() == false) goto L82;
    L97:
        r43 = null;
    L67:
        r22 = false;
        goto L68
    L59:
        if (r20.isEmpty() == false) goto L61;
    L70:
        r23 = false;
    L99:
        r24 = false;
        goto L100
    L39:
        if ((!StringsKt.isBlank(r14)) == false) goto L43;
        if (StringsKt.contains$default(r9, r14, false, 2, null) == false) goto L43;
        r15 = true;
    L46:
        r16 = false;
        goto L47
    L31:
        if (r12.isEmpty() == false) goto L33;
    L23:
        r10 = false;
    L49:
        r17 = false;
        goto L50
    L8:
        r6 = null;
        goto L9
    }
}
