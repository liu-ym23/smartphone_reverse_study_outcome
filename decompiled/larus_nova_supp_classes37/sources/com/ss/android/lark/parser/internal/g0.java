package com.ss.android.lark.parser.internal;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.ImageSetV2;
import com.bytedance.lark.pb.basic.v1.LingoOption;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.widget.richtext.LingoLocalExtraData;
import com.ss.android.lark.widget.richtext.MarkdownImageSet;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g0 {

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RichTextElement.RichTextTag.values().length];
            a = r0;
            r0[RichTextElement.RichTextTag.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L53
        L134:
            a[RichTextElement.RichTextTag.IMG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L54
        L162:
            a[RichTextElement.RichTextTag.PARAGRAPH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L55
        L174:
            a[RichTextElement.RichTextTag.FIGURE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L56
        L180:
            a[RichTextElement.RichTextTag.AT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L57
        L112:
            a[RichTextElement.RichTextTag.ANCHOR.ordinal()] = 6;     // Catch: NoSuchFieldError -> L58
        L118:
            a[RichTextElement.RichTextTag.BOLD.ordinal()] = 7;     // Catch: NoSuchFieldError -> L59
        L148:
            a[RichTextElement.RichTextTag.ITALIC.ordinal()] = 8;     // Catch: NoSuchFieldError -> L60
        L154:
            a[RichTextElement.RichTextTag.UNDERLINE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L61
        L186:
            a[RichTextElement.RichTextTag.EMOTION.ordinal()] = 10;     // Catch: NoSuchFieldError -> L62
        L192:
            a[RichTextElement.RichTextTag.BUTTON.ordinal()] = 11;     // Catch: NoSuchFieldError -> L63
        L124:
            a[RichTextElement.RichTextTag.SELECT.ordinal()] = 12;     // Catch: NoSuchFieldError -> L64
        L132:
            a[RichTextElement.RichTextTag.PROGRESS_SELECT_OPTION.ordinal()] = 13;     // Catch: NoSuchFieldError -> L65
        L160:
            a[RichTextElement.RichTextTag.DIV.ordinal()] = 14;     // Catch: NoSuchFieldError -> L66
        L168:
            a[RichTextElement.RichTextTag.TEXTABLEAREA.ordinal()] = 15;     // Catch: NoSuchFieldError -> L67
        L198:
            a[RichTextElement.RichTextTag.TIME.ordinal()] = 16;     // Catch: NoSuchFieldError -> L68
        L106:
            a[RichTextElement.RichTextTag.LINK.ordinal()] = 17;     // Catch: NoSuchFieldError -> L69
        L138:
            a[RichTextElement.RichTextTag.MEDIA.ordinal()] = 18;     // Catch: NoSuchFieldError -> L70
        L142:
            a[RichTextElement.RichTextTag.SELECTMENU.ordinal()] = 19;     // Catch: NoSuchFieldError -> L71
        L172:
            a[RichTextElement.RichTextTag.OVERFLOWMENU.ordinal()] = 20;     // Catch: NoSuchFieldError -> L72
        L178:
            a[RichTextElement.RichTextTag.DATEPICKER.ordinal()] = 21;     // Catch: NoSuchFieldError -> L73
        L110:
            a[RichTextElement.RichTextTag.DOCS.ordinal()] = 22;     // Catch: NoSuchFieldError -> L74
        L116:
            a[RichTextElement.RichTextTag.H1.ordinal()] = 23;     // Catch: NoSuchFieldError -> L75
        L146:
            a[RichTextElement.RichTextTag.H2.ordinal()] = 24;     // Catch: NoSuchFieldError -> L76
        L152:
            a[RichTextElement.RichTextTag.H3.ordinal()] = 25;     // Catch: NoSuchFieldError -> L77
        L184:
            a[RichTextElement.RichTextTag.H4.ordinal()] = 26;     // Catch: NoSuchFieldError -> L78
        L190:
            a[RichTextElement.RichTextTag.H5.ordinal()] = 27;     // Catch: NoSuchFieldError -> L79
        L122:
            a[RichTextElement.RichTextTag.H6.ordinal()] = 28;     // Catch: NoSuchFieldError -> L80
        L130:
            a[RichTextElement.RichTextTag.UL.ordinal()] = 29;     // Catch: NoSuchFieldError -> L81
        L158:
            a[RichTextElement.RichTextTag.OL.ordinal()] = 30;     // Catch: NoSuchFieldError -> L82
        L166:
            a[RichTextElement.RichTextTag.LI.ordinal()] = 31;     // Catch: NoSuchFieldError -> L83
        L196:
            a[RichTextElement.RichTextTag.QUOTE.ordinal()] = 32;     // Catch: NoSuchFieldError -> L84
        L104:
            a[RichTextElement.RichTextTag.CODE.ordinal()] = 33;     // Catch: NoSuchFieldError -> L85
        L136:
            a[RichTextElement.RichTextTag.CODE_BLOCK.ordinal()] = 34;     // Catch: NoSuchFieldError -> L86
        L140:
            a[RichTextElement.RichTextTag.HR.ordinal()] = 35;     // Catch: NoSuchFieldError -> L87
        L170:
            a[RichTextElement.RichTextTag.TIMEPICKER.ordinal()] = 36;     // Catch: NoSuchFieldError -> L88
        L176:
            a[RichTextElement.RichTextTag.DATETIMEPICKER.ordinal()] = 37;     // Catch: NoSuchFieldError -> L89
        L108:
            a[RichTextElement.RichTextTag.MENTION.ordinal()] = 38;     // Catch: NoSuchFieldError -> L90
        L114:
            a[RichTextElement.RichTextTag.CODE_BLOCK_V2.ordinal()] = 39;     // Catch: NoSuchFieldError -> L91
        L144:
            a[RichTextElement.RichTextTag.MY_AI_TOOL.ordinal()] = 40;     // Catch: NoSuchFieldError -> L92
        L150:
            a[RichTextElement.RichTextTag.TABLE.ordinal()] = 41;     // Catch: NoSuchFieldError -> L93
        L182:
            a[RichTextElement.RichTextTag.TABLE_ROW.ordinal()] = 42;     // Catch: NoSuchFieldError -> L94
        L188:
            a[RichTextElement.RichTextTag.TABLE_CELL.ordinal()] = 43;     // Catch: NoSuchFieldError -> L95
        L120:
            a[RichTextElement.RichTextTag.COLUMNS.ordinal()] = 44;     // Catch: NoSuchFieldError -> L96
        L128:
            a[RichTextElement.RichTextTag.COLUMN.ordinal()] = 45;     // Catch: NoSuchFieldError -> L97
        L156:
            a[RichTextElement.RichTextTag.AT_USER_GROUP.ordinal()] = 46;     // Catch: NoSuchFieldError -> L98
        L164:
            a[RichTextElement.RichTextTag.IMAGE_GALLERY.ordinal()] = 47;     // Catch: NoSuchFieldError -> L99
        L194:
            a[RichTextElement.RichTextTag.MARKDOWN.ordinal()] = 48;     // Catch: NoSuchFieldError -> L100
        L102:
            a[RichTextElement.RichTextTag.UNKNOWN_TAG.ordinal()] = 49;     // Catch: NoSuchFieldError -> L101
            return;
        }
    }

    public static Map<String, com.bytedance.lark.pb.basic.v1.RichTextElement.AtProperty> a(Map<String, RichTextElement.AtProperty> r5) {
        if (CollectionUtils.isEmpty(r5) == true) goto L5;
        HashMap r0 = new HashMap(r5.size());
        Iterator<Map.Entry<String, RichTextElement.AtProperty>> r6 = r5.entrySet().iterator();
    L8:
        if (r6.hasNext() == false) goto L13;
        Map.Entry<String, RichTextElement.AtProperty> r1 = r6.next();
        RichTextElement.AtProperty r2 = r1.getValue();
        if (r2 == null) goto L8;
        com.bytedance.lark.pb.basic.v1.RichTextElement.AtProperty.Builder r3 = new com.bytedance.lark.pb.basic.v1.RichTextElement.AtProperty.Builder().user_id(r2.getUserId()).is_outer(Boolean.valueOf(r2.isOutChatUser())).content(r2.getAtContentForPB()).is_anonymous(Boolean.valueOf(r2.isAnonymous())).is_highlight(Boolean.valueOf(r2.isHighLight()));
        r0.put(r1.getKey(), r3.build());
        goto L8
    L13:
        return r0;
    L5:
        return new HashMap();
    }

    public static Map<String, ImageSetV2> b(Map<String, MarkdownImageSet> r3) {
        if (CollectionUtils.isEmpty(r3) == true) goto L5;
        HashMap r0 = new HashMap(r3.size());
        Iterator<Map.Entry<String, MarkdownImageSet>> r4 = r3.entrySet().iterator();
    L8:
        if (r4.hasNext() == false) goto L16;
        Map.Entry<String, MarkdownImageSet> r1 = r4.next();
        MarkdownImageSet r2 = r1.getValue();
        if (r2 == null) goto L8;
        ImageSetV2 r5 = r2.toImageSetV2();
        if (r5 == null) goto L8;
        r0.put(r1.getKey(), r5);
        goto L8
    L16:
        return r0;
    L5:
        return new HashMap();
    }

    public static LingoOption c(RichText r2) {
        if (r2.getExtraInfo() != null) goto L5;
        return null;
    L5:
        if (r2.getExtraInfo().getLingoLocalExtraData() == null) goto L16;
        LingoLocalExtraData r3 = r2.getExtraInfo().getLingoLocalExtraData();
        LingoOption.Builder r0 = new LingoOption.Builder();
        if (r3.getHighlightIgnoreWords() == null) goto L10;
        r0.highlight_ignore_words(r3.getHighlightIgnoreWords());
    L10:
        if (r3.getPinInfo() == null) goto L13;
        r0.pin_info(r3.getPinInfo());
    L13:
        return r0.build();
    L16:
        return null;
    }

    public static com.bytedance.lark.pb.basic.v1.RichText d(RichText r3) {
        com.bytedance.lark.pb.basic.v1.RichText.Builder r0 = new com.bytedance.lark.pb.basic.v1.RichText.Builder();
        if (r3.getElementIds() != null) goto L5;
        List r1 = new ArrayList();
    L6:
        com.bytedance.lark.pb.basic.v1.RichText.Builder r2 = r0.element_ids(r1);
        if (r3.getInnerText() != null) goto L9;
        String r4 = "";
    L10:
        com.bytedance.lark.pb.basic.v1.RichText.Builder r5 = r2.inner_text(r4).elements(com.larksuite.framework.utils.y.b(r3.getElements().getDictionary(), new f0()));
        if (r3.getImageIds() != null) goto L13;
        List r6 = new ArrayList();
    L14:
        com.bytedance.lark.pb.basic.v1.RichText.Builder r7 = r5.image_ids(r6);
        if (r3.getAtIds() != null) goto L17;
        List r8 = new ArrayList();
    L18:
        com.bytedance.lark.pb.basic.v1.RichText.Builder r9 = r7.at_ids(r8);
        if (r3.getAnchorIds() != null) goto L21;
        List r10 = new ArrayList();
    L22:
        com.bytedance.lark.pb.basic.v1.RichText.Builder r11 = r9.anchor_ids(r10);
        if (r3.getMediaIds() != null) goto L25;
        List r12 = new ArrayList();
    L26:
        com.bytedance.lark.pb.basic.v1.RichText.Builder r13 = r11.media_ids(r12);
        if (r3.getAtUserGroupIds() != null) goto L29;
        ArrayList r14 = new ArrayList();
    L30:
        com.bytedance.lark.pb.basic.v1.RichText.Builder r15 = r13.at_user_group_ids(r14);
        if (r3.getMarkdownIds() != null) goto L33;
        List r16 = new ArrayList();
    L35:
        return r15.markdown_ids(r16).rich_text_version(Integer.valueOf(r3.getRichTextVersion())).build();
    L33:
        r16 = r3.getMarkdownIds();
        goto L35
    L29:
        r14 = r3.getAtUserGroupIds();
        goto L30
    L25:
        r12 = r3.getMediaIds();
        goto L26
    L21:
        r10 = r3.getAnchorIds();
        goto L22
    L17:
        r8 = r3.getAtIds();
        goto L18
    L13:
        r6 = r3.getImageIds();
        goto L14
    L9:
        r4 = r3.getInnerText();
        goto L10
    L5:
        r1 = r3.getElementIds();
        goto L6
    }

    public static RichText e(com.bytedance.lark.pb.basic.v1.RichText r5, HashMap r6) {
        RichText r0 = new RichText();
        if (r5 != null) goto L5;
        return r0;
    L5:
        r0.setElementIds(r5.element_ids);
        r0.setInnerText(r5.inner_text);
        Map r1 = r5.elements;
        RichText.RichTextElements r2 = new RichText.RichTextElements();
        if (r1 == null) goto L9;
        r2.setDictionary(com.larksuite.framework.utils.y.b(r1, new e0(r6)));
    L9:
        r0.setElements(r2);
        r0.setImageIds(r5.image_ids);
        r0.setAtIds(r5.at_ids);
        r0.setAnchorIds(r5.anchor_ids);
        r0.setMediaIds(r5.media_ids);
        r0.setDocsIds(r5.docs_ids);
        r0.setMarkdownIds(r5.markdown_ids);
        r0.setUrls(com.ss.android.lark.widget.richtext.d.j(r0));
        ArrayList r7 = new ArrayList();
        if (r0.getElements() != null) goto L12;
    L28:
        r0.setMyAIRunningToolsIds(r7);
        r0.setAtUserGroupIds(r5.at_user_group_ids);
        return r0;
    L12:
        if (r0.getElements().getDictionary() == null) goto L28;
        Iterator r3 = r0.getElements().getDictionary().entrySet().iterator();
    L15:
        if (r3.hasNext() == false) goto L28;
        Map.Entry r4 = (Map.Entry) r3.next();
        if (r4 == null) goto L15;
        if (TextUtils.isEmpty((CharSequence) r4.getKey()) == true) goto L15;
        if (r4.getValue() == null) goto L15;
        RichTextElement.MyAIToolProperty r8 = ((RichTextElement) r4.getValue()).getProperty();
        if ((r8 instanceof RichTextElement.MyAIToolProperty) == false) goto L15;
        if (r8.getStatus() != RichTextElement.MyAIToolProperty.Status.RUNING) goto L15;
        r7.add((String) r4.getKey());
        goto L15
    }
}
