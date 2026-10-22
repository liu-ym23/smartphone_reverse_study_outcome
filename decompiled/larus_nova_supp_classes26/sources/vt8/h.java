package vt8;

import android.text.SpannableStringBuilder;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.platform.model.MarkDownSelectorSettings;
import io.noties.markwon.core.spans.t;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lw8.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h implements d {
    public final CustomMarkdownTextView a;
    public final Lazy b;
    public int c;

    public static boolean e(char r3) {
        if ('A' <= r3) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
    L16:
        return true;
    L10:
        if ('a' <= r3) goto L12;
    L14:
        boolean r4 = false;
    L15:
        if (r4 == true) goto L16;
        return false;
    L12:
        if (r3 >= '{') goto L14;
        r4 = true;
        goto L15
    L5:
        if (r3 >= '[') goto L7;
        r1 = true;
        goto L8
    }

    @Override // vt8.d
    public final int b() {
        return this.c;
    }

    public h(CustomMarkdownTextView r1) {
        this.a = r1;
        this.b = LazyKt.lazy(new g());
        this.c = 2;
    }

    public static List c(String r4, char r5) {
        ArrayList r0 = new ArrayList();
        int r1 = r4.length();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        if (r4.charAt(r2) != r5) goto L7;
        r0.add(Integer.valueOf(r2));
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        return r0;
    }

    public static Pair d(Pair r3, Pair r4) {
        if (r4 != null) goto L5;
        return r3;
    L5:
        if ((((Number) r4.getSecond()).intValue() - ((Number) r4.getFirst()).intValue()) < (((Number) r3.getSecond()).intValue() - ((Number) r3.getFirst()).intValue())) goto L7;
    L11:
        return r3;
    L7:
        if (((Number) r4.getFirst()).intValue() < ((Number) r3.getFirst()).intValue()) goto L11;
        if (((Number) r4.getSecond()).intValue() >= ((Number) r3.getSecond()).intValue()) goto L11;
        return r4;
    }

    public static Pair f(String r7, int r8) {
        if (r8 < 0) goto L43;
        boolean r1 = true;
        if (r8 > (r7.length() - 1)) goto L43;
        char r0 = r7.charAt(r8);
        if (CollectionsKt.listOf(new Character[]{' ', '/', '-', '%', (char) 8240}).contains(Character.valueOf(r0)) == true) goto L42;
        char r2 = r7.charAt(r8);
        if (r8 > 0) goto L11;
    L27:
        boolean r9 = false;
    L28:
        if (r9 == true) goto L42;
        if (Character.isDigit(r0) == false) goto L33;
    L36:
        if (r1 == false) goto L39;
        Boolean r10 = Boolean.TRUE;
        return TuplesKt.to(r10, r10);
    L39:
        Boolean r11 = Boolean.FALSE;
        return TuplesKt.to(r11, r11);
    L33:
        if (e(r0) == true) goto L36;
        r1 = false;
        goto L36
    L11:
        if (r8 >= (r7.length() - 1)) goto L27;
        if (CollectionsKt.listOf(new Character[]{'.', ','}).contains(Character.valueOf(r2)) == false) goto L27;
        char r3 = r7.charAt(r8 - 1);
        char r12 = r7.charAt(r8 + 1);
        if (r2 != '.') goto L23;
        if (e(r3) == false) goto L23;
        if (e(r12) == false) goto L23;
    L26:
        r9 = true;
    L23:
        if (Character.isDigit(r3) == false) goto L27;
        if (Character.isDigit(r12) == false) goto L27;
    L42:
        return TuplesKt.to(Boolean.TRUE, Boolean.FALSE);
    L43:
        Boolean r13 = Boolean.FALSE;
        return TuplesKt.to(r13, r13);
    }

    @Override // vt8.d
    public final Pair<Integer, Integer> a(String r24, int r25) {
        Intrinsics.checkNotNullParameter(r24, "txt");
        Lazy r3 = c.a;
        if (c.c(r25, this.a) == false) goto L6;
        Pair<Integer, Integer> r1 = new f(this.a).a(r24, r25);
        this.c = 4;
        return r1;
    L6:
        this.c = 2;
        CustomMarkdownTextView r5 = this.a;
        if (r5 == null) goto L23;
        l r6 = r5.getMarkdownContent();
        if (r6 == null) goto L23;
        SpannableStringBuilder r7 = r6.e();
        if (r7 == null) goto L23;
        t[] r9 = (t[]) r7.getSpans(0, r7.length(), t.class);
        int r10 = r9.length;
        int r11 = 0;
    L14:
        if (r11 >= r10) goto L23;
        t r12 = r9[r11];
        int r13 = r7.getSpanStart(r12);
        int r14 = r7.getSpanEnd(r12);
        if (r13 > r25) goto L19;
        if (r25 >= r14) goto L19;
        boolean r15 = true;
    L20:
        if (r15 == true) goto L21;
        r11 = r11 + 1;
        goto L14
    L21:
        Pair r8 = TuplesKt.to(Integer.valueOf(r13), Integer.valueOf(r14));
    L24:
        if (r8 != null) goto L27;
        r8 = null;
    L27:
        int r16 = r25;
    L29:
        if (r16 <= 0) goto L37;
        if (CollectionsKt.listOf(new Character[]{(char) 12298, (char) 12299}).contains(Character.valueOf(r24.charAt(r16))) == true) goto L37;
        if (r24.charAt(r16) == '\n') goto L50;
        r16 = r16 - 1;
    L50:
        Pair r17 = null;
    L52:
        if (r17 == null) goto L54;
        r8 = d(r17, r8);
    L54:
        List r18 = c(r24, '\"');
        List r19 = c(r24, '\'');
        int r20 = r25;
    L55:
        int r110 = 6;
        if (r20 <= 0) goto L63;
        if (CollectionsKt.listOf(new Character[]{'\'', '\"', (char) 8220, (char) 8221, (char) 8216, (char) 8217}).contains(Character.valueOf(r24.charAt(r20))) == true) goto L63;
        if (r24.charAt(r20) == '\n') goto L106;
        r20 = r20 - 1;
    L106:
        Pair r4 = null;
    L108:
        if (r4 == null) goto L110;
        r8 = d(r4, r8);
    L110:
        int r21 = r25;
    L112:
        if (r21 <= 0) goto L120;
        if (CollectionsKt.listOf(new Character[]{'(', (char) 65288, ')', (char) 65289}).contains(Character.valueOf(r24.charAt(r21))) == true) goto L120;
        if (r24.charAt(r21) == '\n') goto L140;
        r21 = r21 - 1;
    L140:
        Pair r22 = null;
    L142:
        if (r22 == null) goto L144;
        r8 = d(r22, r8);
    L144:
        Pair r23 = f(r24, r25);
        if (((Boolean) r23.getFirst()).booleanValue() == false) goto L173;
        boolean r26 = ((Boolean) r23.getSecond()).booleanValue();
        int r27 = r25;
    L148:
        if (r27 <= 0) goto L159;
        int r28 = r27 - 1;
        Pair r29 = f(r24, r28);
        if (r26 == false) goto L152;
    L155:
        r26 = true;
    L157:
        if (((Boolean) r29.getFirst()).booleanValue() == false) goto L159;
        r27 = r28;
        goto L148
    L152:
        if (((Boolean) r29.getSecond()).booleanValue() == true) goto L155;
        r26 = false;
    L159:
        int r30 = r25;
    L161:
        if (r30 >= (r24.length() - 1)) goto L172;
        int r31 = r30 + 1;
        Pair r111 = f(r24, r31);
        if (r26 == false) goto L165;
    L168:
        r26 = true;
    L170:
        if (((Boolean) r111.getFirst()).booleanValue() == false) goto L172;
        r30 = r31;
        goto L161
    L165:
        if (((Boolean) r111.getSecond()).booleanValue() == true) goto L168;
        r26 = false;
    L172:
        if (r26 == false) goto L173;
        Pair r32 = TuplesKt.to(Integer.valueOf(r27), Integer.valueOf(r30 + 1));
    L175:
        if (r32 == null) goto L177;
        r8 = d(r32, r8);
    L177:
        Pair<Integer, Integer> r33 = c.d(r24, r8);
        if (r33 != null) goto L208;
        d r34 = c.b(((MarkDownSelectorSettings) this.b.getValue()).getDoubleClickStrategy(), this.a);
        if ((r34 instanceof h) == false) goto L182;
        r34 = new f(this.a);
    L182:
        Pair<Integer, Integer> r2 = r34.a(r24, r25);
        this.c = r34.b();
        return r2;
    L208:
        return r33;
    L173:
        r32 = null;
    L120:
        if (CollectionsKt.listOf(new Character[]{'(', (char) 65288}).contains(Character.valueOf(r24.charAt(r21))) == false) goto L140;
        int r112 = r25;
    L124:
        if (r112 >= (r24.length() - 1)) goto L131;
        if (CollectionsKt.listOf(new Character[]{'(', (char) 65288, ')', (char) 65289}).contains(Character.valueOf(r24.charAt(r112))) == true) goto L131;
        if (r24.charAt(r112) == '\n') goto L140;
        r112 = r112 + 1;
    L131:
        char r35 = r24.charAt(r112);
        if (r35 == ')') goto L139;
        if (r35 != 65289) goto L140;
        if (r24.charAt(r21) != 65288) goto L140;
    L141:
        r22 = TuplesKt.to(Integer.valueOf(r21 + 1), Integer.valueOf(r112));
        goto L142
    L139:
        if (r24.charAt(r21) == '(') goto L141;
    L63:
        char r36 = r24.charAt(r20);
        if (r36 == '\"') goto L75;
        if (r36 == '\'') goto L72;
        if (r36 == 8216) goto L77;
        if (r36 != 8220) goto L106;
    L77:
        int r37 = r25;
    L79:
        if (r37 >= (r24.length() - 1)) goto L86;
        Character[] r113 = new Character[r110];
        r113[0] = '\'';
        r113[1] = '\"';
        r113[2] = (char) 8220;
        r113[3] = (char) 8221;
        r113[4] = (char) 8216;
        r113[5] = (char) 8217;
        if (CollectionsKt.listOf(r113).contains(Character.valueOf(r24.charAt(r37))) == true) goto L86;
        if (r24.charAt(r37) == '\n') goto L106;
        r37 = r37 + 1;
        r110 = 6;
    L86:
        char r114 = r24.charAt(r37);
        if (r114 == '\"') goto L105;
        if (r114 == '\'') goto L102;
        if (r114 == 8217) goto L99;
        if (r114 != 8221) goto L106;
        if (r24.charAt(r20) != 8220) goto L106;
    L107:
        r4 = TuplesKt.to(Integer.valueOf(r20 + 1), Integer.valueOf(r37));
        goto L108
    L99:
        if (r24.charAt(r20) == 8216) goto L107;
    L102:
        if ((((ArrayList) r19).indexOf(Integer.valueOf(r37)) % 2) == 1) goto L107;
    L105:
        if ((((ArrayList) r18).indexOf(Integer.valueOf(r37)) % 2) == 1) goto L107;
    L72:
        if ((((ArrayList) r19).indexOf(Integer.valueOf(r20)) % 2) == 0) goto L77;
    L75:
        if ((((ArrayList) r18).indexOf(Integer.valueOf(r20)) % 2) == 0) goto L77;
    L37:
        if (r24.charAt(r16) != 12298) goto L50;
        int r115 = r25;
    L41:
        if (r115 >= (r24.length() - 1)) goto L49;
        if (CollectionsKt.listOf(new Character[]{(char) 12298, (char) 12299}).contains(Character.valueOf(r24.charAt(r115))) == true) goto L49;
        if (r24.charAt(r115) == '\n') goto L50;
        r115 = r115 + 1;
    L49:
        if (r24.charAt(r115) != 12299) goto L50;
        r17 = TuplesKt.to(Integer.valueOf(r16 + 1), Integer.valueOf(r115));
    L19:
        r15 = false;
    L23:
        r8 = null;
        goto L24
    }
}
