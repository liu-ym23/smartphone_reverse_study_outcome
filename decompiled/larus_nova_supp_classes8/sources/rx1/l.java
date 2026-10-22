package rx1;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l {
    public static final Map<String, b> a = null;
    public static final String b = null;

    public static class a {
        public final Context a;
        public View b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l;
        public int m;
        public boolean n;
        public long o;
        public TimeInterpolator p;
        public String q;
        public boolean r;
        public e s;
        public boolean t;
        public boolean u;
        public final String v;
        public final int w;

        public final void a() {
            Map<String, b> r0 = l.a;
            HashMap r2 = (HashMap) r0;
            if (r2.containsKey(this.q) == false) goto L6;
            Logger.e("LiveFloatWindowManager", "Float window has been added!");
            return;
        L6:
            View r1 = this.b;
            if (r1 != null) goto L10;
            Logger.e("LiveFloatWindowManager", "view can not be null!");
            return;
        L10:
            if (r1 != null) goto L12;
            this.b = ((LayoutInflater) this.a.getSystemService("layout_inflater")).inflate(0, null);
        L12:
            g r3 = new g(this);
            HashMap r4 = (HashMap) r0;
            r4.put(this.q, r3);
        }

        public a(Context r3) {
            this.c = -2;
            this.d = -2;
            this.e = 3;
            this.n = true;
            this.o = 300;
            this.q = l.b;
            this.t = false;
            this.v = "";
            this.w = -1;
            this.a = r3;
        }
    }

    static {
        a = new HashMap();
        b = "live_default_window";
    }

    public static b a(String r1) {
        if (StringUtils.isEmpty(r1) == false) goto L7;
        return null;
    L7:
        return (b) ((HashMap) a).get(r1);
    }
}
