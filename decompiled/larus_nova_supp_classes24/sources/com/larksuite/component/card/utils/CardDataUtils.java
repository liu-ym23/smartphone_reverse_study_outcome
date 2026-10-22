package com.larksuite.component.card.utils;

import android.app.Application;
import android.content.res.Resources;
import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.UniversalCardEntity;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.larksuite.component.card.debugger.ICardDebugger;
import com.larksuite.component.card.protocol.CardConfig;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.CardData;
import com.larksuite.component.card.protocol.context.ActionContext;
import com.larksuite.component.card.protocol.data.CardAttachment;
import com.larksuite.component.card.protocol.data.CardContent;
import com.larksuite.component.card.protocol.data.CardTranslateInfo;
import com.larksuite.component.card.protocol.data.ComponentStatus;
import com.larksuite.component.card.protocol.data.StreamingConfig;
import com.larksuite.component.card.protocol.data.action.ActionInfo;
import com.larksuite.component.card.protocol.data.action.ActionStatus;
import com.larksuite.component.card.protocol.data.at.AtProperty;
import com.larksuite.component.card.protocol.data.media.AudioInfo;
import com.larksuite.component.card.protocol.data.media.VideoInfo;
import com.larksuite.component.card.protocol.data.media.VisitInfo;
import com.larksuite.component.card.protocol.data.options.OptionUser;
import com.larksuite.component.card.protocol.data.person.Character;
import com.larksuite.component.card.settings.LynxMsgCardTimeFormatConfig;
import com.larksuite.framework.utils.CollectionUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.parser.internal.z;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.linked_emojicon.base.EmojiHandler;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.ByteString;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class CardDataUtils {
    public static final CardDataUtils a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[UniversalCardEntity.PrintStrategy.values().length];
            r0[UniversalCardEntity.PrintStrategy.DELAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    static {
        a = new CardDataUtils();
    }

    public CardDataUtils() {
    }

    public static JsonObject a(CardAttachment r8) {
        JsonObject r0 = new JsonObject();
        JsonObject r1 = new JsonObject();
        if (r8 == null) goto L10;
        HashMap<String, RichTextElement.ImageProperty> r2 = r8.getImages();
        if (r2 == null) goto L10;
        Iterator<Map.Entry<String, RichTextElement.ImageProperty>> r3 = r2.entrySet().iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        Map.Entry<String, RichTextElement.ImageProperty> r4 = r3.next();
        String r5 = r4.getKey();
        RichTextElement.ImageProperty r6 = r4.getValue();
        a.getClass();
        JsonObject r7 = new JsonObject();
        r7.addProperty("originWidth", Integer.valueOf(r6.getOriginWidth()));
        r7.addProperty("originHeight", Integer.valueOf(r6.getOriginHeight()));
        r7.addProperty("originKey", r6.getOriginKey());
        r1.add(r5, r7);
    L10:
        r0.add("images", r1);
        JsonObject r9 = new JsonObject();
        if (r8 == null) goto L18;
        HashMap<String, AtProperty> r10 = r8.getAtUsers();
        if (r10 == null) goto L18;
        Iterator<Map.Entry<String, AtProperty>> r11 = r10.entrySet().iterator();
    L16:
        if (r11.hasNext() == false) goto L18;
        Map.Entry<String, AtProperty> r12 = r11.next();
        r9.add(r12.getKey(), r12.getValue().toJson());
    L18:
        r0.add("atUsers", r9);
        JsonObject r13 = new JsonObject();
        if (r8 == null) goto L27;
        HashMap<String, OptionUser> r14 = r8.getOptionUsers();
        if (r14 == null) goto L27;
        Iterator<Map.Entry<String, OptionUser>> r15 = r14.entrySet().iterator();
    L24:
        if (r15.hasNext() == false) goto L27;
        Map.Entry<String, OptionUser> r16 = r15.next();
        r13.add(r16.getKey(), r16.getValue().toJson());
    L27:
        if (r8 == null) goto L76;
        HashMap<String, Character> r17 = r8.getCharacters();
        if (r17 == null) goto L76;
        Iterator<Map.Entry<String, Character>> r19 = r17.entrySet().iterator();
    L32:
        if (r19.hasNext() == false) goto L76;
        Map.Entry<String, Character> r20 = r19.next();
        String r21 = r20.getKey();
        Character r22 = r20.getValue();
        if (r22 == null) goto L36;
        JsonObject r23 = r22.toJson();     // Catch: JSONException -> L39
    L37:
        r13.add(r21, r23);     // Catch: JSONException -> L39
    L39:
        Log.e("CardDataUtils", "jsonAttachment put json error");
        goto L32
    L36:
        r23 = null;
    L76:
        r0.add("characters", r13);     // Catch: JSONException -> L42
    L43:
        JsonObject r24 = new JsonObject();
        if (r8 == null) goto L82;
        HashMap<String, AudioInfo> r25 = r8.getAudios();
        if (r25 == null) goto L82;
        Iterator<Map.Entry<String, AudioInfo>> r26 = r25.entrySet().iterator();
    L49:
        if (r26.hasNext() == false) goto L82;
        Map.Entry<String, AudioInfo> r27 = r26.next();
        String r29 = r27.getKey();
        r24.add(r29, r27.getValue().toJson());     // Catch: Throwable -> L53
    L53:
        Log.e("CardDataUtils", "jsonAttachment put audios error");
    L82:
        r0.add("audios", r24);     // Catch: Throwable -> L56
    L57:
        JsonObject r30 = new JsonObject();
        if (r8 == null) goto L72;
        HashMap<String, VideoInfo> r31 = r8.getVideos();
        if (r31 == null) goto L72;
        Iterator<Map.Entry<String, VideoInfo>> r32 = r31.entrySet().iterator();
    L63:
        if (r32.hasNext() == false) goto L72;
        Map.Entry<String, VideoInfo> r33 = r32.next();
        String r34 = r33.getKey();
        r30.add(r34, r33.getValue().toJson());     // Catch: Throwable -> L67
    L67:
        Log.e("CardDataUtils", "jsonAttachment put videos error");
    L72:
        r0.add("videos", r30);     // Catch: Throwable -> L70
    L71:
        return r0;
    L70:
        Log.e("CardDataUtils", "jsonAttachment put videos error");
    L56:
        Log.e("CardDataUtils", "jsonAttachment put audios error");
    L42:
        Log.e("CardDataUtils", "jsonAttachment put persons error");
        goto L43
    }

    public static CardData b(UniversalCardEntity r19) {
        Intrinsics.checkNotNullParameter(r19, "universalEntity");
        CardAttachment r0 = new CardAttachment();
        UniversalCardEntity.Attachment r2 = r19.content.attachment;
        Map r4 = null;
        if (r2 == null) goto L126;
        CardAttachment r5 = new CardAttachment();
        if (CollectionUtils.isNotEmpty(r2.at_users) == false) goto L32;
        HashMap<String, AtProperty> r8 = new HashMap(r2.at_users.size());
        Iterator r9 = r2.at_users.keySet().iterator();
    L8:
        if (r9.hasNext() == false) goto L30;
        String r1 = (String) r9.next();
        com.bytedance.lark.pb.basic.v1.RichTextElement.AtProperty r10 = (com.bytedance.lark.pb.basic.v1.RichTextElement.AtProperty) r2.at_users.get(r1);     // Catch: Exception -> L28
        AtProperty r11 = new AtProperty();     // Catch: Exception -> L28
        if (r10 == null) goto L13;
        String r12 = r10.user_id;     // Catch: Exception -> L28
    L14:
        r11.setUserId(r12);     // Catch: Exception -> L28
        if (r10 == null) goto L17;
        String r13 = r10.content;     // Catch: Exception -> L28
    L18:
        r11.setContent(r13);     // Catch: Exception -> L28
        if (r10 != null) goto L21;
        boolean r14 = false;
    L22:
        r11.setOutChatUser(r14);     // Catch: Exception -> L28
        if (r10 != null) goto L25;
        boolean r15 = false;
    L26:
        r11.setAnonymous(r15);     // Catch: Exception -> L28
        r8.put(r1, r11);     // Catch: Exception -> L28
        goto L8
    L25:
        r15 = r10.is_anonymous.booleanValue();     // Catch: Exception -> L28
        goto L26
    L21:
        r14 = r10.is_outer.booleanValue();     // Catch: Exception -> L28
        goto L22
    L17:
        r13 = null;
        goto L18
    L13:
        r12 = null;
    L28:
        e = move-exception;
        Log.e("CardDataUtils_[OPCard]", "transform AtProperty failed", e);
        goto L8
    L30:
        r5.setAtUsers(r8);
    L32:
        if (CollectionUtils.isNotEmpty(r2.images) == false) goto L43;
        HashMap<String, RichTextElement.ImageProperty> r16 = new HashMap(r2.images.size());
        Iterator r17 = r2.images.keySet().iterator();
    L35:
        if (r17.hasNext() == false) goto L41;
        String r3 = (String) r17.next();
        r16.put(r3, i((com.bytedance.lark.pb.basic.v1.RichTextElement.ImageProperty) r2.images.get(r3)));     // Catch: Exception -> L39
    L39:
        e = move-exception;
        Log.e("CardDataUtils_[OPCard]", "transform ImageProperty failed", e);
        goto L35
    L41:
        r5.setImages(r16);
    L43:
        if (CollectionUtils.isNotEmpty(r2.characters) == false) goto L51;
        HashMap<String, OptionUser> r6 = new HashMap(r2.characters.size());
        Iterator r7 = r2.characters.keySet().iterator();
    L46:
        if (r7.hasNext() == false) goto L50;
        String r20 = (String) r7.next();
        UniversalCardEntity.Character r21 = (UniversalCardEntity.Character) r2.characters.get(r20);
        if (r21 == null) goto L46;
        r6.put(r20, new OptionUser(r21.id, r21.content, r21.avatar_key));
        goto L46
    L50:
        r5.setOptionUsers(r6);
    L51:
        UniversalCardEntity.SummaryContent r22 = r2.summary;
        if (r22 == null) goto L93;
        List r23 = r22.items;
        if (r23 == null) goto L93;
        StringBuilder r24 = new StringBuilder();
        Iterator r25 = r23.iterator();
    L57:
        if (r25.hasNext() == false) goto L91;
        UniversalCardEntity.SummaryContent.Item r26 = (UniversalCardEntity.SummaryContent.Item) r25.next();
        if (r26 == null) goto L57;
        if (TextUtils.isEmpty(r26.text) == false) goto L62;
        if (r26.image != null) goto L65;
        if (r26.at_user != null) goto L68;
        UniversalCardEntity.SummaryContent.Item.Emotion r27 = r26.emotion;
        if (r27 == null) goto L74;
        if (TextUtils.isEmpty(r27.key) == true) goto L74;
        r24.append(EmojiHandler.e(r26.emotion.key));
    L74:
        UniversalCardEntity.SummaryContent.Item.CharacterList r29 = r26.person_list;
        if (r29 == null) goto L57;
        if (CollectionUtils.isNotEmpty(r29.characters) == false) goto L57;
        StringBuilder r30 = new StringBuilder();
        Iterator r31 = r26.person_list.characters.iterator();
    L80:
        if (r31.hasNext() == false) goto L90;
        UniversalCardEntity.Character r110 = (UniversalCardEntity.Character) r31.next();
        if (TextUtils.isEmpty(r110.content) == true) goto L80;
        if (r30.length() <= 0) goto L86;
        boolean r111 = true;
    L87:
        if (r111 == false) goto L89;
        r30.append(UIHelper.getString(2131892752));
    L89:
        r30.append(r110.content);
        goto L80
    L86:
        r111 = false;
        goto L87
    L90:
        r24.append(r30.toString());
        goto L57
    L68:
        r24.append("@");
        r24.append(r26.at_user.content);
        goto L57
    L65:
        r24.append(UIHelper.getString(2131891845));
        goto L57
    L62:
        r24.append(r26.text);
        goto L57
    L91:
        r5.setSummary(r24.toString());
    L93:
        if (CollectionUtils.isNotEmpty(r2.characters) == false) goto L103;
        r5.setCharacters(new HashMap());
        HashMap r32 = new HashMap(r2.characters.size());
        Iterator r33 = r2.characters.keySet().iterator();
    L96:
        if (r33.hasNext() == false) goto L100;
        String r34 = (String) r33.next();
        UniversalCardEntity.Character r35 = (UniversalCardEntity.Character) r2.characters.get(r34);
        if (r35 == null) goto L96;
        r32.put(r34, new Character(Integer.valueOf(r35.type.getValue()), r35.id, r35.content, r35.avatar_key));
        goto L96
    L100:
        HashMap<String, Character> r36 = r5.getCharacters();
        if (r36 == null) goto L103;
        r36.putAll(r32);
    L103:
        CardDataUtils$getCardAttachmentFromEntity$visitInfoConverter$1 r37 = CardDataUtils$getCardAttachmentFromEntity$visitInfoConverter$1.INSTANCE;
        if (CollectionUtils.isNotEmpty(r2.audios) == false) goto L115;
        r5.setAudios(new HashMap());
        HashMap r38 = new HashMap(r2.audios.size());
        Iterator r39 = r2.audios.keySet().iterator();
    L107:
        if (r39.hasNext() == false) goto L111;
        String r40 = (String) r39.next();
        UniversalCardEntity.AudioInfo r41 = (UniversalCardEntity.AudioInfo) r2.audios.get(r40);
        if (r41 == null) goto L107;
        r38.put(r40, new AudioInfo(r41.key, r41.duration.intValue(), r41.size.longValue(), (VisitInfo) r37.invoke(r41.visit_info)));
        goto L107
    L111:
        HashMap<String, AudioInfo> r42 = r5.getAudios();
        if (r42 == null) goto L115;
        r42.putAll(r38);
    L115:
        if (CollectionUtils.isNotEmpty(r2.videos) == false) goto L125;
        r5.setVideos(new HashMap());
        HashMap r43 = new HashMap(r2.videos.size());
        Iterator r44 = r2.videos.keySet().iterator();
    L118:
        if (r44.hasNext() == false) goto L122;
        String r45 = (String) r44.next();
        UniversalCardEntity.VideoInfo r46 = (UniversalCardEntity.VideoInfo) r2.videos.get(r45);
        if (r46 == null) goto L118;
        r43.put(r45, new VideoInfo(r46.key, r46.duration.intValue(), r46.size.longValue(), r46.url, r46.mime, (VisitInfo) r37.invoke(r46.visit_info)));
        goto L118
    L122:
        HashMap<String, VideoInfo> r47 = r5.getVideos();
        if (r47 == null) goto L125;
        r47.putAll(r43);
    L125:
        r0 = r5;
    L126:
        CardContent r48 = new CardContent(r19.content.card, r0);
        Boolean r49 = r19.streaming_mode;
        CardData.a.C0027a r50 = new CardData.a.C0027a();
        String r51 = r19.card_id;
        Intrinsics.checkNotNullParameter(r51, "cardID");
        r50.a = r51;
        r50.b = r19.card_id;
        String r52 = r19.version;
        r50.c = r52;
        r50.d = r52;
        r50.e = r48;
        r50.f = null;
        r50.h = null;
        r50.g = new ComponentStatus((String) r19.local_extra.get(Integer.valueOf(UniversalCardEntity.LocalExtraKey.OPEN_PLATFORM_MESSAGE_CARD.getValue())));
        Intrinsics.checkNotNull(r49);
        r50.j = r49.booleanValue();
        r50.k = k(r19);
        HashMap r53 = new HashMap();
        UniversalCardEntity.ActionStatus r54 = r19.action_status;
        if (r54 == null) goto L131;
        Map r55 = r54.component_status_by_action_id;
        if (r55 == null) goto L131;
        r53.putAll(r55);
    L131:
        UniversalCardEntity.ActionStatus r56 = r19.action_status;
        if (r56 == null) goto L134;
        r4 = r56.component_status_by_name;
    L134:
        ActionStatus r57 = new ActionStatus(r4, r53);
        UniversalCardEntity.Attachment r59 = r19.content.attachment;
        if (r59 == null) goto L139;
        Boolean r60 = r59.ignore_at_remind;
        if (r60 == null) goto L139;
        boolean r61 = true ^ r60.booleanValue();
    L140:
        r50.i = new ActionInfo(r57, r61, false, LarkContext.getApplication().getString(2131892336), r19.source_type.intValue(), r19.source_id);
        return r50.a();
    L139:
        r61 = true;
        goto L140
    }

    public static Image c(com.ss.android.lark.widget.richtext.Image r2) {
        Image r0 = new Image();
        if (r2 != null) goto L5;
        return r0;
    L5:
        r0.setHeight(r2.getHeight());
        r0.setWidth(r2.getWidth());
        r0.setKey(r2.getKey());
        r0.setToken(r2.getToken());
        r0.setCrypto(r2.getCrypto());
        r0.setFsUnit(r2.getFsUnit());
        r0.setResourceCleanScene(r2.getResourceCleanScene());
        r0.setResourceIsCleaned(r2.isResourceIsCleaned());
        com.ss.android.lark.widget.richtext.Image.Type r1 = r2.getType();
        if (r1 == null) goto L8;
        r0.setType(Image.Type.forNumber(r1.getNumber()));
    L8:
        r0.setUrls(r2.getUrls());
        return r0;
    }

    public static com.ss.android.lark.widget.richtext.Image e(RichTextElement.ImageProperty r7) {
        if (r7 != null) goto L5;
        return null;
    L5:
        com.ss.android.lark.widget.richtext.Image r1 = new com.ss.android.lark.widget.richtext.Image();
        r1.setHeight(r7.getOriginHeight());
        r1.setWidth(r7.getOriginWidth());
        r1.setFsUnit(r7.getFsUnit());
        r1.setResourceCleanScene(r7.getResourceCleanScene());
        if (r7.getResourceCleanScene() == null) goto L8;
        boolean r2 = true;
    L9:
        r1.setResourceIsCleaned(r2);
        if (TextUtils.isEmpty(r7.getOriginKey()) == false) goto L12;
        r1.setUrls(r7.getUrls());
        r1.setToken(r7.getToken());
        r1.setType(com.ss.android.lark.widget.richtext.Image.Type.NORMAL);
    L33:
        return r1;
    L12:
        String r3 = r7.getToken();
        if (TextUtils.isEmpty(r3) == true) goto L32;
        r1.setToken(r3);
        a.getClass();
        String r4 = g(r7, 0);
        r1.setKey(r4);
        r1.setType(com.ss.android.lark.widget.richtext.Image.Type.ENCRYPTED);
        r1.setCrypto(r7.getCrypto());
        if (r4 != null) goto L17;
    L19:
        if (r4 != null) goto L21;
    L23:
        if (r4 != null) goto L25;
    L27:
        List r8 = r7.getUrls();
        ArrayList r0 = new ArrayList();
        Iterator r9 = r8.iterator();
    L29:
        if (r9.hasNext() == false) goto L31;
        r0.add(((String) r9.next()) + r4);
        goto L29
    L31:
        r1.setUrls(r0);
        goto L33
    L25:
        if (StringsKt.startsWith$default(r4, "thumb:", false, 2, null) == false) goto L27;
        r4 = r4.substring(6);
        goto L27
    L21:
        if (StringsKt.startsWith$default(r4, "middle:", false, 2, null) == false) goto L23;
        r4 = r4.substring(7);
        goto L27
    L17:
        if (StringsKt.startsWith$default(r4, "origin:", false, 2, null) == false) goto L19;
        r4 = r4.substring(7);
        goto L27
    L32:
        r1.setKey(r7.getOriginKey());
        r1.setType(com.ss.android.lark.widget.richtext.Image.Type.NORMAL);
        r1.setUrls(r7.getUrls());
        goto L33
    L8:
        r2 = false;
        goto L9
    }

    public static List h(List r2) {
        ArrayList r0 = new ArrayList();
        if (r2 != null) goto L5;
        return r0;
    L5:
        Iterator r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L12;
        com.ss.android.lark.widget.richtext.Image r1 = (com.ss.android.lark.widget.richtext.Image) r3.next();
        if (r1 == null) goto L7;
        r0.add(c(r1));
        goto L7
    L12:
        return r0;
    }

    public static RichTextElement.ImageProperty i(com.bytedance.lark.pb.basic.v1.RichTextElement.ImageProperty r5) throws Exception {
        RichTextElement.ImageProperty r0 = new RichTextElement.ImageProperty();
        if (r5 != null) goto L5;
        List r1 = new ArrayList();
    L6:
        r0.setUrls(r1);
        String r2 = "";
        if (r5 != null) goto L9;
        String r3 = "";
    L10:
        r0.setToken(r3);
        if (r5 == null) goto L17;
        com.bytedance.lark.pb.basic.v1.Image r4 = r5.intact;
        if (r4 == null) goto L17;
        if (r4.exif_orientation.intValue() <= 0) goto L17;
        r0.setIntactKey(r4.key);
    L17:
        if (r5 != null) goto L19;
        String r6 = "";
    L20:
        r0.setOriginKey(r6);
        boolean r7 = false;
        if (r5 != null) goto L23;
        int r8 = 0;
    L24:
        r0.setOriginWidth(r8);
        if (r5 != null) goto L27;
        int r9 = 0;
    L28:
        r0.setOriginHeight(r9);
        if (r5 != null) goto L31;
        int r10 = 0;
    L32:
        r0.setCustomWidth(r10);
        if (r5 == null) goto L36;
        r7 = r5.need_copy.booleanValue();
    L36:
        r0.setNeedCopy(r7);
        ResourceCleanScene r11 = null;
        if (r5 != null) goto L39;
        com.ss.android.lark.widget.richtext.Image r12 = null;
    L40:
        r0.setMiddleImage(r12);
        if (r5 != null) goto L43;
        com.ss.android.lark.widget.richtext.Image r13 = null;
    L44:
        r0.setThumbImage(r13);
        if (r5 == null) goto L49;
        com.bytedance.lark.pb.basic.v1.Image r14 = r5.origin;
        if (r14 == null) goto L49;
        r0.setFsUnit(r14.fs_unit);
        r0.setCrypto(r14.crypto);
    L79:
        if (r5 == null) goto L90;
        com.bytedance.lark.pb.basic.v1.Image r15 = r5.middle_webp;
        if (r15 != null) goto L84;
    L89:
        r2 = r5.middle_key;
        goto L90
    L84:
        if (TextUtils.isEmpty(r15.key) == true) goto L89;
        com.bytedance.lark.pb.basic.v1.Image r16 = r5.middle_webp;
        if (r16 == null) goto L88;
        r2 = r16.key;
        goto L90
    L88:
        r2 = null;
    L90:
        r0.setMiddleKey(r2);
        r0.setThumbKey(z.u(r5));
        if (r5 == null) goto L93;
        String r17 = r5.alt;
    L94:
        r0.setAlt(r17);
        if (r5 == null) goto L97;
        String r19 = r5.alt_i18n_key;
    L98:
        r0.setAltI18nKey(r19);
        if (r5 == null) goto L103;
        Boolean r20 = r5.img_can_preview;
        if (r20 == null) goto L103;
        r20.booleanValue();
        r0.setImgCanPreview(r5.img_can_preview.booleanValue());
    L103:
        if (r5 == null) goto L107;
        Boolean r21 = r5.is_origin_source;
        if (r21 == null) goto L107;
        r21.booleanValue();
        r0.setOriginSource(r5.is_origin_source.booleanValue());
    L107:
        if (r5 == null) goto L111;
        Long r22 = r5.origin_size;
        if (r22 == null) goto L111;
        r22.longValue();
        r0.setOriginSize(r5.origin_size.longValue());
    L111:
        if (r5 == null) goto L115;
        Integer r23 = r5.show_mode;
        if (r23 == null) goto L115;
        r23.intValue();
        r0.setShowMode(r5.show_mode.intValue());
    L115:
        if (r5 == null) goto L117;
        ByteString r24 = r5.inline_preview;
    L118:
        if (r24 != null) goto L120;
    L122:
        if (r5 == null) goto L126;
        com.bytedance.lark.pb.basic.v1.ResourceCleanScene r25 = r5.clean_resource_scene;
        if (r25 == null) goto L126;
        ResourceCleanScene.Companion.getClass();
        r11 = ResourceCleanScene.a.a(r25);
    L126:
        r0.setResourceCleanScene(r11);
        return r0;
    L120:
        if (r5.inline_preview.size() <= 0) goto L122;
        r0.setInlinePreview(r5.inline_preview);
        goto L122
    L117:
        r24 = null;
        goto L118
    L97:
        r19 = null;
        goto L98
    L93:
        r17 = null;
    L49:
        if (r5 == null) goto L51;
        com.bytedance.lark.pb.basic.v1.Image r26 = r5.middle_webp;
    L52:
        if (r26 == null) goto L62;
        com.bytedance.lark.pb.basic.v1.Image r27 = r5.middle_webp;
        if (r27 == null) goto L56;
        String r29 = r27.fs_unit;
    L57:
        r0.setFsUnit(r29);
        com.bytedance.lark.pb.basic.v1.Image r30 = r5.middle_webp;
        if (r30 == null) goto L60;
        ByteString r31 = r30.crypto;
    L61:
        r0.setCrypto(r31);
        goto L79
    L60:
        r31 = null;
        goto L61
    L56:
        r29 = null;
        goto L57
    L62:
        if (r5 == null) goto L64;
        com.bytedance.lark.pb.basic.v1.Image r32 = r5.thumbnail_webp;
    L65:
        if (r32 == null) goto L75;
        com.bytedance.lark.pb.basic.v1.Image r33 = r5.thumbnail_webp;
        if (r33 == null) goto L69;
        String r34 = r33.fs_unit;
    L70:
        r0.setFsUnit(r34);
        com.bytedance.lark.pb.basic.v1.Image r35 = r5.thumbnail_webp;
        if (r35 == null) goto L73;
        ByteString r36 = r35.crypto;
    L74:
        r0.setCrypto(r36);
        goto L79
    L73:
        r36 = null;
        goto L74
    L69:
        r34 = null;
        goto L70
    L75:
        if (r5 == null) goto L77;
        String r37 = r5.fs_unit;
    L78:
        r0.setFsUnit(r37);
        goto L79
    L77:
        r37 = null;
        goto L78
    L64:
        r32 = null;
        goto L65
    L51:
        r26 = null;
        goto L52
    L43:
        r13 = f(r5.thumbnail_webp, r5.clean_resource_scene);
        goto L44
    L39:
        r12 = f(r5.middle_webp, r5.clean_resource_scene);
        goto L40
    L31:
        r10 = r5.custom_width.intValue();
        goto L32
    L27:
        r9 = r5.origin_height.intValue();
        goto L28
    L23:
        r8 = r5.origin_width.intValue();
        goto L24
    L19:
        r6 = r5.origin_key;
        goto L20
    L9:
        r3 = r5.token;
        goto L10
    L5:
        r1 = r5.urls;
        goto L6
    }

    public static StreamingConfig k(UniversalCardEntity r4) {
        Intrinsics.checkNotNullParameter(r4, "cardEntity");
        UniversalCardEntity.StreamingConfig r5 = r4.streaming_config;
        if (r5 == null) goto L24;
        UniversalCardEntity.PrintStrategy r0 = r5.print_strategy;
        if (r0 != null) goto L7;
        int r1 = -1;
    L9:
        if (r1 != 1) goto L11;
        StreamingConfig.PrintStrategy r2 = StreamingConfig.PrintStrategy.DELAY;
    L12:
        CardDataUtils$getStreamingConfigFromEntity$1$parser$1 r3 = CardDataUtils$getStreamingConfigFromEntity$1$parser$1.INSTANCE;
        UniversalCardEntity.StreamingConfig.PrintConfig r6 = r5.print_frequency_ms;
        int r7 = 0;
        if (r6 == null) goto L17;
        Integer r8 = (Integer) r3.invoke(r6);
        if (r8 == null) goto L17;
        int r9 = r8.intValue();
    L18:
        UniversalCardEntity.StreamingConfig.PrintConfig r10 = r5.print_step;
        if (r10 == null) goto L26;
        Integer r11 = (Integer) r3.invoke(r10);
        if (r11 == null) goto L26;
        r7 = r11.intValue();
    L26:
        return new StreamingConfig(r2, r9, r7);
    L17:
        r9 = 0;
        goto L18
    L11:
        r2 = StreamingConfig.PrintStrategy.FAST;
        goto L12
    L7:
        r1 = a.a[r0.ordinal()];
        goto L9
    L24:
        return null;
    }

    public static com.ss.android.lark.widget.richtext.Image d(RichTextElement.ImageProperty r6, int r7) {
        if (r6 != null) goto L5;
        return null;
    L5:
        com.ss.android.lark.widget.richtext.Image r1 = new com.ss.android.lark.widget.richtext.Image();
        r1.setHeight(r6.getOriginHeight());
        r1.setWidth(r6.getOriginWidth());
        if (r6.getResourceCleanScene() == null) goto L8;
        boolean r2 = true;
    L9:
        r1.setResourceIsCleaned(r2);
        r1.setResourceCleanScene(r6.getResourceCleanScene());
        if (TextUtils.isEmpty(r6.getToken()) == false) goto L18;
        String r8 = g(r6, r7);
        r1.setKey(r8);
        List r9 = r6.getUrls();
        ArrayList r0 = new ArrayList();
        if (CollectionUtils.isEmpty(r9) == true) goto L17;
        Iterator r10 = r9.iterator();
    L15:
        if (r10.hasNext() == false) goto L17;
        r0.add(((String) r10.next()) + r8);
    L17:
        r1.setUrls(r0);
        r1.setType(com.ss.android.lark.widget.richtext.Image.Type.NORMAL);
    L36:
        return r1;
    L18:
        r1.setToken(r6.getToken());
        String r11 = g(r6, r7);
        r1.setKey(r11);
        r1.setType(com.ss.android.lark.widget.richtext.Image.Type.ENCRYPTED);
        if (r11 != null) goto L21;
    L23:
        if (r11 != null) goto L25;
    L27:
        if (r11 != null) goto L29;
    L31:
        List r12 = r6.getUrls();
        ArrayList r3 = new ArrayList();
        Iterator r13 = r12.iterator();
    L33:
        if (r13.hasNext() == false) goto L35;
        r3.add(((String) r13.next()) + r11);
        goto L33
    L35:
        r1.setUrls(r3);
        goto L36
    L29:
        if (StringsKt.startsWith$default(r11, "thumb:", false, 2, null) == false) goto L31;
        r11 = r11.substring(6);
        goto L31
    L25:
        if (StringsKt.startsWith$default(r11, "middle:", false, 2, null) == false) goto L27;
        r11 = r11.substring(7);
        goto L31
    L21:
        if (StringsKt.startsWith$default(r11, "origin:", false, 2, null) == false) goto L23;
        r11 = r11.substring(7);
        goto L31
    L8:
        r2 = false;
        goto L9
    }

    public static com.ss.android.lark.widget.richtext.Image f(com.bytedance.lark.pb.basic.v1.Image r2, com.bytedance.lark.pb.basic.v1.ResourceCleanScene r3) {
        if (r2 != null) goto L5;
        return null;
    L5:
        com.ss.android.lark.widget.richtext.Image r0 = new com.ss.android.lark.widget.richtext.Image();
        r0.setKey(r2.key);
        r0.setWidth(r2.width.intValue());
        r0.setHeight(r2.height.intValue());
        r0.setUrls(r2.urls);
        r0.setCrypto(r2.crypto);
        r0.setFsUnit(r2.fs_unit);
        ResourceCleanScene.Companion.getClass();
        r0.setResourceCleanScene(ResourceCleanScene.a.a(r3));
        if (r3 == null) goto L8;
        boolean r4 = true;
    L9:
        r0.setResourceIsCleaned(r4);
        return r0;
    L8:
        r4 = false;
        goto L9
    }

    public static String g(RichTextElement.ImageProperty r2, int r3) {
        ArrayList r0 = new ArrayList();
        if (r3 != 0) goto L5;
        r0.add(new com.ss.android.lark.image.entity.f(r2.getOriginKey()));
    L9:
        String r4 = ((com.ss.android.lark.image.entity.b) ListProtector.get(r0, 0)).a();
        if (TextUtils.isEmpty(r4) == true) goto L12;
        return r4;
    L12:
        return r2.getOriginKey();
    L5:
        if (r3 == 1) goto L7;
        r0.add(new com.ss.android.lark.image.entity.g(r2.getThumbKey()));
        r0.add(new com.ss.android.lark.image.entity.e(r2.getMiddleKey()));
        r0.add(new com.ss.android.lark.image.entity.f(r2.getOriginKey()));
        goto L9
    L7:
        r0.add(new com.ss.android.lark.image.entity.e(r2.getMiddleKey()));
        r0.add(new com.ss.android.lark.image.entity.f(r2.getOriginKey()));
        goto L9
    }

    public static JsonObject j(CardConfig r16, CardContext r17, CardData r19, boolean r110) {
        Intrinsics.checkNotNullParameter(r16, "cardConfig");
        Intrinsics.checkNotNullParameter(r17, "cardContext");
        Intrinsics.checkNotNullParameter(r19, "cardData");
        JsonObject r7 = new JsonObject();
        JsonObject r8 = new JsonObject();     // Catch: JSONException -> L22
        r8.addProperty("cardID", r19.getCardID());     // Catch: JSONException -> L22
        String r9 = r19.getUniversalCardVersion();     // Catch: JSONException -> L22
        boolean r10 = false;
        JsonObject r12 = null;
        if (r9 != null) goto L6;
    L13:
        r9 = r19.getVersion();     // Catch: JSONException -> L22
    L14:
        r8.addProperty("version", r9);     // Catch: JSONException -> L22
        ComponentStatus r11 = r19.getComponentStatus();     // Catch: JSONException -> L22
        if (r11 == null) goto L19;
        String r13 = r11.getCardComponentLocalCache();     // Catch: JSONException -> L22
        if (r13 == null) goto L19;
        r8.addProperty("localStatus", r13);     // Catch: JSONException -> L22
    L19:
        JsonObject r14 = new JsonObject();     // Catch: JSONException -> L22
        r14.add("attachment", a(r19.getCardContent().getAttachment()));     // Catch: JSONException -> L22
        r14.addProperty("card", r19.getCardContent().getCardJSON());     // Catch: JSONException -> L22
        r8.add("cardContent", r14);     // Catch: JSONException -> L22
        CardContent r15 = r19.getTranslateContent();     // Catch: JSONException -> L22
        if (r15 == null) goto L24;
        JsonObject r111 = new JsonObject();     // Catch: JSONException -> L22
        CardDataUtils r112 = a;     // Catch: JSONException -> L22
        CardAttachment r113 = r15.getAttachment();     // Catch: JSONException -> L22
        r112.getClass();     // Catch: JSONException -> L22
        r111.add("attachment", a(r113));     // Catch: JSONException -> L22
        r111.addProperty("card", r15.getCardJSON());     // Catch: JSONException -> L22
        r8.add("translateContent", r111);     // Catch: JSONException -> L22
    L24:
        JsonObject r0 = new JsonObject();     // Catch: JSONException -> L22
        JsonObject r2 = new JsonObject();     // Catch: JSONException -> L22
        ActionInfo r20 = r19.getActionInfo();     // Catch: JSONException -> L22
        if (r20 == null) goto L36;
        ActionStatus r21 = r20.getActionStatus();     // Catch: JSONException -> L22
        if (r21 == null) goto L36;
        Map<String, String> r22 = r21.getComponentStatusByName();     // Catch: JSONException -> L22
        if (r22 == null) goto L36;
        Set<Map.Entry<String, String>> r23 = r22.entrySet();     // Catch: JSONException -> L22
        if (r23 == null) goto L36;
        Iterator<Map.Entry<String, String>> r24 = r23.iterator();     // Catch: JSONException -> L22
    L34:
        if (r24.hasNext() == false) goto L36;
        Map.Entry<String, String> r114 = r24.next();     // Catch: JSONException -> L22
        r2.addProperty(r114.getKey(), r114.getValue());     // Catch: JSONException -> L22
    L36:
        r0.add("componentStatusByName", r2);     // Catch: JSONException -> L22
        JsonObject r3 = new JsonObject();     // Catch: JSONException -> L22
        ActionInfo r25 = r19.getActionInfo();     // Catch: JSONException -> L22
        if (r25 == null) goto L48;
        ActionStatus r26 = r25.getActionStatus();     // Catch: JSONException -> L22
        if (r26 == null) goto L48;
        HashMap<String, String> r27 = r26.getComponentStatusByActionID();     // Catch: JSONException -> L22
        if (r27 == null) goto L48;
        Set<Map.Entry<String, String>> r29 = r27.entrySet();     // Catch: JSONException -> L22
        if (r29 == null) goto L48;
        Iterator<Map.Entry<String, String>> r30 = r29.iterator();     // Catch: JSONException -> L22
    L46:
        if (r30.hasNext() == false) goto L48;
        Map.Entry<String, String> r115 = r30.next();     // Catch: JSONException -> L22
        r3.addProperty(r115.getKey(), r115.getValue());     // Catch: JSONException -> L22
    L48:
        r0.add("componentStatusByActionID", r3);     // Catch: JSONException -> L22
        r8.add("actionStatus", r0);     // Catch: JSONException -> L22
        r7.add("cardData", r8);     // Catch: JSONException -> L22
        JsonObject r4 = new JsonObject();     // Catch: JSONException -> L22
        ActionInfo r1 = r19.getActionInfo();     // Catch: JSONException -> L22
        if (r1 == null) goto L51;
        r4.addProperty("actionEnable", Boolean.valueOf(r1.getActionEnable()));     // Catch: JSONException -> L22
        r4.addProperty("actionForceDisable", Boolean.valueOf(r1.getActionForceDisable()));     // Catch: JSONException -> L22
        r4.addProperty("actionDisableMessage", r1.getActionDisableMessage());     // Catch: JSONException -> L22
    L51:
        JsonObject r5 = new JsonObject();     // Catch: JSONException -> L22
        r5.addProperty("isWideMode", Boolean.valueOf(r17.getCardStyle().isWideMode()));     // Catch: JSONException -> L22
        r5.addProperty("showTranslateMargin", Boolean.valueOf(r17.getCardStyle().getShowTranslateMargin()));     // Catch: JSONException -> L22
        CardContent r31 = r19.getTranslateContent();     // Catch: JSONException -> L22
        if (r31 == null) goto L54;
        String r32 = r31.getCardJSON();     // Catch: JSONException -> L22
    L56:
        if (TextUtils.isEmpty(r32) == true) goto L58;
        r10 = true;
    L58:
        r5.addProperty("showCardBGColor", Boolean.valueOf(r10));     // Catch: JSONException -> L22
        r5.addProperty("showCardBorderRadius", Boolean.FALSE);     // Catch: JSONException -> L22
        r5.addProperty("headerNoPaddingTop", Boolean.valueOf(r17.getCardStyle().getHeaderNoPaddingTop()));     // Catch: JSONException -> L22
        Integer r6 = r17.getCardStyle().getBodyMinHeight();     // Catch: JSONException -> L22
        if (r6 == null) goto L62;
        r5.addProperty("bodyMinHeight", Integer.valueOf(r6.intValue()));     // Catch: JSONException -> L22
    L62:
        if (r16.getMaxWidth() == null) goto L64;
        Application r33 = LarkContext.getApplication();     // Catch: JSONException -> L22
        float r34 = r16.getMaxWidth().intValue();     // Catch: JSONException -> L22
        Resources r35 = r33.getResources();     // Catch: JSONException -> L22
        int r36 = (int) ((r34 / WindowDisplayMetricsOverride.apply(r35, r35.getDisplayMetrics()).density) + 0.5f);     // Catch: JSONException -> L22
    L65:
        r5.addProperty("preferWidth", Integer.valueOf(r36));     // Catch: JSONException -> L22
        r4.add("displayConfig", r5);     // Catch: JSONException -> L22
        JsonObject r37 = new JsonObject();     // Catch: JSONException -> L22
        JsonObject r38 = new JsonObject();     // Catch: JSONException -> L22
        int r39 = ez7.c.d;     // Catch: JSONException -> L22
        LynxMsgCardTimeFormatConfig r40 = r16.getSettings().a;     // Catch: JSONException -> L22
        String r116 = j.c();     // Catch: JSONException -> L22
        if (r40 != null) goto L110;
    L76:
        JsonObject r41 = new JsonObject();     // Catch: JSONException -> L22
    L77:
        r38.add("localeLanguageFormat", r41);     // Catch: JSONException -> L22
        CardTranslateInfo r42 = r19.getTranslateInfo();     // Catch: JSONException -> L22
        if (r42 == null) goto L93;
        r37.addProperty("translateLanguage", r42.getTranslateLanguage());     // Catch: JSONException -> L22
        r37.addProperty("renderType", r42.getTranslateShowType());     // Catch: JSONException -> L22
        int r117 = ez7.c.d;     // Catch: JSONException -> L22
        String r43 = r42.getTranslateLanguage();     // Catch: JSONException -> L22
        LynxMsgCardTimeFormatConfig r44 = r16.getSettings().a;     // Catch: JSONException -> L22
        Intrinsics.checkNotNullParameter(r43, "translateLanguage");     // Catch: JSONException -> L22
        if (TextUtils.isEmpty(r43) == true) goto L91;
        if (r44 == null) goto L91;
        JSONObject r45 = r44.translateFormat;     // Catch: JSONException -> L89
        if (r45 == null) goto L91;
        JSONObject r46 = r45.optJSONObject(r43);     // Catch: JSONException -> L89
        if (r46 == null) goto L91;
        JsonElement r47 = JsonParser.parseString(r46.toString());     // Catch: JSONException -> L89
    L92:
        r38.add("translateLanguageFormat", r47);     // Catch: JSONException -> L22
    L94:
        r37.add("timeFormatSetting", r38);     // Catch: JSONException -> L22
        r4.add("translateConfig", r37);     // Catch: JSONException -> L22
        r4.addProperty("isStreaming", Boolean.valueOf(r19.isStreamingMode()));     // Catch: JSONException -> L22
        StreamingConfig r48 = r19.getStreamingConfig();     // Catch: JSONException -> L22
        if (r48 == null) goto L97;
        JsonObject r49 = new JsonObject();     // Catch: JSONException -> L22
        r49.addProperty("printStrategy", r48.getPrintStrategy().getValue());     // Catch: JSONException -> L22
        r49.addProperty("printFrequencyMs", Integer.valueOf(r48.getPrintFrequencyMs()));     // Catch: JSONException -> L22
        r49.addProperty("printStep", Integer.valueOf(r48.getPrintStep()));     // Catch: JSONException -> L22
        r4.add("streamingConfig", r49);     // Catch: JSONException -> L22
    L97:
        r7.add("config", r4);     // Catch: JSONException -> L22
        JsonObject r50 = new JsonObject();     // Catch: JSONException -> L22
        r50.addProperty("key", r19.getCardID());     // Catch: JSONException -> L22
        r50.addProperty("traceID", r17.getRenderTrace().getTracingID());     // Catch: JSONException -> L22
        r50.add("bizContext", r17.getBizContext().toJson());     // Catch: JSONException -> L22
        r50.addProperty("businessType", r17.getMonitorData().getBusinessType());     // Catch: JSONException -> L22
        ActionContext r51 = r17.getActionContext();     // Catch: JSONException -> L22
        if (r51 == null) goto L100;
        r12 = r51.toJson();     // Catch: JSONException -> L22
    L100:
        r50.add("actionContext", r12);     // Catch: JSONException -> L22
        if (k.b(r17.getDeliveryType()) == false) goto L103;
        r50.addProperty("deliveryType", r17.getDeliveryType());     // Catch: JSONException -> L22
    L103:
        r50.addProperty("host", r17.getHost());     // Catch: JSONException -> L22
        r7.add("context", r50);     // Catch: JSONException -> L22
        if (r110 == false) goto L106;
        r7.addProperty("__lynx_timing_flag", "__lynx_timing_actual_fmp_" + r17.getRenderTrace().getTracingID());     // Catch: JSONException -> L22
    L106:
        r7.addProperty("isUniversalCard", 1);     // Catch: JSONException -> L22
        ICardDebugger.a.getClass();     // Catch: JSONException -> L22
        ((ICardDebugger) ICardDebugger.Companion.b.getValue()).getEnable();     // Catch: JSONException -> L22
    L109:
        return r7;
    L89:
        e = move-exception;
        Log.e("SettingsInfo", "get translateLanguageFormat is exception", e);     // Catch: JSONException -> L22
    L91:
        r47 = new JsonObject();     // Catch: JSONException -> L22
        goto L92
    L93:
        r37.addProperty("renderType", CardTranslateInfo.RENDER_TYPE_ORIGIN);     // Catch: JSONException -> L22
        goto L94
    L110:
        JSONObject r52 = r40.localeLanguageFormat;     // Catch: JSONException -> L74
        if (r52 == null) goto L76;
        JSONObject r53 = r52.optJSONObject(r116);     // Catch: JSONException -> L74
        if (r53 == null) goto L76;
        r41 = JsonParser.parseString(r53.toString());     // Catch: JSONException -> L74
    L74:
        e = move-exception;
        Log.e("SettingsInfo", "get localeLanguageFormat is exception", e);     // Catch: JSONException -> L22
        goto L76
    L64:
        r36 = 300;
        goto L65
    L54:
        r32 = null;
        goto L56
    L6:
        if (r9.length() <= 0) goto L8;
        boolean r118 = true;
    L9:
        if (r118 == true) goto L12;
        r9 = null;
    L12:
        if (r9 != null) goto L14;
    L8:
        r118 = false;
    L22:
        e = move-exception;
        Log.e("CardDataUtils", "card data get init data json exception", e);
        goto L109
    }
}
