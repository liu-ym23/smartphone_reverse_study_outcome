package com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.thread.MMCoroutines;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmHardwareCallRecordingFloatController {
    public final hub.a a;
    public final tub.a b;
    public final CoroutineScope c;
    public final String d;

    public final void a(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "recordingId");
        Intrinsics.checkNotNullParameter(r8, "trigger");
        if (StringsKt.isBlank(r7) == false) goto L6;
        lvb.a.h(this.d, "[tryShow] skip blank recordingId, trigger=" + r8);
        return;
    L6:
        CoroutineScope r0 = this.c;
        Lazy r1 = MMCoroutines.a;
        BuildersKt.launch$default(r0, Dispatchers.getMain().getImmediate(), null, new MmHardwareCallRecordingFloatController$tryShow$1(this, r8, r7, null), 2, null);
    }

    public MmHardwareCallRecordingFloatController(hub.a r2, tub.a r3, CoroutineScope r4) {
        Intrinsics.checkNotNullParameter(r2, "capacity");
        Intrinsics.checkNotNullParameter(r3, "priorityCapacity");
        Intrinsics.checkNotNullParameter(r4, "scope");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = "MmHardwareCallRecordingFloatController_" + hashCode();
    }
}
