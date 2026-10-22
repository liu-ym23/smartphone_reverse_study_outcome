package com.ss.android.lark.keyboard.editor;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final /* synthetic */ class FlowChatKeyboardEditor$onDestroy$2 extends FunctionReferenceImpl implements Function1<FlowChatKeyboardEditor, Unit> {
    public FlowChatKeyboardEditor$onDestroy$2(Object r8) {
        super(1, r8, FlowChatKeyboardEditor.class, "popReEditModeWhenActivityChange", "popReEditModeWhenActivityChange(Lcom/ss/android/lark/keyboard/editor/FlowChatKeyboardEditor;)V", 0);
    }

    public final void invoke(FlowChatKeyboardEditor r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        FlowChatKeyboardEditor.z((FlowChatKeyboardEditor) ((CallableReference) this).receiver, r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((FlowChatKeyboardEditor) r1);
        return Unit.INSTANCE;
    }
}
