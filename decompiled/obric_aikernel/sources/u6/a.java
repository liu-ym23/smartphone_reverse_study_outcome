package u6;

import android.text.TextUtils;
import com.bytedance.apm.d;
import com.monitor.cloudmessage.utils.NetworkUtils;
import e0.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import w6.b;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    static {
        new ArrayList();
    }

    private static boolean a(w6.a r10) {
        if (r10.g() == false) goto L6;
        return false;
    L6:
        if (r10.q() == true) goto L11;
        if ((System.currentTimeMillis() - r10.d()) >= 0) goto L11;
        return false;
    L11:
        if (NetworkUtils.k(k6.a.k().i()) == true) goto L13;
        return false;
    L13:
        return true;
    }

    private static String b(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return "";
    L6:
        int r11 = r10.lastIndexOf(".");
        if (r11 != (-1)) goto L11;
        return r10 + "-cloudMsg.zip";
    L11:
        return r10.substring(0, r11) + "-cloudMsg.zip";
    }

    public static void c(w6.a r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.j() != null) goto L6;
        return;
    L6:
        if (r10.j().a().size() != 0) goto L9;
        return;
    L9:
        if (a(r10) == true) goto L12;
        return;
    L12:
        if (r10.m() == true) goto L14;
        r10.u(r10.j().a());
    L15:
        boolean r11 = x6.a.e(r10);
        if (r10.n() == false) goto L31;
        if (r11 == false) goto L32;
        Iterator<String> r12 = r10.j().a().iterator();
    L20:
        if (r12.hasNext() == false) goto L34;
        File r13 = new File(r12.next());
        if (r13.exists() == false) goto L20;
        r13.delete();
        goto L20
    L34:
        return;
    L32:
        return;
    L31:
        return;
    L14:
        e(r10);
        goto L15
    }

    public static void d(b r10) {
        if (d.D() == false) goto L5;
        e.b("cloudmessage", new String[]{"uploadInfo=" + r10});
    L5:
        if (r10 != null) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r10.b()) == true) goto L12;
        x6.a.c(r10);
        return;
    }

    private static void e(w6.a r10) {
        if (r10.j().a().size() != 1) goto L5;
    L14:
        File r11 = new File(r10.j().a().get(0));
        File r12 = new File(r11.getParent(), b(r11.getName()));
        if (r12.exists() == false) goto L17;
        r12.delete();
    L17:
        com.monitor.cloudmessage.utils.b.b(r12.getAbsolutePath(), (String[]) r10.j().a().toArray(new String[r10.j().a().size()]));
        ArrayList r13 = new ArrayList(1);
        r13.add(r12.getAbsolutePath());
    L18:
        r10.u(r13);
        return;
    L5:
        if (r10.p() == true) goto L14;
        r13 = new ArrayList();
        Iterator<String> r14 = r10.j().a().iterator();
    L9:
        if (r14.hasNext() == false) goto L18;
        String r15 = r14.next();
        File r16 = new File(r15);
        File r17 = new File(r16.getParent(), b(r16.getName()));
        if (r17.exists() == false) goto L13;
        r17.delete();
    L13:
        com.monitor.cloudmessage.utils.b.b(r17.getAbsolutePath(), new String[]{r15});
        r13.add(r17.getAbsolutePath());
        goto L9
    }
}
