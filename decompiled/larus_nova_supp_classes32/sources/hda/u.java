package hda;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.tasm.event.LynxTouchEvent;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.cocreationreview.ModuleKey;
import com.obric.assistant.cocreationreview.a5;
import com.obric.assistant.cocreationreview.c4;
import com.obric.assistant.cocreationreview.l5;
import com.obric.assistant.cocreationreview.modules.memory.DiffType;
import com.obric.assistant.cocreationreview.modules.memory.MemoryDataReviewModuleKey;
import com.obric.assistant.cocreationreview.x4;
import com.obric.assistant.cocreationreview.y4;
import com.obric.assistant.cocreationreview.z4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class u {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public final String a;
        public final String b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
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
            return (((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f;
        }

        public final String toString() {
            return "DetailDiffStyle(prefix=" + this.a + ", badgeText=" + this.b + ", textColor=" + this.c + ", fillColor=" + this.d + ", strokeColor=" + this.e + ", badgeFillColor=" + this.f + ')';
        }

        public a(String r2, String r3, int r4, int r5, int r6, int r7) {
            Intrinsics.checkNotNullParameter(r2, "prefix");
            Intrinsics.checkNotNullParameter(r3, "badgeText");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[ModuleKey.values().length];
            r0[ModuleKey.PERSONAL_MEMORY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L4:
            a = r0;
            int[] r1 = new int[DiffType.values().length];
            r1[DiffType.EQUAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L14:
            r1[DiffType.INSERT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L20:
            r1[DiffType.DELETE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L8:
            b = r1;
        }
    }

    static {
    }

    public u() {
    }

    public static int c(int r4) {
        return ((Number) ListProtector.get(CollectionsKt.listOf(new Integer[]{176, 220, 196, 244}), r4 % 4)).intValue();
    }

    public static View e(Context r5, String r6) {
        TextView r7 = c4.f(r5, r6, 13.0f, -9735552, 0);
        r7.setGravity(17);
        r7.setPadding(c4.c(r5, 14), c4.c(r5, 14), c4.c(r5, 14), c4.c(r5, 14));
        r7.setBackground(c4.h(r5, -460036, 14, -1512723, 1));
        return r7;
    }

    public static final void b(TextView r1, Ref.BooleanRef r2, TextView r3) {
        if (r2.element == false) goto L5;
        int r0 = Integer.MAX_VALUE;
    L6:
        r1.setMaxLines(r0);
        if (r2.element == false) goto L9;
        TextUtils.TruncateAt r4 = null;
    L10:
        r1.setEllipsize(r4);
        if (r2.element == false) goto L13;
        String r5 = "收起 ⌃";
    L14:
        r3.setText(r5);
        return;
    L13:
        r5 = "展开全文 ⌄";
        goto L14
    L9:
        r4 = TextUtils.TruncateAt.END;
        goto L10
    L5:
        r0 = 4;
        goto L6
    }

    public static View d(Context r4, String r5, final Function0 r6) {
        TextView r7 = c4.f(r4, r5, 14.0f, -13418155, 0);
        r7.setLineSpacing(c4.c(r4, 2), 1.0f);
        r7.setPadding(c4.c(r4, 16), c4.c(r4, 13), c4.c(r4, 16), c4.c(r4, 13));
        r7.setBackground(c4.h(r4, -262657, 14, -1512723, 1));
        if (r6 == null) goto L5;
        r7.setClickable(true);
        r7.setFocusable(true);
        r7.setOnClickListener(new h(r6));
    L5:
        return r7;
    }

    public static List g(String r6, e1 r7, boolean r8) {
        if (r8 == false) goto L4;
        String r0 = null;
        if ((!StringsKt.isBlank(r6)) == true) goto L9;
        r6 = null;
    L9:
        if (r6 != null) goto L17;
        String r9 = r7.c;
        if ((!StringsKt.isBlank(r9)) == false) goto L13;
        r0 = r9;
    L13:
        if (r0 == null) goto L15;
        String r2 = r0;
    L19:
        if (r7.b != MemoryDataReviewModuleKey.PERSONAL_MEMORY) goto L21;
        String r10 = "记忆内容";
    L23:
        return CollectionsKt.listOf(new v(r10, r2, null, null, 12));
    L21:
        r10 = "记忆摘要";
        goto L23
    L15:
        return CollectionsKt.emptyList();
    L17:
        r2 = r6;
        goto L19
    L4:
        return CollectionsKt.emptyList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v34, types: [java.util.ArrayList, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v40, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v47, types: [java.util.List] */
    public static List a(final e1 r17, boolean r18, boolean r19, final List r20, List r21, List r22, List r23) {
        ArrayList r2 = new ArrayList();
        if ((!r20.isEmpty()) == false) goto L5;
        r2.add(new y4.a("基础信息", null, new o(r20)));
    L5:
        Iterator r1 = r21.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        final v r3 = (v) r1.next();
        r2.add(new y4.a(r3.a, null, new p(r3)));
        goto L7
    L9:
        Iterator r4 = r22.iterator();
    L11:
        if (r4.hasNext() == false) goto L13;
        final v r5 = (v) r4.next();
        r2.add(new y4.a(r5.a, null, new q(r5)));
        goto L11
    L13:
        if (r18 == false) goto L114;
        String r6 = r17.p;
        if (r6 != null) goto L17;
    L20:
        boolean r7 = true;
    L21:
        if (r7 == true) goto L114;
        String r8 = r17.o;
        if (r8 != null) goto L25;
    L28:
        boolean r9 = true;
    L29:
        if (r9 == true) goto L114;
        String r10 = r17.p;
        String r11 = r17.o;
        int r12 = b1.a;
        if (r10 != null) goto L33;
        r10 = NameKeys.UnloadStrategy_No_Strategy;
    L33:
        List r13 = b1.c(b1.a(r10));
        if (r11 != null) goto L36;
        r11 = NameKeys.UnloadStrategy_No_Strategy;
    L36:
        List r14 = b1.c(b1.a(r11));
        if (r13.isEmpty() == false) goto L42;
        if (r14.isEmpty() == false) goto L42;
        ?? r15 = CollectionsKt.emptyList();
    L102:
        final ArrayList r16 = new ArrayList();
        Iterator r24 = ((Iterable) r15).iterator();
    L104:
        if (r24.hasNext() == false) goto L112;
        Object r25 = r24.next();
        if (((d1) r25).getType() == DiffType.EQUAL) goto L108;
        boolean r26 = true;
    L109:
        if (r26 == false) goto L104;
        r16.add(r25);
        goto L104
    L108:
        r26 = false;
        goto L109
    L112:
        if ((!r16.isEmpty()) == false) goto L114;
        r2.add(new y4.a("变动点", null, new r(r16)));
    L42:
        if (r13.isEmpty() == false) goto L48;
        List r27 = r14;
        r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r27, 10));
        Iterator r28 = r27.iterator();
    L45:
        if (r28.hasNext() == false) goto L102;
        r15.add(new d1(DiffType.INSERT, (String) r28.next()));
        goto L45
    L48:
        if (r14.isEmpty() == false) goto L54;
        List r29 = r13;
        ArrayList r30 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r29, 10));
        Iterator r31 = r29.iterator();
    L51:
        if (r31.hasNext() == false) goto L53;
        r30.add(new d1(DiffType.DELETE, (String) r31.next()));
        goto L51
    L53:
        r15 = r30;
        goto L102
    L54:
        int r32 = r13.size() + 1;
        int[][] r33 = new int[r32][];
        int r110 = 0;
    L55:
        if (r110 >= r32) goto L57;
        r33[r110] = new int[r14.size() + 1];
        r110 = r110 + 1;
        goto L55
    L57:
        int r34 = r13.size() - 1;
        if (r34 < 0) goto L72;
    L59:
        int r111 = r34 - 1;
        int r112 = r14.size() - 1;
        if (r112 < 0) goto L69;
    L61:
        int r113 = r112 - 1;
        int[] r114 = r33[r34];
        if (Intrinsics.areEqual(ListProtector.get(r13, r34), ListProtector.get(r14, r112)) == false) goto L64;
        int r115 = r33[r34 + 1][r112 + 1] + 1;
    L65:
        r114[r112] = r115;
        if (r113 < 0) goto L69;
        r112 = r113;
        goto L61
    L64:
        r115 = Math.max(r33[r34 + 1][r112], r33[r34][r112 + 1]);
    L69:
        if (r111 < 0) goto L72;
        r34 = r111;
    L72:
        ArrayList r35 = new ArrayList();
        int r116 = 0;
        int r117 = 0;
    L74:
        if (r116 >= r13.size()) goto L85;
        if (r117 >= r14.size()) goto L85;
        if (Intrinsics.areEqual(ListProtector.get(r13, r116), ListProtector.get(r14, r117)) == true) goto L79;
        int r118 = r116 + 1;
        int r119 = r117 + 1;
        if (r33[r118][r117] >= r33[r116][r119]) goto L82;
        r35.add(new d1(DiffType.INSERT, (String) ListProtector.get(r14, r117)));
        r117 = r119;
        goto L74
    L82:
        r35.add(new d1(DiffType.DELETE, (String) ListProtector.get(r13, r116)));
        r116 = r118;
        goto L74
    L79:
        r35.add(new d1(DiffType.EQUAL, (String) ListProtector.get(r13, r116)));
        r116 = r116 + 1;
        r117 = r117 + 1;
    L85:
        if (r116 >= r13.size()) goto L88;
        r35.add(new d1(DiffType.DELETE, (String) ListProtector.get(r13, r116)));
        r116 = r116 + 1;
    L88:
        if (r117 >= r14.size()) goto L91;
        r35.add(new d1(DiffType.INSERT, (String) ListProtector.get(r14, r117)));
        r117 = r117 + 1;
        goto L88
    L91:
        if (r35.isEmpty() == false) goto L93;
        r15 = r35;
        goto L102
    L93:
        r15 = new ArrayList();
        Iterator r36 = r35.iterator();
    L95:
        if (r36.hasNext() == false) goto L102;
        d1 r37 = (d1) r36.next();
        d1 r38 = (d1) CollectionsKt.lastOrNull(r15);
        if (r38 == null) goto L101;
        if (r38.getType() != r37.getType()) goto L101;
        int r120 = CollectionsKt.getLastIndex(r15);
        String r39 = r38.b + '\n' + r37.b;
        DiffType r40 = r38.a;
        Intrinsics.checkNotNullParameter(r40, "type");
        Intrinsics.checkNotNullParameter(r39, "text");
        ListProtector.set(r15, r120, new d1(r40, r39));
    L101:
        r15.add(r37);
        goto L95
    L25:
        if (StringsKt.isBlank(r8) == true) goto L28;
        r9 = false;
        goto L29
    L17:
        if (StringsKt.isBlank(r6) == true) goto L20;
        r7 = false;
    L114:
        if (r19 == false) goto L134;
        final String r41 = r17.m;
        if (r41 != null) goto L118;
    L123:
        r41 = r17.e;
        if ((!StringsKt.isBlank(r41)) == true) goto L127;
        r41 = null;
    L127:
        if (r41 != null) goto L132;
        r41 = r17.d;
        if ((!StringsKt.isBlank(r41)) == true) goto L132;
        r41 = null;
    L132:
        if (r41 == null) goto L134;
        r2.add(new y4.a("记忆内容", null, new s(r41)));
        goto L134
    L118:
        if ((!StringsKt.isBlank(r41)) == true) goto L121;
        r41 = null;
    L121:
        if (r41 == null) goto L123;
    L134:
        Iterator r42 = r23.iterator();
    L136:
        if (r42.hasNext() == false) goto L139;
        final v r43 = (v) r42.next();
        r2.add(new y4.a(r43.a, null, new t(r43)));
        goto L136
    L139:
        if (u0.a(r17) == false) goto L141;
        r2.add(new y4.a("记忆来源", "memory_source", new f(r17)));
    L141:
        return r2;
    }

    public static z4.a f(l5 r29, String r30, String r31, String r32, a5 r33, e1 r34, boolean r35, List r36, Function1 r37, Function1 r38, ida.g r39, int r40) {
        if ((r40 & LynxTouchEvent.kPseudoStateFocusTransition) == 0) goto L5;
        boolean r19 = true;
    L7:
        if ((r40 & 256) == 0) goto L9;
        final List r6 = CollectionsKt.emptyList();
    L11:
        if ((r40 & 512) == 0) goto L13;
        Function1 r15 = new l(r6);
    L15:
        if ((r40 & 1024) == 0) goto L17;
        boolean r14 = true;
    L19:
        if ((r40 & 2048) == 0) goto L21;
        Function1 r13 = new m();
    L23:
        if ((r40 & 4096) == 0) goto L25;
        Function1 r12 = new n();
    L26:
        Intrinsics.checkNotNullParameter(r29, "meta");
        Intrinsics.checkNotNullParameter(r30, "recordId");
        Intrinsics.checkNotNullParameter(r31, "titleText");
        Intrinsics.checkNotNullParameter(r32, "timeLabel");
        Intrinsics.checkNotNullParameter(r33, "feedback");
        Intrinsics.checkNotNullParameter(r34, "uiModel");
        Intrinsics.checkNotNullParameter(r6, "basicInfo");
        Intrinsics.checkNotNullParameter(r15, "basicInfoProvider");
        Intrinsics.checkNotNullParameter(r13, "afterBasicInfoTextSectionsProvider");
        Intrinsics.checkNotNullParameter(r12, "afterMemoryContentTextSectionsProvider");
        List r25 = a(r34, r35, r19, r6, g(r31, r34, r14), (List) r13.invoke(r34), (List) r12.invoke(r34));
        if (b.a[r29.a.ordinal()] != 1) goto L29;
        String r3 = "个人信息详情";
    L30:
        String r22 = r3;
        String r5 = null;
        com.obric.assistant.cocreationreview.e r4 = new com.obric.assistant.cocreationreview.e(NameKeys.UnloadStrategy_No_Strategy, null, r32);
        if (r34.r.size() > 1) goto L33;
        List r26 = CollectionsKt.emptyList();
    L39:
        if (r29.a != ModuleKey.PERSONAL_MEMORY) goto L41;
        String r0 = "记忆内容";
    L43:
        return new z4.a(r30, r22, r4, r33, r25, r26, r0, 64);
    L41:
        r0 = "记忆摘要";
        goto L43
    L33:
        List<e1> r2 = r34.r;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r8 = r2.iterator();
    L35:
        if (r8.hasNext() == false) goto L37;
        e1 r9 = (e1) r8.next();
        r7.add(new x4(r9.a, new com.obric.assistant.cocreationreview.e(NameKeys.UnloadStrategy_No_Strategy, r5, r9.g), a(r9, r35, r19, (List) r15.invoke(r9), g(r9.c, r9, r14), (List) r13.invoke(r9), (List) r12.invoke(r9))));
        r12 = r12;
        r13 = r13;
        r14 = r14;
        r15 = r15;
        r5 = null;
        goto L35
    L37:
        r26 = r7;
        goto L39
    L29:
        r3 = r29.b + "详情";
        goto L30
    L25:
        r12 = r39;
        goto L26
    L21:
        r13 = r38;
        goto L23
    L17:
        r14 = false;
        goto L19
    L13:
        r15 = r37;
        goto L15
    L9:
        r6 = r36;
        goto L11
    L5:
        r19 = false;
        goto L7
    }
}
