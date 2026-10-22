package mwb;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewpager2.widget.ViewPager2;
import com.larksuite.component.universe_design.tab.UDTabLayout;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.HideKeyboardLinearLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d {
    public static final /* synthetic */ int h = 0;
    public final HideKeyboardLinearLayout a;
    public final FrameLayout b;
    public final UDTabLayout c;
    public final ImageView d;
    public final View e;
    public final FrameLayout f;
    public final ViewPager2 g;

    public static final class a {
    }

    static {
    }

    public d(HideKeyboardLinearLayout r3) {
        Intrinsics.checkNotNullParameter(r3, "root");
        this.a = r3;
        View r0 = r3.findViewById(2131380194);
        if (r0 == null) goto L27;
        this.b = (FrameLayout) r0;
        UDTabLayout r1 = r3.findViewById(2131380193);
        if (r1 == null) goto L25;
        this.c = r1;
        View r2 = r3.findViewById(2131374778);
        if (r2 == null) goto L23;
        this.d = (ImageView) r2;
        View r4 = r3.findViewById(2131369203);
        if (r4 == null) goto L21;
        this.e = r4;
        View r5 = r3.findViewById(2131381036);
        if (r5 == null) goto L19;
        this.f = (FrameLayout) r5;
        ViewPager2 r6 = r3.findViewById(2131380199);
        if (r6 == null) goto L17;
        this.g = r6;
        return;
    L17:
        throw new IllegalStateException("Required view not found, id=2131380199, type=ViewPager2");
    L19:
        throw new IllegalStateException("Required view not found, id=2131381036, type=".concat(FrameLayout.class.getSimpleName()));
    L21:
        throw new IllegalStateException("Required view not found, id=2131369203, type=".concat(View.class.getSimpleName()));
    L23:
        throw new IllegalStateException("Required view not found, id=2131374778, type=".concat(ImageView.class.getSimpleName()));
    L25:
        throw new IllegalStateException("Required view not found, id=2131380193, type=UDTabLayout");
    L27:
        throw new IllegalStateException("Required view not found, id=2131380194, type=".concat(FrameLayout.class.getSimpleName()));
    }
}
