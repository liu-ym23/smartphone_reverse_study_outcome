package com.bytedance.ai.resource;

import android.content.Context;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIPackageManager", f = "AIPackageManager.kt", i = {0, 0, 0, 1}, l = {80, 83}, m = "init", n = {"this", "context", "exclusionList", "context"}, s = {"L$0", "L$1", "L$2", "L$0"})
final class AIPackageManager$init$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f2511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f2512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set f2513c;
    public /* synthetic */ Object d;
    public final /* synthetic */ r e;
    public int f;

    public AIPackageManager$init$1(r r5, ContinuationImpl r10) {
        this.e = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.d = r10;
        this.f |= Integer.MIN_VALUE;
        return this.e.c(null, false, false, null, this);
    }
}
