package com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.style;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.ui.style.e;
import gwb.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements f {
    public final MmRecordingUILaunchMode a;
    public final long b;

    public static final class a {
    }

    static {
    }

    @Override // gwb.f
    public final hwb.a b() {
        e r0 = e.a;
        MmRecordingUILaunchMode r1 = this.a;
        r0.getClass();
        e.b(r1).getLayout().g();
        return new hwb.a(2131564090);
    }

    @Override // gwb.f
    public final long a() {
        return this.b;
    }

    public b(MmRecordingUILaunchMode r3) {
        Intrinsics.checkNotNullParameter(r3, "uiLaunchMode");
        this.a = r3;
        this.b = 3000;
    }
}
