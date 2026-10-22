package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.database.ContentObserver;
import android.net.Uri;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class f extends ContentObserver {
    public final String a;
    public final Lazy b;

    public static final class a {
    }

    static {
    }

    public f() {
        Intrinsics.checkNotNullParameter("/location/status", "myPath");
        super(null);
        this.a = "/location/status";
        this.b = LazyKt.lazy(new MatrixEventObserver$myUri$2(this));
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean r2, Uri r3) {
        super.onChange(r2, r3);
        String r4 = "onChange, ignore! uri: [" + r3 + "], registered: [false]";
        int r5 = gka.b.a;
        Intrinsics.checkNotNullParameter("MatrixEventObserver", "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
        bka.a r6 = bka.a.a;
    }
}
