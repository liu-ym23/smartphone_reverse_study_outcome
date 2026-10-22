package com.ss.android.lark.inline.ai.ui.at;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.EditText;
import com.ss.android.lark.inline.ai.ui.richtext.InlineAIAtSpanHolder;
import com.ss.android.lark.inline.ai.ui.view.URLRecognition;
import com.ss.android.lark.keyboard.edittext2.span.m;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final Regex a;
    public final Regex b;

    /* JADX INFO: renamed from: com.ss.android.lark.inline.ai.ui.at.a$a, reason: collision with other inner class name */
    public static final class C0109a {
    }

    static {
    }

    public a() {
        this.a = new Regex("<at.*?</at>");
        this.b = new Regex("(?<=>).*?(?=<)");
    }

    public final boolean a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "placeholder");
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return false;
    L6:
        return !SequencesKt.toList(Regex.findAll$default(this.a, r5, 0, 2, null)).isEmpty();
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public final void b(String r35, final EditText r36) {
        a r1 = this;
        Intrinsics.checkNotNullParameter(r35, "text");
        Intrinsics.checkNotNullParameter(r36, "editText");
        Log.d("PlaceholderParser", "parseToEntityWithUrl start ");
        SpannableStringBuilder r4 = new SpannableStringBuilder(r35);
        int r11 = 0;
        int r12 = 2;
        Object r13 = null;
        Sequence r0 = Regex.findAll$default(r1.a, r35, 0, 2, null);
        ArrayList r14 = new ArrayList();
        Iterator r15 = r0.iterator();
    L4:
        if (r15.hasNext() == false) goto L75;
        MatchResult r16 = (MatchResult) r15.next();
        Log.d("PlaceholderParser", "parseAt: " + r16.getValue());
        MatchResult r2 = Regex.find$default(r1.b, r16.getValue(), r11, r12, r13);
        if (r2 == null) goto L15;
        MatchResult.Destructured r3 = r2.getDestructured();
        if (r3 == null) goto L15;
        MatchResult r5 = r3.getMatch();
        if (r5 == null) goto L15;
        String r6 = r5.getValue();
        if (r6 == null) goto L15;
        String r9 = r6;
    L16:
        String r17 = r16.getValue();
        XmlPullParser r7 = XmlPullParserFactory.newInstance().newPullParser();
        r7.setInput(new StringReader(StringsKt.replace$default(r17, "&", "&amp;", false, 4, null)));
        int r8 = r7.getEventType();
    L17:
        String r10 = "parseAt xml exception";
        if (r8 == 1) goto L33;
        String r18 = r7.getName();
        if (r8 == 2) goto L22;
    L86:
        r8 = r7.next();     // Catch: Exception -> L30
    L30:
        e = move-exception;
        Log.e("PlaceholderParser", "parseAt xml next exception", e);
        goto L17
    L22:
        if (Intrinsics.areEqual(INotificationHitPoint.NoticeType.AT, r18) == false) goto L86;
        Log.d("PlaceholderParser", "apply: find at tag");
        String r19 = r7.getAttributeValue(null, "href");     // Catch: Exception -> L26
    L34:
        Log.d("PlaceholderParser", "parseToEntityWithUrl content:" + r9 + ",  url:" + r19);
        if (TextUtils.isEmpty(r19) == true) goto L41;
        r14.add(r19);
        String r20 = r16.getValue();
        SpannableStringBuilder r21 = new m(new m.a(r36.getContext(), r9, r19, "")).e;
        if (r21 == null) goto L41;
        int r22 = StringsKt.indexOf$default(r4, r20, 0, false, 6, null);
        r4.replace(r22, r20.length() + r22, r21);
    L41:
        if (new bmb.a().b.isCurrentEnable("ccm.knowledge.inline_ai_mention_all_enable") == false) goto L72;
        String r23 = r16.getValue();
        XmlPullParser r110 = XmlPullParserFactory.newInstance().newPullParser();
        r110.setInput(new StringReader(StringsKt.replace$default(r23, "&", "&amp;", false, 4, null)));
        int r24 = r110.getEventType();
    L43:
        int r25 = r24;
    L44:
        if (r25 == 1) goto L67;
        String r26 = r110.getName();
        if (r25 == 2) goto L48;
    L62:
        String r27 = r10;
    L80:
        r25 = r110.next();     // Catch: Exception -> L65
        r10 = r27;
    L65:
        e = move-exception;
        Log.e("PlaceholderParser", "parseAt xml next exception", e);
        r24 = r25;
        r10 = r27;
        goto L43
    L48:
        if (Intrinsics.areEqual(INotificationHitPoint.NoticeType.AT, r26) == false) goto L62;
        Log.d("PlaceholderParser", "apply: find at tag");
        Object r28 = null;
    L57:
        e = move-exception;
        r27 = r10;
        Log.e("PlaceholderParser", r27, e);
        goto L80
    L53:
        if (Intrinsics.areEqual(r110.getAttributeValue(null, "type"), "0") == false) goto L56;
        String r29 = r110.getAttributeValue(null, "token");     // Catch: Exception -> L57
    L68:
        StringBuilder r30 = new StringBuilder("parseToEntityWithUrl content:");
        String r111 = r9;
        r30.append(r111);
        r30.append(",  uid:");
        r30.append(r29);
        Log.d("PlaceholderParser", r30.toString());
        if (TextUtils.isEmpty(r29) == true) goto L71;
        String r31 = r16.getValue();
        com.ss.android.lark.keyboard.edittext2.span.a r112 = new com.ss.android.lark.keyboard.edittext2.span.a(r36.getContext(), r29, false, false, false);
        InlineAIAtSpanHolder.a r113 = new InlineAIAtSpanHolder.a(r29);
        Object r114 = r28;
        int r32 = StringsKt.indexOf$default(r4, r31, 0, false, 6, null);
        int r33 = r31.length();
        SpannableStringBuilder r34 = new SpannableStringBuilder(r111);
        r34.setSpan(r112, 0, r34.length(), 33);
        r34.setSpan(r113, 0, r34.length(), 33);
        r4.replace(r32, r33 + r32, r34);
    L74:
        r1 = this;
        r13 = r114;
        r11 = 0;
        r12 = 2;
        goto L4
    L71:
        r114 = r28;
        goto L74
    L56:
        r27 = r10;
        goto L80
    L67:
        r28 = null;
        r29 = "";
        goto L68
    L72:
        r114 = null;
    L26:
        e = move-exception;
        Log.e("PlaceholderParser", "parseAt xml exception", e);
        goto L86
    L33:
        r19 = "";
    L15:
        r9 = "";
        goto L16
    L75:
        r36.setText(r4);
        Iterator r37 = r14.iterator();
    L77:
        if (r37.hasNext() == false) goto L79;
        final String r38 = (String) r37.next();
        URLRecognition.a(r38, new AtParser$flashIconKey$1(r36, r38));
        goto L77
    }
}
