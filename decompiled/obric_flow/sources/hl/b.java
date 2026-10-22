package hl;

import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f17337b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f17338a;

    static {
        CollectionsKt.emptyList();
    }

    public b(boolean r5, il.f... r10) {
        Intrinsics.checkNotNullParameter(r10, "sources");
        this.f17338a = ArraysKt.toList(r10);
    }
}
