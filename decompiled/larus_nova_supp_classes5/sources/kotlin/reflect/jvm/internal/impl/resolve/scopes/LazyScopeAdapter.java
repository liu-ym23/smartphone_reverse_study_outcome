package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class LazyScopeAdapter extends AbstractScopeAdapter {
    private final NotNullLazyValue<MemberScope> lazyScope;

    public LazyScopeAdapter(Function0<? extends MemberScope> r3) {
        Intrinsics.checkNotNullParameter(r3, "getScope");
        StorageManager r0 = null;
        this(r0, r3, 1, r0);
    }

    public static /* synthetic */ MemberScope accessor$LazyScopeAdapter$lambda0(Function0 r0) {
        return lazyScope$lambda$1(r0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter
    public MemberScope getWorkerScope() {
        return (MemberScope) this.lazyScope.invoke();
    }

    private static final MemberScope lazyScope$lambda$1(Function0 r1) {
        Intrinsics.checkNotNullParameter(r1, "$getScope");
        MemberScope r2 = (MemberScope) r1.invoke();
        if ((r2 instanceof AbstractScopeAdapter) == true) goto L5;
        return r2;
    L5:
        return ((AbstractScopeAdapter) r2).getActualScope();
    }

    public LazyScopeAdapter(StorageManager r2, final Function0<? extends MemberScope> r3) {
        Intrinsics.checkNotNullParameter(r2, "storageManager");
        Intrinsics.checkNotNullParameter(r3, "getScope");
        this.lazyScope = r2.createLazyValue(new LazyScopeAdapter$$Lambda$0(r3));
    }

    public /* synthetic */ LazyScopeAdapter(StorageManager r1, Function0 r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = LockBasedStorageManager.NO_LOCKS;
    L5:
        this(r1, r2);
    }
}
