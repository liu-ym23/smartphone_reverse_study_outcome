package com.larus.voicecall.impl.museum;

import android.app.Application;
import com.ixigua.lib.track.TrackParams;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONException;
import org.json.JSONObject;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.museum.MuseumExtensionDispatcher$pickExtension$1", f = "MuseumExtensionDispatcher.kt", i = {}, l = {270}, m = "invokeSuspend", n = {}, s = {})
public final class MuseumExtensionDispatcher$pickExtension$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ a $banner;
    final /* synthetic */ Function2<String, j, Unit> $onPickResult;
    final /* synthetic */ Function0<RealtimeCallParam> $paramsProvider;
    final /* synthetic */ boolean $sendLongLinkAfterSuccess;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public MuseumExtensionDispatcher$pickExtension$1(a r1, boolean r2, Function0<RealtimeCallParam> r3, Function2<? super String, ? super j, Unit> r4, Continuation<? super MuseumExtensionDispatcher$pickExtension$1> r5) {
        this.$banner = r1;
        this.$sendLongLinkAfterSuccess = r2;
        this.$paramsProvider = r3;
        this.$onPickResult = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MuseumExtensionDispatcher$pickExtension$1(this.$banner, this.$sendLongLinkAfterSuccess, this.$paramsProvider, this.$onPickResult, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r3 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L11:
        j r10 = (j) r9;
        FLogger r2 = FLogger.a;
        r2.i("MuseumExtensionDebug", "[shortLink][result] stage=" + this.$banner.e + ", museum=" + this.$banner.d + ", success=" + r10.a + ", msg=" + r10.b + ", grantDuration=" + r10.c + ", failReason=" + r10.d + ", sendLongLinkAfterSuccess=" + this.$sendLongLinkAfterSuccess);
        String r4 = r10.b;
        if (r4 != null) goto L14;
    L17:
        boolean r5 = true;
    L19:
        if ((true ^ r5) == true) goto L22;
        r4 = null;
    L22:
        if (r4 != null) goto L29;
        Application r6 = AppHost.a.getApplication();
        if (r10.a == false) goto L26;
        int r7 = 2131907901;
    L27:
        r4 = r6.getString(r7);
        goto L29
    L26:
        r7 = 2131907899;
    L29:
        if (r10.a == false) goto L31;
        r2.i("MuseumExtensionDebug", "[toast][show][attempt] type=success, stage=" + this.$banner.e + ", text=" + r4 + ", context=AppHost.application");
        s r8 = s.a;
        Application r11 = AppHost.a.getApplication();
        r8.getClass();
        s.p(r11, r4);
        r2.i("MuseumExtensionDebug", "[toast][show][called] type=success, stage=" + this.$banner.e);
    L32:
        int r12 = g.a;
        Function0<RealtimeCallParam> r13 = this.$paramsProvider;
        if (r13 == null) goto L35;
        RealtimeCallParam r14 = (RealtimeCallParam) r13.invoke();
    L36:
        a r15 = this.$banner;
        String r16 = r15.j;
        String r17 = r15.e;
        boolean r18 = r10.a;
        String r19 = r10.d;
        Long r20 = r10.c;
        if (r20 != null) goto L41;
        if (r18 == false) goto L40;
        r20 = Boxing.boxLong(3600);
        goto L41
    L40:
        r20 = null;
    L41:
        Intrinsics.checkNotNullParameter(r17, "stage");
        if (f.a() == false) goto L62;
        if (r16 != null) goto L47;
        if (r14 == null) goto L48;
        r3 = r14.e;
    L48:
        String r21 = e.c(r17);
        Integer r22 = Integer.valueOf(r18 ? 1 : 0);
        JSONObject r23 = new JSONObject();
        Intrinsics.checkNotNullParameter(r23, LynxResourceModule.PARAMS_KEY);
        if (r3 != null) goto L67;
    L51:
        r23.put("trigger_scene", r21);     // Catch: JSONException -> L59
        r23.put("card_type", "museum_extension");     // Catch: JSONException -> L59
        if (r22 == null) goto L54;
        r23.put("success", r22.intValue());     // Catch: JSONException -> L59
    L54:
        if (r19 == null) goto L56;
        r23.put("fail_reason", r19);     // Catch: JSONException -> L59
    L56:
        if (r20 == null) goto L61;
        r23.put("grant_duration", r20.longValue());     // Catch: JSONException -> L59
    L59:
        e = move-exception;
        FLogger.a.e("RealtimeEventHelper", "error in RealtimeEventHelper mobMuseumCardReceiveResult " + e.getLocalizedMessage());
    L61:
        TrackParams r24 = new TrackParams().merge(r23);
        by7.a r25 = new by7.a("museum_card_receive_result");
        r25.a.merge(r24);
        r25.b();
        goto L62
    L67:
        r23.put("call_id", r3);     // Catch: JSONException -> L59
        goto L51
    L47:
        r3 = r16;
    L62:
        Function2<String, j, Unit> r26 = this.$onPickResult;
        if (r26 == null) goto L66;
        r26.invoke(this.$banner.e, r10);
    L66:
        return Unit.INSTANCE;
    L35:
        r14 = null;
        goto L36
    L31:
        r2.i("MuseumExtensionDebug", "[toast][show][attempt] type=warning, stage=" + this.$banner.e + ", text=" + r4 + ", context=AppHost.application");
        s r27 = s.a;
        Application r28 = AppHost.a.getApplication();
        r27.getClass();
        s.t(r28, r4);
        r2.i("MuseumExtensionDebug", "[toast][show][called] type=warning, stage=" + this.$banner.e);
        goto L32
    L14:
        if (StringsKt.isBlank(r4) == true) goto L17;
        r5 = false;
        goto L19
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        CoroutineDispatcher r29 = Dispatchers.getIO();
        MuseumExtensionDispatcher$pickExtension$1$result$1 r30 = new MuseumExtensionDispatcher$pickExtension$1$result$1(this.$banner, null);
        this.label = 1;
        r9 = BuildersKt.withContext(r29, r30, this);
        if (r9 != r0) goto L11;
        return r0;
    }
}
