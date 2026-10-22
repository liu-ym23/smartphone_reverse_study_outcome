package zsc;

import java.util.regex.Pattern;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Text;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b extends i {
    public static final Pattern e = null;

    @Override // zsc.i
    public final char d() {
        return '\\';
    }

    static {
        e = j.n;
    }

    @Override // zsc.i
    public final uvc.b b() {
        this.d++;
        if (c() != '\n') goto L6;
        HardLineBreak r0 = new HardLineBreak();
        this.d++;
        return r0;
    L6:
        if (this.d >= this.c.length()) goto L11;
        Pattern r1 = e;
        String r2 = this.c;
        int r3 = this.d;
        if (r1.matcher(r2.substring(r3, r3 + 1)).matches() == false) goto L11;
        String r4 = this.c;
        int r5 = this.d;
        ((j) this.a).getClass();
        Text r6 = new Text(r4.substring(r5, r5 + 1));
        this.d++;
        return r6;
    L11:
        return f("\\");
    }

    public b() {
    }
}
