package dob;

import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends com.ss.android.lark.keyboard.edittext2.edittors.richText.a {
    public final boolean y;

    public b() {
        this.y = true;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.richText.a, com.ss.android.lark.keyboard.edittext2.edittors.richText.RichTextEditor
    public final void a(RichText r3) {
        super.a(r3);
        com.ss.android.lark.keyboard.edittext2.base.a r0 = q(com.ss.android.lark.keyboard.edittext2.edittors.a.e);
        if ((r0 instanceof a) == false) goto L5;
        a r1 = (a) r0;
    L6:
        if (r1 == null) goto L11;
        Iterator<T> r2 = r1.f.iterator();
    L9:
        if (r2.hasNext() == false) goto L13;
        ((d) r2.next()).a(r3);
        goto L9
    L13:
        return;
    L11:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.richText.a, com.ss.android.lark.keyboard.edittext2.edittors.richText.RichTextEditor
    public final void b(RichText r3) {
        super.b(r3);
        com.ss.android.lark.keyboard.edittext2.base.a r0 = q(com.ss.android.lark.keyboard.edittext2.edittors.a.e);
        if ((r0 instanceof a) == false) goto L5;
        a r1 = (a) r0;
    L6:
        if (r1 == null) goto L11;
        Iterator<T> r2 = r1.f.iterator();
    L9:
        if (r2.hasNext() == false) goto L13;
        ((d) r2.next()).b(r3);
        goto L9
    L13:
        return;
    L11:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.richText.RichTextEditor
    public final void t(RichTextElement.AtProperty r3, Map<String, String> r4) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (this.y == false) goto L7;
    L10:
        super.t(r3, r4);
        return;
    L7:
        if (Intrinsics.areEqual(r3.getUserId(), "all") == false) goto L10;
        V(r4, r3.getAtContent());
    }
}
