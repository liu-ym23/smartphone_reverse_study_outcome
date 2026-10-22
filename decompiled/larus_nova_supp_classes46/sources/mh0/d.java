package mh0;

import android.content.Context;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d extends lh0.a {
    public final String e;

    public d(Context r2, DataCenter r3, com.bytedance.android.live.liveinteract.plantform.dynamicframe.b r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "feedDataCenter");
        Intrinsics.checkNotNullParameter(r4, "feedInfoProvider");
        super(r2, r3, r4);
        this.e = "AudioLayoutFeedDynamicHandler";
    }
}
