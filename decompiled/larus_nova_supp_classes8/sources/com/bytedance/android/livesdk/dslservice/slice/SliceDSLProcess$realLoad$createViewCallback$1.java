package com.bytedance.android.livesdk.dslservice.slice;

import com.bytedance.android.ecom.arch.slice.render.j;
import com.bytedance.android.ecom.arch.slice.template.JsonTemplate;
import com.bytedance.android.livesdk.dsl.api.DSLType;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import yt1.l;
import yt1.m;
import yt1.o;
import yt1.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class SliceDSLProcess$realLoad$createViewCallback$1 implements com.bytedance.android.ecom.arch.slice.render.d {
    public final /* synthetic */ SliceDSLProcess a;
    public final /* synthetic */ Ref.ObjectRef b;
    public final /* synthetic */ m c;
    public final /* synthetic */ a d;
    public final /* synthetic */ o e;
    public final /* synthetic */ r f;
    public final /* synthetic */ Ref.ObjectRef g;

    public final void a(j r12) {
        Intrinsics.checkNotNullParameter(r12, "result");
        if (this.a.f.b() == false) goto L5;
        this.a.e.remove(this);
    L5:
        this.b.element = r12;
        com.bytedance.android.ecom.arch.slice.render.r r0 = r12.a;
        Throwable r2 = null;
        if (r0 != null) goto L9;
        this.c.b(DSLType.Slice, "ViewInfo is null", null);
        return;
    L9:
        boolean r3 = r12.d;
        boolean r13 = !Intrinsics.areEqual(r12.c, "RemoteData");
        b r5 = this.d.a(this.e.b, r0, this.f, new SliceDSLProcess$realLoad$createViewCallback$1$notifyCreateView$resultComponent$1(this));
        if (r5.b != 3) goto L50;
        com.bytedance.android.livesdk.dslservice.util.o.f.d(SliceDSLProcess$realLoad$createViewCallback$1$notifyCreateView$1.INSTANCE);
        return;
    L50:
        SliceDSLProcess.h(this.a, r5, r0, this.f);     // Catch: Throwable -> L28
        int r7 = com.bytedance.android.livesdk.dsl.util.c.a;     // Catch: Throwable -> L28
        HashMap r8 = com.bytedance.android.livesdk.dsl.util.c.g((String) this.g.element);     // Catch: Throwable -> L28
        if (r8 != null) goto L17;
        r8 = new HashMap();     // Catch: Throwable -> L28
    L17:
        int r9 = com.bytedance.android.livesdk.dslservice.util.e.a;     // Catch: Throwable -> L28
        l r10 = this.a.g;     // Catch: Throwable -> L28
        r r11 = this.f;     // Catch: Throwable -> L28
        if (r11 == null) goto L22;
        Map<String, ? extends Object> r14 = r11.c;     // Catch: Throwable -> L28
        if (r14 == null) goto L22;
        r8.put("__local_custom_data", r14);     // Catch: Throwable -> L28
    L22:
        if (r10 == null) goto L26;
        HashMap<String, Object> r15 = r10.b();     // Catch: Throwable -> L28
        if (r15 == null) goto L26;
        r8.put("__local_global_data", r15);     // Catch: Throwable -> L28
    L26:
        r0.a(JsonTemplate.a.b(JsonTemplate.c, r8), String.valueOf(Math.random()));     // Catch: Throwable -> L28
        r5.b(au1.a.b.b, false);     // Catch: Throwable -> L28
        r5.b(au1.a.c.b, false);     // Catch: Throwable -> L28
    L33:
        String r1 = "";
        if (r3 == false) goto L42;
        r5.b = 1;
        m r4 = this.c;
        j r6 = (j) this.b.element;
        if (r6 == null) goto L41;
        String r16 = r6.c;
        if (r16 == null) goto L41;
        r1 = r16;
    L41:
        r4.a(r5, r13, r1);
        return;
    L42:
        r5.b = 2;
        m r17 = this.c;
        j r18 = (j) this.b.element;
        if (r18 == null) goto L48;
        String r19 = r18.e;
        if (r19 == null) goto L48;
        r1 = r19;
    L48:
        r17.b(DSLType.Slice, r1, r2);
        return;
    L28:
        th = move-exception;
        r2 = th;
        j r20 = (j) this.b.element;
        if (r20 == null) goto L32;
        r20.e = r2.toString();
    L32:
        r3 = false;
        goto L33
    }

    public SliceDSLProcess$realLoad$createViewCallback$1(SliceDSLProcess r1, Ref.ObjectRef r2, SliceDSLProcess$wrapInnerCallback$1 r3, a r4, o r5, r r6, Ref.ObjectRef r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
