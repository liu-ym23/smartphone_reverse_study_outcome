package tsc;

import android.text.Spanned;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.ArraysKt;
import lsc.p$a;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.HtmlInline;
import uvc.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class i extends h {
    public final Set<String> f;
    public final n g;

    public static final class a {
    }

    static {
    }

    @Override // lsc.a, lsc.j
    public final void i(CharSequence r1, b r2) {
    }

    public i() {
        this.g = null;
        this.f = new LinkedHashSet();
    }

    public static String q(List r4) {
        StringBuffer r0 = new StringBuffer("{");
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r0.append("span: " + ((usc.e) r5.next()).toString());
        goto L4
    L6:
        r0.append("}");
        return r0.toString();
    }

    @Override // lsc.a, lsc.j
    public final void G4(TextView r5) {
        ViewParent r0 = r5.getParent();
        if ((r0 instanceof ViewGroup) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup r1 = (ViewGroup) r0;
        if (r1 == null) goto L8;
        r1.setTag(2131379632, null);
    L8:
        CharSequence r2 = r5.getText();
        if ((r2 instanceof Spanned) == false) goto L13;
        int r3 = 0;
        usc.e[] r4 = (usc.e[]) ((Spanned) r2).getSpans(0, r2.length(), usc.e.class);
        int r6 = r4.length;
    L11:
        if (r3 >= r6) goto L15;
        r4[r3].a(r5);
        r3 = r3 + 1;
        goto L11
    L15:
        return;
    }

    @Override // lsc.a, lsc.j
    public final void c(p$a r3) {
        r3.a(HtmlBlock.class, new j(this));
        r3.a(HtmlInline.class, new k(this));
    }

    @Override // lsc.a, lsc.j
    public final void k(vvc.e.a r4) {
        usc.c$a r0 = new usc.c$a();
        r0.a.addAll(this.f);
        r4.a(r0);
    }

    public static String p(usc.e r2, String r3) {
        return "span[" + r2 + "]:" + r3;
    }

    @Override // lsc.a, lsc.j
    public final void f(TextView r7, Spanned r8) {
        n r0 = this.g;
        if (r0 == null) goto L5;
        r0.d("custom-data-hp", "beforeSetText markdown: " + r8);
    L5:
        CharSequence r1 = r7.getText();
        n r2 = this.g;
        if (r2 == null) goto L9;
        r2.d("custom-data-hp", "beforeSetText currText: " + r1);
    L9:
        if ((r1 instanceof Spanned) == true) goto L11;
        CharSequence r3 = null;
    L12:
        Spanned r4 = (Spanned) r3;
        if (r4 == null) goto L19;
        usc.e[] r5 = (usc.e[]) r4.getSpans(0, r1.length(), usc.e.class);
        if (r5 == null) goto L19;
        List r6 = ArraysKt.toMutableList(r5);
        if (r6 == null) goto L19;
    L20:
        n r9 = this.g;
        if (r9 == null) goto L23;
        r9.d("custom-data-hp", "beforeSetText currSpans: " + q(r6));
    L23:
        List r10 = ArraysKt.toMutableList(r8.getSpans(0, r8.length(), usc.e.class));
        n r11 = this.g;
        if (r11 == null) goto L26;
        r11.d("custom-data-hp", "beforeSetText newSpans: " + q(r10));
    L26:
        Iterator r12 = r6.iterator();
    L28:
        if (r12.hasNext() == false) goto L38;
        usc.e r13 = (usc.e) r12.next();
        if (r10.remove(r13) == false) goto L31;
        n r14 = this.g;
        if (r14 == null) goto L37;
        r14.d("custom-data-hp", p(r13, "reuse span"));
    L37:
        r13.g(r7, r8);
        goto L28
    L31:
        r13.c(r7);
        n r15 = this.g;
        if (r15 == null) goto L28;
        r15.d("custom-data-hp", p(r13, "span.onDetach"));
        goto L28
    L38:
        Iterator r16 = r10.iterator();
    L40:
        if (r16.hasNext() == false) goto L45;
        usc.e r17 = (usc.e) r16.next();
        n r18 = this.g;
        if (r18 == null) goto L44;
        r18.d("custom-data-hp", p(r17, "new span beforeAttach"));
    L44:
        r17.d(r7, r8);
        goto L40
    L45:
        return;
    L19:
        r6 = new ArrayList();
        goto L20
    L11:
        r3 = r1;
        goto L12
    }
}
