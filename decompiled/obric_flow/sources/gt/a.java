package gt;

import com.ss.android.agilelogger.utils.FormatUtils$TYPE;
import ct.b;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f17226a = null;

    static {
        ConcurrentHashMap r5 = new ConcurrentHashMap();
        f17226a = r5;
        FormatUtils$TYPE r10 = FormatUtils$TYPE.MSG;
        at.a r11 = new at.a(0);
        new Date();
        r5.put(r10, r11);
        r5.put(FormatUtils$TYPE.JSON, new at.a(1));
        r5.put(FormatUtils$TYPE.BUNDLE, new ct.a());
        r5.put(FormatUtils$TYPE.INTENT, new b());
        r5.put(FormatUtils$TYPE.BORDER, new at.a(5));
        r5.put(FormatUtils$TYPE.STACKTRACE, new at.a(3));
        r5.put(FormatUtils$TYPE.THREAD, new at.a(4));
        r5.put(FormatUtils$TYPE.THROWABLE, new at.a(2));
    }

    public static String a(FormatUtils$TYPE r5, String r10) {
        ys.a r11 = (ys.a) f17226a.get(r5);
        if (r11 != null) goto L5;
        return r10;
    L5:
        if (r5 != FormatUtils$TYPE.BORDER) goto L9;
        return r11.a(new String[]{r10});
    L9:
        return r11.a(r10);
    }
}
