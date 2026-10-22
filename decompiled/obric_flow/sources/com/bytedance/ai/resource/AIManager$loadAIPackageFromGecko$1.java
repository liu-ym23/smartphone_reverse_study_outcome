package com.bytedance.ai.resource;

import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.model.objects.AIPackage;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIManager", f = "AIManager.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {919}, m = "loadAIPackageFromGecko", n = {"this", "packageName", Constant.APPID, "packageType", "extraInfo", "aiPackage", "errMsg", "start$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0"})
final class AIManager$loadAIPackageFromGecko$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f2478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2480c;
    public AIPackage.AIPackageType d;
    public Map e;
    public Ref.ObjectRef f;
    public Ref.ObjectRef g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f2481h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public /* synthetic */ Object f2482i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ j f2483j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2484k;

    public AIManager$loadAIPackageFromGecko$1(j r5, ContinuationImpl r10) {
        this.f2483j = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.f2482i = r10;
        this.f2484k |= Integer.MIN_VALUE;
        j r5 = this.f2483j;
        j r11 = j.f2734a;
        return r5.b(null, null, null, null, this);
    }
}
