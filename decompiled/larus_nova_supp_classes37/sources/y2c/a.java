package y2c;

import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import s5c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void a(d r1) {
        Intrinsics.checkNotNullParameter(r1, "extras");
        Statistics.sendEvent("im_thread_detail_click", r1.toJson());
    }
}
