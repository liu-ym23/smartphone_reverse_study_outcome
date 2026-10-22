package com.ss.android.lark.officesdk.minutes.service.foundation.userscope;

import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import com.ss.android.lark.officesdk.minutes.service.fileupload.MmMinutesFileUploadSessionManager;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.MmMockAwareRequestService;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmRecordingNetHelper;
import com.ss.android.lark.officesdk.minutes.service.foundation.utils.user.MmUserInfoHelper;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc.f;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.MmD1204RecordingEventTracker;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.c;
import com.ss.android.lark.officesdk.minutes.service.recording.hardware.i;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import kotlinx.coroutines.CoroutineScope;
import nub.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface a {
    MmRecordingSessionManager A();

    CoroutineScope B();

    fub.a C();

    UserSession D();

    com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.a E();

    MmMinutesFileUploadSessionManager F();

    MmRecordingNetHelper G();

    KVRepo H();

    bvb.a I();

    zub.a J();

    f K();

    i L();

    MmMockAwareRequestService M();

    c N();

    MmUserInfoHelper O();

    b P();

    com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.a Q();

    String getCurrentUserId();

    com.ss.android.lark.officesdk.minutes.service.foundation.feature.a getFeatureService();

    com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.b getSettingsService();

    String getTenantId();

    nub.a t(String r1);

    <T extends IOfficeSDKProtocol> T u(Class<T> r1);

    com.ss.android.lark.officesdk.minutes.service.recording.common.core.orchestrator.b v();

    com.ss.android.lark.officesdk.minutes.service.recording.hardware.live.a w();

    MmD1204RecordingEventTracker x();

    gpb.a y();

    dvb.a z();
}
