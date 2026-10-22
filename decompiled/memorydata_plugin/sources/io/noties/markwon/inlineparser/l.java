package io.noties.markwon.inlineparser;

import java.util.regex.Pattern;
import org.commonmark.internal.Bracket;
import org.commonmark.internal.Delimiter;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.node.Node;
import org.commonmark.node.Text;

/* JADX INFO: loaded from: classes6.dex */
public interface l {
    String a(Pattern r1);

    Text a(String r1);

    Text a(String r1, int r2, int r3);

    void a(int r1);

    void a(Bracket r1);

    void a(Delimiter r1);

    char b();

    LinkReferenceDefinition b(String r1);

    Node c();

    String d();

    int e();

    Bracket f();

    Delimiter g();

    void h();

    void i();

    String j();

    String k();

    int l();
}
