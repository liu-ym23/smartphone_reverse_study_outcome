package com.ss.android.lark.officesdk.minutes.service.foundation.feature;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.feature.MmOfficeSdkFeature;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmRecordingSource.values().length];
            r0[MmRecordingSource.DOUBAO_PERSONAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[MmRecordingSource.DOUBAO_ENTERPRISE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[MmRecordingSource.FEISHU_DOUBAO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public static boolean a(com.ss.android.lark.officesdk.minutes.service.foundation.feature.a r1) {
        Intrinsics.checkNotNullParameter(r1, "featureService");
        Intrinsics.checkNotNullParameter(r1, "featureService");
        if (r1.h(MmOfficeSdkFeature.RecordingNoAiNotes) == false) goto L5;
    L7:
        return false;
    L5:
        if (r1.h(MmOfficeSdkFeature.RecordingPersonalNotesEnable) == false) goto L7;
        return true;
    }

    public static boolean b(com.ss.android.lark.officesdk.minutes.service.foundation.feature.a r1) {
        Intrinsics.checkNotNullParameter(r1, "featureService");
        if (a(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.h(MmOfficeSdkFeature.RecordingPersonalNotesMarkTranscript) == false) goto L7;
        return true;
    }
}
