package com.larus.uaigc.creation.gallery.datasource;

import android.graphics.Bitmap;
import android.os.Build;
import androidx.collection.LruCache;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.chat.adapter.f0;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageContentData;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageEntity;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageItem;
import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.creative.messagecard.bean.CreationAsset;
import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import com.larus.bmhome.utils.c4;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.im.bean.IMMsgExt;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Cover;
import com.larus.im.bean.message.CreationGenDetail;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.ImageData;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.VideoData;
import com.larus.im.internal.delegate.c0;
import com.larus.platform.api.IVideoController;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.api.creation.UserCreationImage;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.chat.markdown.helper.CreationChatItemClickHelper;
import com.larus.uaigc.chat.markdown.helper.j0;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager$d;
import com.larus.uaigc.utils.DataConverterKt;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.p0;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import jy9.x;
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
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import tx9.l3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class CreationDataSourceHelper {
    public static final CreationDataSourceHelper a = null;
    public static final String b = null;

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class a extends TypeToken<Map<String, ? extends String>> {
        public a() {
        }
    }

    public static final class b implements VideoPlayView.a {
        public final /* synthetic */ x a;

        public b(x r1) {
            this.a = r1;
        }

        public final void a(String r3) {
            iy9.b r0 = this.a.c;
            if (r0 == null) goto L8;
            Function2<String, Boolean, Unit> r1 = r0.c;
            if (r1 == null) goto L9;
            r1.invoke(r3, Boolean.TRUE);
            return;
        L9:
            return;
        }

        public final void onPause(String r3) {
            iy9.b r0 = this.a.c;
            if (r0 == null) goto L8;
            Function2<String, Boolean, Unit> r1 = r0.c;
            if (r1 == null) goto L9;
            r1.invoke(r3, Boolean.FALSE);
            return;
        L9:
            return;
        }
    }

    public static final class c implements VideoPlayView.a {
        public final /* synthetic */ x a;

        public c(x r1) {
            this.a = r1;
        }

        public final void a(String r3) {
            iy9.b r0 = this.a.c;
            if (r0 == null) goto L8;
            Function2<String, Boolean, Unit> r1 = r0.c;
            if (r1 == null) goto L9;
            r1.invoke(r3, Boolean.TRUE);
            return;
        L9:
            return;
        }

        public final void onPause(String r3) {
            iy9.b r0 = this.a.c;
            if (r0 == null) goto L8;
            Function2<String, Boolean, Unit> r1 = r0.c;
            if (r1 == null) goto L9;
            r1.invoke(r3, Boolean.FALSE);
            return;
        L9:
            return;
        }
    }

    public CreationDataSourceHelper() {
    }

    static {
        a = new CreationDataSourceHelper();
        b = "CreationDataSourceHelper";
    }

    public static Map c(Message r6) {
        String r1 = null;
        if (r6 == null) goto L29;
        Map r7 = r6.getExt();
        if (r7 == null) goto L29;
        String r8 = (String) r7.get("creation_template");
        if (r8 == null) goto L29;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L23
        zd9.h r3 = zd9.h.a;     // Catch: Throwable -> L23
        if (StringsKt.isBlank(r8) == false) goto L49;
    L20:
        Object r9 = null;
    L21:
        Object r10 = Result.constructor-impl((Map) r9);     // Catch: Throwable -> L23
    L26:
        if (Result.isFailure-impl(r10) == false) goto L28;
        r10 = null;
    L28:
        Map r11 = (Map) r10;
    L30:
        LinkedHashMap r0 = new LinkedHashMap();
        CreationDataSourceHelper r4 = a;
        if (r11 == null) goto L33;
        String r5 = (String) r11.get("recommend_from");
    L34:
        r4.getClass();
        m(r0, "recommend_from", r5);
        if (r11 == null) goto L37;
        String r12 = (String) r11.get("template_rec_extra");
    L38:
        m(r0, "template_rec_extra", r12);
        if (r11 == null) goto L41;
        String r13 = (String) r11.get("template_rec_req_id");
    L42:
        m(r0, "template_rec_req_id", r13);
        if (r11 == null) goto L45;
        r1 = (String) r11.get("from_template_id");
    L45:
        m(r0, "from_template_id", r1);
        return r0;
    L41:
        r13 = null;
        goto L42
    L37:
        r12 = null;
        goto L38
    L33:
        r5 = null;
        goto L34
    L49:
        r3.getClass();     // Catch: Throwable -> L13
        r9 = Result.constructor-impl(zd9.h.b.fromJson(r8, new a().getType()));     // Catch: Throwable -> L13
    L15:
        Throwable r14 = Result.exceptionOrNull-impl(r9);     // Catch: Throwable -> L23
        if (r14 == null) goto L19;
        c0 r15 = c0.b;     // Catch: Throwable -> L23
        StringBuilder r16 = new StringBuilder("fromJson failed, stack: ");     // Catch: Throwable -> L23
        Intrinsics.checkNotNullParameter(r14, "<this>");     // Catch: Throwable -> L23
        r16.append(ExceptionsKt.stackTraceToString(r14));     // Catch: Throwable -> L23
        r15.e("GsonHolder", r16.toString());     // Catch: Throwable -> L23
    L19:
        if (Result.isFailure-impl(r9) == false) goto L21;
    L13:
        th = move-exception;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L23
        r9 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
    L29:
        r11 = null;
        goto L30
    }

    public static Map d(x r8) {
        String r0 = null;
        if (r8 == null) goto L8;
        Function0<BotModel> r1 = r8.o;
        if (r1 == null) goto L8;
        BotModel r2 = (BotModel) r1.invoke();
        if (r2 == null) goto L8;
    L15:
        if (r8 == null) goto L20;
        Function0<wc9.e> r3 = r8.p;
        if (r3 == null) goto L20;
        wc9.e r4 = (wc9.e) r3.invoke();
        if (r4 == null) goto L20;
    L28:
        if (r8 == null) goto L30;
        boolean r5 = r8.q;
    L31:
        Pair[] r6 = new Pair[7];
        r6[0] = TuplesKt.to("user_type", "bot");
        String r7 = "chat";
        r6[1] = TuplesKt.to("enter_picture_method", "chat");
        if (r5 == false) goto L34;
        String r9 = "temporary_chat";
    L35:
        r6[2] = TuplesKt.to("enter_from", r9);
        String r10 = "";
        if (r4 == null) goto L39;
        String r11 = r4.a;
        if (r11 == null) goto L39;
    L40:
        r6[3] = TuplesKt.to("conversation_id", r11);
        if (r2 == null) goto L46;
        String r12 = r2.getBotId();
        if (r12 == null) goto L46;
        r10 = r12;
    L46:
        r6[4] = TuplesKt.to("bot_id", r10);
        LruCache r13 = ko8.a.a;
        if (r4 == null) goto L49;
        Integer r14 = r4.v;
    L50:
        if (r2 == null) goto L52;
        Integer r15 = r2.getBotType();
    L53:
        if (r2 == null) goto L57;
        BotCreatorInfo r16 = r2.getBotCreatorInfo();
        if (r16 == null) goto L57;
        String r17 = r16.getId();
    L58:
        r6[5] = TuplesKt.to("chat_type", ko8.a.f(r14, r15, Intrinsics.areEqual(r17, AccountService.a.getUserId())));
        if (r8 == null) goto L64;
        String r18 = r8.j;
        if (r18 == null) goto L64;
        r7 = r18;
    L64:
        r6[6] = TuplesKt.to("previous_page", r7);
        Map r19 = MapsKt.mutableMapOf(r6);
        if (r8 == null) goto L69;
        Message r20 = r8.a;
        if (r20 == null) goto L69;
        String r21 = com.larus.im.bean.message.a.r(r20);
    L70:
        String r22 = "0";
        if (o0.d(r21) == false) goto L79;
        if (r8 == null) goto L77;
        Message r23 = r8.a;
        if (r23 == null) goto L77;
        String r24 = com.larus.im.bean.message.a.r(r23);
        if (r24 == null) goto L77;
    L78:
        r19.put("is_general_agent", r24);
    L77:
        r24 = "0";
    L79:
        if (r8 == null) goto L84;
        Message r25 = r8.a;
        if (r25 == null) goto L84;
        r0 = com.larus.im.bean.message.a.s(r25);
    L84:
        if (o0.d(r0) == false) goto L93;
        if (r8 == null) goto L92;
        Message r26 = r8.a;
        if (r26 == null) goto L92;
        String r27 = com.larus.im.bean.message.a.s(r26);
        if (r27 == null) goto L92;
        r22 = r27;
    L92:
        r19.put("chat_id", r22);
    L93:
        return r19;
    L69:
        r21 = null;
    L57:
        r17 = null;
        goto L58
    L52:
        r15 = null;
        goto L53
    L49:
        r14 = null;
    L39:
        r11 = "";
        goto L40
    L34:
        r9 = "chat";
        goto L35
    L30:
        r5 = false;
    L20:
        if (r8 == null) goto L26;
        q0.a r28 = r8.b;
        if (r28 == null) goto L26;
        y r29 = r28.u0();
        if (r29 == null) goto L26;
        r4 = r29.h();
    L26:
        r4 = null;
    L8:
        if (r8 == null) goto L14;
        q0.a r30 = r8.b;
        if (r30 == null) goto L14;
        y r31 = r30.u0();
        if (r31 == null) goto L14;
        r2 = r31.j0();
    L14:
        r2 = null;
        goto L15
    }

    public static JSONObject f(Map r3, Map r4) {
        JSONObject r0 = new JSONObject();
        if (r3 == null) goto L8;
        Iterator r5 = r3.entrySet().iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        Map.Entry r1 = (Map.Entry) r5.next();
        r0.put((String) r1.getKey(), r1.getValue());
    L8:
        if (r4 == null) goto L13;
        Iterator r6 = r4.entrySet().iterator();
    L11:
        if (r6.hasNext() == false) goto L13;
        Map.Entry r7 = (Map.Entry) r6.next();
        r0.put((String) r7.getKey(), r7.getValue());
    L13:
        return r0;
    }

    public static boolean h(Map r2, String r3) {
        String r4 = (String) r2.get(r3);
        if (r4 != null) goto L5;
    L12:
        r4 = null;
    L13:
        if (r4 == null) goto L16;
        return true;
    L16:
        return false;
    L5:
        if ((!StringsKt.isBlank(r4)) == true) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L12;
    L7:
        if (Intrinsics.areEqual(r4, "null") == true) goto L9;
        r1 = true;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object b(Message r6, Continuation<? super Unit> r7) {
        if ((r7 instanceof CreationDataSourceHelper$ensureNoWatermarkForGalleryIfNeeded$1) == false) goto L7;
        CreationDataSourceHelper$ensureNoWatermarkForGalleryIfNeeded$1 r0 = (CreationDataSourceHelper$ensureNoWatermarkForGalleryIfNeeded$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        Message r9 = (Message) r0.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L35 CancellationException -> L39
        r6 = r9;
    L41:
    L38:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r8);
        if (r6.getContentType() != 6) goto L21;
        if (r6.getUserType() != 2) goto L21;
    L28:
        boolean r10 = true;
    L29:
        if (r10 == false) goto L31;
        CoroutineDispatcher r11 = Dispatchers.getIO();     // Catch: Throwable -> L35 CancellationException -> L39
        CreationDataSourceHelper$ensureNoWatermarkForGalleryIfNeeded$2 r4 = new CreationDataSourceHelper$ensureNoWatermarkForGalleryIfNeeded$2(r6, null);     // Catch: Throwable -> L35 CancellationException -> L39
        r0.L$0 = r6;     // Catch: Throwable -> L35 CancellationException -> L39
        r0.label = 1;     // Catch: Throwable -> L35 CancellationException -> L39
        Object r12 = BuildersKt.withContext(r11, r4, r0);     // Catch: Throwable -> L35 CancellationException -> L39
        r6 = r12;
        if (r12 != r2) goto L41;
        return r2;
    L31:
        return Unit.INSTANCE;
    L21:
        if (r6.getContentType() == 9999) goto L28;
        if (r6.getContentType() == 1) goto L25;
    L27:
        r10 = false;
        goto L29
    L25:
        if (com.larus.im.bean.message.a.b0(r6) == false) goto L27;
    L39:
        e = move-exception;
        throw e;
    L35:
        th = move-exception;
        FLogger.a.w(b, "ensure no watermark for gallery failed, messageId=" + r6.getMessageId() + ", msg=" + th.getMessage());
    L7:
        r0 = new CreationDataSourceHelper$ensureNoWatermarkForGalleryIfNeeded$1(this, r7);
        goto L8
    }

    public static void m(Map r2, String r3, String r4) {
        if (r4 == null) goto L11;
        boolean r1 = true;
        if ((!StringsKt.isBlank(r4)) == true) goto L6;
    L8:
        r1 = false;
    L9:
        if (r1 == false) goto L11;
    L12:
        if (r4 == null) goto L15;
        String r5 = (String) r2.put(r3, r4);
        return;
    L15:
        return;
    L6:
        if (Intrinsics.areEqual(r4, "null") == true) goto L8;
    L11:
        r4 = null;
        goto L12
    }

    public final Object a(x r13, Message r14, Continuation<? super List<sz9.b>> r15) {
        if ((r15 instanceof CreationDataSourceHelper$convertMessageToGalleryData$1) == false) goto L7;
        CreationDataSourceHelper$convertMessageToGalleryData$1 r0 = (CreationDataSourceHelper$convertMessageToGalleryData$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        CreationDataSourceHelper$convertMessageToGalleryData$1 r7 = r0;
        Object r16 = r7.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String r3 = "";
        switch(r7.label) {
            case 0: goto L16;
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L12;
            case 6: goto L12;
            case 7: goto L12;
            case 8: goto L12;
            default: goto L11;
        };
    L12:
        List<sz9.b> r17 = (List) r7.L$0;
        ResultKt.throwOnFailure(r16);
    L78:
        return r17;
    L13:
        Map<String, UserCreationFromIM> r18 = (Map) r7.L$4;
        String r19 = (String) r7.L$3;
        List<sz9.b> r4 = (List) r7.L$2;
        Message r5 = (Message) r7.L$1;
        x r6 = (x) r7.L$0;
        ResultKt.throwOnFailure(r16);
        Map<String, UserCreationFromIM> r8 = r18;
        r17 = r4;
    L49:
        int r110 = r5.getContentType();
        if (r110 == 1) goto L73;
        if (r110 != 6) goto L54;
        CreationDataSourceHelper r9 = a;
        r7.L$0 = r17;
        r7.L$1 = null;
        r7.L$2 = null;
        r7.L$3 = null;
        r7.L$4 = null;
        r7.label = 4;
        if (r9.j(r6, r5, r17, r19, r8, r7) != r2) goto L78;
        return r2;
    L54:
        if (r110 != 9999) goto L56;
        CreationDataSourceHelper r111 = a;
        r7.L$0 = r17;
        r7.L$1 = null;
        r7.L$2 = null;
        r7.L$3 = null;
        r7.L$4 = null;
        r7.label = 6;
        if (r111.i(r6, r5, r17, r19, r8, r7) != r2) goto L78;
        return r2;
    L56:
        if (r110 != 2021) goto L58;
        CreationDataSourceHelper r10 = a;
        r7.L$0 = r17;
        r7.L$1 = null;
        r7.L$2 = null;
        r7.L$3 = null;
        r7.L$4 = null;
        r7.label = 7;
        if (r10.l(r6, r5, r17, r19, r8, r7) != r2) goto L78;
        return r2;
    L58:
        if (r110 != 2022) goto L78;
        CreationDataSourceHelper r11 = a;
        r7.L$0 = r17;
        r7.L$1 = null;
        r7.L$2 = null;
        r7.L$3 = null;
        r7.L$4 = null;
        r7.label = 5;
        if (r11.k(r6, r5, r17, r19, r8, r7) != r2) goto L78;
        return r2;
    L73:
        if (com.larus.im.bean.message.a.b0(r5) == false) goto L78;
        CreationDataSourceHelper r12 = a;
        r7.L$0 = r17;
        r7.L$1 = null;
        r7.L$2 = null;
        r7.L$3 = null;
        r7.L$4 = null;
        r7.label = 8;
        if (r12.i(r6, r5, r17, r19, r8, r7) != r2) goto L78;
        return r2;
    L14:
        String r112 = (String) r7.L$4;
        List<sz9.b> r113 = (List) r7.L$3;
        Message r20 = (Message) r7.L$2;
        Message r21 = (Message) r7.L$1;
        x r22 = (x) r7.L$0;
        ResultKt.throwOnFailure(r16);
    L38:
        String r114 = (String) r16;
        if (r114 != null) goto L41;
        r114 = "";
    L41:
        String r23 = r20.getMessageId();
        if (r23 == null) goto L45;
        r3 = r23;
    L45:
        Map<String, UserCreationFromIM> r115 = DataConverterKt.c(r114, r3);
        FLogger.a.i(b, "convertMessageToGalleryData, message id: " + r21.getMessageId() + ", contentType: " + r21.getContentType());
        CreationDataSourceHelper r24 = a;
        r7.L$0 = r22;
        r7.L$1 = r21;
        r7.L$2 = r113;
        r7.L$3 = r112;
        r7.L$4 = r115;
        r7.label = 3;
        if (r24.b(r20, r7) != r2) goto L48;
        return r2;
    L48:
        r5 = r21;
        r6 = r22;
        r8 = r115;
        List<sz9.b> r116 = r113;
        r19 = r112;
        r17 = r116;
        goto L49
    L15:
        List<sz9.b> r117 = (List) r7.L$3;
        Message r118 = (Message) r7.L$2;
        Message r25 = (Message) r7.L$1;
        x r26 = (x) r7.L$0;
        ResultKt.throwOnFailure(r16);
        List<sz9.b> r27 = r117;
        r13 = r26;
        Object r28 = r16;
        Message r119 = r118;
        r14 = r25;
    L22:
        Message r29 = (Message) r28;
        boolean r30 = false;
        if (r29 != null) goto L25;
    L27:
        if (r30 == false) goto L30;
        String r31 = com.larus.bmhome.chat.bean.d.H(r29);
        if (r31 == null) goto L30;
    L31:
        IChatRepoService r32 = RepoDispatcherDelegate.b.e();
        String r33 = r119.getMessageId();
        if (r33 != null) goto L34;
        r33 = "";
    L34:
        r7.L$0 = r13;
        r7.L$1 = r14;
        r7.L$2 = r119;
        r7.L$3 = r27;
        r7.L$4 = r31;
        r7.label = 2;
        Object r34 = r32.w1(r33, r7);
        if (r34 != r2) goto L37;
        return r2;
    L37:
        r22 = r13;
        r112 = r31;
        r21 = r14;
        r113 = r27;
        r20 = r119;
        r16 = r34;
    L30:
        r31 = "";
        goto L31
    L25:
        if (r29.getContentType() != 1) goto L27;
        r30 = true;
        goto L27
    L16:
        ResultKt.throwOnFailure(r16);
        if (r14 == null) goto L79;
        ArrayList r120 = new ArrayList();
        IChatRepoService r35 = zh8.a.a;
        IChatRepoService r36 = zh8.a.a;
        r7.L$0 = r13;
        r7.L$1 = r14;
        r7.L$2 = r14;
        r7.L$3 = r120;
        r7.label = 1;
        Object r37 = r36.y1(r14, r7);
        if (r37 != r2) goto L21;
        return r2;
    L21:
        r28 = r37;
        r27 = r120;
        r119 = r14;
        goto L22
    L79:
        return null;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r0 = new CreationDataSourceHelper$convertMessageToGalleryData$1(this, r15);
        goto L8
    }

    public final Object e(Message r6, x r7, Continuation<? super Map<String, String>> r8) {
        if ((r8 instanceof CreationDataSourceHelper$getCreationTemplateTrackParams$1) == false) goto L7;
        CreationDataSourceHelper$getCreationTemplateTrackParams$1 r0 = (CreationDataSourceHelper$getCreationTemplateTrackParams$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Map r10 = (Map) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L50:
        Message r11 = (Message) r9;
        Map r12 = r10;
    L51:
        Iterator r13 = ((LinkedHashMap) c(r11)).entrySet().iterator();
    L53:
        if (r13.hasNext() == false) goto L57;
        Map.Entry r14 = (Map.Entry) r13.next();
        CreationDataSourceHelper r4 = a;
        String r5 = (String) r14.getKey();
        r4.getClass();
        if (h(r12, r5) == true) goto L53;
        r12.put(r14.getKey(), r14.getValue());
        goto L53
    L57:
        return r12;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        r11 = null;
        if (r7 == null) goto L20;
        Function0<List<Message>> r15 = r7.u;
        if (r15 == null) goto L20;
        List r16 = (List) r15.invoke();
        if (r16 == null) goto L20;
    L27:
        r12 = MapsKt.toMutableMap(c(f0.c(r6, r16)));
        if (h(r12, "recommend_from") == true) goto L30;
    L36:
        boolean r17 = false;
    L37:
        if (r17 == false) goto L39;
        return r12;
    L39:
        String r18 = r6.getReplyId();
        if (r18 == null) goto L51;
        if ((!StringsKt.isBlank(r18)) == true) goto L45;
        r18 = null;
    L45:
        if (r18 == null) goto L51;
        CoroutineDispatcher r19 = Dispatchers.getIO();
        CreationDataSourceHelper$getCreationTemplateTrackParams$repoReplyMessage$2$1 r20 = new CreationDataSourceHelper$getCreationTemplateTrackParams$repoReplyMessage$2$1(r18, null);
        r0.L$0 = r12;
        r0.label = 1;
        r9 = BuildersKt.withContext(r19, r20, r0);
        if (r9 != r2) goto L49;
        return r2;
    L49:
        r10 = r12;
        goto L50
    L30:
        if (h(r12, "template_rec_extra") == false) goto L36;
        if (h(r12, "template_rec_req_id") == false) goto L36;
        if (h(r12, "from_template_id") == false) goto L36;
        r17 = true;
    L20:
        if (r7 == null) goto L26;
        q0.a r21 = r7.b;
        if (r21 == null) goto L26;
        q0 r22 = r21.e();
        if (r22 == null) goto L26;
        r16 = r22.getCurrentList();
    L26:
        r16 = null;
    L7:
        r0 = new CreationDataSourceHelper$getCreationTemplateTrackParams$1(this, r8);
        goto L8
    }

    public final Object g(x r6, Message r7, boolean r8, boolean r9, String r10, Continuation<? super Map<String, ? extends Object>> r11) {
        if ((r11 instanceof CreationDataSourceHelper$getSingleParams$1) == false) goto L7;
        CreationDataSourceHelper$getSingleParams$1 r0 = (CreationDataSourceHelper$getSingleParams$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r9 = r0.Z$1;
        r8 = r0.Z$0;
        r10 = (String) r0.L$1;
        r7 = (Message) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L17:
        Map r13 = (Map) r12;
        Pair[] r14 = new Pair[7];
        String r4 = r7.getMessageId();
        if (r4 != null) goto L20;
        r4 = "";
    L20:
        r14[0] = TuplesKt.to("message_id", r4);
        if (com.larus.bmhome.chat.bean.d.y(r7) == false) goto L23;
        String r5 = "1";
    L24:
        r14[1] = TuplesKt.to("is_feely_img", r5);
        String r15 = l3.f(Boxing.boxBoolean(com.larus.im.bean.message.a.C0(r7)));
        if (r15 != null) goto L27;
        r15 = "0";
    L27:
        r14[2] = TuplesKt.to("is_deep_thinking", r15);
        r14[3] = TuplesKt.to("ai_create_show_mode", tz9.a.a(r7));
        if (r8 == false) goto L30;
        String r16 = "picture_detail";
    L31:
        r14[4] = TuplesKt.to("current_page", r16);
        if (r10 != null) goto L34;
        r10 = "";
    L34:
        r14[5] = TuplesKt.to("creation_task_id", r10);
        r14[6] = TuplesKt.to("is_edu", "0");
        Map r17 = MapsKt.mutableMapOf(r14);
        if (r9 == false) goto L37;
        TuplesKt.to("ai_create_show_mode", "mixed");
    L37:
        Iterator r18 = r13.entrySet().iterator();
    L39:
        if (r18.hasNext() == false) goto L41;
        Map.Entry r19 = (Map.Entry) r18.next();
        r17.put(r19.getKey(), r19.getValue());
        goto L39
    L41:
        return r17;
    L30:
        r16 = "video_detail";
        goto L31
    L23:
        r5 = "0";
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        r0.L$0 = r7;
        r0.L$1 = r10;
        r0.Z$0 = r8;
        r0.Z$1 = r9;
        r0.label = 1;
        r12 = e(r7, r6, r0);
        if (r12 != r2) goto L17;
        return r2;
    L7:
        r0 = new CreationDataSourceHelper$getSingleParams$1(this, r11);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:260:0x04f6 -> B:321:0x0684). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:300:0x05d5 -> B:301:0x05f0). Please report as a decompilation issue!!! */
    public final Object i(x r42, Message r43, List<sz9.b> r44, String r45, Map<String, UserCreationFromIM> r46, Continuation<? super x> r47) {
        x r0 = r42;
        if ((r47 instanceof CreationDataSourceHelper$parseBlockItemData$1) == false) goto L7;
        CreationDataSourceHelper$parseBlockItemData$1 r3 = (CreationDataSourceHelper$parseBlockItemData$1) r47;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        String r11 = "";
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        boolean r1 = r3.Z$0;
        int r7 = r3.I$2;
        int r8 = r3.I$1;
        int r12 = r3.I$0;
        List<sz9.b> r13 = (List) r3.L$18;
        CreationDataSourceHelper r14 = (CreationDataSourceHelper) r3.L$17;
        Map r15 = (Map) r3.L$16;
        zo8.e r9 = (zo8.e) r3.L$15;
        zo8.b r10 = (zo8.b) r3.L$14;
        Ref.ObjectRef r16 = (Ref.ObjectRef) r3.L$13;
        Ref.BooleanRef r17 = (Ref.BooleanRef) r3.L$12;
        CreationItem r18 = (CreationItem) r3.L$11;
        Iterator r19 = (Iterator) r3.L$10;
        Collection r20 = (Collection) r3.L$9;
        Map r21 = (Map) r3.L$8;
        JSONObject r22 = (JSONObject) r3.L$7;
        Message r23 = (Message) r3.L$6;
        x r24 = (x) r3.L$5;
        x r25 = (x) r3.L$4;
        Map<String, UserCreationFromIM> r26 = (Map) r3.L$3;
        String r27 = (String) r3.L$2;
        List<sz9.b> r28 = (List) r3.L$1;
        x r29 = (x) r3.L$0;
        ResultKt.throwOnFailure(r2);
        boolean r30 = r1;
        int r31 = r8;
        String r32 = "";
        int r33 = r12;
        JSONObject r110 = r22;
        final Message r34 = r23;
        Map<String, UserCreationFromIM> r35 = r26;
        String r36 = r27;
        List<sz9.b> r48 = r28;
        final CreationItem r111 = r18;
        CreationDataSourceHelper$parseBlockItemData$1 r112 = r3;
        zo8.e r210 = r9;
        CreationDataSourceHelper r113 = r14;
        x r49 = r25;
        Collection r37 = r20;
        Map r114 = r21;
        Object r38 = r2;
        zo8.b r211 = r10;
        x r39 = r24;
        x r40 = r29;
        List<sz9.b> r41 = r13;
        Ref.BooleanRef r115 = r17;
        int r50 = r7;
        Map r51 = r15;
        Ref.ObjectRef r116 = r16;
        Object r117 = r5;
        Iterator r52 = r19;
    L301:
        Map r53 = MapsKt.toMutableMap((Map) r38);
        x r410 = r40;
        Collection r411 = r37;
        r53.put("position", Boxing.boxInt(r31 + 1));
        ImageData r54 = r111.image;
        if (r54 == null) goto L304;
        String r55 = r54.key;
    L305:
        if (r55 != null) goto L307;
        r55 = r32;
    L307:
        r53.put("pic_id", r55);
        ImageData r56 = r111.image;
        if (r56 == null) goto L310;
        String r57 = r56.requestId;
    L311:
        if (r57 != null) goto L313;
        r57 = r32;
    L313:
        r53.put("request_id", r57);
        String r58 = r111.id;
        if (r58 != null) goto L316;
        r58 = r32;
    L316:
        r53.put("creation_task_id", r58);
        Unit r59 = Unit.INSTANCE;
        r113.getClass();
        JSONObject r212 = f(r51, r53);
        boolean r60 = r115.element;
        String r213 = (String) r116.element;
        CreationGenDetail r61 = r111.genDetail;
        if (r61 == null) goto L319;
        Integer r214 = r61.taskType;
    L320:
        r41.add(new sz9.b(r34, Boxing.boxBoolean(r30), r211, r210, false, true, r212, r213, r35, r60, Boxing.boxInt(r50), r214, 112));
        r0 = r49;
        r40 = r410;
        Collection r118 = r411;
        Iterator r119 = r52;
        final x r62 = r39;
        r5 = r117;
        r3 = r112;
        r11 = r32;
        r31 = r33;
        Map<String, UserCreationFromIM> r63 = r35;
        String r64 = r36;
        r110 = r110;
        List<sz9.b> r120 = r48;
    L321:
        r118.add(Unit.INSTANCE);
    L26:
        if (r119.hasNext() == false) goto L322;
        Object r121 = r119.next();
        r33 = r31 + 1;
        if (r31 >= 0) goto L30;
        CollectionsKt.throwIndexOverflow();
    L30:
        String r412 = r11;
        r111 = (CreationItem) r121;
        Object r413 = r5;
        Ref.ObjectRef r65 = new Ref.ObjectRef();
        Iterator r414 = r119;
        r115 = new Ref.BooleanRef();
        Collection r415 = r118;
        Ref.ObjectRef r122 = new Ref.ObjectRef();
        r122.element = r64;
        x r416 = r0;
        Ref.ObjectRef r66 = new Ref.ObjectRef();
        r35 = r63;
        CreationGenDetail r67 = r111.genDetail;
        if (r67 == null) goto L37;
        String r68 = r67.creationPrompt;
        if (r68 == null) goto L37;
        String r69 = p0.a(r68);
        if (r69 == null) goto L37;
        r122.element = r69;
        Unit r70 = Unit.INSTANCE;
    L37:
        Integer r71 = r111.type;
        if (r71 != null) goto L40;
        r36 = r64;
        Ref.ObjectRef r310 = r122;
    L170:
        if (r71 != null) goto L173;
    L254:
        Unit r72 = Unit.INSTANCE;
    L255:
        zo8.b r73 = null;
    L256:
        if (r73 == null) goto L258;
    L261:
        zo8.e r74 = (zo8.e) r65.element;
        CreationItem r75 = r62.f;
        if (r75 == null) goto L266;
        CreationGenDetail r76 = r75.genDetail;
        if (r76 == null) goto L266;
        Integer r77 = r76.taskType;
    L268:
        if (r77 != null) goto L271;
    L273:
        if (r77 != null) goto L276;
    L278:
        if (r77 != null) goto L281;
    L283:
        if (r77 != null) goto L286;
    L288:
        int r78 = 2;
    L289:
        Map r79 = r34.getBusinessExt();
        if (r79 == null) goto L292;
        String r80 = (String) r79.get("message_case_mode");
    L293:
        r30 = Intrinsics.areEqual(r80, "1");
        CreationDataSourceHelper r81 = a;
        r81.getClass();
        Map r123 = d(r40);
        if (r73 == null) goto L296;
        boolean r215 = true;
    L297:
        String r82 = r111.id;
        r112 = r3;
        r112.L$0 = r40;
        r112.L$1 = r120;
        r112.L$2 = r36;
        r112.L$3 = r35;
        r112.L$4 = r416;
        r112.L$5 = r62;
        r112.L$6 = r34;
        x r216 = r62;
        r112.L$7 = r110;
        r112.L$8 = r114;
        r112.L$9 = r415;
        r112.L$10 = r414;
        r112.L$11 = r111;
        r112.L$12 = r115;
        Ref.ObjectRef r83 = r310;
        r112.L$13 = r83;
        r112.L$14 = r73;
        r112.L$15 = r74;
        r112.L$16 = r123;
        r112.L$17 = r81;
        r112.L$18 = r120;
        r112.I$0 = r33;
        r112.I$1 = r31;
        r112.I$2 = r78;
        r112.Z$0 = r30;
        r112.label = 2;
        Object r84 = r81.g(r40, r34, r215, true, r82, r112);
        if (r84 != r413) goto L300;
        return r413;
    L300:
        r32 = r412;
        r210 = r74;
        r49 = r416;
        r113 = r81;
        r211 = r73;
        r48 = r120;
        r39 = r216;
        r52 = r414;
        r117 = r413;
        r41 = r48;
        int r311 = r78;
        r37 = r415;
        r51 = r123;
        r116 = r83;
        r38 = r84;
        r50 = r311;
        goto L301
    L296:
        r215 = false;
        goto L297
    L292:
        r80 = null;
        goto L293
    L286:
        if (r77.intValue() != 2) goto L288;
        r78 = 5;
        goto L289
    L281:
        if (r77.intValue() != 6) goto L283;
        r78 = 6;
        goto L289
    L276:
        if (r77.intValue() != 7) goto L278;
        r78 = 4;
        goto L289
    L271:
        if (r77.intValue() != 5) goto L273;
        r78 = 3;
    L266:
        r77 = null;
        goto L268
    L258:
        if (r65.element != null) goto L261;
        r11 = r412;
        r5 = r413;
        r119 = r414;
        r118 = r415;
        r0 = r416;
        r31 = r33;
        r63 = r35;
        r64 = r36;
        r3 = r3;
        r110 = r110;
        goto L321
    L173:
        if (r71.intValue() != 1) goto L254;
        ImageData r85 = r111.image;
        if (r85 == null) goto L255;
        String r86 = r85.imageUri;
        if (r86 != null) goto L179;
        r86 = r85.key;
    L179:
        r66.element = r86;
        ImageObj r87 = r85.imagePreview;
        if (r87 == null) goto L182;
        String r88 = bz9.a.a(r87);
    L183:
        if (r88 != null) goto L186;
        r88 = r412;
    L186:
        if (r88.length() != 0) goto L188;
        boolean r89 = true;
    L189:
        if (r89 == false) goto L191;
        r88 = bz9.a.c(r85);
    L191:
        String r124 = r88;
        ImageObj r90 = r85.imageOrigin;
        if (r90 == null) goto L194;
        String r125 = r90.url;
    L195:
        ImageObj r91 = r85.imageOriRaw;
        if (r91 == null) goto L198;
        String r217 = r91.url;
    L200:
        if (ap8.a.c(r34) == true) goto L209;
        CreationGenDetail r92 = r111.genDetail;
        if (r92 == null) goto L209;
        List r93 = r92.refImages;
        if (r93 == null) goto L209;
        ImageObj r94 = (ImageObj) CollectionsKt.firstOrNull(r93);
        if (r94 == null) goto L209;
        String r218 = r94.url;
    L210:
        ImageObj r95 = r85.imageOrigin;
        if (r95 == null) goto L213;
        Long r219 = Boxing.boxLong(r95.width);
    L214:
        ImageObj r96 = r85.imageOrigin;
        if (r96 == null) goto L217;
        Long r220 = Boxing.boxLong(r96.height);
    L218:
        n1 r97 = new n1(r124, r125, r217, r218, r219, r220);
        CreationNoWatermarkManager r98 = CreationNoWatermarkManager.a;
        String r99 = r85.imageUri;
        if (r99 != null) goto L221;
        r99 = r85.key;
    L221:
        r98.getClass();
        Intrinsics.checkNotNullParameter(r97, "original");
        CreationNoWatermarkManager$d r100 = r98.V(r99, r97, false);
        n1 r101 = (n1) r100.a;
        if (r114 == null) goto L224;
        fz9.a r102 = (fz9.a) r114.get(r111.id);
    L225:
        String r126 = r101.a;
        if (r126 != null) goto L229;
        r126 = r412;
    L229:
        if (r126.length() != 0) goto L231;
        boolean r127 = true;
    L232:
        if (r127 == false) goto L237;
        String r103 = bz9.a.c(r85);
        if (r103 != null) goto L236;
        r103 = r412;
    L236:
        String r128 = r103;
    L238:
        String r104 = r111.id;
        Boolean r129 = r111.canPublish;
        if (r129 == null) goto L241;
        boolean r130 = r129.booleanValue();
    L242:
        if (r130 == true) goto L244;
    L246:
        boolean r221 = false;
    L247:
        if (r102 == null) goto L249;
        String r222 = r102.a();
    L250:
        if (r102 == null) goto L252;
        String r223 = r102.b();
    L253:
        zo8.b r105 = new zo8.b(r101, r128, "", r104, r221, true, r222, r223, (String) r66.element);
        r115.element = r100.b;
        Unit r106 = Unit.INSTANCE;
        r73 = r105;
        goto L256
    L252:
        r223 = null;
        goto L253
    L249:
        r222 = null;
        goto L250
    L244:
        if (AccountService.a.isLogin().booleanValue() == false) goto L246;
        z2.a.w3();
        r221 = true;
        goto L247
    L241:
        r130 = false;
        goto L242
    L237:
        r128 = r126;
        goto L238
    L231:
        r127 = false;
        goto L232
    L224:
        r102 = null;
        goto L225
    L217:
        r220 = null;
        goto L218
    L213:
        r219 = null;
    L209:
        r218 = null;
        goto L210
    L198:
        r217 = null;
        goto L200
    L194:
        r125 = null;
        goto L195
    L188:
        r89 = false;
        goto L189
    L182:
        r88 = null;
        goto L183
    L40:
        r310 = r122;
        r36 = r64;
        if (r71.intValue() != 2) goto L170;
        VideoData r107 = r111.video;
        if (r107 == null) goto L167;
        String r108 = r111.id;
        Function0<String> r131 = r62.n;
        if (r131 == null) goto L48;
        String r132 = (String) r131.invoke();
        if (r132 == null) goto L48;
    L53:
        String r133 = r132;
    L55:
        String r134 = r34.getMessageId();
        Function0<BotModel> r135 = r62.o;
        if (r135 == null) goto L59;
        BotModel r136 = (BotModel) r135.invoke();
        if (r136 == null) goto L59;
    L64:
        BotModel r224 = r136;
    L66:
        Function0<wc9.e> r137 = r62.p;
        if (r137 == null) goto L70;
        wc9.e r138 = (wc9.e) r137.invoke();
        if (r138 == null) goto L70;
    L75:
        wc9.e r225 = r138;
    L77:
        c4 r109 = new c4(r133, r134, "chat", r224, r225, "click", "0", r111.id, Boxing.boxInt(r33), tz9.a.a(r34), Boxing.boxBoolean(com.larus.im.bean.message.a.C0(r34)), r34, r110, null, 8192);
        CreationItem r139 = r62.f;
        if (r139 == null) goto L80;
        String r140 = r139.id;
    L82:
        if (o0.d(r140) == false) goto L95;
        CreationItem r141 = r62.f;
        if (r141 == null) goto L86;
        String r142 = r141.id;
    L88:
        if (Intrinsics.areEqual(r142, r111.id) == false) goto L96;
        iy9.b r143 = r62.c;
        if (r143 == null) goto L96;
        Long r144 = r143.d;
        if (r144 == null) goto L96;
        r3 = r3;
        Integer r145 = Boxing.boxInt((int) r144.longValue());
    L97:
        if (r145 == null) goto L99;
        int r226 = r145.intValue();
        r31 = r31;
        r3 = r3;
    L126:
        String r227 = UUID.randomUUID().toString();
        b r146 = new b(r62);
        z2 r147 = z2.a;
        boolean r228 = r147.getCreationExtendVideoConfig().b();
        nr9.g r148 = bz9.a.l(r107);
        CreationNoWatermarkManager r149 = CreationNoWatermarkManager.a;
        r110 = r110;
        String r150 = r107.vid;
        Cover r151 = r107.cover;
        if (r151 == null) goto L129;
        String r152 = r151.key;
    L130:
        nr9.g r153 = r149.c0(r150, r148, r152);
        if (r153 == null) goto L134;
        r148 = r153;
    L134:
        CreationItem r154 = r62.f;
        if (r154 == null) goto L137;
        String r155 = r154.id;
    L139:
        if (o0.d(r155) == false) goto L153;
        CreationItem r156 = r62.f;
        if (r156 == null) goto L143;
        String r157 = r156.id;
    L145:
        if (Intrinsics.areEqual(r157, r111.id) == false) goto L153;
        nr9.f r158 = r148.g;
        if (r158 == null) goto L153;
        iy9.b r159 = r62.c;
        if (r159 == null) goto L151;
        Bitmap r160 = r159.e;
    L152:
        r158.f = r160;
        Unit r161 = Unit.INSTANCE;
        goto L153
    L151:
        r160 = null;
        goto L152
    L143:
        r157 = null;
    L153:
        iy9.b r162 = r62.c;
        if (r162 == null) goto L156;
        Function2<String, IVideoController, Unit> r229 = r162.b;
    L157:
        Boolean r163 = r111.canPublish;
        if (r163 == null) goto L160;
        boolean r164 = r163.booleanValue();
    L161:
        if (r164 == true) goto L163;
    L165:
        boolean r230 = false;
    L166:
        r65.element = new zo8.e(null, r109, r148, r226, r227, r146, r229, r228, new com.larus.uaigc.creation.gallery.datasource.b(), new com.larus.uaigc.creation.gallery.datasource.c(r34, r111, r62), r108, r230, true, 1);
        goto L255
    L163:
        if (AccountService.a.isLogin().booleanValue() == false) goto L165;
        r147.w3();
        r230 = true;
        goto L166
    L160:
        r164 = false;
        goto L161
    L156:
        r229 = null;
        goto L157
    L137:
        r155 = null;
        goto L139
    L129:
        r152 = null;
        goto L130
    L99:
        ps8.a r165 = IAIChatUgcAIGCService.a.L();
        int r166 = hz9.a.a;
        String r167 = r111.id;
        if (r167 != null) goto L103;
        r167 = r412;
    L103:
        if (r167.length() != 0) goto L105;
        boolean r168 = true;
    L106:
        if (r168 == false) goto L108;
        r167 = String.valueOf(r31);
    L108:
        r3 = r3;
        r31 = r31;
        IVideoController r169 = r165.a(hz9.a.b(r34, r167, false, 12), "ugc_video", "message_card");
        if (r169 == null) goto L111;
        Integer r170 = Boxing.boxInt(r169.getCurrentPlaybackTime());
    L112:
        if (r170 != null) goto L124;
        iy9.b r171 = r62.c;
        if (r171 == null) goto L122;
        Function1<String, Integer> r172 = r171.a;
        if (r172 == null) goto L122;
        String r173 = r107.vid;
        if (r173 != null) goto L121;
        r173 = r412;
    L121:
        r170 = (Integer) r172.invoke(r173);
    L123:
        if (r170 != null) goto L124;
        r226 = 0;
    L122:
        r170 = null;
    L124:
        r226 = r170.intValue();
        goto L126
    L111:
        r170 = null;
        goto L112
    L105:
        r168 = false;
    L96:
        r145 = null;
        goto L97
    L86:
        r142 = null;
        goto L88
    L95:
        r33 = r33;
        goto L96
    L80:
        r140 = null;
    L70:
        q0.a r174 = r62.b;
        if (r174 == null) goto L76;
        y r175 = r174.u0();
        if (r175 == null) goto L76;
        r138 = r175.h();
    L76:
        r225 = null;
    L59:
        q0.a r176 = r62.b;
        if (r176 == null) goto L65;
        y r177 = r176.u0();
        if (r177 == null) goto L65;
        r136 = r177.j0();
    L65:
        r224 = null;
    L48:
        q0.a r178 = r62.b;
        if (r178 == null) goto L54;
        y r179 = r178.u0();
        if (r179 == null) goto L54;
        r132 = r179.getBotId();
    L54:
        r133 = null;
        goto L55
    L167:
        r3 = r3;
        r33 = r33;
        r31 = r31;
        r110 = r110;
        goto L255
    L322:
        List r180 = (List) r118;
    L326:
        return r0;
    L319:
        r214 = null;
        goto L320
    L310:
        r57 = null;
        goto L311
    L304:
        r55 = null;
        goto L305
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Message r181 = (Message) r3.L$6;
        r62 = (x) r3.L$5;
        x r182 = (x) r3.L$4;
        Map<String, UserCreationFromIM> r183 = (Map) r3.L$3;
        String r184 = (String) r3.L$2;
        List<sz9.b> r185 = (List) r3.L$1;
        x r186 = (x) r3.L$0;
        ResultKt.throwOnFailure(r2);
        Object r187 = r2;
        r40 = r186;
        r34 = r181;
        r0 = r182;
        r63 = r183;
        r64 = r184;
    L24:
        r110 = (JSONObject) r187;
        List<CreationItem> r188 = bz9.a.g(r34);
        CreationChatItemClickHelper.a.getClass();
        r114 = CreationChatItemClickHelper.j(r34);
        r118 = new ArrayList();
        r119 = ((ArrayList) r188).iterator();
        r120 = r185;
        r31 = 0;
        goto L26
    L16:
        ResultKt.throwOnFailure(r2);
        if (r0 == null) goto L324;
        if (r43 == null) goto L326;
        CreationDataSourceHelper r189 = a;
        r3.L$0 = r0;
        r3.L$1 = r44;
        r64 = r45;
        r3.L$2 = r64;
        r63 = r46;
        r3.L$3 = r63;
        r3.L$4 = r0;
        r3.L$5 = r0;
        r3.L$6 = r43;
        r3.label = 1;
        r189.getClass();
        Object r190 = BuildersKt.withContext(Dispatchers.getIO(), new CreationDataSourceHelper$getVideoRecommendParams$2(r43, null), r3);
        if (r190 != r5) goto L23;
        return r5;
    L23:
        r187 = r190;
        r185 = r44;
        r40 = r0;
        r34 = r43;
        r62 = r40;
        goto L24
    L324:
        return null;
    L7:
        r3 = new CreationDataSourceHelper$parseBlockItemData$1(this, r47);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:127:0x02c8 -> B:128:0x02e9). Please report as a decompilation issue!!! */
    public final Object j(x r36, Message r37, List<sz9.b> r38, String r39, Map<String, UserCreationFromIM> r40, Continuation<? super Message> r41) {
        final Message r1 = r37;
        if ((r41 instanceof CreationDataSourceHelper$parseImageItemData$1) == false) goto L7;
        CreationDataSourceHelper$parseImageItemData$1 r2 = (CreationDataSourceHelper$parseImageItemData$1) r41;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r0 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        boolean r6 = r2.Z$1;
        boolean r7 = r2.Z$0;
        int r11 = r2.I$2;
        int r12 = r2.I$1;
        int r13 = r2.I$0;
        List<sz9.b> r14 = (List) r2.L$12;
        CreationDataSourceHelper r15 = (CreationDataSourceHelper) r2.L$11;
        Map r8 = (Map) r2.L$10;
        zo8.b r9 = (zo8.b) r2.L$9;
        ImageItem r10 = (ImageItem) r2.L$8;
        Iterator r16 = (Iterator) r2.L$7;
        Function1 r17 = (Function1) r2.L$6;
        Message r18 = (Message) r2.L$5;
        Message r19 = (Message) r2.L$4;
        Map<String, UserCreationFromIM> r20 = (Map) r2.L$3;
        String r110 = (String) r2.L$2;
        List<sz9.b> r111 = (List) r2.L$1;
        x r21 = (x) r2.L$0;
        ResultKt.throwOnFailure(r0);
        Message r112 = r18;
        Message r24 = r19;
        Map<String, UserCreationFromIM> r113 = r20;
        CreationDataSourceHelper$parseImageItemData$1 r22 = r2;
        Object r23 = r4;
        Iterator r25 = r16;
        String r26 = "";
        int r27 = r13;
        CreationDataSourceHelper r114 = r15;
        boolean r28 = r6;
        Function1 r115 = r17;
    L128:
        Map r29 = MapsKt.toMutableMap((Map) r0);
        r29.put("position", Boxing.boxInt(r12 + 1));
        String r30 = r10.getKey();
        if (r30 != null) goto L131;
        r30 = r26;
    L131:
        r29.put("pic_id", r30);
        String r31 = r10.getRequestId();
        if (r31 != null) goto L134;
        r31 = r26;
    L134:
        r29.put("request_id", r31);
        TemplateInfo$TemplateInfo r32 = (TemplateInfo$TemplateInfo) r115.invoke(Boxing.boxInt(r12));
        if (r32 == null) goto L137;
        Long r33 = Boxing.boxLong(r32.a);
    L138:
        if (r33 == null) goto L140;
        r29.put("from_template_id", r33);
    L140:
        Unit r34 = Unit.INSTANCE;
        r114.getClass();
        JSONObject r35 = f(r8, r29);
        if (r21 == null) goto L147;
        CreationItem r42 = r21.f;
        if (r42 == null) goto L147;
        CreationGenDetail r43 = r42.genDetail;
        if (r43 == null) goto L147;
        Integer r210 = r43.taskType;
    L148:
        List<sz9.b> r310 = r14;
        r310.add(new sz9.b(r112, Boxing.boxBoolean(r7), r9, null, r28, false, r35, r110, r113, false, Boxing.boxInt(r11), r210, 2264));
        x r44 = r21;
        Message r45 = r112;
        String r46 = r110;
        List<sz9.b> r47 = r111;
        Map<String, UserCreationFromIM> r48 = r113;
        CreationDataSourceHelper$parseImageItemData$1 r49 = r22;
        Object r116 = r23;
        Iterator r117 = r25;
        String r118 = r26;
        r1 = r24;
        int r119 = r27;
        Function1 r50 = r115;
    L38:
        if (r117.hasNext() == false) goto L159;
        Object r120 = r117.next();
        int r121 = r119 + 1;
        if (r119 >= 0) goto L42;
        CollectionsKt.throwIndexOverflow();
    L42:
        ImageItem r122 = (ImageItem) r120;
        ImageItem r51 = (ImageItem) CreationNoWatermarkManager.a.R(r122).a;
        if (r51 != null) goto L45;
        r51 = r122;
    L45:
        ImageEntity r123 = r122.getImageOrigin();
        if (r123 == null) goto L51;
        String r124 = r123.getUri();
        if (r124 == null) goto L51;
    L50:
        String r311 = r124;
        String r125 = df8.b.a(r51);
        ImageEntity r126 = r122.getImageOrigin();
        if (r126 == null) goto L70;
        String r127 = r126.getUrl();
    L71:
        ImageEntity r128 = r122.getRawImage();
        if (r128 == null) goto L74;
        String r129 = r128.getUrl();
    L76:
        if (ap8.a.c(r45) == true) goto L81;
        ImageEntity r130 = r122.getRefImage();
        if (r130 == null) goto L81;
        String r211 = r130.getUrl();
    L82:
        ImageEntity r131 = r122.getImageOrigin();
        String r312 = r118;
        if (r131 == null) goto L85;
        Long r212 = Boxing.boxLong(r131.getWidth());
    L86:
        ImageEntity r132 = r122.getImageOrigin();
        if (r132 == null) goto L89;
        Long r213 = Boxing.boxLong(r132.getHeight());
    L90:
        n1 r214 = new n1(r125, r127, r129, r211, r212, r213);
        String r52 = df8.b.b(r51);
        if (r52 != null) goto L93;
        String r215 = r312;
    L94:
        Integer r53 = r122.getIndex();
        if (r53 == null) goto L97;
        int r54 = r53.intValue();
    L98:
        String r216 = String.valueOf(r54);
        z2.a.w3();
        zo8.b r55 = new zo8.b(r214, r215, r216, null, true, false, null, null, r311, 232);
        String r56 = ap8.a.b(r45);
        if (r56 == null) goto L119;
        int r133 = r56.hashCode();
        if (r133 == (-2096799662)) goto L116;
        if (r133 == (-578836747)) goto L112;
        if (r133 != 1220276612) goto L119;
        if (r56.equals("image2image") == false) goto L119;
        int r57 = 5;
    L120:
        boolean r134 = com.larus.bmhome.chat.bean.d.y(r45);
        Map r135 = r45.getBusinessExt();
        Object r217 = r116;
        if (r135 == null) goto L123;
        String r136 = (String) r135.get("message_case_mode");
    L124:
        boolean r137 = Intrinsics.areEqual(r136, "1");
        r114 = a;
        r114.getClass();
        Map r138 = d(r44);
        r49.L$0 = r44;
        r49.L$1 = r47;
        r49.L$2 = r46;
        r49.L$3 = r48;
        r49.L$4 = r1;
        r49.L$5 = r45;
        r49.L$6 = r50;
        r49.L$7 = r117;
        r49.L$8 = r122;
        r49.L$9 = r55;
        r49.L$10 = r138;
        r49.L$11 = r114;
        r49.L$12 = r47;
        r49.I$0 = r121;
        r24 = r1;
        r49.I$1 = r119;
        r49.I$2 = r57;
        r49.Z$0 = r137;
        r49.Z$1 = r134;
        r49.label = 1;
        Object r58 = r114.g(r44, r45, true, false, null, r49);
        x r313 = r44;
        if (r58 != r217) goto L127;
        return r217;
    L127:
        r26 = r312;
        r23 = r217;
        r0 = r58;
        r112 = r45;
        r111 = r47;
        r110 = r46;
        r113 = r48;
        r22 = r49;
        r25 = r117;
        r8 = r138;
        r27 = r121;
        r12 = r119;
        r28 = r134;
        r21 = r313;
        r9 = r55;
        r11 = r57;
        r115 = r50;
        r7 = r137;
        r10 = r122;
        r14 = r111;
        goto L128
    L123:
        r136 = null;
        goto L124
    L112:
        if (r56.equals("avatar_image") == false) goto L119;
        r57 = 3;
        goto L120
    L116:
        if (r56.equals("ai_beautify_image") == false) goto L119;
        r57 = 4;
    L119:
        r57 = 2;
        goto L120
    L97:
        r54 = 0;
        goto L98
    L93:
        r215 = r52;
        goto L94
    L89:
        r213 = null;
        goto L90
    L85:
        r212 = null;
    L81:
        r211 = null;
        goto L82
    L74:
        r129 = null;
        goto L76
    L70:
        r127 = null;
    L51:
        ImageEntity r139 = r122.getPreviewImage();
        if (r139 == null) goto L54;
        r124 = r139.getUri();
    L55:
        if (r124 != null) goto L50;
        ImageEntity r140 = r122.getImageThumb();
        if (r140 == null) goto L59;
        r124 = r140.getUri();
    L60:
        if (r124 != null) goto L50;
        ImageEntity r141 = r122.getRawImage();
        if (r141 == null) goto L64;
        r124 = r141.getUri();
    L65:
        if (r124 != null) goto L50;
        r124 = r122.getKey();
        goto L50
    L64:
        r124 = null;
        goto L65
    L59:
        r124 = null;
        goto L60
    L54:
        r124 = null;
    L159:
        return r1;
    L147:
        r210 = null;
        goto L148
    L137:
        r33 = null;
        goto L138
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        if (r1 == null) goto L150;
        ImageContentData r59 = IAIChatUgcAIGCService.a.d0(r1);
        CreationDataSourceHelper r60 = a;
        IMMsgExt r61 = com.larus.bmhome.chat.bean.d.x(r37);
        r60.getClass();
        String r62 = r61.getTemplateData();
        if (r62 != null) goto L152;
    L23:
        final List r63 = null;
    L24:
        Function1 r64 = new com.larus.uaigc.creation.gallery.datasource.a(r63, r1);
        if (r59 == null) goto L159;
        List r65 = r59.getImageList();
        if (r65 == null) goto L159;
        List r66 = CollectionsKt.take(r65, 4);
        if (r66 == null) goto L159;
        ArrayList r67 = new ArrayList();
        Iterator r68 = r66.iterator();
    L32:
        if (r68.hasNext() == false) goto L36;
        Object r69 = r68.next();
        if (df8.b.c((ImageItem) r69) == false) goto L32;
        r67.add(r69);
        goto L32
    L36:
        Iterator r70 = r67.iterator();
        r48 = r40;
        r117 = r70;
        r49 = r2;
        r50 = r64;
        r118 = "";
        r119 = 0;
        r44 = r36;
        r46 = r39;
        r45 = r1;
        r116 = r4;
        r47 = r38;
        goto L38
    L152:
        r63 = (List) new Gson().fromJson(r62, new i().getType());     // Catch: Exception -> L21
    L21:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        goto L23
    L150:
        return null;
    L7:
        r2 = new CreationDataSourceHelper$parseImageItemData$1(this, r41);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:233:0x04ca -> B:234:0x04e7). Please report as a decompilation issue!!! */
    public final Object k(x r51, Message r52, List<sz9.b> r53, String r54, Map<String, UserCreationFromIM> r55, Continuation<? super x> r56) {
        x r0 = r51;
        if ((r56 instanceof CreationDataSourceHelper$parseMDItemData$1) == false) goto L7;
        CreationDataSourceHelper$parseMDItemData$1 r3 = (CreationDataSourceHelper$parseMDItemData$1) r56;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        String r11 = "";
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        boolean r1 = r3.Z$0;
        int r7 = r3.I$3;
        int r8 = r3.I$2;
        int r12 = r3.I$1;
        int r13 = r3.I$0;
        List<sz9.b> r14 = (List) r3.L$15;
        CreationDataSourceHelper r15 = (CreationDataSourceHelper) r3.L$14;
        Map r9 = (Map) r3.L$13;
        zo8.e r10 = (zo8.e) r3.L$12;
        zo8.b r16 = (zo8.b) r3.L$11;
        CreationTask r17 = (CreationTask) r3.L$10;
        Iterator r18 = (Iterator) r3.L$9;
        Collection r19 = (Collection) r3.L$8;
        JSONObject r20 = (JSONObject) r3.L$7;
        Message r21 = (Message) r3.L$6;
        x r22 = (x) r3.L$5;
        x r23 = (x) r3.L$4;
        Map<String, UserCreationFromIM> r24 = (Map) r3.L$3;
        String r25 = (String) r3.L$2;
        List<sz9.b> r26 = (List) r3.L$1;
        x r27 = (x) r3.L$0;
        ResultKt.throwOnFailure(r2);
        Message r28 = r21;
        zo8.e r38 = r10;
        zo8.b r37 = r16;
        CreationDataSourceHelper r110 = r15;
        x r29 = r22;
        x r210 = r23;
        Map<String, UserCreationFromIM> r30 = r24;
        int r111 = r7;
        Object r112 = r5;
        int r113 = r13;
        List<sz9.b> r31 = r14;
        String r114 = r25;
        Collection r32 = r19;
        JSONObject r115 = r20;
        boolean r33 = r1;
        Iterator r57 = r18;
        CreationDataSourceHelper$parseMDItemData$1 r58 = r3;
        x r34 = r27;
    L234:
        Map r35 = MapsKt.toMutableMap((Map) r2);
        Object r59 = r112;
        r35.put("position", Boxing.boxInt(r12 + 1));
        if (r17 == null) goto L244;
        CreationAsset r116 = r17.asset;
        if (r116 == null) goto L244;
        UserCreationImage r117 = r116.imageContent;
        if (r117 == null) goto L244;
        ImageInfo r118 = r117.a;
        if (r118 == null) goto L244;
        String r119 = r118.e;
        if (r119 == null) goto L244;
    L245:
        r35.put("pic_id", r119);
        if (r17 == null) goto L255;
        CreationAsset r36 = r17.asset;
        if (r36 == null) goto L255;
        UserCreationImage r39 = r36.imageContent;
        if (r39 == null) goto L255;
        ImageInfo r40 = r39.a;
        if (r40 == null) goto L255;
        String r41 = r40.f;
        if (r41 == null) goto L255;
    L256:
        r35.put("request_id", r41);
        Unit r42 = Unit.INSTANCE;
        r110.getClass();
        JSONObject r43 = f(r9, r35);
        CreationItem r44 = r34.f;
        if (r44 == null) goto L261;
        CreationGenDetail r45 = r44.genDetail;
        if (r45 == null) goto L261;
        Integer r46 = r45.taskType;
    L262:
        Boolean r310 = Boxing.boxBoolean(r33);
        if (r8 == 0) goto L265;
        boolean r47 = true;
    L266:
        Message r311 = r28;
        String r48 = r114;
        Map<String, UserCreationFromIM> r49 = r30;
        r32.add(Boxing.boxBoolean(r31.add(new sz9.b(r311, r310, r37, r38, false, true, r43, r48, r49, r47, Boxing.boxInt(r111), r46, 112))));
        Iterator r50 = r57;
        Object r60 = r59;
        final Message r61 = r28;
        String r62 = r114;
        JSONObject r120 = r115;
        int r121 = r113;
        List<sz9.b> r122 = r26;
        x r63 = r210;
        final x r64 = r29;
        Collection r123 = r32;
        CreationDataSourceHelper$parseMDItemData$1 r65 = r58;
    L30:
        if (r50.hasNext() == false) goto L267;
        Object r124 = r50.next();
        int r125 = r121 + 1;
        if (r121 >= 0) goto L34;
        CollectionsKt.throwIndexOverflow();
    L34:
        final CreationTask r66 = (CreationTask) r124;
        String r510 = r11;
        Ref.ObjectRef r126 = new Ref.ObjectRef();
        if (r66 == null) goto L37;
        Integer r67 = r66.loadingAssetType;
    L38:
        if (r67 != null) goto L41;
        int r511 = r121;
    L40:
        Collection r512 = r123;
        if (r66 == null) goto L195;
        CreationAsset r68 = r66.asset;
        if (r68 == null) goto L195;
        UserCreationImage r69 = r68.imageContent;
        if (r69 == null) goto L195;
        ImageInfo r70 = r69.a;
        if (r70 == null) goto L195;
        Image r71 = r70.c;
        if (r71 == null) goto L140;
        String r72 = bz9.a.b(r71);
    L141:
        Image r73 = r70.a;
        if (r73 == null) goto L144;
        String r211 = r73.a;
    L145:
        Image r74 = r70.i;
        if (r74 == null) goto L148;
        String r212 = r74.a;
    L150:
        if (ap8.a.c(r61) == true) goto L155;
        Image r75 = r70.d;
        if (r75 == null) goto L155;
        String r213 = r75.a;
    L156:
        Image r76 = r70.a;
        if (r76 == null) goto L159;
        Long r214 = Boxing.boxLong(r76.c);
    L160:
        Image r77 = r70.a;
        if (r77 == null) goto L163;
        Long r215 = Boxing.boxLong(r77.d);
    L164:
        n1 r78 = new n1(r72, r211, r212, r213, r214, r215);
        if (r72 != null) goto L168;
        r72 = r510;
    L168:
        if (r72.length() != 0) goto L170;
        boolean r79 = true;
    L171:
        if (r79 == false) goto L189;
        Image r80 = r70.b;
        if (r80 == null) goto L175;
        r72 = r80.b;
    L177:
        if (Build.VERSION.SDK_INT > 26) goto L179;
    L182:
        Image r81 = r70.b;
        if (r81 == null) goto L185;
        String r82 = r81.a;
    L186:
        if (r82 != null) goto L188;
    L187:
        String r216 = r510;
    L190:
        Integer r83 = r66.index;
        if (r83 == null) goto L193;
        int r84 = r83.intValue();
    L194:
        String r217 = String.valueOf(r84);
        z2.a.w3();
        zo8.b r127 = new zo8.b(r78, r216, r217, null, true, false, null, null, null, 488);
    L196:
        zo8.e r85 = (zo8.e) r126.element;
        String r86 = ap8.a.b(r61);
        if (r86 == null) goto L217;
        int r87 = r86.hashCode();
        if (r87 == (-2096799662)) goto L214;
        if (r87 == (-578836747)) goto L210;
        if (r87 != 1220276612) goto L217;
        if (r86.equals("image2image") == false) goto L217;
        int r88 = 5;
    L218:
        Map r89 = r61.getBusinessExt();
        if (r89 == null) goto L221;
        String r90 = (String) r89.get("message_case_mode");
    L222:
        boolean r91 = Intrinsics.areEqual(r90, "1");
        CreationDataSourceHelper r92 = a;
        r92.getClass();
        Map r128 = d(r34);
        if (r127 == null) goto L225;
        boolean r218 = true;
    L227:
        if (r66 == null) goto L229;
        String r219 = r66.id;
    L230:
        r65.L$0 = r34;
        r65.L$1 = r122;
        r114 = r62;
        r65.L$2 = r114;
        Map<String, UserCreationFromIM> r129 = r30;
        r65.L$3 = r129;
        r65.L$4 = r63;
        r65.L$5 = r64;
        r65.L$6 = r61;
        r65.L$7 = r120;
        r210 = r63;
        Collection r93 = r512;
        r65.L$8 = r93;
        r29 = r64;
        r65.L$9 = r50;
        r65.L$10 = r66;
        r65.L$11 = r127;
        r65.L$12 = r85;
        r65.L$13 = r128;
        r65.L$14 = r92;
        r65.L$15 = r122;
        r65.I$0 = r125;
        r65.I$1 = r511;
        r65.I$2 = 0;
        r65.I$3 = r88;
        r65.Z$0 = r91;
        r65.label = 2;
        r2 = r92.g(r34, r61, r218, true, r219, r65);
        r111 = r88;
        Object r94 = r60;
        if (r2 != r94) goto L233;
        return r94;
    L233:
        r38 = r85;
        r110 = r92;
        r37 = r127;
        r30 = r129;
        r26 = r122;
        r112 = r94;
        r17 = r66;
        r28 = r61;
        r33 = r91;
        r9 = r128;
        r115 = r120;
        r8 = 0;
        r11 = r510;
        r12 = r511;
        r57 = r50;
        r58 = r65;
        r32 = r93;
        r31 = r26;
        r113 = r125;
        goto L234
    L229:
        r219 = null;
        goto L230
    L225:
        r218 = false;
        goto L227
    L221:
        r90 = null;
        goto L222
    L210:
        if (r86.equals("avatar_image") == false) goto L217;
        r88 = 3;
        goto L218
    L214:
        if (r86.equals("ai_beautify_image") == false) goto L217;
        r88 = 4;
    L217:
        r88 = 2;
        goto L218
    L193:
        r84 = r511;
        goto L194
    L188:
        r216 = r82;
        goto L190
    L185:
        r82 = null;
        goto L186
    L179:
        if (o0.d(r72) == false) goto L182;
        if (r72 != null) goto L189;
    L175:
        r72 = null;
    L189:
        r216 = r72;
        goto L190
    L170:
        r79 = false;
        goto L171
    L163:
        r215 = null;
        goto L164
    L159:
        r214 = null;
    L155:
        r213 = null;
        goto L156
    L148:
        r212 = null;
        goto L150
    L144:
        r211 = null;
        goto L145
    L140:
        r72 = null;
    L195:
        r127 = null;
        goto L196
    L41:
        r511 = r121;
        if (r67.intValue() != 7) goto L40;
        CreationAsset r95 = r66.asset;
        if (r95 == null) goto L128;
        ep8.a r96 = r95.videoContent;
        if (r96 == null) goto L128;
        AiGenVideoContentData r97 = r96.videoInfo;
        if (r97 == null) goto L128;
        String r130 = r66.id;
        r50 = r50;
        Integer r98 = r66.index;
        if (r98 == null) goto L52;
        int r99 = r98.intValue();
    L53:
        String r100 = String.valueOf(r99);
        r512 = r123;
        Function0<String> r131 = r64.n;
        if (r131 == null) goto L57;
        String r132 = (String) r131.invoke();
        if (r132 == null) goto L57;
    L62:
        String r133 = r132;
    L64:
        String r220 = r61.getMessageId();
        Function0<BotModel> r134 = r64.o;
        if (r134 == null) goto L68;
        BotModel r135 = (BotModel) r134.invoke();
        if (r135 == null) goto L68;
    L73:
        BotModel r221 = r135;
    L75:
        Function0<wc9.e> r136 = r64.p;
        if (r136 == null) goto L79;
        wc9.e r137 = (wc9.e) r136.invoke();
        if (r137 == null) goto L79;
    L84:
        wc9.e r222 = r137;
    L86:
        r125 = r125;
        c4 r312 = new c4(r133, r220, "chat", r221, r222, "click", "0", r66.id, Boxing.boxInt(r125), tz9.a.a(r61), Boxing.boxBoolean(com.larus.im.bean.message.a.C0(r61)), r34.a, r120, null, 8192);
        if (Intrinsics.areEqual(r64.d, r66.id) == false) goto L93;
        iy9.b r138 = r64.c;
        if (r138 == null) goto L93;
        Long r139 = r138.d;
        if (r139 == null) goto L93;
        Integer r101 = Boxing.boxInt((int) r139.longValue());
    L94:
        if (r101 == null) goto L96;
        int r223 = r101.intValue();
        r62 = r62;
    L114:
        String r224 = UUID.randomUUID().toString();
        c r102 = new c(r64);
        z2 r103 = z2.a;
        boolean r225 = r103.getCreationExtendVideoConfig().b();
        nr9.g r104 = ff8.a.a(r97);
        if (Intrinsics.areEqual(r64.d, r66.id) == false) goto L123;
        nr9.f r140 = r104.g;
        if (r140 == null) goto L123;
        iy9.b r141 = r64.c;
        if (r141 == null) goto L121;
        Bitmap r142 = r141.e;
    L122:
        r140.f = r142;
        Unit r143 = Unit.INSTANCE;
        goto L123
    L121:
        r142 = null;
    L123:
        iy9.b r144 = r64.c;
        if (r144 == null) goto L126;
        Function2<String, IVideoController, Unit> r226 = r144.b;
    L127:
        r103.w3();
        r126.element = new zo8.e(r100, r312, r104, r223, r224, r102, r226, r225, new d(), new e(r61, r66, r64), r130, true, false, 4096);
        goto L195
    L126:
        r226 = null;
        goto L127
    L96:
        ps8.a r105 = IAIChatUgcAIGCService.a.L();
        int r106 = hz9.a.a;
        r62 = r62;
        IVideoController r107 = r105.a(hz9.a.b(r61, r66.id, false, 12), "ugc_video", "message_card");
        if (r107 == null) goto L99;
        Integer r108 = Boxing.boxInt(r107.getCurrentPlaybackTime());
    L100:
        if (r108 != null) goto L112;
        iy9.b r109 = r64.c;
        if (r109 == null) goto L110;
        Function1<String, Integer> r145 = r109.a;
        if (r145 == null) goto L110;
        String r146 = r97.getVid();
        if (r146 != null) goto L109;
        r146 = r510;
    L109:
        r108 = (Integer) r145.invoke(r146);
    L111:
        if (r108 != null) goto L112;
        r223 = 0;
    L110:
        r108 = null;
    L112:
        r223 = r108.intValue();
        goto L114
    L99:
        r108 = null;
    L93:
        r101 = null;
    L79:
        q0.a r147 = r64.b;
        if (r147 == null) goto L85;
        y r148 = r147.u0();
        if (r148 == null) goto L85;
        r137 = r148.h();
    L85:
        r222 = null;
    L68:
        q0.a r149 = r64.b;
        if (r149 == null) goto L74;
        y r150 = r149.u0();
        if (r150 == null) goto L74;
        r135 = r150.j0();
    L74:
        r221 = null;
    L57:
        q0.a r151 = r64.b;
        if (r151 == null) goto L63;
        y r152 = r151.u0();
        if (r152 == null) goto L63;
        r132 = r152.getBotId();
    L63:
        r133 = null;
        goto L64
    L52:
        r99 = r511;
    L128:
        r50 = r50;
        r62 = r62;
        r30 = r30;
        r125 = r125;
        r512 = r123;
        goto L195
    L37:
        r67 = null;
        goto L38
    L267:
        List r153 = (List) r123;
        return r63;
    L265:
        r47 = false;
    L261:
        r46 = null;
    L255:
        r41 = r11;
    L244:
        r119 = r11;
        goto L245
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Message r154 = (Message) r3.L$6;
        x r155 = (x) r3.L$5;
        x r156 = (x) r3.L$4;
        Map<String, UserCreationFromIM> r157 = (Map) r3.L$3;
        String r158 = (String) r3.L$2;
        List<sz9.b> r159 = (List) r3.L$1;
        x r160 = (x) r3.L$0;
        ResultKt.throwOnFailure(r2);
        Object r161 = r2;
        x r162 = r160;
        r61 = r154;
        r0 = r156;
        r30 = r157;
        r62 = r158;
    L24:
        r120 = (JSONObject) r161;
        Map<String, CreationTask> r163 = j0.c(dp8.e.c(r61));
        if (r163 == null) goto L272;
        Collection<CreationTask> r164 = r163.values();
        if (r164 == null) goto L272;
        r123 = new ArrayList();
        r122 = r159;
        r60 = r5;
        r65 = r3;
        r34 = r162;
        r64 = r155;
        r63 = r0;
        r50 = r164.iterator();
        r121 = 0;
    L272:
        return r0;
    L16:
        ResultKt.throwOnFailure(r2);
        if (r0 == null) goto L269;
        if (r52 == null) goto L272;
        CreationDataSourceHelper r165 = a;
        r3.L$0 = r0;
        r3.L$1 = r53;
        r62 = r54;
        r3.L$2 = r62;
        r30 = r55;
        r3.L$3 = r30;
        r3.L$4 = r0;
        r3.L$5 = r0;
        r3.L$6 = r52;
        r3.label = 1;
        r165.getClass();
        Object r166 = BuildersKt.withContext(Dispatchers.getIO(), new CreationDataSourceHelper$getVideoRecommendParams$2(r52, null), r3);
        if (r166 != r5) goto L23;
        return r5;
    L23:
        r161 = r166;
        r159 = r53;
        r162 = r0;
        r61 = r52;
        r155 = r162;
        goto L24
    L269:
        return null;
    L7:
        r3 = new CreationDataSourceHelper$parseMDItemData$1(this, r56);
        goto L8
    }

    public final Object l(x r45, Message r46, List<sz9.b> r47, String r48, Map<String, UserCreationFromIM> r49, Continuation<? super x> r50) {
        Message r9 = r46;
        if ((r50 instanceof CreationDataSourceHelper$parseVideoGenerateData$1) == false) goto L7;
        CreationDataSourceHelper$parseVideoGenerateData$1 r1 = (CreationDataSourceHelper$parseVideoGenerateData$1) r50;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        CreationDataSourceHelper$parseVideoGenerateData$1 r7 = r1;
        Object r0 = r7.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r7.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        List<sz9.b> r4 = (List) r7.L$8;
        CreationDataSourceHelper r5 = (CreationDataSourceHelper) r7.L$7;
        Map r6 = (Map) r7.L$6;
        zo8.e r8 = (zo8.e) r7.L$5;
        Message r10 = (Message) r7.L$4;
        x r12 = (x) r7.L$3;
        Map<String, UserCreationFromIM> r13 = (Map) r7.L$2;
        String r14 = (String) r7.L$1;
        x r15 = (x) r7.L$0;
        ResultKt.throwOnFailure(r0);
        zo8.e r16 = r8;
        Map<String, UserCreationFromIM> r17 = r13;
        String r18 = r14;
        r9 = r10;
    L91:
        r5.getClass();
        JSONObject r19 = f(r6, (Map) r0);
        CreationItem r20 = r15.f;
        if (r20 == null) goto L96;
        CreationGenDetail r21 = r20.genDetail;
        if (r21 == null) goto L96;
        Integer r22 = r21.taskType;
    L97:
        r4.add(new sz9.b(r9, null, null, r16, false, false, r19, r18, r17, false, null, r22, 6390));
    L106:
        return r12;
    L96:
        r22 = null;
        goto L97
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        if (r45 == null) goto L100;
        if (r9 == null) goto L98;
        AiGenVideoContentData r23 = IAIChatUgcAIGCService.a.r0(r9);
        Function0<String> r24 = r45.n;
        if (r24 == null) goto L22;
        String r25 = (String) r24.invoke();
        if (r25 == null) goto L22;
    L29:
        String r110 = r25;
    L31:
        String r111 = r46.getMessageId();
        String r26 = tz9.a.a(r46);
        Boolean r27 = Boxing.boxBoolean(com.larus.im.bean.message.a.C0(r46));
        CreationDataSourceHelper r28 = a;
        Function0<List<Message>> r29 = r45.u;
        if (r29 == null) goto L35;
        List r30 = (List) r29.invoke();
        if (r30 == null) goto L35;
    L41:
        Message r31 = f0.c(r9, r30);
        r28.getClass();
        if (r31 == null) goto L68;
        Map r32 = r31.getExt();
        if (r32 == null) goto L68;
        String r33 = (String) r32.get("creation_template");
        if (r33 == null) goto L68;
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L62
        zd9.h r35 = zd9.h.a;     // Catch: Throwable -> L62
        if (StringsKt.isBlank(r33) == false) goto L102;
    L59:
        Object r36 = null;
    L60:
        Object r37 = Result.constructor-impl((Map) r36);     // Catch: Throwable -> L62
    L65:
        if (Result.isFailure-impl(r37) == false) goto L67;
        r37 = null;
    L67:
        Map r38 = (Map) r37;
    L69:
        JSONObject r39 = new JSONObject();
        if (r38 == null) goto L72;
        String r40 = (String) r38.get("recommend_from");
    L74:
        if (r38 == null) goto L76;
        String r112 = (String) r38.get("from_template_id");
    L78:
        if (r38 == null) goto L80;
        String r41 = (String) r38.get("template_rec_extra");
    L82:
        if (r38 == null) goto L84;
        String r42 = (String) r38.get("template_rec_req_id");
    L85:
        r39.put("recommend_from", r40);
        r39.put("from_template_id", r112);
        r39.put("template_rec_req_id", r42);
        r39.put("template_rec_extra", r41);
        c4 r310 = new c4(r110, r111, "chat", null, null, "click", "0", null, Boxing.boxInt(1), r26, r27, null, r39, null, 10392);
        if (r23 == null) goto L98;
        nr9.g r311 = ff8.a.a(r23);
        String r312 = UUID.randomUUID().toString();
        z2.a.w3();
        zo8.e r43 = new zo8.e(null, r310, r311, 0, r312, null, null, false, null, null, null, true, false, 6113);
        CreationDataSourceHelper r113 = a;
        r113.getClass();
        Map r114 = d(r45);
        r7.L$0 = r45;
        r7.L$1 = r48;
        r7.L$2 = r49;
        r7.L$3 = r45;
        r7.L$4 = r9;
        r7.L$5 = r43;
        r7.L$6 = r114;
        r7.L$7 = r113;
        r7.L$8 = r47;
        r7.label = 1;
        Object r44 = r113.g(r45, r46, false, false, null, r7);
        if (r44 != r11) goto L90;
        return r11;
    L90:
        r12 = r45;
        r15 = r12;
        r5 = r113;
        r6 = r114;
        r18 = r48;
        r17 = r49;
        r16 = r43;
        r0 = r44;
        r4 = r47;
        goto L91
    L84:
        r42 = null;
        goto L85
    L80:
        r41 = null;
        goto L82
    L76:
        r112 = null;
        goto L78
    L72:
        r40 = null;
        goto L74
    L102:
        r35.getClass();     // Catch: Throwable -> L52
        r36 = Result.constructor-impl(zd9.h.b.fromJson(r33, new h().getType()));     // Catch: Throwable -> L52
    L54:
        Throwable r51 = Result.exceptionOrNull-impl(r36);     // Catch: Throwable -> L62
        if (r51 == null) goto L58;
        c0 r52 = c0.b;     // Catch: Throwable -> L62
        StringBuilder r115 = new StringBuilder("fromJson failed, stack: ");     // Catch: Throwable -> L62
        Intrinsics.checkNotNullParameter(r51, "<this>");     // Catch: Throwable -> L62
        r115.append(ExceptionsKt.stackTraceToString(r51));     // Catch: Throwable -> L62
        r52.e("GsonHolder", r115.toString());     // Catch: Throwable -> L62
    L58:
        if (Result.isFailure-impl(r36) == false) goto L60;
    L52:
        th = move-exception;
        Result.Companion r53 = Result.Companion;     // Catch: Throwable -> L62
        r36 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        Result.Companion r54 = Result.Companion;
        r37 = Result.constructor-impl(ResultKt.createFailure(th));
    L68:
        r38 = null;
    L35:
        q0.a r55 = r45.b;
        if (r55 == null) goto L40;
        q0 r56 = r55.e();
        if (r56 == null) goto L40;
        r30 = r56.getCurrentList();
    L40:
        r30 = null;
    L22:
        q0.a r57 = r45.b;
        if (r57 == null) goto L30;
        y r58 = r57.u0();
        if (r58 == null) goto L30;
        BotModel r59 = r58.j0();
        if (r59 == null) goto L30;
        r25 = r59.getBotId();
    L30:
        r110 = null;
    L98:
        r12 = r45;
        goto L106
    L100:
        return null;
    L7:
        r1 = new CreationDataSourceHelper$parseVideoGenerateData$1(this, r50);
        goto L8
    }
}
