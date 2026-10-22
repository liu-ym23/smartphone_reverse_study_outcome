package com.ss.android.lark.chat.message.menu;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class MessageLongPressTextSelectHelper$partialRangeStrategies$2 extends FunctionReferenceImpl implements Function2<CharSequence, Integer, IntRange> {
    public MessageLongPressTextSelectHelper$partialRangeStrategies$2(Object r8) {
        super(2, r8, MessageLongPressTextSelectHelper.class, "findParagraphRange", "findParagraphRange(Ljava/lang/CharSequence;I)Lkotlin/ranges/IntRange;", 0);
    }

    public final IntRange invoke(CharSequence r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "p0");
        MessageLongPressTextSelectHelper r0 = (MessageLongPressTextSelectHelper) ((CallableReference) this).receiver;
        MessageLongPressTextSelectHelper r1 = MessageLongPressTextSelectHelper.a;
        r0.getClass();
        boolean r2 = false;
        int r9 = RangesKt.coerceIn(r8, 0, r7.length());
        int r3 = RangesKt.coerceAtMost(r9 - 1, r7.length() - 1);
    L4:
        if (r3 < 0) goto L9;
        if (r7.charAt(r3) == '\n') goto L7;
        r3 = r3 - 1;
        goto L4
    L7:
        int r4 = r3 + 1;
    L10:
        int r5 = RangesKt.coerceAtMost(r9, r7.length());
    L12:
        if (r5 >= r7.length()) goto L17;
        if (r7.charAt(r5) == '\n') goto L18;
        r5 = r5 + 1;
    L18:
        IntRange r6 = MessageLongPressTextSelectHelper.g(r7, r4, r5);
        if (r6 != null) goto L21;
        IntRange r10 = null;
    L22:
        if (r10 != null) goto L25;
        return null;
    L25:
        if (MessageLongPressTextSelectHelper.c(r7, r10) == true) goto L45;
        int r11 = r10.getFirst();
        if (r9 > r10.getLast()) goto L31;
        if (r11 > r9) goto L31;
        boolean r12 = true;
    L32:
        if (r12 == false) goto L34;
    L35:
        r2 = true;
    L36:
        if (r2 == true) goto L38;
        return null;
    L38:
        return r10;
    L34:
        if (r9 != (r10.getLast() + 1)) goto L36;
    L31:
        r12 = false;
        goto L32
    L45:
        return null;
    L21:
        r10 = MessageLongPressTextSelectHelper.h(r7, r6);
        goto L22
    L17:
        r5 = r7.length();
        goto L18
    L9:
        r4 = 0;
        goto L10
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CharSequence) r1, ((Number) r2).intValue());
    }
}
