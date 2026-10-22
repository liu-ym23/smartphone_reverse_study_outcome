package com.obric.memorydata.task.condition.vendor;

import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.condition.f;
import com.obric.memorydata.task.condition.l;
import com.obric.memorydata.task.condition.vendor.gr.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\bJ\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u000fJ\b\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/task/condition/vendor/VendorConditionRegistry;", "", "<init>", "()V", "TAG", "", "conditionMap", "", "Lcom/obric/memorydata/task/condition/Condition;", "Lcom/obric/memorydata/task/condition/BaseCondition;", "conflictConditionMap", "", "obtainCondition", "condition", "filterConflictCondition", "", "conditions", "isGRProject", "", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12898a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<Condition, com.obric.memorydata.task.condition.b> f12899b = null;
    private static final Map<Condition, Set<Condition>> c = null;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        b r0 = new b();
        f12898a = r0;
        Map<Condition, com.obric.memorydata.task.condition.b> r1 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        f12899b = r1;
        Map<Condition, Set<Condition>> r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        c = r2;
        if (r0.a() == false) goto L5;
        RunLog.INSTANCE.info("VendorCondition", "Using GR Project Condition", true);
        com.obric.memorydata.task.condition.vendor.gr.b r3 = new com.obric.memorydata.task.condition.vendor.gr.b();
        r1.put(Condition.COMMON_POWER_CONTROL, r3);
        r1.put(Condition.MEMORY_EXTRACT_POWER_CONTROL, r3);
        r1.put(Condition.STRICTLY_POWER_CONTROL, new com.obric.memorydata.task.condition.vendor.gr.a());
        r1.put(Condition.LIGHT_POWER_CONTROL, new c());
        r2.put(Condition.COMMON_POWER_CONTROL, SetsKt.setOf(Condition.SCREEN_ON));
        r2.put(Condition.MEMORY_EXTRACT_POWER_CONTROL, SetsKt.setOf(Condition.SCREEN_ON));
        r2.put(Condition.STRICTLY_POWER_CONTROL, SetsKt.setOf(Condition.SCREEN_ON));
        return;
    L5:
        RunLog.INSTANCE.info("VendorCondition", "Using internal Condition", true);
        r1.put(Condition.STRICTLY_POWER_CONTROL, new l());
        Condition r4 = Condition.COMMON_POWER_CONTROL;
        Condition r5 = null;
        Object[] r6 = 0 == true ? 1 : 0;
        r1.put(r4, new com.obric.memorydata.task.condition.c(r5, r6, 3, 0 == true ? 1 : 0));
        r1.put(Condition.MEMORY_EXTRACT_POWER_CONTROL, new f());
    }

    private b() {
    }

    private final boolean a() {
        return Intrinsics.areEqual(DeviceInfoState.INSTANCE.getDeviceModel(), "Genesis-R");
    }

    public final com.obric.memorydata.task.condition.b a(Condition r2) {
        Intrinsics.checkNotNullParameter(r2, "condition");
        com.obric.memorydata.task.condition.b r1 = (com.obric.memorydata.task.condition.b) ZeusTransformUtils.preCheckCast(f12899b.get(r2), com.obric.memorydata.task.condition.b.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L5;
        return r1;
    L5:
        return (com.obric.memorydata.task.condition.b) ZeusTransformUtils.preCheckCast(a.f12897a, com.obric.memorydata.task.condition.b.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Type inference failed for: r1v9, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r6v3, types: [T, java.lang.Object, java.util.List] */
    public final List<Condition> a(List<? extends Condition> r7) {
        ?? r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "conditions");
        Ref.ObjectRef r8 = new Ref.ObjectRef();
        r8.element = r6;
        Iterator<Map.Entry<Condition, Set<Condition>>> r9 = c.entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L15;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Condition r2 = (Condition) ZeusTransformUtils.preCheckCast(r1.getKey(), Condition.class, "com.obric.memorydata.plugin");
        Set r3 = (Set) ZeusTransformUtils.preCheckCast(r1.getValue(), Set.class, "com.obric.memorydata.plugin");
        if (((List) ZeusTransformUtils.preCheckCast(r8.element, List.class, "com.obric.memorydata.plugin")).contains(r2) == false) goto L4;
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r8.element, Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r4.iterator();
    L9:
        if (r10.hasNext() == false) goto L13;
        Object r11 = r10.next();
        if ((!r3.contains((Condition) ZeusTransformUtils.preCheckCast(r11, Condition.class, "com.obric.memorydata.plugin"))) == false) goto L9;
        r5.add(r11);
        goto L9
    L13:
        r8.element = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
        goto L4
    L15:
        return (List) ZeusTransformUtils.preCheckCast(r8.element, List.class, "com.obric.memorydata.plugin");
    }
}
