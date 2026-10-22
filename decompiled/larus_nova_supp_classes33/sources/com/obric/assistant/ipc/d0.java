package com.obric.assistant.ipc;

import com.bytedance.keva.Keva;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d0 {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(new c0());
    }

    public static String b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "uid");
        if (StringsKt.isBlank(r2) == false) goto L5;
        return "";
    L5:
        String r3 = ((Keva) a.getValue()).getString(c(r2), "");
        if (r3 != null) goto L9;
        return "";
    L9:
        return r3;
    }

    public static String c(String r2) {
        return "register_data_id_" + r2;
    }

    public static void a(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "uid");
        Intrinsics.checkNotNullParameter(r5, WindowEvent.Params.REASON);
        if (StringsKt.isBlank(r4) == false) goto L5;
        return;
    L5:
        ((Keva) a.getValue()).erase(c(r4));
        FLogger.a.i("WakeupTruthUploadRegisterDataStore", "clear register_data_id uid=" + StringsKt.padStart(StringsKt.takeLast(r4, 4), RangesKt.coerceAtMost(r4.length(), 4), '*') + " reason=" + r5);
    }
}
