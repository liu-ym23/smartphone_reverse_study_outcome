package com.bytedance.android.live.broadcast.api;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdkapi.announcement.AnnounceSequenceTipConfig;
import com.bytedance.android.livesdkapi.announcement.OpenAnnounceChooseConfig;
import com.bytedance.android.livesdkapi.announcement.OpenAnnounceMoreSettingConfig;
import com.bytedance.android.livesdkapi.announcement.OpenAnnounceRepeatWeekChooseConfig;
import com.bytedance.android.livesdkapi.announcement.OpenAnnounceSettingConfig;
import com.bytedance.android.livesdkapi.announcement.OpenAnnounceSubmitSuccessConfig;
import com.bytedance.android.livesdkapi.announcement.OpenAnnounceTimeChooseConfig;
import com.bytedance.android.livesdkapi.announcement.OpenSharePanelConfig;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ServiceLookup("com.bytedance.android.live.broadcast.BroadcastAnnounceService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0016H&J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\fH&J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\t\u001a\u00020\u001aH&¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/IBroadcastAnnounceService;", "Lcom/bytedance/android/live/base/IService;", "enableAnnounceGroupOpt", "", "fetchAnnouncement", "", "getAnnouncementObserver", "Lio/reactivex/Observable;", "openAnnouncementChooseDialogOpt", "config", "Lcom/bytedance/android/livesdkapi/announcement/OpenAnnounceChooseConfig;", "openAnnouncementCreateDialogOpt", "Lcom/bytedance/android/livesdkapi/announcement/OpenAnnounceSettingConfig;", "openAnnouncementCreateSuccessDialog", "Lcom/bytedance/android/livesdkapi/announcement/OpenAnnounceSubmitSuccessConfig;", "openAnnouncementDateChooseDialog", "Lcom/bytedance/android/livesdkapi/announcement/OpenAnnounceTimeChooseConfig;", "openAnnouncementMoreSettingDialog", "Lcom/bytedance/android/livesdkapi/announcement/OpenAnnounceMoreSettingConfig;", "openAnnouncementRepeatWeekChooseDialog", "Lcom/bytedance/android/livesdkapi/announcement/OpenAnnounceRepeatWeekChooseConfig;", "openAnnouncementSequenceTipDialog", "Lcom/bytedance/android/livesdkapi/announcement/AnnounceSequenceTipConfig;", "openAnnouncementUpdateDialogOpt", "openSharePanel", "Lio/reactivex/disposables/Disposable;", "Lcom/bytedance/android/livesdkapi/announcement/OpenSharePanelConfig;", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IBroadcastAnnounceService extends IService {
    boolean enableAnnounceGroupOpt();

    void fetchAnnouncement();

    Observable<Boolean> getAnnouncementObserver();

    void openAnnouncementChooseDialogOpt(OpenAnnounceChooseConfig r1);

    void openAnnouncementCreateDialogOpt(OpenAnnounceSettingConfig r1);

    void openAnnouncementCreateSuccessDialog(OpenAnnounceSubmitSuccessConfig r1);

    void openAnnouncementDateChooseDialog(OpenAnnounceTimeChooseConfig r1);

    void openAnnouncementMoreSettingDialog(OpenAnnounceMoreSettingConfig r1);

    void openAnnouncementRepeatWeekChooseDialog(OpenAnnounceRepeatWeekChooseConfig r1);

    void openAnnouncementSequenceTipDialog(AnnounceSequenceTipConfig r1);

    void openAnnouncementUpdateDialogOpt(OpenAnnounceSettingConfig r1);

    Disposable openSharePanel(OpenSharePanelConfig r1);
}
