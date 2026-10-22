package kb0;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c extends TextView {

    public static final class a {
    }

    static {
    }

    public c(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        setId(ViewCompat.generateViewId());
        ConstraintLayout.LayoutParams r4 = new ConstraintLayout.LayoutParams(-2, -2);
        r4.topToTop = 0;
        r4.startToStart = 0;
        r4.endToEnd = 0;
        r4.bottomToBottom = 0;
        Unit r1 = Unit.INSTANCE;
        setLayoutParams(r4);
        setVisibility(0);
        setIncludeFontPadding(false);
        setMaxLines(1);
        setGravity(17);
        setTextSize(1, 15.0f);
        a(false);
    }

    public final void a(boolean r1) {
        if (r1 == false) goto L4;
        KtvOrderSongThemeManager.d(this, 10);
        setTypeface(Typeface.defaultFromStyle(1));
        return;
    L4:
        KtvOrderSongThemeManager.d(this, KtvOrderSongThemeManager.a);
        setTypeface(Typeface.defaultFromStyle(0));
    }
}
