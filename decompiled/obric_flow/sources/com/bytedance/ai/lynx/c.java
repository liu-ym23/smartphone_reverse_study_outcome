package com.bytedance.ai.lynx;

import android.net.Uri;
import android.util.LruCache;
import com.bytedance.ai.resource.e0;
import com.bytedance.ies.bullet.lynx.impl.LynxErrorCode;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.o0;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference f2175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Uri f2176c;
    public t9.a d;
    public String e;

    public c(g r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "appletLynxView");
        Intrinsics.checkNotNullParameter(r10, "bid");
        this.f2174a = r10;
        this.f2175b = new WeakReference(r5);
        this.e = "";
    }

    @Override // com.lynx.tasm.o0
    public final void onFirstScreen() {
        if (this.d == null) goto L6;
        g r5 = (g) this.f2175b.get();
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onLoadSuccess() {
        if (this.d != null) goto L5;
        return;
    L5:
        if (((g) this.f2175b.get()) == null) goto L11;
        String r5 = "onLoadUriSuccess " + this.f2176c;
        Intrinsics.checkNotNullParameter("LynxViewFloatingPage", "tag");
        t0.d r10 = com.bytedance.ai.utils.c.f2846a;
        if (r10 == null) goto L12;
        r10.i("LynxViewFloatingPage", r5);
        return;
    L12:
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onPageStart(String r5) {
        if (this.d != null) goto L5;
        return;
    L5:
        if (((g) this.f2175b.get()) == null) goto L11;
        String r10 = com.lynx.tasm.behavior.utils.d.c("onPageStart ", r5, "LynxViewFloatingPage");
        t0.d r11 = com.bytedance.ai.utils.c.f2846a;
        if (r11 == null) goto L12;
        r11.i("LynxViewFloatingPage", r10);
        return;
    L12:
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onPageUpdate() {
        if (this.d != null) goto L5;
        return;
    L5:
        if (((g) this.f2175b.get()) == null) goto L11;
        Intrinsics.checkNotNullParameter("LynxViewFloatingPage", "tag");
        t0.d r5 = com.bytedance.ai.utils.c.f2846a;
        if (r5 == null) goto L12;
        r5.i("LynxViewFloatingPage", "onPageUpdate");
        return;
    L12:
        return;
    }

    @Override // com.lynx.tasm.o0, com.lynx.tasm.j
    public final void onReceivedError(LynxError r10) {
        if (this.d != null) goto L5;
        return;
    L5:
        if (((g) this.f2175b.get()) == null) goto L17;
        String r5 = "onReceivedError " + r10;
        Intrinsics.checkNotNullParameter("LynxViewFloatingPage", "tag");
        t0.d r11 = com.bytedance.ai.utils.c.f2846a;
        if (r11 == null) goto L9;
        r11.e("LynxViewFloatingPage", r5);
    L9:
        if (r10 == null) goto L18;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (CollectionsKt.listOf(new Integer[]{100, 102, 103, Integer.valueOf(LynxErrorCode.LYNX_ERROR_MAIN_FLOW)}).contains(Integer.valueOf(r10.a())) != true) goto L19;
        String r12 = "onReceivedError FatalError " + r10;
        Intrinsics.checkNotNullParameter("LynxViewFloatingPage", "tag");
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L20;
        r13.e("LynxViewFloatingPage", r12);
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onRuntimeReady() {
        if (this.d == null) goto L6;
        g r5 = (g) this.f2175b.get();
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onTimingSetup(Map r5) {
        if (this.d == null) goto L6;
        g r10 = (g) this.f2175b.get();
        return;
    }

    @Override // com.lynx.tasm.o0
    public final void onTimingUpdate(Map r5, Map r10, String r11) {
        if (this.d == null) goto L6;
        g r12 = (g) this.f2175b.get();
        return;
    }

    @Override // com.lynx.tasm.o0, com.lynx.tasm.behavior.k
    public final String shouldRedirectImageUrl(String r10) {
        if (r10 == null) goto L32;
        Uri r5 = Uri.parse(r10);
        LruCache r11 = e0.f2711a;
        String r12 = this.e;
        String r13 = this.f2174a;
        Intrinsics.checkNotNullParameter(r13, "bid");
        if (StringsKt.P(r10, "content://") != true) goto L7;
        String r14 = r10;
    L8:
        if (r14 == null) goto L16;
        if (equals(r10) == false) goto L13;
        r14 = null;
    L13:
        if (r14 == null) goto L16;
        return r14;
    L16:
        if (r10.length() != 0) goto L18;
        return null;
    L18:
        List r15 = CollectionsKt.listOf(new String[]{"http", IIvyAIPackageResourceService.SCHEMA, "file", "content", "res", "data"});
        String r16 = r5.getScheme();
        if (r16 != null) goto L22;
        r16 = "";
    L22:
        if (r15.contains(r16) == false) goto L25;
    L29:
        return r10;
    L25:
        if (Intrinsics.areEqual(r5.getScheme(), "bundle") == true) goto L31;
        if (Intrinsics.areEqual(r5.getScheme(), "relative") == false) goto L29;
    L31:
        return r5.getPath();
    L7:
        r14 = IIvyAIPackageResourceService.Companion.getImageUrl(r12, r10, r13);
        goto L8
    L32:
        return null;
    }
}
