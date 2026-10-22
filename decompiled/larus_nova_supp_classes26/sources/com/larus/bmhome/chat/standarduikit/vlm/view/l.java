package com.larus.bmhome.chat.standarduikit.vlm.view;

import android.util.Size;
import com.larus.bmhome.chat.markdown.vlm.FlowVLMContainerViewType;
import com.larus.bmhome.chat.markdown.vlm.RenderType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class l {
    public final String a;
    public final String b;
    public final Size c;
    public final String d;
    public final Integer e;
    public final String f;
    public final String g;
    public final RenderType h;
    public final c i;
    public final FlowVLMContainerViewType j;
    public final boolean k;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof l) == true) goto L8;
        return false;
    L8:
        l r6 = (l) r5;
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (this.k == r6.k) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        Size r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Integer r8 = this.e;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.f;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.g;
        if (r14 == null) goto L22;
        r2 = r14.hashCode();
    L22:
        int r15 = (((((((r13 + r2) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31;
        if (this.k == false) goto L25;
        int r16 = 1231;
    L27:
        return r15 + r16;
    L25:
        r16 = 1237;
        goto L27
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "VlmRenderInfo(messageId=" + this.a + ", cardId=" + this.b + ", itemViewSize=" + this.c + ", descriptionTitle=" + this.d + ", moreImageSize=" + this.e + ", sourceIconUrl=" + this.f + ", coverUrl=" + this.g + ", renderType=" + this.h + ", originData=" + this.i + ", containerViewType=" + this.j + ", isInVideoGroup=" + this.k + ')';
    }

    public l(String r2, String r3, Size r4, String r5, Integer r6, String r7, String r8, RenderType r9, c r10, FlowVLMContainerViewType r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        Intrinsics.checkNotNullParameter(r3, "cardId");
        Intrinsics.checkNotNullParameter(r9, "renderType");
        Intrinsics.checkNotNullParameter(r10, "originData");
        Intrinsics.checkNotNullParameter(r11, "containerViewType");
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
