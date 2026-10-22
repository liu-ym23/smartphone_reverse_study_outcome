package com.ss.android.lark.officesdk.minutes.service.fileupload;

import com.ss.android.lark.officesdk.minutes.api.fileupload.MmMinutesFileUploadErrorCode;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.fileupload.MmMinutesFileUploadSessionManager$buildUploadCallback$1$onSuccess$1", f = "MmMinutesFileUploadSessionManager.kt", i = {0, 0, 0, 2}, l = {2297, 1466, 2310}, m = "invokeSuspend", n = {"$this$launchFileUpload", "shouldCompleteAfterResume", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$0"})
public final class MmMinutesFileUploadSessionManager$buildUploadCallback$1$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ fub.e $result;
    final /* synthetic */ String $taskId;
    final /* synthetic */ String $uploadTaskId;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ MmMinutesFileUploadSessionManager this$0;

    public MmMinutesFileUploadSessionManager$buildUploadCallback$1$onSuccess$1(MmMinutesFileUploadSessionManager r1, String r2, String r3, fub.e r4, Continuation<? super MmMinutesFileUploadSessionManager$buildUploadCallback$1$onSuccess$1> r5) {
        this.this$0 = r1;
        this.$taskId = r2;
        this.$uploadTaskId = r3;
        this.$result = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        MmMinutesFileUploadSessionManager$buildUploadCallback$1$onSuccess$1 r6 = new MmMinutesFileUploadSessionManager$buildUploadCallback$1$onSuccess$1(this.this$0, this.$taskId, this.$uploadTaskId, this.$result, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = this.label;
        if (r3 == 0) goto L15;
        if (r3 == 1) goto L14;
        if (r3 == 2) goto L10;
        if (r3 != 3) goto L9;
        String r0 = (String) this.L$2;
        MmMinutesFileUploadSessionManager r4 = (MmMinutesFileUploadSessionManager) this.L$1;
        kotlinx.coroutines.sync.a r5 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r20);
    L98:
        MmMinutesFileUploadSessionManager.e r1 = r4.p.get(r0);     // Catch: Throwable -> L86
        if (r1 == null) goto L84;
        r1.s = false;     // Catch: Throwable -> L86
    L84:
        r4.w();     // Catch: Throwable -> L86
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L86
        r5.unlock(null);
    L90:
        return Unit.INSTANCE;
    L86:
        th = move-exception;
        r5.unlock(null);
        throw th;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r20);     // Catch: Throwable -> L12
    L68:
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L71:
        MmMinutesFileUploadSessionManager r8 = this.this$0;
        String r11 = this.$taskId;
        Throwable r9 = Result.exceptionOrNull-impl(r7);
        if (r9 == null) goto L77;
        lvb.a.b(r8.d, "uploadCallback.onSuccess: complete after resume failed, taskId=" + r11 + ", err=" + r9);
        MmMinutesFileUploadErrorCode r12 = MmMinutesFileUploadErrorCode.FINISH_REQUEST_ERROR;
        String r10 = r9.getMessage();
        if (r10 != null) goto L76;
        r10 = "";
    L76:
        r8.r("updateToErrorAsync", new MmMinutesFileUploadSessionManager$updateToErrorAsync$1(r8, r11, r12, r10, null, null));
    L77:
        MmMinutesFileUploadSessionManager r13 = this.this$0;
        r5 = r13.g;
        String r14 = this.$taskId;
        this.L$0 = r5;
        this.L$1 = r13;
        this.L$2 = r14;
        this.L$3 = null;
        this.L$4 = null;
        this.L$5 = null;
        this.L$6 = null;
        this.label = 3;
        if (r5.a(null, this) != r2) goto L80;
        return r2;
    L80:
        r4 = r13;
        r0 = r14;
        goto L98
    L14:
        fub.e r15 = (fub.e) this.L$6;
        String r16 = (String) this.L$5;
        String r17 = (String) this.L$4;
        MmMinutesFileUploadSessionManager r18 = (MmMinutesFileUploadSessionManager) this.L$3;
        kotlinx.coroutines.sync.a r19 = (kotlinx.coroutines.sync.a) this.L$2;
        Ref.BooleanRef r110 = (Ref.BooleanRef) this.L$1;
        CoroutineScope r111 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r20);
    L94:
        MmMinutesFileUploadSessionManager.e r112 = r18.p.get(r17);     // Catch: Throwable -> L91
        if (r112 != null) goto L23;
    L61:
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L91
        r19.unlock(null);
        if (r110.element == false) goto L90;
        MmMinutesFileUploadSessionManager r22 = this.this$0;
        String r23 = this.$taskId;
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L12
        this.L$0 = null;     // Catch: Throwable -> L12
        this.L$1 = null;     // Catch: Throwable -> L12
        this.L$2 = null;     // Catch: Throwable -> L12
        this.L$3 = null;     // Catch: Throwable -> L12
        this.L$4 = null;     // Catch: Throwable -> L12
        this.L$5 = null;     // Catch: Throwable -> L12
        this.L$6 = null;     // Catch: Throwable -> L12
        this.label = 2;     // Catch: Throwable -> L12
        if (r22.m(r23, this) != r2) goto L68;
        return r2;
    L23:
        if (r112.c(r16) == true) goto L25;
        lvb.a.e(r18.d, "uploadCallback.onSuccess: skip stale callback. taskId=" + r17 + ", uploadTaskId=" + r16);     // Catch: Throwable -> L91
        goto L61
    L25:
        Intrinsics.checkNotNullParameter(r16, "uploadTaskId");     // Catch: Throwable -> L91
        r112.l.remove(r16);     // Catch: Throwable -> L91
        r112.k.remove(r16);     // Catch: Throwable -> L91
        r112.f.put(r16, Boxing.boxBoolean(true));     // Catch: Throwable -> L91
        r112.i.put(r16, r15.a);     // Catch: Throwable -> L91
        r112.j.put(r16, Boxing.boxInt(100));     // Catch: Throwable -> L91
        Long r25 = (Long) ((LinkedHashMap) r112.h).get(r16);     // Catch: Throwable -> L91
        if (r25 != null) goto L30;
        r25 = (Long) ((LinkedHashMap) r112.g).get(r16);     // Catch: Throwable -> L91
        if (r25 != null) goto L30;
        long r113 = 0;
    L32:
        r112.h.put(r16, Boxing.boxLong(r113));     // Catch: Throwable -> L91
        r112.g.put(r16, Boxing.boxLong(r113));     // Catch: Throwable -> L91
        if (r113 <= 0) goto L35;
        MmMinutesFileUploadSessionManager.g(r18, r17, r112);     // Catch: Throwable -> L91
    L37:
        if ((!((ArrayList) r112.e).isEmpty()) == false) goto L52;
        List<String> r26 = r112.e;     // Catch: Throwable -> L91
        if ((r26 instanceof Collection) == true) goto L41;
    L43:
        Iterator r27 = ((ArrayList) r26).iterator();     // Catch: Throwable -> L91
    L45:
        if (r27.hasNext() == false) goto L49;
        if (Intrinsics.areEqual(((LinkedHashMap) r112.f).get((String) r27.next()), Boxing.boxBoolean(true)) == true) goto L45;
        boolean r28 = false;
    L50:
        if (r28 == false) goto L52;
        boolean r29 = true;
    L53:
        if (r29 == false) goto L60;
        lvb.a.e(r18.d, "uploadCallback.onSuccess: all uploads done. taskId=" + r17);     // Catch: Throwable -> L91
        CompletableDeferred<Unit> r30 = r112.r;     // Catch: Throwable -> L91
        if (r30 == null) goto L58;
        r30.complete(Unit.INSTANCE);     // Catch: Throwable -> L91
        r112.r = null;     // Catch: Throwable -> L91
        goto L60
    L58:
        if (r112.s == true) goto L60;
        r112.s = true;     // Catch: Throwable -> L91
        r110.element = true;     // Catch: Throwable -> L91
    L60:
        r18.w();     // Catch: Throwable -> L91
    L49:
        r28 = true;
        goto L50
    L41:
        if (((ArrayList) r26).isEmpty() == false) goto L43;
    L52:
        r29 = false;
        goto L53
    L35:
        MmMinutesFileUploadSessionManager.f(r18, r17, r112);     // Catch: Throwable -> L91
    L30:
        r113 = r25.longValue();     // Catch: Throwable -> L91
    L91:
        th = move-exception;
        r19.unlock(null);
        throw th;
    L15:
        ResultKt.throwOnFailure(r20);
        CoroutineScope r31 = (CoroutineScope) this.L$0;
        r110 = new Ref.BooleanRef();
        r18 = this.this$0;
        r19 = r18.g;
        r17 = this.$taskId;
        r16 = this.$uploadTaskId;
        fub.e r114 = this.$result;
        this.L$0 = r31;
        this.L$1 = r110;
        this.L$2 = r19;
        this.L$3 = r18;
        this.L$4 = r17;
        this.L$5 = r16;
        this.L$6 = r114;
        this.label = 1;
        if (r19.a(null, this) != r2) goto L18;
        return r2;
    L18:
        r15 = r114;
    L12:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L71
    }
}
