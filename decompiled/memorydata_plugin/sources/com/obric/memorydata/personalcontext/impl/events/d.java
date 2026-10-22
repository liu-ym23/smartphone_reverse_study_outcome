package com.obric.memorydata.personalcontext.impl.events;

import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.memorydata.personalcontext.impl.events.handlers.e;
import com.obric.memorydata.personalcontext.impl.events.handlers.f;
import com.obric.memorydata.personalcontext.impl.events.handlers.g;
import com.obric.memorydata.personalcontext.impl.events.handlers.h;
import com.obric.memorydata.personalcontext.impl.events.handlers.i;
import com.obric.memorydata.personalcontext.impl.events.handlers.j;
import com.obric.memorydata.personalcontext.impl.events.handlers.k;
import com.obric.memorydata.personalcontext.impl.events.handlers.l;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0007J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/personalcontext/impl/events/RawEntityEventRegistry;", "", "<init>", "()V", "handlers", "", "", "Lcom/obric/memorydata/personalcontext/impl/events/RawEntityEventHandler;", "register", "", "entityType", "handler", "get", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f12201a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<Integer, c> f12202b = null;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        d r0 = new d();
        f12201a = r0;
        f12202b = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        r0.a(101, (c) ZeusTransformUtils.preCheckCast(new h(), c.class, "com.obric.memorydata.plugin"));
        r0.a(402, (c) ZeusTransformUtils.preCheckCast(new g(), c.class, "com.obric.memorydata.plugin"));
        r0.a(202, (c) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.personalcontext.impl.events.handlers.c(), c.class, "com.obric.memorydata.plugin"));
        r0.a(501, (c) ZeusTransformUtils.preCheckCast(new k(), c.class, "com.obric.memorydata.plugin"));
        r0.a(701, (c) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.personalcontext.impl.events.handlers.a(), c.class, "com.obric.memorydata.plugin"));
        r0.a(601, (c) ZeusTransformUtils.preCheckCast(new i(), c.class, "com.obric.memorydata.plugin"));
        r0.a(EntityType.FILE, (c) ZeusTransformUtils.preCheckCast(new f(), c.class, "com.obric.memorydata.plugin"));
        r0.a(301, (c) ZeusTransformUtils.preCheckCast(new j(), c.class, "com.obric.memorydata.plugin"));
        r0.a(-304, (c) ZeusTransformUtils.preCheckCast(new l(null, 1, 0 == true ? 1 : 0), c.class, "com.obric.memorydata.plugin"));
        r0.a(702, (c) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.personalcontext.impl.events.handlers.d(), c.class, "com.obric.memorydata.plugin"));
        r0.a(NetError.ERR_CACHE_OPERATION_NOT_SUPPORTED, (c) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.personalcontext.impl.events.handlers.b(), c.class, "com.obric.memorydata.plugin"));
        r0.a(-306, (c) ZeusTransformUtils.preCheckCast(new e(), c.class, "com.obric.memorydata.plugin"));
    }

    private d() {
    }

    public final c a(int r2) {
        return (c) ZeusTransformUtils.preCheckCast(f12202b.get(Integer.valueOf(r2)), c.class, "com.obric.memorydata.plugin");
    }

    public final void a(int r2, c r3) {
        c r1 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "handler");
        Integer r4 = Integer.valueOf(r2);
        f12202b.put(r4, r1);
    }
}
