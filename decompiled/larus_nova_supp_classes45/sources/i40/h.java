package i40;

import com.bytedance.android.live.core.log.ALogger;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h {
    public static final ArrayList<String> a = null;
    public static final ArrayList<Long> b = null;
    public static final SimpleDateFormat c = null;
    public static String d;

    static {
        a = new ArrayList();
        b = new ArrayList();
        c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA);
    }

    @JvmStatic
    public static final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "info");
        LocalTestManager.a(new Class[]{wy.a.class});
        ALogger.i("LiveKeyboard", r3);
    }

    @JvmStatic
    public static final void b(String r3, Exception r4) {
        Intrinsics.checkNotNullParameter(r3, "msg");
        Intrinsics.checkNotNullParameter(r4, "exception");
        LocalTestManager.a(new Class[]{wy.a.class});
        ALogger.e("LiveKeyboard", r3, r4);
    }

    @JvmStatic
    public static final void c(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "info");
        LocalTestManager.a(new Class[]{wy.a.class});
        ALogger.i("LiveKeyboard", r3);
        if (r4 == false) goto L6;
        a.add(r3);
        b.add(Long.valueOf(System.currentTimeMillis()));
        return;
    }
}
