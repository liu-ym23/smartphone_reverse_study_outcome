package xq0;

import android.text.format.DateUtils;
import com.bytedance.android.livesdk.sharedpref.b;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    public static boolean a() {
        Long r0 = (Long) b.H3.getValue();
        if ((System.currentTimeMillis() - r0.longValue()) < (((long) 7) * TimeUnit.DAYS.toMillis(1))) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean b() {
        Integer r0 = (Integer) b.G3.getValue();
        Long r1 = (Long) b.F3.getValue();
        if (r0.intValue() < 3) goto L5;
    L7:
        return false;
    L5:
        if (DateUtils.isToday(r1.longValue()) == true) goto L7;
        return true;
    }

    static {
    }
}
