package com.larus.dora.obric.device_management.device_home;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.o.api.IDoraODiaryService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraObricDeviceHomeUsageRepository {

    public static final class a {
    }

    static {
    }

    public DoraObricDeviceHomeUsageRepository() {
    }

    public static Boolean a(String r9) {
        Intrinsics.checkNotNullParameter(r9, "userId");
        Object r1 = null;
        if (StringsKt.isBlank(r9) == false) goto L30;
        return null;
    L30:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L19
        String r10 = "dora_obric_device_home_diary_data_" + r9;     // Catch: Throwable -> L19
        com.larus.dora.impl.util.b0.a.getClass();     // Catch: Throwable -> L19
        long r5 = com.larus.dora.impl.util.b0.j().getLong(r10 + "_time", 0);     // Catch: Throwable -> L19
        long r7 = System.currentTimeMillis() - r5;     // Catch: Throwable -> L19
        if (r5 > 0) goto L8;
    L16:
        Boolean r11 = null;
    L17:
        Object r12 = Result.constructor-impl(r11);     // Catch: Throwable -> L19
    L21:
        Throwable r2 = Result.exceptionOrNull-impl(r12);
        if (r2 == null) goto L25;
        g49.d.e("DoraObricHomeUsageRepo", "read diary cache failed: " + r2.getMessage());
    L25:
        if (Result.isFailure-impl(r12) == true) goto L29;
        r1 = r12;
    L29:
        return (Boolean) r1;
    L8:
        if (0 <= r7) goto L10;
    L12:
        boolean r3 = false;
    L13:
        if (r3 == false) goto L16;
        r11 = Boolean.valueOf(com.larus.dora.impl.util.b0.j().getBoolean(r10, false));     // Catch: Throwable -> L19
        goto L17
    L10:
        if (r7 >= 300001) goto L12;
        r3 = true;
    L19:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    }

    public static s1 b(String r9, List r10) {
        Intrinsics.checkNotNullParameter(r9, "userId");
        Intrinsics.checkNotNullParameter(r10, "boundDevices");
        List r11 = r10;
        boolean r0 = r11 instanceof Collection;
        boolean r2 = false;
        if (r0 == true) goto L5;
    L7:
        Iterator r3 = r11.iterator();
    L9:
        if (r3.hasNext() == false) goto L13;
        if (t.a((DoraDevice) r3.next()) == false) goto L9;
        boolean r4 = true;
    L14:
        if (r0 == true) goto L16;
    L18:
        Iterator r12 = r11.iterator();
    L20:
        if (r12.hasNext() == false) goto L24;
        if (t.b((DoraDevice) r12.next()) == false) goto L20;
        boolean r13 = true;
    L26:
        if (StringsKt.isBlank(r9) == false) goto L58;
        boolean r1 = false;
    L39:
        if (r4 == true) goto L41;
        if (r1 == true) goto L41;
    L42:
        if (r4 == false) goto L54;
        if (r1 == true) goto L54;
        if (StringsKt.isBlank(r9) == true) goto L54;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L49
        com.larus.dora.impl.util.b0.a.getClass();     // Catch: Throwable -> L49
        com.larus.dora.impl.util.b0.j().storeBoolean("dora_obric_device_home_glasses_binding_history_" + r9, true);     // Catch: Throwable -> L49
        g49.d.d("DoraObricHomeUsageRepo", "glasses binding history updated");     // Catch: Throwable -> L49
        Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L49
    L51:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L54;
        g49.d.e("DoraObricHomeUsageRepo", "write glasses binding history failed: " + r15.getMessage());
    L49:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
    L54:
        g49.d.d("DoraObricHomeUsageRepo", "loadBoundDeviceEvidence hasBoundGlasses=" + r4 + " hasBoundEarbuds=" + r13 + " hasBoundGlassesHistory=" + r2);
        return new s1(r4, r13, r2, 8);
    L41:
        r2 = true;
        goto L42
    L58:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L30
        com.larus.dora.impl.util.b0.a.getClass();     // Catch: Throwable -> L30
        Object r8 = Result.constructor-impl(Boolean.valueOf(com.larus.dora.impl.util.b0.j().getBoolean("dora_obric_device_home_glasses_binding_history_" + r9, false)));     // Catch: Throwable -> L30
    L32:
        Throwable r16 = Result.exceptionOrNull-impl(r8);
        if (r16 == null) goto L35;
        g49.d.e("DoraObricHomeUsageRepo", "read glasses binding history failed: " + r16.getMessage());
    L35:
        Boolean r17 = Boolean.FALSE;
        if (Result.isFailure-impl(r8) == false) goto L38;
        r8 = r17;
    L38:
        r1 = ((Boolean) r8).booleanValue();
    L30:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
    L24:
        r13 = false;
        goto L26
    L16:
        if (r11.isEmpty() == false) goto L18;
    L13:
        r4 = false;
        goto L14
    L5:
        if (r11.isEmpty() == false) goto L7;
        goto L7
    }

    public final Object c(String r5, boolean r6, Continuation<? super Result<Boolean>> r7) {
        if ((r7 instanceof DoraObricDeviceHomeUsageRepository$queryGlassesDiaryData$1) == false) goto L7;
        DoraObricDeviceHomeUsageRepository$queryGlassesDiaryData$1 r0 = (DoraObricDeviceHomeUsageRepository$queryGlassesDiaryData$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
        return ((Result) r8).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        if (r6 == true) goto L20;
        Boolean r9 = a(r5);
        if (r9 == null) goto L20;
        boolean r10 = r9.booleanValue();
        g49.d.d("DoraObricHomeUsageRepo", "diary cache hit hasDiaryData=" + r10);
        Result.Companion r11 = Result.Companion;
        return Result.constructor-impl(Boxing.boxBoolean(r10));
    L20:
        IDoraODiaryService r12 = (IDoraODiaryService) ServiceManager.get().getService(IDoraODiaryService.class);
        if (r12 != null) goto L24;
        Result.Companion r13 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("Dora O diary service is unavailable")));
    L24:
        r0.label = 1;
        Object r14 = r12.c(r0);
        if (r14 != r2) goto L28;
        return r2;
    L28:
        return r14;
    L7:
        r0 = new DoraObricDeviceHomeUsageRepository$queryGlassesDiaryData$1(this, r7);
        goto L8
    }
}
