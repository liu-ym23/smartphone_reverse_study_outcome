package zsc;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.Text;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class m extends i {
    public static final Pattern e = null;

    @Override // zsc.i
    public final char d() {
        return '\n';
    }

    static {
        e = PatternProtector.compile(" *$");
    }

    @Override // zsc.i
    public final uvc.b b() {
        this.d++;
        uvc.b r0 = this.b.c;
        if ((r0 instanceof Text) == false) goto L19;
        Text r1 = (Text) r0;
        if (r1.h.endsWith(" ") == false) goto L19;
        String r2 = r1.h;
        Matcher r3 = e.matcher(r2);
        if (r3.find() == false) goto L9;
        int r4 = r3.end() - r3.start();
    L10:
        if (r4 <= 0) goto L13;
        r1.h = r2.substring(0, r2.length() - r4);
    L13:
        if (r4 < 2) goto L17;
        return new HardLineBreak();
    L17:
        return new SoftLineBreak();
    L9:
        r4 = 0;
    L19:
        return new SoftLineBreak();
    }

    public m() {
    }
}
