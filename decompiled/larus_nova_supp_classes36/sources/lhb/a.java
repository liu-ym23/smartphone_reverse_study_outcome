package lhb;

import android.content.Context;
import com.ss.android.lark.flow.feed.status.FlowBackgroundPageStatusView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements cfb.a {
    public a() {
    }

    public final FlowBackgroundPageStatusView create(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        return new FlowBackgroundPageStatusView(r4, null, 0);
    }
}
