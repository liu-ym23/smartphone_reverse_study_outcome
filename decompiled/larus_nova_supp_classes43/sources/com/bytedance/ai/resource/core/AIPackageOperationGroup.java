package com.bytedance.ai.resource.core;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.AIPackageManager;
import com.bytedance.ai.resource.core.bean.AIPackageManifestBean;
import com.bytedance.ai.resource.core.operations.AbsAIPackageOperation;
import com.bytedance.ai.resource.core.operations.BaseAIPackageHelper;
import com.bytedance.ai.utils.f;
import com.bytedance.ai.utils.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AIPackageOperationGroup {
    public final ConcurrentHashMap<String, AbsAIPackageOperation> a;
    public final ConcurrentHashMap<String, Deferred<AbsAIPackageOperation.a>> b;
    public final ConcurrentHashMap<String, ConcurrentLinkedQueue<a>> c;
    public final ConcurrentHashMap<String, AIPackageManifestBean> d;

    public static final class a {
        public final AIPackageDeployment.AIPackageDeploymentItem a;
        public final AIPackage.PackageStatus b;
        public final AIPackageManager.b c;
        public final boolean d;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r11.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r11.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            AIPackageManager.b r1 = this.c;
            if (r1 != null) goto L5;
            int r10 = 0;
        L6:
            int r11 = (r0 + r10) * 31;
            if (this.d == false) goto L9;
            int r12 = 1231;
        L11:
            return r11 + r12;
        L9:
            r12 = 1237;
            goto L11
        L5:
            r10 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "Action(deploymentInfo=" + this.a + ", type=" + this.b + ", listener=" + this.c + ", onlyInMemory=" + this.d + ')';
        }

        public final AIPackage.PackageStatus getType() {
            return this.b;
        }

        public a(AIPackageDeployment.AIPackageDeploymentItem r10, AIPackage.PackageStatus r11, AIPackageManager.b r12, boolean r13) {
            Intrinsics.checkNotNullParameter(r10, "deploymentInfo");
            Intrinsics.checkNotNullParameter(r11, "type");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r13;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AIPackage.PackageStatus.values().length];
            r0[AIPackage.PackageStatus.INSTALLING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[AIPackage.PackageStatus.UPDATING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[AIPackage.PackageStatus.DELETING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public AIPackageOperationGroup() {
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
    }

    public static String f(String r1, long r10) {
        return r1 + '_' + r10;
    }

    public final Object i(AIPackageDeployment.AIPackageDeploymentItem r10, Continuation<? super AbsAIPackageOperation.a> r11) {
        return BuildersKt.withContext(com.bytedance.ai.infra.thread_pool.b.a, new AIPackageOperationGroup$loadAppletBasePackage$2(r10, this, null), r11);
    }

    public final Object j(AIPackageDeployment.AIPackageDeploymentItem r13, Continuation<? super AbsAIPackageOperation.a> r14) {
        if ((r14 instanceof AIPackageOperationGroup$loadManifestBean$1) == false) goto L7;
        AIPackageOperationGroup$loadManifestBean$1 r0 = (AIPackageOperationGroup$loadManifestBean$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = r0.label;
        if (r11 == 0) goto L14;
        if (r11 != 1) goto L13;
        r13 = (AIPackageDeployment.AIPackageDeploymentItem) r0.L$0;
        ResultKt.throwOnFailure(r15);
    L23:
        AbsAIPackageOperation.a r16 = (AbsAIPackageOperation.a) r15;
        if (Intrinsics.areEqual(r16.c, r13.getAppId()) == true) goto L27;
        String r12 = r13.getAppId();
        AIPackage r17 = r16.a;
        String r18 = r16.b;
        AIPackage.AIPackageType r19 = r16.d;
        int r20 = r16.e;
        String r21 = r16.f;
        Intrinsics.checkNotNullParameter(r18, "packageName");
        Intrinsics.checkNotNullParameter(r12, BdpAwemeConstant.KEY_APP_ID);
        Intrinsics.checkNotNullParameter(r19, "packageType");
        return new AbsAIPackageOperation.a(r17, r18, r12, r19, r20, r21);
    L27:
        return r16;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        final String r110 = f(r13.getPackageName(), r13.getVersionCode());
        BaseAIPackageHelper r22 = new BaseAIPackageHelper(r13);
        ConcurrentHashMap<String, Deferred<AbsAIPackageOperation.a>> r23 = this.b;
        final Deferred<AbsAIPackageOperation.a> r24 = r23.get(r110);
        if (r24 != null) goto L20;
        r24 = BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.a), null, CoroutineStart.LAZY, new AIPackageOperationGroup$loadManifestBean$job$1$1(r22, this, r13, null), 1, null);
        r24.invokeOnCompletion(new c(this, r110, r24));
        Deferred<AbsAIPackageOperation.a> r111 = r23.putIfAbsent(r110, r24);
        if (r111 == null) goto L20;
        r24 = r111;
    L20:
        r0.L$0 = r13;
        r0.label = 1;
        r15 = r24.await(r0);
        if (r15 != r10) goto L23;
        return r10;
    L7:
        r0 = new AIPackageOperationGroup$loadManifestBean$1(this, r14);
        goto L8
    }

    public final Object k(AbsAIPackageOperation.a r13, Continuation<? super Unit> r14) {
        g r0 = g.a;
        StringBuilder r1 = new StringBuilder("operationEnd ===> packageName: ");
        r1.append(r13.b);
        r1.append(", appId: ");
        r1.append(r13.c);
        r1.append(", code: ");
        r1.append(r13.e);
        r1.append(", msg: ");
        String r10 = r13.f;
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        r1.append(r10);
        r0.i("AIPackageManager", r1.toString());
        AbsAIPackageOperation r11 = this.a.remove(r13.c);
        if (r11 == null) goto L15;
        Intrinsics.checkNotNullParameter(r13, com.bytedance.android.ec.core.event.a.KEY_RESULT);
        r11.e = r13;
        r11.d.set(true);
        Iterator<Continuation<AbsAIPackageOperation.a>> r12 = r11.g.iterator();
    L9:
        if (r12.hasNext() == false) goto L11;
        Continuation<AbsAIPackageOperation.a> r15 = r12.next();
        Intrinsics.checkNotNull(r15);
        r15.resumeWith(Result.constructor-impl(r13));
        goto L9
    L11:
        Iterator<AIPackageManager.b> r16 = r11.f.iterator();
    L13:
        if (r16.hasNext() == false) goto L15;
        r16.next().a(r13.a, r13.b, r13.c, r13.d, r13.e, r13.f);
        g.a.d("AIPackageManager", "packageName: " + r13.b + ", appId: " + r13.c + " ===> installAIPackage notify listener");
    L15:
        ConcurrentLinkedQueue<a> r17 = this.c.get(r13.c);
        if (r17 != null) goto L18;
    L21:
        boolean r18 = true;
    L22:
        if (r18 == false) goto L24;
        Object r19 = Unit.INSTANCE;
    L52:
        if (r19 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L55;
        return r19;
    L55:
        return Unit.INSTANCE;
    L24:
        a r110 = r17.poll();
        if (r110 == null) goto L50;
        int r20 = b.a[r110.getType().ordinal()];
        if (r20 == 1) goto L42;
        if (r20 != 2) goto L31;
        r19 = m(r110.a, r110.c, r14);
        if (r19 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L52;
        r19 = Unit.INSTANCE;
        goto L52
    L31:
        if (r20 != 3) goto L50;
        r19 = l(r110.a, r110.c, r14);
        if (r19 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L52;
        r19 = Unit.INSTANCE;
        goto L52
    L42:
        if (r110.d == false) goto L46;
        r19 = h(this, r110.a, r110.c, r14);
        if (r19 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L52;
    L49:
        r19 = Unit.INSTANCE;
        goto L52
    L46:
        r19 = g(this, r110.a, r110.c, r14);
        if (r19 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L49;
    L50:
        r19 = Unit.INSTANCE;
        goto L52
    L18:
        if (r17.isEmpty() == true) goto L21;
        r18 = false;
        goto L22
    }

    public final Object l(AIPackageDeployment.AIPackageDeploymentItem r10, AIPackageManager.b r11, Continuation<? super Unit> r12) {
        Object r13 = BuildersKt.withContext(com.bytedance.ai.infra.thread_pool.b.a, new AIPackageOperationGroup$uninstallAIPackage$2(r10, r11, this, null), r12);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r13;
    L6:
        return Unit.INSTANCE;
    }

    public final Object m(AIPackageDeployment.AIPackageDeploymentItem r10, AIPackageManager.b r11, Continuation<? super Unit> r12) {
        Object r13 = BuildersKt.withContext(com.bytedance.ai.infra.thread_pool.b.a, new AIPackageOperationGroup$updateAIPackage$2(r10, r11, this, null), r12);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r13;
    L6:
        return Unit.INSTANCE;
    }

    public static final Object a(AIPackageOperationGroup r17, AIPackageDeployment.AIPackageDeploymentItem r18, AbsAIPackageOperation r19, Continuation r20) {
        AbsAIPackageOperation r0 = r19;
        r17.getClass();
        if ((r20 instanceof AIPackageOperationGroup$downloadAIPackage$1) == false) goto L7;
        AIPackageOperationGroup$downloadAIPackage$1 r10 = (AIPackageOperationGroup$downloadAIPackage$1) r20;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r1 = r10.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r10.label;
        boolean r14 = false;
        if (r13 == 0) goto L14;
        if (r13 != 1) goto L13;
        int r15 = r10.I$0;
        AbsAIPackageOperation r16 = (AbsAIPackageOperation) r10.L$1;
        AIPackageDeployment.AIPackageDeploymentItem r21 = (AIPackageDeployment.AIPackageDeploymentItem) r10.L$0;
        ResultKt.throwOnFailure(r1);
        int r22 = r15;
        r0 = r16;
        Object r23 = r1;
        AIPackageDeployment.AIPackageDeploymentItem r24 = r21;
    L19:
        if (((Boolean) r23).booleanValue() == true) goto L21;
        g.a.e("AIPackageManager", "packageName: " + r24.getPackageName() + ", appId: " + r24.getAppId() + " ===> download failed");
        int r110 = 2;
    L23:
        if (r0.a == null) goto L25;
        r14 = true;
    L25:
        if (r14 == false) goto L27;
        AIPackage r25 = r0.e();
    L28:
        r12 = new AbsAIPackageOperation.a(r25, r24.getPackageName(), r24.getAppId(), AIPackage.AIPackageType.UNKNOWN, r110, 32);
    L29:
        return r12;
    L27:
        r25 = null;
        goto L28
    L21:
        g.a.i("AIPackageManager", "packageName: " + r24.getPackageName() + ", appId: " + r24.getAppId() + " ===> download successful");
        r110 = r22;
        goto L23
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        r24 = r18;
        r10.L$0 = r24;
        r10.L$1 = r0;
        r10.I$0 = 0;
        r10.label = 1;
        Object r26 = r0.c(r10);
        if (r26 == r12) goto L29;
        r23 = r26;
        r22 = 0;
    L7:
        r10 = new AIPackageOperationGroup$downloadAIPackage$1(r17, r20);
        goto L8
    }

    public static final Object b(AIPackageOperationGroup r17, AbsAIPackageOperation r18, AIPackageDeployment.AIPackageDeploymentItem r19, Continuation r20) {
        r17.getClass();
        if ((r20 instanceof AIPackageOperationGroup$operationRun$1) == false) goto L7;
        AIPackageOperationGroup$operationRun$1 r10 = (AIPackageOperationGroup$operationRun$1) r20;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.label;
        if (r14 == 0) goto L16;
        if (r14 == 1) goto L15;
        if (r14 != 2) goto L14;
        ResultKt.throwOnFailure(r12);
    L36:
        return r12;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        AbsAIPackageOperation r0 = (AbsAIPackageOperation) r10.L$0;
        ResultKt.throwOnFailure(r12);
    L25:
        Iterator r1 = ((Iterable) r12).iterator();
    L27:
        if (r1.hasNext() == false) goto L32;
        AbsAIPackageOperation.a r15 = (AbsAIPackageOperation.a) r1.next();
        if (r15.e == 0) goto L27;
        return r15;
    L32:
        r10.L$0 = null;
        r10.label = 2;
        r12 = r0.g(r10);
        if (r12 != r13) goto L36;
        return r13;
    L16:
        ResultKt.throwOnFailure(r12);
        r18.h(r19);
        if (r19.getVersionCode() != (-1)) goto L19;
        boolean r16 = true;
    L20:
        if (r16 == true) goto L31;
        ArrayList r21 = new ArrayList();
        com.bytedance.ai.infra.thread_pool.a r22 = com.bytedance.ai.infra.thread_pool.b.a;
        r21.add(BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(r22), null, null, new AIPackageOperationGroup$operationRun$2(r17, r19, r18, null), 3, null));
        r21.add(BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(r22), null, null, new AIPackageOperationGroup$operationRun$3(r17, r19, r18, null), 3, null));
        r10.L$0 = r18;
        r10.label = 1;
        r12 = AwaitKt.a(r21, r10);
        if (r12 == r13) goto L41;
        r0 = r18;
        goto L25
    L41:
        return r13;
    L31:
        r0 = r18;
        goto L32
    L19:
        r16 = false;
    L7:
        r10 = new AIPackageOperationGroup$operationRun$1(r17, r20);
        goto L8
    }

    public static final Object c(AIPackageOperationGroup r11, AIPackageDeployment.AIPackageDeploymentItem r12, AbsAIPackageOperation r13, Continuation r14) {
        r11.getClass();
        if ((r14 instanceof AIPackageOperationGroup$setManifestData$1) == false) goto L7;
        AIPackageOperationGroup$setManifestData$1 r0 = (AIPackageOperationGroup$setManifestData$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r0.label;
        boolean r17 = true;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        r13 = (AbsAIPackageOperation) r0.L$1;
        r12 = (AIPackageDeployment.AIPackageDeploymentItem) r0.L$0;
        ResultKt.throwOnFailure(r15);
    L21:
        AbsAIPackageOperation.a r18 = (AbsAIPackageOperation.a) r15;
        int r19 = r18.e;
        Object r20 = r18;
        if (r19 != 0) goto L43;
        AIPackageManifestBean r110 = r11.d.get(f(r12.getPackageName(), r12.getVersionCode()));
    L25:
        r13.getClass();
        if (r110 == null) goto L29;
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        r13.b = r110;
    L29:
        if (r13.b == null) goto L31;
        boolean r111 = true;
    L32:
        if (r111 == true) goto L34;
        g.a.e("AIPackageManager", "packageName: " + r12.getPackageName() + ", appId: " + r12.getAppId() + " ===> read base_" + r12.getVersionCode() + " error");
        int r21 = 6;
    L36:
        if (r13.a != null) goto L39;
        r17 = false;
    L39:
        if (r17 == false) goto L41;
        AIPackage r112 = r13.e();
    L42:
        r20 = new AbsAIPackageOperation.a(r112, r12.getPackageName(), r12.getAppId(), AIPackage.AIPackageType.UNKNOWN, r21, 32);
        goto L43
    L41:
        r112 = null;
        goto L42
    L34:
        r21 = 0;
        goto L36
    L31:
        r111 = false;
    L43:
        return r20;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        r110 = r11.d.get(f(r12.getPackageName(), r12.getVersionCode()));
        if (r110 != null) goto L17;
    L18:
        r0.L$0 = r12;
        r0.L$1 = r13;
        r0.label = 1;
        r15 = r11.j(r12, r0);
        r20 = r10;
        if (r15 != r10) goto L21;
    L17:
        if (f.a(com.bytedance.ai.resource.core.a.d(r12)) == true) goto L25;
    L7:
        r0 = new AIPackageOperationGroup$setManifestData$1(r11, r14);
        goto L8
    }

    public static Object g(AIPackageOperationGroup r10, AIPackageDeployment.AIPackageDeploymentItem r11, AIPackageManager.b r12, Continuation r13) {
        r10.getClass();
        Object r14 = BuildersKt.withContext(com.bytedance.ai.infra.thread_pool.b.a, new AIPackageOperationGroup$installAIPackage$2(r11, "installed", r10, r12, null), r13);
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r14;
    L6:
        return Unit.INSTANCE;
    }

    public static Object h(AIPackageOperationGroup r10, AIPackageDeployment.AIPackageDeploymentItem r11, AIPackageManager.b r12, Continuation r13) {
        r10.getClass();
        Object r14 = BuildersKt.withContext(com.bytedance.ai.infra.thread_pool.b.a, new AIPackageOperationGroup$installAIPackageInMemory$2(r11, "installed", r10, r12, null), r13);
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r14;
    L6:
        return Unit.INSTANCE;
    }

    public final void d(AIPackageDeployment.AIPackageDeploymentItem r10, AIPackage.PackageStatus r11, AIPackageManager.b r12, boolean r13) {
        boolean r14 = true;
        if (r10.getVersionCode() != 0) goto L5;
        boolean r0 = true;
    L6:
        AIPackage.PackageStatus r1 = null;
        if (r0 == false) goto L19;
        AbsAIPackageOperation r15 = this.a.get(r10.getAppId());
        if (r15 == null) goto L11;
        AIPackage.PackageStatus r16 = r15.j();
    L12:
        AIPackage.PackageStatus r17 = AIPackage.PackageStatus.INSTALLING;
        if (r16 != r17) goto L19;
        if (r11 != r17) goto L19;
        if (r12 == null) goto L40;
        AbsAIPackageOperation r18 = this.a.get(r10.getAppId());
        if (r18 == null) goto L41;
        r18.f(r12);
        return;
    L41:
        return;
    L40:
        return;
    L11:
        r16 = null;
    L19:
        AbsAIPackageOperation r19 = this.a.get(r10.getAppId());
        if (r19 == null) goto L26;
        AIPackageDeployment.AIPackageDeploymentItem r20 = r19.d();
        if (r20 == null) goto L26;
        if (r10.getVersionCode() != r20.getVersionCode()) goto L26;
    L27:
        if (r14 == false) goto L36;
        AbsAIPackageOperation r21 = this.a.get(r10.getAppId());
        if (r21 == null) goto L31;
        r1 = r21.j();
    L31:
        if (r11 != r1) goto L36;
        if (r12 == null) goto L43;
        AbsAIPackageOperation r22 = this.a.get(r10.getAppId());
        if (r22 == null) goto L44;
        r22.f(r12);
        return;
    L44:
        return;
    L43:
        return;
    L36:
        this.c.putIfAbsent(r10.getAppId(), new ConcurrentLinkedQueue());
        ConcurrentLinkedQueue<a> r23 = this.c.get(r10.getAppId());
        if (r23 == null) goto L46;
        r23.offer(new a(r10, r11, r12, r13));
        return;
    L46:
        return;
    L26:
        r14 = false;
        goto L27
    L5:
        r0 = false;
        goto L6
    }

    public final Object e(AIPackage r14, AIPackageDeployment.AIPackageDeploymentItem r15, boolean r16, Continuation<? super Boolean> r17) {
        if ((r17 instanceof AIPackageOperationGroup$checkOldPackageVersion$1) == false) goto L7;
        AIPackageOperationGroup$checkOldPackageVersion$1 r10 = (AIPackageOperationGroup$checkOldPackageVersion$1) r17;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        AIPackageOperationGroup$checkOldPackageVersion$1 r12 = r10;
        Object r1 = r12.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r18 = r12.label;
        if (r18 == 0) goto L14;
        if (r18 != 1) goto L13;
        ResultKt.throwOnFailure(r1);
    L31:
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        if (r15.getVersionCode() != 0) goto L17;
        boolean r19 = true;
    L18:
        if (r19 == false) goto L20;
    L27:
        g.a.i("AIPackageManager", "packageName: " + r15.getPackageName() + ", appId: " + r15.getAppId() + " ===> AIPackage installs the same version");
        AbsAIPackageOperation.a r110 = new AbsAIPackageOperation.a(r14, r14.b, r14.a(), r14.c(), 0, 32);
        r12.label = 1;
        if (k(r110, r12) != r13) goto L31;
        return r13;
    L20:
        if (r14.c == r15.getVersionCode()) goto L27;
        if (r16 == false) goto L26;
        if (r14.c > r15.getVersionCode()) goto L27;
    L26:
        return Boxing.boxBoolean(true);
    L17:
        r19 = false;
    L7:
        r10 = new AIPackageOperationGroup$checkOldPackageVersion$1(this, r17);
        goto L8
    }
}
