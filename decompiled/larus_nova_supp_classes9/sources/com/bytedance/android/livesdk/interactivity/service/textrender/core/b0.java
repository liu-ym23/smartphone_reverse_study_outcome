package com.bytedance.android.livesdk.interactivity.service.textrender.core;

import android.text.SpannableString;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b0 {
    public final SpannableString a;
    public final List<b> b;

    public b0(SpannableString r2, List<b> r3) {
        Intrinsics.checkNotNullParameter(r2, "spannable");
        Intrinsics.checkNotNullParameter(r3, "asyncInfos");
        this.a = r2;
        this.b = r3;
    }
}
