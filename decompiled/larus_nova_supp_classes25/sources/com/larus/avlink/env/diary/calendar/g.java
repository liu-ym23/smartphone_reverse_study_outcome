package com.larus.avlink.env.diary.calendar;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g extends BottomSheetBehavior.BottomSheetCallback {
    public final /* synthetic */ DiaryCalendarDialog a;

    public final void onSlide(View r1, float r2) {
        Intrinsics.checkNotNullParameter(r1, "bottomSheet");
    }

    public g(DiaryCalendarDialog r1) {
        this.a = r1;
    }

    public final void onStateChanged(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "bottomSheet");
        if (r3 == 5) goto L12;
        return;
    L12:
        this.a.dismiss();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L15;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
