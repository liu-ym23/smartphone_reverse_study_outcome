package com.bytedance.ai.resource;

import com.bytedance.ai.resource.core.AIPackageDeployment;
import com.bytedance.ai.resource.core.bean.AIPackageAppList;
import com.bytedance.ai.resource.core.bean.AIPackageInfoRequest;
import com.bytedance.ai.resource.core.bean.AIPackageNetworkResponse;
import com.bytedance.ai.resource.core.bean.AIPackageResponseItem;
import com.bytedance.ai.resource.core.bean.PackageRequestItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIPackageManager$installAIPackagesWithVersionCode$2", f = "AIPackageManager.kt", i = {}, l = {134}, m = "invokeSuspend", n = {}, s = {})
final class AIPackageManager$installAIPackagesWithVersionCode$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AIPackageManager.b $listener;
    final /* synthetic */ String $packageName;
    final /* synthetic */ long $versionCode;
    long J$0;
    Object L$0;
    Object L$1;
    int label;

    public AIPackageManager$installAIPackagesWithVersionCode$2(String r1, long r10, AIPackageManager.b r11, Continuation<? super AIPackageManager$installAIPackagesWithVersionCode$2> r12) {
        this.$packageName = r1;
        this.$versionCode = r10;
        this.$listener = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIPackageManager$installAIPackagesWithVersionCode$2(this.$packageName, this.$versionCode, this.$listener, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L9;
        if (r0 != 1) goto L8;
        long r1 = this.J$0;
        Iterator r11 = (Iterator) this.L$1;
        AIPackageManager.b r12 = (AIPackageManager.b) this.L$0;
        ResultKt.throwOnFailure(r19);
        long r13 = r1;
        Iterator r14 = r11;
    L6:
        AIPackageManager.b r15 = r12;
    L32:
        if (r14.hasNext() == false) goto L37;
        AIPackageDeployment.AIPackageDeploymentItem r16 = (AIPackageDeployment.AIPackageDeploymentItem) r14.next();
        AIPackageManager.a r17 = new AIPackageManager.a(r16.getAppId(), r16.getPackageName());
        AIPackageManager r18 = AIPackageManager.a;
        this.L$0 = r15;
        this.L$1 = r14;
        this.J$0 = r13;
        this.label = 1;
        if (AIPackageManager.j(r18, r17, r13, r15, this) != r10) goto L32;
        return r10;
    L37:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r19);
        com.bytedance.ai.utils.g r20 = com.bytedance.ai.utils.g.a;
        r20.d("AIPackageManager", "packageName: " + this.$packageName + ", versionCode: " + this.$versionCode + " ===> installAIPackage start");
        ConcurrentHashMap<String, AIPackageDeployment.AIPackageDeploymentItem> r21 = AIPackageDeployment.a;
        String r22 = this.$packageName;
        long r23 = this.$versionCode;
        Intrinsics.checkNotNullParameter(r22, "packageName");
        if (r23 <= 0) goto L12;
        String r24 = String.valueOf(r23);
    L13:
        boolean r110 = false;
        AIPackageInfoRequest r25 = new AIPackageInfoRequest(CollectionsKt.mutableListOf(new PackageRequestItem[]{new PackageRequestItem(r22, r24)}), null, null, 6, null);
        Lazy r111 = o5.b.a;
        Intrinsics.checkNotNullParameter(r25, "request");
        AIPackageNetworkResponse<AIPackageAppList> r26 = o5.b.a().requestPackageDeploymentInfo(r25);
        if (r26.getCode() != 0) goto L17;
        r110 = true;
    L17:
        if (r110 == false) goto L28;
        AIPackageAppList r27 = r26.getData();
        r20.i("AIPackageManager", "packageName: " + r22 + " , versionCode: " + r24 + " ===> Successful request for all Applets/Widgets under the specified Package : " + r27);
        ArrayList r28 = new ArrayList();
        if (r27 == null) goto L29;
        List<AIPackageResponseItem> r29 = r27.getAppList();
        if (r29 == null) goto L29;
        Iterator<T> r30 = r29.iterator();
    L24:
        if (r30.hasNext() == false) goto L29;
        AIPackageDeployment.AIPackageDeploymentItem r31 = AIPackageDeployment.c((AIPackageResponseItem) r30.next());
        if (r31 == null) goto L24;
        r28.add(r31);
    L29:
        if (r28 == null) goto L46;
        long r32 = this.$versionCode;
        r12 = this.$listener;
        r14 = r28.iterator();
        r13 = r32;
        goto L6
    L46:
        return null;
    L28:
        r20.e("AIPackageManager", "packageName: " + r22 + ", versionCode: " + r24 + " ===> Failed request for all Applets/Widgets under the specified Package : code = " + r26.getCode() + ", msg = " + r26.getMsg());
        r28 = null;
        goto L29
    L12:
        r24 = "";
        goto L13
    }
}
