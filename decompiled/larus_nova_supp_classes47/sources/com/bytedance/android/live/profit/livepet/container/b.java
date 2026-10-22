package com.bytedance.android.live.profit.livepet.container;

import com.bytedance.android.live.revlink.api.ILinkService;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<V> implements Callable {
    public final /* synthetic */ com.bytedance.android.live.profit.livepet.container.a a;

    public static final class a<T> implements ObservableOnSubscribe {
        public final /* synthetic */ b a;
        public final /* synthetic */ p11.i b;

        /* JADX INFO: renamed from: com.bytedance.android.live.profit.livepet.container.b$a$a, reason: collision with other inner class name */
        public static final class C0024a implements ttc.c {
            public final /* synthetic */ a a;
            public final /* synthetic */ Observer b;

            public C0024a(a r1, C0025b r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void cancel() {
                this.a.b.unRegisterRegionObserver(this.b);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.profit.livepet.container.b$a$b, reason: collision with other inner class name */
        public static final class C0025b<T> implements Observer {
            public final /* synthetic */ a a;
            public final /* synthetic */ ObservableEmitter b;

            public C0025b(a r1, ObservableEmitter r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void onChanged(Object r14) {
                Map r15 = (Map) r14;
                LinkedHashMap r0 = new LinkedHashMap(MapsKt.mapCapacity(r15.size()));
                Iterator<T> r16 = r15.entrySet().iterator();
            L4:
                if (r16.hasNext() == false) goto L6;
                Map.Entry r1 = (Map.Entry) r16.next();
                Object r2 = r1.getKey();
                pc0.c r3 = (pc0.c) r1.getValue();
                l r4 = new l(this.a.a.a);
                r4.a = MathKt.roundToInt(r3.b);
                r4.b = MathKt.roundToInt(r3.c);
                r4.c = MathKt.roundToInt(r3.d);
                r4.d = MathKt.roundToInt(r3.e);
                r0.put(r2, r4);
                goto L4
            L6:
                ArrayList r5 = new ArrayList(r0.size());
                Iterator r17 = r0.entrySet().iterator();
            L8:
                if (r17.hasNext() == false) goto L10;
                Map.Entry r6 = (Map.Entry) r17.next();
                r5.add(((String) r6.getKey()) + ": " + m.a((l) r6.getValue()));
                goto L8
            L10:
                jy0.b.a("LivePet/ObserveLinkRegionsUseCase", "link region count: " + r0.size() + '\n' + CollectionsKt.joinToString$default(r5, "\n", null, null, 0, null, null, 62, null));
                this.b.onNext(r0);
            }
        }

        public a(b r1, p11.i r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void subscribe(ObservableEmitter<Map<String, com.bytedance.android.live.profit.livepet.container.a>> r3) {
            Intrinsics.checkNotNullParameter(r3, "emitter");
            C0025b r0 = new C0025b(this, r3);
            this.b.registerRegionObserver(r0);
            r3.setCancellable(new C0024a(this, r0));
        }
    }

    public b(n r1) {
        this.a = r1;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }

    @Override // java.util.concurrent.Callable
    public final ObservableSource<? extends Map<String, com.bytedance.android.live.profit.livepet.container.a>> call() {
        p11.i r0 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).getLinkRegionService();
        if (r0 != null) goto L7;
        return Observable.empty();
    L7:
        return Observable.create(new a(this, r0));
    }
}
