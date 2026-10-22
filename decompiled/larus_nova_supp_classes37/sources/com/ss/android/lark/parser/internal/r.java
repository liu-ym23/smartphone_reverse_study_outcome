package com.ss.android.lark.parser.internal;

import android.text.TextUtils;
import android.util.LruCache;
import android.util.Pair;
import com.bytedance.lark.pb.basic.v1.BaikeEntityMeta;
import com.bytedance.lark.pb.basic.v1.CalendarEntityMeta;
import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.basic.v1.Content;
import com.bytedance.lark.pb.basic.v1.ElementRefs;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.FilePreviewStage;
import com.bytedance.lark.pb.basic.v1.HashTagMentionEntity;
import com.bytedance.lark.pb.basic.v1.HongbaoContent;
import com.bytedance.lark.pb.basic.v1.HongbaoCover;
import com.bytedance.lark.pb.basic.v1.Image;
import com.bytedance.lark.pb.basic.v1.ImageSet;
import com.bytedance.lark.pb.basic.v1.ImageSetPassThrough;
import com.bytedance.lark.pb.basic.v1.ImageTranslationAbility;
import com.bytedance.lark.pb.basic.v1.ImageTranslationInfo;
import com.bytedance.lark.pb.basic.v1.MentionAction;
import com.bytedance.lark.pb.basic.v1.MentionContent;
import com.bytedance.lark.pb.basic.v1.MentionContentStyle;
import com.bytedance.lark.pb.basic.v1.PreviewUrlContent;
import com.bytedance.lark.pb.basic.v1.PreviewVideo;
import com.bytedance.lark.pb.basic.v1.Ref;
import com.bytedance.lark.pb.basic.v1.Refs;
import com.bytedance.lark.pb.basic.v1.Span;
import com.bytedance.lark.pb.basic.v1.SystemMessageItemAction;
import com.bytedance.lark.pb.basic.v1.Thread;
import com.bytedance.lark.pb.basic.v1.TranslateInfo;
import com.bytedance.lark.pb.basic.v1.TranslatedImage;
import com.bytedance.lark.pb.basic.v1.URL;
import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.framework.utils.ApkUtil;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larksuite.framework.utils.n0;
import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.chat.api.service.impl.i2;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatAnnouncement;
import com.ss.android.lark.chat.entity.chatter.ChatterInfo;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageUrlPreview;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.chat.entity.message.content.FolderContent;
import com.ss.android.lark.chat.entity.message.content.ImageContent;
import com.ss.android.lark.chat.entity.message.content.ImageTranslateProperty;
import com.ss.android.lark.chat.entity.message.content.MediaContent;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.entity.message.content.ProfileContent;
import com.ss.android.lark.chat.entity.message.content.RedPacketContent;
import com.ss.android.lark.chat.entity.message.content.StickerContent;
import com.ss.android.lark.chat.entity.message.content.SystemContent;
import com.ss.android.lark.chat.entity.message.content.TextContent;
import com.ss.android.lark.chat.entity.redpacket.RedPacketCover;
import com.ss.android.lark.chat.entity.redpacket.RedPacketDisplayName;
import com.ss.android.lark.chat.entity.sticker.StickerInfo;
import com.ss.android.lark.chat.export.entity.message.content.ChatterToolTipType;
import com.ss.android.lark.chat.export.entity.message.content.ContentValue;
import com.ss.android.lark.chat.export.entity.message.content.ContentValueType;
import com.ss.android.lark.chat.export.entity.message.content.SystemMessageAction;
import com.ss.android.lark.chat.export.entity.message.content.SystemMessageType;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.SendScene;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.ColorIcon;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.export.entity.preview.UnifiedHeaderInfo;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.im.sdk.utils.ImSdkMessageUtils;
import com.ss.android.lark.image.entity.PassThroughImage;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class r {
    public static StickerContent m(Content r4) throws Exception {
        StickerContent r0 = new StickerContent();
        r0.setHeight(r4.height.intValue());
        r0.setWidth(r4.width.intValue());
        r0.setKey(r4.key);
        r0.setStickerId(r4.sticker_id);
        r0.setStickerSetId(r4.sticker_set_id);
        StickerInfo r1 = new StickerInfo();
        Content.StickerInfo r2 = r4.sticker_info;
        if (r2 == null) goto L5;
        r1.setTitle(r2.title);
        r1.setDescription(r2.description);
        r1.setHasPaid(r2.is_paid.booleanValue());
    L5:
        r0.setStickerInfo(r1);
        ResourceCleanScene.a r3 = ResourceCleanScene.Companion;
        Map r5 = r4.clean_resource_key_scene;
        r3.getClass();
        r0.setCleanResourceKeyScene(ResourceCleanScene.a.b(r5));
        return r0;
    }

    public static SystemContent n(Content r14) throws Exception {
        SystemContent r0 = new SystemContent();
        r0.setMessageTemplate(r14.template);
        SystemMessageType r1 = SystemMessageType.forNumber(r14.system_type.getValue());
        r0.setType(r1);
        Integer r2 = r14.system_type_value;
        if (r2 != null) goto L5;
        int r3 = 0;
    L6:
        r0.setSystemTypeValue(r3);
        Map r4 = r14.values;
        SystemMessageType r5 = SystemMessageType.LOCAL_MENTION_BOTS_NOT_IN_CHAT;
        Map r6 = r4;
        if (r1 != r5) goto L20;
        HashMap r7 = new HashMap(r14.values);
        if (r1 != r5) goto L18;
        String r8 = (String) r7.remove("trigger_local_message_id");
        if (r8 == null) goto L18;
        long r9 = CastLongProtector.parseLong(r8);     // Catch: NumberFormatException -> L110
        if (r9 <= 0) goto L18;
        if (TextUtils.equals(r8, Long.toString(r9)) == false) goto L18;
    L19:
        r0.setLocalMentionTriggerMessageId(r8);
        r6 = r7;
    L18:
        r8 = null;
    L20:
        r0.setContents(r6);
        Map r10 = r14.content_values;
        if (r1 != SystemMessageType.LOCAL_MENTION_BOTS_NOT_IN_CHAT) goto L53;
        if (r10 == null) goto L53;
        Content.ContentValue r11 = (Content.ContentValue) r10.get("agent");
        if (r11 == null) goto L52;
        List r12 = r11.items;
        if (r12 == null) goto L52;
        if (r12.isEmpty() == true) goto L52;
        ArrayList r13 = new ArrayList(r11.items.size());
        HashSet r15 = new HashSet();
        Iterator r16 = r11.items.iterator();
    L33:
        if (r16.hasNext() == false) goto L54;
        Content.ContentValue.Item r17 = (Content.ContentValue.Item) r16.next();
        if (r17 == null) goto L51;
        if (r17.type != Content.ContentValueType.BOT) goto L51;
        String r18 = r17.id;
        if (r18 == null) goto L51;
        long r19 = CastLongProtector.parseLong(r18.trim());     // Catch: NumberFormatException -> L50
        if (r19 <= 0) goto L49;
        if (r15.add(Long.valueOf(r19)) == false) goto L49;
        r13.add(Long.toString(r19));
    L49:
        r13 = new ArrayList();
    L50:
        r13 = new ArrayList();
    L51:
        r13 = new ArrayList();
    L54:
        r0.setLocalMentionAgentIds(r13);
        Map r20 = r14.system_content_values;
        HashMap r21 = new HashMap();
        Iterator r22 = r20.entrySet().iterator();
        boolean r23 = false;
    L56:
        if (r22.hasNext() == false) goto L75;
        Map.Entry r24 = (Map.Entry) r22.next();
        Content.SystemContentValue r25 = (Content.SystemContentValue) r24.getValue();
        ArrayList r26 = new ArrayList();
        Iterator r27 = r25.content_values.iterator();
    L59:
        if (r27.hasNext() == false) goto L74;
        Content.SystemContentValue.ContentValue r110 = (Content.SystemContentValue.ContentValue) r27.next();
        ContentValue r111 = new ContentValue();
        r111.setId(r110.id);
        r111.setValue(r110.value);
        r111.setLink(r110.link);
        r111.setContentValueType(ContentValueType.fromValue(r110.type.getValue()));
        r111.setAction(new SystemMessageAction(SystemMessageAction.ActType.fromValue(r110.action_type.getValue())));
        r111.setAnonymous(r110.is_anonymous);
        r111.setActionId(r110.action_id.intValue());
        if (SystemMessageType.CREATE_TEAM_CHAT_V2_MANAGER != r1) goto L63;
    L66:
        r111.setClickable(true);
    L67:
        r26.add(r111);
        if (r23 == true) goto L73;
        if (r110.is_clickable.booleanValue() == true) goto L73;
        r23 = false;
    L73:
        r23 = true;
        goto L59
    L63:
        if (SystemMessageType.BIND_CHAT_INTO_TEAM_MANAGER == r1) goto L66;
        r111.setClickable(r110.is_clickable.booleanValue());
        goto L67
    L74:
        r21.put((String) r24.getKey(), r26);
        goto L56
    L75:
        Pair r28 = new Pair(Boolean.valueOf(r23), r21);
        r0.setSystemContents((Map) r28.second);
        r0.setMsgClickable(((Boolean) r28.first).booleanValue());
        Map r29 = r14.item_actions;
        HashMap r30 = new HashMap();
        if (CollectionUtils.isEmpty(r29) == true) goto L108;
        Iterator r31 = r29.entrySet().iterator();
    L80:
        if (r31.hasNext() == false) goto L108;
        Map.Entry r32 = (Map.Entry) r31.next();
        if (r32.getValue() == null) goto L80;
        SystemMessageItemAction r33 = (SystemMessageItemAction) r32.getValue();
        SystemMessageItemAction.Url r34 = r33.url;
        if (r34 != null) goto L86;
        SystemMessageItemAction.LarkCommand r35 = r33.lark_command;
        if (r35 != null) goto L89;
        SystemMessageItemAction.InviteAtChatters r36 = r33.invite_at_chatters;
        if (r36 != null) goto L93;
    L99:
        SystemMessageItemAction.ChatterTooltip r37 = r33.chatter_tooltip;
        if (r37 == null) goto L80;
        ChatterToolTipType.a r38 = ChatterToolTipType.Companion;
        int r39 = r37.chatter_tooltip_type.getValue();
        r38.getClass();
        if (r39 == 0) goto L106;
        if (r39 == 1) goto L105;
        ChatterToolTipType r40 = ChatterToolTipType.UNKNOWN;
    L107:
        com.ss.android.lark.chat.export.entity.message.content.b r41 = new com.ss.android.lark.chat.export.entity.message.content.b(r40);
        r30.put((Integer) r32.getKey(), r41);
        goto L80
    L105:
        r40 = ChatterToolTipType.SIMPLIFY_SYSTEM_MESSAGE;
        goto L107
    L106:
        r40 = ChatterToolTipType.UNKNOWN;
        goto L107
    L93:
        if (CollectionUtils.isNotEmpty(r36.at_chatter_ids) == false) goto L99;
        ArrayList r42 = new ArrayList();
        Iterator r43 = r33.invite_at_chatters.at_chatter_ids.iterator();
    L96:
        if (r43.hasNext() == false) goto L98;
        r42.add(String.valueOf((Long) r43.next()));
        goto L96
    L98:
        com.ss.android.lark.chat.export.entity.message.content.c r44 = new com.ss.android.lark.chat.export.entity.message.content.c(r42);
        r30.put((Integer) r32.getKey(), r44);
        goto L99
    L89:
        com.ss.android.lark.chat.export.entity.message.content.d r45 = new com.ss.android.lark.chat.export.entity.message.content.d(r35.cmd.intValue(), r33.lark_command.payload);
        r30.put((Integer) r32.getKey(), r45);
        goto L80
    L86:
        com.ss.android.lark.chat.export.entity.message.content.a r46 = new com.ss.android.lark.chat.export.entity.message.content.a(r34.android, r34.common);
        r30.put((Integer) r32.getKey(), r46);
    L108:
        r0.setItemActions(r30);
        r0.setVersion(r14.system_message_version.intValue());
        r0.setVoIPFromId(r14.e2ee_from_id);
        r0.setVoIPToId(r14.e2ee_to_id);
        r0.setVoIpTriggerId(r14.trigger_id);
        r0.setVcFromId(r14.vc_from_id);
        r0.setVcToId(r14.vc_to_id);
        r0.setSystemExtraContent(r14.system_extra_content);
        return r0;
    L52:
        r13 = new ArrayList();
    L53:
        r13 = new ArrayList();
        goto L54
    L5:
        r3 = r2.intValue();
        goto L6
    }

    public static TextContent p(Content r1) throws Exception {
        if (r1 == null) goto L4;
        String r2 = r1.text;
    L5:
        if (r2 != null) goto L7;
        r2 = UIHelper.mustacheFormat(2131892299);
    L7:
        TextContent r0 = new TextContent();
        r0.setRichText(com.ss.android.lark.widget.richtext.c.c(r2));
        return r0;
    L4:
        r2 = null;
        goto L5
    }

    public static AudioContent b(Content r4, TranslateInfo r5) throws Exception {
        AudioContent r0 = new AudioContent();
        if (ImSdkProxy.c().isFeatureGatingEnable("ai.translate.message.audio") == false) goto L8;
        if (r5 == null) goto L8;
        Content r6 = r5.content;
        if (r6 == null) goto L8;
        r4 = r6;
    L8:
        RichText r7 = g0.e(r4.rich_text, null);
        if (TextUtils.isEmpty(r4.key) == false) goto L11;
        String r2 = r4.local_upload_id;
    L12:
        r0.setKey(r2);
        r0.setSize(r4.size.longValue());
        r0.setDuration(r4.duration.intValue());
        r0.setRecognizedText(r4.voice2text);
        if (r7.getElements() != null) goto L15;
    L20:
        boolean r8 = true;
    L21:
        if (r8 == true) goto L23;
        r0.setRecognizedRichText(g0.e(r4.rich_text, null));
    L23:
        r0.setNeedHideText(r4.hide_voice2text.booleanValue());
        r0.setRecognizeFinished(r4.is_audio_recognize_finish.booleanValue());
        r0.setAudio2TextStartTime(r4.audio2text_start_time.intValue());
        r0.setAudioWithText(r4.is_audio_with_text.booleanValue());
        return r0;
    L15:
        if (CollectionUtils.isEmpty(r7.getElements().getDictionary()) == true) goto L20;
        if (CollectionUtils.isEmpty(r7.getElementIds()) == true) goto L20;
        r8 = false;
        goto L21
    L11:
        r2 = r4.key;
        goto L12
    }

    public static FolderContent d(Content r3, Message r4) throws Exception {
        boolean r5 = r4.isFromMe();
        FolderContent r0 = new FolderContent();
        r0.setKey(r3.key);
        r0.setName(r3.name);
        r0.setNameSpace(r3.namespace);
        r0.setSize(r3.size.longValue());
        r0.setInMyNutStore(r3.is_in_my_nut_store.booleanValue());
        r0.setLanTransStatus(r3.lan_trans_status.getValue());
        ResourceCleanScene.a r1 = ResourceCleanScene.Companion;
        Map r2 = r3.clean_resource_key_scene;
        r1.getClass();
        r0.setCleanResourceKeyScene(ResourceCleanScene.a.b(r2));
        r0.setSource(r3.file_source.getValue());
        r0.setSender(r5);
        return r0;
    }

    public static ImageContent e(Content r5, Message r6) {
        ImageContent r0 = new ImageContent();
        String r1 = null;
        if (r5 == null) goto L5;
        ImageSet r2 = r5.image;
    L6:
        com.ss.android.lark.chat.entity.image.ImageSet r3 = o.a(r2, r6.getId());
        if (r5 == null) goto L17;
        Boolean r4 = r5.is_origin_source;
        if (r4 == null) goto L11;
        boolean r7 = r4.booleanValue();
    L12:
        r3.setOriginSource(r7);
        Long r8 = r5.origin_size;
        if (r8 == null) goto L15;
        long r9 = r8.longValue();
    L16:
        r3.setOriginSize(r9);
        r0.setRiskObjectKeys(new ArrayList(r5.risk_object_keys));
        goto L17
    L15:
        r9 = 0;
        goto L16
    L11:
        r7 = false;
    L17:
        r3.setFromMe(r6.isFromMe());
        r3.setSenderTenantId(r6.getFromChatterTenantId());
        r0.setImageSet(r3);
        if (r5 == null) goto L20;
        r1 = r5.image_upload_id;
    L20:
        r0.setImageUploadId(r1);
        if (r5 == null) goto L23;
        ResourceCleanScene.a r10 = ResourceCleanScene.Companion;
        Map r11 = r5.clean_resource_key_scene;
        r10.getClass();
        r0.setCleanResourceKeyScene(ResourceCleanScene.a.b(r11));
    L23:
        return r0;
    L5:
        r2 = null;
        goto L6
    }

    public static MediaContent g(Content r4, Message r5) {
        String r6 = r5.getId();
        MediaContent r0 = new MediaContent();
        com.bytedance.lark.pb.basic.v1.MediaContent r1 = r4.media_content;
        if (r1 == null) goto L12;
        r0.setKey(r1.key);
        r0.setUrl(r1.url);
        r0.setName(r1.name);
        r0.setSize(r1.size.longValue());
        r0.setMime(r1.mime);
        MediaContent.Source.a r2 = MediaContent.Source.Companion;
        int r3 = r1.source.getValue();
        r2.getClass();
        if (r3 != 0) goto L7;
        MediaContent.Source r7 = MediaContent.Source.UNKNOWN;
    L11:
        r0.setSource(r7);
        r0.setImageSet(o.a(r1.image, r6));
        r0.setProgress(0);
        r0.setCompressPath(r1.compress_path);
        r0.setOriginPath(r1.origin_path);
        r0.setFilePath(r4.file_path);
        r0.setDuration(r1.duration.intValue());
        r0.setOriginal(r1.is_original.booleanValue());
        r0.setRiskObjectKeys(new ArrayList(r4.risk_object_keys));
        ResourceCleanScene.a r8 = ResourceCleanScene.Companion;
        Map r9 = r4.clean_resource_key_scene;
        r8.getClass();
        r0.setCleanResourceKeyScene(ResourceCleanScene.a.b(r9));
        r0.setCryptoToken(r4.crypto_token);
        r0.setMediaUploadId(r1.media_upload_id);
        r0.setFirstScreenImageUploadId(r1.first_screen_image_upload_id);
    L13:
        return r0;
    L7:
        if (r3 == 1) goto L9;
        r7 = MediaContent.Source.UNKNOWN;
        goto L11
    L9:
        r7 = MediaContent.Source.LARK;
        goto L11
    L12:
        r0.setImageSet(o.a(null, r6));
        goto L13
    }

    public static Chat i(String r1, Chat.Type r2) {
        Chat r0 = new Chat();
        r0.setId(r1);
        r0.setType(r2);
        r0.setLastMessageId("");
        r0.setName("");
        r0.setAvatarKey("");
        r0.setOwnerId("");
        r0.setStatus(Chat.Status.NORMAL);
        r0.setDescription("");
        r0.setCreateTime("");
        r0.setNamePinyin("");
        r0.setTags(new ArrayList());
        r0.setTextDraftId("");
        r0.setPostDraftId("");
        r0.setLastThreadId("");
        r0.setLastVisibleThreadId("");
        r0.setAddMemberApply(Chat.AddMemberApply.UNKNOWN);
        r0.setLastDraftId("");
        r0.setMiniAvatarKey("");
        r0.setSideBarId("");
        r0.setSideBarButtons(new ArrayList());
        r0.setTenantId("");
        r0.setAnonymousId("");
        r0.setMessageVisibilitySetting(Chat.MessageVisibilitySetting.UNKNOWN);
        r0.setRole(Chat.Role.VISITOR);
        r0.setChatAnnouncement(new ChatAnnouncement());
        r0.setChatMode(Chat.ChatMode.DEFAULT);
        return r0;
    }

    public static List<MessageUrlPreview> q(String r8, Content r9) {
        if (r9.preview_urls.size() == 0) goto L5;
        ArrayList r0 = new ArrayList();
        Iterator r1 = r9.preview_urls.iterator();
    L8:
        if (r1.hasNext() == false) goto L36;
        PreviewUrlContent r2 = (PreviewUrlContent) r1.next();
        MessageUrlPreview r3 = new MessageUrlPreview();
        r3.setMessageId(r8);
        String r4 = r2.title;
        int r5 = 0;
        if (r4 != null) goto L12;
    L15:
        r3.setTitle(r4);
        r3.setSequenceId(r2.sequence_id.intValue());
        String r6 = r2.summary;
        if (r6 != null) goto L18;
    L21:
        r3.setDescription(r6);
        r3.setIcon(o.a(r2.icon, r8));
        r3.setUrl(r2.url);
        r3.setDeleted(r2.is_hidden.booleanValue());
        String r7 = r9.text;
        String r10 = "";
        if (r7 != null) goto L25;
        r7 = "";
    L25:
        String r11 = r2.url;
        if (r11 == null) goto L28;
        r10 = r11;
    L28:
        int r12 = r7.indexOf(r10);
        String r13 = r2.url;
        if (r13 == null) goto L31;
        r5 = r13.length();
    L31:
        r3.setCount(r5);
        r3.setOffset(r12);
        r3.setCoverImage(o.a(r2.cover_image, r8));
        PreviewVideo r14 = r2.video_info;
        if (r14 != null) goto L34;
        com.ss.android.lark.chat.entity.message.PreviewVideo r15 = null;
    L35:
        r3.setPreviewVideo(r15);
        r0.add(r3);
        goto L8
    L34:
        r15 = new com.ss.android.lark.chat.entity.message.PreviewVideo(com.ss.android.lark.chat.entity.message.PreviewVideo.Site.valueOf(r14.site.name()), r14.vid, r14.iframe_url);
        goto L35
    L18:
        if (r6.length() <= 400) goto L21;
        r6 = r6.substring(0, 400);
        goto L21
    L12:
        if (r4.length() <= 200) goto L15;
        r4 = r4.substring(0, 200);
        goto L15
    L36:
        return r0;
    L5:
        return new ArrayList();
    }

    public static Map<String, PreviewHangPoint> r(String r14, Content r15) {
        boolean r2 = true;
        if (r15.preview_urls.size() == 1) goto L5;
    L9:
        r2 = false;
    L10:
        if (r2 == false) goto L32;
        if (r15.url_preview_hang_point_map.size() > 0) goto L32;
        HashMap r0 = new HashMap();
        Iterator r16 = r15.preview_urls.iterator();
    L16:
        if (r16.hasNext() == false) goto L30;
        PreviewUrlContent r3 = (PreviewUrlContent) r16.next();
        if (TextUtils.isEmpty(r3.title) == true) goto L16;
        UrlPreviewEntity.Builder r4 = new UrlPreviewEntity.Builder();
        r4.is_sdk_preview = Boolean.TRUE;
        r4.sdk_title = r3.title;
        r4.sdk_description = r3.summary;
        if (TextUtils.isEmpty(r3.url) == true) goto L23;
        r4.sdk_domain = n0.b(r3.url);
    L23:
        com.ss.android.lark.chat.entity.image.ImageSet r5 = o.a(r3.icon, r14);
        if (CollectionUtils.isNotEmpty(r5.getOrigin().getUrls()) == false) goto L26;
        r4.sdk_favicon_url = (String) ListProtector.get(r5.getOrigin().getUrls(), 0);
    L26:
        com.ss.android.lark.chat.entity.image.ImageSet r6 = o.a(r3.cover_image, r14);
        if (CollectionUtils.isNotEmpty(r6.getOrigin().getUrls()) == false) goto L29;
        r4.sdk_icon_url = (String) ListProtector.get(r6.getOrigin().getUrls(), 0);
    L29:
        URL.Builder r7 = new URL.Builder();
        r7.url = r3.url;
        r4.url = r7.build();
        r4.source_id = r14;
        r4.version = 0;
        r4.preview_id = "URLPreview" + UUID.randomUUID().toString().substring(0, 20);
        UrlCardPreviewEntity r13 = j6b.d.d(r4.build(), false);
        PreviewHangPoint r8 = new PreviewHangPoint(r3.url, "URLPreview_hang_point_id" + UUID.randomUUID().toString().substring(0, 10), r14, r4.preview_id, true, false, SendScene.DEFAULT, r13);
        r0.put(r8.getHangPointId(), r8);
        goto L16
    L30:
        return r0;
    L32:
        return new HashMap();
    L5:
        if (((PreviewUrlContent) ListProtector.get(r15.preview_urls, 0)).is_hidden.booleanValue() == true) goto L9;
        if (TextUtils.isEmpty(((PreviewUrlContent) ListProtector.get(r15.preview_urls, 0)).title) == true) goto L9;
        goto L9
    }

    public static void w(RichText r6, Entity r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        if (CollectionUtils.isEmpty(r7.mentions) == true) goto L44;
        if (r6 != null) goto L8;
        return;
    L8:
        if (r6.getElements() == null) goto L45;
        Map r8 = r6.getElements().getDictionary();
        Iterator r0 = r8.keySet().iterator();
    L12:
        if (r0.hasNext() == false) goto L46;
        RichTextElement r1 = (RichTextElement) r8.get((String) r0.next());
        if ((r1.getProperty() instanceof RichTextElement.MentionProperty) == false) goto L12;
        RichTextElement.MentionProperty r2 = r1.getProperty();
        HashTagMentionEntity r3 = (HashTagMentionEntity) r7.mentions.get(r2.getMentionItem().getId());
        if (r3 == null) goto L12;
        MentionContent r4 = r3.name;
        if (r4 == null) goto L26;
        String r5 = r4.default_content;
        if (TextUtils.isEmpty(r5) == true) goto L23;
        r2.setContent(r5);
    L23:
        MentionContentStyle r9 = r4.style;
        if (r9 == null) goto L26;
        r2.setAuthorized(r9.is_available.booleanValue());
    L26:
        MentionAction r10 = r3.click_action;
        if (r10 == null) goto L12;
        if (r10.action_type != MentionAction.ActionType.redirect) goto L12;
        r2.setRedirectUrl(r10.redirect_url);
        goto L12
    L46:
        return;
    L45:
        return;
    }

    public static void x(RichText r12, Map<String, PreviewHangPoint> r13) {
        if (r12 == null) goto L66;
        if (r13 != null) goto L5;
        return;
    L5:
        if (CollectionUtils.isEmpty(r13) == true) goto L83;
        Iterator<String> r0 = r13.keySet().iterator();
    L9:
        if (r0.hasNext() == false) goto L84;
        String r1 = r0.next();
        Log.i("[URLPreview]ModelParserMessageContent", "content, elementId:" + r1);
        RichTextElement r2 = (RichTextElement) r12.getElements().getDictionary().get(r1);
        if (r2 == null) goto L9;
        if ((r2.getProperty() instanceof RichTextElement.AnchorProperty) == false) goto L9;
        PreviewHangPoint r3 = r13.get(r1);
        if (r3 == null) goto L18;
        RichTextElement.AnchorProperty r4 = r2.getProperty();
        r4.setUrlPreviewId(r3.getPreviewId());
        UrlCardPreviewEntity r5 = r3.getUrlCardPreviewEntity();
        if (r5 == null) goto L21;
        if (r4.isCloseCardPreview() == false) goto L26;
        UrlCardPreviewEntity r6 = new UrlCardPreviewEntity(r5.getInlineEntity(), null, r5.getRenderRouterEntity(), r5.getComponentTreeTime());
        r3.setUrlCardPreviewEntity(r6);
        r5 = r6;
    L26:
        if (r4.isCustom() == true) goto L9;
        UrlInlinePreviewEntity r7 = r5.getInlineEntity();
        Log.i("[URLPreview]ModelParserMessageContent", "urlPreviewEntity.previewID:" + r7.getPreviewId());
        r4.setDisplayTitle(r7.getTitle());
        if (r7.getUrl() != null) goto L30;
    L35:
        r4.setLocalIconRes(2131235936);
        int r8 = edb.e.a;
        Intrinsics.checkNotNullParameter(r7, "inlineEntity");
        Intrinsics.checkNotNullParameter(r4, "anchorProperty");
        if (r7.getUseColorIcon() == false) goto L62;
        UnifiedHeaderInfo r9 = r7.getHeaderInfo();
        if (r9 == null) goto L40;
        ColorIcon r10 = r9.getIcon();
    L41:
        if (r10 == null) goto L58;
        if (r10.getUdIcon() == null) goto L46;
        edb.e.a(r10.getUdIcon(), r4);
    L56:
        r4.setColorIcon(true);
    L65:
        r4.setVersion(r7.getVersion());
        r4.setUrlPreview(true);
        goto L9
    L46:
        if (r10.getImageSet() == null) goto L52;
        com.ss.android.lark.export.entity.preview.ImageSet r11 = r10.getImageSet();
        if (r11 == null) goto L50;
        String r14 = r11.getKey();
    L51:
        r4.setIconKey(r14);
    L53:
        ThemeColor r15 = r10.getThemeColor();
        if (r15 == null) goto L56;
        r4.setIconColor(com.ss.android.lark.export.entity.preview.a.a(r15, UIHelper.getContext(), null));
        goto L56
    L50:
        r14 = null;
        goto L51
    L52:
        r4.setFaviconUrl(r10.getFaviconUrl());
        goto L53
    L58:
        if (r7.getUdIcon() != null) goto L60;
        r4.setIconKey(r7.getNetIconKey());
        goto L65
    L60:
        edb.e.a(r7.getUdIcon(), r4);
        goto L65
    L40:
        r10 = null;
        goto L41
    L62:
        if (r7.getUdIcon() != null) goto L64;
        r4.setIconKey(r7.getNetIconKey());
        goto L65
    L64:
        edb.e.a(r7.getUdIcon(), r4);
        goto L65
    L30:
        if (TextUtils.isEmpty(r7.getUrl().getAndroidUrl()) == true) goto L33;
        r4.setHref(r7.getUrl().getAndroidUrl());
        goto L35
    L33:
        if (TextUtils.isEmpty(r7.getUrl().getUrl()) == true) goto L35;
        r4.setHref(r7.getUrl().getUrl());
        goto L35
    L21:
        Log.i("[URLPreview]ModelParserMessageContent", "urlPreviewEntity is null, previewId: " + r3.getPreviewId());
        goto L9
    L18:
        Log.i("[URLPreview]ModelParserMessageContent", "transformRichTextByPreview previewHangPoint is null");
        goto L9
    L84:
        return;
    L83:
        return;
    }

    public static boolean a(Span r4, String r5, String r6) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r5) == false) goto L7;
        return false;
    L7:
        if (TextUtils.isEmpty(r6) == true) goto L27;
        int r1 = r4.start.intValue();
        int r7 = r4.end.intValue();
        if (r1 < 0) goto L23;
        if (r1 <= r7) goto L13;
        return false;
    L13:
        if ((r7 - r1) == r5.length()) goto L16;
        return false;
    L16:
        if (r7 <= r6.length()) goto L18;
        return false;
    L18:
        if (r6.substring(r1, r7).equals(r5) == false) goto L26;
        return true;
    L26:
        return false;
    L23:
        return false;
    L27:
        return false;
    }

    public static ImageContent f(Content r3, Message r4, TranslateInfo r5) throws Exception {
        Object r1 = null;
        if (ImSdkProxy.c().isFeatureGatingEnable("translate.image.chat.menu.enable") == false) goto L21;
        if (r5 == null) goto L21;
        ImageSet r0 = r3.image;
        ImageTranslationInfo r6 = r5.image_translation_info;
        if (r6 == null) goto L17;
        Map r7 = r6.translated_images;
        if (r7 == null) goto L17;
        if (r0 != null) goto L12;
    L11:
        Object r8 = null;
    L16:
        TranslatedImage r9 = (TranslatedImage) r8;
    L18:
        if (r9 == null) goto L20;
        ImageContent r2 = new ImageContent();
        r2.setImageSet(o.a(r9.translated_image_set, r4.getId()));
    L22:
        ImageTranslateProperty r10 = r2.getImageTranslateProperty();
        Map r11 = r4.getImageTranslationAbility();
        if (r11 != null) goto L25;
    L39:
        return r2;
    L25:
        if (r11.isEmpty() == true) goto L39;
        ImageSet r12 = r3.image;
        if (r12 == null) goto L33;
        Image r13 = r12.origin;
        if (r13 == null) goto L33;
        r1 = r11.get(ImSdkProxy.d().a(r13.key));
    L33:
        ImageTranslationAbility r14 = (ImageTranslationAbility) r1;
        if (r14 == null) goto L39;
        r10.setCanTranslate(r14.can_translate);
        List r15 = r14.src_language;
        if (r15 != null) goto L38;
        r15 = Collections.emptyList();
    L38:
        r10.setSrcLanguages(r15);
        goto L39
    L20:
        r2 = e(r3, r4);
        goto L22
    L12:
        Image r16 = r0.origin;
        if (r16 == null) goto L11;
        r8 = r7.get(ImSdkProxy.d().a(r16.key));
    L17:
        r9 = null;
    L21:
        r2 = e(r3, r4);
        goto L22
    }

    public static MergeForwardContent h(Entity r12, Message r13, Content r14) {
        MergeForwardContent r0 = new MergeForwardContent();
        com.bytedance.lark.pb.basic.v1.MergeForwardContent r15 = r14.merge_forward_content;
        if (r15 == null) goto L5;
        com.bytedance.lark.pb.basic.v1.Chat.Type r1 = r15.chat_type;
    L7:
        if (r1 != com.bytedance.lark.pb.basic.v1.Chat.Type.P2P) goto L9;
        Chat.Type r2 = Chat.Type.P2P;
    L10:
        r0.setType(r2);
        r13.getId();
        if (r15 != null) goto L13;
        List r3 = new ArrayList();
    L14:
        okb.h r4 = ModelParserMessage.a;
        ArrayList r5 = new ArrayList();
        if (r3 == null) goto L21;
        Iterator r6 = r3.iterator();
    L18:
        if (r6.hasNext() == false) goto L21;
        r5.add(ModelParserMessage.f(r12, (com.bytedance.lark.pb.basic.v1.Message) r6.next()));
    L21:
        if (r15 != null) goto L23;
    L25:
        boolean r7 = false;
    L26:
        r0.setCopyFromDoubao(r7);
        if (CollectionUtils.isEmpty(r5) == false) goto L30;
    L45:
        r0.setMessages(r5);
        if (r15 != null) goto L48;
        String r8 = "";
    L49:
        r0.setGroupChatName(r8);
        if (r15 != null) goto L52;
        String r9 = "";
    L53:
        r0.setP2pCreatorName(r9);
        if (r15 != null) goto L56;
        String r10 = "";
    L57:
        r0.setP2pPartnerName(r10);
        if (r15 != null) goto L60;
        String r11 = "";
    L61:
        r0.setQuasiTitle(r11);
        if (r15 != null) goto L64;
        Map r16 = new HashMap();
    L65:
        r0.setChatters(com.larksuite.framework.utils.y.b(r16, new k()));
        Chat r17 = null;
        if (r15 != null) goto L68;
        Map r18 = null;
    L69:
        r0.setReactionMap(x.c(r18));
        if (r15 != null) goto L72;
        HashMap r19 = new HashMap();
    L73:
        r0.setReactionChatterMap(r19);
        if (r15 != null) goto L76;
        Map r20 = null;
    L77:
        HashMap r21 = new HashMap();
        if (CollectionUtils.isEmpty(r20) == true) goto L93;
        Iterator r22 = r20.keySet().iterator();
    L82:
        if (r22.hasNext() == false) goto L93;
        Long r23 = (Long) r22.next();
        com.bytedance.lark.pb.basic.v1.MergeForwardContent.MessageThread r24 = (com.bytedance.lark.pb.basic.v1.MergeForwardContent.MessageThread) r20.get(r23);
        if (r24 == null) goto L82;
        MergeForwardContent.MessageThread r25 = new MergeForwardContent.MessageThread();
        r25.setReplyCount(r24.reply_count.intValue());
        r25.setLatestReplyTime(r24.latest_reply_time.longValue());
        List r26 = r24.messages;
        ArrayList r110 = new ArrayList();
        if (r26 == null) goto L92;
        Iterator r27 = r26.iterator();
    L90:
        if (r27.hasNext() == false) goto L92;
        r110.add(ModelParserMessage.f(r12, (com.bytedance.lark.pb.basic.v1.Message) r27.next()));
    L92:
        r25.setChildMessages(r110);
        r25.setReactionMap(x.c(r24.reaction_snapshots));
        r21.put(String.valueOf(r23), r25);
    L93:
        r0.setMessageThreadMap(r21);
        if (r15 != null) goto L96;
        Thread r28 = null;
    L97:
        if (r15 != null) goto L99;
        String r29 = "";
    L100:
        if (r28 == null) goto L105;
        if (TextUtils.equals(r28.channel.id, r29) == true) goto L105;
        r29 = r28.channel.id;
    L105:
        if (r15 != null) goto L107;
    L131:
        Log.i("ModelParserMessageContent", "get origin chat failed: pb merge forward content is null or chat id is empty");
        r17 = i("", Chat.Type.UNKNOWN);
    L132:
        r0.setOriginChat(r17);
        if (r28 == null) goto L142;
        r0.setThread(r28);
        r0.setSubtitle(r28.subtitle);
        r0.setFromPrivateTopic(true);
        r0.setReplyInThread(r28.is_reply_in_thread.booleanValue());
        if (r0.getOriginChat().isP2PChat() == false) goto L142;
        if (r0.getOriginChat().isMember() == false) goto L142;
        if (Long.valueOf(CastLongProtector.parseLong(r28.owner_id)).equals(r15.p2p_creator_id) == false) goto L141;
        r0.setP2pThreadCreatorName(r15.p2p_creator_name);
        r0.setP2pThreadPartnerName(r15.p2p_partner_name);
        goto L142
    L141:
        r0.setP2pThreadCreatorName(r15.p2p_partner_name);
        r0.setP2pThreadPartnerName(r15.p2p_creator_name);
    L142:
        return r0;
    L107:
        if (TextUtils.isEmpty(r29) == true) goto L131;
        Long r111 = Long.valueOf(CastLongProtector.parseLong(ImSdkProxy.e().getCurrentUserId()));     // Catch: NumberFormatException -> L112
    L114:
        com.bytedance.lark.pb.basic.v1.Chat.Type r30 = r15.chat_type;
        com.bytedance.lark.pb.basic.v1.Chat.Type r31 = com.bytedance.lark.pb.basic.v1.Chat.Type.P2P;
        if (r30 == r31) goto L117;
    L121:
        if (r12 == null) goto L125;
        Map r112 = r12.chats;
        if (r112 == null) goto L125;
        r17 = h.a((com.bytedance.lark.pb.basic.v1.Chat) r112.get(r29), null);
    L125:
        if (r17 != null) goto L132;
        Log.i("ModelParserMessageContent", "get merge forward content， origin chat is null, chat id = " + r29);
        if (r15.chat_type != r31) goto L129;
        Chat.Type r113 = Chat.Type.P2P;
    L130:
        r17 = i(r29, r113);
        goto L132
    L129:
        r113 = Chat.Type.GROUP;
        goto L130
    L117:
        if (r111.equals(r15.p2p_creator_id) == true) goto L121;
        if (r111.equals(r15.p2p_partner_id) == true) goto L121;
        r17 = i(r29, Chat.Type.P2P);
        r17.setMemberCount(2);
        r17.setUserCount(2);
    L112:
        e = move-exception;
        Log.e("ModelParserMessageContent", e);
        r111 = 0L;
        goto L114
    L99:
        r29 = String.valueOf(r15.origin_chat_id);
        goto L100
    L96:
        r28 = r15.thread;
        goto L97
    L76:
        r20 = r15.message_threads;
        goto L77
    L72:
        r19 = new HashMap(j.b(r12, null).a);
        goto L73
    L68:
        r18 = r15.reaction_snapshots;
        goto L69
    L64:
        r16 = r15.chatters;
        goto L65
    L60:
        r11 = r15.quasi_title;
        goto L61
    L56:
        r10 = r15.p2p_partner_name;
        goto L57
    L52:
        r9 = r15.p2p_creator_name;
        goto L53
    L48:
        r8 = r15.group_chat_name;
        goto L49
    L30:
        if (r13.getDisabledAction() == null) goto L45;
        Map r114 = r13.getDisabledAction();
        if (r114 == null) goto L45;
        if (CollectionUtils.isEmpty(r114) == true) goto L45;
        Iterator r32 = r5.iterator();
    L39:
        if (r32.hasNext() == false) goto L45;
        Message r33 = (Message) r32.next();
        if (r33.getDisabledAction() == null) goto L44;
        if (CollectionUtils.isEmpty(r33.getDisabledAction()) == false) goto L39;
    L44:
        r33.setDisabledAction(r114);
        goto L39
    L23:
        if (r15.is_copy_from_doubao.booleanValue() == false) goto L25;
        r7 = true;
        goto L26
    L13:
        r3 = r15.messages;
        goto L14
    L9:
        r2 = Chat.Type.GROUP;
        goto L10
    L5:
        r1 = com.bytedance.lark.pb.basic.v1.MergeForwardContent.DEFAULT_CHAT_TYPE;
        goto L7
    }

    public static ProfileContent k(Entity r2, String r3, Content r4) {
        ProfileContent r0 = new ProfileContent();
        r0.setId(r4.share_chatter_id);
        if (r2 == null) goto L22;
        Map r1 = r2.chat_chatters;
        if (r1 == null) goto L22;
        Entity.ChatChatter r5 = (Entity.ChatChatter) r1.get(r3);
        if (r5 == null) goto L10;
    L12:
        if (r5 == null) goto L22;
        Map r6 = r5.chatters;
        if (r6 == null) goto L22;
        Chatter r7 = (Chatter) r6.get(r4.share_chatter_id);
        if (r7 == null) goto L22;
        r0.setAvatarKey(r7.avatar_key);
        if (TextUtils.isEmpty(r7.name_with_another_name) == true) goto L20;
        r0.setDisplayName(r7.name_with_another_name);
    L21:
        r0.setChatterType(com.ss.android.lark.chat.entity.chatter.Chatter.ChatterType.forNumber(r7.type.getValue()));
        r0.setTenantId(r7.tenant_id);
        goto L22
    L20:
        r0.setDisplayName(r7.localized_name);
        goto L21
    L10:
        if (r2.chat_chatters.isEmpty() == true) goto L12;
        r5 = ((Entity.ChatChatter[]) r2.chat_chatters.values().toArray(new Entity.ChatChatter[0]))[0];
    L22:
        return r0;
    }

    public static RedPacketContent l(Entity r20, Content r21, String r22) {
        String r1 = ImSdkProxy.e().getCurrentUserId();
        RedPacketContent r2 = new RedPacketContent();
        HongbaoContent r3 = r21.hongbao_content;
        if (r3 != null) goto L5;
        return r2;
    L5:
        r2.setRedPacketId(r3.id);
        r2.setSubject(r3.subject);
        r2.setType(RedPacketContent.Type.Companion.valueOf(r3.type.getValue()));
        r2.setClicked(r3.clicked.booleanValue());
        r2.setExpired(r3.is_expired.booleanValue());
        r2.setGrabbed(r3.grabbed.booleanValue());
        r2.setGrabbedFinish(r3.grabbed_finish.booleanValue());
        HongbaoCover r4 = r3.cover;
        int r5 = y.a;
        if (r4 != null) goto L8;
        r1 = r1;
        RedPacketCover r6 = null;
    L48:
        r2.setCover(r6);
        r2.setCanGrab(r3.can_grab.booleanValue());
        r2.setTotalNum(r3.total_num.intValue());
        List r7 = r3.preview_user_ids;
        ArrayList r8 = new ArrayList();
        if (CollectionUtils.isNotEmpty(r7) == false) goto L68;
        if (r20 == null) goto L68;
        if (r20.chat_chatters == null) goto L68;
        Iterator r9 = r7.iterator();
    L55:
        if (r9.hasNext() == false) goto L68;
        String r10 = String.valueOf(((Long) r9.next()).longValue());
        Entity.ChatChatter r11 = (Entity.ChatChatter) r20.chat_chatters.get(r22);
        if (r11 == null) goto L66;
        Map r12 = r11.chatters;
        if (r12 == null) goto L66;
        Chatter r13 = (Chatter) r12.get(r10);
        if (r13 == null) goto L66;
        ChatterInfo r14 = new ChatterInfo();
        r14.setId(r10);
        r14.setName(r13.name);
        r14.setAvatarKey(r13.avatar_key);
        String r15 = r1;
        if (TextUtils.equals(r15, r10) == false) goto L65;
        ListProtector.add(r8, 0, r14);
    L67:
        r1 = r15;
        goto L55
    L65:
        r8.add(r14);
    L66:
        r15 = r1;
    L68:
        r2.setPreviewUsers(r8);
        return r2;
    L8:
        long r16 = r4.id.longValue();
        String r17 = r4.name;
        HongbaoCover.CoverType r18 = r4.cover_type;
        if (r18 != null) goto L11;
        int r19 = -1;
    L13:
        if (r19 != 1) goto L15;
        RedPacketCover.CoverType r23 = RedPacketCover.CoverType.CUSTOMIZE;
    L19:
        RedPacketCover.CoverType r110 = r23;
        ImageSetPassThrough r24 = r4.main_cover;
        if (r24 == null) goto L22;
        PassThroughImage r111 = y.a(r24);
    L23:
        ImageSetPassThrough r25 = r4.message_cover;
        if (r25 == null) goto L26;
        PassThroughImage r112 = y.a(r25);
    L27:
        ImageSetPassThrough r26 = r4.head_cover;
        if (r26 == null) goto L30;
        PassThroughImage r113 = y.a(r26);
    L31:
        ImageSetPassThrough r27 = r4.company_logo;
        if (r27 == null) goto L34;
        PassThroughImage r114 = y.a(r27);
    L35:
        ImageSetPassThrough r28 = r4.select_cover;
        if (r28 == null) goto L38;
        PassThroughImage r115 = y.a(r28);
    L39:
        HongbaoCover.DisplayName r29 = r4.display_name;
        if (r29 == null) goto L46;
        ImageSetPassThrough r30 = r29.background_img;
        if (r30 == null) goto L44;
        PassThroughImage r31 = y.a(r30);
    L45:
        RedPacketDisplayName r116 = new RedPacketDisplayName(r31, r29.display_name);
    L47:
        r6 = new RedPacketCover(r16, r17, r110, r111, r112, r113, r114, r115, r116, r4.company_name);
        goto L48
    L44:
        r31 = null;
        goto L45
    L46:
        r116 = null;
        goto L47
    L38:
        r115 = null;
        goto L39
    L34:
        r114 = null;
        goto L35
    L30:
        r113 = null;
        goto L31
    L26:
        r112 = null;
        goto L27
    L22:
        r111 = null;
        goto L23
    L15:
        if (r19 == 2) goto L17;
        r23 = RedPacketCover.CoverType.UNKNOWN;
        goto L19
    L17:
        r23 = RedPacketCover.CoverType.TEMPLATE;
        goto L19
    L11:
        r19 = y.a.a[r18.ordinal()];
        goto L13
    }

    public static void t(RichText r2, Entity r3, String r4) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.getElements() == null) goto L14;
        int r0 = i2.a;
        a2b.o r1 = (a2b.o) e0c.k.a(LarkContext.getApplication(), a2b.o.class);
        if (r3 != null) goto L9;
    L11:
        r1.c6(r2, r4);
        return;
    L9:
        if (CollectionUtils.isNotEmpty(r3.user_groups) == false) goto L11;
        r1.pe(r3.user_groups);
        goto L11
    }

    public static FileContent c(Content r9, String r10, Message r11, Entity r12) throws Exception {
        boolean r0 = r11.isFromMe();
        String r13 = r11.getId();
        FileContent r1 = new FileContent();
        r1.setKey(r9.key);
        r1.setName(r9.name);
        r1.setNameSpace(r9.namespace);
        r1.setSize(r9.size.longValue());
        r1.setFilePath(r9.file_path);
        r1.setInMyNutStore(r9.is_in_my_nut_store.booleanValue());
        r1.setLanTransStatus(r9.lan_trans_status.getValue());
        r1.setEncrypted(r9.is_encrypted.booleanValue());
        r1.setFileUploadId(r9.file_upload_id);
        if (TextUtils.isEmpty(r9.file_path) == true) goto L5;
    L7:
        r1.setMime(r9.mime);
        r1.setSource(r9.file_source.getValue());
        r1.setSender(r0);
        r1.setUriString(r9.file_uri);
        r1.setRiskObjectKeys(new ArrayList(r9.risk_object_keys));
        ResourceCleanScene.a r2 = ResourceCleanScene.Companion;
        Map r3 = r9.clean_resource_key_scene;
        r2.getClass();
        r1.setCleanResourceKeyScene(ResourceCleanScene.a.b(r3));
        FilePreviewStage r4 = r9.file_preview_stage;
        if (r4 == null) goto L10;
        r1.setFilePreviewStage(com.ss.android.lark.chat.entity.message.content.FilePreviewStage.fromValue(r4.getValue()));
    L10:
        Map r5 = new HashMap();
        if (r12 == null) goto L13;
        r5 = r12.preview_entities;
    L13:
        Map r6 = r9.url_preview_hang_point_map;
        int r7 = w.a;
        Intrinsics.checkNotNullParameter(r13, "messageId");
        PreviewHangPoint r14 = (PreviewHangPoint) ((LinkedHashMap) w.d(r13, r6, r5)).get("im_file");
        LinkedHashMap r8 = new LinkedHashMap();
        if (r14 == null) goto L16;
        r8.put("im_file", r14);
    L16:
        r1.setPreviewHangPoints(r8);
        Content.FileAbility r15 = r9.file_ability;
        if (r15 == null) goto L19;
        r1.setFileAbility(FileContent.FileAbility.fromValue(r15.getValue()));
    L19:
        r1.setLastUpdateTime(r9.file_last_update_time_ms.longValue());
        Long r16 = r9.file_last_update_user_id;
        if (r12 == null) goto L35;
        Map r17 = r12.chat_chatters;
        if (r17 == null) goto L35;
        if (r10 == null) goto L35;
        if (r16 == null) goto L35;
        Entity.ChatChatter r18 = (Entity.ChatChatter) r17.get(r10);
        String r19 = null;
        if (r18 != null) goto L28;
        Chatter r20 = null;
    L29:
        if (r20 == null) goto L35;
        Chatter.ChatExtra r110 = r20.chat_extra;
        if (r110 == null) goto L34;
        r19 = r110.nick_name;
    L34:
        String r21 = r20.alias;
        String r22 = r20.name;
        String r23 = r20.localized_name;
        r1.setLastUpdateChatterName(com.ss.android.lark.chat.utils.m.d(r22, r20.en_us_name, r23, r19, r21, r20.name_with_another_name, ChatterNameDisplayRule.ALIAS_NICKNAME_NAME));
        goto L35
    L28:
        r20 = (Chatter) r18.chatters.get(r16.toString());
    L35:
        return r1;
    L5:
        if (TextUtils.isEmpty(r9.cache_file_path) == true) goto L7;
        r1.setFilePath(r9.cache_file_path);
        goto L7
    }

    public static PostContent j(Entity r8, Content r9, Message r10, TranslateInfo r11) throws Exception {
        String r2 = r10.getChatId();
        String r7 = r10.getId();
        r10.getcId();
        long r4 = r10.getCreateTimeInMills();
        PostContent r12 = new PostContent();
        r12.setTitle(r9.title);
        if (CollectionUtils.isNotEmpty(r9.file_attachments) == false) goto L5;
        List r0 = r9.file_attachments;
    L6:
        r12.setAttachments(r0);
        CollectionUtils.isNotEmpty(r12.getAttachments());
        r12.setRichText(g0.e(r9.rich_text, null));
        r12.setGroupAnnouncement(r9.is_group_announcement.booleanValue());
        r12.setRiskObjectKeys(new ArrayList(r9.risk_object_keys));
        ResourceCleanScene.a r1 = ResourceCleanScene.Companion;
        Map r3 = r9.clean_resource_key_scene;
        r1.getClass();
        r12.setCleanResourceKeyScene(ResourceCleanScene.a.b(r3));
        Map r5 = r9.url_preview_hang_point_map;
        if (r5 != null) goto L9;
    L10:
        r12.setUrlPreviewList(q(r7, r9));
    L11:
        Map<String, PreviewHangPoint> r6 = r(r7, r9);
        Map r13 = new HashMap();
        if (r8 == null) goto L14;
        r13 = r8.preview_entities;
    L14:
        Map r14 = r9.url_preview_hang_point_map;
        int r15 = w.a;
        Intrinsics.checkNotNullParameter(r7, "messageId");
        Map r16 = w.d(r7, r14, r13);
        r16.putAll(r6);
        r12.setPreviewHangPoints(r16);
        x(r12.getRichText(), r12.getPreviewHangPoints());
        Lazy r17 = ImSdkMessageUtils.a;
        if (ImSdkProxy.c().a() == false) goto L17;
        u(r12.getRichText(), r2, r7, r9.typed_element_refs);
    L17:
        w(r12.getRichText(), r8);
        v(r8, r12.getRichText(), r2, r7, r4, r9.typed_element_refs);
        s(r9, r12, r7, r8);
        t(r12.getRichText(), r8, r7);
        if (r11 == null) goto L59;
        RichText r18 = r12.getRichText();
        if (r18 == null) goto L59;
        ImageTranslationInfo r19 = r11.image_translation_info;
        if (r19 == null) goto L27;
        Map r20 = r19.translated_images;
        if (r20 == null) goto L27;
    L29:
        if (r20.isEmpty() == true) goto L59;
        Map r110 = r18.getElements().getDictionary();
        if (r110 == null) goto L59;
        Iterator r21 = r18.getImageIds().iterator();
    L36:
        if (r21.hasNext() == false) goto L59;
        RichTextElement r22 = (RichTextElement) r110.get((String) r21.next());
        if (r22 == null) goto L36;
        RichTextElement.ImageProperty r23 = r22.getProperty();
        if ((r23 instanceof RichTextElement.ImageProperty) == false) goto L36;
        RichTextElement.ImageProperty r24 = r23;
        String r25 = r24.getOriginKey();
        TranslatedImage r26 = (TranslatedImage) r20.get(ImSdkProxy.d().a(r25));
        if (r26 == null) goto L36;
        ImageSet r27 = r26.translated_image_set;
        if (r27 == null) goto L36;
        Image r28 = r27.origin;
        if (r28 == null) goto L50;
        r24.setOriginKey(r28.key);
    L50:
        Image r29 = r27.middle;
        if (r29 == null) goto L53;
        r24.setMiddleKey(r29.key);
    L53:
        Image r30 = r27.thumbnail_webp;
        if (r30 != null) goto L55;
        Image r31 = r27.thumbnail;
        if (r31 == null) goto L36;
        r24.setThumbKey(r31.key);
        goto L36
    L55:
        r24.setThumbKey(r30.key);
    L27:
        r20 = new HashMap();
    L59:
        return r12;
    L9:
        if (r5.size() > 0) goto L11;
    L5:
        r0 = Collections.emptyList();
        goto L6
    }

    public static void s(Content r2, BaseTextContent r3, String r4, Entity r5) {
        Iterator r0 = ((okb.e) ImSdkProxy.f.getValue()).d().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((gya.a) r0.next()).i(r2, r3, r4, r5);
        goto L4
    }

    public static void u(RichText r33, String r34, String r35, Map<String, ElementRefs> r36) {
        if (r33 != null) goto L5;
        return;
    L5:
        if (r33.getElements() != null) goto L7;
        return;
    L7:
        if (r33.getElements().getDictionary() == null) goto L224;
        if (r36 == null) goto L225;
        ElementRefs r0 = r36.get("baike");
        if (r0 != null) goto L14;
        return;
    L14:
        if (CollectionUtils.isEmpty(r0.element_refs) == true) goto L226;
        Map r1 = r33.getElements().getDictionary();
        Iterator r2 = r1.keySet().iterator();
    L18:
        if (r2.hasNext() == false) goto L227;
        String r3 = (String) r2.next();
        RichTextElement r4 = (RichTextElement) r1.get(r3);
        if (r4 == null) goto L180;
        if ((r4.getProperty() instanceof RichTextElement.TextProperty) == false) goto L18;
        String r5 = r4.getProperty().getContent();
        if (r0.element_refs.containsKey(r3) == false) goto L18;
        Refs r6 = (Refs) r0.element_refs.get(r3);
        if (r6 == null) goto L180;
        if (com.larksuite.framework.utils.q.a(r6.refs) == true) goto L18;
        Iterator r7 = r6.refs.iterator();
    L34:
        if (r7.hasNext() == false) goto L180;
        Ref r8 = (Ref) r7.next();
        Span r9 = r8.span;
        String r10 = r8.matched_word;
        BaikeEntityMeta r11 = r8.baike_entity_meta;
        if (r11 == null) goto L34;
        if (a(r9, r10, r5) == false) goto L34;
        Map r12 = r11.allowed_typed_ids;
        if (r11.is_allow_all.booleanValue() == false) goto L45;
    L70:
        boolean r13 = true;
    L72:
        Map r14 = r11.platform_disable_option;
        if (CollectionUtils.isEmpty(r14) == true) goto L77;
        String r15 = (String) r14.get("android");
        if (TextUtils.isEmpty(r15) == true) goto L77;
        if ("*".equals(r15) == false) goto L83;
        ElementRefs r16 = r0;
        Map r17 = r1;
        Iterator r18 = r2;
        Iterator r19 = r7;
        RichTextElement r31 = r4;
        String r29 = r5;
        Ref r26 = r8;
        Span r23 = r9;
        boolean r20 = r13;
    L82:
        BaikeEntityMeta r27 = r11;
        boolean r110 = true;
    L169:
        if (r110 == false) goto L171;
        boolean r111 = false;
    L172:
        if (r111 == true) goto L174;
        String r21 = r29;
        r4 = r31;
    L179:
        r5 = r21;
        r0 = r16;
        r1 = r17;
        r2 = r18;
        r7 = r19;
        goto L34
    L174:
        if ((r31.getProperty() instanceof RichTextElement.DashedPropertyV2) == true) goto L176;
        RichTextElement.DashedPropertyV2 r22 = new RichTextElement.DashedPropertyV2();
        r22.chatId = r34;
        r22.messageId = r35;
        r21 = r29;
        r22.setContent(r21);
        r22.intervalOn = UIUtils.dp2px(LarkContext.getApplication(), 1.5f);
        r22.intervalOff = UIUtils.dp2px(LarkContext.getApplication(), 2.0f);
        r4 = r31;
        r4.setProperty(r22);
    L177:
        RichTextElement.DashedPropertyV2 r24 = r4.getProperty();
        String r25 = r27.id;
        String r28 = r26.matched_word;
        RichTextElement.DashedPropertyV2.PropertyV2 r30 = new RichTextElement.DashedPropertyV2.PropertyV2();
        Span r32 = r23;
        r30.start = r32.start.intValue();
        r30.end = r32.end.intValue();
        r30.name = r28;
        r30.id = r25;
        r24.propertyV2List.add(r30);
        goto L179
    L176:
        r21 = r29;
        r4 = r31;
        goto L177
    L171:
        r111 = r20;
        goto L172
    L83:
        String[] r112 = r15.split("\\|");
        String r113 = ApkUtil.getAppVersionName(LarkContext.getApplication());
        int r114 = r112.length;
        int r115 = 0;
    L84:
        if (r115 >= r114) goto L77;
        String[] r116 = r112[r115].split(fyb.a.COMMA);
        ArrayList r117 = new ArrayList();
        r16 = r0;
        int r37 = r116.length;
        r17 = r1;
        r18 = r2;
        int r38 = 0;
    L86:
        String r39 = "=";
        r19 = r7;
        r20 = r13;
        String[] r210 = r112;
        int r211 = r114;
        r23 = r9;
        if (r38 >= r37) goto L117;
        int r212 = r37;
        String r40 = r116[r38];
        if (TextUtils.isEmpty(r40) == false) goto L91;
        String[] r213 = r116;
    L112:
        boolean r41 = false;
    L114:
        if (r41 == false) goto L115;
        r38 = r38 + 1;
        r7 = r19;
        r13 = r20;
        r112 = r210;
        r114 = r211;
        r9 = r23;
        r37 = r212;
        r116 = r213;
        goto L86
    L115:
        r31 = r4;
        r29 = r5;
        r26 = r8;
    L78:
        r27 = r11;
        r110 = false;
        goto L169
    L91:
        r213 = r116;
        if (r40.startsWith("!=") == false) goto L95;
        r39 = "!=";
    L111:
        if ("none".equals(r39) == true) goto L112;
        r117.add(new Pair(r39, r40.substring(r39.length())));
        r41 = true;
        goto L114
    L95:
        if (r40.startsWith(">=") == false) goto L98;
        r39 = ">=";
        goto L111
    L98:
        if (r40.startsWith("<=") == false) goto L101;
        r39 = "<=";
        goto L111
    L101:
        if (r40.startsWith(">") == false) goto L104;
        r39 = ">";
        goto L111
    L104:
        if (r40.startsWith("<") == false) goto L107;
        r39 = "<";
        goto L111
    L107:
        if (r40.startsWith("=") == true) goto L111;
        r39 = "none";
        goto L111
    L117:
        int r42 = r117.size();
        int r43 = 0;
    L118:
        if (r43 >= r42) goto L166;
        Pair r118 = (Pair) ListProtector.get(r117, r43);
        int r214 = r42;
        String r44 = (String) r118.second;
        ArrayList r215 = r117;
        if (r113.contains("-") == false) goto L122;
        int r45 = 0;
        String r46 = r113.substring(0, r113.indexOf("-"));
    L124:
        if (r44.contains("-") == false) goto L126;
        r44 = r44.substring(r45, r44.indexOf("-"));
    L126:
        String[] r47 = r46.split("\\.", -1);
        String[] r48 = r44.split("\\.", -1);
        int r49 = r47.length;
        int r119 = r48.length;
        String r216 = r113;
        int r120 = Math.min(r49, r119);
        String r217 = r5;
        int r50 = 0;
    L127:
        if (r50 >= r120) goto L139;
        int r310 = r120;
        RichTextElement r311 = r4;
        if ("".equals(r47[r50]) == false) goto L131;
        int r121 = 0;
    L133:
        if ("".equals(r48[r50]) == false) goto L135;
        int r51 = 0;
    L136:
        if (r121 != r51) goto L137;
        r50 = r50 + 1;
        r120 = r310;
        r4 = r311;
        r47 = r47;
        goto L127
    L137:
        int r122 = r121 - r51;
    L141:
        if ("!=".equals(r118.first) == false) goto L145;
        if (r122 != 0) goto L164;
    L165:
        r115 = r115 + 1;
        r0 = r16;
        r1 = r17;
        r2 = r18;
        r7 = r19;
        r13 = r20;
        r112 = r210;
        r114 = r211;
        r9 = r23;
        r8 = r8;
        r11 = r11;
        r113 = r216;
        r5 = r217;
        r4 = r311;
    L164:
        r43 = r43 + 1;
        r42 = r214;
        r117 = r215;
        r8 = r8;
        r11 = r11;
        r113 = r216;
        r5 = r217;
        r4 = r311;
        goto L118
    L145:
        if (">=".equals(r118.first) == false) goto L149;
        if (r122 >= 0) goto L164;
    L149:
        if ("<=".equals(r118.first) == false) goto L153;
        if (r122 <= 0) goto L164;
    L153:
        if (">".equals(r118.first) == false) goto L157;
        if (r122 > 0) goto L164;
    L157:
        if ("<".equals(r118.first) == false) goto L161;
        if (r122 < 0) goto L164;
    L161:
        if ("=".equals(r118.first) == false) goto L165;
        if (r122 == 0) goto L164;
    L135:
        r51 = CastIntegerProtector.parseInt(r48[r50]);
        goto L136
    L131:
        r121 = CastIntegerProtector.parseInt(r47[r50]);
        goto L133
    L139:
        r311 = r4;
        r122 = r49 - r119;
        goto L141
    L122:
        r45 = 0;
        r46 = r113;
        goto L124
    L166:
        r31 = r4;
        r29 = r5;
        r26 = r8;
    L77:
        r16 = r0;
        r17 = r1;
        r18 = r2;
        r19 = r7;
        r31 = r4;
        r29 = r5;
        r26 = r8;
        r23 = r9;
        r20 = r13;
        goto L78
    L45:
        if (CollectionUtils.isEmpty(r12) == true) goto L71;
        BaikeEntityMeta.TypedIDs r123 = (BaikeEntityMeta.TypedIDs) r12.get("repo");
        if (r123 != null) goto L50;
    L57:
        BaikeEntityMeta.TypedIDs r124 = (BaikeEntityMeta.TypedIDs) r12.get("user");
        if (r124 != null) goto L60;
    L64:
        BaikeEntityMeta.TypedIDs r52 = (BaikeEntityMeta.TypedIDs) r12.get("tenant");
        if (r52 == null) goto L71;
        if (com.larksuite.framework.utils.q.a(r52.ids) == true) goto L71;
        if (r52.ids.contains(ImSdkProxy.e().getCurrentTenantId()) == false) goto L71;
    L60:
        if (com.larksuite.framework.utils.q.a(r124.ids) == true) goto L64;
        if (r124.ids.contains(ImSdkProxy.e().getCurrentUserId()) == false) goto L64;
    L50:
        if (com.larksuite.framework.utils.q.a(r123.ids) == true) goto L57;
        Iterator r125 = r123.ids.iterator();
    L53:
        if (r125.hasNext() == false) goto L57;
        String r126 = (String) r125.next();
        if (ImSdkProxy.c().b(r126) == false) goto L53;
    L71:
        r13 = false;
    L180:
        r0 = r0;
        r1 = r1;
        r2 = r2;
        goto L18
    L227:
        return;
    L226:
        return;
    L225:
        return;
    }

    public static TextContent o(String r9, String r10, Content r11, Entity r12, long r13) throws Exception {
        TextContent r0 = new TextContent();
        String r1 = r11.title;
        if (CollectionUtils.isNotEmpty(r11.file_attachments) == false) goto L5;
        List r2 = r11.file_attachments;
    L6:
        r0.setAttachments(r2);
        CollectionUtils.isNotEmpty(r0.getAttachments());
        r0.setRichText(g0.e(r11.rich_text, null));
        Map r3 = r11.url_preview_hang_point_map;
        if (r3 != null) goto L9;
    L10:
        r0.setUrlPreviewList(q(r10, r11));
    L11:
        Map<String, PreviewHangPoint> r4 = r(r10, r11);
        Map r5 = new HashMap();
        if (r12 == null) goto L24;
        r5 = r12.preview_entities;
        LruCache r6 = j6b.l.a;
        Map r7 = r12.preview_templates;
        if (r7 == null) goto L24;
        if (r7.isEmpty() == true) goto L24;
        Iterator r8 = r7.entrySet().iterator();
    L20:
        if (r8.hasNext() == false) goto L24;
        Map.Entry r14 = (Map.Entry) r8.next();
        if (r14.getValue() == null) goto L20;
        j6b.l.a.put(r14.getKey(), r14.getValue());
    L24:
        Map r15 = w.d(r10, r11.url_preview_hang_point_map, r5);
        r15.putAll(r4);
        r0.setPreviewHangPoints(r15);
        x(r0.getRichText(), r0.getPreviewHangPoints());
        Lazy r16 = ImSdkMessageUtils.a;
        if (ImSdkProxy.c().a() == false) goto L27;
        u(r0.getRichText(), r9, r10, r11.typed_element_refs);
    L27:
        w(r0.getRichText(), r12);
        v(r12, r0.getRichText(), r9, r10, r13, r11.typed_element_refs);
        s(r11, r0, r10, r12);
        t(r0.getRichText(), r12, r10);
        return r0;
    L9:
        if (r3.size() > 0) goto L11;
    L5:
        r2 = Collections.emptyList();
        goto L6
    }

    public static void v(Entity r18, RichText r19, String r20, String r21, long r22, Map<String, ElementRefs> r24) {
        if (r19 != null) goto L5;
        return;
    L5:
        if (r19.getElements() != null) goto L7;
        return;
    L7:
        if (r19.getElements().getDictionary() == null) goto L105;
        if (r18 == null) goto L13;
        Map r0 = r18.chats;
        if (r0 == null) goto L13;
        com.bytedance.lark.pb.basic.v1.Chat r1 = (com.bytedance.lark.pb.basic.v1.Chat) r0.get(r20);
    L14:
        Lazy r4 = ImSdkMessageUtils.a;
        boolean r2 = ImSdkProxy.c().isCalendarAbbrHighlightEnabled(r20, r1);
        Log.d("ModelParserMessageContent", "isCalendarAbbrHighlightEnabled : " + r2);
        if (r2 == true) goto L17;
        return;
    L17:
        if (r24 == null) goto L106;
        ElementRefs r3 = r24.get("calendar");
        if (r3 != null) goto L22;
    L78:
        Log.d("ModelParserMessageContent", "calendar ref is null! chat : " + r20 + ", msg : " + r21);
        return;
    L22:
        if (CollectionUtils.isEmpty(r3.element_refs) == true) goto L78;
        Map r5 = r19.getElements().getDictionary();
        HashSet r6 = new HashSet();
        Iterator r7 = r5.keySet().iterator();
    L26:
        if (r7.hasNext() == false) goto L107;
        String r8 = (String) r7.next();
        RichTextElement r9 = (RichTextElement) r5.get(r8);
        if (r9 == null) goto L26;
        if ((r9.getProperty() instanceof RichTextElement.TextProperty) == false) goto L26;
        String r10 = r9.getProperty().getContent();
        if (r3.element_refs.containsKey(r8) == false) goto L26;
        Refs r11 = (Refs) r3.element_refs.get(r8);
        if (r11 == null) goto L26;
        if (com.larksuite.framework.utils.q.a(r11.refs) == true) goto L26;
        Iterator r12 = r11.refs.iterator();
    L42:
        if (r12.hasNext() == false) goto L26;
        Ref r13 = (Ref) r12.next();
        Span r14 = r13.span;
        if (r14 == null) goto L42;
        if (r6.contains(r14) == true) goto L42;
        Iterator r15 = r6.iterator();
    L50:
        if (r15.hasNext() == false) goto L57;
        Span r16 = (Span) r15.next();
        ElementRefs r25 = r3;
        if ((r14.end.intValue() - 1) < r16.start.intValue()) goto L56;
        if ((r16.end.intValue() - 1) < r14.start.intValue()) goto L56;
        boolean r17 = true;
    L58:
        if (r17 == false) goto L60;
    L59:
        r6 = r6;
        r7 = r7;
    L77:
        r6 = r6;
        r3 = r25;
        r7 = r7;
        goto L42
    L60:
        r6.add(r14);
        String r23 = r13.matched_word;
        if (r13.calendar_entity_meta != null) goto L64;
        Log.d("ModelParserMessageContent", "calendar_entity_meta is null! chat : " + r20 + ", msg : " + r21);
        goto L59
    L64:
        if (a(r14, r23, r10) == false) goto L59;
        if ((r9.getCalendarAiProperty() instanceof RichTextElement.CalendarDashedProperty) == true) goto L75;
        RichTextElement.CalendarDashedProperty r26 = new RichTextElement.CalendarDashedProperty();
        r26.chatId = r20;
        r26.messageId = r21;
        r26.setContent(r10);
        r26.intervalOn = UIUtils.dp2px(LarkContext.getApplication(), 1.5f);
        r26.intervalOff = UIUtils.dp2px(LarkContext.getApplication(), 2.0f);
        if ((System.currentTimeMillis() - r22) <= TimeUnit.DAYS.toMillis(1)) goto L71;
        boolean r110 = true;
    L72:
        r26.isOver24HourAndDisableDash = r110;
        r9.setCalendarAiProperty(r26);
        goto L75
    L71:
        r110 = false;
    L75:
        if ((r9.getCalendarAiProperty() instanceof RichTextElement.CalendarDashedProperty) == false) goto L77;
        RichTextElement.CalendarDashedProperty r27 = r9.getCalendarAiProperty();
        String r28 = r13.matched_word.hashCode() + "";
        String r29 = r13.matched_word;
        CalendarEntityMeta r111 = r13.calendar_entity_meta;
        RichTextElement.CalendarDashedProperty.Property r112 = new RichTextElement.CalendarDashedProperty.Property();
        r112.start = r14.start.intValue();
        r112.end = r14.end.intValue();
        r112.name = r29;
        r112.id = r28;
        r112.extra = r111;
        r27.propertyV2List.add(r112);
    L56:
        r3 = r25;
        goto L50
    L57:
        r25 = r3;
        r17 = false;
        goto L58
    L107:
        return;
    L106:
        return;
    L13:
        r1 = null;
        goto L14
    }
}
