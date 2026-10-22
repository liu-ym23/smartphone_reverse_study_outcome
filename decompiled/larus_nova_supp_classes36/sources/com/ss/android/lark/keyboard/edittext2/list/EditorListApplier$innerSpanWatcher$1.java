package com.ss.android.lark.keyboard.edittext2.list;

import android.text.Editable;
import android.text.Selection;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
public /* synthetic */ class EditorListApplier$innerSpanWatcher$1 extends FunctionReferenceImpl implements Function2<Editable, Object, Unit> {
    public EditorListApplier$innerSpanWatcher$1(Object r8) {
        super(2, r8, EditorListApplier.class, "handleSpanChange", "handleSpanChange(Landroid/text/Editable;Ljava/lang/Object;)V", 0);
    }

    public final void invoke(Editable r4, Object r5) {
        Intrinsics.checkNotNullParameter(r4, "p0");
        EditorListApplier r0 = (EditorListApplier) ((CallableReference) this).receiver;
        int r1 = EditorListApplier.o;
        r0.getClass();
        Object r2 = Selection.SELECTION_START;
        Object r3 = Selection.SELECTION_END;
        if (Intrinsics.areEqual(r5, r2) == false) goto L5;
    L7:
        r0.l.c(r4, Selection.getSelectionStart(r4), Selection.getSelectionEnd(r4));
        return;
    L5:
        if (Intrinsics.areEqual(r5, r3) == true) goto L7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Editable) r1, r2);
        return Unit.INSTANCE;
    }
}
