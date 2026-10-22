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
    public LazyScopeAdapter(Function0<? extends MemberScope> r10) {
        Intrinsics.checkNotNullParameter(r10, "getScope");
        this(null, r10, 1, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public LazyScopeAdapter(StorageManager r10, final Function0<? extends MemberScope> r11) {
        Intrinsics.checkNotNullParameter(r10, "storageManager");
        Intrinsics.checkNotNullParameter(r11, "getScope");
        this.lazyScope = r10.createLazyValue(new LazyScopeAdapter$lazyScope$1(r11));
    }

    public /* synthetic */ LazyScopeAdapter(StorageManager r10, Function0 r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        r10 = LockBasedStorageManager.NO_LOCKS;
        Intrinsics.checkNotNullExpressionValue(r10, "NO_LOCKS");
    L5:
        this(r10, r11);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter
    protected MemberScope getWorkerScope() {
        return this.lazyScope.invoke();
    }
}
