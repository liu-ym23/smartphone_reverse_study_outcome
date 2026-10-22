package sh0;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j0 {
    public static i0 a;

    static {
    }

    public static i0 a(DataCenter r1) {
        if (r1 != null) goto L6;
        return a;
    L6:
        return (i0) r1.get("data_multi_link_talkroom_store");
    }

    public static void b(DataCenter r2) {
        a = null;
        i0 r1 = a(r2);
        if (r1 == null) goto L5;
        r1.onDestory();
    L5:
        if (r2 == null) goto L8;
        r2.put("data_multi_link_talkroom_store", null);
        return;
    }

    @JvmStatic
    public static final i0 e(DataCenter r0) {
        return a(r0);
    }

    public static i0 c(DataCenter r1, LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "lifecycle");
        i0 r0 = a(r1);
        if (r0 != null) goto L7;
        r0 = new i0(r2);
        if (r1 == null) goto L7;
        r1.put("data_multi_link_talkroom_store", r0);
    L7:
        a = r0;
        return r0;
    }

    public static Object d(DataCenter r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        i0 r3 = a(r1);
        if (r3 == null) goto L7;
        ne0.g r4 = r3.b;
        if (r4 == null) goto L7;
        return r4.a(r2);
    L7:
        return null;
    }

    public static void f(DataCenter r1, String r2, Observer r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        i0 r4 = a(r1);
        if (r4 == null) goto L8;
        ne0.g r5 = r4.b;
        if (r5 == null) goto L9;
        r5.b(r2, r3);
        return;
    L9:
        return;
    }
}
