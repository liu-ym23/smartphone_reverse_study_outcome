package com.larus.bmhome.view.actionbar.edit.component;

import com.skydoves.balloon.Balloon;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f1 implements b1 {
    public final /* synthetic */ DropdownSelectorHolderV2 a;

    public f1(DropdownSelectorHolderV2 r1) {
        this.a = r1;
    }

    @Override // com.larus.bmhome.view.actionbar.edit.component.b1
    public final void b(int r1, com.larus.bmhome.actionbar.model.w r2) {
        Intrinsics.checkNotNullParameter(r2, "selectedSpinnerItem");
    }

    @Override // com.larus.bmhome.view.actionbar.edit.component.b1
    public final void a(int r2, com.larus.bmhome.actionbar.model.w r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "selectedSpinnerItem");
        Balloon r0 = this.a.d;
        if (r0 == null) goto L5;
        r0.h();
    L5:
        this.a.a.a(r2, r3, r4);
    }

    @Override // com.larus.bmhome.view.actionbar.edit.component.b1
    public final boolean c(int r2, com.larus.bmhome.actionbar.model.w r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "selectedSpinnerItem");
        Balloon r0 = this.a.d;
        if (r0 == null) goto L6;
        r0.h();
    L6:
        return this.a.a.c(r2, r3, r4);
    }
}
