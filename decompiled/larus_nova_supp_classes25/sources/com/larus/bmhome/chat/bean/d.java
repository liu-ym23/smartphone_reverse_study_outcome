package com.larus.bmhome.chat.bean;

import android.text.TextUtils;
import android.util.LruCache;
import androidx.core.text.HtmlCompat;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageContentData;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageItem;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.creative.messagecard.bean.CreationInfo;
import com.larus.bmhome.creative.messagecard.bean.CreationMsgContentData;
import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import com.larus.bmhome.social.userchat.messagelist.model.IMessageContentConvertor;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.bmhome.utils.k;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.IMMetaInfo;
import com.larus.im.bean.IMMsgExt;
import com.larus.im.bean.message.ClientControllerParam;
import com.larus.im.bean.message.ContainerAttribute;
import com.larus.im.bean.message.CreationBlock;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageContent;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.MessageTag;
import com.larus.im.bean.message.MsgFeedbackType;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.bean.message.RichMediaMeta;
import com.larus.im.bean.message.SuggestQuestion;
import com.larus.im.bean.message.TagEnum;
import com.larus.im.bean.message.TextContent;
import com.larus.im.bean.message.TextTagInfo;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.block.AttachmentBlock;
import com.larus.im.bean.message.block.AttachmentItem;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockMetaInfo;
import com.larus.im.bean.message.block.BlockType;
import com.larus.im.bean.message.block.InteractionAskBlock;
import com.larus.im.bean.message.block.InteractionAskBlockStatus;
import com.larus.im.bean.message.block.LynxBlock;
import com.larus.im.bean.message.block.QuickReplyBlock;
import com.larus.im.bean.message.block.QuickReplyBlockStatus;
import com.larus.im.bean.message.block.QuickReplyScene;
import com.larus.im.bean.message.block.ReferenceBlock;
import com.larus.im.bean.message.block.ReferenceText;
import com.larus.im.bean.message.block.ReferenceTextOption;
import com.larus.im.bean.message.block.RichMediaType;
import com.larus.im.bean.message.block.SearchRichMediaBlock;
import com.larus.im.bean.message.block.TextBlock;
import com.larus.im.bean.message.block.UploadImage;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.audio.ObricTtsControlDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import ic8.c0;
import ic8.e0;
import ic8.h;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import vd9.r;
import yc9.f0;
import yc9.q0;
import yc9.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d {
    public static final Regex a = null;
    public static final Regex b = null;
    public static final Set<String> c = null;
    public static final Regex d = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MessageTag.values().length];
            r0[MessageTag.MessageTag_Onboarding_FIRSTMEG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[MessageTag.MessageTag_Onboarding_WELCOMEBACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[MessageTag.MessageTag_OnboardingV2.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/bmhome/chat/bean/MessageExtKt$toOnboardingSug$1$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/larus/bmhome/chat/bean/OnboardingSug;", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final class b extends TypeToken<List<? extends OnboardingSug>> {
        public b() {
        }
    }

    static {
        a = new Regex("<data-\\w+\\s+[^>]*?value=\"([^\"]*)\"[^>]*?>");
        b = new Regex("value=\"[^\"]*\"");
        c = SetsKt.setOf(new String[]{"applet", "creation", "image-group", "lynx_ruyi", "lynx", "simple-image-group", "search_reference", "mixed_media_card", "video-group", "video-group-v2", "vlm_mixed_media_card", "memory"});
        d = new Regex("sslocal://flow/scheduled_job_editor\\?[^\\s)]+");
    }

    public static final boolean U0() {
        return z2.a.S3().b();
    }

    public static final boolean A(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        String r0 = r3.getReplyId();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L17;
        String r4 = r3.getReplyId();
        if (r4 != null) goto L14;
        r4 = "";
    L14:
        if (r4.length() <= 4) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public static final boolean A0(Message r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        String r2 = null;
        if (com.larus.im.bean.message.a.b0(r5) == true) goto L5;
        List<String> r1 = K(r5);
        if (r1 != null) goto L25;
    L27:
        boolean r3 = false;
    L28:
        if (r3 == false) goto L44;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        TextContent r6 = com.larus.im.bean.message.a.P(r5);
        if (r6 == null) goto L32;
        r2 = r6.text;
    L32:
        if (r2 != null) goto L34;
    L37:
        boolean r7 = true;
    L38:
        if (r7 == false) goto L45;
        return true;
    L45:
        return false;
    L34:
        if (r2.length() == 0) goto L37;
        r7 = false;
        goto L38
    L44:
        return false;
    L25:
        if ((!r1.isEmpty()) != true) goto L27;
        r3 = true;
        goto L28
    L5:
        if (com.larus.im.bean.message.a.d(r5).size() == 1) goto L7;
        return false;
    L7:
        if (((Block) CollectionsKt.first(com.larus.im.bean.message.a.d(r5))).getBlockType() != BlockType.BLOCK_TYPE_TEXT.getValue()) goto L42;
        BlockContent r8 = ((Block) CollectionsKt.first(com.larus.im.bean.message.a.d(r5))).getContent();
        if (r8 == null) goto L13;
        TextBlock r9 = r8.getTextBlock();
        if (r9 == null) goto L13;
        r2 = r9.text;
    L13:
        if (r2 != null) goto L15;
    L18:
        boolean r10 = true;
    L19:
        if (r10 == false) goto L43;
        return true;
    L43:
        return false;
    L15:
        if (r2.length() == 0) goto L18;
        r10 = false;
        goto L19
    L42:
        return false;
    }

    public static final String B(Message r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        if (lr8.c.a(r9) == false) goto L13;
        NestedFileContent r10 = f(r9);
        int r0 = v0.b(r10, new q0());
        int r11 = v0.c(r10);
        if (r0 <= 0) goto L8;
        if (r11 <= 0) goto L8;
        return "pic_and_file";
    L8:
        if (r11 <= 0) goto L11;
        return "pic";
    L11:
        return "file";
    L13:
        if (N0(r9) == false) goto L17;
        return "sticker";
    L17:
        if (y(r9) == false) goto L20;
        return "feely_pic";
    L20:
        int r1 = r9.getContentType();
        if (r1 == 0) goto L149;
        boolean r3 = true;
        if (r1 != 1) goto L25;
        return ChatDraftItem.TYPE_TEXT;
    L25:
        if (r1 != 2) goto L27;
        return "suggest";
    L27:
        if (r1 != 3) goto L29;
        return "music";
    L29:
        if (r1 != 5) goto L31;
        return "video";
    L31:
        if (r1 != 6) goto L33;
        return "pic";
    L33:
        if (r1 == 7) goto L174;
        if (r1 != 8) goto L37;
        return "search_list";
    L37:
        if (r1 != 50) goto L39;
        return "lynx";
    L39:
        if (r1 != 51) goto L41;
        return "bot_maker";
    L41:
        if (r1 != 60) goto L43;
        return "expert";
    L43:
        if (r1 != 66) goto L45;
        return "multi_content";
    L45:
        if (r1 != 100) goto L47;
        return "first_application_card";
    L47:
        if (r1 == 1001) goto L137;
        Integer r6 = null;
        if (r1 != 9999) goto L51;
        List r2 = com.larus.im.bean.message.a.k(r9);
        if ((!r2.isEmpty()) == false) goto L166;
        Block r12 = (Block) CollectionsKt.firstOrNull(r2);
        if (r12 == null) goto L130;
        BlockContent r13 = r12.getContent();
        if (r13 == null) goto L130;
        CreationBlock r14 = r13.getCreationBlock();
        if (r14 == null) goto L130;
        List r15 = r14.creations;
        if (r15 == null) goto L130;
        CreationItem r16 = (CreationItem) CollectionsKt.firstOrNull(r15);
        if (r16 == null) goto L130;
        r6 = r16.type;
    L130:
        if (r6 != null) goto L133;
    L135:
        return "pic_and_text";
    L133:
        if (r6.intValue() != 2) goto L135;
    L134:
        return "video_and_text";
    L166:
        return "type_" + r9.getContentType();
    L51:
        if (r1 != 2021) goto L53;
        return "ai_video";
    L53:
        if (r1 == 2022) goto L78;
        switch(r1) {
            case 70: goto L67;
            case 71: goto L66;
            case 72: goto L67;
            default: goto L56;
        };
    L66:
        return "ai_music_lyric_card";
    L67:
        return "ai_music_card";
    L56:
        if (r9.getContentType() != 800) goto L160;
        String r4 = r9.getBizContentType();
        if (r4 == null) goto L159;
        int r5 = r4.hashCode();
        if (r5 == (-122918927)) goto L75;
        if (r5 == 1228121530) goto L72;
        if (r5 != 1655233225) goto L159;
        if (r4.equals("edu_continue_shot") == false) goto L159;
        return "edu_continue_shot";
    L72:
        if (r4.equals("crowd_test_tab") == false) goto L159;
        return "crowd_test_tab";
    L75:
        if (r4.equals("crowd_test_selection") == false) goto L159;
        return "crowd_test_selection";
    L159:
        return "type_" + r9.getContentType();
    L160:
        return "type_" + r9.getContentType();
    L78:
        CreationMsgContentData r7 = dp8.e.c(r9);
        if (r7 == null) goto L81;
        CreationInfo r8 = r7.creationInfo;
    L82:
        if (r8 == null) goto L84;
        Integer r17 = r8.layoutType;
    L85:
        if (r17 != null) goto L88;
    L110:
        if (r17 == null) goto L162;
        if (r17.intValue() != 2) goto L162;
        return "pic";
    L162:
        return "type_" + r9.getContentType();
    L88:
        if (r17.intValue() != 1) goto L110;
        Map r18 = r8.taskInfo;
        if (r18 == null) goto L96;
        Collection r19 = r18.values();
        if (r19 == null) goto L96;
        CreationTask r20 = (CreationTask) CollectionsKt.firstOrNull(r19);
        if (r20 == null) goto L96;
        r6 = r20.loadingAssetType;
    L96:
        if (r6 != null) goto L99;
    L101:
        Map r21 = r8.taskInfo;
        if (r21 != null) goto L104;
    L106:
        r3 = false;
    L107:
        if (r3 == true) goto L135;
        return "type_" + r9.getContentType();
    L104:
        if ((!r21.isEmpty()) != true) goto L106;
    L99:
        if (r6.intValue() != 7) goto L101;
    L84:
        r17 = null;
        goto L85
    L81:
        r8 = null;
        goto L82
    L137:
        return "system";
    L174:
        return "file";
    L149:
        return "unspecified";
    }

    public static final boolean B0(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Map r2 = r1.getBusinessExt();
        if (r2 == null) goto L5;
        String r3 = (String) r2.get("collect_type");
    L7:
        return Intrinsics.areEqual(r3, "1");
    L5:
        r3 = null;
        goto L7
    }

    public static final List<TextTagInfo> C(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r1, "<this>");
        TextContent r2 = com.larus.im.bean.message.a.P(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.textTags;
    }

    public static final boolean C0(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r2.getMessageStatus() != MessageStatus.MessageStatus_REGENATED) goto L5;
    L8:
        return true;
    L5:
        if (r2.getMessageStatus() == MessageStatus.MessageStatus_REGEN_ROOT) goto L8;
        return false;
    }

    public static final MessageTag D(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        MessageTag.a r0 = MessageTag.Companion;
        List r2 = r1.getTags();
        r0.getClass();
        return MessageTag.a.b(r2);
    }

    public static final String E(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        String r2 = x(r1).getOnBoardingContentSource();
        if (r2 != null) goto L6;
        return "";
    L6:
        return r2;
    }

    public static final boolean E0(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (com.larus.im.bean.message.a.b0(r3) == true) goto L5;
        return false;
    L5:
        if (r3.getContentType() != 8) goto L25;
        List r4 = r3.getContentBlock();
        if (r4 == null) goto L20;
        Block r5 = (Block) CollectionsKt.firstOrNull(r4);
        if (r5 == null) goto L20;
        BlockContent r6 = r5.getContent();
        if (r6 == null) goto L20;
        SearchRichMediaBlock r7 = r6.getRichMediaBlock();
        if (r7 == null) goto L20;
        Integer r8 = r7.scene;
        if (r8 == null) goto L20;
        if (r8.intValue() != 3) goto L20;
        boolean r9 = true;
    L21:
        if (r9 == false) goto L26;
        return true;
    L26:
        return false;
    L20:
        r9 = false;
        goto L21
    L25:
        return false;
    }

    public static final String F(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        MessageTag.a r0 = MessageTag.Companion;
        List r2 = r1.getTags();
        r0.getClass();
        MessageTag r3 = MessageTag.a.b(r2);
        int r4 = a.a[r3.ordinal()];
        if (r4 != 1) goto L5;
        return "first_met";
    L5:
        if (r4 == 2) goto L7;
        return null;
    L7:
        return "welcome_back";
    }

    public static final boolean F0(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (com.larus.im.bean.message.a.b0(r1) == false) goto L11;
        Map r2 = r1.getExt();
        if (r2 == null) goto L7;
        String r3 = (String) r2.get("msg_scene");
    L9:
        if (Intrinsics.areEqual(r3, "rv_two_col") == false) goto L11;
        return true;
    L7:
        r3 = null;
    L11:
        return false;
    }

    public static final String G(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return x(r1).getPluginAuthInfo();
    }

    public static final boolean G0(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (b0.f(r3) == true) goto L17;
        AccountService r0 = AccountService.a;
        if (Intrinsics.areEqual(r0.getUserId(), r3.getSenderId()) == false) goto L7;
        return true;
    L7:
        if (Intrinsics.areEqual(r0.getSecUserId(), r3.getSenderId()) == true) goto L20;
        Map r1 = r3.getExt();
        if (r1 == null) goto L11;
        String r2 = (String) r1.get("case_scene");
    L13:
        if (Intrinsics.areEqual(r2, "detail") == false) goto L17;
        if (r3.getUserType() != 1) goto L17;
        return true;
    L11:
        r2 = null;
        goto L13
    L20:
        return true;
    L17:
        return false;
    }

    public static final String H(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (com.larus.im.bean.message.a.b0(r4) == false) goto L22;
        Iterator r5 = com.larus.im.bean.message.a.A(r4).iterator();
    L6:
        if (r5.hasNext() == false) goto L13;
        Object r0 = r5.next();
        if (((Block) r0).getBlockType() != BlockType.BLOCK_TYPE_TEXT.getValue()) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == false) goto L6;
    L14:
        Block r2 = (Block) r0;
        if (r2 == null) goto L31;
        BlockContent r6 = r2.getContent();
        if (r6 == null) goto L32;
        TextBlock r7 = r6.getTextBlock();
        if (r7 != null) goto L21;
        return null;
    L21:
        return r7.text;
    L32:
        return null;
    L31:
        return null;
    L10:
        r1 = false;
        goto L11
    L13:
        r0 = null;
        goto L14
    L22:
        Intrinsics.checkNotNullParameter(r4, "<this>");
        TextContent r8 = com.larus.im.bean.message.a.P(r4);
        if (r8 != null) goto L25;
        return null;
    L25:
        return r8.text;
    }

    public static final boolean H0(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        LruCache<String, Boolean> r0 = c0.a;
        Intrinsics.checkNotNullParameter(r3, "message");
        LruCache<String, Boolean> r1 = c0.a;
        Boolean r2 = r1.get(r3.getLocalMessageId());
        if (r2 != null) goto L7;
        boolean r4 = G0(r3);
        r1.put(r3.getLocalMessageId(), Boolean.valueOf(r4));
        return r4;
    L7:
        return r2.booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final int I(Message r6) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        int r0 = 1;
        ImageContentData r1 = null;
        Object[] r2 = 0;
        Object[] r3 = 0;
    L9:
        e = move-exception;
        FLogger.a.e("get_image_size", String.valueOf(g2a.d.d(r6.getContent())), e);
    L12:
        if (a0(r6) == false) goto L34;
        CreationMsgContentData r7 = dp8.e.c(r6);
        if (r7 == null) goto L45;
        CreationInfo r8 = r7.creationInfo;
        if (r8 == null) goto L46;
        Map r9 = r8.taskInfo;
        if (r9 == null) goto L47;
        LinkedHashMap r4 = new LinkedHashMap();
        Iterator r10 = r9.entrySet().iterator();
    L21:
        if (r10.hasNext() == false) goto L48;
        Map.Entry r5 = (Map.Entry) r10.next();
        CreationTask r11 = (CreationTask) r5.getValue();
        if (r11 == null) goto L30;
        Integer r12 = r11.status;
        if (r12 == null) goto L30;
        if (r12.intValue() != 4) goto L30;
        boolean r13 = true;
    L31:
        if (r13 == false) goto L21;
        r4.put(r5.getKey(), r5.getValue());
    L30:
        r13 = false;
        goto L31
    L48:
        return r4.size();
    L47:
        return 0;
    L46:
        return 0;
    L45:
        return 0;
    L34:
        if (r1 == null) goto L49;
        List<ImageItem> r14 = r1.getImageList();
        if (r14 != null) goto L38;
        return 0;
    L38:
        return r14.size();
    L49:
        return 0;
    L4:
        if (a0(r6) == false) goto L7;
        ImageContentData r15 = new ImageContentData(r3 == true ? 1 : 0, r0, r2 == true ? 1 : 0);     // Catch: JsonSyntaxException -> L9
    L6:
        r1 = r15;
        goto L12
    L7:
        r15 = (ImageContentData) GsonProtectorUtils.fromJson(new Gson(), r6.getContent(), ImageContentData.class);     // Catch: JsonSyntaxException -> L9
        goto L6
    }

    public static final boolean I0(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r0 = wf9.b.a;
        Intrinsics.checkNotNullParameter(r1, "message");
        return com.larus.im.bean.message.a.r0(r1);
    }

    public static final Map<String, String> J(Message r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Map<String, String> r1 = l(r10);
        if (r1 == null) goto L6;
        Map<String, String> r2 = MapsKt.toMutableMap(r1);
        if (r2 == null) goto L6;
    L7:
        String r3 = r2.get("job_id");
        if (r3 == null) goto L17;
        String r4 = StringsKt.trim(r3).toString();
        if (r4 == null) goto L17;
        if (r4.length() <= 0) goto L14;
        boolean r7 = true;
    L15:
        if (r7 == false) goto L17;
    L18:
        if (r4 != null) goto L104;
        r2.remove("job_id");
        Map r5 = r10.getExt();
        if (r5 == null) goto L34;
        String r6 = (String) r5.get("job_id");
        if (r6 == null) goto L34;
        String r8 = StringsKt.trim(r6).toString();
        if (r8 == null) goto L34;
        if (r8.length() <= 0) goto L28;
        boolean r9 = true;
    L29:
        if (r9 == true) goto L32;
        r8 = null;
    L32:
        if (r8 == null) goto L34;
    L101:
        if (r8 == null) goto L104;
        r2.put("job_id", r8);
        goto L104
    L28:
        r9 = false;
    L34:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator r11 = r.a(r10).iterator();
    L36:
        if (r11.hasNext() == false) goto L66;
        Block r12 = (Block) r11.next();
        if (r12.getBlockType() != BlockType.BLOCK_TYPE_LYNX.getValue()) goto L36;
        BlockContent r13 = r12.getContent();
        if (r13 == null) goto L63;
        LynxBlock r14 = r13.getLynxBlock();
        if (r14 == null) goto L63;
        String r15 = r14.lynxData;
        if (r15 == null) goto L63;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L48
        Object r17 = Result.constructor-impl(new JSONObject(r15).optString("job_id"));     // Catch: Throwable -> L48
    L51:
        if (Result.isFailure-impl(r17) == false) goto L53;
        r17 = null;
    L53:
        String r18 = (String) r17;
        if (r18 == null) goto L63;
        String r19 = StringsKt.trim(r18).toString();
        if (r19 == null) goto L63;
        if (r19.length() <= 0) goto L60;
        boolean r20 = true;
    L61:
        if (r20 == false) goto L63;
    L64:
        if (r19 == null) goto L36;
        r8 = r19;
        goto L101
    L60:
        r20 = false;
    L48:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
    L63:
        r19 = null;
        goto L64
    L66:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator r110 = r.a(r10).iterator();
    L68:
        if (r110.hasNext() == false) goto L100;
        BlockContent r0 = ((Block) r110.next()).getContent();
        if (r0 == null) goto L68;
        TextBlock r22 = r0.getTextBlock();
        if (r22 == null) goto L68;
        String r23 = r22.text;
        if (r23 == null) goto L68;
        MatchResult r24 = Regex.find$default(d, r23, 0, 2, null);
        if (r24 == null) goto L78;
        String r25 = r24.getValue();
    L79:
        if (r25 == null) goto L68;
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L82
        Object r27 = Result.constructor-impl(UriProtector.getQueryParameter(UriProtector.parse(r25), "job_id"));     // Catch: Throwable -> L82
    L85:
        if (Result.isFailure-impl(r27) == false) goto L87;
        r27 = null;
    L87:
        String r28 = (String) r27;
        if (r28 == null) goto L97;
        String r29 = StringsKt.trim(r28).toString();
        if (r29 == null) goto L97;
        if (r29.length() <= 0) goto L94;
        boolean r30 = true;
    L95:
        if (r30 == false) goto L97;
        r8 = r29;
    L98:
        if (r8 == null) goto L68;
    L94:
        r30 = false;
    L97:
        r8 = null;
    L82:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r27 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L85
    L78:
        r25 = null;
        goto L79
    L100:
        r8 = null;
    L104:
        if ((!r2.isEmpty()) == false) goto L107;
        return r2;
    L107:
        return null;
    L14:
        r7 = false;
    L17:
        r4 = null;
    L6:
        r2 = new LinkedHashMap();
        goto L7
    }

    public static final boolean J0(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Map r0 = r4.getBusinessExt();
        if (r0 == null) goto L7;
        boolean r3 = true;
        if (r0.containsKey("share_pic_mode") != true) goto L7;
    L8:
        if (r3 == false) goto L15;
        Map r5 = r4.getBusinessExt();
        if (r5 == null) goto L12;
        String r6 = (String) r5.get("share_pic_mode");
    L14:
        return Intrinsics.areEqual(r6, "1");
    L12:
        r6 = null;
        goto L14
    L15:
        return false;
    L7:
        r3 = false;
        goto L8
    }

    public static final List<String> K(Message r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        Map r6 = r5.getExt();     // Catch: Throwable -> L13
        if (r6 == null) goto L11;
        String r7 = (String) r6.get("ruyi_card_type");     // Catch: Throwable -> L13
        if (r7 == null) goto L11;
        JSONArray r2 = new JSONArray(r7);     // Catch: Throwable -> L13
        int r8 = r2.length();     // Catch: Throwable -> L13
        ArrayList r3 = new ArrayList(r8);     // Catch: Throwable -> L13
        int r4 = 0;
    L8:
        if (r4 >= r8) goto L10;
        r3.add(JSONArrayProtectorUtils.getString(r2, r4));     // Catch: Throwable -> L13
        r4 = r4 + 1;     // Catch: Throwable -> L13
        goto L8
    L10:
        return r3;
    L11:
        Object r9 = Result.constructor-impl(null);     // Catch: Throwable -> L13
    L15:
        Result.exceptionOrNull-impl(r9);
        return null;
    L13:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    public static final boolean K0(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Map r3 = r2.getExt();
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.containsKey("simultaneous_interpretation") != true) goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean L(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return x(r1).getServerLoadingNotInterruptTts();
    }

    public static final boolean L0(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        String r5 = r4.getMessageId();
        if (r5 != null) goto L5;
        return false;
    L5:
        if (StringsKt.startsWith$default(r5, "spacer_cell_", false, 2, null) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean M(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return x(r1).getShowLoading();
    }

    public static final boolean M0(Message r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Map r0 = r5.getExt();
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = (String) r0.get("chat_round_first_raf");
    L7:
        if (Intrinsics.areEqual(r2, "1") == true) goto L33;
        Map r3 = r5.getExt();
        if (r3 == null) goto L11;
        String r4 = (String) r3.get("chat_lite_option");
    L13:
        if (Intrinsics.areEqual(r4, "1") == true) goto L33;
        Map r6 = r5.getExt();
        if (r6 == null) goto L17;
        String r7 = (String) r6.get("chat_lite_option");
    L19:
        if (Intrinsics.areEqual(r7, "2") == true) goto L33;
        Map r8 = r5.getExt();
        if (r8 == null) goto L23;
        String r9 = (String) r8.get("is_chat_lite");
    L25:
        if (Intrinsics.areEqual(r9, "2") == true) goto L33;
        Map r10 = r5.getExt();
        if (r10 == null) goto L30;
        r1 = (String) r10.get("is_chat_lite");
    L30:
        if (Intrinsics.areEqual(r1, "1") == true) goto L33;
        return false;
    L23:
        r9 = null;
        goto L25
    L17:
        r7 = null;
        goto L19
    L11:
        r4 = null;
    L33:
        return true;
    L5:
        r2 = null;
        goto L7
    }

    public static final boolean N(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.getContentType() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static final boolean N0(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r3.getContentType() != 6) goto L14;
        Map r0 = r3.getBusinessExt();
        String r2 = null;
        if (r0 == null) goto L7;
        String r1 = (String) r0.get("is_feely_emojis_img");
    L8:
        if (r1 != null) goto L13;
        Map r4 = r3.getExt();
        if (r4 == null) goto L12;
        r2 = (String) r4.get("is_feely_emojis_img");
    L12:
        if (r2 == null) goto L14;
    L13:
        return true;
    L7:
        r1 = null;
    L14:
        return false;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0056 -> B:16:0x0057). Please report as a decompilation issue!!! */
    public static final List<TextTagInfo> O(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
    L12:
        e = move-exception;
        FLogger.a.e("MessageExt", "getTextTagInfoList called, " + e.getMessage());
    L14:
        List<TextTagInfo> r4 = null;
    L16:
        return r4;
    L4:
        if (((Boolean) ac8.c.a.getValue()).booleanValue() == false) goto L8;
        Intrinsics.checkNotNullParameter(r3, "<this>");     // Catch: Exception -> L12
        Intrinsics.checkNotNullParameter(r3, "<this>");     // Catch: Exception -> L12
        TextContent r5 = r.b(r3);     // Catch: Exception -> L12
        if (r5 == null) goto L14;
        r4 = r5.textTags;     // Catch: Exception -> L12
        goto L16
    L8:
        wt7.c r0 = wt7.a.a;     // Catch: Exception -> L12
        String r6 = r3.getContent();     // Catch: Exception -> L12
        juc.d r1 = TextContent.Companion.serializer();     // Catch: Exception -> L12
        r0.getClass();     // Catch: Exception -> L12
        TextContent r7 = (TextContent) wt7.c.a(r6, r1);     // Catch: Exception -> L12
        if (r7 == null) goto L14;
        r4 = r7.textTags;     // Catch: Exception -> L12
        goto L16
    }

    public static final boolean O0(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.getContentType() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public static final String P(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        List r0 = com.larus.im.bean.message.a.S(r4);
        String r1 = null;
        if (r0 == null) goto L5;
        com.larus.im.bean.message.c r2 = (com.larus.im.bean.message.c) CollectionsKt.firstOrNull(r0);
    L6:
        if (r2 == null) goto L8;
        List r3 = r2.c();
    L9:
        if (r2 == null) goto L11;
        r1 = r2.b();
    L11:
        List r5 = r3;
        if (r5 != null) goto L14;
    L17:
        boolean r6 = true;
    L18:
        if (r6 == false) goto L20;
        return r1;
    L20:
        if (r1 != null) goto L23;
        r1 = "";
    L23:
        return q(r1, r3, r4, false, 24);
    L14:
        if (r5.isEmpty() == true) goto L17;
        r6 = false;
        goto L18
    L8:
        r3 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    public static final boolean P0(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (x(r4).getTemplateId() == null) goto L10;
        Long r5 = x(r4).getTemplateId();
        if (r5 != null) goto L8;
    L9:
        return true;
    L8:
        if (r5.longValue() != 0) goto L9;
    L10:
        return false;
    }

    public static final boolean Q(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return x(r1).getTts();
    }

    public static final boolean Q0(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r0 = wf9.b.a;
        Intrinsics.checkNotNullParameter(r1, "message");
        return com.larus.im.bean.message.a.w0(r1);
    }

    public static final boolean R(Message r5) {
        if (r5 == null) goto L66;
        List r6 = r5.getContentBlock();
        if (r6 == null) goto L67;
        List r7 = r6;
        if ((r7 instanceof Collection) == true) goto L9;
    L11:
        Iterator r8 = r7.iterator();
    L13:
        if (r8.hasNext() == false) goto L10;
        Block r1 = (Block) r8.next();
        if (r1.getBlockType() != BlockType.BLOCK_TYPE_QUICK_REPLY.getValue()) goto L41;
        BlockContent r3 = r1.getContent();
        if (r3 == null) goto L26;
        QuickReplyBlock r4 = r3.getQuickReplyBlock();
        if (r4 == null) goto L26;
        Integer r9 = r4.getScene();
        int r10 = QuickReplyScene.SCENE_COMPUTER_USE_AGENT_ASK_HUMAN.getValue();
        if (r9 == null) goto L26;
        if (r9.intValue() != r10) goto L26;
        boolean r11 = true;
    L27:
        if (r11 == false) goto L41;
        BlockContent r12 = r1.getContent();
        if (r12 == null) goto L38;
        QuickReplyBlock r13 = r12.getQuickReplyBlock();
        if (r13 == null) goto L38;
        Integer r14 = r13.getStatus();
        int r15 = QuickReplyBlockStatus.STATUS_HIDDEN.getValue();
        if (r14 == null) goto L38;
        if (r14.intValue() != r15) goto L38;
        boolean r16 = true;
    L39:
        if (r16 == true) goto L41;
    L54:
        boolean r2 = true;
    L56:
        if (r2 == false) goto L13;
        boolean r17 = true;
    L58:
        if (r17 != true) goto L68;
        return true;
    L68:
        return false;
    L38:
        r16 = false;
    L26:
        r11 = false;
    L41:
        if (r1.getBlockType() != BlockType.BLOCK_TYPE_INTERACTION_ASK.getValue()) goto L55;
        BlockContent r18 = r1.getContent();
        if (r18 == null) goto L52;
        InteractionAskBlock r19 = r18.getInteractionAskBlock();
        if (r19 == null) goto L52;
        Integer r20 = r19.getStatus();
        int r21 = InteractionAskBlockStatus.STATUS_PROCESSING.getValue();
        if (r20 == null) goto L52;
        if (r20.intValue() != r21) goto L52;
        boolean r22 = true;
    L53:
        if (r22 == false) goto L55;
    L52:
        r22 = false;
    L55:
        r2 = false;
    L10:
        r17 = false;
        goto L58
    L9:
        if (r7.isEmpty() == false) goto L11;
    L67:
        return false;
    L66:
        return false;
    }

    public static final boolean R0(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.getMessageStatus() != MessageStatus.MessageStatus_UNSELECTED) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean S(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r2.getSourceFromAsr() == true) goto L5;
    L15:
        return false;
    L5:
        if (r2.getMessageStatusLocal() != 0) goto L15;
        if (Intrinsics.areEqual(j(r2), "is_mock_sending") == false) goto L15;
        Map r3 = r2.getBusinessExt();
        if (r3 == null) goto L11;
        String r4 = (String) r3.get("is_real_audio_text");
    L13:
        if (Intrinsics.areEqual(r4, "1") == true) goto L15;
        return true;
    L11:
        r4 = null;
        goto L13
    }

    public static final boolean S0(PromptContent r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (U0() == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r1.getOnboardingDisplayStyle(), "vertical") == false) goto L7;
        return true;
    }

    public static final boolean T(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r3.getSourceFromAsr() == true) goto L5;
        return false;
    L5:
        if (r3.getMessageStatusLocal() == 0) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(j(r3), "place_holder") == false) goto L26;
        Map r0 = r3.getBusinessExt();
        if (r0 == null) goto L11;
        String r1 = (String) r0.get("is_real_audio_text");
    L13:
        if (Intrinsics.areEqual(r1, "1") == true) goto L27;
        String r4 = H(r3);
        if (r4 != null) goto L17;
    L20:
        boolean r5 = true;
    L21:
        if (r5 == false) goto L28;
        return true;
    L28:
        return false;
    L17:
        if (r4.length() == 0) goto L20;
        r5 = false;
        goto L21
    L27:
        return false;
    L11:
        r1 = null;
        goto L13
    L26:
        return false;
    }

    public static final boolean T0(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return x(r1).isVideoVLM();
    }

    public static final boolean U(Message r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        if (CollectionsKt.contains(CollectionsKt.listOf(new MessageStatus[]{MessageStatus.MessageStatus_INVISIBLE, MessageStatus.MessageStatus_NOT_EXIST, MessageStatus.MessageStatus_DELETED, MessageStatus.MessageStatus_BEFOREEDIT}), r5.getMessageStatus()) == true) goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean V(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        String r5 = r4.getLocalMessageId();
        if (r5 != null) goto L5;
        return false;
    L5:
        if (StringsKt.endsWith$default(r5, "-aweme", false, 2, null) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean V0(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return x(r1).isWelcomeBackMessageHidden();
    }

    public static final boolean W(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int r0 = x(r2).getOnboardingSugType();
        if (r0 == SuggestItemType.VideoRichMediaWelcomeBack.getValue()) goto L7;
        if (r0 == SuggestItemType.ArticleRichMediaWelcomeBack.getValue()) goto L7;
    L9:
        return false;
    L7:
        if ((!h1(r2).isEmpty()) == false) goto L9;
        return true;
    }

    public static final boolean W0(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (D(r1) != MessageTag.MessageTag_Onboarding_WELCOMEBACK) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean X(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (W0(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(x(r1).get("next_pulse_type"), "2") == false) goto L7;
        return true;
    }

    public static final boolean X0(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (W0(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(x(r1).get("next_pulse_card_name"), "world_cup_2026_guide") == false) goto L7;
        return true;
    }

    public static final boolean Y(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        String r5 = r4.getMessageId();
        if (r5 != null) goto L5;
        return false;
    L5:
        if (StringsKt.contains$default(r5, "-clear-context", false, 2, null) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean Y0(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (W0(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(x(r1).get("is_z_lottery_guide"), "1") == false) goto L7;
        return true;
    }

    public static final boolean Z(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return x(r1).isClearContextMessage();
    }

    public static final String Z0(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        MessageTag r3 = D(r2);
        int r4 = a.a[r3.ordinal()];
        if (r4 != 1) goto L5;
        return "first_met";
    L5:
        if (r4 != 2) goto L7;
        return "welcome_back";
    L7:
        if (r4 == 3) goto L12;
        return null;
    L12:
        return "first_met";
    }

    public static final boolean a(String r3) {
        if (r3.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L10:
        return false;
    L8:
        if (Intrinsics.areEqual(r3, "[]") == true) goto L10;
        return true;
    L5:
        r0 = false;
        goto L6
    }

    public static final boolean a0(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.getContentType() != 2022) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean a1(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (com.larus.im.bean.message.a.b0(r4) == true) goto L5;
        return false;
    L5:
        List r5 = com.larus.im.bean.message.a.d(r4);
        if ((r5 instanceof Collection) == true) goto L8;
    L10:
        Iterator r6 = r5.iterator();
    L12:
        if (r6.hasNext() == false) goto L9;
        if (((Block) r6.next()).getBlockType() != BlockType.BLOCK_TYPE_LOADING.getValue()) goto L16;
        boolean r0 = true;
    L17:
        if (r0 == true) goto L12;
        return false;
    L16:
        r0 = false;
    L9:
        return true;
    L8:
        if (r5.isEmpty() == false) goto L10;
        goto L9
    }

    public static final String b(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        JSONArray r4 = e(r3);
        if (r4.length() > 0) goto L5;
        return null;
    L5:
        JSONObject r5 = r4.optJSONObject(0);
        if (r5 != null) goto L8;
        return null;
    L8:
        String r6 = r5.optString("aed_display_res", "");
        if (r6 != null) goto L11;
        return null;
    L11:
        return r6;
    }

    public static final boolean b0(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return x(r1).isCrowdTest();
    }

    public static final ReferenceInfo b1(Message r13) {
        Intrinsics.checkNotNullParameter(r13, "<this>");
        if (r13.isNewBlockType() == false) goto L63;
        List r14 = r13.getContentBlock();
        String r0 = null;
        if (r14 == null) goto L17;
        Iterator r15 = r14.iterator();
    L8:
        if (r15.hasNext() == false) goto L15;
        Object r1 = r15.next();
        if (((Block) r1).getBlockType() != BlockType.BLOCK_TYPE_REFERENCE.getValue()) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L8;
    L16:
        Block r3 = (Block) r1;
    L18:
        if (r3 == null) goto L69;
        BlockContent r16 = r3.getContent();
        if (r16 == null) goto L26;
        ReferenceBlock r17 = r16.getReferenceBlock();
        if (r17 == null) goto L26;
        ReferenceText r18 = r17.getText();
        if (r18 == null) goto L26;
        String r4 = r18.getText();
    L27:
        BlockContent r19 = r3.getContent();
        if (r19 == null) goto L34;
        ReferenceBlock r110 = r19.getReferenceBlock();
        if (r110 == null) goto L34;
        ReferenceText r111 = r110.getText();
        if (r111 == null) goto L34;
        r0 = r111.getMessageId();
    L34:
        String r5 = r0;
        LinkedHashMap r8 = new LinkedHashMap();
        BlockContent r112 = r3.getContent();
        if (r112 == null) goto L43;
        ReferenceBlock r113 = r112.getReferenceBlock();
        if (r113 == null) goto L43;
        ReferenceTextOption r114 = r113.getOption();
        if (r114 == null) goto L43;
        String r115 = r114.getRefMsgIsSelf();
        if (r115 == null) goto L43;
        String r116 = (String) r8.put("ref_msg_is_self", r115);
    L43:
        BlockContent r117 = r3.getContent();
        if (r117 == null) goto L52;
        ReferenceBlock r118 = r117.getReferenceBlock();
        if (r118 == null) goto L52;
        ReferenceTextOption r119 = r118.getOption();
        if (r119 == null) goto L52;
        String r120 = r119.getDeepResearchPhase();
        if (r120 == null) goto L52;
        String r121 = (String) r8.put("deep_research_phase", r120);
    L52:
        BlockContent r122 = r3.getContent();
        if (r122 == null) goto L61;
        ReferenceBlock r123 = r122.getReferenceBlock();
        if (r123 == null) goto L61;
        ReferenceText r124 = r123.getText();
        if (r124 == null) goto L61;
        String r125 = r124.getIconKey();
        if (r125 == null) goto L61;
        r8.put("ref_icon_key", r125);
    L61:
        Unit r126 = Unit.INSTANCE;
        return new ReferenceInfo(null, r4, r5, 0, null, r8, null, null, 217, null);
    L26:
        r4 = null;
        goto L27
    L69:
        return null;
    L12:
        r2 = false;
        goto L13
    L15:
        r1 = null;
        goto L16
    L17:
        r3 = null;
        goto L18
    L63:
        return r13.getReferenceInfo();
    }

    public static final String c(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        JSONArray r4 = e(r3);
        if (r4.length() > 0) goto L5;
        return null;
    L5:
        JSONObject r5 = r4.optJSONObject(0);
        if (r5 != null) goto L8;
        return null;
    L8:
        String r6 = r5.optString("aed_res", "");
        if (r6 != null) goto L11;
        return null;
    L11:
        return r6;
    }

    public static final boolean c0(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r2.getContentType() == 800) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r2.getBizContentType(), "crowd_test_selection") == false) goto L7;
        return true;
    }

    public static final List<IMMetaInfo.f> c1(Message r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (com.larus.im.bean.message.a.b0(r5) == false) goto L9;
        List r6 = com.larus.im.bean.message.a.A(r5);
        ArrayList r0 = new ArrayList();
        Iterator r7 = r6.iterator();
    L6:
        if (r7.hasNext() == false) goto L8;
        CollectionsKt.addAll(r0, d1((Block) r7.next()));
        goto L6
    L8:
        return r0;
    L9:
        List<TextTagInfo> r8 = C(r5);
        ArrayList r1 = null;
        if (r8 == null) goto L36;
        ArrayList r2 = new ArrayList();
        Iterator<T> r9 = r8.iterator();
    L13:
        if (r9.hasNext() == false) goto L20;
        Object r3 = r9.next();
        boolean r4 = true;
        if (((TextTagInfo) r3).type == 1) goto L18;
        r4 = false;
    L18:
        if (r4 == false) goto L13;
        r2.add(r3);
        goto L13
    L20:
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r11 = r2.iterator();
    L22:
        if (r11.hasNext() == false) goto L35;
        TextTagInfo r12 = (TextTagInfo) r11.next();
        Gson r13 = HttpExtKt.f;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L29
        String r15 = r12.tagInfo;     // Catch: Throwable -> L29
        if (r15 != null) goto L27;
        r15 = "{}";
    L27:
        Object r16 = Result.constructor-impl((IMMetaInfo.f) r13.fromJson(r15, IMMetaInfo.f.class));     // Catch: Throwable -> L29
    L32:
        if (Result.isFailure-impl(r16) == false) goto L34;
        r16 = null;
    L34:
        r10.add((IMMetaInfo.f) r16);
    L29:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L32
    L35:
        r1 = r10;
    L36:
        if (r1 == null) goto L38;
        return r1;
    L38:
        return CollectionsKt.emptyList();
    }

    public static final boolean d(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Map r2 = r1.getExt();
        if (r2 == null) goto L5;
        String r3 = (String) r2.get("answer_action");
    L7:
        return Intrinsics.areEqual(r3, "1");
    L5:
        r3 = null;
        goto L7
    }

    public static final boolean d0(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return x(r1).isDeepThinkingPro();
    }

    public static final List<IMMetaInfo.f> d1(Block r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        List r6 = r5.getMetaInfo();
        if (r6 == null) goto L5;
        List r7 = r6;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r8 = r7.iterator();
    L8:
        if (r8.hasNext() == false) goto L10;
        BlockMetaInfo r2 = (BlockMetaInfo) r8.next();
        r0.add(new TextTagInfo(r2.type, r2.getRealInfo()));
        goto L8
    L10:
        ArrayList r9 = new ArrayList();
        Iterator r1 = r0.iterator();
    L12:
        if (r1.hasNext() == false) goto L19;
        Object r3 = r1.next();
        boolean r4 = true;
        if (((TextTagInfo) r3).type == 1) goto L17;
        r4 = false;
    L17:
        if (r4 == false) goto L12;
        r9.add(r3);
        goto L12
    L19:
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r11 = r9.iterator();
    L21:
        if (r11.hasNext() == false) goto L34;
        TextTagInfo r12 = (TextTagInfo) r11.next();
        Gson r13 = HttpExtKt.f;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L28
        String r15 = r12.tagInfo;     // Catch: Throwable -> L28
        if (r15 != null) goto L26;
        r15 = "{}";
    L26:
        Object r16 = Result.constructor-impl((IMMetaInfo.f) r13.fromJson(r15, IMMetaInfo.f.class));     // Catch: Throwable -> L28
    L31:
        if (Result.isFailure-impl(r16) == false) goto L33;
        r16 = null;
    L33:
        r10.add((IMMetaInfo.f) r16);
    L28:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L31
    L34:
        return r10;
    L5:
        return CollectionsKt.emptyList();
    }

    public static final JSONArray e(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Map r2 = r1.getExt();
        if (r2 == null) goto L17;
        String r3 = (String) r2.get("audio_event_resp");
        if (r3 == null) goto L17;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        Object r4 = Result.constructor-impl(new JSONArray(r3));     // Catch: Throwable -> L8
    L11:
        if (Result.isFailure-impl(r4) == false) goto L13;
        r4 = null;
    L13:
        JSONArray r5 = (JSONArray) r4;
        if (r5 == null) goto L17;
        return r5;
    L8:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
    L17:
        return new JSONArray();
    }

    public static final boolean e0(Message r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (com.larus.im.bean.message.a.f0(r5) == true) goto L5;
        return true;
    L5:
        int r0 = r5.getContentType();
        if (r0 == 1) goto L11;
        if (r0 == 9999) goto L11;
        return true;
    L11:
        if (com.larus.im.bean.message.a.b0(r5) == false) goto L29;
        List r6 = com.larus.im.bean.message.a.d(r5);
        if ((r6 instanceof Collection) == true) goto L15;
    L17:
        Iterator r7 = r6.iterator();
    L19:
        if (r7.hasNext() == false) goto L42;
        Block r1 = (Block) r7.next();
        if (r1.getBlockType() == BlockType.BLOCK_TYPE_DEEP_THINK.getValue()) goto L23;
    L25:
        boolean r2 = false;
    L26:
        if (r2 == false) goto L19;
        return false;
    L23:
        if (r1.isFinish() == true) goto L25;
        r2 = true;
        goto L26
    L42:
        return true;
    L15:
        if (r6.isEmpty() == false) goto L17;
        return true;
    L29:
        List r8 = com.larus.im.bean.message.a.S(r5);
        if (r8 == null) goto L35;
        com.larus.im.bean.message.c r9 = (com.larus.im.bean.message.c) CollectionsKt.firstOrNull(r8);
        if (r9 == null) goto L35;
        return Intrinsics.areEqual(r9.d, Boolean.TRUE);
    L35:
        return true;
    }

    public static final String e1(Integer r2) {
        int r0 = RichMediaType.SEARCH_IMAGE.getValue();
        if (r2 != null) goto L6;
    L8:
        int r1 = RichMediaType.SEARCH_VIDEO.getValue();
        if (r2 != null) goto L12;
    L14:
        int r3 = RichMediaType.RUYI.getValue();
        if (r2 != null) goto L18;
    L20:
        int r4 = RichMediaType.APPLET.getValue();
        if (r2 != null) goto L24;
    L26:
        return "";
    L24:
        if (r2.intValue() != r4) goto L26;
        return "applet";
    L18:
        if (r2.intValue() != r3) goto L20;
        return "lynx_ruyi";
    L12:
        if (r2.intValue() != r1) goto L14;
        return "video-group";
    L6:
        if (r2.intValue() != r0) goto L8;
        return "image-group";
    }

    public static final NestedFileContent f(Message r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        if (r9.isNewBlockType() == false) goto L34;
        List r0 = r9.getContentBlock();
        List r1 = null;
        if (r0 == null) goto L17;
        Iterator r2 = r0.iterator();
    L8:
        if (r2.hasNext() == false) goto L15;
        Object r3 = r2.next();
        if (((Block) r3).getBlockType() != BlockType.BLOCK_TYPE_ATTACHMENT.getValue()) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == false) goto L8;
    L16:
        Block r5 = (Block) r3;
    L18:
        if (r5 == null) goto L45;
        BlockContent r6 = r5.getContent();
        if (r6 == null) goto L45;
        AttachmentBlock r7 = r6.getAttachmentBlock();
        if (r7 == null) goto L45;
        List r8 = r7.getAttachments();
        if (r8 == null) goto L45;
        ArrayList r10 = new ArrayList();
        Iterator r11 = r8.iterator();
    L27:
        if (r11.hasNext() == false) goto L31;
        UplinkFileEntity r12 = h.f((AttachmentItem) r11.next(), r9);
        if (r12 == null) goto L27;
        r10.add(r12);
        goto L27
    L31:
        r1 = CollectionsKt.toMutableList(r10);
    L45:
        return new NestedFileContent(r1, null, false, null, 14, null);
    L12:
        r4 = false;
        goto L13
    L15:
        r3 = null;
        goto L16
    L17:
        r5 = null;
        goto L18
    L34:
        return com.larus.bmhome.chat.sendimage.e.e(r9.getContent());
    }

    public static final boolean f0(Message r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (com.larus.im.bean.message.a.f0(r5) == true) goto L6;
        return false;
    L6:
        if (ObricTtsControlDelegate.b.e() == true) goto L8;
    L10:
        int r0 = r5.getContentType();
        if (r0 == 1) goto L16;
        if (r0 == 9999) goto L16;
        return false;
    L16:
        if (com.larus.im.bean.message.a.b0(r5) == true) goto L18;
        List r1 = com.larus.im.bean.message.a.S(r5);
        if (r1 == null) goto L70;
        com.larus.im.bean.message.c r2 = (com.larus.im.bean.message.c) CollectionsKt.firstOrNull(r1);
        if (r2 != null) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(r2.d, Boolean.FALSE) == true) goto L58;
        com.larus.im.internal.stream.b r3 = com.larus.im.internal.stream.b.a;
        String r4 = r2.e;
        if (r4 != null) goto L48;
        r4 = "";
    L48:
        Integer r6 = r2.c;
        if (r6 == null) goto L51;
        int r7 = r6.intValue();
    L53:
        if (r3.d(r4, r7) == null) goto L55;
        boolean r8 = true;
    L56:
        if (r8 == true) goto L58;
        return false;
    L55:
        r8 = false;
        goto L56
    L51:
        r7 = -1;
    L58:
        if (r5.getMessageStatusLocal() != 20) goto L60;
    L61:
        return true;
    L60:
        if (r5.getMessageStatusLocal() == 21) goto L61;
        return false;
    L70:
        return false;
    L18:
        if (com.larus.im.bean.message.a.w0(r5) == false) goto L68;
        List r9 = com.larus.im.bean.message.a.f(r5);
        if ((r9 instanceof Collection) == true) goto L22;
    L24:
        Iterator r10 = r9.iterator();
    L26:
        if (r10.hasNext() == false) goto L35;
        Block r11 = (Block) r10.next();
        if (r11.getBlockType() == BlockType.BLOCK_TYPE_DEEP_THINK.getValue()) goto L30;
    L32:
        boolean r12 = false;
    L33:
        if (r12 == false) goto L26;
        boolean r13 = false;
    L36:
        if (r13 == false) goto L69;
        return true;
    L69:
        return false;
    L30:
        if (r11.isFinish() == false) goto L32;
        r12 = true;
    L35:
        r13 = true;
        goto L36
    L22:
        if (r9.isEmpty() == false) goto L24;
    L68:
        return false;
    L8:
        if (com.larus.im.bean.message.a.w0(r5) == true) goto L10;
        return false;
    }

    public static final ImageContent g(Message r25) {
        Intrinsics.checkNotNullParameter(r25, "<this>");
        boolean r3 = false;
        if (r25.isNewBlockType() == false) goto L40;
        List r2 = r25.getContentBlock();
        if (r2 == null) goto L17;
        Iterator r4 = r2.iterator();
    L8:
        if (r4.hasNext() == false) goto L15;
        Object r7 = r4.next();
        if (((Block) r7).getBlockType() != BlockType.BLOCK_TYPE_ATTACHMENT.getValue()) goto L12;
        boolean r8 = true;
    L13:
        if (r8 == false) goto L8;
    L16:
        Block r9 = (Block) r7;
    L18:
        if (r9 == null) goto L38;
        BlockContent r5 = r9.getContent();
        if (r5 == null) goto L38;
        AttachmentBlock r6 = r5.getAttachmentBlock();
        if (r6 == null) goto L38;
        List r10 = r6.getAttachments();
        if (r10 == null) goto L38;
        ArrayList r11 = new ArrayList();
        Iterator r12 = r10.iterator();
    L27:
        if (r12.hasNext() == false) goto L65;
        AttachmentItem r13 = (AttachmentItem) r12.next();
        Intrinsics.checkNotNullParameter(r13, "<this>");
        Intrinsics.checkNotNullParameter(r25, "originMessage");
        Map r14 = r25.getBusinessExt();
        if (r14 == null) goto L31;
        String r15 = (String) r14.get("send_image_local_path");
    L32:
        UploadImage r16 = r13.getImage();
        if (r16 == null) goto L35;
        Image r17 = Image.copy$default(h.b(r16), null, null, null, null, null, r15, null, null, null, null, null, null, null, null, 16351, null);
    L36:
        if (r17 == null) goto L27;
        r11.add(r17);
        goto L27
    L35:
        r17 = null;
        goto L36
    L31:
        r15 = null;
    L65:
        return new ImageContent(r11, null, 2, null);
    L38:
        r11 = null;
        goto L65
    L12:
        r8 = false;
        goto L13
    L15:
        r7 = null;
        goto L16
    L17:
        r9 = null;
        goto L18
    L40:
        String r0 = r25.getContent();
        Lazy r1 = com.larus.bmhome.chat.sendimage.e.a;
        if (r0 != null) goto L43;
    L44:
        r3 = true;
    L45:
        if (r3 == true) goto L66;
        ImageContent r18 = (ImageContent) com.larus.bmhome.chat.sendimage.e.i().fromJson(r0, (Type) com.larus.bmhome.chat.sendimage.e.a.getValue());     // Catch: Throwable -> L51
        if (r18 != null) goto L67;
        return new ImageContent(new ArrayList(), null, 2, null);
    L67:
        return r18;
    L52:
        return new ImageContent(new ArrayList(), null, 2, null);
    L66:
        return new ImageContent(new ArrayList(), null, 2, null);
    L43:
        if (r0.length() != 0) goto L45;
        goto L44
    }

    public static final boolean g0(PromptContent r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Map<String, String> r0 = r3.getBusinessExt();
        if (r0 == null) goto L9;
        String r1 = r0.get("next_pulse_scene");
        if (r1 == null) goto L9;
        Integer r2 = StringsKt.toIntOrNull(r1);
        if (r2 == null) goto L9;
        int r4 = r2.intValue();
    L11:
        if (S0(r3) == true) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(r3.getWcbRenderStatus(), WcbRenderStatus.DEFAULT) == true) goto L15;
        return false;
    L15:
        if (r4 > 1) goto L20;
        return true;
    L20:
        return false;
    L9:
        r4 = 0;
        goto L11
    }

    public static final int h(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return x(r1).getActionBarInstructionType();
    }

    public static final boolean h0(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Integer r2 = r1.getFeedback();
        int r0 = MsgFeedbackType.MsgFeedbackTypeDislike.value;
        if (r2 != null) goto L6;
    L8:
        return false;
    L6:
        if (r2.intValue() != r0) goto L8;
        return true;
    }

    public static final List<OnboardingSug> h1(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        String r3 = x(r2).getOnboardingSug();
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        Gson r1 = HttpExtKt.f;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L12
        Object r5 = Result.constructor-impl((List) r1.fromJson(r3, new b().getType()));     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r5) == false) goto L17;
        r5 = null;
    L17:
        List r6 = (List) r5;
        if (r6 == null) goto L23;
        List<OnboardingSug> r7 = CollectionsKt.filterNotNull(r6);
        if (r7 == null) goto L23;
        return r7;
    L23:
        return CollectionsKt.emptyList();
    L12:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L8:
        return CollectionsKt.emptyList();
    L5:
        r0 = false;
        goto L6
    }

    public static final String i(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return x(r1).getActionBarKey();
    }

    public static final boolean i0(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        String r0 = com.larus.network.http.d.a;
        if (com.larus.network.http.d.e == false) goto L11;
        Map r2 = r1.getExt();
        if (r2 == null) goto L7;
        String r3 = (String) r2.get("evaluate_interference");
    L9:
        if (Intrinsics.areEqual(r3, "1") == false) goto L11;
        return true;
    L7:
        r3 = null;
    L11:
        return false;
    }

    public static final String j(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Map r2 = r1.getBusinessExt();
        if (r2 != null) goto L7;
        return null;
    L7:
        return (String) r2.get("biz_audio_url");
    }

    public static final boolean j0(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r2.getMessageStatusLocal() != 21) goto L5;
    L10:
        return true;
    L5:
        if (r2.getMessageStatusLocal() == 23) goto L10;
        if (r2.getMessageStatusLocal() == 22) goto L10;
        return false;
    }

    public static final boolean j1(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Intrinsics.areEqual(x(r1).get("use_creation"), "1");
    }

    public static final boolean k(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.getContentType() != 9999) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean k0(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (D(r1) != MessageTag.MessageTag_Onboarding_FIRSTMEG) goto L5;
        return true;
    L5:
        return false;
    }

    public static final Map<String, String> l(Message r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Map r0 = r8.getExt();
        if (r0 == null) goto L5;
        String r1 = (String) r0.get("business_notify_extra");
    L6:
        String r2 = "";
        if (r1 != null) goto L10;
        r1 = "";
    L10:
        if (r1.length() != 0) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == false) goto L38;
        return null;
    L38:
        JSONObject r4 = new JSONObject(r1).optJSONObject("tracking");     // Catch: Exception -> L31
        if (r4 != null) goto L18;
        return null;
    L18:
        HashMap r5 = new HashMap(r4.length());     // Catch: Exception -> L31
        Iterator<String> r6 = r4.keys();     // Catch: Exception -> L31
    L19:
        if (r6.hasNext() == false) goto L43;
        String r7 = r6.next();     // Catch: Exception -> L31
        Object r9 = r4.opt(r7);     // Catch: Exception -> L31
        if (r9 != null) goto L24;
    L27:
        String r10 = "";
    L28:
        r5.put(r7, r10);     // Catch: Exception -> L31
        goto L19
    L24:
        if (Intrinsics.areEqual(r9, JSONObject.NULL) == true) goto L27;
        r10 = r9.toString();     // Catch: Exception -> L31
        goto L28
    L43:
        return r5;
    L31:
        e = move-exception;
        FLogger r11 = FLogger.a;
        String r12 = r8.getMessageId();
        if (r12 == null) goto L36;
        r2 = r12;
    L36:
        r11.e("MessageExt", "getBusinessNotifyTrackingMap parse failed, msgId=".concat(r2), e);
        return null;
    L12:
        r3 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public static final boolean l0(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Map r3 = r2.getExt();     // Catch: JSONException -> L10
        if (r3 == null) goto L9;
        String r4 = (String) r3.get("edu_params");     // Catch: JSONException -> L10
        if (r4 == null) goto L9;
        return Intrinsics.areEqual(new JSONObject(r4).optString("scene"), "homework_correction");
    L9:
        return false;
    }

    public static final boolean m0(Message r7) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        if (S(r7) == false) goto L15;
        String r0 = H(r7);
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == false) goto L15;
        long r3 = r7.getCreateTime() * ((long) 1000);
        if ((AppHost.a.getAppClock().currentTimeMillis() - r3) < 120000) goto L15;
        return true;
    L7:
        if (r0.length() == 0) goto L10;
        r1 = false;
    L15:
        return false;
    }

    public static final String n(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        List r0 = com.larus.im.bean.message.a.S(r4);
        String r1 = null;
        if (r0 == null) goto L5;
        com.larus.im.bean.message.c r2 = (com.larus.im.bean.message.c) CollectionsKt.firstOrNull(r0);
    L6:
        if (r2 == null) goto L8;
        List r3 = r2.c();
    L9:
        if (r2 == null) goto L11;
        r1 = r2.a;
    L11:
        List r5 = r3;
        if (r5 != null) goto L14;
    L17:
        boolean r6 = true;
    L18:
        if (r6 == false) goto L20;
        return r1;
    L20:
        if (r1 != null) goto L23;
        r1 = "";
    L23:
        return q(r1, r3, r4, false, 24);
    L14:
        if (r5.isEmpty() == true) goto L17;
        r6 = false;
        goto L18
    L8:
        r3 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    public static final boolean n0(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.getContentType() != 6) goto L5;
        return true;
    L5:
        return false;
    }

    public static final String o(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (com.larus.im.bean.message.a.b0(r1) == false) goto L7;
        return com.larus.im.bean.message.a.B(r1);
    L7:
        return r1.getContent();
    }

    public static final boolean o0(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r2.getContentType() == 6) goto L7;
        if (dp8.a.a(r2) == true) goto L7;
    L9:
        return false;
    L7:
        if (r2.getUserType() != 2) goto L9;
        return true;
    }

    public static final boolean p0(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.getSourceFromAsr() == true) goto L5;
    L9:
        return false;
    L5:
        if (r1.getContentType() != 0) goto L9;
        if (b0.h(r1) == true) goto L9;
        return true;
    }

    public static final boolean q0(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Integer r2 = r1.getFeedback();
        int r0 = MsgFeedbackType.MsgFeedbackTypeLike.value;
        if (r2 != null) goto L6;
    L8:
        return false;
    L6:
        if (r2.intValue() != r0) goto L8;
        return true;
    }

    public static final String r(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (com.larus.im.bean.message.a.b0(r2) == true) goto L5;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        TextContent r3 = com.larus.im.bean.message.a.P(r2);
        if (r3 != null) goto L11;
        return null;
    L11:
        return r3.text;
    L5:
        return com.larus.im.bean.message.a.B(r2);
    }

    public static final boolean r0(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.getMessageStatusLocal() != 0) goto L5;
    L8:
        return true;
    L5:
        if (r1.getMessageStatusLocal() == 12) goto L8;
        return false;
    }

    public static final String s(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        List<TextTagInfo> r0 = O(r4);
        int r1 = wf9.b.a;
        Intrinsics.checkNotNullParameter(r4, "message");
        String r2 = com.larus.im.bean.message.a.K(r4);
        List<TextTagInfo> r3 = r0;
        if (r3 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == false) goto L11;
        return r2;
    L11:
        if (r2 != null) goto L14;
        r2 = "";
    L14:
        return q(r2, r0, r4, false, 24);
    L5:
        if (r3.isEmpty() == true) goto L8;
        r5 = false;
        goto L9
    }

    public static final boolean s0(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (D(r1) != MessageTag.MessageTag_Onboarding_LONG_TIME_NO_SEE) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <CONTENT> CONTENT t(Message r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        IMessageContentConvertor.a.getClass();
        Intrinsics.checkNotNullParameter(r5, "message");
        String r0 = r5.getContent();
        if (r0 != null) goto L5;
    L4:
        Object r2 = null;
    L17:
        if (r2 != null) goto L20;
        return null;
    L20:
        return (CONTENT) r2;
    L5:
        String r1 = r0.hashCode() + r5.getMessageId();
        r2 = IMessageContentConvertor.a.b.get(r1);
        if (r2 != null) goto L17;
        Set r3 = ServiceManager.get().getServices(IMessageContentConvertor.class, true);
        Iterator r4 = r3.iterator();
    L10:
        if (r4.hasNext() == false) goto L16;
        Pair r6 = ((IMessageContentConvertor) r4.next()).a(r5);
        if (r6 == null) goto L10;
        boolean r7 = ((Boolean) r6.getFirst()).booleanValue();
        r2 = r6.getSecond();
        if (r7 == false) goto L17;
        IMessageContentConvertor.a.b.put(r1, r2);
        goto L17
    L16:
        FLogger.a.e("CONTENT_CONVERT", "all converter: " + r3);
        goto L4
    }

    public static final boolean t0(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Map r2 = r1.getExt();
        if (r2 == null) goto L5;
        String r3 = (String) r2.get("is_lottery");
    L7:
        return Intrinsics.areEqual(r3, "1");
    L5:
        r3 = null;
        goto L7
    }

    public static final String u(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Map r2 = r1.getExt();
        if (r2 != null) goto L7;
        return null;
    L7:
        return (String) r2.get("deep_research_id");
    }

    public static final boolean u0(com.larus.im.bean.bot.BotOnBoarding r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        List r0 = r4.getMessageList();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return true;
    L11:
        List r5 = r4.getMessageList();
        Intrinsics.checkNotNull(r5);
        List r6 = r5;
        if ((r6 instanceof Collection) == true) goto L14;
    L16:
        Iterator r7 = r6.iterator();
        if (r7.hasNext() == false) goto L57;
        PromptContent r8 = i1((Message) r7.next(), null, 3);
        if (r8.isEmpty() == false) goto L21;
        return false;
    L21:
        List<String> r2 = r8.getSuggest();
        if (r2 == null) goto L34;
        List<String> r3 = r2;
        if ((r3 instanceof Collection) == true) goto L26;
    L28:
        Iterator<T> r9 = r3.iterator();
    L30:
        if (r9.hasNext() == false) goto L34;
        if (StringsKt.isBlank((String) r9.next()) == false) goto L30;
        boolean r10 = true;
    L35:
        List<PromptContent.SuggestItem> r11 = r8.getSuggestItems();
        if (r11 == null) goto L51;
        List<PromptContent.SuggestItem> r12 = r11;
        if ((r12 instanceof Collection) == true) goto L40;
    L42:
        Iterator<T> r13 = r12.iterator();
    L44:
        if (r13.hasNext() == false) goto L51;
        String r14 = ((PromptContent.SuggestItem) r13.next()).getSuggest();
        if (r14 == null) goto L48;
        boolean r15 = StringsKt.isBlank(r14);
    L49:
        if (r15 == false) goto L44;
        boolean r16 = true;
    L52:
        if (r10 == true) goto L66;
        if (r16 == true) goto L67;
        return false;
    L67:
        return true;
    L66:
        return true;
    L48:
        r15 = true;
        goto L49
    L40:
        if (r12.isEmpty() == false) goto L42;
    L51:
        r16 = false;
        goto L52
    L26:
        if (r3.isEmpty() == false) goto L28;
    L34:
        r10 = false;
    L57:
        return false;
    L14:
        if (r6.isEmpty() == false) goto L16;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public static final boolean v(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return x(r1).getDisableActionView();
    }

    public static final boolean v0(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (k0(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(x(r1).get("is_mock_onboarding_text"), "1") == false) goto L7;
        return true;
    }

    public static final boolean w(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (i0(r2) == false) goto L13;
        String r3 = com.larus.network.http.d.a;
        com.larus.network.http.e r4 = com.larus.network.http.d.h;
        if (r4 != null) goto L7;
    L9:
        boolean r5 = false;
    L10:
        if (r5 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r4.g != true) goto L9;
        r5 = true;
        goto L10
    L13:
        return false;
    }

    public static final boolean w0(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (z2.a.audioTtsUseSceneVerify() == true) goto L5;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (x(r2).getTtsStr().length() <= 0) goto L9;
        return true;
    L9:
        return false;
    L5:
        return Intrinsics.areEqual(x(r2).getClientReportScene(), "gui");
    }

    public static final IMMsgExt x(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        IMMsgExt r0 = new IMMsgExt();
        Map r5 = r4.getExt();     // Catch: Exception -> L7
        if (r5 == null) goto L9;
        r0.putAll(new ConcurrentHashMap(r5));     // Catch: Exception -> L7
    L9:
        return r0;
    L7:
        e = move-exception;
        FLogger.a.i("MessageExt", "extras e=" + e.getMessage());
        com.larus.platform.service.g.a.ensureNotReachHere(e);
        goto L9
    }

    public static final boolean x0(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.getContentType() != 66) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean y(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return x(r1).getFeelyImgMessage();
    }

    public static final boolean y0(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (x(r1).isCrowdTest() == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.isNewBlockType() == true) goto L7;
        return true;
    }

    public static final FpaCommonParam z(Message r12) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        Gson r1 = new Gson();     // Catch: Throwable -> L8
        String r13 = x(r12).getFpaCommonParam();     // Catch: Throwable -> L8
        if (r13 != null) goto L6;
        r13 = "{}";
    L6:
        Object r14 = Result.constructor-impl((FpaCommonParam) r1.fromJson(r13, FpaCommonParam.class));     // Catch: Throwable -> L8
    L11:
        if (Result.exceptionOrNull-impl(r14) == null) goto L15;
        r14 = new FpaCommonParam(null, null, null, null, null, null, null, null, 255, null);
    L15:
        return (FpaCommonParam) r14;
    L8:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public static final boolean z0(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        MessageTag.a r0 = MessageTag.Companion;
        List r2 = r1.getTags();
        r0.getClass();
        if (MessageTag.a.b(r2) == MessageTag.MessageTag_Unknown) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean D0(Message r4, Message r5) {
        Intrinsics.checkNotNullParameter(r5, "target");
        String r0 = null;
        if (r4 == null) goto L5;
        String r1 = r4.getLocalMessageId();
    L6:
        if (r4 == null) goto L9;
        r0 = r4.getMessageId();
    L9:
        if (r1 != null) goto L11;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == false) goto L17;
    L18:
        if (r0 != null) goto L20;
    L23:
        boolean r2 = true;
    L24:
        if (r2 == false) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(r0, r5.getMessageId()) == false) goto L30;
    L27:
        return true;
    L30:
        return false;
    L20:
        if (StringsKt.isBlank(r0) == true) goto L23;
        r2 = false;
        goto L24
    L17:
        if (Intrinsics.areEqual(r1, r5.getLocalMessageId()) == true) goto L27;
    L11:
        if (StringsKt.isBlank(r1) == true) goto L14;
        r3 = false;
        goto L15
    L5:
        r1 = null;
        goto L6
    }

    @Deprecated(message = "replaced by ISendMessageStrategy")
    public static final f0 g1(Message r26, ClientControllerParam r27) {
        Intrinsics.checkNotNullParameter(r26, "<this>");
        String r0 = r26.getConversationId();
        if (r0 != null) goto L5;
        String r4 = "";
    L6:
        String r1 = r26.getSenderId();
        if (r1 != null) goto L9;
        String r6 = "";
    L10:
        int r7 = r26.getUserType();
        int r8 = r26.getContentType();
        String r9 = r26.getContent();
        ReferenceInfo r13 = r26.getReferenceInfo();
        boolean r14 = r26.getSourceFromAsr();
        String r10 = r26.getLocalMessageId();
        int r12 = r26.getMessageStatusLocal();
        Map r16 = r26.getExt();
        Map r2 = r26.getBusinessExt();
        if (r2 != null) goto L14;
        r2 = new LinkedHashMap();
    L14:
        return new f0(r4, null, r6, r7, r8, r9, r10, null, r12, r13, r14, null, r16, null, null, null, null, r2, r27, null, null, 524143298);
    L9:
        r6 = r1;
        goto L10
    L5:
        r4 = r0;
        goto L6
    }

    public static final String m(Message r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        List<TextTagInfo> r0 = O(r3);
        String r1 = com.larus.im.bean.message.a.O(r3);
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        List<TextTagInfo> r2 = r0;
        if (r2 != null) goto L8;
    L11:
        boolean r5 = true;
    L12:
        if (r5 == false) goto L15;
        return r1;
    L15:
        return q(r1, r0, r3, r4, 16);
    L8:
        if (r2.isEmpty() == true) goto L11;
        r5 = false;
        goto L12
    }

    public static final String f1(Message r3, PromptContent.SuggestV2 r4, PromptContent.SuggestItem r5) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Integer r0 = null;
        if (r5 == null) goto L5;
        String r6 = r5.getSuggestedType();
    L7:
        if (x(r3).isEmpty() == true) goto L35;
        if (r4 == null) goto L11;
        r0 = r4.getSuggestType();
    L11:
        boolean r7 = true;
        if (r0 != null) goto L15;
    L17:
        boolean r1 = false;
    L18:
        if (r1 == false) goto L20;
        return "ai_generate_suggest";
    L20:
        if (r6 != null) goto L40;
        String r8 = (String) x(r3).get("suggested_type");
        if (r8 != null) goto L25;
    L28:
        if (r7 == true) goto L31;
        return r8;
    L31:
        if (x(r3).getProactiveBotMessage() == false) goto L33;
    L36:
        return "bot_active";
    L33:
        if (x(r3).getActionBarProactiveBotMessage() == false) goto L35;
    L25:
        if (r8.length() == 0) goto L28;
        r7 = false;
        goto L28
    L40:
        return r6;
    L15:
        if (r0.intValue() != 5) goto L17;
        r1 = true;
    L35:
        return "suggested_prompt";
    L5:
        r6 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.util.ArrayList] */
    public static PromptContent i1(Message r13, List r14, int r15) {
        if ((r15 & 2) == 0) goto L5;
        r14 = CollectionsKt.emptyList();
    L5:
        Intrinsics.checkNotNullParameter(r13, "<this>");
        Intrinsics.checkNotNullParameter(r14, "dynamicSuggest");
        ArrayList r2 = new ArrayList();
        ArrayList r4 = new ArrayList();
        ArrayList r3 = new ArrayList();
        List r0 = r13.getSuggestQuestions();
        if (r0 == null) goto L14;
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L14;
        String r5 = ((SuggestQuestion) r1.next()).content;
        if (r5 != null) goto L13;
        r5 = "";
    L13:
        r2.add(r5);
    L14:
        List r16 = r14;
        boolean r6 = true;
        if ((!r16.isEmpty()) == false) goto L17;
        r4.addAll(r16);
    L39:
        Gson r17 = HttpExtKt.f;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L42
        Object r18 = Result.constructor-impl((List) r17.fromJson(x(r13).getSuggestV2Prompt(), new f().getType()));     // Catch: Throwable -> L42
    L45:
        if (Result.isFailure-impl(r18) == false) goto L47;
        r18 = null;
    L47:
        List r19 = (List) r18;
        if (r19 == null) goto L50;
        List r110 = r19;
    L51:
        r3.addAll(r110);
        boolean r8 = x(r13).isNoDisappear();
        int r9 = x(r13).getSuggestActionCardCnt();
        Map r10 = r13.getBusinessExt();
        if (r10 == null) goto L55;
        String r11 = (String) r10.get("onboarding_display_style");
        if (r11 == null) goto L55;
    L56:
        String r12 = r11;
        PromptContent.SuggestV2 r20 = (PromptContent.SuggestV2) CollectionsKt.firstOrNull(r3);
        Intrinsics.checkNotNullParameter(r13, "<this>");
        if (z0(r13) == true) goto L59;
        String r111 = f1(r13, r20, null);
    L60:
        String r21 = r111;
        Map r22 = r13.getBusinessExt();
        if (U0() == false) goto L64;
        String r112 = (String) x(r13).get("wcb_render_status");
        if (r112 == null) goto L64;
    L66:
        return new PromptContent(r2, r3, r4, r8, r9, r12, r21, r22, r112, x(r13).getWcbTitle(), Integer.valueOf(x(r13).getWcbTitleStyle()));
    L64:
        r112 = WcbRenderStatus.DEFAULT;
        goto L66
    L59:
        r111 = "onboarding_" + D(r13).value;
    L55:
        r11 = x(r13).getOnboardingDisplayStyle();
        goto L56
    L50:
        r110 = CollectionsKt.emptyList();
    L42:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L45
    L17:
        Gson r113 = HttpExtKt.f;
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L26
        String r25 = x(r13).getSuggestItemsV2();     // Catch: Throwable -> L26
        if (r25.length() == 0) goto L22;
        r6 = false;
    L22:
        if (r6 == false) goto L24;
        r25 = x(r13).getSuggestItems();     // Catch: Throwable -> L26
    L24:
        Object r114 = Result.constructor-impl((List) r113.fromJson(r25, new e().getType()));     // Catch: Throwable -> L26
    L29:
        if (Result.isFailure-impl(r114) == false) goto L31;
        r114 = null;
    L31:
        List r115 = (List) r114;
        if (r115 == null) goto L37;
        List r26 = new ArrayList();
        Iterator r116 = r115.iterator();
    L35:
        if (r116.hasNext() == false) goto L38;
        Object r27 = r116.next();
        PromptContent.SuggestItem r28 = (PromptContent.SuggestItem) r27;
        r26.add(r27);
    L38:
        r4.addAll(r26);
        goto L39
    L37:
        r26 = CollectionsKt.emptyList();
    L26:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r114 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    }

    public static String q(String r6, List r7, Message r8, boolean r9, int r10) {
        if ((r10 & 8) == 0) goto L5;
        boolean r3 = false;
    L6:
        Intrinsics.checkNotNullParameter(r6, "content");
        return p(r6, r7, r8, r3, null, CollectionsKt.emptyList());
    L5:
        r3 = r9;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r34v0 */
    /* JADX WARN: Type inference failed for: r34v1 */
    /* JADX WARN: Type inference failed for: r34v10 */
    /* JADX WARN: Type inference failed for: r34v11 */
    /* JADX WARN: Type inference failed for: r34v12 */
    /* JADX WARN: Type inference failed for: r34v13 */
    /* JADX WARN: Type inference failed for: r34v14 */
    /* JADX WARN: Type inference failed for: r34v5 */
    /* JADX WARN: Type inference failed for: r34v6 */
    /* JADX WARN: Type inference failed for: r34v7 */
    /* JADX WARN: Type inference failed for: r34v8 */
    /* JADX WARN: Type inference failed for: r34v9 */
    /* JADX WARN: Type inference failed for: r4v27, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r4v35, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r4v46, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r4v50, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r4v51, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.util.List] */
    public static final String p(String r35, List<TextTagInfo> r36, Message r37, boolean r38, String r39, List<IMMetaInfo.InsertTextReference> r40) {
        String r5 = "content";
        Intrinsics.checkNotNullParameter(r35, "content");
        Intrinsics.checkNotNullParameter(r40, "additionalInsertTextReferences");
        if (r37 == null) goto L5;
        r37.getMessageId();
    L5:
        ConcurrentHashMap r6 = new ConcurrentHashMap();
        if (r36 == null) goto L19;
        ?? r9 = new ArrayList();
        Iterator r0 = r36.iterator();
    L9:
        if (r0.hasNext() == false) goto L20;
        Object r10 = r0.next();
        int r11 = ((TextTagInfo) r10).type;
        if (r11 != TagEnum.TagEnum_InsertText_APPLET.value) goto L13;
    L16:
        boolean r12 = true;
    L17:
        if (r12 == false) goto L9;
        r9.add(r10);
        goto L9
    L13:
        if (r11 == TagEnum.TagEnum_InsertText_BLOCK.value) goto L16;
        r12 = false;
    L20:
        if (r36 != null) goto L22;
        List<TextTagInfo> r1 = CollectionsKt.emptyList();
    L23:
        ArrayList r13 = new ArrayList();
        Iterator r14 = r1.iterator();
        int r2 = 0;
        ?? r15 = r9;
    L25:
        if (r14.hasNext() == false) goto L306;
        Object r16 = r14.next();
        int r17 = r2 + 1;
        if (r2 >= 0) goto L29;
        CollectionsKt.throwIndexOverflow();
    L29:
        final TextTagInfo r18 = (TextTagInfo) r16;
        int r19 = r18.type;
        if (r19 != TagEnum.TagEnum_Replaceable.value) goto L45;
        Gson r3 = HttpExtKt.f;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L37
        String r8 = r18.tagInfo;     // Catch: Throwable -> L37
        if (r8 != null) goto L35;
        r8 = "{}";
    L35:
        Object r4 = Result.constructor-impl((IMMetaInfo.f) r3.fromJson(r8, IMMetaInfo.f.class));     // Catch: Throwable -> L37
    L40:
        if (Result.isFailure-impl(r4) == false) goto L42;
        Object r110 = null;
    L43:
        IMMetaInfo.d r111 = (IMMetaInfo.d) r110;
    L74:
        String r112 = r5;
        ?? r34 = r15;
        ArrayList r21 = r13;
        Iterator r113 = r14;
        int r114 = r17;
    L302:
        ArrayList r20 = r21;
        if (r111 == null) goto L305;
        r20.add(r111);
    L305:
        r13 = r20;
        r14 = r113;
        r2 = r114;
        r5 = r112;
        r15 = r34;
        goto L25
    L42:
        r110 = r4;
    L37:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L40
    L45:
        if (r19 != TagEnum.TagEnum_Insertable.value) goto L60;
        Gson r23 = HttpExtKt.f;
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L52
        String r25 = r18.tagInfo;     // Catch: Throwable -> L52
        if (r25 != null) goto L50;
        r25 = "{}";
    L50:
        Object r26 = Result.constructor-impl((IMMetaInfo.c) r23.fromJson(r25, IMMetaInfo.c.class));     // Catch: Throwable -> L52
    L55:
        if (Result.isFailure-impl(r26) == false) goto L57;
        Object r115 = null;
    L58:
        r111 = (IMMetaInfo.d) r115;
        goto L74
    L57:
        r115 = r26;
    L52:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r26 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L55
    L60:
        if (r19 != TagEnum.TagEnum_AT.value) goto L76;
        Gson r28 = HttpExtKt.f;
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L67
        String r30 = r18.tagInfo;     // Catch: Throwable -> L67
        if (r30 != null) goto L65;
        r30 = "{}";
    L65:
        Object r31 = Result.constructor-impl((IMMetaInfo.MentionInfoReference) r28.fromJson(r30, IMMetaInfo.MentionInfoReference.class));     // Catch: Throwable -> L67
    L70:
        if (Result.isFailure-impl(r31) == false) goto L72;
        Object r116 = null;
    L73:
        r111 = (IMMetaInfo.d) r116;
        goto L74
    L72:
        r116 = r31;
    L67:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        r31 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L70
    L76:
        if (r19 != TagEnum.TagEnum_InsertText.value) goto L78;
    L240:
        r112 = r5;
        ?? r310 = r15;
        r21 = r13;
        r113 = r14;
        r114 = r17;
        if (r38 == false) goto L289;
        if (r37 == null) goto L289;
        StringBuilder r33 = new StringBuilder();
        r33.append(r37.getMessageId());
        r33.append('_');
        r33.append(r39);
        r33.append('_');
        r33.append(r2);
        r33.append('_');
        String r41 = r18.tagInfo;
        if (r41 == null) goto L246;
        Integer r42 = Integer.valueOf(r41.length());
    L247:
        r33.append(r42);
        String r43 = r33.toString();
        wc8.b r44 = wc8.b.a;
        String r45 = r37.getMessageId();
        if (r45 != null) goto L250;
        r45 = "";
    L250:
        wc8.a r46 = r44.d(r45, r43);
        if (r46 != null) goto L288;
        Gson r47 = HttpExtKt.f;
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L258
        String r49 = r18.tagInfo;     // Catch: Throwable -> L258
        if (r49 != null) goto L256;
        r49 = "{}";
    L256:
        Object r50 = Result.constructor-impl((IMMetaInfo.InsertTextReference) r47.fromJson(r49, IMMetaInfo.InsertTextReference.class));     // Catch: Throwable -> L258
    L261:
        if (Result.isFailure-impl(r50) == false) goto L263;
        r50 = null;
    L263:
        IMMetaInfo.d r51 = (IMMetaInfo.InsertTextReference) r50;
        ?? r311 = r310;
        if (r51 != null) goto L266;
    L265:
        r111 = null;
        r34 = r311;
        goto L302
    L266:
        Regex r52 = a;
        String r53 = r51.getInsertText();
        if (r53 != null) goto L269;
        r53 = "";
    L269:
        MatchResult r54 = Regex.find$default(r52, r53, 0, 2, null);
        if (r54 == null) goto L287;
        MatchGroupCollection r55 = r54.getGroups();
        if (r55 == null) goto L287;
        MatchGroup r56 = r55.get(1);
        if (r56 == null) goto L287;
        String r57 = r56.getValue();
        if (r57 == null) goto L287;
        String r58 = r51.getInsertText();
        if (r58 == null) goto L287;
        String r59 = b.replace(r58, "value=\"\" value_id=\"" + r43 + '\"');
        if (r59 == null) goto L287;
        String r60 = HtmlCompat.fromHtml(r57, 0).toString();
        r51.setInsertText(r59);
        wc8.a r61 = new wc8.a(r60, r51, null);
        wc8.b r62 = wc8.b.a;
        String r63 = r37.getMessageId();
        if (r63 != null) goto L286;
        r63 = "";
    L286:
        r62.a(r63, r43, r61);
    L287:
        r111 = r51;
        r34 = r310;
    L258:
        th = move-exception;
        Result.Companion r64 = Result.Companion;
        r50 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L261
    L288:
        r111 = r46.b;
        r34 = r310;
        goto L302
    L246:
        r42 = null;
    L289:
        Gson r65 = HttpExtKt.f;
        Result.Companion r66 = Result.Companion;     // Catch: Throwable -> L295
        String r67 = r18.tagInfo;     // Catch: Throwable -> L295
        if (r67 != null) goto L293;
        r67 = "{}";
    L293:
        Object r68 = Result.constructor-impl((IMMetaInfo.InsertTextReference) r65.fromJson(r67, IMMetaInfo.InsertTextReference.class));     // Catch: Throwable -> L295
    L298:
        if (Result.isFailure-impl(r68) == false) goto L300;
        Object r117 = null;
    L301:
        r111 = (IMMetaInfo.InsertTextReference) r117;
        r34 = r310;
        goto L302
    L300:
        r117 = r68;
    L295:
        th = move-exception;
        Result.Companion r69 = Result.Companion;
        r68 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L298
    L78:
        if (r19 == TagEnum.TagEnum_InsertText_V2.value) goto L240;
        if (r19 == TagEnum.TagEnum_InsertText_Lynx.value) goto L240;
        TagEnum r70 = TagEnum.TagEnum_InsertText_APPLET;
        r113 = r14;
        r114 = r17;
        r112 = r5;
        if (r19 != r70.value) goto L175;
        if (r37 == null) goto L87;
        String r118 = r37.getMessageId();
        if (r118 == null) goto L87;
    L88:
        StringBuilder r119 = new StringBuilder();
        r119.append(r118);
        r119.append('_');
        r119.append(r39);
        r119.append('_');
        r119.append(r2);
        r119.append('_');
        String r71 = r18.tagInfo;
        if (r71 == null) goto L91;
        Integer r72 = Integer.valueOf(r71.length());
    L92:
        r119.append(r72);
        r119.append('_');
        r119.append(r70.value);
        r119.append('_');
        r119.append(r15.indexOf(r18));
        String r73 = r119.toString();
        wc8.b r74 = wc8.b.a;
        wc8.a r120 = r74.d(r118, r73);
        if (r120 != null) goto L161;
        IMMetaInfo.InsertTextReference r210 = wc8.b.f(r18.tagInfo, new e0(r18));
        if (r210 == null) goto L160;
        IMMetaInfo.d r75 = IMMetaInfo.InsertTextReference.copy$default(r210, null, null, null, null, null, null, null, null, null, 511, null);
        if (r75 == null) goto L160;
        if (CollectionsKt.contains(c, r75.getCardType()) == false) goto L160;
        String r121 = r75.getValue();
        if (r121 != null) goto L103;
    L106:
        boolean r122 = true;
    L107:
        if (r122 == true) goto L160;
        String r123 = r75.getStyle();
        if (r123 != null) goto L111;
    L114:
        boolean r124 = true;
    L115:
        if (r124 == true) goto L160;
        String r125 = r75.getCardType();
        if (r125 != null) goto L119;
    L122:
        boolean r126 = true;
    L123:
        if (r126 == false) goto L126;
        r311 = r15;
        r21 = r13;
        goto L265
    L126:
        if (Intrinsics.areEqual(r75.getCardType(), "creation") == false) goto L137;
        StringBuilder r127 = new StringBuilder();
        r127.append(r118);
        r127.append('_');
        r127.append(r39);
        r127.append('_');
        r21 = r13;
        r127.append(r75.getPos());
        r127.append('_');
        String r128 = r75.getValue();
        if (r128 == null) goto L130;
        Integer r129 = Integer.valueOf(r128.length());
    L131:
        r127.append(r129);
        r127.append('_');
        r127.append(r2);
        r127.append("_creation");
        String r76 = r127.toString();
        wc8.a r130 = r74.d(r118, r76);
        if (r130 != null) goto L134;
    L138:
        String r131 = r75.getExtra();
        if (r131 != null) goto L141;
        r131 = "";
    L141:
        String r132 = TextUtils.htmlEncode(r131);
        if (r132 != null) goto L144;
        r132 = "";
    L144:
        String r133 = r75.getAlt();
        if (r133 != null) goto L147;
        r133 = "";
    L147:
        String r134 = TextUtils.htmlEncode(r133);
        if (r134 != null) goto L150;
        r134 = "";
    L150:
        String r211 = "";
        if (Intrinsics.areEqual(r75.getCardType(), "search_reference") == false) goto L155;
        String r77 = r75.getValue();
        if (r77 != null) goto L159;
        r77 = r211;
    L159:
        r75.setInsertText("<data-" + r75.getStyle() + " type=\"" + r75.getCardType() + "\" value_id=\"" + r76 + "\" alt=\"" + r134 + "\" extra=\"" + r132 + "\"></data-" + r75.getStyle() + '>');
        r74.a(r118, r76, new wc8.a(r77, r75, null));
    L162:
        String r78 = r75.getCardType();
        if (r78 != null) goto L165;
        r78 = r211;
    L165:
        Integer r79 = (Integer) r6.get(r78);
        if (r79 == null) goto L168;
        int r80 = r79.intValue();
    L169:
        String r81 = r75.getCardType();
        if (r81 != null) goto L172;
        String r82 = r211;
    L173:
        r6.put(r82, Integer.valueOf(r80 + 1));
        r111 = r75;
    L174:
        r34 = r15;
        goto L302
    L172:
        r82 = r81;
        goto L173
    L168:
        r80 = 0;
        goto L169
    L155:
        String r83 = r75.getValue();
        if (r83 != null) goto L158;
        r83 = r211;
    L158:
        r77 = HtmlCompat.fromHtml(r83, 0).toString();
        goto L159
    L134:
        if (Intrinsics.areEqual(r130.b.getCanReplace(), r75.getCanReplace()) == true) goto L136;
        IMMetaInfo.InsertTextReference r84 = IMMetaInfo.InsertTextReference.copy$default(r130.b, null, null, r75.getCanReplace(), null, null, null, null, null, null, 507, null);
        Intrinsics.checkNotNullParameter(r84, "<set-?>");
        r130.b = r84;
    L136:
        r111 = r130.b;
        goto L174
    L130:
        r129 = null;
        goto L131
    L137:
        r21 = r13;
        r76 = r73;
        goto L138
    L119:
        if (r125.length() == 0) goto L122;
        r126 = false;
        goto L123
    L111:
        if (r123.length() == 0) goto L114;
        r124 = false;
        goto L115
    L103:
        if (r121.length() == 0) goto L106;
        r122 = false;
    L160:
        r21 = r13;
    L239:
        r311 = r15;
        goto L265
    L161:
        r211 = "";
        r21 = r13;
        r75 = r120.b;
        goto L162
    L91:
        r72 = null;
    L87:
        r118 = "";
        goto L88
    L175:
        r21 = r13;
        TagEnum r85 = TagEnum.TagEnum_InsertText_BLOCK;
        if (r19 != r85.value) goto L239;
        if (r37 == null) goto L180;
        String r86 = r37.getMessageId();
        if (r86 == null) goto L180;
    L181:
        StringBuilder r87 = new StringBuilder();
        r87.append(r86);
        r87.append('_');
        r87.append(r39);
        r87.append('_');
        r87.append(r2);
        r87.append('_');
        String r88 = r18.tagInfo;
        if (r88 == null) goto L184;
        Integer r89 = Integer.valueOf(r88.length());
    L185:
        r87.append(r89);
        r87.append('_');
        r87.append(r85.value);
        r87.append('_');
        r87.append(r15.indexOf(r18));
        r87.append('_');
        String r90 = r18.tagInfo;
        if (r90 == null) goto L188;
        Integer r91 = Integer.valueOf(r90.hashCode());
    L189:
        r87.append(r91);
        String r92 = r87.toString();
        wc8.b r93 = wc8.b.a;
        wc8.a r94 = r93.d(r86, r92);
        if (r94 != null) goto L226;
        RichMediaMeta r212 = wc8.b.e(r18.tagInfo, new ic8.f0(r18));
        if (r212 == null) goto L239;
        RichMediaMeta r95 = RichMediaMeta.copy$default(r212, null, null, null, null, 15, null);
        if (r95 == null) goto L239;
        String r135 = e1(r95.getSceneType());
        if (c.contains(r135) == false) goto L239;
        List r136 = r95.getMedia();
        if (r136 != null) goto L200;
    L203:
        boolean r137 = true;
    L204:
        if (r137 == true) goto L239;
        ContainerAttribute r138 = r95.getContainerAttribute();
        if (r138 == null) goto L208;
        String r139 = r138.getStyle();
    L209:
        if (r139 != null) goto L211;
    L214:
        boolean r140 = true;
    L215:
        if (r140 == true) goto L239;
        ContainerAttribute r141 = r95.getContainerAttribute();
        if (r141 == null) goto L220;
        String r142 = r141.getStyle();
    L221:
        Integer r213 = r95.getPos();
        String r214 = "<data-" + r142 + " type=\"" + r135 + "\" value_id=\"" + r92 + "\"></data-" + r142 + '>';
        ContainerAttribute r96 = r95.getContainerAttribute();
        if (r96 == null) goto L224;
        Boolean r215 = r96.getCanReplace();
    L225:
        String r97 = "";
        wc8.a r143 = new wc8.a(r97, new IMMetaInfo.InsertTextReference(r213, r214, r215, null, r135, r142, null, null, null, 456, null), r95);
        r93.a(r86, r92, r143);
        IMMetaInfo.d r99 = r143.b;
    L227:
        r111 = r99;
        String r100 = r111.getCardType();
        if (r100 != null) goto L230;
        r100 = r97;
    L230:
        Integer r101 = (Integer) r6.get(r100);
        if (r101 == null) goto L233;
        int r102 = r101.intValue();
    L234:
        String r103 = r111.getCardType();
        if (r103 != null) goto L237;
        String r104 = r97;
    L238:
        r6.put(r104, Integer.valueOf(r102 + 1));
        r34 = r15;
        goto L302
    L237:
        r104 = r103;
        goto L238
    L233:
        r102 = 0;
        goto L234
    L224:
        r215 = null;
        goto L225
    L220:
        r142 = null;
        goto L221
    L211:
        if (r139.length() == 0) goto L214;
        r140 = false;
        goto L215
    L208:
        r139 = null;
        goto L209
    L200:
        if (r136.isEmpty() == true) goto L203;
        r137 = false;
        goto L204
    L226:
        r97 = "";
        r99 = r94.b;
        goto L227
    L188:
        r91 = null;
        goto L189
    L184:
        r89 = null;
    L180:
        r86 = "";
        goto L181
    L306:
        String r144 = r5;
        List r105 = CollectionsKt.plus(r13, r40);
        ArrayList r106 = new ArrayList();
        Iterator r107 = r105.iterator();
    L308:
        if (r107.hasNext() == false) goto L355;
        IMMetaInfo.c r108 = (IMMetaInfo.d) r107.next();
        if ((r108 instanceof IMMetaInfo.c) == false) goto L320;
        List r109 = new ArrayList();
        IMMetaInfo.c r145 = r108;
        List r146 = r145.d();
        if (r146 == null) goto L354;
        Iterator r147 = r146.iterator();
    L315:
        if (r147.hasNext() == false) goto L317;
        int r148 = ((Number) r147.next()).intValue();
        IMMetaInfo.c r149 = IMMetaInfo.c.a(r145);
        r149.a = Integer.valueOf(r148);
        r109.add(r149);
        goto L315
    L317:
        Unit r150 = Unit.INSTANCE;
    L354:
        CollectionsKt.addAll(r106, r109);
        goto L308
    L320:
        if ((r108 instanceof IMMetaInfo.InsertTextReference) == false) goto L353;
        IMMetaInfo.InsertTextReference r216 = (IMMetaInfo.InsertTextReference) r108;
        Integer r151 = r216.getPos();
        if (r37 == null) goto L324;
        Integer r152 = Integer.valueOf(r37.getMessageStatusLocal());
    L326:
        if (r151 == null) goto L344;
        if (r151.intValue() != (-1)) goto L344;
        if (r152 == null) goto L344;
        if (r152.intValue() != 21) goto L344;
        int r153 = wf9.b.a;
        Intrinsics.checkNotNullParameter(r37, "message");
        if (com.larus.im.bean.message.a.w0(r37) == true) goto L344;
        IMMetaInfo.d[] r154 = new IMMetaInfo.d[1];
        int r155 = k.a;
        int r156 = r35.length();
        Intrinsics.checkNotNullParameter(r35, "str");
        if (r156 >= 0) goto L339;
    L342:
        r154[0] = IMMetaInfo.InsertTextReference.copy$default(r216, Integer.valueOf(r156), null, null, null, null, null, null, null, null, 510, null);
        r109 = CollectionsKt.mutableListOf(r154);
        goto L354
    L339:
        if (r156 > r35.length()) goto L342;
        r156 = StringsKt.encodeToByteArray(r35.substring(0, r156)).length;
    L344:
        if (Intrinsics.areEqual(r216.getCanReplace(), Boolean.TRUE) == false) goto L353;
        if (r152 == null) goto L353;
        if (r152.intValue() != 21) goto L353;
        int r157 = wf9.b.a;
        Intrinsics.checkNotNullParameter(r37, "message");
        if (com.larus.im.bean.message.a.w0(r37) == true) goto L353;
        r109 = CollectionsKt.emptyList();
        goto L354
    L324:
        r152 = null;
    L353:
        r109 = CollectionsKt.mutableListOf(new IMMetaInfo.d[]{r108});
        goto L354
    L355:
        Iterator r158 = vh8.a.c(CollectionsKt.sortedWith(r106, new IMMetaInfo.e())).iterator();
        String r159 = r35;
    L357:
        if (r158.hasNext() == false) goto L457;
        IMMetaInfo.f r160 = (IMMetaInfo.d) r158.next();
        if ((r160 instanceof IMMetaInfo.f) == false) goto L400;
        int r161 = vh8.a.a;
        byte[] r162 = StringsKt.encodeToByteArray(r35);
        byte[] r163 = StringsKt.encodeToByteArray(r159);
        IMMetaInfo.f r164 = r160;
        Intrinsics.checkNotNullParameter(r162, "source");
        String r165 = r144;
        Intrinsics.checkNotNullParameter(r163, r165);
        Intrinsics.checkNotNullParameter(r164, "replaceMeta");
        int r166 = r163.length;
        int r167 = r162.length;
        String r168 = r164.d();
        if (r168 == null) goto L399;
        byte[] r169 = StringsKt.encodeToByteArray(r168);
        if (r169 == null) goto L399;
        Integer r170 = r164.i();
        if (r170 == null) goto L399;
        int r171 = r170.intValue();
        Integer r172 = r164.b();
        if (r172 == null) goto L399;
        int r173 = r172.intValue();
        int r174 = r166 - (r167 - r171);
        int r175 = r166 - (r167 - r173);
        Result.Companion r176 = Result.Companion;     // Catch: Throwable -> L372
        Object r177 = Result.constructor-impl(ArraysKt.copyOfRange(r162, r171, r173));     // Catch: Throwable -> L372
    L375:
        if (Result.isFailure-impl(r177) == false) goto L377;
        r177 = null;
    L377:
        byte[] r178 = (byte[]) r177;
        if (r178 == null) goto L399;
        Object r179 = Result.constructor-impl(ArraysKt.copyOfRange(r163, r174, r175));     // Catch: Throwable -> L382
    L385:
        if (Result.isFailure-impl(r179) == false) goto L387;
        r179 = null;
    L387:
        byte[] r180 = (byte[]) r179;
        if (r180 != null) goto L390;
    L392:
        boolean r181 = false;
    L393:
        if (r181 == false) goto L399;
        if (r174 < 0) goto L399;
        if (r174 > r163.length) goto L399;
        if (r175 < r174) goto L399;
        r163 = ArraysKt.plus(ArraysKt.plus(ArraysKt.copyOfRange(r163, 0, r174), r169), ArraysKt.copyOfRange(r163, r175, r166));
        goto L399
    L390:
        if (Arrays.equals(r180, r178) != true) goto L392;
        r181 = true;
    L382:
        th = move-exception;
        Result.Companion r182 = Result.Companion;
        r179 = Result.constructor-impl(ResultKt.createFailure(th));
    L372:
        th = move-exception;
        Result.Companion r183 = Result.Companion;
        r177 = Result.constructor-impl(ResultKt.createFailure(th));
    L399:
        r159 = StringsKt.decodeToString(r163);
    L456:
        r144 = r165;
        goto L357
    L400:
        r165 = r144;
        if ((r160 instanceof IMMetaInfo.c) == false) goto L419;
        int r184 = vh8.a.a;
        byte[] r185 = StringsKt.encodeToByteArray(r35);
        byte[] r186 = StringsKt.encodeToByteArray(r159);
        IMMetaInfo.c r187 = (IMMetaInfo.c) r160;
        Intrinsics.checkNotNullParameter(r185, "source");
        Intrinsics.checkNotNullParameter(r186, r165);
        Intrinsics.checkNotNullParameter(r187, "insertMeta");
        Integer r188 = r187.a;
        if (r188 == null) goto L416;
        int r189 = r188.intValue();
        if (r189 < 0) goto L416;
        if (r189 > r186.length) goto L416;
        int r190 = r186.length;
        int r191 = r185.length;
        byte[] r192 = StringsKt.encodeToByteArray("[[" + r187.c() + "]](" + r187.f() + " \"[" + r187.c() + "]\")");
        if (r192 == null) goto L416;
        int r193 = r190 - (r191 - r189);
        if (r193 < 0) goto L416;
        if (r193 > r186.length) goto L416;
        r186 = ArraysKt.plus(ArraysKt.plus(ArraysKt.copyOfRange(r186, 0, r193), r192), ArraysKt.copyOfRange(r186, r193, r190));
    L416:
        r159 = StringsKt.decodeToString(r186);
        goto L456
    L419:
        if ((r160 instanceof IMMetaInfo.MentionInfoReference) == false) goto L454;
        int r194 = vh8.a.a;
        byte[] r195 = StringsKt.encodeToByteArray(r35);
        byte[] r196 = StringsKt.encodeToByteArray(r159);
        IMMetaInfo.MentionInfoReference r197 = (IMMetaInfo.MentionInfoReference) r160;
        Intrinsics.checkNotNullParameter(r195, "source");
        Intrinsics.checkNotNullParameter(r196, r165);
        Intrinsics.checkNotNullParameter(r197, "replaceMeta");
        int r198 = r196.length;
        int r199 = r195.length;
        int r200 = r197.getStartIndex();
        int r201 = r197.getEndIndex();
        byte[] r1100 = StringsKt.encodeToByteArray("[" + StringsKt.decodeToString(ArraysKt.copyOfRange(r195, r200, r201)) + "](mention://)");
        int r1101 = r198 - (r199 - r200);
        int r1102 = r198 - (r199 - r201);
        Result.Companion r202 = Result.Companion;     // Catch: Throwable -> L423
        Object r203 = Result.constructor-impl(ArraysKt.copyOfRange(r195, r200, r201));     // Catch: Throwable -> L423
    L426:
        if (Result.isFailure-impl(r203) == false) goto L428;
        r203 = null;
    L428:
        byte[] r204 = (byte[]) r203;
        if (r204 == null) goto L452;
        Object r205 = Result.constructor-impl(ArraysKt.copyOfRange(r196, r1101, r1102));     // Catch: Throwable -> L433
    L436:
        if (Result.isFailure-impl(r205) == false) goto L438;
        r205 = null;
    L438:
        byte[] r206 = (byte[]) r205;
        if (r206 == null) goto L444;
        if (Arrays.equals(r206, r204) != true) goto L444;
        boolean r207 = true;
    L445:
        if (r207 == false) goto L452;
        if (r1101 < 0) goto L452;
        if (r1101 > r196.length) goto L452;
        if (r1102 < r1101) goto L452;
        r196 = ArraysKt.plus(ArraysKt.plus(ArraysKt.copyOfRange(r196, 0, r1101), r1100), ArraysKt.copyOfRange(r196, r1102, r198));
    L444:
        r207 = false;
    L433:
        th = move-exception;
        Result.Companion r208 = Result.Companion;
        r205 = Result.constructor-impl(ResultKt.createFailure(th));
    L452:
        r159 = StringsKt.decodeToString(r196);
    L423:
        th = move-exception;
        Result.Companion r209 = Result.Companion;
        r203 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L426
    L454:
        if ((r160 instanceof IMMetaInfo.InsertTextReference) == false) goto L456;
        int r217 = vh8.a.a;
        r159 = StringsKt.decodeToString(vh8.a.a(StringsKt.encodeToByteArray(r35), StringsKt.encodeToByteArray(r159), (IMMetaInfo.InsertTextReference) r160, r37));
        goto L456
    L457:
        return r159;
    L22:
        r1 = r36;
        goto L23
    L19:
        r9 = CollectionsKt.emptyList();
        goto L20
    }
}
