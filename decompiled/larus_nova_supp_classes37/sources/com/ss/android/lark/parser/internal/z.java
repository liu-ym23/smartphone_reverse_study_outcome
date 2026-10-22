package com.ss.android.lark.parser.internal;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.ImageSet;
import com.bytedance.lark.pb.basic.v1.ImageSetV2;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.codeblock.entity.LineContent;
import com.ss.android.lark.widget.richtext.MarkdownImageSet;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.table.entity.Column;
import com.ss.android.lark.widget.table.entity.HorizontalAlign;
import com.ss.android.lark.widget.table.entity.VerticalAlign;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class z {
    public static RichTextElement.AnchorProperty a(com.bytedance.lark.pb.basic.v1.RichTextElement.AnchorProperty r4) throws Exception {
        RichTextElement.AnchorProperty r0 = new RichTextElement.AnchorProperty();
        if (r4 == null) goto L16;
        r0.setHref(r4.href);
        if (TextUtils.isEmpty(r4.text_content) == false) goto L7;
        String r2 = r4.content;
    L9:
        if (TextUtils.isEmpty(r2) == false) goto L11;
        r2 = r4.href;
    L11:
        r0.setContent(r2);
        r0.setAndroidHref(r4.android_href);
        r0.setI18nKey(r4.i18n_key);
        r0.setCustom(r4.is_custom.booleanValue());
        r0.setScene(RichTextElement.AnchorProperty.Scene.valueOf(r4.scene.getValue()));
        Boolean r3 = r4.close_card_preview;
        if (r3 == null) goto L14;
        r0.setCloseCardPreview(r3.booleanValue());
    L15:
        r0.setSpecialURL(RichTextElement.AnchorProperty.SpecialURL.valueOf(r4.special_url.getValue()));
    L17:
        return r0;
    L14:
        r0.setCloseCardPreview(false);
        goto L15
    L7:
        r2 = r4.text_content;
        goto L9
    L16:
        r0.setHref("");
        r0.setContent("");
        r0.setAndroidHref("");
        r0.setI18nKey("");
        r0.setCustom(false);
        goto L17
    }

    public static RichTextElement.AtProperty b(com.bytedance.lark.pb.basic.v1.RichTextElement.AtProperty r3) throws Exception {
        RichTextElement.AtProperty r0 = new RichTextElement.AtProperty();
        String r1 = "";
        if (r3 != null) goto L5;
        String r2 = "";
    L6:
        r0.setUserId(r2);
        if (r3 == null) goto L10;
        r1 = r3.content;
    L10:
        r0.setContent(r1);
        boolean r4 = false;
        if (r3 != null) goto L13;
        boolean r5 = false;
    L14:
        r0.setOutChatUser(r5);
        if (r3 != null) goto L17;
        boolean r6 = false;
    L18:
        r0.setAnonymous(r6);
        if (r3 != null) goto L21;
    L23:
        r0.setHighLight(r4);
        return r0;
    L21:
        if (r3.is_highlight.booleanValue() == false) goto L23;
        r4 = true;
        goto L23
    L17:
        r6 = r3.is_anonymous.booleanValue();
        goto L18
    L13:
        r5 = r3.is_outer.booleanValue();
        goto L14
    L5:
        r2 = r3.user_id;
        goto L6
    }

    public static RichTextElement.ButtonProperty c(com.bytedance.lark.pb.basic.v1.RichTextElement.ButtonProperty r3) throws Exception {
        RichTextElement.ButtonProperty r0 = new RichTextElement.ButtonProperty();
        if (r3 != null) goto L5;
        String r1 = "";
    L6:
        r0.setActionId(r1);
        boolean r2 = false;
        if (r3 != null) goto L9;
        boolean r4 = false;
    L10:
        r0.setActive(r4);
        if (r3 != null) goto L13;
        boolean r5 = true;
    L14:
        r0.setDisable(r5);
        if (r3 == null) goto L18;
        r2 = r3.is_loading.booleanValue();
    L18:
        r0.setShowLoadingIcon(r2);
        if (r3 != null) goto L21;
        String r6 = "default";
    L22:
        r0.setMode(r6);
        if (r3 == null) goto L44;
        com.bytedance.lark.pb.basic.v1.RichTextElement.ButtonConfirmProperty r7 = r3.confirm;
        if (r7 != null) goto L27;
    L35:
        com.bytedance.lark.pb.basic.v1.RichTextElement.ButtonLoadingProperty r8 = r3.loading;
        if (r8 == null) goto L44;
        if (TextUtils.isEmpty(r8.begin) == true) goto L44;
        if (TextUtils.isEmpty(r3.loading.success) == true) goto L44;
        if (TextUtils.isEmpty(r3.loading.fail) == true) goto L44;
        RichTextElement.ButtonProperty.ButtonLoadingProperty r9 = new RichTextElement.ButtonProperty.ButtonLoadingProperty();
        r9.setBegin(r3.loading.begin);
        r9.setBeginI18NKey(r3.loading.begin_i18n_key);
        r9.setSuccess(r3.loading.success);
        r9.setSuccessI18NKey(r3.loading.success_i18n_key);
        r9.setFail(r3.loading.fail);
        r9.setFailI18NKey(r3.loading.fail_i18n_key);
        r0.setLoading(r9);
        goto L44
    L27:
        if (TextUtils.isEmpty(r7.title) == true) goto L35;
        if (TextUtils.isEmpty(r3.confirm.text) == true) goto L35;
        if (TextUtils.isEmpty(r3.confirm.confirm) == true) goto L35;
        if (TextUtils.isEmpty(r3.confirm.dismiss) == true) goto L35;
        RichTextElement.ConfirmProperty r10 = new RichTextElement.ConfirmProperty();
        r10.setTitle(r3.confirm.title);
        r10.setTitleI18NKey(r3.confirm.title_i18n_key);
        r10.setText(r3.confirm.text);
        r10.setTextI18NKey(r3.confirm.text_i18n_key);
        r10.setConfirm(r3.confirm.confirm);
        r10.setConfirmI18NKey(r3.confirm.confirm_i18n_key);
        r10.setDismiss(r3.confirm.dismiss);
        r10.setDismissI18NKey(r3.confirm.dismiss_i18n_key);
        r0.setConfirm(r10);
    L44:
        return r0;
    L21:
        r6 = r3.mode;
        goto L22
    L13:
        r5 = r3.disable.booleanValue();
        goto L14
    L9:
        r4 = r3.active.booleanValue();
        goto L10
    L5:
        r1 = r3.action_id;
        goto L6
    }

    public static RichTextElement.CodeBlockProperty d(com.bytedance.lark.pb.basic.v1.RichTextElement.CodeBlockProperty r6) {
        RichTextElement.CodeBlockProperty r0 = new RichTextElement.CodeBlockProperty();
        if (r6 != null) goto L5;
        RichTextElement.CodeBlockProperty.Language r1 = RichTextElement.CodeBlockProperty.Language.JS;
    L6:
        r0.setLanguage(r1);
        if (r6 != null) goto L9;
        String r2 = "";
    L10:
        r0.setContent(r2);
        if (r6 != null) goto L13;
    L26:
        return r0;
    L13:
        if (CollectionUtils.isNotEmpty(r6.style_refs) == false) goto L20;
        ArrayList r3 = new ArrayList();
        Iterator r4 = r6.style_refs.iterator();
    L16:
        if (r4.hasNext() == false) goto L18;
        com.bytedance.lark.pb.basic.v1.RichTextElement.CodeBlockProperty.StyleRef r5 = (com.bytedance.lark.pb.basic.v1.RichTextElement.CodeBlockProperty.StyleRef) r4.next();
        RichTextElement.CodeBlockProperty.StyleRef r7 = new RichTextElement.CodeBlockProperty.StyleRef();
        r7.length = r5.length.intValue();
        r7.location = r5.location.intValue();
        r7.styleIds = new ArrayList(r5.style_ids);
        r3.add(r7);
        goto L16
    L18:
        r0.setStyleRefList(r3);
    L20:
        if (CollectionUtils.isNotEmpty(r6.styles) == false) goto L26;
        ArrayList r8 = new ArrayList();
        Iterator r9 = r6.styles.iterator();
    L23:
        if (r9.hasNext() == false) goto L25;
        com.bytedance.lark.pb.basic.v1.RichTextElement.CodeBlockProperty.Style r10 = (com.bytedance.lark.pb.basic.v1.RichTextElement.CodeBlockProperty.Style) r9.next();
        RichTextElement.CodeBlockProperty.Style r11 = new RichTextElement.CodeBlockProperty.Style();
        r11.type = RichTextElement.CodeBlockProperty.StyleType.forType(r10.type.getValue());
        r11.name = r10.name;
        r11.value = r10.value;
        r8.add(r11);
        goto L23
    L25:
        r0.setStyleList(r8);
        goto L26
    L9:
        r2 = r6.content;
        goto L10
    L5:
        r1 = RichTextElement.CodeBlockProperty.Language.forType(r6.language.getValue());
        goto L6
    }

    public static RichTextElement.CodeBlockV2Property e(com.bytedance.lark.pb.basic.v1.RichTextElement.CodeBlockV2Property r11) {
        RichTextElement.CodeBlockV2Property r0 = new RichTextElement.CodeBlockV2Property();
        if (r11 != null) goto L5;
        RichTextElement.CodeBlockV2Property.Language r1 = RichTextElement.CodeBlockV2Property.Language.PLAIN_TEXT;
    L6:
        r0.setLanguage(r1);
        ArrayList r2 = null;
        if (r11 == null) goto L34;
        List r3 = r11.contents;
        if (CollectionUtils.isEmpty(r3) == true) goto L34;
        ArrayList r4 = new ArrayList();
        Iterator r5 = r3.iterator();
    L14:
        if (r5.hasNext() == false) goto L33;
        com.bytedance.lark.pb.basic.v1.RichTextElement.CodeBlockV2Property.LineContent r6 = (com.bytedance.lark.pb.basic.v1.RichTextElement.CodeBlockV2Property.LineContent) r5.next();
        if (r6 == null) goto L14;
        LineContent r7 = new LineContent();
        if (r6.contents == null) goto L20;
        ArrayList r8 = new ArrayList();
        Iterator r9 = r6.contents.iterator();
    L23:
        if (r9.hasNext() == false) goto L32;
        com.bytedance.lark.pb.basic.v1.RichTextElement.CodeBlockV2Property.Content r10 = (com.bytedance.lark.pb.basic.v1.RichTextElement.CodeBlockV2Property.Content) r9.next();
        if (r10 == null) goto L23;
        if (CollectionUtils.isNotEmpty(r10.style) == false) goto L30;
        HashMap r12 = new HashMap(r10.style);
    L31:
        LineContent.Content r13 = new LineContent.Content();
        r13.setOriginText(r10.content);
        r13.setContentType(LineContent.ContentType.fromValue(r10.type.getValue()));
        r13.setStyle(r12);
        r8.add(r13);
        goto L23
    L30:
        r12 = null;
        goto L31
    L32:
        r7.setContents(r8);
        r4.add(r7);
        goto L14
    L20:
        r4.add(r7);
        goto L14
    L33:
        r2 = r4;
    L34:
        r0.setLineContents(r2);
        int r14 = 0;
        if (r11 != null) goto L37;
    L39:
        boolean r15 = false;
    L40:
        r0.setWordWrap(r15);
        if (r11 == null) goto L44;
        r14 = r11.version.intValue();
    L44:
        r0.setVersion(r14);
        return r0;
    L37:
        if (r11.word_wrap.booleanValue() == false) goto L39;
        r15 = true;
        goto L40
    L5:
        r1 = RichTextElement.CodeBlockV2Property.Language.fromValue(r11.language.getValue());
        goto L6
    }

    public static RichTextElement.DatePickerProperty f(com.bytedance.lark.pb.basic.v1.RichTextElement.DatePickerProperty r3) throws Exception {
        RichTextElement.DatePickerProperty r0 = new RichTextElement.DatePickerProperty();
        String r1 = "";
        if (r3 != null) goto L5;
        String r2 = "";
    L6:
        r0.setActionId(r2);
        if (r3 != null) goto L9;
        String r4 = "";
    L10:
        r0.setPlaceHolder(r4);
        if (r3 != null) goto L13;
        String r5 = "";
    L14:
        r0.setInitialDate(r5);
        if (r3 == null) goto L18;
        r1 = r3.place_holder_i18n_key;
    L18:
        r0.setPlaceHolderI18nKey(r1);
        boolean r6 = false;
        if (r3 != null) goto L21;
        boolean r7 = false;
    L22:
        r0.setDisable(r7);
        if (r3 == null) goto L26;
        r6 = r3.is_loading.booleanValue();
    L26:
        r0.setLoading(r6);
        if (r3 == null) goto L39;
        com.bytedance.lark.pb.basic.v1.RichTextElement.ButtonConfirmProperty r8 = r3.confirm;
        if (r8 == null) goto L39;
        if (TextUtils.isEmpty(r8.title) == true) goto L39;
        if (TextUtils.isEmpty(r3.confirm.text) == true) goto L39;
        if (TextUtils.isEmpty(r3.confirm.confirm) == true) goto L39;
        if (TextUtils.isEmpty(r3.confirm.dismiss) == true) goto L39;
        RichTextElement.ConfirmProperty r9 = new RichTextElement.ConfirmProperty();
        r9.setTitle(r3.confirm.title);
        r9.setTitleI18NKey(r3.confirm.title_i18n_key);
        r9.setText(r3.confirm.text);
        r9.setTextI18NKey(r3.confirm.text_i18n_key);
        r9.setConfirm(r3.confirm.confirm);
        r9.setConfirmI18NKey(r3.confirm.confirm_i18n_key);
        r9.setDismiss(r3.confirm.dismiss);
        r9.setDismissI18NKey(r3.confirm.dismiss_i18n_key);
        r0.setConfirm(r9);
    L39:
        return r0;
    L21:
        r7 = r3.disable.booleanValue();
        goto L22
    L13:
        r5 = r3.initial_date;
        goto L14
    L9:
        r4 = r3.place_holder;
        goto L10
    L5:
        r2 = r3.action_id;
        goto L6
    }

    public static RichTextElement.DateTimePickerProperty g(com.bytedance.lark.pb.basic.v1.RichTextElement.DatetimePickerProperty r3) throws Exception {
        RichTextElement.DateTimePickerProperty r0 = new RichTextElement.DateTimePickerProperty();
        String r1 = "";
        if (r3 != null) goto L5;
        String r2 = "";
    L6:
        r0.setActionId(r2);
        if (r3 != null) goto L9;
        String r4 = "";
    L10:
        r0.setPlaceHolder(r4);
        if (r3 != null) goto L13;
        String r5 = "";
    L14:
        r0.setInitialDateTime(r5);
        if (r3 == null) goto L18;
        r1 = r3.place_holder_i18n_key;
    L18:
        r0.setPlaceHolderI18nKey(r1);
        boolean r6 = false;
        if (r3 != null) goto L21;
        boolean r7 = false;
    L22:
        r0.setDisable(r7);
        if (r3 == null) goto L26;
        r6 = r3.is_loading.booleanValue();
    L26:
        r0.setLoading(r6);
        if (r3 == null) goto L39;
        com.bytedance.lark.pb.basic.v1.RichTextElement.ButtonConfirmProperty r8 = r3.confirm;
        if (r8 == null) goto L39;
        if (TextUtils.isEmpty(r8.title) == true) goto L39;
        if (TextUtils.isEmpty(r3.confirm.text) == true) goto L39;
        if (TextUtils.isEmpty(r3.confirm.confirm) == true) goto L39;
        if (TextUtils.isEmpty(r3.confirm.dismiss) == true) goto L39;
        RichTextElement.ConfirmProperty r9 = new RichTextElement.ConfirmProperty();
        r9.setTitle(r3.confirm.title);
        r9.setTitleI18NKey(r3.confirm.title_i18n_key);
        r9.setText(r3.confirm.text);
        r9.setTextI18NKey(r3.confirm.text_i18n_key);
        r9.setConfirm(r3.confirm.confirm);
        r9.setConfirmI18NKey(r3.confirm.confirm_i18n_key);
        r9.setDismiss(r3.confirm.dismiss);
        r9.setDismissI18NKey(r3.confirm.dismiss_i18n_key);
        r0.setConfirm(r9);
    L39:
        return r0;
    L21:
        r7 = r3.disable.booleanValue();
        goto L22
    L13:
        r5 = r3.initial_datetime;
        goto L14
    L9:
        r4 = r3.place_holder;
        goto L10
    L5:
        r2 = r3.action_id;
        goto L6
    }

    public static Image h(com.bytedance.lark.pb.basic.v1.Image r3) {
        Image r0 = new Image();
        if (r3 != null) goto L5;
        return r0;
    L5:
        r0.setKey(r3.key);
        if (r3.exif_orientation.intValue() < 5) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        Integer r2 = r3.height;
    L12:
        r0.setWidth(r2.intValue());
        if (r1 == false) goto L15;
        Integer r4 = r3.width;
    L16:
        r0.setHeight(r4.intValue());
        r0.setUrls(new ArrayList(r3.urls));
        r0.setType(Image.Type.forNumber(r3.type.getValue()));
        r0.setCrypto(r3.crypto);
        r0.setFsUnit(r3.fs_unit);
        return r0;
    L15:
        r4 = r3.height;
        goto L16
    L11:
        r2 = r3.width;
        goto L12
    L8:
        r1 = false;
        goto L9
    }

    public static RichTextElement.ImageProperty j(com.bytedance.lark.pb.basic.v1.RichTextElement.ImageProperty r4) throws Exception {
        RichTextElement.ImageProperty r0 = new RichTextElement.ImageProperty();
        if (r4 != null) goto L5;
        List r1 = new ArrayList();
    L6:
        r0.setUrls(r1);
        String r2 = "";
        if (r4 != null) goto L9;
        String r3 = "";
    L10:
        r0.setToken(r3);
        if (r4 == null) goto L17;
        com.bytedance.lark.pb.basic.v1.Image r5 = r4.intact;
        if (r5 == null) goto L17;
        if (r5.exif_orientation.intValue() <= 0) goto L17;
        r0.setIntactKey(r4.intact.key);
    L17:
        if (r4 == null) goto L20;
        r2 = r4.origin_key;
    L20:
        r0.setOriginKey(r2);
        boolean r6 = false;
        if (r4 != null) goto L23;
        int r7 = 0;
    L24:
        r0.setOriginWidth(r7);
        if (r4 != null) goto L27;
        int r8 = 0;
    L28:
        r0.setOriginHeight(r8);
        if (r4 != null) goto L31;
        int r9 = 0;
    L32:
        r0.setCustomWidth(r9);
        if (r4 != null) goto L35;
    L37:
        r0.setNeedCopy(r6);
        com.ss.android.lark.widget.richtext.Image r10 = null;
        if (r4 != null) goto L40;
        ResourceCleanScene r11 = null;
    L41:
        r0.setResourceCleanScene(r11);
        if (r4 != null) goto L44;
        com.ss.android.lark.widget.richtext.Image r12 = null;
    L45:
        r0.setMiddleImage(r12);
        if (r4 == null) goto L49;
        r10 = i(r4.thumbnail_webp, r4.clean_resource_scene);
    L49:
        r0.setThumbImage(r10);
        com.bytedance.lark.pb.basic.v1.Image r13 = r4.origin;
        if (r13 == null) goto L53;
        r0.setFsUnit(r13.fs_unit);
        r0.setCrypto(r4.origin.crypto);
    L59:
        com.bytedance.lark.pb.basic.v1.Image r14 = r4.middle_webp;
        if (r14 != null) goto L62;
    L64:
        String r15 = r4.middle_key;
    L65:
        r0.setMiddleKey(r15);
        r0.setThumbKey(u(r4));
        r0.setAlt(r4.alt);
        r0.setAltI18nKey(r4.alt_i18n_key);
        r0.setImgCanPreview(r4.img_can_preview.booleanValue());
        r0.setOriginSource(r4.is_origin_source.booleanValue());
        r0.setOriginSize(r4.origin_size.longValue());
        r0.setShowMode(r4.show_mode.intValue());
        r0.setWidth(r4.width.intValue());
        r0.setHeight(r4.height.intValue());
        ByteString r16 = r4.inline_preview;
        if (r16 != null) goto L68;
    L70:
        return r0;
    L68:
        if (r16.size() <= 0) goto L70;
        r0.setInlinePreview(r4.inline_preview);
        goto L70
    L62:
        if (TextUtils.isEmpty(r14.key) == true) goto L64;
        r15 = r4.middle_webp.key;
        goto L65
    L53:
        if (r0.getMiddleImage() == null) goto L56;
        r0.setFsUnit(r0.getMiddleImage().getFsUnit());
        r0.setCrypto(r0.getMiddleImage().getCrypto());
        goto L59
    L56:
        if (r0.getThumbImage() == null) goto L58;
        r0.setFsUnit(r0.getThumbImage().getFsUnit());
        r0.setCrypto(r0.getThumbImage().getCrypto());
        goto L59
    L58:
        r0.setFsUnit(r4.fs_unit);
        goto L59
    L44:
        r12 = i(r4.middle_webp, r4.clean_resource_scene);
        goto L45
    L40:
        ResourceCleanScene.a r17 = ResourceCleanScene.Companion;
        com.bytedance.lark.pb.basic.v1.ResourceCleanScene r18 = r4.clean_resource_scene;
        r17.getClass();
        r11 = ResourceCleanScene.a.a(r18);
        goto L41
    L35:
        if (r4.need_copy.booleanValue() == false) goto L37;
        r6 = true;
        goto L37
    L31:
        r9 = r4.custom_width.intValue();
        goto L32
    L27:
        r8 = r4.origin_height.intValue();
        goto L28
    L23:
        r7 = r4.origin_width.intValue();
        goto L24
    L9:
        r3 = r4.token;
        goto L10
    L5:
        r1 = r4.urls;
        goto L6
    }

    public static RichTextElement.MarkdownProperty k(com.bytedance.lark.pb.basic.v1.RichTextElement.MarkdownProperty r6) {
        RichTextElement.MarkdownProperty r0 = new RichTextElement.MarkdownProperty();
        String r1 = "";
        if (r6 != null) goto L6;
        r0.setContent("");
        return r0;
    L6:
        String r2 = r6.content;
        if (r2 == null) goto L10;
        r1 = r2;
    L10:
        r0.setContent(r1);
        Map r3 = r6.images;
        HashMap r4 = null;
        if (CollectionUtils.isEmpty(r3) == false) goto L13;
        HashMap r5 = null;
    L20:
        r0.setImages(r5);
        r0.setAtUserIds(r6.at_user_ids);
        r0.setAtAll(Boolean.TRUE.equals(r6.is_at_all));
        Map r7 = r6.at_users;
        if (CollectionUtils.isEmpty(r7) == true) goto L31;
        r4 = new HashMap(r7.size());
        Iterator r8 = r7.entrySet().iterator();
    L25:
        if (r8.hasNext() == false) goto L31;
        Map.Entry r9 = (Map.Entry) r8.next();
        r4.put((String) r9.getKey(), b((com.bytedance.lark.pb.basic.v1.RichTextElement.AtProperty) r9.getValue()));     // Catch: Exception -> L29
    L29:
        e = move-exception;
        Log.e("ModelParserRichTextProperty", "parse markdown at user failed: " + e.getMessage(), e);
    L31:
        r0.setAtUsers(r4);
        return r0;
    L13:
        r5 = new HashMap(r3.size());
        Iterator r10 = r3.entrySet().iterator();
    L15:
        if (r10.hasNext() == false) goto L20;
        Map.Entry r11 = (Map.Entry) r10.next();
        MarkdownImageSet r12 = MarkdownImageSet.fromImageSetV2((ImageSetV2) r11.getValue());
        if (r12 == null) goto L15;
        r5.put((String) r11.getKey(), r12);
        goto L15
    }

    public static RichTextElement.MediaProperty l(com.bytedance.lark.pb.basic.v1.RichTextElement.MediaProperty r9) throws Exception {
        RichTextElement.MediaProperty r0 = new RichTextElement.MediaProperty();
        String r1 = "";
        if (r9 != null) goto L5;
        String r2 = "";
    L6:
        r0.setKey(r2);
        if (r9 != null) goto L9;
        String r3 = "";
    L10:
        r0.setName(r3);
        if (r9 != null) goto L13;
        long r4 = 0;
    L14:
        r0.setSize(r4);
        if (r9 != null) goto L17;
        String r5 = "";
    L18:
        r0.setMime(r5);
        if (r9 != null) goto L21;
        String r6 = "";
    L22:
        r0.setCryptoToken(r6);
        if (r9 != null) goto L25;
        RichTextElement.MediaProperty.Source r7 = RichTextElement.MediaProperty.Source.UNKNOWN;
    L26:
        r0.setSource(r7);
        ResourceCleanScene r8 = null;
        if (r9 == null) goto L32;
        ImageSet r10 = r9.image;
        if (r10 == null) goto L32;
        com.ss.android.lark.widget.richtext.Image r11 = i(r10.origin, r9.clean_resource_scene);
    L33:
        r0.setOriginImage(r11);
        boolean r12 = true;
        int r13 = 0;
        if (r9 == null) goto L49;
        ImageSet r14 = r9.image;
        if (r14 == null) goto L49;
        com.bytedance.lark.pb.basic.v1.ResourceCleanScene r15 = r9.clean_resource_scene;
        com.bytedance.lark.pb.basic.v1.Image r16 = r14.thumbnail_webp;
        if (r16 != null) goto L41;
    L43:
        Image r17 = h(r14.thumbnail);
    L44:
        com.ss.android.lark.widget.richtext.Image r18 = new com.ss.android.lark.widget.richtext.Image();
        r18.setKey(r17.getKey());
        r18.setWidth(r17.getWidth());
        r18.setHeight(r17.getHeight());
        r18.setUrls(r17.getUrls());
        r18.setCrypto(r17.getCrypto());
        r18.setFsUnit(r17.getFsUnit());
        if (r15 == null) goto L47;
        boolean r19 = true;
    L48:
        r18.setResourceIsCleaned(r19);
        ResourceCleanScene.Companion.getClass();
        r18.setResourceCleanScene(ResourceCleanScene.a.a(r15));
    L50:
        r0.setThumbImage(r18);
        if (r0.getOriginImage() == null) goto L54;
        r0.setFsUnit(r0.getOriginImage().getFsUnit());
        r0.setCrypto(r0.getOriginImage().getCrypto());
    L60:
        if (r9 != null) goto L62;
        int r20 = 0;
    L63:
        r0.setDuration(r20);
        if (r9 != null) goto L66;
        String r21 = "";
    L67:
        r0.setUrl(r21);
        if (r9 != null) goto L70;
        String r22 = "";
    L71:
        r0.setCompressPath(r22);
        if (r9 != null) goto L74;
        String r23 = "";
    L75:
        r0.setOriginPath(r23);
        if (r9 == null) goto L81;
        ImageSet r24 = r9.image;
        if (r24 == null) goto L81;
        String r25 = r24.key;
    L82:
        r0.setImageSetKey(r25);
        if (r9 == null) goto L88;
        String r26 = r9.image_path;
        if (r26 == null) goto L88;
        r1 = r26;
    L88:
        r0.setCoverPath(r1);
        if (r9 != null) goto L91;
    L95:
        r12 = false;
    L96:
        r0.setNeedCopy(r12);
        if (r9 == null) goto L100;
        ResourceCleanScene.a r27 = ResourceCleanScene.Companion;
        com.bytedance.lark.pb.basic.v1.ResourceCleanScene r28 = r9.clean_resource_scene;
        r27.getClass();
        r8 = ResourceCleanScene.a.a(r28);
    L100:
        r0.setResourceCleanScene(r8);
        if (r9 != null) goto L103;
        int r29 = 0;
    L104:
        r0.setWidth(r29);
        if (r9 == null) goto L108;
        r13 = r9.height.intValue();
    L108:
        r0.setHeight(r13);
        return r0;
    L103:
        r29 = r9.width.intValue();
        goto L104
    L91:
        if (r9.need_copy_img.booleanValue() == false) goto L95;
        if (r9.need_copy_media.booleanValue() == false) goto L95;
    L81:
        r25 = "";
        goto L82
    L74:
        r23 = r9.origin_path;
        goto L75
    L70:
        r22 = r9.compress_path;
        goto L71
    L66:
        r21 = r9.url;
        goto L67
    L62:
        r20 = r9.duration.intValue();
        goto L63
    L54:
        if (r0.getThumbImage() == null) goto L56;
        r0.setFsUnit(r0.getThumbImage().getFsUnit());
        r0.setCrypto(r0.getThumbImage().getCrypto());
        goto L60
    L56:
        if (r9 != null) goto L58;
        String r30 = "";
    L59:
        r0.setFsUnit(r30);
        Log.i("ModelParserRichTextProperty", "there is no origin or thumbnail, fsUnit " + r0.getFsUnit());
        goto L60
    L58:
        r30 = r9.fs_unit;
        goto L59
    L47:
        r19 = false;
        goto L48
    L41:
        if (TextUtils.isEmpty(r16.key) == true) goto L43;
        r17 = h(r14.thumbnail_webp);
    L49:
        r18 = null;
    L32:
        r11 = null;
        goto L33
    L25:
        r7 = RichTextElement.MediaProperty.Source.forNumber(r9.source.getValue());
        goto L26
    L21:
        r6 = r9.crypto_token;
        goto L22
    L17:
        r5 = r9.mime;
        goto L18
    L13:
        r4 = r9.size.longValue();
        goto L14
    L9:
        r3 = r9.name;
        goto L10
    L5:
        r2 = r9.key;
        goto L6
    }

    public static RichTextElement.MentionProperty m(com.bytedance.lark.pb.basic.v1.RichTextElement.MentionProperty r3) {
        RichTextElement.MentionProperty r0 = new RichTextElement.MentionProperty();
        if (r3 == null) goto L5;
        String r1 = r3.content;
    L6:
        r0.setContent(r1);
        RichTextElement.MentionItem r2 = new RichTextElement.MentionItem();
        if (r3 == null) goto L11;
        com.bytedance.lark.pb.basic.v1.RichTextElement.MentionItem r4 = r3.item;
        if (r4 == null) goto L11;
        r2.setId(r4.id);
        r2.setType(RichTextElement.MentionItem.MentionType.valueOf(r3.item.type.getValue()));
    L11:
        r0.setMentionItem(r2);
        return r0;
    L5:
        r1 = "";
        goto L6
    }

    public static RichTextElement.MyAIToolProperty n(com.bytedance.lark.pb.basic.v1.RichTextElement.MyAIToolProperty r3) {
        RichTextElement.MyAIToolProperty r0 = new RichTextElement.MyAIToolProperty();
        if (r3 != null) goto L5;
        RichTextElement.MyAIToolProperty.Status r1 = RichTextElement.MyAIToolProperty.Status.FAILED;
    L6:
        r0.setStatus(r1);
        com.bytedance.lark.pb.basic.v1.RichTextElement.MyAIToolProperty.Icon r2 = null;
        if (r3 != null) goto L9;
        String r4 = null;
    L10:
        r0.setTool_id(r4);
        if (r3 != null) goto L13;
        String r5 = null;
    L14:
        r0.setTool_runtime_id(r5);
        if (r3 != null) goto L17;
        Map r6 = null;
    L18:
        r0.setI18n_name(r6);
        if (r3 != null) goto L21;
        String r7 = null;
    L22:
        r0.setText(r7);
        if (r3 == null) goto L26;
        r2 = r3.icon;
    L26:
        r0.setIcon(r2);
        return r0;
    L21:
        r7 = r3.text;
        goto L22
    L17:
        r6 = r3.i18n_name;
        goto L18
    L13:
        r5 = r3.tool_runtime_id;
        goto L14
    L9:
        r4 = r3.tool_id;
        goto L10
    L5:
        r1 = RichTextElement.MyAIToolProperty.Status.fromValue(r3.status.getValue());
        goto L6
    }

    public static RichTextElement.OverflowMenuProperty o(com.bytedance.lark.pb.basic.v1.RichTextElement.OverflowMenuProperty r6) throws Exception {
        RichTextElement.OverflowMenuProperty r0 = new RichTextElement.OverflowMenuProperty();
        if (r6 != null) goto L5;
        String r1 = "";
    L6:
        r0.setActionId(r1);
        boolean r2 = false;
        if (r6 != null) goto L9;
        boolean r3 = false;
    L10:
        r0.setDisable(r3);
        if (r6 == null) goto L14;
        r2 = r6.is_loading.booleanValue();
    L14:
        r0.setLoading(r2);
        if (r6 == null) goto L36;
        List r4 = r6.options;
        if (r4 != null) goto L19;
    L25:
        com.bytedance.lark.pb.basic.v1.RichTextElement.ButtonConfirmProperty r5 = r6.confirm;
        if (r5 == null) goto L36;
        if (TextUtils.isEmpty(r5.title) == true) goto L36;
        if (TextUtils.isEmpty(r6.confirm.text) == true) goto L36;
        if (TextUtils.isEmpty(r6.confirm.confirm) == true) goto L36;
        if (TextUtils.isEmpty(r6.confirm.dismiss) == true) goto L36;
        RichTextElement.ConfirmProperty r7 = new RichTextElement.ConfirmProperty();
        r7.setTitle(r6.confirm.title);
        r7.setTitleI18NKey(r6.confirm.title_i18n_key);
        r7.setText(r6.confirm.text);
        r7.setTextI18NKey(r6.confirm.text_i18n_key);
        r7.setConfirm(r6.confirm.confirm);
        r7.setConfirmI18NKey(r6.confirm.confirm_i18n_key);
        r7.setDismiss(r6.confirm.dismiss);
        r7.setDismissI18NKey(r6.confirm.dismiss_i18n_key);
        r0.setConfirm(r7);
        goto L36
    L19:
        if (r4.size() <= 0) goto L25;
        ArrayList r8 = new ArrayList();
        Iterator r9 = r6.options.iterator();
    L22:
        if (r9.hasNext() == false) goto L24;
        com.bytedance.lark.pb.basic.v1.RichTextElement.MenuOption r10 = (com.bytedance.lark.pb.basic.v1.RichTextElement.MenuOption) r9.next();
        RichTextElement.MenuOption r11 = new RichTextElement.MenuOption();
        r11.setText(r10.text);
        r11.setI18Key(r10.text_i18n_key);
        r11.setValue(r10.value);
        r11.setOptionActionId(r10.option_action_id);
        r8.add(r11);
        goto L22
    L24:
        r0.setOptions(r8);
    L36:
        return r0;
    L9:
        r3 = r6.disable.booleanValue();
        goto L10
    L5:
        r1 = r6.action_id;
        goto L6
    }

    public static RichTextElement.ProgressSelectOptionProperty p(com.bytedance.lark.pb.basic.v1.RichTextElement.ProgressSelectOptionProperty r4) throws Exception {
        RichTextElement.ProgressSelectOptionProperty r0 = new RichTextElement.ProgressSelectOptionProperty();
        String r1 = "";
        if (r4 != null) goto L5;
        String r2 = "";
    L6:
        r0.setActionId(r2);
        if (r4 != null) goto L9;
        String r3 = "";
    L10:
        r0.setActionParamName(r3);
        if (r4 != null) goto L13;
        String r5 = "";
    L14:
        r0.setActionParamValue(r5);
        int r6 = 0;
        if (r4 != null) goto L17;
        boolean r7 = false;
    L18:
        r0.setDisable(r7);
        if (r4 != null) goto L21;
        boolean r8 = false;
    L22:
        r0.setSelected(r8);
        if (r4 != null) goto L25;
        String r9 = "";
    L26:
        r0.setOptionCase(r9);
        if (r4 == null) goto L30;
        r1 = r4.content;
    L30:
        r0.setContent(r1);
        if (r4 != null) goto L33;
        int r10 = 0;
    L34:
        r0.setNumberOfSelected(r10);
        if (r4 == null) goto L38;
        r6 = r4.number_of_total.intValue();
    L38:
        r0.setNumberOfTotal(r6);
        return r0;
    L33:
        r10 = r4.number_of_selected.intValue();
        goto L34
    L25:
        r9 = r4.option_case;
        goto L26
    L21:
        r8 = r4.selected.booleanValue();
        goto L22
    L17:
        r7 = r4.disable.booleanValue();
        goto L18
    L13:
        r5 = r4.action_param_value;
        goto L14
    L9:
        r3 = r4.action_param_name;
        goto L10
    L5:
        r2 = r4.action_id;
        goto L6
    }

    public static RichTextElement.SelectMenuProperty q(com.bytedance.lark.pb.basic.v1.RichTextElement.SelectMenuProperty r6) throws Exception {
        RichTextElement.SelectMenuProperty r0 = new RichTextElement.SelectMenuProperty();
        String r1 = "";
        if (r6 != null) goto L5;
        String r2 = "";
    L6:
        r0.setActionId(r2);
        if (r6 != null) goto L9;
        String r3 = "";
    L10:
        r0.setPlaceHolder(r3);
        if (r6 != null) goto L13;
        RichTextElement.SelectMenuProperty.Type r4 = RichTextElement.SelectMenuProperty.Type.UNKNOWN;
    L14:
        r0.setType(r4);
        if (r6 != null) goto L17;
        String r5 = "";
    L18:
        r0.setPlaceHolderI18nKey(r5);
        if (r6 == null) goto L22;
        r1 = r6.initial_option;
    L22:
        r0.setInitialOption(r1);
        boolean r7 = false;
        if (r6 != null) goto L25;
        boolean r8 = false;
    L26:
        r0.setDisable(r8);
        if (r6 == null) goto L30;
        r7 = r6.is_loading.booleanValue();
    L30:
        r0.setLoading(r7);
        if (r6 == null) goto L52;
        List r9 = r6.options;
        if (r9 != null) goto L35;
    L41:
        com.bytedance.lark.pb.basic.v1.RichTextElement.ButtonConfirmProperty r10 = r6.confirm;
        if (r10 == null) goto L52;
        if (TextUtils.isEmpty(r10.title) == true) goto L52;
        if (TextUtils.isEmpty(r6.confirm.text) == true) goto L52;
        if (TextUtils.isEmpty(r6.confirm.confirm) == true) goto L52;
        if (TextUtils.isEmpty(r6.confirm.dismiss) == true) goto L52;
        RichTextElement.ConfirmProperty r11 = new RichTextElement.ConfirmProperty();
        r11.setTitle(r6.confirm.title);
        r11.setTitleI18NKey(r6.confirm.title_i18n_key);
        r11.setText(r6.confirm.text);
        r11.setTextI18NKey(r6.confirm.text_i18n_key);
        r11.setConfirm(r6.confirm.confirm);
        r11.setConfirmI18NKey(r6.confirm.confirm_i18n_key);
        r11.setDismiss(r6.confirm.dismiss);
        r11.setDismissI18NKey(r6.confirm.dismiss_i18n_key);
        r0.setConfirm(r11);
        goto L52
    L35:
        if (r9.size() <= 0) goto L41;
        ArrayList r12 = new ArrayList();
        Iterator r13 = r6.options.iterator();
    L38:
        if (r13.hasNext() == false) goto L40;
        com.bytedance.lark.pb.basic.v1.RichTextElement.MenuOption r14 = (com.bytedance.lark.pb.basic.v1.RichTextElement.MenuOption) r13.next();
        RichTextElement.MenuOption r15 = new RichTextElement.MenuOption();
        r15.setText(r14.text);
        r15.setI18Key(r14.text_i18n_key);
        r15.setValue(r14.value);
        r12.add(r15);
        goto L38
    L40:
        r0.setOptions(r12);
    L52:
        return r0;
    L25:
        r8 = r6.disable.booleanValue();
        goto L26
    L17:
        r5 = r6.place_holder_i18n_key;
        goto L18
    L13:
        r4 = RichTextElement.SelectMenuProperty.Type.forType(r6.type.getValue());
        goto L14
    L9:
        r3 = r6.place_holder;
        goto L10
    L5:
        r2 = r6.action_id;
        goto L6
    }

    public static RichTextElement.TableCellProperty r(com.bytedance.lark.pb.basic.v1.RichTextElement.TableCellProperty r3) {
        RichTextElement.TableCellProperty r0 = new RichTextElement.TableCellProperty();
        boolean r1 = true;
        if (r3 != null) goto L5;
    L8:
        int r2 = 1;
    L9:
        r0.setColumnSpan(r2);
        if (r3 != null) goto L12;
    L15:
        int r4 = 1;
    L16:
        r0.setRowSpan(r4);
        if (r3 != null) goto L19;
        HorizontalAlign r5 = HorizontalAlign.HORIZONTAL_ALIGN_CENTER;
    L20:
        r0.setHorizontalAlign(r5);
        if (r3 != null) goto L23;
        VerticalAlign r6 = VerticalAlign.VERTICAL_ALIGN_CENTER;
    L24:
        r0.setVerticalAlign(r6);
        if (r3 != null) goto L27;
    L29:
        r1 = false;
    L30:
        r0.setMerged(r1);
        return r0;
    L27:
        if (r3.is_merged.booleanValue() == false) goto L29;
    L23:
        r6 = VerticalAlign.fromValue(r3.vertical_align.getValue());
        goto L24
    L19:
        r5 = HorizontalAlign.fromValue(r3.horizontal_align.getValue());
        goto L20
    L12:
        if (r3.rowspan.intValue() <= 0) goto L15;
        r4 = r3.rowspan.intValue();
        goto L16
    L5:
        if (r3.colspan.intValue() <= 0) goto L8;
        r2 = r3.colspan.intValue();
        goto L9
    }

    public static RichTextElement.TableProperty s(com.bytedance.lark.pb.basic.v1.RichTextElement.TableProperty r7) {
        RichTextElement.TableProperty r0 = new RichTextElement.TableProperty();
        LinkedList r1 = new LinkedList();
        if (r7 != null) goto L5;
    L14:
        r0.setColumns(r1);
        return r0;
    L5:
        if (CollectionUtils.isEmpty(r7.columns) == true) goto L14;
        Iterator r8 = r7.columns.iterator();
    L8:
        if (r8.hasNext() == false) goto L14;
        com.bytedance.lark.pb.basic.v1.RichTextElement.TableProperty.Column r2 = (com.bytedance.lark.pb.basic.v1.RichTextElement.TableProperty.Column) r8.next();
        if (r2.width.intValue() > 0) goto L12;
        int r3 = 100;
    L13:
        r1.add(new Column(Integer.valueOf(r3), HorizontalAlign.fromValue(r2.horizontal_align.getValue()), VerticalAlign.fromValue(r2.vertical_align.getValue()), r2.is_header.booleanValue()));
        goto L8
    L12:
        r3 = r2.width.intValue();
        goto L13
    }

    public static RichTextElement.TableRowProperty t(com.bytedance.lark.pb.basic.v1.RichTextElement.TableRowProperty r2) {
        RichTextElement.TableRowProperty r0 = new RichTextElement.TableRowProperty();
        if (r2 != null) goto L5;
        HorizontalAlign r1 = HorizontalAlign.HORIZONTAL_ALIGN_CENTER;
    L6:
        r0.setHorizontalAlign(r1);
        if (r2 != null) goto L9;
        VerticalAlign r3 = VerticalAlign.VERTICAL_ALIGN_CENTER;
    L10:
        r0.setVerticalAlign(r3);
        if (r2 != null) goto L13;
    L15:
        boolean r4 = false;
    L16:
        r0.setHeader(r4);
        return r0;
    L13:
        if (r2.is_header.booleanValue() == false) goto L15;
        r4 = true;
        goto L16
    L9:
        r3 = VerticalAlign.fromValue(r2.vertical_align.getValue());
        goto L10
    L5:
        r1 = HorizontalAlign.fromValue(r2.horizontal_align.getValue());
        goto L6
    }

    public static String u(com.bytedance.lark.pb.basic.v1.RichTextElement.ImageProperty r1) {
        if (r1 != null) goto L5;
        return "";
    L5:
        com.bytedance.lark.pb.basic.v1.Image r0 = r1.thumbnail_webp;
        if (r0 == null) goto L12;
        if (TextUtils.isEmpty(r0.key) == true) goto L12;
        return r1.thumbnail_webp.key;
    L12:
        return r1.thumb_key;
    }

    public static RichTextElement.TimePickerProperty v(com.bytedance.lark.pb.basic.v1.RichTextElement.TimePickerProperty r3) throws Exception {
        RichTextElement.TimePickerProperty r0 = new RichTextElement.TimePickerProperty();
        String r1 = "";
        if (r3 != null) goto L5;
        String r2 = "";
    L6:
        r0.setActionId(r2);
        if (r3 != null) goto L9;
        String r4 = "";
    L10:
        r0.setPlaceHolder(r4);
        if (r3 != null) goto L13;
        String r5 = "";
    L14:
        r0.setInitialTime(r5);
        if (r3 == null) goto L18;
        r1 = r3.place_holder_i18n_key;
    L18:
        r0.setPlaceHolderI18nKey(r1);
        boolean r6 = false;
        if (r3 != null) goto L21;
        boolean r7 = false;
    L22:
        r0.setDisable(r7);
        if (r3 == null) goto L26;
        r6 = r3.is_loading.booleanValue();
    L26:
        r0.setLoading(r6);
        if (r3 == null) goto L39;
        com.bytedance.lark.pb.basic.v1.RichTextElement.ButtonConfirmProperty r8 = r3.confirm;
        if (r8 == null) goto L39;
        if (TextUtils.isEmpty(r8.title) == true) goto L39;
        if (TextUtils.isEmpty(r3.confirm.text) == true) goto L39;
        if (TextUtils.isEmpty(r3.confirm.confirm) == true) goto L39;
        if (TextUtils.isEmpty(r3.confirm.dismiss) == true) goto L39;
        RichTextElement.ConfirmProperty r9 = new RichTextElement.ConfirmProperty();
        r9.setTitle(r3.confirm.title);
        r9.setTitleI18NKey(r3.confirm.title_i18n_key);
        r9.setText(r3.confirm.text);
        r9.setTextI18NKey(r3.confirm.text_i18n_key);
        r9.setConfirm(r3.confirm.confirm);
        r9.setConfirmI18NKey(r3.confirm.confirm_i18n_key);
        r9.setDismiss(r3.confirm.dismiss);
        r9.setDismissI18NKey(r3.confirm.dismiss_i18n_key);
        r0.setConfirm(r9);
    L39:
        return r0;
    L21:
        r7 = r3.disable.booleanValue();
        goto L22
    L13:
        r5 = r3.initial_time;
        goto L14
    L9:
        r4 = r3.place_holder;
        goto L10
    L5:
        r2 = r3.action_id;
        goto L6
    }

    public static com.ss.android.lark.widget.richtext.Image i(com.bytedance.lark.pb.basic.v1.Image r2, com.bytedance.lark.pb.basic.v1.ResourceCleanScene r3) {
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
        if (r3 == null) goto L8;
        boolean r4 = true;
    L9:
        r0.setResourceIsCleaned(r4);
        ResourceCleanScene.Companion.getClass();
        r0.setResourceCleanScene(ResourceCleanScene.a.a(r3));
        return r0;
    L8:
        r4 = false;
        goto L9
    }
}
