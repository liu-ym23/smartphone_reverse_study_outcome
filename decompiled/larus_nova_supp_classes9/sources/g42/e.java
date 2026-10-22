package g42;

import android.view.View;
import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface e {

    public static final class a {
        public static void a(c r1, HighlightItem r2) {
            Intrinsics.checkNotNullParameter(r1, "pinContainer");
            Intrinsics.checkNotNullParameter(r2, "item");
        }

        public static void update(e r0, c r1, HighlightItem r2) {
            Intrinsics.checkNotNullParameter(r1, "pinContainer");
            Intrinsics.checkNotNullParameter(r2, "highlightItem");
        }
    }

    void a(HighlightItem r1);

    void b(c r1, HighlightItem r2);

    void c(DataCenter r1, c r2, HighlightItem r3);

    int getContentHeight();

    int getMinHeight();

    View getView();

    void update(c r1, HighlightItem r2);
}
