package com.larus.dora.impl.bridge;

import com.bytedance.dora.device.DoraDevice;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.larus.dora.impl.core.o0;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.bridge.DoraDeviceGetCurrentMethod$handle$1", f = "DoraDeviceGetCurrentMethod.kt", i = {0, 0, 1, 1, 1, 1}, l = {68, 94, 108}, m = "invokeSuspend", n = {"requestedExtraInfo", "deviceKey", "requestedExtraInfo", "deviceKey", "settingsSnapshot", "result"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3"})
final class DoraDeviceGetCurrentMethod$handle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ kj4.a $adapter;
    final /* synthetic */ CompletionBlock<m.c> $callback;
    final /* synthetic */ DoraDevice $device;
    final /* synthetic */ m.b $params;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ m this$0;

    /* JADX INFO: renamed from: com.larus.dora.impl.bridge.DoraDeviceGetCurrentMethod$handle$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.bridge.DoraDeviceGetCurrentMethod$handle$1$3", f = "DoraDeviceGetCurrentMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CompletionBlock<m.c> $callback;
        final /* synthetic */ m.c $result;
        int label;

        public AnonymousClass3(CompletionBlock<m.c> r1, m.c r2, Continuation<? super AnonymousClass3> r3) {
            this.$callback = r1;
            this.$result = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass3(this.$callback, this.$result, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r4);
            CompletionBlock.DefaultImpls.onSuccess$default(this.$callback, this.$result, null, 2, null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DoraDeviceGetCurrentMethod$handle$1(m.b r1, m r2, DoraDevice r3, kj4.a r4, CompletionBlock<m.c> r5, Continuation<? super DoraDeviceGetCurrentMethod$handle$1> r6) {
        this.$params = r1;
        this.this$0 = r2;
        this.$device = r3;
        this.$adapter = r4;
        this.$callback = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        DoraDeviceGetCurrentMethod$handle$1 r7 = new DoraDeviceGetCurrentMethod$handle$1(this.$params, this.this$0, this.$device, this.$adapter, this.$callback, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r22) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L16;
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L10;
        if (r0 != 3) goto L9;
        ResultKt.throwOnFailure(r22);
    L139:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        m.c r1 = (m.c) this.L$3;
        n r6 = (n) this.L$2;
        String r8 = (String) this.L$1;
        Set r10 = (Set) this.L$0;
        ResultKt.throwOnFailure(r22);
        Object r3 = r22;
    L118:
        Map r4 = (Map) r3;
        m.c r12 = r1;
        n r5 = r6;
        Set r11 = r10;
        String r13 = r8;
    L120:
        m r7 = this.this$0;
        if (r5 == null) goto L123;
        IntRange r9 = m.b;
        r7.getClass();
        Map r14 = m.e(r5, r11);
    L124:
        IntRange r15 = m.b;
        r7.getClass();
        if (r4 == null) goto L131;
        LinkedHashMap r16 = new LinkedHashMap();
        if (r14 == null) goto L130;
        r16.putAll(r14);
    L130:
        r16.put("gestureSettings", r4);
        r14 = r16;
    L131:
        r12.setSettings(r14);
        FLogger r17 = FLogger.a;
        StringBuilder r18 = new StringBuilder("dora.device.getCurrent return result deviceKey=");
        r18.append(r13);
        r18.append(" sn=");
        r18.append(this.$device.getSerialNumber());
        r18.append(" productId=");
        r18.append(this.$device.productId);
        r18.append(" requestedExtraInfo=");
        r18.append(r11);
        r18.append(" settings=");
        r18.append(r14);
        r18.append(" supportAbilitiesCount=");
        List<String> r20 = r12.getSupportAbilities();
        if (r20 == null) goto L134;
        int r21 = r20.size();
    L135:
        r18.append(r21);
        r17.i("DoraDeviceGetCurrentMethod", r18.toString());
        MainCoroutineDispatcher r23 = Dispatchers.getMain();
        AnonymousClass3 r24 = new AnonymousClass3(this.$callback, r12, null);
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.label = 3;
        if (BuildersKt.withContext(r23, r24, this) != r2) goto L139;
        return r2;
    L134:
        r21 = 0;
        goto L135
    L123:
        r14 = null;
        goto L124
    L11:
        r13 = (String) this.L$1;
        r11 = (Set) this.L$0;
        ResultKt.throwOnFailure(r22);     // Catch: Throwable -> L14
        Object r25 = r22;
    L63:
        Object r26 = Result.constructor-impl((n) r25);     // Catch: Throwable -> L14
    L68:
        Throwable r110 = Result.exceptionOrNull-impl(r26);
        if (r110 == null) goto L72;
        FLogger.a.e("DoraDeviceGetCurrentMethod", "dora.device.getCurrent load device settings failed deviceKey=" + r13 + " requestedExtraInfo=" + r11, r110);
    L72:
        if (Result.isFailure-impl(r26) == false) goto L74;
        r26 = null;
    L74:
        r5 = (n) r26;
    L75:
        r12 = ne7.e.b(m.c.class);
        r12.setName(this.$device.name);
        r12.setMac(this.$device.mac);
        r12.setSn(this.$device.getSerialNumber());
        r12.setBattery(m.b(this.this$0, this.$device.battery));
        r12.setCharge(m.b(this.this$0, this.$device.charge));
        r12.setState(m.b(this.this$0, this.$device.state));
        Integer r111 = Boxing.boxInt(this.$device.busyState);
        if (r111.intValue() < 0) goto L78;
        boolean r112 = true;
    L79:
        if (r112 == true) goto L82;
        r111 = null;
    L82:
        r12.setBtstate(r111);
        Integer r113 = Boxing.boxInt(this.$device.sku);
        if (r113.intValue() < 0) goto L85;
        boolean r114 = true;
    L86:
        if (r114 == true) goto L89;
        r113 = null;
    L89:
        r12.setSku(r113);
        r12.setVersion(this.$device.softVersion);
        r12.setProductId(Boxing.boxInt(this.$device.productId));
        r12.setVendorId(Boxing.boxInt(this.$device.vendorId));
        m r115 = this.this$0;
        sk4.e r116 = o0.a;
        sk4.e r117 = o0.a(this.$device.getSerialNumber());
        if (r117 == null) goto L92;
        String r118 = sk4.f.a(r117);
    L93:
        r115.getClass();
        if (r118 == null) goto L111;
        List r119 = StringsKt.split$default(r118, new String[]{","}, false, 0, 6, null);
        ArrayList r120 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r119, 10));
        Iterator r121 = r119.iterator();
    L98:
        if (r121.hasNext() == false) goto L100;
        r120.add(StringsKt.trim(StringsKt.trim((String) r121.next()).toString(), new char[]{'[', ']'}));
        goto L98
    L100:
        ArrayList r27 = new ArrayList();
        Iterator r122 = r120.iterator();
    L102:
        if (r122.hasNext() == false) goto L110;
        Object r123 = r122.next();
        if (((String) r123).length() <= 0) goto L106;
        boolean r124 = true;
    L107:
        if (r124 == false) goto L102;
        r27.add(r123);
        goto L102
    L106:
        r124 = false;
        goto L107
    L110:
        if (r27.isEmpty() == true) goto L111;
    L112:
        r12.setSupportAbilities(r27);
        if (r11.contains("GestureSettings") == false) goto L119;
        DoraDeviceBridgePayloadHelper r28 = DoraDeviceBridgePayloadHelper.a;
        DoraDevice r30 = this.$device;
        List<String> r125 = r12.getSupportAbilities();
        this.L$0 = r11;
        this.L$1 = r13;
        this.L$2 = r5;
        this.L$3 = r12;
        this.label = 2;
        r3 = r28.c(r30, r125, this);
        if (r3 != r2) goto L117;
        return r2;
    L117:
        r6 = r5;
        r8 = r13;
        r10 = r11;
        r1 = r12;
        goto L118
    L119:
        r4 = null;
    L111:
        r27 = null;
        goto L112
    L92:
        r118 = null;
        goto L93
    L85:
        r114 = false;
        goto L86
    L78:
        r112 = false;
    L14:
        th = th;
        String r126 = r13;
        Set r127 = r11;
    L67:
        Result.Companion r128 = Result.Companion;
        r26 = Result.constructor-impl(ResultKt.createFailure(th));
        r11 = r127;
        r13 = r126;
        goto L68
    L16:
        ResultKt.throwOnFailure(r22);
        CoroutineScope r31 = (CoroutineScope) this.L$0;
        List<String> r32 = this.$params.getDeviceExtraInfo();
        if (r32 != null) goto L19;
        r32 = CollectionsKt.emptyList();
    L19:
        m r129 = this.this$0;
        IntRange r130 = m.b;
        r129.getClass();
        if (r32.isEmpty() == false) goto L22;
        r127 = SetsKt.emptySet();
    L29:
        m r131 = this.this$0;
        ArrayList r132 = new ArrayList();
        Iterator<T> r133 = r32.iterator();
    L31:
        if (r133.hasNext() == false) goto L35;
        Object r134 = r133.next();
        r131.getClass();
        if (m.c((String) r134) == true) goto L31;
        r132.add(r134);
        goto L31
    L35:
        List r135 = CollectionsKt.distinct(r132);
        m r136 = this.this$0;
        r126 = this.$device.getSerialNumber();
        DoraDevice r137 = this.$device;
        String r138 = r137.mac;
        Integer r139 = Boxing.boxInt(r137.productId);
        r136.getClass();
        if (r126 != null) goto L38;
    L42:
        if (r138 != null) goto L44;
    L46:
        r138 = null;
    L47:
        if (r138 != null) goto L51;
        if (r139 == null) goto L50;
        r126 = r139.toString();
    L52:
        FLogger r140 = FLogger.a;
        r140.i("DoraDeviceGetCurrentMethod", "dora.device.getCurrent request deviceKey=" + r126 + " rawExtraInfo=" + r32 + " requestedExtraInfo=" + r127);
        if ((!r135.isEmpty()) == false) goto L56;
        r140.w("DoraDeviceGetCurrentMethod", "dora.device.getCurrent ignored unknown deviceExtraInfo=" + r135);
    L56:
        if (r127.isEmpty() == false) goto L58;
        r140.i("DoraDeviceGetCurrentMethod", "dora.device.getCurrent skip settings load because requestedExtraInfo is empty");
        r5 = null;
        r11 = r127;
        r13 = r126;
        goto L75
    L58:
        m r33 = this.this$0;
        kj4.a r141 = this.$adapter;
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L66
        Intrinsics.checkNotNull(r141);     // Catch: Throwable -> L66
        this.L$0 = r127;     // Catch: Throwable -> L66
        this.L$1 = r126;     // Catch: Throwable -> L66
        this.label = 1;     // Catch: Throwable -> L66
        r25 = m.a(r33, r141, r126, r127, this);     // Catch: Throwable -> L66
        if (r25 != r2) goto L62;
        return r2;
    L62:
        r11 = r127;
        r13 = r126;
    L66:
        th = th;
        goto L67
    L50:
        r126 = null;
        goto L52
    L51:
        r126 = r138;
        goto L52
    L44:
        if ((!StringsKt.isBlank(r138)) == false) goto L46;
    L38:
        if ((!StringsKt.isBlank(r126)) == true) goto L41;
        r126 = null;
    L41:
        if (r126 != null) goto L52;
    L22:
        ArrayList r143 = new ArrayList();
        Iterator<T> r144 = r32.iterator();
    L24:
        if (r144.hasNext() == false) goto L28;
        Object r145 = r144.next();
        if (m.c((String) r145) == false) goto L24;
        r143.add(r145);
        goto L24
    L28:
        r127 = CollectionsKt.toSet(r143);
        goto L29
    }
}
