package com.bytedance.android.live.effect.sticker;

import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import gd0.v;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k {
    public static boolean i;
    public static int j;
    public static final a k = null;
    public Disposable a;
    public List<Long> b;
    public final ArrayList<Effect> c;
    public final HashMap<String, Effect> d;
    public int e;
    public final b f;
    public final long g;
    public final String h;

    public static final class a {
        public a() {
        }

        public static boolean a() {
            if (LiveEffectSettings.LIVE_ENABLE_MULTI_ANCHOR_EFFECT_SHARE.getValue().booleanValue() == true) goto L5;
        L7:
            return false;
        L5:
            if (k.i == false) goto L7;
            return true;
        }

        public static String b() {
            int r0 = k.j;
            if (r0 > 0) goto L7;
            return "0";
        L7:
            if (v.a(r0, 4) == false) goto L9;
            return "pk";
        L9:
            if (v.a(k.j, 16) == true) goto L15;
            return "multi";
        L15:
            return "pk";
        }
    }

    public interface b {
        void a(List<? extends Effect> r1);
    }

    static {
        k = new a();
    }

    public final void a() {
        int r0 = this.e + 1;
        this.e = r0;
        List<Long> r1 = this.b;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r0 == r1.size()) goto L7;
        return;
    L7:
        if (i == true) goto L9;
        return;
    L9:
        this.c.clear();
        List<Long> r2 = this.b;
        if (r2 == null) goto L18;
        List<Long> r3 = r2;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r5 = r3.iterator();
    L13:
        if (r5.hasNext() == false) goto L15;
        long r6 = ((Number) r5.next()).longValue();
        r4.add(this.d.get(String.valueOf(r6)));
        goto L13
    L15:
        List r7 = CollectionsKt.filterNotNull(r4);
        if (r7 == null) goto L18;
        this.c.addAll(r7);
    L18:
        this.f.a(this.c);
    }

    public k(com.bytedance.android.live.effect.beauty.sticker.e r2, long r3, String r5) {
        Intrinsics.checkNotNullParameter(r2, "mOnMultiAnchorEffectLoadListener");
        Intrinsics.checkNotNullParameter(r5, "anchorId");
        this.f = r2;
        this.g = r3;
        this.h = r5;
        this.c = new ArrayList();
        this.d = new HashMap();
    }
}
