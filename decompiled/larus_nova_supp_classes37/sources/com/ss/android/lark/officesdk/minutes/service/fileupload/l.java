package com.ss.android.lark.officesdk.minutes.service.fileupload;

import android.app.Application;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.MinutesForegroundService;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class l implements d {
    public final /* synthetic */ MmMinutesFileUploadSessionManager a;

    @Override // com.ss.android.lark.officesdk.minutes.service.fileupload.d
    public final void release() {
        MinutesForegroundService.Companion r0 = MinutesForegroundService.h;
        MinutesForegroundService.Companion.j(LarkContext.getApplication(), MinutesForegroundService.ForegroundServiceOwner.FILE_UPLOAD);
    }

    public l(MmMinutesFileUploadSessionManager r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.fileupload.d
    public final void a(MmRecordingSource r10) {
        Intrinsics.checkNotNullParameter(r10, "source");
        Application r1 = LarkContext.getApplication();
        MinutesForegroundService.Companion r11 = MinutesForegroundService.h;
        Intrinsics.checkNotNull(r1);
        MmRecordingSessionManager r2 = this.a.a.A();
        MinutesForegroundService.ForegroundServiceType r3 = MinutesForegroundService.ForegroundServiceType.DATA_SYNC;
        MinutesForegroundService.ForegroundServiceOwner r4 = MinutesForegroundService.ForegroundServiceOwner.FILE_UPLOAD;
        String r5 = r1.getApplicationInfo().loadLabel(r1.getPackageManager()).toString();
        MmMinutesFileUploadSessionManager r12 = this.a;
        r12.getClass();
        int r0 = r1.getResources().getIdentifier("View_MemPopeSCW_SyncingAudioFiles_Desc", "string", r1.getPackageName());
        if (r0 != 0) goto L5;
        lvb.a.h(r12.d, "resolveSyncingAudioFilesText: resource missing");
        String r13 = r1.getApplicationInfo().loadLabel(r1.getPackageManager()).toString();
    L6:
        MinutesForegroundService.Companion.g(r1, r2, r3, r4, r5, r13, MinutesForegroundService.NotificationTarget.D1204_DEVICE, true);
        return;
    L5:
        r13 = r1.getString(r0);
        goto L6
    }
}
