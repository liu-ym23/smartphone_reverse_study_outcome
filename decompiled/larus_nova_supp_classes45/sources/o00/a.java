package o00;

import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    public a() {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(HSImageView r2) {
        Intrinsics.checkNotNullParameter("#1AFFFFFF", "color");
        if (r2 == 0) goto L6;
        r2.setBackgroundColor(ColorProtector.parseColor("#1AFFFFFF"));
        return;
    }
}
