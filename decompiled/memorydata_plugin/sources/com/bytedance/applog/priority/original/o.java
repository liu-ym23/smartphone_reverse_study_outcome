package com.bytedance.applog.priority.original;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0012\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/applog/priority/original/LocalLazy;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Lazy;", "initializer", "Lcom/bytedance/applog/priority/original/ValueLoader;", "(Lcom/bytedance/applog/priority/original/ValueLoader;)V", "cached", "Ljava/lang/Object;", "getInitializer", "()Lcom/bytedance/applog/priority/original/ValueLoader;", EventBody.KEY_VALUE, "getValue", "()Ljava/lang/Object;", "isInitialized", "", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class o<T> implements Lazy<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u<T> f1846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private T f1847b;

    public o(u<T> r3) {
        u<T> r4 = (u) ZeusTransformUtils.wrapperContextForParams(r3, u.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "initializer");
        this.f1846a = r4;
    }

    @Override // kotlin.Lazy
    public T getValue() {
        if (this.f1847b != null) goto L5;
        this.f1847b = this.f1846a.load();
    L5:
        T r1 = this.f1847b;
        Intrinsics.checkNotNull(r1);
        return r1;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        if (this.f1847b == null) goto L5;
        return true;
    L5:
        return false;
    }
}
