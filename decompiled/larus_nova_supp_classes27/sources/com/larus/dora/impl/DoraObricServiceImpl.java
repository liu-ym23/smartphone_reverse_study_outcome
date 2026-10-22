package com.larus.dora.impl;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.api.IDoraObricService;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.core.OnlyConnectResult;
import com.larus.dora.impl.guide.strategy.FineDoraDeviceStrategy;
import com.larus.network.HttpConst;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import t39.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u000b\u001a\u00020\fH\u0082@¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u000b\u001a\u00020\fH\u0082@¢\u0006\u0004\b\u0010\u0010\u000eJ\f\u0010\u0011\u001a\u00020\f*\u00020\u0007H\u0002¨\u0006\u0013"}, d2 = {"Lcom/larus/dora/impl/DoraObricServiceImpl;", "Lcom/larus/dora/api/IDoraObricService;", "<init>", "()V", "checkBindAndConnectIfNecessary", "", "deviceInfo", "Lcom/larus/dora/api/DoraDeviceInfo;", "(Lcom/larus/dora/api/DoraDeviceInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isDeviceBound", "Lkotlin/Result;", "device", "Lcom/bytedance/dora/device/DoraDevice;", "isDeviceBound-gIAlu-s", "(Lcom/bytedance/dora/device/DoraDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkBindStatus", "checkBindStatus-gIAlu-s", "toDoraDevice", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricServiceImpl implements IDoraObricService {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public DoraObricServiceImpl() {
    }

    @Override // com.larus.dora.api.IDoraObricService
    public final Object a(d r10, Continuation<? super Boolean> r11) {
        if ((r11 instanceof DoraObricServiceImpl$checkBindAndConnectIfNecessary$1) == false) goto L7;
        DoraObricServiceImpl$checkBindAndConnectIfNecessary$1 r0 = (DoraObricServiceImpl$checkBindAndConnectIfNecessary$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        ResultKt.throwOnFailure(r12);
    L48:
        return Boxing.boxBoolean(true);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r12);
    L41:
        OnlyConnectResult r13 = (OnlyConnectResult) r12;
        if (r13 != OnlyConnectResult.SUCCESS) goto L46;
        g49.d.d("DoraObricServiceImpl", "checkBindAndConnectIfNecessary: connect success, binding buds...");
        kj4.a r14 = kj4.a.g();
        r0.label = 3;
        if (DoraAdapterExtKt.c(r14, true, r0) != r2) goto L48;
        return r2;
    L46:
        g49.d.e("DoraObricServiceImpl", "checkBindAndConnectIfNecessary: connect failed result=" + r13);
        Unit r15 = Unit.INSTANCE;
        goto L48
    L17:
        DoraDevice r16 = (DoraDevice) r0.L$0;
        ResultKt.throwOnFailure(r12);
        Object r17 = ((Result) r12).unbox-impl();
    L31:
        if (Result.isFailure-impl(r17) == false) goto L33;
        r17 = null;
    L33:
        Boolean r18 = (Boolean) r17;
        if (r18 == null) goto L36;
        boolean r110 = r18.booleanValue();
    L37:
        if (r110 == false) goto L49;
        g49.d.d("DoraObricServiceImpl", "checkBindAndConnectIfNecessary: device is bound, connecting... device=" + r16.getSerialNumber());
        kj4.a.g();
        r0.L$0 = null;
        r0.label = 2;
        r12 = DoraAdapterExtKt.A(r16);
        if (r12 != r2) goto L41;
        return r2;
    L49:
        g49.d.d("DoraObricServiceImpl", "checkBindAndConnectIfNecessary: device not bound");
        return Boxing.boxBoolean(false);
    L36:
        r110 = false;
        goto L37
    L18:
        ResultKt.throwOnFailure(r12);
        DoraDevice r111 = new DoraDevice();
        r111.name = r10.a;
        r111.mac = r10.b;
        Integer r4 = r10.c;
        if (r4 == null) goto L21;
        int r5 = r4.intValue();
    L22:
        r111.productId = r5;
        r111.sn = r10.f;
        Integer r112 = r10.d;
        if (r112 == null) goto L25;
        int r113 = r112.intValue();
    L26:
        r111.vendorId = r113;
        r0.L$0 = r111;
        r0.label = 1;
        Object r114 = c(r111, r0);
        if (r114 != r2) goto L29;
        return r2;
    L29:
        r17 = r114;
        r16 = r111;
        goto L31
    L25:
        r113 = 1;
        goto L26
    L21:
        r5 = 1;
    L7:
        r0 = new DoraObricServiceImpl$checkBindAndConnectIfNecessary$1(this, r11);
        goto L8
    }

    public final Object b(DoraDevice r12, Continuation<? super Result<Boolean>> r13) {
        if ((r13 instanceof DoraObricServiceImpl$checkBindStatus$1) == false) goto L7;
        DoraObricServiceImpl$checkBindStatus$1 r2 = (DoraObricServiceImpl$checkBindStatus$1) r13;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        DoraObricServiceImpl$checkBindStatus$1 r8 = r2;
        Object r14 = r8.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r8.label;
        if (r5 == 0) goto L15;
        if (r5 != 1) goto L14;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L39
    L19:
        com.larus.network.http.y r15 = (com.larus.network.http.a) r14;     // Catch: Throwable -> L39
        if ((r15 instanceof com.larus.network.http.y) == false) goto L33;
        Long r16 = r15.g;     // Catch: Throwable -> L39
        if (r16 == null) goto L33;
        if (r16.longValue() != 0) goto L33;
        FineDoraDeviceStrategy.a r17 = (FineDoraDeviceStrategy.a) ((com.larus.network.http.a) r15).b;     // Catch: Throwable -> L39
        if (r17 == null) goto L31;
        Boolean r18 = r17.a();     // Catch: Throwable -> L39
        if (r18 == null) goto L31;
        boolean r110 = r18.booleanValue();     // Catch: Throwable -> L39
    L32:
        g49.d.d("DoraObricServiceImpl", "checkBindStatus() success, bindingStatus=" + r110);     // Catch: Throwable -> L39
        Object r111 = Result.constructor-impl(Boxing.boxBoolean(r110));     // Catch: Throwable -> L39
    L41:
        Throwable r112 = Result.exceptionOrNull-impl(r111);
        if (r112 == null) goto L47;
        g49.d.c("DoraObricServiceImpl", "checkBindStatus() error: " + r112.getMessage(), r112);
        return Result.constructor-impl(ResultKt.createFailure(r112));
    L47:
        return Result.constructor-impl(Boxing.boxBoolean(((Boolean) r111).booleanValue()));
    L31:
        r110 = false;
    L33:
        StringBuilder r0 = new StringBuilder("Check bind status failed, code=");     // Catch: Throwable -> L39
        if ((r15 instanceof com.larus.network.http.y) == false) goto L36;
        Long r113 = r15.g;     // Catch: Throwable -> L39
    L37:
        r0.append(r113);     // Catch: Throwable -> L39
        throw new IllegalStateException(r0.toString());     // Catch: Throwable -> L39
    L36:
        r113 = Boxing.boxLong(-1);     // Catch: Throwable -> L39
        goto L37
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r14);
        g49.d.d("DoraObricServiceImpl", "checkBindStatus() start, w_did=" + r12.getSerialNumber());
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L39
        com.larus.dora.api.network.a r6 = com.larus.dora.api.network.a.a;     // Catch: Throwable -> L39
        StringBuilder r7 = new StringBuilder();     // Catch: Throwable -> L39
        HttpConst.a.getClass();     // Catch: Throwable -> L39
        r7.append(HttpConst.m);     // Catch: Throwable -> L39
        r7.append("/alice/w/device/check_binding_status");     // Catch: Throwable -> L39
        String r9 = r7.toString();     // Catch: Throwable -> L39
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L39
        r10.put("w_did", r12.getSerialNumber());     // Catch: Throwable -> L39
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L39
        r8.label = 1;     // Catch: Throwable -> L39
        r14 = com.larus.dora.api.network.a.c(r6, FineDoraDeviceStrategy.a.class, r9, r10, null, r8, 248);     // Catch: Throwable -> L39
        if (r14 != r4) goto L19;
        return r4;
    L39:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r111 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r2 = new DoraObricServiceImpl$checkBindStatus$1(this, r13);
        goto L8
    }

    public final Object c(DoraDevice r7, Continuation<? super Result<Boolean>> r8) {
        if ((r8 instanceof DoraObricServiceImpl$isDeviceBound$1) == false) goto L7;
        DoraObricServiceImpl$isDeviceBound$1 r0 = (DoraObricServiceImpl$isDeviceBound$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        DoraDevice r10 = (DoraDevice) r0.L$0;
        ResultKt.throwOnFailure(r9);     // Catch: Exception -> L38
        return ((Result) r9).unbox-impl();
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r9);
        List r11 = kj4.a.g().getDoraBindList();     // Catch: Exception -> L38
        if ((r11 instanceof Collection) == true) goto L20;
    L22:
        Iterator r12 = r11.iterator();     // Catch: Exception -> L38
    L24:
        if (r12.hasNext() == false) goto L21;
        if (Intrinsics.areEqual(((DoraDevice) r12.next()).mac, r7.mac) == false) goto L24;
        boolean r13 = true;
    L28:
        if (r13 == false) goto L32;
        Result.Companion r14 = Result.Companion;     // Catch: Exception -> L38
        return Result.constructor-impl(Boxing.boxBoolean(true));
    L32:
        if (o59.a.o(Boxing.boxInt(r7.productId)) == false) goto L35;
        Result.Companion r15 = Result.Companion;     // Catch: Exception -> L38
        return Result.constructor-impl(Boxing.boxBoolean(false));
    L35:
        r0.L$0 = r7;     // Catch: Exception -> L38
        r0.label = 1;     // Catch: Exception -> L38
        Object r16 = b(r7, r0);     // Catch: Exception -> L38
        if (r16 != r2) goto L45;
        return r2;
    L45:
        return r16;
    L21:
        r13 = false;
        goto L28
    L20:
        if (r11.isEmpty() == false) goto L22;
    L38:
        e = move-exception;
        g49.d.c("DoraObricServiceImpl", "Failed to check bind state for device: " + r7.mac, e);
        Result.Companion r17 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(e));
    L7:
        r0 = new DoraObricServiceImpl$isDeviceBound$1(this, r8);
        goto L8
    }
}
