package j1c;

import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.log.Log;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import l1c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c extends g1c.a<String> implements i1c.a {
    public static final HashMap<String, Biz> d = null;

    public static final class a {
    }

    @Override // g1c.b
    public final boolean isValid() {
        return true;
    }

    static {
        Biz r1 = Biz.Messenger;
        Biz r2 = Biz.Docs;
        Biz r3 = Biz.VideoConference;
        Biz r4 = Biz.Todo;
        d = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("conversation", r1), TuplesKt.to("group", r1), TuplesKt.to("pin", r1), TuplesKt.to("calendar", Biz.Calendar), TuplesKt.to("appCenter", Biz.OpenPlatform), TuplesKt.to("space", r2), TuplesKt.to("wiki", r2), TuplesKt.to("contact", Biz.UserGrowth), TuplesKt.to("mail", Biz.Mail), TuplesKt.to("videochat", r3), TuplesKt.to("videomm", r3), TuplesKt.to("moments", Biz.Moments), TuplesKt.to("todo", r4), TuplesKt.to("pano", r4), TuplesKt.to("more", Biz.Core)});
    }

    public c() {
        super("");
    }

    @Override // g1c.b
    public final Class<k1c.b<String>> b() {
        return d.class;
    }

    @Override // g1c.a, g1c.b
    public final void e(o1c.c<?, ?> r4) {
        Intrinsics.checkNotNullParameter(r4, "task");
        Intrinsics.checkNotNullParameter(r4, "task");
        Biz r0 = d.get(this.c);
        if (r4.getBiz() != r0) goto L5;
        r4.setPriority(r4.getPriority() + 50);
    L5:
        Log.d("PrimaryTab", "checkCondition, task is " + r4.getClass().getSimpleName() + ", biz is " + r0);
    }
}
