package gta;

import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.common.applog.l0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class a implements Runnable {
    public final /* synthetic */ b a;

    public final void a() {
        String r0 = this.a.a.getSharedPreferences(kta.b.a, 0).getString("key_task_session", "");
        if (TextUtils.isEmpty(r0) == false) goto L14;
    L9:
        g r4 = null;
    L10:
        if (r4 == null) goto L12;
        this.a.b(r4);
    L12:
        this.a.a();
        return;
    L14:
        JSONObject r1 = new JSONObject(r0);     // Catch: JSONException -> L7
        String r2 = r1.optString("session_id", "");     // Catch: JSONException -> L7
        r4 = new g();     // Catch: JSONException -> L7
        r4.b = r2;     // Catch: JSONException -> L7
        r4.a = l0.b(r1, "start_time");     // Catch: JSONException -> L7
        r4.c = r1.optBoolean("is_front_continuous", false);     // Catch: JSONException -> L7
        r4.d = r1.optString("front_session_id", "");     // Catch: JSONException -> L7
        r4.e = r1.optBoolean("is_end_continuous", false);     // Catch: JSONException -> L7
        r4.f = r1.optString("end_session_id", "");     // Catch: JSONException -> L7
        r4.g = l0.b(r1, "latest_end_time");     // Catch: JSONException -> L7
        r4.h = l0.b(r1, "non_task_time");     // Catch: JSONException -> L7
        r4.i = l0.b(r1, "tea_event_index");     // Catch: JSONException -> L7
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(b r1) {
        this.a = r1;
    }
}
