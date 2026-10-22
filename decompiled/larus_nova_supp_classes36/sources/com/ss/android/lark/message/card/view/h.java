package com.ss.android.lark.message.card.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.entity.message.content.CardContent;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.message.card.view.richtext.MsgCardLinkEmojiTextView;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.linked_emojicon.TextViewFixTouchConsume;
import com.ss.android.lark.widget.richtext.Image;
import com.ss.android.lark.widget.span.RecogniseSpansResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h {
    public static void a(Context r45, CardContent.CardHeader r46, FrameLayout r47, c r48) {
        if (r47 != null) goto L5;
        return;
    L5:
        r47.removeAllViews();
        if (com.ss.android.lark.message.card.utils.a.a(r46) == false) goto L8;
        return;
    L8:
        String r4 = r46.getSubTitle();
        Image r5 = com.ss.android.lark.widget.richtext.d.g(r46.getIcon());
        LinearLayout r6 = new LinearLayout(r45);
        r6.setOrientation(0);
        r6.setPadding(0, 0, 0, UIHelper.dp2px(12.0f));
        LinearLayout r8 = new LinearLayout(r45);
        r8.setOrientation(1);
        if (r5 == null) goto L11;
        ImageView r11 = new ImageView(r45);
        int r12 = UIHelper.dp2px(16.0f);
        LinearLayout.LayoutParams r13 = new LinearLayout.LayoutParams(r12, r12);
        r13.rightMargin = r12 / 2;
        r13.topMargin = r12 / 4;
        r6.addView(r11, r13);
        r11.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ImageLoader.with(r45).load(new EncryptImage(r5.getKey(), r5.getFsUnit(), r5.getCrypto())).dontAnimate(false).error(UDIconUtils.getIconDrawable(r45, 2131255039, UIUtils.getColor(r45, 2131102416))).listener(new e(r11, r45)).into(r11);
    L11:
        TextViewFixTouchConsume r7 = new MsgCardLinkEmojiTextView(r45);
        if (TextUtils.isEmpty(r4) == true) goto L14;
        r7.setPadding(0, 0, 0, UIHelper.dp2px(4.0f));
    L14:
        r7.setMaxLines(4);
        r7.setLineSpacing(UIHelper.dp2px(4.0f), 1.0f);
        r7.setEllipsize(TextUtils.TruncateAt.END);
        r7.setTypeface(h18.e.b(r45, 1));
        if (TextUtils.isEmpty(r46.getMainTitle()) == false) goto L17;
        String r9 = r46.getTitle();
    L18:
        r7.T(new RecogniseSpansResult(new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList()), r9, false);
        r7.setGravity(16);
        r7.setOnLongClickListener(new f(r48));
        int r14 = UIHelper.getColor(2131106622);
        Map r15 = r46.getStyle();
        if (CollectionUtils.isEmpty(r15) == false) goto L38;
        Log.w("CardMessagePreview", "card header style is empty");
        int r0 = 14;
        int r16 = 16;
    L29:
        String r17 = r46.getTheme();
        HashMap<String, com.ss.android.lark.message.card.style.a.C0182a> r10 = com.ss.android.lark.message.card.style.a.a;
        if (r10.containsKey(r17) == false) goto L32;
        r14 = UIHelper.getColor(r10.get(r17).c);
    L33:
        r7.setTextColor(r14);
        zz7.a.c(r7, r16);
        r8.addView(r7);
        if (TextUtils.isEmpty(r4) == true) goto L36;
        TextViewFixTouchConsume r18 = new MsgCardLinkEmojiTextView(r45);
        r18.setMaxLines(1);
        r18.setSingleLine();
        r18.setLineSpacing(UIHelper.dp2px(4.0f), 1.0f);
        r18.setEllipsize(TextUtils.TruncateAt.END);
        r18.T(new RecogniseSpansResult(new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList()), r4, false);
        r18.setGravity(16);
        r18.setTextColor(r14);
        zz7.a.c(r18, r0);
        r18.setOnLongClickListener(new g(r48));
        r8.addView(r18);
    L36:
        r6.addView(r8);
        r47.addView(r6, new FrameLayout.LayoutParams(-1, -1));
        return;
    L32:
        Log.i("CardMessagePreview", "card header ig theme do not contain " + r17);
        goto L33
    L38:
        r14 = com.ss.android.lark.message.card.view.richtext.b.e(r15, "color");     // Catch: Exception -> L25
        r16 = CastIntegerProtector.valueOf((String) r15.get("fontSize")).intValue();     // Catch: Exception -> L25
        r0 = CastIntegerProtector.valueOf((String) r15.get("fontSize")).intValue();     // Catch: Exception -> L23
    L23:
        e = e;
    L27:
        Log.e("CardMessagePreview", "parse header color or size failed", e);
        r0 = 14;
    L25:
        e = e;
        r16 = 16;
        goto L27
    L17:
        r9 = r46.getMainTitle();
        goto L18
    }
}
