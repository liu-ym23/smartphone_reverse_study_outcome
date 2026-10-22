package com.obric.assistant.interaction.impl.window.helpers;

import android.app.Dialog;
import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class PopupOrDialogVisibilityTracker$dialogVisibleRectResolver$1 extends FunctionReferenceImpl implements Function1<Dialog, Rect> {
    public PopupOrDialogVisibilityTracker$dialogVisibleRectResolver$1(Object r8) {
        super(1, r8, PopupOrDialogVisibilityTracker.class, "resolveDialogVisibleRect", "resolveDialogVisibleRect$impl_mainlandRelease(Landroid/app/Dialog;)Landroid/graphics/Rect;", 0);
    }

    public final Rect invoke(Dialog r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        return ((PopupOrDialogVisibilityTracker) ((CallableReference) this).receiver).resolveDialogVisibleRect$impl_mainlandRelease(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Dialog) r1);
    }
}
