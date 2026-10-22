package lg;

import com.bytedance.android.ec.base.api.ai.AIStateLogRequest;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class f extends lg.a {
    public final String a;

    public static final class a {
    }

    static {
    }

    public final String getType() {
        return this.a;
    }

    public f(String r10, e r11) {
        Intrinsics.checkNotNullParameter("mall_live_room", AIStateLogRequest.SOURCE_PAGE);
        Intrinsics.checkNotNullParameter(r10, "type");
        Intrinsics.checkNotNullParameter(r11, "param");
        this.a = r10;
    }
}
