package k32;

import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.android.livesdk.utils.t;
import com.bytedance.bdlocation.BuildConfig;
import java.util.Map;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class a {
    public String a;
    public String b;
    public final String c;
    public k d;
    public k e;
    public String f;
    public String g;
    public int h;
    public int i;
    public int j;
    public va.a k;
    public t.b l;
    public k m;
    public long n;
    public long o;
    public long p;
    public long q;
    public boolean r;
    public Map<String, String> s;

    public a(String r2, String r3, String r4) {
        this(r2, r3, r4, BuildConfig.FLAVOR);
    }

    public a(String r5, String r6, String r7, String r8) {
        this.n = 0;
        this.o = 0;
        this.p = 40000;
        this.q = 0;
        this.r = false;
        this.s = null;
        this.a = r5;
        this.b = r6;
        this.c = r7;
        this.f = r8;
    }
}
