package com.bytedance.ai.resource.core;

import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.resource.AIPackageManager;
import com.bytedance.ai.resource.core.db.AIPackageDao;
import com.bytedance.ai.resource.core.db.AIPackageDatabase;
import com.bytedance.ai.utils.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AIPackageStorage {
    public static final AIPackageStorage a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AIPackage.AIPackageType.values().length];
            r0[AIPackage.AIPackageType.WIDGET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[AIPackage.AIPackageType.APPLET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
        a = new AIPackageStorage();
    }

    public AIPackageStorage() {
    }

    public final Object i(Continuation<? super List<? extends AIPackage>> r10) {
        if ((r10 instanceof AIPackageStorage$queryInactiveAIPackages$1) == false) goto L7;
        AIPackageStorage$queryInactiveAIPackages$1 r0 = (AIPackageStorage$queryInactiveAIPackages$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r0.label;
        if (r13 == 0) goto L24;
        if (r13 == 1) goto L19;
        if (r13 != 2) goto L18;
        List r14 = (List) r0.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Exception -> L15
    L36:
        List r15 = (List) r11;     // Catch: Exception -> L15
        if (r15 == null) goto L43;
        r14.addAll(r15);     // Catch: Exception -> L15
    L43:
        return r14;
    L15:
        Exception e = e;
    L42:
        g.a.e("AIPackageStorage", "query all inactive AIPackage info database error : " + ExceptionsKt.stackTraceToString(e));
        goto L43
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        List r16 = (List) r0.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Exception -> L22
    L29:
        List r17 = (List) r11;     // Catch: Exception -> L22
        if (r17 == null) goto L32;
        r16.addAll(r17);     // Catch: Exception -> L22
    L32:
        AIPackageDao r18 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L22
        r0.L$0 = r16;     // Catch: Exception -> L22
        r0.label = 2;     // Catch: Exception -> L22
        r11 = r18.w(r0);     // Catch: Exception -> L22
        if (r11 != r12) goto L35;
        return r12;
    L35:
        r14 = r16;
    L22:
        e = e;
        r14 = r16;
        goto L42
    L24:
        ResultKt.throwOnFailure(r11);
        ArrayList r19 = new ArrayList();
        AIPackageDao r20 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L40
        r0.L$0 = r19;     // Catch: Exception -> L40
        r0.label = 1;     // Catch: Exception -> L40
        Object r21 = r20.y(r0);     // Catch: Exception -> L40
        if (r21 != r12) goto L28;
        return r12;
    L28:
        r16 = r19;
        r11 = r21;
    L40:
        e = move-exception;
        r14 = r19;
        e = e;
    L7:
        r0 = new AIPackageStorage$queryInactiveAIPackages$1(this, r10);
        goto L8
    }

    public final Object p(Continuation<? super List<? extends AIPackage>> r10) {
        if ((r10 instanceof AIPackageStorage$queryPackagesToDelete$1) == false) goto L7;
        AIPackageStorage$queryPackagesToDelete$1 r0 = (AIPackageStorage$queryPackagesToDelete$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r0.label;
        if (r13 == 0) goto L24;
        if (r13 == 1) goto L19;
        if (r13 != 2) goto L18;
        List r14 = (List) r0.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Exception -> L15
    L36:
        List r15 = (List) r11;     // Catch: Exception -> L15
        if (r15 == null) goto L43;
        r14.addAll(r15);     // Catch: Exception -> L15
    L43:
        return r14;
    L15:
        Exception e = e;
    L42:
        g.a.e("AIPackageStorage", "query all AIPackage to delete database error : " + ExceptionsKt.stackTraceToString(e));
        goto L43
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        List r16 = (List) r0.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Exception -> L22
    L29:
        List r17 = (List) r11;     // Catch: Exception -> L22
        if (r17 == null) goto L32;
        r16.addAll(r17);     // Catch: Exception -> L22
    L32:
        AIPackageDao r18 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L22
        r0.L$0 = r16;     // Catch: Exception -> L22
        r0.label = 2;     // Catch: Exception -> L22
        r11 = r18.L(r0);     // Catch: Exception -> L22
        if (r11 != r12) goto L35;
        return r12;
    L35:
        r14 = r16;
    L22:
        e = e;
        r14 = r16;
        goto L42
    L24:
        ResultKt.throwOnFailure(r11);
        ArrayList r19 = new ArrayList();
        AIPackageDao r20 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L40
        r0.L$0 = r19;     // Catch: Exception -> L40
        r0.label = 1;     // Catch: Exception -> L40
        Object r21 = r20.u(r0);     // Catch: Exception -> L40
        if (r21 != r12) goto L28;
        return r12;
    L28:
        r16 = r19;
        r11 = r21;
    L40:
        e = move-exception;
        r14 = r19;
        e = e;
    L7:
        r0 = new AIPackageStorage$queryPackagesToDelete$1(this, r10);
        goto L8
    }

    public final Object a(AIPackage r11, Continuation<? super List<String>> r12) {
        if ((r12 instanceof AIPackageStorage$cleanPackageToDelete$1) == false) goto L7;
        AIPackageStorage$cleanPackageToDelete$1 r0 = (AIPackageStorage$cleanPackageToDelete$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        if (r14 == 0) goto L22;
        if (r14 == 1) goto L21;
        if (r14 == 2) goto L18;
        if (r14 != 3) goto L17;
        AIPackage r15 = (AIPackage) r0.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L35
    L34:
        return r13;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r11 = (AIPackage) r0.L$0;
    L19:
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L35
    L31:
        g.a.d("AIPackageStorage", "packageName: " + r11.b + ", appId: " + r11.a() + " ===> end delete database");     // Catch: Exception -> L35
        r0.L$0 = r11;     // Catch: Exception -> L35
        r0.label = 3;     // Catch: Exception -> L35
        r13 = c(r11, r0);     // Catch: Exception -> L35
        if (r13 != r10) goto L34;
        return r10;
    L21:
        r11 = (AIPackage) r0.L$0;
        goto L19
    L22:
        ResultKt.throwOnFailure(r13);
        g.a.d("AIPackageStorage", "packageName: " + r11.b + ", appId: " + r11.a() + " ===> start delete database");     // Catch: Exception -> L35
        if (r11.c() != AIPackage.AIPackageType.WIDGET) goto L28;
        AIPackageDao r16 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L35
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.bytedance.ai.model.objects.Widget");     // Catch: Exception -> L35
        r0.L$0 = r11;     // Catch: Exception -> L35
        r0.label = 1;     // Catch: Exception -> L35
        if (r16.e((Widget) r11, r0) != r10) goto L31;
        return r10;
    L28:
        AIPackageDao r17 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L35
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.bytedance.ai.model.objects.Applet");     // Catch: Exception -> L35
        r0.L$0 = r11;     // Catch: Exception -> L35
        r0.label = 2;     // Catch: Exception -> L35
        if (r17.b((Applet) r11, r0) != r10) goto L31;
        return r10;
    L35:
        e = move-exception;
        g.a.e("AIPackageStorage", "packageName: " + r11.b + ", appId: " + r11.a() + " ===> cleanPackageToDelete error : " + ExceptionsKt.stackTraceToString(e));
        return CollectionsKt.emptyList();
    L7:
        r0 = new AIPackageStorage$cleanPackageToDelete$1(this, r12);
        goto L8
    }

    public final Object c(AIPackage r10, Continuation<? super List<String>> r11) {
        if ((r11 instanceof AIPackageStorage$getFileListToRemoved$1) == false) goto L7;
        AIPackageStorage$getFileListToRemoved$1 r0 = (AIPackageStorage$getFileListToRemoved$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        AIPackageStorage$getFileListToRemoved$1 r12 = r0;
        Object r13 = r12.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r12.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        r10 = (AIPackage) r12.L$0;
        ResultKt.throwOnFailure(r13);
    L17:
        List r16 = (List) r13;
        g.a.d("AIPackageStorage", "packageName: " + r10.b + ", appId: " + r10.a() + " ===> rename outdated file");
        return r16;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        AIPackageDao r17 = AIPackageDatabase.a.b().c();
        long r18 = r10.c;
        String r19 = r10.a();
        String r20 = r10.b;
        String r21 = r10.n;
        r12.L$0 = r10;
        r12.label = 1;
        r13 = r17.M(r18, r19, r20, r21, r12);
        if (r13 != r14) goto L17;
        return r14;
    L7:
        r0 = new AIPackageStorage$getFileListToRemoved$1(this, r11);
        goto L8
    }

    public final Object d(AIPackage r10, Continuation<? super Boolean> r11) {
        if ((r11 instanceof AIPackageStorage$insertAIPackage$1) == false) goto L7;
        AIPackageStorage$insertAIPackage$1 r0 = (AIPackageStorage$insertAIPackage$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        boolean r15 = true;
        if (r14 == 0) goto L18;
        if (r14 == 1) goto L15;
        if (r14 == 2) goto L15;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r10 = (AIPackage) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L29
    L27:
        g.a.d("AIPackageStorage", "packageName: " + r10.b + ", appId: " + r10.a() + " ===> end insert installed database");     // Catch: Exception -> L29
    L32:
        return Boxing.boxBoolean(r15);
    L18:
        ResultKt.throwOnFailure(r12);
        g.a.d("AIPackageStorage", "packageName: " + r10.b + ", appId: " + r10.a() + " ===> start insert installed database");     // Catch: Exception -> L29
        if (r10.c() != AIPackage.AIPackageType.WIDGET) goto L24;
        AIPackageDao r16 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L29
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.bytedance.ai.model.objects.Widget");     // Catch: Exception -> L29
        r0.L$0 = r10;     // Catch: Exception -> L29
        r0.label = 1;     // Catch: Exception -> L29
        if (r16.l((Widget) r10, r0) != r13) goto L27;
        return r13;
    L24:
        AIPackageDao r17 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L29
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.bytedance.ai.model.objects.Applet");     // Catch: Exception -> L29
        r0.L$0 = r10;     // Catch: Exception -> L29
        r0.label = 2;     // Catch: Exception -> L29
        if (r17.h((Applet) r10, r0) != r13) goto L27;
        return r13;
    L29:
        e = move-exception;
        g.a.e("AIPackageStorage", "packageName: " + r10.b + ", appId: " + r10.a() + " ===> insert database error : " + ExceptionsKt.stackTraceToString(e));
        r15 = false;
    L7:
        r0 = new AIPackageStorage$insertAIPackage$1(this, r11);
        goto L8
    }

    public final Object e(AIPackage r10, Continuation<? super Boolean> r11) {
        if ((r11 instanceof AIPackageStorage$insertInactiveAIPackage$1) == false) goto L7;
        AIPackageStorage$insertInactiveAIPackage$1 r0 = (AIPackageStorage$insertInactiveAIPackage$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        boolean r15 = true;
        if (r14 == 0) goto L18;
        if (r14 == 1) goto L17;
        if (r14 != 2) goto L16;
        r10 = (AIPackage) r0.L$0;
    L13:
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L29
    L27:
        g.a.d("AIPackageStorage", "packageName: " + r10.b + ", appId: " + r10.a() + " ===> end insert inactive database");     // Catch: Exception -> L29
    L32:
        return Boxing.boxBoolean(r15);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r10 = (AIPackage) r0.L$0;
        goto L13
    L18:
        ResultKt.throwOnFailure(r12);
        g.a.d("AIPackageStorage", "packageName: " + r10.b + ", appId: " + r10.a() + " ===> start insert inactive database");     // Catch: Exception -> L29
        if (r10.c() != AIPackage.AIPackageType.WIDGET) goto L24;
        AIPackageDao r16 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L29
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.bytedance.ai.model.objects.Widget");     // Catch: Exception -> L29
        r0.L$0 = r10;     // Catch: Exception -> L29
        r0.label = 1;     // Catch: Exception -> L29
        if (r16.k((Widget) r10, r0) != r13) goto L27;
        return r13;
    L24:
        AIPackageDao r17 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L29
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.bytedance.ai.model.objects.Applet");     // Catch: Exception -> L29
        r0.L$0 = r10;     // Catch: Exception -> L29
        r0.label = 2;     // Catch: Exception -> L29
        if (r17.i((Applet) r10, r0) != r13) goto L27;
        return r13;
    L29:
        e = move-exception;
        g.a.e("AIPackageStorage", "packageName: " + r10.b + ", appId: " + r10.a() + " ===> insert database error : " + ExceptionsKt.stackTraceToString(e));
        r15 = false;
    L7:
        r0 = new AIPackageStorage$insertInactiveAIPackage$1(this, r11);
        goto L8
    }

    public final Object l(AIPackageDeployment.AIPackageDeploymentItem r10, Continuation r11) {
        if ((r11 instanceof AIPackageStorage$queryInstallOrInactiveAIPackageById$1) == false) goto L7;
        AIPackageStorage$queryInstallOrInactiveAIPackageById$1 r0 = (AIPackageStorage$queryInstallOrInactiveAIPackageById$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        AIPackageStorage$queryInstallOrInactiveAIPackageById$1 r12 = r0;
        Object r13 = r12.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r12.label;
        if (r15 == 0) goto L16;
        if (r15 == 1) goto L15;
        if (r15 != 2) goto L14;
        ResultKt.throwOnFailure(r13);
    L25:
        return r13;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        AIPackageManager.a r16 = (AIPackageManager.a) r12.L$0;
        ResultKt.throwOnFailure(r13);
        AIPackageManager.a r17 = r16;
    L19:
        AIPackageManager.a r18 = r17;
        AIPackage r19 = (AIPackage) r13;
        if (r19 == null) goto L22;
        return r19;
    L22:
        r12.L$0 = null;
        r12.label = 2;
        r13 = k(r18, AIPackage.AIPackageType.UNKNOWN, false, 0, r12);
        if (r13 != r14) goto L25;
        return r14;
    L16:
        ResultKt.throwOnFailure(r13);
        AIPackage.AIPackageType r20 = AIPackage.AIPackageType.UNKNOWN;
        r12.L$0 = r10;
        r12.label = 1;
        r13 = h(r10, r20, 0, r12);
        r17 = r10;
        if (r13 != r14) goto L19;
        return r14;
    L7:
        r0 = new AIPackageStorage$queryInstallOrInactiveAIPackageById$1(this, r11);
        goto L8
    }

    public final Object n(String r10, Continuation<? super List<? extends AIPackage>> r11) {
        if ((r11 instanceof AIPackageStorage$queryInstalledAIPackagesByPackageName$1) == false) goto L7;
        AIPackageStorage$queryInstalledAIPackagesByPackageName$1 r0 = (AIPackageStorage$queryInstalledAIPackagesByPackageName$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        if (r14 == 0) goto L24;
        if (r14 == 1) goto L19;
        if (r14 != 2) goto L18;
        List r15 = (List) r0.L$1;
        String r16 = (String) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L15
    L36:
        List r17 = (List) r12;     // Catch: Exception -> L15
        if (r17 == null) goto L49;
        r15.addAll(r17);     // Catch: Exception -> L15
        return r15;
    L49:
        return r15;
    L15:
        e = move-exception;
        List r18 = r15;
        r10 = r16;
        e = e;
    L41:
        g.a.e("AIPackageStorage", "query " + r10 + " info database error : " + ExceptionsKt.stackTraceToString(e));
        return r18;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r15 = (List) r0.L$1;
        String r19 = (String) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L22
    L29:
        List r20 = (List) r12;     // Catch: Exception -> L22
        if (r20 == null) goto L32;
        r15.addAll(r20);     // Catch: Exception -> L22
    L32:
        AIPackageDao r21 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L22
        r0.L$0 = r19;     // Catch: Exception -> L22
        r0.L$1 = r15;     // Catch: Exception -> L22
        r0.label = 2;     // Catch: Exception -> L22
        r12 = r21.B(r19, r0);     // Catch: Exception -> L22
        if (r12 != r13) goto L35;
        return r13;
    L35:
        r16 = r19;
    L22:
        e = move-exception;
        e = e;
        r18 = r15;
        r10 = r19;
        goto L41
    L24:
        ResultKt.throwOnFailure(r12);
        r18 = new ArrayList();
        AIPackageDao r22 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L40
        r0.L$0 = r10;     // Catch: Exception -> L40
        r0.L$1 = r18;     // Catch: Exception -> L40
        r0.label = 1;     // Catch: Exception -> L40
        Object r23 = r22.E(r10, r0);     // Catch: Exception -> L40
        if (r23 != r13) goto L28;
        return r13;
    L28:
        r19 = r10;
        r15 = r18;
        r12 = r23;
    L40:
        e = e;
    L7:
        r0 = new AIPackageStorage$queryInstalledAIPackagesByPackageName$1(this, r11);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.bytedance.ai.model.objects.AIPackage$AIPackageType, java.lang.Enum, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r10v11, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r10v15, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v21, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v27 */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r10v29 */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5, types: [java.lang.Object, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v18, types: [com.bytedance.ai.model.objects.AIPackage$AIPackageType] */
    /* JADX WARN: Type inference failed for: r2v19 */
    public final Object o(AIPackage.AIPackageType r10, Continuation<? super List<? extends AIPackage>> r11) {
        if ((r11 instanceof AIPackageStorage$queryInstalledAIPackagesByType$1) == false) goto L7;
        AIPackageStorage$queryInstalledAIPackagesByType$1 r0 = (AIPackageStorage$queryInstalledAIPackagesByType$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        if (r14 == 0) goto L32;
        if (r14 == 1) goto L27;
        if (r14 == 2) goto L24;
        if (r14 == 3) goto L19;
        if (r14 != 4) goto L18;
        List r15 = (List) r0.L$1;
        AIPackage.AIPackageType r16 = (AIPackage.AIPackageType) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L30
        ?? r17 = r15;
    L47:
        List r18 = (List) r12;     // Catch: Exception -> L30
        if (r18 == null) goto L74;
        r17.addAll(r18);     // Catch: Exception -> L30
        return r17;
    L74:
        return r17;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ?? r19 = (List) r0.L$1;
        ?? r20 = (AIPackage.AIPackageType) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L22
        r20 = r20;
        r19 = r19;
    L40:
        List r110 = (List) r12;     // Catch: Exception -> L22
        if (r110 == null) goto L43;
        r19.addAll(r110);     // Catch: Exception -> L22
    L43:
        AIPackageDao r111 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L22
        r0.L$0 = r20;     // Catch: Exception -> L22
        r0.L$1 = r19;     // Catch: Exception -> L22
        r0.label = 4;     // Catch: Exception -> L22
        r12 = r111.D(r0);     // Catch: Exception -> L22
        if (r12 != r13) goto L46;
        return r13;
    L46:
        r17 = r19;
    L22:
        e = move-exception;
        Exception e = e;
        ?? r112 = r19;
        r10 = r20;
    L68:
        g.a.e("AIPackageStorage", "query all " + r10 + " AIPackage info database error : " + ExceptionsKt.stackTraceToString(e));
        return r112;
    L24:
        List r113 = (List) r0.L$1;
        AIPackage.AIPackageType r21 = (AIPackage.AIPackageType) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L30
        ?? r114 = r113;
    L63:
        List r115 = (List) r12;     // Catch: Exception -> L30
        if (r115 == null) goto L76;
        r114.addAll(r115);     // Catch: Exception -> L30
        return r114;
    L76:
        return r114;
    L27:
        List r116 = (List) r0.L$1;
        AIPackage.AIPackageType r22 = (AIPackage.AIPackageType) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L30
        ?? r117 = r116;
    L55:
        List r118 = (List) r12;     // Catch: Exception -> L30
        if (r118 == null) goto L75;
        r117.addAll(r118);     // Catch: Exception -> L30
        return r117;
    L75:
        return r117;
    L32:
        ResultKt.throwOnFailure(r12);
        r112 = new ArrayList();
        int r23 = a.a[r10.ordinal()];     // Catch: Exception -> L67
        if (r23 == 1) goto L59;
        if (r23 == 2) goto L51;
        AIPackageDao r24 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L67
        r0.L$0 = r10;     // Catch: Exception -> L67
        r0.L$1 = r112;     // Catch: Exception -> L67
        r0.label = 3;     // Catch: Exception -> L67
        Object r25 = r24.A(r0);     // Catch: Exception -> L67
        if (r25 != r13) goto L39;
        return r13;
    L39:
        r20 = r10;
        r19 = r112;
        r12 = r25;
        goto L40
    L51:
        AIPackageDao r26 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L67
        r0.L$0 = r10;     // Catch: Exception -> L67
        r0.L$1 = r112;     // Catch: Exception -> L67
        r0.label = 1;     // Catch: Exception -> L67
        Object r27 = r26.A(r0);     // Catch: Exception -> L67
        if (r27 != r13) goto L54;
        return r13;
    L54:
        r117 = r112;
        r12 = r27;
        goto L55
    L59:
        AIPackageDao r28 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L67
        r0.L$0 = r10;     // Catch: Exception -> L67
        r0.L$1 = r112;     // Catch: Exception -> L67
        r0.label = 2;     // Catch: Exception -> L67
        Object r29 = r28.D(r0);     // Catch: Exception -> L67
        if (r29 != r13) goto L62;
        return r13;
    L62:
        r114 = r112;
        r12 = r29;
    L67:
        e = e;
    L30:
        e = move-exception;
        r112 = r10;
        r10 = r0;
        e = e;
    L7:
        r0 = new AIPackageStorage$queryInstalledAIPackagesByType$1(this, r11);
        goto L8
    }

    public final Object b(AIPackageManager.a r10, AIPackage.AIPackageType r11, Continuation<? super Boolean> r12) {
        if ((r12 instanceof AIPackageStorage$deleteAIPackageById$1) == false) goto L7;
        AIPackageStorage$deleteAIPackageById$1 r0 = (AIPackageStorage$deleteAIPackageById$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r0.label;
        boolean r16 = true;
        if (r15 == 0) goto L18;
        if (r15 == 1) goto L15;
        if (r15 == 2) goto L15;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r10 = (AIPackageManager.a) r0.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L29
    L27:
        g.a.d("AIPackageStorage", "packageName: " + r10.getPackageName() + ", appId: " + r10.getAppId() + " ===> end delete database");     // Catch: Exception -> L29
    L32:
        return Boxing.boxBoolean(r16);
    L18:
        ResultKt.throwOnFailure(r13);
        g.a.d("AIPackageStorage", "packageName: " + r10.getPackageName() + ", appId: " + r10.getAppId() + " ===> start delete database");     // Catch: Exception -> L29
        if (r11 != AIPackage.AIPackageType.WIDGET) goto L24;
        AIPackageDao r17 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L29
        String r18 = r10.getAppId();     // Catch: Exception -> L29
        String r19 = r10.getPackageName();     // Catch: Exception -> L29
        r0.L$0 = r10;     // Catch: Exception -> L29
        r0.label = 1;     // Catch: Exception -> L29
        if (r17.f(r18, r19, r0) != r14) goto L27;
        return r14;
    L24:
        AIPackageDao r110 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L29
        String r111 = r10.getAppId();     // Catch: Exception -> L29
        String r20 = r10.getPackageName();     // Catch: Exception -> L29
        r0.L$0 = r10;     // Catch: Exception -> L29
        r0.label = 2;     // Catch: Exception -> L29
        if (r110.c(r111, r20, r0) != r14) goto L27;
        return r14;
    L29:
        e = move-exception;
        g.a.e("AIPackageStorage", "packageName: " + r10.getPackageName() + ", appId: " + r10.getAppId() + " ===> delete database error :  " + ExceptionsKt.stackTraceToString(e));
        r16 = false;
    L7:
        r0 = new AIPackageStorage$deleteAIPackageById$1(this, r12);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object f(AIPackageManager.a r10, AIPackage.AIPackageType r11, Continuation<? super Boolean> r12) {
        if ((r12 instanceof AIPackageStorage$markPackageAsDeleted$1) == false) goto L7;
        AIPackageStorage$markPackageAsDeleted$1 r0 = (AIPackageStorage$markPackageAsDeleted$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r0.label;
        boolean r16 = true;
        if (r15 == 0) goto L18;
        if (r15 == 1) goto L15;
        if (r15 == 2) goto L15;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        AIPackageManager.a r17 = (AIPackageManager.a) r0.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L29
        r10 = r17;
    L33:
    L32:
        return Boxing.boxBoolean(r16);
    L18:
        ResultKt.throwOnFailure(r13);
        int r18 = a.a[r11.ordinal()];     // Catch: Exception -> L29
        if (r18 == 1) goto L26;
        if (r18 == 2) goto L23;
        r10 = r10;
        goto L33
    L23:
        AIPackageDao r19 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L29
        String r20 = r10.getAppId();     // Catch: Exception -> L29
        String r21 = r10.getPackageName();     // Catch: Exception -> L29
        r0.L$0 = r10;     // Catch: Exception -> L29
        r0.label = 2;     // Catch: Exception -> L29
        Object r22 = r19.m(r20, r21, r0);     // Catch: Exception -> L29
        r10 = r22;
        if (r22 != r14) goto L33;
        return r14;
    L26:
        AIPackageDao r23 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L29
        String r24 = r10.getAppId();     // Catch: Exception -> L29
        String r25 = r10.getPackageName();     // Catch: Exception -> L29
        r0.L$0 = r10;     // Catch: Exception -> L29
        r0.label = 1;     // Catch: Exception -> L29
        Object r26 = r23.n(r24, r25, r0);     // Catch: Exception -> L29
        r10 = r26;
        if (r26 != r14) goto L33;
        return r14;
    L29:
        e = move-exception;
        g.a.e("AIPackageStorage", "Failed to markPackageAsDeleted. packageName: " + r10.getPackageName() + ", appId: " + r10.getAppId() + ",  error: " + ExceptionsKt.stackTraceToString(e));
        r16 = false;
    L7:
        r0 = new AIPackageStorage$markPackageAsDeleted$1(this, r12);
        goto L8
    }

    public final Object j(String r10, AIPackage.AIPackageType r11, Continuation<? super Boolean> r12) {
        if ((r12 instanceof AIPackageStorage$queryInactiveVersion$1) == false) goto L7;
        AIPackageStorage$queryInactiveVersion$1 r0 = (AIPackageStorage$queryInactiveVersion$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r0.label;
        boolean r16 = true;
        if (r15 == 0) goto L28;
        if (r15 == 1) goto L25;
        if (r15 == 2) goto L22;
        if (r15 == 3) goto L19;
        if (r15 != 4) goto L18;
        String r17 = (String) r0.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L89
    L77:
        List r18 = (List) r13;     // Catch: Exception -> L89
        if (r18 != null) goto L80;
    L83:
        boolean r19 = true;
    L84:
        if (r19 == false) goto L88;
        r16 = false;
    L88:
        return Boxing.boxBoolean(r16);
    L80:
        if (r18.isEmpty() == true) goto L83;
        r19 = false;
        goto L84
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r10 = (String) r0.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L89
    L66:
        List r110 = (List) r13;     // Catch: Exception -> L89
        if (r110 != null) goto L69;
    L72:
        boolean r111 = true;
    L73:
        if (r111 == false) goto L88;
        AIPackageDao r112 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L89
        r0.L$0 = r10;     // Catch: Exception -> L89
        r0.label = 4;     // Catch: Exception -> L89
        r13 = r112.x(r10, r0);     // Catch: Exception -> L89
        if (r13 != r14) goto L77;
        return r14;
    L69:
        if (r110.isEmpty() == true) goto L72;
        r111 = false;
        goto L73
    L22:
        String r20 = (String) r0.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L89
    L51:
        List r113 = (List) r13;     // Catch: Exception -> L89
        if (r113 != null) goto L54;
    L57:
        boolean r114 = true;
    L58:
        if (r114 == false) goto L62;
        r16 = false;
    L62:
        return Boxing.boxBoolean(r16);
    L54:
        if (r113.isEmpty() == true) goto L57;
        r114 = false;
        goto L58
    L25:
        String r21 = (String) r0.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L89
    L34:
        List r115 = (List) r13;     // Catch: Exception -> L89
        if (r115 != null) goto L37;
    L40:
        boolean r116 = true;
    L41:
        if (r116 == false) goto L45;
        r16 = false;
    L45:
        return Boxing.boxBoolean(r16);
    L37:
        if (r115.isEmpty() == true) goto L40;
        r116 = false;
        goto L41
    L28:
        ResultKt.throwOnFailure(r13);
        if (r11 != AIPackage.AIPackageType.APPLET) goto L47;
        AIPackageDao r117 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L89
        r0.L$0 = r10;     // Catch: Exception -> L89
        r0.label = 1;     // Catch: Exception -> L89
        r13 = r117.v(r10, r0);     // Catch: Exception -> L89
        if (r13 != r14) goto L34;
        return r14;
    L47:
        if (r11 != AIPackage.AIPackageType.WIDGET) goto L63;
        AIPackageDao r118 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L89
        r0.L$0 = r10;     // Catch: Exception -> L89
        r0.label = 2;     // Catch: Exception -> L89
        r13 = r118.x(r10, r0);     // Catch: Exception -> L89
        if (r13 != r14) goto L51;
        return r14;
    L63:
        AIPackageDao r119 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L89
        r0.L$0 = r10;     // Catch: Exception -> L89
        r0.label = 3;     // Catch: Exception -> L89
        r13 = r119.v(r10, r0);     // Catch: Exception -> L89
        if (r13 != r14) goto L66;
        return r14;
    L89:
        e = move-exception;
        g.a.e("AIPackageStorage", "query inactive version of " + r10 + " error : " + ExceptionsKt.stackTraceToString(e));
        return Boxing.boxBoolean(false);
    L7:
        r0 = new AIPackageStorage$queryInactiveVersion$1(this, r12);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0085 -> B:14:0x0039). Please report as a decompilation issue!!! */
    public final Object m(List<? extends AIPackageManager.a> r13, boolean r14, Continuation<? super List<? extends AIPackage>> r15) {
        if ((r15 instanceof AIPackageStorage$queryInstalledAIPackagesByIds$1) == false) goto L7;
        AIPackageStorage$queryInstalledAIPackagesByIds$1 r0 = (AIPackageStorage$queryInstalledAIPackagesByIds$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = r0.label;
        if (r11 == 0) goto L19;
        if (r11 != 1) goto L18;
        boolean r17 = r0.Z$0;
        Iterator r18 = (Iterator) r0.L$2;
        List r12 = (List) r0.L$1;
        List<? extends AIPackageManager.a> r19 = (List) r0.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Exception -> L15
        AIPackageStorage$queryInstalledAIPackagesByIds$1 r110 = r0;
        boolean r20 = r17;
        r13 = r19;
    L14:
        List r21 = r12;
        Object r22 = r10;
        AIPackageStorage$queryInstalledAIPackagesByIds$1 r23 = r110;
        AIPackage r111 = (AIPackage) r16;     // Catch: Exception -> L35
        if (r111 == null) goto L34;
        r21.add(r111);     // Catch: Exception -> L35
    L34:
        boolean r112 = r20;
        r0 = r23;
        r10 = r22;
        r12 = r21;
    L21:
        if (r18.hasNext() == false) goto L39;
        AIPackageManager.a r24 = (AIPackageManager.a) r18.next();     // Catch: Exception -> L37
        AIPackageStorage r25 = a;     // Catch: Exception -> L37
        AIPackage.AIPackageType r26 = AIPackage.AIPackageType.UNKNOWN;     // Catch: Exception -> L37
        if (r112 == false) goto L26;
        boolean r27 = true;
    L27:
        r0.L$0 = r13;     // Catch: Exception -> L37
        r0.L$1 = r12;     // Catch: Exception -> L37
        r0.L$2 = r18;     // Catch: Exception -> L37
        r0.Z$0 = r112;     // Catch: Exception -> L37
        r0.label = 1;     // Catch: Exception -> L37
        Object r28 = r25.k(r24, r26, r27, 0, r0);     // Catch: Exception -> L37
        if (r28 != r10) goto L30;
        return r10;
    L30:
        r110 = r0;
        r20 = r112;
        r16 = r28;
        goto L14
    L26:
        r27 = false;
    L39:
        return r12;
    L37:
        Exception e = e;
    L38:
        g.a.e("AIPackageStorage", "query packages(size=" + r13.size() + ") info database error : " + ExceptionsKt.stackTraceToString(e));
    L35:
        e = e;
        r12 = r21;
    L15:
        e = move-exception;
        e = e;
        r13 = r19;
        goto L38
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ResultKt.throwOnFailure(r16);
        r12 = new ArrayList();
        r112 = r14;
        r18 = r13.iterator();     // Catch: Exception -> L37
    L7:
        r0 = new AIPackageStorage$queryInstalledAIPackagesByIds$1(this, r15);
        goto L8
    }

    public final Object h(AIPackageManager.a r11, AIPackage.AIPackageType r12, long r13, Continuation<? super AIPackage> r15) {
        if ((r15 instanceof AIPackageStorage$queryInactiveAIPackageById$1) == false) goto L7;
        AIPackageStorage$queryInactiveAIPackageById$1 r0 = (AIPackageStorage$queryInactiveAIPackageById$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        AIPackageStorage$queryInactiveAIPackageById$1 r10 = r0;
        Object r16 = r10.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r10.label;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        ResultKt.throwOnFailure(r16);
    L17:
        AIPackage r18 = (AIPackage) r16;
        if (r18 != null) goto L20;
        return null;
    L20:
        if (Intrinsics.areEqual(r18.v, "inactive") == false) goto L28;
        Integer r19 = r18.w;
        if (r19 != null) goto L25;
        return r18;
    L25:
        if (r19.intValue() == 1) goto L28;
        return r18;
    L28:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        r10.label = 1;
        r16 = g(r11, r12, "inactive", false, r13, r10);
        if (r16 != r14) goto L17;
        return r14;
    L7:
        r0 = new AIPackageStorage$queryInactiveAIPackageById$1(this, r15);
        goto L8
    }

    public final Object k(AIPackageManager.a r13, AIPackage.AIPackageType r14, boolean r15, long r16, Continuation<? super AIPackage> r18) {
        if ((r18 instanceof AIPackageStorage$queryInstallAIPackageById$2) == false) goto L7;
        AIPackageStorage$queryInstallAIPackageById$2 r1 = (AIPackageStorage$queryInstallAIPackageById$2) r18;
        int r10 = r1.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r10 - Integer.MIN_VALUE;
    L8:
        AIPackageStorage$queryInstallAIPackageById$2 r11 = r1;
        Object r0 = r11.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r11.label;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
    L17:
        AIPackage r19 = (AIPackage) r0;
        if (r19 != null) goto L20;
        return null;
    L20:
        if (Intrinsics.areEqual(r19.v, "installed") == false) goto L28;
        Integer r20 = r19.w;
        if (r20 != null) goto L25;
        return r19;
    L25:
        if (r20.intValue() == 1) goto L28;
        return r19;
    L28:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        r11.label = 1;
        r0 = g(r13, r14, "installed", r15, r16, r11);
        if (r0 != r12) goto L17;
        return r12;
    L7:
        r1 = new AIPackageStorage$queryInstallAIPackageById$2(this, r18);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.bytedance.ai.resource.AIPackageManager$a] */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    public final Object g(AIPackageManager.a r18, AIPackage.AIPackageType r19, String r20, boolean r21, long r22, Continuation<? super AIPackage> r24) {
        AIPackageManager.a r1 = r18;
        String r0 = r20;
        long r10 = r22;
        if ((r24 instanceof AIPackageStorage$queryAIPackageById$1) == false) goto L7;
        AIPackageStorage$queryAIPackageById$1 r11 = (AIPackageStorage$queryAIPackageById$1) r24;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        int r13 = r12 - Integer.MIN_VALUE;
        r11.label = r13;
        AIPackageStorage r14 = this;
        int r15 = r13;
    L8:
        AIPackageStorage$queryAIPackageById$1 r16 = r11;
        Object r17 = r16.result;
        Object r110 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r14 = null;
        switch(r16.label) {
            case 0: goto L50;
            case 1: goto L47;
            case 2: goto L44;
            case 3: goto L41;
            case 4: goto L38;
            case 5: goto L35;
            case 6: goto L32;
            case 7: goto L27;
            case 8: goto L24;
            case 9: goto L21;
            case 10: goto L18;
            case 11: goto L15;
            case 12: goto L12;
            default: goto L11;
        };
    L12:
        AIPackageManager.a r23 = (AIPackageManager.a) r16.L$0;
        ResultKt.throwOnFailure(r17);     // Catch: Exception -> L142
    L101:
        Object r25 = (AIPackage) r17;     // Catch: Exception -> L117
    L150:
        return r25;
    L15:
        long r26 = r16.J$0;
        String r27 = (String) r16.L$1;
        AIPackageManager.a r28 = (AIPackageManager.a) r16.L$0;
        ResultKt.throwOnFailure(r17);     // Catch: Exception -> L30
        r10 = r26;
        r0 = r27;
        AIPackageManager.a r29 = r28;
    L95:
        r25 = (Applet) r17;     // Catch: Exception -> L117
        if (r25 != null) goto L150;
        AIPackageDao r30 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L117
        String r31 = r29.getAppId();     // Catch: Exception -> L117
        String r32 = r29.getPackageName();     // Catch: Exception -> L117
        r16.L$0 = r29;     // Catch: Exception -> L117
        r16.L$1 = 0;     // Catch: Exception -> L117
        r16.label = 12;     // Catch: Exception -> L117
        r17 = r30.I(r31, r32, r0, r10, r16);     // Catch: Exception -> L117
        if (r17 != r110) goto L101;
        return r110;
    L18:
        AIPackageManager.a r33 = (AIPackageManager.a) r16.L$0;
        ResultKt.throwOnFailure(r17);     // Catch: Exception -> L142
    L86:
        List r34 = (List) r17;     // Catch: Exception -> L71
        if (r34 != null) goto L149;
        r14 = null;
    L147:
        return r14;
    L149:
        return (Widget) CollectionsKt.firstOrNull(r34);
    L21:
        r0 = (String) r16.L$1;
        AIPackageManager.a r35 = (AIPackageManager.a) r16.L$0;
        ResultKt.throwOnFailure(r17);     // Catch: Exception -> L142
        AIPackageManager.a r36 = r35;
    L78:
        List r37 = (List) r17;     // Catch: Exception -> L71
        if (r37 == null) goto L83;
        r25 = (Applet) CollectionsKt.firstOrNull(r37);     // Catch: Exception -> L71
        if (r25 != null) goto L150;
    L83:
        AIPackageDao r38 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L71
        String r39 = r36.getAppId();     // Catch: Exception -> L71
        String r40 = r36.getPackageName();     // Catch: Exception -> L71
        r16.L$0 = r36;     // Catch: Exception -> L71
        r16.L$1 = null;     // Catch: Exception -> L71
        r16.label = 10;     // Catch: Exception -> L71
        r17 = r38.J(r39, r40, r0, r16);     // Catch: Exception -> L71
        if (r17 != r110) goto L86;
        return r110;
    L24:
        AIPackageManager.a r41 = (AIPackageManager.a) r16.L$0;
        ResultKt.throwOnFailure(r17);     // Catch: Exception -> L142
    L70:
        r25 = (AIPackage) r17;     // Catch: Exception -> L71
        goto L150
    L27:
        long r42 = r16.J$0;
        AIPackageManager.a r43 = (AIPackageManager.a) r16.L$0;
        ResultKt.throwOnFailure(r17);     // Catch: Exception -> L30
        r10 = r42;
        AIPackageManager.a r44 = r43;
    L64:
        r25 = (Applet) r17;     // Catch: Exception -> L71
        if (r25 != null) goto L150;
        AIPackageDao r45 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L71
        String r46 = r44.getAppId();     // Catch: Exception -> L71
        String r47 = r44.getPackageName();     // Catch: Exception -> L71
        r16.L$0 = r44;     // Catch: Exception -> L71
        r16.label = 8;     // Catch: Exception -> L71
        r17 = r45.H(r46, r47, r10, r16);     // Catch: Exception -> L71
        if (r17 != r110) goto L70;
        return r110;
    L32:
        AIPackageManager.a r48 = (AIPackageManager.a) r16.L$0;
        ResultKt.throwOnFailure(r17);     // Catch: Exception -> L142
    L153:
        return (Applet) r17;
    L35:
        AIPackageManager.a r49 = (AIPackageManager.a) r16.L$0;
        ResultKt.throwOnFailure(r17);     // Catch: Exception -> L142
    L114:
        List r50 = (List) r17;     // Catch: Exception -> L117
        if (r50 == null) goto L147;
        return (Applet) CollectionsKt.firstOrNull(r50);
    L38:
        AIPackageManager.a r51 = (AIPackageManager.a) r16.L$0;
        ResultKt.throwOnFailure(r17);     // Catch: Exception -> L142
    L151:
        return (Applet) r17;
    L41:
        AIPackageManager.a r52 = (AIPackageManager.a) r16.L$0;
        ResultKt.throwOnFailure(r17);     // Catch: Exception -> L142
    L156:
        return (Widget) r17;
    L44:
        AIPackageManager.a r53 = (AIPackageManager.a) r16.L$0;
        ResultKt.throwOnFailure(r17);     // Catch: Exception -> L142
    L134:
        List r54 = (List) r17;     // Catch: Exception -> L117
        if (r54 == null) goto L147;
        return (Widget) CollectionsKt.firstOrNull(r54);
    L47:
        AIPackageManager.a r55 = (AIPackageManager.a) r16.L$0;
        ResultKt.throwOnFailure(r17);     // Catch: Exception -> L142
    L154:
        return (Widget) r17;
    L50:
        ResultKt.throwOnFailure(r17);
        g r56 = g.a;     // Catch: Exception -> L142
        StringBuilder r57 = new StringBuilder("packageName: ");     // Catch: Exception -> L142
        r57.append(r18.getPackageName());     // Catch: Exception -> L142
        r57.append(", appId: ");     // Catch: Exception -> L142
        r57.append(r18.getAppId());     // Catch: Exception -> L142
        r57.append(", versionCode: ");     // Catch: Exception -> L142
        r57.append(r10);     // Catch: Exception -> L142
        r57.append(", tryActive ");     // Catch: Exception -> L142
        if (r21 == false) goto L54;
        boolean r58 = true;
    L55:
        r57.append(r58);     // Catch: Exception -> L142
        r57.append(" ===> query AIPackage info database");     // Catch: Exception -> L142
        r56.d("AIPackageStorage", r57.toString());     // Catch: Exception -> L142
        int r59 = a.a[r19.ordinal()];     // Catch: Exception -> L142
        if (r59 == 1) goto L124;
        if (r59 == 2) goto L104;
        if (r21 == false) goto L74;
        AIPackageDao r60 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L142
        String r61 = r18.getAppId();     // Catch: Exception -> L142
        String r62 = r18.getPackageName();     // Catch: Exception -> L142
        r16.L$0 = r1;     // Catch: Exception -> L142
        r16.J$0 = r10;     // Catch: Exception -> L142
        r16.label = 7;     // Catch: Exception -> L142
        r17 = r60.G(r61, r62, r22, r16);     // Catch: Exception -> L71
        r44 = r1;
        if (r17 != r110) goto L64;
        return r110;
    L74:
        if (r10 != 0) goto L90;
        AIPackageDao r63 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L71
        String r64 = r18.getAppId();     // Catch: Exception -> L71
        String r65 = r18.getPackageName();     // Catch: Exception -> L71
        r16.L$0 = r1;     // Catch: Exception -> L71
        r16.L$1 = r0;     // Catch: Exception -> L71
        r16.label = 9;     // Catch: Exception -> L71
        r17 = r63.s(r64, r65, r0, r16);     // Catch: Exception -> L71
        r36 = r1;
        if (r17 != r110) goto L78;
        return r110;
    L90:
        AIPackageDao r66 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L71
        String r67 = r18.getAppId();     // Catch: Exception -> L71
        String r68 = r18.getPackageName();     // Catch: Exception -> L71
        r16.L$0 = r1;     // Catch: Exception -> L71
        r16.L$1 = r0;     // Catch: Exception -> L71
        r16.J$0 = r10;     // Catch: Exception -> L71
        r16.label = 11;     // Catch: Exception -> L71
        r17 = r66.r(r67, r68, r20, r22, r16);     // Catch: Exception -> L117
        r29 = r1;
        if (r17 != r110) goto L95;
        return r110;
    L104:
        if (r21 == false) goto L110;
        AIPackageDao r69 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L117
        String r70 = r18.getAppId();     // Catch: Exception -> L117
        String r71 = r18.getPackageName();     // Catch: Exception -> L117
        r16.L$0 = r1;     // Catch: Exception -> L117
        r16.label = 4;     // Catch: Exception -> L117
        r17 = r69.G(r70, r71, r22, r16);     // Catch: Exception -> L117
        if (r17 != r110) goto L151;
        return r110;
    L110:
        if (r10 != 0) goto L119;
        AIPackageDao r72 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L117
        String r73 = r18.getAppId();     // Catch: Exception -> L117
        String r74 = r18.getPackageName();     // Catch: Exception -> L117
        r16.L$0 = r1;     // Catch: Exception -> L117
        r16.label = 5;     // Catch: Exception -> L117
        r17 = r72.s(r73, r74, r0, r16);     // Catch: Exception -> L117
        if (r17 != r110) goto L114;
        return r110;
    L119:
        AIPackageDao r75 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L117
        String r76 = r18.getAppId();     // Catch: Exception -> L117
        String r77 = r18.getPackageName();     // Catch: Exception -> L117
        r16.L$0 = r1;     // Catch: Exception -> L117
        r16.label = 6;     // Catch: Exception -> L117
        r17 = r75.r(r76, r77, r20, r22, r16);     // Catch: Exception -> L117
        if (r17 != r110) goto L153;
        return r110;
    L124:
        if (r21 == false) goto L130;
        AIPackageDao r78 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L117
        String r79 = r18.getAppId();     // Catch: Exception -> L117
        String r80 = r18.getPackageName();     // Catch: Exception -> L117
        r16.L$0 = r1;     // Catch: Exception -> L117
        r16.label = 1;     // Catch: Exception -> L117
        r17 = r78.H(r79, r80, r22, r16);     // Catch: Exception -> L117
        if (r17 != r110) goto L154;
        return r110;
    L130:
        if (r10 != 0) goto L137;
        AIPackageDao r81 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L117
        String r82 = r18.getAppId();     // Catch: Exception -> L117
        String r83 = r18.getPackageName();     // Catch: Exception -> L117
        r16.L$0 = r1;     // Catch: Exception -> L117
        r16.label = 2;     // Catch: Exception -> L117
        r17 = r81.J(r82, r83, r0, r16);     // Catch: Exception -> L117
        if (r17 != r110) goto L134;
        return r110;
    L137:
        AIPackageDao r84 = AIPackageDatabase.a.b().c();     // Catch: Exception -> L117
        String r85 = r18.getAppId();     // Catch: Exception -> L117
        String r86 = r18.getPackageName();     // Catch: Exception -> L117
        r16.L$0 = r1;     // Catch: Exception -> L117
        r16.label = 3;     // Catch: Exception -> L117
        r17 = r84.I(r85, r86, r20, r22, r16);     // Catch: Exception -> L117
        if (r17 != r110) goto L156;
        return r110;
    L54:
        r58 = false;
        goto L55
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L142:
        e = e;
        ?? r87 = r1;
    L144:
        ?? r88 = r87;
    L145:
        g.a.e("AIPackageStorage", "packageName: " + r88.getPackageName() + ", appId: " + r88.getAppId() + " ===> qyery AIPackage info database error : " + ExceptionsKt.stackTraceToString(e));
    L30:
        e = e;
        r87 = r15;
    L117:
        e = e;
        r88 = r1;
    L71:
        e = e;
        r14 = null;
        r88 = r1;
    L7:
        r14 = this;
        r11 = new AIPackageStorage$queryAIPackageById$1(r14, r24);
        r15 = r12;
        goto L8
    }
}
