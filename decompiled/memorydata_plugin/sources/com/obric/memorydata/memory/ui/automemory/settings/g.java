package com.obric.memorydata.memory.ui.automemory.settings;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;
import kotlinx.coroutines.flow.k;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bJ\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0006J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u0006J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u00062\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0012J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0006R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryTaskDraftRepository;", "", "<init>", "()V", "sessions", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/memorydata/memory/ui/automemory/settings/DraftRule;", "open", "initial", "flow", "Lkotlinx/coroutines/flow/StateFlow;", ObricMemoryConstants.KEY_SESSION_ID, "peek", BuildConfig.CHANNEL, "", "transform", "Lkotlin/Function1;", IslandSession.REOPEN_VALUE_CLOSE, "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f10759a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, ae<b>> f10760b = null;

    static {
        f10759a = new g();
        f10760b = new ConcurrentHashMap();
    }

    private g() {
    }

    public final String a(b r4) {
        Intrinsics.checkNotNullParameter(r4, "initial");
        String r3 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(r3, "toString(...)");
        ((Map) ZeusTransformUtils.preCheckCast(f10760b, Map.class, "com.obric.memorydata.plugin")).put(r3, at.a(r4));
        return r3;
    }

    public final ar<b> a(String r2) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_SESSION_ID);
        ae r1 = (ae) ZeusTransformUtils.preCheckCast(f10760b.get(r2), ae.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        return null;
    L7:
        return k.a(r1);
    }

    public final b b(String r2) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_SESSION_ID);
        ae r1 = (ae) ZeusTransformUtils.preCheckCast(f10760b.get(r2), ae.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        return null;
    L7:
        return (b) ZeusTransformUtils.preCheckCast(r1.c(), b.class, "com.obric.memorydata.plugin");
    }

    public final void c(String r1) {
        Intrinsics.checkNotNullParameter(r1, ObricMemoryConstants.KEY_SESSION_ID);
        f10760b.remove(r1);
    }

    public final void update(String r2, Function1<? super b, b> r3) {
        Function1 r1 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_SESSION_ID);
        Intrinsics.checkNotNullParameter(r1, "transform");
        ae r4 = (ae) ZeusTransformUtils.preCheckCast(f10760b.get(r2), ae.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
    L4:
        Object r5 = r4.c();
        if (r4.a(r5, r1.invoke(r5)) == false) goto L4;
        return;
    }
}
