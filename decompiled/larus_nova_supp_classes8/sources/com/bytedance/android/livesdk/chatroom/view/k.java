package com.bytedance.android.livesdk.chatroom.view;

import android.app.Activity;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k extends om3.e {

    public static final class a extends om3.e.a {
        public a(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            super(r2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        if (getContentView() != null) goto L5;
    L10:
        PopupWindowLancet.handleDismissBeforeOrigin(this);
        super.dismiss();
        return;
    L5:
        if (getContentView().getVisibility() != 8) goto L10;
        om3.e.c r0 = ((om3.e) this).l;
        if (r0 == null) goto L9;
        r0.bubbleDismiss();
    L9:
        c();
    }

    public k(a r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        super(r2);
        j r3 = new j(this);
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        ((om3.e) this).m = r3;
    }
}
