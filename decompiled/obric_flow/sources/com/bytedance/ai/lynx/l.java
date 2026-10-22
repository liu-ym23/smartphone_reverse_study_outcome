package com.bytedance.ai.lynx;

import android.content.Context;
import com.google.common.reflect.w;
import java.io.InputStream;
import ko.r;
import kotlin.NotImplementedError;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends dn.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2191a;

    public l(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.f2191a = r5;
    }

    @Override // dn.a
    public final void N(r r5, go.a r10) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // dn.a
    public final void O(r r5, go.a r10) {
        String r11 = (String) r5.f18728b;
        if (r11 != null) goto L5;
    L25:
        w r12 = w.b(new IllegalArgumentException("template url is empty"));
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.lynx.tasm.resourceprovider.LynxResourceResponse<com.lynx.tasm.resourceprovider.template.TemplateProviderResult?>");
        r10.f(r12);
        return;
    L5:
        if (r11.length() == 0) goto L25;
        String r13 = (String) com.bytedance.ai.applet.render.core.lynx.b.f1760a.get(r11);
        if (r13 != null) goto L31;
        w r14 = w.b(new IllegalArgumentException("unsupported template url: ".concat(r11)));
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type com.lynx.tasm.resourceprovider.LynxResourceResponse<com.lynx.tasm.resourceprovider.template.TemplateProviderResult?>");
        r10.f(r14);
        return;
    L31:
        Context r15 = this.f2191a;     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r15, "context");     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r13, "assetPath");     // Catch: Throwable -> L16
        InputStream r16 = r15.getAssets().open(r13);     // Catch: Throwable -> L16
        Intrinsics.checkNotNull(r16);     // Catch: Throwable -> L18
        byte[] r17 = ByteStreamsKt.readBytes(r16);     // Catch: Throwable -> L18
    L14:
        CloseableKt.closeFinally(r16, null);     // Catch: Throwable -> L16
        jo.a r18 = new jo.a();     // Catch: Throwable -> L16
        r18.f18400a = r17;     // Catch: Throwable -> L16
        r10.f(w.a(r18));     // Catch: Throwable -> L16
        return;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r16, th);     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        w r19 = w.b(th);
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type com.lynx.tasm.resourceprovider.LynxResourceResponse<com.lynx.tasm.resourceprovider.template.TemplateProviderResult?>");
        r10.f(r19);
    }
}
