package com.bytedance.ai.resource;

import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.model.objects.AIPackage;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIManager", f = "AIManager.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4}, l = {659, 666, 677, 693, 1163}, m = "loadAIPackage", n = {"this", "packageName", Constant.APPID, "packageType", "extraInfo", "installIfAbsent", "this", "packageName", Constant.APPID, "packageType", "extraInfo", "installIfAbsent", "start", "this", "packageName", Constant.APPID, "packageType", "extraInfo", "start", "this", "packageName", Constant.APPID, "packageType", "extraInfo", "start", "versionCode", "packageName", Constant.APPID, "extraInfo", "start", "versionCode"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "J$1", "L$0", "L$1", "L$2", "J$0", "J$1"})
final class AIManager$loadAIPackage$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f2468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f2470c;
    public AIPackage.AIPackageType d;
    public Map e;
    public boolean f;
    public long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f2471h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f2472i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ j f2473j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2474k;

    public AIManager$loadAIPackage$1(j r5, ContinuationImpl r10) {
        this.f2473j = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.f2472i = r10;
        this.f2474k |= Integer.MIN_VALUE;
        return this.f2473j.e(null, null, false, null, null, this);
    }
}
