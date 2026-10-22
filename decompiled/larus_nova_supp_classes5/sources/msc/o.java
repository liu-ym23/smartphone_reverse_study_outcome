package msc;

import android.text.Spannable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.core.spans.v;
import java.util.ArrayList;
import java.util.List;
import lsc.y;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.BulletList;
import org.commonmark.node.Code;
import org.commonmark.node.Emphasis;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Heading;
import org.commonmark.node.Image;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.Link;
import org.commonmark.node.ListItem;
import org.commonmark.node.OrderedList;
import org.commonmark.node.Paragraph;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.node.ThematicBreak;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class o extends lsc.a {
    public final List<b> a;
    public boolean b;
    public final List<a> c;

    public o() {
        this.a = new ArrayList(0);
        this.c = new ArrayList(0);
    }

    @Override // lsc.a, lsc.j
    public final void G4(TextView r2) {
        if (this.b == false) goto L5;
        return;
    L5:
        if (r2.getMovementMethod() != null) goto L9;
        r2.setMovementMethod(LinkMovementMethod.getInstance());
        return;
    }

    @Override // lsc.a, lsc.j
    public void c(lsc.p$a r3) {
        r3.a(Text.class, new g(this));
        r3.a(StrongEmphasis.class, new h());
        r3.a(Emphasis.class, new i());
        r3.a(BlockQuote.class, new j());
        r3.a(Code.class, new k());
        r3.a(FencedCodeBlock.class, new l());
        r3.a(IndentedCodeBlock.class, new m());
        r3.a(Image.class, new n());
        r3.a(BulletList.class, new t());
        r3.a(OrderedList.class, new t());
        r3.a(ListItem.class, new io.noties.markwon.core.a());
        r3.a(ThematicBreak.class, new a());
        r3.a(Heading.class, new b());
        r3.a(SoftLineBreak.class, new c());
        r3.a(HardLineBreak.class, new d());
        r3.a(Paragraph.class, new e());
        r3.a(Link.class, new f());
    }

    @Override // lsc.a, lsc.j
    public final void h(lsc.l.a r5) {
        nsc.c r0 = new nsc.c();
        r5.a(StrongEmphasis.class, new nsc.l());
        r5.a(Emphasis.class, new nsc.f());
        r5.a(BlockQuote.class, new nsc.b(0, 0));
        r5.a(Code.class, new nsc.d());
        r5.a(FencedCodeBlock.class, r0);
        r5.a(IndentedCodeBlock.class, r0);
        r5.a(ListItem.class, new nsc.k());
        r5.a(Heading.class, new nsc.h());
        r5.a(Link.class, new nsc.i());
        r5.a(ThematicBreak.class, new nsc.n());
    }

    @Override // lsc.a, lsc.j
    public final void f(TextView r9, Spanned r10) {
        io.noties.markwon.core.spans.r[] r0 = (io.noties.markwon.core.spans.r[]) r10.getSpans(0, r10.length(), io.noties.markwon.core.spans.r.class);
        if (r0 == null) goto L8;
        TextPaint r1 = r9.getPaint();
        int r3 = r0.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L8;
        io.noties.markwon.core.spans.r r5 = r0[r4];
        r5.d = (int) (r1.measureText(r5.b) + 0.5f);
        r4 = r4 + 1;
    L8:
        if ((r10 instanceof Spannable) == false) goto L18;
        Spannable r11 = (Spannable) r10;
        v[] r2 = (v[]) r11.getSpans(0, r11.length(), v.class);
        if (r2 == null) goto L14;
        int r6 = r2.length;
        int r7 = 0;
    L12:
        if (r7 >= r6) goto L14;
        r11.removeSpan(r2[r7]);
        r7 = r7 + 1;
    L14:
        r11.setSpan(new v(r9), 0, r11.length(), 18);
        return;
    }

    @Override // lsc.a, lsc.j
    public void a(TextView r3, uvc.b r4, lsc.p r5) {
        s r6 = r5.a.a;
        float r7 = r6.i;
        if (r7 == 1.0f) goto L5;
    L6:
        r5.o(0, new io.noties.markwon.core.spans.l(r7, r6.j));
        return;
    L5:
        if (r6.j != 1.0f) goto L6;
    }

    @Override // lsc.a, lsc.j
    public void d(CharSequence r3, uvc.b r4, lsc.p r5) {
        s r6 = r5.a.a;
        float r7 = r6.i;
        if (r7 == 1.0f) goto L5;
    L6:
        r5.o(0, new io.noties.markwon.core.spans.l(r7, r6.j));
        return;
    L5:
        if (r6.j != 1.0f) goto L6;
    }

    public static void n(lsc.m r5, String r6, String r7, uvc.b r8) {
        r5.C(r8);
        int r0 = r5.length();
        y r1 = r5.builder();
        r1.a.append(160);
        r1.a.append('\n');
        r1.b(r5.B().b.a(r6, r7));
        r5.a();
        r5.builder().a(160);
        CoreProps.k.c(r5.r(), r6);
        r5.G(r8, r0);
        r5.q(r8);
    }
}
