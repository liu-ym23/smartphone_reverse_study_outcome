package com.bytedance.android.livesdk.interactivity.medialink.dialog;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.ArrayList;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t implements View.OnClickListener {
    public final /* synthetic */ MediaMultiAnchorStartDialog a;

    public static final class a implements lm3.c.a {
        public static final a b = null;

        static {
            b = new a();
        }

        public a() {
        }

        public final void onAction(lm3.d r4) {
            com.bytedance.android.livesdk.interactivity.medialink.contract.b.R0.getClass();
            com.bytedance.android.livesdk.interactivity.medialink.contract.b r5 = com.bytedance.android.livesdk.interactivity.medialink.contract.b.a.a();
            if (r5 == null) goto L6;
            r5.jg(17, "ceiling_view_leave", true);
            return;
        }
    }

    public t(MediaMultiAnchorStartDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        Context r5 = this.a.getContext();
        if (r5 == null) goto L17;
        lm3.d.a r0 = new lm3.d.a(r5);
        if (e92.m.e() == false) goto L7;
        int r6 = 2131920291;
    L8:
        r0.b = s1.B(r6);
        r0.a = s1.B(2131920293);
        ArrayList r7 = new ArrayList();
        lm3.c r1 = new lm3.c();
        r1.b = s1.B(2131920289);
        Unit r2 = Unit.INSTANCE;
        r7.add(r1);
        lm3.c r3 = new lm3.c();
        r3.b = s1.B(2131920292);
        r3.c = a.b;
        r7.add(r3);
        r0.e = r7;
        r0.a();
        goto L17
    L7:
        r6 = 2131920290;
    L17:
        this.a.dismiss();     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r8 = DialogFragmentLancet.sLastShowStack;
        if (r8 == null) goto L19;
        com.bytedance.crash.d.d(r8, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
