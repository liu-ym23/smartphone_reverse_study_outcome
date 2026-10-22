package com.bytedance.ai.bridge.method.log;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import b2.b;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.p;
import com.bytedance.ai.monitor.AppletMonitorableEvent$EventOrigin;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import m1.j;
import n1.c;
import z2.f;
import z2.g;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f1832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbsReportAppLogMethodIDL.ReportAppLogParamModel f1833b;

    public a(c r5, AbsReportAppLogMethodIDL.ReportAppLogParamModel r10) {
        this.f1832a = r5;
        this.f1833b = r10;
    }

    @Override // z2.g
    public final void b(f r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        n1.a r10 = (n1.a) this.f1832a;
        j r11 = (j) r10.b(j.class);
        if (r11 == null) goto L5;
        ContainerType r12 = r11.d();
    L6:
        if (r12 != null) goto L8;
        int r13 = -1;
    L10:
        if (r13 != 1) goto L12;
        AppletMonitorableEvent$EventOrigin r14 = AppletMonitorableEvent$EventOrigin.f2386c;
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r5.f23385c = r14;
        AppletRuntime r15 = (AppletRuntime) r10.b(AppletRuntime.class);
    L25:
        Lazy r16 = p.f2292a;
        Intrinsics.checkNotNullParameter("is_background", STGroup.DICT_KEY);
        r5.b("is_background", 0);
        Map<String, Object> r17 = this.f1833b.getParams();
        if (r17 == null) goto L29;
        r5.e(r17);
        return;
    L29:
        return;
    L12:
        if (r13 != 2) goto L14;
        AppletMonitorableEvent$EventOrigin r18 = AppletMonitorableEvent$EventOrigin.d;
        Intrinsics.checkNotNullParameter(r18, "<set-?>");
        r5.f23385c = r18;
        WidgetContainer r19 = (WidgetContainer) r10.b(WidgetContainer.class);
        goto L25
    L14:
        if (r13 != 3) goto L25;
        AppletMonitorableEvent$EventOrigin r20 = AppletMonitorableEvent$EventOrigin.d;
        Intrinsics.checkNotNullParameter(r20, "<set-?>");
        r5.f23385c = r20;
        w0.f r21 = (w0.f) r10.b(w0.f.class);
        if (r21 == null) goto L19;
        ((com.bytedance.ai.model.widgets.a) r21).f2330b.getBotId();
    L19:
        if (r21 == null) goto L25;
        PageInfo r22 = ((com.bytedance.ai.model.widgets.a) r21).f2330b;
        if (r22 == null) goto L25;
        r22.getMessageId();
        goto L25
    L8:
        r13 = b.f820a[r12.ordinal()];
        goto L10
    L5:
        r12 = null;
        goto L6
    }
}
