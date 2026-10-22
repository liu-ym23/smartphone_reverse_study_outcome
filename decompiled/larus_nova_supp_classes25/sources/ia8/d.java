package ia8;

import android.app.Application;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.common.apphost.AppHost;
import com.larus.utils.j0;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(long r2) {
        Calendar r0 = Calendar.getInstance();
        r0.setTimeInMillis(r2);
        StringCompanionObject r3 = StringCompanionObject.INSTANCE;
        return String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(r0.get(5))}, 1));
    }

    public static String b(long r7) {
        Calendar r0 = Calendar.getInstance();
        r0.setTimeInMillis(r7);
        Calendar r8 = Calendar.getInstance();
        Application r9 = AppHost.a.getApplication();
        if (r0.get(1) == r8.get(1)) goto L5;
    L8:
        Calendar r2 = Calendar.getInstance();
        r2.add(6, -1);
        if (r0.get(1) == r2.get(1)) goto L11;
    L14:
        String r3 = r9.getString(2131902995);
        String r4 = r9.getString(2131902993);
        String r10 = r9.getString(2131902992);
        if (r0.get(1) == r8.get(1)) goto L19;
        return new SimpleDateFormat("yyyy" + r3 + "MM" + r4 + "dd" + r10, Locale.CHINESE).format(r0.getTime());
    L19:
        return new SimpleDateFormat("MM" + r4 + "dd" + r10, Locale.CHINESE).format(r0.getTime());
    L11:
        if (r0.get(6) != r2.get(6)) goto L14;
        return r9.getString(2131902996);
    L5:
        if (r0.get(6) != r8.get(6)) goto L8;
        return r9.getString(2131902994);
    }

    public static String c(long r3) {
        if (r3 != 0) goto L6;
        return "";
    L6:
        Calendar r0 = Calendar.getInstance();
        r0.setTimeInMillis(r3);
        return new SimpleDateFormat("HH:mm", Locale.getDefault()).format(r0.getTime());
    }

    public static String d(long r7) {
        Calendar r0 = Calendar.getInstance();
        r0.setTimeInMillis(r7);
        Calendar r8 = Calendar.getInstance();
        if (r0.get(1) == r8.get(1)) goto L5;
    L7:
        boolean r9 = false;
    L8:
        Integer[] r2 = {2131907420, 2131907417, 2131907422, 2131907423, 2131907421, 2131907416, 2131907419};
        int r1 = r0.get(7) - 1;
        int r10 = j0.a;
        if (r1 >= 0) goto L11;
        Integer r11 = r2[0];
    L12:
        String r12 = j0.d(r11.intValue());
        if (r9 == true) goto L15;
        return r12;
    L15:
        return "今日 " + r12;
    L11:
        r11 = r2[r1];
        goto L12
    L5:
        if (r0.get(6) != r8.get(6)) goto L7;
        r9 = true;
        goto L8
    }

    public static String e(long r2) {
        Calendar r0 = Calendar.getInstance();
        r0.setTimeInMillis(r2);
        int r3 = r0.get(1);
        int r1 = r0.get(2) + 1;
        StringBuilder r4 = new StringBuilder();
        r4.append(r3);
        r4.append(24180);
        r4.append(r1);
        r4.append(26376);
        return r4.toString();
    }

    public static boolean f(String r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        long r1 = CastLongProtector.parseLong(r5);
        Calendar r6 = Calendar.getInstance();
        r6.setTimeInMillis(r1);
        Calendar r2 = Calendar.getInstance();
        if (r6.get(1) == r2.get(1)) goto L8;
        return false;
    L8:
        if (r6.get(6) != r2.get(6)) goto L12;
        return true;
    L12:
        return false;
    }
}
