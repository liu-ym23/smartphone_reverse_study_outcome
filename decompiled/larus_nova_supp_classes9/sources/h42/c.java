package h42;

import com.bytedance.android.livesdk.interactivity.api.pin.container.PinType;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import g42.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends l<HighlightItem.d> {
    public c(HighlightItem.d r4) {
        Intrinsics.checkNotNullParameter(r4, "im");
        super(PinType.Im, r4, r4.getMessageId());
    }
}
