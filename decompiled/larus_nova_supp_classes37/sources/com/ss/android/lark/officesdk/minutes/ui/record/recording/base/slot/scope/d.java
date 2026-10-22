package com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.scope;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingFragment;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public final a a;
    public final LifecycleOwner b;
    public final ViewModelStoreOwner c;
    public final Function0<MmRecordingSession> d;
    public final hub.a e;
    public final b f;

    public d(MmRecordingFragment r2, MmRecordingFragment r3, MmRecordingFragment r4, MmRecordingFragment r5, Function0 r6, hub.a r7, c r8) {
        Intrinsics.checkNotNullParameter(r2, "page");
        Intrinsics.checkNotNullParameter(r3, "state");
        Intrinsics.checkNotNullParameter(r4, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r5, "viewModelStoreOwner");
        Intrinsics.checkNotNullParameter(r6, "sessionProvider");
        Intrinsics.checkNotNullParameter(r8, "ui");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
    }
}
