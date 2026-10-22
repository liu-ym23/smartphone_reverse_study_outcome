package com.bytedance.ai.widget.contianer;

import b3.p;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements g1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppletWidgetContainer f3044a;

    public d(AppletWidgetContainer r5) {
        this.f3044a = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [int] */
    public final void a(g1.b r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "url");
        String r12 = androidx.room.jarjarred.org.antlr.runtime.a.v(new StringBuilder("onDidReadResource "), r11, "AppletWidgetContainer", "tag");
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L5;
        r13.i("AppletWidgetContainer", r12);
    L5:
        p r14 = b3.h.f841a;
        AppletWidgetContainer r15 = this.f3044a;
        String r5 = r15.v();
        g1.b r16 = r15.f2994w;
        if (r16 == null) goto L8;
        ?? r17 = r16.e();
    L9:
        Map r18 = MapsKt.mapOf(TuplesKt.to("isReused", Integer.valueOf(r17)));
        Intrinsics.checkNotNullParameter(r5, "traceId");
        Intrinsics.checkNotNullParameter(r18, "eventInfo");
        b3.h.c(new b3.a(r5, System.currentTimeMillis(), r18, 2));
        return;
    L8:
        r17 = 0;
        goto L9
    }

    public final void b(g1.b r5, boolean r10, int r11, String r12) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r12, "errorMsg");
        StringBuilder r13 = new StringBuilder("onReceivedError, isFatal = ");
        r13.append(r10);
        r13.append(", errorCode = ");
        r13.append(r11);
        r13.append(", errorMsg = ");
        String r14 = androidx.room.jarjarred.org.antlr.runtime.a.v(r13, r12, "AppletWidgetContainer", "tag");
        t0.d r15 = com.bytedance.ai.utils.c.f2846a;
        if (r15 == null) goto L5;
        r15.e("AppletWidgetContainer", r14);
    L5:
        if (r10 == false) goto L8;
        WidgetContainer.LifecycleEvent r16 = WidgetContainer.LifecycleEvent.f3034c;
        AppletWidgetContainer r17 = this.f3044a;
        r17.i(r16);
        p r18 = b3.h.f841a;
        b3.h.a(r11, r17.v(), r12, "applet_widget_timeline_full");
        return;
    }
}
