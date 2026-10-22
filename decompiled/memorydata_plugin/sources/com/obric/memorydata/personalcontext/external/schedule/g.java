package com.obric.memorydata.personalcontext.external.schedule;

import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J,\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0011J\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/schedule/IcsComponent;", "", ActivityLifecycle.NAME, "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "properties", "", "Lcom/obric/memorydata/personalcontext/external/schedule/IcsProperty;", "getProperties", "()Ljava/util/List;", "addProperty", "", EventBody.KEY_VALUE, "parameters", "", "toString", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<i> f12171b;

    public g(String r3) {
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        this.f12170a = r3;
        this.f12171b = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ void a(g r2, String r3, String r4, Map r5, int r6, Object r7) {
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L10;
        if ((r6 & 4) == 0) goto L7;
        r8 = MapsKt.emptyMap();
    L7:
        r2.a(r3, r4, r8);
        return;
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addProperty");
    }

    public final String a() {
        return this.f12170a;
    }

    public final void a(String r3, String r4, Map<String, String> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r4, EventBody.KEY_VALUE);
        Intrinsics.checkNotNullParameter(r6, "parameters");
        this.f12171b.add(new i(r3, r4, r6));
    }

    public final List<i> b() {
        return this.f12171b;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("BEGIN:" + this.f12170a + "\r\n");
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f12171b, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.append(((i) ZeusTransformUtils.preCheckCast(r1.next(), i.class, "com.obric.memorydata.plugin")).toString()).append("\r\n");
        goto L4
    L6:
        r0.append("END:" + this.f12170a + "\r\n");
        String r6 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r6, "toString(...)");
        return r6;
    }
}
