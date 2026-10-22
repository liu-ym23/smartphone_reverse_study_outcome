package com.ss.android.lark.chat.message.menu;

import android.text.Layout;
import android.text.Spanned;
import android.text.style.ReplacementSpan;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.PartialReplyInfo;
import com.ss.android.lark.chat.utils.u;
import com.ss.android.lark.widget.light.LKUILightTextView;
import com.ss.android.lark.widget.select.m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KFunction;
import kotlin.text.CharsKt;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MessageLongPressTextSelectHelper {
    public static final MessageLongPressTextSelectHelper a = null;
    public static final Set<Character> b = null;
    public static final Set<Class<? extends s>> c = null;
    public static final List<Function2<CharSequence, Integer, IntRange>> d = null;
    public static final WeakHashMap<LKUILightTextView, b> e = null;

    public static final class a {
        public static final a b = null;
        public final List<IntRange> a;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.message.menu.MessageLongPressTextSelectHelper$a$a, reason: collision with other inner class name */
        public static final class C0098a {
        }

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "SentenceBoundaryClickableInfo(ranges=" + this.a + ')';
        }

        static {
            b = new a(CollectionsKt.emptyList());
        }

        public a(List<IntRange> r2) {
            Intrinsics.checkNotNullParameter(r2, "ranges");
            this.a = r2;
        }

        public final IntRange a(int r7) {
            if (this.a.isEmpty() == true) goto L15;
            if (r7 < 0) goto L15;
            int r0 = CollectionsKt.getLastIndex(this.a);
            int r2 = 0;
        L7:
            if (r2 > r0) goto L15;
            int r3 = (r2 + r0) >>> 1;
            IntRange r4 = (IntRange) ListProtector.get(this.a, r3);
            if (r7 < r4.getFirst()) goto L10;
            if (r7 <= r4.getLast()) goto L14;
            r2 = r3 + 1;
            goto L7
        L14:
            return r4;
        L10:
            r0 = r3 - 1;
        L15:
            return null;
        }
    }

    public static final class b {
        public float a;
        public float b;
        public boolean c;

        public b() {
            this(0);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Float.compare(this.a, r6.a) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.b, r6.b) == 0) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "TouchState(downX=" + this.a + ", downY=" + this.b + ", hasDown=" + this.c + ')';
        }

        public b(int r1) {
            this.a = 0.0f;
            this.b = 0.0f;
            this.c = false;
        }
    }

    public MessageLongPressTextSelectHelper() {
    }

    static {
        MessageLongPressTextSelectHelper r0 = new MessageLongPressTextSelectHelper();
        a = r0;
        b = SetsKt.setOf(new Character[]{'.', '!', '?', (char) 12290, (char) 65281, (char) 65311, (char) 8230});
        c = SetsKt.setOf(new Class[]{com.ss.android.lark.coremd.nonimbiz.asl.a.class, com.ss.android.lark.coremd.nonimbiz.calendar.a.class});
        d = CollectionsKt.listOf(new KFunction[]{new MessageLongPressTextSelectHelper$partialRangeStrategies$1(r0), new MessageLongPressTextSelectHelper$partialRangeStrategies$2(r0), new MessageLongPressTextSelectHelper$partialRangeStrategies$3(r0), new MessageLongPressTextSelectHelper$partialRangeStrategies$4(r0)});
        e = new WeakHashMap();
    }

    public static boolean e(char r3) {
        if (Character.isLetterOrDigit(r3) == false) goto L5;
        return true;
    L5:
        if (13312 <= r3) goto L7;
    L9:
        boolean r0 = false;
    L10:
        if (r0 == false) goto L12;
    L27:
        boolean r1 = true;
    L28:
        if (r1 == false) goto L30;
        return true;
    L30:
        if (r3 != '_') goto L32;
        return true;
    L32:
        if (r3 == '-') goto L39;
        return false;
    L39:
        return true;
    L12:
        if (19968 <= r3) goto L14;
    L16:
        boolean r2 = false;
    L17:
        if (r2 == true) goto L27;
        if (63744 <= r3) goto L21;
    L23:
        boolean r4 = false;
    L24:
        if (r4 == true) goto L27;
        r1 = false;
        goto L28
    L21:
        if (r3 >= 64256) goto L23;
        r4 = true;
        goto L24
    L14:
        if (r3 >= 40960) goto L16;
        r2 = true;
        goto L17
    L7:
        if (r3 >= 19904) goto L9;
        r0 = true;
        goto L10
    }

    public static IntRange a(CharSequence r4, int r5) {
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return null;
    L9:
        int r6 = Math.max(0, RangesKt.coerceIn(r5, 0, r4.length()) - 1);
        int r1 = Math.min(r4.length(), r6 + 2);
        if ((r1 - r6) < 2) goto L14;
        return RangesKt.until(r6, r1);
    L14:
        return RangesKt.until(Math.max(0, r4.length() - 2), r4.length());
    L5:
        r0 = false;
        goto L6
    }

    public static boolean c(CharSequence r3, IntRange r4) {
        IntRange r0 = g(r3, 0, r3.length());
        if (r0 != null) goto L5;
        IntProgression r5 = null;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (r4.getFirst() == r5.getFirst()) goto L11;
        return false;
    L11:
        if (r4.getLast() != r5.getLast()) goto L15;
        return true;
    L15:
        return false;
    L5:
        r5 = h(r3, r0);
        goto L6
    }

    public static IntRange h(CharSequence r12, IntRange r13) {
        if ((r12 instanceof Spanned) == true) goto L5;
        return r13;
    L5:
        int r0 = r13.getFirst();
        int r14 = r13.getLast() + 1;
    L7:
        if (r0 >= r14) goto L42;
        Spanned r3 = (Spanned) r12;
        Object[] r4 = r3.getSpans(r0, r14, ReplacementSpan.class);
        ArrayList r5 = new ArrayList();
        int r6 = r4.length;
        int r8 = 0;
    L9:
        if (r8 >= r6) goto L22;
        Object r9 = r4[r8];
        ReplacementSpan r10 = (ReplacementSpan) r9;
        int r11 = r3.getSpanStart(r10);
        int r15 = r3.getSpanEnd(r10);
        if (r0 > r11) goto L14;
        if (r11 >= r15) goto L14;
        boolean r16 = true;
    L15:
        if (r16 == false) goto L18;
        if (r15 != r14) goto L18;
        boolean r17 = true;
    L19:
        if (r17 == false) goto L21;
        r5.add(r9);
    L21:
        r8 = r8 + 1;
    L18:
        r17 = false;
    L14:
        r16 = false;
        goto L15
    L22:
        Iterator r7 = r5.iterator();
        if (r7.hasNext() == true) goto L25;
        Object r18 = null;
    L34:
        ReplacementSpan r19 = (ReplacementSpan) r18;
        if (r19 == null) goto L42;
        r14 = r3.getSpanStart(r19);
    L38:
        if (r0 >= r14) goto L7;
        int r2 = r14 - 1;
        if (CharsKt.isWhitespace(r12.charAt(r2)) == false) goto L7;
        r14 = r2;
        goto L38
    L25:
        r18 = r7.next();
        if (r7.hasNext() == false) goto L34;
        int r20 = r3.getSpanStart((ReplacementSpan) r18);
    L29:
        Object r21 = r7.next();
        int r22 = r3.getSpanStart((ReplacementSpan) r21);
        if (r20 >= r22) goto L33;
        r18 = r21;
        r20 = r22;
    L33:
        if (r7.hasNext() == true) goto L29;
    L42:
        if (r0 < r14) goto L44;
        return null;
    L44:
        return RangesKt.until(r0, r14);
    }

    public static IntRange b(CharSequence r2, int r3, boolean r4) {
        if (r4 == true) goto L4;
    L15:
        return null;
    L4:
        if ((r2 instanceof Spanned) == false) goto L15;
        com.ss.android.lark.widget.linked_emojicon.base.a r5 = (com.ss.android.lark.widget.linked_emojicon.base.a) ArraysKt.firstOrNull(((Spanned) r2).getSpans(r3, RangesKt.coerceAtMost(r3 + 1, r2.length()), com.ss.android.lark.widget.linked_emojicon.base.a.class));
        if (r5 == null) goto L15;
        Spanned r6 = (Spanned) r2;
        int r0 = r6.getSpanStart(r5);
        int r7 = r6.getSpanEnd(r5);
        if (r0 > r3) goto L12;
        if (r3 >= r7) goto L12;
        boolean r8 = true;
    L13:
        if (r8 == false) goto L15;
        return RangesKt.until(r0, r7);
    L12:
        r8 = false;
        goto L13
    }

    public static IntRange g(CharSequence r2, int r3, int r4) {
        int r5 = RangesKt.coerceIn(r3, 0, r2.length());
        int r6 = RangesKt.coerceIn(r4, 0, r2.length());
    L3:
        if (r5 >= r6) goto L7;
        if (CharsKt.isWhitespace(r2.charAt(r5)) == false) goto L7;
        r5 = r5 + 1;
    L7:
        if (r6 <= r5) goto L11;
        int r0 = r6 - 1;
        if (CharsKt.isWhitespace(r2.charAt(r0)) == false) goto L11;
        r6 = r0;
    L11:
        if (r5 < r6) goto L15;
        return null;
    L15:
        return RangesKt.until(r5, r6);
    }

    public static boolean d(CharSequence r4, int r5, boolean r6, a r7) {
        if (r5 >= 0) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L11;
        return false;
    L11:
        if (b.contains(Character.valueOf(r4.charAt(r5))) == false) goto L13;
        return true;
    L13:
        if (b(r4, r5, r6) == null) goto L15;
        return true;
    L15:
        if (r7.a(r5) != null) goto L21;
        return false;
    L21:
        return true;
    L5:
        if (r5 >= r4.length()) goto L7;
        r2 = true;
        goto L8
    }

    @JvmStatic
    public static final void f(LKUILightTextView r13, m2b.a r14, boolean r15, Function3<? super CharSequence, ? super Boolean, ? super PartialReplyInfo.PartialContentRelativePosition, Unit> r16, Function0<Unit> r17, Integer r18) {
        Intrinsics.checkNotNullParameter(r13, "selectableView");
        Intrinsics.checkNotNullParameter(r16, "changeCopyTextAction");
        Intrinsics.checkNotNullParameter(r17, "onTextSelectedAction");
        MessageLongPressTextSelectHelper r0 = a;
        r0.getClass();
        u r2 = u.a.a;
        if (r2.d == false) goto L9;
        if (com.ss.android.lark.chat.message.menu.a.b(r13) == false) goto L9;
        r2.g = 2;
        r2.f = true;
    L9:
        if (ChatCoreModule.a().getFeatureGatingDependency().isEnable("lark.im.partial.select") == true) goto L12;
        r0.getClass();
        com.ss.android.lark.chat.message.menu.a.d(r13, r14, r15, r16, r17, r18, 64);
        return;
    L12:
        WeakHashMap<LKUILightTextView, b> r3 = e;
        boolean r9 = false;
        if (r3.containsKey(r13) == true) goto L16;
        b r8 = new b(0);
        r3.put(r13, r8);
        r13.setOnTouchListener(new f(r13, r8));
    L16:
        Object r10 = r13.getTag(2131388122);
        if ((r10 instanceof LKUILightTextView) == false) goto L19;
        LKUILightTextView r11 = (LKUILightTextView) r10;
    L20:
        if (r11 == null) goto L36;
        if (ChatCoreModule.a().getFeatureGatingDependency().isEnable("lark.im.partial.select") == true) goto L25;
    L31:
        boolean r12 = false;
    L32:
        if (r12 == false) goto L36;
        r2.g = 2;
        r2.f = true;
        r0.getClass();
        com.ss.android.lark.chat.message.menu.a.d(r11, r14, r15, r16, r17, r18, 64);
        return;
    L25:
        if (r2.d == false) goto L31;
        if (com.ss.android.lark.chat.message.menu.a.b(r13) == false) goto L29;
    L30:
        r12 = true;
        goto L32
    L29:
        if (com.ss.android.lark.chat.message.menu.a.b(r11) == false) goto L31;
    L36:
        if (ChatCoreModule.a().getFeatureGatingDependency().isEnable("lark.im.partial.select") == true) goto L39;
    L45:
        boolean r1 = false;
    L46:
        if (r1 == false) goto L123;
        b r4 = r3.get(r13);
        Layout r5 = r13.getLayout();
        if (r5 == null) goto L90;
        CharSequence r6 = r5.getText();
        if (r6.length() != 0) goto L53;
        boolean r7 = true;
    L54:
        if (r7 == true) goto L90;
        Layout r19 = r13.getLayout();
        if (r19 == null) goto L65;
        if (r4 != null) goto L61;
    L63:
        boolean r20 = false;
    L64:
        if (r20 == false) goto L65;
        float r21 = (r4.a - r13.getTotalPaddingLeft()) + r13.getScrollX();
        float r22 = r4.b;
        int r110 = r13.getGravity() & 112;
        if (r110 != 16) goto L69;
        float r111 = (r13.getMeasuredHeight() - com.ss.android.lark.widget.light.layout.e.a(r19)) / 2;
    L74:
        Integer r23 = Integer.valueOf(r19.getOffsetForHorizontal(r19.getLineForVertical((int) ((r22 - r111) + r13.getScrollY())), r21));
    L75:
        if (r23 == null) goto L90;
        int r24 = r23.intValue();
        if (r24 >= 0) goto L79;
    L81:
        boolean r25 = false;
    L82:
        if (r25 == false) goto L90;
        Iterator<T> r26 = d.iterator();
    L86:
        if (r26.hasNext() == false) goto L90;
        IntRange r27 = (IntRange) ((Function2) r26.next()).invoke(r6, Integer.valueOf(r24));
        if (r27 == null) goto L86;
    L91:
        if (r27 == null) goto L123;
        a.getClass();
        WeakReference<m> r28 = com.ss.android.lark.chat.message.menu.a.a;
        Intrinsics.checkNotNullParameter(r13, "view");
        WeakReference<View> r29 = com.ss.android.lark.chat.message.menu.a.b;
        if (r29 == null) goto L95;
        View r30 = r29.get();
    L97:
        if (Intrinsics.areEqual(r13, r30) == false) goto L121;
        Intrinsics.checkNotNullParameter(r27, "intRange");
        WeakReference<m> r31 = com.ss.android.lark.chat.message.menu.a.a;
        if (r31 == null) goto L119;
        m r32 = r31.get();
        if (r32 == null) goto L119;
        u r33 = u.a.a;
        r33.g = 2;
        r33.f = true;
        monitor-enter(r33);
        r33.a = null;     // Catch: Throwable -> L115
        monitor-exit(r33);
        int r34 = r27.getFirst();
        int r35 = r27.getLast() + 1;
        CharSequence r112 = r32.c.getContent();     // Catch: Exception -> L112
        if (r112 == null) goto L114;
        int r113 = r112.length();     // Catch: Exception -> L112
        r32.k(Math.max(0, Math.min(r34, r113)), Math.max(0, Math.min(r35, r113)));     // Catch: Exception -> L112
        r32.i = true;     // Catch: Exception -> L112
        r32.g(null);     // Catch: Exception -> L112
        r32.j();     // Catch: Exception -> L112
    L114:
        r9 = true;
    L112:
        e = move-exception;
        e.toString();
    L115:
        th = move-exception;
        throw th;
    L119:
        if (r9 == false) goto L121;
        return;
    L121:
        u r36 = u.a.a;
        r36.c();
        r36.g = 2;
        r36.f = true;
        com.ss.android.lark.chat.message.menu.a.c(r13, r14, r15, r16, r17, r18, r27);
        return;
    L95:
        r30 = null;
        goto L97
    L79:
        if (r24 > r6.length()) goto L81;
        r25 = true;
        goto L82
    L69:
        if (r110 == 80) goto L71;
        int r114 = r13.getPaddingTop();
    L72:
        r111 = r114;
        goto L74
    L71:
        r114 = (r13.getMeasuredHeight() - r13.getPaddingBottom()) - com.ss.android.lark.widget.light.layout.e.a(r19);
        goto L72
    L61:
        if (r4.c != true) goto L63;
        r20 = true;
    L65:
        r23 = null;
        goto L75
    L53:
        r7 = false;
    L90:
        r27 = null;
    L123:
        a.getClass();
        com.ss.android.lark.chat.message.menu.a.d(r13, r14, r15, r16, r17, r18, 64);
        return;
    L39:
        if (r2.d == false) goto L45;
        if (com.ss.android.lark.chat.message.menu.a.b(r13) == false) goto L43;
    L44:
        r1 = true;
        goto L46
    L43:
        if (com.ss.android.lark.chat.message.menu.a.b(r13) == false) goto L45;
    L19:
        r11 = null;
        goto L20
    }
}
