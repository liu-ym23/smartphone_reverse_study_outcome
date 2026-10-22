package lr8;

import android.view.View;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileContent;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f {
    public final String a;
    public final View b;
    public final Message c;
    public final NestedFileContent d;
    public final int e;
    public final BaseResourceViewHolder.a f;
    public final a g;
    public final Function3<Message, NestedFileContent, BaseResourceViewHolder.a, Unit> h;
    public final Boolean i;
    public final boolean j;

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
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
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
        int r0 = ((((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31;
        Boolean r1 = this.i;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (r0 + r2) * 31;
        if (this.j == false) goto L9;
        int r4 = 1231;
    L11:
        return r3 + r4;
    L9:
        r4 = 1237;
        goto L11
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "OpenResourceOnClickParams(key=" + this.a + ", view=" + this.b + ", data=" + this.c + ", content=" + this.d + ", position=" + this.e + ", callback=" + this.f + ", delegate=" + this.g + ", refreshCallback=" + this.h + ", forceOpenBigImage=" + this.i + ", preferMessageFileUrl=" + this.j + ')';
    }

    public f(String r2, View r3, Message r4, NestedFileContent r5, int r6, BaseResourceViewHolder.a r7, a r8, Function3<? super Message, ? super NestedFileContent, ? super BaseResourceViewHolder.a, Unit> r9, Boolean r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "data");
        Intrinsics.checkNotNullParameter(r5, "content");
        Intrinsics.checkNotNullParameter(r7, "callback");
        Intrinsics.checkNotNullParameter(r8, "delegate");
        Intrinsics.checkNotNullParameter(r9, "refreshCallback");
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

    public /* synthetic */ f(String r14, View r15, Message r16, NestedFileContent r17, int r18, BaseResourceViewHolder.a r19, a r20, Function3 r21, Boolean r22, boolean r23, int r24) {
        if ((r24 & 256) == 0) goto L5;
        Boolean r11 = Boolean.FALSE;
    L7:
        if ((r24 & 512) == 0) goto L9;
        boolean r12 = false;
    L10:
        this(r14, r15, r16, r17, r18, r19, r20, r21, r11, r12);
        return;
    L9:
        r12 = r23;
        goto L10
    L5:
        r11 = r22;
        goto L7
    }
}
