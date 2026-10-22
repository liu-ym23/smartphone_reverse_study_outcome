package cq8;

import com.larus.bmhome.instruction.core.model.widget.TranslatorSelectorType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class w0 extends y {
    public final String b;
    public final TranslatorSelectorType c;
    public final long d;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof w0) == true) goto L8;
        return false;
    L8:
        w0 r9 = (w0) r8;
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L12;
        return false;
    L12:
        if (this.c == r9.c) goto L15;
        return false;
    L15:
        if (this.d == r9.d) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.b.hashCode() * 31) + this.c.hashCode()) * 31;
        long r1 = this.d;
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
    }

    public final String toString() {
        return "TranslatorLanguageSelectAction(widgetId=" + this.b + ", selectorType=" + this.c + ", optionId=" + this.d + ')';
    }

    @Override // cq8.y
    public final String a() {
        return this.b;
    }

    public w0(String r2, TranslatorSelectorType r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "widgetId");
        Intrinsics.checkNotNullParameter(r3, "selectorType");
        super("TranslatorLanguageSelectAction");
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
