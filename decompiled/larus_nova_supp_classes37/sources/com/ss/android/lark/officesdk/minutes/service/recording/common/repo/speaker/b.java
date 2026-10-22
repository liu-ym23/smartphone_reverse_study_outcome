package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public final LinkedHashMap<String, c> a;

    public b() {
        this(0);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "MmEndWindowSpeakerSnapshot(markedSpeakerMap=" + this.a + ')';
    }

    public b(LinkedHashMap<String, c> r2) {
        Intrinsics.checkNotNullParameter(r2, "markedSpeakerMap");
        this.a = r2;
    }

    public /* synthetic */ b(int r1) {
        this(new LinkedHashMap());
    }
}
