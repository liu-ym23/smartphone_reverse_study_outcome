package com.larus.bmhome.clarification;

import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import com.larus.im.bean.message.block.InteractionAskOption;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class u implements jc8.l {
    public final int a;
    public final List<String> b;
    public final String c;
    public final boolean d;
    public final int e;
    public final List<ResourceItemBean> f;
    public final boolean g;
    public final Function0<Unit> h;
    public final Function2<Integer, InteractionAskOption, Unit> i;
    public final BaseResourceViewHolder.a j;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof u) == true) goto L8;
        return false;
    L8:
        u r6 = (u) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
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
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        int r2 = 1231;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (((((r0 + r1) * 31) + this.e) * 31) + this.f.hashCode()) * 31;
        if (this.g == true) goto L10;
        r2 = 1237;
    L10:
        int r4 = (((((r3 + r2) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31;
        BaseResourceViewHolder.a r5 = this.j;
        if (r5 != null) goto L13;
        int r6 = 0;
    L15:
        return r4 + r6;
    L13:
        r6 = r5.hashCode();
        goto L15
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "ClarificationBlockPassData(pageIndex=" + this.a + ", selectedOptionIds=" + this.b + ", inputText=" + this.c + ", hasAttachment=" + this.d + ", attachmentCount=" + this.e + ", attachmentItems=" + this.f + ", showCloseButton=" + this.g + ", onCloseClick=" + this.h + ", onOptionClick=" + this.i + ", attachmentCallback=" + this.j + ')';
    }

    public u(int r2, List r3, String r4, boolean r5, int r6, List r7, Function0 r8, Function2 r9, BaseResourceViewHolder.a r10) {
        Intrinsics.checkNotNullParameter(r3, "selectedOptionIds");
        Intrinsics.checkNotNullParameter(r4, "inputText");
        Intrinsics.checkNotNullParameter(r7, "attachmentItems");
        Intrinsics.checkNotNullParameter(r8, "onCloseClick");
        Intrinsics.checkNotNullParameter(r9, "onOptionClick");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = true;
        this.h = r8;
        this.i = r9;
        this.j = r10;
    }
}
