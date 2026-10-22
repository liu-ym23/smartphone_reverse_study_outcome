package com.larus.dora.impl;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.network.DoraNetworkApi;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import o59.a;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.DoraServiceImpl$handleAppAtomicFunctions$1", f = "DoraServiceImpl.kt", i = {0, 0, 0, 1}, l = {547, 570}, m = "invokeSuspend", n = {"device", "results", "destination$iv$iv", "overallCode"}, s = {"L$0", "L$1", "L$4", "I$0"})
final class DoraServiceImpl$handleAppAtomicFunctions$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ JSONArray $jsonRpcRequests;
    final /* synthetic */ String $reqId;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ DoraServiceImpl this$0;

    public DoraServiceImpl$handleAppAtomicFunctions$1(String r1, JSONArray r2, DoraServiceImpl r3, Continuation<? super DoraServiceImpl$handleAppAtomicFunctions$1> r4) {
        this.$reqId = r1;
        this.$jsonRpcRequests = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraServiceImpl$handleAppAtomicFunctions$1(this.$reqId, this.$jsonRpcRequests, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00fc -> B:24:0x0102). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        int r7 = 0;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        int r3 = this.I$0;
        ResultKt.throwOnFailure(r18);
        Object r4 = ((Result) r18).unbox-impl();
        DoraServiceImpl$handleAppAtomicFunctions$1 r15 = this;
    L61:
        String r5 = r15.$reqId;
        if (Result.isSuccess-impl(r4) == false) goto L64;
        ((Boolean) r4).booleanValue();
        FLogger.a.i("DoraServiceImpl", "handleAppAtomicFunctions: callback success, reqId=" + r5 + ", code=" + r3);
    L64:
        String r6 = r15.$reqId;
        Throwable r8 = Result.exceptionOrNull-impl(r4);
        if (r8 == null) goto L68;
        FLogger.a.e("DoraServiceImpl", "handleAppAtomicFunctions: callback failed, reqId=" + r6 + ", code=" + r3, r8);
    L68:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Collection r9 = (Collection) this.L$6;
        Iterator r10 = (Iterator) this.L$5;
        Collection r11 = (Collection) this.L$4;
        JSONArray r12 = (JSONArray) this.L$3;
        DoraServiceImpl r13 = (DoraServiceImpl) this.L$2;
        JSONArray r14 = (JSONArray) this.L$1;
        DoraDevice r16 = (DoraDevice) this.L$0;
        ResultKt.throwOnFailure(r18);
        Object r17 = r18;
        DoraDevice r110 = r16;
        JSONArray r111 = r14;
        DoraServiceImpl r112 = r13;
        JSONArray r113 = r12;
        DoraServiceImpl$handleAppAtomicFunctions$1 r114 = this;
    L24:
        r9.add((DoraServiceImpl$a) r17);
        r9 = r11;
        DoraServiceImpl$handleAppAtomicFunctions$1 r20 = r114;
        JSONArray r115 = r113;
        DoraServiceImpl r116 = r112;
        JSONArray r117 = r111;
        DoraDevice r118 = r110;
    L19:
        if (r10.hasNext() == false) goto L25;
        JSONObject r119 = r115.optJSONObject(((IntIterator) r10).nextInt());
        r20.L$0 = r118;
        r20.L$1 = r117;
        r20.L$2 = r116;
        r20.L$3 = r115;
        r20.L$4 = r9;
        r20.L$5 = r10;
        r20.L$6 = r9;
        r20.label = 1;
        r17 = DoraServiceImpl.n1(r116, r119, r118, r20);
        if (r17 != r1) goto L23;
        return r1;
    L23:
        r110 = r118;
        r111 = r117;
        r112 = r116;
        r113 = r115;
        r114 = r20;
        r11 = r9;
        goto L24
    L25:
        DoraServiceImpl$handleAppAtomicFunctions$1 r120 = r20;
        List r21 = (List) r9;
        DoraDevice r22 = r118;
        JSONArray r121 = r117;
    L26:
        List r23 = r21;
        Iterator r24 = r23.iterator();
    L28:
        if (r24.hasNext() == false) goto L30;
        DoraServiceImpl$a r122 = (DoraServiceImpl$a) r24.next();
        r122.getClass();
        JSONObject r123 = new JSONObject();
        r123.put("jsonrpc", "2.0");
        r123.put("result", r122.c);
        r123.put("id", r122.a);
        r121.put(r123);
        goto L28
    L30:
        if (r22 != null) goto L33;
        FLogger.a.w("DoraServiceImpl", "handleAppAtomicFunctions: skip callback because current device is unavailable, code=5020");
        return Unit.INSTANCE;
    L33:
        String r25 = a.A(r22.getSerialNumber(), r22.mac, Boxing.boxInt(r22.productId));
        if (r25 != null) goto L36;
        String r124 = "";
    L38:
        if (r124.length() != 0) goto L40;
        boolean r26 = true;
    L41:
        if (r26 == false) goto L44;
        FLogger.a.e("DoraServiceImpl", "handleAppAtomicFunctions: skip callback because wDid is empty");
        return Unit.INSTANCE;
    L44:
        Iterator r27 = r23.iterator();
    L46:
        if (r27.hasNext() == false) goto L53;
        Object r28 = r27.next();
        if (((DoraServiceImpl$a) r28).b == 0) goto L50;
        boolean r125 = true;
    L51:
        if (r125 == false) goto L46;
    L54:
        DoraServiceImpl$a r30 = (DoraServiceImpl$a) r28;
        if (r30 == null) goto L57;
        r7 = r30.b;
    L57:
        DoraNetworkApi r31 = DoraNetworkApi.a;
        String r32 = String.valueOf(r22.productId);
        String r126 = r120.$reqId;
        r120.L$0 = null;
        r120.L$1 = null;
        r120.L$2 = null;
        r120.L$3 = null;
        r120.L$4 = null;
        r120.L$5 = null;
        r120.L$6 = null;
        r120.I$0 = r7;
        r120.label = 2;
        DoraServiceImpl$handleAppAtomicFunctions$1 r33 = r120;
        Object r34 = r31.b(r32, r124, r126, r7, r121, null, r120);
        if (r34 != r1) goto L60;
        return r1;
    L60:
        r15 = r33;
        r4 = r34;
        r3 = r7;
        goto L61
    L50:
        r125 = false;
        goto L51
    L53:
        r28 = null;
        goto L54
    L40:
        r26 = false;
        goto L41
    L36:
        r124 = r25;
        goto L38
    L10:
        ResultKt.throwOnFailure(r18);
        r22 = DoraAdapterExtKt.i(kj4.a.g(), false);
        FLogger r35 = FLogger.a;
        StringBuilder r36 = new StringBuilder("handleAppAtomicFunctions: receive reqId=");
        r36.append(this.$reqId);
        r36.append(", requestCount=");
        r36.append(this.$jsonRpcRequests.length());
        r36.append(", hasCurrentDevice=");
        if (r22 == null) goto L13;
        boolean r127 = true;
    L14:
        r36.append(r127);
        r35.d("DoraServiceImpl", r36.toString());
        JSONArray r37 = new JSONArray();
        if (this.$jsonRpcRequests.length() != 0) goto L17;
        r21 = CollectionsKt.listOf(new DoraServiceImpl$a("", -1, "invalid_request"));
        r120 = this;
        r121 = r37;
        goto L26
    L17:
        IntRange r38 = RangesKt.until(0, this.$jsonRpcRequests.length());
        DoraServiceImpl r128 = this.this$0;
        JSONArray r129 = this.$jsonRpcRequests;
        r118 = r22;
        r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r38, 10));
        r117 = r37;
        r10 = r38.iterator();
        r20 = this;
        r116 = r128;
        r115 = r129;
        goto L19
    L13:
        r127 = false;
        goto L14
    }
}
