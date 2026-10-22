package u22;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.interactivity.api.comment.event.OpenInputSource;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m {
    public final int a;
    public final String b;
    public final boolean c;
    public boolean d;
    public a e;
    public String f;
    public long g;
    public int h;
    public final long i;
    public IBaseUser j;
    public long k;
    public OpenInputSource l;
    public int m;
    public long n;

    public static class a {
        public final String a;
        public final int b;
        public final boolean c;
        public final String d;
        public String e;
        public final long f;
        public final Map<String, String> g;
        public final Map<String, String> h;
        public final String i;
        public IBaseUser j;
        public boolean k;
        public boolean l;

        public final void a(String r2, String r3) {
            ((HashMap) this.h).put(r2, r3);
        }

        public a(String r3, boolean r4, String r5, int r6, String r7, long r8, String r10) {
            this.f = 0;
            this.g = new HashMap();
            this.h = new HashMap();
            this.l = false;
            this.c = r4;
            this.a = r3;
            this.d = r5;
            this.b = r6;
            this.e = r7;
            this.f = r8;
            this.i = r10;
        }
    }

    public m() {
        this.a = 0;
        this.g = -1;
        this.h = 2;
        this.k = 0;
        this.l = OpenInputSource.Unknow;
        this.m = 0;
        this.n = 0;
        this.i = System.currentTimeMillis();
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public int getType() {
        return this.a;
    }

    public m(String r2) {
        this();
        this.a = 1;
        this.b = r2;
    }

    public m(int r1, boolean r2, OpenInputSource r3) {
        this();
        this.a = r1;
        this.c = r2;
        this.l = r3;
    }
}
