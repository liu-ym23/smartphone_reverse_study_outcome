package io.noties.markwon.inlineparser;

import java.util.regex.Pattern;
import org.commonmark.internal.Bracket;
import org.commonmark.internal.util.Escaping;
import org.commonmark.node.Image;
import org.commonmark.node.Link;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes6.dex */
public class e extends i {
    private static final Pattern e = null;

    static {
        e = j.f16629b;
    }

    public e() {
    }

    @Override // io.noties.markwon.inlineparser.i
    public char a() {
        return ']';
    }

    @Override // io.noties.markwon.inlineparser.i
    public Node b() {
        boolean r1 = true;
        this.d++;
        int r0 = this.d;
        Bracket r2 = c();
        if (r2 != null) goto L7;
        return a("]");
    L7:
        if (r2.allowed == true) goto L10;
    L8:
        e();
        return a("]");
    L10:
        String r7 = null;
        if (j() != '(') goto L23;
        this.d++;
        f();
        String r4 = g();
        if (r4 == null) goto L22;
        f();
        if (e.matcher(this.c.substring(this.d - 1, this.d)).matches() == false) goto L17;
        String r5 = h();
        f();
    L19:
        if (j() != ')') goto L21;
        this.d++;
        boolean r8 = true;
    L24:
        if (r8 == true) goto L35;
        int r9 = this.d;
        i();
        int r10 = this.d - r9;
        if (r10 <= 2) goto L29;
        r7 = this.c.substring(r9, r10 + r9);
    L31:
        if (r7 == null) goto L35;
        LinkReferenceDefinition r11 = this.f16626a.b(Escaping.normalizeReference(r7));
        if (r11 == null) goto L35;
        r4 = r11.getDestination();
        r5 = r11.getTitle();
    L36:
        if (r1 == true) goto L38;
        this.d = r0;
        goto L8
    L38:
        if (r2.image == false) goto L40;
        Node r3 = new Image(r4, r5);
    L41:
        Node r6 = r2.node.getNext();
    L42:
        if (r6 == null) goto L44;
        Node r12 = r6.getNext();
        r3.appendChild(r6);
        r6 = r12;
        goto L42
    L44:
        a(r2.previousDelimiter);
        h.a(r3);
        r2.node.unlink();
        e();
        if (r2.image == true) goto L52;
        Bracket r13 = c();
    L47:
        if (r13 == null) goto L52;
        if (r13.image == true) goto L51;
        r13.allowed = false;
    L51:
        r13 = r13.previous;
    L52:
        return r3;
    L40:
        r3 = new Link(r4, r5);
        goto L41
    L29:
        if (r2.bracketAfter == true) goto L31;
        r7 = this.c.substring(r2.index, r0);
    L35:
        r1 = r8;
        goto L36
    L21:
        this.d = r0;
        r8 = false;
        goto L24
    L17:
        r5 = null;
        goto L19
    L22:
        r8 = false;
        r5 = null;
        goto L24
    L23:
        r8 = false;
        r4 = null;
        r5 = null;
        goto L24
    }
}
