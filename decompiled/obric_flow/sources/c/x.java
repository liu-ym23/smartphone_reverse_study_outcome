package c;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static w f1089a;

    public static SharedPreferences a(Context r5) {
        return r5.getSharedPreferences("n_cards", 0);
    }

    public static void b(Context r5, String r10, mt.u r11) {
        m.i("GaodePoiNetHelper", "queryPlaceInfo placeName=" + r10);
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        HashMap<String, String> r12 = new HashMap();
        String r13 = "";
        if (TextUtils.isEmpty("") == false) goto L8;
        r13 = "03ffe426cb04d29ca26db1f753606210";
    L8:
        r12.put(STGroup.DICT_KEY, r13);
        r12.put("extensions", "all");
        r12.put("output", "json");
        r12.put("offset", "3");
        r12.put("keywords", r10);
        monitor-enter(x.class);
    L13:
        th = move-exception;
        throw th;
    L11:
        if (f1089a != null) goto L15;
        f1089a = (w) j0.a(r5, "https://restapi.amap.com/v3/").create(w.class);     // Catch: Throwable -> L13
    L15:
        w r14 = f1089a;     // Catch: Throwable -> L13
        monitor-exit(x.class);
        j0.b(r14.a(r12), r11);
    }

    public static boolean c(Context r5, String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L7;
        return false;
    L7:
        return a(r5).getBoolean(r10, true);
    }
}
