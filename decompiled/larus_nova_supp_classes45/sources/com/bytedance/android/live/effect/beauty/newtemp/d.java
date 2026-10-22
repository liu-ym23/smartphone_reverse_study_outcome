package com.bytedance.android.live.effect.beauty.newtemp;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.api.k;
import com.bytedance.android.live.effect.base.EffectDataFetchCacheType;
import com.bytedance.android.live.effect.beauty.smallitem.q;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements k.b {
    public final /* synthetic */ com.bytedance.android.live.effect.beauty.newtemp.c a;
    public final /* synthetic */ String b;
    public final /* synthetic */ q c;

    public static final class a<T, R> implements Function {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r2) {
            List r3 = (List) r2;
            Intrinsics.checkNotNullParameter(r3, "list");
            i.a(r3);
            return r3;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ d a;

        public b(d r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            List<Sticker> r4 = (List) r3;
            d r0 = this.a;
            r0.a.a.put(r0.b, r4);
            q r1 = this.a.c;
            if (r1 == null) goto L6;
            r1.a(r4, null);
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ d a;

        public c(d r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
            q r3 = this.a.c;
            if (r3 == null) goto L6;
            r3.onError();
            return;
        }
    }

    @Override // com.bytedance.android.live.effect.api.k.b
    public final void onFetchFailed() {
        q r0 = this.c;
        if (r0 == null) goto L5;
        r0.onError();
    L5:
        ALogger.i("ttlive_inspiration_panel", "on fetchCategoryEffect fail");
    }

    @Override // com.bytedance.android.live.effect.api.k.b
    public final void a(List<? extends Effect> r2, EffectDataFetchCacheType r3) {
        Intrinsics.checkNotNullParameter(r2, "effectList");
        Intrinsics.checkNotNullParameter(r3, "cacheType");
        this.a.b.put(this.b, r2);
        com.bytedance.android.live.effect.sticker.d.e(r2).map(a.a).subscribe(new b(this), new c(this));
    }

    public d(com.bytedance.android.live.effect.beauty.newtemp.c r1, String r2, e r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
