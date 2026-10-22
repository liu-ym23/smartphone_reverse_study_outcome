package com.obric.assistant.cocreationreview;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.banner.bean.ObricBannerType;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class UsageCardTemplateRenderer {
    public final Context a;
    public final Function2<String, Vote, Unit> b;
    public final Function2<String, String, Unit> c;
    public final Function2<String, String, Unit> d;
    public final Function1<String, Unit> e;
    public final Function1<z4.a, Unit> f;
    public final Function1<View, Unit> g;
    public final Function0<View> h;
    public final Function2<String, Integer, Unit> i;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/cocreationreview/UsageCardTemplateRenderer$TemplateTagPlacement;", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;I)V", "HEADER", "FOOT", "FEEDBACK", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TemplateTagPlacement extends Enum<TemplateTagPlacement> {
        public static final TemplateTagPlacement FEEDBACK = null;
        public static final TemplateTagPlacement FOOT = null;
        public static final TemplateTagPlacement HEADER = null;
        public static final /* synthetic */ TemplateTagPlacement[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<TemplateTagPlacement> getEntries() {
            return b;
        }

        static {
            TemplateTagPlacement r0 = new TemplateTagPlacement("HEADER", 0);
            HEADER = r0;
            TemplateTagPlacement r1 = new TemplateTagPlacement("FOOT", 1);
            FOOT = r1;
            TemplateTagPlacement r3 = new TemplateTagPlacement("FEEDBACK", 2);
            FEEDBACK = r3;
            TemplateTagPlacement[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static TemplateTagPlacement[] values() {
            return (TemplateTagPlacement[]) a.clone();
        }

        public static TemplateTagPlacement valueOf(String r1) {
            return (TemplateTagPlacement) r27.a.a(TemplateTagPlacement.class, r1);
        }

        public TemplateTagPlacement(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b {
        public final float a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;

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
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            return (((((((((Float.floatToIntBits(this.a) * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f;
        }

        public final String toString() {
            return "TemplateTagStyle(textSizeSp=" + this.a + ", radiusDp=" + this.b + ", horizontalPaddingDp=" + this.c + ", textColor=" + this.d + ", fillColor=" + this.e + ", strokeColor=" + this.f + ')';
        }

        public /* synthetic */ b(float r8, int r9, int r10) {
            this(r8, r9, r10, -9735552, -1, -1973274);
        }

        public static b a(b r8, int r9, int r10, int r11, int r12) {
            if ((r12 & 1) == 0) goto L5;
            float r2 = r8.a;
        L7:
            if ((r12 & 2) == 0) goto L9;
            int r3 = r8.b;
        L11:
            if ((r12 & 4) == 0) goto L13;
            int r4 = r8.c;
        L15:
            if ((r12 & 8) == 0) goto L17;
            r9 = r8.d;
        L17:
            int r5 = r9;
            if ((r12 & 16) == 0) goto L20;
            r10 = r8.e;
        L20:
            int r6 = r10;
            if ((r12 & 32) == 0) goto L24;
            r11 = r8.f;
        L24:
            return new b(r2, r3, r4, r5, r6, r11);
        L13:
            r4 = 0;
            goto L15
        L9:
            r3 = 0;
            goto L11
        L5:
            r2 = 0.0f;
            goto L7
        }

        public b(float r1, int r2, int r3, int r4, int r5, int r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[TemplateTagPlacement.values().length];
            r0[TemplateTagPlacement.HEADER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L41:
            r0[TemplateTagPlacement.FOOT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L57:
            r0[TemplateTagPlacement.FEEDBACK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L8:
            a = r0;
            int[] r1 = new int[Vote.values().length];
            r1[Vote.UP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L45:
            r1[Vote.DOWN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L11:
            b = r1;
            int[] r2 = new int[CardTemplateTagTone.values().length];
            r2[CardTemplateTagTone.NEUTRAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L47:
            r2[CardTemplateTagTone.ACCENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L35:
            r2[CardTemplateTagTone.SUCCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
        L49:
            r2[CardTemplateTagTone.WARNING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L30
        L39:
            r2[CardTemplateTagTone.DANGER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L31
        L51:
            r2[CardTemplateTagTone.METRIC.ordinal()] = 6;     // Catch: NoSuchFieldError -> L32
        L53:
            r2[CardTemplateTagTone.FEEDBACK_UP.ordinal()] = 7;     // Catch: NoSuchFieldError -> L33
        L43:
            r2[CardTemplateTagTone.FEEDBACK_DOWN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L34
        L20:
            c = r2;
        }
    }

    static {
    }

    public static Integer b(String r6) {
        String r7 = StringsKt.trim(r6).toString();
        boolean r1 = false;
        if (r7.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        return null;
    L9:
        int r2 = 0;
    L11:
        if (r2 >= r7.length()) goto L21;
        char r4 = r7.charAt(r2);
        if ('0' <= r4) goto L15;
    L17:
        boolean r5 = false;
    L18:
        if (r5 == false) goto L19;
        r2 = r2 + 1;
        goto L11
    L19:
        boolean r3 = false;
    L22:
        if (r3 == true) goto L24;
        return null;
    L24:
        Integer r8 = StringsKt.toIntOrNull(r7);
        if (r8 == null) goto L36;
        Integer r9 = Integer.valueOf(r8.intValue());
        int r10 = r9.intValue();
        if (r10 >= 0) goto L29;
    L31:
        if (r1 == true) goto L33;
        return null;
    L33:
        return r9;
    L29:
        if (r10 >= 10000) goto L31;
        r1 = true;
        goto L31
    L36:
        return null;
    L15:
        if (r4 >= ':') goto L17;
        r5 = true;
        goto L18
    L21:
        r3 = true;
        goto L22
    L5:
        r0 = false;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r3v27, types: [com.obric.assistant.cocreationreview.i6] */
    public final View c(final w5 r49) {
        final UsageCardTemplateRenderer r6 = this;
        Intrinsics.checkNotNullParameter(r49, "template");
        Context r8 = r6.a;
        LinearLayout r9 = c4.k(r8);
        r9.setPadding(c4.c(r8, 14), c4.c(r8, 14), c4.c(r8, 14), c4.c(r8, 14));
        r9.setBackground(c4.h(r8, -1, 18, -1973274, 1));
        Context r13 = r6.a;
        LinearLayout r14 = c4.e(r13);
        r14.setGravity(16);
        LinearLayout r0 = c4.e(r13);
        Iterator<T> r1 = r49.f.iterator();
        int r2 = 0;
    L4:
        if (r1.hasNext() == false) goto L12;
        Object r3 = r1.next();
        int r18 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        View r4 = r6.e((d) r3, TemplateTagPlacement.HEADER, null);
        LinearLayout.LayoutParams r11 = new LinearLayout.LayoutParams(-2, c4.c(r13, 30));
        if (r2 >= CollectionsKt.getLastIndex(r49.f)) goto L11;
        r11.setMargins(0, 0, c4.c(r13, 7), 0);
    L11:
        Unit r5 = Unit.INSTANCE;
        r0.addView(r4, r11);
        r2 = r18;
        goto L4
    L12:
        HorizontalScrollView r7 = new HorizontalScrollView(r13);
        r7.setHorizontalScrollBarEnabled(false);
        r7.setOverScrollMode(2);
        r7.addView(r0, new ViewGroup.LayoutParams(-2, -2));
        r14.addView(r7, new LinearLayout.LayoutParams(0, -2, 1.0f));
        if (r49.d.b != Vote.UP) goto L15;
        boolean r10 = true;
    L16:
        View r12 = g("赞", r10, -14979842, !r49.e, new f6(r6, r49));
        LinearLayout.LayoutParams r15 = new LinearLayout.LayoutParams(c4.c(r13, 32), c4.c(r13, 32));
        r15.setMargins(c4.c(r13, 5), 0, 0, 0);
        Unit r16 = Unit.INSTANCE;
        r14.addView(r12, r15);
        if (r49.d.b != Vote.DOWN) goto L19;
        boolean r17 = true;
    L20:
        View r19 = g("踩", r17, -2076093, !r49.e, new g6(r6, r49));
        LinearLayout.LayoutParams r20 = new LinearLayout.LayoutParams(c4.c(r13, 32), c4.c(r13, 32));
        r20.setMargins(c4.c(r13, 5), 0, 0, 0);
        r14.addView(r19, r20);
        c4.b(r9, r14, 0, 0, 0, 14);
        Context r21 = r6.a;
        String r22 = r49.c.b;
        if (r22 == null) goto L25;
        int r23 = 1;
        if ((!StringsKt.isBlank(r22)) == true) goto L27;
    L26:
        r22 = null;
    L27:
        LinearLayout r24 = c4.k(r21);
        c4.b(r24, c4.f(r21, r49.c.a, 16.0f, -15656921, r23), 0, 0, 0, 14);
        if (r22 == null) goto L58;
        Context r25 = r6.a;
        List r110 = StringsKt.split$default(r22, new char[]{'\n'}, false, 0, 6, null);
        ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator r112 = r110.iterator();
    L31:
        if (r112.hasNext() == false) goto L33;
        r111.add(StringsKt.trim((String) r112.next()).toString());
        goto L31
    L33:
        ArrayList r113 = new ArrayList();
        Iterator r114 = r111.iterator();
    L35:
        if (r114.hasNext() == false) goto L43;
        Object r115 = r114.next();
        if (((String) r115).length() <= 0) goto L39;
        boolean r26 = true;
    L40:
        if (r26 == false) goto L35;
        r113.add(r115);
        goto L35
    L39:
        r26 = false;
        goto L40
    L43:
        if (r113.size() > 1) goto L45;
        View r27 = c4.f(r25, r22, 13.0f, -9735552, 1);
    L57:
        c4.b(r24, r27, 0, c4.c(r21, 4), 0, 10);
        goto L58
    L45:
        LinearLayout r28 = c4.k(r25);
        Iterator r116 = r113.iterator();
        int r117 = 0;
    L47:
        if (r116.hasNext() == false) goto L56;
        Object r29 = r116.next();
        int r32 = r117 + 1;
        if (r117 >= 0) goto L51;
        CollectionsKt.throwIndexOverflow();
    L51:
        TextView r118 = c4.f(r25, (String) r29, 13.0f, -9735552, 1);
        r118.setMaxLines(1);
        r118.setEllipsize(TextUtils.TruncateAt.END);
        if (r117 != 0) goto L54;
        int r210 = 0;
    L55:
        c4.b(r28, r118, 0, r210, 0, 10);
        r117 = r32;
        goto L47
    L54:
        r210 = c4.c(r25, 2);
        goto L55
    L56:
        r27 = r28;
    L58:
        TextView r211 = c4.f(r21, r49.c.c, 12.5f, -9735552, 0);
        if (r22 != null) goto L61;
        int r30 = 5;
    L62:
        c4.b(r24, r211, 0, c4.c(r21, r30), 0, 10);
        c4.b(r9, r24, 0, c4.c(r8, 10), 0, 10);
        final z4 r31 = r49.j;
        if (r49.h == true) goto L65;
    L68:
        View r33 = r49.g;
    L69:
        c4.b(r9, r33, 0, c4.c(r8, 14), 0, 10);
        int r34 = 17;
        if (r49.m == false) goto L125;
        final String r35 = r49.a;
        Integer r36 = r49.d.h;
        if (r49.e == false) goto L74;
    L76:
        boolean r37 = false;
    L77:
        Context r119 = r6.a;
        LinearLayout r212 = c4.k(r119);
        c4.b(r212, (View) r6.h.invoke(), c4.c(r119, 1), 0, c4.c(r119, 15), 4);
        TextView r38 = c4.f(r119, "这条建议对你的价值？", 12.0f, -9735552, 1);
        r38.setGravity(17);
        c4.b(r212, r38, 0, 0, c4.c(r119, 9), 6);
        LinearLayout r39 = c4.e(r119);
        r39.setPadding(c4.c(r119, 3), c4.c(r119, 3), c4.c(r119, 3), c4.c(r119, 3));
        r39.setBackground(c4.h(r119, -459777, ObricBannerType.OTHER, 0, 0));
        Iterator r120 = t3.a.iterator();
    L79:
        if (r120.hasNext() == false) goto L102;
        final int r121 = ((Number) r120.next()).intValue();
        if (r36 != null) goto L84;
    L86:
        final boolean r122 = false;
    L87:
        String r123 = "¥" + r121;
        if (r122 == false) goto L90;
        int r124 = 1;
        int r125 = -15656921;
    L91:
        TextView r126 = c4.f(r119, r123, 12.0f, r125, r124);
        r126.setGravity(r34);
        r126.setMinHeight(c4.c(r119, 28));
        if (r122 == false) goto L94;
        r126.setBackground(c4.h(r119, -1, ObricBannerType.OTHER, 0, 0));
    L94:
        r126.setEnabled(r37);
        if (r37 == false) goto L97;
        float r40 = 1.0f;
    L98:
        r126.setAlpha(r40);
        if (r37 == false) goto L101;
        r126.setClickable(true);
        r126.setOnClickListener(new y5(r6, r35, r122, r121));
    L101:
        r39.addView(r126, new LinearLayout.LayoutParams(0, -2, 1.0f));
        r120 = r120;
        r34 = 17;
        goto L79
    L97:
        r40 = 0.75f;
        goto L98
    L90:
        r125 = -5721662;
        r124 = 1;
        goto L91
    L84:
        if (r36.intValue() != r121) goto L86;
        r122 = true;
        goto L87
    L102:
        c4.b(r212, r39, 0, 0, 0, 14);
        Context r41 = r6.a;
        final LinearLayout r42 = c4.e(r41);
        r42.setId(2131362049);
        r42.setVisibility(8);
        LinearLayout r127 = c4.e(r41);
        r127.setPadding(c4.c(r41, 10), 0, c4.c(r41, 10), 0);
        r127.setMinimumHeight(c4.c(r41, 30));
        r127.setBackground(c4.h(r41, -459777, ObricBannerType.OTHER, -1973274, 1));
        r127.addView(c4.f(r41, "¥", 12.0f, -9735552, 1));
        final EditText r43 = new EditText(r41);
        r43.setId(2131362050);
        r43.setHint("自定义金额");
        r43.setTextSize(12.0f);
        r43.setTextColor(-15656921);
        r43.setHintTextColor(-5721662);
        r43.setTypeface(Typeface.DEFAULT_BOLD);
        r43.setInputType(2);
        r43.setMaxLines(1);
        r43.setBackground(null);
        r43.setEnabled(r37);
        r43.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(4)});
        if (r36 != null) goto L105;
    L107:
        r43.setPadding(c4.c(r41, 4), 0, 0, 0);
        r43.setOnFocusChangeListener(new k6(r6));
        r127.addView(r43, new LinearLayout.LayoutParams(0, -2, 1.0f));
        r42.addView(r127, new LinearLayout.LayoutParams(0, -2, 1.0f));
        TextView r44 = c4.j(r41, "确定", true, -14979842, new l6(r6, r43, r35));
        r44.setMinHeight(c4.c(r41, 30));
        r43.addTextChangedListener(new m6(r37, r6, r43, r44));
        a(r37, r6, r43, r44);
        LinearLayout.LayoutParams r45 = new LinearLayout.LayoutParams(-2, -2);
        r45.setMargins(c4.c(r41, 6), 0, 0, 0);
        Unit r128 = Unit.INSTANCE;
        r42.addView(r44, r45);
        TextView r46 = c4.f(r41, "取消", 12.0f, -9735552, 1);
        r46.setId(2131362051);
        r46.setGravity(17);
        r46.setMinHeight(c4.c(r41, 30));
        int r129 = 12;
        r46.setPadding(c4.c(r41, 12), 0, c4.c(r41, 12), 0);
        r46.setBackground(c4.h(r41, -459777, ObricBannerType.OTHER, 0, 0));
        r46.setClickable(true);
        LinearLayout.LayoutParams r47 = new LinearLayout.LayoutParams(-2, -2);
        r47.setMargins(c4.c(r41, 6), 0, 0, 0);
        r42.addView(r46, r47);
        final LinearLayout r48 = c4.e(r119);
        r48.setGravity(17);
        if (r36 == null) goto L110;
        String r50 = "已记录 ¥ " + r36;
    L111:
        r48.addView(c4.f(r119, r50, 12.0f, -5721662, 0));
        if (r36 == null) goto L114;
        String r130 = "修改金额";
    L115:
        if (r37 == false) goto L117;
        int r51 = -14979842;
    L118:
        TextView r52 = c4.f(r119, r130, 12.0f, r51, 1);
        r52.setPadding(c4.c(r119, 10), 0, 0, 0);
        if (r37 == false) goto L121;
        r52.setClickable(true);
        r52.setOnClickListener(new d6(r48, r42, r6));
    L121:
        r48.addView(r52);
        c4.b(r212, r48, 0, c4.c(r119, 7), 0, 10);
        View r53 = r42.findViewById(2131362051);
        if (r53 == null) goto L124;
        r53.setOnClickListener(new e6(r42, r48));
    L124:
        c4.b(r212, r42, 0, c4.c(r119, 7), 0, 10);
        c4.b(r9, r212, 0, c4.c(r8, 14), 0, 10);
    L127:
        if ((!r49.i.isEmpty()) == false) goto L129;
    L130:
        c4.a(r9, (View) r6.h.invoke(), c4.c(r8, 1), c4.c(r8, 14), c4.c(r8, r129));
        Context r54 = r6.a;
        LinearLayout r55 = c4.e(r54);
        r55.setGravity(16);
        if ((!r49.i.isEmpty()) == false) goto L148;
        List<com.obric.assistant.cocreationreview.c> r56 = r49.i;
        final z4 r57 = r49.j;
        if ((r57 instanceof z4.a) == false) goto L147;
        List<com.obric.assistant.cocreationreview.c> r58 = r56;
        ArrayList r59 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r58, 10));
        Iterator r60 = r58.iterator();
    L137:
        if (r60.hasNext() == false) goto L146;
        com.obric.assistant.cocreationreview.c r61 = (com.obric.assistant.cocreationreview.c) r60.next();
        final String r131 = r61.g;
        if (r131 == null) goto L145;
        if (r61.h != null) goto L145;
        Function0 r132 = new z5(r6, r57, r131);
        String r133 = r61.a;
        CardTemplateTagTone r134 = r61.b;
        Integer r135 = r61.c;
        Integer r136 = r61.d;
        Function1<Context, Drawable> r62 = r61.e;
        Integer r63 = r61.f;
        Intrinsics.checkNotNullParameter(r133, "text");
        Intrinsics.checkNotNullParameter(r134, "tone");
        r61 = new com.obric.assistant.cocreationreview.c(r133, r134, r135, r136, r62, r63, r131, r132);
    L145:
        r59.add(r61);
        r60 = r60;
        r57 = r57;
        goto L137
    L146:
        r56 = r59;
    L147:
        r55.addView(r6.d(r56), new LinearLayout.LayoutParams(0, -2, 1.0f));
    L149:
        final z4 r64 = r49.j;
        if ((r64 instanceof z4.a) == false) goto L152;
        final ?? r65 = new i6(r6, r64);
        Context r66 = r6.a;
        TextView r67 = c4.f(r66, "查看详情  ›", 10.5f, -14979842, 1);
        r67.setGravity(17);
        r67.setPadding(c4.c(r66, 12), 0, c4.c(r66, 10), 0);
        r67.setBackground(c4.h(r66, -1, 15, -1512723, 1));
        r67.setOnClickListener(new a6(r65));
        LinearLayout.LayoutParams r68 = new LinearLayout.LayoutParams(-2, c4.c(r54, 30));
        r68.setMargins(c4.c(r54, 10), 0, 0, 0);
        Unit r69 = Unit.INSTANCE;
        r55.addView(r67, r68);
    L152:
        c4.b(r9, r55, 0, 0, 0, 14);
    L153:
        com.obric.assistant.cocreationreview.b r70 = r49.k;
        if (Intrinsics.areEqual(r70, com.obric.assistant.cocreationreview.b.C0079b.a) == false) goto L156;
        LinearLayout r213 = r9;
    L270:
        int r71 = RangesKt.coerceIn(r49.b, 0, 3);
        if (r71 == 0) goto L307;
        Context r72 = this.a;
        int r73 = y3.a;
        FrameLayout r74 = new FrameLayout(r72);
        r74.setClipChildren(false);
        r74.setClipToPadding(false);
        int r137 = 0;
    L274:
        if (r137 >= r71) goto L276;
        int r75 = c4.c(r72, (r71 - r137) * 9);
        View r76 = new View(r72);
        r76.setImportantForAccessibility(2);
        r76.setBackground(c4.h(r72, -1, 18, -1973274, 1));
        FrameLayout.LayoutParams r77 = new FrameLayout.LayoutParams(-1, c4.c(r72, 58));
        r77.setMargins(r75, c4.c(r72, r137 * 7), r75, 0);
        Unit r78 = Unit.INSTANCE;
        r74.addView(r76, r77);
        r137 = r137 + 1;
        goto L274
    L276:
        FrameLayout.LayoutParams r79 = new FrameLayout.LayoutParams(-1, -2);
        r79.topMargin = c4.c(r72, r71 * 7);
        Unit r80 = Unit.INSTANCE;
        r74.addView(r213, r79);
        return r74;
    L307:
        return r213;
    L156:
        if ((r70 instanceof com.obric.assistant.cocreationreview.b.a) == false) goto L203;
        ((com.obric.assistant.cocreationreview.b.a) r70).getClass();
        Context r81 = r6.a;
        a5 r82 = r49.d;
        LinearLayout r83 = c4.k(r81);
        c4.b(r83, (View) r6.h.invoke(), c4.c(r81, 1), 0, c4.c(r81, 15), 4);
        Vote r84 = r82.b;
        if (r84 != null) goto L160;
        int r85 = -1;
    L162:
        if (r85 != (-1)) goto L164;
        List r86 = CollectionsKt.emptyList();
        if (r82.b != Vote.DOWN) goto L176;
        String r87 = "点踩原因（单选）";
    L177:
        r83.addView(c4.f(r81, r87, 13.5f, -9735552, 1));
        if (r86.isEmpty() == true) goto L199;
        final String r88 = r49.a;
        Context r89 = r6.a;
        LinearLayout r138 = c4.k(r89);
        LinearLayout r90 = c4.e(r89);
        Iterator r91 = r86.iterator();
        LinearLayout r92 = r90;
        int r93 = 0;
        int r94 = 0;
    L181:
        if (r91.hasNext() == false) goto L196;
        Object r139 = r91.next();
        int r140 = r93 + 1;
        if (r93 >= 0) goto L185;
        CollectionsKt.throwIndexOverflow();
    L185:
        final String r141 = (String) r139;
        int r142 = r141.length() + 4;
        if (r93 <= 0) goto L191;
        if ((r94 + r142) <= 22) goto L191;
        c4.b(r138, r92, 0, 0, c4.c(r89, 8), 6);
        r92 = c4.e(r89);
        r94 = 0;
    L191:
        if (r82.c.contains(r141) == false) goto L193;
        CardTemplateTagTone r95 = CardTemplateTagTone.ACCENT;
    L194:
        View r96 = r6.e(new d(r141, r95, null, null, 28), TemplateTagPlacement.FEEDBACK, null);
        r96.setOnClickListener(new c6(r6, r88, r141));
        LinearLayout.LayoutParams r143 = new LinearLayout.LayoutParams(-2, c4.c(r89, 32));
        r143.setMargins(0, 0, c4.c(r89, 8), 0);
        Unit r144 = Unit.INSTANCE;
        r92.addView(r96, r143);
        r94 = r94 + r142;
        r93 = r140;
        goto L181
    L193:
        r95 = CardTemplateTagTone.NEUTRAL;
        goto L194
    L196:
        if (r92.getChildCount() <= 0) goto L198;
        c4.b(r138, r92, 0, 0, 0, 14);
    L198:
        c4.b(r83, r138, 0, c4.c(r81, 10), 0, 10);
    L200:
        new EditText(r81).setText(r82.d);
        t3.a(null, r82.b);
        throw null;
    L199:
        c4.b(r83, c4.f(r81, "需先选择点赞或点踩", 12.0f, -9735552, 0), 0, c4.c(r81, 10), 0, 10);
        goto L200
    L176:
        r87 = "点赞原因（单选）";
        goto L177
    L164:
        if (r85 == 1) goto L172;
        if (r85 != 2) goto L170;
        throw null;
    L170:
        throw new NoWhenBranchMatchedException();
    L172:
        throw null;
    L160:
        r85 = c.b[r84.ordinal()];
        goto L162
    L203:
        if (Intrinsics.areEqual(r70, com.obric.assistant.cocreationreview.b.c.a) == false) goto L268;
        Context r97 = r6.a;
        a5 r98 = r49.d;
        LinearLayout r99 = c4.k(r97);
        c4.b(r99, (View) r6.h.invoke(), c4.c(r97, 1), 0, c4.c(r97, 15), 4);
        LinearLayout r145 = c4.e(r97);
        r145.setGravity(16);
        r145.addView(c4.f(r97, "标注结果", 13.5f, -15656921, 1), new LinearLayout.LayoutParams(0, -2, 1.0f));
        long r100 = r98.f;
        if (r100 > 0) goto L207;
        String r101 = "提交时间未知";
    L208:
        r145.addView(c4.f(r97, r101, 12.0f, -9735552, 0));
        c4.b(r99, r145, 0, 0, c4.c(r97, 10), 6);
        Vote r102 = r98.b;
        if (r102 != null) goto L211;
        int r103 = -1;
    L213:
        if (r103 != (-1)) goto L215;
        d r146 = null;
    L224:
        List r104 = CollectionsKt.listOfNotNull(r146);
        Set<String> r105 = r98.c;
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator<T> r107 = r105.iterator();
    L226:
        if (r107.hasNext() == false) goto L228;
        r106.add(new d((String) r107.next(), CardTemplateTagTone.NEUTRAL, null, null, 28));
        goto L226
    L228:
        List r108 = CollectionsKt.plus(r104, r106);
        Intrinsics.checkNotNullParameter(r108, "tags");
        Context r109 = r6.a;
        LinearLayout r147 = c4.k(r109);
        LinearLayout r148 = c4.e(r109);
        Iterator r149 = r108.iterator();
        LinearLayout r150 = r148;
        int r151 = 0;
        int r152 = 0;
    L230:
        if (r149.hasNext() == false) goto L242;
        Object r153 = r149.next();
        int r214 = r151 + 1;
        if (r151 >= 0) goto L234;
        CollectionsKt.throwIndexOverflow();
    L234:
        d r154 = (d) r153;
        int r310 = r154.a.length() + 4;
        if (r151 <= 0) goto L240;
        if ((r152 + r310) <= 22) goto L240;
        c4.b(r147, r150, 0, 0, c4.c(r109, 8), 6);
        r150 = c4.e(r109);
        r152 = 0;
    L240:
        View r155 = r6.e(r154, TemplateTagPlacement.FEEDBACK, null);
        LinearLayout.LayoutParams r156 = new LinearLayout.LayoutParams(-2, c4.c(r109, 32));
        r156.setMargins(0, 0, c4.c(r109, 8), 0);
        Unit r157 = Unit.INSTANCE;
        r150.addView(r155, r156);
        r152 = r152 + r310;
        r151 = r214;
        r149 = r149;
        goto L230
    L242:
        if (r150.getChildCount() <= 0) goto L244;
        c4.b(r147, r150, 0, 0, 0, 14);
    L244:
        c4.b(r99, r147, 0, 0, 0, 14);
        if ((!StringsKt.isBlank(r98.d)) == false) goto L248;
        c4.b(r99, c4.f(r97, "补充说明", 12.0f, -9735552, 1), 0, c4.c(r97, 12), c4.c(r97, 6), 2);
        TextView r158 = c4.f(r97, r98.d, 12.5f, -13418155, 0);
        r158.setPadding(c4.c(r97, 12), c4.c(r97, 10), c4.c(r97, 12), c4.c(r97, 10));
        r158.setBackground(c4.h(r97, -459777, 10, -1512723, 1));
        c4.b(r99, r158, 0, 0, 0, 14);
    L248:
        if ((!r49.l.isEmpty()) == false) goto L265;
        List<b5> r159 = r49.l;
        Context r160 = r6.a;
        LinearLayout r161 = c4.k(r160);
        c4.b(r161, c4.f(r160, "上传内容 · " + r159.size(), 12.0f, -9735552, 1), 0, 0, c4.c(r160, 6), 6);
        LinearLayout r162 = c4.e(r160);
        r162.setGravity(48);
        Iterator r163 = r159.iterator();
        int r164 = 0;
    L251:
        if (r163.hasNext() == false) goto L264;
        Object r165 = r163.next();
        int r166 = r164 + 1;
        if (r164 >= 0) goto L255;
        CollectionsKt.throwIndexOverflow();
    L255:
        b5 r167 = (b5) r165;
        Context r168 = r6.a;
        FrameLayout r169 = new FrameLayout(r168);
        Iterator r170 = r163;
        r169.setBackground(c4.h(r168, -1, 9, -1512723, 1));
        ImageView r171 = new ImageView(r168);
        r171.setScaleType(ImageView.ScaleType.CENTER_CROP);
        r171.setBackground(c4.h(r168, -1512205, 9, 0, 0));
        r171.setClipToOutline(true);
        r171.setContentDescription(r167.d);
        FrameLayout.LayoutParams r172 = new FrameLayout.LayoutParams(-1, -1);
        LinearLayout r215 = r9;
        Context r216 = r8;
        LinearLayout r311 = r99;
        r172.setMargins(c4.c(r168, 1), c4.c(r168, 1), c4.c(r168, 1), c4.c(r168, 1));
        Unit r173 = Unit.INSTANCE;
        r169.addView(r171, r172);
        ExecutorService r174 = p.a;
        p.c(r171, r167, c4.c(r168, 64));
        if (r167.getType() != FeedbackMediaType.VIDEO) goto L258;
        TextView r175 = c4.f(r168, "视频", 9.0f, -1, 1);
        r175.setGravity(17);
        r175.setBackground(c4.h(r168, -1728053248, 4, 0, 0));
        FrameLayout.LayoutParams r176 = new FrameLayout.LayoutParams(c4.c(r168, 30), c4.c(r168, 18), 8388691);
        int r177 = 0;
        r176.setMargins(c4.c(r168, 4), 0, 0, c4.c(r168, 4));
        r169.addView(r175, r176);
    L259:
        LinearLayout.LayoutParams r178 = new LinearLayout.LayoutParams(c4.c(r160, 64), c4.c(r160, 64));
        if (r164 >= CollectionsKt.getLastIndex(r159)) goto L263;
        r178.setMargins(r177, r177, c4.c(r160, 8), r177);
    L263:
        r162.addView(r169, r178);
        r6 = this;
        r163 = r170;
        r164 = r166;
        r9 = r215;
        r8 = r216;
        r99 = r311;
        goto L251
    L258:
        r177 = 0;
        goto L259
    L264:
        LinearLayout r312 = r99;
        Context r217 = r8;
        r213 = r9;
        HorizontalScrollView r179 = new HorizontalScrollView(r160);
        r179.setHorizontalScrollBarEnabled(false);
        r179.setOverScrollMode(2);
        r179.addView(r162, new ViewGroup.LayoutParams(-2, -2));
        c4.b(r161, r179, 0, 0, 0, 14);
        c4.b(r312, r161, 0, c4.c(r97, 12), 0, 10);
    L266:
        c4.b(r213, r312, 0, c4.c(r217, 15), 0, 10);
        goto L270
    L265:
        r312 = r99;
        r217 = r8;
        r213 = r9;
        goto L266
    L215:
        if (r103 != 1) goto L217;
        d r180 = new d("点赞", CardTemplateTagTone.FEEDBACK_UP, null, null, 28);
    L222:
        r146 = r180;
        goto L224
    L217:
        if (r103 != 2) goto L220;
        r180 = new d("点踩", CardTemplateTagTone.FEEDBACK_DOWN, null, null, 28);
        goto L222
    L220:
        throw new NoWhenBranchMatchedException();
    L211:
        r103 = c.b[r102.ordinal()];
        goto L213
    L207:
        r101 = "提交于 " + new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA).format(new Date(r100));
        goto L208
    L268:
        throw new NoWhenBranchMatchedException();
    L148:
        r55.addView(new View(r54), new LinearLayout.LayoutParams(0, 1, 1.0f));
        goto L149
    L129:
        if ((r49.j instanceof z4.a) == false) goto L153;
    L117:
        r51 = -5721662;
        goto L118
    L114:
        r130 = "自定义金额";
        goto L115
    L110:
        r50 = "未选择金额";
        goto L111
    L105:
        if (t3.a.contains(r36) == true) goto L107;
        r43.setText(r36.toString());
        r43.setSelection(r43.getText().length());
        goto L107
    L74:
        if ((r49.k instanceof com.obric.assistant.cocreationreview.b.c) == true) goto L76;
        r37 = true;
        goto L77
    L125:
        r129 = 12;
        goto L127
    L65:
        if ((r31 instanceof z4.a) == false) goto L68;
        r33 = r49.g;
        r33.setClickable(true);
        r33.setFocusable(true);
        r33.setOnClickListener(new h6(r6, r31));
        goto L69
    L61:
        r30 = 3;
        goto L62
    L25:
        r23 = 1;
        goto L26
    L19:
        r17 = false;
        goto L20
    L15:
        r10 = false;
        goto L16
    }

    public final View d(List<com.obric.assistant.cocreationreview.c> r18) {
        Intrinsics.checkNotNullParameter(r18, "tags");
        Context r2 = this.a;
        LinearLayout r3 = c4.e(r2);
        Iterator<T> r4 = r18.iterator();
        int r6 = 0;
    L4:
        if (r4.hasNext() == false) goto L21;
        Object r7 = r4.next();
        int r8 = r6 + 1;
        if (r6 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        com.obric.assistant.cocreationreview.c r9 = (com.obric.assistant.cocreationreview.c) r7;
        Integer r10 = r9.f;
        if (r10 == null) goto L11;
        Integer r11 = Integer.valueOf(c4.c(this.a, r10.intValue()));
    L12:
        View r5 = e(new d(r9.a, r9.b, r9.c, r9.d, r9.e), TemplateTagPlacement.FOOT, r11);
        final Function0<Unit> r12 = r9.h;
        if (r12 == null) goto L16;
        r5.setClickable(true);
        r5.setFocusable(true);
        r5.setOnClickListener(new b6(r12));
    L16:
        LinearLayout.LayoutParams r13 = new LinearLayout.LayoutParams(-2, c4.c(r2, 30));
        if (r6 >= CollectionsKt.getLastIndex(r18)) goto L20;
        r13.setMargins(0, 0, c4.c(r2, 7), 0);
    L20:
        Unit r14 = Unit.INSTANCE;
        r3.addView(r5, r13);
        r6 = r8;
        goto L4
    L11:
        r11 = null;
        goto L12
    L21:
        return r3;
    }

    public static b f(CardTemplateTagTone r4, TemplateTagPlacement r5) {
        int r6 = c.a[r5.ordinal()];
        int r1 = 8;
        int r2 = 15;
        float r3 = 10.5f;
        if (r6 != 1) goto L5;
        b r7 = new b(r3, r2, r1);
    L14:
        switch(c.c[r4.ordinal()]) {
            case 1: goto L25;
            case 2: goto L32;
            case 3: goto L31;
            case 4: goto L30;
            case 5: goto L29;
            case 6: goto L28;
            case 7: goto L27;
            case 8: goto L26;
            default: goto L16;
        };
    L16:
        throw new NoWhenBranchMatchedException();
    L26:
        return b.a(r7, -2076093, -3598, -79158, 7);
    L27:
        return b.a(r7, -14979842, -1379585, -14979842, 7);
    L28:
        return b.a(r7, -13418155, -459777, -1512723, 7);
    L29:
        return b.a(r7, -2349530, -3598, -79158, 7);
    L30:
        return b.a(r7, -680437, -2067, -75862, 7);
    L31:
        return b.a(r7, -15293622, -1378321, -3807022, 7);
    L32:
        return b.a(r7, -14979842, -1378561, -4661249, 7);
    L25:
        return b.a(r7, -9735552, -1, -1973274, 7);
    L5:
        if (r6 != 2) goto L7;
        r7 = new b(r3, r2, r1);
        goto L14
    L7:
        if (r6 != 3) goto L10;
        float r8 = 12.0f;
        r7 = new b(r8, 16, 10);
        goto L14
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final View e(d r17, TemplateTagPlacement r18, Integer r19) {
        Context r3 = this.a;
        int[] r4 = c.a;
        int r5 = r4[r18.ordinal()];
        if (r5 == 1) goto L13;
        if (r5 == 2) goto L12;
        if (r5 != 3) goto L11;
        Integer r6 = r17.c;
        if (r6 == null) goto L9;
        int r7 = r6.intValue();
        b r8 = b.a(f(r17.b, r18), r7, c4.g(r7), c4.i(r7), 7);
    L14:
        GradientDrawable r10 = c4.h(r3, r8.e, r8.b, r8.f, 1);
        Function1<Context, Drawable> r11 = r17.e;
        if (r11 == null) goto L17;
        Drawable r12 = (Drawable) r11.invoke(r3);
    L18:
        Integer r13 = r17.d;
        if (r12 != null) goto L25;
        if (r13 != null) goto L25;
        TextView r0 = c4.f(r3, r17.a, r8.a, r8.d, 1);
        r0.setGravity(17);
        r0.setMaxLines(1);
        r0.setEllipsize(TextUtils.TruncateAt.END);
        if (r19 == null) goto L24;
        r0.setMaxWidth(r19.intValue());
    L24:
        r0.setPadding(c4.c(r3, r8.c), 0, c4.c(r3, r8.c), 0);
        r0.setBackground(r10);
        return r0;
    L25:
        int r14 = c4.c(r3, r8.c);
        LinearLayout r15 = c4.e(r3);
        r15.setGravity(17);
        r15.setPadding(r14, 0, r14, 0);
        r15.setBackground(r10);
        int r1 = r4[r18.ordinal()];
        if (r1 == 1) goto L32;
        if (r1 == 2) goto L32;
        if (r1 != 3) goto L31;
        int r2 = 15;
    L33:
        ImageView r9 = new ImageView(r3);
        if (r12 == null) goto L36;
        r9.setImageDrawable(r12);
        r9.setScaleType(ImageView.ScaleType.CENTER_CROP);
        r9.setBackground(c4.h(r3, -1, 5, 0, 0));
        r9.setClipToOutline(true);
    L38:
        r9.setContentDescription(r17.a);
        LinearLayout.LayoutParams r16 = new LinearLayout.LayoutParams(c4.c(r3, r2), c4.c(r3, r2));
        r16.setMargins(0, 0, c4.c(r3, 5), 0);
        Unit r20 = Unit.INSTANCE;
        r15.addView(r9, r16);
        TextView r21 = c4.f(r3, r17.a, r8.a, r8.d, 1);
        r21.setMaxLines(1);
        r21.setEllipsize(TextUtils.TruncateAt.END);
        if (r19 == null) goto L41;
        r21.setMaxWidth(RangesKt.coerceAtLeast(r19.intValue() - (((r14 * 2) + c4.c(r3, r2)) + c4.c(r3, 5)), c4.c(r3, 24)));
    L41:
        r15.addView(r21);
        return r15;
    L36:
        if (r13 == null) goto L38;
        r9.setImageResource(r13.intValue());
        r9.setScaleType(ImageView.ScaleType.FIT_CENTER);
        goto L38
    L31:
        throw new NoWhenBranchMatchedException();
    L32:
        r2 = 16;
        goto L33
    L17:
        r12 = null;
        goto L18
    L9:
        r8 = f(r17.b, r18);
        goto L14
    L11:
        throw new NoWhenBranchMatchedException();
    L12:
        r8 = b.a(f(CardTemplateTagTone.NEUTRAL, r18), 0, 0, 0, 47);
        goto L14
    L13:
        r8 = f(CardTemplateTagTone.NEUTRAL, r18);
        goto L14
    }

    public static final void a(boolean r0, UsageCardTemplateRenderer r1, EditText r2, TextView r3) {
        if (r0 == false) goto L6;
        String r4 = r2.getText().toString();
        r1.getClass();
        if (b(r4) == null) goto L6;
        boolean r5 = true;
    L7:
        r3.setEnabled(r5);
        r3.setClickable(r5);
        if (r5 == false) goto L10;
        float r6 = 1.0f;
    L11:
        r3.setAlpha(r6);
        return;
    L10:
        r6 = 0.45f;
    L6:
        r5 = false;
        goto L7
    }

    public final ImageView g(String r6, boolean r7, int r8, boolean r9, final Function0<Unit> r10) {
        Intrinsics.checkNotNullParameter(r6, "text");
        Intrinsics.checkNotNullParameter(r10, "onClick");
        Context r0 = this.a;
        if (Intrinsics.areEqual(r6, "踩") == false) goto L5;
        int r1 = 2131235880;
    L6:
        ImageView r2 = new ImageView(r0);
        r2.setContentDescription(r6);
        r2.setImageResource(r1);
        if (r7 == false) goto L9;
        int r11 = -1;
    L10:
        r2.setColorFilter(r11);
        r2.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        r2.setPadding(c4.c(r0, 7), c4.c(r0, 7), c4.c(r0, 7), c4.c(r0, 7));
        GradientDrawable r12 = new GradientDrawable();
        r12.setShape(1);
        if (r7 == false) goto L13;
        int r3 = r8;
    L14:
        r12.setColor(r3);
        int r4 = c4.c(r0, 1);
        if (r7 == true) goto L18;
        r8 = -1512723;
    L18:
        r12.setStroke(r4, r8);
        r2.setBackground(r12);
        r2.setEnabled(r9);
        r2.setClickable(r9);
        r2.setFocusable(r9);
        if (r9 == false) goto L21;
        r2.setOnClickListener(new j6(r10));
    L21:
        return r2;
    L13:
        r3 = -459777;
        goto L14
    L9:
        r11 = -9735552;
        goto L10
    L5:
        r1 = 2131235881;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UsageCardTemplateRenderer(CocreationReviewActivity r2, Function2 r3, Function2 r4, b2 r5, Function1 r6, Function1 r7, Function1 r8, Function0 r9, Function2 r10) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "onVote");
        Intrinsics.checkNotNullParameter(r4, "onReasonToggle");
        Intrinsics.checkNotNullParameter(r5, "onCommentChange");
        Intrinsics.checkNotNullParameter(r6, "onComplete");
        Intrinsics.checkNotNullParameter(r7, "onShowDetail");
        Intrinsics.checkNotNullParameter(r8, "onInputFocus");
        Intrinsics.checkNotNullParameter(r9, "divider");
        Intrinsics.checkNotNullParameter(r10, "onFeedbackValueSelect");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }
}
