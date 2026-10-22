package com.obric.assistant.interaction.impl.window.helpers;

import android.graphics.Rect;
import android.widget.PopupWindow;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class PopupOrDialogVisibilityTracker$popupVisibleRectResolver$1 extends FunctionReferenceImpl implements Function1<PopupWindow, Rect> {
    public PopupOrDialogVisibilityTracker$popupVisibleRectResolver$1(Object r8) {
        super(1, r8, PopupOrDialogVisibilityTracker.class, "resolvePopupVisibleRect", "resolvePopupVisibleRect$impl_mainlandRelease(Landroid/widget/PopupWindow;)Landroid/graphics/Rect;", 0);
    }

    public final Rect invoke(PopupWindow r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        return ((PopupOrDialogVisibilityTracker) ((CallableReference) this).receiver).resolvePopupVisibleRect$impl_mainlandRelease(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((PopupWindow) r1);
    }
}
