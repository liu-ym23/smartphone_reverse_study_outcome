package jj8;

import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.InteractionAskBlock;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f {
    public final Message a;
    public final InteractionAskBlock b;
    public final int c;
    public final List<String> d;
    public final String e;
    public final boolean f;
    public final String g;
    public final boolean h;
    public final int i;
    public final List<ResourceItemBean> j;
    public final boolean k;

    public f() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (this.k == r6.k) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        Message r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        InteractionAskBlock r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        int r5 = (((((((r3 + r1) * 31) + this.c) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        int r6 = 1231;
        if (this.f == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (((r5 + r7) * 31) + this.g.hashCode()) * 31;
        if (this.h == false) goto L17;
        int r9 = 1231;
    L18:
        int r10 = (((((r8 + r9) * 31) + this.i) * 31) + this.j.hashCode()) * 31;
        if (this.k == true) goto L23;
        r6 = 1237;
    L23:
        return r10 + r6;
    L17:
        r9 = 1237;
        goto L18
    L13:
        r7 = 1237;
        goto L14
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "InteractionAskVMData(message=" + this.a + ", interactionAskBlock=" + this.b + ", questionIndex=" + this.c + ", selectedOptionIds=" + this.d + ", inputText=" + this.e + ", allowInputText=" + this.f + ", textPlaceholder=" + this.g + ", hasAttachment=" + this.h + ", attachmentCount=" + this.i + ", attachmentItems=" + this.j + ", showCloseButton=" + this.k + ')';
    }

    public /* synthetic */ f(int r13) {
        this(null, null, 0, CollectionsKt.emptyList(), "", false, "", false, 0, CollectionsKt.emptyList(), true);
    }

    public f(Message r2, InteractionAskBlock r3, int r4, List<String> r5, String r6, boolean r7, String r8, boolean r9, int r10, List<ResourceItemBean> r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r5, "selectedOptionIds");
        Intrinsics.checkNotNullParameter(r6, "inputText");
        Intrinsics.checkNotNullParameter(r8, "textPlaceholder");
        Intrinsics.checkNotNullParameter(r11, "attachmentItems");
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
        this.k = r12;
    }
}
