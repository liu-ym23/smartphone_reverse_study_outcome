package com.obric.memorydata.memory.ui.edit;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\r\u001a\u00020\u0004H\u0002\"*\u0010\u0000\u001a\u001e\u0012\u0014\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0004\u0012\u00020\u00050\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0091\u0001\u0010\u0006\u001a\u0082\u0001\u0012,\u0012*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u0004 \b*\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \b*\u0004\u0018\u00010\t0\t \b*@\u0012,\u0012*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u0004 \b*\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00020\u0002\u0012\f\u0012\n \b*\u0004\u0018\u00010\t0\t\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u000e"}, d2 = {"FIELD_CACHE", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/Pair;", "Ljava/lang/Class;", "", "Ljava/lang/reflect/Field;", "FIELD_NOT_FOUND", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "kotlin.jvm.PlatformType", "", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "resolveField", "clazz", ActivityLifecycle.NAME, "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<Pair<Class<?>, String>, Field> f10894a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap.KeySetView<Pair<Class<?>, String>, Boolean> f10895b = null;

    static {
        f10894a = new ConcurrentHashMap();
        f10895b = ConcurrentHashMap.newKeySet();
    }

    public static final /* synthetic */ Field a(Class r0, String r1) {
        return b(r0, r1);
    }

    private static final Field b(Class<?> r8, String r9) {
        Pair<Class<?>, String> r0 = TuplesKt.to(r8, r9);
        Field r1 = (Field) ZeusTransformUtils.preCheckCast(f10894a.get(r0), Field.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        return r1;
    L6:
        if (f10895b.contains(r0) == false) goto L8;
        return null;
    L8:
        if (r8 == null) goto L23;
        if (Intrinsics.areEqual(r8, Object.class) == true) goto L23;
        Field[] r2 = r8.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(r2, "getDeclaredFields(...)");
        Object[] r3 = (Object[]) ZeusTransformUtils.preCheckCast(r2, Object[].class, "com.obric.memorydata.plugin");
        int r4 = 0;
        int r5 = r3.length;
    L12:
        if (r4 >= r5) goto L17;
        Object r6 = r3[r4];
        if (Intrinsics.areEqual(((Field) ZeusTransformUtils.preCheckCast(r6, Field.class, "com.obric.memorydata.plugin")).getName(), r9) == true) goto L18;
        r4 = r4 + 1;
    L18:
        Field r7 = (Field) ZeusTransformUtils.preCheckCast(r6, Field.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L20;
        r8 = r8.getSuperclass();
        goto L8
    L20:
        r7.setAccessible(true);
        ((Map) ZeusTransformUtils.preCheckCast(f10894a, Map.class, "com.obric.memorydata.plugin")).put(r0, r7);
        return r7;
    L17:
        r6 = null;
    L23:
        f10895b.add(r0);
        return null;
    }
}
