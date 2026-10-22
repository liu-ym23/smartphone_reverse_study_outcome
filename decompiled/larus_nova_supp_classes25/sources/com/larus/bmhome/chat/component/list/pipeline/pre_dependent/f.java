package com.larus.bmhome.chat.component.list.pipeline.pre_dependent;

import com.larus.extension.offline_message.api.OfflineMessageServiceDelegate;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f implements td8.c {
    public final td8.d a;

    public static final class a {
    }

    static {
    }

    @Override // td8.c
    public final boolean a(int r1, xc8.b r2, xc8.b r3, List<? extends xc8.b> r4) {
        Intrinsics.checkNotNullParameter(r3, "current");
        Intrinsics.checkNotNullParameter(r4, "input");
        return true;
    }

    public f(td8.d r2) {
        Intrinsics.checkNotNullParameter(r2, "taskContextTask");
        this.a = r2;
    }

    @Override // td8.c
    public final List<xc8.b> b(int r1, xc8.b r2, xc8.b r3, List<xc8.b> r4) {
        Intrinsics.checkNotNullParameter(r3, "current");
        Intrinsics.checkNotNullParameter(r4, "input");
        OfflineMessageServiceDelegate.b.d(this.a.o());
        return r4;
    }
}
