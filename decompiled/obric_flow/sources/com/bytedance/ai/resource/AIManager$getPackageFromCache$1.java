package com.bytedance.ai.resource;

import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.model.objects.AIPackage;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIManager", f = "AIManager.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2}, l = {1167, 766, 775}, m = "getPackageFromCache", n = {"packageName", Constant.APPID, "packageType", "$this$withLock_u24default$iv", "packageName", Constant.APPID, "packageType", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0"})
final class AIManager$getPackageFromCache$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f2462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AIPackage.AIPackageType f2464c;
    public kotlinx.coroutines.sync.a d;
    public /* synthetic */ Object e;
    public final /* synthetic */ j f;
    public int g;

    public AIManager$getPackageFromCache$1(j r5, ContinuationImpl r10) {
        this.f = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.e = r5;
        this.g |= Integer.MIN_VALUE;
        j r10 = this.f;
        j r11 = j.f2734a;
        return r10.c(null, null, null, this);
    }
}
