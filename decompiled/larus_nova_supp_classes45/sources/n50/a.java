package n50;

import android.opengl.Matrix;
import com.bytedance.android.live.core.gl.camera.BaseCamera;
import com.bytedance.android.live.core.gl.primitive.e;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k50.f;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class a {
    public final ArrayList<m50.b> a;
    public f b;
    public final Map<String, List<Integer>> c;
    public final b d;

    /* JADX INFO: renamed from: n50.a$a, reason: collision with other inner class name */
    public static final class C0250a {
    }

    static {
    }

    public a() {
        this(new b());
    }

    public final void b() {
        ArrayList<m50.b> r0 = this.a;
        monitor-enter(r0);
        this.a.clear();     // Catch: Throwable -> L8
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r0);
        ((LinkedHashMap) this.c).clear();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public a(b r2) {
        Intrinsics.checkNotNullParameter(r2, "sceneParams");
        this.d = r2;
        this.a = new ArrayList();
        this.c = new LinkedHashMap();
    }

    public final void a(r50.b r3) {
        Intrinsics.checkNotNullParameter(r3, "model");
        ArrayList<m50.b> r0 = this.a;
        monitor-enter(r0);
        this.a.add(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void c(f r15) {
        Intrinsics.checkNotNullParameter(r15, "rendererParams");
        BaseCamera r0 = this.d.a;
        int r2 = 0;
        Matrix.setIdentityM(r0.c, 0);
        float[] r3 = r0.c;
        e r1 = r0.d;
        float r5 = r1.a;
        float r6 = r1.b;
        float r7 = r1.c;
        e r4 = r0.e;
        float r8 = r4.a;
        float r9 = r4.b;
        float r11 = r4.c;
        e r12 = r0.f;
        Matrix.setLookAtM(r3, 0, r5, r6, r7, r8, r9, r11, r12.a, r12.b, r12.c);
        ArrayList<m50.b> r13 = this.a;
        monitor-enter(r13);
        int r14 = this.a.size();     // Catch: Throwable -> L10
    L5:
        if (r2 >= r14) goto L7;
        this.a.get(r2).a(r15, this.d);     // Catch: Throwable -> L10
        r2 = r2 + 1;     // Catch: Throwable -> L10
        goto L5
    L7:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r13);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void e(r50.b r3) {
        Intrinsics.checkNotNullParameter(r3, "model");
        ArrayList<m50.b> r0 = this.a;
        monitor-enter(r0);
        this.a.remove(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void d(f r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "rendererParams");
        BaseCamera r7 = this.d.a;
        int[] r0 = r7.a;
        r0[0] = 0;
        r0[1] = 0;
        r0[2] = r5;
        r0[3] = r6;
        r7.a();
    }
}
