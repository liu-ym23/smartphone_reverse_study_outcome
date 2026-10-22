package com.ss.android.lark.officesdk.minutes.ui.record.recording.content;

import androidx.fragment.app.Fragment;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta.MmRecordingUITab;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui.MmSubtitleFragment;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class i implements h {
    public i() {
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.recording.content.h
    public final Fragment a() {
        return new MmSubtitleFragment();
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.recording.content.h
    public final CharSequence getTitle() {
        return UIHelper.getString(2131893543);
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.record.recording.content.h
    public final MmRecordingUITab getTabType() {
        return MmRecordingUITab.SUBTITLE;
    }
}
