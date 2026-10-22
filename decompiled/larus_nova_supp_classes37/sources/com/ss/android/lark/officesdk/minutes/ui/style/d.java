package com.ss.android.lark.officesdk.minutes.ui.style;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.style.contract.h;
import java.util.function.BiFunction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d<T, U, R> implements BiFunction {
    public final /* synthetic */ h a;

    public d(h r1) {
        this.a = r1;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object r4, Object r5) {
        h r6 = (h) r5;
        Intrinsics.checkNotNullParameter((MmRecordingUILaunchMode) r4, "<unused var>");
        if (r6 != null) goto L6;
        return this.a;
    L6:
        if (Intrinsics.areEqual(r6.getClass().getName(), this.a.getClass().getName()) == true) goto L10;
        int r7 = bwb.b.a;
        bwb.b.d(MmUiLogScene.STYLE, "register", "duplicate provider, mode=" + this.a.getUiLaunchMode() + ", old=" + r6.getClass().getName() + ", new=" + this.a.getClass().getName(), null);
        return r6;
    L10:
        return r6;
    }
}
