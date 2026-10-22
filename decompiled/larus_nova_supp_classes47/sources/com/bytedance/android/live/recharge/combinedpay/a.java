package com.bytedance.android.live.recharge.combinedpay;

import com.bytedance.android.live.recharge.utils.i;
import com.bytedance.android.live.revenue.common.reactive.b;
import com.bytedance.android.live.revenue.common.reactive.c;
import com.bytedance.android.live.revenue.common.reactive.f;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public static final C0060a a = null;
    public static final KMutableProperty0 b = null;

    /* JADX INFO: renamed from: com.bytedance.android.live.recharge.combinedpay.a$a, reason: collision with other inner class name */
    public static final class C0060a implements b<Boolean> {
        public final c a;

        @Override // com.bytedance.android.live.revenue.common.reactive.b, com.bytedance.android.live.revenue.common.reactive.e
        public final Object getValue() {
            return Boolean.valueOf(((Boolean) i.c.getValue(null, i.a[1])).booleanValue());
        }

        public C0060a() {
            this.a = new c(Boolean.FALSE);
        }

        @Override // com.bytedance.android.live.revenue.common.reactive.e
        public final Disposable a(f<Boolean> r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            return this.a.a(r2);
        }

        @Override // com.bytedance.android.live.revenue.common.reactive.b
        public final void setValue(Boolean r5) {
            boolean r6 = r5.booleanValue();
            i.c.setValue(null, i.a[1], Boolean.valueOf(r6));
            this.a.setValue(Boolean.valueOf(r6));
        }
    }

    public static boolean a() {
        return ((Boolean) b.get()).booleanValue();
    }

    static {
        final C0060a r0 = new C0060a();
        a = r0;
        b = new CombinedPaySelectionProvider$value$2(r0);
    }
}
