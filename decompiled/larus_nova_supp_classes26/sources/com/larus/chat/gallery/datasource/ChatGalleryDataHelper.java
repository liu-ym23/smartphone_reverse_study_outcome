package com.larus.chat.gallery.datasource;

import android.net.Uri;
import androidx.collection.LruCache;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.bigimg.m1;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bmhome.utils.c4;
import com.larus.gallery.api.GalleryType;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.p0;
import com.larus.utils.y0;
import ic8.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import lr8.c;
import nr9.g;
import org.json.JSONObject;
import ty8.b;
import v19.m5;
import wc9.e;
import yc9.l1;
import yc9.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ChatGalleryDataHelper {
    public static final ChatGalleryDataHelper a = null;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001¨\u0006\u0005"}, d2 = {"com/larus/chat/gallery/datasource/ChatGalleryDataHelper$transformMessageToGalleryData$2$whiteTeeIndexList$1$1", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<ArrayList<Integer>> {
        public a() {
        }
    }

    static {
        a = new ChatGalleryDataHelper();
    }

    public ChatGalleryDataHelper() {
    }

    public static JSONObject a(Message r8, ty8.a r9, boolean r10) {
        JSONObject r0 = new JSONObject();
        r9.getClass();
        q0 r1 = r9.e;
        String r2 = null;
        if (r1 == null) goto L9;
        q0.a r3 = r1.getProvider();
        if (r3 == null) goto L9;
        y r4 = r3.u0();
        if (r4 == null) goto L9;
        e r5 = r4.h();
    L10:
        BotModel r6 = r9.a;
        Map r7 = r8.getExt();
        if (r7 == null) goto L13;
        String r11 = (String) r7.get("Copilot:hippo:hippo_ext");
    L14:
        if (r11 == null) goto L16;
        boolean r12 = true;
    L17:
        r0.put(MusicAppletPage.KEY_SOURCE, "send_img_holder");
        r0.put("user_type", "user");
        r0.put("enter_picture_method", "chat");
        r0.put("enter_from", "chat");
        String r13 = r8.getMessageId();
        String r14 = "";
        if (r13 != null) goto L20;
        r13 = "";
    L20:
        r0.put(MusicAppletPage.KEY_MESSAGE_ID, r13);
        String r15 = r8.getConversationId();
        if (r15 != null) goto L23;
        r15 = "";
    L23:
        r0.put(MusicAppletPage.KEY_CONVERSATION_ID, r15);
        BotModel r16 = r9.a;
        if (r16 == null) goto L29;
        String r17 = r16.getBotId();
        if (r17 == null) goto L29;
        r14 = r17;
    L29:
        r0.put("bot_id", r14);
        LruCache<String, e> r18 = ko8.a.a;
        if (r5 == null) goto L32;
        Integer r19 = r5.v;
    L33:
        if (r6 == null) goto L35;
        Integer r20 = r6.getBotType();
    L36:
        if (r6 == null) goto L40;
        BotCreatorInfo r21 = r6.getBotCreatorInfo();
        if (r21 == null) goto L40;
        r2 = r21.getId();
    L40:
        r0.put("chat_type", ko8.a.f(r19, r20, Intrinsics.areEqual(r2, AccountService.a.getUserId())));
        if (r12 == false) goto L43;
        String r22 = "1";
    L44:
        r0.put("is_edu", r22);
        if (r10 == false) goto L47;
        String r23 = "picture_detail";
    L48:
        r0.put("current_page", r23);
        return r0;
    L47:
        r23 = "video_detail";
        goto L48
    L43:
        r22 = TriggerSendLoading.NO_LOADING;
        goto L44
    L35:
        r20 = null;
        goto L36
    L32:
        r19 = null;
        goto L33
    L16:
        r12 = false;
        goto L17
    L13:
        r11 = null;
    L9:
        r5 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v2, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11, types: [int] */
    /* JADX WARN: Type inference failed for: r15v19 */
    public final Object b(ty8.a r49, Message r50, Continuation<? super List<b>> r51) {
        if ((r51 instanceof ChatGalleryDataHelper$transformMessageToGalleryData$1) == false) goto L7;
        ChatGalleryDataHelper$transformMessageToGalleryData$1 r2 = (ChatGalleryDataHelper$transformMessageToGalleryData$1) r51;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        boolean r6 = true;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        List r0 = (List) r2.L$3;
        Message r7 = (Message) r2.L$2;
        Message r8 = (Message) r2.L$1;
        ty8.a r9 = (ty8.a) r2.L$0;
        ResultKt.throwOnFailure(r1);
        List r10 = r0;
        Object r11 = r1;
    L20:
        Iterator r12 = ((List) r11).iterator();
    L22:
        if (r12.hasNext() == false) goto L29;
        Object r13 = r12.next();
        if (((Message) r13).getContentType() != 1) goto L26;
        boolean r14 = true;
    L27:
        if (r14 == false) goto L22;
    L30:
        Message r15 = (Message) r13;
        if (r15 == null) goto L33;
        String r18 = d.H(r15);
    L34:
        String r16 = "pic_id";
        if (c.a(r7) == false) goto L146;
        NestedFileContent r17 = d.f(r7);
        Gson r19 = new Gson();
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L43
        Map r21 = r8.getExt();     // Catch: Throwable -> L43
        if (r21 == null) goto L40;
        String r22 = (String) r21.get("white_tee_index_list");     // Catch: Throwable -> L43
    L41:
        Object r23 = Result.constructor-impl((ArrayList) r19.fromJson(r22, new a().getType()));     // Catch: Throwable -> L43
    L46:
        if (Result.exceptionOrNull-impl(r23) == null) goto L49;
        r23 = new ArrayList();
    L49:
        ArrayList r24 = (ArrayList) r23;
        if (r24 != null) goto L52;
        r24 = new ArrayList();
    L52:
        List r25 = r17.getEntities();
        if (r25 == null) goto L259;
        Iterator r26 = r25.iterator();
        int r27 = 0;
    L56:
        if (r26.hasNext() == false) goto L259;
        Object r28 = r26.next();
        int r29 = r27 + 1;
        if (r27 >= 0) goto L60;
        CollectionsKt.throwIndexOverflow();
    L60:
        UplinkFileEntity r30 = (UplinkFileEntity) r28;
        if (n1.d(r30) == false) goto L129;
        Integer r110 = r30.getFileReviewStatus();
        int r111 = FileReviewState.NOT_COMPLIANT.getValue();
        if (r110 == null) goto L68;
        if (r110.intValue() != r111) goto L68;
    L128:
        String r31 = r16;
    L144:
        r27 = r29;
        r16 = r31;
        r6 = true;
    L68:
        if (r24.contains(Boxing.boxInt(r27)) == true) goto L128;
        String r32 = r30.getFileIdentifier();
        if (r32 != null) goto L72;
        r32 = "";
    L72:
        String r33 = com.larus.bmhome.chat.sendimage.e.h(r7, r32);
        if (m5.c(r33) == true) goto L75;
        Uri r34 = null;
    L79:
        Image r112 = l1.c(r30);
        if (r112 == null) goto L84;
        ImageObj r113 = r112.imageOri;
        if (r113 == null) goto L84;
        String r114 = r113.url;
    L85:
        Image r115 = l1.c(r30);
        if (r115 == null) goto L90;
        ImageObj r116 = r115.previewImage;
        if (r116 == null) goto L90;
        String r117 = r116.url;
    L91:
        if (r34 == null) goto L93;
        Uri r118 = r34;
    L97:
        Image r119 = l1.c(r30);
        if (r119 == null) goto L101;
        String r120 = r119.key;
        if (r120 == null) goto L101;
    L102:
        int r121 = p0.a;
        String r210 = p0.a(r118.toString());
        if (r210 == null) goto L128;
        if (r34 == null) goto L108;
        String r35 = r34.toString();
        if (r35 == null) goto L108;
    L113:
        String r211 = r35;
    L115:
        Image r36 = l1.c(r30);
        if (r36 == null) goto L120;
        ImageObj r37 = r36.imageOri;
        if (r37 == null) goto L120;
        Integer r212 = Boxing.boxInt(r37.width);
    L121:
        Image r38 = l1.c(r30);
        if (r38 == null) goto L126;
        ImageObj r39 = r38.imageOri;
        if (r39 == null) goto L126;
        Integer r213 = Boxing.boxInt(r39.height);
    L127:
        m1 r122 = new m1(r210, r211, null, r212, r213, null, 36);
        GalleryType r123 = GalleryType.Image;
        String r124 = r30.getFileIdentifier();
        JSONObject r125 = a(r7, r9, r6);
        r125.put(r16, r120);
        r31 = r16;
        r10.add(new b(r7, r122, null, r123, r125, null, r124, r18, 588));
    L126:
        r213 = null;
    L120:
        r212 = null;
    L108:
        Image r40 = l1.c(r30);
        if (r40 == null) goto L114;
        ImageObj r41 = r40.imageThumb;
        if (r41 == null) goto L114;
        r35 = r41.url;
    L114:
        r211 = null;
    L101:
        r120 = "";
        goto L102
    L93:
        if (o0.d(r117) == false) goto L95;
        r118 = y0.h(r117);
        goto L97
    L95:
        r118 = y0.h(r114);
    L90:
        r117 = null;
    L84:
        r114 = null;
        goto L85
    L75:
        if (r33 != null) goto L77;
        r33 = "";
    L77:
        r34 = Uri.fromFile(new PolarisFileWrapper(r33));
        goto L79
    L129:
        r31 = r16;
        if (n1.e(r30) == false) goto L144;
        g r126 = os8.a.a(r30);
        GalleryType r127 = GalleryType.Video;
        String r128 = r30.getFileIdentifier();
        BotModel r42 = r9.a;
        if (r42 == null) goto L134;
        String r310 = r42.getBotId();
    L135:
        String r311 = r8.getMessageId();
        BotModel r43 = r9.a;
        q0 r44 = r9.e;
        if (r44 == null) goto L142;
        q0.a r45 = r44.getProvider();
        if (r45 == null) goto L142;
        y r46 = r45.u0();
        if (r46 == null) goto L142;
        e r312 = r46.h();
    L143:
        Message r47 = r7;
        r10.add(new b(r47, null, r126, r127, a(r8, r9, false), new c4(r310, r311, "chat", r43, r312, "click_message_video", "1", null, Boxing.boxInt(r27), null, null, null, null, null, 16000), r128, r18, 522));
    L142:
        r312 = null;
        goto L143
    L134:
        r310 = null;
    L259:
        return r10;
    L40:
        r22 = null;
    L43:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L46
    L146:
        if (r7.getContentType() != 6) goto L259;
        Map r52 = r7.getBusinessExt();
        if (r52 == null) goto L150;
        String r53 = (String) r52.get("send_image_local_path");
    L151:
        List r54 = d.g(r7).imageList;
        if (r54 == null) goto L154;
        Image r55 = (Image) CollectionsKt.firstOrNull(r54);
    L156:
        if (o0.d(r53) == true) goto L158;
    L160:
        if (r55 == null) goto L173;
        ImageObj r56 = r55.imageThumb;
        if (r56 == null) goto L173;
        String r57 = r56.url;
        if (r57 == null) goto L173;
        if (r57.length() <= 0) goto L168;
        boolean r129 = true;
    L169:
        if (r129 == true) goto L172;
        r57 = null;
    L172:
        if (r57 == null) goto L173;
    L185:
        Uri r58 = y0.h(r57);
        String r59 = null;
    L186:
        if (r55 == null) goto L197;
        ImageObj r60 = r55.previewImage;
        if (r60 == null) goto L197;
        String r61 = r60.url;
        if (r61 == null) goto L197;
        if (r61.length() <= 0) goto L194;
        boolean r62 = true;
        boolean r130 = true;
    L195:
        if (r130 != r62) goto L197;
        boolean r131 = true;
    L198:
        if (r131 == false) goto L204;
        ImageObj r63 = r55.previewImage;
        if (r63 == null) goto L202;
        String r64 = r63.url;
    L203:
        r58 = y0.h(r64);
        goto L204
    L202:
        r64 = null;
    L204:
        int r65 = p0.a;
        String r66 = p0.a(r58.toString());
        if (r66 == null) goto L259;
        if (r59 != null) goto L215;
        if (r55 == null) goto L212;
        ImageObj r67 = r55.imageThumb;
        if (r67 == null) goto L212;
        r59 = r67.url;
    L213:
        if (r59 != null) goto L215;
        String r132 = r66;
    L216:
        if (r55 == null) goto L223;
        ImageObj r68 = r55.imageOri;
        if (r68 == null) goto L223;
        String r69 = r68.url;
        if (r69 == null) goto L223;
        String r133 = r69;
    L224:
        if (r55 == null) goto L228;
        ImageObj r70 = r55.imageOri;
        if (r70 == null) goto L228;
        Integer r134 = Boxing.boxInt(r70.width);
    L229:
        if (r55 == null) goto L233;
        ImageObj r71 = r55.imageOri;
        if (r71 == null) goto L233;
        Integer r135 = Boxing.boxInt(r71.height);
    L234:
        m1 r72 = new m1(r66, r132, r133, r134, r135, null, 32);
        GalleryType r136 = GalleryType.Image;
        ?? r137 = a(r7, r9, true);
        if (r55 == null) goto L238;
        String r73 = r55.key;
        if (r73 == null) goto L238;
    L239:
        r137.put("pic_id", r73);
        Map r74 = r7.getExt();
        if (r74 == null) goto L242;
        ?? r138 = j.a(r74);
    L243:
        r137.put("is_image_edit", r138);
        Boxing.boxBoolean(r10.add(new b(r7, r72, null, r136, r137, null, null, r18, 716)));
        goto L259
    L242:
        r138 = 0;
    L238:
        r73 = "";
    L233:
        r135 = null;
    L228:
        r134 = null;
    L223:
        r133 = r66;
    L212:
        r59 = null;
    L215:
        r132 = r59;
        goto L216
    L194:
        r62 = true;
        r130 = false;
    L197:
        r131 = false;
        goto L198
    L168:
        r129 = false;
    L173:
        if (r55 == null) goto L184;
        ImageObj r75 = r55.imageOri;
        if (r75 == null) goto L184;
        r57 = r75.url;
        if (r57 == null) goto L184;
        if (r57.length() <= 0) goto L181;
        boolean r139 = true;
    L182:
        if (r139 == false) goto L184;
    L181:
        r139 = false;
    L184:
        r57 = null;
        goto L185
    L158:
        if (new PolarisFileWrapper(r53).exists() == false) goto L160;
        r58 = Uri.fromFile(new PolarisFileWrapper(r53));
        r59 = r58.toString();
        goto L186
    L154:
        r55 = null;
        goto L156
    L150:
        r53 = null;
        goto L151
    L33:
        r18 = null;
        goto L34
    L26:
        r14 = false;
        goto L27
    L29:
        r13 = null;
        goto L30
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        if (r50 == null) goto L245;
        FLogger.a.i("ChatGalleryDataHelper", "transformMessageToGalleryData, message id: " + r50.getMessageId() + ", contentType: " + Boxing.boxInt(r50.getContentType()));
        r10 = new ArrayList();
        IChatRepoService r76 = zh8.a.a;
        r2.L$0 = r49;
        r2.L$1 = r50;
        r2.L$2 = r50;
        r2.L$3 = r10;
        r2.label = 1;
        Object r77 = r76.s1(r50, r2);
        if (r77 != r4) goto L19;
        return r4;
    L19:
        r7 = r50;
        r8 = r7;
        r11 = r77;
        r9 = r49;
        goto L20
    L245:
        return null;
    L7:
        r2 = new ChatGalleryDataHelper$transformMessageToGalleryData$1(this, r51);
        goto L8
    }
}
