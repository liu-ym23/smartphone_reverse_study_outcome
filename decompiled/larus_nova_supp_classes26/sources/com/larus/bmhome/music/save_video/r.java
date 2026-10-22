package com.larus.bmhome.music.save_video;

import android.content.Context;
import com.larus.bmhome.share.panel.ShareType;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class r {
    public static final String d = null;
    public final Context a;
    public final File b;
    public final q c;

    public static final class a {
    }

    static {
        d = r.class.getSimpleName();
    }

    public r(Context r13, q r14) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "config");
        File r3 = r14.a;
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r3, ShareType.FILE);
        this.a = r13;
        this.b = r3;
        this.c = new q(r3, 0, 0, null, 0, 0.0f, 0, 0, 1022);
        this.c = r14;
    }
}
