package com.ss.android.lark.commonmark.internal;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Pattern;
import v7b.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k extends y7b.a {
    public static final Pattern[][] e = null;
    public final v7b.j a;
    public final Pattern b;
    public boolean c;
    public com.ss.android.lark.commonmark.internal.a d;

    public static class a extends y7b.b {
        public a() {
        }

        @Override // y7b.e
        public final d a(y7b.g r9, h.a r10) {
            h r11 = (h) r9;
            int r0 = r11.f;
            CharSequence r1 = r11.a.a;
            if (r11.h < 4) goto L5;
            return null;
        L5:
            if (r1.charAt(r0) != '<') goto L27;
            int r3 = 1;
        L8:
            if (r3 > 7) goto L28;
            if (r3 == 7) goto L11;
        L15:
            Pattern[] r4 = k.e[r3];
            Pattern r6 = r4[0];
            Pattern r5 = r4[1];
            if (r6.matcher(r1.subSequence(r0, r1.length())).find() == false) goto L19;
            d r2 = new d(new y7b.d[]{new k(r5)});
            r2.b = r11.c;
            return r2;
        L19:
            r3 = r3 + 1;
            goto L8
        L11:
            if ((r10.a.a() instanceof v) == true) goto L19;
            if (r11.h().b() == false) goto L15;
        L28:
            return null;
        L27:
            return null;
        }
    }

    static {
        e = new Pattern[][]{new Pattern[]{null, null}, new Pattern[]{PatternProtector.compile("^<(?:script|pre|style|textarea)(?:\\s|>|$)", 2), PatternProtector.compile("</(?:script|pre|style|textarea)>", 2)}, new Pattern[]{PatternProtector.compile("^<!--"), PatternProtector.compile("-->")}, new Pattern[]{PatternProtector.compile("^<[?]"), PatternProtector.compile("\\?>")}, new Pattern[]{PatternProtector.compile("^<![A-Z]"), PatternProtector.compile(">")}, new Pattern[]{PatternProtector.compile("^<!\\[CDATA\\["), PatternProtector.compile("\\]\\]>")}, new Pattern[]{PatternProtector.compile("^</?(?:address|article|aside|base|basefont|blockquote|body|caption|center|col|colgroup|dd|details|dialog|dir|div|dl|dt|fieldset|figcaption|figure|footer|form|frame|frameset|h1|h2|h3|h4|h5|h6|head|header|hr|html|iframe|legend|li|link|main|menu|menuitem|nav|noframes|ol|optgroup|option|p|param|search|section|summary|table|tbody|td|tfoot|th|thead|title|tr|track|ul)(?:\\s|[/]?[>]|$)", 2), null}, new Pattern[]{PatternProtector.compile("^(?:<[A-Za-z][A-Za-z0-9-]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-]*\\s*[>])\\s*$", 2), null}};
    }

    @Override // y7b.a, y7b.d
    public final void c() {
        v7b.j r0 = this.a;
        this.d.a.getClass();
        r0.getClass();
        this.d = null;
    }

    @Override // y7b.d
    public final v7b.a a() {
        return this.a;
    }

    public k(Pattern r2) {
        this.a = new v7b.j();
        this.c = false;
        this.d = new com.ss.android.lark.commonmark.internal.a();
        this.b = r2;
    }

    @Override // y7b.a, y7b.d
    public final void e(w7b.f r5) {
        com.ss.android.lark.commonmark.internal.a r0 = this.d;
        CharSequence r1 = r5.a;
        if (r0.b == 0) goto L5;
        r0.a.append('\n');
    L5:
        r0.a.append(r1);
        r0.b++;
        Pattern r2 = this.b;
        if (r2 != null) goto L8;
        return;
    L8:
        if (r2.matcher(r5.a).find() == false) goto L12;
        this.c = true;
        return;
    }

    @Override // y7b.d
    public final y7b.c h(y7b.g r3) {
        if (this.c == false) goto L5;
        return null;
    L5:
        h r4 = (h) r3;
        if (r4.i == false) goto L11;
        if (this.b != null) goto L11;
        return null;
    L11:
        return y7b.c.a(r4.c);
    }
}
