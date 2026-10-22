package com.larus.dorag.widget.provider;

import a49.e;
import a49.g;
import a49.h;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.NetworkService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dorag.widget.provider.DoraWidgetDiaryProvider$Companion$requestLegacyDiaryContent$1", f = "DoraWidgetDiaryProvider.kt", i = {}, l = {142}, m = "invokeSuspend", n = {}, s = {})
final class DoraWidgetDiaryProvider$Companion$requestLegacyDiaryContent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public DoraWidgetDiaryProvider$Companion$requestLegacyDiaryContent$1(Continuation<? super DoraWidgetDiaryProvider$Companion$requestLegacyDiaryContent$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DoraWidgetDiaryProvider$Companion$requestLegacyDiaryContent$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        e r2 = null;
        boolean r3 = true;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r12);     // Catch: Exception -> L75
        Object r13 = ((Result) r12).unbox-impl();     // Catch: Exception -> L75
    L17:
        Result r14 = Result.box-impl(r13);     // Catch: Exception -> L75
    L19:
        if (r14 != null) goto L21;
    L23:
        r3 = false;
    L24:
        if (r3 == false) goto L78;
        Object r15 = r14.unbox-impl();     // Catch: Exception -> L75
        if (Result.isFailure-impl(r15) == false) goto L28;
        r15 = null;
    L28:
        h r16 = (h) r15;     // Catch: Exception -> L75
        if (r16 == null) goto L78;
        a49.a r17 = r16.a();     // Catch: Exception -> L75
        if (r17 == null) goto L33;
        r2 = r17.a();     // Catch: Exception -> L75
    L33:
        if (r2 == null) goto L78;
        String r18 = r2.d();     // Catch: Exception -> L75
        if (r18 != null) goto L40;
        r18 = r2.i();     // Catch: Exception -> L75
        if (r18 != null) goto L40;
        String r7 = "";
    L41:
        String r110 = r2.b();     // Catch: Exception -> L75
        if (r110 != null) goto L44;
        String r8 = "";
    L45:
        Long r111 = r2.f();     // Catch: Exception -> L75
        if (r111 == null) goto L51;
        String r112 = r111.toString();     // Catch: Exception -> L75
        if (r112 == null) goto L51;
        String r4 = r112;
    L52:
        Long r113 = r2.c();     // Catch: Exception -> L75
        if (r113 == null) goto L55;
        long r5 = r113.longValue();     // Catch: Exception -> L75
    L56:
        g r114 = r2.e();     // Catch: Exception -> L75
        if (r114 == null) goto L62;
        String r115 = r114.a();     // Catch: Exception -> L75
        if (r115 == null) goto L62;
        String r9 = r115;
    L63:
        g r116 = r2.e();     // Catch: Exception -> L75
        if (r116 == null) goto L69;
        String r117 = r116.b();     // Catch: Exception -> L75
        if (r117 == null) goto L69;
        String r10 = r117;
    L71:
        if (f79.a.g(r4, "", r5, r7, r8, r9, r10) == false) goto L73;
        Context r118 = AppHost.a.getApplication().getApplicationContext();     // Catch: Exception -> L75
        Intent r6 = new Intent(r118, DoraWidgetDiaryProvider.class);     // Catch: Exception -> L75
        r6.setAction("android.appwidget.action.APPWIDGET_UPDATE");     // Catch: Exception -> L75
        r6.putExtra("appWidgetIds", AppWidgetManager.getInstance(r118).getAppWidgetIds(new ComponentName(r118, DoraWidgetDiaryProvider.class)));     // Catch: Exception -> L75
        r118.sendBroadcast(r6);     // Catch: Exception -> L75
        goto L78
    L73:
        Boxing.boxBoolean(f79.a.e());     // Catch: Exception -> L75
    L69:
        r10 = "";
    L62:
        r9 = "";
        goto L63
    L55:
        r5 = System.currentTimeMillis();     // Catch: Exception -> L75
    L51:
        r4 = "";
        goto L52
    L44:
        r8 = r110;
    L40:
        r7 = r18;
    L78:
        return Unit.INSTANCE;
    L21:
        if (Result.isSuccess-impl(r14.unbox-impl()) != true) goto L23;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r12);
        IDoraService r119 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Exception -> L75
        if (r119 == null) goto L18;
        NetworkService r120 = r119.network();     // Catch: Exception -> L75
        if (r120 == null) goto L18;
        this.label = 1;     // Catch: Exception -> L75
        r13 = r120.b(this);     // Catch: Exception -> L75
        if (r13 != r0) goto L17;
        return r0;
    L18:
        r14 = null;
    L75:
        e = move-exception;
        FLogger.a.e("DoraWidgetDiaryProvider", "Error fetching diary for widget", e);
        goto L78
    }
}
