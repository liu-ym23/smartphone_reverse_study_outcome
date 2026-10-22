package bx1;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final List<String> a = null;
    public static final List<String> b = null;
    public static final List<String> c = null;

    static {
        a = new ArrayList(CollectionsKt.listOf(new String[]{"homepage_follow", "push", "drawer_follow", "moment", "homepage_moment", "drawer_moment", "homepage_follow_ecom", "homepage_ecom_follow"}));
        b = new ArrayList(Arrays.asList(new String[]{"homepage_fresh", "drawer_city", "city", "drawer_fresh"}));
        c = new ArrayList(Arrays.asList(new String[]{"goods", "drawer_goods"}));
    }

    public static boolean a(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
    L7:
        return false;
    L5:
        if (CollectionsKt.contains(b, r1) == false) goto L7;
        return true;
    }

    public static boolean b(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
    L7:
        return false;
    L5:
        if (CollectionsKt.contains(a, r1) == false) goto L7;
        return true;
    }
}
