package com.ivy.ivykit.plugin.impl.jsb;

import com.bytedance.ai.lynx.j;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import com.ivy.ivykit.plugin.impl.render.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends tc.a implements pb.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f9519b;

    public /* synthetic */ c(int r5) {
        this.f9519b = r5;
    }

    @Override // pb.a
    public final List c(rb.b r5) {
        int r10 = 1;
        int r11 = this.f9519b;
        Intrinsics.checkNotNullParameter(r5, "providerFactory");
        switch(r11) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        j r12 = new j(r5);
        ib.c r13 = new ib.c(r5);
        Intrinsics.checkNotNullParameter(r5, "providerFactory");
        return CollectionsKt.listOf(new h[]{r12, r13, new j(r10)});
    L6:
        ArrayList r14 = new ArrayList();
        f r15 = (f) r5.a(f.class);
        if (r15 == null) goto L11;
        a r16 = r15.d;
        if (r16 == null) goto L11;
        r14.add(r16);
    L11:
        com.ivy.ivykit.plugin.impl.web.h r17 = (com.ivy.ivykit.plugin.impl.web.h) r5.a(com.ivy.ivykit.plugin.impl.web.h.class);
        if (r17 == null) goto L16;
        a r18 = r17.f9545h;
        if (r18 == null) goto L16;
        r14.add(r18);
    L16:
        return r14;
    }

    public ArrayList d(rb.b r5) {
        switch(this.f9519b) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "providerFactory");
        return new ArrayList();
    L6:
        Intrinsics.checkNotNullParameter(r5, "providerFactory");
        ArrayList r10 = new ArrayList();
        r10.addAll(b.f9517c.f9518a);
        f r11 = (f) r5.a(f.class);
        if (r11 == null) goto L11;
        a r12 = r11.d;
        if (r12 == null) goto L11;
        r10.addAll(r12.f9515c);
    L11:
        com.ivy.ivykit.plugin.impl.web.h r13 = (com.ivy.ivykit.plugin.impl.web.h) r5.a(com.ivy.ivykit.plugin.impl.web.h.class);
        if (r13 == null) goto L16;
        a r14 = r13.f9545h;
        if (r14 == null) goto L16;
        r10.addAll(r14.f9515c);
    L16:
        return r10;
    }
}
