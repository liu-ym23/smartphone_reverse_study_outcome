package com.bytedance.android.livesdk.interactivity.comment.utils;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.v;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import ec2.c0;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    static {
    }

    @JvmStatic
    public static final boolean a(String r2) {
        if (v.a() == true) goto L6;
        return false;
    L6:
        if (((Boolean) c0.a.getValue()).booleanValue() == false) goto L8;
        return false;
    L8:
        if (r2 == null) goto L10;
        return false;
    L10:
        return true;
    }

    @JvmStatic
    public static final void b(String r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "context");
        if ((r3 instanceof FragmentActivity) == true) goto L5;
        r3 = null;
    L5:
        FragmentActivity r4 = (FragmentActivity) r3;
        if (r4 == null) goto L16;
        LiveCommentInterceptTipDialog r0 = new LiveCommentInterceptTipDialog();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r0.d = r2;
        FragmentManager r5 = r4.getSupportFragmentManager();
        LandscapeRestrictionOperation r6 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, "COMMENT_INTERCEPT", r6);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r5, r0, r6) == true) goto L17;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L11:
        r0.show(r5, "COMMENT_INTERCEPT");
        return;
    L17:
        return;
    }
}
