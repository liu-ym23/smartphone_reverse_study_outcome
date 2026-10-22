package com.ss.android.lark.richtextmd.generate;

import android.content.Context;
import com.larksuite.framework.utils.p;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.richtextmd.RichTextBISUUtils;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import v7b.a0;
import v7b.e0;
import v7b.f;
import v7b.r;
import v7b.s;
import v7b.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public final Context a;
    public final Map<Class<? extends s>, InterfaceC0127c<s>> b;

    public static final class a {
    }

    public static final class b {
        public final Map<Class<? extends s>, InterfaceC0127c<s>> a;
        public final Context b;
        public final Map<String, RichTextElement> c;
        public final AtomicInteger d;
        public final LinkedList<String> e;

        public b() {
            throw null;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
        }

        public final String toString() {
            return "NodeHandleContext(nodeHandlers=" + this.a + ", context=" + this.b + ", eleMap=" + this.c + ", idGen=" + this.d + ", idStack=" + this.e + ')';
        }

        public final Context getContext() {
            return this.b;
        }

        public b(Map r5, Context r6) {
            LinkedHashMap r0 = new LinkedHashMap();
            AtomicInteger r1 = new AtomicInteger();
            LinkedList<String> r2 = new LinkedList();
            Intrinsics.checkNotNullParameter(r5, "nodeHandlers");
            Intrinsics.checkNotNullParameter(r6, "context");
            Intrinsics.checkNotNullParameter(r0, "eleMap");
            Intrinsics.checkNotNullParameter(r1, "idGen");
            Intrinsics.checkNotNullParameter(r2, "idStack");
            this.a = r5;
            this.b = r6;
            this.c = r0;
            this.d = r1;
            this.e = r2;
        }

        public final void a(RichTextElement r3, RichTextElement r4) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            Intrinsics.checkNotNullParameter(r4, "child");
            String r0 = String.valueOf(this.d.getAndIncrement());
            this.c.put(r0, r4);
            List r5 = r3.getChildIds();
            if (r5 != null) goto L5;
            r5 = new ArrayList();
        L5:
            r5.add(r0);
            r3.setChildIds(r5);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.richtextmd.generate.c$c, reason: collision with other inner class name */
    public interface InterfaceC0127c<N extends s> {
        RichTextElement a(b r1, N r2);
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RichTextElement.RichTextTag.values().length];
            r0[RichTextElement.RichTextTag.ANCHOR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[RichTextElement.RichTextTag.IMG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[RichTextElement.RichTextTag.MEDIA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[RichTextElement.RichTextTag.AT_USER_GROUP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[RichTextElement.RichTextTag.AT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[RichTextElement.RichTextTag.DOCS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[RichTextElement.RichTextTag.MARKDOWN.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            a = r0;
        }
    }

    static {
    }

    public c(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = new LinkedHashMap();
    }

    public final RichText b(s r15) {
        Intrinsics.checkNotNullParameter(r15, "node");
        StringBuilder r0 = new StringBuilder("generate richText , node tree is ");
        boolean r1 = false;
        r0.append(r.a(r15, false));
        Log.d("MarkdownRichTextGenerator", r0.toString());
        b r2 = new b(this.b, this.a);
        a(r15, r2);
        RichText r16 = new RichText();
        Map<String, RichTextElement> r3 = r2.c;
        ArrayList r4 = new ArrayList();
        ArrayList r5 = new ArrayList();
        ArrayList r6 = new ArrayList();
        ArrayList r7 = new ArrayList();
        ArrayList r8 = new ArrayList();
        ArrayList r9 = new ArrayList();
        ArrayList r10 = new ArrayList();
        Iterator<Map.Entry<String, RichTextElement>> r11 = r3.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L18;
        Map.Entry<String, RichTextElement> r12 = r11.next();
        RichTextElement.RichTextTag r13 = r12.getValue().getTag();
        if (r13 != null) goto L8;
        int r14 = -1;
    L9:
        switch(r14) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            default: goto L4;
        };
    L11:
        r10.add(r12.getKey());
        goto L4
    L12:
        r9.add(r12.getKey());
        goto L4
    L13:
        r8.add(r12.getKey());
        goto L4
    L14:
        r7.add(r12.getKey());
        goto L4
    L15:
        r6.add(r12.getKey());
        goto L4
    L16:
        r5.add(r12.getKey());
        goto L4
    L17:
        r4.add(r12.getKey());
        goto L4
    L8:
        r14 = d.a[r13.ordinal()];
        goto L9
    L18:
        r16.setAnchorIds(r4);
        r16.setImageIds(r5);
        r16.setMediaIds(r6);
        r16.setAtIds(r8);
        r16.setDocsIds(r9);
        r16.setMarkdownIds(r10);
        r16.setAtUserGroupIds(r7);
        r16.setElementIds(p.a(r2.e));
        RichText.RichTextElements r17 = new RichText.RichTextElements();
        r17.setDictionary(r2.c);
        r16.setElements(r17);
        Lazy r18 = RichTextBISUUtils.a;
        Intrinsics.checkNotNullParameter(r16, "<this>");
        RichText.RichTextElements r19 = r16.getElements();
        if (r19 == null) goto L38;
        Map r20 = r19.getDictionary();
        if (r20 == null) goto L38;
        List r21 = r16.getElementIds();
        Intrinsics.checkNotNull(r21);
        Iterator r22 = r21.iterator();
    L25:
        if (r22.hasNext() == false) goto L38;
        RichTextElement r23 = (RichTextElement) r20.get((String) r22.next());
        if (r23 == null) goto L25;
        List r24 = r23.getChildIds();
        if (r24 == null) goto L25;
        Iterator r25 = r24.iterator();
    L33:
        if (r25.hasNext() == false) goto L25;
        RichTextElement r26 = (RichTextElement) r20.get((String) r25.next());
        if (r26 == null) goto L33;
        Lazy r27 = RichTextBISUUtils.a;
        RichTextBISUUtils.e(r23.getStyle(), r26);
    L38:
        StringBuilder r28 = new StringBuilder("generate richText, richText is ");
        int r29 = com.ss.android.lark.widget.richtext.utils.d.a;
        Intrinsics.checkNotNullParameter(r16, "richText");
        List r30 = r16.getElementIds();
        List r31 = r30;
        if (r31 != null) goto L41;
    L42:
        r1 = true;
    L43:
        if (r1 == false) goto L45;
        List r32 = CollectionsKt.emptyList();
    L57:
        r28.append(r32);
        Log.d("MarkdownRichTextGenerator", r28.toString());
        return r16;
    L45:
        RichText.RichTextElements r33 = r16.getElements();
        if (r33 == null) goto L49;
        Map r34 = r33.getDictionary();
        if (r34 == null) goto L49;
    L50:
        ArrayList r35 = new ArrayList();
        Iterator r36 = r30.iterator();
    L52:
        if (r36.hasNext() == false) goto L56;
        String r37 = (String) r36.next();
        RichTextElement r38 = (RichTextElement) r34.get(r37);
        if (r38 == null) goto L52;
        int r39 = com.ss.android.lark.widget.richtext.utils.d.a;
        Intrinsics.checkNotNull(r37);
        com.ss.android.lark.widget.richtext.utils.d.b(r37, r38, r34, r35, "Root");
        goto L52
    L56:
        r32 = r35;
    L49:
        r34 = MapsKt.emptyMap();
        goto L50
    L41:
        if (r31.isEmpty() == false) goto L43;
        goto L42
    }

    public final void a(s r12, b r13) {
        LinkedList<String> r0 = r13.e;
        Map<String, RichTextElement> r1 = r13.c;
        AtomicInteger r2 = r13.d;
        InterfaceC0127c r3 = (InterfaceC0127c) ((LinkedHashMap) this.b).get(r12.getClass());
        if (r3 == null) goto L5;
        RichTextElement r4 = r3.a(r13, r12);
    L6:
        int r5 = r0.size();
        if (r4 == null) goto L9;
        String r6 = String.valueOf(r2.getAndIncrement());
        r1.put(r6, r4);
        r0.push(r6);
        Map r7 = null;
    L23:
        s r14 = r12.e;
    L24:
        if (r14 == null) goto L26;
        a(r14, r13);
        r14 = r14.h;
        goto L24
    L26:
        boolean r15 = false;
        if (r6.length() <= 0) goto L29;
        boolean r16 = true;
    L30:
        if (r16 == false) goto L52;
        if (r4 == null) goto L52;
        ArrayList r17 = new ArrayList();
        LinkedList r8 = new LinkedList();
        if (r4.getTag() != RichTextElement.RichTextTag.PARAGRAPH) goto L36;
        r15 = true;
    L36:
        if ((!r0.isEmpty()) == false) goto L48;
        if (Intrinsics.areEqual(r0.getFirst(), r6) == true) goto L48;
        RichTextElement r9 = r1.get(r0.getFirst());
        if (r15 == false) goto L47;
        if (r9 == null) goto L43;
        RichTextElement.RichTextTag r10 = r9.getTag();
    L45:
        if (r10 != RichTextElement.RichTextTag.PARAGRAPH) goto L47;
        List r11 = r9.getChildIds();
        Intrinsics.checkNotNull(r11);
        r9.setChildIds(CollectionsKt.plus(r11, p.a(r8)));
        r8.clear();
        r17.add(r0.pop());
        goto L36
    L43:
        r10 = null;
    L47:
        r8.add(r0.pop());
    L48:
        List r18 = r4.getChildIds();
        Intrinsics.checkNotNull(r18);
        r4.setChildIds(CollectionsKt.plus(r18, p.a(r8)));
        Iterator r19 = p.a(r17).iterator();
    L50:
        if (r19.hasNext() == false) goto L76;
        r0.push((String) r19.next());
        goto L50
    L76:
        return;
    L52:
        if (r7 == null) goto L61;
        int r110 = r0.size() - r5;
        Iterator<String> r111 = r0.iterator();
    L54:
        int r20 = r110 - 1;
        if (r110 <= 0) goto L77;
        RichTextElement r112 = r1.get(r111.next());
        if (r112 == null) goto L60;
        RichTextBISUUtils.e(r7, r112);
    L60:
        r110 = r20;
        goto L54
    L77:
        return;
    L61:
        return;
    L29:
        r16 = false;
        goto L30
    L9:
        Lazy r21 = RichTextBISUUtils.a;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        if ((r12 instanceof a0) == false) goto L13;
        Map r22 = MapsKt.mapOf(TuplesKt.to("fontWeight", (String) RichTextBISUUtils.a.getValue()));
    L22:
        r7 = r22;
        r6 = "";
        goto L23
    L13:
        if ((r12 instanceof f) == false) goto L16;
        r22 = MapsKt.mapOf(TuplesKt.to("fontStyle", (String) RichTextBISUUtils.b.getValue()));
        goto L22
    L16:
        if ((r12 instanceof e0) == false) goto L19;
        r22 = MapsKt.mapOf(TuplesKt.to("-lark-textDecoration", (String) RichTextBISUUtils.d.getValue()));
        goto L22
    L19:
        if ((r12 instanceof z) == false) goto L21;
        r22 = MapsKt.mapOf(TuplesKt.to("-lark-textDecoration", (String) RichTextBISUUtils.c.getValue()));
        goto L22
    L21:
        r22 = null;
        goto L22
    L5:
        r4 = null;
        goto L6
    }

    public final <N extends s> void c(Class<N> r2, InterfaceC0127c<N> r3) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        Intrinsics.checkNotNullParameter(r3, "handler");
        this.b.put(r2, r3);
    }
}
