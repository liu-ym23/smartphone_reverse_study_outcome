package com.obric.aikernel.model_preset.impl.ipc;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.model_preset.impl.PresetDecryptIPCUtil;
import java.util.Collection;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o;

/* JADX INFO: loaded from: classes2.dex */
public final class OtherProcessDecryptUtils {
    public static final OtherProcessDecryptUtils INSTANCE = null;
    private static final String TAG = "OtherProcessDecryptUtils";
    private static final Lazy ipcAuthority$delegate = null;
    private static PresetDecryptIPCUtil myBinder;

    /* JADX INFO: renamed from: com.obric.aikernel.model_preset.impl.ipc.OtherProcessDecryptUtils$waitingDecrypting$1, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.model_preset.impl.ipc.OtherProcessDecryptUtils", f = "OtherProcessDecryptUtils.kt", i = {0, 0, 0}, l = {109}, m = "waitingDecrypting", n = {"modelNames", "binder", "$completion$iv"}, s = {"L$0", "L$1", "L$2"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ OtherProcessDecryptUtils this$0;

        AnonymousClass1(OtherProcessDecryptUtils r10, Continuation<? super AnonymousClass1> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.waitingDecrypting(null, this);
        }
    }

    static {
        INSTANCE = new OtherProcessDecryptUtils();
        ipcAuthority$delegate = LazyKt.lazy(OtherProcessDecryptUtils$ipcAuthority$2.INSTANCE);
    }

    private OtherProcessDecryptUtils() {
    }

    public static /* synthetic */ void a() {
        getBinder$lambda$15$lambda$14();
    }

    private final synchronized PresetDecryptIPCUtil getBinder() {
        monitor-enter(this);
        PresetDecryptIPCUtil r10 = myBinder;     // Catch: Throwable -> L24
        if (r10 == null) goto L27;
        Intrinsics.checkNotNull(r10);     // Catch: Throwable -> L24
        monitor-exit(this);
        return r10;
    L27:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L13
        IBinder r12 = null;
        Bundle r13 = AppContext.INSTANCE.getContext().getContentResolver().call(INSTANCE.getIpcAuthority(), PresetDecryptIPCProvider.METHOD_GET_BINDER, null, null);     // Catch: Throwable -> L13
        if (r13 == null) goto L11;
        r12 = r13.getBinder("binder");     // Catch: Throwable -> L13
    L11:
        Object r14 = Result.m32constructorimpl(PresetDecryptIPCUtil.Stub.asInterface(r12));     // Catch: Throwable -> L13
    L15:
        Throwable r15 = Result.m35exceptionOrNullimpl(r14);     // Catch: Throwable -> L24
        if (r15 == null) goto L19;
        AIKLog.INSTANCE.e(TAG, "getBinder failed: " + r15, r15);     // Catch: Throwable -> L24
    L19:
        if (Result.m39isSuccessimpl(r14) == false) goto L21;
        PresetDecryptIPCUtil r16 = (PresetDecryptIPCUtil) r14;     // Catch: Throwable -> L24
        r16.asBinder().linkToDeath(a.f4688a, 0);     // Catch: Throwable -> L24
        myBinder = r16;     // Catch: Throwable -> L24
    L21:
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L24
        Intrinsics.checkNotNullExpressionValue(r14, "runCatching {\n          …it\n        }.getOrThrow()");     // Catch: Throwable -> L24
        PresetDecryptIPCUtil r17 = (PresetDecryptIPCUtil) r14;     // Catch: Throwable -> L24
        monitor-exit(this);
        return r17;
    L13:
        th = move-exception;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L24
        r14 = Result.m32constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    private static final void getBinder$lambda$15$lambda$14() {
        myBinder = null;
    }

    private final Uri getIpcAuthority() {
        return (Uri) ipcAuthority$delegate.getValue();
    }

    public final void decryptPresetModel(Collection<String> r10) {
        Intrinsics.checkNotNullParameter(r10, "modelNames");
        AIKLog.INSTANCE.d(TAG, "decryptPresetModel: " + r10);
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L5
        INSTANCE.getBinder().decryptPresetModel(CollectionsKt.toList(r10));     // Catch: Throwable -> L5
        Object r12 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r13 = Result.m35exceptionOrNullimpl(r12);
        if (r13 == null) goto L13;
        AIKLog.INSTANCE.e(TAG, "decryptPresetModel failed: " + r13, r13);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final Object waitingDecrypting(Collection<String> r11, Continuation<? super Unit> r12) {
        if ((r12 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r10 = (AnonymousClass1) r12;
        int r13 = r10.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r10.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r10.label;
        if (r16 == 0) goto L16;
        if (r16 != 1) goto L15;
        AnonymousClass1 r17 = (AnonymousClass1) r10.L$2;
        PresetDecryptIPCUtil r18 = (PresetDecryptIPCUtil) r10.L$1;
        r11 = (Collection) r10.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L47
    L45:
        Object r19 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L47
    L49:
        Throwable r110 = Result.m35exceptionOrNullimpl(r19);
        if (r110 == null) goto L52;
        AIKLog.INSTANCE.e(TAG, "waitingDecrypting failed: " + r110, r110);
    L52:
        AIKLog.INSTANCE.d(TAG, "waitingDecrypting complete: " + r11);
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r14);
        AIKLog.INSTANCE.d(TAG, "waitingDecrypting start : " + r11);
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L47
        final PresetDecryptIPCUtil r112 = INSTANCE.getBinder();     // Catch: Throwable -> L47
        r10.L$0 = r11;     // Catch: Throwable -> L47
        r10.L$1 = r112;     // Catch: Throwable -> L47
        r10.L$2 = r10;     // Catch: Throwable -> L47
        r10.label = 1;     // Catch: Throwable -> L47
        final o r20 = new o(IntrinsicsKt.intercepted(r10), 1);     // Catch: Throwable -> L47
        r20.F();     // Catch: Throwable -> L47
        final IBinder.DeathRecipient r21 = new OtherProcessDecryptUtils$waitingDecrypting$2$1$1$linkToDeath$1(r20);     // Catch: Throwable -> L47
        r20.h(new OtherProcessDecryptUtils$waitingDecrypting$2$1$1$1(r112, r21));     // Catch: Throwable -> L47
        r112.asBinder().linkToDeath(r21, 0);     // Catch: Throwable -> L21
        Object r22 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        Throwable r23 = Result.m35exceptionOrNullimpl(r22);     // Catch: Throwable -> L47
        if (r23 == null) goto L60;
        AIKLog.INSTANCE.w(TAG, "linkToDeath failed: " + r23, r23);     // Catch: Throwable -> L47
    L60:
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L28
        r112.decryptPresetModelWithCallback(CollectionsKt.toList(r11), new OtherProcessDecryptUtils$waitingDecrypting$2$1$1$4$1(r20));     // Catch: Throwable -> L28
        Object r25 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L28
    L30:
        Throwable r26 = Result.m35exceptionOrNullimpl(r25);     // Catch: Throwable -> L47
        if (r26 == null) goto L58;
        AIKLog.INSTANCE.e(TAG, "waitingDecrypting failed: " + r26, r26);     // Catch: Throwable -> L47
    L58:
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L35
        Object r113 = Result.m32constructorimpl(Boxing.boxBoolean(r112.asBinder().unlinkToDeath(r21, 0)));     // Catch: Throwable -> L35
    L37:
        Throwable r114 = Result.m35exceptionOrNullimpl(r113);     // Catch: Throwable -> L47
        if (r114 == null) goto L40;
        AIKLog.INSTANCE.w(TAG, "unlinkToDeath failed: " + r114, r114);     // Catch: Throwable -> L47
    L40:
        Object r115 = r20.B();     // Catch: Throwable -> L47
        if (r115 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L43;
        DebugProbesKt.probeCoroutineSuspended(r10);     // Catch: Throwable -> L47
    L43:
        if (r115 != r15) goto L45;
        return r15;
    L35:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L47
        r113 = Result.m32constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L47
        goto L37
    L28:
        th = move-exception;
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L47
        r25 = Result.m32constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L47
        goto L30
    L21:
        th = move-exception;
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L47
        r22 = Result.m32constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r19 = Result.m32constructorimpl(ResultKt.createFailure(th));
    L7:
        r10 = new AnonymousClass1(this, r12);
        goto L8
    }
}
