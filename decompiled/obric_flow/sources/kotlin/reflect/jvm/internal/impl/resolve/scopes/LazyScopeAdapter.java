package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: loaded from: classes3.dex */
public final class LazyScopeAdapter extends AbstractScopeAdapter {
    private final NotNullLazyValue<MemberScope> lazyScope;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public LazyScopeAdapter(Function0<? extends MemberScope> r5) {
        Intrinsics.checkNotNullParameter(r5, "getScope");
        this(null, r5, 1, 0 == true ? 1 : 0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter
    public MemberScope getWorkerScope() {
        return this.lazyScope.invoke();
    }

    public /* synthetic */ LazyScopeAdapter(StorageManager r5, Function0 r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r5 = LockBasedStorageManager.NO_LOCKS;
    L5:
        this(r5, r10);
    }

    @JvmOverloads
    public LazyScopeAdapter(StorageManager r5, final Function0<? extends MemberScope> r10) {
        Intrinsics.checkNotNullParameter(r5, "storageManager");
        Intrinsics.checkNotNullParameter(r10, "getScope");
        this.lazyScope = r5.createLazyValue(new LazyScopeAdapter$lazyScope$1(r10));
    }
}
