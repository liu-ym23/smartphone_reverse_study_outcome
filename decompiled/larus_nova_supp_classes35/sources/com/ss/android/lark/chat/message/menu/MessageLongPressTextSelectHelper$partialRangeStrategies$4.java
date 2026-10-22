package com.ss.android.lark.chat.message.menu;

import android.text.Spanned;
import android.text.style.ReplacementSpan;
import java.text.BreakIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class MessageLongPressTextSelectHelper$partialRangeStrategies$4 extends FunctionReferenceImpl implements Function2<CharSequence, Integer, IntRange> {
    public MessageLongPressTextSelectHelper$partialRangeStrategies$4(Object r8) {
        super(2, r8, MessageLongPressTextSelectHelper.class, "findWordRange", "findWordRange(Ljava/lang/CharSequence;I)Lkotlin/ranges/IntRange;", 0);
    }

    public final IntRange invoke(CharSequence r13, int r14) {
        Intrinsics.checkNotNullParameter(r13, "p0");
        MessageLongPressTextSelectHelper r0 = (MessageLongPressTextSelectHelper) ((CallableReference) this).receiver;
        MessageLongPressTextSelectHelper r1 = MessageLongPressTextSelectHelper.a;
        r0.getClass();
        boolean r2 = false;
        IntProgression r3 = null;
        if ((r13 instanceof Spanned) == false) goto L15;
        int r4 = RangesKt.coerceIn(r14, 0, r13.length());
        Spanned r5 = (Spanned) r13;
        Object[] r6 = r5.getSpans(0, r13.length(), ReplacementSpan.class);
        int r7 = r6.length;
        int r8 = 0;
    L6:
        if (r8 >= r7) goto L15;
        ReplacementSpan r9 = (ReplacementSpan) r6[r8];
        int r10 = r5.getSpanStart(r9);
        int r11 = r5.getSpanEnd(r9);
        if (r10 > r4) goto L11;
        if (r4 >= r11) goto L11;
        boolean r12 = true;
    L12:
        if (r12 == true) goto L13;
        r8 = r8 + 1;
        goto L6
    L13:
        IntRange r15 = RangesKt.until(r10, r11);
    L16:
        if (r15 != null) goto L99;
        String r16 = r13.toString();
        if (r16.length() != 0) goto L21;
        boolean r17 = true;
    L22:
        if (r17 == true) goto L79;
        BreakIterator r18 = BreakIterator.getWordInstance(Locale.getDefault());
        r18.setText(r16);
        int r19 = RangesKt.coerceIn(r14, 0, r16.length() - 1);
        int r20 = r18.preceding(r19 + 1);
        int r21 = r18.following(r19);
        if (r20 == (-1)) goto L79;
        if (r21 == (-1)) goto L79;
        if (r20 >= r21) goto L79;
    L29:
        if (r20 <= 0) goto L44;
        CharSequence r22 = r16.subSequence(r20, r21);
        int r23 = 0;
    L32:
        if (r23 >= r22.length()) goto L37;
        if (MessageLongPressTextSelectHelper.e(r22.charAt(r23)) == true) goto L35;
        r23 = r23 + 1;
        goto L32
    L35:
        boolean r24 = true;
    L38:
        if (r24 == true) goto L44;
        int r25 = r18.preceding(r20);
        if (r25 == (-1)) goto L79;
        if (r25 >= r20) goto L79;
        int r110 = r20;
        r20 = r25;
        r21 = r110;
        goto L29
    L37:
        r24 = false;
    L44:
        IntProgression r26 = MessageLongPressTextSelectHelper.g(r16, r20, r21);
        if (r26 == null) goto L79;
        CharSequence r27 = r16.subSequence(r26.getFirst(), r26.getLast() + 1);
        MessageLongPressTextSelectHelper r28 = MessageLongPressTextSelectHelper.a;
        int r29 = 0;
    L49:
        if (r29 >= r27.length()) goto L54;
        char r30 = r27.charAt(r29);
        r28.getClass();
        if (MessageLongPressTextSelectHelper.e(r30) == true) goto L52;
        r29 = r29 + 1;
        goto L49
    L52:
        r2 = true;
    L54:
        if (r2 == true) goto L57;
        r26 = null;
    L57:
        if (r26 == null) goto L79;
        MessageLongPressTextSelectHelper.a.getClass();
        if (((r26.getLast() - r26.getFirst()) + 1) >= 2) goto L78;
        IntRange r31 = MessageLongPressTextSelectHelper.a(r16, r14);
        if (r31 == null) goto L78;
        int r32 = Math.min(r26.getFirst(), r31.getFirst());
        int r33 = Math.max(r26.getLast() + 1, r31.getLast() + 1);
    L66:
        if (r32 >= r26.getFirst()) goto L71;
        if (MessageLongPressTextSelectHelper.e(r16.charAt(r32)) == true) goto L71;
        r32 = r32 + 1;
    L71:
        if (r33 <= (r26.getLast() + 1)) goto L76;
        int r34 = r33 - 1;
        if (MessageLongPressTextSelectHelper.e(r16.charAt(r34)) == true) goto L76;
        r33 = r34;
    L76:
        if ((r33 - r32) < 2) goto L78;
        r3 = RangesKt.until(r32, r33);
    L78:
        r3 = r26;
    L79:
        if (r3 == null) goto L82;
        return r3;
    L82:
        return MessageLongPressTextSelectHelper.a(r13, r14);
    L21:
        r17 = false;
        goto L22
    L99:
        return r15;
    L11:
        r12 = false;
    L15:
        r15 = null;
        goto L16
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CharSequence) r1, ((Number) r2).intValue());
    }
}
