package kib;

import com.ss.android.lark.forwardv2.dto.ForwardTemplate;
import com.ss.android.lark.statistics.Statistics;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import s5c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static void a() {
            Intrinsics.checkNotNullParameter("confirm", "click");
            Intrinsics.checkNotNullParameter("none", "target");
            Statistics.sendEvent("public_multi_select_share_click", new JSONObject().put("click", "confirm").put("target", "none"));
        }
    }

    static {
    }

    @JvmStatic
    public static final d a(ForwardTemplate r3) {
        Intrinsics.checkNotNullParameter(r3, "forwradTemplate");
        List<String> r4 = r3.f.f;
        if (r4 != null) goto L5;
        r4 = CollectionsKt.emptyList();
    L5:
        d.a r0 = d.o2;
        String r1 = r4.toString();
        r0.getClass();
        s5c.a r2 = new s5c.a("msg_id", r1);
        return d.b.b(new s5c.a("msg_count", String.valueOf(r4.size())), r2);
    }
}
