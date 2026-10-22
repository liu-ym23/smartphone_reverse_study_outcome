package com.larus.sheet.sdk.impl;

import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.config.CommentImageSelectorDismissReason;
import com.larus.platform.model.video.sdkwrapper.feed.CustomFeedPlayerEvent;
import com.larus.sheet.sdk.impl.plugins.media.CommentPhotoInsertFragment;
import com.larus.sheet.sdk.impl.plugins.media.m0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import ew4.z;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c implements z {
    public c() {
    }

    public final boolean f() {
        return true;
    }

    public final boolean H0() {
        LarkAppContext.Companion.getClass();
        return !LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK();
    }

    public final boolean f1() {
        LarkAppContext.Companion.getClass();
        return !LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK();
    }

    public final boolean o1() {
        LarkAppContext.Companion.getClass();
        return !LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK();
    }

    public final ew4.g l() {
        return z.a.a();
    }

    public final boolean c(DialogFragment r8, CommentImageSelectorDismissReason r9) {
        Intrinsics.checkNotNullParameter(r8, "fragment");
        Intrinsics.checkNotNullParameter(r9, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        m0.a.getClass();
        Intrinsics.checkNotNullParameter(r8, "fragment");
        Intrinsics.checkNotNullParameter(r9, CustomFeedPlayerEvent.EXTRA_KEY_REASON);
        Dialog r0 = r8.getDialog();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L10;
    L13:
        FLogger.a.i("SheetSelectMediaProvider", "dismissCommentImageSelectorPanel, reason=" + r9 + ", fragment=" + r8.getClass().getSimpleName() + ", isShowing=" + r1);
        if (r1 == false) goto L45;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L31
        if ((r8 instanceof CommentPhotoInsertFragment) == false) goto L19;
        CommentPhotoInsertFragment r4 = (CommentPhotoInsertFragment) r8;     // Catch: Throwable -> L31
    L20:
        if (r4 == null) goto L41;
        r4.U90(r9);     // Catch: Throwable -> L31
    L29:
        Object r5 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L31
    L33:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L36;
        FLogger.a.e("SheetSelectMediaProvider", "dismissCommentImageSelectorPanel failed, reason=" + r9 + ", fragment=" + r8.getClass().getSimpleName() + ", error=" + r6.getMessage());
    L36:
        Boolean r10 = Boolean.FALSE;
        if (Result.isFailure-impl(r5) == false) goto L40;
        r5 = r10;
    L40:
        return ((Boolean) r5).booleanValue();
    L41:
        r8.dismissAllowingStateLoss();     // Catch: Exception -> L25 Throwable -> L31
    L25:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L31
        Throwable r7 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L31
        if (r7 == null) goto L29;
        com.bytedance.crash.d.d(r7, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L31
        goto L29
    L19:
        r4 = null;
    L31:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L33
    L45:
        return false;
    L10:
        if (r8.isAdded() == true) goto L13;
        r1 = false;
        goto L13
    L5:
        if (r0.isShowing() != true) goto L7;
        r2 = true;
        goto L8
    }

    public final DialogFragment e(ew4.c r4, ew4.e r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "request");
        m0.a.getClass();
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "request");
        m0.b = r5;
        FLogger.a.i("SheetSelectMediaProvider", "createCommentImageSelectorPanel, height=" + r5.a + ", maxSelectImageCount=" + r5.b);
        Bundle r0 = new Bundle();
        r0.putInt("init_height", r5.a);
        r0.putInt("max_select_image_count", r5.b);
        CommentPhotoInsertFragment r6 = Fragment.instantiate(r4.getActivity(), CommentPhotoInsertFragment.class.getName(), r0);
        if ((r6 instanceof CommentPhotoInsertFragment) == false) goto L5;
        CommentPhotoInsertFragment r7 = r6;
    L6:
        if (r7 == null) goto L9;
        ew4.d r8 = r5.e;
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r7.g = r8;
        return r7;
    L9:
        return null;
    L5:
        r7 = null;
        goto L6
    }
}
