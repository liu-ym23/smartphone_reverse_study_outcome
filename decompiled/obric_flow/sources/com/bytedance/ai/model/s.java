package com.bytedance.ai.model;

import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import com.bytedance.ai.model.widgets.LynxViewFloatingPage;
import com.bytedance.ai.model.widgets.RelaxViewFloatingPageV2;
import com.bytedance.ai.model.widgets.WebViewFloatingPageV2;
import com.bytedance.ai.widget.contianer.AppletWidgetContainer;
import kotlin.Lazy;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2297b;

    public /* synthetic */ s(Object r5, int r10) {
        this.f2296a = r10;
        this.f2297b = r5;
    }

    public final void a(Function1 r11) {
        Object r5 = this.f2297b;
        switch(this.f2296a) {
            case 0: goto L26;
            case 1: goto L24;
            case 2: goto L22;
            case 3: goto L20;
            case 4: goto L18;
            case 5: goto L16;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r11, ST.IMPLICIT_ARG_NAME);
        AppletWidgetContainer r10 = (AppletWidgetContainer) r5;
        com.bytedance.ai.widget.contianer.h r12 = r10.f;
        if (r12 == null) goto L28;
        Lazy r13 = p.f2292a;
        String r14 = r10.getAppletId();
        if (r14 != null) goto L9;
        String r15 = "";
    L10:
        String r16 = r10.f3018a;
        if (r16 != null) goto L13;
        String r17 = "";
    L14:
        com.bytedance.ai.bridge.method.router.h r18 = new com.bytedance.ai.bridge.method.router.h(2, r11);
        p.e(r15, r17, r12.d, r12.e, null, r18, 48);
        return;
    L13:
        r17 = r16;
        goto L14
    L9:
        r15 = r14;
        goto L10
    L28:
        return;
    L16:
        Intrinsics.checkNotNullParameter(r11, "callback");
        r11.invoke(((WebViewFloatingPageV2) r5).f2329a);
        return;
    L18:
        Intrinsics.checkNotNullParameter(r11, ST.IMPLICIT_ARG_NAME);
        r11.invoke(((RelaxViewFloatingPageV2) r5).f2329a);
        return;
    L20:
        Intrinsics.checkNotNullParameter(r11, ST.IMPLICIT_ARG_NAME);
        r11.invoke(((LynxViewFloatingPage) r5).f2329a);
        return;
    L22:
        int r19 = RelaxWorkerRuntime.A;
        Intrinsics.checkNotNullParameter(r11, ST.IMPLICIT_ARG_NAME);
        r11.invoke((RelaxWorkerRuntime) r5);
        return;
    L24:
        int r110 = LynxWorkerRuntime.B;
        Intrinsics.checkNotNullParameter(r11, ST.IMPLICIT_ARG_NAME);
        r11.invoke((LynxWorkerRuntime) r5);
        return;
    L26:
        int r111 = JSWorkerRuntime.A;
        Intrinsics.checkNotNullParameter(r11, ST.IMPLICIT_ARG_NAME);
        r11.invoke((JSWorkerRuntime) r5);
    }
}
