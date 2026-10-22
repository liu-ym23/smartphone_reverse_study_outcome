package com.ss.android.lark.parser.internal;

import com.bytedance.lark.pb.basic.v1.RichTextElement;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.log.Log;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e0 implements com.larksuite.framework.utils.y.a<RichTextElement, com.ss.android.lark.widget.richtext.RichTextElement> {
    public final /* synthetic */ HashMap a;

    public e0(HashMap r1) {
        this.a = r1;
    }

    public final Object get(Object r8) {
        RichTextElement r9 = (RichTextElement) r8;
        HashMap r0 = this.a;
        com.ss.android.lark.widget.richtext.RichTextElement r1 = new com.ss.android.lark.widget.richtext.RichTextElement();
        if (r9 == null) goto L196;
        r1.setStyle(r9.style);
        r1.setStyleKeys(r9.style_keys);
        if (CollectionUtils.isEmpty(r0) == false) goto L8;
    L22:
        RichTextElement.Tag r2 = r9.tag;
        if (r2 == null) goto L25;
        r1.setTag(com.ss.android.lark.widget.richtext.RichTextElement.RichTextTag.valueOf(r2.getValue()));
    L26:
        RichTextElement.PropertySet r3 = r9.property;
    L194:
        com.ss.android.lark.widget.richtext.RichTextElement.MarkdownProperty r4 = new com.ss.android.lark.widget.richtext.RichTextElement.ParagraphProperty();
    L195:
        r1.setProperty(r4);
        r1.setChildIds(r9.child_ids);
        goto L196
    L28:
        int r5 = 0;
        long r6 = 0;
        String r7 = "";
        switch(g0.a.a[r1.getTag().ordinal()]) {
            case 1: goto L177;
            case 2: goto L176;
            case 3: goto L175;
            case 4: goto L174;
            case 5: goto L173;
            case 6: goto L172;
            case 7: goto L163;
            case 8: goto L154;
            case 9: goto L145;
            case 10: goto L139;
            case 11: goto L138;
            case 12: goto L129;
            case 13: goto L128;
            case 14: goto L127;
            case 15: goto L122;
            case 16: goto L105;
            case 17: goto L90;
            case 18: goto L89;
            case 19: goto L88;
            case 20: goto L87;
            case 21: goto L86;
            case 22: goto L85;
            case 23: goto L84;
            case 24: goto L83;
            case 25: goto L82;
            case 26: goto L81;
            case 27: goto L80;
            case 28: goto L79;
            case 29: goto L74;
            case 30: goto L65;
            case 31: goto L64;
            case 32: goto L63;
            case 33: goto L62;
            case 34: goto L61;
            case 35: goto L60;
            case 36: goto L59;
            case 37: goto L58;
            case 38: goto L57;
            case 39: goto L56;
            case 40: goto L55;
            case 41: goto L54;
            case 42: goto L53;
            case 43: goto L52;
            case 44: goto L51;
            case 45: goto L46;
            case 46: goto L33;
            case 47: goto L32;
            case 48: goto L31;
            default: goto L192;
        };
    L31:
        r4 = z.k(r3.markdown);     // Catch: Exception -> L194
        goto L195
    L32:
        RichTextElement.ImageGalleryProperty r10 = r3.image_gallery;     // Catch: Exception -> L194
        r4 = new com.ss.android.lark.widget.richtext.RichTextElement.ImageGalleryProperty();     // Catch: Exception -> L194
        goto L195
    L33:
        RichTextElement.AtUserGroupProperty r11 = r3.at_user_group;     // Catch: Exception -> L194
        com.ss.android.lark.widget.richtext.RichTextElement.MarkdownProperty r12 = new com.ss.android.lark.widget.richtext.RichTextElement.AtUserGroupProperty();     // Catch: Exception -> L194
        if (r11 == null) goto L37;
        r6 = r11.user_group_id.longValue();     // Catch: Exception -> L194
    L37:
        r12.setUserGroupId(r6);     // Catch: Exception -> L194
        if (r11 == null) goto L41;
        r7 = r11.default_group_name;     // Catch: Exception -> L194
    L41:
        r12.setDefaultGroupName(r7);     // Catch: Exception -> L194
        if (r11 != null) goto L44;
        Map r13 = Collections.emptyMap();     // Catch: Exception -> L194
    L45:
        r12.setI18nGroupName(r13);     // Catch: Exception -> L194
    L144:
        r4 = r12;
        goto L195
    L44:
        r13 = r11.i18n_group_name;     // Catch: Exception -> L194
        goto L45
    L46:
        RichTextElement.ColumnProperty r14 = r3.column;     // Catch: Exception -> L194
        r12 = new com.ss.android.lark.widget.richtext.RichTextElement.ColumnProperty();     // Catch: Exception -> L194
        if (r14 != null) goto L49;
        int r15 = 100;
    L50:
        r12.setWidth(r15);     // Catch: Exception -> L194
        goto L144
    L49:
        r15 = r14.width.intValue();     // Catch: Exception -> L194
        goto L50
    L51:
        RichTextElement.ColumnsProperty r16 = r3.columns;     // Catch: Exception -> L194
        r4 = new com.ss.android.lark.widget.richtext.RichTextElement.ColumnsProperty();     // Catch: Exception -> L194
        goto L195
    L52:
        r4 = z.r(r3.table_cell);     // Catch: Exception -> L194
        goto L195
    L53:
        r4 = z.t(r3.table_row);     // Catch: Exception -> L194
        goto L195
    L54:
        r4 = z.s(r3.table);     // Catch: Exception -> L194
        goto L195
    L55:
        r4 = z.n(r3.my_ai_tool);     // Catch: Exception -> L194
        goto L195
    L56:
        r4 = z.e(r3.code_block_v2);     // Catch: Exception -> L194
        goto L195
    L57:
        r4 = z.m(r3.mention);     // Catch: Exception -> L194
        goto L195
    L58:
        r4 = z.g(r3.datetime_picker);     // Catch: Exception -> L194
        goto L195
    L59:
        r4 = z.v(r3.time_picker);     // Catch: Exception -> L194
        goto L195
    L60:
        RichTextElement.HRProperty r17 = r3.hr;     // Catch: Exception -> L194
        r4 = new com.ss.android.lark.widget.richtext.RichTextElement.HRProperty();     // Catch: Exception -> L194
        goto L195
    L61:
        r4 = z.d(r3.code_block);     // Catch: Exception -> L194
        goto L195
    L62:
        RichTextElement.CodeProperty r18 = r3.code;     // Catch: Exception -> L194
        r4 = new com.ss.android.lark.widget.richtext.RichTextElement.CodeProperty();     // Catch: Exception -> L194
        goto L195
    L63:
        RichTextElement.QuoteProperty r19 = r3.quote;     // Catch: Exception -> L194
        r4 = new com.ss.android.lark.widget.richtext.RichTextElement.QuoteProperty();     // Catch: Exception -> L194
        goto L195
    L64:
        RichTextElement.LIProperty r20 = r3.li;     // Catch: Exception -> L194
        r4 = new com.ss.android.lark.widget.richtext.RichTextElement.LIProperty();     // Catch: Exception -> L194
        goto L195
    L65:
        RichTextElement.OLProperty r21 = r3.ol;     // Catch: Exception -> L194
        r12 = new com.ss.android.lark.widget.richtext.RichTextElement.OLProperty();     // Catch: Exception -> L194
        if (r21 != null) goto L68;
        com.ss.android.lark.widget.richtext.RichTextElement.OLProperty.Type r22 = com.ss.android.lark.widget.richtext.RichTextElement.OLProperty.Type.NUMBER;     // Catch: Exception -> L194
    L69:
        r12.setType(r22);     // Catch: Exception -> L194
        if (r21 == null) goto L73;
        r5 = r21.start.intValue();     // Catch: Exception -> L194
    L73:
        r12.setStart(r5);     // Catch: Exception -> L194
        goto L144
    L68:
        r22 = com.ss.android.lark.widget.richtext.RichTextElement.OLProperty.Type.forType(r21.type.getValue());     // Catch: Exception -> L194
        goto L69
    L74:
        RichTextElement.ULProperty r23 = r3.ul;     // Catch: Exception -> L194
        r12 = new com.ss.android.lark.widget.richtext.RichTextElement.ULProperty();     // Catch: Exception -> L194
        if (r23 != null) goto L77;
        com.ss.android.lark.widget.richtext.RichTextElement.ULProperty.Type r24 = com.ss.android.lark.widget.richtext.RichTextElement.ULProperty.Type.DISC;     // Catch: Exception -> L194
    L78:
        r12.setType(r24);     // Catch: Exception -> L194
        goto L144
    L77:
        r24 = com.ss.android.lark.widget.richtext.RichTextElement.ULProperty.Type.forType(r23.type.getValue());     // Catch: Exception -> L194
        goto L78
    L79:
        RichTextElement.H6Property r25 = r3.h6;     // Catch: Exception -> L194
        r4 = new com.ss.android.lark.widget.richtext.RichTextElement.H6Property();     // Catch: Exception -> L194
        goto L195
    L80:
        RichTextElement.H5Property r26 = r3.h5;     // Catch: Exception -> L194
        r4 = new com.ss.android.lark.widget.richtext.RichTextElement.H5Property();     // Catch: Exception -> L194
        goto L195
    L81:
        RichTextElement.H4Property r27 = r3.h4;     // Catch: Exception -> L194
        r4 = new com.ss.android.lark.widget.richtext.RichTextElement.H4Property();     // Catch: Exception -> L194
        goto L195
    L82:
        RichTextElement.H3Property r28 = r3.h3;     // Catch: Exception -> L194
        r4 = new com.ss.android.lark.widget.richtext.RichTextElement.H3Property();     // Catch: Exception -> L194
        goto L195
    L83:
        RichTextElement.H2Property r29 = r3.h2;     // Catch: Exception -> L194
        r4 = new com.ss.android.lark.widget.richtext.RichTextElement.H2Property();     // Catch: Exception -> L194
        goto L195
    L84:
        RichTextElement.H1Property r30 = r3.h1;     // Catch: Exception -> L194
        r4 = new com.ss.android.lark.widget.richtext.RichTextElement.H1Property();     // Catch: Exception -> L194
        goto L195
    L85:
        RichTextElement.DocsProperty r31 = r3.docs;     // Catch: Exception -> L194
        r4 = new com.ss.android.lark.widget.richtext.RichTextElement.DocsProperty();     // Catch: Exception -> L194
        goto L195
    L86:
        r4 = z.f(r3.date_picker);     // Catch: Exception -> L194
        goto L195
    L87:
        r4 = z.o(r3.overflow_menu);     // Catch: Exception -> L194
        goto L195
    L88:
        r4 = z.q(r3.select_menu);     // Catch: Exception -> L194
        goto L195
    L89:
        r4 = z.l(r3.media);     // Catch: Exception -> L194
        goto L195
    L90:
        RichTextElement.LinkProperty r32 = r3.link;     // Catch: Exception -> L194
        r12 = new com.ss.android.lark.widget.richtext.RichTextElement.LinkProperty();     // Catch: Exception -> L194
        if (r32 != null) goto L93;
        String r33 = "";
    L94:
        r12.setAndroidUrl(r33);     // Catch: Exception -> L194
        if (r32 == null) goto L98;
        r7 = r32.url;     // Catch: Exception -> L194
    L98:
        r12.setUrl(r7);     // Catch: Exception -> L194
        if (r32 == null) goto L103;
        RichTextElement.LinkProperty.LinkScene r34 = r32.scene;     // Catch: Exception -> L194
        if (r34 == null) goto L103;
        com.ss.android.lark.widget.richtext.RichTextElement.LinkProperty.Source r35 = com.ss.android.lark.widget.richtext.RichTextElement.LinkProperty.Source.valueOf(r34.getValue());     // Catch: Exception -> L194
    L104:
        r12.setSource(r35);     // Catch: Exception -> L194
    L103:
        r35 = com.ss.android.lark.widget.richtext.RichTextElement.LinkProperty.Source.UNKNOWN;     // Catch: Exception -> L194
        goto L104
    L93:
        r33 = r32.android_url;     // Catch: Exception -> L194
        goto L94
    L105:
        RichTextElement.TimeProperty r36 = r3.time;     // Catch: Exception -> L194
        r12 = new com.ss.android.lark.widget.richtext.RichTextElement.TimeProperty();     // Catch: Exception -> L194
        if (r36 == null) goto L109;
        r6 = r36.millisecond_since1970.longValue();     // Catch: Exception -> L194
    L109:
        r12.setMillisecondSince1970(r6);     // Catch: Exception -> L194
        if (r36 != null) goto L112;
        String r37 = "";
    L113:
        r12.setFormat(r37);     // Catch: Exception -> L194
        if (r36 != null) goto L116;
        String r38 = "";
    L117:
        r12.setFormat_type(r38);     // Catch: Exception -> L194
        if (r36 == null) goto L121;
        r7 = r36.link;     // Catch: Exception -> L194
    L121:
        r12.setLink(r7);     // Catch: Exception -> L194
        goto L144
    L116:
        r38 = r36.format_type;     // Catch: Exception -> L194
        goto L117
    L112:
        r37 = r36.format;     // Catch: Exception -> L194
        goto L113
    L122:
        RichTextElement.TextableAreaProperty r39 = r3.textable_area;     // Catch: Exception -> L194
        r12 = new com.ss.android.lark.widget.richtext.RichTextElement.TextableAreaProperty();     // Catch: Exception -> L194
        if (r39 == null) goto L126;
        r5 = r39.numberOfLines.intValue();     // Catch: Exception -> L194
    L126:
        r12.setNumberOfLines(r5);     // Catch: Exception -> L194
        goto L144
    L127:
        RichTextElement.DivProperty r40 = r3.div;     // Catch: Exception -> L194
        r4 = new com.ss.android.lark.widget.richtext.RichTextElement.DivProperty();     // Catch: Exception -> L194
        goto L195
    L128:
        r4 = z.p(r3.progress);     // Catch: Exception -> L194
        goto L195
    L129:
        RichTextElement.SelectProperty r41 = r3.select;     // Catch: Exception -> L194
        r12 = new com.ss.android.lark.widget.richtext.RichTextElement.SelectProperty();     // Catch: Exception -> L194
        if (r41 != null) goto L132;
        int r42 = 0;
    L133:
        r12.setMinPickNum(r42);     // Catch: Exception -> L194
        if (r41 == null) goto L137;
        r5 = r41.max_pick_num.intValue();     // Catch: Exception -> L194
    L137:
        r12.setMaxPickNum(r5);     // Catch: Exception -> L194
        goto L144
    L132:
        r42 = r41.min_pick_num.intValue();     // Catch: Exception -> L194
        goto L133
    L138:
        r4 = z.c(r3.button);     // Catch: Exception -> L194
        goto L195
    L139:
        RichTextElement.EmotionProperty r43 = r3.emotion;     // Catch: Exception -> L194
        r12 = new com.ss.android.lark.widget.richtext.RichTextElement.EmotionProperty();     // Catch: Exception -> L194
        if (r43 == null) goto L143;
        r7 = r43.key;     // Catch: Exception -> L194
    L143:
        r12.setKey(r7);     // Catch: Exception -> L194
        goto L144
    L145:
        RichTextElement.UnderlineProperty r44 = r3.underline;     // Catch: Exception -> L194
        r12 = new com.ss.android.lark.widget.richtext.RichTextElement.UnderlineProperty();     // Catch: Exception -> L194
        if (r44 != null) goto L148;
        String r45 = "";
    L149:
        r12.setContent(r45);     // Catch: Exception -> L194
        if (r44 == null) goto L153;
        r7 = r44.i18n_key;     // Catch: Exception -> L194
    L153:
        r12.setI18nKey(r7);     // Catch: Exception -> L194
        goto L144
    L148:
        r45 = r44.content;     // Catch: Exception -> L194
        goto L149
    L154:
        RichTextElement.ItalicProperty r46 = r3.italic;     // Catch: Exception -> L194
        r12 = new com.ss.android.lark.widget.richtext.RichTextElement.ItalicProperty();     // Catch: Exception -> L194
        if (r46 != null) goto L157;
        String r47 = "";
    L158:
        r12.setContent(r47);     // Catch: Exception -> L194
        if (r46 == null) goto L162;
        r7 = r46.i18n_key;     // Catch: Exception -> L194
    L162:
        r12.setContent(r7);     // Catch: Exception -> L194
        goto L144
    L157:
        r47 = r46.content;     // Catch: Exception -> L194
        goto L158
    L163:
        RichTextElement.BoldProperty r48 = r3.bold;     // Catch: Exception -> L194
        r12 = new com.ss.android.lark.widget.richtext.RichTextElement.BoldProperty();     // Catch: Exception -> L194
        if (r48 != null) goto L166;
        String r49 = "";
    L167:
        r12.setContent(r49);     // Catch: Exception -> L194
        if (r48 == null) goto L171;
        r7 = r48.i18n_key;     // Catch: Exception -> L194
    L171:
        r12.setI18nKey(r7);     // Catch: Exception -> L194
        goto L144
    L166:
        r49 = r48.content;     // Catch: Exception -> L194
        goto L167
    L172:
        r4 = z.a(r3.anchor);     // Catch: Exception -> L194
        goto L195
    L173:
        r4 = z.b(r3.at);     // Catch: Exception -> L194
        goto L195
    L174:
        RichTextElement.FigureProperty r50 = r3.figure;     // Catch: Exception -> L194
        r4 = new com.ss.android.lark.widget.richtext.RichTextElement.FigureProperty();     // Catch: Exception -> L194
        goto L195
    L175:
        RichTextElement.ParagraphProperty r51 = r3.paragraph;     // Catch: Exception -> L194
        r4 = new com.ss.android.lark.widget.richtext.RichTextElement.ParagraphProperty();     // Catch: Exception -> L194
        goto L195
    L176:
        r4 = z.j(r3.image);     // Catch: Exception -> L194
        goto L195
    L177:
        RichTextElement.TextProperty r52 = r3.text;     // Catch: Exception -> L194
        r12 = new com.ss.android.lark.widget.richtext.RichTextElement.TextProperty();     // Catch: Exception -> L194
        if (r52 != null) goto L180;
        String r53 = "";
    L181:
        r12.setContent(r53);     // Catch: Exception -> L194
        if (r52 == null) goto L185;
        r7 = r52.i18n_key;     // Catch: Exception -> L194
    L185:
        r12.setI18nKey(r7);     // Catch: Exception -> L194
        if (r52 == null) goto L191;
        Integer r54 = r52.numberOfLines;     // Catch: Exception -> L194
        if (r54 == null) goto L191;
        r5 = r54.intValue();     // Catch: Exception -> L194
    L191:
        r12.setNumberOfLines(r5);     // Catch: Exception -> L194
        goto L144
    L180:
        r53 = r52.content;     // Catch: Exception -> L194
        goto L181
    L192:
        r4 = new com.ss.android.lark.widget.richtext.RichTextElement.ParagraphProperty();     // Catch: Exception -> L194
        goto L195
    L25:
        r1.setTag(com.ss.android.lark.widget.richtext.RichTextElement.RichTextTag.UNKNOWN_TAG);
        goto L26
    L8:
        if (CollectionUtils.isEmpty(r9.style_keys) == true) goto L22;
        HashMap r55 = new HashMap();
        Iterator r56 = r9.style_keys.iterator();
    L11:
        if (r56.hasNext() == false) goto L16;
        HashMap r57 = (HashMap) r0.get((String) r56.next());
        if (CollectionUtils.isEmpty(r57) == true) goto L11;
        r55.putAll(r57);
        goto L11
    L16:
        if (r9.style.containsKey("aspectRatio") == false) goto L18;
        r55.put("aspectRatio", (String) r9.style.get("aspectRatio"));
    L18:
        r1.setStyle(r55);
        if (r55.size() == r9.style.size()) goto L21;
        Log.e("ModuleParserRichText", "msg card style invalid styleKeys=" + r9.style_keys);
    L21:
        Log.d("ModuleParserRichText", "msg card merge style tag=" + r9.tag.name() + " styleKeys=" + r9.style_keys + " pbStyle=" + r9.style + " mergedStyle=" + r55);
    L196:
        return r1;
    }
}
