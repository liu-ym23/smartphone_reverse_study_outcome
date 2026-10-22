package hub;

import android.content.Context;
import com.larus.office.minutes.impl.MinutesServiceImpl;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKCapacity;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.EndRecordingReason;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmOfflineRecordingItem;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingTerminateReason;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.route.MmRecordingPageOpenSource;
import com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware.MmHardwareCallRecordingFloatController$tryShow$1;
import iub.j;
import iub.k;
import iub.r;
import iub.s;
import java.util.List;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.i1;
import sub.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface a extends IOfficeSDKCapacity {
    MutableSharedFlow A8();

    b1 Bc();

    StateFlowImpl E2();

    void J2(String r1, EndRecordingReason r2, iub.a<j, ? super MmRecordingError> r3);

    void Ja(String r1, iub.a<j, ? super MmRecordingError> r2);

    void Me(k r1, iub.a r2, b r3);

    void S3(String r1, MmRecordingTerminateReason r2, iub.a<j, ? super MmRecordingError> r3);

    MutableSharedFlow S6();

    void V1();

    void Y0(k r1, MinutesServiceImpl.h r2, b r3);

    boolean Z0();

    Object Zd(String r1, Continuation<? super MmRecordingSource> r2);

    Object bf(String r1, Continuation<? super String> r2);

    boolean isRecording();

    boolean j();

    void l1(String r1, iub.a<j, ? super MmRecordingError> r2);

    void me(Context r1, String r2, MmRecordingUILaunchMode r3, MmHardwareCallRecordingFloatController$tryShow$1.a r4);

    void qd(Context r1, String r2, MmRecordingPageOpenSource r3, iub.a<j, ? super MmRecordingError> r4);

    i1<r> r5();

    Object s2(String r1, Continuation<? super Unit> r2);

    i1<s> sa();

    @Deprecated(message = "Use hasActiveRecordingOrInterpretationSession() instead.", replaceWith = @ReplaceWith(expression = "hasActiveRecordingOrInterpretationSession()", imports = {}))
    boolean t3();

    String u0();

    void ud(String r1, String r2, iub.a<j, ? super MmRecordingError> r3);

    Object x0(Continuation<? super List<MmOfflineRecordingItem>> r1);
}
