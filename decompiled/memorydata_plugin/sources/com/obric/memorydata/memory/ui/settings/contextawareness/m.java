package com.obric.memorydata.memory.ui.settings.contextawareness;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessSourceDefaultsPolicy;", "", "<init>", "()V", "keysToEnable", "", "", "screenObservationEnabled", "", "locationPermissionGranted", "configuredKeys", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f11461a = null;

    static {
        f11461a = new m();
    }

    private m() {
    }

    public final List<String> a(boolean r5, boolean r6, Set<String> r7) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "configuredKeys");
        if (r5 == false) goto L5;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(l.a(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.iterator();
    L8:
        if (r10.hasNext() == false) goto L19;
        Object r1 = r10.next();
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");
        if (r4.contains(r2) == false) goto L12;
    L15:
        boolean r3 = false;
    L16:
        if (r3 == false) goto L8;
        r9.add(r1);
        goto L8
    L12:
        if (Intrinsics.areEqual(r2, "context_awareness_location_enabled") == false) goto L14;
        if (r6 == false) goto L15;
    L14:
        r3 = true;
        goto L16
    L19:
        return (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin");
    L5:
        return CollectionsKt.emptyList();
    }
}
