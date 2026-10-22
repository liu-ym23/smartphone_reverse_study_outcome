package mh0;

import android.content.Context;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i extends lh0.a {
    public final ih0.b e;

    public static final class a {
    }

    static {
    }

    public i(Context r2, DataCenter r3, com.bytedance.android.live.liveinteract.plantform.dynamicframe.b r4, ih0.b r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "feedDataCenter");
        Intrinsics.checkNotNullParameter(r4, "feedInfoProvider");
        Intrinsics.checkNotNullParameter(r5, "service");
        super(r2, r3, r4);
        this.e = r5;
    }
}
