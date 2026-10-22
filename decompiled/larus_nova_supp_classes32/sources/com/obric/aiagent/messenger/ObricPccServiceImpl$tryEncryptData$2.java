package com.obric.aiagent.messenger;

import com.bytedance.privacy.pcc.PccManager;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.ObricPccServiceImpl$tryEncryptData$2", f = "ObricPccServiceImpl.kt", i = {0, 0, 1, 1, 2, 2, 2, 3, 3, 3}, l = {360, 155, 370, 171}, m = "invokeSuspend", n = {"$this$withContext", "$this$withLock_u24default$iv", "$this$withContext", "$this$withLock_u24default$iv", "$this$withContext", "job", "$this$withLock_u24default$iv", "$this$withContext", "job", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
public final class ObricPccServiceImpl$tryEncryptData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ byte[] $data;
    final /* synthetic */ String $messageId;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ ObricPccServiceImpl this$0;

    public ObricPccServiceImpl$tryEncryptData$2(ObricPccServiceImpl r1, String r2, byte[] r3, Continuation<? super ObricPccServiceImpl$tryEncryptData$2> r4) {
        this.this$0 = r1;
        this.$messageId = r2;
        this.$data = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        ObricPccServiceImpl$tryEncryptData$2 r0 = new ObricPccServiceImpl$tryEncryptData$2(this.this$0, this.$messageId, this.$data, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = this.label;
        boolean r8 = false;
        Integer r10 = null;
        if (r3 == 0) goto L22;
        if (r3 == 1) goto L21;
        if (r3 == 2) goto L16;
        if (r3 == 3) goto L15;
        if (r3 != 4) goto L14;
        String r4 = (String) this.L$4;
        ObricPccServiceImpl r5 = (ObricPccServiceImpl) this.L$3;
        kotlinx.coroutines.sync.a r6 = (kotlinx.coroutines.sync.a) this.L$2;
        CompletableDeferred r7 = (CompletableDeferred) this.L$1;
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L11
        kotlinx.coroutines.sync.a r11 = r6;
        Object r12 = r18;
    L70:
        if (((Boolean) r12).booleanValue() == true) goto L77;
        FLogger.a.e("ObricPccServiceImpl", "tryEncryptData " + r4 + " failed, currSessionId: " + r5.i);     // Catch: Throwable -> L102
        ConcurrentHashMap<String, String> r13 = f.a;     // Catch: Throwable -> L102
        StringBuilder r14 = new StringBuilder("openSecuritySession failed, currSessionId: ");     // Catch: Throwable -> L102
        r14.append(r5.i);     // Catch: Throwable -> L102
        r14.append(", appInfo is null: ");     // Catch: Throwable -> L102
        if (r5.e != null) goto L74;
        r8 = true;
    L74:
        r14.append(r8);     // Catch: Throwable -> L102
        f.a(r4, r14.toString());     // Catch: Throwable -> L102
        f.b(r4);     // Catch: Throwable -> L102
        r11.unlock(null);
        return null;
    L102:
        th = th;
        r6 = r11;
    L104:
        r6.unlock(null);
        throw th;
    L77:
        r6 = r11;
        r5.l.add(r7);     // Catch: Throwable -> L11
        String r0 = r5.i;     // Catch: Throwable -> L11
        r6.unlock(null);
        if (r0 != null) goto L118;
        String r1 = this.$messageId;
        f.a(r1, "sessionId is null after mutex lock");
        f.b(r1);
        return null;
    L118:
        long r15 = System.currentTimeMillis();     // Catch: Throwable -> L99
        PccManager r16 = this.this$0.g;     // Catch: Throwable -> L99
        if (r16 == null) goto L86;
        String r17 = r16.dataEncrypt(r0, this.$data);     // Catch: Throwable -> L99
    L87:
        FLogger r19 = FLogger.a;     // Catch: Throwable -> L99
        StringBuilder r20 = new StringBuilder("tryEncryptData ");     // Catch: Throwable -> L99
        r20.append(this.$messageId);     // Catch: Throwable -> L99
        r20.append(" res=");     // Catch: Throwable -> L99
        if (r17 == null) goto L90;
        r10 = Boxing.boxInt(r17.length());     // Catch: Throwable -> L99
    L90:
        r20.append(r10);     // Catch: Throwable -> L99
        r20.append(", cost=");     // Catch: Throwable -> L99
        r20.append(System.currentTimeMillis() - r15);     // Catch: Throwable -> L99
        r19.i("ObricPccServiceImpl", r20.toString());     // Catch: Throwable -> L99
        if (r17 != null) goto L93;
    L94:
        r8 = true;
    L95:
        if (r8 == false) goto L97;
        ConcurrentHashMap<String, String> r21 = f.a;     // Catch: Throwable -> L99
        f.a(this.$messageId, "dataEncrypt failed, encryptedData is null");     // Catch: Throwable -> L99
    L97:
        ConcurrentHashMap<String, String> r22 = f.a;
        f.b(this.$messageId);
        r7.complete(Unit.INSTANCE);
        this.this$0.l.remove(r7);
        return r17;
    L93:
        if (r17.length() != 0) goto L95;
    L86:
        r17 = null;
    L99:
        th = move-exception;
        ConcurrentHashMap<String, String> r23 = f.a;
        f.b(this.$messageId);
        r7.complete(Unit.INSTANCE);
        this.this$0.l.remove(r7);
        throw th;
    L11:
        th = th;
        goto L104
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r24 = (String) this.L$4;
        ObricPccServiceImpl r25 = (ObricPccServiceImpl) this.L$3;
        r11 = (kotlinx.coroutines.sync.a) this.L$2;
        CompletableDeferred r110 = (CompletableDeferred) this.L$1;
        CoroutineScope r111 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r18);
        String r112 = r24;
        r5 = r25;
        r7 = r110;
    L112:
        String r113 = r5.i;     // Catch: Throwable -> L102
        if (r113 != null) goto L60;
    L63:
        boolean r114 = true;
    L64:
        if (r114 == false) goto L77;
        this.L$0 = r111;     // Catch: Throwable -> L102
        this.L$1 = r7;     // Catch: Throwable -> L102
        this.L$2 = r11;     // Catch: Throwable -> L102
        this.L$3 = r5;     // Catch: Throwable -> L102
        this.L$4 = r112;     // Catch: Throwable -> L102
        this.label = 4;     // Catch: Throwable -> L102
        r12 = ObricPccServiceImpl.e(r5, this);     // Catch: Throwable -> L102
        if (r12 != r2) goto L68;
        return r2;
    L68:
        r4 = r112;
        goto L70
    L60:
        if (r113.length() == 0) goto L63;
        r114 = false;
        goto L64
    L16:
        String r26 = (String) this.L$2;
        kotlinx.coroutines.sync.a r27 = (kotlinx.coroutines.sync.a) this.L$1;
        CoroutineScope r115 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L19
        kotlinx.coroutines.sync.a r116 = r27;
        Object r28 = r18;
    L42:
        String r29 = (String) r28;     // Catch: Throwable -> L108
        if (r29 == null) goto L45;
        f.a(r26, r29);     // Catch: Throwable -> L108
    L108:
        th = th;
        r27 = r116;
    L110:
        r27.unlock(null);
        throw th;
    L45:
        CoroutineScope r117 = r115;
    L37:
        r27 = r116;
        Unit r30 = Unit.INSTANCE;     // Catch: Throwable -> L19
        r27.unlock(null);
        if (this.this$0.d == true) goto L50;
    L106:
        FLogger.a.e("ObricPccServiceImpl", "tryEncryptData " + this.$messageId + " failed, isInit=" + this.this$0.d + ", pccManager=" + this.this$0.g);
        ConcurrentHashMap<String, String> r31 = f.a;
        f.b(this.$messageId);
        return null;
    L50:
        if (this.this$0.g == null) goto L106;
        r111 = r117;
    L53:
        CompletableDeferred r32 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        ObricPccServiceImpl r33 = this.this$0;
        kotlinx.coroutines.sync.a r118 = r33.k;
        r112 = this.$messageId;
        this.L$0 = r111;
        this.L$1 = r32;
        this.L$2 = r118;
        this.L$3 = r33;
        this.L$4 = r112;
        this.label = 3;
        if (r118.a(null, this) != r2) goto L56;
        return r2;
    L56:
        r7 = r32;
        r5 = r33;
        r11 = r118;
    L19:
        th = th;
        goto L110
    L21:
        r26 = (String) this.L$3;
        ObricPccServiceImpl r119 = (ObricPccServiceImpl) this.L$2;
        r116 = (kotlinx.coroutines.sync.a) this.L$1;
        r117 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r18);
    L116:
        if (r119.d == true) goto L35;
    L38:
        this.L$0 = r117;     // Catch: Throwable -> L108
        this.L$1 = r116;     // Catch: Throwable -> L108
        this.L$2 = r26;     // Catch: Throwable -> L108
        this.L$3 = null;     // Catch: Throwable -> L108
        this.label = 2;     // Catch: Throwable -> L108
        r28 = r119.f(this);     // Catch: Throwable -> L108
        if (r28 != r2) goto L41;
        return r2;
    L41:
        r115 = r117;
        goto L42
    L35:
        if (r119.g != null) goto L37;
    L22:
        ResultKt.throwOnFailure(r18);
        CoroutineScope r34 = (CoroutineScope) this.L$0;
        if (this.this$0.d == true) goto L25;
    L28:
        r119 = this.this$0;
        r116 = r119.k;
        String r120 = this.$messageId;
        this.L$0 = r34;
        this.L$1 = r116;
        this.L$2 = r119;
        this.L$3 = r120;
        this.label = 1;
        if (r116.a(null, this) != r2) goto L31;
        return r2;
    L31:
        r117 = r34;
        r26 = r120;
        goto L116
    L25:
        if (this.this$0.g == null) goto L28;
        r111 = r34;
        goto L53
    }
}
