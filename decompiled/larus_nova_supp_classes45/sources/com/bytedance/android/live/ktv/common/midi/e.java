package com.bytedance.android.live.ktv.common.midi;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e {
    public static final d a(View r1, Function0 r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$createFrescoPlayOnceControllerListener");
        Intrinsics.checkNotNullParameter(r2, "onStart");
        return new d(r1, r2);
    }

    public static final void b(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        ALogger.d("midiEnhance_".concat(r1), r2);
    }
}
