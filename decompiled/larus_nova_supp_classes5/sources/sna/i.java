package sna;

import android.content.Context;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class i {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final boolean a() {
        Context r0 = f.a;
        Intrinsics.checkNotNullParameter("wakeup_truth_capture_enabled", "key");
        c r2 = f.b();
        r2.getClass();
        Intrinsics.checkNotNullParameter("wakeup_truth_capture_enabled", "key");
        return r2.a().getBoolean("wakeup_truth_capture_enabled", false);
    }
}
