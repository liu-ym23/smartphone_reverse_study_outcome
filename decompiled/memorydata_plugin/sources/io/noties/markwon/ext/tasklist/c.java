package io.noties.markwon.ext.tasklist;

import android.graphics.drawable.Drawable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.l;
import io.noties.markwon.n;
import org.commonmark.parser.Parser;

/* JADX INFO: loaded from: classes6.dex */
public class c extends io.noties.markwon.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Drawable f16534a;

    private c(Drawable r1) {
        this.f16534a = r1;
    }

    public static c a(int r2, int r3, int r4) {
        return new c(new a(r2, r3, r4));
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(l.a r3) {
        ((l.a) ZeusTransformUtils.wrapperContextForParams(r3, l.a.class, "com.obric.memorydata.plugin")).a(b.class, new g(this.f16534a));
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(n.b r3) {
        ((n.b) ZeusTransformUtils.wrapperContextForParams(r3, n.b.class, "com.obric.memorydata.plugin")).a(b.class, new AnonymousClass1(this));
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(Parser.Builder r1) {
        r1.postProcessor(new d());
    }
}
