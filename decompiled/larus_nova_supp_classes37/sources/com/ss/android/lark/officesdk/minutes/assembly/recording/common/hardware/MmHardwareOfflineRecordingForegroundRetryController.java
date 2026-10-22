package com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.thread.MMCoroutines;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import yub.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmHardwareOfflineRecordingForegroundRetryController {
    public final hub.a a;
    public final MmHardwareCallRecordingFloatController b;
    public final CoroutineScope c;
    public final String d;
    public final Map<String, yub.a.b> e;
    public final Map<String, Long> f;

    public static final class a {
    }

    static {
    }

    public final void b(String r8) {
        Intrinsics.checkNotNullParameter(r8, "recordingId");
        if (StringsKt.isBlank(r8) == false) goto L5;
        return;
    L5:
        CoroutineScope r1 = this.c;
        Lazy r0 = MMCoroutines.a;
        BuildersKt.launch$default(r1, Dispatchers.getMain().getImmediate(), null, new MmHardwareOfflineRecordingForegroundRetryController$unregister$1(this, r8, null), 2, null);
    }

    public MmHardwareOfflineRecordingForegroundRetryController(hub.a r2, MmHardwareCallRecordingFloatController r3, CoroutineScope r4) {
        Intrinsics.checkNotNullParameter(r2, "capacity");
        Intrinsics.checkNotNullParameter(r3, "floatController");
        Intrinsics.checkNotNullParameter(r4, "scope");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = "MmHardwareOfflineRecordingForegroundRetryController_" + hashCode();
        this.e = new LinkedHashMap();
        this.f = new LinkedHashMap();
    }

    public static final void a(MmHardwareOfflineRecordingForegroundRetryController r7, String r8, yub.a.b r9, String r10) {
        if (((LinkedHashMap) r7.e).get(r8) != r9) goto L19;
        d r11 = d.a;
        if (com.ss.android.lark.appcontext.applifecycle2.api.a.b() == true) goto L8;
        lvb.a.e(r7.d, "[retryWhenForeground] wait, trigger=" + r10 + ", recordingId=" + r8);
        return;
    L8:
        long r1 = System.currentTimeMillis();
        Long r12 = (Long) ((LinkedHashMap) r7.f).get(r8);
        if (r12 == null) goto L11;
        long r3 = r12.longValue();
    L13:
        if ((r1 - r3) >= 10000) goto L15;
        lvb.a.e(r7.d, "[retryWhenForeground] skip by interval, trigger=" + r10 + ", recordingId=" + r8);
        return;
    L15:
        r7.f.put(r8, Long.valueOf(r1));
        lvb.a.e(r7.d, "[retryWhenForeground] foreground confirmed, trigger=" + r10 + ", recordingId=" + r8);
        lvb.a.e(r7.d, "[retryCreateRecording] trigger=" + r10 + ", recordingId=" + r8);
        r7.a.ud(r8, null, new b(r7, r10, r8));
        return;
    L11:
        r3 = 0;
        goto L13
    }
}
