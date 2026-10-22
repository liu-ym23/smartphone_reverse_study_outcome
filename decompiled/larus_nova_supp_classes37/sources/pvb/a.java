package pvb;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingCreateMode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import iub.j;
import iub.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a a;
    public final String b;

    public a(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r2) {
        Intrinsics.checkNotNullParameter(r2, "userComponentContext");
        this.a = r2;
        this.b = "MmRecordingPreChecker";
    }

    public final boolean a(k r6, iub.a<j, ? super MmRecordingError> r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "callback");
        if (r6.f != MmRecordingCreateMode.OFFLINE_LOCAL) goto L7;
        lvb.a.e(this.b, "[preCheck] skip rtcService check in offline mode");
        return true;
    L7:
        if (this.a.P() != null) goto L10;
        lvb.a.b(this.b, "[preCheck] rtcService is null");
        qvb.a r8 = qvb.a.a;
        MmRecordingError.RtcServiceNotAvailable r0 = MmRecordingError.RtcServiceNotAvailable.INSTANCE;
        r8.d(Integer.valueOf(r0.getErrorCode()), "rtc_service_not_available", r0.getErrorMsg(), "error");
        r7.a(r0);
        return false;
    L10:
        return true;
    }
}
