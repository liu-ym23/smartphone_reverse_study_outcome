package io.noties.markwon.ext.strikethrough;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.l;
import io.noties.markwon.n;
import java.util.Collections;
import org.commonmark.ext.gfm.strikethrough.Strikethrough;
import org.commonmark.ext.gfm.strikethrough.StrikethroughExtension;
import org.commonmark.parser.Parser;

/* JADX INFO: loaded from: classes6.dex */
public class a extends io.noties.markwon.a {
    public a() {
    }

    public static a a() {
        return new a();
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(l.a r3) {
        ((l.a) ZeusTransformUtils.wrapperContextForParams(r3, l.a.class, "com.obric.memorydata.plugin")).a(Strikethrough.class, new AnonymousClass1(this));
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(n.b r3) {
        ((n.b) ZeusTransformUtils.wrapperContextForParams(r3, n.b.class, "com.obric.memorydata.plugin")).a(Strikethrough.class, new AnonymousClass2(this));
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(Parser.Builder r1) {
        r1.extensions(Collections.singleton(StrikethroughExtension.create()));
    }
}
