package com.ss.android.lark.message.card.view.richtext;

import android.text.TextUtils;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.widget.linked_emojicon.base.EmojiHandler;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public static CharSequence a(RichTextElement r6, Map<String, RichTextElement> r7, boolean r8) {
        if (r6 != null) goto L5;
        return "";
    L5:
        StringBuilder r1 = new StringBuilder();
        RichTextElement.RichTextTag r2 = r6.getTag();
        RichTextElement.TextProperty r3 = r6.getProperty();
        if (r2 != RichTextElement.RichTextTag.TEXT) goto L11;
        if ((r3 instanceof RichTextElement.TextProperty) == false) goto L11;
        r1.append(r3.getContent());
    L11:
        if (r2 != RichTextElement.RichTextTag.ANCHOR) goto L16;
        if ((r3 instanceof RichTextElement.AnchorProperty) == false) goto L16;
        r1.append(((RichTextElement.AnchorProperty) r3).getContent());
    L16:
        if (r2 != RichTextElement.RichTextTag.AT) goto L21;
        if ((r3 instanceof RichTextElement.AtProperty) == false) goto L21;
        r1.append(((RichTextElement.AtProperty) r3).getAtContent());
    L21:
        if (r2 != RichTextElement.RichTextTag.EMOTION) goto L28;
        if ((r3 instanceof RichTextElement.EmotionProperty) == false) goto L28;
        String r4 = ((RichTextElement.EmotionProperty) r3).getKey();
        if (TextUtils.isEmpty(r4) == true) goto L28;
        r1.append(EmojiHandler.e(r4));
    L28:
        if (r2 != RichTextElement.RichTextTag.TIME) goto L33;
        if ((r3 instanceof RichTextElement.TimeProperty) == false) goto L33;
        r1.append(c0.m((RichTextElement.TimeProperty) r3, ""));
    L33:
        if (r8 == false) goto L38;
        if (r1.toString().isEmpty() == true) goto L38;
        r1.append("\n");
    L38:
        if (r2 != RichTextElement.RichTextTag.TEXTABLEAREA) goto L40;
    L45:
        List r9 = r6.getChildIds();
        if (CollectionUtils.isEmpty(r9) == true) goto L58;
        Iterator r10 = r9.iterator();
    L49:
        if (r10.hasNext() == false) goto L56;
        RichTextElement r11 = r7.get((String) r10.next());
        if (r2 == RichTextElement.RichTextTag.TEXTABLEAREA) goto L53;
        boolean r5 = true;
    L54:
        r1.append(a(r11, r7, r5));
        goto L49
    L53:
        r5 = false;
        goto L54
    L56:
        if (r2 != RichTextElement.RichTextTag.TEXTABLEAREA) goto L58;
        r1.append("\n");
    L58:
        return r1;
    L40:
        if (r2 == RichTextElement.RichTextTag.DIV) goto L45;
        if (r2 == RichTextElement.RichTextTag.PARAGRAPH) goto L45;
        if (r2 != RichTextElement.RichTextTag.LINK) goto L58;
        goto L45
    }
}
