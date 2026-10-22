package com.larus.uaigc.createpage.component.instruction;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.larus.common.apphost.AppHost;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.applet.IAICreationAppletHostService;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d extends vp8.g {
    public final BaseContentWidget h;
    public final String i;
    public final String j;
    public com.larus.bmhome.instruction.helper.f k;
    public com.larus.bmhome.actionbar.model.z0 l;

    public final void d() {
        com.larus.bmhome.instruction.helper.f r0 = IAIChatUgcAIGCService.a.H0(((vp8.g) this).g);
        this.k = r0;
        if (r0 == null) goto L6;
        r0.b(new b(this));
        return;
    }

    public final void p() {
        com.larus.bmhome.instruction.helper.f r0 = this.k;
        if (r0 == null) goto L6;
        r0.onDestroy();
        return;
    }

    public final boolean v() {
        int r0 = com.larus.uaigc.applet.a.a;
        FragmentActivity r1 = s1a.a.getActivity(this.h);
        if (IAICreationAppletHostService.a.s(r1) == true) goto L5;
        return false;
    L5:
        ny9.s r2 = (ny9.s) s1a.d.a(this.h).a(ny9.s.class);
        if (r2 == null) goto L8;
        Bundle r3 = r2.a;
    L10:
        if (cy9.a.a.c(r3) == null) goto L13;
        return true;
    L13:
        return false;
    L8:
        r3 = null;
        goto L10
    }

    public final boolean f(final com.larus.bmhome.actionbar.model.z0 r5) {
        if (r5 == null) goto L12;
        com.larus.bmhome.actionbar.model.r r2 = r5.q;
        if (r2 == null) goto L12;
        Integer r3 = r2.a;
        if (r3 == null) goto L12;
        if (r3.intValue() != 16) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == true) goto L25;
        if (r5 == null) goto L23;
        com.larus.bmhome.actionbar.model.r r6 = r5.q;
        if (r6 == null) goto L23;
        Integer r7 = r6.a;
        if (r7 == null) goto L23;
        if (r7.intValue() != 24) goto L23;
        boolean r8 = true;
    L24:
        if (r8 == true) goto L25;
    L32:
        return false;
    L23:
        r8 = false;
    L25:
        FragmentActivity r9 = AppHost.a.a().getCurrentActivity();
        if ((r9 instanceof FragmentActivity) == false) goto L28;
        final FragmentActivity r10 = r9;
    L29:
        if (r10 == null) goto L32;
        com.obric.assistant.spi.keyguard.a.b(false, new a(this, r10, r5), 3);
        return true;
    L28:
        r10 = null;
    L12:
        r4 = false;
        goto L13
    }

    public d(BaseContentWidget r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "component");
        super(r2);
        this.h = r2;
        this.i = r3;
        this.j = r4;
    }
}
