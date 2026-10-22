package com.bytedance.android.live.effect.beauty.newtemp;

import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.j;
import com.bytedance.android.live.effect.beauty.smallitem.q;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public static final /* synthetic */ int d = 0;
    public final Map<String, List<Sticker>> a;
    public final Map<String, List<Effect>> b;
    public final LiveEffectContextFactoryDelegate$Type c;

    public static final class a {
    }

    static {
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.c;
    }

    public c(LiveEffectContextFactoryDelegate$Type r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.c = r2;
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
    }

    public static void a(c r3, LiveEffectContextFactoryDelegate$Type r4, WeakReference r5) {
        r3.getClass();
        Intrinsics.checkNotNullParameter("inspiration_beautification", "panel");
        Intrinsics.checkNotNullParameter(r4, "type");
        List<String> r0 = LiveEffectContext.h;
        j r6 = LiveEffectContext.a.a(r4).b();
        List r1 = (List) ((LinkedHashMap) r3.a).get("inspiration_beautification");
        if (r1 != null) goto L5;
    L11:
        r6.d().f("inspiration_beautification", new f(r3, r6, r5));
        return;
    L5:
        if ((!r1.isEmpty()) != true) goto L11;
        List<Sticker> r7 = (List) ((LinkedHashMap) r3.a).get("inspiration_beautification");
        if (r7 == null) goto L13;
        q r8 = (q) r5.get();
        if (r8 == null) goto L14;
        r8.a(r7, null);
        return;
    L14:
        return;
    }
}
