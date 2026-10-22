package f81;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final void a(com.bytedance.android.live.room.api.base.alog.a r2) {
        Intrinsics.checkNotNullParameter(r2, "args");
        Throwable r0 = r2.b;
        if (r0 == null) goto L5;
        ALogger.e("RotateALog", r2.a, r0);
        return;
    L5:
        ALogger.i("RotateALog", r2.a);
        Unit r3 = Unit.INSTANCE;
    }
}
