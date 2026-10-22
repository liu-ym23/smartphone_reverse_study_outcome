package vt8;

import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import java.text.BreakIterator;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i implements d {
    public final int a;
    public final CustomMarkdownTextView b;
    public final BreakIterator c;
    public int d;

    @Override // vt8.d
    public final int b() {
        return this.d;
    }

    public i(int r1, CustomMarkdownTextView r2) {
        this.a = r1;
        this.b = r2;
        if (r1 != 1) goto L5;
        BreakIterator r3 = BreakIterator.getWordInstance(Locale.getDefault());
    L6:
        this.c = r3;
        this.d = r1;
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // vt8.d
    public final Pair<Integer, Integer> a(String r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "txt");
        Lazy r0 = c.a;
        if (c.c(r7, this.b) == false) goto L6;
        Pair<Integer, Integer> r8 = new f(this.b).a(r6, r7);
        this.d = 4;
        return r8;
    L6:
        this.d = this.a;
        BreakIterator r1 = this.c;
        if (r1 == null) goto L9;
        r1.setText(r6);
        int r2 = this.c.next();
        if (r7 < 0) goto L14;
        if (r7 >= r2) goto L14;
        boolean r3 = true;
    L15:
        if (r3 == false) goto L19;
        return TuplesKt.to(0, Integer.valueOf(r2));
    L19:
        if (r2 == (-1)) goto L33;
        int r4 = this.c.next();
        if (r4 == (-1)) goto L23;
        if (r7 < 0) goto L27;
        if (r7 >= r4) goto L27;
        boolean r5 = true;
    L28:
        if (r5 == true) goto L30;
        r2 = r4;
        goto L19
    L30:
        return TuplesKt.to(Integer.valueOf(r2), Integer.valueOf(r4));
    L27:
        r5 = false;
        goto L28
    L23:
        return TuplesKt.to(Integer.valueOf(r2), Integer.valueOf(r6.length()));
    L33:
        return TuplesKt.to(0, Integer.valueOf(r6.length()));
    L14:
        r3 = false;
        goto L15
    L9:
        return TuplesKt.to(0, Integer.valueOf(r6.length()));
    }
}
