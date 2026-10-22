package com.bytedance.ai.resource;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIPackageUpdateManager", f = "AIPackageUpdateManager.kt", i = {2}, l = {52, 55, 57, 105}, m = "checkUpdateAllAIPackages", n = {"inactiveAIPackages"}, s = {"L$0"})
final class AIPackageUpdateManager$checkUpdateAllAIPackages$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f2535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f2536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f2537c;
    public final /* synthetic */ s d;
    public int e;

    public AIPackageUpdateManager$checkUpdateAllAIPackages$1(s r5, ContinuationImpl r10) {
        this.d = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.f2537c = r5;
        this.e |= Integer.MIN_VALUE;
        return this.d.a(this);
    }
}
