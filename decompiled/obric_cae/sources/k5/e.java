package k5;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import x4.r;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static boolean a(Context r8) {
        NetworkInfo r10 = ((ConnectivityManager) r8.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r10 == null) goto L12;
        if (r10.isAvailable() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    public static ArrayList b(Map r8) {
        ArrayList r10 = new ArrayList();
        if (r8 != null) goto L5;
    L17:
        return r10;
    L5:
        if (r8.isEmpty() == true) goto L17;
        Iterator r11 = r8.entrySet().iterator();
    L8:
        if (r11.hasNext() == false) goto L16;
        Map.Entry r12 = (Map.Entry) r11.next();
        int r13 = 0;
    L11:
        if (r13 >= ((List) r12.getValue()).size()) goto L8;
        if (TextUtils.isEmpty((CharSequence) r12.getKey()) == true) goto L15;
        r10.add(new Pair(r12.getKey(), ((List) r12.getValue()).get(r13)));
    L15:
        r13 = r13 + 1;
        goto L11
    L16:
        r10.toString();
        int r14 = r.f13543a;
        goto L17
    }
}
