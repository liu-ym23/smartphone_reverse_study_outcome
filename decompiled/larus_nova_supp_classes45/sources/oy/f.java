package oy;

import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.anchormodelink.impl.AnchorModeLinkDynamicWidget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f {
    public final ViewGroup a;
    public final a b;

    public f(ConstraintLayout r2, AnchorModeLinkDynamicWidget.e r3) {
        Intrinsics.checkNotNullParameter(r2, "singleViewContainer");
        Intrinsics.checkNotNullParameter(r3, "callBack");
        this.a = r2;
        this.b = r3;
    }
}
