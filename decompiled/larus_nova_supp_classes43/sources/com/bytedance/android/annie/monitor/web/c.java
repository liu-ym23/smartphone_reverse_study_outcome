package com.bytedance.android.annie.monitor.web;

import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.android.monitorV2.webview.m;
import com.bytedance.ies.web.jsbridge2.TimeLineEvent;
import com.bytedance.ies.web.jsbridge2.c0;
import com.bytedance.ies.web.jsbridge2.o0;
import com.bytedance.ies.web.jsbridge2.u;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.List;
import jz2.h;
import jz2.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements u {
    public final SoftReference<WebView> a;

    public static final class a {
    }

    static {
    }

    public final /* synthetic */ void b(c0 r1, int r10) {
    }

    public c(WebView r10) {
        Intrinsics.checkNotNullParameter(r10, "webview");
        this.a = new SoftReference(r10);
    }

    public static i d(String r10, int r11, o0 r12) {
        long r0 = SystemClock.elapsedRealtime();
        i r13 = new i();
        r13.a = r10;
        r13.b = r11;
        List r14 = r12.c;
        if (r14 == null) goto L12;
        Iterator r15 = r14.iterator();
    L6:
        if (r15.hasNext() == false) goto L12;
        TimeLineEvent r16 = (TimeLineEvent) r15.next();
        if (r16 == null) goto L6;
        if (Intrinsics.areEqual("label_create_java_call", r16.getLabel()) == false) goto L6;
        long r17 = r16.getElapsedTimestamp();
    L13:
        r13.f = r17;
        if (r17 == 0) goto L16;
        r13.g = r0;
        r13.e = r0 - r17;
    L16:
        return r13;
    L12:
        r17 = 0;
        goto L13
    }

    public final void a(String r10, String r11, o0 r12) {
        WebView r13 = this.a.get();
        if (r13 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L10;
        i r14 = d(r11, 1, r12);
        m.f.p(r13, r14);
        return;
    }

    public final void c(String r10, String r11, int r12, String r13, o0 r14) {
        WebView r15 = this.a.get();
        if (r15 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L26;
        int r0 = 0;
        if (r12 == 1) goto L14;
        if (r12 == 2) goto L13;
        if (r12 == 3) goto L12;
        int r16 = 0;
    L15:
        i r17 = d(r11, r16, r14);
        m r18 = m.f;
        r18.p(r15, r17);
        if (r12 == 1) goto L22;
        if (r12 == 2) goto L21;
        if (r12 != 3) goto L23;
        r0 = -3;
    L23:
        h r19 = new h();
        r19.c = r11;
        r19.a = r0;
        r19.b = r13;
        r18.o(r15, r19);
        return;
    L21:
        r0 = -2;
        goto L23
    L22:
        r0 = -1;
        goto L23
    L12:
        r16 = -3;
        goto L15
    L13:
        r16 = -2;
        goto L15
    L14:
        r16 = -1;
        goto L15
    }
}
