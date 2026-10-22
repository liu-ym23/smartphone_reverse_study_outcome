package com.ss.android.lark.keyboard.edittext2.utils;

import android.text.Spannable;
import android.text.Spanned;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static final List<String> a = null;

    public static final class a {
        public final String a;
        public final int b;
        public final int c;
        public final boolean d;

        public a(String r2, int r3, int r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r2, "url");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    static {
        a = CollectionsKt.listOf(new String[]{"http://", "https://"});
    }

    @JvmStatic
    public static final void a(CharSequence r10, List r11) {
        Intrinsics.checkNotNullParameter(r10, "data");
        Intrinsics.checkNotNullParameter(r11, "urls");
        Intrinsics.checkNotNullParameter(r10, "data");
        Intrinsics.checkNotNullParameter(r11, "urls");
        Intrinsics.checkNotNullParameter("^https?://(www\\.)?([a-zA-Z\\d-_]|%[0-9a-fA-F]{2})+([.|/]([a-zA-Z\\d-_]|%[0-9a-fA-F]{2})+)*/?(\\?(&?([a-zA-Z\\d-_]|%[0-9a-fA-F]{2})*=([a-zA-Z\\d-_]|%[0-9a-fA-F]{2})*)*)?(?:#(([a-zA-Z\\d-_]|%[0-9a-fA-F]{2})*))?", "regexString");
        Regex r1 = new Regex("^https?://(www\\.)?([a-zA-Z\\d-_]|%[0-9a-fA-F]{2})+([.|/]([a-zA-Z\\d-_]|%[0-9a-fA-F]{2})+)*/?(\\?(&?([a-zA-Z\\d-_]|%[0-9a-fA-F]{2})*=([a-zA-Z\\d-_]|%[0-9a-fA-F]{2})*)*)?(?:#(([a-zA-Z\\d-_]|%[0-9a-fA-F]{2})*))?");
        LinkedList r0 = new LinkedList();
        int r2 = r10.length();
    L3:
        if (r2 < 0) goto L12;
        int r3 = StringsKt.lastIndexOfAny$default(r10, a, r2 - 1, false, 4, null);
        if (r3 == (-1)) goto L11;
        MatchResult r4 = Regex.find$default(r1, r10.subSequence(r3, r2), 0, 2, null);
        if (r4 == null) goto L11;
        String r5 = r4.getValue();
        if (r5 == null) goto L11;
        r0.add(0, new a(r5, r3, r5.length() + r3, false));
    L11:
        r2 = r3;
        goto L3
    L12:
        Log.i("AnchorParseUtils", "findUrls: find " + r0.size() + " urls");
        ((ArrayList) r11).addAll(r0);
        r0.isEmpty();
    }

    public static void b(CharSequence r5, List r6) {
        Intrinsics.checkNotNullParameter(r5, "data");
        Intrinsics.checkNotNullParameter(r6, "urls");
        if (d.a("messenger.chat.editor.disable_filter_bare_markdown_link") == false) goto L5;
        Regex r0 = new Regex("(((https?)://([\\-a-zA-Z0-9:%_+~#@]{1,256}\\.){1,50}[a-z\\-]{2,15})|(([\\-a-zA-Z0-9:%_+~#@]{1,256}\\.){1,50}(com|org|net|int|edu|gov|mil|ac|ad|ae|af|ag|ai|al|am|an|ao|aq|ar|as|at|au|aw|ax|az|ba|bb|bd|be|bf|bg|bh|bi|bj|bm|bn|bo|br|bs|bt|bv|bw|by|bz|ca|cc|cf|cg|ch|ci|ck|cl|cm|cn|co|cr|cu|cv|cw|cx|cy|cz|de|dj|dk|dm|do|dz|ec|ee|eg|eh|er|es|et|eu|fi|fj|fk|fm|fo|fr|ga|gb|gd|ge|gf|gh|gi|gl|gm|gn|gp|gr|gs|gt|gu|gw|gy|hk|hm|hn|hr|ht|hu|id|ie|il|im|in|io|iq|ir|is|it|jm|jo|jp|ke|kg|kh|ki|km|kn|kp|kr|kw|ky|kz|la|lb|lc|li|lk|lr|ls|lt|lu|lv|ly|ma|mc|md|me|mf|mg|mh|mk|ml|mm|mn|mo|mp|mq|mr|ms|mt|mu|mv|mw|mx|my|mz|na|nc|ne|nf|ng|ni|nl|no|np|nr|nu|nz|om|pa|pe|pf|pg|ph|pk|pl|pm|pn|pr|ps|pt|pw|py|qa|re|ro|rs|ru|rw|sa|sb|sc|sd|se|sg|sh|si|sj|sk|sl|sm|sn|so|sr|ss|st|su|sv|sx|sy|sz|tc|td|tf|tg|th|tj|tk|tl|tm|tn|to|tp|tr|tt|tv|tw|tz|ua|ug|uk|um|us|uy|uz|va|vc|ve|vg|vi|vn|vu|wf|ws|ye|yt|za|zm|zw|site|top|wtf|xxx|xyz|cloud|engineering|help|one)))(:[0-9]{2,5})?\\b([/?#][-a-zA-Z0-9@:%_+.~#?&/=;()$,!\\*\\[\\]{}^|<>]*)?");
    L6:
        List r7 = SequencesKt.toList(r0.findAll(r5, 0));
        if (r7.isEmpty() == false) goto L9;
        return;
    L9:
        Iterator r8 = r7.iterator();
    L11:
        if (r8.hasNext() == false) goto L13;
        MatchResult r1 = (MatchResult) r8.next();
        String r2 = r1.getValue();
        int r3 = r1.getRange().getFirst();
        a r4 = new a(r2, r3, r2.length() + r3, false);
        ((ArrayList) r6).add(r4);
        goto L11
    L13:
        return;
    L5:
        r0 = new Regex("(((https?)://([\\-a-zA-Z0-9:%_+~#@]{1,256}\\.){1,50}[a-z\\-]{2,15})|(([\\-a-zA-Z0-9:%_+~#@]{1,256}\\.){1,50}(com|org|net|int|edu|gov|mil|ac|ad|ae|af|ag|ai|al|am|an|ao|aq|ar|as|at|au|aw|ax|az|ba|bb|bd|be|bf|bg|bh|bi|bj|bm|bn|bo|br|bs|bt|bv|bw|by|bz|ca|cc|cf|cg|ch|ci|ck|cl|cm|cn|co|cr|cu|cv|cw|cx|cy|cz|de|dj|dk|dm|do|dz|ec|ee|eg|eh|er|es|et|eu|fi|fj|fk|fm|fo|fr|ga|gb|gd|ge|gf|gh|gi|gl|gm|gn|gp|gr|gs|gt|gu|gw|gy|hk|hm|hn|hr|ht|hu|id|ie|il|im|in|io|iq|ir|is|it|jm|jo|jp|ke|kg|kh|ki|km|kn|kp|kr|kw|ky|kz|la|lb|lc|li|lk|lr|ls|lt|lu|lv|ly|ma|mc|me|mf|mg|mh|mk|ml|mm|mn|mo|mp|mq|mr|ms|mt|mu|mv|mw|mx|my|mz|na|nc|ne|nf|ng|ni|nl|no|np|nr|nu|nz|om|pa|pe|pf|pg|ph|pk|pl|pm|pn|pr|ps|pt|pw|py|qa|re|ro|rs|ru|rw|sa|sb|sc|sd|se|sg|sh|si|sj|sk|sl|sm|sn|so|sr|ss|st|su|sv|sx|sy|sz|tc|td|tf|tg|th|tj|tk|tl|tm|tn|to|tp|tr|tt|tv|tw|tz|ua|ug|uk|um|us|uy|uz|va|vc|ve|vg|vi|vn|vu|wf|ws|ye|yt|za|zm|zw|site|top|wtf|xxx|xyz|cloud|engineering|help|one)))(:[0-9]{2,5})?\\b([/?#][-a-zA-Z0-9@:%_+.~#?&/=;()$,!\\*\\[\\]{}^|<>]*)?");
        goto L6
    }

    @JvmStatic
    public static final void e(CharSequence r4, List r5) {
        Intrinsics.checkNotNullParameter(r4, "content");
        Intrinsics.checkNotNullParameter(r5, "urls");
        List r6 = SequencesKt.toList(new Regex("^https?://([^\\./:@\\s#\\?\\,=]+\\.){1,50}[^\\./:@\\s#\\?\\,=]+(:[0-9]{2,5})?([/?#]\\S*)?$").findAll(r4, 0));
        if (r6.size() != 1) goto L6;
        MatchResult r7 = (MatchResult) ListProtector.get(r6, 0);
        String r0 = r7.getValue();
        int r8 = r7.getRange().getFirst();
        ArrayList r9 = (ArrayList) r5;
        r9.add(new a(r0, r8, r0.length() + r8, true));
        return;
    }

    @JvmStatic
    public static final boolean c(CharSequence r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(com.ss.android.lark.keyboard.edittext2.widget.f.class, "clazz");
        Intrinsics.checkNotNullParameter("Anchor", "className");
        boolean r1 = false;
        if (r9 != null) goto L6;
    L33:
        return r1;
    L6:
        if ((r9 instanceof Spanned) == false) goto L33;
        Spanned r12 = (Spanned) r9;
        Object[] r0 = r12.getSpans(r10, r11, com.ss.android.lark.keyboard.edittext2.widget.f.class);
        ArrayList r2 = new ArrayList(r0.length);
        int r3 = r0.length;
        int r4 = 0;
    L10:
        if (r4 >= r3) goto L12;
        Object r6 = r0[r4];
        r2.add(new Integer[]{Integer.valueOf(r12.getSpanStart(r6)), Integer.valueOf(r12.getSpanEnd(r6))});
        r4 = r4 + 1;
        goto L10
    L12:
        List r13 = CollectionsKt.sortedWith(r2, new c());
        if (r13.isEmpty() == false) goto L15;
        Log.i("AnchorParseUtils", "isParsedAnchor: markIndices is empty");
        goto L33
    L15:
        ArrayList r5 = new ArrayList();
        Iterator r14 = r13.iterator();
    L17:
        if (r14.hasNext() == false) goto L26;
        Integer[] r7 = (Integer[]) r14.next();
        int r8 = r7[0].intValue();
        int r15 = r7[1].intValue();
        if (r5.isEmpty() == true) goto L24;
        if (((Integer[]) CollectionsKt.last(r5))[1].intValue() < r8) goto L24;
        ((Integer[]) CollectionsKt.last(r5))[1] = Integer.valueOf(Math.max(((Integer[]) CollectionsKt.last(r5))[1].intValue(), r15));
    L24:
        r5.add(r7);
        goto L17
    L26:
        if (r5.size() == 1) goto L28;
    L32:
        Log.i("AnchorParseUtils", "isParsedAnchor: " + r1);
        goto L33
    L28:
        if (((Integer[]) ListProtector.get(r5, 0))[0].intValue() > r10) goto L32;
        if (((Integer[]) ListProtector.get(r5, 0))[1].intValue() < r11) goto L32;
        r1 = true;
        goto L32
    }

    @JvmStatic
    public static final void d(Spannable r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "data");
        com.ss.android.lark.keyboard.edittext2.widget.f.J1.getClass();
        r2.setSpan(new com.ss.android.lark.keyboard.edittext2.widget.e(), r3, r4, 33);
    }
}
