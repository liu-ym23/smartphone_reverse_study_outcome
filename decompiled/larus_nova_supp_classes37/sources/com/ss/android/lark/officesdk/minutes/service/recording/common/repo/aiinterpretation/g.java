package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g {
    public final String a;
    public final String b;
    public final String c;

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
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "MmAIInterpretationLanguage(languageType=" + this.a + ", description=" + this.b + ", icon=" + this.c + ')';
    }

    public g(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "languageType");
        Intrinsics.checkNotNullParameter(r3, "description");
        Intrinsics.checkNotNullParameter(r4, AppbrandHostConstants.Schema_Meta.ICON);
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
