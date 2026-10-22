package com.ss.android.lark.keyboard.edittext2.edittors.richText;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import com.ss.android.lark.coremd.span.CommonPrefixSpan;
import com.ss.android.lark.keyboard.edittext2.edittors.inlinecode.EditorInlineCodeCenterSpan;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.light.span.p;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import com.ss.android.lark.widget.richtext.genv2.RichTextGenerateUtils2;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class b extends d {
    public static final Map<Class<? extends Object>, Integer> i = null;
    public final C0142b h;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.edittext2.edittors.richText.b$b, reason: collision with other inner class name */
    public static final class C0142b extends d.b implements RichTextGenerateUtils2.a {
        public C0142b(b r2) {
            Intrinsics.checkNotNullParameter(r2, "generator");
            super(r2);
        }

        public final List<jec.c> b(Object r2) {
            Intrinsics.checkNotNullParameter(r2, "span");
            return CollectionsKt.emptyList();
        }

        public final boolean d(Object r3) {
            Intrinsics.checkNotNullParameter(r3, "span");
            if ((r3 instanceof EditorInlineCodeCenterSpan) == false) goto L6;
            return true;
        L6:
            if ((r3 instanceof y9b.a) == false) goto L8;
            return true;
        L8:
            return false;
        }

        public final RichTextGenerateUtils2.OverlappingResult f(RichTextGenerateUtils2.b r3, RichTextGenerateUtils2.b r4) {
            Intrinsics.checkNotNullParameter(r3, "first");
            Intrinsics.checkNotNullParameter(r4, "second");
            Object r5 = r3.a;
            Object r6 = r4.a;
            Map<Class<? extends Object>, Integer> r0 = b.i;
            Integer r7 = r0.get(r5.getClass());
            int r1 = Integer.MAX_VALUE;
            if (r7 == null) goto L5;
            int r8 = r7.intValue();
        L6:
            Integer r9 = r0.get(r6.getClass());
            if (r9 == null) goto L9;
            r1 = r9.intValue();
        L9:
            if (r8 > r1) goto L12;
            return RichTextGenerateUtils2.OverlappingResult.KEEP_FIRST;
        L12:
            return RichTextGenerateUtils2.OverlappingResult.KEEP_SECOND;
        L5:
            r8 = Integer.MAX_VALUE;
            goto L6
        }
    }

    static {
        int r3 = 0;
        Class[] r1 = {y9b.a.class, y9b.b.class, y9b.c.class, EditorInlineCodeCenterSpan.class, p.class};
        ArrayList r2 = new ArrayList(5);
        int r4 = 0;
    L3:
        if (r3 >= 5) goto L5;
        r2.add(TuplesKt.to(r1[r3], Integer.valueOf(r4)));
        r3 = r3 + 1;
        r4 = r4 + 1;
        goto L3
    L5:
        i = MapsKt.toMap(r2);
    }

    public b() {
        this.h = new C0142b(this);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.richText.d
    public final void e(SpannableStringBuilder r2) {
        Intrinsics.checkNotNullParameter(r2, "ssb");
        super.e(r2);
        u(r2, "\u200b");
        u(r2, "\u2060");
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.richText.d
    public final RichTextElement g(Object r8) {
        Intrinsics.checkNotNullParameter(r8, "span");
        if ((r8 instanceof EditorInlineCodeCenterSpan) == false) goto L7;
        Map r9 = RichTextElementCreator.a;
        return RichTextElementCreator.h(new RichTextElement.CodeProperty());
    L7:
        if ((r8 instanceof y9b.c) == false) goto L22;
        RichTextElement.LIProperty r0 = new RichTextElement.LIProperty();
        y9b.c r10 = (y9b.c) r8;
        r0.setFloor(((CommonPrefixSpan) r10).a.h);
        r0.setListNum("- ");
        RichTextElement.ULProperty r5 = new RichTextElement.ULProperty();
        Intrinsics.checkNotNullParameter(r10, "<this>");
        CommonPrefixSpan.Type r11 = r10.getType();
        if (r11 != null) goto L11;
        int r12 = -1;
    L12:
        if (r12 == 1) goto L18;
        if (r12 == 2) goto L17;
        if (r12 == 3) goto L16;
        RichTextElement.ULProperty.Type r13 = RichTextElement.ULProperty.Type.NONE;
    L19:
        r5.setType(r13);
        RichTextElement r14 = RichTextElementCreator.h(r0);
        r14.getElementExtra().getFloorInfo().setFloorProperty(r5);
        return r14;
    L16:
        r13 = RichTextElement.ULProperty.Type.SQUARE;
        goto L19
    L17:
        r13 = RichTextElement.ULProperty.Type.CIRCLE;
        goto L19
    L18:
        r13 = RichTextElement.ULProperty.Type.DISC;
        goto L19
    L11:
        r12 = com.ss.android.lark.keyboard.edittext2.list.c.a[r11.ordinal()];
        goto L12
    L22:
        if ((r8 instanceof y9b.b) == false) goto L33;
        RichTextElement.LIProperty r1 = new RichTextElement.LIProperty();
        y9b.b r15 = (y9b.b) r8;
        CommonPrefixSpan.c r6 = ((CommonPrefixSpan) r15).a;
        r1.setFloor(r6.h);
        r1.setListNum(r6.f);
        RichTextElement r2 = RichTextElementCreator.h(r1);
        RichTextElement.OLProperty r7 = new RichTextElement.OLProperty();
        r7.setStart(r6.i);
        Intrinsics.checkNotNullParameter(r15, "<this>");
        int r16 = ((CommonPrefixSpan) r15).a.h % 3;
        if (r16 == 0) goto L30;
        if (r16 == 1) goto L29;
        if (r16 == 2) goto L28;
        RichTextElement.OLProperty.Type r17 = RichTextElement.OLProperty.Type.NONE;
    L31:
        r7.setType(r17);
        r2.getElementExtra().getFloorInfo().setFloorProperty(r7);
        return r2;
    L28:
        r17 = RichTextElement.OLProperty.Type.LOWERCASE_ROMAN;
        goto L31
    L29:
        r17 = RichTextElement.OLProperty.Type.LOWERCASE_A;
        goto L31
    L30:
        r17 = RichTextElement.OLProperty.Type.NUMBER;
        goto L31
    L33:
        return null;
    }

    public static void u(SpannableStringBuilder r9, String r10) {
        int r0 = StringsKt.indexOf$default(r9, r10, 0, false, 6, null);
    L4:
        if (r0 == (-1)) goto L6;
        r9.replace(r0, r10.length() + r0, "");
        r0 = StringsKt.indexOf$default(r9, r10, 0, false, 6, null);
        goto L4
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.richText.d
    public final String h(Object r5, CharSequence r6) {
        Intrinsics.checkNotNullParameter(r5, "span");
        Intrinsics.checkNotNullParameter(r6, "sequence");
        if ((r5 instanceof y9b.a) == false) goto L9;
        StringBuilder r0 = new StringBuilder();
        y9b.a r7 = (y9b.a) r5;
        int r1 = ((CommonPrefixSpan) r7).a.h;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        r0.append("\t");
        r2 = r2 + 1;
        goto L5
    L7:
        r0.append(((CommonPrefixSpan) r7).a.f);
        r0.append(r6);
        return r0.toString();
    L9:
        super.h(r5, r6);
        return "";
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.richText.d
    public final void p(Spanned r4, List<Object> r5) {
        Intrinsics.checkNotNullParameter(r4, "editable");
        Intrinsics.checkNotNullParameter(r5, "spans");
        super.p(r4, r5);
        CollectionsKt.addAll(r5, r4.getSpans(0, r4.length(), y9b.a.class));
        CollectionsKt.addAll(r5, r4.getSpans(0, r4.length(), EditorInlineCodeCenterSpan.class));
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.richText.d
    public final void q(Spanned r4, List<Object> r5) {
        Intrinsics.checkNotNullParameter(r4, "editable");
        Intrinsics.checkNotNullParameter(r5, "spans");
        super.q(r4, r5);
        CollectionsKt.addAll(r5, r4.getSpans(0, r4.length(), y9b.a.class));
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.richText.d
    public final RichText l(Spannable r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "targetSequence");
        RichText r5 = RichTextGenerateUtils2.b(r2, this.h);
        Log.i("ComprehensiveRichTextGenerator", "generateRichText: richText path is: " + com.ss.android.lark.widget.richtext.utils.d.c(r5));
        r5.setInnerText(n(r2));
        return r5;
    }
}
