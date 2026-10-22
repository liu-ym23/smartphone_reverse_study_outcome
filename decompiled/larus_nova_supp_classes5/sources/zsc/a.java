package zsc;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Pattern;
import org.commonmark.node.Link;
import org.commonmark.node.Text;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a extends i {
    public static final Pattern e = null;
    public static final Pattern f = null;

    @Override // zsc.i
    public final char d() {
        return '<';
    }

    static {
        e = PatternProtector.compile("^<([a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*)>");
        f = PatternProtector.compile("^<[a-zA-Z][a-zA-Z0-9.+-]{1,31}:[^<>\u0000- ]*>");
    }

    @Override // zsc.i
    public final uvc.b b() {
        String r0 = a(e);
        if (r0 == null) goto L6;
        String r1 = r0.substring(1, r0.length() - 1);
        Link r2 = new Link("mailto:" + r1, null);
        r2.b(new Text(r1));
        return r2;
    L6:
        String r3 = a(f);
        if (r3 == null) goto L10;
        String r4 = r3.substring(1, r3.length() - 1);
        Link r5 = new Link(r4, null);
        r5.b(new Text(r4));
        return r5;
    L10:
        return null;
    }

    public a() {
    }
}
