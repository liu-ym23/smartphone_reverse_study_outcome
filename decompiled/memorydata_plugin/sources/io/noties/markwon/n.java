package io.noties.markwon;

import org.commonmark.node.Node;
import org.commonmark.node.Visitor;

/* JADX INFO: loaded from: classes6.dex */
public interface n extends Visitor {

    public interface a {
        void a(n r1, Node r2);

        void b(n r1, Node r2);
    }

    public interface b {
        b a(a r1);

        <N extends Node> b a(Class<N> r1, c<? super N> r2);

        n a(i r1, t r2);
    }

    public interface c<N extends Node> {
        void a(n r1, N r2);
    }

    i a();

    c<Node> a(Node r1);

    void a(int r1, Object r2);

    <N extends Node> void a(N r1, int r2);

    t b();

    <N extends Node> void b(N r1, int r2);

    x c();

    void c(Node r1);

    void d();

    boolean d(Node r1);

    void e();

    void e(Node r1);

    int f();

    void f(Node r1);
}
