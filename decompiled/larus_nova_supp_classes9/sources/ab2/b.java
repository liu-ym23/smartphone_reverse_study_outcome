package ab2;

import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import com.bytedance.android.livehostapi.business.IMiddleWareHostEmoji;
import com.bytedance.android.livesdk.y5;
import fb2.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public static b c;
    public final cb2.a a;
    public final bb2.a b;

    public static b a() {
        if (c != null) goto L6;
        c = new b();
    L6:
        return c;
    }

    public b() {
        this.a = new cb2.a();
        this.b = new bb2.a();
    }

    public final void b(SpannableString r10, int r11) {
        this.b.getClass();
        Iterator r0 = ((ArrayList) bb2.a.c(r10)).iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        db2.a r1 = (db2.a) r0.next();
        Drawable r3 = r1.a;
        if (r3 == null) goto L4;
        bb2.a.a(r10, r3, r1.b, r1.c, (int) (c.b(r11, r3, false) + 0.5f), r11, null);
        goto L4
    }

    public final SpannableString c(CharSequence r13, float r14) {
        this.b.getClass();
        if (r13 != null) goto L5;
        return null;
    L5:
        e90.a[] r1 = new e90.a[0];
        if ((r13 instanceof Spannable) == false) goto L15;
        Spannable r2 = (Spannable) r13;
        eb2.a[] r3 = (eb2.a[]) r2.getSpans(0, r13.length(), eb2.a.class);
        if (r3 != null) goto L10;
    L14:
        r1 = (e90.a[]) r2.getSpans(0, r13.length(), e90.a.class);
        goto L15
    L10:
        if (r3.length <= 0) goto L14;
        int r4 = r3.length;
        int r5 = 0;
    L12:
        if (r5 >= r4) goto L14;
        r2.removeSpan(r3[r5]);
        r5 = r5 + 1;
    L15:
        SpannableString r9 = SpannableString.valueOf(r13);
        Matcher r10 = bb2.a.b.matcher(r13);     // Catch: Exception -> L37
    L18:
        if (r10.find() == false) goto L36;
        String r6 = r10.group();
        int r7 = r10.start();
        int r8 = r10.end();
        if (((Boolean) y5.a.getValue()).booleanValue() == false) goto L32;
        int r11 = r1.length;
        int r15 = 0;
    L22:
        if (r15 >= r11) goto L29;
        e90.a r16 = r1[r15];
        int r17 = r9.getSpanStart(r16);
        int r18 = r9.getSpanEnd(r16);
        if (r16.b() == false) goto L28;
        if (r7 < r17) goto L28;
        if (r8 > r18) goto L28;
        boolean r19 = true;
    L30:
        if (r19 == false) goto L32;
    L28:
        r15 = r15 + 1;
        goto L22
    L29:
        r19 = false;
    L32:
        Drawable r20 = k.f(IMiddleWareHostEmoji.class).getRealDrawable(r6);
        if (r20 == null) goto L18;
        bb2.a.a(r9, r20, r7, r8, (int) (c.b(r14, r20, false) + 0.5f), (int) (0.5f + r14), String.valueOf(r13.subSequence(r7, r8)));
    L36:
        return r9;
    }
}
