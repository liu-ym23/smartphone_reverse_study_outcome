package bb2;

import android.graphics.drawable.Drawable;
import android.text.Spannable;
import com.bytedance.android.livehostapi.business.IMiddleWareHostEmoji;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final Pattern b = null;
    public List<BaseEmoji> a;

    static {
        b = PatternProtector.compile("\\[[a-zA-Z0-9\\u4e00-\\u9fa5]+\\]");
    }

    public a() {
        this.a = null;
    }

    public static List c(CharSequence r8) {
        ArrayList r0 = new ArrayList();
        if (r8 != null) goto L5;
    L23:
        return r0;
    L5:
        if (r8.length() < 3) goto L23;
        StringBuilder r1 = new StringBuilder();
        int r3 = 0;
        boolean r4 = false;
        int r5 = 0;
    L9:
        if (r3 >= r8.length()) goto L23;
        char r6 = r8.charAt(r3);
        if (r6 != '[') goto L14;
        r1.setLength(0);
        r1.append('[');
        r4 = true;
        r5 = r3;
    L22:
        r3 = r3 + 1;
        goto L9
    L14:
        if (r6 != ']') goto L20;
        if (r4 == false) goto L20;
        r1.append(']');
        Drawable r7 = k.f(IMiddleWareHostEmoji.class).getRealDrawable(r1.toString());
        if (r7 == null) goto L19;
        r0.add(new db2.a(r7, r5, r3 + 1));
    L19:
        r1.setLength(0);
        r4 = false;
    L20:
        if (r4 == false) goto L22;
        r1.append(r6);
        goto L22
    }

    public final List<db2.a> b(CharSequence r6) {
        ArrayList r0 = new ArrayList();
        Matcher r7 = b.matcher(r6);     // Catch: Exception -> L10
    L5:
        if (r7.find() == false) goto L9;
        String r1 = r7.group();
        int r2 = r7.start();
        int r3 = r7.end();
        Drawable r4 = k.f(IMiddleWareHostEmoji.class).getRealDrawable(r1);
        if (r4 == null) goto L5;
        r0.add(new db2.a(r4, r2, r3));
    L9:
        return r0;
    }

    public static void a(Spannable r1, Drawable r2, int r3, int r4, int r5, int r6, String r7) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.length() == 0) goto L15;
        if (r3 >= 0) goto L7;
        return;
    L7:
        if (r3 > r1.length()) goto L17;
        if (r3 <= r4) goto L10;
        return;
    L10:
        if (r4 > r1.length()) goto L19;
        r2.setBounds(0, 0, r5, r6);
        eb2.a r8 = new eb2.a(r2);
        r8.a = 2;
        r8.b = 2;
        r8.c = r7;
        r1.setSpan(r8, r3, r4, 33);
        return;
    L19:
        return;
    L17:
        return;
    }
}
