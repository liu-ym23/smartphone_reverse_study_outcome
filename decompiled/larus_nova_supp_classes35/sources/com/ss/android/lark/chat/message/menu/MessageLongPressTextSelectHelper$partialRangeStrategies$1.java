package com.ss.android.lark.chat.message.menu;

import android.text.Spanned;
import android.text.style.ClickableSpan;
import com.ss.android.lark.coremd.impl.parse.h;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class MessageLongPressTextSelectHelper$partialRangeStrategies$1 extends FunctionReferenceImpl implements Function2<CharSequence, Integer, IntRange> {
    public MessageLongPressTextSelectHelper$partialRangeStrategies$1(Object r8) {
        super(2, r8, MessageLongPressTextSelectHelper.class, "findClickableSpanRange", "findClickableSpanRange(Ljava/lang/CharSequence;I)Lkotlin/ranges/IntRange;", 0);
    }

    public final IntRange invoke(CharSequence r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "p0");
        MessageLongPressTextSelectHelper r0 = (MessageLongPressTextSelectHelper) ((CallableReference) this).receiver;
        MessageLongPressTextSelectHelper r1 = MessageLongPressTextSelectHelper.a;
        r0.getClass();
        if ((r9 instanceof Spanned) == false) goto L24;
        int r11 = RangesKt.coerceIn(r10, 0, r9.length());
        Spanned r2 = (Spanned) r9;
        Object[] r12 = r2.getSpans(0, r9.length(), ClickableSpan.class);
        int r3 = r12.length;
        int r4 = 0;
    L6:
        if (r4 >= r3) goto L24;
        ClickableSpan r5 = (ClickableSpan) r12[r4];
        MessageLongPressTextSelectHelper r6 = MessageLongPressTextSelectHelper.a;
        Intrinsics.checkNotNull(r5);
        r6.getClass();
        boolean r7 = true;
        if ((r5 instanceof h) == true) goto L10;
    L12:
        boolean r8 = false;
    L13:
        if (r8 == true) goto L23;
        int r13 = r2.getSpanStart(r5);
        int r14 = r2.getSpanEnd(r5);
        if (r13 > r11) goto L19;
        if (r11 > r14) goto L19;
    L20:
        if (r7 == false) goto L23;
        if (r13 >= r14) goto L23;
        return RangesKt.until(r13, r14);
    L19:
        r7 = false;
    L23:
        r4 = r4 + 1;
        goto L6
    L10:
        if (MessageLongPressTextSelectHelper.c.contains(((h) r5).getType()) == false) goto L12;
        r8 = true;
    L24:
        return null;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CharSequence) r1, ((Number) r2).intValue());
    }
}
