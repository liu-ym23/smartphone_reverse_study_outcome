package ne0;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.j1;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveMemLeakConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tf0.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class e implements c {
    public final DataCenter a;
    public g b;
    public b c;
    public f d;
    public boolean e;
    public e f;
    public Map<String, c> g;

    public static final class a {
    }

    static {
    }

    public abstract void f();

    @Override // ne0.c
    public final void onDestory() {
        this.e = true;
        Map<String, c> r1 = this.g;
        if (r1 == null) goto L5;
        ((HashMap) r1).clear();
    L5:
        b r2 = this.c;
        if (r2 == null) goto L11;
        if ((true ^ r2.a.isEmpty()) == false) goto L11;
        r2.a.clear();
    L11:
        if (((LiveMemLeakConfig) j1.a.getValue()).getFixInteractStore() == false) goto L14;
        this.a.lifecycleOwner = null;
        return;
    }

    @Override // ne0.c
    public final g a() {
        return this.b;
    }

    public e(LifecycleOwner r2) {
        this.c = new b();
        this.d = new f(this);
        DataCenter r0 = new DataCenter();
        this.a = r0;
        r0.lifecycleOwner = r2;
        f();
        this.b = new g(this);
    }

    @Override // ne0.c
    public final void c(e r1) {
        this.f = r1;
    }

    @Override // ne0.c
    public final e e(p r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        b r1 = this.c;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNullParameter(r3, "action");
        r1.a.remove(r3);
    L5:
        return this;
    }

    @Override // ne0.c
    public final void b(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.a.put(r2, r3);
    }

    @Override // ne0.c
    public final e d(p r4, ne0.a r5) {
        Intrinsics.checkNotNullParameter(r4, "action");
        Intrinsics.checkNotNullParameter(r5, "effect");
        b r2 = this.c;
        if (r2 == null) goto L5;
        Intrinsics.checkNotNullParameter(r4, "action");
        Intrinsics.checkNotNullParameter(r5, "effect");
        r2.a.put(r4, r5);
    L5:
        return this;
    }

    @Override // ne0.c
    public final void d0(p r7, Object r8) {
        Intrinsics.checkNotNullParameter(r7, "action");
        if (this.e == false) goto L5;
        return;
    L5:
        f r1 = this.d;
        if (r1 == null) goto L27;
        Intrinsics.checkNotNullParameter(r7, "action");
        ALogger.d("Live_Redux_Action", "effect action is <" + r7.a);
        e r0 = r1.a;
        b r2 = r0.c;
        if (r2 == null) goto L14;
        Intrinsics.checkNotNullParameter(r0, "store");
        if ((!r2.a.isEmpty()) == false) goto L14;
        ne0.a r3 = r2.a.get(r7);
        if (r3 == null) goto L14;
        ALogger.i("EffectCollect", "do action has effect action:" + r7);
        r3.a(r0, r8);
    L14:
        e r4 = r1.a;
        if (r4.e == true) goto L35;
        Map<String, c> r5 = r4.g;
        if (r5 != null) goto L20;
        return;
    L20:
        if ((!((HashMap) r5).isEmpty()) != true) goto L34;
        Map<String, c> r6 = r4.g;
        Intrinsics.checkNotNull(r6);
        Iterator r9 = ((HashMap) r6).values().iterator();
    L23:
        if (r9.hasNext() == false) goto L36;
        c r10 = (c) r9.next();
        if (r10 == null) goto L23;
        r10.d0(r7, r8);
        goto L23
    L36:
        return;
    L34:
        return;
    L35:
        return;
    }
}
