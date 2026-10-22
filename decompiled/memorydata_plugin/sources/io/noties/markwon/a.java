package io.noties.markwon;

import android.text.Spanned;
import android.widget.TextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a implements k {
    public a() {
    }

    @Override // io.noties.markwon.k
    public String a(String r1) {
        return r1;
    }

    @Override // io.noties.markwon.k
    public void a(TextView r1) {
    }

    @Override // io.noties.markwon.k
    public void a(TextView r1, Spanned r2) {
        Spanned r0 = (Spanned) ZeusTransformUtils.wrapperContextForParams(r2, Spanned.class, "com.obric.memorydata.plugin");
    }

    @Override // io.noties.markwon.k
    @Deprecated
    public void a(TextView r1, Node r2) {
        a(r2);
    }

    @Override // io.noties.markwon.k
    @Deprecated
    public void a(TextView r2, Node r3, n r4) {
        a(r3, (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.memorydata.plugin"));
    }

    @Override // io.noties.markwon.k
    public void a(io.noties.markwon.core.c.a r1) {
    }

    @Override // io.noties.markwon.k
    public void a(i.a r1) {
    }

    @Override // io.noties.markwon.k
    public void a(k.b r2) {
        k.b r1 = (k.b) ZeusTransformUtils.wrapperContextForParams(r2, k.b.class, "com.obric.memorydata.plugin");
    }

    @Override // io.noties.markwon.k
    public void a(l.a r2) {
        l.a r1 = (l.a) ZeusTransformUtils.wrapperContextForParams(r2, l.a.class, "com.obric.memorydata.plugin");
    }

    @Override // io.noties.markwon.k
    public void a(n.b r2) {
        n.b r1 = (n.b) ZeusTransformUtils.wrapperContextForParams(r2, n.b.class, "com.obric.memorydata.plugin");
    }

    @Override // io.noties.markwon.k
    public void a(CharSequence r3, Node r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        a(r4);
    }

    @Override // io.noties.markwon.k
    public void a(CharSequence r3, Node r4, n r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        a(r4, (n) ZeusTransformUtils.wrapperContextForParams(r5, n.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated
    public void a(Node r1) {
    }

    @Deprecated
    public void a(Node r1, n r2) {
        n r0 = (n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.memorydata.plugin");
    }

    @Override // io.noties.markwon.k
    public void a(Parser.Builder r1) {
    }
}
