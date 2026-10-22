package com.bytedance.ai.bridge.method.payment;

import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.app.foundation.v;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.ai.widget.contianer.m;
import d3.a0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ContainerType.values().length];
            r0[ContainerType.WIDGET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ContainerType.PAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final h a(e3.d r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        a0 r0 = r10.getContainerContext();
        String r1 = null;
        if (r0 == null) goto L5;
        int r11 = a.a[r0.getContainerType().ordinal()];
        boolean r12 = false;
        if (r11 != 1) goto L9;
        WidgetContainer r13 = (WidgetContainer) r10.d(WidgetContainer.class);
        if (r13 == null) goto L50;
        m r14 = r13.g;
        if (r14 == null) goto L50;
        String r15 = r14.e;
        if (r15 == null) goto L50;
        if (r15.length() <= 0) goto L47;
        r12 = true;
    L47:
        if (r12 == false) goto L50;
        r1 = r15;
    L50:
        return new h(r1);
    L9:
        if (r11 != 2) goto L51;
        String r16 = r0.getAppletId();
        if (r16 == null) goto L37;
        if (r16.length() <= 0) goto L16;
        boolean r17 = true;
    L17:
        if (r17 == true) goto L20;
        r16 = null;
    L20:
        if (r16 == null) goto L37;
        AppletAppManagerService.INSTANCE.getClass();
        AppletApplication r18 = AppletAppManagerService.a(r16);
        if (r18 == null) goto L52;
        v r19 = r18.h();
        if (r19 == null) goto L52;
        com.bytedance.ai.applet.app.foundation.j r20 = r19.e();
        if (r20 == null) goto L52;
        String r21 = r20.c;
        if (r21 == null) goto L52;
        if (r21.length() <= 0) goto L33;
        r12 = true;
    L33:
        if (r12 == false) goto L52;
        r1 = r21;
    L52:
        return new h(r1);
    L16:
        r17 = false;
    L37:
        return new h(null);
    L51:
        return new h(null);
    L5:
        return new h(null);
    }
}
