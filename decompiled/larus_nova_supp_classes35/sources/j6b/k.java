package j6b;

import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k {
    public static final k b = null;
    public static final Set<Character> c = null;
    public final /* synthetic */ k6b.b a;

    static {
        b = new k();
        c = SetsKt.setOf(new Character[]{'#', ':', '_', '.'});
    }

    public k() {
        this.a = k6b.b.a;
    }

    @JvmStatic
    public static final Map<String, PreviewHangPoint> b(v5b.a<?> r9) {
        if ((r9 instanceof BaseTextContentVO) == false) goto L5;
        BaseTextContentVO r10 = (BaseTextContentVO) r9;
        Map<String, PreviewHangPoint> r0 = r10.C;
        if (r0 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == true) goto L15;
        RichText r11 = r10.g();
        if (r11 == null) goto L19;
        RichText.RichTextElements r4 = r11.getElements();
        if (r4 == null) goto L46;
        Map r5 = r4.getDictionary();
        if (r5 == null) goto L46;
        Set r12 = CollectionsKt.toSet(a(r11, r0));
        LinkedHashMap r6 = new LinkedHashMap();
        Iterator<Map.Entry<String, PreviewHangPoint>> r1 = r0.entrySet().iterator();
    L27:
        if (r1.hasNext() == false) goto L44;
        Map.Entry<String, PreviewHangPoint> r7 = r1.next();
        String r8 = r7.getKey();
        PreviewHangPoint r13 = r7.getValue();
        if (r12.contains(r8) == true) goto L31;
    L41:
        boolean r14 = false;
    L42:
        if (r14 == false) goto L27;
        r6.put(r7.getKey(), r7.getValue());
        goto L27
    L31:
        if (r13.isValidCardData() == false) goto L41;
        RichTextElement r15 = (RichTextElement) r5.get(r8);
        if (r15 != null) goto L37;
    L35:
        r14 = true;
        goto L42
    L37:
        if (r15.getTag() != RichTextElement.RichTextTag.ANCHOR) goto L41;
        if ((r15.getProperty() instanceof RichTextElement.AnchorProperty) == false) goto L41;
    L44:
        return r6;
    L46:
        return MapsKt.emptyMap();
    L19:
        return MapsKt.emptyMap();
    L15:
        return MapsKt.emptyMap();
    L9:
        if (r0.isEmpty() == true) goto L12;
        r3 = false;
        goto L13
    L5:
        return MapsKt.emptyMap();
    }

    @JvmStatic
    public static final List<String> a(RichText r9, Map<String, PreviewHangPoint> r10) {
        Intrinsics.checkNotNullParameter(r9, "richText");
        ArrayList r0 = new ArrayList();
        List r1 = r9.getElementIds();
        Map r7 = r9.getElements().getDictionary();
        Iterator r8 = r1.iterator();
    L4:
        if (r8.hasNext() == false) goto L9;
        String r2 = (String) r8.next();
        RichTextElement r3 = (RichTextElement) r7.get(r2);
        if (r3 == null) goto L4;
        k r4 = b;
        Intrinsics.checkNotNull(r2);
        Intrinsics.checkNotNull(r7);
        r4.getClass();
        c(r2, r3, r9, r10, r7, r0);
        goto L4
    L9:
        return r0;
    }

    public static void d(RichTextElement r1, Map r2, ArrayList r3, ArrayList r4) {
        List r0 = r1.getChildIds();
        if (r0 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == false) goto L12;
        r3.add(r1);
        return;
    L12:
        if ((r1.getProperty() instanceof RichTextElement.ParagraphProperty) == true) goto L14;
        r4.add(r1);
    L14:
        Iterator r6 = r1.getChildIds().iterator();
    L16:
        if (r6.hasNext() == false) goto L27;
        RichTextElement r7 = (RichTextElement) r2.get((String) r6.next());
        if (r7 == null) goto L16;
        d(r7, r2, r3, r4);
        goto L16
    L27:
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r5 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r20v0, types: [java.util.Map] */
    public static void c(String r16, RichTextElement r17, RichText r18, Map r19, Map r20, List r21) {
        RichTextElement.RichTextTag r1 = r17.getTag();
        RichTextElement.MarkdownProperty r2 = r17.getProperty();
        boolean r4 = true;
        if (r1 != RichTextElement.RichTextTag.ANCHOR) goto L8;
        if ((r2 instanceof RichTextElement.AnchorProperty) == false) goto L8;
        ((ArrayList) r21).add(r16);
    L93:
        List r0 = r17.getChildIds();
        List r3 = r0;
        if (r3 != null) goto L96;
    L99:
        if (r4 == true) goto L107;
        Iterator r6 = r0.iterator();
    L102:
        if (r6.hasNext() == false) goto L123;
        String r5 = (String) r6.next();
        RichTextElement r7 = (RichTextElement) r20.get(r5);
        if (r7 == null) goto L102;
        Intrinsics.checkNotNull(r5);
        c(r5, r7, r18, r19, r20, r21);
        goto L102
    L123:
        return;
    L107:
        return;
    L96:
        if (r3.isEmpty() == true) goto L99;
        r4 = false;
    L8:
        if (r1 != RichTextElement.RichTextTag.MARKDOWN) goto L93;
        if ((r2 instanceof RichTextElement.MarkdownProperty) == false) goto L93;
        String r8 = r2.getContent();
        if (r8 != null) goto L15;
        r8 = BuildConfig.FLAVOR;
    L15:
        if (r8.length() != 0) goto L17;
        boolean r9 = true;
    L18:
        if (r9 == true) goto L91;
        if (r19 != null) goto L21;
    L24:
        boolean r10 = true;
    L25:
        if (r10 == true) goto L91;
        Map r11 = r18.getElements().getDictionary();
        ArrayList r12 = new ArrayList();
        Iterator r13 = r19.entrySet().iterator();
    L29:
        if (r13.hasNext() == false) goto L87;
        Map.Entry r14 = (Map.Entry) r13.next();
        String r15 = (String) r14.getKey();
        PreviewHangPoint r22 = (PreviewHangPoint) r14.getValue();
        if (Intrinsics.areEqual(r15, r16) == false) goto L33;
        Pair r23 = TuplesKt.to(r15, 0);
    L84:
        Pair r110 = r23;
    L85:
        if (r110 == null) goto L29;
        r12.add(r110);
        goto L29
    L33:
        b.getClass();
        r110 = null;
        if (r15.length() > r16.length()) goto L36;
    L40:
        boolean r24 = false;
    L41:
        if (r24 == false) goto L61;
        String r25 = StringsKt.drop(r15, r16.length());
        int r26 = r25.length();
        int r27 = 0;
    L43:
        if (r27 >= r26) goto L48;
        if ((!Character.isDigit(r25.charAt(r27))) == false) goto L46;
        r27 = r27 + 1;
        goto L43
    L46:
        String r28 = r25.substring(r27);
    L49:
        int r29 = r28.length();
        int r30 = 0;
    L50:
        if (r30 >= r29) goto L55;
        if (Character.isDigit(r28.charAt(r30)) == false) goto L53;
        r30 = r30 + 1;
        goto L50
    L53:
        r28 = r28.substring(0, r30);
    L55:
        Integer r31 = StringsKt.toIntOrNull(r28);
        if (r31 == null) goto L58;
        int r32 = r31.intValue();
    L59:
        r23 = TuplesKt.to(r15, Integer.valueOf(r32));
        goto L84
    L58:
        r32 = 0;
        goto L59
    L48:
        r28 = BuildConfig.FLAVOR;
        goto L49
    L61:
        if (r11.containsKey(r15) == true) goto L83;
        String r33 = r22.getUrl();
        if (r33 != null) goto L65;
    L68:
        boolean r34 = true;
    L69:
        if (r34 == true) goto L83;
        String r35 = r22.getUrl();
        if (r35 != null) goto L73;
        String r36 = BuildConfig.FLAVOR;
    L74:
        Integer r37 = Integer.valueOf(StringsKt.indexOf$default(r8, r36, 0, false, 6, null));
        if (r37.intValue() < 0) goto L77;
        boolean r38 = true;
    L78:
        if (r38 == true) goto L81;
        r37 = null;
    L81:
        if (r37 == null) goto L85;
        r23 = TuplesKt.to(r15, Integer.valueOf(r37.intValue()));
        goto L84
    L77:
        r38 = false;
        goto L78
    L73:
        r36 = r35;
        goto L74
    L65:
        if (r33.length() == 0) goto L68;
        r34 = false;
    L83:
        r23 = null;
        goto L84
    L36:
        if (StringsKt.startsWith$default(r15, r16, false, 2, null) == false) goto L40;
        if (c.contains(Character.valueOf(r15.charAt(r16.length()))) == false) goto L40;
        r24 = true;
        goto L41
    L87:
        List r39 = CollectionsKt.sortedWith(r12, new j(new i()));
        ?? r40 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r39, 10));
        Iterator r41 = r39.iterator();
    L89:
        if (r41.hasNext() == false) goto L92;
        r40.add((String) ((Pair) r41.next()).getFirst());
    L92:
        ((ArrayList) r21).addAll((Collection) r40);
        goto L93
    L21:
        if (r19.isEmpty() == true) goto L24;
        r10 = false;
    L91:
        r40 = CollectionsKt.emptyList();
        goto L92
    L17:
        r9 = false;
        goto L18
    }
}
