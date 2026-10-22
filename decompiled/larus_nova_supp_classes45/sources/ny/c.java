package ny;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public static final /* synthetic */ int d = 0;
    public int a;
    public int b;
    public String c;

    public static final class a {
        public static c a(JsonObject r3) {
            c r0 = new c();
            int r1 = 0;
            if (r3 == null) goto L7;
            JsonElement r2 = r3.get("width");
            if (r2 == null) goto L7;
            int r4 = r2.getAsInt();
        L8:
            r0.a = r4;
            if (r3 == null) goto L13;
            JsonElement r5 = r3.get("height");
            if (r5 == null) goto L13;
            r1 = r5.getAsInt();
        L13:
            r0.b = r1;
            if (r3 == null) goto L18;
            JsonElement r6 = r3.get("backgroundColor");
            if (r6 == null) goto L18;
            String r7 = r6.getAsString();
        L19:
            r0.c = r7;
            return r0;
        L18:
            r7 = null;
        L7:
            r4 = 0;
            goto L8
        }
    }

    static {
    }

    public c() {
    }

    public final String toString() {
        return "Canvas(width=" + this.a + ", height=" + this.b + ", backgroundColor=" + this.c + ')';
    }
}
