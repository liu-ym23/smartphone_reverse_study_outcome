package io.noties.markwon.inlineparser;

import java.util.regex.Pattern;
import kotlin.text.Typography;
import org.commonmark.internal.util.Html5Entities;
import org.commonmark.node.Node;

/* JADX INFO: loaded from: classes6.dex */
public class f extends i {
    private static final Pattern e = null;

    static {
        e = Pattern.compile("^&(?:#x[a-f0-9]{1,6}|#[0-9]{1,7}|[a-z][a-z0-9]{1,31});", 2);
    }

    public f() {
    }

    @Override // io.noties.markwon.inlineparser.i
    public char a() {
        return Typography.amp;
    }

    @Override // io.noties.markwon.inlineparser.i
    public Node b() {
        String r0 = a(e);
        if (r0 != null) goto L5;
        return null;
    L5:
        return a(Html5Entities.entityToString(r0));
    }
}
