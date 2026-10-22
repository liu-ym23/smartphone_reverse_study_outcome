package com.ss.android.lark.chat.utils;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;
import com.ss.android.lark.chat.base.view.vo.message.PostContentVO;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.TextLayoutRender;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k1 {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public final CharSequence a;
        public final RichText b;
        public final boolean c;

        public a(CharSequence r2, RichText r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "content");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    static {
    }

    public static boolean c(RichText r6) {
        if (r6 != null) goto L5;
        return false;
    L5:
        Map r1 = r6.getElements().getDictionary();
        List r7 = r6.getElementIds();
        RichTextElement.RichTextTag r2 = null;
        RichTextElement r3 = null;
    L6:
        List r4 = r7;
        if (r4 != null) goto L9;
    L12:
        boolean r5 = true;
    L13:
        if (r5 == true) goto L21;
        if (r7.size() > 1) goto L16;
        r3 = (RichTextElement) r1.get(CollectionsKt.first(r7));
        if (r3 == null) goto L19;
        r7 = r3.getChildIds();
        goto L6
    L19:
        return false;
    L16:
        return false;
    L21:
        if (r3 == null) goto L23;
        RichTextElement.RichTextTag r8 = r3.getTag();
    L25:
        if (r8 == RichTextElement.RichTextTag.IMG) goto L30;
        if (r3 == null) goto L29;
        r2 = r3.getTag();
    L29:
        if (r2 == RichTextElement.RichTextTag.MEDIA) goto L30;
        return false;
    L30:
        return true;
    L23:
        r8 = null;
        goto L25
    L9:
        if (r4.isEmpty() == true) goto L12;
        r5 = false;
        goto L13
    }

    public static boolean d(RichText r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        List r1 = r3.getImageIds();
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L21;
        List r4 = r3.getMediaIds();
        if (r4 != null) goto L16;
    L19:
        boolean r5 = true;
    L20:
        if (r5 == false) goto L21;
        return false;
    L16:
        if (r4.isEmpty() == true) goto L19;
        r5 = false;
    L21:
        return true;
    L8:
        if (r1.isEmpty() == true) goto L11;
        r2 = false;
        goto L12
    }

    @JvmStatic
    public static final a a(Context r1, y6b.a<? extends BaseTextContentVO<?>> r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "messageVO");
        return b(r1, r2, r2.b());
    }

    public static a b(Context r10, y6b.a r11, BaseTextContentVO r12) {
        boolean r1 = true;
        boolean r0 = !h7b.l.d(r12);
        if (r12.f != 3) goto L5;
        boolean r2 = true;
    L6:
        if (r0 == false) goto L10;
        if (r2 == true) goto L10;
        boolean r3 = false;
    L11:
        CharSequence r4 = r12.t;
        boolean r5 = u.a.a.c;
        if (r5 == false) goto L14;
    L16:
        boolean r6 = false;
    L17:
        boolean r7 = r12.y;
        Log.i("TextMessageCopyUtils", "onCopyMessage: isPartialSelectCopy is " + r5 + " , isFullSelectCopy is " + r6 + " , isSelectedTranslateText is " + r7);
        SpannableStringBuilder r8 = new SpannableStringBuilder();
        String r9 = null;
        if (r5 == false) goto L35;
        CharSequence r13 = com.ss.android.lark.utils.o.c(b7b.b.e(r4));
        Intrinsics.checkNotNull(r13);
        int r14 = TextLayoutRender.j;
        if (TextLayoutRender.c.a() == true) goto L22;
    L26:
        RichText r15 = IMRichTextCopyUtils.e(r13);
    L27:
        boolean r16 = c(r15);
        RichText r17 = IMRichTextCopyUtils.h(r15, r11);
        if (r16 == true) goto L30;
    L33:
        boolean r18 = true;
    L34:
        Pair r19 = TuplesKt.to(r17, Boolean.valueOf(r18));
        r8.append(com.ss.android.lark.widget.richtext.i.c((RichText) r19.getFirst()));
    L65:
        RichText r110 = (RichText) r19.getFirst();
        if (r6 == true) goto L69;
        if (r5 == true) goto L69;
        boolean r20 = true;
    L70:
        if (r20 == false) goto L86;
        if ((r12 instanceof PostContentVO) == false) goto L74;
        PostContentVO r111 = (PostContentVO) r12;
    L75:
        if (r111 == null) goto L77;
        r9 = (String) r111.E.getValue();
    L77:
        if (r9 != null) goto L79;
    L82:
        if (r1 == true) goto L86;
        if (r110 == null) goto L86;
        r110 = com.ss.android.lark.widget.richtext.utils.a.b(com.ss.android.lark.widget.richtext.c.c(r9 + '\n'), r110);
        goto L86
    L79:
        if (r9.length() == 0) goto L82;
        r1 = false;
        goto L82
    L74:
        r111 = null;
    L86:
        return new a(r8, r110, ((Boolean) r19.getSecond()).booleanValue());
    L69:
        r20 = false;
        goto L70
    L30:
        if (d(r17) == true) goto L33;
        r18 = false;
        goto L34
    L22:
        if (r11.getType() == Message.Type.AUDIO) goto L26;
        IMRichTextCopyUtils r21 = IMRichTextCopyUtils.a;
        r15 = IMRichTextCopyUtils.g(r10, r13);
        if (r15 != null) goto L27;
        r15 = IMRichTextCopyUtils.e(r13);
        goto L27
    L35:
        if (r6 == false) goto L37;
        if (r7 == false) goto L37;
    L40:
        if (h7b.l.d(r12) == false) goto L42;
        Object r22 = r12;
    L43:
        Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO<*>");
        BaseTextContentVO r23 = (BaseTextContentVO) r22;
    L46:
        if ((r23 instanceof PostContentVO) == false) goto L53;
        PostContentVO r24 = (PostContentVO) r23;
        boolean r25 = !r6;
        w4b.d0 r26 = b7b.b.a;
        String r27 = com.ss.android.lark.widget.richtext.i.c(r24.g());
        if (r25 == true) goto L50;
    L52:
        Intrinsics.checkNotNull(r27);
    L54:
        r8.append(com.ss.android.lark.utils.o.c(r27));
        RichText r112 = r23.g();
        if (r112 != null) goto L57;
        r19 = TuplesKt.to(null, Boolean.TRUE);
        goto L65
    L57:
        RichText r28 = new RichText(r112);
        RichText.RichTextElements r29 = new RichText.RichTextElements();
        r29.setDictionary(r112.getElements().getDictionary());
        r28.setElements(r29);
        boolean r113 = c(r112);
        RichText r114 = IMRichTextCopyUtils.h(r28, r11);
        if (r113 == true) goto L60;
    L63:
        boolean r115 = true;
    L64:
        r19 = TuplesKt.to(r114, Boolean.valueOf(r115));
        goto L65
    L60:
        if (d(r114) == true) goto L63;
        r115 = false;
        goto L64
    L50:
        if (TextUtils.isEmpty(r24.h(r10)) == true) goto L52;
        r27 = r24.h(r10) + "\n" + r27;
        goto L52
    L53:
        r27 = com.ss.android.lark.widget.richtext.i.c(r23.g());
        Intrinsics.checkNotNull(r27);
        goto L54
    L42:
        r22 = r12.g;
    L37:
        if (r0 == false) goto L44;
        if (r3 == false) goto L40;
    L44:
        r23 = r12;
        goto L46
    L14:
        if (TextUtils.isEmpty(r4) == true) goto L16;
        r6 = true;
    L10:
        r3 = true;
        goto L11
    L5:
        r2 = false;
        goto L6
    }
}
