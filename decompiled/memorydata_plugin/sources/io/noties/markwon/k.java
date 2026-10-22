package io.noties.markwon;

import android.text.Spanned;
import android.widget.TextView;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;

/* JADX INFO: loaded from: classes6.dex */
public interface k {

    public interface a<P extends k> {
        void a(P r1);
    }

    public interface b {
        <P extends k> P a(Class<P> r1);

        <P extends k> void a(Class<P> r1, a<? super P> r2);
    }

    String a(String r1);

    void a(TextView r1);

    void a(TextView r1, Spanned r2);

    void a(TextView r1, Node r2);

    void a(TextView r1, Node r2, n r3);

    void a(io.noties.markwon.core.c.a r1);

    void a(i.a r1);

    void a(b r1);

    void a(l.a r1);

    void a(n.b r1);

    void a(CharSequence r1, Node r2);

    void a(CharSequence r1, Node r2, n r3);

    void a(Parser.Builder r1);
}
