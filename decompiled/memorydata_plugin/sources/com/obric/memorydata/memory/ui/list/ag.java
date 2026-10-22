package com.obric.memorydata.memory.ui.list;

import com.obric.memorydata.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/MemorySourcePageOrder;", "", "<init>", "()V", "orderedKeys", "", "", "keys", "", "getKeys", "()Ljava/util/List;", BuildConfig.CHANNEL, "", "latestKeys", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<Integer> f11178a;

    public ag() {
        this.f11178a = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    }

    public final List<Integer> a() {
        return this.f11178a;
    }

    public final boolean update(List<Integer> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "latestKeys");
        if (Intrinsics.areEqual(this.f11178a, r4) == false) goto L6;
        return false;
    L6:
        this.f11178a.clear();
        this.f11178a.addAll((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin"));
        return true;
    }
}
