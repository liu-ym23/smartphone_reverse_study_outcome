package v2;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: v2.a$a, reason: collision with other inner class name */
    public static class C0178a {
    }

    static {
        new C0178a();
    }

    public static String a(String[] r8) {
        StringBuilder r10 = new StringBuilder(400);
        int r11 = r8.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L6;
        r10.append(r8[r12]);
        r12 = r12 + 1;
        goto L3
    L6:
        return r10.toString();
    }

    public static void b(Object... r8) {
        JSONObject r10 = new JSONObject();
        int r11 = r8.length;
        if ((r11 % 2) != 0) goto L13;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L10;
        r10.put(String.valueOf(r8[r12]), String.valueOf(r8[r12 + 1]));     // Catch: JSONException -> L8
        r12 = r12 + 2;
    L8:
        e = move-exception;
        e.printStackTrace();
    L10:
        Log.i("<monitor><flow>", a(new String[]{r10.toString()}));
        return;
    L13:
        throw new IllegalArgumentException();
    }
}
