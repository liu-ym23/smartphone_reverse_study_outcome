package rn0;

import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import com.bytedance.android.live.multilink.layoutconfig.resource.producer.ProducerResStep;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import pn0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements rn0.a {
    public final List<pn0.a> a;
    public final List<pn0.a> b;
    public final HashMap<String, LayoutConfigModel> c;
    public final HashMap<String, HashMap<String, String>> d;
    public final HashMap<String, String> e;
    public final HashMap<String, LayoutConfigModel> f;
    public final ln0.b g;

    public static final class a {
    }

    static {
    }

    @Override // rn0.a
    public final String a() {
        return this.g.a;
    }

    @Override // rn0.a
    public final String b() {
        return this.g.b;
    }

    @Override // rn0.a
    public final nn0.b c() {
        return this.g.d;
    }

    @Override // rn0.a
    public final pn0.b d() {
        return this.g.c;
    }

    public b(ln0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "layoutCoreConfig");
        this.g = r2;
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = new HashMap();
    }

    public final void e(pn0.d r2, LayoutConfigModel r3, LayoutConfigModel r4, g r5, ProducerResStep r6, on0.a r7) {
        this.g.d.c().d(r2, r5, r3, r4);
        r7.a(r2, new pn0.e(r3, r6));
    }
}
