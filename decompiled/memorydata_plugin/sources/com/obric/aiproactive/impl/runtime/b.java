package com.obric.aiproactive.impl.runtime;

import com.obric.memorydata.middleware.api.store.IStore;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0002\u0010\u0004\u001a\u0017\u0010\u0005\u001a\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0002\u0010\u0007\u001a\u001b\u0010\b\u001a\u0004\u0018\u00010\u0001*\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"resolvePersistedWakeUpEnabled", "", "userPreferenceEnabled", "legacyEnabled", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)Z", "normalizeWakeUpEnabled", "enabled", "(Ljava/lang/Boolean;)Z", "takeBooleanIfPresent", "Lcom/obric/memorydata/middleware/api/store/IStore;", "key", "", "(Lcom/obric/memorydata/middleware/api/store/IStore;Ljava/lang/String;)Ljava/lang/Boolean;", "ai_proactive_impl_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class b {
    public static final /* synthetic */ Boolean a(IStore r2, String r3) {
        return b((IStore) ZeusTransformUtils.wrapperContextForParams(r2, IStore.class, "com.obric.memorydata.plugin"), r3);
    }

    public static final boolean a(Boolean r1) {
        return Intrinsics.areEqual(r1, true);
    }

    public static final boolean a(Boolean r3, Boolean r4) {
        if (Intrinsics.areEqual(r3, true) == false) goto L6;
        return true;
    L6:
        if (Intrinsics.areEqual(r3, false) == true) goto L13;
        if (r3 != null) goto L12;
        return a(r4);
    L12:
        throw new NoWhenBranchMatchedException();
    L13:
        return false;
    }

    private static final Boolean b(IStore r2, String r3) {
        IStore r4 = (IStore) ZeusTransformUtils.wrapperContextForParams(r2, IStore.class, "com.obric.memorydata.plugin");
        if (r4.contains(r3) == true) goto L7;
        return null;
    L7:
        return Boolean.valueOf(r4.getBoolean(r3, false));
    }
}
