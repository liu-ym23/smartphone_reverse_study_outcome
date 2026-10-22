package e42;

import com.bytedance.android.livesdk.interactivity.api.pin.container.PinType;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import g42.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends l<HighlightItem.c> {
    public b(HighlightItem.c r4) {
        Intrinsics.checkNotNullParameter(r4, "comment");
        super(PinType.Comment, r4, r4.getMessageId());
    }
}
