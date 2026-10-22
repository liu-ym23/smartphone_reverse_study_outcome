package com.bytedance.android.live.revenue.common;

import android.content.Context;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.uikit.dialog.AlertDialog;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k {
    public static final void c(Throwable r1) {
        a(com.bytedance.live.kmp.util.c.a.getContext(), r1);
    }

    public static final void a(Context r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (r3 != null) goto L5;
        return;
    L5:
        com.bytedance.live.kmp.util.c r0 = com.bytedance.live.kmp.util.c.a;
        int r1 = nx0.a.a;
        b(r2, r3, com.bytedance.live.kmp.util.c.a(2131916038, new Object[0]));
    }

    public static final void d(Throwable r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "throwable");
        Intrinsics.checkNotNullParameter(r2, "fallbackPrompt");
        b(com.bytedance.live.kmp.util.c.a.getContext(), r1, r2);
    }

    public static final void e(Context r3, Throwable r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        com.bytedance.live.kmp.util.c r0 = com.bytedance.live.kmp.util.c.a;
        int r1 = nx0.a.a;
        String r2 = com.bytedance.live.kmp.util.c.a(2131916038, new Object[0]);
        if (r3 != null) goto L7;
        r3 = r0.getContext();
    L7:
        b(r3, r4, r2);
    }

    public static final void b(Context r5, Throwable r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "throwable");
        Intrinsics.checkNotNullParameter(r7, "fallbackPrompt");
        if ((r6 instanceof ApiServerException) == false) goto L37;
        ApiServerException r8 = (ApiServerException) r6;
        String r0 = r8.getPrompt();
        String r4 = r8.getAlert();
        if (r8.isBlockNotice() == true) goto L41;
        if (r4 != null) goto L9;
    L12:
        boolean r9 = true;
    L13:
        if (r9 == true) goto L22;
        com.bytedance.live.kmp.util.c r10 = com.bytedance.live.kmp.util.c.a;
        int r12 = nx0.a.a;
        String r13 = com.bytedance.live.kmp.util.c.a(2131916050, new Object[0]);
        String r14 = com.bytedance.live.kmp.util.c.a(2131915973, new Object[0]);
        Intrinsics.checkNotNullParameter(r13, "title");
        Intrinsics.checkNotNullParameter(r4, "message");
        Intrinsics.checkNotNullParameter(r14, "confirmBtnText");
        if (r5 != null) goto L17;
        r5 = s1.getContext();
    L17:
        AlertDialog.Builder r1 = new AlertDialog.Builder(r5);
        r1.setTitle(r13);
        r1.setMessage(r4);
        r1.setPositiveButton(r14, null);
        AlertDialog r15 = r1.create();
        if (DialogLancet.shouldBlockDialogShow(r15) == false) goto L44;
        DialogLancet.handleBlockedDialogShow(r15);
        goto L41
    L44:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L43
    L21:
        DialogLancet.beforeDialogShow(r15);
        r15.show();
        DialogLancet.afterDialogShow(r15);
        goto L41
    L22:
        if (r0 != null) goto L24;
    L27:
        boolean r16 = true;
    L28:
        if (r16 == true) goto L33;
        Intrinsics.checkNotNullParameter(r0, "message");
        if (r5 != null) goto L32;
        r5 = s1.getContext();
    L32:
        IESUIUtils.displayToast(r5, r0);
        goto L41
    L33:
        Intrinsics.checkNotNullParameter(r7, "message");
        if (r5 != null) goto L36;
        r5 = s1.getContext();
    L36:
        IESUIUtils.displayToast(r5, r7);
        goto L41
    L24:
        if (r0.length() == 0) goto L27;
        r16 = false;
        goto L28
    L9:
        if (r4.length() == 0) goto L12;
        r9 = false;
    L41:
        LocalTestManager.a(new Class[]{wy.a.class});
        return;
    L37:
        Intrinsics.checkNotNullParameter(r7, "message");
        if (r5 != null) goto L40;
        r5 = s1.getContext();
    L40:
        IESUIUtils.displayToast(r5, r7);
        goto L41
    }
}
