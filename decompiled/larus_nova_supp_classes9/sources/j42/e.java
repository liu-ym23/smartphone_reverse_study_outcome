package j42;

import com.bytedance.android.livesdk.interactivity.api.pin.container.PinType;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import g42.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e extends l<HighlightItem.a> {
    public e(HighlightItem.a r4) {
        Intrinsics.checkNotNullParameter(r4, "answer");
        super(PinType.Answer, r4, r4.b());
    }
}
