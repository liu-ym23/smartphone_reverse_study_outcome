package com.bytedance.ai.model;

import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.monitor.AppletErrorCode;
import com.obric.widget.host.runtime.WidgetInstanceManager;
import com.obric.widget.host.runtime.WidgetInstanceRecord;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class n implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f2256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f2257c;
    public final /* synthetic */ Object d;

    public /* synthetic */ n(int r5, Object r10, boolean r11, Object r12) {
        this.f2255a = r5;
        this.f2256b = r11;
        this.f2257c = r10;
        this.d = r12;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r10) {
        Object r5 = this.f2257c;
        Object r11 = this.d;
        boolean r12 = this.f2256b;
        switch(this.f2255a) {
            case 0: goto L16;
            case 1: goto L14;
            default: goto L4;
        };
    L4:
        com.ivy.ivykit.api.plugin.b r13 = (com.ivy.ivykit.api.plugin.b) r10;
        Intrinsics.checkNotNullParameter(r13, ST.IMPLICIT_ARG_NAME);
        com.bytedance.ai.utils.c.n("load Main.js finish and it from ".concat(r13.f9481c));
        if (r12 == false) goto L11;
        com.ivy.ivykit.api.plugin.a r14 = r13.e;
        if (r14 == null) goto L9;
        byte[] r15 = r14.f9478a;
    L10:
        Object r16 = new com.bytedance.ai.utils.f(r15);
    L12:
        g r17 = (g) r11;
        String r18 = (String) r5;
        r17.invoke(r16, r18, r13.f9481c);
        return Unit.INSTANCE;
    L9:
        r15 = null;
        goto L10
    L11:
        r16 = new com.bytedance.ai.utils.g(r13.f9479a);
        goto L12
    L14:
        WidgetInstanceManager r19 = (WidgetInstanceManager) r5;
        return WidgetInstanceManager.d(r12, r19, (Ref.BooleanRef) r11, (WidgetInstanceRecord) r10);
    L16:
        AppletRuntime r20 = (AppletRuntime) r10;
        String r21 = (String) r5;
        if (r12 == false) goto L32;
        b3.p r22 = b3.h.f841a;
        String r23 = "";
        if (r20 == null) goto L24;
        Applet r24 = r20.f2197h;
        if (r24 == null) goto L24;
        String r25 = r24.B;
        if (r25 == null) goto L24;
    L25:
        Pair r26 = TuplesKt.to("applet_res_from", r25);
        if (r20 == null) goto L31;
        String r27 = r20.s;
        if (r27 == null) goto L31;
        r23 = r27;
    L31:
        b3.h.e(r21, "applet_page_timeline_full", MapsKt.mapOf(new Pair[]{r26, TuplesKt.to("main_js_res_from", r23)}));
    L24:
        r25 = "";
    L32:
        if (r20 == null) goto L34;
        PageInfo r28 = (PageInfo) r11;
        r20.o(r28, new o());
    L37:
        return Unit.INSTANCE;
    L34:
        if (r12 == false) goto L37;
        b3.p r29 = b3.h.f841a;
        AppletErrorCode r30 = AppletErrorCode.f2378b;
        b3.h.a(404, r21, "fail to run AppletRunTime", "applet_page_timeline_full");
        goto L37
    }

    public /* synthetic */ n(boolean r5, g r10, String r11) {
        this.f2255a = 2;
        this.f2256b = r5;
        this.d = r10;
        this.f2257c = r11;
    }
}
