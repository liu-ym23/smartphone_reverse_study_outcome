package as9;

import android.content.Context;
import android.os.Looper;
import android.util.Pair;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public abstract class a {
    public InterfaceC0000a a;
    public final Context b;
    public float c;
    public int d;
    public final List<Pair<Float, Float>> e;

    /* JADX INFO: renamed from: as9.a$a, reason: collision with other inner class name */
    public interface InterfaceC0000a {
        void onStatusGenerate(int r1, float r2);
    }

    public abstract boolean a();

    public abstract int c();

    public abstract void e();

    public final synchronized void f() {
        monitor-enter(this);
        this.a = null;     // Catch: Throwable -> L7
        e();     // Catch: Throwable -> L7
        toString();     // Catch: Throwable -> L7
        boolean r0 = bs9.a.a;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public float b() {
        return this.c;
    }

    public final synchronized boolean g(c.b r1) {
        monitor-enter(this);
        this.a = r1;     // Catch: Throwable -> L6
        boolean r2 = a();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r2;
    L6:
        th = move-exception;
        throw th;
    }

    public a(Context r2, Looper r3) {
        this.c = -99.0f;
        this.d = -1;
        this.e = new ArrayList();
        this.b = r2;
        if (r3 != null) goto L6;
        r2.getMainLooper();
        return;
    }

    public final int d(float r5, boolean r6) {
        int r0 = ((ArrayList) this.e).size();
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L18;
        Pair r3 = (Pair) ListProtector.get(this.e, r1);
        if (r3 == null) goto L16;
        if (r6 == false) goto L8;
        Object r4 = r3.first;
    L10:
        if (r5 < ((Float) r4).floatValue()) goto L18;
        if (r6 == false) goto L13;
    L15:
        r2 = r1;
        goto L16
    L13:
        if (r1 != this.d) goto L15;
        return r1;
    L8:
        r4 = r3.second;
    L16:
        r1 = r1 + 1;
    L18:
        return r2;
    }
}
