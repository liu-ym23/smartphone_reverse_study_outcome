package com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.style;

import android.content.Context;
import android.util.AttributeSet;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.p000float.MmFloatView;
import com.ss.android.lark.officesdk.minutes.ui.style.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements gwb.b {
    public a() {
    }

    @Override // gwb.b
    public final MmFloatView a(Context r6, final hwb.b r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "params");
        MmRecordingSession r0 = r7.b.b(r7.a);
        AttributeSet r4 = null;
        MmFloatView r1 = new MmFloatView(c.c(r6, r7.c), r4, 6, 0);
        if (r0 == null) goto L5;
        r1.U5(r0);
    L5:
        r1.setOnCloseWindow(new MmRecordingFloatDefaultContentFactory$createContent$1$1(r7));
        return r1;
    }
}
