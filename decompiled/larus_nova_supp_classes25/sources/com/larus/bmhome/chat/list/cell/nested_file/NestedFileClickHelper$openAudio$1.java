package com.larus.bmhome.chat.list.cell.nested_file;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.google.gson.Gson;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace;
import com.larus.home.impl.sdk.n1;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.nested_file.NestedFileClickHelper$openAudio$1", f = "NestedFileClickHelper.kt", i = {}, l = {256}, m = "invokeSuspend", n = {}, s = {})
public final class NestedFileClickHelper$openAudio$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ Context $cxt;
    final /* synthetic */ UplinkFileInfo $fileInfo;
    final /* synthetic */ String $fileKey;
    final /* synthetic */ Message $message;
    final /* synthetic */ String $path;
    final /* synthetic */ String $tosKey;
    int label;

    public NestedFileClickHelper$openAudio$1(Context r1, String r2, Message r3, String r4, UplinkFileInfo r5, String r6, String r7, Continuation<? super NestedFileClickHelper$openAudio$1> r8) {
        this.$cxt = r1;
        this.$fileKey = r2;
        this.$message = r3;
        this.$tosKey = r4;
        this.$fileInfo = r5;
        this.$path = r6;
        this.$botId = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new NestedFileClickHelper$openAudio$1(this.$cxt, this.$fileKey, this.$message, this.$tosKey, this.$fileInfo, this.$path, this.$botId, r11);
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
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r19);
        Object r4 = r19;
    L11:
        ic8.g r5 = (ic8.g) r4;
        boolean r6 = false;
        if (r5 != null) goto L14;
    L16:
        boolean r1 = false;
    L17:
        if (r1 == false) goto L23;
        t19.s.a.g(this.$cxt, 2131899538, false);
        int r7 = com.larus.bmhome.chat.trace.multimodal.a.a;
        String r8 = this.$fileKey;
        String r9 = this.$message.getMessageId();
        String r10 = this.$tosKey;
        UplinkFileInfo r11 = this.$fileInfo;
        if (r11 == null) goto L21;
        r3 = r11.getResourceId();
    L21:
        com.larus.bmhome.chat.trace.multimodal.a.d(r8, r9, true, "message_file_open_error_getUrl", r10, r3);
        return Unit.INSTANCE;
    L23:
        if (r5 != null) goto L25;
    L27:
        boolean r12 = false;
    L28:
        if (r12 == true) goto L161;
        if (r5 != null) goto L31;
    L33:
        boolean r13 = false;
    L34:
        if (r13 == true) goto L161;
        if (r5 == null) goto L42;
        String r14 = r5.b();
        if (r14 == null) goto L42;
        if ((!StringsKt.isBlank(r14)) == false) goto L42;
        String r15 = r14;
    L43:
        if (r5 == null) goto L49;
        String r16 = r5.a();
        if (r16 == null) goto L49;
        if ((!StringsKt.isBlank(r16)) == false) goto L49;
        String r17 = r16;
    L50:
        if (r15 == null) goto L84;
        Uri r18 = UriProtector.parse(r15);
        Map r20 = this.$message.getExt();
        if (r20 == null) goto L54;
        String r21 = (String) r20.get("feishu_record_generated_type");
    L55:
        Uri r22 = y0.l(r18, "record_scene", tx9.l.a(r21));
        Uri.Builder r23 = r22.buildUpon();
        Message r24 = this.$message;
        Iterator r25 = CollectionsKt.listOf(new String[]{"feishu_record_id", "feishu_record_generated_type"}).iterator();
    L57:
        if (r25.hasNext() == false) goto L79;
        String r110 = (String) r25.next();
        String r111 = UriProtector.getQueryParameter(r22, r110);
        if (r111 != null) goto L61;
    L64:
        boolean r112 = true;
    L65:
        if (r112 == false) goto L57;
        Map r113 = r24.getExt();
        if (r113 == null) goto L57;
        String r114 = (String) r113.get(r110);
        if (r114 == null) goto L57;
        if (r114.length() <= 0) goto L73;
        boolean r115 = true;
    L74:
        if (r115 == true) goto L77;
        r114 = null;
    L77:
        if (r114 == null) goto L57;
        r23.appendQueryParameter(r110, r114);
        goto L57
    L73:
        r115 = false;
        goto L74
    L61:
        if (r111.length() == 0) goto L64;
        r112 = false;
        goto L65
    L79:
        String r26 = r23.build().toString();
        IFlowSdkDepend r27 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r27 == null) goto L133;
        r27.N();
        if (n1.a.g(this.$cxt, r26, "click_audio_attachment") != true) goto L133;
    L131:
        r6 = true;
    L133:
        FLogger r28 = FLogger.a;
        StringBuilder r29 = new StringBuilder("opened:");
        r29.append(r6);
        r29.append(", docUrl:");
        int r30 = -1;
        if (r15 == null) goto L136;
        int r31 = r15.length();
    L137:
        r29.append(r31);
        r29.append(", detailUrl:");
        if (r17 == null) goto L140;
        r30 = r17.length();
    L140:
        r29.append(r30);
        r28.i("NestedFileClickHelper", r29.toString());
        if (r6 == true) goto L148;
        t19.s.a.g(this.$cxt, 2131900064, false);
        int r32 = com.larus.bmhome.chat.trace.multimodal.a.a;
        String r33 = this.$fileKey;
        String r34 = this.$message.getMessageId();
        String r35 = this.$tosKey;
        UplinkFileInfo r36 = this.$fileInfo;
        if (r36 == null) goto L145;
        String r37 = r36.getResourceId();
    L146:
        com.larus.bmhome.chat.trace.multimodal.a.d(r33, r34, true, "message_file_open_error_getUrl", r35, r37);
        return Unit.INSTANCE;
    L145:
        r37 = null;
        goto L146
    L148:
        StringBuilder r38 = new StringBuilder("open audio success, localId=");
        NestedFileClickHelper r39 = NestedFileClickHelper.a;
        String r40 = this.$message.getLocalMessageId();
        r39.getClass();
        r38.append(NestedFileClickHelper.k(r40));
        r38.append(", hasLocalPath=");
        String r41 = this.$path;
        if (r41 != null) goto L151;
    L154:
        boolean r42 = true;
        boolean r43 = true;
    L155:
        r38.append(r43 ^ r42);
        r28.i("NestedFileClickHelper", r38.toString());
        int r44 = MultimodalSendCostTrace.a;
        String r45 = this.$fileKey;
        String r46 = this.$tosKey;
        String r47 = this.$message.getMessageId();
        UplinkFileInfo r48 = this.$fileInfo;
        if (r48 == null) goto L158;
        String r49 = r48.getResourceId();
    L159:
        MultimodalSendCostTrace.f(r45, r46, r47, true, r49);
        return Unit.INSTANCE;
    L158:
        r49 = null;
        goto L159
    L151:
        if (StringsKt.isBlank(r41) == true) goto L154;
        r42 = true;
        r43 = false;
        goto L155
    L136:
        r31 = -1;
        goto L137
    L54:
        r21 = null;
        goto L55
    L84:
        if (r17 == null) goto L132;
        z2.a.w3();
        NestedFileClickHelper r50 = NestedFileClickHelper.a;
        Context r51 = this.$cxt;
        String r52 = this.$path;
        String r53 = "";
        if (r52 != null) goto L88;
        r52 = "";
    L88:
        Message r116 = this.$message;
        String r117 = this.$botId;
        r50.getClass();
        String r54 = r116.getConversationId();
        String r118 = r116.getMessageId();
        if (r118 != null) goto L91;
        r118 = "";
    L91:
        AttachmentUtil r119 = AttachmentUtil.a;
        if (r117 != null) goto L94;
        r117 = "";
    L94:
        if (r54 == null) goto L97;
        r53 = r54;
    L97:
        r119.getClass();
        Intrinsics.checkNotNullParameter(r51, "cxt");
        Intrinsics.checkNotNullParameter(r17, "audioDetailUrl");
        Intrinsics.checkNotNullParameter(r52, "audioPath");
        Intrinsics.checkNotNullParameter(r117, "botId");
        Intrinsics.checkNotNullParameter(r53, "conversationId");
        Uri r120 = UriProtector.parse(r17);
        Uri.Builder r121 = UriProtector.parse(r17).buildUpon();
        r121.clearQuery();
        Iterator r122 = UriProtector.getQueryParameterNames(r120).iterator();
    L99:
        if (r122.hasNext() == false) goto L104;
        String r55 = (String) r122.next();
        if (Intrinsics.areEqual(r55, "pageData") == true) goto L99;
        r121.appendQueryParameter(r55, UriProtector.getQueryParameter(r120, r55));
        goto L99
    L104:
        String r56 = UriProtector.getQueryParameter(r120, "conversationId");
        if (r56 != null) goto L107;
    L110:
        boolean r57 = true;
    L111:
        if (r57 == false) goto L113;
        r121.appendQueryParameter("conversationId", r53);
    L113:
        String r58 = UriProtector.getQueryParameter(r120, "botId");
        if (r58 != null) goto L116;
    L119:
        boolean r59 = true;
    L120:
        if (r59 == false) goto L163;
        r121.appendQueryParameter("botId", r117);
    L163:
        Result.Companion r60 = Result.Companion;     // Catch: Throwable -> L128
        String r61 = UriProtector.getQueryParameter(r120, "pageData");     // Catch: Throwable -> L128
        LinkedHashMap r62 = new LinkedHashMap();     // Catch: Throwable -> L128
        JSONObject r123 = new JSONObject(r61);     // Catch: Throwable -> L128
        Iterator<String> r63 = r123.keys();     // Catch: Throwable -> L128
    L124:
        if (r63.hasNext() == false) goto L126;
        String r64 = r63.next();     // Catch: Throwable -> L128
        r62.put(r64, r123.optString(r64));     // Catch: Throwable -> L128
        r63 = r63;
        goto L124
    L126:
        r62.put("messageId", r118);     // Catch: Throwable -> L128
        r62.put("conversationId", r53);     // Catch: Throwable -> L128
        r62.put("path", r52);     // Catch: Throwable -> L128
        r62.put("area", "audio_file");     // Catch: Throwable -> L128
        r62.put("scene", "upload");     // Catch: Throwable -> L128
        Result.constructor-impl(r121.appendQueryParameter("pageData", new Gson().toJson(r62)));     // Catch: Throwable -> L128
    L130:
        r121.appendQueryParameter("messageId", r118);
        com.bytedance.router.i r65 = SmartRouter.buildRoute(r51, "sslocal://flow/applet_dispatch");
        Bundle r66 = new Bundle();
        r66.putString("applet_info", r121.build().toString());
        r65.c.putExtras(r66);
        r65.f = r120;
        r65.d();
    L128:
        th = move-exception;
        Result.Companion r67 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L130
    L116:
        if (r58.length() == 0) goto L119;
        r59 = false;
        goto L120
    L107:
        if (r56.length() == 0) goto L110;
        r57 = false;
        goto L111
    L132:
        r6 = false;
    L49:
        r17 = null;
    L42:
        r15 = null;
        goto L43
    L31:
        if (r5.c() != 1) goto L33;
        r13 = true;
    L161:
        t19.s.a.g(this.$cxt, 2131898370, false);
        return Unit.INSTANCE;
    L25:
        if (r5.c() != 2) goto L27;
        r12 = true;
        goto L28
    L14:
        if (r5.c() != 11) goto L16;
        r1 = true;
        goto L17
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r19);
        CoroutineDispatcher r68 = Dispatchers.getIO();
        NestedFileClickHelper$openAudio$1$parseResult$1 r69 = new NestedFileClickHelper$openAudio$1$parseResult$1(this.$tosKey, null);
        this.label = 1;
        r4 = BuildersKt.withContext(r68, r69, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
