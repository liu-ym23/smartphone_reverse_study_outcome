package hob;

import com.ss.android.lark.widget.codeblock.entity.LineContent;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e {
    public static final /* synthetic */ int c = 0;
    public final List<LineContent> a;
    public final RichTextElement.CodeBlockV2Property b;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        RichTextElement.CodeBlockV2Property r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "InsertCodeBlockV2Info(lineContents=" + this.a + ", codeBlockV2Property=" + this.b + ')';
    }

    public e(List<LineContent> r2, RichTextElement.CodeBlockV2Property r3) {
        Intrinsics.checkNotNullParameter(r2, "lineContents");
        this.a = r2;
        this.b = r3;
    }
}
