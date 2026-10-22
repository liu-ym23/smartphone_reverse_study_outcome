package io.noties.markwon.ext.onetex;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import com.edu.onetex.latex.LaTeXParam;
import com.edu.onetex.latex.icon.LaTeXIcon;
import io.noties.markwon.onetex.LatexMathBlock;
import io.noties.markwon.onetex.LatexMathNode;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import kotlin.text.StringsKt;
import lsc.p$a;
import msc.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class o extends lsc.a {
    public final b a;
    public final d b;
    public final k c;
    public final Context d;
    public final f e;

    public static final class a {
    }

    public static class b extends wsc.b {
        public final Handler a;
        public final Map<wsc.a, Future<?>> b;
        public final f c;
        public final Context d;

        @Override // wsc.b
        public final void c(wsc.a r1) {
        }

        @Override // wsc.b
        public final void a(wsc.a r2) {
            Future<?> r3 = this.b.remove(r2);
            if (r3 == null) goto L6;
            r3.cancel(true);
            return;
        }

        @Override // wsc.b
        public final void b(wsc.a r4) {
            if ((r4 instanceof io.noties.markwon.ext.onetex.b) == true) goto L5;
            wsc.a r0 = null;
        L6:
            io.noties.markwon.ext.onetex.b r1 = (io.noties.markwon.ext.onetex.b) r0;
            boolean r2 = true;
            if (r1 != null) goto L9;
        L12:
            Future<?> r3 = this.c.e.submit(new a(this, r2, r4));
            this.b.put(r4, r3);
            return;
        L9:
            if (r1.m != true) goto L12;
            r2 = false;
            goto L12
        L5:
            r0 = r4;
            goto L6
        }

        public b(f r1, Context r2) {
            this.c = r1;
            this.d = r2;
            this.a = new Handler(Looper.getMainLooper());
            this.b = new LinkedHashMap();
        }
    }

    static {
    }

    public wsc.f o(s r1, String r2) {
        throw null;
    }

    public wsc.f p(s r1, String r2, boolean r3, LaTeXIcon r4, Integer r5, Integer r6, Float r7) {
        throw null;
    }

    public List<LaTeXIcon> q(LaTeXParam r1) {
        throw null;
    }

    public static String r(String r7) {
        String r8 = StringsKt.replace$default(r7, '\n', ' ', false, 4, null);
        int r0 = r8.length() - 1;
        int r3 = 0;
        boolean r4 = false;
    L3:
        if (r3 > r0) goto L19;
        if (r4 == true) goto L6;
        int r5 = r3;
    L8:
        if (r8.charAt(r5) > ' ') goto L10;
        boolean r6 = true;
    L11:
        if (r4 == false) goto L12;
        if (r6 == false) goto L19;
        r0 = r0 - 1;
        goto L3
    L12:
        if (r6 == false) goto L13;
        r3 = r3 + 1;
        goto L3
    L13:
        r4 = true;
        goto L3
    L10:
        r6 = false;
        goto L11
    L6:
        r5 = r0;
    L19:
        return r8.subSequence(r3, r0 + 1).toString();
    }

    @Override // lsc.a, lsc.j
    public void G4(TextView r8) {
        Integer r1 = (Integer) r8.getTag(2131379635);
        int r2 = r8.getText().hashCode();
        if (r1 != null) goto L5;
    L7:
        r8.setTag(2131379635, Integer.valueOf(r2));
        wsc.f[] r0 = wsc.e.a(r8);
        if (r0 != null) goto L10;
        return;
    L10:
        if (r0.length > 0) goto L12;
        return;
    L12:
        if (r8.getTag(2131379633) != null) goto L14;
        wsc.d r3 = new wsc.d(r8);
        r8.addOnAttachStateChangeListener(r3);
        r8.setTag(2131379633, r3);
    L14:
        wsc.e.b r4 = new wsc.e.b(r8);
        int r5 = r0.length;
        int r6 = 0;
    L15:
        if (r6 >= r5) goto L21;
        wsc.a r7 = r0[r6].b;
        r7.c(new wsc.e.a(r8, r4, r7.getBounds()));
        r6 = r6 + 1;
        goto L15
    L21:
        return;
    L5:
        if (r1.intValue() != r2) goto L7;
    }

    @Override // lsc.a, lsc.j
    public final void c(p$a r3) {
        f r0 = this.e;
        if (r0.f == false) goto L11;
        if (r0.b == false) goto L8;
        r3.a(LatexMathBlock.class, new r(this));
    L8:
        if (this.e.c == false) goto L17;
        r3.a(LatexMathNode.class, new s(this));
        return;
    L17:
        return;
    L11:
        if (r0.b == false) goto L14;
        r3.a(LatexMathBlock.class, new p(this));
    L14:
        if (this.e.c == false) goto L19;
        r3.a(LatexMathNode.class, new q(this));
        return;
    }

    public o(Context r2, f r3) {
        this.d = r2;
        this.e = r3;
        this.a = new b(r3, r2);
        this.b = new d(r3.a.c);
        this.c = new k(r3.a.c);
    }

    public static final boolean n(o r5, String r6) {
        List<String> r7 = r5.e.h;
        if (r7.isEmpty() == true) goto L15;
        Iterator<T> r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L16;
        if (StringsKt.contains$default(r6, (String) r8.next(), false, 2, null) == false) goto L7;
        return false;
    L16:
        return true;
    L15:
        return true;
    }
}
