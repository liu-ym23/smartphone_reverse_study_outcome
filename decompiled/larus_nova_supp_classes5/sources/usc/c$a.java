package usc;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Pattern;
import org.commonmark.internal.d;
import org.commonmark.internal.h;
import wvc.b;
import wvc.f;
import wvc.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c$a extends b {
    public final Set<String> a;

    public c$a() {
        this.a = new LinkedHashSet();
    }

    @Override // wvc.e
    public final f a(g r8, h.a r9) {
        h r10 = (h) r8;
        int r11 = r10.e;
        CharSequence r0 = r10.a;
        if (r10.g < 4) goto L5;
        return null;
    L5:
        if (r0.charAt(r11) != '<') goto L18;
        Iterator<String> r1 = this.a.iterator();
    L8:
        if (r1.hasNext() == false) goto L19;
        String r2 = r1.next();
        Pattern r3 = PatternProtector.compile("^<(?:" + r2 + ")(?:\\s|>|$)", 2);
        Pattern r4 = PatternProtector.compile("</(?:" + r2 + ")>", 2);
        if (r3.matcher(r0.subSequence(r11, r0.length())).find() == false) goto L8;
        d r5 = new d(new wvc.d[]{new c(r4)});
        r5.b = r10.b;
        return r5;
    L19:
        return null;
    L18:
        return null;
    }
}
