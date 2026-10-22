package com.obric.aikernel.res.metadata.data;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a&\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0000¨\u0006\t"}, d2 = {"isPackageReadyWithDependencyTags", "", "baseReady", "dependsDirExists", "dependencyStateBroken", "staticPackageDependenciesSatisfied", "baseSatisfied", "dependencyAvailableStates", "", "resource_manager_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class c {
    public static final boolean a(boolean r3, boolean r4, Collection<Boolean> r5) {
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "dependencyAvailableStates");
        if (r3 == false) goto L20;
        if (r4 == true) goto L21;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        if (((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L8;
    L7:
        boolean r8 = true;
    L14:
        if (r8 == true) goto L16;
        return false;
    L16:
        return true;
    L8:
        Iterator r9 = r7.iterator();
    L10:
        if (r9.hasNext() == false) goto L7;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r9.next(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L10;
        r8 = false;
        goto L14
    L21:
        return false;
    L20:
        return false;
    }

    public static final boolean a(boolean r0, boolean r1, boolean r2) {
        if (r0 == false) goto L6;
        if (r1 == false) goto L6;
        if (r2 == true) goto L6;
        return true;
    L6:
        return false;
    }
}
