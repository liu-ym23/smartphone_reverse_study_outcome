package io.noties.markwon.inlineparser;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.commonmark.parser.Parser;

/* JADX INFO: loaded from: classes6.dex */
public class m extends io.noties.markwon.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j.b f16636a;

    m(j.b r3) {
        this.f16636a = (j.b) ZeusTransformUtils.wrapperContextForParams(r3, j.b.class, "com.obric.memorydata.plugin");
    }

    public static m a() {
        return a(j.a());
    }

    public static m a(j.b r2) {
        return new m((j.b) ZeusTransformUtils.wrapperContextForParams(r2, j.b.class, "com.obric.memorydata.plugin"));
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(Parser.Builder r1) {
        r1.inlineParserFactory(this.f16636a.a());
    }

    public j.b b() {
        return this.f16636a;
    }
}
