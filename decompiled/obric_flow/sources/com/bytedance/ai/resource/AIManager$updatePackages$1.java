package com.bytedance.ai.resource;

import androidx.recyclerview.widget.ItemTouchHelper;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIManager", f = "AIManager.kt", i = {0, 0}, l = {246, 248, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION}, m = "updatePackages", n = {"this", "packageName"}, s = {"L$0", "L$1"})
final class AIManager$updatePackages$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f2502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f2504c;
    public final /* synthetic */ j d;
    public int e;

    public AIManager$updatePackages$1(j r5, ContinuationImpl r10) {
        this.d = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f2504c = r5;
        this.e |= Integer.MIN_VALUE;
        return this.d.g(null, this);
    }
}
