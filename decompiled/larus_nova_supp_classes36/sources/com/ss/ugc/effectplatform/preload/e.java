package com.ss.ugc.effectplatform.preload;

import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.util.s;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e {
    public final long a;
    public long b;
    public final List<String> c;
    public c0.b d;
    public final EffectConfig e;
    public final String f;

    public final void a() {
        long r0 = b0.a.a() - this.a;
        Logger r2 = Logger.INSTANCE;
        StringBuilder r3 = new StringBuilder("[预加载][下载][全部][Mob][");
        r3.append(this.f);
        r3.append("][");
        Object[] r4 = ((ArrayList) this.c).toArray(new String[0]);
        if (r4 == null) goto L13;
        r3.append(s.a((String[]) r4));
        r3.append("][耗时:");
        r3.append(r0);
        r3.append("][大小:");
        r3.append(this.b);
        r3.append(']');
        r2.w("JKL", r3.toString());
        klc.a r5 = (klc.a) this.e.v.a;
        if (r5 == null) goto L11;
        String r6 = this.f;
        Object[] r7 = ((ArrayList) this.c).toArray(new String[0]);
        if (r7 == null) goto L10;
        r5.monitorStatusRate("resource_provider_preload", 0, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("busi_key", r6), TuplesKt.to("resource_key_list", s.a((String[]) r7)), TuplesKt.to("load_time", Long.valueOf(r0)), TuplesKt.to("size", Long.valueOf(this.b))}));
        return;
    L10:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    L11:
        return;
    L13:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public e(EffectConfig r1, String r2) {
        this.e = r1;
        this.f = r2;
        this.a = b0.a.a();
        this.c = new ArrayList();
    }
}
