package com.bytedance.android.livesdk.dslservice.lynxair;

import com.bytedance.android.live.core.setting.n0;
import com.bytedance.android.livesdk.dslservice.util.p;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import yt1.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ LynxAirDSLProcess a;
    public final /* synthetic */ a b;
    public final /* synthetic */ p c;
    public final /* synthetic */ String d;
    public final /* synthetic */ m e;

    public d(LynxAirDSLProcess r1, a r2, p r3, String r4, m r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void accept(Object r5) {
        String r6 = (String) r5;
        a r7 = this.b;
        boolean r0 = true;
        r7.b = 1;
        String r8 = r7.f;
        if (r8 != null) goto L5;
        r8 = "UnKnown";
    L5:
        this.a.getClass();
        if (Intrinsics.areEqual(r8, "NodeCache") == true) goto L12;
        if (Intrinsics.areEqual(r8, "LocalRawData") == true) goto L12;
        r0 = false;
    L12:
        if (((Boolean) n0.a.getValue()).booleanValue() == true) goto L14;
        m r1 = this.e;
        if (r1 == null) goto L24;
        r1.a(this.b, r0, r8);
    L24:
        if (r0 == true) goto L32;
        p r2 = this.c;
        if (r2 == null) goto L28;
        r2.a(new c(this, r8));
    L28:
        this.b.b(au1.a.c.b, false);
        return;
    L32:
        return;
    L14:
        if (((Boolean) dt2.c.a.getValue()).booleanValue() == true) goto L18;
        p r3 = this.c;
        if (r3 == null) goto L18;
        r3.a(new b(this, r8));
    L18:
        this.b.b(au1.a.c.b, false);
        m r4 = this.e;
        if (r4 == null) goto L30;
        r4.a(this.b, r0, r8);
        return;
    }
}
