package ij8;

import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.im.bean.message.block.InteractionAskOption;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class p {
    public final String a;
    public final int b;
    public final List<InteractionAskOption> c;
    public final List<String> d;
    public final boolean e;
    public final String f;
    public final boolean g;
    public final int h;
    public final List<ResourceItemBean> i;
    public final boolean j;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof p) == true) goto L8;
        return false;
    L8:
        p r6 = (p) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        int r2 = 1231;
        if (this.e == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (((r0 + r1) * 31) + this.f.hashCode()) * 31;
        if (this.g == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (((((r3 + r4) * 31) + this.h) * 31) + this.i.hashCode()) * 31;
        if (this.j == true) goto L15;
        r2 = 1237;
    L15:
        return r5 + r2;
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "InteractionAskViewInput(title=" + this.a + ", questionType=" + this.b + ", options=" + this.c + ", selectedOptionIds=" + this.d + ", allowInputText=" + this.e + ", textPlaceholder=" + this.f + ", hasAttachment=" + this.g + ", attachmentCount=" + this.h + ", attachmentItems=" + this.i + ", showCloseButton=" + this.j + ')';
    }

    public p() {
        this("", 0, CollectionsKt.emptyList(), CollectionsKt.emptyList(), false, "", false, 0, CollectionsKt.emptyList(), true);
    }

    public p(String r2, int r3, List<InteractionAskOption> r4, List<String> r5, boolean r6, String r7, boolean r8, int r9, List<ResourceItemBean> r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r4, "options");
        Intrinsics.checkNotNullParameter(r5, "selectedOptionIds");
        Intrinsics.checkNotNullParameter(r7, "textPlaceholder");
        Intrinsics.checkNotNullParameter(r10, "attachmentItems");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
    }
}
