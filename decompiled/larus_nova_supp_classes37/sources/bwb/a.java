package bwb;

import android.content.Context;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.route.MmRecordingEntity;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.MmBaseRecordingActivity;
import com.ss.android.lark.officesdk.minutes.ui.style.contract.h;
import com.ss.android.lark.officesdk.minutes.ui.style.e;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public static boolean a(Context r5, MmRecordingEntity r6, UserSession r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "entity");
        Intrinsics.checkNotNullParameter(r7, "userSession");
        MmRecordingUILaunchMode r0 = r6.getUiLaunchMode();
        e.a.getClass();
        h r1 = e.c(r0);
        if (r1 != null) goto L5;
        return false;
    L5:
        String r2 = r1.getActivity().b();
        if (StringsKt.isBlank(r2) == false) goto L18;
        lvb.a.b("MmRecordPageRouter", "[startRecording] activityClassName is blank, ui=" + r0);
        return false;
    L18:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L11
        int r4 = MmBaseRecordingActivity.d;     // Catch: Throwable -> L11
        MmBaseRecordingActivity.a.a(r5, r2, r6, r7);     // Catch: Throwable -> L11
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L17;
        lvb.a.b("MmRecordPageRouter", "[startRecording] ui=" + r0 + ", error=" + r9);
    L17:
        return Result.isSuccess-impl(r8);
    L11:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }
}
