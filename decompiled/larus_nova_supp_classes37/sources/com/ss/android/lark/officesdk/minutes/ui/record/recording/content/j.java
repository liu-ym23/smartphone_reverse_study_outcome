package com.ss.android.lark.officesdk.minutes.ui.record.recording.content;

import androidx.fragment.app.Fragment;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.MmRecordingUITab;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.summary.MmSummaryFragment;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class j implements h {
    public j() {
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.recording.content.h
    public final Fragment a() {
        return new MmSummaryFragment();
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.recording.content.h
    public final CharSequence getTitle() {
        return UIHelper.getString(2131893535);
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.recording.content.h
    public final MmRecordingUITab getTabType() {
        return MmRecordingUITab.SUMMARY;
    }
}
