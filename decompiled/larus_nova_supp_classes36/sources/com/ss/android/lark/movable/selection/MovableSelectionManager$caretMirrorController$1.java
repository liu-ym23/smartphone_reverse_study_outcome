package com.ss.android.lark.movable.selection;

import android.R;
import android.view.ViewGroup;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final /* synthetic */ class MovableSelectionManager$caretMirrorController$1 extends FunctionReferenceImpl implements Function0<ViewGroup> {
    public MovableSelectionManager$caretMirrorController$1(Object r8) {
        super(0, r8, MovableSelectionManager.class, "getCursorContainer", "getCursorContainer()Landroid/view/ViewGroup;", 0);
    }

    public final ViewGroup invoke() {
        MovableSelectionManager r0 = (MovableSelectionManager) ((CallableReference) this).receiver;
        ViewGroup r1 = r0.e;
        if (r1 != null) goto L8;
        ViewGroup r2 = (ViewGroup) r0.a.getRootView().findViewById(R.id.content);
        if (r2 == null) goto L7;
        return r2;
    L7:
        return r0.a;
    L8:
        return r1;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1479invoke() {
        return invoke();
    }
}
