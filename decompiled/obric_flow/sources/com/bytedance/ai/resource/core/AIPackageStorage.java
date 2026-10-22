package com.bytedance.ai.resource.core;

import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.resource.core.db.AIPackageDao;
import com.bytedance.ai.resource.core.db.AIPackageDatabase;
import com.bytedance.ai.resource.k;
import com.bytedance.ai.utils.c;
import com.lynx.tasm.utils.e;
import i.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import t0.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ai/resource/core/AIPackageStorage;", "", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAIPackageStorage.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIPackageStorage.kt\ncom/bytedance/ai/resource/core/AIPackageStorage\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,383:1\n1863#2,2:384\n1863#2,2:386\n*S KotlinDebug\n*F\n+ 1 AIPackageStorage.kt\ncom/bytedance/ai/resource/core/AIPackageStorage\n*L\n181#1:384,2\n195#1:386,2\n*E\n"})
public final class AIPackageStorage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AIPackageStorage f2618a = null;

    static {
        f2618a = new AIPackageStorage();
    }

    public AIPackageStorage() {
    }

    public final Object a(k r10, AIPackage.AIPackageType r11, ContinuationImpl r12) {
        if ((r12 instanceof AIPackageStorage$deleteAIPackageById$1) == false) goto L7;
        AIPackageStorage$deleteAIPackageById$1 r5 = (AIPackageStorage$deleteAIPackageById$1) r12;
        int r13 = r5.d;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r5.d = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r5.f2623b;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r5.d;
        boolean r17 = true;
        if (r16 == 0) goto L19;
        if (r16 == 1) goto L12;
        if (r16 == 2) goto L12;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        r10 = r5.f2622a;
        ResultKt.throwOnFailure(r14);     // Catch: Exception -> L17
    L31:
        String r18 = "packageName: " + r10.getPackageName() + ", appId: " + r10.getAppId() + " ===> end delete database";     // Catch: Exception -> L17
        Intrinsics.checkNotNullParameter("AIPackageStorage", "tag");     // Catch: Exception -> L17
        d r19 = c.f2846a;     // Catch: Exception -> L17
        if (r19 == null) goto L40;
        r19.d("AIPackageStorage", r18);     // Catch: Exception -> L17
    L40:
        return Boxing.boxBoolean(r17);
    L19:
        ResultKt.throwOnFailure(r14);
        String r20 = "packageName: " + r10.getPackageName() + ", appId: " + r10.getAppId() + " ===> start delete database";     // Catch: Exception -> L17
        Intrinsics.checkNotNullParameter("AIPackageStorage", "tag");     // Catch: Exception -> L17
        d r21 = c.f2846a;     // Catch: Exception -> L17
        if (r21 == null) goto L24;
        r21.d("AIPackageStorage", r20);     // Catch: Exception -> L17
    L24:
        if (r11 != AIPackage.AIPackageType.f2280b) goto L28;
        AIPackageDao r22 = AIPackageDatabase.Companion.get().userDao();     // Catch: Exception -> L17
        String r110 = r10.getAppId();     // Catch: Exception -> L17
        String r23 = r10.getPackageName();     // Catch: Exception -> L17
        r5.f2622a = r10;     // Catch: Exception -> L17
        r5.d = 1;     // Catch: Exception -> L17
        if (r22.deleteWidgetById(r110, r23, r5) != r15) goto L31;
    L30:
        return r15;
    L28:
        AIPackageDao r24 = AIPackageDatabase.Companion.get().userDao();     // Catch: Exception -> L17
        String r111 = r10.getAppId();     // Catch: Exception -> L17
        String r25 = r10.getPackageName();     // Catch: Exception -> L17
        r5.f2622a = r10;     // Catch: Exception -> L17
        r5.d = 2;     // Catch: Exception -> L17
        if (r24.deleteAppletById(r111, r25, r5) != r15) goto L31;
    L17:
        e = move-exception;
        StringBuilder r112 = new StringBuilder("packageName: ");
        r112.append(r10.getPackageName());
        r112.append(", appId: ");
        r112.append(r10.getAppId());
        r112.append(" ===> delete database error :  ");
        String r26 = a.h(e, r112, "AIPackageStorage");
        d r27 = c.f2846a;
        if (r27 == null) goto L38;
        r27.e("AIPackageStorage", r26);
    L38:
        r17 = false;
    L7:
        r5 = new AIPackageStorage$deleteAIPackageById$1(this, r12);
        goto L8
    }

    public final Object b(ContinuationImpl r10) {
        if ((r10 instanceof AIPackageStorage$queryPackagesToDelete$1) == false) goto L7;
        AIPackageStorage$queryPackagesToDelete$1 r5 = (AIPackageStorage$queryPackagesToDelete$1) r10;
        int r11 = r5.d;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r5.d = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r5.f2662b;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r5.d;
        if (r14 == 0) goto L22;
        if (r14 == 1) goto L19;
        if (r14 != 2) goto L18;
        List r15 = r5.f2661a;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L15
    L34:
        List r16 = (List) r12;     // Catch: Exception -> L15
        if (r16 == null) goto L37;
        r15.addAll(r16);     // Catch: Exception -> L15
    L37:
        return r15;
    L15:
        Exception e = e;
        List r17 = r15;
    L43:
        String r18 = a.h(e, new StringBuilder("query all AIPackage to delete database error : "), "AIPackageStorage");
        d r19 = c.f2846a;
        if (r19 == null) goto L46;
        r19.e("AIPackageStorage", r18);
    L46:
        return r17;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r17 = r5.f2661a;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L39
    L27:
        List r20 = (List) r12;     // Catch: Exception -> L39
        if (r20 == null) goto L30;
        r17.addAll(r20);     // Catch: Exception -> L39
    L30:
        AIPackageDao r21 = AIPackageDatabase.Companion.get().userDao();     // Catch: Exception -> L39
        r5.f2661a = r17;     // Catch: Exception -> L39
        r5.d = 2;     // Catch: Exception -> L39
        r12 = r21.queryWidgetsToDelete(r5);     // Catch: Exception -> L39
        if (r12 != r13) goto L33;
    L32:
        return r13;
    L33:
        r15 = r17;
    L39:
        e = e;
        goto L43
    L22:
        ResultKt.throwOnFailure(r12);
        ArrayList r22 = new ArrayList();
        AIPackageDao r23 = AIPackageDatabase.Companion.get().userDao();     // Catch: Exception -> L41
        r5.f2661a = r22;     // Catch: Exception -> L41
        r5.d = 1;     // Catch: Exception -> L41
        Object r24 = r23.queryAppletsToDelete(r5);     // Catch: Exception -> L41
        if (r24 == r13) goto L32;
        r17 = r22;
        r12 = r24;
    L41:
        e = move-exception;
        r17 = r22;
        e = e;
    L7:
        r5 = new AIPackageStorage$queryPackagesToDelete$1(this, r10);
        goto L8
    }

    public final Object c(AIPackage r10, ContinuationImpl r11) {
        if ((r11 instanceof AIPackageStorage$insertAIPackage$1) == false) goto L7;
        AIPackageStorage$insertAIPackage$1 r5 = (AIPackageStorage$insertAIPackage$1) r11;
        int r12 = r5.d;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r5.d = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r5.f2629b;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r5.d;
        boolean r16 = true;
        if (r15 == 0) goto L19;
        if (r15 == 1) goto L12;
        if (r15 == 2) goto L12;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        r10 = r5.f2628a;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L17
    L31:
        String r17 = "packageName: " + r10.f2259b + ", appId: " + r10.c() + " ===> end insert installed database";     // Catch: Exception -> L17
        Intrinsics.checkNotNullParameter("AIPackageStorage", "tag");     // Catch: Exception -> L17
        d r18 = c.f2846a;     // Catch: Exception -> L17
        if (r18 == null) goto L40;
        r18.d("AIPackageStorage", r17);     // Catch: Exception -> L17
    L40:
        return Boxing.boxBoolean(r16);
    L19:
        ResultKt.throwOnFailure(r13);
        String r19 = "packageName: " + r10.f2259b + ", appId: " + r10.c() + " ===> start insert installed database";     // Catch: Exception -> L17
        Intrinsics.checkNotNullParameter("AIPackageStorage", "tag");     // Catch: Exception -> L17
        d r20 = c.f2846a;     // Catch: Exception -> L17
        if (r20 == null) goto L24;
        r20.d("AIPackageStorage", r19);     // Catch: Exception -> L17
    L24:
        if (r10.e() != AIPackage.AIPackageType.f2280b) goto L28;
        AIPackageDao r21 = AIPackageDatabase.Companion.get().userDao();     // Catch: Exception -> L17
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.bytedance.ai.model.objects.Widget");     // Catch: Exception -> L17
        r5.f2628a = r10;     // Catch: Exception -> L17
        r5.d = 1;     // Catch: Exception -> L17
        if (r21.insertWidget((Widget) r10, r5) != r14) goto L31;
    L30:
        return r14;
    L28:
        AIPackageDao r22 = AIPackageDatabase.Companion.get().userDao();     // Catch: Exception -> L17
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.bytedance.ai.model.objects.Applet");     // Catch: Exception -> L17
        r5.f2628a = r10;     // Catch: Exception -> L17
        r5.d = 2;     // Catch: Exception -> L17
        if (r22.insertApplet((Applet) r10, r5) != r14) goto L31;
    L17:
        e = move-exception;
        StringBuilder r110 = new StringBuilder("packageName: ");
        r110.append(r10.f2259b);
        r110.append(", appId: ");
        r110.append(r10.c());
        r110.append(" ===> insert database error : ");
        String r23 = a.h(e, r110, "AIPackageStorage");
        d r24 = c.f2846a;
        if (r24 == null) goto L38;
        r24.e("AIPackageStorage", r23);
    L38:
        r16 = false;
    L7:
        r5 = new AIPackageStorage$insertAIPackage$1(this, r11);
        goto L8
    }

    public final Object d(AIPackage r10, ContinuationImpl r11) {
        if ((r11 instanceof AIPackageStorage$insertInactiveAIPackage$1) == false) goto L7;
        AIPackageStorage$insertInactiveAIPackage$1 r5 = (AIPackageStorage$insertInactiveAIPackage$1) r11;
        int r12 = r5.d;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r5.d = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r5.f2632b;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r5.d;
        boolean r16 = true;
        if (r15 == 0) goto L19;
        if (r15 == 1) goto L12;
        if (r15 == 2) goto L12;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        r10 = r5.f2631a;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L17
    L31:
        String r17 = "packageName: " + r10.f2259b + ", appId: " + r10.c() + " ===> end insert inactive database";     // Catch: Exception -> L17
        Intrinsics.checkNotNullParameter("AIPackageStorage", "tag");     // Catch: Exception -> L17
        d r18 = c.f2846a;     // Catch: Exception -> L17
        if (r18 == null) goto L40;
        r18.d("AIPackageStorage", r17);     // Catch: Exception -> L17
    L40:
        return Boxing.boxBoolean(r16);
    L19:
        ResultKt.throwOnFailure(r13);
        String r19 = "packageName: " + r10.f2259b + ", appId: " + r10.c() + " ===> start insert inactive database";     // Catch: Exception -> L17
        Intrinsics.checkNotNullParameter("AIPackageStorage", "tag");     // Catch: Exception -> L17
        d r20 = c.f2846a;     // Catch: Exception -> L17
        if (r20 == null) goto L24;
        r20.d("AIPackageStorage", r19);     // Catch: Exception -> L17
    L24:
        if (r10.e() != AIPackage.AIPackageType.f2280b) goto L28;
        AIPackageDao r21 = AIPackageDatabase.Companion.get().userDao();     // Catch: Exception -> L17
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.bytedance.ai.model.objects.Widget");     // Catch: Exception -> L17
        r5.f2631a = r10;     // Catch: Exception -> L17
        r5.d = 1;     // Catch: Exception -> L17
        if (r21.insertInactiveWidget((Widget) r10, r5) != r14) goto L31;
    L30:
        return r14;
    L28:
        AIPackageDao r22 = AIPackageDatabase.Companion.get().userDao();     // Catch: Exception -> L17
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.bytedance.ai.model.objects.Applet");     // Catch: Exception -> L17
        r5.f2631a = r10;     // Catch: Exception -> L17
        r5.d = 2;     // Catch: Exception -> L17
        if (r22.insertInactiveApplet((Applet) r10, r5) != r14) goto L31;
    L17:
        e = move-exception;
        StringBuilder r110 = new StringBuilder("packageName: ");
        r110.append(r10.f2259b);
        r110.append(", appId: ");
        r110.append(r10.c());
        r110.append(" ===> insert database error : ");
        String r23 = a.h(e, r110, "AIPackageStorage");
        d r24 = c.f2846a;
        if (r24 == null) goto L38;
        r24.e("AIPackageStorage", r23);
    L38:
        r16 = false;
    L7:
        r5 = new AIPackageStorage$insertInactiveAIPackage$1(this, r11);
        goto L8
    }

    public final Object b(k r5, AIPackage.AIPackageType r10, ContinuationImpl r11) {
        if ((r11 instanceof AIPackageStorage$markPackageAsDeleted$1) == false) goto L7;
        AIPackageStorage$markPackageAsDeleted$1 r12 = (AIPackageStorage$markPackageAsDeleted$1) r11;
        int r13 = r12.d;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.d = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.f2635b;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.d;
        boolean r17 = true;
        if (r16 == 0) goto L19;
        if (r16 == 1) goto L12;
        if (r16 == 2) goto L12;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        r5 = r12.f2634a;
        ResultKt.throwOnFailure(r14);     // Catch: Exception -> L17
    L36:
    L35:
        return Boxing.boxBoolean(r17);
    L19:
        ResultKt.throwOnFailure(r14);
        int r18 = r10.ordinal();     // Catch: Exception -> L17
        if (r18 == 0) goto L27;
        if (r18 != 1) goto L36;
        AIPackageDao r19 = AIPackageDatabase.Companion.get().userDao();     // Catch: Exception -> L17
        String r20 = r5.getAppId();     // Catch: Exception -> L17
        String r21 = r5.getPackageName();     // Catch: Exception -> L17
        r12.f2634a = r5;     // Catch: Exception -> L17
        r12.d = 1;     // Catch: Exception -> L17
        if (r19.markWidgetToDelete(r20, r21, r12) != r15) goto L36;
    L29:
        return r15;
    L27:
        AIPackageDao r22 = AIPackageDatabase.Companion.get().userDao();     // Catch: Exception -> L17
        String r23 = r5.getAppId();     // Catch: Exception -> L17
        String r24 = r5.getPackageName();     // Catch: Exception -> L17
        r12.f2634a = r5;     // Catch: Exception -> L17
        r12.d = 2;     // Catch: Exception -> L17
        if (r22.markAppletToDelete(r23, r24, r12) != r15) goto L36;
    L17:
        e = move-exception;
        StringBuilder r25 = new StringBuilder("Failed to markPackageAsDeleted. packageName: ");
        r25.append(r5.getPackageName());
        r25.append(", appId: ");
        r25.append(r5.getAppId());
        r25.append(",  error: ");
        String r26 = a.h(e, r25, "AIPackageStorage");
        d r27 = c.f2846a;
        if (r27 == null) goto L33;
        r27.e("AIPackageStorage", r26);
    L33:
        r17 = false;
    L7:
        r12 = new AIPackageStorage$markPackageAsDeleted$1(this, r11);
        goto L8
    }

    public final Object a(k r18, AIPackage.AIPackageType r19, String r20, boolean r21, long r22, ContinuationImpl r24) {
        k r5 = r18;
        String r10 = r20;
        long r11 = r22;
        if ((r24 instanceof AIPackageStorage$queryAIPackageById$1) == false) goto L8;
        AIPackageStorage$queryAIPackageById$1 r12 = (AIPackageStorage$queryAIPackageById$1) r24;
        int r13 = r12.f;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L8;
        r12.f = r13 - Integer.MIN_VALUE;
    L7:
        AIPackageStorage$queryAIPackageById$1 r14 = r12;
        Object r15 = r14.d;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r14.f) {
            case 0: goto L55;
            case 1: goto L52;
            case 2: goto L49;
            case 3: goto L46;
            case 4: goto L43;
            case 5: goto L40;
            case 6: goto L37;
            case 7: goto L32;
            case 8: goto L29;
            case 9: goto L26;
            case 10: goto L23;
            case 11: goto L18;
            case 12: goto L13;
            default: goto L12;
        };
    L13:
        k r17 = r14.f2637a;
        ResultKt.throwOnFailure(r15);     // Catch: Exception -> L16
    L105:
        return (AIPackage) r15;
    L18:
        long r23 = r14.f2639c;
        String r25 = r14.f2638b;
        k r26 = r14.f2637a;
        ResultKt.throwOnFailure(r15);     // Catch: Exception -> L21
        r11 = r23;
        r10 = r25;
        r5 = r26;
    L98:
        Applet r27 = (Applet) r15;     // Catch: Exception -> L106
        if (r27 == null) goto L101;
        return r27;
    L101:
        AIPackageDao r28 = AIPackageDatabase.Companion.get().userDao();     // Catch: Exception -> L106
        String r29 = r5.getAppId();     // Catch: Exception -> L106
        String r30 = r5.getPackageName();     // Catch: Exception -> L106
        r14.f2637a = r5;     // Catch: Exception -> L106
        r14.f2638b = null;     // Catch: Exception -> L106
        r14.f = 12;     // Catch: Exception -> L106
        r15 = r28.queryWidgetById(r29, r30, r10, r11, r14);     // Catch: Exception -> L106
        if (r15 != r16) goto L105;
    L149:
        return r16;
    L21:
        e = e;
        r5 = r26;
    L152:
        StringBuilder r31 = new StringBuilder("packageName: ");
        r31.append(r5.getPackageName());
        r31.append(", appId: ");
        r31.append(r5.getAppId());
        r31.append(" ===> qyery AIPackage info database error : ");
        String r32 = a.h(e, r31, "AIPackageStorage");
        d r33 = c.f2846a;
        if (r33 == null) goto L155;
        r33.e("AIPackageStorage", r32);
    L155:
        return null;
    L23:
        k r34 = r14.f2637a;
        ResultKt.throwOnFailure(r15);     // Catch: Exception -> L16
    L88:
        List r35 = (List) r15;     // Catch: Exception -> L16
        if (r35 != null) goto L91;
        return null;
    L91:
        return (Widget) CollectionsKt.firstOrNull(r35);
    L26:
        r10 = r14.f2638b;
        r5 = r14.f2637a;
        ResultKt.throwOnFailure(r15);     // Catch: Exception -> L16
    L80:
        List r36 = (List) r15;     // Catch: Exception -> L16
        if (r36 == null) goto L85;
        Applet r37 = (Applet) CollectionsKt.firstOrNull(r36);     // Catch: Exception -> L16
        if (r37 == null) goto L85;
        return r37;
    L85:
        AIPackageDao r38 = AIPackageDatabase.Companion.get().userDao();     // Catch: Exception -> L16
        String r39 = r5.getAppId();     // Catch: Exception -> L16
        String r40 = r5.getPackageName();     // Catch: Exception -> L16
        r14.f2637a = r5;     // Catch: Exception -> L16
        r14.f2638b = null;     // Catch: Exception -> L16
        r14.f = 10;     // Catch: Exception -> L16
        r15 = r38.queryWidgetById(r39, r40, r10, r14);     // Catch: Exception -> L16
        if (r15 != r16) goto L88;
    L29:
        k r41 = r14.f2637a;
        ResultKt.throwOnFailure(r15);     // Catch: Exception -> L16
    L74:
        return (AIPackage) r15;
    L32:
        long r42 = r14.f2639c;
        k r43 = r14.f2637a;
        ResultKt.throwOnFailure(r15);     // Catch: Exception -> L35
        r11 = r42;
        r5 = r43;
    L67:
        Applet r44 = (Applet) r15;     // Catch: Exception -> L16
        if (r44 == null) goto L70;
        return r44;
    L70:
        AIPackageDao r45 = AIPackageDatabase.Companion.get().userDao();     // Catch: Exception -> L16
        String r46 = r5.getAppId();     // Catch: Exception -> L16
        String r47 = r5.getPackageName();     // Catch: Exception -> L16
        r14.f2637a = r5;     // Catch: Exception -> L16
        r14.f = 8;     // Catch: Exception -> L16
        r15 = r45.queryOrActiveWidget(r46, r47, r11, r14);     // Catch: Exception -> L16
        if (r15 != r16) goto L74;
    L35:
        e = e;
        r5 = r43;
        goto L152
    L37:
        k r48 = r14.f2637a;
        ResultKt.throwOnFailure(r15);     // Catch: Exception -> L16
    L151:
        return (Applet) r15;
    L40:
        k r49 = r14.f2637a;
        ResultKt.throwOnFailure(r15);     // Catch: Exception -> L16
    L142:
        List r50 = (List) r15;     // Catch: Exception -> L106
        if (r50 != null) goto L145;
        return null;
    L145:
        return (Applet) CollectionsKt.firstOrNull(r50);
    L43:
        k r51 = r14.f2637a;
        ResultKt.throwOnFailure(r15);     // Catch: Exception -> L16
    L136:
        return (Applet) r15;
    L46:
        k r52 = r14.f2637a;
        ResultKt.throwOnFailure(r15);     // Catch: Exception -> L16
    L129:
        return (Widget) r15;
    L49:
        k r53 = r14.f2637a;
        ResultKt.throwOnFailure(r15);     // Catch: Exception -> L16
    L120:
        List r54 = (List) r15;     // Catch: Exception -> L106
        if (r54 != null) goto L123;
        return null;
    L123:
        return (Widget) CollectionsKt.firstOrNull(r54);
    L52:
        k r55 = r14.f2637a;
        ResultKt.throwOnFailure(r15);     // Catch: Exception -> L16
    L114:
        return (Widget) r15;
    L55:
        ResultKt.throwOnFailure(r15);
        String r56 = "packageName: " + r18.getPackageName() + ", appId: " + r18.getAppId() + ", versionCode: " + r11 + ", tryActive " + r21 + " ===> query AIPackage info database";     // Catch: Exception -> L16
        Intrinsics.checkNotNullParameter("AIPackageStorage", "tag");     // Catch: Exception -> L16
        d r57 = c.f2846a;     // Catch: Exception -> L16
        if (r57 == null) goto L59;
        r57.d("AIPackageStorage", r56);     // Catch: Exception -> L16
    L59:
        int r58 = r19.ordinal();     // Catch: Exception -> L16
        if (r58 == 0) goto L131;
        if (r58 == 1) goto L109;
        if (r21 == false) goto L76;
        AIPackageDao r59 = AIPackageDatabase.Companion.get().userDao();     // Catch: Exception -> L16
        String r60 = r18.getAppId();     // Catch: Exception -> L16
        String r61 = r18.getPackageName();     // Catch: Exception -> L16
        r14.f2637a = r5;     // Catch: Exception -> L16
        r14.f2639c = r11;     // Catch: Exception -> L16
        r14.f = 7;     // Catch: Exception -> L16
        r15 = r59.queryOrActiveApplet(r60, r61, r22, r14);     // Catch: Exception -> L16
        if (r15 != r16) goto L67;
    L76:
        if (r11 != 0) goto L93;
        AIPackageDao r62 = AIPackageDatabase.Companion.get().userDao();     // Catch: Exception -> L16
        String r63 = r18.getAppId();     // Catch: Exception -> L16
        String r64 = r18.getPackageName();     // Catch: Exception -> L16
        r14.f2637a = r5;     // Catch: Exception -> L16
        r14.f2638b = r10;     // Catch: Exception -> L16
        r14.f = 9;     // Catch: Exception -> L16
        r15 = r62.queryAppletById(r63, r64, r10, r14);     // Catch: Exception -> L16
        if (r15 != r16) goto L80;
    L93:
        AIPackageDao r65 = AIPackageDatabase.Companion.get().userDao();     // Catch: Exception -> L16
        String r66 = r18.getAppId();     // Catch: Exception -> L16
        String r67 = r18.getPackageName();     // Catch: Exception -> L16
        r14.f2637a = r5;     // Catch: Exception -> L16
        r14.f2638b = r10;     // Catch: Exception -> L16
        r14.f2639c = r11;     // Catch: Exception -> L16
        r14.f = 11;     // Catch: Exception -> L16
        r15 = r65.queryAppletById(r66, r67, r20, r22, r14);     // Catch: Exception -> L106
        if (r15 != r16) goto L98;
    L109:
        if (r21 == false) goto L116;
        AIPackageDao r68 = AIPackageDatabase.Companion.get().userDao();     // Catch: Exception -> L106
        String r69 = r18.getAppId();     // Catch: Exception -> L106
        String r70 = r18.getPackageName();     // Catch: Exception -> L106
        r14.f2637a = r5;     // Catch: Exception -> L106
        r14.f = 1;     // Catch: Exception -> L106
        r15 = r68.queryOrActiveWidget(r69, r70, r22, r14);     // Catch: Exception -> L106
        if (r15 != r16) goto L114;
    L116:
        if (r11 != 0) goto L125;
        AIPackageDao r71 = AIPackageDatabase.Companion.get().userDao();     // Catch: Exception -> L106
        String r72 = r18.getAppId();     // Catch: Exception -> L106
        String r73 = r18.getPackageName();     // Catch: Exception -> L106
        r14.f2637a = r5;     // Catch: Exception -> L106
        r14.f = 2;     // Catch: Exception -> L106
        r15 = r71.queryWidgetById(r72, r73, r10, r14);     // Catch: Exception -> L106
        if (r15 != r16) goto L120;
    L125:
        AIPackageDao r74 = AIPackageDatabase.Companion.get().userDao();     // Catch: Exception -> L106
        String r75 = r18.getAppId();     // Catch: Exception -> L106
        String r76 = r18.getPackageName();     // Catch: Exception -> L106
        r14.f2637a = r5;     // Catch: Exception -> L106
        r14.f = 3;     // Catch: Exception -> L106
        r15 = r74.queryWidgetById(r75, r76, r20, r22, r14);     // Catch: Exception -> L106
        if (r15 != r16) goto L129;
    L131:
        if (r21 == false) goto L138;
        AIPackageDao r77 = AIPackageDatabase.Companion.get().userDao();     // Catch: Exception -> L106
        String r78 = r18.getAppId();     // Catch: Exception -> L106
        String r79 = r18.getPackageName();     // Catch: Exception -> L106
        r14.f2637a = r5;     // Catch: Exception -> L106
        r14.f = 4;     // Catch: Exception -> L106
        r15 = r77.queryOrActiveApplet(r78, r79, r22, r14);     // Catch: Exception -> L106
        if (r15 != r16) goto L136;
    L138:
        if (r11 != 0) goto L147;
        AIPackageDao r80 = AIPackageDatabase.Companion.get().userDao();     // Catch: Exception -> L106
        String r81 = r18.getAppId();     // Catch: Exception -> L106
        String r82 = r18.getPackageName();     // Catch: Exception -> L106
        r14.f2637a = r5;     // Catch: Exception -> L106
        r14.f = 5;     // Catch: Exception -> L106
        r15 = r80.queryAppletById(r81, r82, r10, r14);     // Catch: Exception -> L106
        if (r15 != r16) goto L142;
    L147:
        AIPackageDao r83 = AIPackageDatabase.Companion.get().userDao();     // Catch: Exception -> L106
        String r84 = r18.getAppId();     // Catch: Exception -> L106
        String r85 = r18.getPackageName();     // Catch: Exception -> L106
        r14.f2637a = r5;     // Catch: Exception -> L106
        r14.f = 6;     // Catch: Exception -> L106
        r15 = r83.queryAppletById(r84, r85, r20, r22, r14);     // Catch: Exception -> L106
        if (r15 != r16) goto L151;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        e = e;
    L106:
        e = e;
    L8:
        r12 = new AIPackageStorage$queryAIPackageById$1(this, r24);
        goto L7
    }

    public final Object b(AIPackage r10, ContinuationImpl r11) {
        if ((r11 instanceof AIPackageStorage$getFileListToRemoved$1) == false) goto L8;
        AIPackageStorage$getFileListToRemoved$1 r5 = (AIPackageStorage$getFileListToRemoved$1) r11;
        int r12 = r5.d;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L8;
        r5.d = r12 - Integer.MIN_VALUE;
    L7:
        AIPackageStorage$getFileListToRemoved$1 r13 = r5;
        Object r14 = r13.f2626b;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r13.d;
        if (r16 == 0) goto L15;
        if (r16 != 1) goto L14;
        r10 = r13.f2625a;
        ResultKt.throwOnFailure(r14);
    L18:
        List r17 = (List) r14;
        String r18 = "packageName: " + r10.f2259b + ", appId: " + r10.c() + " ===> rename outdated file";
        Intrinsics.checkNotNullParameter("AIPackageStorage", "tag");
        d r19 = c.f2846a;
        if (r19 == null) goto L21;
        r19.d("AIPackageStorage", r18);
    L21:
        return r17;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r14);
        AIPackageDao r20 = AIPackageDatabase.Companion.get().userDao();
        long r21 = r10.f2260c;
        String r22 = r10.c();
        String r23 = r10.f2267n;
        r13.f2625a = r10;
        r13.d = 1;
        r14 = r20.renameOutdatedFile$ai_sdk_release(r21, r22, r10.f2259b, r23, r13);
        if (r14 != r15) goto L18;
        return r15;
    L8:
        r5 = new AIPackageStorage$getFileListToRemoved$1(this, r11);
        goto L7
    }

    public final Object a(k r12, AIPackage.AIPackageType r13, boolean r14, long r15, ContinuationImpl r17) {
        if ((r17 instanceof AIPackageStorage$queryInstallAIPackageById$2) == false) goto L8;
        AIPackageStorage$queryInstallAIPackageById$2 r5 = (AIPackageStorage$queryInstallAIPackageById$2) r17;
        int r10 = r5.f2648c;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L8;
        r5.f2648c = r10 - Integer.MIN_VALUE;
    L7:
        AIPackageStorage$queryInstallAIPackageById$2 r11 = r5;
        Object r16 = r11.f2646a;
        Object r18 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r19 = r11.f2648c;
        if (r19 == 0) goto L15;
        if (r19 != 1) goto L14;
        ResultKt.throwOnFailure(r16);
    L18:
        AIPackage r20 = (AIPackage) r16;
        if (r20 != null) goto L21;
    L28:
        return null;
    L21:
        if (Intrinsics.areEqual(r20.f2274v, "installed") == false) goto L28;
        Integer r21 = r20.f2275w;
        if (r21 != null) goto L26;
    L27:
        return r20;
    L26:
        if (r21.intValue() == 1) goto L28;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r16);
        r11.f2648c = 1;
        r16 = a(r12, r13, "installed", r14, r15, r11);
        if (r16 != r18) goto L18;
        return r18;
    L8:
        r5 = new AIPackageStorage$queryInstallAIPackageById$2(this, r17);
        goto L7
    }

    public final Object a(k r11, AIPackage.AIPackageType r12, long r13, ContinuationImpl r15) {
        if ((r15 instanceof AIPackageStorage$queryInactiveAIPackageById$1) == false) goto L8;
        AIPackageStorage$queryInactiveAIPackageById$1 r5 = (AIPackageStorage$queryInactiveAIPackageById$1) r15;
        int r10 = r5.f2642c;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L8;
        r5.f2642c = r10 - Integer.MIN_VALUE;
    L7:
        AIPackageStorage$queryInactiveAIPackageById$1 r14 = r5;
        Object r16 = r14.f2640a;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r18 = r14.f2642c;
        if (r18 == 0) goto L15;
        if (r18 != 1) goto L14;
        ResultKt.throwOnFailure(r16);
    L18:
        AIPackage r19 = (AIPackage) r16;
        if (r19 != null) goto L21;
    L28:
        return null;
    L21:
        if (Intrinsics.areEqual(r19.f2274v, "inactive") == false) goto L28;
        Integer r110 = r19.f2275w;
        if (r110 != null) goto L26;
    L27:
        return r19;
    L26:
        if (r110.intValue() == 1) goto L28;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r16);
        r14.f2642c = 1;
        r16 = a(r11, r12, "inactive", false, r13, r14);
        if (r16 != r17) goto L18;
        return r17;
    L8:
        r5 = new AIPackageStorage$queryInactiveAIPackageById$1(this, r15);
        goto L7
    }

    public final Object a(k r10, ContinuationImpl r11) {
        if ((r11 instanceof AIPackageStorage$queryInstallOrInactiveAIPackageById$1) == false) goto L8;
        AIPackageStorage$queryInstallOrInactiveAIPackageById$1 r5 = (AIPackageStorage$queryInstallOrInactiveAIPackageById$1) r11;
        int r12 = r5.e;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L8;
        r5.e = r12 - Integer.MIN_VALUE;
    L7:
        AIPackageStorage$queryInstallOrInactiveAIPackageById$1 r13 = r5;
        Object r14 = r13.f2651c;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r13.e;
        if (r16 == 0) goto L19;
        if (r16 == 1) goto L17;
        if (r16 != 2) goto L16;
        ResultKt.throwOnFailure(r14);
        return r14;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r10 = r13.f2650b;
        AIPackageStorage this = r13.f2649a;
        ResultKt.throwOnFailure(r14);
    L18:
        AIPackageStorage r17 = this;
        k r18 = r10;
        AIPackage r19 = (AIPackage) r14;
        if (r19 == null) goto L25;
        return r19;
    L25:
        r13.f2649a = null;
        r13.f2650b = null;
        r13.e = 2;
        r17.getClass();
        Object r20 = r17.a(r18, AIPackage.AIPackageType.f2281c, false, 0, r13);
        if (r20 != r15) goto L28;
    L27:
        return r15;
    L28:
        return r20;
    L19:
        ResultKt.throwOnFailure(r14);
        AIPackage.AIPackageType r21 = AIPackage.AIPackageType.f2281c;
        r13.f2649a = this;
        r13.f2650b = r10;
        r13.e = 1;
        r14 = a(r10, r21, 0, r13);
        if (r14 != r15) goto L18;
    L8:
        r5 = new AIPackageStorage$queryInstallOrInactiveAIPackageById$1(this, r11);
        goto L7
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0071 -> B:27:0x0075). Please report as a decompilation issue!!! */
    public final Object a(List r12, boolean r13, ContinuationImpl r14) {
        if ((r14 instanceof AIPackageStorage$queryInstalledAIPackagesByIds$1) == false) goto L7;
        AIPackageStorage$queryInstalledAIPackagesByIds$1 r5 = (AIPackageStorage$queryInstalledAIPackagesByIds$1) r14;
        int r10 = r5.g;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r5.g = r10 - Integer.MIN_VALUE;
    L8:
        Object r11 = r5.e;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r5.g;
        if (r16 == 0) goto L18;
        if (r16 != 1) goto L17;
        boolean r17 = r5.d;
        Iterator r18 = r5.f2654c;
        List r19 = r5.f2653b;
        List r20 = r5.f2652a;
        ResultKt.throwOnFailure(r11);     // Catch: Exception -> L14
    L27:
        AIPackage r110 = (AIPackage) r11;     // Catch: Exception -> L14
        if (r110 == null) goto L30;
        r19.add(r110);     // Catch: Exception -> L14
    L30:
        boolean r111 = r17;
        r12 = r20;
    L41:
    L31:
        Exception e = e;
    L36:
        r20 = r12;
    L37:
        StringBuilder r112 = new StringBuilder("query ");
        r112.append(r20);
        r112.append(" info database error : ");
        String r113 = a.h(e, r112, "AIPackageStorage");
        d r114 = c.f2846a;
        if (r114 == null) goto L40;
        r114.e("AIPackageStorage", r113);
    L40:
        return r19;
    L22:
        if (r18.hasNext() == false) goto L33;
        k r21 = (k) r18.next();     // Catch: Exception -> L31
        AIPackageStorage r22 = f2618a;     // Catch: Exception -> L31
        AIPackage.AIPackageType r23 = AIPackage.AIPackageType.f2281c;     // Catch: Exception -> L31
        r5.f2652a = r12;     // Catch: Exception -> L31
        r5.f2653b = r19;     // Catch: Exception -> L31
        r5.f2654c = r18;     // Catch: Exception -> L31
        r5.d = r111;     // Catch: Exception -> L31
        r5.g = 1;     // Catch: Exception -> L31
        Object r24 = r22.a(r21, r23, r111, 0, r5);     // Catch: Exception -> L31
        if (r24 != r15) goto L26;
        return r15;
    L26:
        List r115 = r12;
        r17 = r111;
        r11 = r24;
        r20 = r115;
        goto L27
    L33:
        return r19;
    L14:
        e = e;
        goto L37
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r11);
        ArrayList r116 = new ArrayList();
        r19 = r116;
        r111 = r13;
        r18 = r12.iterator();     // Catch: Exception -> L34
    L34:
        e = move-exception;
        r19 = r116;
        e = e;
    L7:
        r5 = new AIPackageStorage$queryInstalledAIPackagesByIds$1(this, r14);
        goto L8
    }

    public final Object a(String r10, ContinuationImpl r11) {
        if ((r11 instanceof AIPackageStorage$queryInstalledAIPackagesByPackageName$1) == false) goto L7;
        AIPackageStorage$queryInstalledAIPackagesByPackageName$1 r5 = (AIPackageStorage$queryInstalledAIPackagesByPackageName$1) r11;
        int r12 = r5.e;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r5.e = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r5.f2657c;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r5.e;
        if (r15 == 0) goto L24;
        if (r15 == 1) goto L19;
        if (r15 != 2) goto L18;
        List r16 = r5.f2656b;
        String r17 = r5.f2655a;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L15
    L36:
        List r18 = (List) r13;     // Catch: Exception -> L15
        if (r18 == null) goto L39;
        r16.addAll(r18);     // Catch: Exception -> L15
    L39:
        return r16;
    L15:
        Exception e = e;
        String r19 = r17;
        List r20 = r16;
        r10 = r19;
    L43:
        String r21 = a.h(e, e.b("query ", r10, " info database error : "), "AIPackageStorage");
        d r22 = c.f2846a;
        if (r22 == null) goto L46;
        r22.e("AIPackageStorage", r21);
    L46:
        return r20;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r16 = r5.f2656b;
        String r23 = r5.f2655a;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L22
    L29:
        List r24 = (List) r13;     // Catch: Exception -> L22
        if (r24 == null) goto L32;
        r16.addAll(r24);     // Catch: Exception -> L22
    L32:
        AIPackageDao r25 = AIPackageDatabase.Companion.get().userDao();     // Catch: Exception -> L22
        r5.f2655a = r23;     // Catch: Exception -> L22
        r5.f2656b = r16;     // Catch: Exception -> L22
        r5.e = 2;     // Catch: Exception -> L22
        r13 = r25.queryInstalledAppletsByPackageName(r23, r5);     // Catch: Exception -> L22
        if (r13 != r14) goto L35;
    L34:
        return r14;
    L35:
        r17 = r23;
    L22:
        e = e;
        r20 = r16;
        r10 = r23;
        goto L43
    L24:
        ResultKt.throwOnFailure(r13);
        ArrayList r26 = new ArrayList();
        AIPackageDao r27 = AIPackageDatabase.Companion.get().userDao();     // Catch: Exception -> L41
        r5.f2655a = r10;     // Catch: Exception -> L41
        r5.f2656b = r26;     // Catch: Exception -> L41
        r5.e = 1;     // Catch: Exception -> L41
        Object r28 = r27.queryInstalledWidgetsByPackageName(r10, r5);     // Catch: Exception -> L41
        if (r28 == r14) goto L34;
        r16 = r26;
        r13 = r28;
        r23 = r10;
    L41:
        e = move-exception;
        r20 = r26;
        e = e;
    L7:
        r5 = new AIPackageStorage$queryInstalledAIPackagesByPackageName$1(this, r11);
        goto L8
    }

    public final Object a(ContinuationImpl r10) {
        if ((r10 instanceof AIPackageStorage$queryInactiveAIPackages$1) == false) goto L7;
        AIPackageStorage$queryInactiveAIPackages$1 r5 = (AIPackageStorage$queryInactiveAIPackages$1) r10;
        int r11 = r5.d;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r5.d = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r5.f2644b;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r5.d;
        if (r14 == 0) goto L22;
        if (r14 == 1) goto L19;
        if (r14 != 2) goto L18;
        List r15 = r5.f2643a;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L15
    L34:
        List r16 = (List) r12;     // Catch: Exception -> L15
        if (r16 == null) goto L37;
        r15.addAll(r16);     // Catch: Exception -> L15
    L37:
        return r15;
    L15:
        Exception e = e;
        List r17 = r15;
    L43:
        String r18 = a.h(e, new StringBuilder("query all inactive AIPackage info database error : "), "AIPackageStorage");
        d r19 = c.f2846a;
        if (r19 == null) goto L46;
        r19.e("AIPackageStorage", r18);
    L46:
        return r17;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r17 = r5.f2643a;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L39
    L27:
        List r20 = (List) r12;     // Catch: Exception -> L39
        if (r20 == null) goto L30;
        r17.addAll(r20);     // Catch: Exception -> L39
    L30:
        AIPackageDao r21 = AIPackageDatabase.Companion.get().userDao();     // Catch: Exception -> L39
        r5.f2643a = r17;     // Catch: Exception -> L39
        r5.d = 2;     // Catch: Exception -> L39
        r12 = r21.queryInactiveApplets(r5);     // Catch: Exception -> L39
        if (r12 != r13) goto L33;
    L32:
        return r13;
    L33:
        r15 = r17;
    L39:
        e = e;
        goto L43
    L22:
        ResultKt.throwOnFailure(r12);
        ArrayList r22 = new ArrayList();
        AIPackageDao r23 = AIPackageDatabase.Companion.get().userDao();     // Catch: Exception -> L41
        r5.f2643a = r22;     // Catch: Exception -> L41
        r5.d = 1;     // Catch: Exception -> L41
        Object r24 = r23.queryInactiveWidgets(r5);     // Catch: Exception -> L41
        if (r24 == r13) goto L32;
        r17 = r22;
        r12 = r24;
    L41:
        e = move-exception;
        r17 = r22;
        e = e;
    L7:
        r5 = new AIPackageStorage$queryInactiveAIPackages$1(this, r10);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15, types: [com.bytedance.ai.model.objects.AIPackage$AIPackageType] */
    /* JADX WARN: Type inference failed for: r1v16, types: [com.bytedance.ai.model.objects.AIPackage$AIPackageType] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.util.ArrayList, java.util.List] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.bytedance.ai.model.objects.AIPackage$AIPackageType, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v15, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r8v18, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v30 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    public final Object a(AIPackage.AIPackageType r10, ContinuationImpl r11) {
        if ((r11 instanceof AIPackageStorage$queryInstalledAIPackagesByType$1) == false) goto L7;
        AIPackageStorage$queryInstalledAIPackagesByType$1 r5 = (AIPackageStorage$queryInstalledAIPackagesByType$1) r11;
        int r12 = r5.e;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r5.e = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r5.f2660c;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r5.e;
        if (r15 == 0) goto L32;
        if (r15 == 1) goto L29;
        if (r15 == 2) goto L26;
        if (r15 == 3) goto L21;
        if (r15 != 4) goto L20;
        List r16 = r5.f2659b;
        AIPackage.AIPackageType r17 = r5.f2658a;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L17
        Object r18 = r13;
        ?? r19 = r16;
    L47:
        List r20 = (List) r18;     // Catch: Exception -> L17
        if (r20 == null) goto L50;
        r19.addAll(r20);     // Catch: Exception -> L17
    L50:
        return r19;
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        ?? r21 = r5.f2659b;
        ?? r22 = r5.f2658a;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L24
        r22 = r22;
        Object r23 = r13;
        r21 = r21;
    L40:
        List r24 = (List) r23;     // Catch: Exception -> L24
        if (r24 == null) goto L43;
        r21.addAll(r24);     // Catch: Exception -> L24
    L43:
        AIPackageDao r25 = AIPackageDatabase.Companion.get().userDao();     // Catch: Exception -> L24
        r5.f2658a = r22;     // Catch: Exception -> L24
        r5.f2659b = r21;     // Catch: Exception -> L24
        r5.e = 4;     // Catch: Exception -> L24
        Object r26 = r25.queryInstalledWidgets(r5);     // Catch: Exception -> L24
        ?? r27 = r26;
        r10 = r21;
        if (r26 == r14) goto L77;
        r18 = r26;
        r19 = r21;
    L77:
        return r14;
    L52:
        e = move-exception;
        ?? r28 = r27;
        e = e;
        ?? r29 = r10;
    L71:
        ?? r30 = new StringBuilder("query all ");
        r30.append(r29);
        r30.append(" AIPackage info database error : ");
        String r31 = a.h(e, r30, "AIPackageStorage");
        d r32 = c.f2846a;
        if (r32 == null) goto L74;
        r32.e("AIPackageStorage", r31);
    L74:
        return r28;
    L24:
        e = e;
        r28 = r21;
        r29 = r22;
        goto L71
    L26:
        List r33 = r5.f2659b;
        AIPackage.AIPackageType r34 = r5.f2658a;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L17
        Object r35 = r13;
        ?? r36 = r33;
    L58:
        List r37 = (List) r35;     // Catch: Exception -> L17
        if (r37 == null) goto L61;
        r36.addAll(r37);     // Catch: Exception -> L17
    L61:
        return r36;
    L29:
        List r38 = r5.f2659b;
        AIPackage.AIPackageType r39 = r5.f2658a;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L17
        Object r40 = r13;
        ?? r41 = r38;
    L66:
        List r42 = (List) r40;     // Catch: Exception -> L17
        if (r42 == null) goto L69;
        r41.addAll(r42);     // Catch: Exception -> L17
    L69:
        return r41;
    L32:
        ResultKt.throwOnFailure(r13);
        r27 = new ArrayList();
        int r43 = r10.ordinal();     // Catch: Exception -> L52
        if (r43 == 0) goto L62;
        if (r43 == 1) goto L54;
        AIPackageDao r44 = AIPackageDatabase.Companion.get().userDao();     // Catch: Exception -> L52
        r5.f2658a = r10;     // Catch: Exception -> L52
        r5.f2659b = r27;     // Catch: Exception -> L52
        r5.e = 3;     // Catch: Exception -> L52
        Object r45 = r44.queryInstalledApplets(r5);     // Catch: Exception -> L52
        r27 = r27;
        r10 = r10;
        if (r45 == r14) goto L77;
        r21 = r27;
        r23 = r45;
        r22 = r10;
        goto L40
    L54:
        AIPackageDao r46 = AIPackageDatabase.Companion.get().userDao();     // Catch: Exception -> L52
        r5.f2658a = r10;     // Catch: Exception -> L52
        r5.f2659b = r27;     // Catch: Exception -> L52
        r5.e = 2;     // Catch: Exception -> L52
        Object r47 = r46.queryInstalledWidgets(r5);     // Catch: Exception -> L52
        r27 = r27;
        r10 = r10;
        if (r47 == r14) goto L77;
        r36 = r27;
        r35 = r47;
        goto L58
    L62:
        AIPackageDao r48 = AIPackageDatabase.Companion.get().userDao();     // Catch: Exception -> L52
        r5.f2658a = r10;     // Catch: Exception -> L52
        r5.f2659b = r27;     // Catch: Exception -> L52
        r5.e = 1;     // Catch: Exception -> L52
        Object r49 = r48.queryInstalledApplets(r5);     // Catch: Exception -> L52
        r27 = r27;
        r10 = r10;
        if (r49 == r14) goto L77;
        r41 = r27;
        r40 = r49;
    L17:
        e = e;
        r28 = r10;
        r29 = r14;
    L7:
        r5 = new AIPackageStorage$queryInstalledAIPackagesByType$1(this, r11);
        goto L8
    }

    public final Object a(AIPackage r12, ContinuationImpl r13) {
        if ((r13 instanceof AIPackageStorage$cleanPackageToDelete$1) == false) goto L7;
        AIPackageStorage$cleanPackageToDelete$1 r5 = (AIPackageStorage$cleanPackageToDelete$1) r13;
        int r10 = r5.e;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r5.e = r10 - Integer.MIN_VALUE;
    L8:
        Object r14 = r5.f2621c;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r5.e;
        if (r15 == 0) goto L23;
        if (r15 == 1) goto L20;
        if (r15 == 2) goto L20;
        if (r15 != 3) goto L19;
        AIPackage r16 = (AIPackage) r5.f2619a;
        ResultKt.throwOnFailure(r14);     // Catch: Exception -> L16
        return r14;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        AIPackage r17 = r5.f2620b;
        r12 = r17;
        AIPackageStorage this = (AIPackageStorage) r5.f2619a;
        ResultKt.throwOnFailure(r14);     // Catch: Exception -> L16
    L35:
        String r18 = "packageName: " + r12.f2259b + ", appId: " + r12.c() + " ===> end delete database";     // Catch: Exception -> L16
        Intrinsics.checkNotNullParameter("AIPackageStorage", "tag");     // Catch: Exception -> L16
        d r19 = c.f2846a;     // Catch: Exception -> L16
        if (r19 == null) goto L38;
        r19.d("AIPackageStorage", r18);     // Catch: Exception -> L16
    L38:
        r5.f2619a = r12;     // Catch: Exception -> L16
        r5.f2620b = null;     // Catch: Exception -> L16
        r5.e = 3;     // Catch: Exception -> L16
        Object r110 = this.b(r12, r5);     // Catch: Exception -> L16
        if (r110 != r11) goto L41;
    L40:
        return r11;
    L41:
        return r110;
    L23:
        ResultKt.throwOnFailure(r14);
        String r111 = "packageName: " + r12.f2259b + ", appId: " + r12.c() + " ===> start delete database";     // Catch: Exception -> L16
        Intrinsics.checkNotNullParameter("AIPackageStorage", "tag");     // Catch: Exception -> L16
        d r20 = c.f2846a;     // Catch: Exception -> L16
        if (r20 == null) goto L28;
        r20.d("AIPackageStorage", r111);     // Catch: Exception -> L16
    L28:
        if (r12.e() != AIPackage.AIPackageType.f2280b) goto L32;
        AIPackageDao r112 = AIPackageDatabase.Companion.get().userDao();     // Catch: Exception -> L16
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.bytedance.ai.model.objects.Widget");     // Catch: Exception -> L16
        r5.f2619a = this;     // Catch: Exception -> L16
        r5.f2620b = r12;     // Catch: Exception -> L16
        r5.e = 1;     // Catch: Exception -> L16
        if (r112.deleteWidget((Widget) r12, r5) != r11) goto L35;
    L32:
        AIPackageDao r113 = AIPackageDatabase.Companion.get().userDao();     // Catch: Exception -> L16
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.bytedance.ai.model.objects.Applet");     // Catch: Exception -> L16
        r5.f2619a = this;     // Catch: Exception -> L16
        r5.f2620b = r12;     // Catch: Exception -> L16
        r5.e = 2;     // Catch: Exception -> L16
        if (r113.deleteApplet((Applet) r12, r5) != r11) goto L35;
    L16:
        e = move-exception;
        StringBuilder r114 = new StringBuilder("packageName: ");
        r114.append(r12.f2259b);
        r114.append(", appId: ");
        r114.append(r12.c());
        r114.append(" ===> cleanPackageToDelete error : ");
        String r115 = a.h(e, r114, "AIPackageStorage");
        d r116 = c.f2846a;
        if (r116 == null) goto L46;
        r116.e("AIPackageStorage", r115);
    L46:
        return CollectionsKt.emptyList();
    L7:
        r5 = new AIPackageStorage$cleanPackageToDelete$1(this, r13);
        goto L8
    }
}
