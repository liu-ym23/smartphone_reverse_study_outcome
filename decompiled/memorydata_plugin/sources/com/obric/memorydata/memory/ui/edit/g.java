package com.obric.memorydata.memory.ui.edit;

import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u0016\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/memory/ui/edit/MemoryEditedEventDispatcher;", "", "<init>", "()V", "listeners", "", "Lcom/obric/memorydata/memory/ui/edit/MemoryEditedInvoke;", "addListener", "", "listener", "removeListener", "notifyMemoryEdited", "memoryRawDbId", "", "memoryEntity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f10904a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<h> f10905b = null;

    static {
        f10904a = new g();
        f10905b = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    }

    private g() {
    }

    public final void a(long r4, MemoryEntity r6) {
        Intrinsics.checkNotNullParameter(r6, "memoryEntity");
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(f10905b, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((h) ZeusTransformUtils.preCheckCast(r3.next(), h.class, "com.obric.memorydata.plugin")).a(r4, r6);
        goto L4
    }
}
