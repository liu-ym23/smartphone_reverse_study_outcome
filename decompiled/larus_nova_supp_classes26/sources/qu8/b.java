package qu8;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.ugc.perf.impl.c;
import com.larus.ugc.perf.impl.g;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public static String a;
    public static final Map<String, Boolean> b = null;

    static {
        a = "";
        b = new LinkedHashMap();
    }

    @JvmStatic
    public static final void a(ConstraintLayout r2, String r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r3.length() != 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L10;
        return;
    L10:
        if (Intrinsics.areEqual(((LinkedHashMap) b).get(r3), Boolean.TRUE) == false) goto L12;
        return;
    L12:
        a r1 = new a(r2, r3);
        r2.getViewTreeObserver().addOnPreDrawListener(r1);
        return;
    L6:
        r0 = false;
        goto L7
    }

    @JvmStatic
    public static final void c(long r3, String... r5) {
        Intrinsics.checkNotNullParameter(r5, "scenes");
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        d(r5[r1], r3);
        r1 = r1 + 1;
        goto L3
    }

    @JvmStatic
    public static final void d(String r5, long r6) {
        Intrinsics.checkNotNullParameter(r5, "scene");
        c.a.getClass();
        if (c.b(r5) != null) goto L5;
        return;
    L5:
        g r0 = c.b(r5);
        if (r0 != null) goto L8;
        return;
    L8:
        if (r6 != 0) goto L10;
        r0.d("success", "1");
    L11:
        c.e(r5);
        JSONObject r7 = r0.c();
        c.f(r0.a, r7);
        return;
    L10:
        r0.d("success", TriggerSendLoading.NO_LOADING);
        r0.d("err_code", String.valueOf(r6));
        goto L11
    }

    @JvmStatic
    public static final void b(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "value");
        c.c(r2, new String[]{r3, r4});
    }

    @JvmStatic
    public static final void e(String r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "scene");
        Intrinsics.checkNotNullParameter(r5, "parentScene");
        if (Intrinsics.areEqual(r4, r5) == true) goto L7;
        c.a.getClass();
        if (c.b(r5) != null) goto L7;
        return;
    L7:
        g r1 = new g("ugc_core_segment_report");
        r1.d("trace_id", a);
        r1.d("scene", r4);
        r1.d("parent_scene", r5);
        c.a.getClass();
        c.d(r4, r1);
        if (r6 == false) goto L11;
        b.put(r4, Boolean.FALSE);
        return;
    }
}
