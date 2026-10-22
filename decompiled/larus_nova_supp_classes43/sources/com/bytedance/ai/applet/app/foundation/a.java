package com.bytedance.ai.applet.app.foundation;

import android.content.Context;
import com.bytedance.ai.applet.app.AppletAppActivity;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.components.input.AppletChatInputController;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.AppletChatConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements w {
    public final AppletApplication a;
    public String b;
    public String c;
    public String d;

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void d() {
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void onDestroy() {
    }

    public final void b() {
        AppletAppActivity r0 = this.a.d;
        if (r0 == null) goto L8;
        AppletChatInputController r1 = r0.H1();
        if (r1 == null) goto L9;
        r1.t7();
        return;
    L9:
        return;
    }

    public a(AppletApplication r10) {
        Intrinsics.checkNotNullParameter(r10, "app");
        this.a = r10;
        Applet r0 = r10.j();
        r0.getClass();
        h5.f r1 = h5.f.a;
        String r11 = r0.Y;
        r1.getClass();
        AppletChatConfig r12 = (AppletChatConfig) h5.f.a(r11, AppletChatConfig.class);
        String r13 = null;
        if (r12 == null) goto L5;
        String r14 = r12.getInputHint();
    L6:
        this.c = r14;
        Applet r15 = r10.j();
        r15.getClass();
        String r16 = r15.Y;
        r1.getClass();
        AppletChatConfig r17 = (AppletChatConfig) h5.f.a(r16, AppletChatConfig.class);
        if (r17 == null) goto L9;
        r13 = r17.getSpeakHint();
    L9:
        this.d = r13;
        return;
    L5:
        r14 = null;
        goto L6
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void a(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void g(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void h(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
    }
}
