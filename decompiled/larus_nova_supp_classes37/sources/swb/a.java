package swb;

import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final <T> T a(Class<T> r3) {
        T r1 = (T) ClaymoreServiceLoader.loadFirst(r3);
    L7:
        if (r1 != null) goto L9;
        com.ss.android.lark.officesdk.utils.di.j.e("ApiUtil", "getApi service is null,class name: ".concat(r3.getName()));
    L9:
        return r1;
    L5:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.d("ApiUtil", e);
        r1 = null;
        goto L7
    }
}
