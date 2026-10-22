package ab2;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.bytedance.android.livehostapi.business.IMiddleWareHostEmoji;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.interactivity.service.emoji.model.EmojiUriModel;
import com.bytedance.android.livesdk.interactivity.service.emoji.model.EmojiUriNode;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import jc1.k;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final boolean a(String r7) {
        int r0 = fb2.a.a;
        if (TextUtils.isEmpty(r7) == true) goto L54;
        ArrayList r1 = new ArrayList();     // Catch: Exception -> L36
        Matcher r2 = PatternProtector.compile("(?:[\\uD83C\\uDF00-\\uD83D\\uDDFF]|[\\uD83E\\uDD00-\\uD83E\\uDDFF]|[\\uD83D\\uDE00-\\uD83D\\uDE4F]|[\\uD83D\\uDE80-\\uD83D\\uDEFF]|[\\u2600-\\u26FF]\\uFE0F?|[\\u2700-\\u27BF]\\uFE0F?|\\u24C2\\uFE0F?|[\\uD83C\\uDDE6-\\uD83C\\uDDFF]{1,2}|[\\uD83C\\uDD70\\uD83C\\uDD71\\uD83C\\uDD7E\\uD83C\\uDD7F\\uD83C\\uDD8E\\uD83C\\uDD91-\\uD83C\\uDD9A]\\uFE0F?|[\\u0023\\u002A\\u0030-\\u0039]\\uFE0F?\\u20E3|[\\u2194-\\u2199\\u21A9-\\u21AA]\\uFE0F?|[\\u2B05-\\u2B07\\u2B1B\\u2B1C\\u2B50\\u2B55]\\uFE0F?|[\\u2934\\u2935]\\uFE0F?|[\\u3030\\u303D]\\uFE0F?|[\\u3297\\u3299]\\uFE0F?|[\\uD83C\\uDE01\\uD83C\\uDE02\\uD83C\\uDE1A\\uD83C\\uDE2F\\uD83C\\uDE32-\\uD83C\\uDE3A\\uD83C\\uDE50\\uD83C\\uDE51]\\uFE0F?|[\\u203C\\u2049]\\uFE0F?|[\\u25AA\\u25AB\\u25B6\\u25C0\\u25FB-\\u25FE]\\uFE0F?|[\\u00A9\\u00AE]\\uFE0F?|[\\u2122\\u2139]\\uFE0F?|\\uD83C\\uDC04\\uFE0F?|\\uD83C\\uDCCF\\uFE0F?|[\\u231A\\u231B\\u2328\\u23CF\\u23E9-\\u23F3\\u23F8-\\u23FA]\\uFE0F?)").matcher(r7);     // Catch: Exception -> L36
    L7:
        if (r2.find() == false) goto L11;
        r1.add(r2.group());     // Catch: Exception -> L36
        if (r1.size() <= 3) goto L7;
        return false;
    L11:
        int r3 = r1.size();     // Catch: Exception -> L36
        int r4 = 0;
        int r5 = 0;
    L12:
        if (r4 >= r3) goto L14;
        r5 = r5 + ((String) ListProtector.get(r1, r4)).length();     // Catch: Exception -> L36
        r4 = r4 + 1;     // Catch: Exception -> L36
        goto L12
    L14:
        Intrinsics.checkNotNull(r7);     // Catch: Exception -> L36
        if (r5 == r7.length()) goto L17;
        Matcher r6 = PatternProtector.compile("(\\[)([^\\[\\]]+)(])").matcher(r7);     // Catch: Exception -> L36
    L21:
        if (r6.find() == false) goto L27;
        String r8 = r6.group();     // Catch: Exception -> L36
        if (k.n(IMiddleWareHostEmoji.class).getRealDrawable(r8) == null) goto L21;
        r1.add(r8);     // Catch: Exception -> L36
        if (r1.size() <= 3) goto L21;
        return false;
    L27:
        int r9 = r1.size();     // Catch: Exception -> L36
        int r10 = 0;
        int r11 = 0;
    L28:
        if (r10 >= r9) goto L31;
        r11 = r11 + ((String) ListProtector.get(r1, r10)).length();     // Catch: Exception -> L36
        r10 = r10 + 1;     // Catch: Exception -> L36
        goto L28
    L31:
        if (r11 == r7.length()) goto L33;
        return false;
    L33:
        if (r1.size() > 3) goto L53;
    L34:
        return true;
    L53:
        return false;
    L17:
        if (r1.size() <= 3) goto L34;
        return false;
    L55:
        return false;
    L54:
        return false;
    }

    @JvmStatic
    public static final void c(Spannable r13) {
        bb2.a r0 = b.a().b;
        r0.getClass();
        ArrayList r2 = new ArrayList();
        Matcher r4 = bb2.a.b.matcher(r13);     // Catch: Exception -> L65
    L5:
        if (r4.find() == false) goto L35;
        String r5 = r4.group();
        int r6 = r4.start();
        int r7 = r4.end();
        List<BaseEmoji> r8 = r0.a;
        if (r8 != null) goto L9;
    L10:
        r0.a = k.f(IMiddleWareHostEmoji.class).loadAllBaseEmoji();
    L11:
        List<BaseEmoji> r9 = r0.a;
        if (r9 != null) goto L14;
    L32:
        EmojiUriModel r10 = null;
    L33:
        if (r10 == null) goto L5;
        r2.add(new EmojiUriNode(r10, r6, r7));
        goto L5
    L14:
        if (r9.isEmpty() == true) goto L32;
        Iterator<BaseEmoji> r11 = r9.iterator();
    L18:
        if (r11.hasNext() == false) goto L32;
        BaseEmoji r14 = r11.next();
        if (TextUtils.equals(r14.getDescription(), r5) == false) goto L18;
        int r15 = r14.getIconId();
        String r16 = r14.getLocalFilePath();
        if (r15 > 0) goto L24;
        if (r16 == null) goto L18;
        if (r16.startsWith("file://") == true) goto L29;
    L31:
        r10 = new EmojiUriModel(r15, r16, r5);
        goto L33
    L29:
        if (r16.startsWith("file:///") == true) goto L31;
        r16 = r16.replace("file://", "file:///");
        goto L31
    L24:
        r10 = new EmojiUriModel(r15, r16, r5);
        goto L33
    L9:
        if (r8.isEmpty() == false) goto L11;
    L35:
        Iterator r1 = r2.iterator();
    L37:
        if (r1.hasNext() == false) goto L64;
        EmojiUriNode r3 = (EmojiUriNode) r1.next();
        EmojiUriModel r17 = r3.getEmojiUri();
        if (r17 == null) goto L37;
        int r18 = r3.getStartIndex();
        int r19 = r3.getEndIndex();
        if (r13 == null) goto L37;
        if (r13.length() == 0) goto L37;
        if (r18 < 0) goto L37;
        if (r18 > r13.length()) goto L37;
        if (r18 > r19) goto L37;
        if (r19 > r13.length()) goto L37;
        if (r17.getLocalFilePath() == null) goto L58;
        if (r17.getLocalFilePath().startsWith("file://") == false) goto L58;
        String r20 = r17.getLocalFilePath();
    L61:
        if (r20 == null) goto L37;
        r13.setSpan(new ImageSpan(new ColorDrawable(), r20), r18, r19, 33);
    L58:
        if (r17.getIconId() <= 0) goto L60;
        r20 = String.format(Locale.CHINESE, "%s%d", new Object[]{"res://", Integer.valueOf(r17.getIconId())});
        goto L61
    L60:
        r20 = null;
        goto L61
    }

    @JvmStatic
    public static final List<db2.a> d(CharSequence r1) {
        return b.a().b.b(r1);
    }

    @JvmStatic
    public static final void b(Spannable r9, int r10) {
        Iterator r0 = ((ArrayList) b.a().b.b(r9)).iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        db2.a r1 = (db2.a) r0.next();
        Drawable r3 = r1.a;
        if (r3 == null) goto L4;
        bb2.a.a(r9, r3, r1.b, r1.c, r10, r10, null);
        goto L4
    }

    @JvmStatic
    public static final void e(SpannableString r1, int r2) {
        b.a().b(r1, r2);
    }

    @JvmStatic
    public static final SpannableString f(CharSequence r1, float r2) {
        return b.a().c(r1, r2);
    }
}
