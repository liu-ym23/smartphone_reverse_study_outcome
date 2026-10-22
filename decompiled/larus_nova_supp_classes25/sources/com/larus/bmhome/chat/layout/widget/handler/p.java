package com.larus.bmhome.chat.layout.widget.handler;

import android.graphics.Color;
import android.text.SpannableString;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.layout.widget.ForegroundAlphaSpan;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p {
    public static final CoroutineScope a = null;
    public static final Map<String, a> b = null;
    public static final Map<String, Set<TextView>> c = null;
    public static boolean d;
    public static final long e = 0;

    public static final class a {
        public CharSequence a;
        public String b;
        public final Map<Integer, Integer> c;

        public a() {
            throw null;
        }

        public a(CharSequence r3, String r4) {
            LinkedHashMap r0 = new LinkedHashMap();
            Intrinsics.checkNotNullParameter(r3, "content");
            Intrinsics.checkNotNullParameter(r4, "extra");
            Intrinsics.checkNotNullParameter(r0, "alphaMap");
            this.a = r3;
            this.b = r4;
            this.c = r0;
        }
    }

    static {
        a = CoroutineScopeKt.MainScope();
        b = new LinkedHashMap();
        c = new LinkedHashMap();
        e = 300;
    }

    public static void a(String r11) {
        a r0 = (a) ((LinkedHashMap) b).get(r11);
        if (r0 != null) goto L5;
        return;
    L5:
        Set r12 = (Set) ((LinkedHashMap) c).get(r11);
        if (r12 != null) goto L8;
        return;
    L8:
        Map<Integer, Integer> r1 = r0.c;
        SpannableString r2 = new SpannableString(r0.a);
        List r3 = CollectionsKt.sorted(CollectionsKt.toList(r1.keySet()));
        Iterator r4 = r3.iterator();
        int r5 = 0;
    L10:
        if (r4.hasNext() == false) goto L25;
        Object r6 = r4.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        int r8 = ((Number) r6).intValue();
        if (r2.length() <= r8) goto L24;
        if (r7 >= r3.size()) goto L20;
        int r9 = RangesKt.coerceAtMost(((Number) ListProtector.get(r3, r7)).intValue(), r2.length());
    L21:
        Integer r10 = r1.get(Integer.valueOf(r8));
        if (r10 == null) goto L24;
        int r13 = r10.intValue();
        r2.setSpan(new ForegroundAlphaSpan(Color.argb(r13, 0, 0, 0), r13), r8, r9, 17);
        goto L24
    L20:
        r9 = r2.length();
    L24:
        r5 = r7;
        goto L10
    L25:
        Iterator r14 = r12.iterator();
    L27:
        if (r14.hasNext() == false) goto L32;
        TextView r15 = (TextView) r14.next();
        if (r15.isAttachedToWindow() == true) goto L30;
        r14.remove();
        goto L27
    L30:
        r15.setText(r2);
        goto L27
    }

    public static String b(String r1, String r2) {
        return r1 + '#' + r2;
    }

    public static void d(String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "messageId");
        Intrinsics.checkNotNullParameter(r7, "viewTag");
        Set r0 = ((LinkedHashMap) c).keySet();
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if (Intrinsics.areEqual((String) r3, b(r6, r7)) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        Set r4 = ((LinkedHashMap) b).keySet();
        ArrayList r5 = new ArrayList();
        Iterator r8 = r4.iterator();
    L10:
        if (r8.hasNext() == false) goto L14;
        Object r9 = r8.next();
        if (Intrinsics.areEqual((String) r9, b(r6, r7)) == false) goto L10;
        r5.add(r9);
        goto L10
    L14:
        Iterator r10 = r1.iterator();
    L16:
        if (r10.hasNext() == false) goto L18;
        String r11 = (String) r10.next();
        c.remove(r11);
        goto L16
    L18:
        Iterator r12 = r5.iterator();
    L20:
        if (r12.hasNext() == false) goto L22;
        String r13 = (String) r12.next();
        b.remove(r13);
        goto L20
    }

    public static void c(Integer r7, String r8, String r9, CharSequence r10, String r11, CustomMarkdownTextView r12) {
        Intrinsics.checkNotNullParameter(r8, "messageId");
        Intrinsics.checkNotNullParameter(r9, "viewTag");
        Intrinsics.checkNotNullParameter(r10, "content");
        Intrinsics.checkNotNullParameter(r11, "extra");
        Intrinsics.checkNotNullParameter(r12, "textView");
        if (r7 != null) goto L6;
    L7:
        if (r7 != null) goto L10;
        return;
    L10:
        if (r7.intValue() == 3) goto L13;
        return;
    L13:
        if (r10.length() > r11.length()) goto L15;
        return;
    L15:
        String r13 = b(r8, r9);
        Map<String, a> r14 = b;
        LinkedHashMap r15 = (LinkedHashMap) r14;
        if (r15.get(r13) != null) goto L19;
        r14.put(r13, new a(r10, r11));
        return;
    L19:
        a r16 = (a) r15.get(r13);
        if (r16 != null) goto L22;
        return;
    L22:
        CharSequence r17 = r16.a;
        CharSequence r18 = r17.subSequence(0, r17.length() - r16.b.length());
        if (r10.length() <= r18.length()) goto L25;
        r16.c.put(Integer.valueOf(r18.length()), 0);
    L25:
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r16.a = r10;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");
        r16.b = r11;
        if (r16.c.isEmpty() == false) goto L28;
        return;
    L28:
        Map<String, Set<TextView>> r19 = c;
        LinkedHashMap r20 = (LinkedHashMap) r19;
        if (r20.get(r13) != null) goto L31;
        r19.put(r13, new LinkedHashSet());
    L31:
        Set r21 = (Set) r20.get(r13);
        if (r21 == null) goto L34;
        r21.add(r12);
    L34:
        a(r13);
        if (d == true) goto L40;
        d = true;
        BuildersKt.launch$default(a, null, null, new StreamAlphaSpanHandler$loop$1(null), 3, null);
        return;
    L40:
        return;
    L6:
        if (r7.intValue() == 1) goto L13;
        goto L7
    }
}
