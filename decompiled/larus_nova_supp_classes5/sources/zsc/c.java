package zsc;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Pattern;
import org.commonmark.node.Code;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c extends i {
    public static final Pattern e = null;
    public static final Pattern f = null;

    @Override // zsc.i
    public final char d() {
        return '`';
    }

    static {
        e = PatternProtector.compile("`+");
        f = PatternProtector.compile("^`+");
    }

    @Override // zsc.i
    public final uvc.b b() {
        String r0 = a(f);
        if (r0 != null) goto L6;
        return null;
    L6:
        int r1 = this.d;
    L7:
        String r2 = a(e);
        if (r2 == null) goto L24;
        if (r2.equals(r0) == false) goto L7;
        Code r3 = new Code();
        String r4 = this.c.substring(r1, this.d - r0.length()).replace('\n', ' ');
        if (r4.length() < 3) goto L22;
        boolean r5 = false;
        if (r4.charAt(0) != ' ') goto L22;
        if (r4.charAt(r4.length() - 1) != ' ') goto L22;
        int r6 = r4.length();
        if (tvc.d.b(' ', r4, 0, r6) == r6) goto L20;
        r5 = true;
    L20:
        if (r5 == false) goto L22;
        r4 = r4.substring(1, r4.length() - 1);
    L22:
        r3.h = r4;
        return r3;
    L24:
        this.d = r1;
        return f(r0);
    }

    public c() {
    }
}
