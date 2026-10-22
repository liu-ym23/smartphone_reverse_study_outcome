package com.bytedance.ai.resource;

import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.core.AIPackageStorage;
import com.bytedance.ai.resource.core.bean.AIPackageAppList;
import com.bytedance.ai.resource.core.bean.AppRequestItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f2755a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f2756b = null;

    static {
        f2755a = new s();
        f2756b = LazyKt.lazy(new a3.f(12));
    }

    public final Object a(ContinuationImpl r17) {
        if ((r17 instanceof AIPackageUpdateManager$checkUpdateAllAIPackages$1) == false) goto L7;
        AIPackageUpdateManager$checkUpdateAllAIPackages$1 r5 = (AIPackageUpdateManager$checkUpdateAllAIPackages$1) r17;
        int r10 = r5.e;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r5.e = r10 - Integer.MIN_VALUE;
    L8:
        Object r11 = r5.f2537c;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r5.e;
        if (r13 == 0) goto L27;
        if (r13 == 1) goto L25;
        if (r13 == 2) goto L23;
        if (r13 == 3) goto L20;
        if (r13 != 4) goto L19;
        ResultKt.throwOnFailure(r11);     // Catch: Exception -> L16
    L109:
        return Unit.INSTANCE;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        List r14 = r5.f2535a;
        ResultKt.throwOnFailure(r11);     // Catch: Exception -> L16
    L39:
        ArrayList r15 = new ArrayList();     // Catch: Exception -> L16
        Iterator r16 = ((List) r11).iterator();     // Catch: Exception -> L16
    L41:
        if (r16.hasNext() == false) goto L72;
        AIPackage r18 = (AIPackage) r16.next();     // Catch: Exception -> L16
        Iterator r19 = r14.iterator();     // Catch: Exception -> L16
    L44:
        if (r19.hasNext() == false) goto L50;
        Object r110 = r19.next();     // Catch: Exception -> L16
        AIPackage r111 = (AIPackage) r110;     // Catch: Exception -> L16
        if (Intrinsics.areEqual(r111.c(), r18.c()) == false) goto L44;
        if (Intrinsics.areEqual(r111.f2259b, r18.f2259b) == false) goto L44;
    L51:
        AIPackage r112 = (AIPackage) r110;     // Catch: Exception -> L16
        if (r112 == null) goto L54;
        r14.remove(r112);     // Catch: Exception -> L16
        AppRequestItem r20 = new AppRequestItem(r112.c(), r112.f2259b, String.valueOf(r112.f2260c));     // Catch: Exception -> L16
    L55:
        String r113 = r20.getPackageName();     // Catch: Exception -> L16
        com.bytedance.ai.multiprocess.a r114 = com.bytedance.ai.multiprocess.d.f2406a;     // Catch: Exception -> L16
        if (r114 != null) goto L58;
    L68:
        boolean r115 = false;
    L69:
        if (r115 == true) goto L41;
        r15.add(r20);     // Catch: Exception -> L16
        goto L41
    L58:
        if (r114.f2402c == false) goto L60;
        boolean r116 = true;
    L66:
        if (r116 != true) goto L68;
        r115 = true;
        goto L69
    L60:
        if (r113 != null) goto L62;
    L65:
        r116 = false;
        goto L66
    L62:
        if (r113.length() == 0) goto L65;
        r116 = r114.d.contains(r113);     // Catch: Exception -> L16
        goto L66
    L54:
        r20 = new AppRequestItem(r18.c(), r18.f2259b, String.valueOf(r18.f2260c));     // Catch: Exception -> L16
        goto L55
    L50:
        r110 = null;
        goto L51
    L72:
        if (r14.isEmpty() == true) goto L92;
        Iterator r21 = r14.iterator();     // Catch: Exception -> L16
    L75:
        if (r21.hasNext() == false) goto L92;
        AIPackage r22 = (AIPackage) r21.next();     // Catch: Exception -> L16
        String r23 = r22.f2259b;     // Catch: Exception -> L16
        com.bytedance.ai.multiprocess.a r117 = com.bytedance.ai.multiprocess.d.f2406a;     // Catch: Exception -> L16
        if (r117 != null) goto L79;
    L89:
        boolean r24 = false;
    L90:
        if (r24 == true) goto L75;
        r15.add(new AppRequestItem(r22.c(), r22.f2259b, String.valueOf(r22.f2260c)));     // Catch: Exception -> L16
        goto L75
    L79:
        if (r117.f2402c == false) goto L81;
        boolean r25 = true;
    L87:
        if (r25 != true) goto L89;
        r24 = true;
        goto L90
    L81:
        if (r23 != null) goto L83;
    L86:
        r25 = false;
        goto L87
    L83:
        if (r23.length() == 0) goto L86;
        r25 = r117.d.contains(r23);     // Catch: Exception -> L16
    L92:
        Intrinsics.checkNotNullParameter("AIPackageUpdateManager", "tag");     // Catch: Exception -> L16
        t0.d r26 = com.bytedance.ai.utils.c.f2846a;     // Catch: Exception -> L16
        if (r26 == null) goto L95;
        r26.i("AIPackageUpdateManager", "Start requesting the server to get the update list");     // Catch: Exception -> L16
    L95:
        String r27 = "the installed list is : " + r15;     // Catch: Exception -> L16
        Intrinsics.checkNotNullParameter("AIPackageUpdateManager", "tag");     // Catch: Exception -> L16
        t0.d r28 = com.bytedance.ai.utils.c.f2846a;     // Catch: Exception -> L16
        if (r28 == null) goto L99;
        r28.d("AIPackageUpdateManager", r27);     // Catch: Exception -> L16
    L99:
        if (r15.isEmpty() == true) goto L101;
        r r29 = r.f2752a;     // Catch: Exception -> L16
        AIPackageAppList r30 = r.a(r15);     // Catch: Exception -> L16
        r5.f2535a = null;     // Catch: Exception -> L16
        r5.e = 4;     // Catch: Exception -> L16
        if (r29.e(r30, null, r5) != r12) goto L109;
    L104:
        return r12;
    L101:
        return Unit.INSTANCE;
    L23:
        ArrayList r31 = r5.f2536b;
        List r32 = r5.f2535a;
        ResultKt.throwOnFailure(r11);     // Catch: Exception -> L16
    L35:
        r31.addAll((Collection) r11);     // Catch: Exception -> L16
        AIPackageStorage r33 = AIPackageStorage.f2618a;     // Catch: Exception -> L16
        r5.f2535a = r32;     // Catch: Exception -> L16
        r5.f2536b = null;     // Catch: Exception -> L16
        r5.e = 3;     // Catch: Exception -> L16
        r11 = r33.a(AIPackage.AIPackageType.f2281c, r5);     // Catch: Exception -> L16
        if (r11 == r12) goto L104;
        r14 = r32;
        goto L39
    L25:
        ResultKt.throwOnFailure(r11);     // Catch: Exception -> L16
    L31:
        r31 = new ArrayList();     // Catch: Exception -> L16
        AIPackageStorage r34 = AIPackageStorage.f2618a;     // Catch: Exception -> L16
        r5.f2535a = r31;     // Catch: Exception -> L16
        r5.f2536b = r31;     // Catch: Exception -> L16
        r5.e = 2;     // Catch: Exception -> L16
        r11 = r34.a(r5);     // Catch: Exception -> L16
        if (r11 == r12) goto L104;
        r32 = r31;
        goto L35
    L27:
        ResultKt.throwOnFailure(r11);
        j r35 = j.f2734a;     // Catch: Exception -> L16
        r5.e = 1;     // Catch: Exception -> L16
        if (r35.h(r5) != r12) goto L31;
    L16:
        e = move-exception;
        StringBuilder r36 = new StringBuilder("Check update exception : ");
        e.printStackTrace();
        r36.append(Unit.INSTANCE);
        String r37 = r36.toString();
        Intrinsics.checkNotNullParameter("AIPackageUpdateManager", "tag");
        t0.d r38 = com.bytedance.ai.utils.c.f2846a;
        if (r38 == null) goto L109;
        r38.e("AIPackageUpdateManager", r37);
    L7:
        r5 = new AIPackageUpdateManager$checkUpdateAllAIPackages$1(this, r17);
        goto L8
    }
}
