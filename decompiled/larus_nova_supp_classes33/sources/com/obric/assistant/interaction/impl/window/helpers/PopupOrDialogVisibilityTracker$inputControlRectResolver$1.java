package com.obric.assistant.interaction.impl.window.helpers;

import android.graphics.Rect;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class PopupOrDialogVisibilityTracker$inputControlRectResolver$1 extends FunctionReferenceImpl implements Function2<OverlaySource, FragmentActivity, Rect> {
    public PopupOrDialogVisibilityTracker$inputControlRectResolver$1(Object r8) {
        super(2, r8, PopupOrDialogVisibilityTracker.class, "resolveInputControlRect", "resolveInputControlRect$impl_mainlandRelease(Lcom/obric/assistant/interaction/impl/window/helpers/OverlaySource;Landroidx/fragment/app/FragmentActivity;)Landroid/graphics/Rect;", 0);
    }

    public final Rect invoke(OverlaySource r2, FragmentActivity r3) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        return ((PopupOrDialogVisibilityTracker) ((CallableReference) this).receiver).resolveInputControlRect$impl_mainlandRelease(r2, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((OverlaySource) r1, (FragmentActivity) r2);
    }
}
