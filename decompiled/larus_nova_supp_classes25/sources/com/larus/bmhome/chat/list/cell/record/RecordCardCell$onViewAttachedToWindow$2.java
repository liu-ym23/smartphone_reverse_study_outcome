package com.larus.bmhome.chat.list.cell.record;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.layout.item.RecordStatus;
import com.larus.bmhome.chat.layout.item.u3;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class RecordCardCell$onViewAttachedToWindow$2 implements p68.c {
    public final /* synthetic */ RecordCardCell a;

    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "meetingId");
    }

    public final void d(int r1, String r2) {
    }

    public final void e(String r1) {
    }

    public RecordCardCell$onViewAttachedToWindow$2(RecordCardCell r1) {
        this.a = r1;
    }

    public final void a(String r7) {
        Intrinsics.checkNotNullParameter(r7, "meetingId");
        Fragment r8 = lf8.a.d(this.a);
        if (r8 == null) goto L8;
        LifecycleCoroutineScope r0 = LifecycleOwnerKt.getLifecycleScope(r8);
        if (r0 == null) goto L9;
        BuildersKt.launch$default(r0, Dispatchers.getMain(), null, new RecordCardCell$onViewAttachedToWindow$2$onRecordingStart$1(this.a, null), 2, null);
        return;
    L9:
        return;
    }

    public final void c(int r9) {
        if (this.a.i.isRecording() == false) goto L16;
        u3 r0 = this.a.e;
        if (r0 == null) goto L7;
        RecordStatus r1 = r0.getRecordStatus();
    L9:
        if (r1 != RecordStatus.RECORDING) goto L17;
        FLogger.a.d("RecordCardBox", "onRecordingDurationUpdate duration:" + r9);
        Fragment r2 = lf8.a.d(this.a);
        if (r2 == null) goto L18;
        LifecycleCoroutineScope r3 = LifecycleOwnerKt.getLifecycleScope(r2);
        if (r3 == null) goto L19;
        BuildersKt.launch$default(r3, Dispatchers.getMain(), null, new RecordCardCell$onViewAttachedToWindow$2$onRecordingDurationUpdate$1(this.a, r9, null), 2, null);
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L7:
        r1 = null;
        goto L9
    }

    public final void f(byte[] r9) {
        if (r9 != null) goto L5;
        return;
    L5:
        if (this.a.i.isRecording() == false) goto L18;
        u3 r0 = this.a.e;
        if (r0 == null) goto L9;
        RecordStatus r1 = r0.getRecordStatus();
    L11:
        if (r1 != RecordStatus.RECORDING) goto L19;
        Fragment r2 = lf8.a.d(this.a);
        if (r2 == null) goto L20;
        LifecycleCoroutineScope r3 = LifecycleOwnerKt.getLifecycleScope(r2);
        if (r3 == null) goto L21;
        BuildersKt.launch$default(r3, Dispatchers.getMain(), null, new RecordCardCell$onViewAttachedToWindow$2$onRecordedData$1(this.a, r9, null), 2, null);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L9:
        r1 = null;
        goto L11
    }
}
