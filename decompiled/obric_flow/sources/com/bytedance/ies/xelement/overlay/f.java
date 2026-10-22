package com.bytedance.ies.xelement.overlay;

import android.content.DialogInterface;
import android.view.KeyEvent;
import com.obric.oui.window.permission.PrivacyStatementActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class f implements DialogInterface.OnKeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6497b;

    public /* synthetic */ f(Object r5, int r10) {
        this.f6496a = r10;
        this.f6497b = r5;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface r5, int r10, KeyEvent r11) {
        Object r12 = this.f6497b;
        switch(this.f6496a) {
            case 0: goto L22;
            default: goto L4;
        };
    L4:
        com.obric.oui.privacy.b r13 = (com.obric.oui.privacy.b) r12;
        Intrinsics.checkNotNullParameter(r13, "this$0");
        if (r10 != 4) goto L31;
        if (r11 != null) goto L9;
        return false;
    L9:
        if (r11.getAction() != 1) goto L32;
        com.obric.oui.window.permission.c r14 = r13.e;
        if (r14 == null) goto L21;
        PrivacyStatementActivity r15 = r14.f14920a;
        r15.getClass();
        com.obric.oui.privacy.b r16 = r15.f14914w;
        if (r16 == null) goto L21;
        com.obric.oui.sheet.v2.b r17 = r16.f14183c;     // Catch: Exception -> L28
        if (r17 == null) goto L21;
        r17.dismiss();     // Catch: Exception -> L28
    L21:
        return true;
    L32:
        return false;
    L31:
        return false;
    L22:
        int r18 = LynxOverlayView.f6470t;
        LynxOverlayView r19 = (LynxOverlayView) r12;
        Intrinsics.checkNotNullParameter(r19, "this$0");
        if (r10 == 4) goto L25;
        return false;
    L25:
        if (r11.getAction() != 0) goto L35;
        r19.b("onRequestClose");
        return true;
    L35:
        return false;
    }
}
