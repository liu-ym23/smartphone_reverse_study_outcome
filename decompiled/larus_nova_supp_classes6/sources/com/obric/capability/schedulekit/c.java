package com.obric.capability.schedulekit;

import com.obric.capabilitykit.common.intent.AppIntentImplInfo;
import com.obric.sva.sdk.session.IWakeupSessionConstant;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class c {
    public static final c a = null;
    public static final ConcurrentHashMap<String, Integer> b = null;

    public c() {
    }

    static {
        a = new c();
        b = new ConcurrentHashMap();
    }

    public static int b(String r2) {
        if (r2 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return 0;
    L11:
        Integer r3 = b.get(r2);
        if (r3 != null) goto L14;
        uia.a.a.getClass();
        throw new IllegalStateException("app module must call Apphost.setApphost()");
    L14:
        return r3.intValue();
    L5:
        if (r2.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final Object a(Continuation r5) {
        if ((r5 instanceof IntentSdkVersionResolver.getSdkVersionByIntent.1) == false) goto L7;
        IntentSdkVersionResolver.getSdkVersionByIntent.1 r0 = (IntentSdkVersionResolver.getSdkVersionByIntent.1) r5;
        int r1 = r0.label;
        if ((r1 & IWakeupSessionConstant.RC_ERROR) == 0) goto L7;
        r0.label = r1 - IWakeupSessionConstant.RC_ERROR;
    L8:
        Object r6 = r0.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        boolean r3 = true;
        if (r2 == 0) goto L33;
        if (r2 != 1) goto L32;
        String r4 = (String) r0.L$0;
        ResultKt.throwOnFailure(r6);
        List r7 = (List) r6;
        List r8 = r7;
        if (r8 != null) goto L14;
    L17:
        if (r3 == false) goto L20;
        via.b r9 = via.b.a;
        Intrinsics.checkNotNullParameter("IntentSdkVersionResolver", "tag");
        int r10 = via.a.a;
        Intrinsics.checkNotNullParameter("ac_".concat("IntentSdkVersionResolver"), "tag");
        return Boxing.boxInt(0);
    L20:
        Iterator r11 = r7.iterator();
        if (r11.hasNext() == false) goto L30;
        Integer r12 = Boxing.boxInt(b(((AppIntentImplInfo) r11.next()).getPackageName()));
    L24:
        if (r11.hasNext() == false) goto L28;
        Integer r13 = Boxing.boxInt(b(((AppIntentImplInfo) r11.next()).getPackageName()));
        if (r12.compareTo(r13) >= 0) goto L24;
        r12 = r13;
        goto L24
    L28:
        return r12;
    L30:
        throw new NoSuchElementException();
    L14:
        if (r8.isEmpty() == true) goto L17;
        r3 = false;
        goto L17
    L32:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L33:
        ResultKt.throwOnFailure(r6);
        CoroutineScope r14 = b.a;
        final String r15 = null;
        r0.L$0 = null;
        r0.label = 1;
        final j r16 = new j(IntrinsicsKt.intercepted(r0), 1);
        r16.C();
        new CapabilityScheduleSdk$queryAppIntents$2$1(r15, r16);
        b.a();
        throw null;
    L7:
        r0 = new IntentSdkVersionResolver.getSdkVersionByIntent.1(this, r5);
        goto L8
    }
}
