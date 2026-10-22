package com.bytedance.android.anya;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\u001a\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0004\"\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u0000\"\b\b\u0001\u0010\u0003*\u00020\u0002H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/bytedance/android/anya/MVIState;", "STATE", "Lcom/bytedance/android/anya/p;", "ACTION", "", "Lcom/bytedance/android/anya/internal/q;", "Lcom/bytedance/android/anya/c0;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class BaseMVIViewModel$reflexComponents$2 extends Lambda implements Function0<Map<com.bytedance.android.anya.internal.q<?, ?>, ? extends c0<?>>> {
    final /* synthetic */ BaseMVIViewModel this$0;

    public BaseMVIViewModel$reflexComponents$2(BaseMVIViewModel r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final Map<com.bytedance.android.anya.internal.q<?, ?>, c0<?>> m457invoke() {
        ReentrantLock r0 = this.this$0.K().b;
        r0.lock();
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L6
        this.this$0.getClass();     // Catch: Throwable -> L6
        Map<com.bytedance.android.anya.internal.q<?, ?>, c0<?>> r10 = MapsKt.toMap(SequencesKt.flatMap(CollectionsKt.asSequence(r1), new BaseMVIViewModel$reflexComponents$2$$special$$inlined$runBlocking$runtime_release$lambda$1(this)));     // Catch: Throwable -> L6
        r0.unlock();
        return r10;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m457invoke();
    }
}
