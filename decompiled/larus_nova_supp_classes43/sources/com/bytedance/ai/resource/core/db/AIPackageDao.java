package com.bytedance.ai.resource.core.db;

import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.resource.core.AIPackageDeployment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class AIPackageDao {
    public final String a;

    public abstract Object A(Continuation<? super List<Applet>> r1);

    public abstract Object B(String r1, Continuation<? super List<Applet>> r10);

    public abstract Object C(String r1, long r10, ContinuationImpl r11);

    public abstract Object D(Continuation<? super List<? extends Widget>> r1);

    public abstract Object E(String r1, Continuation<? super List<? extends Widget>> r10);

    public abstract Object I(String r1, String r10, String r11, long r12, Continuation<? super Widget> r13);

    public abstract Object J(String r1, String r10, String r11, ContinuationImpl r12);

    public abstract Object K(String r1, String r10, Continuation<? super List<? extends Widget>> r11);

    public abstract Object L(Continuation<? super List<? extends Widget>> r1);

    public abstract Object N(Applet[] r1, ContinuationImpl r10);

    public abstract Object O(Widget[] r1, ContinuationImpl r10);

    public abstract Object b(Applet r1, Continuation<? super Unit> r10);

    public abstract Object c(String r1, String r10, Continuation<? super Unit> r11);

    public abstract Object d(List r1, ContinuationImpl r10);

    public abstract Object e(Widget r1, Continuation<? super Unit> r10);

    public abstract Object f(String r1, String r10, Continuation<? super Unit> r11);

    public abstract Object g(List r1, ContinuationImpl r10);

    public abstract Object h(Applet r1, ContinuationImpl r10);

    public abstract Object l(Widget r1, ContinuationImpl r10);

    public abstract Object m(String r1, String r10, Continuation<? super Unit> r11);

    public abstract Object n(String r1, String r10, Continuation<? super Unit> r11);

    public abstract Object o(Continuation<? super List<Applet>> r1);

    public abstract Object p(Continuation<? super List<? extends Widget>> r1);

    public abstract Object q(Continuation r1);

    public abstract Object r(String r1, String r10, String r11, long r12, Continuation<? super Applet> r13);

    public abstract Object s(String r1, String r10, String r11, ContinuationImpl r12);

    public abstract Object t(String r1, String r10, Continuation<? super List<Applet>> r11);

    public abstract Object u(Continuation<? super List<Applet>> r1);

    public abstract Object v(String r1, Continuation<? super List<Applet>> r10);

    public abstract Object w(Continuation<? super List<Applet>> r1);

    public abstract Object x(String r1, Continuation<? super List<? extends Widget>> r10);

    public abstract Object y(Continuation<? super List<? extends Widget>> r1);

    public abstract Object z(String r1, long r10, ContinuationImpl r11);

    public AIPackageDao() {
        this.a = "AIPackageDao";
    }

    public Object i(Applet r1, Continuation<? super Unit> r10) {
        Object r11 = j(r1, r10);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Unit.INSTANCE;
    }

    public final Object j(AIPackage r12, Continuation<? super Unit> r13) {
        if ((r13 instanceof AIPackageDao$insertInactivePackage$1) == false) goto L7;
        Continuation<? super Unit> r0 = (AIPackageDao$insertInactivePackage$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean r11 = true;
        switch(r0.label) {
            case 0: goto L19;
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L16;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            default: goto L11;
        };
    L12:
        ResultKt.throwOnFailure(r14);
    L71:
        return Unit.INSTANCE;
    L13:
        ResultKt.throwOnFailure(r14);
    L66:
        return Unit.INSTANCE;
    L14:
        Iterator r15 = (Iterator) r0.L$2;
        AIPackage.AIPackageType r16 = (AIPackage.AIPackageType) r0.L$1;
        AIPackage r17 = (AIPackage) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L15:
        AIPackage.AIPackageType r18 = r16;
        AIPackage r19 = r17;
    L53:
        if (r15.hasNext() == false) goto L59;
        AIPackage r20 = (AIPackage) r15.next();
        if (Intrinsics.areEqual(r20.n, r19.n) == true) goto L53;
        long r21 = r20.c;
        String r22 = r20.a();
        String r23 = r20.b;
        String r24 = r20.n;
        r0.L$0 = r19;
        r0.L$1 = r18;
        r0.L$2 = r15;
        r0.label = 5;
        if (a(r21, r22, r23, r24, r0) != r10) goto L53;
        return r10;
    L59:
        AIPackage.AIPackageType r110 = r18;
        AIPackage r25 = r19;
    L61:
        if (r110 != AIPackage.AIPackageType.APPLET) goto L67;
        Intrinsics.checkNotNull(r25, "null cannot be cast to non-null type com.bytedance.ai.model.objects.Applet");
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 6;
        if (h((Applet) r25, r0) != r10) goto L66;
        return r10;
    L67:
        Intrinsics.checkNotNull(r25, "null cannot be cast to non-null type com.bytedance.ai.model.objects.Widget");
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 7;
        if (l((Widget) r25, r0) != r10) goto L71;
        return r10;
    L16:
        List r111 = (List) r0.L$2;
        r16 = (AIPackage.AIPackageType) r0.L$1;
        r17 = (AIPackage) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L51:
        r15 = r111.iterator();
        goto L15
    L17:
        r110 = (AIPackage.AIPackageType) r0.L$1;
        r25 = (AIPackage) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L34:
        List r112 = (List) r14;
    L35:
        List r26 = r112;
        if (r26 != null) goto L38;
    L41:
        if (r11 == true) goto L61;
        if (r110 != AIPackage.AIPackageType.APPLET) goto L47;
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type kotlin.collections.List<com.bytedance.ai.model.objects.Applet>");
        r0.L$0 = r25;
        r0.L$1 = r110;
        r0.L$2 = r112;
        r0.label = 3;
        if (d(r112, r0) != r10) goto L50;
        return r10;
    L50:
        r17 = r25;
        r16 = r110;
        r111 = r112;
        goto L51
    L47:
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type kotlin.collections.List<com.bytedance.ai.model.objects.Widget>");
        r0.L$0 = r25;
        r0.L$1 = r110;
        r0.L$2 = r112;
        r0.label = 4;
        if (g(r112, r0) != r10) goto L50;
        return r10;
    L38:
        if (r26.isEmpty() == true) goto L41;
        r11 = false;
        goto L41
    L18:
        r110 = (AIPackage.AIPackageType) r0.L$1;
        r25 = (AIPackage) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L29:
        r112 = (List) r14;
        goto L35
    L19:
        ResultKt.throwOnFailure(r14);
        if (Intrinsics.areEqual(r12.v, "inactive") == true) goto L23;
        com.bytedance.ai.utils.g.a.e(this.a, "insert inactive package failed! package status isn't inactive, unique id: " + r12.d());
        return Unit.INSTANCE;
    L23:
        AIPackage.AIPackageType r113 = r12.c();
        if (r113 != AIPackage.AIPackageType.APPLET) goto L30;
        String r27 = r12.a();
        String r28 = r12.b;
        r0.L$0 = r12;
        r0.L$1 = r113;
        r0.label = 1;
        Object r29 = s(r27, r28, "inactive", r0);
        if (r29 != r10) goto L28;
        return r10;
    L28:
        r25 = r12;
        r110 = r113;
        r14 = r29;
        goto L29
    L30:
        String r30 = r12.a();
        String r31 = r12.b;
        r0.L$0 = r12;
        r0.L$1 = r113;
        r0.label = 2;
        Object r32 = J(r30, r31, "inactive", r0);
        if (r32 != r10) goto L33;
        return r10;
    L33:
        r25 = r12;
        r110 = r113;
        r14 = r32;
        goto L34
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r0 = new AIPackageDao$insertInactivePackage$1(this, r13);
        goto L8
    }

    public Object k(Widget r1, Continuation<? super Unit> r10) {
        Object r11 = j(r1, r10);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Unit.INSTANCE;
    }

    public Object G(String r10, String r11, long r12, Continuation<? super Applet> r13) {
        Object r14 = F(r10, r11, AIPackage.AIPackageType.APPLET, r12, r13);
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r14;
    L6:
        return (Applet) r14;
    }

    public Object H(String r10, String r11, long r12, Continuation<? super Widget> r13) {
        Object r14 = F(r10, r11, AIPackage.AIPackageType.WIDGET, r12, r13);
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r14;
    L6:
        return (Widget) r14;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object F(String r17, String r18, AIPackage.AIPackageType r19, long r20, Continuation<? super AIPackage> r22) {
        AIPackage.AIPackageType r10 = r19;
        if ((r22 instanceof AIPackageDao$queryOrActiveAIPackage$1) == false) goto L7;
        Continuation<? super List<? extends Widget>> r11 = (AIPackageDao$queryOrActiveAIPackage$1) r22;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r11.label) {
            case 0: goto L16;
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        long r1 = r11.J$0;
        List r15 = (List) r11.L$3;
        AIPackage r16 = (AIPackage) r11.L$2;
        List r21 = (List) r11.L$1;
        AIPackage r23 = (AIPackage) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L149:
        long r110 = r1;
        List r24 = r21;
        AIPackage r111 = r23;
        AIPackage r25 = r16;
    L150:
        r25.m = r110;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.a), null, null, new AIPackageDao$queryOrActiveAIPackage$4(r111, r25, r24, this, null), 3, null);
        return r25;
    L13:
        long r26 = r11.J$1;
        long r27 = r11.J$0;
        r25 = (AIPackage) r11.L$3;
        r24 = (List) r11.L$2;
        r111 = (AIPackage) r11.L$1;
        AIPackage.AIPackageType r112 = (AIPackage.AIPackageType) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L124:
        r110 = r26;
    L129:
        r25.m = r27;
        ArrayList r28 = new ArrayList();
        Iterator r29 = r24.iterator();
    L131:
        if (r29.hasNext() == false) goto L139;
        Object r30 = r29.next();
        if (((AIPackage) r30).m == r110) goto L135;
        boolean r31 = true;
    L136:
        if (r31 == false) goto L131;
        r28.add(r30);
        goto L131
    L135:
        r31 = false;
        goto L136
    L139:
        if ((!r28.isEmpty()) == false) goto L150;
        if (r112 != AIPackage.AIPackageType.APPLET) goto L145;
        r11.L$0 = r111;
        r11.L$1 = r24;
        r11.L$2 = r25;
        r11.L$3 = r28;
        r11.J$0 = r110;
        r11.label = 5;
        if (d(r28, r11) != r14) goto L148;
        return r14;
    L148:
        r16 = r25;
        r21 = r24;
        r23 = r111;
        r1 = r110;
        goto L149
    L145:
        r11.L$0 = r111;
        r11.L$1 = r24;
        r11.L$2 = r25;
        r11.L$3 = r28;
        r11.J$0 = r110;
        r11.label = 6;
        if (g(r28, r11) != r14) goto L148;
        return r14;
    L14:
        long r32 = r11.J$0;
        r10 = (AIPackage.AIPackageType) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L31:
        List r33 = (List) r13;
    L26:
        r112 = r10;
        if (r32 != 0) goto L54;
        if (r33 == null) goto L72;
        Iterator r34 = r33.iterator();
    L37:
        if (r34.hasNext() == false) goto L52;
        Object r35 = r34.next();
        AIPackage r113 = (AIPackage) r35;
        if (Intrinsics.areEqual(r113.v, "installed") == false) goto L41;
    L42:
        Integer r114 = r113.w;
        if (r114 != null) goto L46;
    L48:
        boolean r115 = false;
    L49:
        if (r115 == false) goto L37;
    L53:
        AIPackage r36 = (AIPackage) r35;
    L71:
        r111 = r36;
    L74:
        if (r32 != 0) goto L90;
        if (r33 == null) goto L103;
        ArrayList r37 = new ArrayList();
        Iterator r38 = r33.iterator();
    L78:
        if (r38.hasNext() == false) goto L104;
        Object r39 = r38.next();
        AIPackage r40 = (AIPackage) r39;
        if (Intrinsics.areEqual(r40.v, "inactive") == false) goto L87;
        Integer r41 = r40.w;
        if (r41 == null) goto L87;
        if (r41.intValue() != 0) goto L87;
        boolean r42 = true;
    L88:
        if (r42 == false) goto L78;
        r37.add(r39);
    L87:
        r42 = false;
    L104:
        if (r37 != null) goto L106;
    L109:
        boolean r43 = true;
    L110:
        if (r43 == true) goto L152;
        r25 = (AIPackage) CollectionsKt.first(r37);
        r27 = r25.m;
        if (r111 == null) goto L114;
        long r116 = r111.m;
    L115:
        com.bytedance.ai.utils.g r44 = com.bytedance.ai.utils.g.a;
        String r45 = this.a;
        StringBuilder r117 = new StringBuilder("find inactive package: ");
        r117.append(r25.b);
        r117.append(", appId: ");
        r117.append(r25.a());
        r117.append(", version code: ");
        long r118 = r116;
        r117.append(r25.c);
        r117.append(" ===> update as installed package");
        r44.d(r45, r117.toString());
        if (r111 == null) goto L118;
        r25.m = r111.m;
    L118:
        Intrinsics.checkNotNullParameter("installed", "<set-?>");
        r25.v = "installed";
        if (r112 != AIPackage.AIPackageType.APPLET) goto L125;
        Intrinsics.checkNotNull(r25, "null cannot be cast to non-null type com.bytedance.ai.model.objects.Applet");
        Applet[] r46 = {r25};
        r11.L$0 = r112;
        r11.L$1 = r111;
        r11.L$2 = r37;
        r11.L$3 = r25;
        r11.J$0 = r27;
        r11.J$1 = r118;
        r11.label = 3;
        if (N(r46, r11) != r14) goto L123;
        return r14;
    L123:
        r24 = r37;
        r26 = r118;
        goto L124
    L125:
        r110 = r118;
        Intrinsics.checkNotNull(r25, "null cannot be cast to non-null type com.bytedance.ai.model.objects.Widget");
        Widget[] r47 = {r25};
        r11.L$0 = r112;
        r11.L$1 = r111;
        r11.L$2 = r37;
        r11.L$3 = r25;
        r11.J$0 = r27;
        r11.J$1 = r110;
        r11.label = 4;
        if (O(r47, r11) != r14) goto L128;
        return r14;
    L128:
        r24 = r37;
        goto L129
    L114:
        r116 = r27;
        goto L115
    L152:
        return r111;
    L106:
        if (r37.isEmpty() == true) goto L109;
        r43 = false;
    L103:
        r37 = null;
        goto L104
    L90:
        if (r33 == null) goto L103;
        ArrayList r48 = new ArrayList();
        Iterator r49 = r33.iterator();
    L93:
        if (r49.hasNext() == false) goto L102;
        Object r50 = r49.next();
        AIPackage r119 = (AIPackage) r50;
        if (Intrinsics.areEqual(r119.v, "inactive") == true) goto L97;
    L99:
        boolean r120 = false;
    L100:
        if (r120 == false) goto L93;
        r48.add(r50);
        goto L93
    L97:
        if (r119.c != r32) goto L99;
        r120 = true;
        goto L100
    L102:
        r37 = r48;
        goto L104
    L46:
        if (r114.intValue() != 0) goto L48;
        r115 = true;
        goto L49
    L41:
        if (Intrinsics.areEqual(r113.v, "") == false) goto L48;
    L52:
        r35 = null;
    L72:
        r111 = null;
        goto L74
    L54:
        if (r33 == null) goto L72;
        Iterator r51 = r33.iterator();
    L57:
        if (r51.hasNext() == false) goto L69;
        Object r52 = r51.next();
        AIPackage r121 = (AIPackage) r52;
        if (Intrinsics.areEqual(r121.v, "installed") == true) goto L63;
        if (Intrinsics.areEqual(r121.v, "") == true) goto L63;
    L65:
        boolean r122 = false;
    L66:
        if (r122 == false) goto L57;
    L70:
        r36 = (AIPackage) r52;
    L63:
        if (r121.c != r32) goto L65;
        r122 = true;
        goto L66
    L69:
        r52 = null;
        goto L70
    L15:
        r32 = r11.J$0;
        r10 = (AIPackage.AIPackageType) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L25:
        r33 = (List) r13;
        goto L26
    L16:
        ResultKt.throwOnFailure(r13);
        if (r10 != AIPackage.AIPackageType.UNKNOWN) goto L20;
        return null;
    L20:
        if (r10 != AIPackage.AIPackageType.APPLET) goto L27;
        r11.L$0 = r10;
        r11.J$0 = r20;
        r11.label = 1;
        r13 = t(r17, r18, r11);
        if (r13 != r14) goto L24;
        return r14;
    L24:
        r32 = r20;
        goto L25
    L27:
        r11.L$0 = r10;
        r11.J$0 = r20;
        r11.label = 2;
        r13 = K(r17, r18, r11);
        if (r13 != r14) goto L30;
        return r14;
    L30:
        r32 = r20;
        goto L31
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r11 = new AIPackageDao$queryOrActiveAIPackage$1(this, r22);
        goto L8
    }

    public final Object M(long r30, String r32, String r33, String r34, Continuation<? super List<String>> r35) {
        AIPackageDao r0 = this;
        long r14 = r30;
        if ((r35 instanceof AIPackageDao$renameOutdatedFile$1) == false) goto L7;
        AIPackageDao$renameOutdatedFile$1 r10 = (AIPackageDao$renameOutdatedFile$1) r35;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        AIPackageDao$renameOutdatedFile$1 r12 = r10;
        Object r1 = r12.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r12.label;
        boolean r16 = false;
        String r17 = ": ";
        if (r15 == 0) goto L16;
        if (r15 == 1) goto L15;
        if (r15 != 2) goto L14;
        long r18 = r12.J$0;
        List r19 = (List) r12.L$3;
        AIPackageDeployment.AIPackageDeploymentItem r20 = (AIPackageDeployment.AIPackageDeploymentItem) r12.L$2;
        String r21 = (String) r12.L$1;
        String r110 = (String) r12.L$0;
        ResultKt.throwOnFailure(r1);
        String r22 = r21;
        AIPackageDeployment.AIPackageDeploymentItem r23 = r20;
    L34:
        List r24 = (List) r1;
        Object r111 = null;
        if (r24 == null) goto L43;
        Iterator r112 = r24.iterator();
    L38:
        if (r112.hasNext() == false) goto L42;
        Object r113 = r112.next();
        if (Intrinsics.areEqual(((Widget) r113).K, r110) == false) goto L38;
        r111 = r113;
    L42:
        r111 = (Widget) r111;
    L43:
        if (r111 == null) goto L46;
        com.bytedance.ai.utils.g.a.w(r0.a, r22 + r17 + r110 + r17 + r18 + ": the same version is installed again. skip removing files");
        return r19;
    L46:
        List r25 = r24;
        if (r25 != null) goto L49;
    L50:
        r16 = true;
    L52:
        if (r16 == false) goto L59;
        String r26 = com.bytedance.ai.resource.core.a.b(r23);
        Intrinsics.checkNotNullParameter(r23, "deploymentInfo");
        String r27 = com.bytedance.ai.resource.core.a.a + '/' + r23.getPackageName() + "/base_" + r23.getVersionCode() + "_delete.zip";
        if (com.bytedance.ai.utils.f.i(r26, r27) == false) goto L56;
        com.bytedance.ai.utils.g.a.d(r0.a, "add " + r27 + " into the delete list");
        r19.add(r27);
    L56:
        String r28 = com.bytedance.ai.resource.core.a.a(r23);
        Intrinsics.checkNotNullParameter(r23, "deploymentInfo");
        String r29 = com.bytedance.ai.resource.core.a.a + '/' + r23.getPackageName() + "/base_" + r23.getVersionCode() + "_delete";
        if (com.bytedance.ai.utils.f.i(r28, r29) == false) goto L59;
        com.bytedance.ai.utils.g.a.d(r0.a, "add " + r29 + " into the delete list");
        r19.add(r29);
    L59:
        String r31 = com.bytedance.ai.resource.core.a.f(r23);
        Intrinsics.checkNotNullParameter(r23, "deploymentInfo");
        String r36 = com.bytedance.ai.resource.core.a.f(r23) + "_delete";
        if (com.bytedance.ai.utils.f.i(r31, r36) == false) goto L62;
        com.bytedance.ai.utils.g.a.d(r0.a, "add " + r36 + " into the delete list");
        r19.add(r36);
    L62:
        String r37 = com.bytedance.ai.resource.core.a.e(r23);
        Intrinsics.checkNotNullParameter(r23, "deploymentInfo");
        String r38 = com.bytedance.ai.resource.core.a.e(r23) + "_delete";
        if (com.bytedance.ai.utils.f.i(r37, r38) == false) goto L65;
        com.bytedance.ai.utils.g.a.d(r0.a, "add " + r38 + " into the delete list");
        r19.add(r38);
    L65:
        return r19;
    L49:
        if (r25.isEmpty() == false) goto L52;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r39 = r12.J$0;
        r19 = (List) r12.L$3;
        AIPackageDeployment.AIPackageDeploymentItem r40 = (AIPackageDeployment.AIPackageDeploymentItem) r12.L$2;
        String r41 = (String) r12.L$1;
        String r114 = (String) r12.L$0;
        ResultKt.throwOnFailure(r1);
        r14 = r39;
        AIPackageDeployment.AIPackageDeploymentItem r42 = r40;
        Object r43 = r13;
        AIPackageDao$renameOutdatedFile$1 r44 = r12;
    L20:
        List r45 = (List) r1;
        if (r45 != null) goto L23;
    L26:
        boolean r46 = true;
    L27:
        if (r46 == true) goto L30;
        com.bytedance.ai.utils.g.a.w(r0.a, r41 + ": " + r114 + ": " + r14 + ": the same version is installed again. skip removing files");
        return r19;
    L30:
        r17 = r17;
        r44.L$0 = r114;
        r44.L$1 = r41;
        r44.L$2 = r42;
        r44.L$3 = r19;
        r44.J$0 = r14;
        r44.label = 2;
        r1 = r0.C(r41, r14, r44);
        if (r1 != r43) goto L33;
        return r43;
    L33:
        r22 = r41;
        r110 = r114;
        r23 = r42;
        r18 = r14;
        goto L34
    L23:
        if (r45.isEmpty() == true) goto L26;
        r46 = false;
        goto L27
    L16:
        ResultKt.throwOnFailure(r1);
        AIPackageDeployment.AIPackageDeploymentItem r47 = new AIPackageDeployment.AIPackageDeploymentItem(r32, r33, r30, null, r34, null, false, null, null, 488, null);
        ArrayList r48 = new ArrayList();
        r44 = r12;
        r44.L$0 = r32;
        r44.L$1 = r33;
        r44.L$2 = r47;
        r44.L$3 = r48;
        r44.J$0 = r14;
        r44.label = 1;
        r41 = r33;
        r0 = this;
        Object r49 = r0.z(r41, r14, r44);
        r43 = r13;
        if (r49 != r43) goto L19;
        return r43;
    L19:
        r114 = r32;
        r42 = r47;
        r19 = r48;
        r1 = r49;
    L7:
        r10 = new AIPackageDao$renameOutdatedFile$1(r0, r35);
        goto L8
    }

    public final Object a(long r32, String r34, String r35, String r36, Continuation<? super Unit> r37) {
        AIPackageDao r0 = this;
        long r14 = r32;
        if ((r37 instanceof AIPackageDao$cleanOutdatedFile$1) == false) goto L7;
        AIPackageDao$cleanOutdatedFile$1 r10 = (AIPackageDao$cleanOutdatedFile$1) r37;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        AIPackageDao$cleanOutdatedFile$1 r12 = r10;
        Object r1 = r12.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r12.label;
        boolean r16 = false;
        String r17 = ", digest: ";
        String r18 = ", version code: ";
        String r19 = ", packageName: ";
        String r20 = ", appId: ";
        if (r15 == 0) goto L16;
        if (r15 == 1) goto L15;
        if (r15 != 2) goto L14;
        long r21 = r12.J$0;
        AIPackageDeployment.AIPackageDeploymentItem r22 = (AIPackageDeployment.AIPackageDeploymentItem) r12.L$3;
        String r110 = (String) r12.L$2;
        String r111 = (String) r12.L$1;
        String r112 = (String) r12.L$0;
        ResultKt.throwOnFailure(r1);
        r20 = ", appId: ";
        AIPackageDeployment.AIPackageDeploymentItem r23 = r22;
        r19 = ", packageName: ";
        r18 = ", version code: ";
        r17 = ", digest: ";
    L32:
        Collection r24 = (Collection) r1;
        if (r24 != null) goto L35;
    L36:
        r16 = true;
    L37:
        if (r16 == false) goto L39;
        boolean r25 = com.bytedance.ai.utils.f.d(com.bytedance.ai.resource.core.a.b(r23));
        com.bytedance.ai.utils.g r26 = com.bytedance.ai.utils.g.a;
        String r27 = r0.a;
        StringBuilder r28 = new StringBuilder("cleaning base zip. result: ");
        r28.append(r25);
        String r29 = r20;
        r28.append(r29);
        r28.append(r112);
        String r30 = r19;
        r28.append(r30);
        r28.append(r111);
        String r31 = r18;
        r28.append(r31);
        r28.append(r21);
        String r113 = r17;
        r28.append(r113);
        r28.append(r110);
        r26.d(r27, r28.toString());
        boolean r33 = com.bytedance.ai.utils.f.c(com.bytedance.ai.resource.core.a.a(r23));
        r26.d(r0.a, "cleaning base dir. result: " + r33 + r29 + r112 + r30 + r111 + r31 + r21 + r113 + r110);
    L40:
        r14 = r21;
        String r38 = r111;
        String r39 = r113;
        String r40 = r31;
        String r114 = r110;
        String r41 = r112;
    L42:
        boolean r42 = com.bytedance.ai.utils.f.d(com.bytedance.ai.resource.core.a.f(r23));
        com.bytedance.ai.utils.g r43 = com.bytedance.ai.utils.g.a;
        r43.d(r0.a, "cleaning package zip, result: " + r42 + r29 + r41 + r30 + r38 + r40 + r14 + r39 + r114);
        boolean r44 = com.bytedance.ai.utils.f.c(com.bytedance.ai.resource.core.a.e(r23));
        r43.d(r0.a, "cleaning package dir, result: " + r44 + r29 + r41 + r30 + r38 + r40 + r14 + r39 + r114);
        return Unit.INSTANCE;
    L39:
        r29 = r20;
        r30 = r19;
        r31 = r18;
        r113 = r17;
        goto L40
    L35:
        if (r24.isEmpty() == false) goto L37;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r45 = r12.J$0;
        AIPackageDeployment.AIPackageDeploymentItem r46 = (AIPackageDeployment.AIPackageDeploymentItem) r12.L$3;
        r114 = (String) r12.L$2;
        String r115 = (String) r12.L$1;
        String r116 = (String) r12.L$0;
        ResultKt.throwOnFailure(r1);
        r23 = r46;
        Object r47 = r13;
        r38 = r115;
        Object r48 = r1;
        r41 = r116;
        r14 = r45;
        AIPackageDao$cleanOutdatedFile$1 r49 = r12;
    L20:
        Collection r50 = (Collection) r48;
        if (r50 != null) goto L23;
    L26:
        boolean r51 = true;
    L27:
        if (r51 == false) goto L41;
        r49.L$0 = r41;
        r49.L$1 = r38;
        r49.L$2 = r114;
        r49.L$3 = r23;
        r49.J$0 = r14;
        r49.label = 2;
        Object r52 = r0.C(r38, r14, r49);
        if (r52 != r47) goto L31;
        return r47;
    L31:
        r112 = r41;
        r1 = r52;
        r111 = r38;
        r110 = r114;
        r21 = r14;
        goto L32
    L41:
        r29 = r20;
        r30 = r19;
        r40 = r18;
        r39 = r17;
        goto L42
    L23:
        if (r50.isEmpty() == true) goto L26;
        r51 = false;
        goto L27
    L16:
        ResultKt.throwOnFailure(r1);
        AIPackageDeployment.AIPackageDeploymentItem r53 = new AIPackageDeployment.AIPackageDeploymentItem(r34, r35, r32, null, r36, null, false, null, null, 488, null);
        r41 = r34;
        r49 = r12;
        r49.L$0 = r41;
        r49.L$1 = r35;
        r49.L$2 = r36;
        r23 = r53;
        r49.L$3 = r23;
        r49.J$0 = r14;
        r49.label = 1;
        r38 = r35;
        r0 = this;
        r48 = r0.z(r38, r14, r49);
        r47 = r13;
        if (r48 != r47) goto L19;
        return r47;
    L19:
        r114 = r36;
    L7:
        r10 = new AIPackageDao$cleanOutdatedFile$1(r0, r37);
        goto L8
    }
}
