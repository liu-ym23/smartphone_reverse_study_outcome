package com.obric.assistant.interaction.impl.window.helpers;

import me.ele.lancet.base.Origin;
import me.ele.lancet.base.This;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class BottomSheetDialogLancet {
    public BottomSheetDialogLancet() {
    }

    public void onStart() {
        Object r0 = This.get();
        Origin.callVoid();
        DialogLancet.handleDialogPreAddViewOnStart(r0, "bottomSheetDialog:onStart");
    }
}
