package com.larus.bmhome.chat.component.bottom.attachment;

import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.model.action.SuggestedActionScene;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g {
    public final String a;
    public final String b;
    public final a c;
    public final SuggestedActionScene d;
    public final String e;
    public final List<UplinkFileEntity> f;
    public final boolean g;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        a r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (((((((r0 + r2) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        if (this.g == false) goto L9;
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
        return "AlbumEduIntentSuggestSnapshot(conversationId=" + this.a + ", firstImageKey=" + this.b + ", firstImageSource=" + this.c + ", baseScene=" + this.d + ", bizScene=" + this.e + ", attachments=" + this.f + ", useDraft=" + this.g + ')';
    }

    public g(String r2, String r3, a r4, SuggestedActionScene r5, String r6, List<UplinkFileEntity> r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        Intrinsics.checkNotNullParameter(r3, "firstImageKey");
        Intrinsics.checkNotNullParameter(r5, "baseScene");
        Intrinsics.checkNotNullParameter(r6, "bizScene");
        Intrinsics.checkNotNullParameter(r7, "attachments");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
