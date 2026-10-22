package com.ss.android.lark.chat.utils;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.TranslateUrlPreviewContext;
import com.bytedance.lark.pb.im.v1.PushMessageReadStates;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.api.service.impl.h2;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.chat.entity.message.content.CardContent;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.entity.message.content.ShareGroupChatContent;
import com.ss.android.lark.chat.entity.message.content.TextContent;
import com.ss.android.lark.chat.entity.translate.TranslateInfo;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.preview.entity.component.property.PreviewHeaderProperty;
import com.ss.android.lark.chat.preview.entity.component.property.TextViewProperty;
import com.ss.android.lark.export.entity.ExtTranslateInfo;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlPreviewBody;
import com.ss.android.lark.export.entity.preview.UrlPreviewComponent;
import com.ss.android.lark.export.entity.preview.UrlPreviewState;
import com.ss.android.lark.export.entity.preview.UrlPreviewTemplate;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h0 {
    public static final w4b.d0 a = null;

    static {
        a = ChatCoreModule.a().getSettingDependency();
    }

    public static String d(f5b.b r5) {
        if (r5 != null) goto L6;
        Log.w("MessageInfoUtils", "getMessageTranslateCacheKey message is null");
        return BuildConfig.FLAVOR;
    L6:
        Message r2 = r5.getMessage();
        if (r2 == null) goto L22;
        Message.Type r3 = r2.getType();
        Message.Type r4 = Message.Type.AUDIO;
        if (r3 != r4) goto L22;
        if (r2.getType() != r4) goto L17;
        AudioContent r6 = (AudioContent) r2.getContent();
        if (r6.isNeedHideText() == true) goto L17;
        if (TextUtils.isEmpty(r6.getRecognizedText()) == true) goto L17;
        boolean r7 = true;
    L18:
        if (r7 == true) goto L22;
        Log.w("MessageInfoUtils", "audio message text not shown, translateCacheKey is null");
        return BuildConfig.FLAVOR;
    L17:
        r7 = false;
    L22:
        return r5.getId() + "_" + r2.getContentVersion();
    }

    public static String e(Message r3) {
        if (r3 != null) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        if (r3.getType() != Message.Type.SHARE_GROUP_CHAT) goto L13;
        ShareGroupChatContent r4 = (ShareGroupChatContent) r3.getContent();
        if (r4 != null) goto L10;
        return BuildConfig.FLAVOR;
    L10:
        if (r4.getChat() != null) goto L12;
        return BuildConfig.FLAVOR;
    L12:
        return UIHelper.mustacheFormat(2131892219, "chat_name", r4.getChat().getName());
    L13:
        return BuildConfig.FLAVOR;
    }

    public static Message f(MessageInfo r3) {
        Message r0 = r3.getMessage();
        if (r0 != null) goto L5;
        return r0;
    L5:
        TranslateInfo r4 = r3.getTranslateInfo();
        if (r4 != null) goto L8;
        return null;
    L8:
        if (Objects.equals(r0.getTranslateLanguage(), r4.getLanguage()) == true) goto L10;
        return null;
    L10:
        if (r4.getTranslateContent() == null) goto L18;
        Message r1 = r0.clone();
        if (r1 == null) goto L19;
        r1.setMessageContent(r4.getTranslateContent());
        return r1;
    L19:
        return null;
    L18:
        return null;
    }

    public static boolean j(Message r3) {
        if (ChatCoreModule.a().getFeatureConfigDependency().b() == true) goto L6;
        return false;
    L6:
        if (r3.getType() == Message.Type.AUDIO) goto L9;
        return false;
    L9:
        if ((r3.getContent() instanceof AudioContent) == false) goto L23;
        AudioContent r4 = (AudioContent) r3.getContent();
        if (ChatCoreModule.a().getFeatureGatingDependency().isEnable("ai.translate.message.audio") == true) goto L13;
        return false;
    L13:
        if (r4 != null) goto L15;
    L19:
        boolean r5 = false;
    L20:
        if (r5 == false) goto L25;
        return true;
    L25:
        return false;
    L15:
        if (r4.isNeedHideText() == true) goto L19;
        if (TextUtils.isEmpty(r4.getRecognizedText()) == true) goto L19;
        r5 = true;
        goto L20
    L23:
        return false;
    }

    public static boolean k(Message r4) {
        if (ChatCoreModule.a().getFeatureGatingDependency().isEnable("messagecard.translate.support") == true) goto L5;
        return false;
    L5:
        boolean r0 = ChatCoreModule.a().getFeatureGatingDependency().isEnable("messagecard.translate.force_enable_translate");
        if (r4.getType() == Message.Type.CARD) goto L9;
        return false;
    L9:
        if ((r4.getContent() instanceof CardContent) == false) goto L24;
        CardContent r5 = (CardContent) r4.getContent();
        if (r5.getExtraInfo() != null) goto L13;
    L14:
        if (r0 == true) goto L17;
        return false;
    L17:
        if (r5.getType() == CardContent.Type.TEXT) goto L20;
        return false;
    L20:
        if (r5.getCardVersion() >= 2) goto L22;
        return false;
    L22:
        return true;
    L13:
        if (r5.getExtraInfo().getEnableTranslate() == true) goto L17;
    L24:
        return false;
    }

    public static boolean m(Message r5) {
        if (r5.getTranslateDisplayRule() != 1) goto L5;
    L7:
        boolean r0 = false;
    L9:
        if (r5.getType() != Message.Type.CARD) goto L14;
        if (k(r5) == false) goto L18;
        return r0;
    L18:
        if (r0 == true) goto L20;
        return false;
    L20:
        if (TextUtils.isEmpty(r5.getTranslateLanguage()) == true) goto L24;
        return true;
    L24:
        return false;
    L14:
        if (r5.getType() != Message.Type.AUDIO) goto L18;
        if (j(r5) == false) goto L18;
        return r0;
    L5:
        if (r5.getTranslateDisplayRule() == 0) goto L7;
        r0 = true;
        goto L9
    }

    public static boolean n(f5b.b r3) {
        int r0 = r3.getMessage().getTranslateDisplayRule();
        String r1 = r3.getMessage().getTranslateLanguage();
        TranslateInfo r4 = r3.getTranslateInfo();
        if (r0 == 1) goto L9;
        if (r0 == 0) goto L9;
        if (TextUtils.isEmpty(r1) == true) goto L9;
        if (r4 == null) goto L9;
        return true;
    L9:
        return false;
    }

    public static Map<String, PreviewHangPoint> p(Map<String, PreviewHangPoint> r15) {
        HashMap r0 = new HashMap();
        Iterator<Map.Entry<String, PreviewHangPoint>> r16 = r15.entrySet().iterator();
    L4:
        if (r16.hasNext() == false) goto L10;
        PreviewHangPoint r1 = r16.next().getValue();
        if (r1 == null) goto L4;
        if (r1.getUrlCardPreviewEntity() == null) goto L4;
        UrlCardPreviewEntity r2 = r1.getUrlCardPreviewEntity();
        UrlInlinePreviewEntity r3 = r2.getInlineEntity();
        UrlCardPreviewEntity r14 = new UrlCardPreviewEntity(new UrlInlinePreviewEntity.Builder().sourceId(r3.getSourceId()).previewId(r3.getPreviewId()).netIconKey(r3.getNetIconKey()).title(r3.getTitle()).netUrlTag(r3.getNetUrlTag()).version(r3.getVersion()).udIcon(r3.getUdIcon()).needReload(r3.getNeedReload()).isSdkPreview(r3.isSdkPreview()).passThroughImage(r3.getPassThroughImage()).useColorIcon(r3.getUseColorIcon()).headerInfo(r3.getHeaderInfo()).build(), null, null, r2.getComponentTreeTime());
        r0.put(r1.getHangPointId(), new PreviewHangPoint(r1.getUrl(), r1.getHangPointId(), r1.getMessageId(), r1.getPreviewId(), r1.getNeedLocalPreview(), r1.isLazyLoad(), r1.getSendScene(), r14));
        goto L4
    L10:
        return r0;
    }

    public static boolean c(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L9:
        Log.e("MessageInfoUtils", "chat id is not match: current chat id is: " + r2 + ", push chat id is: " + r3);
        return false;
    L5:
        if (r2.equals(r3) == false) goto L9;
        return true;
    }

    public static void h(Content r3, Map<String, PreviewHangPoint> r4) {
        if (r3 == null) goto L41;
        if (r4 == null) goto L45;
        boolean r0 = r3 instanceof TextContent;
        if (r0 == false) goto L8;
    L24:
        if (r0 == false) goto L27;
        com.ss.android.lark.parser.internal.r.x(((TextContent) r3).getRichText(), r4);
        return;
    L27:
        if ((r3 instanceof PostContent) == false) goto L44;
        com.ss.android.lark.parser.internal.r.x(((PostContent) r3).getRichText(), r4);
        return;
    L44:
        return;
    L8:
        if ((r3 instanceof PostContent) == true) goto L24;
        if ((r3 instanceof MergeForwardContent) == false) goto L42;
        Iterator<Message> r5 = ((MergeForwardContent) r3).getMessages().iterator();
    L14:
        if (r5.hasNext() == false) goto L46;
        Content r1 = r5.next().getContent();
        boolean r2 = r1 instanceof TextContent;
        if (r2 == true) goto L19;
        if ((r1 instanceof PostContent) == false) goto L14;
    L19:
        if (r2 == true) goto L20;
        if ((r1 instanceof PostContent) == false) goto L14;
        com.ss.android.lark.parser.internal.r.x(((PostContent) r1).getRichText(), r4);
        goto L14
    L20:
        com.ss.android.lark.parser.internal.r.x(((TextContent) r1).getRichText(), r4);
        goto L14
    L46:
        return;
    L42:
        return;
    L45:
        return;
    }

    public static boolean l(Content r2, String r3) {
        if ((r2 instanceof BaseTextContent) == false) goto L13;
        RichText r4 = ((BaseTextContent) r2).getRichText();
        if (r4 == null) goto L13;
        RichTextElement r5 = (RichTextElement) r4.getElements().getDictionary().get(r3);
        if (r5 != null) goto L9;
        return false;
    L9:
        RichTextElement.AnchorProperty r6 = r5.getProperty();
        if ((r6 instanceof RichTextElement.AnchorProperty) == false) goto L13;
        return r6.isCustom();
    L13:
        return false;
    }

    public static boolean a(Content r11, Map<String, PreviewHangPoint> r12, String r13) {
        if ((r11 instanceof TextContent) == false) goto L5;
    L6:
        Iterator<PreviewHangPoint> r14 = r12.values().iterator();
    L8:
        if (r14.hasNext() == false) goto L110;
        PreviewHangPoint r0 = r14.next();
        if (r0 == null) goto L8;
        boolean r1 = l(r11, r0.getHangPointId());
        UrlCardPreviewEntity r2 = r0.getUrlCardPreviewEntity();
        if (r1 == true) goto L8;
        if (r2 == null) goto L8;
        PreviewHangPoint r3 = h2.a.get(Integer.valueOf(h2.a(r0, r13)));
        if (r3 == null) goto L67;
        HashMap r4 = new HashMap();
        r4.put(r3.getHangPointId(), r3);
        h(r11, r4);
        if (ChatCoreModule.a().getFeatureGatingDependency().isEnable("im.messenger.url_card_header_translate") == false) goto L8;
        UrlCardPreviewEntity r5 = r3.getUrlCardPreviewEntity();
        if (r5 == null) goto L23;
        String r6 = r5.getInlineEntity().getTitle();
        if (r6 == null) goto L26;
        Log.w("MessageInfoUtils", "apply translate " + r2.getInlineEntity().getPreviewId());
        int r7 = h6b.h.a;
        Intrinsics.checkNotNullParameter(r2, "urlCardPreviewEntity");
        Intrinsics.checkNotNullParameter(r6, "inlineTranslation");
        ExtTranslateInfo r8 = r2.getExtTranslateInfo();
        if (r8 == null) goto L8;
        String r9 = r8.getInlineReplacementElementId();
        if (r9 == null) goto L8;
        UrlPreviewBody r10 = r2.getPreviewBody();
        if (r10 == null) goto L8;
        Map<String, UrlPreviewState> r15 = r10.getStates();
        TextViewProperty r16 = null;
        PreviewHeaderProperty r17 = null;
        if (r15 == null) goto L38;
        UrlPreviewState r18 = r15.get(r10.getCurrentStateId());
    L39:
        HashMap<String, UrlPreviewTemplate> r19 = r10.getTemplates();
        if (r18 == null) goto L42;
        String r20 = r18.getTemplateId();
    L43:
        UrlPreviewTemplate r21 = r19.get(r20);
        if (r21 == null) goto L8;
        Map<String, UrlPreviewComponent> r22 = r21.getElements();
        if (r22 == null) goto L66;
        UrlPreviewComponent r23 = r22.get(r9);
        if (r23 == null) goto L66;
        int r24 = h6b.h.a.a[r23.getType().ordinal()];
        if (r24 != 1) goto L54;
        Log.i("UrlPreviewTranslateUtil", "apply translate to type: " + r23.getType() + ", id: " + r9 + ", previewId: " + r2.getInlineEntity().getPreviewId());
        BaseProperty r25 = r23.getProperty();
        if ((r25 instanceof PreviewHeaderProperty) == false) goto L64;
        r17 = (PreviewHeaderProperty) r25;
    L64:
        if (r17 == null) goto L8;
        r17.setTitle(r6);
        goto L8
    L54:
        if (r24 != 2) goto L55;
        Log.i("UrlPreviewTranslateUtil", "apply translate to type: " + r23.getType() + ", id: " + r9 + ", previewId: " + r2.getInlineEntity().getPreviewId());
        BaseProperty r26 = r23.getProperty();
        if ((r26 instanceof TextViewProperty) == false) goto L59;
        r16 = (TextViewProperty) r26;
    L59:
        if (r16 == null) goto L8;
        r16.setText(r6);
        goto L8
    L55:
        Log.w("UrlPreviewTranslateUtil", "element type not supported: " + r23.getType() + ", id: " + r9 + ", previewId: " + r2.getInlineEntity().getPreviewId());
    L66:
        Log.w("UrlPreviewTranslateUtil", "element not found, id: " + r9 + ", previewId: " + r2.getInlineEntity().getPreviewId());
        goto L8
    L42:
        r20 = null;
        goto L43
    L38:
        r18 = null;
        goto L39
    L26:
        Log.w("MessageInfoUtils", "translated title not found " + r3.getPreviewId());
        goto L8
    L23:
        Log.w("MessageInfoUtils", "translated entity not found " + r3.getPreviewId());
        goto L8
    L67:
        return true;
    L110:
        return false;
    L5:
        if ((r11 instanceof PostContent) == true) goto L6;
        return false;
    }

    public static void o(String r7, PushMessageReadStates r8, aqb.h r9) {
        if (c(r7, r8.chat_id) == true) goto L5;
        return;
    L5:
        Map r10 = r8.read_states;
        Map r11 = r8.read_states_extra;
        HashSet r0 = new HashSet();
        if (CollectionUtils.isNotEmpty(r10) == false) goto L9;
        r0.addAll(r10.keySet());
    L9:
        if (CollectionUtils.isNotEmpty(r11) == false) goto L11;
        r0.addAll(r11.keySet());
    L11:
        Iterator r1 = r0.iterator();
    L13:
        if (r1.hasNext() == false) goto L30;
        String r2 = (String) r1.next();
        Log.i("MessageInfoUtils", "onPushReadStateMessage: " + r2);
        MessageInfo r3 = r9.p(r2);
        if (r3 != null) goto L16;
        Log.i("MessageInfoUtils", "onPushReadStateMessage: message not found!");
        goto L13
    L16:
        if (r10 != null) goto L18;
    L20:
        if (r11 != null) goto L22;
    L28:
        r9.q(r3);
        goto L13
    L22:
        if (r11.get(r2) == null) goto L28;
        PushMessageReadStates.ReadStatesExtra r4 = (PushMessageReadStates.ReadStatesExtra) r11.get(r2);
        Message r5 = r3.getMessage();
        if (r4.me_read.booleanValue() == false) goto L26;
        int r6 = 2;
    L27:
        r5.setMeReadType(r6);
        Log.i("MessageInfoUtils", "onPushReadStateMessage, ReadStatesExtra, " + r2);
        goto L28
    L26:
        r6 = 0;
        goto L27
    L18:
        if (r10.get(r2) == null) goto L20;
        PushMessageReadStates.ReadStates r12 = (PushMessageReadStates.ReadStates) r10.get(r2);
        r3.getMessage().setReadCount(r12.read_count.intValue());
        r3.getMessage().setUnReadCount(r12.unread_count.intValue());
        r3.getMessage().setReadAtChatterIds(r12.read_at_chatter_ids);
        Log.i("MessageInfoUtils", "onPushReadStateMessage, ReadStates, " + r2);
        goto L20
    }

    public static void b(Map<String, PreviewHangPoint> r4, String r5, Map<String, TranslateUrlPreviewContext> r6, Message r7) {
        Iterator<Map.Entry<String, PreviewHangPoint>> r8 = r4.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L9;
        PreviewHangPoint r0 = r8.next().getValue();
        String r1 = r0.getHangPointId();
        boolean r2 = l(r7.getContent(), r1);
        UrlCardPreviewEntity r3 = r0.getUrlCardPreviewEntity();
        if (r2 == true) goto L4;
        if (r3 == null) goto L4;
        UrlInlinePreviewEntity r9 = r3.getInlineEntity();
        TranslateUrlPreviewContext r10 = new TranslateUrlPreviewContext.Builder().preview_id(r9.getPreviewId()).title(r9.getTitle()).tag(r9.getNetUrlTag()).target_language(r5).is_sdk_preview(Boolean.valueOf(r9.isSdkPreview())).build();
        ((HashMap) r6).put(r1, r10);
        goto L4
    }

    public static void g(Map<String, f5b.b> r4, String r5, Map<String, TranslateUrlPreviewContext> r6, Map<String, Map<String, PreviewHangPoint>> r7) {
        Iterator<Map.Entry<String, f5b.b>> r8 = r4.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L21;
        f5b.b r0 = r8.next().getValue();
        Message.Type r1 = r0.getMessage().getType();
        if (r1 == Message.Type.TEXT) goto L20;
        if (r1 == Message.Type.POST) goto L20;
        if (r1 != Message.Type.MERGE_FORWARD) goto L4;
        Iterator<Message> r2 = ((MergeForwardContent) r0.getMessage().getContent()).getMessages().iterator();
    L14:
        if (r2.hasNext() == false) goto L4;
        Message r3 = r2.next();
        if (r3.getType() == Message.Type.TEXT) goto L19;
        if (r3.getType() != Message.Type.POST) goto L14;
    L19:
        i(r3.getContent(), r7, r3, r5, r6);
    L20:
        i(r0.getMessage().getContent(), r7, r0.getMessage(), r5, r6);
        goto L4
    }

    public static void i(Content r2, Map<String, Map<String, PreviewHangPoint>> r3, Message r4, String r5, Map<String, TranslateUrlPreviewContext> r6) {
        if ((r2 instanceof TextContent) == false) goto L8;
        Map<String, PreviewHangPoint> r7 = ((TextContent) r2).getPreviewHangPoints();
        if (CollectionUtils.isEmpty(r7) == true) goto L13;
        HashMap r8 = (HashMap) r3;
        r8.put(r4.getId(), p(r7));
        b(r7, r5, r6, r4);
        return;
    L13:
        return;
    L8:
        if ((r2 instanceof PostContent) == false) goto L15;
        Map<String, PreviewHangPoint> r9 = ((PostContent) r2).getPreviewHangPoints();
        if (CollectionUtils.isEmpty(r9) == true) goto L16;
        HashMap r10 = (HashMap) r3;
        r10.put(r4.getId(), p(r9));
        b(r9, r5, r6, r4);
        return;
    L16:
        return;
    }
}
