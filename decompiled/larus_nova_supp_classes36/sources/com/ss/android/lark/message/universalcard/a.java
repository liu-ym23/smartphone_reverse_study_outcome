package com.ss.android.lark.message.universalcard;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larksuite.component.card.protocol.CardActionDataSource;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.CardData;
import com.larksuite.component.card.protocol.CardDataSource;
import com.larksuite.component.card.protocol.context.CardStyle;
import com.larksuite.component.card.protocol.data.CardAttachment;
import com.larksuite.component.card.protocol.data.CardTranslateInfo;
import com.larksuite.component.card.protocol.data.ComponentStatus;
import com.larksuite.component.card.protocol.data.StreamingConfig;
import com.larksuite.component.card.protocol.data.action.ActionInfo;
import com.larksuite.component.card.protocol.data.action.ActionStatus;
import com.larksuite.component.card.protocol.data.action.CardActionDependencyData;
import com.larksuite.component.card.protocol.data.at.AtProperty;
import com.larksuite.component.card.protocol.data.media.AudioInfo;
import com.larksuite.component.card.protocol.data.media.VideoInfo;
import com.larksuite.component.card.protocol.data.media.VisitInfo;
import com.larksuite.component.card.protocol.data.options.OptionUser;
import com.larksuite.component.card.protocol.data.person.Character;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.base.view.vo.message.f;
import com.ss.android.lark.chat.entity.message.content.CardContent;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.message.lynxcard.entity.LynxCardContentVO;
import com.ss.android.lark.message.lynxcard.message.d;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.richtext.Image;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import v5b.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.ss.android.lark.message.universalcard.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0184a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[CardContent.DataSource.values().length];
            r0[CardContent.DataSource.IM_CONTENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            r0[CardContent.DataSource.IM_ENTITY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L24:
            r0[CardContent.DataSource.CARD_ENTITY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L20:
            r0[CardContent.DataSource.STREAMING_ENTITY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L7:
            a = r0;
            int[] r1 = new int[CardContent.StreamingConfig.PrintStrategy.values().length];
            r1[CardContent.StreamingConfig.PrintStrategy.DELAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L9:
            b = r1;
        }
    }

    static {
    }

    public static com.larksuite.component.card.protocol.data.CardContent b(CardContent r26) {
        if (r26 != null) goto L5;
        return null;
    L5:
        CardAttachment r0 = new CardAttachment();
        if (r26.getDslJsonAttachment() == null) goto L105;
        CardContent.JsonAttachment r2 = r26.getDslJsonAttachment();
        CardAttachment r3 = new CardAttachment();
        if (r2 == null) goto L104;
        HashMap r4 = r2.getAtUsers();
        if (CollectionUtils.isNotEmpty(r4) == false) goto L38;
        if (r4 == null) goto L38;
        HashMap r5 = new HashMap(r4.size());
        Iterator r6 = r4.keySet().iterator();
    L15:
        if (r6.hasNext() == false) goto L36;
        String r1 = (String) r6.next();
        RichTextElement.AtProperty r7 = (RichTextElement.AtProperty) r4.get(r1);     // Catch: Exception -> L34
        AtProperty r8 = new AtProperty();     // Catch: Exception -> L34
        if (r7 == null) goto L20;
        String r9 = r7.getUserId();     // Catch: Exception -> L34
    L21:
        r8.setUserId(r9);     // Catch: Exception -> L34
        if (r7 == null) goto L24;
        String r10 = r7.getContent();     // Catch: Exception -> L34
    L25:
        r8.setContent(r10);     // Catch: Exception -> L34
        boolean r11 = false;
        if (r7 == null) goto L28;
        boolean r12 = r7.isOutChatUser();     // Catch: Exception -> L34
    L29:
        r8.setOutChatUser(r12);     // Catch: Exception -> L34
        if (r7 == null) goto L32;
        r11 = r7.isAnonymous();     // Catch: Exception -> L34
    L32:
        r8.setAnonymous(r11);     // Catch: Exception -> L34
        r5.put(r1, r8);     // Catch: Exception -> L34
        goto L15
    L28:
        r12 = false;
        goto L29
    L24:
        r10 = null;
        goto L25
    L20:
        r9 = null;
    L34:
        e = move-exception;
        Log.e("ModelParseCardData_[MessageCard]", "transform AtProperty failed", e);
        goto L15
    L36:
        r3.setAtUsers(r5);
    L38:
        if (CollectionUtils.isNotEmpty(r2.getImages()) == false) goto L51;
        HashMap r13 = r2.getImages();
        if (r13 == null) goto L51;
        HashMap r14 = new HashMap(r13.size());
        Iterator r15 = r13.keySet().iterator();
    L43:
        if (r15.hasNext() == false) goto L49;
        String r16 = (String) r15.next();
        r14.put(r16, c((RichTextElement.ImageProperty) r13.get(r16)));     // Catch: Exception -> L47
    L47:
        e = move-exception;
        Log.e("ModelParseCardData_[OPCard]", "transform ImageProperty failed", e);
        goto L43
    L49:
        r3.setImages(r14);
    L51:
        if (CollectionUtils.isNotEmpty(r2.getOptionUsers()) == false) goto L61;
        HashMap r17 = r2.getOptionUsers();
        if (r17 == null) goto L61;
        HashMap r18 = new HashMap(r17.size());
        Iterator r19 = r17.keySet().iterator();
    L56:
        if (r19.hasNext() == false) goto L60;
        String r20 = (String) r19.next();
        CardContent.JsonAttachment.OptionUser r21 = (CardContent.JsonAttachment.OptionUser) r17.get(r20);
        if (r21 == null) goto L56;
        r18.put(r20, new OptionUser(r21.getUserId(), r21.getContent(), r21.getAvatarKey()));
        goto L56
    L60:
        r3.setOptionUsers(r18);
    L61:
        r3.setSummary(r2.getSummary());
        if (CollectionUtils.isNotEmpty(r2.getPersonMap()) == false) goto L75;
        r3.setCharacters(new HashMap());
        r3.setCharacters(new HashMap());
        HashMap r22 = r2.getPersonMap();
        if (r22 == null) goto L75;
        HashMap r23 = new HashMap(r22.size());
        Iterator r24 = r22.keySet().iterator();
    L67:
        if (r24.hasNext() == false) goto L71;
        String r25 = (String) r24.next();
        CardContent.JsonAttachment.Person r27 = (CardContent.JsonAttachment.Person) r22.get(r25);
        if (r27 == null) goto L67;
        r23.put(r25, new Character(Integer.valueOf(r27.getType()), r27.getPersonID(), r27.getContent(), r27.getAvatarKey()));
        goto L67
    L71:
        HashMap r28 = r3.getCharacters();
        if (r28 == null) goto L75;
        r28.putAll(r23);
    L75:
        if (CollectionUtils.isNotEmpty(r2.getAudioInfoMap()) == false) goto L90;
        r3.setAudios(new HashMap());
        HashMap r29 = r2.getAudioInfoMap();
        HashMap r30 = new HashMap(r29.size());
        Iterator r31 = r29.keySet().iterator();
    L78:
        if (r31.hasNext() == false) goto L86;
        String r32 = (String) r31.next();
        CardContent.JsonAttachment.AudioInfo r33 = (CardContent.JsonAttachment.AudioInfo) r29.get(r32);
        if (r33 == null) goto L78;
        CardContent.JsonAttachment.VisitInfo r34 = r33.getVisitInfo();
        if (r34 == null) goto L84;
        VisitInfo r210 = new VisitInfo(r34.getSceneType(), r34.getEntityType(), r34.getEntityId(), r34.getInnerMsgId(), r34.getAuthFileKey(), r34.getImExt(), r34.getExt());
    L85:
        r30.put(r32, new AudioInfo(r33.getKey(), r33.getDuration(), r33.getSize(), r210));
        goto L78
    L84:
        r210 = null;
        goto L85
    L86:
        HashMap r35 = r3.getAudios();
        if (r35 == null) goto L90;
        r35.putAll(r30);
    L90:
        if (CollectionUtils.isNotEmpty(r2.getVideoInfoMap()) == false) goto L104;
        r3.setVideos(new HashMap());
        HashMap r36 = r2.getVideoInfoMap();
        HashMap r37 = new HashMap(r36.size());
        Iterator r38 = r36.keySet().iterator();
    L93:
        if (r38.hasNext() == false) goto L101;
        String r39 = (String) r38.next();
        CardContent.JsonAttachment.VideoInfo r40 = (CardContent.JsonAttachment.VideoInfo) r36.get(r39);
        if (r40 == null) goto L93;
        CardContent.JsonAttachment.VisitInfo r41 = r40.getVisitInfo();
        if (r41 == null) goto L99;
        VisitInfo r211 = new VisitInfo(r41.getSceneType(), r41.getEntityType(), r41.getEntityId(), r41.getInnerMsgId(), r41.getAuthFileKey(), r41.getImExt(), r41.getExt());
    L100:
        r37.put(r39, new VideoInfo(r40.getKey(), r40.getDuration(), r40.getSize(), r40.getUrl(), r40.getMime(), r211));
        goto L93
    L99:
        r211 = null;
        goto L100
    L101:
        HashMap r42 = r3.getVideos();
        if (r42 == null) goto L104;
        r42.putAll(r37);
    L104:
        r0 = r3;
    L105:
        String r43 = r26.getDslJsonString();
        if (r43 != null) goto L110;
        r43 = "";
    L110:
        return new com.larksuite.component.card.protocol.data.CardContent(r43, r0);
    }

    public static RichTextElement.ImageProperty c(RichTextElement.ImageProperty r5) throws Exception {
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
        if (r5 == null) goto L15;
        String r4 = r5.getIntactKey();
        if (r4 == null) goto L15;
        r0.setIntactKey(r4);
    L15:
        if (r5 == null) goto L18;
        r2 = r5.getOriginKey();
    L18:
        r0.setOriginKey(r2);
        boolean r6 = false;
        if (r5 == null) goto L21;
        int r7 = r5.getOriginWidth();
    L22:
        r0.setOriginWidth(r7);
        if (r5 == null) goto L25;
        int r8 = r5.getOriginHeight();
    L26:
        r0.setOriginHeight(r8);
        if (r5 == null) goto L29;
        int r9 = r5.getCustomWidth();
    L30:
        r0.setCustomWidth(r9);
        if (r5 == null) goto L33;
        boolean r10 = r5.isNeedCopy();
    L34:
        r0.setNeedCopy(r10);
        ResourceCleanScene r11 = null;
        if (r5 == null) goto L37;
        Image r12 = r5.getMiddleImage();
    L38:
        r0.setMiddleImage(r12);
        if (r5 == null) goto L41;
        Image r13 = r5.getThumbImage();
    L42:
        r0.setThumbImage(r13);
        if (r5 == null) goto L45;
        String r14 = r5.getFsUnit();
    L46:
        r0.setFsUnit(r14);
        if (r5 == null) goto L49;
        ByteString r15 = r5.getCrypto();
    L50:
        r0.setCrypto(r15);
        if (r5 == null) goto L53;
        String r16 = r5.getMiddleKey();
    L54:
        r0.setMiddleKey(r16);
        if (r5 == null) goto L57;
        String r17 = r5.getThumbKey();
    L58:
        r0.setThumbKey(r17);
        if (r5 == null) goto L61;
        String r18 = r5.getAlt();
    L62:
        r0.setAlt(r18);
        if (r5 == null) goto L65;
        String r19 = r5.getAltI18nKey();
    L66:
        r0.setAltI18nKey(r19);
        if (r5 != null) goto L69;
    L71:
        r0.setImgCanPreview(r6);
        if (r5 == null) goto L74;
        r5.isOriginSource();
        r0.setOriginSource(r5.isOriginSource());
    L74:
        if (r5 == null) goto L76;
        r5.getOriginSize();
        r0.setOriginSize(r5.getOriginSize());
    L76:
        if (r5 == null) goto L78;
        r5.getShowMode();
        r0.setShowMode(r5.getShowMode());
    L78:
        if (r5 == null) goto L80;
        ByteString r20 = r5.getInlinePreview();
    L81:
        if (r20 == null) goto L83;
        r0.setInlinePreview(r5.getInlinePreview());
    L83:
        if (r5 == null) goto L85;
        r11 = r5.getResourceCleanScene();
    L85:
        r0.setResourceCleanScene(r11);
        return r0;
    L80:
        r20 = null;
        goto L81
    L69:
        if (r5.isImgCanPreview() != true) goto L71;
        r6 = true;
        goto L71
    L65:
        r19 = null;
        goto L66
    L61:
        r18 = null;
        goto L62
    L57:
        r17 = null;
        goto L58
    L53:
        r16 = null;
        goto L54
    L49:
        r15 = null;
        goto L50
    L45:
        r14 = null;
        goto L46
    L41:
        r13 = null;
        goto L42
    L37:
        r12 = null;
        goto L38
    L33:
        r10 = false;
        goto L34
    L29:
        r9 = 0;
        goto L30
    L25:
        r8 = 0;
        goto L26
    L21:
        r7 = 0;
        goto L22
    L9:
        r3 = r5.getToken();
        goto L10
    L5:
        r1 = r5.getUrls();
        goto L6
    }

    public static CardData d(CardContent r9, f r10, String r11, boolean r12, boolean r13, String r14) {
        Intrinsics.checkNotNullParameter(r9, "messageCardContent");
        Intrinsics.checkNotNullParameter(r14, "renderType");
        com.larksuite.component.card.protocol.data.CardContent r0 = b(r9);
        String r1 = r9.getMessageId();
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        StreamingConfig r2 = null;
        if (r10 == null) goto L11;
        String r3 = r10.b;
        if (r3 == null) goto L11;
        CardTranslateInfo r4 = new CardTranslateInfo(r3, r14);
    L12:
        CardData.a.a r15 = new CardData.a.a();
        Intrinsics.checkNotNullParameter(r1, "cardID");
        r15.a = r1;
        r15.b = r9.getUniversalCardID();
        r15.c = String.valueOf(r9.getContentVersion());
        r15.d = r9.getUniversalCardVersion();
        r15.e = r0;
        if (r10 == null) goto L15;
        CardContent r16 = (CardContent) ((v5b.a) r10).a;
    L16:
        r15.f = b(r16);
        r15.h = r4;
        r15.g = new ComponentStatus(r11);
        r15.j = r9.isStreamingMode();
        CardContent.StreamingConfig r17 = r9.getStreamingConfig();
        if (r17 != null) goto L19;
    L23:
        r15.k = r2;
        CardContent.JsonAttachment r18 = r9.getDslJsonAttachment();
        HashMap r5 = r9.getComponentStatusByActionId();
        HashMap r6 = new HashMap();
        if (r18 == null) goto L28;
        HashMap r19 = r18.getComponentStatusByName();
        if (r19 == null) goto L28;
        r6.putAll(r19);
    L28:
        r15.i = new ActionInfo(new ActionStatus(r6, r5), r12, r13, LarkContext.getApplication().getString(2131892336), 0, "");
        CardContent.DataSource r110 = r9.getDataSource();
        int[] r111 = C0184a.a;
        int r112 = r111[r110.ordinal()];
        if (r112 == 1) goto L37;
        if (r112 == 2) goto L36;
        if (r112 == 3) goto L35;
        if (r112 == 4) goto L34;
        CardDataSource r113 = CardDataSource.IM_CONTENT;
    L38:
        r15.l = r113;
        int r114 = r111[r9.getDataSource().ordinal()];
        if (r114 == 1) goto L46;
        if (r114 == 2) goto L45;
        if (r114 == 3) goto L45;
        if (r114 == 4) goto L44;
        CardActionDataSource r115 = CardActionDataSource.IM_CONTENT;
    L47:
        Intrinsics.checkNotNullParameter(r115, "dataSource");
        r15.m = r115;
        r15.o = r9.getHostCardId();
        return r15.a();
    L44:
        r115 = CardActionDataSource.STREAMING_CARD_ENTITY;
    L45:
        r115 = CardActionDataSource.CARD_ENTITY;
        goto L47
    L46:
        r115 = CardActionDataSource.IM_CONTENT;
        goto L47
    L34:
        r113 = CardDataSource.STREAMING_ENTITY;
        goto L38
    L35:
        r113 = CardDataSource.CARD_ENTITY;
        goto L38
    L36:
        r113 = CardDataSource.IM_ENTITY;
        goto L38
    L37:
        r113 = CardDataSource.IM_CONTENT;
        goto L38
    L19:
        if (C0184a.b[r17.getPrintStrategy().ordinal()] != 1) goto L21;
        StreamingConfig.PrintStrategy r7 = StreamingConfig.PrintStrategy.DELAY;
    L22:
        r2 = new StreamingConfig(r7, r17.getPrintFrequencyMs(), r17.getPrintStep());
        goto L23
    L21:
        r7 = StreamingConfig.PrintStrategy.FAST;
        goto L22
    L15:
        r16 = null;
    L11:
        r4 = null;
        goto L12
    }

    public static CardContext a(boolean r17, boolean r18, boolean r19, String r20, boolean r21, Context r22, Fragment r23, OPTrace r24, String r25, boolean r26, String r27, String r28, String r29, String r30, String r31, d r32) {
        Intrinsics.checkNotNullParameter(r20, "chatId");
        Intrinsics.checkNotNullParameter(r22, "context");
        Intrinsics.checkNotNullParameter(r24, "renderTrace");
        Intrinsics.checkNotNullParameter(r25, "cardId");
        Intrinsics.checkNotNullParameter(r27, "scene");
        Intrinsics.checkNotNullParameter(INotificationHitPoint.NoticeType.MESSAGE, "businessType");
        CardStyle r8 = new CardStyle(r17, r18, r19, null, 8, null);
        MessageCardBizContext r10 = new MessageCardBizContext(r25, r20, r30, r31);
        MessageCardActionContext r11 = new MessageCardActionContext(r25, r20);
        Bundle r13 = new Bundle();
        c<LynxCardContentVO> r14 = r32.b;
        if (r14 == null) goto L8;
        String r15 = r14.g();
        if (r15 == null) goto L8;
        String r110 = "";
    L9:
        r13.putString("senderId", r15);
        c<LynxCardContentVO> r16 = r32.b;
        if (r16 == null) goto L15;
        String r111 = r16.getId();
        if (r111 == null) goto L15;
        String r112 = r111;
    L16:
        r13.putString("messageId", r112);
        c<LynxCardContentVO> r113 = r32.b;
        if (r113 == null) goto L19;
        long r114 = r113.getCreateTime();
    L20:
        r13.putLong("createTime", r114);
        CardActionDependencyData r12 = new CardActionDependencyData(r20, r21, r26, r13);
        MessageCardCardMonitorData r0 = new MessageCardCardMonitorData(INotificationHitPoint.NoticeType.MESSAGE, r27, r28, r29);
        CardContext.a.a r4 = new CardContext.a.a();
        Intrinsics.checkNotNullParameter(r22, "context");
        r4.c = r22;
        r4.d = r23;
        Intrinsics.checkNotNullParameter(r25, TabAppInfo.IMAGE_JSON_KEY);
        r4.a = r25;
        Intrinsics.checkNotNullParameter(r24, "renderTrace");
        r4.b = r24;
        Intrinsics.checkNotNullParameter(r10, "bizContext");
        r4.f = r10;
        Intrinsics.checkNotNullParameter(r0, "monitorData");
        r4.e = r0;
        r4.g = r11;
        Intrinsics.checkNotNullParameter(r12, "cardActionDependencyData");
        r4.j = r12;
        MessageCardDependencyImpl r1 = new MessageCardDependencyImpl(r10, r32, new MessageCardActionService());
        Intrinsics.checkNotNullParameter(r1, "dependency");
        r4.k = r1;
        Intrinsics.checkNotNullParameter(r8, "cardStyle");
        r4.l = r8;
        Intrinsics.checkNotNullParameter("im_message", "host");
        r4.h = "im_message";
        return r4.a();
    L19:
        r114 = 0;
    L15:
        r112 = r110;
    L8:
        r110 = "";
        r15 = r110;
        goto L9
    }
}
