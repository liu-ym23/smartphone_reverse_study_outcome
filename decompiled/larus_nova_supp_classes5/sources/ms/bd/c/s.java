package ms.bd.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.ArrayList;
import kotlin.jvm.internal.ByteCompanionObject;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class s {
    public static final String c = null;
    public static final String d = null;
    public static final String e = null;
    public static s f;
    public static final String g = null;
    public final SharedPreferences a;
    public ArrayList b;

    static {
        c = (String) p2.a(16777217, 0, 0, "e5c990", new byte[]{59, 52, 17, 93, 18, 36, 110, 21, 125, ByteCompanionObject.MAX_VALUE, 113, 37, 25, 75, 31});
        d = (String) p2.a(16777217, 0, 0, "ad8651", new byte[]{63, 118, 74, 81, 25, 54, 109, 87, 125, 41, 125, 105, 73, 75, 6, 35, 45, 72, 102, 100, 121, 106, 78, 125, 9, 39, 112, 65, 86, 106, ByteCompanionObject.MAX_VALUE, 97, 66, 76, 69});
        e = (String) p2.a(16777217, 0, 0, "83d835", new byte[]{102, 33, 22, 95, 31, 50, 52, 0, 33, 39, 36, 62, 21, 69, 0, 39, 116, 1, 56, 123, 22, 61, 24, 75, 5, 44, 116});
        g = (String) p2.a(16777217, 0, 0, "741fa3", new byte[]{52, 51, 69, 23, 70, 27, 57, 26, 100, 51, 25, 58, 75, 1, 74});
    }

    public s(Context r12) {
        this.b = new ArrayList(10);
        SharedPreferences r13 = PreferenceManager.getDefaultSharedPreferences(r12);
        this.a = r13;
        b(r13.getString((String) p2.a(16777217, 0, 0, "593f0d", new byte[]{54, 62, 71, 23, 23, 76, 59, 23, 102, 51, 27, 55, 73, 1, 27}), ""), false);
        if (this.b.size() >= 1) goto L18;
        Object r14 = p2.a(33554445, 3, 0, null, null);
        Object r2 = p2.a(33554445, 2, 0, null, null);
        Object r3 = p2.a(33554445, 1, 0, null, null);
        if (r14 != null) goto L7;
    L9:
        if (r2 != null) goto L11;
    L13:
        if (r3 != null) goto L15;
        return;
    L15:
        if (((Integer) r3).intValue() != 1) goto L20;
        r r15 = new r((String) p2.a(16777217, 0, 0, "9c7828", new byte[]{103, 113, 69, 95, 30, 63, 53, 80, 114, 39, 37, 110, 70, 69, 1, 42, 117, 81, 107, 123, 23, 109, 75, 75, 4, 33, 117}), (String) p2.a(16777217, 0, 0, "d04d13", new byte[]{102, 43, 73, 19}));
        this.b.add(r15);
        return;
    L20:
        return;
    L11:
        if (((Integer) r2).intValue() != 1) goto L13;
        r r16 = new r((String) p2.a(16777217, 0, 0, "e61670", new byte[]{59, 36, 67, 81, 27, 55, 105, 5, 116, 41, 121, 59, 64, 75, 4, 34, 41, 26, 111, 100, 125, 56, 71, 125, 11, 38, 116, 19, 95, 106, 123, 51, 75, 76, 71}), (String) p2.a(16777217, 0, 0, "3beb37", new byte[]{49, 121, 24, 21}));
        this.b.add(r16);
        goto L13
    L7:
        if (((Integer) r14).intValue() == 0) goto L9;
        r r17 = new r((String) p2.a(16777217, 0, 0, "0a0e5c", new byte[]{110, 96, 66, 1, 30, 119, 59, 65, 46, 35, 36, 113, 74, 23, 19}), (String) p2.a(16777217, 0, 0, "095e8a", new byte[]{50, 34, 72, 18}));
        this.b.add(r17);
        goto L9
    }

    public static synchronized s a(Context r2) {
        monitor-enter(s.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f != null) goto L7;
        f = new s(r2);     // Catch: Throwable -> L10
    L7:
        s r3 = f;     // Catch: Throwable -> L10
        monitor-exit(s.class);
        return r3;
    }

    public final synchronized void b(String r23, boolean r24) {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r23) == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        ArrayList r2 = new ArrayList(20);     // Catch: Throwable -> L23 JSONException -> L28
        JSONObject r3 = new JSONObject(r23);     // Catch: Throwable -> L23 JSONException -> L28
        String r4 = JSONObjectProtectorUtils.getString(r3, (String) p2.a(16777217, 0, 0, "b0e83b", new byte[]{101, 55, 4, 95, 5, 122, 111}));     // Catch: Throwable -> L23 JSONException -> L28
        String r5 = JSONObjectProtectorUtils.getString(r3, (String) p2.a(16777217, 0, 0, "02e611", new byte[]{51, 37, 26, 71, 29}));     // Catch: Throwable -> L23 JSONException -> L28
        if (((String) p2.a(16777217, 0, 0, "abfd97", new byte[]{33})).equals(r4) == false) goto L19;
        if (r5 == null) goto L19;
        String[] r6 = r5.split((String) p2.a(16777217, 0, 0, "34e61f", new byte[]{30, 42}));     // Catch: Throwable -> L23 JSONException -> L28
        int r7 = r6.length;     // Catch: Throwable -> L23 JSONException -> L28
        int r8 = 0;
    L12:
        if (r8 >= r7) goto L19;
        String[] r9 = r6[r8].split((String) p2.a(16777217, 0, 0, "7beba9", new byte[]{124}));     // Catch: Throwable -> L23 JSONException -> L28
        if (r9 == null) goto L18;
        if (r9.length < 2) goto L18;
        r2.add(new r(new String(q.b(r9[0])), r9[1]));     // Catch: Throwable -> L23 JSONException -> L28
    L18:
        r8 = r8 + 1;     // Catch: Throwable -> L23 JSONException -> L28
    L19:
        this.b = r2;     // Catch: Throwable -> L23 JSONException -> L28
        if (r24 == false) goto L26;
        this.a.edit().putString(g, r23).apply();     // Catch: Throwable -> L23 JSONException -> L28
    L26:
        monitor-exit(this);
    }
}
