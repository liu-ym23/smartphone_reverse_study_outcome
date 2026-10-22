package yhc;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b {
    public static e a;

    public static class a implements e {
        public a() {
        }

        @Override // yhc.e
        public final void onEvent(String r1, JSONObject r2) {
        }
    }

    static {
        a = new a();
    }

    public static void a(String r1, JSONObject r2) {
        a.onEvent(r1, r2);
    }
}
