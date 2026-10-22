package com.bytedance.ai.resource.core;

import androidx.constraintlayout.motion.widget.a;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.ex.widget.model.MiniAppWidgetAvailability;
import com.bytedance.ai.model.m;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.core.bean.AIPackageManifestBean;
import com.bytedance.ai.resource.core.operations.AbsAIPackageOperation;
import com.bytedance.ai.resource.core.operations.BaseAIPackageHelper;
import com.bytedance.ai.resource.l;
import com.bytedance.ai.resource.y;
import com.lynx.tasm.utils.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import jm.c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.r1;
import t0.d;
import t2.b;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ai/resource/core/AIPackageOperationGroup;", "", "Action", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAIPackageOperationGroup.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIPackageOperationGroup.kt\ncom/bytedance/ai/resource/core/AIPackageOperationGroup\n+ 2 AIPackageDeployment.kt\ncom/bytedance/ai/resource/core/AIPackageDeployment$AIPackageDeploymentItem\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 6 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,620:1\n164#2:621\n161#2:624\n161#2:629\n1863#3,2:622\n1#4:625\n1#4:628\n72#5,2:626\n216#6,2:630\n216#6,2:632\n216#6,2:634\n*S KotlinDebug\n*F\n+ 1 AIPackageOperationGroup.kt\ncom/bytedance/ai/resource/core/AIPackageOperationGroup\n*L\n283#1:621\n343#1:624\n485#1:629\n303#1:622,2\n399#1:628\n399#1:626,2\n585#1:630,2\n604#1:632,2\n611#1:634,2\n*E\n"})
public final class AIPackageOperationGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f2574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f2575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f2576c;
    public final ConcurrentHashMap d;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/resource/core/AIPackageOperationGroup$Action;", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AIPackageDeployment.AIPackageDeploymentItem f2577a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AIPackage.PackageStatus f2578b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final l f2579c;
        public final boolean d;

        public Action(AIPackageDeployment.AIPackageDeploymentItem r5, AIPackage.PackageStatus r10, l r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r5, "deploymentInfo");
            Intrinsics.checkNotNullParameter(r10, "type");
            this.f2577a = r5;
            this.f2578b = r10;
            this.f2579c = r11;
            this.d = r12;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Action) == true) goto L8;
            return false;
        L8:
            Action r10 = (Action) r5;
            if (Intrinsics.areEqual(this.f2577a, r10.f2577a) == true) goto L12;
            return false;
        L12:
            if (this.f2578b == r10.f2578b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f2579c, r10.f2579c) == true) goto L18;
            return false;
        L18:
            if (this.d == r10.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r5 = this.f2577a.hashCode() * 31;
            int r10 = (this.f2578b.hashCode() + r5) * 31;
            l r11 = this.f2579c;
            if (r11 != null) goto L5;
            int r12 = 0;
        L6:
            int r13 = Boolean.hashCode(this.d);
            return r13 + ((r10 + r12) * 31);
        L5:
            r12 = r11.hashCode();
            goto L6
        }

        public final String toString() {
            StringBuilder r5 = new StringBuilder("Action(deploymentInfo=");
            r5.append(this.f2577a);
            r5.append(", type=");
            r5.append(this.f2578b);
            r5.append(", listener=");
            r5.append(this.f2579c);
            r5.append(", onlyInMemory=");
            return a.w(r5, this.d, ')');
        }
    }

    public AIPackageOperationGroup() {
        this.f2574a = new ConcurrentHashMap();
        this.f2575b = new ConcurrentHashMap();
        this.f2576c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
    }

    public static final Object a(AIPackageOperationGroup r10, AIPackageDeployment.AIPackageDeploymentItem r11, AbsAIPackageOperation r12, ContinuationImpl r13) {
        r10.getClass();
        if ((r13 instanceof AIPackageOperationGroup$downloadAIPackage$1) == false) goto L7;
        AIPackageOperationGroup$downloadAIPackage$1 r5 = (AIPackageOperationGroup$downloadAIPackage$1) r13;
        int r14 = r5.e;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r5.e = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r5.f2585c;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r5.e;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        r12 = r5.f2584b;
        r11 = r5.f2583a;
        ResultKt.throwOnFailure(r15);
    L18:
        if (((Boolean) r15).booleanValue() == true) goto L24;
        StringBuilder r18 = new StringBuilder("packageName: ");
        c.f(r11, r18, ", appId: ");
        r18.append(r11.getAppId());
        r18.append(" ===> download failed");
        String r19 = r18.toString();
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r110 = com.bytedance.ai.utils.c.f2846a;
        if (r110 == null) goto L22;
        r110.e("AIPackageManager", r19);
    L22:
        int r20 = 2;
    L23:
        int r21 = r20;
        y r22 = y.f2766a;
        String r23 = r11.getPackageName();
        String r111 = r11.getAppId();
        if (r21 != 0) goto L31;
        String r24 = "READY";
    L32:
        y.e(r23, r111, "download", r24, com.lynx.jsbridge.a.d(r21, "errorCode="));
        if (r12.f2687a == null) goto L36;
        AIPackage r25 = r12.b();
    L35:
        AIPackage r26 = r25;
        return new AbsAIPackageOperation.Result(r26, r11.getPackageName(), r11.getAppId(), AIPackage.AIPackageType.f2281c, r21, null);
    L36:
        r25 = null;
        goto L35
    L31:
        r24 = MiniAppWidgetAvailability.INSTALL_STATE_FAILED;
        goto L32
    L24:
        StringBuilder r27 = new StringBuilder("packageName: ");
        c.f(r11, r27, ", appId: ");
        r27.append(r11.getAppId());
        r27.append(" ===> download successful");
        String r28 = r27.toString();
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r112 = com.bytedance.ai.utils.c.f2846a;
        if (r112 == null) goto L27;
        r112.i("AIPackageManager", r28);
    L27:
        r20 = 0;
        goto L23
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        r5.f2583a = r11;
        r5.f2584b = r12;
        r5.e = 1;
        r15 = r12.a(r5);
        if (r15 != r16) goto L18;
        return r16;
    L7:
        r5 = new AIPackageOperationGroup$downloadAIPackage$1(r10, r13);
        goto L8
    }

    public static final Object b(AIPackageOperationGroup r10, AIPackageDeployment.AIPackageDeploymentItem r11, AbsAIPackageOperation r12, ContinuationImpl r13) {
        r10.getClass();
        if ((r13 instanceof AIPackageOperationGroup$setManifestData$1) == false) goto L7;
        AIPackageOperationGroup$setManifestData$1 r5 = (AIPackageOperationGroup$setManifestData$1) r13;
        int r14 = r5.f;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r5.f = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r5.d;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r5.f;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        r12 = r5.f2609c;
        r11 = r5.f2608b;
        r10 = r5.f2607a;
        ResultKt.throwOnFailure(r15);
    L19:
        AbsAIPackageOperation.Result r18 = (AbsAIPackageOperation.Result) r15;
        if (r18.e == 0) goto L22;
        return r18;
    L22:
        String r19 = r11.getPackageName();
        long r20 = r11.getVersionCode();
        AIPackageManifestBean r110 = (AIPackageManifestBean) r10.d.get(r19 + '_' + r20);
    L23:
        r12.getClass();
        if (r110 == null) goto L27;
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        r12.f2688b = r110;
    L27:
        if (r12.f2688b == null) goto L30;
        int r21 = 0;
    L29:
        int r22 = r21;
        y r23 = y.f2766a;
        String r24 = r11.getPackageName();
        String r111 = r11.getAppId();
        if (r22 != 0) goto L37;
        String r25 = "READY";
    L38:
        y.e(r24, r111, "manifest", r25, com.lynx.jsbridge.a.d(r22, "errorCode="));
        if (r12.f2687a == null) goto L42;
        AIPackage r112 = r12.b();
    L44:
        return new AbsAIPackageOperation.Result(r112, r11.getPackageName(), r11.getAppId(), AIPackage.AIPackageType.f2281c, r22, null);
    L42:
        r112 = null;
        goto L44
    L37:
        r25 = MiniAppWidgetAvailability.INSTALL_STATE_FAILED;
        goto L38
    L30:
        String r26 = "packageName: " + r11.getPackageName() + ", appId: " + r11.getAppId() + " ===> read base_" + r11.getVersionCode() + " error";
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r27 = com.bytedance.ai.utils.c.f2846a;
        if (r27 == null) goto L33;
        r27.e("AIPackageManager", r26);
    L33:
        r21 = 6;
        goto L29
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        String r113 = r11.getPackageName();
        long r28 = r11.getVersionCode();
        r110 = (AIPackageManifestBean) r10.d.get(r113 + '_' + r28);
        if (r110 != null) goto L23;
        r5.f2607a = r10;
        r5.f2608b = r11;
        r5.f2609c = r12;
        r5.f = 1;
        r15 = r10.a(r11, r5);
        if (r15 != r16) goto L19;
        return r16;
    L7:
        r5 = new AIPackageOperationGroup$setManifestData$1(r10, r13);
        goto L8
    }

    public static final Object a(AIPackageOperationGroup r17, AbsAIPackageOperation r18, AIPackageDeployment.AIPackageDeploymentItem r19, ContinuationImpl r20) {
        AbsAIPackageOperation r5 = r18;
        r17.getClass();
        if ((r20 instanceof AIPackageOperationGroup$operationRun$1) == false) goto L7;
        AIPackageOperationGroup$operationRun$1 r10 = (AIPackageOperationGroup$operationRun$1) r20;
        int r11 = r10.e;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.e = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.f2600c;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.e;
        if (r14 == 0) goto L17;
        if (r14 == 1) goto L16;
        if (r14 != 2) goto L15;
        ResultKt.throwOnFailure(r12);
        return r12;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        AIPackageDeployment.AIPackageDeploymentItem r15 = r10.f2599b;
        r5 = r10.f2598a;
        ResultKt.throwOnFailure(r12);
    L24:
        Iterator r16 = ((Iterable) r12).iterator();
    L26:
        if (r16.hasNext() == false) goto L30;
        AbsAIPackageOperation.Result r21 = (AbsAIPackageOperation.Result) r16.next();
        if (r21.e == 0) goto L26;
        return r21;
    L30:
        y r22 = y.f2766a;
        y.e(r15.getPackageName(), r15.getAppId(), "operation", "RUNNING_UNZIP_AND_STORAGE", null);
        r10.f2598a = null;
        r10.f2599b = null;
        r10.e = 2;
        Object r23 = r5.a(r10);
        if (r23 != r13) goto L33;
    L32:
        return r13;
    L33:
        return r23;
    L17:
        ResultKt.throwOnFailure(r12);
        r18.getClass();
        Intrinsics.checkNotNullParameter(r19, "info");
        Intrinsics.checkNotNullParameter(r19, "<set-?>");
        r5.f2689c = r19;
        if (r19.getVersionCode() != (-1)) goto L20;
        r15 = r19;
        goto L30
    L20:
        ArrayList r24 = new ArrayList();
        t2.a r25 = b.f22089a;
        r24.add(BuildersKt.async$default(h0.a(r25), null, null, new AIPackageOperationGroup$operationRun$2(r19, r17, r5, null), 3, null));
        r24.add(BuildersKt.async$default(h0.a(r25), null, null, new AIPackageOperationGroup$operationRun$3(r19, r17, r5, null), 3, null));
        r10.f2598a = r5;
        r10.f2599b = r19;
        r10.e = 1;
        r12 = j0.c(r24, r10);
        if (r12 == r13) goto L32;
        r15 = r19;
    L7:
        r10 = new AIPackageOperationGroup$operationRun$1(r17, r20);
        goto L8
    }

    public final Object b(AIPackageDeployment.AIPackageDeploymentItem r5, l r10, ContinuationImpl r11) {
        Object r12 = BuildersKt.withContext(b.f22089a, new AIPackageOperationGroup$updateAIPackage$2(r5, r10, this, null), r11);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r12;
    L6:
        return Unit.INSTANCE;
    }

    public final Object a(AIPackageDeployment.AIPackageDeploymentItem r5, l r10, ContinuationImpl r11) {
        Object r12 = BuildersKt.withContext(b.f22089a, new AIPackageOperationGroup$uninstallAIPackage$2(r5, r10, this, null), r11);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r12;
    L6:
        return Unit.INSTANCE;
    }

    public static Object a(AIPackageOperationGroup r5, AIPackageDeployment.AIPackageDeploymentItem r10, l r11, ContinuationImpl r12) {
        r5.getClass();
        Object r13 = BuildersKt.withContext(b.f22089a, new AIPackageOperationGroup$installAIPackage$2(r10, r5, r11, null), r12);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r13;
    L6:
        return Unit.INSTANCE;
    }

    public final Object a(AbsAIPackageOperation.Result r13, ContinuationImpl r14) {
        y r5 = y.f2766a;
        String r10 = r13.f2691b;
        String r11 = r13.f2692c;
        if (r13.e != 0) goto L5;
        String r12 = "SUCCEEDED";
    L6:
        y.e(r10, r11, "operation", r12, "errorCode=" + r13.e + ", errorMsg=" + r13.f);
        StringBuilder r15 = new StringBuilder("operationEnd ===> packageName: ");
        r15.append(r13.f2691b);
        r15.append(", appId: ");
        r15.append(r13.f2692c);
        r15.append(", code: ");
        r15.append(r13.e);
        r15.append(", msg: ");
        String r16 = r13.f;
        if (r16 != null) goto L9;
        r16 = "";
    L9:
        String r17 = androidx.room.jarjarred.org.antlr.runtime.a.v(r15, r16, "AIPackageManager", "tag");
        d r18 = com.bytedance.ai.utils.c.f2846a;
        if (r18 == null) goto L12;
        r18.i("AIPackageManager", r17);
    L12:
        AbsAIPackageOperation r19 = (AbsAIPackageOperation) this.f2574a.remove(r13.f2692c);
        if (r19 == null) goto L24;
        Intrinsics.checkNotNullParameter(r13, "result");
        r19.e = r13;
        r19.d.set(true);
        Iterator r20 = r19.g.iterator();
    L16:
        if (r20.hasNext() == false) goto L18;
        Continuation r21 = (Continuation) r20.next();
        Intrinsics.checkNotNull(r21);
        r21.resumeWith(Result.m124constructorimpl(r13));
        goto L16
    L18:
        Iterator r22 = r19.f.iterator();
    L20:
        if (r22.hasNext() == false) goto L24;
        ((l) r22.next()).a(r13.f2690a, r13.f2691b, r13.f2692c, r13.d, r13.e, r13.f);
        StringBuilder r23 = new StringBuilder("packageName: ");
        r23.append(r13.f2691b);
        r23.append(", appId: ");
        String r24 = ug.a.c(r23, r13.f2692c, " ===> installAIPackage notify listener", "AIPackageManager");
        d r25 = com.bytedance.ai.utils.c.f2846a;
        if (r25 == null) goto L20;
        r25.d("AIPackageManager", r24);
    L24:
        ConcurrentLinkedQueue r110 = (ConcurrentLinkedQueue) this.f2576c.get(r13.f2692c);
        if (r110 != null) goto L27;
    L60:
        Object r111 = Unit.INSTANCE;
    L62:
        if (r111 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L65;
        return r111;
    L65:
        return Unit.INSTANCE;
    L27:
        if (r110.isEmpty() == true) goto L60;
        Action r112 = (Action) r110.poll();
        if (r112 == null) goto L59;
        int r26 = r112.f2578b.ordinal();
        if (r26 != 1) goto L34;
        r111 = b(r112.f2577a, r112.f2579c, r14);
        if (r111 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L62;
        r111 = Unit.INSTANCE;
        goto L62
    L34:
        if (r26 == 2) goto L43;
        if (r26 != 3) goto L59;
        r111 = a(r112.f2577a, r112.f2579c, r14);
        if (r111 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L62;
        r111 = Unit.INSTANCE;
        goto L62
    L43:
        if (r112.d == false) goto L51;
        r111 = BuildersKt.withContext(b.f22089a, new AIPackageOperationGroup$installAIPackageInMemory$2(r112.f2577a, this, r112.f2579c, null), r14);
        if (r111 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L49;
        r111 = Unit.INSTANCE;
    L49:
        if (r111 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L62;
    L54:
        r111 = Unit.INSTANCE;
        goto L62
    L51:
        r111 = a(this, r112.f2577a, r112.f2579c, r14);
        if (r111 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L54;
    L59:
        r111 = Unit.INSTANCE;
        goto L62
    L5:
        r12 = MiniAppWidgetAvailability.INSTALL_STATE_FAILED;
        goto L6
    }

    public final Object a(AIPackageDeployment.AIPackageDeploymentItem r13, ContinuationImpl r14) {
        if ((r14 instanceof AIPackageOperationGroup$loadManifestBean$1) == false) goto L7;
        AIPackageOperationGroup$loadManifestBean$1 r5 = (AIPackageOperationGroup$loadManifestBean$1) r14;
        int r10 = r5.g;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r5.g = r10 - Integer.MIN_VALUE;
    L8:
        Object r15 = r5.e;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = r5.g;
        if (r12 == 0) goto L14;
        if (r12 != 1) goto L13;
        m0 r16 = r5.d;
        String r17 = r5.f2594c;
        AIPackageDeployment.AIPackageDeploymentItem r18 = r5.f2593b;
        AIPackageOperationGroup r19 = r5.f2592a;
        ResultKt.throwOnFailure(r15);
        m0 r20 = r16;
        AIPackageOperationGroup this = r19;
    L24:
        AbsAIPackageOperation.Result r110 = (AbsAIPackageOperation.Result) r15;
        this.f2575b.remove(r17, r20);
        if (Intrinsics.areEqual(r110.f2692c, r18.getAppId()) == true) goto L28;
        String r21 = r18.getAppId();
        AIPackage r22 = r110.f2690a;
        String r23 = r110.f2691b;
        AIPackage.AIPackageType r24 = r110.d;
        int r25 = r110.e;
        String r26 = r110.f;
        Intrinsics.checkNotNullParameter(r23, "packageName");
        Intrinsics.checkNotNullParameter(r21, Constant.APPID);
        Intrinsics.checkNotNullParameter(r24, "packageType");
        return new AbsAIPackageOperation.Result(r22, r23, r21, r24, r25, r26);
    L28:
        return r110;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        String r111 = r13.getPackageName() + '_' + r13.getVersionCode();
        BaseAIPackageHelper r27 = new BaseAIPackageHelper(r13);
        ConcurrentHashMap r28 = this.f2575b;
        Object r29 = r28.get(r111);
        if (r29 != null) goto L20;
        r29 = BuildersKt.async$default(h0.a(b.f22089a), null, CoroutineStart.LAZY, new AIPackageOperationGroup$loadManifestBean$job$1$1(r27, this, r13, null), 1, null);
        Object r30 = r28.putIfAbsent(r111, r29);
        if (r30 == null) goto L20;
        r29 = r30;
    L20:
        r20 = (m0) r29;
        r5.f2592a = this;
        r5.f2593b = r13;
        r5.f2594c = r111;
        r5.d = r20;
        r5.g = 1;
        Object r31 = r20.d(r5);
        if (r31 != r11) goto L23;
        return r11;
    L23:
        r18 = r13;
        r17 = r111;
        r15 = r31;
    L7:
        r5 = new AIPackageOperationGroup$loadManifestBean$1(this, r14);
        goto L8
    }

    public final Object a(AIPackage r12, AIPackageDeployment.AIPackageDeploymentItem r13, boolean r14, ContinuationImpl r15) {
        if ((r15 instanceof AIPackageOperationGroup$checkOldPackageVersion$1) == false) goto L7;
        AIPackageOperationGroup$checkOldPackageVersion$1 r5 = (AIPackageOperationGroup$checkOldPackageVersion$1) r15;
        int r10 = r5.f2582c;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r5.f2582c = r10 - Integer.MIN_VALUE;
    L8:
        Object r16 = r5.f2580a;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r5.f2582c;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        ResultKt.throwOnFailure(r16);
    L32:
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        if (r13.getVersionCode() != 0) goto L18;
    L25:
        String r18 = "packageName: " + r13.getPackageName() + ", appId: " + r13.getAppId() + " ===> AIPackage installs the same version";
        Intrinsics.checkNotNullParameter("AIPackageManager", "tag");
        d r19 = com.bytedance.ai.utils.c.f2846a;
        if (r19 == null) goto L28;
        r19.i("AIPackageManager", r18);
    L28:
        AbsAIPackageOperation.Result r110 = new AbsAIPackageOperation.Result(r12, r12.f2259b, r12.c(), r12.e(), 0, null);
        r5.f2582c = 1;
        if (a(r110, r5) != r11) goto L32;
        return r11;
    L18:
        if (r12.f2260c == r13.getVersionCode()) goto L25;
        if (r14 == false) goto L24;
        if (r12.f2260c > r13.getVersionCode()) goto L25;
    L24:
        return Boxing.boxBoolean(true);
    L7:
        r5 = new AIPackageOperationGroup$checkOldPackageVersion$1(this, r15);
        goto L8
    }

    public final String a() {
        StringBuilder r5 = new StringBuilder();
        r5.append("activeOperations=" + this.f2574a.size());
        r5.append('\n');
        Iterator r10 = MapsKt.toSortedMap(this.f2574a).entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L23;
        Map.Entry r11 = (Map.Entry) r10.next();
        String r12 = (String) r11.getKey();
        AbsAIPackageOperation r13 = (AbsAIPackageOperation) r11.getValue();
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L8
        Object r15 = Result.m124constructorimpl(r13.a());     // Catch: Throwable -> L8
    L11:
        if (Result.m130isFailureimpl(r15) == false) goto L13;
        r15 = null;
    L13:
        AIPackageDeployment.AIPackageDeploymentItem r16 = (AIPackageDeployment.AIPackageDeploymentItem) r15;
        r5.append("operation[" + r12 + "]=");
        r5.append(r13.getClass().getSimpleName());
        r5.append(", status=");
        r5.append(r13.c());
        r5.append(", versionCode=");
        if (r16 == null) goto L16;
        Object r17 = Long.valueOf(r16.getVersionCode());
    L17:
        r5.append(r17);
        r5.append(", consumed=");
        r5.append(r13.d.get());
        r5.append(", result=");
        AbsAIPackageOperation.Result r18 = r13.e;
        if (r18 == null) goto L21;
        String r19 = "errorCode=" + r18.e + ", errorMsg=" + r18.f;
        if (r19 == null) goto L21;
    L22:
        r5.append(r19);
        r5.append('\n');
    L21:
        r19 = "<pending>";
        goto L22
    L16:
        r17 = "unknown";
    L8:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r15 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L11
    L23:
        r5.append("manifestOperations=" + this.f2575b.size());
        r5.append('\n');
        Iterator r21 = MapsKt.toSortedMap(this.f2575b).entrySet().iterator();
    L25:
        if (r21.hasNext() == false) goto L27;
        Map.Entry r22 = (Map.Entry) r21.next();
        String r23 = (String) r22.getKey();
        Job r24 = (m0) r22.getValue();
        StringBuilder r25 = e.b("manifest[", r23, "]=active=");
        r25.append(r24.isActive());
        r25.append(", completed=");
        r1 r26 = (r1) r24;
        r25.append(r26.isCompleted());
        r25.append(", cancelled=");
        r25.append(r26.isCancelled());
        r5.append(r25.toString());
        r5.append('\n');
        goto L25
    L27:
        r5.append("pendingActionGroups=" + this.f2576c.size());
        r5.append('\n');
        Iterator r110 = MapsKt.toSortedMap(this.f2576c).entrySet().iterator();
    L29:
        if (r110.hasNext() == false) goto L32;
        Map.Entry r27 = (Map.Entry) r110.next();
        String r28 = (String) r27.getKey();
        ConcurrentLinkedQueue r29 = (ConcurrentLinkedQueue) r27.getValue();
        StringBuilder r30 = e.b("pending[", r28, "]=count=");
        r30.append(r29.size());
        r30.append(", actions=");
        Intrinsics.checkNotNull(r29);
        r30.append(CollectionsKt.q(r29, null, null, null, 0, null, new m(2), 31));
        r5.append(r30.toString());
        r5.append('\n');
        goto L29
    L32:
        return r5.toString();
    }

    public static final CharSequence a(Action r5) {
        StringBuilder r10 = new StringBuilder();
        r10.append(r5.f2578b);
        r10.append('@');
        r10.append(r5.f2577a.getVersionCode());
        return r10.toString();
    }

    public final void a(AIPackageDeployment.AIPackageDeploymentItem r10, AIPackage.PackageStatus r11, l r12, boolean r13) {
        AIPackage.PackageStatus r5 = null;
        if (r10.getVersionCode() != 0) goto L16;
        AbsAIPackageOperation r14 = (AbsAIPackageOperation) this.f2574a.get(r10.getAppId());
        if (r14 == null) goto L7;
        AIPackage.PackageStatus r15 = r14.c();
    L8:
        AIPackage.PackageStatus r16 = AIPackage.PackageStatus.f2284c;
        if (r15 != r16) goto L16;
        if (r11 != r16) goto L16;
        if (r12 == null) goto L35;
        AbsAIPackageOperation r17 = (AbsAIPackageOperation) this.f2574a.get(r10.getAppId());
        if (r17 == null) goto L36;
        r17.a(r12);
        return;
    L36:
        return;
    L35:
        return;
    L7:
        r15 = null;
    L16:
        AbsAIPackageOperation r18 = (AbsAIPackageOperation) this.f2574a.get(r10.getAppId());
        if (r18 == null) goto L31;
        AIPackageDeployment.AIPackageDeploymentItem r19 = r18.a();
        if (r19 == null) goto L31;
        if (r10.getVersionCode() != r19.getVersionCode()) goto L31;
        AbsAIPackageOperation r20 = (AbsAIPackageOperation) this.f2574a.get(r10.getAppId());
        if (r20 == null) goto L25;
        r5 = r20.c();
    L25:
        if (r11 != r5) goto L31;
        if (r12 == null) goto L37;
        AbsAIPackageOperation r21 = (AbsAIPackageOperation) this.f2574a.get(r10.getAppId());
        if (r21 == null) goto L38;
        r21.a(r12);
        return;
    L38:
        return;
    L37:
        return;
    L31:
        this.f2576c.putIfAbsent(r10.getAppId(), new ConcurrentLinkedQueue());
        ConcurrentLinkedQueue r22 = (ConcurrentLinkedQueue) this.f2576c.get(r10.getAppId());
        if (r22 == null) goto L39;
        r22.offer(new Action(r10, r11, r12, r13));
        return;
    }
}
