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
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AIPackageUpdateManager {
    public static final AIPackageUpdateManager a = null;
    public static CoroutineScope b;
    public static final Lazy c = null;

    public AIPackageUpdateManager() {
    }

    static {
        a = new AIPackageUpdateManager();
        c = LazyKt.lazy(new i());
    }

    public final Object a(Continuation<? super Unit> r15) {
        if ((r15 instanceof AIPackageUpdateManager$checkUpdateAllAIPackages$1) == false) goto L7;
        AIPackageUpdateManager$checkUpdateAllAIPackages$1 r0 = (AIPackageUpdateManager$checkUpdateAllAIPackages$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = r0.label;
        if (r11 == 0) goto L25;
        if (r11 == 1) goto L23;
        if (r11 == 2) goto L21;
        if (r11 == 3) goto L18;
        if (r11 != 4) goto L17;
        ResultKt.throwOnFailure(r16);     // Catch: Exception -> L70
    L73:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        List r12 = (List) r0.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Exception -> L70
    L37:
        ArrayList r13 = new ArrayList();     // Catch: Exception -> L70
        Iterator r17 = ((List) r16).iterator();     // Catch: Exception -> L70
    L39:
        if (r17.hasNext() == false) goto L58;
        AIPackage r14 = (AIPackage) r17.next();     // Catch: Exception -> L70
        Iterator r18 = r12.iterator();     // Catch: Exception -> L70
    L42:
        if (r18.hasNext() == false) goto L51;
        Object r19 = r18.next();     // Catch: Exception -> L70
        AIPackage r110 = (AIPackage) r19;     // Catch: Exception -> L70
        if (Intrinsics.areEqual(r110.a(), r14.a()) == true) goto L46;
    L48:
        boolean r111 = false;
    L49:
        if (r111 == false) goto L42;
    L52:
        AIPackage r112 = (AIPackage) r19;     // Catch: Exception -> L70
        if (r112 == null) goto L55;
        r12.remove(r112);     // Catch: Exception -> L70
        AppRequestItem r20 = new AppRequestItem(r112.a(), r112.b, String.valueOf(r112.c));     // Catch: Exception -> L70
    L56:
        n5.a.C0181a r21 = n5.a.a;     // Catch: Exception -> L70
        r20.getPackageName();     // Catch: Exception -> L70
        r21.getClass();     // Catch: Exception -> L70
        r13.add(r20);     // Catch: Exception -> L70
        goto L39
    L55:
        r20 = new AppRequestItem(r14.a(), r14.b, String.valueOf(r14.c));     // Catch: Exception -> L70
        goto L56
    L46:
        if (Intrinsics.areEqual(r110.b, r14.b) == false) goto L48;
        r111 = true;
        goto L49
    L51:
        r19 = null;
        goto L52
    L58:
        if (r12.isEmpty() == true) goto L63;
        Iterator r113 = r12.iterator();     // Catch: Exception -> L70
    L61:
        if (r113.hasNext() == false) goto L63;
        AIPackage r22 = (AIPackage) r113.next();     // Catch: Exception -> L70
        n5.a.C0181a r23 = n5.a.a;     // Catch: Exception -> L70
        r22.getClass();     // Catch: Exception -> L70
        r23.getClass();     // Catch: Exception -> L70
        r13.add(new AppRequestItem(r22.a(), r22.b, String.valueOf(r22.c)));     // Catch: Exception -> L70
    L63:
        com.bytedance.ai.utils.g r114 = com.bytedance.ai.utils.g.a;     // Catch: Exception -> L70
        r114.i("AIPackageUpdateManager", "Start requesting the server to get the update list");     // Catch: Exception -> L70
        r114.d("AIPackageUpdateManager", "the installed list is : " + r13);     // Catch: Exception -> L70
        if (r13.isEmpty() == true) goto L66;
        AIPackageManager r115 = AIPackageManager.a;     // Catch: Exception -> L70
        r115.getClass();     // Catch: Exception -> L70
        AIPackageAppList r24 = AIPackageManager.g(r13);     // Catch: Exception -> L70
        r0.L$0 = null;     // Catch: Exception -> L70
        r0.label = 4;     // Catch: Exception -> L70
        if (r115.m(r24, null, r0) != r10) goto L73;
        return r10;
    L66:
        return Unit.INSTANCE;
    L21:
        List r25 = (List) r0.L$1;
        List r26 = (List) r0.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Exception -> L70
    L33:
        r25.addAll((Collection) r16);     // Catch: Exception -> L70
        AIPackageStorage r116 = AIPackageStorage.a;     // Catch: Exception -> L70
        r0.L$0 = r26;     // Catch: Exception -> L70
        r0.L$1 = null;     // Catch: Exception -> L70
        r0.label = 3;     // Catch: Exception -> L70
        r16 = r116.o(AIPackage.AIPackageType.UNKNOWN, r0);     // Catch: Exception -> L70
        if (r16 != r10) goto L36;
        return r10;
    L36:
        r12 = r26;
        goto L37
    L23:
        ResultKt.throwOnFailure(r16);     // Catch: Exception -> L70
    L29:
        r25 = new ArrayList();     // Catch: Exception -> L70
        AIPackageStorage r117 = AIPackageStorage.a;     // Catch: Exception -> L70
        r0.L$0 = r25;     // Catch: Exception -> L70
        r0.L$1 = r25;     // Catch: Exception -> L70
        r0.label = 2;     // Catch: Exception -> L70
        r16 = r117.i(r0);     // Catch: Exception -> L70
        if (r16 != r10) goto L32;
        return r10;
    L32:
        r26 = r25;
        goto L33
    L25:
        ResultKt.throwOnFailure(r16);
        com.bytedance.ai.debug.f.a.getClass();     // Catch: Exception -> L70
        AIManager r118 = AIManager.a;     // Catch: Exception -> L70
        r0.label = 1;     // Catch: Exception -> L70
        if (r118.i(r0) != r10) goto L29;
        return r10;
    L70:
        e = move-exception;
        com.bytedance.ai.utils.g r27 = com.bytedance.ai.utils.g.a;
        StringBuilder r28 = new StringBuilder("Check update exception : ");
        e.printStackTrace();
        r28.append(Unit.INSTANCE);
        r27.e("AIPackageUpdateManager", r28.toString());
    L7:
        r0 = new AIPackageUpdateManager$checkUpdateAllAIPackages$1(this, r15);
        goto L8
    }
}
