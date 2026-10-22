package com.bytedance.android.live.impl.utils;

import com.bytedance.android.live.impl.service.FeatureManager;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0011\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0007\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/impl/utils/LimitSizeQueue;", "E", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "element", "", "add", "(Ljava/lang/Object;)Z", "offer", "", "limitSize", "I", "<init>", "(I)V", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LimitSizeQueue<E> extends ConcurrentLinkedQueue<E> {
    private final int limitSize;

    public LimitSizeQueue() {
        this(0, 1, null);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public LimitSizeQueue(int r1) {
        this.limitSize = r1;
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public boolean add(E r1) {
        return offer(r1);
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue
    public boolean offer(E r2) {
        if (super.offer(r2) == true) goto L5;
        return false;
    L5:
        if (size() <= this.limitSize) goto L11;
        poll();
        return true;
    L11:
        return true;
    }

    public LimitSizeQueue(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        FeatureManager.u.getClass();
        r1 = FeatureManager.g;
    L5:
        this(r1);
    }
}
