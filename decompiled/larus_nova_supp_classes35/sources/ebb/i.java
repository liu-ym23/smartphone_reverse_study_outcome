package ebb;

import android.content.Context;
import java.io.File;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Singleton
public final class i implements f {
    @Inject
    public i() {
    }

    @Override // ebb.f
    public final List<File> a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return CollectionsKt.emptyList();
    }

    @Override // ebb.f
    public final List<File> b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return CollectionsKt.emptyList();
    }
}
