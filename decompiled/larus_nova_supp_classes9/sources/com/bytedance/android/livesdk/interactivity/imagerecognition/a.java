package com.bytedance.android.livesdk.interactivity.imagerecognition;

import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionEntry;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public final int a;
    public final ImageRecognitionEntry b;
    public final String c;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L12;
        a r4 = (a) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        ImageRecognitionEntry r1 = this.b;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.c;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        return r4 + r2;
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "ImageRecognitionEvent(scene=" + this.a + ", entry=" + this.b + ", btmToken=" + this.c + ")";
    }

    public a(int r2, ImageRecognitionEntry r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "entry");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
