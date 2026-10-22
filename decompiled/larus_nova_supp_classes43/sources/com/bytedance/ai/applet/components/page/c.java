package com.bytedance.ai.applet.components.page;

import android.net.Uri;
import com.bytedance.ai.applet.render.core.RenderType;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final RenderUrlData a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Uri r11 = UriProtector.parse(r10);
        String r0 = r11.getHost();
        if (r0 == null) goto L17;
        int r1 = r0.hashCode();
        if (r1 == (-1772600516)) goto L14;
        if (r1 != 1224424441) goto L17;
        if (r0.equals("webview") == false) goto L17;
        RenderType r12 = RenderType.WEB;
    L18:
        RenderType r13 = r12;
        String r14 = UriProtector.getQueryParameter(r11, com.bytedance.android.ec.core.event.a.KEY_URL);
        if (r14 != null) goto L21;
        r14 = "";
    L21:
        String r15 = r14;
        if (r15.length() != 0) goto L24;
        boolean r16 = true;
    L25:
        if (r16 == true) goto L41;
        boolean r17 = Intrinsics.areEqual(UriProtector.getQueryParameter(r11, "trans_status_bar"), "1");
        boolean r18 = Intrinsics.areEqual(UriProtector.getQueryParameter(r11, "hide_nav_bar"), "1");
        Uri r19 = UriProtector.parse(r15);
        LinkedHashMap r20 = new LinkedHashMap();
        Iterator r21 = UriProtector.getQueryParameterNames(r11).iterator();
    L28:
        if (r21.hasNext() == false) goto L32;
        String r22 = (String) r21.next();
        String r23 = UriProtector.getQueryParameter(r11, r22);
        if (r23 == null) goto L28;
        r20.put(r22, r23);
        goto L28
    L32:
        Iterator r24 = UriProtector.getQueryParameterNames(r19).iterator();
    L34:
        if (r24.hasNext() == false) goto L39;
        String r25 = (String) r24.next();
        String r26 = UriProtector.getQueryParameter(r19, r25);
        if (r26 == null) goto L34;
        r20.put(r25, r26);
        goto L34
    L39:
        return new RenderUrlData(r13, r17, r18, r15, r20);
    L41:
        throw new IllegalArgumentException("url is empty");
    L24:
        r16 = false;
        goto L25
    L14:
        if (r0.equals("lynxview") == false) goto L17;
        r12 = RenderType.LYNX;
    L17:
        r12 = RenderType.WEB;
        goto L18
    }
}
