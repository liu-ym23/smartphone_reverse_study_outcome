package i8a;

import com.lynx.tasm.LynxView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j {
    public final String a;
    public final WeakReference<LynxView> b;
    public final boolean c;
    public final int d;
    public final boolean e;
    public final int f;
    public final long g;
    public final long h;

    public static class a {
        public long a;
        public long b;
        public boolean c;
        public String d;
        public int e;
        public int f;
        public LynxView g;
        public boolean h;

        public a() {
            this.a = 0;
            this.b = 0;
            this.c = false;
            this.d = null;
            this.e = 0;
            this.f = 0;
            this.g = null;
            this.h = false;
        }
    }

    public j(a r3) {
        this.g = r3.a;
        this.h = r3.b;
        this.c = r3.c;
        this.a = r3.d;
        this.f = r3.e;
        this.d = r3.f;
        this.b = new WeakReference(r3.g);
        this.e = r3.h;
    }
}
