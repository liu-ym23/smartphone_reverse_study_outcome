package com.bytedance.android.live.revenue.platform.stream.impl;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;
import or2.j;
import or2.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b<T> implements ObservableOnSubscribe {
    public final /* synthetic */ com.bytedance.android.live.revenue.platform.stream.impl.a a;

    public static final class a implements ttc.c {
        public final /* synthetic */ or2.c a;
        public final /* synthetic */ Observer b;

        public a(or2.c r1, C0106b r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void cancel() {
            this.a.getSeiUpdate().removeObserver(this.b);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revenue.platform.stream.impl.b$b, reason: collision with other inner class name */
    public static final class C0106b<T> implements Observer {
        public final /* synthetic */ ObservableEmitter a;

        public C0106b(ObservableEmitter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            ObservableEmitter r0 = this.a;
            r0.onNext((String) r2);
        }
    }

    public b(com.bytedance.android.live.revenue.platform.stream.impl.a r1) {
        this.a = r1;
    }

    public final void subscribe(ObservableEmitter<String> r5) {
        Intrinsics.checkNotNullParameter(r5, "emitter");
        j r0 = this.a.f.getCurrentClient();
        if (r0 == null) goto L5;
        m r1 = r0.d();
    L6:
        if (r1 != null) goto L9;
        jy0.b.c("SeiServiceImpl", "roomEventHub is null", null, 4);
        r5.onComplete();
        return;
    L9:
        C0106b r2 = new C0106b(r5);
        r5.setCancellable(new a(r1, r2));
        r1.getSeiUpdate().observeForever(r2);
        return;
    L5:
        r1 = null;
        goto L6
    }
}
