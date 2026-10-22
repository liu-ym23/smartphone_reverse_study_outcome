package com.larus.dora.impl.bridge;

import android.os.SystemClock;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.larus.doc.sdk.impl.BuildConfig;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@XBridgeMethod(name = "dora.buds.txSync")
public final class DoraBudsTxSyncMethod extends XCoreIDLBridgeMethod<c, d> {
    public static final IntRange b = null;

    @XBridgeMethodName(name = "dora.buds.txSync")
    public final String a;

    public static final class a {
        public final boolean a;
        public final d b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r1 = ((r0 * 31) + this.b.hashCode()) * 31;
            String r2 = this.c;
            if (r2 != null) goto L9;
            int r3 = 0;
        L11:
            return r1 + r3;
        L9:
            r3 = r2.hashCode();
            goto L11
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "BridgeResult(isFailure=" + this.a + ", resultModel=" + this.b + ", message=" + this.c + ')';
        }

        public a(boolean r2, d r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "resultModel");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class b {
    }

    @XBridgeParamModel
    public interface c extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "cid", required = true)
        Number getCid();

        @XBridgeParamField(isGetter = true, keyPath = "event", required = true)
        Number getEvent();

        @XBridgeParamField(isGetter = true, keyPath = "sid", required = true)
        Number getSid();

        @XBridgeParamField(isGetter = true, keyPath = "tolerableTimeout", required = BuildConfig.DEBUG)
        Number getTolerableTimeout();

        @XBridgeParamField(isGetter = true, keyPath = "value", required = BuildConfig.DEBUG)
        List<Number> getValue();
    }

    @XBridgeResultModel
    public interface d extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "retCode", required = BuildConfig.DEBUG)
        Number getRetCode();

        @XBridgeParamField(isGetter = true, keyPath = "retData", required = BuildConfig.DEBUG)
        Object getRetData();

        @XBridgeParamField(isGetter = BuildConfig.DEBUG, keyPath = "retCode", required = BuildConfig.DEBUG)
        void setRetCode(Number r1);

        @XBridgeParamField(isGetter = BuildConfig.DEBUG, keyPath = "retData", required = BuildConfig.DEBUG)
        void setRetData(Object r1);
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.bridge.DoraBudsTxSyncMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.bridge.DoraBudsTxSyncMethod$handle$1", f = "DoraBudsTxSyncMethod.kt", i = {0}, l = {75, 90}, m = "invokeSuspend", n = {"startMs"}, s = {"J$0"})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CompletionBlock<d> $callback;
        final /* synthetic */ Integer $cid;
        final /* synthetic */ Integer $event;
        final /* synthetic */ Integer $sid;
        final /* synthetic */ List<Integer> $values;
        long J$0;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DoraBudsTxSyncMethod this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.bridge.DoraBudsTxSyncMethod$handle$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.dora.impl.bridge.DoraBudsTxSyncMethod$handle$1$1", f = "DoraBudsTxSyncMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ a $bridgeResult;
            final /* synthetic */ CompletionBlock<d> $callback;
            int label;

            public C00281(a r1, CompletionBlock<d> r2, Continuation<? super C00281> r3) {
                this.$bridgeResult = r1;
                this.$callback = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C00281(this.$bridgeResult, this.$callback, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r4) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L14;
                ResultKt.throwOnFailure(r4);
                a r5 = this.$bridgeResult;
                if (r5.a == false) goto L10;
                CompletionBlock<d> r0 = this.$callback;
                String r1 = r5.c;
                if (r1 != null) goto L9;
                r1 = "unknown error";
            L9:
                r0.onFailure(0, r1, r5.b);
            L12:
                return Unit.INSTANCE;
            L10:
                CompletionBlock.DefaultImpls.onSuccess$default(this.$callback, r5.b, null, 2, null);
                goto L12
            L14:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(DoraBudsTxSyncMethod r1, Integer r2, Integer r3, Integer r4, List<Integer> r5, CompletionBlock<d> r6, Continuation<? super AnonymousClass1> r7) {
            this.this$0 = r1;
            this.$sid = r2;
            this.$cid = r3;
            this.$event = r4;
            this.$values = r5;
            this.$callback = r6;
            super(2, r7);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            AnonymousClass1 r8 = new AnonymousClass1(this.this$0, this.$sid, this.$cid, this.$event, this.$values, this.$callback, r11);
            r8.L$0 = r10;
            return r8;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r13);
        L31:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            long r4 = this.J$0;
            ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L18
        L16:
            Object r14 = Result.constructor-impl((a) r13);     // Catch: Throwable -> L18
        L20:
            DoraBudsTxSyncMethod r2 = this.this$0;
            Throwable r6 = Result.exceptionOrNull-impl(r14);
            if (r6 == null) goto L27;
            FLogger.a.e("DoraBudsTxSyncMethod", "dora.buds.txSync execute failed", r6);
            String r15 = r6.getMessage();
            if (r15 != null) goto L26;
            r15 = "unknown error";
        L26:
            IntRange r7 = DoraBudsTxSyncMethod.b;
            r2.getClass();
            d r3 = ne7.e.b(d.class);
            r3.setRetCode(-1);
            r3.setRetData(null);
            r14 = new a(true, r3, r15);
        L27:
            a r16 = (a) r14;
            long r9 = SystemClock.elapsedRealtime() - r4;
            FLogger r5 = FLogger.a;
            StringBuilder r8 = new StringBuilder("dora.buds.txSync end sid=0x");
            DoraBudsTxSyncMethod r10 = this.this$0;
            int r11 = this.$sid.intValue();
            IntRange r12 = DoraBudsTxSyncMethod.b;
            r10.getClass();
            r8.append(Integer.toHexString(r11));
            r8.append(" cid=0x");
            DoraBudsTxSyncMethod r17 = this.this$0;
            int r18 = this.$cid.intValue();
            r17.getClass();
            r8.append(Integer.toHexString(r18));
            r8.append(" event=0x");
            DoraBudsTxSyncMethod r20 = this.this$0;
            int r21 = this.$event.intValue();
            r20.getClass();
            r8.append(Integer.toHexString(r21));
            r8.append(" retCode=");
            r8.append(r16.b.getRetCode());
            r8.append(" costMs=");
            r8.append(r9);
            r5.i("DoraBudsTxSyncMethod", r8.toString());
            MainCoroutineDispatcher r22 = Dispatchers.getMain();
            C00281 r23 = new C00281(r16, this.$callback, null);
            this.label = 2;
            if (BuildersKt.withContext(r22, r23, this) != r0) goto L31;
            return r0;
        L12:
            ResultKt.throwOnFailure(r13);
            CoroutineScope r110 = (CoroutineScope) this.L$0;
            r4 = SystemClock.elapsedRealtime();
            DoraBudsTxSyncMethod r24 = this.this$0;
            Integer r111 = this.$sid;
            Integer r25 = this.$cid;
            Integer r26 = this.$event;
            List<Integer> r112 = this.$values;
            Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L18
            int r113 = r111.intValue();     // Catch: Throwable -> L18
            int r28 = r25.intValue();     // Catch: Throwable -> L18
            int r30 = r26.intValue();     // Catch: Throwable -> L18
            this.J$0 = r4;     // Catch: Throwable -> L18
            this.label = 1;     // Catch: Throwable -> L18
            r13 = DoraBudsTxSyncMethod.a(r24, r113, r28, r30, r112, this);     // Catch: Throwable -> L18
            if (r13 != r0) goto L16;
            return r0;
        L18:
            th = move-exception;
            Result.Companion r31 = Result.Companion;
            r14 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L20
        }
    }

    static {
        b = new IntRange(0, 1);
    }

    public DoraBudsTxSyncMethod() {
        this.a = "dora.buds.txSync";
    }

    public final String getName() {
        return this.a;
    }

    public static String e(DoraBudsTxSyncMethod r6, List r7) {
        r6.getClass();
        if (r7.isEmpty() == false) goto L5;
        return "[]";
    L5:
        int r8 = Math.min(r7.size(), 16);
        StringBuilder r1 = new StringBuilder("[");
        int r2 = 0;
    L6:
        if (r2 >= r8) goto L14;
        if (r2 <= 0) goto L9;
        r1.append(' ');
    L9:
        r1.append("0x");
        String r3 = Integer.toHexString(((Number) ListProtector.get(r7, r2)).intValue() & 255);
        if (r3.length() != 1) goto L12;
        r1.append('0');
    L12:
        r1.append(r3);
        r2 = r2 + 1;
        goto L6
    L14:
        if (r7.size() <= 16) goto L16;
        r1.append(" ... +");
        r1.append(r7.size() - 16);
    L16:
        r1.append(']');
        return r1.toString();
    }

    public final Object c(List<Integer> r11, Continuation<? super Pair<Integer, ? extends Object>> r12) {
        if ((r12 instanceof DoraBudsTxSyncMethod$executeVolumeAdaptation$1) == false) goto L7;
        DoraBudsTxSyncMethod$executeVolumeAdaptation$1 r0 = (DoraBudsTxSyncMethod$executeVolumeAdaptation$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = false;
        boolean r6 = true;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        final int r14 = r0.I$0;
        String r5 = (String) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L44:
        int r15 = ((Number) r13).intValue();
        if (r15 != 0) goto L52;
        IntRange r7 = b;
        int r8 = r7.getFirst();
        if (r14 > r7.getLast()) goto L50;
        if (r8 > r14) goto L50;
        r4 = true;
    L50:
        if (r4 == false) goto L52;
        DoraDeviceSettingsCache.a.update(r5, new com.larus.dora.impl.bridge.b(r14));
    L52:
        FLogger.a.i("DoraBudsTxSyncMethod", "dora.buds.txSync volumeAdaptation set deviceKey=" + r5 + " nextState=" + r14 + " retCode=" + r15);
        return TuplesKt.to(Boxing.boxInt(r15), null);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r16 = (String) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L32:
        final int r17 = ((Number) r13).intValue();
        IntRange r9 = b;
        int r10 = r9.getFirst();
        if (r17 > r9.getLast()) goto L36;
        if (r10 > r17) goto L36;
    L37:
        if (r6 == false) goto L39;
        DoraDeviceSettingsCache.a.update(r16, new com.larus.dora.impl.bridge.a(r17));
        FLogger.a.i("DoraBudsTxSyncMethod", "dora.buds.txSync volumeAdaptation get ok deviceKey=" + r16 + " state=" + r17);
        return TuplesKt.to(Boxing.boxInt(0), Boxing.boxInt(r17));
    L39:
        FLogger.a.w("DoraBudsTxSyncMethod", "dora.buds.txSync volumeAdaptation get unexpected state=" + r17 + " deviceKey=" + r16);
        return TuplesKt.to(Boxing.boxInt(r17), null);
    L36:
        r6 = false;
        goto L37
    L16:
        ResultKt.throwOnFailure(r13);
        kj4.a r18 = kj4.a.g();
        Intrinsics.checkNotNull(r18);
        DoraDevice r20 = DoraAdapterExtKt.h(r18);
        if (r20 == null) goto L19;
        String r21 = r20.getSerialNumber();
    L20:
        if (r20 == null) goto L22;
        String r22 = r20.mac;
    L23:
        if (r20 == null) goto L25;
        Integer r23 = Boxing.boxInt(r20.productId);
    L26:
        String r24 = b(r21, r22, r23);
        if (r11.isEmpty() == false) goto L40;
        r0.L$0 = r24;
        r0.label = 1;
        r13 = DoraAdapterExtKt.l(r18);
        if (r13 != r2) goto L31;
        return r2;
    L31:
        r16 = r24;
        goto L32
    L40:
        r14 = ((Number) CollectionsKt.first(r11)).intValue();
        r0.L$0 = r24;
        r0.I$0 = r14;
        r0.label = 2;
        r13 = DoraAdapterExtKt.H(r18, r14);
        if (r13 != r2) goto L43;
        return r2;
    L43:
        r5 = r24;
        goto L44
    L25:
        r23 = null;
        goto L26
    L22:
        r22 = null;
        goto L23
    L19:
        r21 = null;
    L7:
        r0 = new DoraBudsTxSyncMethod$executeVolumeAdaptation$1(this, r12);
        goto L8
    }

    public final String b(String r3, String r4, Number r5) {
        if (r3 != null) goto L5;
    L11:
        if (r4 != null) goto L13;
    L15:
        r4 = null;
    L16:
        if (r4 != null) goto L20;
        if (r5 != null) goto L23;
        return null;
    L23:
        return r5.toString();
    L20:
        return r4;
    L13:
        if ((!StringsKt.isBlank(r4)) == false) goto L15;
    L5:
        if ((!StringsKt.isBlank(r3)) == true) goto L8;
        r3 = null;
    L8:
        if (r3 == null) goto L11;
        return r3;
    }

    public final void handle(IBDXBridgeContext r110, XBaseParamModel r20, CompletionBlock r21) {
        c r0 = (c) r20;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r0, "params");
        Intrinsics.checkNotNullParameter(r21, "callback");
        if (DoraAdapterExtKt.h(kj4.a.g()) != null) goto L5;
        FLogger.a.w("DoraBudsTxSyncMethod", "dora.buds.txSync current dora device not found");
        CompletionBlock.DefaultImpls.onFailure$default(r21, 0, "current dora device not found", null, 4, null);
    L36:
        return;
    L5:
        Number r1 = r0.getSid();
        if (r1 == null) goto L8;
        Integer r4 = Integer.valueOf(r1.intValue());
    L9:
        Number r2 = r0.getCid();
        if (r2 == null) goto L12;
        Integer r5 = Integer.valueOf(r2.intValue());
    L13:
        Number r3 = r0.getEvent();
        if (r3 == null) goto L16;
        Integer r6 = Integer.valueOf(r3.intValue());
    L17:
        if (r4 == null) goto L33;
        if (r5 == null) goto L33;
        if (r6 == null) goto L33;
        List<Number> r7 = r0.getValue();
        if (r7 != null) goto L24;
        r7 = CollectionsKt.emptyList();
    L24:
        List<Number> r8 = r7;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r10 = r8.iterator();
    L26:
        if (r10.hasNext() == false) goto L29;
        r9.add(Integer.valueOf(((Number) r10.next()).intValue() & 255));
        goto L26
    L29:
        if (r9.size() <= 255) goto L32;
        FLogger.a.w("DoraBudsTxSyncMethod", "dora.buds.txSync value too long sid=0x" + Integer.toHexString(r4.intValue()) + " cid=0x" + Integer.toHexString(r5.intValue()) + " event=0x" + Integer.toHexString(r6.intValue()) + " len=" + r9.size());
        StringBuilder r11 = new StringBuilder("value is too long: ");
        r11.append(r9.size());
        CompletionBlock.DefaultImpls.onFailure$default(r21, -3, r11.toString(), null, 4, null);
        goto L36
    L32:
        FLogger.a.i("DoraBudsTxSyncMethod", "dora.buds.txSync start sid=0x" + Integer.toHexString(r4.intValue()) + " cid=0x" + Integer.toHexString(r5.intValue()) + " event=0x" + Integer.toHexString(r6.intValue()) + " len=" + r9.size() + " values=" + e(this, r9) + " tolerableTimeout=" + r0.getTolerableTimeout());
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO())), null, null, new AnonymousClass1(this, r4, r5, r6, r9, r21, null), 3, null);
        return;
    L33:
        FLogger.a.w("DoraBudsTxSyncMethod", "dora.buds.txSync invalid params sid=" + r4 + " cid=" + r5 + " event=" + r6);
        CompletionBlock.DefaultImpls.onFailure$default(r21, -3, "sid/cid/event is required", null, 4, null);
        return;
    L16:
        r6 = null;
        goto L17
    L12:
        r5 = null;
        goto L13
    L8:
        r4 = null;
        goto L9
    }

    public static final Object a(DoraBudsTxSyncMethod r16, int r17, int r18, int r110, List r20, Continuation r21) {
        r16.getClass();
        if ((r21 instanceof DoraBudsTxSyncMethod$executeTxSync$1) == false) goto L7;
        DoraBudsTxSyncMethod$executeTxSync$1 r6 = (DoraBudsTxSyncMethod$executeTxSync$1) r21;
        int r7 = r6.label;
        if ((r7 & Integer.MIN_VALUE) == 0) goto L7;
        r6.label = r7 - Integer.MIN_VALUE;
    L8:
        Object r5 = r6.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r9 = r6.label;
        if (r9 == 0) goto L14;
        if (r9 != 1) goto L13;
        ResultKt.throwOnFailure(r5);
    L22:
        Pair r10 = (Pair) r5;
    L67:
        int r0 = ((Number) r10.component1()).intValue();
        Object r1 = r10.component2();
        d r2 = ne7.e.b(d.class);
        r2.setRetCode(Integer.valueOf(r0));
        r2.setRetData(r1);
        return new a(false, r2, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r5);
        if (r17 == 1) goto L17;
    L23:
        if (r17 == 1) goto L25;
    L46:
        int r3 = r20.size() + 2;
        byte[] r4 = new byte[r3];
        r4[0] = (byte) r110;
        r4[1] = (byte) r3;
        int r11 = 0;
        int r12 = 0;
    L47:
        if (r11 >= r3) goto L49;
        int r13 = r12 + 1;
        r4[r12 + 2] = r4[r11];
        r11 = r11 + 1;
        r12 = r13;
        goto L47
    L49:
        FLogger r14 = FLogger.a;
        StringBuilder r15 = new StringBuilder("dora.buds.txSync branch=rawTxSync sid=0x");
        r15.append(Integer.toHexString(r17));
        r15.append(" cid=0x");
        r15.append(Integer.toHexString(r18));
        r15.append(" payload=");
        if (r3 != 0) goto L52;
        boolean r22 = true;
    L53:
        if (r22 == false) goto L55;
        String r23 = "[]";
    L66:
        r15.append(r23);
        r14.i("DoraBudsTxSyncMethod", r15.toString());
        r10 = TuplesKt.to(Boxing.boxInt(ak4.a.d().i(r17, r18, r4)), null);
        goto L67
    L55:
        int r24 = Math.min(r3, 24);
        StringBuilder r25 = new StringBuilder("[");
        int r111 = 0;
    L56:
        if (r111 >= r24) goto L63;
        if (r111 <= 0) goto L59;
        r25.append(' ');
    L59:
        r25.append("0x");
        String r112 = Integer.toHexString(r4[r111] & 255);
        if (r112.length() != 1) goto L62;
        r25.append('0');
    L62:
        r25.append(r112);
        r111 = r111 + 1;
        goto L56
    L63:
        if (r3 <= 24) goto L65;
        r25.append(" ... +");
        r25.append(r3 - 24);
    L65:
        r25.append(']');
        r23 = r25.toString();
        goto L66
    L52:
        r22 = false;
        goto L53
    L25:
        if (r18 != 4) goto L46;
        if (r110 != 11) goto L46;
        FLogger r26 = FLogger.a;
        r26.i("DoraBudsTxSyncMethod", "dora.buds.txSync branch=cueToneVolume sid=0x" + Integer.toHexString(r17) + " cid=0x" + Integer.toHexString(r18) + " event=0x" + Integer.toHexString(r110) + " values=" + e(r16, r20));
        kj4.a r27 = kj4.a.g();
        Intrinsics.checkNotNull(r27);
        DoraDevice r28 = DoraAdapterExtKt.h(r27);
        if (r28 == null) goto L31;
        String r30 = r28.getSerialNumber();
    L32:
        if (r28 == null) goto L34;
        String r31 = r28.mac;
    L35:
        if (r28 == null) goto L37;
        Integer r32 = Integer.valueOf(r28.productId);
    L38:
        String r33 = r16.b(r30, r31, r32);
        if (r20.isEmpty() == false) goto L42;
        final int r34 = r27.z() & 255;
        DoraDeviceSettingsCache.a.update(r33, new com.larus.dora.impl.bridge.c(r34));
        r26.i("DoraBudsTxSyncMethod", "dora.buds.txSync cueToneVolume get ok deviceKey=" + r33 + " volumeRaw=" + r34);
        Pair r35 = TuplesKt.to(0, Integer.valueOf(r34));
    L41:
        r10 = r35;
        goto L67
    L42:
        int r36 = ((Number) CollectionsKt.first(r20)).intValue();
        int r37 = r27.o(r36);
        if (r37 != 0) goto L45;
        final int r38 = r36 & 255;
        DoraDeviceSettingsCache.a.update(r33, new com.larus.dora.impl.bridge.d(r38));
    L45:
        r26.i("DoraBudsTxSyncMethod", "dora.buds.txSync cueToneVolume set deviceKey=" + r33 + " nextValue=" + r36 + " retCode=" + r37);
        r35 = TuplesKt.to(Integer.valueOf(r37), null);
        goto L41
    L37:
        r32 = null;
        goto L38
    L34:
        r31 = null;
        goto L35
    L31:
        r30 = null;
        goto L32
    L17:
        if (r18 != 5) goto L23;
        if (r110 != 1) goto L23;
        FLogger.a.i("DoraBudsTxSyncMethod", "dora.buds.txSync branch=volumeAdaptation sid=0x" + Integer.toHexString(r17) + " cid=0x" + Integer.toHexString(r18) + " event=0x" + Integer.toHexString(r110) + " values=" + e(r16, r20));
        r6.label = 1;
        r5 = r16.c(r20, r6);
        if (r5 != r8) goto L22;
        return r8;
    L7:
        r6 = new DoraBudsTxSyncMethod$executeTxSync$1(r16, r21);
        goto L8
    }
}
