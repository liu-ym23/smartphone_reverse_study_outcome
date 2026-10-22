package x11;

import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import kotlin.jvm.internal.Reflection;
import y11.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements b, o {
    public static com.bytedance.android.livesdk.revenue.service.room.c a;

    public static final class a {
    }

    static {
    }

    public c() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public static x11.a a() {
        o41.a r0 = (o41.a) f.d(j.C0.a(), o41.a.class);
        if (r0 == null) goto L7;
        o11.b r1 = r0.a;
        if (r1 == null) goto L7;
        m.e.getClass();
        return (x11.a) m.b(r1).a(Reflection.getOrCreateKotlinClass(x11.a.class));
    L7:
        return null;
    }

    @Override // x11.b
    public final y11.c V0() {
        x11.a r0 = a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPkService();
    }

    @Override // x11.b
    public final y11.a Yk() {
        x11.a r0 = a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mo1159do();
    }

    @Override // x11.b
    public final e Ym() {
        x11.a r0 = a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.G9();
    }
}
