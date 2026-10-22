package com.ss.android.lark.officesdk.minutes.ui.style.provider;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class k implements com.ss.android.lark.officesdk.minutes.ui.style.contract.c {
    public k() {
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.c
    public final boolean a() {
        return true;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.c
    public final void b(com.ss.android.lark.officesdk.minutes.ui.style.contract.i r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.c
    public final void c() {
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.c
    public final void d() {
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.c
    public final boolean e() {
        return true;
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.style.contract.c
    public final boolean f(com.ss.android.lark.officesdk.minutes.ui.style.contract.i r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (r3.c != MmRecordingSource.FEISHU_DOUBAO) goto L5;
    L7:
        return false;
    L5:
        if (r3.b == true) goto L7;
        return true;
    }
}
