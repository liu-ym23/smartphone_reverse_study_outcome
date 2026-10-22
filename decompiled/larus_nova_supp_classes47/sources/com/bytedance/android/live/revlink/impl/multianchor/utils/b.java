package com.bytedance.android.live.revlink.impl.multianchor.utils;

import com.bytedance.android.live.base.model.user.IBaseUser;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public final CompositeDisposable a;
    public final i11.b b;
    public final com.bytedance.android.live.revenuelink.rtc.i c;
    public final ArrayList<com.bytedance.android.livesdk.link.model.p> d;
    public final c e;
    public final ArrayList<af2.b> f;
    public final AnchorLinkStateChecker$pkStateObserver$1 g;
    public final AnchorLinkStateChecker$scoreObserver$1 h;
    public final com.bytedance.android.live.revlink.impl.global.c i;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [com.bytedance.android.live.revlink.impl.multianchor.utils.AnchorLinkStateChecker$pkStateObserver$1] */
    /* JADX WARN: Type inference failed for: r3v7, types: [com.bytedance.android.live.revlink.impl.multianchor.utils.AnchorLinkStateChecker$scoreObserver$1] */
    public b(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a r3) {
        this.i = r3;
        this.a = new CompositeDisposable();
        com.bytedance.android.live.revenuelink.rtc.i r0 = null;
        if (r3 == null) goto L5;
        com.bytedance.android.live.revlink.impl.multianchor.service.d r1 = r3.R8();
    L6:
        if (r1 == null) goto L8;
        i11.b r2 = r1.getLinkUserCenter();
    L9:
        this.b = r2;
        if (r3 == null) goto L12;
        com.bytedance.android.live.revenuelink.rtc.f r4 = r3.m0();
    L13:
        if (r4 == null) goto L15;
        r0 = r4.getRtcManager();
    L15:
        this.c = r0;
        this.d = new ArrayList();
        this.e = new c(this);
        this.f = new ArrayList();
        this.g = new AnchorLinkStateChecker$pkStateObserver$1(this);
        this.h = new AnchorLinkStateChecker$scoreObserver$1(this);
        return;
    L12:
        r4 = null;
        goto L13
    L8:
        r2 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    public static final boolean a(b r0) {
        com.bytedance.android.live.revlink.impl.global.c r1 = r0.i;
        if (r1 == null) goto L5;
        w r2 = r1.getMultiLinkUtil();
    L6:
        if (r2 != null) goto L10;
        return false;
    L10:
        return r2.d();
    L5:
        r2 = null;
        goto L6
    }

    public static final boolean b(b r6, List r7) {
        r6.getClass();
        List r0 = r7;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L28;
        Iterator r8 = r7.iterator();
    L11:
        Object r3 = null;
        if (r8.hasNext() == false) goto L26;
        Object r2 = r8.next();
        IBaseUser r4 = ((com.bytedance.android.livesdk.link.model.p) r2).getUser();
        if (r4 == null) goto L16;
        String r5 = r4.getIdString();
    L17:
        com.bytedance.android.live.revlink.impl.global.c r9 = r6.i;
        if (r9 == null) goto L20;
        com.bytedance.android.live.revlink.impl.utils.s r10 = r9.getRevLinkCommonUtil();
    L21:
        if (r10 == null) goto L24;
        r3 = r10.e();
    L24:
        if (Intrinsics.areEqual(r5, r3) == false) goto L11;
        r3 = r2;
        goto L26
    L20:
        r10 = null;
        goto L21
    L16:
        r5 = null;
    L26:
        if (r3 != null) goto L28;
        return true;
    L28:
        return false;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }
}
