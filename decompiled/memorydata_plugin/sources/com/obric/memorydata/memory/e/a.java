package com.obric.memorydata.memory.e;

import com.obric.memorydata.memory.llm.MemoryLLMBuildHelperV2;
import com.obric.memorydata.memory.memoryentity.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011JD\u0010\u0002\u001a\"\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00060\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH&JD\u0010\u000e\u001a\"\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00060\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\f\u001a\u00020\rH&¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/memory/strategy/MemoryBuildStrategy;", "", "build", "Lkotlin/Pair;", "", "Lcom/obric/memorydata/memory/llm/MemoryLLMBuildHelperV2$ResultEntity;", "", "", "trackingEvent", "Lcom/obric/memorydata/memory/strategy/MemoryTrackingEvent;", "memorySourceInfo", "Lcom/obric/memorydata/memory/memoryentity/MemorySourceInfo;", "eval", "", "retryBuild", "memoryEntity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0494a f10116b = null;

    /* JADX INFO: renamed from: com.obric.memorydata.memory.e.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/strategy/MemoryBuildStrategy$Companion;", "", "<init>", "()V", "TYPE_CLOUD", "", "TYPE_CLIENT", "get", "Lcom/obric/memorydata/memory/strategy/MemoryBuildStrategy;", "type", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0494a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ C0494a f10117a = null;

        static {
            f10117a = new C0494a();
        }

        private C0494a() {
        }

        public final a a(int r2) {
            return (a) ZeusTransformUtils.preCheckCast(com.obric.memorydata.memory.llm.a.f10277a.a(), a.class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b {
        public static /* synthetic */ Pair a(a r2, com.obric.memorydata.memory.e.b r3, f r4, boolean r5, int r6, Object r7) {
            a r8 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.memorydata.plugin");
            com.obric.memorydata.memory.e.b r9 = (com.obric.memorydata.memory.e.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.memory.e.b.class, "com.obric.memorydata.plugin");
            if (r7 != null) goto L10;
            if ((r6 & 4) == 0) goto L8;
            r5 = false;
        L8:
            return r8.a(r9, r4, r5);
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: build");
        }
    }

    static {
        f10116b = C0494a.f10117a;
    }

    Pair<List<MemoryLLMBuildHelperV2.a>, Map<String, Object>> a(com.obric.memorydata.memory.e.b r1, f r2, boolean r3);
}
