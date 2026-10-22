package com.larus.bmhome.chat.layout.holder.helper;

import android.view.View;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public /* synthetic */ class PopMenuPanelTrigger$invoke$11$menuContext$1 extends FunctionReferenceImpl implements Function0<Long> {
    public PopMenuPanelTrigger$invoke$11$menuContext$1(Object r8) {
        super(0, r8, v1.class, "getChatUniqueKey", "getChatUniqueKey(Landroid/view/View;)J", 1);
    }

    public final Long invoke() {
        return Long.valueOf(v1.c((View) ((CallableReference) this).receiver));
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m90invoke() {
        return invoke();
    }
}
