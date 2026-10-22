package com.ss.android.lark.message.card.parser;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.CardAppInfo;
import com.bytedance.lark.pb.basic.v1.CardContent;
import com.bytedance.lark.pb.basic.v1.CardVisitInfo;
import com.bytedance.lark.pb.basic.v1.Content;
import com.bytedance.lark.pb.basic.v1.RichTextElement;
import com.bytedance.lark.pb.basic.v1.UniversalCardEntity;
import com.larksuite.component.card.cardcontainer.UniversalCardRuntimeJsLoader;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larksuite.framework.utils.y;
import com.ss.android.lark.chat.entity.message.CardAction;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.message.card.style.MessageCardStyleProvider;
import com.ss.android.lark.message.lynxcard.settings.CardMessageUserLynxRenderSettings;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.linked_emojicon.base.EmojiHandler;
import com.ss.android.lark.widget.richtext.RichText;
import idb.f;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Okio;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public static HashSet<String> b(List<CardContent.Url> r3) {
        HashSet<String> r0 = new HashSet();
        Iterator<CardContent.Url> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L11;
        CardContent.Url r1 = r4.next();
        if (TextUtils.isEmpty(r1.android_url) == false) goto L7;
        if (TextUtils.isEmpty(r1.url) == true) goto L4;
        r0.add(r1.url);
        goto L4
    L7:
        r0.add(r1.android_url);
        goto L4
    L11:
        return r0;
    }

    public static com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment.VisitInfo c(CardVisitInfo r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment.VisitInfo(r10.scene_type.getValue(), r10.entity_type.getValue(), r10.entity_id, r10.inner_msg_id.longValue(), r10.auth_file_key, new HashMap(r10.im_ext), new HashMap(r10.ext));
    }

    public static com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment d(CardContent.JsonAttachment r13) {
        com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment r0 = new com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment();
        if (CollectionUtils.isNotEmpty(r13.at_users) == false) goto L14;
        HashMap r1 = new HashMap(r13.at_users.size());
        Iterator r3 = r13.at_users.entrySet().iterator();
    L6:
        if (r3.hasNext() == false) goto L12;
        Map.Entry r4 = (Map.Entry) r3.next();
        r1.put((String) r4.getKey(), com.ss.android.lark.message.card.b.a().getAtProperty((RichTextElement.AtProperty) r4.getValue()));     // Catch: Exception -> L10
    L10:
        e = move-exception;
        Log.e("ModelParserCardContent_[OPCard]", "transform AtProperty failed", e);
        goto L6
    L12:
        r0.setAtUsers(r1);
    L14:
        if (CollectionUtils.isNotEmpty(r13.images) == false) goto L25;
        HashMap r2 = new HashMap(r13.images.size());
        Iterator r5 = r13.images.entrySet().iterator();
    L17:
        if (r5.hasNext() == false) goto L23;
        Map.Entry r6 = (Map.Entry) r5.next();
        r2.put((String) r6.getKey(), com.ss.android.lark.message.card.b.a().getImageProperty((RichTextElement.ImageProperty) r6.getValue()));     // Catch: Exception -> L21
    L21:
        e = move-exception;
        Log.e("ModelParserCardContent_[OPCard]", "transform ImageProperty failed", e);
        goto L17
    L23:
        r0.setImages(r2);
    L25:
        if (CollectionUtils.isNotEmpty(r13.option_users) == false) goto L32;
        HashMap r7 = new HashMap(r13.option_users.size());
        Iterator r8 = r13.option_users.entrySet().iterator();
    L28:
        if (r8.hasNext() == false) goto L30;
        Map.Entry r9 = (Map.Entry) r8.next();
        r7.put((String) r9.getKey(), new com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment.OptionUser(((CardContent.JsonAttachment.OptionUser) r9.getValue()).user_id, ((CardContent.JsonAttachment.OptionUser) r9.getValue()).content, ((CardContent.JsonAttachment.OptionUser) r9.getValue()).avatar_key));
        goto L28
    L30:
        r0.setOptionUsers(r7);
    L32:
        if (CollectionUtils.isNotEmpty(r13.component_status_by_name) == false) goto L35;
        HashMap r10 = new HashMap(r13.component_status_by_name.size());
        r10.putAll(r13.component_status_by_name);
        r0.setComponentStatusByName(r10);
    L35:
        if (TextUtils.isEmpty(r13.card_simple_summary) == true) goto L37;
        r0.setSummary(r13.card_simple_summary);
    L86:
        if (CollectionUtils.isNotEmpty(r13.persons) == false) goto L93;
        HashMap r11 = new HashMap(r13.persons.size());
        Iterator r12 = r13.persons.entrySet().iterator();
    L89:
        if (r12.hasNext() == false) goto L91;
        Map.Entry r14 = (Map.Entry) r12.next();
        r11.put((String) r14.getKey(), new com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment.Person(((CardContent.JsonAttachment.PersonInfo) r14.getValue()).person_id, ((CardContent.JsonAttachment.PersonInfo) r14.getValue()).type.ordinal(), ((CardContent.JsonAttachment.PersonInfo) r14.getValue()).content, ((CardContent.JsonAttachment.PersonInfo) r14.getValue()).avatar_key));
        goto L89
    L91:
        r0.setPersonMap(r11);
    L93:
        if (CollectionUtils.isNotEmpty(r13.audios) == false) goto L100;
        HashMap r15 = new HashMap(r13.audios.size());
        Iterator r16 = r13.audios.entrySet().iterator();
    L96:
        if (r16.hasNext() == false) goto L98;
        Map.Entry r17 = (Map.Entry) r16.next();
        com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment.VisitInfo r18 = c(((CardContent.JsonAttachment.AudioInfo) r17.getValue()).visit_info);
        r15.put((String) r17.getKey(), new com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment.AudioInfo(((CardContent.JsonAttachment.AudioInfo) r17.getValue()).key, ((CardContent.JsonAttachment.AudioInfo) r17.getValue()).duration.intValue(), ((CardContent.JsonAttachment.AudioInfo) r17.getValue()).size.longValue(), r18));
        goto L96
    L98:
        r0.setAudioInfoMap(r15);
    L100:
        if (CollectionUtils.isNotEmpty(r13.videos) == false) goto L106;
        HashMap r19 = new HashMap(r13.videos.size());
        Iterator r110 = r13.videos.entrySet().iterator();
    L103:
        if (r110.hasNext() == false) goto L105;
        Map.Entry r20 = (Map.Entry) r110.next();
        com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment.VisitInfo r111 = c(((CardContent.JsonAttachment.VideoInfo) r20.getValue()).visit_info);
        r19.put((String) r20.getKey(), new com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment.VideoInfo(((CardContent.JsonAttachment.VideoInfo) r20.getValue()).key, ((CardContent.JsonAttachment.VideoInfo) r20.getValue()).duration.intValue(), ((CardContent.JsonAttachment.VideoInfo) r20.getValue()).size.longValue(), ((CardContent.JsonAttachment.VideoInfo) r20.getValue()).url, ((CardContent.JsonAttachment.VideoInfo) r20.getValue()).mime, r111));
        goto L103
    L105:
        r0.setVideoInfoMap(r19);
    L106:
        return r0;
    L37:
        CardContent.JsonAttachment.SummaryContent r21 = r13.summary;
        if (r21 == null) goto L86;
        if (r21.items == null) goto L86;
        StringBuilder r22 = new StringBuilder();
        Iterator r23 = r13.summary.items.iterator();
    L43:
        if (r23.hasNext() == false) goto L84;
        CardContent.JsonAttachment.SummaryContent.Item r24 = (CardContent.JsonAttachment.SummaryContent.Item) r23.next();
        if (r24 == null) goto L43;
        if (TextUtils.isEmpty(r24.text) == false) goto L48;
        if (r24.image != null) goto L51;
        if (r24.at_user != null) goto L54;
        CardContent.JsonAttachment.SummaryContent.Item.Emotion r25 = r24.emotion;
        if (r25 == null) goto L60;
        if (TextUtils.isEmpty(r25.key) == true) goto L60;
        r22.append(EmojiHandler.e(r24.emotion.key));
    L60:
        CardContent.JsonAttachment.SummaryContent.Item.PersonList r26 = r24.person_list;
        if (r26 == null) goto L75;
        if (CollectionUtils.isNotEmpty(r26.persons) == false) goto L75;
        StringBuilder r27 = new StringBuilder();
        Iterator r28 = r24.person_list.persons.iterator();
    L66:
        if (r28.hasNext() == false) goto L73;
        CardContent.JsonAttachment.PersonInfo r29 = (CardContent.JsonAttachment.PersonInfo) r28.next();
        if (TextUtils.isEmpty(r29.content) == true) goto L66;
        if (r27.length() <= 0) goto L72;
        r27.append(UIHelper.getString(2131892752));
    L72:
        r27.append(r29.content);
        goto L66
    L73:
        r22.append(r27.toString());
    L75:
        if (r24.i18n_content == null) goto L43;
        Application r30 = LarkContext.getApplication();
        String r31 = r24.i18n_content.key;
        int r32 = r30.getResources().getIdentifier(r31, "string", r30.getPackageName());
        if (r32 != 0) goto L82;
        String r33 = r24.i18n_content.defaultValue;
        if (r33 != null) goto L83;
        r33 = "";
    L83:
        r22.append(r33);
        goto L43
    L82:
        r33 = UIUtils.getString(r30, r32);
        goto L83
    L54:
        r22.append("@");
        r22.append(r24.at_user.content);
        goto L43
    L51:
        r22.append(UIHelper.getString(2131891845));
        goto L43
    L48:
        r22.append(r24.text);
        goto L43
    L84:
        r0.setSummary(r22.toString());
        goto L86
    }

    public static CardAction.Parameters e(com.bytedance.lark.pb.basic.v1.CardAction.Parameters r4) {
        CardAction.MessageInfo r0 = null;
        if (r4 != null) goto L5;
        return null;
    L5:
        CardAction.Parameters r1 = new CardAction.Parameters();
        r1.setMessageId(r4.message_id);
        r1.setUserId(r4.user_id);
        r1.setParameters(new HashMap(r4.parameters));
        com.bytedance.lark.pb.basic.v1.CardAction.UserInfo r2 = r4.user_info;
        if (r2 != null) goto L8;
        CardAction.UserInfo r3 = null;
    L9:
        r1.setUserInfo(r3);
        com.bytedance.lark.pb.basic.v1.CardAction.MessageInfo r5 = r4.message_info;
        if (r5 == null) goto L13;
        r0 = new CardAction.MessageInfo();
        r0.setMessageOpenId(r5.message_open_id);
    L13:
        r1.setMessageInfo(r0);
        return r1;
    L8:
        r3 = new CardAction.UserInfo();
        r3.setUserOpenId(r2.user_open_id);
        goto L9
    }

    public static com.bytedance.lark.pb.basic.v1.CardAction.Parameters f(CardAction.Parameters r4) {
        String r0 = null;
        if (r4 != null) goto L5;
        return null;
    L5:
        com.bytedance.lark.pb.basic.v1.CardAction.Parameters.Builder r1 = new com.bytedance.lark.pb.basic.v1.CardAction.Parameters.Builder().message_id(r4.getMessageId()).user_id(r4.getUserId()).parameters(new HashMap(r4.getParameters()));
        com.bytedance.lark.pb.basic.v1.CardAction.UserInfo.Builder r2 = new com.bytedance.lark.pb.basic.v1.CardAction.UserInfo.Builder();
        if (r4.getUserInfo() == null) goto L8;
        String r3 = r4.getUserInfo().getUserOpenId();
    L9:
        com.bytedance.lark.pb.basic.v1.CardAction.Parameters.Builder r5 = r1.user_info(r2.user_open_id(r3).build());
        com.bytedance.lark.pb.basic.v1.CardAction.MessageInfo.Builder r6 = new com.bytedance.lark.pb.basic.v1.CardAction.MessageInfo.Builder();
        if (r4.getMessageInfo() == null) goto L13;
        r0 = r4.getMessageInfo().getMessageOpenId();
    L13:
        return r5.message_info(r6.message_open_id(r0).build()).build();
    L8:
        r3 = null;
        goto L9
    }

    public static com.ss.android.lark.chat.entity.message.content.CardContent a(Content r27, CardContent r28) {
        int r0 = com.ss.android.lark.message.card.utils.b.a;
        Intrinsics.checkNotNullParameter(r28, "cardContent");
        String r1 = r28.universal_host_card_id;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L21;
        String r3 = r28.json_body;
        if (r3 != null) goto L13;
    L16:
        boolean r4 = true;
    L17:
        if (r4 == false) goto L21;
        if (r28.universal_card_entity != null) goto L21;
        boolean r5 = true;
    L22:
        String r6 = null;
        if (r5 == false) goto L41;
        Log.e("ModelParserCardContent", "getCardContent card error, host_card_id=" + r28.universal_host_card_id);
        Intrinsics.checkNotNullParameter(r28, "pbCardContent");
        com.ss.android.lark.chat.entity.message.content.CardContent r7 = new com.ss.android.lark.chat.entity.message.content.CardContent();
        Log.i("ModelParserCardContentEntity", "getErrorCardContent messageId:" + r7.getMessageId() + ", traceId:" + gyb.a.a().subTrace().getTracingID());
        r7.setHostCardId(r28.universal_host_card_id);
        r7.setType(com.ss.android.lark.chat.entity.message.content.CardContent.Type.TEXT);
        r7.setCardVersion(2);
        r7.setExtraType(com.ss.android.lark.chat.entity.message.content.CardContent.ExtraType.UNKNOWN);
        r7.setActions(MapsKt.emptyMap());
        r7.setDataSource(com.ss.android.lark.chat.entity.message.content.CardContent.DataSource.CARD_ENTITY);
        LarkAppContext.Companion.getClass();
        InputStream r8 = LarkAppContext.access$getInstance$cp().getContext().getAssets().open("error_card_dsl.json");     // Catch: Throwable -> L36
        Intrinsics.checkNotNull(r8);     // Catch: Throwable -> L29
        String r9 = Okio.buffer(Okio.source(r8)).readUtf8();     // Catch: Throwable -> L29
        Log.d("ErrorCardUtil", "getErrorDslJsonString successfully read error card");     // Catch: Throwable -> L29
        CloseableKt.closeFinally(r8, null);     // Catch: Throwable -> L36
        r6 = r9;
    L38:
        r7.setDslJsonString(r6);
        r7.setDslJsonAttachment(new com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment());
        r7.setCardHeader(new com.ss.android.lark.chat.entity.message.content.CardContent.CardHeader());
        r7.setExtraInfo(new com.ss.android.lark.chat.entity.message.content.CardContent.ExtraInfo());
        r7.setEnableForward(false);
        r7.setForward(false);
        r7.setJsonCardUrls(new HashSet());
        r7.setUniversalCardID("");
        r7.setUniversalCardVersion("");
        r7.setStreamingMode(false);
        return r7;
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        Log.e("ErrorCardUtil", "getErrorDslJsonString error", th);
        goto L38
    L41:
        if (r28.universal_card_entity == null) goto L316;
        Log.i("ModelParserCardContent", "getCardContent by card entity, message_id=" + r28.universal_card_entity.source_id);
        UniversalCardEntity r10 = r28.universal_card_entity;
        String r11 = r28.universal_host_card_id;
        int r12 = e.a;
        Intrinsics.checkNotNullParameter(r10, "pbEntity");
        com.ss.android.lark.chat.entity.message.content.CardContent r13 = new com.ss.android.lark.chat.entity.message.content.CardContent();
        OPTrace r14 = gyb.a.a().subTrace();
        Log.i("ModelParserCardContentEntity", "getContent messageId:" + r10.source_id + ", traceId:" + r14.getTracingID());
        r13.setType(com.ss.android.lark.chat.entity.message.content.CardContent.Type.TEXT);
        r13.setCardVersion(2);
        r13.setExtraType(com.ss.android.lark.chat.entity.message.content.CardContent.ExtraType.UNKNOWN);
        r13.setActions(MapsKt.emptyMap());
        r13.setHostCardId(r11);
        CardAppInfo r15 = r10.app_info;
        if (r15 == null) goto L45;
        r13.setSendCardBotId(r15.bot_id);
        r13.setSendAppId(r15.app_id);
    L45:
        UniversalCardEntity.DataSource r16 = r10.data_source;
        if (r16 != null) goto L48;
        int r17 = -1;
    L49:
        if (r17 == 1) goto L55;
        if (r17 == 2) goto L54;
        if (r17 == 3) goto L53;
        com.ss.android.lark.chat.entity.message.content.CardContent.DataSource r18 = com.ss.android.lark.chat.entity.message.content.CardContent.DataSource.IM_ENTITY;
    L56:
        r13.setDataSource(r18);
        r13.setDslJsonString(r10.content.card);
        UniversalCardRuntimeJsLoader.b r19 = UniversalCardRuntimeJsLoader.a;
        UniversalCardEntity.Attachment r20 = r10.content.attachment;
        String r21 = "";
        if (r20 != null) goto L59;
        com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment r22 = null;
    L203:
        r13.setDslJsonAttachment(r22);
        UniversalCardEntity.ActionStatus r23 = r10.action_status;
        if (r23 == null) goto L218;
        Map r24 = r23.component_status_by_action_id;
        if (r24 == null) goto L208;
        HashMap r25 = r13.getComponentStatusByActionId();
        r25.clear();
        r25.putAll(r24);
    L208:
        Map r26 = r23.component_status_by_name;
        if (r26 == null) goto L218;
        if (r13.getDslJsonAttachment() != null) goto L213;
        r13.setDslJsonAttachment(new com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment());
    L213:
        com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment r29 = r13.getDslJsonAttachment();
        if (r29 == null) goto L218;
        HashMap r30 = r29.getComponentStatusByName();
        if (r30 == null) goto L218;
        r30.clear();
        r30.putAll(r26);
    L218:
        UniversalCardEntity.CardHeader r31 = r10.card_header;
        if (r31 != null) goto L221;
        com.ss.android.lark.chat.entity.message.content.CardContent.CardHeader r32 = null;
    L232:
        r13.setCardHeader(r32);
        com.ss.android.lark.chat.entity.message.content.CardContent.ExtraInfo r33 = new com.ss.android.lark.chat.entity.message.content.CardContent.ExtraInfo();
        UniversalCardEntity.Content r34 = r10.content;
        if (r34 == null) goto L237;
        UniversalCardEntity.Config r35 = r34.config;
        if (r35 == null) goto L237;
        r33.setGadgetPreload(r35.is_gadget_preload.booleanValue());
        r33.setGadgetAppIds(r35.gadget_client_ids);
        r33.setAnalyticsData(r35.analytics_data);
        r33.setMeegoPreload(r35.is_meego_pre_load.booleanValue());
        r33.setParseTraceId(r14.getTracingID());
        r33.setEnableTranslate(r35.enable_translate.booleanValue());
        r33.setParseUUID(UUID.randomUUID().toString());
        r33.setCustomParameter(r35.custom_parameter);
    L238:
        Log.i("ModelParserCardContentEntity", "parseCardContent parseUUID:" + r33.getParseUUID());
        r13.setExtraInfo(r33);
        UniversalCardEntity.Content r36 = r10.content;
        if (r36 == null) goto L243;
        UniversalCardEntity.Config r37 = r36.config;
        if (r37 == null) goto L243;
        r13.setEnableForward(r37.enable_forward.booleanValue());
        r13.setForward(r37.is_forward.booleanValue());
        com.ss.android.lark.chat.entity.message.content.CardContent.WidthMode.a r38 = com.ss.android.lark.chat.entity.message.content.CardContent.WidthMode.Companion;
        String r39 = r37.width_mode;
        r38.getClass();
        r13.setWidthMode(com.ss.android.lark.chat.entity.message.content.CardContent.WidthMode.a.a(r39));
    L243:
        List r40 = r10.json_card_urls;
        if (r40 == null) goto L271;
        List r41 = r40;
        ArrayList r42 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r41, 10));
        Iterator r43 = r41.iterator();
    L247:
        if (r43.hasNext() == false) goto L270;
        UniversalCardEntity.Url r44 = (UniversalCardEntity.Url) r43.next();
        String r45 = r44.android_url;
        if (r45 != null) goto L251;
    L258:
        String r46 = r44.url;
        if (r46 != null) goto L261;
    L266:
        r45 = null;
    L267:
        if (r45 != null) goto L269;
        r45 = "";
    L269:
        r42.add(r45);
        goto L247
    L261:
        if (r46.length() <= 0) goto L263;
        boolean r47 = true;
    L264:
        if (r47 == false) goto L266;
        r45 = r46;
        goto L267
    L263:
        r47 = false;
        goto L264
    L251:
        if (r45.length() <= 0) goto L253;
        boolean r48 = true;
    L254:
        if (r48 == true) goto L257;
        r45 = null;
    L257:
        if (r45 != null) goto L269;
    L253:
        r48 = false;
        goto L254
    L270:
        r13.setJsonCardUrls(new HashSet(r42));
    L271:
        String r49 = r10.card_id;
        if (r49 == null) goto L275;
        r21 = r49;
    L275:
        r13.setUniversalCardID(r21);
        r13.setUniversalCardVersion(r10.version);
        r13.setStreamingMode(r10.streaming_mode.booleanValue());
        UniversalCardEntity.StreamingConfig r50 = r10.streaming_config;
        if (r50 == null) goto L313;
        com.ss.android.lark.chat.entity.message.content.CardContent.StreamingConfig r51 = new com.ss.android.lark.chat.entity.message.content.CardContent.StreamingConfig();
        com.ss.android.lark.chat.entity.message.content.CardContent.StreamingConfig.PrintStrategy.a r52 = com.ss.android.lark.chat.entity.message.content.CardContent.StreamingConfig.PrintStrategy.Companion;
        int r53 = r50.print_strategy.getValue();
        r52.getClass();
        if (r53 != 1) goto L280;
        com.ss.android.lark.chat.entity.message.content.CardContent.StreamingConfig.PrintStrategy r54 = com.ss.android.lark.chat.entity.message.content.CardContent.StreamingConfig.PrintStrategy.FAST;
    L284:
        r51.setPrintStrategy(r54);
        UniversalCardEntity.StreamingConfig.PrintConfig r55 = r50.print_frequency_ms;
        if (r55 == null) goto L298;
        Integer r56 = r55.android;
        if (r56.intValue() <= 0) goto L289;
        boolean r57 = true;
    L291:
        if (Boolean.valueOf(r57).booleanValue() == true) goto L294;
        r56 = null;
    L294:
        if (r56 == null) goto L296;
        int r58 = r56.intValue();
    L297:
        r51.setPrintFrequencyMs(r58);
        goto L298
    L296:
        r58 = r55.default_.intValue();
        goto L297
    L289:
        r57 = false;
    L298:
        UniversalCardEntity.StreamingConfig.PrintConfig r59 = r50.print_step;
        if (r59 == null) goto L312;
        Integer r60 = r59.android;
        if (r60.intValue() <= 0) goto L303;
        boolean r110 = true;
    L305:
        if (Boolean.valueOf(r110).booleanValue() == false) goto L307;
        Integer r61 = r60;
    L308:
        if (r61 == null) goto L310;
        int r62 = r61.intValue();
    L311:
        r51.setPrintStep(r62);
        goto L312
    L310:
        r62 = r59.default_.intValue();
        goto L311
    L307:
        r61 = null;
        goto L308
    L303:
        r110 = false;
    L312:
        com.ss.android.lark.chat.entity.message.content.CardContent.StreamingConfig r63 = r51;
    L314:
        r13.setStreamingConfig(r63);
        ResourceCleanScene.a r64 = ResourceCleanScene.Companion;
        Map r65 = r10.clean_resource_key_scene;
        r64.getClass();
        r13.setCleanResourceKeyScene(ResourceCleanScene.a.b(r65));
        return r13;
    L280:
        if (r53 == 2) goto L282;
        r54 = com.ss.android.lark.chat.entity.message.content.CardContent.StreamingConfig.PrintStrategy.DEFAULT;
        goto L284
    L282:
        r54 = com.ss.android.lark.chat.entity.message.content.CardContent.StreamingConfig.PrintStrategy.DELAY;
        goto L284
    L313:
        r63 = null;
    L237:
        Log.w("ModelParserCardContentEntity", "parseCardContent config is null");
        goto L238
    L221:
        r32 = new com.ss.android.lark.chat.entity.message.content.CardContent.CardHeader();
        r32.setMainTitle(r31.main_title);
        r32.setTitle(r31.title);
        r32.setTheme(r31.theme);
        String r66 = r31.subtitle;
        if (r66 == null) goto L232;
        if (r66.length() <= 0) goto L226;
        boolean r67 = true;
    L227:
        if (r67 == true) goto L230;
        r66 = null;
    L230:
        if (r66 == null) goto L232;
        r32.setSubTitle(r66);
        goto L232
    L226:
        r67 = false;
        goto L227
    L59:
        r22 = new com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment();
        Map r111 = r20.at_users;
        if (r111 != null) goto L62;
    L71:
        Map r112 = r20.images;
        if (r112 != null) goto L74;
    L83:
        Map r113 = r20.characters;
        if (r113 != null) goto L86;
    L95:
        ModelParserCardContentEntity$parseJsonAttachmentFromEntity$1$visitInfoConverter$1 r68 = ModelParserCardContentEntity$parseJsonAttachmentFromEntity$1$visitInfoConverter$1.INSTANCE;
        Map r69 = r20.audios;
        if (r69 != null) goto L98;
    L107:
        Map r70 = r20.videos;
        if (r70 != null) goto L110;
    L119:
        String r71 = r20.card_simple_summary;
        if (r71 != null) goto L122;
    L131:
        UniversalCardEntity.SummaryContent r72 = r20.summary;
        if (r72 == null) goto L203;
        List r73 = r72.items;
        if (r73 == null) goto L203;
        StringBuilder r74 = new StringBuilder();
        Iterator r75 = CollectionsKt.filterNotNull(r73).iterator();
    L137:
        if (r75.hasNext() == false) goto L202;
        UniversalCardEntity.SummaryContent.Item r76 = (UniversalCardEntity.SummaryContent.Item) r75.next();
        String r77 = r76.text;
        if (r77 != null) goto L141;
    L147:
        boolean r78 = false;
    L148:
        if (r78 == true) goto L149;
        if (r76.image != null) goto L152;
        if (r76.at_user != null) goto L155;
        UniversalCardEntity.SummaryContent.Item.Emotion r79 = r76.emotion;
        if (r79 == null) goto L167;
        String r80 = r79.key;
        if (r80 == null) goto L167;
        if (r80.length() <= 0) goto L163;
        boolean r81 = true;
    L165:
        if (r81 != true) goto L167;
        boolean r82 = true;
    L168:
        if (r82 == true) goto L169;
        UniversalCardEntity.SummaryContent.Item.CharacterList r83 = r76.person_list;
        if (r83 == null) goto L177;
        List r84 = r83.characters;
        if (r84 == null) goto L177;
        if ((!r84.isEmpty()) != true) goto L177;
        boolean r85 = true;
    L178:
        if (r85 == true) goto L179;
        if (r76.i18n_content == null) goto L137;
        Application r86 = LarkContext.getApplication();
        int r87 = r86.getResources().getIdentifier(r76.i18n_content.key, "string", r86.getPackageName());
        if (r87 != 0) goto L200;
        String r88 = r76.i18n_content.defaultValue;
        if (r88 != null) goto L201;
        r88 = "";
    L201:
        r74.append(r88);
        goto L137
    L200:
        r88 = UIUtils.getString(r86, r87);
        goto L201
    L179:
        StringBuilder r89 = new StringBuilder();
        UniversalCardEntity.SummaryContent.Item.CharacterList r90 = r76.person_list;
        if (r90 == null) goto L137;
        List r91 = r90.characters;
        if (r91 == null) goto L137;
        Iterator r92 = r91.iterator();
    L185:
        if (r92.hasNext() == false) goto L137;
        UniversalCardEntity.Character r93 = (UniversalCardEntity.Character) r92.next();
        if (r89.length() <= 0) goto L189;
        boolean r114 = true;
    L190:
        if (r114 == false) goto L192;
        r89.append(UIHelper.getString(2131892752));
    L192:
        r89.append(r93.content);
        goto L185
    L189:
        r114 = false;
    L177:
        r85 = false;
        goto L178
    L169:
        r74.append(EmojiHandler.e(r76.emotion.key));
        goto L137
    L163:
        r81 = false;
    L167:
        r82 = false;
        goto L168
    L155:
        r74.append("@");
        r74.append(r76.at_user.content);
        goto L137
    L152:
        r74.append(UIHelper.getString(2131891845));
        goto L137
    L149:
        r74.append(r76.text);
        goto L137
    L141:
        if (r77.length() <= 0) goto L143;
        boolean r94 = true;
    L145:
        if (r94 != true) goto L147;
        r78 = true;
        goto L148
    L143:
        r94 = false;
        goto L145
    L202:
        r22.setSummary(r74.toString());
        goto L203
    L122:
        if (r71.length() != 0) goto L124;
        boolean r115 = true;
    L126:
        if ((!r115) == true) goto L129;
        r71 = null;
    L129:
        if (r71 == null) goto L131;
        r22.setSummary(r71);
        goto L203
    L124:
        r115 = false;
        goto L126
    L110:
        if ((!r70.isEmpty()) == true) goto L113;
        r70 = null;
    L113:
        if (r70 == null) goto L119;
        HashMap r95 = new HashMap();
        Iterator r96 = r70.entrySet().iterator();
    L116:
        if (r96.hasNext() == false) goto L118;
        Map.Entry r97 = (Map.Entry) r96.next();
        String r116 = (String) r97.getKey();
        UniversalCardEntity.VideoInfo r98 = (UniversalCardEntity.VideoInfo) r97.getValue();
        r95.put(r116, new com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment.VideoInfo(r98.key, r98.duration.intValue(), r98.size.longValue(), r98.url, r98.mime, (com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment.VisitInfo) r68.invoke(r98.visit_info)));
        goto L116
    L118:
        r22.setVideoInfoMap(r95);
        goto L119
    L98:
        if ((!r69.isEmpty()) == true) goto L101;
        r69 = null;
    L101:
        if (r69 == null) goto L107;
        HashMap r99 = new HashMap();
        Iterator r100 = r69.entrySet().iterator();
    L104:
        if (r100.hasNext() == false) goto L106;
        Map.Entry r101 = (Map.Entry) r100.next();
        String r117 = (String) r101.getKey();
        UniversalCardEntity.AudioInfo r102 = (UniversalCardEntity.AudioInfo) r101.getValue();
        r99.put(r117, new com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment.AudioInfo(r102.key, r102.duration.intValue(), r102.size.longValue(), (com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment.VisitInfo) r68.invoke(r102.visit_info)));
        goto L104
    L106:
        r22.setAudioInfoMap(r99);
        goto L107
    L86:
        if ((!r113.isEmpty()) == true) goto L89;
        r113 = null;
    L89:
        if (r113 == null) goto L95;
        HashMap r118 = new HashMap();
        HashMap r119 = new HashMap();
        Iterator r120 = r113.entrySet().iterator();
    L92:
        if (r120.hasNext() == false) goto L94;
        Map.Entry r121 = (Map.Entry) r120.next();
        String r122 = (String) r121.getKey();
        UniversalCardEntity.Character r123 = (UniversalCardEntity.Character) r121.getValue();
        r118.put(r122, new com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment.OptionUser(r123.id, r123.content, r123.avatar_key));
        r119.put(r122, new com.ss.android.lark.chat.entity.message.content.CardContent.JsonAttachment.Person(r123.id, r123.type.ordinal(), r123.content, r123.avatar_key));
        goto L92
    L94:
        r22.setOptionUsers(r118);
        r22.setPersonMap(r119);
        goto L95
    L74:
        if ((!r112.isEmpty()) == true) goto L77;
        r112 = null;
    L77:
        if (r112 == null) goto L83;
        HashMap r124 = new HashMap(r112.size());
        Iterator r125 = r112.entrySet().iterator();
    L80:
        if (r125.hasNext() == false) goto L82;
        Map.Entry r126 = (Map.Entry) r125.next();
        r124.put((String) r126.getKey(), com.ss.android.lark.message.card.b.a().getImageProperty((RichTextElement.ImageProperty) r126.getValue()));
        goto L80
    L82:
        r22.setImages(r124);
        goto L83
    L62:
        if ((!r111.isEmpty()) == true) goto L65;
        r111 = null;
    L65:
        if (r111 == null) goto L71;
        HashMap r127 = new HashMap(r111.size());
        Iterator r128 = r111.entrySet().iterator();
    L68:
        if (r128.hasNext() == false) goto L70;
        Map.Entry r129 = (Map.Entry) r128.next();
        r127.put((String) r129.getKey(), com.ss.android.lark.message.card.b.a().getAtProperty((RichTextElement.AtProperty) r129.getValue()));
        goto L68
    L70:
        r22.setAtUsers(r127);
        goto L71
    L53:
        r18 = com.ss.android.lark.chat.entity.message.content.CardContent.DataSource.STREAMING_ENTITY;
        goto L56
    L54:
        r18 = com.ss.android.lark.chat.entity.message.content.CardContent.DataSource.CARD_ENTITY;
        goto L56
    L55:
        r18 = com.ss.android.lark.chat.entity.message.content.CardContent.DataSource.IM_ENTITY;
        goto L56
    L48:
        r17 = e.a.a[r16.ordinal()];
        goto L49
    L316:
        com.ss.android.lark.chat.entity.message.content.CardContent r103 = new com.ss.android.lark.chat.entity.message.content.CardContent();
        CardAppInfo r104 = r28.app_info;
        if (r104 == null) goto L319;
        r103.setSendCardBotId(r104.bot_id);
        r103.setSendAppId(r28.app_info.app_id);
    L319:
        com.ss.android.lark.chat.entity.message.content.CardContent.Type.a r105 = com.ss.android.lark.chat.entity.message.content.CardContent.Type.Companion;
        int r106 = r28.type.getValue();
        r105.getClass();
        if (r106 != 1) goto L322;
        com.ss.android.lark.chat.entity.message.content.CardContent.Type r107 = com.ss.android.lark.chat.entity.message.content.CardContent.Type.VOTE;
    L328:
        r103.setType(r107);
        r103.setWidthMode(com.ss.android.lark.chat.entity.message.content.CardContent.WidthMode.forString(r28.width_mode));
        r103.setDataSource(com.ss.android.lark.chat.entity.message.content.CardContent.DataSource.IM_CONTENT);
        r103.setHostCardId(r28.universal_host_card_id);
        long r108 = System.currentTimeMillis();
        OPTrace r109 = gyb.a.a().subTrace();
        if (r103.getCardVersion() != 1) goto L332;
        RichText r130 = com.ss.android.lark.message.card.b.a().parseRichTextFromPb(r28.richtext);
    L346:
        Log.i("ModelParserCardContent", "parseRichText messageId:nulltraceId:" + r109.getTracingID());
        r103.setRichText(r130);
        com.ss.android.lark.chat.entity.message.content.CardContent.ExtraType.a r131 = com.ss.android.lark.chat.entity.message.content.CardContent.ExtraType.Companion;
        int r132 = r28.extra.getValue();
        r131.getClass();
        if (r132 != 1) goto L349;
        com.ss.android.lark.chat.entity.message.content.CardContent.ExtraType r133 = com.ss.android.lark.chat.entity.message.content.CardContent.ExtraType.SENDER_CANNOT_CLICK;
    L350:
        r103.setExtraType(r133);
        Map r134 = r28.actions;
        if (r134 != null) goto L353;
        HashMap r135 = new HashMap();
    L354:
        HashMap r136 = new HashMap();
        Iterator r137 = r135.keySet().iterator();
    L356:
        if (r137.hasNext() == false) goto L413;
        String r138 = (String) r137.next();
        CardAction r139 = (CardAction) r135.get(r138);
        JSONObject r140 = new JSONObject();
        if (r139 != null) goto L360;
    L411:
        long r141 = r108;
        OPTrace r142 = r109;
        Iterator r143 = r137;
    L412:
        r137 = r143;
        r109 = r142;
        r108 = r141;
        goto L356
    L360:
        if (r139.getParameters() == null) goto L411;
        if (r139.getParameters().getParameters() == null) goto L411;
        String r144 = (String) r139.getParameters().getParameters().get("initial_type");
        r140.put("tag", r144);     // Catch: JSONException -> L408
        r143 = r137;
        r142 = r109;
        r141 = r108;
        if (f.a().isEnable("messagecard.action.allow_empty_value.android") == true) goto L512;
        String r145 = "";
        if ("input".equals(r144) == false) goto L389;
    L399:
        String r146 = (String) r139.getParameters().getParameters().get("initial_value");     // Catch: JSONException -> L406
        if (TextUtils.isEmpty(r146) == true) goto L403;
    L401:
        r145 = r146;
    L403:
        if (TextUtils.isEmpty(r145) == true) goto L412;
        r140.put("value", r145);     // Catch: JSONException -> L406
        r136.put(r138, r140.toString());     // Catch: JSONException -> L406
        goto L412
    L389:
        if ("checker".equals(r144) == true) goto L399;
        if ("select_img".equals(r144) == false) goto L396;
        r146 = (String) r139.getParameters().getParameters().get("selected_values");     // Catch: JSONException -> L406
        if (TextUtils.isEmpty(r146) == true) goto L403;
    L396:
        r146 = (String) r139.getParameters().getParameters().get("initial_option");     // Catch: JSONException -> L406
        if (TextUtils.isEmpty(r146) == true) goto L403;
    L512:
        if ("input".equals(r144) == false) goto L370;
    L380:
        String r147 = (String) r139.getParameters().getParameters().get("initial_value");     // Catch: JSONException -> L406
        if (r147 != null) goto L384;
    L383:
        r147 = null;
    L384:
        if (r147 == null) goto L412;
        r140.put("value", r147);     // Catch: JSONException -> L406
        r136.put(r138, r140.toString());     // Catch: JSONException -> L406
        goto L412
    L370:
        if ("checker".equals(r144) == true) goto L380;
        if ("select_img".equals(r144) == false) goto L377;
        r147 = (String) r139.getParameters().getParameters().get("selected_values");     // Catch: JSONException -> L406
        if (r147 == null) goto L383;
    L377:
        r147 = (String) r139.getParameters().getParameters().get("initial_option");     // Catch: JSONException -> L406
        if (r147 == null) goto L383;
    L406:
        e = e;
    L410:
        Log.w("ModelParserCardContent", "parseComponentStatusByActionId is exception", e);
    L408:
        e = e;
        r141 = r108;
        r142 = r109;
        r143 = r137;
        goto L410
    L413:
        long r148 = r108;
        OPTrace r149 = r109;
        r103.getComponentStatusByActionId().clear();
        r103.getComponentStatusByActionId().putAll(r136);
        r103.setActions(r135);
        r103.setStreamingMode(r28.streaming_mode.booleanValue());
        String r150 = r28.card_id;
        if (r150 != null) goto L416;
        r150 = "";
    L416:
        r103.setUniversalCardID(r150);
        r103.setUniversalCardVersion(r28.version);
        if (r28.streaming_config == null) goto L429;
        com.ss.android.lark.chat.entity.message.content.CardContent.StreamingConfig r151 = new com.ss.android.lark.chat.entity.message.content.CardContent.StreamingConfig();
        r151.setPrintStrategy(com.ss.android.lark.chat.entity.message.content.CardContent.StreamingConfig.PrintStrategy.forNumber(r28.streaming_config.print_strategy.getValue()));
        UniversalCardEntity.StreamingConfig.PrintConfig r152 = r28.streaming_config.print_frequency_ms;
        if (r152 == null) goto L423;
        r151.setPrintFrequencyMs(r152.default_.intValue());
        if (r152.android.intValue() <= 0) goto L423;
        r151.setPrintFrequencyMs(r152.android.intValue());
    L423:
        UniversalCardEntity.StreamingConfig.PrintConfig r153 = r28.streaming_config.print_step;
        if (r153 == null) goto L428;
        r151.setPrintStep(r153.default_.intValue());
        if (r153.android.intValue() <= 0) goto L428;
        r151.setPrintStep(r153.android.intValue());
    L428:
        r103.setStreamingConfig(r151);
    L429:
        Integer r154 = r28.card_version;
        if (r154 != null) goto L432;
        int r155 = 1;
    L433:
        r103.setCardVersion(r155);
        CardContent.CardHeader r156 = r28.card_header;
        if (r156 == null) goto L445;
        com.ss.android.lark.chat.entity.message.content.CardContent.CardHeader r157 = new com.ss.android.lark.chat.entity.message.content.CardContent.CardHeader();
        r157.setMainTitle(r156.main_title);
        r157.setTitle(r156.title);
        r157.setStyle(r156.style);
        r157.setTheme(r156.theme);
        if (TextUtils.isEmpty(r156.subtitle) == true) goto L439;
        r157.setSubTitle(r156.subtitle);
    L439:
        if (r156.icon != null) goto L506;
    L444:
        r103.setCardHeader(r157);
        goto L445
    L506:
        r157.setIcon(com.ss.android.lark.message.card.b.a().getImageProperty(r156.icon));     // Catch: Exception -> L442
    L442:
        e = move-exception;
        Log.e("ModelParserCardContent", "parse header icon exception", e);
    L445:
        long r158 = System.currentTimeMillis() - r148;
        String r159 = r149.getTracingID();
        CardContent.ExtraInfo r160 = r28.extra_info;
        com.ss.android.lark.chat.entity.message.content.CardContent.ExtraInfo r161 = new com.ss.android.lark.chat.entity.message.content.CardContent.ExtraInfo();
        if (r160 == null) goto L459;
        CardContent.GadgetConfig r162 = r160.gadget_config;
        if (r162 == null) goto L450;
        r161.setGadgetPreload(r162.is_preload.booleanValue());
        r161.setGadgetAppIds(r160.gadget_config.cli_ids);
    L450:
        CardContent.CustomConfig r163 = r160.custom_config;
        if (r163 == null) goto L453;
        r161.setAnalyticsData(r163.analytics_data);
        r161.setEnableTranslate(r160.custom_config.enable_translate.booleanValue());
    L453:
        CardContent.MeegoConfig r164 = r160.meego_config;
        if (r164 == null) goto L456;
        r161.setMeegoPreload(r164.is_preload.booleanValue());
    L456:
        String r165 = r160.custom_parameter;
        if (r165 == null) goto L460;
        r161.setCustomParameter(r165);
    L460:
        r161.setParseDuration(r158);
        r161.setParseTraceId(r159);
        String r166 = UUID.randomUUID().toString();
        Log.i("ModelParserCardContent", "parseCardContent parseUUID:" + r166);
        r161.setParseUUID(r166);
        r103.setExtraInfo(r161);
        CardMessageUserLynxRenderSettings r167 = lrb.a.a;
        if (com.ss.android.lark.message.card.b.a().getFgValue("lynxcard.client.render.enable") == false) goto L500;
        r103.setDslJsonString(r28.json_body);
        UniversalCardRuntimeJsLoader.b r168 = UniversalCardRuntimeJsLoader.a;
        new HashMap();
        CardContent.JsonAttachment r169 = r28.json_attachment;
        if (r169 == null) goto L468;
        r103.setDslJsonAttachment(d(r169));
        if (r103.getDslJsonAttachment() == null) goto L467;
        r103.getDslJsonAttachment().getOptionUsers();
    L467:
        r103.setForward(r28.json_attachment.is_forward.booleanValue());
    L468:
        List r170 = r28.json_card_urls;
        if (r170 == null) goto L472;
        r103.setJsonCardUrls(b(r170));
    L472:
        if (r135.size() > 0) goto L474;
        HashMap r171 = new HashMap();
    L499:
        r103.setActionSelectValue(r171);
        goto L500
    L474:
        r171 = new HashMap();
        Iterator r172 = r135.keySet().iterator();
    L476:
        if (r172.hasNext() == false) goto L499;
        String r173 = (String) r172.next();
        CardAction r174 = (CardAction) r135.get(r173);
        if (r174 == null) goto L476;
        if (r174.getParameters() == null) goto L476;
        if (r174.getParameters().getParameters() == null) goto L476;
        String r175 = (String) r174.getParameters().getParameters().get("initial_type");
        if ("input".equals(r175) == true) goto L496;
        if ("checker".equals(r175) == true) goto L496;
        if ("select_img".equals(r175) == true) goto L490;
        String r176 = (String) r174.getParameters().getParameters().get("initial_option");
        if (TextUtils.isEmpty(r176) == true) goto L476;
        r171.put(r173, r176);
        goto L476
    L490:
        String r177 = (String) r174.getParameters().getParameters().get("selected_values");
        if (TextUtils.isEmpty(r177) == true) goto L476;
        r171.put(r173, r177);
    L496:
        String r178 = (String) r174.getParameters().getParameters().get("initial_value");
        if (TextUtils.isEmpty(r178) == true) goto L476;
        r171.put(r173, r178);
    L500:
        r103.setEnableForward(r28.enable_forward.booleanValue());
        if (r27 == null) goto L503;
        ResourceCleanScene.a r179 = ResourceCleanScene.Companion;
        Map r180 = r27.clean_resource_key_scene;
        r179.getClass();
        r103.setCleanResourceKeyScene(ResourceCleanScene.a.b(r180));
    L503:
        return r103;
    L459:
        Log.w("ModelParserCardContent", "extra Info is null");
        goto L460
    L432:
        r155 = r154.intValue();
        goto L433
    L353:
        r135 = new HashMap(y.b(r134, new b()));
        goto L354
    L349:
        r133 = com.ss.android.lark.chat.entity.message.content.CardContent.ExtraType.UNKNOWN;
        goto L350
    L332:
        if (com.ss.android.lark.message.card.b.a == null) goto L334;
    L345:
        r130 = com.ss.android.lark.message.card.b.a().parseRichTextFromPbWithStyleMerge(r28.richtext, com.ss.android.lark.message.card.b.a.a());
        goto L346
    L334:
        if (com.ss.android.lark.message.card.b.a != null) goto L345;
        monitor-enter(com.ss.android.lark.message.card.b.class);
    L342:
        th = move-exception;
        throw th;
    L338:
        if (com.ss.android.lark.message.card.b.a != null) goto L340;
        com.ss.android.lark.message.card.b.a = new MessageCardStyleProvider();     // Catch: Throwable -> L342
        com.ss.android.lark.message.card.b.a.c();     // Catch: Throwable -> L342
    L340:
        monitor-exit(com.ss.android.lark.message.card.b.class);     // Catch: Throwable -> L342
        goto L345
    L322:
        if (r106 == 2) goto L326;
        if (r106 == 3) goto L325;
        r107 = com.ss.android.lark.chat.entity.message.content.CardContent.Type.UNKNOWN;
        goto L328
    L325:
        r107 = com.ss.android.lark.chat.entity.message.content.CardContent.Type.VCHAT;
        goto L328
    L326:
        r107 = com.ss.android.lark.chat.entity.message.content.CardContent.Type.TEXT;
        goto L328
    L13:
        if (r3.length() == 0) goto L16;
        r4 = false;
    L21:
        r5 = false;
        goto L22
    L5:
        if (r1.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
