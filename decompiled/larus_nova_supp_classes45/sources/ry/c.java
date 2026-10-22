package ry;

import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface c {

    public static class a {
        public final int a;
        public final HashMap<String, String> b;

        public a(int r2) {
            this.b = new HashMap();
            this.a = r2;
        }
    }

    void onEvent(a r1);
}
