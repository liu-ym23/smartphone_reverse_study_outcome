package com.larus.bmhome.music.save_video;

import com.larus.bmhome.share.panel.ShareType;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class t {
    public final File a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof t) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((t) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "MuxingSuccess(file=" + this.a + ')';
    }

    public t(File r2) {
        Intrinsics.checkNotNullParameter(r2, ShareType.FILE);
        this.a = r2;
    }
}
