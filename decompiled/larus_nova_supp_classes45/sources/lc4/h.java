package lc4;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h {
    public final Map<String, String> a;

    public static class a {
        public int a;
        public final Map<String, String> b;
        public String c;

        public final h a() {
            if (this.c.isEmpty() == true) goto L14;
            if (((HashMap) this.b).containsKey("host") == true) goto L7;
        L12:
            return null;
        L7:
            if (((HashMap) this.b).containsKey("accessKey") == false) goto L12;
            if (TextUtils.isEmpty((CharSequence) ((HashMap) this.b).get("host")) == true) goto L12;
            if (TextUtils.isEmpty((CharSequence) ((HashMap) this.b).get("accessKey")) == true) goto L12;
        L14:
            if (this.c.isEmpty() == true) goto L21;
            int r0 = this.a;
            if (r0 >= 0) goto L18;
        L19:
            return null;
        L18:
            if ((r0 & 15) == 0) goto L19;
        L21:
            return new h(this.b);
        }

        public a() {
            this.a = -1;
            this.b = new HashMap();
            this.c = "";
        }

        public final void b(String r3, String r4) {
            ((HashMap) this.b).put("host", r3);
            ((HashMap) this.b).put("accessKey", r4);
        }
    }

    public h(Map r1) {
        this.a = r1;
    }
}
