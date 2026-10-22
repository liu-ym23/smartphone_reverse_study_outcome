package com.bytedance.android.livesdk.interactivity.utils;

import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/utils/DistinctUntilChangedObserver;", "T", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class DistinctUntilChangedObserver<T> implements Observer<KVData> {
    public T a;

    public DistinctUntilChangedObserver() {
    }

    public abstract T a(KVData r1);

    public abstract boolean b(T r1, T r2);

    public abstract void c(T r1);

    public final void onChanged(Object r2) {
        KVData r3 = (KVData) r2;
        if (r3 == null) goto L14;
        T r4 = a(r3);
        T r0 = this.a;
        if (r0 != null) goto L9;
        this.a = r4;
        c(r4);
        return;
    L9:
        if (b(r0, r4) == true) goto L13;
        this.a = r4;
        c(r4);
        return;
    L13:
        return;
    }
}
