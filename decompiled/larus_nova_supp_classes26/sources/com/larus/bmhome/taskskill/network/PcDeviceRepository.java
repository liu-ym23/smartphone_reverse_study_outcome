package com.larus.bmhome.taskskill.network;

import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.dispatcher.api.AllDeviceResponse;
import com.larus.dispatcher.api.GetAllDevicesApi;
import com.larus.dispatcher.api.GetAllDevicesRepo;
import com.larus.network.FlowHttpConnection;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class PcDeviceRepository {
    public static final PcDeviceRepository a = null;
    public static volatile List<PcDevice> b;

    static {
        a = new PcDeviceRepository();
    }

    public PcDeviceRepository() {
    }

    public final Object b(Continuation<? super Result<? extends List<PcDevice>>> r22) {
        if ((r22 instanceof PcDeviceRepository$getAllDevices$1) == false) goto L7;
        PcDeviceRepository$getAllDevices$1 r1 = (PcDeviceRepository$getAllDevices$1) r22;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
    L17:
        AllDeviceResponse r5 = (AllDeviceResponse) r0;
        if (r5 != null) goto L21;
        FLogger.a.w("PcDeviceRepository", "[getAllDevices] failed");
        Result.Companion r6 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("request all devices failed")));
    L21:
        List r7 = r5.getDevices();
        if (r7 != null) goto L24;
        r7 = CollectionsKt.emptyList();
    L24:
        List r8 = r7;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r10 = r8.iterator();
    L26:
        if (r10.hasNext() == false) goto L67;
        PcDevice r11 = (PcDevice) r10.next();
        String r12 = null;
        if (r11 == null) goto L30;
        String r13 = r11.getDeviceId();
    L31:
        if (r11 == null) goto L33;
        String r14 = r11.d();
    L34:
        if (r11 == null) goto L36;
        String r15 = r11.e();
    L37:
        boolean r16 = false;
        if (r11 == null) goto L40;
        boolean r17 = Intrinsics.areEqual(r11.c(), Boolean.TRUE);
    L41:
        if (r11 == null) goto L43;
        boolean r18 = Intrinsics.areEqual(r11.g(), Boolean.TRUE);
    L44:
        if (r11 == null) goto L46;
        r16 = Intrinsics.areEqual(r11.r(), Boolean.TRUE);
    L46:
        if (r11 == null) goto L48;
        List<Integer> r19 = r11.q();
    L49:
        if (r11 == null) goto L51;
        String r110 = r11.j();
    L52:
        if (r11 == null) goto L54;
        String r111 = r11.k();
    L55:
        if (r11 == null) goto L57;
        String r112 = r11.o();
    L58:
        if (r11 == null) goto L60;
        String r113 = r11.b();
    L61:
        if (r11 == null) goto L63;
        String r114 = r11.h();
    L64:
        if (r11 == null) goto L66;
        r12 = r11.i();
    L66:
        r9.add(new PcDevice(r13, r14, r15, Boolean.valueOf(r17), Boolean.valueOf(r16), r113, r110, r111, r112, Boolean.valueOf(r18), r19, r114, r12));
        goto L26
    L63:
        r114 = null;
        goto L64
    L60:
        r113 = null;
        goto L61
    L57:
        r112 = null;
        goto L58
    L54:
        r111 = null;
        goto L55
    L51:
        r110 = null;
        goto L52
    L48:
        r19 = null;
        goto L49
    L43:
        r18 = false;
        goto L44
    L40:
        r17 = false;
        goto L41
    L36:
        r15 = null;
        goto L37
    L33:
        r14 = null;
        goto L34
    L30:
        r13 = null;
        goto L31
    L67:
        b = r9;
        FLogger.a.i("PcDeviceRepository", "[getAllDevices] success, size=" + r9.size());
        return Result.constructor-impl(r9);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        GetAllDevicesRepo r20 = GetAllDevicesRepo.a;
        r1.label = 1;
        r0 = GetAllDevicesRepo.e("PcDeviceRepository", r1);
        if (r0 != r3) goto L17;
        return r3;
    L7:
        r1 = new PcDeviceRepository$getAllDevices$1(this, r22);
        goto L8
    }

    public final Object a(String r11, String r12, Continuation<? super Result<Unit>> r13) {
        if ((r13 instanceof PcDeviceRepository$authorizeDevice$1) == false) goto L7;
        PcDeviceRepository$authorizeDevice$1 r0 = (PcDeviceRepository$authorizeDevice$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        PcDeviceRepository$authorizeDevice$1 r8 = r0;
        Object r14 = r8.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r8.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r11 = (String) r8.L$0;
        ResultKt.throwOnFailure(r14);
    L17:
        dm9.a.b r15 = (dm9.a) r14;
        if ((r15 instanceof dm9.a.b) == false) goto L24;
        dm9.a.b r16 = r15;
        if (r16.a.isSuccess() == false) goto L22;
        FLogger.a.i("PcDeviceRepository", "[authorizeDevice] success, targetDeviceId=" + r11);
        Result.Companion r17 = Result.Companion;
        return Result.constructor-impl(Unit.INSTANCE);
    L22:
        FLogger.a.w("PcDeviceRepository", "[authorizeDevice] failed, targetDeviceId=" + r11 + ", code=" + r16.a.getCode() + ", msg=" + r16.a.getMsg());
        Result.Companion r18 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("authorize device failed")));
    L24:
        if ((r15 instanceof dm9.a.a) == false) goto L31;
        FLogger r19 = FLogger.a;
        StringBuilder r4 = new StringBuilder("[authorizeDevice] error, targetDeviceId=");
        r4.append(r11);
        r4.append(", code=");
        dm9.a.a r110 = (dm9.a.a) r15;
        r4.append(r110.a);
        r4.append(", msg=");
        r4.append(r110.b);
        r19.e("PcDeviceRepository", r4.toString(), r110.c);
        Result.Companion r111 = Result.Companion;
        Throwable r112 = r110.c;
        if (r112 != null) goto L29;
        r112 = new IllegalStateException("authorize device error");
    L29:
        return Result.constructor-impl(ResultKt.createFailure(r112));
    L31:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        GetAllDevicesApi.a r113 = GetAllDevicesApi.a;
        PcDeviceRepository$authorizeDevice$result$1 r5 = new PcDeviceRepository$authorizeDevice$result$1(r11, r12, null);
        r8.L$0 = r11;
        r8.label = 1;
        r113.getClass();
        FlowHttpConnection r114 = FlowHttpConnection.a;
        r14 = FlowHttpConnection.g("MainBot", GetAllDevicesApi.class, r5, true, null, null, null, r8, 240);
        if (r14 != r2) goto L17;
        return r2;
    L7:
        r0 = new PcDeviceRepository$authorizeDevice$1(this, r13);
        goto L8
    }
}
