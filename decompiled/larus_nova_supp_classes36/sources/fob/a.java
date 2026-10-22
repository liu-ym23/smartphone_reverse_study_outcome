package fob;

import com.ss.android.lark.widget.richtext.RichTextElement;
import hob.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class a<I extends hob.b> implements c<RichTextElement.AnchorProperty, I> {

    /* JADX INFO: renamed from: fob.a$a, reason: collision with other inner class name */
    public static final class C0264a {
    }

    static {
    }

    public abstract boolean a(RichTextElement.AnchorProperty r1);

    public abstract I b(RichTextElement.AnchorProperty r1);

    public a(eob.a r2) {
        Intrinsics.checkNotNullParameter(r2, "editor");
    }

    @Override // fob.c
    public final c.a resolve(RichTextElement.AnchorProperty r3) {
        RichTextElement.AnchorProperty r4 = r3;
        Intrinsics.checkNotNullParameter(r4, "value");
        if (a(r4) == true) goto L6;
        return new c.a();
    L6:
        return new c.a(true, b(r4));
    }
}
