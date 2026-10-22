package com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation;

import androidx.lifecycle.ViewModelProvider;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmStandaloneAIInterpretationSlotsProvider {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public MmStandaloneAIInterpretationSlotsProvider() {
    }

    public static final MmStandaloneAIInterpretationViewModel a(com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.scope.d r3) {
        MmStandaloneAIInterpretationViewModel r4 = (MmStandaloneAIInterpretationViewModel) new ViewModelProvider(r3.c, new MmStandaloneAIInterpretationViewModel.Factory(r3.d)).get(MmStandaloneAIInterpretationViewModel.class);
        r4.dispatchEvent(e.b.a);
        return r4;
    }

    public static dwb.b b(final MmRecordingUILaunchMode r7) {
        Intrinsics.checkNotNullParameter(r7, "uiLaunchMode");
        return new dwb.b(new dwb.a.b(new MmStandaloneAIInterpretationSlotsProvider$create$1(r7)), new dwb.a.b(MmStandaloneAIInterpretationSlotsProvider$create$2.INSTANCE), new dwb.a.b(new MmStandaloneAIInterpretationSlotsProvider$create$3(r7)), new dwb.c(true), 36);
    }
}
