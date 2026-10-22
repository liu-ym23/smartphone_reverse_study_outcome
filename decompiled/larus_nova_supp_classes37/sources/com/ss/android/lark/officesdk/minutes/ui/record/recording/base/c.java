package com.ss.android.lark.officesdk.minutes.ui.record.recording.base;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.MmAudioSaveType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.MmRecordingAutoSaveDecisionScene;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public boolean a;
    public boolean b;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmRecordingAutoSaveDecisionScene.values().length];
            r0[MmRecordingAutoSaveDecisionScene.TOKEN_READY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MmRecordingAutoSaveDecisionScene.RECORD_FINISH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public c() {
    }

    public static MmRecordingAutoSaveDialogReason b(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.d r2) {
        if (r2 == null) goto L4;
        String r0 = r2.a();
    L6:
        if (Intrinsics.areEqual(r0, "WINDOW_LIMITED") == false) goto L8;
        String r3 = r2.b();
        if (Intrinsics.areEqual(r3, "5h") == false) goto L13;
        return MmRecordingAutoSaveDialogReason.WindowLimited5H;
    L13:
        if (Intrinsics.areEqual(r3, "7d") == false) goto L16;
        return MmRecordingAutoSaveDialogReason.WindowLimited7D;
    L16:
        return MmRecordingAutoSaveDialogReason.NoQuota;
    L8:
        return MmRecordingAutoSaveDialogReason.NoQuota;
    L4:
        r0 = null;
        goto L6
    }

    public final com.ss.android.lark.officesdk.minutes.ui.record.recording.base.b a(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.g r4) {
        Intrinsics.checkNotNullParameter(r4, "decision");
        MmRecordingAutoSaveDecisionScene r0 = r4.a;
        if (r0 != null) goto L5;
        int r1 = -1;
    L6:
        if (r1 != (-1)) goto L8;
    L28:
        return null;
    L8:
        if (r1 == 1) goto L20;
        if (r1 != 2) goto L18;
        if (this.b == true) goto L28;
        if (r4.b == false) goto L28;
        this.b = true;
        return new com.ss.android.lark.officesdk.minutes.ui.record.recording.base.b(MmRecordingAutoSaveDecisionScene.RECORD_FINISH, b(r4.e));
    L18:
        throw new NoWhenBranchMatchedException();
    L20:
        if (this.a == true) goto L28;
        if (r4.b == false) goto L28;
        if (r4.c != MmAudioSaveType.SAVE.getValue()) goto L28;
        this.a = true;
        return new com.ss.android.lark.officesdk.minutes.ui.record.recording.base.b(MmRecordingAutoSaveDecisionScene.TOKEN_READY, b(r4.e));
    L5:
        r1 = b.a[r0.ordinal()];
        goto L6
    }
}
