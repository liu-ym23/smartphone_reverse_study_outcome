package com.bytedance.ai.applet.render.core.lynx;

import android.net.Uri;
import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.q1;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class n extends q1 {
    public final LynxRenderView a;
    public final w2.b b;
    public final o c;

    public static final class a {
    }

    static {
    }

    public final void onLoadSuccess() {
        w2.b r0 = this.b;
        LynxRenderView r1 = this.a;
        String r10 = r1.getTemplateUrl();
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        r0.e(r1, r10);
    }

    public final void onPageStart(String r10) {
        w2.b r11 = this.b;
        LynxRenderView r0 = this.a;
        String r1 = r0.getTemplateUrl();
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r11.d(r0, r1);
    }

    public final void onReceivedError(LynxError r10) {
        Intrinsics.checkNotNullParameter(r10, IHostStyleUIDepend.TOAST_TYPE_ERROR);
        this.b.f(this.a, CollectionsKt.listOf(new Integer[]{100, 102, 103, 1201}).contains(Integer.valueOf(r10.getErrorCode())), r10.getErrorCode(), r10.getSummaryMessage());
    }

    public final void onTimingSetup(Map<String, Object> r10) {
        this.b.c(this.a, r10);
    }

    public final String shouldRedirectImageUrl(String r10) {
        if (r10 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        String r11 = null;
        if (r1 == false) goto L12;
        return null;
    L12:
        Uri r12 = UriProtector.parse(r10);
        String r13 = this.c.c(r10);
        if (r13 != null) goto L15;
    L19:
        List r0 = CollectionsKt.listOf(new String[]{"http", "https", "file", "content", "res", "data"});
        String r14 = r12.getScheme();
        if (r14 != null) goto L23;
        r14 = "";
    L23:
        if (r0.contains(r14) == false) goto L26;
        return r10;
    L26:
        if (Intrinsics.areEqual(r12.getScheme(), "bundle") == true) goto L30;
        if (Intrinsics.areEqual(r12.getScheme(), "relative") == true) goto L30;
        return r10;
    L30:
        return r12.getPath();
    L15:
        if ((true ^ equals(r10)) == false) goto L17;
        r11 = r13;
    L17:
        if (r11 == null) goto L19;
        return r11;
    L5:
        if (r10.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public n(LynxRenderView r10, w2.b r11, o r12) {
        Intrinsics.checkNotNullParameter(r10, "renderView");
        Intrinsics.checkNotNullParameter(r11, "client");
        Intrinsics.checkNotNullParameter(r12, "loader");
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }

    public final void onTimingUpdate(Map<String, Object> r10, Map<String, Long> r11, String r12) {
        this.b.b(this.a, r10, r11, r12);
    }
}
