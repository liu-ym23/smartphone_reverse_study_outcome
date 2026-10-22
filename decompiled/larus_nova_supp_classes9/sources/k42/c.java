package k42;

import com.bytedance.android.livesdk.interactivity.api.pin.container.PinType;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import g42.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends l<HighlightItem.f> {
    public c(HighlightItem.f r4) {
        Intrinsics.checkNotNullParameter(r4, "video");
        super(PinType.Video, r4, r4.getMessageId());
    }
}
