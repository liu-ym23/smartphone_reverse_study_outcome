package com.bytedance.ai.lynx;

import android.net.Uri;
import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.file.AppletFileManager;
import com.bytedance.ai.resource.AppletResourceTool;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.q1;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b extends q1 {
    public final String a;
    public final WeakReference<g> b;
    public Uri c;
    public r d;
    public String e;
    public String f;

    public static final class a {
    }

    static {
    }

    public final void onRuntimeReady() {
        r r0 = this.d;
        if (r0 == null) goto L8;
        g r1 = this.b.get();
        if (r1 == null) goto L9;
        r0.onRuntimeReady(r1);
        return;
    L9:
        return;
    }

    public final void onFirstScreen() {
        super.onFirstScreen();
        r r0 = this.d;
        if (r0 == null) goto L8;
        g r1 = this.b.get();
        if (r1 == null) goto L9;
        r0.onFirstScreen(r1);
        return;
    L9:
        return;
    }

    public final void onLoadSuccess() {
        super.onLoadSuccess();
        r r0 = this.d;
        if (r0 == null) goto L8;
        g r1 = this.b.get();
        if (r1 == null) goto L9;
        r0.onLoadUriSuccess(this.c, r1);
        return;
    L9:
        return;
    }

    public final void onPageUpdate() {
        super.onPageUpdate();
        r r0 = this.d;
        if (r0 == null) goto L8;
        g r1 = this.b.get();
        if (r1 == null) goto L9;
        r0.onPageUpdate(r1);
        return;
    L9:
        return;
    }

    public final void onPageStart(String r10) {
        super.onPageStart(r10);
        r r0 = this.d;
        if (r0 == null) goto L8;
        g r1 = this.b.get();
        if (r1 == null) goto L9;
        r0.onPageStart(r1, r10);
        return;
    L9:
        return;
    }

    public final void onReceivedError(LynxError r10) {
        super.onReceivedError(r10);
        r r0 = this.d;
        if (r0 == null) goto L8;
        g r1 = this.b.get();
        if (r1 == null) goto L9;
        r0.onReceivedError(r1, r10);
        return;
    L9:
        return;
    }

    public final void onTimingSetup(Map<String, Object> r10) {
        super.onTimingSetup(r10);
        r r0 = this.d;
        if (r0 == null) goto L8;
        g r1 = this.b.get();
        if (r1 == null) goto L9;
        r0.onTimingSetup(r1, r10);
        return;
    L9:
        return;
    }

    public final String shouldRedirectImageUrl(String r12) {
        if (r12 == null) goto L53;
        boolean r10 = false;
        if (StringsKt.startsWith$default(r12, "appletfile://", false, 2, null) == false) goto L17;
        String r11 = this.f;
        if (r11.length() != 0) goto L10;
        boolean r13 = true;
    L11:
        if (r13 == true) goto L17;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L18
        AppletAppManagerService.INSTANCE.getClass();     // Catch: Throwable -> L18
        OnlineAppletApplication r15 = AppletAppManagerService.b(r11);     // Catch: Throwable -> L18
        if (r15 == null) goto L17;
        AppletFileManager r16 = r15.J();     // Catch: Throwable -> L18
        StringBuilder r17 = new StringBuilder("file://");     // Catch: Throwable -> L18
        int r1 = com.bytedance.ai.file.a.b;     // Catch: Throwable -> L18
        r17.append(r16.n(com.bytedance.ai.file.a.C0040a.a(r12)).getAbsolutePath());     // Catch: Throwable -> L18
        Object r18 = Result.constructor-impl(r17.toString());     // Catch: Throwable -> L18
    L20:
        Throwable r19 = Result.exceptionOrNull-impl(r18);
        if (r19 == null) goto L24;
        com.bytedance.ai.utils.g.a.e("AppletDefaultLynxViewClient", "resolveAppletFileUrl failed: " + r19.getMessage());
    L24:
        if (Result.isFailure-impl(r18) == false) goto L26;
        r18 = null;
    L26:
        String r20 = (String) r18;
    L27:
        if (r20 == null) goto L29;
        return r20;
    L29:
        Uri r21 = UriProtector.parse(r12);
        AppletResourceTool r22 = AppletResourceTool.a;
        String r23 = this.e;
        String r24 = this.a;
        r22.getClass();
        Intrinsics.checkNotNullParameter(r24, "bid");
        String r25 = IIvyAIPackageResourceService.a.d(r23, r12, r24);
        if (r25 == null) goto L38;
        if ((!equals(r12)) == true) goto L35;
        r25 = null;
    L35:
        if (r25 == null) goto L38;
        return r25;
    L38:
        if (r12.length() != 0) goto L40;
        r10 = true;
    L40:
        if (r10 == true) goto L53;
        List r0 = CollectionsKt.listOf(new String[]{"http", "https", "file", "content", "res", "data"});
        String r26 = r21.getScheme();
        if (r26 != null) goto L45;
        r26 = "";
    L45:
        if (r0.contains(r26) == false) goto L48;
        return r12;
    L48:
        if (Intrinsics.areEqual(r21.getScheme(), "bundle") == true) goto L52;
        if (Intrinsics.areEqual(r21.getScheme(), "relative") == true) goto L52;
        return r12;
    L52:
        return r21.getPath();
    L18:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L10:
        r13 = false;
    L17:
        r20 = null;
    L53:
        return null;
    }

    public b(g r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "appletLynxView");
        Intrinsics.checkNotNullParameter(r11, "bid");
        this.a = r11;
        this.b = new WeakReference(r10);
        this.e = "";
        this.f = "";
    }

    public final void onTimingUpdate(Map<String, Object> r10, Map<String, Long> r11, String r12) {
        super.onTimingUpdate(r10, r11, r12);
        super.onTimingSetup(r10);
        r r0 = this.d;
        if (r0 == null) goto L8;
        g r1 = this.b.get();
        if (r1 == null) goto L9;
        r0.onTimingUpdate(r1, r10, r11, r12);
        return;
    L9:
        return;
    }
}
