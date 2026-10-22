package io.noties.markwon.inlineparser;

import androidx.core.net.MailTo;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import org.commonmark.node.Link;
import org.commonmark.node.Node;
import org.commonmark.node.Text;

/* JADX INFO: loaded from: classes6.dex */
public class a extends i {
    private static final Pattern e = null;
    private static final Pattern f = null;

    static {
        e = Pattern.compile("^<([a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*)>");
        f = Pattern.compile("^<[a-zA-Z][a-zA-Z0-9.+-]{1,31}:[^<>\u0000- ]*>");
    }

    public a() {
    }

    @Override // io.noties.markwon.inlineparser.i
    public char a() {
        return Typography.less;
    }

    @Override // io.noties.markwon.inlineparser.i
    public Node b() {
        String r0 = a(e);
        if (r0 == null) goto L7;
        String r4 = r0.substring(1, r0.length() - 1);
        Link r1 = new Link(MailTo.MAILTO_SCHEME + r4, null);
        Text r2 = new Text(r4);
    L5:
        r1.appendChild(r2);
        return r1;
    L7:
        String r5 = a(f);
        if (r5 == null) goto L10;
        String r6 = r5.substring(1, r5.length() - 1);
        r1 = new Link(r6, null);
        r2 = new Text(r6);
        goto L5
    L10:
        return null;
    }
}
