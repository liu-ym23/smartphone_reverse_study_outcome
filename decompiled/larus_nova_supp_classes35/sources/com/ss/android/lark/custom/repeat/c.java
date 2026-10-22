package com.ss.android.lark.custom.repeat;

import com.ss.android.lark.custom.repeat.entity.RepeatMode;
import com.ss.android.lark.custom.repeat.widget.wheelview.WheelView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements oab.f {
    public final /* synthetic */ ChooseCustomRepeatFragment a;

    public c(ChooseCustomRepeatFragment r1) {
        this.a = r1;
    }

    @Override // oab.f
    public final void onItemSelected(int r6) {
        if (this.a.isAdded() == true) goto L5;
        return;
    L5:
        if (this.a.getActivity() == null) goto L30;
        mab.b r0 = this.a.o;
        mab.b r2 = null;
        if (r0 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("repeatNumAdapter");
        r0 = null;
    L10:
        Integer r1 = r0.b(r6);
        int r3 = this.a.V90().getCurrentItem();
        if (r1 != null) goto L14;
    L19:
        WheelView r4 = this.a.V90();
        mab.f r5 = this.a.p;
        if (r5 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("repeatFreAdapter");
        r5 = null;
    L22:
        r4.setAdapter(r5);
    L23:
        this.a.V90().setCurrentItem(r3);
        ChooseCustomRepeatFragment r7 = this.a;
        RepeatMode r8 = r7.r;
        mab.b r9 = r7.o;
        if (r9 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("repeatNumAdapter");
    L27:
        r8.setInterval(r2.b(r6).intValue());
        this.a.ba0();
        return;
    L26:
        r2 = r9;
        goto L27
    L14:
        if (r1.intValue() != 1) goto L19;
        WheelView r10 = this.a.V90();
        mab.f r11 = this.a.q;
        if (r11 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("repeatFreSingularAdapter");
        r11 = null;
    L18:
        r10.setAdapter(r11);
        goto L23
    }
}
