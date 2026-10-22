package com.bytedance.android.livesdk.gift.platform.business.anchor;

import com.bytedance.android.scope.o;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class AnchorTrayPostEffectService implements o {
    public final AtomicBoolean a;
    public final Lazy b;
    public final k c;

    public final void onStart() {
    }

    public final void onStop() {
        Iterator r0 = ((Map) this.b.getValue()).values().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Disposable r1 = ((e) r0.next()).b;
        if (r1 == null) goto L4;
        r1.dispose();
        goto L4
    }

    public AnchorTrayPostEffectService(k r2) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        this.c = r2;
        this.a = new AtomicBoolean(false);
        this.b = LazyKt.lazy(AnchorTrayPostEffectService$postEffectTimerMap$2.INSTANCE);
    }
}
