package com.bytedance.android.livesdk.dslservice;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.elements.ElementTypes;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.dsl.api.DSLType;
import com.bytedance.android.livesdk.dslservice.lynx.LynxProcess;
import com.bytedance.android.livesdk.dslservice.lynxair.LynxAirDSLProcess;
import com.bytedance.android.livesdk.dslservice.slice.SliceDSLProcess;
import com.bytedance.android.livesdk.dslservice.util.g;
import com.bytedance.android.livesdk.dslservice.util.i;
import com.bytedance.android.livesdk.dslservice.util.j;
import com.bytedance.android.livesdk.dslservice.util.q;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import yt1.f;
import yt1.h;
import yt1.k;
import yt1.l;
import yt1.m;
import yt1.n;
import yt1.o;
import yt1.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements n {
    public static boolean e;
    public final ArrayList<h> a;
    public final ArrayList<String> b;
    public final HashMap<String, n> c;
    public l d;

    public static final class a {
    }

    static {
    }

    @Override // yt1.n
    public final void release() {
        l r0 = this.d;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        Iterator<Map.Entry<String, n>> r1 = this.c.entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        r1.next().getValue().release();
        goto L7
    }

    public c() {
        this.a = new ArrayList();
        this.b = CollectionsKt.arrayListOf(new String[]{DSLType.Slice, DSLType.LynxAir, DSLType.Lynx});
        this.c = new HashMap();
        if (e == true) goto L10;
        e = true;
        HashMap<String, f<? extends View>> r1 = com.bytedance.android.livesdk.dslservice.view.b.a;
        com.bytedance.android.livesdk.dslservice.view.b.a("Normal_container", new gu1.b());
        com.bytedance.android.livesdk.dslservice.view.b.a("Constraint_container", new gu1.a());
        com.bytedance.android.livesdk.dslservice.view.b.b("LivePDPFlexWidthView", new fu1.c());
        com.bytedance.android.livesdk.dslservice.view.b.b("liveforcefontfamilytext", new fu1.b());
        com.bytedance.android.livesdk.dslservice.lynxair.view.a r2 = new com.bytedance.android.livesdk.dslservice.lynxair.view.a();
        Intrinsics.checkNotNullParameter("LivePDPFlexWidthView", LiveEndPageData.TAG_NAME);
        Intrinsics.checkNotNullParameter(r2, "provider");
        HashMap<String, f<? extends View>> r3 = com.bytedance.android.livesdk.dslservice.view.b.b;
        if (r3.containsKey("LivePDPFlexWidthView") == true) goto L8;
        r3.put("LivePDPFlexWidthView", r2);
    L8:
        SliceRender r4 = SliceRender.o;
        ArrayList r0 = CollectionsKt.arrayListOf(new com.bytedance.android.ecom.arch.slice.render.cache.a[]{new eu1.a(), new eu1.b(), new eu1.c(), new eu1.d()});
        r4.getClass();
        ElementTypes.c("Live", r0);
        return;
    }

    @Override // yt1.n
    public final void g(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        ALogger.i("TriangleManager", "initFramework.");
        Iterator<Map.Entry<String, n>> r0 = this.c.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().getValue().g(r3);
        goto L4
    }

    public final n h(String r2) {
        n r3 = this.c.get(r2);
        if (r3 == null) goto L5;
        return r3;
    L5:
        return new q();
    }

    @Override // yt1.n
    public final void a(yt1.q r2, k r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        if ((r3 instanceof com.bytedance.android.livesdk.dslservice.lynxair.a) == false) goto L6;
        String r0 = DSLType.LynxAir;
    L9:
        h(r0).a(r2, r3);
        return;
    L6:
        if ((r3 instanceof com.bytedance.android.livesdk.dslservice.slice.b) == false) goto L8;
        r0 = DSLType.Slice;
        goto L9
    L8:
        r0 = DSLType.Unknown;
        goto L9
    }

    @Override // yt1.n
    public final boolean b(String r2, yt1.q r3) {
        if (r2 != null) goto L4;
    L6:
        return false;
    L4:
        if (Boolean.valueOf(h(r2).b(r2, r3)).booleanValue() != true) goto L6;
        return true;
    }

    @Override // yt1.n
    public final void e(yt1.q r3, Map r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter("", "data");
        Iterator<Map.Entry<String, n>> r0 = this.c.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().getValue().e(r3, r4);
        goto L4
    }

    @Override // yt1.n
    public final void f(Context r4, l r5, ArrayList<h> r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        ArrayList<h> r0 = this.a;
        int r1 = j.a;
        Intrinsics.checkNotNullParameter(r4, "context");
        r0.add(new com.bytedance.android.livesdk.dslservice.util.h(r4));
        this.a.add(new i());
        this.a.add(new g());
        this.a.add(new com.bytedance.android.livesdk.dslservice.util.jsb.b());
        this.a.add(new hu1.a());
        this.a.add(new hu1.b());
        this.a.add(new com.bytedance.android.livesdk.dslservice.util.jsb.g(r4));
        this.d = r5;
        if (r5 == null) goto L5;
        r5.a();
    L5:
        Iterator<T> r7 = this.b.iterator();
    L7:
        if (r7.hasNext() == false) goto L26;
        String r8 = (String) r7.next();
        HashMap<String, n> r2 = this.c;
        int r3 = b.a;
        Intrinsics.checkNotNullParameter(r8, "type");
        int r9 = r8.hashCode();
        if (r9 == (-1994808941)) goto L22;
        if (r9 == 2383927) goto L19;
        if (r9 == 79973746) goto L16;
    L24:
        n r10 = new q();
    L25:
        r2.put(r8, r10);
        goto L7
    L16:
        if (r8.equals(DSLType.Slice) == false) goto L24;
        r10 = new SliceDSLProcess();
        goto L25
    L19:
        if (r8.equals(DSLType.Lynx) == false) goto L24;
        r10 = new LynxProcess();
        goto L25
    L22:
        if (r8.equals(DSLType.LynxAir) == false) goto L24;
        r10 = new LynxAirDSLProcess();
        goto L25
    L26:
        Iterator<Map.Entry<String, n>> r11 = this.c.entrySet().iterator();
    L28:
        if (r11.hasNext() == false) goto L30;
        r11.next().getValue().f(r4, this.d, this.a);
        goto L28
    }

    @Override // yt1.n
    public final k c(o r8, String r9, Context r10, r r11, m r12) {
        Intrinsics.checkNotNullParameter(r8, "template");
        Intrinsics.checkNotNullParameter(r9, "data");
        Intrinsics.checkNotNullParameter(r10, "context");
        return h(r8.getType()).c(r8, r9, r10, r11, r12);
    }

    @Override // yt1.n
    public final k d(o r8, String r9, ViewGroup r10, r r11, m r12) {
        Intrinsics.checkNotNullParameter(r8, "template");
        Intrinsics.checkNotNullParameter(r9, "data");
        Intrinsics.checkNotNullParameter(r10, "viewGroup");
        return h(r8.getType()).d(r8, r9, r10, r11, r12);
    }
}
