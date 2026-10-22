package bp;

import android.content.Intent;
import android.os.Bundle;
import com.lynx.tasm.behavior.ui.utils.p;
import com.obric.android.agilelogger.utils.FormatUtils$TYPE;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f966a = null;

    static {
        ConcurrentHashMap r5 = new ConcurrentHashMap();
        f966a = r5;
        FormatUtils$TYPE r10 = FormatUtils$TYPE.MSG;
        ap.a r11 = new ap.a(2);
        new Date();
        r5.put(r10, r11);
        r5.put(FormatUtils$TYPE.JSON, new ap.a(3));
        r5.put(FormatUtils$TYPE.BUNDLE, new xo.a());
        r5.put(FormatUtils$TYPE.INTENT, new xo.b());
        r5.put(FormatUtils$TYPE.BORDER, new ap.a(1));
        r5.put(FormatUtils$TYPE.STACKTRACE, new ap.a(5));
        r5.put(FormatUtils$TYPE.THREAD, new ap.a(0));
        r5.put(FormatUtils$TYPE.THROWABLE, new ap.a(4));
    }

    public static String a(FormatUtils$TYPE r5, Intent r10) {
        ((xo.b) ((to.a) f966a.get(r5))).getClass();
        return xo.b.b(r10);
    }

    public static String b(FormatUtils$TYPE r5, Bundle r10) {
        ((xo.a) ((to.a) f966a.get(r5))).getClass();
        return p.q(r10);
    }

    public static String c(FormatUtils$TYPE r5, String r10) {
        to.a r11 = (to.a) f966a.get(r5);
        if (r11 != null) goto L5;
        return r10;
    L5:
        if (r5 != FormatUtils$TYPE.BORDER) goto L9;
        return r11.a(new String[]{r10});
    L9:
        return r11.a(r10);
    }
}
