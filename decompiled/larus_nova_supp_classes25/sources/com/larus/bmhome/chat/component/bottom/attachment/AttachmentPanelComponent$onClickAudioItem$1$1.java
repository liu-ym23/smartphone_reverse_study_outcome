package com.larus.bmhome.chat.component.bottom.attachment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.google.gson.Gson;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.home.impl.sdk.n1;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.attachment.AttachmentPanelComponent$onClickAudioItem$1$1", f = "AttachmentPanelComponent.kt", i = {}, l = {3524}, m = "invokeSuspend", n = {}, s = {})
final class AttachmentPanelComponent$onClickAudioItem$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $cxt;
    final /* synthetic */ UplinkFileInfo $fileInfo;
    final /* synthetic */ AttachmentPanelComponent $this_runCatching;
    int label;

    public AttachmentPanelComponent$onClickAudioItem$1$1(Context r1, UplinkFileInfo r2, AttachmentPanelComponent r3, Continuation<? super AttachmentPanelComponent$onClickAudioItem$1$1> r4) {
        this.$cxt = r1;
        this.$fileInfo = r2;
        this.$this_runCatching = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AttachmentPanelComponent$onClickAudioItem$1$1(this.$cxt, this.$fileInfo, this.$this_runCatching, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        String r3 = null;
        boolean r4 = true;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r19);
        Object r5 = r19;
    L11:
        ic8.g r6 = (ic8.g) r5;
        FLogger r1 = FLogger.a;
        StringBuilder r7 = new StringBuilder("[onClickAudioItem][AudioParseDebug] parseResultNull=");
        if (r6 != null) goto L14;
        boolean r8 = true;
    L15:
        r7.append(r8);
        r7.append(", status=");
        if (r6 == null) goto L18;
        Integer r9 = Boxing.boxInt(r6.c());
    L19:
        r7.append(r9);
        r1.i("AttachmentPanelComponent", r7.toString());
        if (r6 == null) goto L26;
        String r10 = r6.b();
        if (r10 == null) goto L26;
        if ((!StringsKt.isBlank(r10)) == false) goto L26;
        String r11 = r10;
    L27:
        if (r6 == null) goto L33;
        String r12 = r6.a();
        if (r12 == null) goto L33;
        if ((!StringsKt.isBlank(r12)) == false) goto L33;
        String r13 = r12;
    L34:
        if (r11 == null) goto L40;
        IFlowSdkDepend r14 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r14 == null) goto L93;
        r14.N();
        if (n1.a.g(this.$cxt, r11, "click_audio_attachment") != true) goto L93;
    L94:
        FLogger r15 = FLogger.a;
        StringBuilder r16 = new StringBuilder("[onClickAudioItem] opened:");
        r16.append(r4);
        r16.append(", docUrl:");
        int r17 = -1;
        if (r11 == null) goto L97;
        int r18 = r11.length();
    L98:
        r16.append(r18);
        r16.append(", detailUrl:");
        if (r13 == null) goto L101;
        r17 = r13.length();
    L101:
        r16.append(r17);
        r15.i("AttachmentPanelComponent", r16.toString());
        if (r4 == true) goto L106;
        t19.s.a.g(this.$cxt, 2131900064, false);
    L106:
        return Unit.INSTANCE;
    L97:
        r18 = -1;
    L93:
        r4 = false;
        goto L94
    L40:
        if (r13 == null) goto L93;
        z2.a.w3();
        AttachmentUtil r20 = AttachmentUtil.a;
        Context r21 = this.$cxt;
        UplinkFileInfo r22 = this.$fileInfo;
        if (r22 == null) goto L44;
        String r23 = r22.getLocalResPath();
    L46:
        if (r23 != null) goto L48;
        r23 = "";
    L48:
        AttachmentPanelComponent r110 = this.$this_runCatching;
        int r111 = AttachmentPanelComponent.g2;
        BotModel r112 = r110.W3();
        if (r112 == null) goto L51;
        String r113 = r112.getBotId();
    L52:
        if (r113 != null) goto L54;
        r113 = "";
    L54:
        wc9.e r114 = this.$this_runCatching.H3();
        if (r114 == null) goto L57;
        r3 = r114.a;
    L57:
        if (r3 != null) goto L59;
        r3 = "";
    L59:
        Intrinsics.checkNotNullParameter(r21, "cxt");
        Intrinsics.checkNotNullParameter(r13, "audioDetailUrl");
        Intrinsics.checkNotNullParameter(r23, "audioPath");
        Intrinsics.checkNotNullParameter(r113, "botId");
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        Uri r115 = UriProtector.parse(r13);
        Uri.Builder r116 = UriProtector.parse(r13).buildUpon();
        r116.clearQuery();
        Iterator r117 = UriProtector.getQueryParameterNames(r115).iterator();
    L61:
        if (r117.hasNext() == false) goto L66;
        String r24 = (String) r117.next();
        if (Intrinsics.areEqual(r24, "pageData") == true) goto L61;
        r116.appendQueryParameter(r24, UriProtector.getQueryParameter(r115, r24));
        goto L61
    L66:
        String r25 = UriProtector.getQueryParameter(r115, "conversationId");
        if (r25 != null) goto L69;
    L72:
        boolean r26 = true;
    L73:
        if (r26 == false) goto L75;
        r116.appendQueryParameter("conversationId", r3);
    L75:
        String r27 = UriProtector.getQueryParameter(r115, "botId");
        if (r27 != null) goto L78;
    L81:
        boolean r28 = true;
    L82:
        if (r28 == false) goto L107;
        r116.appendQueryParameter("botId", r113);
    L107:
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L90
        String r30 = UriProtector.getQueryParameter(r115, "pageData");     // Catch: Throwable -> L90
        LinkedHashMap r118 = new LinkedHashMap();     // Catch: Throwable -> L90
        JSONObject r119 = new JSONObject(r30);     // Catch: Throwable -> L90
        Iterator<String> r31 = r119.keys();     // Catch: Throwable -> L90
    L86:
        if (r31.hasNext() == false) goto L88;
        Iterator<String> r120 = r31;
        String r32 = r31.next();     // Catch: Throwable -> L90
        r118.put(r32, r119.optString(r32));     // Catch: Throwable -> L90
        r31 = r120;
        goto L86
    L88:
        r118.put("messageId", "");     // Catch: Throwable -> L90
        r118.put("conversationId", r3);     // Catch: Throwable -> L90
        r118.put("path", r23);     // Catch: Throwable -> L90
        r118.put("area", "audio_file");     // Catch: Throwable -> L90
        r118.put("scene", "upload");     // Catch: Throwable -> L90
        Result.constructor-impl(r116.appendQueryParameter("pageData", new Gson().toJson(r118)));     // Catch: Throwable -> L90
    L92:
        r116.appendQueryParameter("messageId", "");
        com.bytedance.router.i r33 = SmartRouter.buildRoute(r21, "sslocal://flow/applet_dispatch");
        Bundle r34 = new Bundle();
        r34.putString("applet_info", r116.build().toString());
        r33.c.putExtras(r34);
        r33.f = r115;
        r33.d();
        r4 = true;
    L90:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L92
    L78:
        if (r27.length() == 0) goto L81;
        r28 = false;
        goto L82
    L69:
        if (r25.length() == 0) goto L72;
        r26 = false;
        goto L73
    L51:
        r113 = null;
        goto L52
    L44:
        r23 = null;
    L33:
        r13 = null;
    L26:
        r11 = null;
        goto L27
    L18:
        r9 = null;
        goto L19
    L14:
        r8 = false;
        goto L15
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r19);
        CoroutineDispatcher r36 = Dispatchers.getIO();
        AttachmentPanelComponent$onClickAudioItem$1$1$parseResult$1 r37 = new AttachmentPanelComponent$onClickAudioItem$1$1$parseResult$1(this.$fileInfo, null);
        this.label = 1;
        r5 = BuildersKt.withContext(r36, r37, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
