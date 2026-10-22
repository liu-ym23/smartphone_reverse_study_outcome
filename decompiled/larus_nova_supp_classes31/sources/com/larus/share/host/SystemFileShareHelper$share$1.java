package com.larus.share.host;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.share.host.SystemFileShareHelper$share$1", f = "SystemFileShareHelper.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
final class SystemFileShareHelper$share$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Function1<Integer, Unit> $listener;
    final /* synthetic */ com.larus.bmhome.share.panel.b $shareContent;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.larus.share.host.SystemFileShareHelper$share$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.share.host.SystemFileShareHelper$share$1$1", f = "SystemFileShareHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ Function1<Integer, Unit> $listener;
        final /* synthetic */ j.a $preparedShare;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(j.a r1, Function1<? super Integer, Unit> r2, Context r3, Continuation<? super AnonymousClass1> r4) {
            this.$preparedShare = r1;
            this.$listener = r2;
            this.$context = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$preparedShare, this.$listener, this.$context, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L31;
            ResultKt.throwOnFailure(r10);
            j.a r11 = this.$preparedShare;
            if (r11 != null) goto L11;
            Function1<Integer, Unit> r12 = this.$listener;
            if (r12 == null) goto L10;
            r12.invoke(Boxing.boxInt(2));
        L10:
            return Unit.INSTANCE;
        L11:
            j r1 = j.a;
            Context r2 = this.$context;
            Function1<Integer, Unit> r3 = this.$listener;
            r1.getClass();
            Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L21
            j.c(r2, r11.a);     // Catch: Throwable -> L21
            Intent r6 = new Intent("android.intent.action.SEND");     // Catch: Throwable -> L21
            r6.setType(r11.c);     // Catch: Throwable -> L21
            r6.putExtra("android.intent.extra.STREAM", r11.a);     // Catch: Throwable -> L21
            r6.setClipData(ClipData.newUri(r2.getContentResolver(), r11.b, r11.a));     // Catch: Throwable -> L21
            r6.addFlags(1);     // Catch: Throwable -> L21
            if ((!r2.getPackageManager().queryIntentActivities(r6, 65536).isEmpty()) == true) goto L16;
            if (r3 == null) goto L29;
            r3.invoke(2);     // Catch: Throwable -> L21
        L29:
            return Unit.INSTANCE;
        L16:
            Intent r7 = Intent.createChooser(r6, r11.d);     // Catch: Throwable -> L21
            r7.setClipData(r6.getClipData());     // Catch: Throwable -> L21
            r7.addFlags(1);     // Catch: Throwable -> L21
            if ((r2 instanceof Activity) == true) goto L19;
            r7.addFlags(268435456);     // Catch: Throwable -> L21
        L19:
            FLogger.a.i("SystemFileShareHelper", "start system file share mime=" + r11.c);     // Catch: Throwable -> L21
            r2.startActivity(r7);     // Catch: Throwable -> L21
            Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L21
        L23:
            Throwable r14 = Result.exceptionOrNull-impl(r13);
            if (r14 == null) goto L29;
            FLogger.a.e("SystemFileShareHelper", "start system file share failed: ".concat(r14.getClass().getSimpleName()));
            if (r3 == null) goto L29;
            r3.invoke(2);
        L21:
            th = move-exception;
            Result.Companion r4 = Result.Companion;
            r13 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L23
        L31:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SystemFileShareHelper$share$1(Context r1, com.larus.bmhome.share.panel.b r2, Function1<? super Integer, Unit> r3, Continuation<? super SystemFileShareHelper$share$1> r4) {
        this.$context = r1;
        this.$shareContent = r2;
        this.$listener = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        SystemFileShareHelper$share$1 r0 = new SystemFileShareHelper$share$1(this.$context, this.$shareContent, this.$listener, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L23:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        Context r10 = this.$context;
        com.larus.bmhome.share.panel.b r2 = this.$shareContent;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L11
        Object r11 = Result.constructor-impl(j.a(j.a, r10, r2));     // Catch: Throwable -> L11
    L13:
        Throwable r4 = Result.exceptionOrNull-impl(r11);
        if (r4 == null) goto L17;
        FLogger.a.e("SystemFileShareHelper", "prepare system file share failed: ".concat(r4.getClass().getSimpleName()));
    L17:
        if (Result.isFailure-impl(r11) == false) goto L19;
        r11 = null;
    L19:
        MainCoroutineDispatcher r5 = Dispatchers.getMain().getImmediate();
        AnonymousClass1 r6 = new AnonymousClass1((j.a) r11, this.$listener, this.$context, null);
        this.label = 1;
        if (BuildersKt.withContext(r5, r6, this) != r0) goto L23;
        return r0;
    L11:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }
}
