package io.noties.markwon.inlineparser;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Node;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.Text;

/* JADX INFO: loaded from: classes6.dex */
public class n extends i {
    private static final Pattern e = null;

    static {
        e = Pattern.compile(" *$");
    }

    public n() {
    }

    @Override // io.noties.markwon.inlineparser.i
    public char a() {
        return '\n';
    }

    @Override // io.noties.markwon.inlineparser.i
    public Node b() {
        this.d++;
        Node r4 = this.f16627b.getLastChild();
        if (ZeusTransformUtils.instanceOf(r4, Text.class) == false) goto L19;
        if (((Text) ZeusTransformUtils.preCheckCast(r4, Text.class, "com.obric.memorydata.plugin")).getLiteral().endsWith(" ") == false) goto L19;
        Text r5 = (Text) ZeusTransformUtils.preCheckCast(r4, Text.class, "com.obric.memorydata.plugin");
        String r0 = r5.getLiteral();
        Matcher r1 = e.matcher(r0);
        if (r1.find() == false) goto L9;
        int r2 = r1.end() - r1.start();
    L10:
        if (r2 <= 0) goto L13;
        r5.setLiteral(r0.substring(0, r0.length() - r2));
    L13:
        if (r2 < 2) goto L17;
        return new HardLineBreak();
    L17:
        return new SoftLineBreak();
    L9:
        r2 = 0;
    L19:
        return new SoftLineBreak();
    }
}
