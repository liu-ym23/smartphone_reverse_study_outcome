package com.larus.bmhome.view.actionbar.edit;

import android.net.Uri;
import com.larus.platform.kmp.chat.TemplateInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class m {
    public final TemplateInfo.TemplateInfo a;
    public final Uri b;

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
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        Uri r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "InstructionPhotoTemplateWrapper(templateInfo=" + this.a + ", localImagePath=" + this.b + ')';
    }

    public m(TemplateInfo.TemplateInfo r2, Uri r3) {
        Intrinsics.checkNotNullParameter(r2, "templateInfo");
        this.a = r2;
        this.b = r3;
    }
}
