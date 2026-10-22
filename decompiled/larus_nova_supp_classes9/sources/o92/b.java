package o92;

import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.livesdk.interactivity.pin.ui.HighlightViewPager;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public Disposable a;
    public final ViewPager b;
    public final long c;
    public final boolean d;
    public final boolean e;

    public b(HighlightViewPager r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "viewPager");
        this.b = r2;
        this.c = r3;
        this.d = false;
        this.e = true;
    }
}
