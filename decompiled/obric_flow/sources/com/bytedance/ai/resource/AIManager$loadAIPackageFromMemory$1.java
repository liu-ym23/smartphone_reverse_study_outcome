package com.bytedance.ai.resource;

import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.model.objects.AIPackage;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIManager", f = "AIManager.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {547, 549}, m = "loadAIPackageFromMemory", n = {"this", "packageName", Constant.APPID, "packageType", "this", "packageName", Constant.APPID, "packageType"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
final class AIManager$loadAIPackageFromMemory$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f2485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2487c;
    public AIPackage.AIPackageType d;
    public /* synthetic */ Object e;
    public final /* synthetic */ j f;
    public int g;

    public AIManager$loadAIPackageFromMemory$1(j r5, ContinuationImpl r10) {
        this.f = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.e = r5;
        this.g |= Integer.MIN_VALUE;
        j r10 = this.f;
        j r11 = j.f2734a;
        return r10.m(null, null, null, this);
    }
}
