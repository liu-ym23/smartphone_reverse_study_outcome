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
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000fJ\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\bJ\b\u0010\u0012\u001a\u00020\fH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/schedule/IcsCalendar;", "", "<init>", "()V", "properties", "", "Lcom/obric/memorydata/personalcontext/external/schedule/IcsProperty;", "components", "Lcom/obric/memorydata/personalcontext/external/schedule/IcsComponent;", "addProperty", "", ActivityLifecycle.NAME, "", EventBody.KEY_VALUE, "parameters", "", "addComponent", "component", "toString", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<i> f12168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<g> f12169b;

    public f() {
        this.f12168a = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        this.f12169b = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ void a(f r1, String r2, String r3, Map r4, int r5, Object r6) {
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if ((r5 & 4) == 0) goto L5;
        r7 = MapsKt.emptyMap();
    L5:
        r1.a(r2, r3, r7);
    }

    public final void a(g r2) {
        Intrinsics.checkNotNullParameter(r2, "component");
        this.f12169b.add(r2);
    }

    public final void a(String r3, String r4, Map<String, String> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r4, EventBody.KEY_VALUE);
        Intrinsics.checkNotNullParameter(r6, "parameters");
        this.f12168a.add(new i(r3, r4, r6));
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("BEGIN:VCALENDAR\r\n");
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f12168a, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r0.append(((i) ZeusTransformUtils.preCheckCast(r1.next(), i.class, "com.obric.memorydata.plugin")).toString()).append("\r\n");
        goto L4
    L6:
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f12169b, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        r0.append(((g) ZeusTransformUtils.preCheckCast(r5.next(), g.class, "com.obric.memorydata.plugin")).toString());
        goto L8
    L10:
        r0.append("END:VCALENDAR\r\n");
        String r6 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r6, "toString(...)");
        return r6;
    }
}
