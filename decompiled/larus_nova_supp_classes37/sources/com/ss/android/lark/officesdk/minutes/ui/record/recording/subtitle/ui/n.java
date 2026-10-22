package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.RecordingSessionType;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.MmSubtitleScrollMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class n implements MmSubtitleScrollHelper.a {
    public final /* synthetic */ MmSubtitleFragment a;

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui.MmSubtitleScrollHelper.a
    public final void a() {
        int r0 = bwb.b.a;
        MmUiLogScene r1 = MmUiLogScene.SUBTITLE;
        MmSubtitleFragment r2 = this.a;
        int r3 = MmSubtitleFragment.E;
        bwb.b.g(r1, "onLoadMoreUp", null, r2.U90(), 4);
        this.a.ga0().dispatchEvent(y.a.a);
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui.MmSubtitleScrollHelper.a
    public final void c() {
        MmSubtitleFragment r0 = this.a;
        int r1 = MmSubtitleFragment.E;
        MmRecordingSession r2 = r0.ea0().getSession();
        if (r2 == null) goto L5;
        RecordingSessionType r3 = r2.a;
    L7:
        if (r3 != RecordingSessionType.STANDALONE_AI_INTERPRETATION) goto L17;
        MmRecordingSession r4 = this.a.ea0().getSession();
        if (r4 == null) goto L19;
        com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r5 = r4.b;
        if (r5 == null) goto L20;
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c r6 = r5.N();
        if (r6 == null) goto L21;
        com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.q r7 = (com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.q) r6.m.getValue();
        if (r7 == null) goto L22;
        r7.b(this.a.ea0().getSession(), "scroll_transcript");
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L17:
        MmRecordingViewModel.trackPageClick$default(this.a.ea0(), "scroll_transcript_record_tab", null, 2, null);
        return;
    L5:
        r3 = null;
        goto L7
    }

    public n(MmSubtitleFragment r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui.MmSubtitleScrollHelper.a
    public final void b(MmSubtitleScrollMode r3) {
        Intrinsics.checkNotNullParameter(r3, "mode");
        this.a.ga0().dispatchEvent(new y.c(r3));
    }
}
