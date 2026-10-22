package com.bytedance.android.livesdk.gift.platform.core.preview;

import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class RequestTimer {
    public Disposable a;
    public final long b;
    public List<Long> c;
    public List<Long> d;
    public int e;
    public Function0<Unit> f;

    public RequestTimer() {
        this.b = ((Number) com.bytedance.android.livesdk.gift.platform.business.a.v.getValue(null, com.bytedance.android.livesdk.gift.platform.business.a.a[20])).longValue();
        this.c = CollectionsKt.emptyList();
        this.d = CollectionsKt.emptyList();
        this.f = RequestTimer$callback$1.INSTANCE;
    }
}
