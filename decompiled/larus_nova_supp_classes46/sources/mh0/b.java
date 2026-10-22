package mh0;

import android.content.Context;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends lh0.a {
    public final String e;
    public final com.bytedance.android.live.liveinteract.plantform.dynamicframe.c f;

    public b(Context r2, DataCenter r3, com.bytedance.android.live.liveinteract.plantform.dynamicframe.b r4, com.bytedance.android.live.liveinteract.plantform.dynamicframe.c r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "feedDataCenter");
        Intrinsics.checkNotNullParameter(r4, "feedInfoProvider");
        super(r2, r3, r4);
        this.f = r5;
        this.e = "AudioChatStageFeedDynamicHandler";
    }
}
