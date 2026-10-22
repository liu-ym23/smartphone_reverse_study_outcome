package com.ss.android.lark.officesdk.minutes.assembly.recording.common;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.b {
    public c() {
    }

    @Override // com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.b
    public final void A(com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.e r2, Fragment r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "from");
    }

    @Override // com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.b
    public final void R1(com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media.e r2, FragmentActivity r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "from");
    }
}
