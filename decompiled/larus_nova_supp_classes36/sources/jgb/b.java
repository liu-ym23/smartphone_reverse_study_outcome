package jgb;

import kotlin.jvm.internal.Intrinsics;
import u2b.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b extends f {
    public b() {
    }

    public final CharSequence d(f5b.b r2) {
        Intrinsics.checkNotNullParameter(r2, "messageInfo");
        return r2.getMessage().getContent().getName();
    }
}
