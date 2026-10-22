package com.larus.bmhome.chat.component.bottom.multimodal;

import com.larus.im.bean.message.ReferenceInfo;
import com.larus.platform.model.action.DirectSendData;
import com.larus.platform.model.action.SuggestedAction;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m {
    public final SuggestedAction a;
    public final ReferenceInfo b;
    public final DirectSendData c;
    public final i d;
    public final List<String> e;
    public final boolean f;
    public final String g;

    public m() {
        this(null, null, null, null, false, null, 127);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m) == true) goto L8;
        return false;
    L8:
        m r6 = (m) r5;
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
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        SuggestedAction r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        ReferenceInfo r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        DirectSendData r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        i r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        List<String> r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        if (this.f == false) goto L25;
        int r16 = 1231;
    L26:
        int r17 = (r15 + r16) * 31;
        String r18 = this.g;
        if (r18 == null) goto L31;
        r1 = r18.hashCode();
    L31:
        return r17 + r1;
    L25:
        r16 = 1237;
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "MultimodalBizData(suggestedAction=" + this.a + ", referenceInfo=" + this.b + ", directSendData=" + this.c + ", imageEditData=" + this.d + ", resultSourceData=" + this.e + ", isOriginalImageChecked=" + this.f + ", uploadTaskShareTag=" + this.g + ')';
    }

    public m(SuggestedAction r3, DirectSendData r4, i r5, List r6, boolean r7, String r8, int r9) {
        if ((r9 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r9 & 4) == 0) goto L9;
        r4 = null;
    L9:
        if ((r9 & 8) == 0) goto L12;
        r5 = null;
    L12:
        if ((r9 & 16) == 0) goto L15;
        r6 = null;
    L15:
        if ((r9 & 32) == 0) goto L18;
        r7 = false;
    L18:
        if ((r9 & 64) == 0) goto L20;
        r8 = null;
    L20:
        this.a = r3;
        this.b = null;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
