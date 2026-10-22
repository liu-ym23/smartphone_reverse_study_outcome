package r90;

import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import com.bytedance.android.live.emoji.api.IAwemeEmojiProxy;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import java.util.List;
import java.util.regex.Matcher;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static a c;
    public final u90.a a;
    public final s90.a b;

    public static a a() {
        if (c != null) goto L6;
        c = new a();
    L6:
        return c;
    }

    public final List<BaseEmoji> b() {
        this.a.getClass();
        if (k.f(IAwemeEmojiProxy.class) != null) goto L7;
        return null;
    L7:
        return ((IAwemeEmojiProxy) k.f(IAwemeEmojiProxy.class)).loadAllBaseEmoji();
    }

    public a() {
        this.a = new u90.a();
        this.b = new s90.a();
    }

    public final SpannableString c(CharSequence r13, float r14, boolean r15) {
        this.b.getClass();
        if (r13 != null) goto L6;
        return null;
    L6:
        if ((r13 instanceof Spannable) == false) goto L14;
        Spannable r1 = (Spannable) r13;
        int r4 = 0;
        x90.a[] r2 = (x90.a[]) r1.getSpans(0, r13.length(), x90.a.class);
        if (r2 == null) goto L14;
        if (r2.length <= 0) goto L14;
        int r3 = r2.length;
    L12:
        if (r4 >= r3) goto L14;
        r1.removeSpan(r2[r4]);
        r4 = r4 + 1;
    L14:
        SpannableString r5 = SpannableString.valueOf(r13);
        Matcher r6 = s90.a.b.matcher(r13);
    L16:
        if (r6.find() == false) goto L24;
        String r7 = r6.group();
        int r8 = r6.start();
        int r9 = r6.end();
        if (k.f(IAwemeEmojiProxy.class) == null) goto L20;
        Drawable r11 = ((IAwemeEmojiProxy) k.f(IAwemeEmojiProxy.class)).getRealDrawable(r7);
    L21:
        if (r11 == null) goto L16;
        s90.a.a(r5, r11, r8, r9, (int) (fb2.c.b(r14, r11, r15) + 0.5f), (int) (fb2.c.a(r14, r15) + 0.5f), String.valueOf(r13.subSequence(r8, r9)));
        goto L16
    L20:
        r11 = null;
        goto L21
    L24:
        return r5;
    }
}
