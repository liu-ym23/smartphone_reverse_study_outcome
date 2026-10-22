package com.bytedance.ai.applet.render.core.lynx;

import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import com.bytedance.salamander.anniex.b0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class m implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.lynx.tasm.behavior.ui.utils.n f1780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ fo.g f1781c;

    public /* synthetic */ m(com.lynx.tasm.behavior.ui.utils.n r5, fo.g r10, int r11) {
        this.f1779a = r11;
        this.f1780b = r5;
        this.f1781c = r10;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r10) {
        switch(this.f1779a) {
            case 0: goto L26;
            case 1: goto L24;
            case 2: goto L9;
            default: goto L4;
        };
    L4:
        Throwable r11 = (Throwable) r10;
        Intrinsics.checkNotNullParameter(r11, ST.IMPLICIT_ARG_NAME);
        StringBuilder r5 = new StringBuilder("get external js failed, e=");
        r5.append(r11);
        r5.append(", url=");
        String r12 = androidx.room.jarjarred.org.antlr.runtime.a.v(r5, (String) this.f1780b.f10761a, "AppletResourceLoader", "tag");
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L7;
        r13.i("AppletResourceLoader", r12);
    L7:
        b0 r14 = new b0(r11);
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type com.lynx.tasm.provider.LynxResourceResponse<kotlin.ByteArray>");
        this.f1781c.a(r14);
        return Unit.INSTANCE;
    L9:
        com.ivy.ivykit.api.plugin.b r15 = (com.ivy.ivykit.api.plugin.b) r10;
        Intrinsics.checkNotNullParameter(r15, "response");
        com.ivy.ivykit.api.plugin.a r16 = r15.e;
        com.lynx.tasm.behavior.ui.utils.n r17 = this.f1780b;
        fo.g r18 = this.f1781c;
        String r19 = (String) r17.f10761a;
        if (r16 == null) goto L18;
        byte[] r20 = r16.f9478a;
        if (r20.length == 0) goto L18;
        String r21 = "get external js success, size=" + r20.length + " url=" + r19;
        Intrinsics.checkNotNullParameter("AppletResourceLoader", "tag");
        t0.d r22 = com.bytedance.ai.utils.c.f2846a;
        if (r22 == null) goto L17;
        r22.i("AppletResourceLoader", r21);
    L17:
        b0 r23 = new b0(r20);
        r23.f7246b = 0;
        r18.a(r23);
    L23:
        return Unit.INSTANCE;
    L18:
        String r24 = "get external js failed, response is empty, url=" + r19;
        Intrinsics.checkNotNullParameter("AppletResourceLoader", "tag");
        t0.d r25 = com.bytedance.ai.utils.c.f2846a;
        if (r25 == null) goto L21;
        r25.i("AppletResourceLoader", r24);
    L21:
        b0 r26 = new b0(new Error("response is empty"));
        Intrinsics.checkNotNull(r26, "null cannot be cast to non-null type com.lynx.tasm.provider.LynxResourceResponse<kotlin.ByteArray>");
        r18.a(r26);
        goto L23
    L24:
        Exception r27 = (Exception) r10;
        Intrinsics.checkNotNullParameter(r27, ST.IMPLICIT_ARG_NAME);
        StringBuilder r28 = new StringBuilder("request: get external js failed, e=");
        r28.append(r27);
        r28.append(", url=");
        a1.a.f43a.i("RenderExternalJSProvider", androidx.room.jarjarred.org.antlr.runtime.a.w(r28, (String) this.f1780b.f10761a, "RenderExternalJSProvider", "tag", "msg"));
        b0 r29 = new b0(r27);
        Intrinsics.checkNotNull(r29, "null cannot be cast to non-null type com.lynx.tasm.provider.LynxResourceResponse<kotlin.ByteArray>");
        this.f1781c.a(r29);
        return Unit.INSTANCE;
    L26:
        byte[] r30 = (byte[]) r10;
        Intrinsics.checkNotNullParameter(r30, ST.IMPLICIT_ARG_NAME);
        StringBuilder r31 = new StringBuilder("request: get external js success, size=");
        r31.append(r30.length);
        r31.append(", url=");
        a1.a.f43a.i("RenderExternalJSProvider", androidx.room.jarjarred.org.antlr.runtime.a.w(r31, (String) this.f1780b.f10761a, "RenderExternalJSProvider", "tag", "msg"));
        b0 r32 = new b0(r30);
        r32.f7246b = 0;
        this.f1781c.a(r32);
        return Unit.INSTANCE;
    }
}
