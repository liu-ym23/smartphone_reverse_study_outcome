package wa1;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface a {
    boolean a();

    void b();

    x60.c.a c();

    void e(String r1);

    void e(String r1, String r2, Throwable r3);

    void e(String r1, Throwable r2);

    void ensureNotReachHere(Throwable r1, String r2);

    Context getContext();

    void i(String r1, String r2);

    void monitorEvent(String r1, JSONObject r2, JSONObject r3, JSONObject r4);
}
