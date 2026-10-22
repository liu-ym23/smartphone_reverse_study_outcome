package com.ss.android.lark.officesdk.minutes.ui.record.recording.language;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingLanguageSettingView extends FrameLayout {
    public static final /* synthetic */ int g = 0;
    public final MmRecordingViewModel a;
    public final MmRecordingUILaunchMode b;
    public final Function0<Unit> c;
    public MmRecordingLanguageChooseView d;
    public MmRecordingSpokenLanguageView e;
    public MmRecordingTranslateLanguageView f;

    public final void a() {
        MmRecordingLanguageChooseView r0 = this.d;
        if (r0 != null) goto L5;
        r0 = new MmRecordingLanguageChooseView(getContext(), this.a, this.b, this.c, new MmRecordingLanguageSettingView$showChoosePage$1(this), new MmRecordingLanguageSettingView$showChoosePage$2(this));
        this.d = r0;
    L5:
        b(r0);
    }

    public final void b(View r6) {
        if (r6.getParent() != null) goto L5;
        addView(r6, new FrameLayout.LayoutParams(-1, -2));
    L5:
        int r0 = getChildCount();
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L12;
        View r3 = getChildAt(r2);
        if (Intrinsics.areEqual(r3, r6) == false) goto L10;
        int r4 = 0;
    L11:
        r3.setVisibility(r4);
        r2 = r2 + 1;
        goto L6
    L10:
        r4 = 8;
        goto L11
    }

    public MmRecordingLanguageSettingView(Context r2, MmRecordingViewModel r3, MmRecordingUILaunchMode r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        Intrinsics.checkNotNullParameter(r4, "uiLaunchMode");
        super(r2, null);
        this.a = r3;
        this.b = r4;
        this.c = r5;
        a();
    }
}
