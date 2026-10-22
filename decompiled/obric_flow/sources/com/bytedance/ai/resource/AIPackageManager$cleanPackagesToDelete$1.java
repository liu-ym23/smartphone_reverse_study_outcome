package com.bytedance.ai.resource;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIPackageManager", f = "AIPackageManager.kt", i = {0, 1, 1, 2}, l = {577, 581, 590}, m = "cleanPackagesToDelete", n = {"exclusionList", "exclusionList", "fileListToDelete", "fileListToDelete"}, s = {"L$0", "L$0", "L$1", "L$0"})
final class AIPackageManager$cleanPackagesToDelete$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Set f2505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f2506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Iterator f2507c;
    public /* synthetic */ Object d;
    public final /* synthetic */ r e;
    public int f;

    public AIPackageManager$cleanPackagesToDelete$1(r r5, ContinuationImpl r10) {
        this.e = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.d = r5;
        this.f |= Integer.MIN_VALUE;
        r r10 = this.e;
        r r11 = r.f2752a;
        return r10.h(null, this);
    }
}
