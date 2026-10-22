package com.larus.uaigc.chat.markdown.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.utils.c4;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.CreationBlock;
import com.larus.im.bean.message.CreationGenDetail;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageData;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoData;
import com.larus.im.bean.message.VideoExtension;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.platform.api.IVideoController;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.service.ICreationReportService;
import com.larus.uaigc.service.ICreationWorkflowService;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import tx9.a4;
import tx9.l3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LocalCreationChatItemClickHelper {
    public static final LocalCreationChatItemClickHelper a = null;

    public static final class a implements IIMCallback<Message> {
        public final /* synthetic */ kotlinx.coroutines.i<Message> a;

        public final boolean mustInMain() {
            return !com.larus.im.internal.delegate.y0.a();
        }

        public a(kotlinx.coroutines.j r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            FLogger.a.e("MDImageScrollWidget", "getMessageFromDb failed", r4.getException());
            if (this.a.isActive() == false) goto L6;
            this.a.resumeWith(Result.constructor-impl(null));
            return;
        }

        public final void onSuccess(Object r2) {
            Message r3 = (Message) r2;
            Intrinsics.checkNotNullParameter(r3, "result");
            if (this.a.isActive() == false) goto L6;
            this.a.resumeWith(Result.constructor-impl(r3));
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class b extends TypeToken<Map<String, ? extends String>> {
        public b() {
        }
    }

    static {
        a = new LocalCreationChatItemClickHelper();
    }

    public LocalCreationChatItemClickHelper() {
    }

    public static String n(CreationItem r2) {
        Integer r0 = r2.type;
        if (r0 != null) goto L6;
    L10:
        ImageData r3 = r2.image;
        if (r3 != null) goto L16;
    L13:
        return null;
    L16:
        return r3.key;
    L6:
        if (r0.intValue() != 3) goto L10;
        ImageInfo r4 = bz9.c.o(r2);
        if (r4 == null) goto L13;
        return r4.e;
    }

    public static Object f(String r3, Continuation r4) {
        kotlinx.coroutines.j r0 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r4), 1);
        r0.C();
        com.larus.im.d.e().m(r3, new a(r0));
        Object r5 = r0.B();
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r4);
    L5:
        return r5;
    }

    public static Object g(Message r3, Continuation r4) {
        return BuildersKt.withContext(Dispatchers.getIO(), new LocalCreationChatItemClickHelper$getVideoRecommendParams$2(r3, null), r4);
    }

    public static boolean h(Map r3, String r4) {
        Object r5 = r3.get(r4);
        String r6 = null;
        if (r5 == null) goto L5;
        String r7 = r5.toString();
    L7:
        if (r7 != null) goto L9;
    L16:
        if (r6 == null) goto L19;
        return true;
    L19:
        return false;
    L9:
        if ((!StringsKt.isBlank(r7)) == true) goto L11;
    L13:
        boolean r2 = false;
    L14:
        if (r2 == false) goto L16;
        r6 = r7;
        goto L16
    L11:
        if (Intrinsics.areEqual(r7, "null") == true) goto L13;
        r2 = true;
        goto L14
    L5:
        r7 = null;
        goto L7
    }

    public static final ChatParam a(String r8, String r9, boolean r10) {
        if (r10 == false) goto L10;
        wc9.e r11 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r11 == null) goto L7;
        r8 = r11.a;
    L8:
        if (r8 != null) goto L10;
        r8 = "";
        goto L10
    L7:
        r8 = null;
    L10:
        String r1 = r8;
        if (r10 == false) goto L18;
        com.larus.bmhome.chat.api.e0 r12 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r12 == null) goto L17;
        LaunchInfo r13 = r12.a;
        if (r13 == null) goto L17;
        r9 = r13.W();
    L17:
        String r2 = null;
    L20:
        return new ChatParam(r1, r2, null, null, null, 252);
    L18:
        r2 = r9;
        goto L20
    }

    public static void j(Map r6, Message r7, boolean r8) {
        if (r7 == null) goto L50;
        Map r9 = r7.getExt();
        if (r9 == null) goto L51;
        String r10 = (String) r9.get("creation_template");
        if (r10 == null) goto L52;
        String r1 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L24
        zd9.h r3 = zd9.h.a;     // Catch: Throwable -> L24
        if (StringsKt.isBlank(r10) == false) goto L48;
    L21:
        Object r11 = null;
    L22:
        Object r12 = Result.constructor-impl((Map) r11);     // Catch: Throwable -> L24
    L27:
        if (Result.isFailure-impl(r12) == false) goto L29;
        r12 = null;
    L29:
        Map r13 = (Map) r12;
        if (r13 == null) goto L32;
        String r4 = (String) r13.get("recommend_from");
    L33:
        k(r6, "recommend_from", r4, r8);
        if (r13 == null) goto L36;
        String r5 = (String) r13.get("template_rec_extra");
    L37:
        k(r6, "template_rec_extra", r5, r8);
        if (r13 == null) goto L40;
        String r14 = (String) r13.get("template_rec_req_id");
    L41:
        k(r6, "template_rec_req_id", r14, r8);
        if (r13 == null) goto L44;
        r1 = (String) r13.get("from_template_id");
    L44:
        k(r6, "from_template_id", r1, r8);
        return;
    L40:
        r14 = null;
        goto L41
    L36:
        r5 = null;
        goto L37
    L32:
        r4 = null;
        goto L33
    L48:
        r3.getClass();     // Catch: Throwable -> L14
        r11 = Result.constructor-impl(zd9.h.b.fromJson(r10, new b().getType()));     // Catch: Throwable -> L14
    L16:
        Throwable r15 = Result.exceptionOrNull-impl(r11);     // Catch: Throwable -> L24
        if (r15 == null) goto L20;
        com.larus.im.internal.delegate.c0 r16 = com.larus.im.internal.delegate.c0.b;     // Catch: Throwable -> L24
        StringBuilder r17 = new StringBuilder("fromJson failed, stack: ");     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r15, "<this>");     // Catch: Throwable -> L24
        r17.append(ExceptionsKt.stackTraceToString(r15));     // Catch: Throwable -> L24
        r16.e("GsonHolder", r17.toString());     // Catch: Throwable -> L24
    L20:
        if (Result.isFailure-impl(r11) == false) goto L22;
    L14:
        th = move-exception;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L24
        r11 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    L52:
        return;
    L51:
        return;
    }

    public static void k(Map r2, String r3, String r4, boolean r5) {
        if (r4 == null) goto L11;
        boolean r1 = true;
        if ((!StringsKt.isBlank(r4)) == true) goto L6;
    L8:
        r1 = false;
    L9:
        if (r1 == false) goto L11;
    L12:
        if (r4 == null) goto L18;
        if (r5 == false) goto L15;
    L16:
        r2.put(r3, r4);
        return;
    L15:
        if (h(r2, r3) == false) goto L16;
        return;
    L18:
        return;
    L6:
        if (Intrinsics.areEqual(r4, "null") == true) goto L8;
    L11:
        r4 = null;
        goto L12
    }

    public static void c(View r45, Fragment r46, Message r47, String r48, Map r49) {
        Intrinsics.checkNotNullParameter(r45, "anchorView");
        Intrinsics.checkNotNullParameter(r48, "fromScene");
        LinkedHashMap r0 = new LinkedHashMap();
        Object r3 = null;
        r0.put("creation_task_id", null);
        r0.put("vid", null);
        r0.put("cover_url", null);
        r0.put("download_url", null);
        if (r49 == null) goto L8;
        Iterator r8 = r49.entrySet().iterator();
    L6:
        if (r8.hasNext() == false) goto L8;
        Map.Entry r9 = (Map.Entry) r8.next();
        r0.put((String) r9.getKey(), (String) r9.getValue());
    L8:
        LinkedHashMap r10 = new LinkedHashMap();
        Iterator r1 = r0.entrySet().iterator();
    L9:
        boolean r11 = false;
        if (r1.hasNext() == false) goto L20;
        Map.Entry r12 = (Map.Entry) r1.next();
        String r13 = (String) r12.getValue();
        if (r13 != null) goto L14;
    L15:
        r11 = true;
    L17:
        if ((!r11) == false) goto L9;
        r10.put(r12.getKey(), r12.getValue());
        goto L9
    L14:
        if (StringsKt.isBlank(r13) == false) goto L17;
    L20:
        if ((!r10.isEmpty()) == true) goto L23;
        r10 = null;
    L23:
        if (r10 == null) goto L28;
        String r2 = (String) r10.get("creation_task_id");
        if (r2 == null) goto L28;
        String r14 = r2;
    L29:
        if (r10 == null) goto L34;
        String r4 = (String) r10.get("vid");
        if (r4 == null) goto L34;
        String r15 = r4;
    L35:
        if (r10 == null) goto L38;
        String r5 = (String) r10.get("cover_url");
        if (r5 == null) goto L38;
    L39:
        if (r10 == null) goto L42;
        String r6 = (String) r10.get("download_url");
        if (r6 == null) goto L42;
    L88:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L80
        if (r15 != null) goto L46;
    L49:
        boolean r16 = true;
    L50:
        if (r16 == false) goto L64;
        if (r5 != null) goto L53;
    L56:
        boolean r17 = true;
    L57:
        if (r17 == false) goto L64;
        if (r6 != null) goto L60;
    L61:
        r11 = true;
    L62:
        if (r11 == false) goto L64;
        UplinkFileEntity r18 = null;
    L78:
        Object r19 = Result.constructor-impl(r18);     // Catch: Throwable -> L80
    L83:
        if (Result.isFailure-impl(r19) == true) goto L86;
        r3 = r19;
    L86:
        ic8.o r20 = ic8.o.a;
        Function1 r110 = new m0();
        r20.getClass();
        ic8.o.a(r45, r46, r47, r14, (UplinkFileEntity) r3, r48, r10, r110);
        return;
    L60:
        if (StringsKt.isBlank(r6) == false) goto L62;
    L53:
        if (StringsKt.isBlank(r5) == true) goto L56;
        r17 = false;
    L64:
        int r21 = UplinkEntityType.EntityTypeFile.getValue();     // Catch: Throwable -> L80
        Integer r25 = Integer.valueOf(FileType.FileTypeVideo.getValue());     // Catch: Throwable -> L80
        if (r5 != null) goto L67;
    L72:
        Image r111 = null;
    L74:
        if (r6 != null) goto L76;
        String r112 = "";
    L77:
        r18 = new UplinkFileEntity(Integer.valueOf(r21), new UplinkEntityContent(new UplinkFileInfo(null, null, null, r25, null, null, new VideoExtension(r15, null, r111, null, r112, null, null, null, null, null, 1002, null), null, null, null, 951, null), null, 2, null), r14, null, null, null, null, null, null, false, null, null, null, r10, 8184, null);     // Catch: Throwable -> L80
        goto L78
    L76:
        r112 = r6;
        goto L77
    L67:
        if ((true ^ StringsKt.isBlank(r5)) == false) goto L69;
        String r113 = r5;
    L70:
        if (r113 == null) goto L72;
        r111 = new Image(null, null, null, null, null, null, null, null, new ImageObj(r113, 0, 0, null, null, 30, null), null, null, null, null, null, 16127, null);     // Catch: Throwable -> L80
        goto L74
    L69:
        r113 = null;
        goto L70
    L46:
        if (StringsKt.isBlank(r15) == true) goto L49;
        r16 = false;
    L80:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
    L42:
        r6 = null;
    L38:
        r5 = null;
    L34:
        r15 = null;
    L28:
        r14 = null;
        goto L29
    }

    public static void m(Context r22, int r23, String r24, String r25, Message r26, com.larus.bmhome.actionbar.model.z0 r27) {
        hy9.d r2 = ICreationReportService.a.j();
        String r3 = r22.getString(r23);
        if (r27 == null) goto L9;
        com.larus.bmhome.actionbar.model.r r7 = r27.q;
        if (r7 == null) goto L9;
        Integer r8 = r7.a;
        if (r8 == null) goto L9;
        String r10 = r8.toString();
    L10:
        if (r27 == null) goto L14;
        com.larus.bmhome.actionbar.model.r r0 = r27.q;
        if (r0 == null) goto L14;
        String r11 = r0.g;
    L15:
        hy9.d.a.b(r2, r3, null, null, "picture_detail", r24, r25, null, r10, r11, "chat", Boolean.valueOf(com.larus.im.bean.message.a.C0(r26)), tz9.a.a(r26), null, null, null, null, null, null, 1044550);
        return;
    L14:
        r11 = null;
    L9:
        r10 = null;
        goto L10
    }

    public static void l(Context r26, int r27, String r28, String r29, Message r30, Map r31, com.larus.bmhome.actionbar.model.z0 r32) {
        hy9.d r3 = ICreationReportService.a.j();
        String r4 = r26.getString(r27);
        if (r32 == null) goto L9;
        com.larus.bmhome.actionbar.model.r r5 = r32.q;
        if (r5 == null) goto L9;
        Integer r6 = r5.a;
        if (r6 == null) goto L9;
        String r11 = r6.toString();
    L10:
        if (r32 == null) goto L14;
        com.larus.bmhome.actionbar.model.r r1 = r32.q;
        if (r1 == null) goto L14;
        String r12 = r1.g;
    L15:
        boolean r2 = com.larus.im.bean.message.a.C0(r30);
        String r15 = tz9.a.a(r30);
        String r16 = String.valueOf(r31.get("recommend_from"));
        String r19 = String.valueOf(r31.get("template_rec_extra"));
        String r18 = String.valueOf(r31.get("template_rec_req_id"));
        hy9.d.a.a(r3, r4, null, null, "picture_detail", r28, r29, null, r11, r12, "chat", Boolean.valueOf(r2), r15, r16, String.valueOf(r31.get("from_template_id")), r18, r19, null, null, null, null, null, 4128838);
        return;
    L14:
        r12 = null;
    L9:
        r11 = null;
        goto L10
    }

    public static /* synthetic */ Object e(LocalCreationChatItemClickHelper r10, Message r11, String r12, String r13, Boolean r14, BotModel r15, wc9.e r16, List r17, Continuation r18) {
        return r10.d(r11, r12, r13, r14, r15, r16, r17, MapsKt.emptyMap(), r18);
    }

    public final Object d(Message r19, String r20, String r21, Boolean r22, BotModel r23, wc9.e r24, List<Message> r25, Map<String, ? extends Object> r26, Continuation<? super Map<String, ? extends Object>> r27) {
        Message r0 = r19;
        if ((r27 instanceof LocalCreationChatItemClickHelper$getCommonParamsWithRepoFallback$1) == false) goto L7;
        LocalCreationChatItemClickHelper$getCommonParamsWithRepoFallback$1 r4 = (LocalCreationChatItemClickHelper$getCommonParamsWithRepoFallback$1) r27;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r3 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        if (r7 == 0) goto L14;
        if (r7 != 1) goto L13;
        Map r1 = (Map) r4.L$1;
        Message r2 = (Message) r4.L$0;
        ResultKt.throwOnFailure(r3);
        Map r8 = r1;
        r0 = r2;
    L101:
        Message r9 = (Message) r3;
    L103:
        Map r10 = MapsKt.toMutableMap(r8);
        j(r10, r9, false);
        if (r9 == null) goto L108;
        Map r11 = r9.getExt();
        if (r11 == null) goto L108;
        String r12 = (String) r11.get("creation_template");
    L109:
        if (r12 == null) goto L111;
        r10.put("message", r0);
    L111:
        return r10;
    L108:
        r12 = null;
        goto L109
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r3);
        Intrinsics.checkNotNullParameter(r26, "extraParams");
        Pair[] r13 = new Pair[12];
        r13[0] = TuplesKt.to("user_type", "bot");
        String r14 = "chat";
        r13[1] = TuplesKt.to("enter_picture_method", "chat");
        if (Intrinsics.areEqual(r22, Boolean.TRUE) == false) goto L17;
        r14 = "temporary_chat";
    L17:
        r13[2] = TuplesKt.to("enter_from", r14);
        if (r0 == null) goto L20;
        String r15 = r19.getMessageId();
    L21:
        String r16 = "";
        if (r15 != null) goto L24;
        r15 = "";
    L24:
        r13[3] = TuplesKt.to("message_id", r15);
        if (r0 == null) goto L27;
        String r17 = r19.getConversationId();
    L28:
        if (r17 != null) goto L30;
        r17 = "";
    L30:
        r13[4] = TuplesKt.to("conversation_id", r17);
        if (r23 == null) goto L34;
        String r18 = r23.getBotId();
        if (r18 == null) goto L34;
    L35:
        r13[5] = TuplesKt.to("bot_id", r18);
        IAIChatControlTraceService.Companion r28 = IAIChatControlTraceService.a;
        if (r24 == null) goto L38;
        Integer r29 = r24.v;
    L39:
        if (r23 == null) goto L41;
        Integer r110 = r23.getBotType();
    L42:
        if (r23 == null) goto L46;
        BotCreatorInfo r111 = r23.getBotCreatorInfo();
        if (r111 == null) goto L46;
        String r112 = r111.getId();
    L47:
        r13[6] = TuplesKt.to("chat_type", r28.g(r29, r110, Intrinsics.areEqual(r112, AccountService.a.getUserId())));
        if (r20 != null) goto L50;
        String r30 = "";
    L51:
        r13[7] = TuplesKt.to("current_page", r30);
        if (r21 == null) goto L55;
        r16 = r21;
    L55:
        r13[8] = TuplesKt.to("previous_page", r16);
        String r31 = "0";
        r13[9] = TuplesKt.to("is_feely_img", "0");
        if (r0 == null) goto L61;
        String r32 = l3.f(Boolean.valueOf(com.larus.im.bean.message.a.C0(r19)));
        if (r32 == null) goto L61;
        r31 = r32;
    L61:
        r13[10] = TuplesKt.to("is_deep_thinking", r31);
        r13[11] = TuplesKt.to("ai_create_show_mode", "mixed");
        r8 = MapsKt.mutableMapOf(r13);
        if (r0 == null) goto L74;
        String r33 = r19.getReplyId();
        if (r33 == null) goto L74;
        if (r25 == null) goto L74;
        Iterator<T> r34 = r25.iterator();
    L68:
        if (r34.hasNext() == false) goto L72;
        Object r113 = r34.next();
        if (Intrinsics.areEqual(((Message) r113).getMessageId(), r33) == false) goto L68;
    L73:
        Message r114 = (Message) r113;
    L75:
        j(r8, r114, true);
        if (r114 == null) goto L80;
        Map r35 = r114.getExt();
        if (r35 == null) goto L80;
        String r36 = (String) r35.get("creation_template");
    L81:
        if (r36 == null) goto L83;
        r8.put("message", r0);
    L83:
        r8.putAll(r26);
        if (h(r8, "recommend_from") == true) goto L86;
    L92:
        boolean r37 = false;
    L93:
        if (r37 == false) goto L95;
        return r8;
    L95:
        if (r0 == null) goto L102;
        String r38 = r19.getReplyId();
        if (r38 == null) goto L102;
        IChatRepoService r39 = RepoDispatcherDelegate.b.e();
        r4.L$0 = r0;
        r4.L$1 = r8;
        r4.label = 1;
        r3 = r39.E1(r38, r4);
        if (r3 != r6) goto L101;
        return r6;
    L102:
        r9 = null;
        goto L103
    L86:
        if (h(r8, "template_rec_extra") == false) goto L92;
        if (h(r8, "template_rec_req_id") == false) goto L92;
        if (h(r8, "from_template_id") == false) goto L92;
        r37 = true;
    L80:
        r36 = null;
        goto L81
    L72:
        r113 = null;
    L74:
        r114 = null;
        goto L75
    L50:
        r30 = r20;
    L46:
        r112 = null;
        goto L47
    L41:
        r110 = null;
        goto L42
    L38:
        r29 = null;
    L34:
        r18 = "";
        goto L35
    L27:
        r17 = null;
        goto L28
    L20:
        r15 = null;
    L7:
        r4 = new LocalCreationChatItemClickHelper$getCommonParamsWithRepoFallback$1(this, r27);
        goto L8
    }

    public static ic8.d b(final Context r12, boolean r13, final Message r14, final Map r15, final String r16, final kc8.q r17, final CoroutineScope r18, final com.larus.uaigc.chat.markdown.image.component.a r19, final int r20, final int r21) {
        return new ic8.d(r13, new t0(r19, r12, r18, r20, r14, r16, r17, r21, r15), new u0(r12, r21, r16, r14, r19), false, null, null, 56);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v51, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r11v28 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r38v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r38v1 */
    /* JADX WARN: Type inference failed for: r38v10 */
    /* JADX WARN: Type inference failed for: r38v2 */
    /* JADX WARN: Type inference failed for: r38v3 */
    /* JADX WARN: Type inference failed for: r38v4 */
    /* JADX WARN: Type inference failed for: r38v5 */
    /* JADX WARN: Type inference failed for: r38v7 */
    /* JADX WARN: Type inference failed for: r38v8 */
    /* JADX WARN: Type inference failed for: r38v9 */
    /* JADX WARN: Type inference failed for: r4v18, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v38 */
    /* JADX WARN: Type inference failed for: r4v44 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    public final Object i(String r72, View r73, View r74, String r75, String r76, Boolean r77, kc8.q r78, String r79, CreationItem r80, com.larus.bmhome.bigimg.e r81, LifecycleCoroutineScope r82, com.larus.uaigc.chat.markdown.image.component.a r83, com.larus.uaigc.chat.markdown.image.component.k r84, iy9.b r85, Message r86, Continuation r87) {
        if ((r87 instanceof LocalCreationChatItemClickHelper$onClickBlockItem$1) == false) goto L7;
        LocalCreationChatItemClickHelper$onClickBlockItem$1 r2 = (LocalCreationChatItemClickHelper$onClickBlockItem$1) r87;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        String r6 = "";
        if (r5 == 0) goto L19;
        if (r5 == 1) goto L18;
        if (r5 == 2) goto L16;
        if (r5 != 3) goto L15;
        int r0 = r2.I$0;
        long r7 = r2.J$0;
        final Context r13 = (Context) r2.L$15;
        String r14 = (String) r2.L$14;
        List r15 = (List) r2.L$13;
        List r9 = (List) r2.L$12;
        List r11 = (List) r2.L$11;
        JSONObject r8 = (JSONObject) r2.L$10;
        final Message r10 = (Message) r2.L$9;
        iy9.b r12 = (iy9.b) r2.L$8;
        com.larus.uaigc.chat.markdown.image.component.k r16 = (com.larus.uaigc.chat.markdown.image.component.k) r2.L$7;
        com.larus.uaigc.chat.markdown.image.component.a r17 = (com.larus.uaigc.chat.markdown.image.component.a) r2.L$6;
        LifecycleCoroutineScope r18 = (CoroutineScope) r2.L$5;
        com.larus.bmhome.bigimg.e r19 = (com.larus.bmhome.bigimg.e) r2.L$4;
        CreationItem r20 = (CreationItem) r2.L$3;
        kc8.q r21 = (kc8.q) r2.L$2;
        View r22 = (View) r2.L$1;
        View r23 = (View) r2.L$0;
        ResultKt.throwOnFailure(r1);
        int r24 = r0;
        com.larus.bmhome.bigimg.e r25 = r19;
        View r39 = r23;
        long r68 = r7;
        r6 = "";
        iy9.b r46 = r12;
        final String r26 = r14;
        List r42 = r15;
        final com.larus.uaigc.chat.markdown.image.component.a r27 = r17;
        final kc8.q r110 = r21;
        View r111 = r22;
        Object r28 = r1;
        LifecycleCoroutineScope r29 = r18;
        CreationItem r30 = r20;
        ?? r112 = r11;
    L323:
        final Map r31 = (Map) r28;
        if (k1.a(r39) == true) goto L326;
        Intrinsics.checkNotNull(r13);
        Integer r32 = r30.type;
        if (r32 != null) goto L331;
    L333:
        boolean r33 = false;
    L334:
        if (r33 == true) goto L336;
        View r52 = r111;
    L337:
        if (r110 == null) goto L339;
        Fragment r53 = r110.a;
    L340:
        if (r110 == null) goto L344;
        com.larus.bmhome.chat.api.q0 r34 = r110.l;
        if (r34 == null) goto L344;
        com.larus.bmhome.chat.api.q0.a r45 = r34.getProvider();
    L345:
        if (r110 == null) goto L349;
        Function0 r35 = r110.e;
        if (r35 == null) goto L349;
        boolean r58 = ((Boolean) r35.invoke()).booleanValue();
    L350:
        if (r110 == null) goto L361;
        Fragment r36 = r110.a;
        if (r36 == null) goto L361;
        Bundle r37 = r36.getArguments();
        if (r37 == null) goto L361;
        if (r37.getBoolean("preview_collection_readonly") == false) goto L359;
    L360:
        boolean r59 = true;
    L362:
        if (r110 == null) goto L364;
        rd8.b r60 = r110.g;
    L365:
        if (r110 == null) goto L369;
        final kc8.b0 r38 = r110.k;
        if (r38 == null) goto L369;
        Function1 r63 = new l0(r38);
    L370:
        if (r110 == null) goto L374;
        final kc8.b0 r40 = r110.k;
        if (r40 == null) goto L374;
        Function4 r64 = new w0(r40);
    L375:
        if (r110 == null) goto L379;
        final kc8.b0 r41 = r110.k;
        if (r41 == null) goto L379;
        Function1 r65 = new a1(r41);
    L380:
        if (r110 == null) goto L384;
        final kc8.b0 r43 = r110.k;
        if (r43 == null) goto L384;
        Function0 r66 = new b1(r43);
    L385:
        jy9.x r44 = new jy9.x(r10, r45, r46, null, r30, r24, r29, null, r52, r53, r25, new c1(r110), new d1(r110), new e1(r110), r58, r59, r60, null, null, r63, r64, r65, r66, 3670808);
        Iterable r113 = (Iterable) r112;
        ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));
        Iterator r115 = r113.iterator();
        int r116 = 0;
    L386:
        JSONObject r117 = r8;
        jy9.x r88 = r44;
        if (r115.hasNext() == false) goto L404;
        Object r118 = r115.next();
        int r210 = r116 + 1;
        if (r116 >= 0) goto L391;
        CollectionsKt.throwIndexOverflow();
    L391:
        CreationItem r119 = (CreationItem) r118;
        Iterator r710 = r115;
        Pair[] r120 = new Pair[5];
        int r89 = r24;
        com.larus.uaigc.chat.markdown.image.component.k r810 = r16;
        r120[0] = TuplesKt.to("position", Integer.valueOf(r210));
        String r47 = n(r119);
        if (r47 != null) goto L394;
        r47 = r6;
    L394:
        r120[1] = TuplesKt.to("pic_id", r47);
        ImageData r48 = r119.image;
        if (r48 == null) goto L397;
        String r49 = r48.requestId;
    L398:
        if (r49 != null) goto L400;
        r49 = r6;
    L400:
        r120[2] = TuplesKt.to("request_id", r49);
        String r50 = r119.id;
        if (r50 != null) goto L403;
        r50 = r6;
    L403:
        r120[3] = TuplesKt.to("creation_task_id", r50);
        r120[4] = TuplesKt.to("is_feely_img", "0");
        r114.add(MapsKt.mutableMapOf(r120));
        r115 = r710;
        r16 = r810;
        r44 = r88;
        r24 = r89;
        r8 = r117;
        r116 = r210;
        goto L386
    L397:
        r49 = null;
        goto L398
    L404:
        int r811 = r24;
        final com.larus.uaigc.chat.markdown.image.component.k r812 = r16;
        uo8.k r51 = new uo8.k(r31, r114);
        CreationGenDetail r121 = r30.genDetail;
        if (r121 == null) goto L407;
        Integer r122 = r121.taskType;
    L408:
        if (r122 != null) goto L411;
    L413:
        if (r122 != null) goto L416;
    L418:
        if (r122 == null) goto L423;
        int r123 = 6;
        if (r122.intValue() != 6) goto L423;
    L429:
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r10, "curMessage");
        Intrinsics.checkNotNullParameter(r9, "initList");
        Intrinsics.checkNotNullParameter(r31, "commonParams");
        Intrinsics.checkNotNullParameter(r29, "lifecycleScope");
        boolean r124 = Intrinsics.areEqual(PollingConfigService.a.f("cre_pic_sc_dg"), "1");
        if (com.larus.im.bean.message.a.e0(r10) == true) goto L433;
        if (r124 == true) goto L433;
        boolean r125 = true;
    L434:
        if (r27 == null) goto L440;
        com.larus.bmhome.actionbar.model.z0 r126 = r27.P();
        if (r126 == null) goto L440;
        com.larus.bmhome.actionbar.model.r r127 = r126.q;
        if (r127 == null) goto L440;
        boolean r54 = Intrinsics.areEqual(r127.h, Boolean.TRUE);
    L441:
        ICreationWorkflowService.Companion r128 = ICreationWorkflowService.a;
        if (r42 != null) goto L444;
        List r211 = CollectionsKt.emptyList();
    L445:
        String r129 = r10.getMessageId();
        if (r129 != null) goto L448;
        String r212 = r6;
    L449:
        Map r55 = r10.getBusinessExt();
        CreationItem r130 = r30;
        if (r55 == null) goto L452;
        String r56 = (String) r55.get("message_case_mode");
    L453:
        boolean r410 = Intrinsics.areEqual(r56, "1");
        String r310 = r10.getMessageId();
        if (r27 == null) goto L457;
        if (r125 == false) goto L457;
        boolean r57 = true;
    L458:
        final LifecycleCoroutineScope r711 = r29;
        final kc8.q r712 = r110;
        final String r713 = r26;
        final Context r714 = r13;
        final Message r715 = r10;
        final com.larus.uaigc.chat.markdown.image.component.a r716 = r27;
        ic8.d r311 = new ic8.d(r57, new o0(r711, r712, r713, r714, r715, r31, r716), new p0(r13, r27, r10), false, null, null, 56);
        if (r812 == null) goto L462;
        if (r125 == false) goto L462;
        boolean r61 = true;
    L463:
        final LifecycleCoroutineScope r717 = r29;
        final Context r718 = r13;
        final String r719 = r26;
        final Message r720 = r10;
        final kc8.q r721 = r110;
        Function1 r62 = new q0(r717, r718, r719, r720, r31, r812, r721);
        Function1 r131 = new r0(r13, r26, r10, r812);
        if ((CollectionsKt.getOrNull(r9, r811) instanceof zo8.e) == true) goto L466;
    L468:
        boolean r67 = false;
    L469:
        ic8.d r312 = new ic8.d(r61, r62, r131, r67, new s0(r13), null, 32);
        if (r54 == false) goto L473;
        if (r125 == false) goto L473;
        boolean r69 = true;
    L474:
        ic8.d r313 = b(r13, r69, r10, r31, r26, r110, r29, r27, 2, 2131906326);
        if (r54 == false) goto L478;
        if (r125 == false) goto L478;
        boolean r70 = true;
    L479:
        ic8.d r411 = b(r13, r70, r10, r31, r26, r110, r29, r27, 1, 2131906330);
        if (r54 == false) goto L483;
        if (r125 == false) goto L483;
        boolean r71 = true;
    L484:
        List r213 = r9;
        r128.b0(r13, new iy9.a(r213, r12, r51, r25, r212, r211, null, 0, r310, null, null, 0, null, Integer.valueOf(r123), r311, r312, r313, b(r13, r71, r10, r31, r26, r110, r29, r27, 3, 2131906329), r411, false, r68, r410, new n0(r110), 12647360), r88);
        Integer r90 = r130.type;
        if (r90 != null) goto L488;
    L502:
        if (r90 != null) goto L505;
    L530:
        return Unit.INSTANCE;
    L505:
        if (r90.intValue() != 3) goto L530;
        com.larus.platform.service.o r91 = com.larus.platform.service.o.a;
        JSONObject r92 = new JSONObject();
        if (r26 != null) goto L509;
        r26 = r6;
    L509:
        r92.put("bot_id", r26);
        r92.put("message_id", r10.getMessageId());
        r92.put("conversation_id", r10.getConversationId());
        r92.put("user_type", "bot");
        r92.put("pic_position", String.valueOf(r811 + 1));
        r92.put("pic_id", n(r130));
        ImageData r93 = r130.image;
        if (r93 == null) goto L512;
        String r132 = r93.requestId;
    L513:
        if (r132 != null) goto L515;
        String r94 = r6;
    L516:
        r92.put("request_id", r94);
        r92.put("is_onboarding", 0);
        Object r95 = r31.get("recommend_from");
        if (r95 == null) goto L519;
        r92.put("recommend_from", r95);
    L519:
        Object r96 = r31.get("template_rec_extra");
        if (r96 == null) goto L522;
        r92.put("template_rec_extra", r96);
    L522:
        Object r97 = r31.get("template_rec_req_id");
        if (r97 == null) goto L525;
        r92.put("template_rec_req_id", r97);
    L525:
        Object r98 = r31.get("from_template_id");
        if (r98 == null) goto L528;
        r92.put("from_template_id", r98);
    L528:
        Unit r99 = Unit.INSTANCE;
        r91.reportEvent("picture_message_click", r92);
        goto L530
    L515:
        r94 = r132;
        goto L516
    L512:
        r132 = null;
        goto L513
    L488:
        if (r90.intValue() != 4) goto L502;
        Integer r100 = r130.type;
        if (r100 != null) goto L493;
    L497:
        VideoData r101 = r130.video;
        if (r101 == null) goto L500;
        String r133 = r101.vid;
    L501:
        a4.c(r133, r10.getMessageId(), r26, r117);
    L500:
        r133 = null;
        goto L501
    L493:
        if (r100.intValue() != 4) goto L497;
        nr9.g r102 = bz9.c.p(r130);
        if (r102 == null) goto L500;
        r133 = r102.a;
    L483:
        r71 = false;
    L478:
        r70 = false;
    L473:
        r69 = false;
        goto L474
    L466:
        if (z2.a.getCreationExtendVideoConfig().b() == false) goto L468;
        r67 = true;
    L462:
        r61 = false;
    L457:
        r57 = false;
        goto L458
    L452:
        r56 = null;
        goto L453
    L448:
        r212 = r129;
        goto L449
    L444:
        r211 = r42;
    L440:
        r54 = false;
    L433:
        r125 = false;
    L423:
        if (r122 != null) goto L426;
    L428:
        r123 = 2;
        goto L429
    L426:
        if (r122.intValue() != 2) goto L428;
        r123 = 5;
        goto L429
    L416:
        if (r122.intValue() != 7) goto L418;
        r123 = 4;
        goto L429
    L411:
        if (r122.intValue() != 5) goto L413;
        r123 = 3;
        goto L429
    L407:
        r122 = null;
    L384:
        r66 = null;
    L379:
        r65 = null;
    L374:
        r64 = null;
    L369:
        r63 = null;
        goto L370
    L364:
        r60 = null;
        goto L365
    L359:
        if (Intrinsics.areEqual(r37.getString("as_container"), "READONLY_FORWARD_DETAIL") == true) goto L360;
    L361:
        r59 = false;
    L349:
        r58 = false;
    L344:
        r45 = null;
        goto L345
    L339:
        r53 = null;
        goto L340
    L336:
        r52 = null;
        goto L337
    L331:
        if (r32.intValue() != 4) goto L333;
        r33 = true;
        goto L334
    L326:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        long r103 = r2.J$0;
        Message r104 = (Message) r2.L$13;
        iy9.b r105 = (iy9.b) r2.L$12;
        com.larus.uaigc.chat.markdown.image.component.k r106 = (com.larus.uaigc.chat.markdown.image.component.k) r2.L$11;
        com.larus.uaigc.chat.markdown.image.component.a r134 = (com.larus.uaigc.chat.markdown.image.component.a) r2.L$10;
        LifecycleCoroutineScope r135 = (CoroutineScope) r2.L$9;
        com.larus.bmhome.bigimg.e r136 = (com.larus.bmhome.bigimg.e) r2.L$8;
        CreationItem r137 = (CreationItem) r2.L$7;
        kc8.q r138 = (kc8.q) r2.L$6;
        Boolean r139 = (Boolean) r2.L$5;
        String r107 = (String) r2.L$4;
        String r722 = (String) r2.L$3;
        View r108 = (View) r2.L$2;
        View r109 = (View) r2.L$1;
        String r140 = (String) r2.L$0;
        ResultKt.throwOnFailure(r1);
        Object r141 = r4;
        r6 = "";
        long r142 = r103;
        com.larus.uaigc.chat.markdown.image.component.a r143 = r134;
        LifecycleCoroutineScope r144 = r135;
        Message r145 = r104;
        iy9.b r146 = r105;
        View r147 = r109;
        Boolean r723 = r139;
        com.larus.uaigc.chat.markdown.image.component.k r148 = r106;
        View r149 = r108;
        String r724 = r107;
    L17:
        Object r725 = r1;
        String r150 = r140;
        JSONObject r151 = (JSONObject) r725;
        long r813 = r142;
        Intrinsics.checkNotNullParameter(r145, "<this>");
        Intrinsics.checkNotNullParameter(r137, "clickItem");
        if (bz9.c.e(r137) == true) goto L42;
        ?? r152 = bz9.a.g(r145);
    L41:
        ?? r153 = r152;
        com.larus.uaigc.chat.markdown.image.component.k r154 = r148;
        ArrayList r155 = new ArrayList();
        r147.getContext();
        com.larus.uaigc.chat.markdown.image.component.a r814 = r143;
        Intrinsics.checkNotNullParameter(r145, "<this>");
        Result.Companion r156 = Result.Companion;     // Catch: Throwable -> L103
        Map r157 = r145.getExt();     // Catch: Throwable -> L103
        if (r157 == null) goto L97;
        LifecycleCoroutineScope r815 = r144;
        String r158 = (String) r157.get("creation_canvas_creation_info");     // Catch: Throwable -> L94
        if (r158 == null) goto L98;
        zd9.h r159 = zd9.h.a;     // Catch: Throwable -> L94
        if (StringsKt.isBlank(r158) == false) goto L539;
        r2 = r2;
        View r816 = r149;
        com.larus.bmhome.bigimg.e r817 = r136;
    L90:
        Object r160 = null;
    L91:
        Map r161 = (Map) r160;     // Catch: Throwable -> L101
    L99:
        Object r162 = Result.constructor-impl(r161);     // Catch: Throwable -> L101
    L107:
        if (Result.isFailure-impl(r162) == false) goto L109;
        r162 = null;
    L109:
        Map r163 = (Map) r162;
        ArrayList r164 = new ArrayList();
        Iterator r165 = r153.iterator();
        ArrayList r166 = r155;
        int r167 = 0;
        ?? r168 = r153;
    L111:
        if (r165.hasNext() == false) goto L262;
        Object r169 = r165.next();
        int r170 = r167 + 1;
        if (r167 >= 0) goto L115;
        CollectionsKt.throwIndexOverflow();
    L115:
        CreationItem r171 = (CreationItem) r169;
        Iterator r726 = r165;
        Integer r172 = r171.type;
        if (r172 != null) goto L119;
        ?? r314 = r168;
        View r315 = r147;
    L118:
        r137 = r137;
        kc8.q r316 = r138;
        ArrayList r173 = r155;
        if (r172 != null) goto L202;
    L257:
        n1 r174 = null;
        ?? r317 = r314;
    L258:
        r164 = r164;
        if (r174 == null) goto L261;
        r164.add(r174);
    L261:
        r165 = r726;
        r150 = r150;
        r155 = r173;
        r167 = r170;
        r138 = r316;
        r168 = r317;
        r147 = r315;
        r137 = r137;
        goto L111
    L202:
        if (r172.intValue() != 3) goto L257;
        ImageInfo r175 = bz9.c.o(r171);
        if (r175 == null) goto L218;
        com.larus.platform.api.Image r176 = r175.c;
        if (r176 == null) goto L209;
        String r177 = bz9.a.b(r176);
    L210:
        if (r177 != null) goto L212;
        String r214 = r6;
    L214:
        if (r214.length() != 0) goto L216;
        boolean r178 = true;
    L217:
        if (r178 == true) goto L218;
        if (com.larus.bmhome.utils.u.c() == false) goto L226;
        com.larus.platform.api.Image r179 = r175.b;
        if (r179 == null) goto L224;
        String r180 = bz9.a.b(r179);
    L225:
        if (r180 == null) goto L226;
    L227:
        com.larus.platform.api.Image r181 = r175.a;
        if (r181 == null) goto L230;
        String r215 = bz9.a.b(r181);
    L231:
        com.larus.platform.api.Image r182 = r175.i;
        if (r182 == null) goto L234;
        String r216 = bz9.a.b(r182);
    L235:
        com.larus.platform.api.Image r183 = r175.a;
        if (r183 == null) goto L238;
        Long r217 = Long.valueOf(r183.c);
    L239:
        com.larus.platform.api.Image r184 = r175.a;
        if (r184 == null) goto L242;
        Long r218 = Long.valueOf(r184.d);
    L243:
        n1 r185 = new n1(r214, r215, r216, null, r217, r218);
        if (r163 == null) goto L246;
        fz9.a r186 = (fz9.a) r163.get(r171.id);
    L247:
        String r187 = r171.id;
        if (r186 == null) goto L250;
        String r318 = r186.a();
    L251:
        if (r186 == null) goto L253;
        String r319 = r186.b();
    L254:
        Pair r188 = TuplesKt.to(r185, new zo8.b(r185, r180, "", r187, false, true, r318, r319, null, 256));
    L255:
        if (r188 == null) goto L257;
        r166.add((zo8.b) r188.component2());
        r174 = (n1) r188.getFirst();
        r317 = r314;
        goto L258
    L253:
        r319 = null;
        goto L254
    L250:
        r318 = null;
        goto L251
    L246:
        r186 = null;
        goto L247
    L242:
        r218 = null;
        goto L243
    L238:
        r217 = null;
        goto L239
    L234:
        r216 = null;
        goto L235
    L230:
        r215 = null;
        goto L231
    L224:
        r180 = null;
    L226:
        r180 = r6;
        goto L227
    L216:
        r178 = false;
        goto L217
    L212:
        r214 = r177;
        goto L214
    L209:
        r177 = null;
    L218:
        r188 = null;
        goto L255
    L119:
        r314 = r168;
        r315 = r147;
        if (r172.intValue() != 4) goto L198;
        nr9.g r189 = bz9.c.p(r171);
        if (r189 != null) goto L124;
        r316 = r138;
        ArrayList r412 = r155;
        Pair r190 = null;
    L195:
        if (r190 == null) goto L197;
        r173 = r412;
        r173.add((zo8.e) r190.component2());
        r174 = (n1) r190.getFirst();
        r166 = r173;
        r317 = r314;
        goto L258
    L197:
        r173 = r412;
        r166 = r173;
        goto L257
    L124:
        String r191 = r189.a;
        if (r191 != null) goto L128;
        r191 = r6;
    L128:
        if (com.larus.utils.o0.d(r137.id) == true) goto L130;
    L132:
        boolean r192 = false;
    L133:
        int r193 = hz9.a.a;
        String r194 = r171.id;
        if (r194 != null) goto L137;
        r194 = r6;
    L137:
        if (r194.length() != 0) goto L139;
        boolean r219 = true;
    L140:
        if (r219 == false) goto L142;
        r194 = String.valueOf(r167);
    L142:
        String r195 = hz9.a.b(r145, r194, false, 12);
        String r196 = r6;
        n1 r197 = new n1(r196, r196);
        String r198 = r171.id;
        if (r138 == null) goto L147;
        kc8.a0 r199 = r138.d;
        if (r199 == null) goto L147;
        String r220 = r199.getBotId();
    L148:
        String r221 = r145.getMessageId();
        if (r138 == null) goto L153;
        kc8.a0 r200 = r138.d;
        if (r200 == null) goto L153;
        BotModel r222 = r200.j0();
    L154:
        if (r138 == null) goto L158;
        kc8.a0 r201 = r138.d;
        if (r201 == null) goto L158;
        wc9.e r223 = r201.h();
    L159:
        c4 r413 = new c4(r220, r221, "chat", r222, r223, "click", "1", r171.id, Integer.valueOf(r170), tz9.a.a(r145), Boolean.valueOf(com.larus.im.bean.message.a.C0(r145)), r145, r151, null, 8192);
        if (r192 == false) goto L165;
        if (r146 == null) goto L165;
        Long r202 = r146.d;
        if (r202 == null) goto L165;
        r316 = r138;
        r412 = r155;
        int r203 = (int) r202.longValue();
    L172:
        int r224 = r203;
    L174:
        String r204 = r171.id;
        if (r204 != null) goto L178;
        r204 = r6;
    L178:
        if (r204.length() != 0) goto L180;
        boolean r205 = true;
    L181:
        if (r205 == false) goto L183;
        r204 = String.valueOf(r167);
    L183:
        String r225 = hz9.a.a(r145, r204, true, String.valueOf(r167));
        i1 r206 = new i1(r146);
        if (r192 == false) goto L191;
        nr9.f r207 = r189.g;
        if (r207 == null) goto L191;
        if (r146 == null) goto L189;
        Bitmap r208 = r146.e;
    L190:
        r207.f = r208;
        goto L191
    L189:
        r208 = null;
    L191:
        if (r146 == null) goto L193;
        Function2<String, IVideoController, Unit> r226 = r146.b;
    L194:
        r190 = TuplesKt.to(r197, new zo8.e(null, r413, r189, r224, r225, r206, r226, false, null, null, r198, false, true, 769));
        goto L195
    L193:
        r226 = null;
        goto L194
    L180:
        r205 = false;
    L165:
        r316 = r138;
        r412 = r155;
        IVideoController r209 = IAIChatUgcAIGCService.a.L().a(r195, "ugc_video", "message_card");
        if (r209 == null) goto L168;
        r203 = r209.getCurrentPlaybackTime();
        goto L172
    L168:
        if (r146 == null) goto L173;
        Function1<String, Integer> r227 = r146.a;
        if (r227 == null) goto L173;
        r203 = ((Number) r227.invoke(r191)).intValue();
    L173:
        r224 = 0;
    L158:
        r223 = null;
    L153:
        r222 = null;
    L147:
        r220 = null;
        goto L148
    L139:
        r219 = false;
        goto L140
    L130:
        if (Intrinsics.areEqual(r137.id, r171.id) == false) goto L132;
        r192 = true;
        goto L133
    L198:
        r314 = r314;
        goto L118
    L262:
        String r727 = r150;
        ?? r320 = r168;
        View r321 = r147;
        CreationItem r414 = r137;
        kc8.q r322 = r138;
        ArrayList r228 = r155;
        Result.Companion r229 = Result.Companion;     // Catch: Throwable -> L265
        FLogger.a.i(r727, "onClickBlockItem, hide ime");     // Catch: Throwable -> L265
        com.larus.utils.e1.p(r321);     // Catch: Throwable -> L265
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L265
    L267:
        Iterator r230 = r228.iterator();
        int r231 = 0;
    L269:
        if (r230.hasNext() == false) goto L293;
        zo8.e r232 = (zo8.a) r230.next();
        CreationItem r1100 = r414;
        if (com.larus.utils.o0.d(r1100.id) == false) goto L274;
        boolean r233 = Intrinsics.areEqual(r232.a(), r1100.id);
    L290:
        if (r233 == true) goto L294;
        r231 = r231 + 1;
        r414 = r1100;
    L294:
        if (r231 != (-1)) goto L296;
        int r234 = 0;
    L297:
        r110 = r322;
        if (r322 == null) goto L302;
        kc8.a0 r235 = r110.d;
        if (r235 == null) goto L302;
        String r236 = r235.getBotId();
    L303:
        Context r237 = r321.getContext();
        if (r110 == null) goto L308;
        kc8.a0 r238 = r110.d;
        if (r238 == null) goto L308;
        BotModel r239 = r238.j0();
    L309:
        if (r110 == null) goto L313;
        kc8.a0 r240 = r110.d;
        if (r240 == null) goto L313;
        wc9.e r241 = r240.h();
    L314:
        if (r110 == null) goto L318;
        Function0 r242 = r110.i;
        if (r242 == null) goto L318;
        List r243 = (List) r242.invoke();
    L319:
        r2.L$0 = r321;
        r111 = r816;
        r2.L$1 = r111;
        r2.L$2 = r110;
        r2.L$3 = r1100;
        r39 = r321;
        r2.L$4 = r817;
        r2.L$5 = r815;
        r2.L$6 = r814;
        r2.L$7 = r154;
        r2.L$8 = r146;
        r2.L$9 = r145;
        r2.L$10 = r151;
        r2.L$11 = r320;
        r2.L$12 = r228;
        r2.L$13 = r164;
        r2.L$14 = r236;
        r2.L$15 = r237;
        String r1101 = r236;
        r42 = r164;
        r2.J$0 = r813;
        r2.I$0 = r234;
        r2.label = 3;
        Object r244 = e(this, r145, r722, r724, r723, r239, r241, r243, r2);
        Object r245 = r141;
        if (r244 != r245) goto L322;
        return r245;
    L322:
        r68 = r813;
        r27 = r814;
        r25 = r817;
        r8 = r151;
        r9 = r228;
        r10 = r145;
        r46 = r146;
        r26 = r1101;
        r28 = r244;
        r112 = r320;
        r16 = r154;
        r29 = r815;
        r24 = r234;
        r30 = r1100;
        r13 = r237;
    L318:
        r243 = null;
    L313:
        r241 = null;
    L308:
        r239 = null;
    L302:
        r236 = null;
        goto L303
    L296:
        r234 = r231;
        goto L297
    L274:
        if ((r232 instanceof zo8.e) == false) goto L281;
        String r246 = r232.c.a;
        nr9.g r247 = bz9.c.p(r1100);
        if (r247 == null) goto L278;
        String r248 = r247.a;
    L279:
        r233 = Intrinsics.areEqual(r246, r248);
        goto L290
    L278:
        r248 = null;
        goto L279
    L281:
        if ((r232 instanceof zo8.b) == false) goto L289;
        String r249 = ((zo8.b) r232).a.c;
        ImageInfo r250 = bz9.c.o(r1100);
        if (r250 == null) goto L287;
        com.larus.platform.api.Image r251 = r250.a;
        if (r251 == null) goto L287;
        String r252 = bz9.a.b(r251);
    L288:
        r233 = Intrinsics.areEqual(r249, r252);
    L287:
        r252 = null;
        goto L288
    L289:
        r233 = false;
        goto L290
    L293:
        r1100 = r414;
        r231 = -1;
    L265:
        th = move-exception;
        Result.Companion r253 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L101:
        th = th;
    L105:
        Result.Companion r254 = Result.Companion;
        r162 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L107
    L539:
        r159.getClass();     // Catch: Throwable -> L75
        r817 = r136;
        r160 = Result.constructor-impl(zd9.h.b.fromJson(r158, new j1().getType()));     // Catch: Throwable -> L73
    L78:
        Throwable r255 = Result.exceptionOrNull-impl(r160);     // Catch: Throwable -> L92
        if (r255 == null) goto L87;
        com.larus.im.internal.delegate.c0 r1102 = com.larus.im.internal.delegate.c0.b;     // Catch: Throwable -> L92
        r816 = r149;
        r2 = r2;
        StringBuilder r256 = new StringBuilder("fromJson failed, stack: ");     // Catch: Throwable -> L101
        Intrinsics.checkNotNullParameter(r255, "<this>");     // Catch: Throwable -> L101
        r256.append(ExceptionsKt.stackTraceToString(r255));     // Catch: Throwable -> L101
        r1102.e("GsonHolder", r256.toString());     // Catch: Throwable -> L101
    L89:
        if (Result.isFailure-impl(r160) == false) goto L91;
    L92:
        th = th;
        r2 = r2;
        r816 = r149;
        goto L105
    L87:
        r2 = r2;
        r816 = r149;
    L73:
        th = th;
    L531:
        Result.Companion r257 = Result.Companion;     // Catch: Throwable -> L92
        r160 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L92
    L75:
        th = th;
        r817 = r136;
    L98:
        r816 = r149;
        r817 = r136;
        r161 = null;
    L94:
        th = th;
    L96:
        r816 = r149;
        r817 = r136;
        goto L105
    L97:
        r815 = r144;
    L103:
        th = th;
        r815 = r144;
        goto L96
    L42:
        r152 = new ArrayList();
        Iterator r258 = com.larus.im.bean.message.a.k(r145).iterator();
    L44:
        if (r258.hasNext() == false) goto L41;
        BlockContent r1103 = ((Block) r258.next()).getContent();
        if (r1103 == null) goto L44;
        Iterator r728 = r258;
        CreationBlock r259 = r1103.getCreationBlock();
        if (r259 == null) goto L58;
        List r260 = r259.creations;
        if (r260 == null) goto L58;
        Iterator r261 = r260.iterator();
    L53:
        if (r261.hasNext() == false) goto L58;
        Iterator r729 = r261;
        CreationItem r262 = (CreationItem) r261.next();
        if (bz9.c.e(r262) == false) goto L57;
        r152.add(r262);
    L57:
        r261 = r729;
    L58:
        r258 = r728;
        goto L44
    L18:
        long r263 = r2.J$0;
        Message r264 = (Message) r2.L$14;
        iy9.b r265 = (iy9.b) r2.L$13;
        com.larus.uaigc.chat.markdown.image.component.k r266 = (com.larus.uaigc.chat.markdown.image.component.k) r2.L$12;
        com.larus.uaigc.chat.markdown.image.component.a r1104 = (com.larus.uaigc.chat.markdown.image.component.a) r2.L$11;
        LifecycleCoroutineScope r1105 = (CoroutineScope) r2.L$10;
        com.larus.bmhome.bigimg.e r1106 = (com.larus.bmhome.bigimg.e) r2.L$9;
        r137 = (CreationItem) r2.L$8;
        String r1107 = (String) r2.L$7;
        kc8.q r1108 = (kc8.q) r2.L$6;
        Boolean r267 = (Boolean) r2.L$5;
        String r268 = (String) r2.L$4;
        String r269 = (String) r2.L$3;
        View r270 = (View) r2.L$2;
        View r271 = (View) r2.L$1;
        r140 = (String) r2.L$0;
        ResultKt.throwOnFailure(r1);
        Message r1109 = r264;
        Object r272 = r1;
        long r273 = r263;
        com.larus.uaigc.chat.markdown.image.component.k r274 = r266;
        r143 = r1104;
        r144 = r1105;
        com.larus.bmhome.bigimg.e r275 = r1106;
        Boolean r1110 = r267;
        String r1111 = r268;
        String r1112 = r269;
        r149 = r270;
        iy9.b r276 = r265;
        r147 = r271;
    L27:
        Message r277 = (Message) r272;
        if (r277 != null) goto L30;
        Message r278 = r1109;
    L31:
        if (r278 != null) goto L34;
        FLogger.a.w(r140, "onClickBlockItem, message missing, messageId=" + r1107);
        return Unit.INSTANCE;
    L34:
        r2.L$0 = r140;
        r2.L$1 = r147;
        r2.L$2 = r149;
        r2.L$3 = r1112;
        r2.L$4 = r1111;
        r2.L$5 = r1110;
        r2.L$6 = r1108;
        r2.L$7 = r137;
        r2.L$8 = r275;
        r2.L$9 = r144;
        r2.L$10 = r143;
        r2.L$11 = r274;
        r2.L$12 = r276;
        r2.L$13 = r278;
        r2.L$14 = null;
        kc8.q r1113 = r1108;
        long r1114 = r273;
        r2.J$0 = r1114;
        com.larus.bmhome.bigimg.e r279 = r275;
        r2.label = 2;
        r1 = g(r278, r2);
        com.larus.uaigc.chat.markdown.image.component.k r280 = r274;
        if (r1 != r4) goto L37;
        return r4;
    L37:
        r141 = r4;
        r722 = r1112;
        r724 = r1111;
        r723 = r1110;
        r136 = r279;
        r146 = r276;
        r145 = r278;
        r142 = r1114;
        r138 = r1113;
        r148 = r280;
        goto L17
    L30:
        r278 = r277;
        goto L31
    L19:
        ResultKt.throwOnFailure(r1);
        if (bz9.c.e(r80) == false) goto L22;
        long r281 = System.currentTimeMillis();
        r2.L$0 = r72;
        r147 = r73;
        r2.L$1 = r147;
        r149 = r74;
        r2.L$2 = r149;
        r1112 = r75;
        r2.L$3 = r1112;
        r1111 = r76;
        r2.L$4 = r1111;
        r1110 = r77;
        r2.L$5 = r1110;
        r2.L$6 = r78;
        r2.L$7 = r79;
        r2.L$8 = r80;
        r2.L$9 = r81;
        r2.L$10 = r82;
        r2.L$11 = r83;
        r2.L$12 = r84;
        r2.L$13 = r85;
        r2.L$14 = r86;
        r2.J$0 = r281;
        r2.label = 1;
        Object r282 = f(r79, r2);
        if (r282 != r4) goto L26;
        return r4;
    L26:
        r274 = r84;
        r1109 = r86;
        r272 = r282;
        r273 = r281;
        r275 = r81;
        r144 = r82;
        r143 = r83;
        r276 = r85;
        r1108 = r78;
        r137 = r80;
        r1107 = r79;
        r140 = r72;
        goto L27
    L22:
        return Unit.INSTANCE;
    L7:
        r2 = new LocalCreationChatItemClickHelper$onClickBlockItem$1(this, r87);
        goto L8
    }
}
