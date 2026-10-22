package com.ss.android.lark.officesdk.minutes.ui.record.notification;

import bwb.b;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.RecordingSessionType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.notification.MmRecordingNotificationRepo;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmDoubaoRecordingNotificationProcessor implements ewb.a {
    public final a a;
    public Job b;

    @Override // ewb.a
    public final void clearAll() {
        Job r0 = this.b;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.b = null;
        a r1 = this.a;
        r1.getClass();
        int r2 = b.a;
        b.g(MmUiLogScene.NOTIFICATION, "clearAll", "brand=doubao, size=" + r1.a.size(), null, 8);
        ((LinkedHashMap) r1.a).clear();
    }

    public MmDoubaoRecordingNotificationProcessor() {
        this.a = new a();
    }

    @Override // ewb.a
    public final void a(ewb.b r8, MmRecordingNotificationRepo r9, RecordingSessionType r10, CoroutineScope r11) {
        Intrinsics.checkNotNullParameter(r8, "host");
        Intrinsics.checkNotNullParameter(r9, "notificationRepo");
        Intrinsics.checkNotNullParameter(r10, "sessionType");
        Intrinsics.checkNotNullParameter(r11, "scope");
        Job r12 = this.b;
        if (r12 == null) goto L5;
        Job.DefaultImpls.cancel$default(r12, null, 1, null);
    L5:
        this.b = BuildersKt.launch$default(r11, null, null, new MmDoubaoRecordingNotificationProcessor$start$1(r9, this, null), 3, null);
    }
}
