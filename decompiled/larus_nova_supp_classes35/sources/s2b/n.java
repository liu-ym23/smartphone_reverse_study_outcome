package s2b;

import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n {
    public RecyclerView a;
    public d b;
    public h c;
    public c d;

    public static final class a {
        public g2b.c a;
        public int b;
        public int c;
        public boolean d;
        public float e;
        public b f;
        public boolean g;
        public int h;

        public a() {
            this.a = null;
            this.b = 48;
            this.c = 0;
            this.d = false;
            this.e = 2.1474836E9f;
            this.g = false;
            this.h = -1;
        }
    }

    public interface b {
        void a();
    }

    public static class c {
        public final g2b.c a;
        public final int b;
        public final int c;
        public final boolean d;
        public final float e;
        public final b f;
        public final boolean g;
        public final int h;

        public c(a r2) {
            this.a = r2.a;
            this.b = r2.b;
            this.c = r2.c;
            this.d = r2.d;
            this.e = r2.e;
            this.f = r2.f;
            this.g = r2.g;
            this.h = r2.h;
        }
    }

    public interface d {
        int a();
    }

    public n() {
        this.b = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.Runnable, s2b.h] */
    public final void a(final c r12) {
        Log.d("MessageListScroller", "scroll called");
        final RecyclerView r1 = this.a;
        final b r4 = r12.f;
        if (r1 != 0) goto L8;
        Log.i("MessageListScroller", "scroll before attachToRecycleView");
        this.d = r12;
        if (r4 == null) goto L27;
        r4.a();
        return;
    L27:
        return;
    L8:
        h r0 = this.c;
        if (r0 == null) goto L11;
        r1.removeCallbacks(r0);
    L11:
        final g2b.c r5 = r12.a;
        final int r9 = r12.b;
        int r2 = r12.c;
        if (r9 == 80) goto L20;
        float r3 = r12.e;
        if (r3 != 2.1474836E9f) goto L21;
        d r6 = this.b;
        if (r6 == null) goto L19;
        r3 = r6.a();
        goto L21
    L19:
        final float r8 = 0.0f;
    L22:
        final boolean r7 = r12.d;
        ?? r10 = new h(r1, r4, r5, r12, r7, r8, r9);
        this.c = r10;
        if (r2 <= 0) goto L25;
        r1.postDelayed(r10, r2);
        return;
    L25:
        r10.run();
        return;
    L21:
        r8 = r3;
        goto L22
    L20:
        r3 = Math.min(r12.e, 0.0f);
        goto L21
    }

    public final void b(int r3, boolean r4) {
        a r0 = new a();
        r0.b = 80;
        r0.c = r3;
        r0.d = r4;
        r0.g = true;
        r0.f = null;
        a(new c(r0));
    }
}
