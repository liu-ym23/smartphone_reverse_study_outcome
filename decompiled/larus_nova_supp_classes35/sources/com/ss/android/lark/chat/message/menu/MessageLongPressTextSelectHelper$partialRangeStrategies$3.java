package com.ss.android.lark.chat.message.menu;

import android.text.Spanned;
import android.text.style.ClickableSpan;
import com.ss.android.lark.coremd.impl.parse.h;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class MessageLongPressTextSelectHelper$partialRangeStrategies$3 extends FunctionReferenceImpl implements Function2<CharSequence, Integer, IntRange> {
    public MessageLongPressTextSelectHelper$partialRangeStrategies$3(Object r8) {
        super(2, r8, MessageLongPressTextSelectHelper.class, "findSentenceRange", "findSentenceRange(Ljava/lang/CharSequence;I)Lkotlin/ranges/IntRange;", 0);
    }

    public final IntRange invoke(CharSequence r18, int r19) {
        Intrinsics.checkNotNullParameter(r18, "p0");
        MessageLongPressTextSelectHelper r2 = (MessageLongPressTextSelectHelper) ((CallableReference) this).receiver;
        MessageLongPressTextSelectHelper r3 = MessageLongPressTextSelectHelper.a;
        r2.getClass();
        boolean r4 = false;
        int r5 = RangesKt.coerceIn(r19, 0, r18.length());
        boolean r6 = r18 instanceof Spanned;
        if (r6 == true) goto L5;
    L11:
        boolean r7 = false;
    L13:
        if (r6 == true) goto L15;
        MessageLongPressTextSelectHelper.a r8 = MessageLongPressTextSelectHelper.a.b;
    L33:
        int r9 = RangesKt.coerceIn(r5, 0, r18.length());
        int r10 = r9 - 1;
    L35:
        if (r10 < 0) goto L41;
        if (r18.charAt(r10) == '\n') goto L41;
        if (MessageLongPressTextSelectHelper.d(r18, r10, r7, r8) == true) goto L41;
        r10 = r10 - 1;
    L41:
        if (r10 >= 0) goto L43;
    L45:
        boolean r11 = false;
    L47:
        if (r10 < 0) goto L64;
        if (MessageLongPressTextSelectHelper.d(r18, r10, r7, r8) == false) goto L64;
        int r13 = r10;
    L51:
        if (r10 < 0) goto L62;
        if (MessageLongPressTextSelectHelper.d(r18, r10, r7, r8) == false) goto L62;
        IntRange r14 = r8.a(r10);
        if (r14 != null) goto L56;
        IntRange r15 = MessageLongPressTextSelectHelper.b(r18, r10, r7);
        if (r15 != null) goto L59;
        r13 = Math.max(r13, r10 + 1);
        r10 = r10 - 1;
        goto L51
    L59:
        int r12 = Math.max(r13, r15.getLast() + 1);
        int r16 = r15.getFirst();
    L60:
        int r17 = r16 - 1;
        r13 = r12;
        r10 = r17;
        goto L51
    L56:
        r12 = Math.max(r13, r14.getLast() + 1);
        r16 = r14.getFirst();
    L62:
        r10 = r13;
    L64:
        if (r9 >= r18.length()) goto L71;
        if (r18.charAt(r9) == '\n') goto L71;
        if (MessageLongPressTextSelectHelper.d(r18, r9, r7, r8) == true) goto L71;
        r9 = r9 + 1;
    L71:
        if (r9 < r18.length()) goto L73;
    L75:
        boolean r110 = false;
    L77:
        if (r9 >= r18.length()) goto L96;
        if (MessageLongPressTextSelectHelper.d(r18, r9, r7, r8) == false) goto L96;
        r9 = RangesKt.coerceIn(r9, 0, r18.length());
    L82:
        if (r9 >= r18.length()) goto L96;
        if (MessageLongPressTextSelectHelper.d(r18, r9, r7, r8) == false) goto L96;
        IntRange r111 = r8.a(r9);
        if (r111 != null) goto L88;
        IntRange r112 = MessageLongPressTextSelectHelper.b(r18, r9, r7);
        if (r112 == null) goto L94;
        r9 = r112.getLast();
    L94:
        r9 = r9 + 1;
        goto L82
    L88:
        if (r9 > r111.getFirst()) goto L96;
        r9 = r111.getFirst();
    L96:
        if (r9 < r18.length()) goto L98;
        boolean r113 = true;
    L99:
        Collection r20 = MessageLongPressTextSelectHelper.g(r18, r10, r9);
        if (r20 != null) goto L103;
    L145:
        r20 = null;
    L146:
        if (r20 != null) goto L205;
        if (r7 == true) goto L207;
        BreakIterator r21 = BreakIterator.getSentenceInstance(Locale.getDefault());
        String r22 = r18.toString();
        r21.setText(r22);
        int r23 = RangesKt.coerceIn(r5, 0, r22.length());
        int r24 = r21.preceding(RangesKt.coerceAtMost(r23 + 1, r22.length()));
        if (r24 != (-1)) goto L153;
        r24 = r21.first();
    L153:
        int r25 = r21.following(RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r23, r22.length() - 1), 0));
        if (r25 == (-1)) goto L208;
        IntRange r26 = MessageLongPressTextSelectHelper.g(r18, r24, r25);
        if (r26 != null) goto L159;
        IntRange r27 = null;
    L160:
        if (r27 != null) goto L163;
        return null;
    L163:
        if (MessageLongPressTextSelectHelper.c(r18, r27) == true) goto L210;
        int r0 = r27.getFirst();
        if (r23 > r27.getLast()) goto L169;
        if (r0 > r23) goto L169;
        boolean r1 = true;
    L170:
        if (r1 == false) goto L172;
    L173:
        r4 = true;
    L174:
        if (r4 == true) goto L176;
        return null;
    L176:
        return r27;
    L172:
        if (r23 != (r27.getLast() + 1)) goto L174;
    L169:
        r1 = false;
        goto L170
    L210:
        return null;
    L159:
        r27 = MessageLongPressTextSelectHelper.h(r18, r26);
        goto L160
    L208:
        return null;
    L207:
        return null;
    L205:
        return r20;
    L103:
        if (MessageLongPressTextSelectHelper.c(r18, r20) == true) goto L145;
        if ((r20 instanceof Collection) == true) goto L108;
    L110:
        IntIterator r28 = r20.iterator();
    L112:
        if (r28.hasNext() == false) goto L126;
        int r114 = r28.nextInt();
        if (r114 >= 0) goto L116;
    L118:
        boolean r115 = false;
    L119:
        if (r115 == false) goto L123;
        MessageLongPressTextSelectHelper.a.getClass();
        if (MessageLongPressTextSelectHelper.d(r18, r114, r7, r8) == false) goto L123;
        boolean r116 = true;
    L124:
        if (r116 == false) goto L112;
        boolean r29 = true;
    L127:
        if (r29 == true) goto L146;
        if (r11 == true) goto L146;
        if (r110 == true) goto L146;
        if (r113 == false) goto L143;
        IntRange r30 = MessageLongPressTextSelectHelper.g(r18, 0, r18.length());
        if (r30 != null) goto L135;
        IntProgression r31 = null;
    L136:
        if (r31 == null) goto L143;
        if (r20.getLast() != r31.getLast()) goto L143;
        if (r20.getFirst() <= r31.getFirst()) goto L143;
        boolean r32 = true;
    L144:
        if (r32 == true) goto L146;
    L135:
        r31 = MessageLongPressTextSelectHelper.h(r18, r30);
    L143:
        r32 = false;
    L123:
        r116 = false;
        goto L124
    L116:
        if (r114 >= r18.length()) goto L118;
        r115 = true;
    L126:
        r29 = false;
        goto L127
    L108:
        if (r20.isEmpty() == false) goto L110;
    L98:
        r113 = false;
        goto L99
    L73:
        if (r8.a(r9) == null) goto L75;
        r110 = true;
        goto L77
    L43:
        if (r8.a(r10) == null) goto L45;
        r11 = true;
        goto L47
    L15:
        Spanned r33 = (Spanned) r18;
        Object[] r34 = r33.getSpans(0, r18.length(), ClickableSpan.class);
        ArrayList r35 = new ArrayList();
        int r117 = r34.length;
        int r118 = 0;
    L16:
        if (r118 >= r117) goto L32;
        ClickableSpan r119 = (ClickableSpan) r34[r118];
        MessageLongPressTextSelectHelper r120 = MessageLongPressTextSelectHelper.a;
        Intrinsics.checkNotNull(r119);
        r120.getClass();
        if ((r119 instanceof h) == true) goto L20;
    L22:
        boolean r121 = false;
    L23:
        if (r121 == true) goto L28;
        int r122 = r33.getSpanStart(r119);
        int r123 = r33.getSpanEnd(r119);
        if (r122 >= r123) goto L28;
        IntRange r124 = RangesKt.until(r122, r123);
    L29:
        if (r124 == null) goto L31;
        r35.add(r124);
    L31:
        r118 = r118 + 1;
    L28:
        r124 = null;
        goto L29
    L20:
        if (MessageLongPressTextSelectHelper.c.contains(((h) r119).getType()) == false) goto L22;
        r121 = true;
        goto L23
    L32:
        r8 = new MessageLongPressTextSelectHelper.a(CollectionsKt.sortedWith(r35, new e()));
        goto L33
    L5:
        if (((Spanned) r18).getSpans(0, r18.length(), com.ss.android.lark.widget.linked_emojicon.base.a.class).length != 0) goto L7;
        boolean r36 = true;
    L9:
        if ((!r36) == false) goto L11;
        r7 = true;
        goto L13
    L7:
        r36 = false;
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CharSequence) r1, ((Number) r2).intValue());
    }
}
