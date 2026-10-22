package kotlinx.serialization.json.internal;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationException;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u001a\u0018\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002*\u00020\nH\u0000\u001a\u001c\u0010\u000b\u001a\u00020\u0004*\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0000\u001a&\u0010\u000f\u001a\u00020\u0004*\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0003H\u0000\u001aF\u0010\u0011\u001a\u00020\u0012*\u00020\r2\u0006\u0010\u0013\u001a\u00020\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u00152\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00152\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0015H\u0080\bø\u0001\u0000\".\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0019"}, d2 = {"JsonAlternativeNamesKey", "Lkotlinx/serialization/json/internal/DescriptorSchemaCache$Key;", "", "", "", "getJsonAlternativeNamesKey$annotations", "()V", "getJsonAlternativeNamesKey", "()Lkotlinx/serialization/json/internal/DescriptorSchemaCache$Key;", "buildAlternativeNamesMap", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getJsonNameIndex", "json", "Lkotlinx/serialization/json/Json;", ActivityLifecycle.NAME, "getJsonNameIndexOrThrow", "suffix", "tryCoerceValue", "", "elementDescriptor", "peekNull", "Lkotlin/Function0;", "peekString", "onEnumCoercing", "", "kotlinx-serialization-json"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final g.a<Map<String, Integer>> f17845a = null;

    static {
        f17845a = new g.a();
    }

    public static final int a(kotlinx.serialization.descriptors.f r5, kotlinx.serialization.json.a r6, String r7) {
        kotlinx.serialization.descriptors.f r8 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r5, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r6, "json");
        Intrinsics.checkNotNullParameter(r7, ActivityLifecycle.NAME);
        int r0 = r8.a(r7);
        if (r0 == (-3)) goto L6;
        return r0;
    L6:
        if (r6.a().i() == true) goto L8;
        return r0;
    L8:
        Integer r9 = (Integer) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.preCheckCast(kotlinx.serialization.json.t.a(r6).a(r8, f17845a, (Function0) ZeusTransformUtils.preCheckCast(new JsonNamesMapKt$getJsonNameIndex$alternativeNamesMap$1(r8), Function0.class, "com.obric.memorydata.plugin")), Map.class, "com.obric.memorydata.plugin")).get(r7), Integer.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L11;
        return -3;
    L11:
        return r9.intValue();
    }

    public static final int a(kotlinx.serialization.descriptors.f r2, kotlinx.serialization.json.a r3, String r4, String r5) {
        kotlinx.serialization.descriptors.f r6 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r3, "json");
        Intrinsics.checkNotNullParameter(r4, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r5, "suffix");
        int r7 = a(r6, r3, r4);
        if (r7 == (-3)) goto L6;
        return r7;
    L6:
        throw new SerializationException(r6.f() + " does not contain element with name '" + r4 + '\'' + r5);
    }

    public static /* synthetic */ int a(kotlinx.serialization.descriptors.f r1, kotlinx.serialization.json.a r2, String r3, String r4, int r5, Object r6) {
        kotlinx.serialization.descriptors.f r7 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r1, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        if ((r5 & 4) == 0) goto L6;
        r4 = "";
    L6:
        return a(r7, r2, r3, r4);
    }

    public static final Map<String, Integer> a(kotlinx.serialization.descriptors.f r9) {
        kotlinx.serialization.descriptors.f r10 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r9, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r0 = r10.b();
        Map<String, Integer> r3 = null;
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L21;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r10.a(r4), Iterable.class, "com.obric.memorydata.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r7 = r5.iterator();
    L6:
        if (r7.hasNext() == false) goto L10;
        Object r8 = r7.next();
        if (ZeusTransformUtils.instanceOf(r8, kotlinx.serialization.json.m.class) == false) goto L6;
        r6.add(r8);
        goto L6
    L10:
        kotlinx.serialization.json.m r11 = (kotlinx.serialization.json.m) ZeusTransformUtils.preCheckCast(CollectionsKt.singleOrNull((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin")), kotlinx.serialization.json.m.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L20;
        String[] r12 = r11.a();
        if (r12 == null) goto L20;
        int r13 = r12.length;
        int r14 = 0;
    L15:
        if (r14 >= r13) goto L20;
        String r15 = r12[r14];
        if (r3 != null) goto L19;
        r3 = f.a(r10.b());
    L19:
        Intrinsics.checkNotNull(r3);
        a(r3, r10, r15, r4);
        r14 = r14 + 1;
    L20:
        r4 = r4 + 1;
        goto L3
    L21:
        if (r3 == null) goto L23;
        return r3;
    L23:
        return MapsKt.emptyMap();
    }

    public static final g.a<Map<String, Integer>> a() {
        return f17845a;
    }

    private static final void a(Map<String, Integer> r4, kotlinx.serialization.descriptors.f r5, String r6, int r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        kotlinx.serialization.descriptors.f r9 = (kotlinx.serialization.descriptors.f) ZeusTransformUtils.wrapperContextForParams(r5, kotlinx.serialization.descriptors.f.class, "com.obric.memorydata.plugin");
        if (r8.containsKey(r6) == true) goto L7;
        r8.put(r6, Integer.valueOf(r7));
        return;
    L7:
        throw new JsonException("The suggested name '" + r6 + "' for property " + r9.c(r7) + " is already one of the names for property " + r9.c(((Number) ZeusTransformUtils.preCheckCast(MapsKt.getValue(r8, r6), Number.class, "com.obric.memorydata.plugin")).intValue()) + " in " + r9);
    }
}
