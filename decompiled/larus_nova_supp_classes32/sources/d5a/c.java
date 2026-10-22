package d5a;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.lynx.base.memory.MemoryPressureCallback;
import com.lynx.clay.embedding.engine.memory.MemoryPressureListener;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public static final c h = null;
    public final int a;
    public int b;
    public Integer c;
    public boolean d;
    public boolean e;
    public final b f;
    public final a g;

    public class a implements ComponentCallbacks2 {
        public final /* synthetic */ c a;

        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration r1) {
        }

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
            c r0 = this.a;
            r0.getClass();
            Object r1 = com.lynx.clay.util.a.a;
            if (r0.d == false) goto L5;
            r0.c = 2;
            return;
        L5:
            r0.a(2);
        }

        public a(c r1) {
            this.a = r1;
        }

        @Override // android.content.ComponentCallbacks2
        public final void onTrimMemory(int r3) {
            if (r3 < 80) goto L5;
        L11:
            Integer r4 = 2;
        L12:
            if (r4 == null) goto L18;
            c r0 = this.a;
            int r5 = r4.intValue();
            r0.getClass();
            Object r1 = com.lynx.clay.util.a.a;
            if (r0.d == false) goto L16;
            r0.c = Integer.valueOf(r5);
            return;
        L16:
            r0.a(r5);
            return;
        L18:
            return;
        L5:
            if (r3 == 15) goto L11;
            if (r3 < 40) goto L10;
            r4 = 1;
            goto L12
        L10:
            r4 = null;
            goto L12
        }
    }

    static {
        h = new c();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [d5a.b] */
    public c() {
        this.b = 0;
        this.f = new b(this);
        this.g = new a(this);
        this.a = 60000;
        this.d = false;
    }

    public final void a(int r5) {
        com.lynx.clay.util.a.a().postDelayed(this.f, this.a);
        this.d = true;
        this.b = r5;
        ArrayList<MemoryPressureCallback> r0 = MemoryPressureListener.a;
        if (r0 == null) goto L9;
        Iterator<MemoryPressureCallback> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        r1.next().onPressure(r5);
        goto L7
    L11:
        return;
    }
}
