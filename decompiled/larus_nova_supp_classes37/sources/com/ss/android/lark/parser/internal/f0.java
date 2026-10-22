package com.ss.android.lark.parser.internal;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.ImageSet;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.widget.codeblock.entity.LineContent;
import com.ss.android.lark.widget.richtext.Image;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class f0 implements com.larksuite.framework.utils.y.a<RichTextElement, com.bytedance.lark.pb.basic.v1.RichTextElement> {
    public f0() {
    }

    public final Object get(Object r11) {
        RichTextElement r12 = (RichTextElement) r11;
        RichTextElement.RichTextTag r0 = r12.getTag();
        Map r1 = r12.getStyle();
        List r2 = r12.getChildIds();
        com.bytedance.lark.pb.basic.v1.RichTextElement.Builder r3 = new com.bytedance.lark.pb.basic.v1.RichTextElement.Builder();
        if (r0 == null) goto L5;
        int r4 = r0.getNumber();
    L6:
        com.bytedance.lark.pb.basic.v1.RichTextElement.Builder r5 = r3.tag(com.bytedance.lark.pb.basic.v1.RichTextElement.Tag.fromValue(r4));
        if (r1 != null) goto L10;
        r1 = Collections.emptyMap();
    L10:
        com.bytedance.lark.pb.basic.v1.RichTextElement.Builder r6 = r5.style(r1);
        if (r2 != null) goto L14;
        r2 = Collections.emptyList();
    L14:
        com.bytedance.lark.pb.basic.v1.RichTextElement.Builder r7 = r6.child_ids(r2);
        com.bytedance.lark.pb.basic.v1.RichTextElement.PropertySet.Builder r8 = new com.bytedance.lark.pb.basic.v1.RichTextElement.PropertySet.Builder();
        int r9 = g0.a.a[r12.getTag().ordinal()];     // Catch: Exception -> L105
        if (r9 != 29) goto L18;
        RichTextElement.ULProperty r13 = r12.getProperty();     // Catch: Exception -> L105
        com.bytedance.lark.pb.basic.v1.RichTextElement.ULProperty.Builder r10 = new com.bytedance.lark.pb.basic.v1.RichTextElement.ULProperty.Builder();     // Catch: Exception -> L105
        RichTextElement.ULProperty.Type r14 = r13.getType();     // Catch: Exception -> L105
        if (r14 == null) goto L103;
        r10.type(com.bytedance.lark.pb.basic.v1.RichTextElement.ULProperty.Type.fromValue(r14.getType()));     // Catch: Exception -> L105
    L103:
        com.bytedance.lark.pb.basic.v1.RichTextElement.PropertySet r15 = r8.ul(r10.build()).build();     // Catch: Exception -> L105
    L107:
        return r7.property(r15).build();
    L18:
        if (r9 == 30) goto L96;
        switch(r9) {
            case 1: goto L34;
            case 2: goto L33;
            case 3: goto L32;
            case 4: goto L31;
            case 5: goto L30;
            case 6: goto L29;
            case 7: goto L28;
            case 8: goto L27;
            case 9: goto L26;
            case 10: goto L25;
            case 11: goto L24;
            default: goto L20;
        };     // Catch: Exception -> L105
    L20:
        switch(r9) {
            case 18: goto L38;
            case 19: goto L37;
            case 20: goto L36;
            case 21: goto L35;
            default: goto L21;
        };     // Catch: Exception -> L105
    L21:
        switch(r9) {
            case 36: goto L89;
            case 37: goto L88;
            case 38: goto L87;
            case 39: goto L63;
            case 40: goto L62;
            case 41: goto L61;
            case 42: goto L60;
            case 43: goto L59;
            default: goto L22;
        };     // Catch: Exception -> L105
    L22:
        switch(r9) {
            case 46: goto L95;
            case 47: goto L94;
            case 48: goto L90;
            default: goto L23;
        };     // Catch: Exception -> L105
    L23:
        r15 = r8.build();     // Catch: Exception -> L105
        goto L107
    L90:
        RichTextElement.MarkdownProperty r16 = r12.getProperty();     // Catch: Exception -> L105
        com.bytedance.lark.pb.basic.v1.RichTextElement.MarkdownProperty.Builder r17 = new com.bytedance.lark.pb.basic.v1.RichTextElement.MarkdownProperty.Builder();     // Catch: Exception -> L105
        if (r16 == null) goto L93;
        r17.content(r16.getContent()).images(g0.b(r16.getImages())).at_user_ids(r16.getAtUserIds()).is_at_all(Boolean.valueOf(r16.isAtAll())).at_users(g0.a(r16.getAtUsers()));     // Catch: Exception -> L105
    L93:
        r15 = r8.markdown(r17.build()).build();     // Catch: Exception -> L105
        goto L107
    L94:
        r15 = r8.image_gallery(new com.bytedance.lark.pb.basic.v1.RichTextElement.ImageGalleryProperty.Builder().build()).build();     // Catch: Exception -> L105
        goto L107
    L95:
        RichTextElement.AtUserGroupProperty r18 = r12.getProperty();     // Catch: Exception -> L105
        com.bytedance.lark.pb.basic.v1.RichTextElement.AtUserGroupProperty.Builder r19 = new com.bytedance.lark.pb.basic.v1.RichTextElement.AtUserGroupProperty.Builder();     // Catch: Exception -> L105
        r19.user_group_id(Long.valueOf(r18.getUserGroupId()));     // Catch: Exception -> L105
        r19.default_group_name(r18.getDefaultGroupName());     // Catch: Exception -> L105
        r15 = r8.at_user_group(r19.build()).build();     // Catch: Exception -> L105
        goto L107
    L59:
        r15 = r8.table_cell(h0.a(r12.getProperty())).build();     // Catch: Exception -> L105
        goto L107
    L60:
        r15 = r8.table_row(h0.c(r12.getProperty())).build();     // Catch: Exception -> L105
        goto L107
    L61:
        r15 = r8.table(h0.b(r12.getProperty())).build();     // Catch: Exception -> L105
        goto L107
    L62:
        RichTextElement.MyAIToolProperty r110 = r12.getProperty();     // Catch: Exception -> L105
        r15 = r8.my_ai_tool(new com.bytedance.lark.pb.basic.v1.RichTextElement.MyAIToolProperty.Builder().tool_id(r110.getTool_id()).tool_runtime_id(r110.getTool_runtime_id()).status(com.bytedance.lark.pb.basic.v1.RichTextElement.MyAIToolProperty.Status.fromValue(r110.getStatus().getNumber())).i18n_name(r110.getI18n_name()).text(r110.getText()).icon(r110.getIcon()).build()).build();     // Catch: Exception -> L105
        goto L107
    L63:
        RichTextElement.CodeBlockV2Property r111 = r12.getProperty();     // Catch: Exception -> L105
        com.bytedance.lark.pb.basic.v1.RichTextElement.CodeBlockV2Property.Builder r20 = new com.bytedance.lark.pb.basic.v1.RichTextElement.CodeBlockV2Property.Builder().language(com.bytedance.lark.pb.basic.v1.RichTextElement.CodeBlockV2Property.Language.fromValue(r111.getLanguage().getNumber())).version(Integer.valueOf(r111.getVersion())).word_wrap(Boolean.valueOf(r111.isWordWrap()));     // Catch: Exception -> L105
        if (CollectionUtils.isNotEmpty(r111.getLineContents()) == false) goto L86;
        ArrayList r21 = new ArrayList();     // Catch: Exception -> L105
        Iterator r112 = r111.getLineContents().iterator();     // Catch: Exception -> L105
    L67:
        if (r112.hasNext() == false) goto L85;
        LineContent r22 = (LineContent) r112.next();     // Catch: Exception -> L105
        if (r22 == null) goto L67;
        com.bytedance.lark.pb.basic.v1.RichTextElement.CodeBlockV2Property.LineContent.Builder r23 = new com.bytedance.lark.pb.basic.v1.RichTextElement.CodeBlockV2Property.LineContent.Builder();     // Catch: Exception -> L105
        if (r22.getContents() == null) goto L73;
        ArrayList r24 = new ArrayList();     // Catch: Exception -> L105
        Iterator r25 = r22.getContents().iterator();     // Catch: Exception -> L105
    L76:
        if (r25.hasNext() == false) goto L84;
        LineContent.Content r26 = (LineContent.Content) r25.next();     // Catch: Exception -> L105
        if (r26 == null) goto L76;
        com.bytedance.lark.pb.basic.v1.RichTextElement.CodeBlockV2Property.Content.Builder r27 = new com.bytedance.lark.pb.basic.v1.RichTextElement.CodeBlockV2Property.Content.Builder().content(r26.getOriginText()).type(com.bytedance.lark.pb.basic.v1.RichTextElement.CodeBlockV2Property.ContentType.fromValue(r26.getContentType().getNumber()));     // Catch: Exception -> L105
        if (CollectionUtils.isNotEmpty(r26.getStyle()) == false) goto L83;
        r27.style(r26.getStyle());     // Catch: Exception -> L105
    L83:
        r24.add(r27.build());     // Catch: Exception -> L105
        goto L76
    L84:
        r23.contents(r24);     // Catch: Exception -> L105
        r21.add(r23.build());     // Catch: Exception -> L105
        goto L67
    L73:
        r21.add(r23.build());     // Catch: Exception -> L105
        goto L67
    L85:
        r20.contents(r21);     // Catch: Exception -> L105
    L86:
        r15 = r8.code_block_v2(r20.build()).build();     // Catch: Exception -> L105
        goto L107
    L87:
        RichTextElement.MentionProperty r113 = r12.getProperty();     // Catch: Exception -> L105
        r15 = r8.mention(new com.bytedance.lark.pb.basic.v1.RichTextElement.MentionProperty.Builder().content(r113.getContent()).item(new com.bytedance.lark.pb.basic.v1.RichTextElement.MentionItem.Builder().id(r113.getMentionItem().getId()).type(com.bytedance.lark.pb.basic.v1.RichTextElement.MentionItem.MentionType.fromValue(r113.getMentionItem().getType().getNumber())).build()).build()).build();     // Catch: Exception -> L105
        goto L107
    L88:
        RichTextElement.DateTimePickerProperty r114 = r12.getProperty();     // Catch: Exception -> L105
        r15 = r8.datetime_picker(new com.bytedance.lark.pb.basic.v1.RichTextElement.DatetimePickerProperty.Builder().action_id(r114.getActionId()).initial_datetime(r114.getInitialDateTime()).build()).build();     // Catch: Exception -> L105
        goto L107
    L89:
        RichTextElement.TimePickerProperty r115 = r12.getProperty();     // Catch: Exception -> L105
        r15 = r8.time_picker(new com.bytedance.lark.pb.basic.v1.RichTextElement.TimePickerProperty.Builder().action_id(r115.getActionId()).initial_time(r115.getInitialTime()).build()).build();     // Catch: Exception -> L105
        goto L107
    L35:
        RichTextElement.DatePickerProperty r116 = r12.getProperty();     // Catch: Exception -> L105
        r15 = r8.date_picker(new com.bytedance.lark.pb.basic.v1.RichTextElement.DatePickerProperty.Builder().action_id(r116.getActionId()).initial_date(r116.getInitialDate()).build()).build();     // Catch: Exception -> L105
        goto L107
    L36:
        RichTextElement.OverflowMenuProperty r117 = r12.getProperty();     // Catch: Exception -> L105
        r15 = r8.overflow_menu(new com.bytedance.lark.pb.basic.v1.RichTextElement.OverflowMenuProperty.Builder().action_id(r117.getActionId()).build()).build();     // Catch: Exception -> L105
        goto L107
    L37:
        RichTextElement.SelectMenuProperty r118 = r12.getProperty();     // Catch: Exception -> L105
        r15 = r8.select_menu(new com.bytedance.lark.pb.basic.v1.RichTextElement.SelectMenuProperty.Builder().action_id(r118.getActionId()).build()).build();     // Catch: Exception -> L105
        goto L107
    L38:
        RichTextElement.MediaProperty r119 = r12.getProperty();     // Catch: Exception -> L105
        com.bytedance.lark.pb.basic.v1.RichTextElement.MediaProperty.Builder r28 = new com.bytedance.lark.pb.basic.v1.RichTextElement.MediaProperty.Builder().origin_path(r119.getOriginPath()).compress_path(r119.getCompressPath()).mime(r119.getMime()).key(r119.getKey()).name(r119.getName()).need_copy_img(Boolean.valueOf(r119.isNeedCopy())).need_copy_media(Boolean.valueOf(r119.isNeedCopy())).url(r119.getUrl()).duration(Integer.valueOf(r119.getDuration())).size(Long.valueOf(r119.getSize())).resource_preview_token(r119.getResourcePreviewToken()).resource_msg_link_token(r119.getResourceMsgLinkToken());     // Catch: Exception -> L105
        if (TextUtils.isEmpty(r119.getCryptoToken()) == true) goto L42;
        r28.crypto_token(r119.getCryptoToken());     // Catch: Exception -> L105
    L42:
        if (TextUtils.isEmpty(r119.getMediaUploadId()) == true) goto L45;
        r28.media_upload_id(r119.getMediaUploadId());     // Catch: Exception -> L105
    L45:
        if (TextUtils.isEmpty(r119.getImageUploadId()) == true) goto L47;
        r28.image_upload_id(r119.getImageUploadId());     // Catch: Exception -> L105
    L47:
        ImageSet.Builder r29 = new ImageSet.Builder().key(r119.getImageSetKey());     // Catch: Exception -> L105
        Image r30 = r119.getOriginImage();     // Catch: Exception -> L105
        if (r30 == null) goto L55;
        com.bytedance.lark.pb.basic.v1.Image.Builder r31 = new com.bytedance.lark.pb.basic.v1.Image.Builder().key(r30.getKey());     // Catch: Exception -> L105
        if (r30.getWidth() > 0) goto L52;
    L54:
        r29.origin(r31.build());     // Catch: Exception -> L105
        goto L55
    L52:
        if (r30.getHeight() <= 0) goto L54;
        r31.width(Integer.valueOf(r30.getWidth())).height(Integer.valueOf(r30.getHeight()));     // Catch: Exception -> L105
    L55:
        r28.image(r29.build());     // Catch: Exception -> L105
        r28.image_path(r119.getCoverPath());     // Catch: Exception -> L105
        String r32 = r119.getCoverPath();     // Catch: Exception -> L105
        if (TextUtils.isEmpty(r32) == true) goto L58;
        r28.image_data(ByteString.of(FileUtils.j(r32)));     // Catch: Exception -> L105
    L58:
        r28.width(Integer.valueOf(r119.getWidth()));     // Catch: Exception -> L105
        r28.height(Integer.valueOf(r119.getHeight()));     // Catch: Exception -> L105
        r15 = r8.media(r28.build()).build();     // Catch: Exception -> L105
        goto L107
    L24:
        RichTextElement.ButtonProperty r120 = r12.getProperty();     // Catch: Exception -> L105
        r15 = r8.button(new com.bytedance.lark.pb.basic.v1.RichTextElement.ButtonProperty.Builder().action_id(r120.getActionId()).build()).build();     // Catch: Exception -> L105
        goto L107
    L25:
        RichTextElement.EmotionProperty r121 = r12.getProperty();     // Catch: Exception -> L105
        r15 = r8.emotion(new com.bytedance.lark.pb.basic.v1.RichTextElement.EmotionProperty.Builder().key(r121.getKey()).build()).build();     // Catch: Exception -> L105
        goto L107
    L26:
        RichTextElement.UnderlineProperty r122 = r12.getProperty();     // Catch: Exception -> L105
        r15 = r8.underline(new com.bytedance.lark.pb.basic.v1.RichTextElement.UnderlineProperty.Builder().content(r122.getContent()).build()).build();     // Catch: Exception -> L105
        goto L107
    L27:
        RichTextElement.ItalicProperty r123 = r12.getProperty();     // Catch: Exception -> L105
        r15 = r8.italic(new com.bytedance.lark.pb.basic.v1.RichTextElement.ItalicProperty.Builder().content(r123.getContent()).build()).build();     // Catch: Exception -> L105
        goto L107
    L28:
        RichTextElement.BoldProperty r124 = r12.getProperty();     // Catch: Exception -> L105
        r15 = r8.bold(new com.bytedance.lark.pb.basic.v1.RichTextElement.BoldProperty.Builder().content(r124.getContent()).build()).build();     // Catch: Exception -> L105
        goto L107
    L29:
        RichTextElement.AnchorProperty r125 = r12.getProperty();     // Catch: Exception -> L105
        r15 = r8.anchor(new com.bytedance.lark.pb.basic.v1.RichTextElement.AnchorProperty.Builder().href(r125.getHref()).content(r125.getContent()).scene(com.bytedance.lark.pb.basic.v1.RichTextElement.AnchorProperty.Scene.fromValue(r125.getScene().value)).is_custom(Boolean.valueOf(r125.isCustom())).build()).build();     // Catch: Exception -> L105
        goto L107
    L30:
        RichTextElement.AtProperty r126 = r12.getProperty();     // Catch: Exception -> L105
        r15 = r8.at(new com.bytedance.lark.pb.basic.v1.RichTextElement.AtProperty.Builder().user_id(r126.getUserId()).is_outer(Boolean.valueOf(r126.isOutChatUser())).content(r126.getAtContentForPB()).is_anonymous(Boolean.valueOf(r126.isAnonymous())).build()).build();     // Catch: Exception -> L105
        goto L107
    L31:
        RichTextElement.FigureProperty r127 = r12.getProperty();     // Catch: Exception -> L105
        r15 = r8.figure(new com.bytedance.lark.pb.basic.v1.RichTextElement.FigureProperty.Builder().build()).build();     // Catch: Exception -> L105
        goto L107
    L32:
        RichTextElement.ParagraphProperty r128 = r12.getProperty();     // Catch: Exception -> L105
        r15 = r8.paragraph(new com.bytedance.lark.pb.basic.v1.RichTextElement.ParagraphProperty.Builder().build()).build();     // Catch: Exception -> L105
        goto L107
    L33:
        RichTextElement.ImageProperty r129 = r12.getProperty();     // Catch: Exception -> L105
        r15 = r8.image(new com.bytedance.lark.pb.basic.v1.RichTextElement.ImageProperty.Builder().token(r129.getToken()).middle_key(r129.getMiddleKey()).origin_key(r129.getOriginKey()).thumb_key(r129.getThumbKey()).need_copy(Boolean.valueOf(r129.isNeedCopy())).is_origin_source(Boolean.valueOf(r129.isOriginSource())).origin_size(Long.valueOf(r129.getOriginSize())).fs_unit(r129.getFsUnit()).resource_preview_token(r129.getResourcePreviewToken()).resource_msg_link_token(r129.getResourceMsgLinkToken()).urls(r129.getUrls()).origin_height(Integer.valueOf(r129.getOriginHeight())).origin_width(Integer.valueOf(r129.getOriginWidth())).build()).build();     // Catch: Exception -> L105
        goto L107
    L34:
        RichTextElement.TextProperty r130 = r12.getProperty();     // Catch: Exception -> L105
        r15 = r8.text(new com.bytedance.lark.pb.basic.v1.RichTextElement.TextProperty.Builder().content(r130.getContent()).build()).build();     // Catch: Exception -> L105
        goto L107
    L96:
        RichTextElement.OLProperty r131 = r12.getProperty();     // Catch: Exception -> L105
        com.bytedance.lark.pb.basic.v1.RichTextElement.OLProperty.Builder r33 = new com.bytedance.lark.pb.basic.v1.RichTextElement.OLProperty.Builder();     // Catch: Exception -> L105
        r33.start(Integer.valueOf(r131.getStart()));     // Catch: Exception -> L105
        RichTextElement.OLProperty.Type r132 = r131.getType();     // Catch: Exception -> L105
        if (r132 == null) goto L99;
        r33.type(com.bytedance.lark.pb.basic.v1.RichTextElement.OLProperty.Type.fromValue(r132.getType()));     // Catch: Exception -> L105
    L99:
        r15 = r8.ol(r33.build()).build();     // Catch: Exception -> L105
    L105:
        r15 = r8.build();
        goto L107
    L5:
        r4 = 0;
        goto L6
    }
}
