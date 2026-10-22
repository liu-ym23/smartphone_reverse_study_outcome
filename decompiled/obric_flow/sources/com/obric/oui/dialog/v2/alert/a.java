package com.obric.oui.dialog.v2.alert;

import android.content.Context;
import android.text.Layout;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f13146b;

    public /* synthetic */ a(Object r5, int r10) {
        this.f13145a = r10;
        this.f13146b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f13145a) {
            case 0: goto L28;
            case 1: goto L16;
            default: goto L4;
        };
    L4:
        f r10 = (f) this.f13146b;
        Intrinsics.checkNotNullParameter(r10, "this$0");
        TextView r5 = r10.C;
        if (r5 == null) goto L11;
        Layout r11 = r5.getLayout();
        if (r11 == null) goto L11;
        r11.getLineCount();
    L11:
        TextView r12 = r10.C;
        if (r12 == null) goto L35;
        r12.getMaxLines();
        return;
    L35:
        return;
    L16:
        b r13 = (b) this.f13146b;
        Intrinsics.checkNotNullParameter(r13, "this$0");
        TextView r14 = r13.f13151w;
        if (r14 == null) goto L23;
        Layout r15 = r14.getLayout();
        if (r15 == null) goto L23;
        r15.getLineCount();
    L23:
        TextView r16 = r13.f13151w;
        if (r16 == null) goto L36;
        r16.getMaxLines();
        return;
    L36:
        return;
    L28:
        final b r17 = (b) this.f13146b;
        Intrinsics.checkNotNullParameter(r17, "this$0");
        View r18 = r17.b();
        Window r19 = r17.getWindow();
        Context r20 = r17.getContext();
        Intrinsics.checkNotNullParameter(r20, "context");
        if ((r20.getResources().getConfiguration().uiMode & 48) != 32) goto L32;
        float r21 = 0.8f;
    L33:
        com.obric.oui.animation.easy.d r22 = com.obric.oui.dialog.anim.d.d(r18, r19, true, r21, false, 8);
        r22.e();
        com.obric.oui.animation.easy.d.d(r22, new OAlertDialog$performEnterAnimation$1$4(r17), new OAlertDialog$performEnterAnimation$1$5(r17));
        return;
    L32:
        r21 = 0.32f;
        goto L33
    }
}
