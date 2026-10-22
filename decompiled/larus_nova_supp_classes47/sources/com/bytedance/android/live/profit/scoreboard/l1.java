package com.bytedance.android.live.profit.scoreboard;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l1 implements com.bytedance.android.scope.o {
    public static final d01.b.a e = null;
    public final CompositeDisposable a;
    public final l b;
    public final d01.a c;
    public final yz0.k d;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ l1 a;
        public final /* synthetic */ d01.b b;

        public b(l1 r1, d01.b r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r6) {
            Pair r7 = (Pair) r6;
            jy0.b.d("ScoreboardSeiClient", "write SEI pos: " + r7);
            d01.b r0 = this.b;
            this.a.getClass();
            JSONObject r1 = new JSONObject();
            r1.put("rgn", ((RegionId) r7.getFirst()).getId());
            r1.put("nx", Float.valueOf(j80.a.a(((j80.d) r7.getSecond()).a().floatValue(), 3)));
            r1.put("ny", Float.valueOf(j80.a.a(((j80.d) r7.getSecond()).b().floatValue(), 3)));
            d01.b.a r8 = l1.e;
            Intrinsics.checkNotNullParameter(r0, "$this$setJSONObject");
            Intrinsics.checkNotNullParameter("scoreboard_pos", "key");
            Intrinsics.checkNotNullParameter(r1, "value");
            Intrinsics.checkNotNullParameter(r8, "attributes");
            r0.a("scoreboard_pos", r1, r8);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ l1 a;
        public final /* synthetic */ d01.b b;

        public c(l1 r1, d01.b r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            if (((Boolean) r2).booleanValue() == false) goto L5;
            this.a.b.x().a(this.a.b.x().a);
            return;
        L5:
            jy0.b.d("ScoreboardSeiClient", "clear SEI data");
            this.b.b("scoreboard_pos");
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ l1 a;

        public d(l1 r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            JsonElement r9 = (JsonElement) r8;
            jy0.b.d("ScoreboardSeiClient", "read SEI data: " + r9);
            this.a.getClass();
            Pair r0 = null;
            JsonObject r10 = r9.getAsJsonObject();     // Catch: Throwable -> L17
            String r1 = r10.get("rgn").getAsString();     // Catch: Throwable -> L17
            if (r1 == null) goto L16;
            String r2 = r1.toUpperCase();     // Catch: Throwable -> L17
            RegionId[] r3 = RegionId.values();     // Catch: Throwable -> L17
            int r4 = r3.length;     // Catch: Throwable -> L17
            int r5 = 0;
        L6:
            if (r5 >= r4) goto L11;
            RegionId r6 = r3[r5];     // Catch: Throwable -> L17
            if (Intrinsics.areEqual(r6.getId(), r2) == true) goto L12;
            r5 = r5 + 1;     // Catch: Throwable -> L17
        L12:
            if (r6 == null) goto L18;
            r0 = TuplesKt.to(r6, new j80.d(r10.get("nx").getAsFloat(), r10.get("ny").getAsFloat()));     // Catch: Throwable -> L17
            goto L18
        L11:
            r6 = null;
            goto L12
        L16:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L17
        L18:
            if (r0 == null) goto L24;
            this.a.b.n().a(r0);
            return;
        }
    }

    static {
        e = new d01.b.a(-1, true);
    }

    public final void onStart() {
        if (this.d.isAnchor() == false) goto L5;
        d01.b r0 = this.c.E3();
        RxUtilKt.c(this.b.x().throttleWithTimeout(500, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).subscribe(new b(this, r0)), this.a);
        RxUtilKt.c(this.b.w().distinctUntilChanged().subscribe(new c(this, r0)), this.a);
        return;
    L5:
        RxUtilKt.c(this.c.o6("scoreboard_pos").subscribe(new d(this)), this.a);
    }

    public final void onStop() {
        this.a.dispose();
    }

    public l1(l r2, d01.a r3, yz0.k r4) {
        Intrinsics.checkNotNullParameter(r2, "repository");
        Intrinsics.checkNotNullParameter(r3, "seiService");
        Intrinsics.checkNotNullParameter(r4, "roomDataService");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.a = new CompositeDisposable();
    }
}
