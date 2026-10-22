package com.obric.memorydata.memory;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JP\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/memory/AutoMemorySwitchPolicy;", "", "<init>", "()V", "reconcileApps", "", "", com.xiphias.browser.scanner.BuildConfig.FLAVOR, "defaultEnabled", "requiresAccessibility", "accessibilityEnabled", "", "currentScheme", "Lcom/obric/memorydata/memory/AutoMemoryCollectionScheme;", "previousScheme", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f10080a = null;

    static {
        f10080a = new c();
    }

    private c() {
    }

    public final Set<String> a(Set<String> r2, Set<String> r3, Set<String> r4, boolean r5, AutoMemoryCollectionScheme r6, AutoMemoryCollectionScheme r7) {
        Set<String> r1 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
        Set<String> r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Set r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, com.xiphias.browser.scanner.BuildConfig.FLAVOR);
        Intrinsics.checkNotNullParameter(r8, "defaultEnabled");
        Intrinsics.checkNotNullParameter(r9, "requiresAccessibility");
        Intrinsics.checkNotNullParameter(r6, "currentScheme");
        if (r7 != null) goto L6;
        r1 = r8;
    L6:
        if (r6 != AutoMemoryCollectionScheme.ACCESSIBILITY) goto L10;
        if (r5 == false) goto L9;
        return r1;
    L9:
        return SetsKt.minus(r1, (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin"));
    L10:
        return r1;
    }
}
