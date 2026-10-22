package j4;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.keva.KevaImpl;
import com.obric.cae.location.database.StarLocationDbManager;
import i4.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList f8582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8583b;

    /* JADX INFO: renamed from: j4.a$a, reason: collision with other inner class name */
    public static class C0097a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f8584a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f8585b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f8586c;

        public C0097a(String r8) {
            this.f8584a = r8;
        }

        public C0097a(String r8, String r10, String r11) {
            this.f8584a = r8;
            this.f8585b = r10;
            this.f8586c = r11;
        }
    }

    public a() {
        this.f8582a = new CopyOnWriteArrayList();
        this.f8583b = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
    }

    public final Pair<Map<String, JSONObject>, Long> a(long r12) {
        if (this.f8583b <= 0) goto L5;
        HashMap r8 = new HashMap();
        CopyOnWriteArrayList r11 = this.f8582a;
        Iterator r10 = r11.iterator();
        int r13 = 0;
    L8:
        if (r10.hasNext() == false) goto L26;
        C0097a r14 = (C0097a) r10.next();
        int r15 = r13 + 1;
        String r16 = String.valueOf(r13);
        String r17 = r14.f8585b;
        String r18 = r14.f8586c;
        String r19 = r14.f8584a;
        JSONObject r20 = new JSONObject();
        r20.put("event", "sdk_fatal");     // Catch: Throwable -> L15
        JSONObject r21 = new JSONObject();     // Catch: Throwable -> L15
        r21.put("message", r19);     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r17) == true) goto L13;
        r21.put(StarLocationDbManager.GeofenceCallbackEntry.CLASS_NAME, r17);     // Catch: Throwable -> L15
        r21.put("stack", r18);     // Catch: Throwable -> L15
    L13:
        r20.put("params", r21);     // Catch: Throwable -> L15
        r20.put("local_time_ms", System.currentTimeMillis());     // Catch: Throwable -> L15
        r20.put("event_id", h.f8232b.incrementAndGet());     // Catch: Throwable -> L15
        r20.put("datetime", h.a());     // Catch: Throwable -> L15
    L17:
        r8.put(r16, r20);
        r11.remove(r14);
        String r22 = r14.f8585b;
        if (TextUtils.isEmpty(r22) == false) goto L20;
        int r23 = r19.length() + 43;
    L21:
        r12 = r12 - ((long) r23);
        if (r12 <= 0) goto L26;
        r13 = r15;
        goto L8
    L20:
        int r24 = r19.length() + 65;
        r23 = (r22.length() + r24) + r18.length();
    L15:
        th = move-exception;
        th.printStackTrace();
    L26:
        return new Pair(r8, Long.valueOf(r12));
    L5:
        return new Pair(null, Long.valueOf(r12));
    }
}
