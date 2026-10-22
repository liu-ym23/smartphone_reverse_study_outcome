package com.bytedance.android.livesdk.dslservice.slice;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements com.bytedance.android.ecom.arch.slice.render.b {
    public final /* synthetic */ SliceDSLProcess a;
    public final /* synthetic */ r b;
    public final /* synthetic */ com.bytedance.android.livesdk.dslservice.slice.action.a c;

    public final void a(com.bytedance.android.ecom.arch.slice.action.r r6) {
        Intrinsics.checkNotNullParameter(r6, "actionInfo");
        IAction r0 = r6.a;
        View r7 = r6.d;
        if ((r0 instanceof SlcCommonAction) == false) goto L24;
        List r1 = r0.getActions();
        if (r1 == null) goto L24;
        if ((!r1.isEmpty()) != true) goto L24;
        List r2 = r0.getActions();
        if (r2 == null) goto L34;
        Iterator r3 = r2.iterator();
    L12:
        if (r3.hasNext() == false) goto L36;
        IAction r4 = (IAction) r3.next();
        if (r4.getDisable() == true) goto L12;
        BaseSlcViewManager r5 = SlcViewExtensionsKt.g(r7);
        if (r5 == null) goto L19;
        Map r8 = r5.l();
        if (r8 == null) goto L19;
    L20:
        IAction r9 = SlcTemplateContext.k(this.b.b, r4, r8, 4);
        if (r9.getDisable() == true) goto L12;
        com.bytedance.android.livesdk.dslservice.slice.action.a r10 = this.c;
        SliceDSLProcess r11 = this.a;
        r r12 = this.b;
        r11.getClass();
        r10.a(r9, r7, new d(r12));
    L19:
        r8 = this.b.b.j;
        goto L20
    L36:
        return;
    L34:
        return;
    L24:
        if (r0.getDisable() == true) goto L35;
        com.bytedance.android.livesdk.dslservice.slice.action.a r13 = this.c;
        SliceDSLProcess r14 = this.a;
        r r15 = this.b;
        r14.getClass();
        r13.a(r0, r7, new d(r15));
        return;
    }

    public c(SliceDSLProcess r1, r r2, com.bytedance.android.livesdk.dslservice.slice.action.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
