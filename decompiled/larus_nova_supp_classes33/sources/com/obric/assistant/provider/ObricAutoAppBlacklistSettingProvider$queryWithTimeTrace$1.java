package com.obric.assistant.provider;

import android.database.Cursor;
import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.reporter.IObricReporter;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.provider.ObricAutoAppBlacklistSettingProvider$queryWithTimeTrace$1", f = "ObricAutoAppBlacklistSettingProvider.kt", i = {0}, l = {151}, m = "invokeSuspend", n = {"startTime"}, s = {"J$0"})
public final class ObricAutoAppBlacklistSettingProvider$queryWithTimeTrace$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Cursor>, Object> $block;
    final /* synthetic */ String $methodName;
    final /* synthetic */ CompletableDeferred<Cursor> $result;
    long J$0;
    int label;
    final /* synthetic */ ObricAutoAppBlacklistSettingProvider this$0;

    public ObricAutoAppBlacklistSettingProvider$queryWithTimeTrace$1(String r1, Function1<? super Continuation<? super Cursor>, ? extends Object> r2, CompletableDeferred<Cursor> r3, ObricAutoAppBlacklistSettingProvider r4, Continuation<? super ObricAutoAppBlacklistSettingProvider$queryWithTimeTrace$1> r5) {
        this.$methodName = r1;
        this.$block = r2;
        this.$result = r3;
        this.this$0 = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ObricAutoAppBlacklistSettingProvider$queryWithTimeTrace$1(this.$methodName, this.$block, this.$result, this.this$0, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 != 1) goto L11;
        long r2 = this.J$0;
        ResultKt.throwOnFailure(r15);     // Catch: Exception -> L8
    L17:
        Cursor r16 = (Cursor) r15;     // Catch: Exception -> L8
        long r10 = SystemClock.elapsedRealtime() - r2;     // Catch: Exception -> L8
        this.$result.complete(r16);     // Catch: Exception -> L8
        FLogger.a.i("ObricAutoAppBlacklistSettingProvider", "query, " + this.$methodName + ", end, cost = " + r10 + "ms, " + r16);     // Catch: Exception -> L8
        ObricAutoAppBlacklistSettingProvider r17 = this.this$0;     // Catch: Exception -> L8
        String r9 = this.$methodName;     // Catch: Exception -> L8
        List r3 = ObricAutoAppBlacklistSettingProvider.b;     // Catch: Exception -> L8
        r17.getClass();     // Catch: Exception -> L8
        IObricReporter.a.getClass();     // Catch: Exception -> L8
        IObricReporter r7 = IObricReporter.a.a();     // Catch: Exception -> L8
        if (r7 == null) goto L27;
        IObricReporter.b.a(r7, "OAuto_Settings", r9, r10, true, 16);     // Catch: Exception -> L8
    L27:
        return Unit.INSTANCE;
    L8:
        e = e;
        long r5 = r2;
    L23:
        long r11 = SystemClock.elapsedRealtime() - r5;
        this.$result.complete(null);
        FLogger.a.e("ObricAutoAppBlacklistSettingProvider", "query, " + this.$methodName + ", failed, cost = " + r11 + "ms", e);
        ObricAutoAppBlacklistSettingProvider r18 = this.this$0;
        String r12 = this.$methodName;
        List r4 = ObricAutoAppBlacklistSettingProvider.b;
        r18.getClass();
        IObricReporter.a.getClass();
        IObricReporter r8 = IObricReporter.a.a();
        if (r8 == null) goto L27;
        IObricReporter.b.a(r8, "OAuto_Settings", r12, r11, false, 16);
        goto L27
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r15);
        r5 = SystemClock.elapsedRealtime();
        FLogger.a.i("ObricAutoAppBlacklistSettingProvider", "query, " + this.$methodName + ", start");     // Catch: Exception -> L22
        Function1<Continuation<? super Cursor>, Object> r19 = this.$block;     // Catch: Exception -> L22
        this.J$0 = r5;     // Catch: Exception -> L22
        this.label = 1;     // Catch: Exception -> L22
        r15 = r19.invoke(this);     // Catch: Exception -> L22
        if (r15 != r0) goto L16;
        return r0;
    L16:
        r2 = r5;
    L22:
        e = e;
        goto L23
    }
}
