package com.obric.memorydata.memory.llm;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0007J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\tR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/memory/llm/MemorySourceInfoMapper;", "", "<init>", "()V", "sessionSourceInfoMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/obric/memorydata/memory/memoryentity/MemorySourceInfo;", "put", "", ObricMemoryConstants.KEY_SESSION_ID, "sourceInfo", "get", "remove", "clear", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f10287a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, com.obric.memorydata.memory.memoryentity.f> f10288b = null;

    static {
        f10287a = new g();
        f10288b = new ConcurrentHashMap();
    }

    private g() {
    }

    public final com.obric.memorydata.memory.memoryentity.f a(String r2) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_SESSION_ID);
        return (com.obric.memorydata.memory.memoryentity.f) ZeusTransformUtils.preCheckCast(f10288b.get(r2), com.obric.memorydata.memory.memoryentity.f.class, "com.obric.memorydata.plugin");
    }

    public final void a(String r3, com.obric.memorydata.memory.memoryentity.f r4) {
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_SESSION_ID);
        Intrinsics.checkNotNullParameter(r4, "sourceInfo");
        ((Map) ZeusTransformUtils.preCheckCast(f10288b, Map.class, "com.obric.memorydata.plugin")).put(r3, r4);
    }

    public final void b(String r1) {
        Intrinsics.checkNotNullParameter(r1, ObricMemoryConstants.KEY_SESSION_ID);
        f10288b.remove(r1);
    }
}
