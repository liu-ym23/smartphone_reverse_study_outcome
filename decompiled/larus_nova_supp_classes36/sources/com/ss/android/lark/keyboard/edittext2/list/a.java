package com.ss.android.lark.keyboard.edittext2.list;

import android.text.Editable;
import android.widget.EditText;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.coremd.span.list.ListHeadType;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import kotlin.collections.ArraysKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends EditorListApplier {
    public final b p;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.edittext2.list.a$a, reason: collision with other inner class name */
    public static final class C0143a<T> implements Comparator {
        public final /* synthetic */ Editable a;

        public C0143a(Editable r1) {
            this.a = r1;
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            Editable r0 = this.a;
            Integer r4 = Integer.valueOf(r0.getSpanStart((y9b.a) r2));
            Editable r1 = this.a;
            return ComparisonsKt.compareValues(r4, Integer.valueOf(r1.getSpanStart((y9b.a) r3)));
        }
    }

    public a(EditText r2, b r3) {
        Intrinsics.checkNotNullParameter(r2, "editText");
        Intrinsics.checkNotNullParameter(r3, "coordinator");
        super(r2, r3);
        this.p = r3;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.list.EditorListApplier
    public final void e(Editable r8, EditorListApplier.e r9) {
        Intrinsics.checkNotNullParameter(r8, "s");
        Intrinsics.checkNotNullParameter(r9, "info");
        super.e(r8, r9);
        h(r8);
        int r0 = r9.a;
        Object[] r1 = r8.getSpans(r0, r9.c + r0, y9b.a.class);
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        this.p.d((y9b.a) r1[r3]);
        r3 = r3 + 1;
        goto L3
    L5:
        int r4 = r9.a;
        y9b.a r10 = (y9b.a) ArraysKt.lastOrNull(r8.getSpans(r4, r9.c + r4, y9b.a.class));
        if (r10 == null) goto L40;
        int r5 = r8.getSpanStart(r10);
        int r6 = r8.getSpanEnd(r10);
        if (r5 < r6) goto L11;
        return;
    L11:
        if (r6 >= 1) goto L13;
    L15:
        Iterator r7 = RangesKt.until(r6, r8.length()).iterator();
    L17:
        if (r7.hasNext() == false) goto L24;
        Object r11 = r7.next();
        if (r8.charAt(((Number) r11).intValue()) != '\n') goto L21;
        boolean r12 = true;
    L22:
        if (r12 == false) goto L17;
    L25:
        Integer r13 = (Integer) r11;
        if (r13 == null) goto L28;
        int r14 = r13.intValue();
    L30:
        if (r14 >= r8.length()) goto L32;
        r14 = r14 + 1;
    L32:
        r8.setSpan(r10, r5, r14, r8.getSpanFlags(r10));
        return;
    L28:
        r14 = r8.length();
        goto L30
    L21:
        r12 = false;
        goto L22
    L24:
        r11 = null;
        goto L25
    L13:
        if (r8.charAt(r6 - 1) != '\n') goto L15;
        return;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.list.EditorListApplier
    public final void f(Editable r19, EditorListApplier.d r20) {
        Intrinsics.checkNotNullParameter(r19, "s");
        Intrinsics.checkNotNullParameter(r20, "info");
        y9b.a r3 = r20.a;
        if (r3 == null) goto L132;
        int r4 = r20.b;
        int r5 = r20.c;
        int r6 = r20.d;
        int r7 = Math.min(r19.length(), r6);
    L6:
        if (r7 >= r19.length()) goto L11;
        if (r19.charAt(r7) == '\n') goto L11;
        r7 = r7 + 1;
    L11:
        if (r7 >= r19.length()) goto L13;
        r7 = r7 + 1;
    L13:
        LinkedList<y9b.a> r8 = this.j;
        r8.clear();
        LinkedHashMap r10 = new LinkedHashMap();
        if (r19.length() != 0) goto L16;
        boolean r11 = true;
    L17:
        if (r11 == false) goto L19;
        int r16 = 1;
        boolean r17 = false;
    L47:
        if ((r6 - r5) == 1) goto L49;
    L51:
        boolean r9 = false;
    L52:
        if (r9 == false) goto L54;
        r16 = 2;
    L54:
        int r12 = r4;
    L56:
        if (r12 >= r7) goto L63;
        if (r12 >= r19.length()) goto L62;
        if (r19.charAt(r12) != 8203) goto L62;
        r19.delete(r12, r12 + 1);
        r7 = r7 - 1;
    L62:
        r12 = r12 + 1;
    L63:
        int r13 = r4 - 1;
        ArrayList r14 = (ArrayList) this.f;
        r14.clear();
        int r15 = r4;
    L64:
        if (r15 >= r7) goto L77;
        if (r16 <= 0) goto L77;
        if (r19.charAt(r15) == '\n') goto L71;
        if (r15 == (r7 - 1)) goto L71;
    L76:
        r15 = r15 + 1;
    L71:
        if (r19.charAt(r15) == '\n') goto L73;
    L75:
        r14.add(Integer.valueOf(Math.min(r19.length(), r15 + 1)));
        r16 = r16 - 1;
        r13 = r15;
        goto L76
    L73:
        if ((r15 - r13) != 1) goto L75;
        r19.insert(r15, "\u200b");
        r7 = r7 + 1;
        r15 = r15 + 1;
    L77:
        if (r16 <= 0) goto L89;
        if (r7 != r19.length()) goto L89;
        if (r19.length() != 0) goto L83;
        boolean r18 = true;
    L84:
        if (r18 == false) goto L86;
    L87:
        r19.append(8203);
        r14.add(Integer.valueOf(r19.length()));
        goto L89
    L86:
        if (StringsKt.last(r19) != '\n') goto L89;
    L83:
        r18 = false;
    L89:
        if ((!r14.isEmpty()) == false) goto L110;
        int r21 = 0;
        int r22 = 0;
    L92:
        if (r21 >= r14.size()) goto L112;
        int r110 = r21 + 1;
        int r23 = ((Number) ListProtector.get(r14, r21)).intValue();
        if ((r3 instanceof y9b.b) == false) goto L96;
        r22 = r22 + 1;
    L96:
        int r111 = r19.getSpanStart(r3);
        int r112 = r19.getSpanEnd(r3);
        Integer r113 = (Integer) r10.get(Integer.valueOf(r4));
        if (r113 == null) goto L99;
        r3.f(r113.intValue());
        r3.g(ListHeadType.None);
    L99:
        this.p.d(r3);
        if (r111 != r4) goto L102;
        if (r112 != r23) goto L102;
    L104:
        if (r110 == r14.size()) goto L105;
        y9b.a r24 = r8.pollFirst();
        if (r24 != null) goto L109;
        r24 = this.p.a(r3);
    L109:
        this.p.getClass();
        b.c(r24, r3);
        this.p.d(r24);
        r3 = r24;
        r4 = r23;
        r21 = r110;
        goto L92
    L105:
        r4 = r23;
    L102:
        r19.setSpan(r3, r4, r23, 33);
    L112:
        if ((!r8.isEmpty()) == false) goto L116;
        y9b.a r25 = r8.pollFirst();
        if (r25 == null) goto L112;
        r19.removeSpan(r25);
        this.p.b(r25);
        goto L112
    L116:
        if (r17 == false) goto L119;
        if (r4 == r7) goto L119;
        boolean r26 = true;
    L120:
        boolean r27 = r20.f;
        if (r22 == r20.g) goto L123;
        boolean r114 = true;
    L124:
        boolean r2 = !r10.isEmpty();
        if (r114 == true) goto L129;
        if (r26 == true) goto L129;
        if (r27 == true) goto L129;
        if (r2 == true) goto L129;
        return;
    L129:
        h(r19);
        return;
    L123:
        r114 = false;
    L119:
        r26 = false;
        goto L120
    L110:
        r22 = 0;
        goto L112
    L49:
        if (r19.charAt(r5) != '\n') goto L51;
        r9 = true;
        goto L52
    L19:
        y9b.a[] r115 = (y9b.a[]) r19.getSpans(r4, Math.min(r7 + 1, r19.length()), y9b.a.class);
        if (r115.length <= 1) goto L22;
        ArraysKt.sortWith(r115, new C0143a(r19));
    L22:
        int r116 = r115.length;
        int r117 = 0;
        r16 = 0;
        r17 = false;
    L23:
        if (r117 >= r116) goto L47;
        y9b.a r118 = r115[r117];
        int r28 = r19.getSpanStart(r118);
        int r119 = r19.getSpanEnd(r118);
        if (r28 != r7) goto L27;
        r17 = true;
    L27:
        if (r119 > r7) goto L31;
        if (r119 > r5) goto L30;
        if (r28 >= r6) goto L31;
    L30:
        r16 = r16 + 1;
    L31:
        if (r4 > r28) goto L34;
        if (r28 >= r7) goto L34;
        boolean r120 = true;
    L35:
        if (r120 == false) goto L45;
        if (Intrinsics.areEqual(r118, r3) == true) goto L45;
        if (r5 > r28) goto L41;
        if (r28 > r6) goto L41;
        boolean r121 = true;
    L42:
        if (r121 == false) goto L44;
        r10.put(Integer.valueOf(r28), Integer.valueOf(r118.b()));
    L44:
        r8.addLast(r118);
    L41:
        r121 = false;
    L45:
        r117 = r117 + 1;
    L34:
        r120 = false;
        goto L35
    L16:
        r11 = false;
        goto L17
    L132:
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
