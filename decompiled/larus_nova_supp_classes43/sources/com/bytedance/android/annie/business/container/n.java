package com.bytedance.android.annie.business.container;

import android.graphics.Bitmap;
import android.os.Looper;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.ai.bridge.service.IHostContextDepend;
import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.jvm.internal.Intrinsics;
import y36.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class n extends WebViewClient {
    public final /* synthetic */ i a;

    public n(i r1) {
        this.a = r1;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r10, String r11) {
        super.onPageFinished(r10, r11);
        this.a.b.hideLoading();
        com.bytedance.android.annie.business.ability.schema.model.b r12 = this.a.o;
        ia.h r0 = null;
        if (r12 == null) goto L7;
        p r13 = r12.h;
        if (r13 == null) goto L7;
        String r14 = (String) ((y36.i) r13).b;
    L8:
        if (r14 != null) goto L17;
        if (r10 == null) goto L17;
        String r15 = r10.getTitle();
        if (r15 == null) goto L17;
        ia.c r1 = this.a.b;
        if ((r1 instanceof ia.h) == false) goto L15;
        r0 = (ia.h) r1;
    L15:
        if (r0 == null) goto L17;
        r0.setTitle(r15);
    L17:
        i r16 = this.a;
        if (r16.j == true) goto L20;
    L26:
        i r17 = this.a;
        ia.c.a.a(r17.b, true);
        w8.d r18 = r17.d;
        if (r18 == null) goto L29;
        r18.a(true);
    L29:
        this.a.b.sendEvent(new m(true));
        if (this.a.l == false) goto L34;
        if (r10 == null) goto L33;
        r10.clearHistory();
    L33:
        this.a.l = false;
    L34:
        if (r10 == null) goto L42;
        i r19 = this.a;
        r19.getClass();
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L38;
        r19.f(r10);
        return;
    L38:
        ViewGroup r20 = r19.p;
        if (r20 == null) goto L44;
        r20.post(new k(r19, r10));
        return;
    L44:
        return;
    L42:
        return;
    L20:
        if (r16.k.booleanValue() == true) goto L26;
        i r21 = this.a;
        if (Intrinsics.areEqual(r21.b.getViewType(), AIStateLogRequest.SOURCE_PAGE) == false) goto L26;
        ViewGroup r22 = r21.p;
        if (r22 == null) goto L26;
        r22.setBackgroundColor(ColorProtector.parseColor(IHostContextDepend.SKIN_TYPE_WHITE));
    L7:
        r14 = null;
        goto L8
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView r1, String r10, Bitmap r11) {
        super.onPageStarted(r1, r10, r11);
        if (this.a.j == false) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r10, "about:blank") == true) goto L11;
        ViewGroup r12 = this.a.p;
        if (r12 == null) goto L12;
        r12.setBackgroundColor(ColorProtector.parseColor("#00000000"));
        return;
    L12:
        return;
    }
}
