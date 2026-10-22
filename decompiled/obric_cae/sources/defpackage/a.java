package defpackage;

import android.content.IntentFilter;
import com.obric.cae.log.CaeLog;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import pe.x;
import qe.b;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a {
    public static float a(float r8, float r10, float r11, float r12) {
        return ((r8 - r10) * r11) + r12;
    }

    public static int b(String r8, int r10, int r11) {
        return (r8.hashCode() + r10) * r11;
    }

    public static IntentFilter c(String r8, String r10) {
        IntentFilter r11 = new IntentFilter();
        r11.addAction(r8);
        r11.addAction(r10);
        return r11;
    }

    public static String d(String r8, int r10) {
        return r8 + r10;
    }

    public static String e(String r8, String r10) {
        return r8 + r10;
    }

    public static String f(String r8, String r10, String r11) {
        return r8 + r10 + r11;
    }

    public static StringBuilder g(String r8, int r10, String r11, int r12, String r13) {
        StringBuilder r14 = new StringBuilder(r8);
        r14.append(r10);
        r14.append(r11);
        r14.append(r12);
        r14.append(r13);
        return r14;
    }

    public static /* synthetic */ Iterator h() {
        return Arrays.asList(new x[]{new b()}).iterator();
    L5:
        th = move-exception;
        throw new ServiceConfigurationError(th.getMessage(), th);
    }

    public static void i(String r8, int r10, String r11) {
        CaeLog.i(r11, r8 + r10);
    }

    public static void j(StringBuilder r8, int r10, String r11) {
        r8.append(r10);
        CaeLog.d(r11, r8.toString());
    }

    public static void k(JSONException r8, StringBuilder r10, String r11) {
        r10.append(r8.getMessage());
        QesdkUtils.LOG.e(r11, r10.toString());
    }

    public static /* synthetic */ boolean l(AtomicReference r8, Integer r10, Integer r11) {
    L3:
        if (r8.compareAndSet(r10, r11) == true) goto L4;
        if (r8.get() == r10) goto L3;
        return false;
    L4:
        return true;
    }
}
