package com.larus.bmhome.chat.component.bottom.core;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
final /* synthetic */ class CoreInputComponent$observerOnActionShownChanged$1 extends PropertyReference1Impl {
    public static final CoreInputComponent$observerOnActionShownChanged$1 INSTANCE = null;

    static {
        INSTANCE = new CoreInputComponent$observerOnActionShownChanged$1();
    }

    public CoreInputComponent$observerOnActionShownChanged$1() {
        super(CoreInputComponentState.class, "actionShown", "getActionShown()I", 0);
    }

    public Object get(Object r1) {
        return Integer.valueOf(((CoreInputComponentState) r1).getActionShown());
    }
}
