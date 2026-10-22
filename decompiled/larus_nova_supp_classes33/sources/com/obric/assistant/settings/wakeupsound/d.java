package com.obric.assistant.settings.wakeupsound;

import com.obric.assistant.WakeupSoundEffectSettings;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d {
    public final String a;
    public final List<h> b;
    public final String c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
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
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "ObricWakeupSoundEffectUiState(pageName=" + this.a + ", rows=" + this.b + ", playingValue=" + this.c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(String r2, List<? extends h> r3, @WakeupSoundEffectSettings String r4) {
        Intrinsics.checkNotNullParameter(r2, "pageName");
        Intrinsics.checkNotNullParameter(r3, "rows");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public static d a(d r2, List r3, String r4, int r5) {
        if ((r5 & 1) == 0) goto L5;
        String r0 = r2.a;
    L7:
        if ((r5 & 2) == 0) goto L10;
        r3 = r2.b;
    L10:
        if ((r5 & 4) == 0) goto L12;
        r4 = r2.c;
    L12:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r0, "pageName");
        Intrinsics.checkNotNullParameter(r3, "rows");
        return new d(r0, r3, r4);
    L5:
        r0 = null;
        goto L7
    }
}
