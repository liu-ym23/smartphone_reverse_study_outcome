package com.larus.dorag.widget.provider;

import a49.c;
import a49.d;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.NetworkService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dorag.widget.provider.DoraWidgetDiaryProvider$Companion$requestBetaWidgetCard$1", f = "DoraWidgetDiaryProvider.kt", i = {}, l = {108}, m = "invokeSuspend", n = {}, s = {})
final class DoraWidgetDiaryProvider$Companion$requestBetaWidgetCard$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public DoraWidgetDiaryProvider$Companion$requestBetaWidgetCard$1(Continuation<? super DoraWidgetDiaryProvider$Companion$requestBetaWidgetCard$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DoraWidgetDiaryProvider$Companion$requestBetaWidgetCard$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = true;
        Throwable r4 = null;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r6);     // Catch: Exception -> L19
        Object r7 = ((Result) r6).unbox-impl();     // Catch: Exception -> L19
    L17:
        Result r8 = Result.box-impl(r7);     // Catch: Exception -> L19
    L22:
        if (r8 == null) goto L27;
        Object r2 = r8.unbox-impl();
        if (Result.isFailure-impl(r2) == false) goto L26;
        r2 = null;
    L26:
        c r5 = (c) r2;
    L28:
        if (r8 != null) goto L30;
    L32:
        r3 = false;
    L33:
        if (r3 == false) goto L41;
        if (r5 == null) goto L41;
        d r9 = r5.b();
        if (r9 == null) goto L38;
        boolean r10 = f79.a.d(r9);
    L39:
        if (r10 == false) goto L46;
        DoraWidgetDiaryProvider$a.a r11 = DoraWidgetDiaryProvider.a;
        Context r12 = AppHost.a.getApplication().getApplicationContext();
        Intent r13 = new Intent(r12, DoraWidgetDiaryProvider.class);
        r13.setAction("android.appwidget.action.APPWIDGET_UPDATE");
        r13.putExtra("appWidgetIds", AppWidgetManager.getInstance(r12).getAppWidgetIds(new ComponentName(r12, DoraWidgetDiaryProvider.class)));
        r12.sendBroadcast(r13);
    L46:
        return Unit.INSTANCE;
    L38:
        r10 = f79.a.a();
    L41:
        FLogger r14 = FLogger.a;
        StringBuilder r15 = new StringBuilder("fetch diary beta widget card failed, keep cached content: ");
        if (r8 == null) goto L44;
        r4 = Result.exceptionOrNull-impl(r8.unbox-impl());
    L44:
        r15.append(r4);
        r14.w("DoraWidgetDiaryProvider", r15.toString());
        Boxing.boxBoolean(f79.a.e());
        goto L46
    L30:
        if (Result.isSuccess-impl(r8.unbox-impl()) != true) goto L32;
    L27:
        r5 = null;
        goto L28
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
        IDoraService r16 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Exception -> L19
        if (r16 == null) goto L21;
        NetworkService r17 = r16.network();     // Catch: Exception -> L19
        if (r17 == null) goto L21;
        List r18 = CollectionsKt.listOf("widget");     // Catch: Exception -> L19
        this.label = 1;     // Catch: Exception -> L19
        r7 = r17.a(r18, this);     // Catch: Exception -> L19
        if (r7 != r0) goto L17;
        return r0;
    L21:
        r8 = null;
    L19:
        e = move-exception;
        FLogger.a.e("DoraWidgetDiaryProvider", "Error fetching diary beta widget card", e);
        goto L21
    }
}
