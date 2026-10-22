package androidx.lifecycle.viewmodel;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class MutableCreationExtras extends CreationExtras {
    /* JADX WARN: Multi-variable type inference failed */
    public MutableCreationExtras() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public MutableCreationExtras(CreationExtras r10) {
        Intrinsics.checkNotNullParameter(r10, "initialExtras");
        getMap$lifecycle_viewmodel_release().putAll(r10.getMap$lifecycle_viewmodel_release());
    }

    public /* synthetic */ MutableCreationExtras(CreationExtras r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = CreationExtras.Empty.INSTANCE;
    L5:
        this(r10);
    }

    @Override // androidx.lifecycle.viewmodel.CreationExtras
    public <T> T get(CreationExtras.Key<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "key");
        return (T) getMap$lifecycle_viewmodel_release().get(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> void set(CreationExtras.Key<T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        getMap$lifecycle_viewmodel_release().put(r10, r11);
    }
}
