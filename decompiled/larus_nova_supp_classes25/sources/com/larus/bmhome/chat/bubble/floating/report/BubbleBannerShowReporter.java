package com.larus.bmhome.chat.bubble.floating.report;

import com.larus.bmhome.chat.bubble.floating.BubbleBannerSource;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class BubbleBannerShowReporter {
    public static final CoroutineScope a = null;

    static {
        a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    public static void a(sc8.b r10, long r11) {
        String r0 = r10.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        String r2 = r0;
        if (r2 != null) goto L12;
        return;
    L12:
        if (r10.k == BubbleBannerSource.CMD) goto L14;
        return;
    L14:
        BuildersKt.launch$default(a, null, null, new BubbleBannerShowReporter$reportShowInternal$1(r2, r11, r10, null), 3, null);
    }
}
