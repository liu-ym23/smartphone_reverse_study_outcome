package com.ss.android.lark.keyboard.edittext2.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.Annotation;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.ss.android.lark.KeyboardBaseModule;
import com.ss.android.lark.keyboard.edittext2.base.FunctionEditText;
import com.ss.android.lark.keyboard.edittext2.edittors.richText.RichTextEditor;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import com.ss.android.lark.widget.richtext.i;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class RichTextCopyUtils {
    public static final Token a = null;
    public static RichText b;
    public static String c;
    public static CharSequence d;

    static {
        a = new Token("LARK-PSDA-messenger-android-copy-im-richText-editor");
    }

    @JvmStatic
    public static final CharSequence a(CharSequence r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        StringBuilder r0 = new StringBuilder("markCopy: richText is null ? : ");
        if (b != null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        Log.i("RichTextCopyUtils", r0.toString());
        RichText r2 = b;
        if (r2 != null) goto L10;
        return r5;
    L10:
        if ((r5 instanceof Spannable) == false) goto L12;
        Spannable r3 = (Spannable) r5;
    L13:
        RichText r4 = new RichText(r2);
        r4.setInnerText(r5.toString());
        String r6 = KeyboardBaseModule.a().encodePbRichText(r4);
        if (r6 != null) goto L16;
        return r5;
    L16:
        r3.setSpan(new Annotation("com.lartsuite.im.RichTextCopyUtils", r6), 0, ((String) r5).length(), 33);
        return r3;
    L12:
        r3 = new SpannableStringBuilder(r5);
        goto L13
    L5:
        r1 = false;
        goto L6
    }

    @JvmStatic
    public static final RichText b(RichText r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        List r0 = r3.getElementIds();
        Map r1 = r3.getElements().getDictionary();
        Intrinsics.checkNotNull(r0);
        Iterator r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        RichTextElement r4 = (RichTextElement) r1.get((String) r2.next());
        if (r4 == null) goto L7;
        Intrinsics.checkNotNull(r1);
        c(r4, r1);
        goto L7
    L11:
        return r3;
    }

    @JvmStatic
    public static final ClipData d(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Object r3 = r2.getSystemService("clipboard");
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.content.ClipboardManager");
        qf7.a r0 = qf7.a.a;
        return r0.d((ClipboardManager) r3, a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final boolean f(final FunctionEditText r2) {
        Intrinsics.checkNotNullParameter(r2, "funcEditor");
        ClipData r0 = d(r2.getContext());
        if (r0 != null) goto L7;
        return false;
    L7:
        return h(r0, new RichTextCopyUtils$onPaste$1(r2));
    }

    public static RichTextEditor g(RichTextEditor r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        final boolean r0 = d.a("messenger.message.copy");
        return (RichTextEditor) e.a(r2, new RichTextCopyUtils$prepare$1(r0));
    }

    public static final void c(RichTextElement r12, Map<String, ? extends RichTextElement> r13) {
        RichTextElement.RichTextTag r0 = r12.getTag();
        boolean r2 = true;
        if (r0 != RichTextElement.RichTextTag.IMG) goto L18;
        RichTextElement.ImageProperty r1 = r12.getProperty();
        List r4 = r1.getUrls();
        if (r4 == null) goto L7;
        String r5 = (String) CollectionsKt.getOrNull(r4, 0);
    L9:
        if (r5 != null) goto L11;
        String r6 = "";
    L12:
        String r7 = r1.getToken();
        if (r7 != null) goto L15;
        String r8 = "";
    L16:
        RichTextElement.ImageProperty r9 = RichTextElementCreator.c(r6, r8, r1.getOriginWidth(), r1.getOriginHeight(), false, r1.getResourceCleanScene());
        r9.setOriginKey(r1.getOriginKey());
        r9.setResourcePreviewToken(r1.getResourcePreviewToken());
        r9.setResourceMsgLinkToken(r1.getResourceMsgLinkToken());
        r9.setNeedCopy(true);
        r9.setResourceCleanScene(r1.getResourceCleanScene());
        r12.setProperty(r9);
        goto L18
    L15:
        r8 = r7;
        goto L16
    L11:
        r6 = r5;
        goto L12
    L7:
        r5 = null;
    L18:
        if (r0 != RichTextElement.RichTextTag.MEDIA) goto L29;
        RichTextElement.MediaProperty r3 = r12.getProperty();
        if (r3.getKey().length() <= 0) goto L22;
        boolean r10 = true;
    L23:
        if (r10 == true) goto L25;
    L27:
        r2 = false;
    L28:
        RichTextElement.MediaProperty r11 = r3.copyInstance();
        r11.setNeedCopy(r2);
        r11.setResourceCleanScene(r3.getResourceCleanScene());
        r11.setMediaUploadId(r3.getMediaUploadId());
        r11.setImageUploadId(r3.getImageUploadId());
        r12.setProperty(r11);
        goto L29
    L25:
        if (r3.getOriginImage() == null) goto L27;
    L22:
        r10 = false;
    L29:
        List r14 = r12.getChildIds();
        if (r14 == null) goto L37;
        Iterator r15 = r14.iterator();
    L33:
        if (r15.hasNext() == false) goto L43;
        RichTextElement r16 = r13.get((String) r15.next());
        if (r16 == null) goto L33;
        c(r16, r13);
        goto L33
    L43:
        return;
    }

    @JvmStatic
    public static final void e(CharSequence r2, RichText r3) {
        StringBuilder r0 = new StringBuilder("onCopy: copy text is null ? : ");
        if (r2 != null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        Log.i("RichTextCopyUtils", r0.toString());
        if (r2 != null) goto L9;
        return;
    L9:
        c = r2.toString();
        b = b(r3);
        return;
    L5:
        r1 = false;
        goto L6
    }

    @JvmStatic
    public static final boolean h(ClipData r12, Function1<? super RichText, Unit> r13) {
        Intrinsics.checkNotNullParameter(r12, "clip");
        Intrinsics.checkNotNullParameter(r13, "action");
        Log.i("RichTextCopyUtils", "readPrimaryClipIfNeed: primaryClipChanged has changed, read from clipboard");
        String r1 = null;
    L50:
        e = move-exception;
        Log.e("RichTextCopyUtils", "readPrimaryClipIfNeed, read clipData failed: " + e.getMessage());
        CharSequence r5 = null;
    L52:
        if (r5 != null) goto L54;
    L57:
        boolean r14 = true;
    L58:
        if (r14 == false) goto L60;
    L139:
        Log.i("RichTextCopyUtils", "withPasteRichText: clipboard has no spanned data found. return false");
        return false;
    L60:
        if ((r5 instanceof Spanned) == false) goto L139;
        Spanned r15 = (Spanned) r5;
        Object[] r4 = r15.getSpans(0, r15.length(), Annotation.class);
        int r6 = r4.length;
        int r7 = 0;
    L64:
        if (r7 >= r6) goto L69;
        Object r9 = r4[r7];
        if (Intrinsics.areEqual(((Annotation) r9).getKey(), "com.lartsuite.im.RichTextCopyUtils") == true) goto L70;
        r7 = r7 + 1;
    L70:
        if (r9 == null) goto L72;
        boolean r8 = true;
    L73:
        if (r8 == true) goto L76;
        Log.d("RichTextCopyUtils", "withPasteRichText: clipContent is not marked. return false.");
        return false;
    L76:
        Object[] r10 = r15.getSpans(0, r15.length(), Annotation.class);
        int r11 = r10.length;
        int r16 = 0;
    L77:
        if (r16 >= r11) goto L82;
        Object r17 = r10[r16];
        if (Intrinsics.areEqual(((Annotation) r17).getKey(), "com.lartsuite.im.RichTextCopyUtils") == true) goto L83;
        r16 = r16 + 1;
    L83:
        Annotation r18 = (Annotation) r17;
        if (r18 == null) goto L86;
        String r19 = r18.getValue();
    L88:
        if (Intrinsics.areEqual(r19, "com.lartsuite.normalText") == false) goto L91;
        Log.i("RichTextCopyUtils", "withPasteRichText: clipContent is normal text, return false");
        return false;
    L91:
        RichText r20 = b;
        String r21 = c;
        if (r21 != null) goto L94;
    L97:
        boolean r22 = true;
    L98:
        if (r22 == false) goto L100;
    L102:
        boolean r23 = false;
    L103:
        if (r23 == true) goto L105;
    L111:
        Log.i("RichTextCopyUtils", "withPasteRichText: there has no cached data locally , trying to parse clipboard.");
        Pair r24 = TuplesKt.to(Boolean.FALSE, null);
        Object[] r25 = r15.getSpans(0, r15.length(), Annotation.class);
        int r26 = r25.length;
        int r27 = 0;
    L112:
        if (r27 >= r26) goto L117;
        Object r110 = r25[r27];
        if (Intrinsics.areEqual(((Annotation) r110).getKey(), "com.lartsuite.im.RichTextCopyUtils") == true) goto L118;
        r27 = r27 + 1;
    L118:
        Annotation r111 = (Annotation) r110;
        if (r111 == null) goto L125;
        RichText r28 = KeyboardBaseModule.a().decodeAndGetRichText(r111);
        boolean r29 = !i.l(r28);
        if (r29 == false) goto L124;
        b = r28;
        c = r15.toString();
    L124:
        r24 = TuplesKt.to(Boolean.valueOf(r29), r28);
    L125:
        boolean r112 = ((Boolean) r24.getFirst()).booleanValue();
        RichText r30 = (RichText) r24.getSecond();
        if (r30 == null) goto L129;
        r1 = r30.getInnerText();
    L129:
        if (Intrinsics.areEqual(r1, r5.toString()) == true) goto L132;
        Log.w("RichTextCopyUtils", "withPasteRichText: clip content is marked with richText, but content has changed");
        return false;
    L132:
        if (r112 == false) goto L138;
        RichText r113 = (RichText) r24.getSecond();
        if (r113 != null) goto L136;
        r113 = com.ss.android.lark.widget.richtext.c.a();
    L136:
        r13.invoke(r113);
        return true;
    L138:
        return false;
    L117:
        r110 = null;
        goto L118
    L105:
        if (Intrinsics.areEqual(c, r5.toString()) == false) goto L111;
        Log.i("RichTextCopyUtils", "withPasteRichText: memory has cached data, use memory richtext。");
        if (r20 != null) goto L109;
        r20 = com.ss.android.lark.widget.richtext.c.a();
    L109:
        r13.invoke(r20);
        return true;
    L100:
        if (i.l(r20) == true) goto L102;
        r23 = true;
        goto L103
    L94:
        if (r21.length() == 0) goto L97;
        r22 = false;
        goto L98
    L86:
        r19 = null;
        goto L88
    L82:
        r17 = null;
        goto L83
    L72:
        r8 = false;
        goto L73
    L69:
        r9 = null;
        goto L70
    L54:
        if (r5.length() == 0) goto L57;
        r14 = false;
        goto L58
    L4:
        r5 = "";
        if (r12.getItemCount() == 0) goto L37;
        int r31 = r12.getItemCount();     // Catch: SensitiveAPIException -> L50
        int r32 = 0;
    L8:
        if (r32 >= r31) goto L37;
        ClipData.Item r33 = r12.getItemAt(r32);     // Catch: SensitiveAPIException -> L50
        Intrinsics.checkNotNull(r33);     // Catch: SensitiveAPIException -> L50
        CharSequence r34 = r33.getText();     // Catch: SensitiveAPIException -> L50
        if (r34 != null) goto L12;
    L15:
        boolean r35 = true;
    L16:
        if (r35 == false) goto L31;
        String r36 = r33.getHtmlText();     // Catch: SensitiveAPIException -> L50
        if (r36 != null) goto L21;
    L24:
        boolean r37 = true;
    L25:
        if (r37 == false) goto L143;
    L29:
        r34 = "";
        goto L31
    L143:
        r34 = Html.fromHtml(r36);     // Catch: RuntimeException -> L141 SensitiveAPIException -> L50
        if (r34 == null) goto L29;
    L21:
        if (r36.length() == 0) goto L24;
        r37 = false;
    L31:
        if (r34.length() != 0) goto L33;
        boolean r38 = true;
    L34:
        if (r38 == false) goto L39;
        r32 = r32 + 1;     // Catch: SensitiveAPIException -> L50
    L39:
        if (r34.length() != 0) goto L41;
        boolean r114 = true;
    L42:
        if (r114 == false) goto L44;
        Log.i("RichTextCopyUtils", "primaryClipChanged has changed, but read nothing from clipboard.");     // Catch: SensitiveAPIException -> L50
        goto L52
    L44:
        d = r34;     // Catch: SensitiveAPIException -> L50
        StringBuilder r115 = new StringBuilder();     // Catch: SensitiveAPIException -> L50
        r115.append("readPrimaryClipIfNeed: read primary clip size is ");     // Catch: SensitiveAPIException -> L50
        CharSequence r39 = d;     // Catch: SensitiveAPIException -> L50
        if (r39 == null) goto L47;
        Integer r40 = Integer.valueOf(r39.length());     // Catch: SensitiveAPIException -> L50
    L48:
        r115.append(r40);     // Catch: SensitiveAPIException -> L50
        Log.i("RichTextCopyUtils", r115.toString());     // Catch: SensitiveAPIException -> L50
        r5 = d;     // Catch: SensitiveAPIException -> L50
        goto L52
    L47:
        r40 = null;
        goto L48
    L41:
        r114 = false;
        goto L42
    L33:
        r38 = false;
        goto L34
    L12:
        if (r34.length() == 0) goto L15;
        r35 = false;
    L37:
        r34 = "";
        goto L39
    }
}
