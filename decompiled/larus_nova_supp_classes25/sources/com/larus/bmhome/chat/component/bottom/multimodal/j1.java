package com.larus.bmhome.chat.component.bottom.multimodal;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.platform.model.action.SuggestedAction;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j1 {
    public final wc9.e a;
    public final ic8.n0 b;
    public final boolean c;
    public final String d;
    public final String e;
    public final String f;
    public final Function1<Message, Function1<mr9.k, Unit>> g;
    public Map<String, String> h;
    public final SuggestedAction i;
    public final Pair<String, Integer> j;
    public final ReferenceInfo k;
    public final ChatPageContext l;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j1) == true) goto L8;
        return false;
    L8:
        j1 r6 = (j1) r5;
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
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (((r0 + r1) * 31) + this.d.hashCode()) * 31;
        String r3 = this.e;
        int r4 = 0;
        if (r3 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((((r2 + r5) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        Map<String, String> r7 = this.h;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        SuggestedAction r10 = this.i;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Pair<String, Integer> r13 = this.j;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        ReferenceInfo r16 = this.k;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        ChatPageContext r19 = this.l;
        if (r19 == null) goto L31;
        r4 = r19.hashCode();
    L31:
        return r18 + r4;
    L25:
        r17 = r16.hashCode();
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
        r5 = r3.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "TryUploadFileOrImgParam(conversation=" + this.a + ", uploadResult=" + this.b + ", isImage=" + this.c + ", fromScene=" + this.d + ", botId=" + this.e + ", fileIdentifier=" + this.f + ", processCallback=" + this.g + ", ext=" + this.h + ", suggestedAction=" + this.i + ", inputContent=" + this.j + ", referenceInfo=" + this.k + ", chatPageContext=" + this.l + ')';
    }

    public j1(wc9.e r2, ic8.n0 r3, String r4, String r5, String r6, Function1 r7, Map r8, SuggestedAction r9, Pair r10, ReferenceInfo r11, ChatPageContext r12) {
        Intrinsics.checkNotNullParameter(r2, "conversation");
        Intrinsics.checkNotNullParameter(r3, "uploadResult");
        Intrinsics.checkNotNullParameter(r4, "fromScene");
        Intrinsics.checkNotNullParameter(r6, "fileIdentifier");
        Intrinsics.checkNotNullParameter(r7, "processCallback");
        this.a = r2;
        this.b = r3;
        this.c = true;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = r12;
    }
}
