package hda;

import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b1 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r15) {
        Intrinsics.checkNotNullParameter(r15, "text");
        String r16 = StringsKt.replace$default(StringsKt.replace$default(r15, "\r\n", "\n", false, 4, null), "\r", "\n", false, 4, null);
        String r17 = new Regex("```(?:\\w+)?\\n?([\\s\\S]*?)```").replace(r16, new y0());
        String r18 = new Regex("(?m)^\\s*[-*_]{3,}\\s*$").replace(r17, NameKeys.UnloadStrategy_No_Strategy);
        String r19 = new Regex("!\\[([^]]*)]\\([^)]*\\)").replace(r18, "$1");
        String r110 = new Regex("\\[([^]]+)]\\([^)]*\\)").replace(r19, "$1");
        String r111 = new Regex("(?m)^\\s*>+\\s?").replace(r110, NameKeys.UnloadStrategy_No_Strategy);
        String r112 = new Regex("(?m)^\\s{0,3}#{1,6}\\s*").replace(r111, NameKeys.UnloadStrategy_No_Strategy);
        String r113 = new Regex("(?m)^\\s*[-*+]\\s*\\[[ xX]]\\s*").replace(r112, NameKeys.UnloadStrategy_No_Strategy);
        String r114 = new Regex("(?m)^\\s*[-*+][ \\t]+").replace(r113, NameKeys.UnloadStrategy_No_Strategy);
        String r115 = new Regex("(?m)^\\s*\\d+(?:[.)][ \\t]+|、[ \\t]*)").replace(r114, NameKeys.UnloadStrategy_No_Strategy);
        String r116 = new Regex("(?m)^\\s*\\|?\\s*:?-{3,}:?\\s*(\\|\\s*:?-{3,}:?\\s*)+\\|?\\s*$").replace(r115, NameKeys.UnloadStrategy_No_Strategy);
        String r117 = new Regex("(?<!\\d)(?:\\+?86)?1\\d{2}\\*{4}\\d{4}(?!\\d)|[*_`~>#]+").replace(r116, new z0());
        String r118 = new Regex("<[^>]+>").replace(r117, NameKeys.UnloadStrategy_No_Strategy);
        return StringsKt.trim(CollectionsKt.joinToString$default(StringsKt.lines(new Regex("[ \\t]+").replace(r118, " ")), "\n", null, null, 0, null, new a1(), 30, null)).toString();
    }

    public static List b(String r5) {
        if (r5.length() <= 80) goto L5;
        List r0 = new Regex("(?<=[。！？!?；;])").split(r5, 0);
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        r2.add(StringsKt.trim((String) r1.next()).toString());
        goto L8
    L10:
        ArrayList r3 = new ArrayList();
        Iterator r4 = r2.iterator();
    L12:
        if (r4.hasNext() == false) goto L16;
        Object r6 = r4.next();
        if ((!StringsKt.isBlank((String) r6)) == false) goto L12;
        r3.add(r6);
        goto L12
    L16:
        ArrayList r7 = new ArrayList();
        Iterator r8 = r3.iterator();
    L18:
        if (r8.hasNext() == false) goto L24;
        String r9 = (String) r8.next();
        if (r9.length() > 80) goto L22;
        List r10 = CollectionsKt.listOf(r9);
    L23:
        CollectionsKt.addAll(r7, r10);
        goto L18
    L22:
        r10 = StringsKt.chunked(r9, 80);
        goto L23
    L24:
        boolean r11 = r7.isEmpty();
        List r12 = r7;
        if (r11 == false) goto L32;
        if (r5.length() > 80) goto L29;
        List r13 = CollectionsKt.listOf(r5);
    L30:
        r12 = r13;
        goto L32
    L29:
        r13 = StringsKt.chunked(r5, 80);
    L32:
        return r12;
    L5:
        return CollectionsKt.listOf(r5);
    }

    public static List c(String r4) {
        if (StringsKt.isBlank(r4) == true) goto L5;
        List r5 = StringsKt.lines(r4);
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        r0.add(StringsKt.trim((String) r6.next()).toString());
        goto L8
    L10:
        ArrayList r7 = new ArrayList();
        Iterator r1 = r0.iterator();
    L12:
        if (r1.hasNext() == false) goto L17;
        Object r2 = r1.next();
        if ((true ^ StringsKt.isBlank((String) r2)) == false) goto L12;
        r7.add(r2);
        goto L12
    L17:
        if (r7.size() <= 1) goto L24;
        ArrayList r3 = new ArrayList();
        Iterator r8 = r7.iterator();
    L20:
        if (r8.hasNext() == false) goto L22;
        CollectionsKt.addAll(r3, b((String) r8.next()));
        goto L20
    L22:
        return r3;
    L24:
        return b((String) CollectionsKt.single(r7));
    L5:
        return CollectionsKt.emptyList();
    }
}
