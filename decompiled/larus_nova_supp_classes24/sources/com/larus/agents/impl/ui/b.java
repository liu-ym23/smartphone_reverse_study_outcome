package com.larus.agents.impl.ui;

import android.content.DialogInterface;
import com.larus.bmhome.chat.component.util.PaneAwareBottomSheetController;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class b implements DialogInterface.OnShowListener {
    public final /* synthetic */ ExpandedTaskBottomSheetFragment a;

    public /* synthetic */ b(ExpandedTaskBottomSheetFragment r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface r2) {
        ExpandedTaskBottomSheetFragment r3 = this.a;
        int r0 = ExpandedTaskBottomSheetFragment.e;
        ((PaneAwareBottomSheetController) r3.d.getValue()).d();
    }
}
