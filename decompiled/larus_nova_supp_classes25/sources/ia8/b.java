package ia8;

import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.larus.platform.service.i2;
import com.larus.utils.j0;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b {
    public static final String a = null;
    public static final Map<String, String> b = null;

    static {
        if (Build.VERSION.SDK_INT > 29) goto L5;
        String r0 = "android.permission.WRITE_EXTERNAL_STORAGE";
    L6:
        a = r0;
        LinkedHashMap r1 = new LinkedHashMap();
        int r2 = j0.a;
        r1.put("android.permission.WRITE_EXTERNAL_STORAGE", j0.d(2131902129));
        b = r1;
        return;
    L5:
        r0 = null;
        goto L6
    }

    public static boolean a(Context r3) {
        boolean r0 = false;
        if (r3 != null) goto L5;
        return false;
    L5:
        String r1 = a;
        if (r1 != null) goto L8;
        return true;
    L8:
        if (ContextCompat.checkSelfPermission(r3, r1) != 0) goto L11;
        r0 = true;
    L11:
        return r0;
    }

    public static void b(Fragment r3, final Function1 r4) {
        String r0 = a;
        if (r0 == null) goto L5;
        i2.b.b(r3, CollectionsKt.listOf(r0), new a(r4), b);
        return;
    L5:
        r4.invoke(Boolean.TRUE);
    }
}
