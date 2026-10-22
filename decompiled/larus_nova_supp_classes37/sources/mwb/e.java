package mwb;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.larksuite.component.universe_design.tab.UDTabLayout;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmRecordingNavLayout;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar.MmRecordingTopBarView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e {
    public static final /* synthetic */ int j = 0;
    public final View a;
    public final ViewGroup b;
    public final FrameLayout c;
    public final MmRecordingNavLayout d;
    public final FrameLayout e;
    public final FrameLayout f;
    public final FrameLayout g;
    public MmRecordingTopBarView h;
    public d i;

    public static final class a {
    }

    static {
    }

    public final d c() {
        d r0 = this.i;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("Default middle slot is not attached");
    }

    public final UDTabLayout a() {
        return c().c;
    }

    public final ViewPager2 b() {
        return c().g;
    }

    public e(View r3) {
        Intrinsics.checkNotNullParameter(r3, "root");
        this.a = r3;
        View r0 = r3.findViewById(2131372654);
        if (r0 == null) goto L27;
        this.b = (ViewGroup) r0;
        View r1 = r3.findViewById(2131389107);
        if (r1 == null) goto L25;
        this.c = (FrameLayout) r1;
        View r2 = r3.findViewById(2131380186);
        if (r2 == null) goto L23;
        this.d = (MmRecordingNavLayout) r2;
        View r4 = r3.findViewById(2131388788);
        if (r4 == null) goto L21;
        this.e = (FrameLayout) r4;
        View r5 = r3.findViewById(2131380092);
        if (r5 == null) goto L19;
        this.f = (FrameLayout) r5;
        View r6 = r3.findViewById(2131389064);
        if (r6 == null) goto L17;
        this.g = (FrameLayout) r6;
        return;
    L17:
        throw new IllegalStateException("Required view not found, id=2131389064, type=".concat(FrameLayout.class.getSimpleName()));
    L19:
        throw new IllegalStateException("Required view not found, id=2131380092, type=".concat(FrameLayout.class.getSimpleName()));
    L21:
        throw new IllegalStateException("Required view not found, id=2131388788, type=".concat(FrameLayout.class.getSimpleName()));
    L23:
        throw new IllegalStateException("Required view not found, id=2131380186, type=MmRecordingNavLayout");
    L25:
        throw new IllegalStateException("Required view not found, id=2131389107, type=".concat(FrameLayout.class.getSimpleName()));
    L27:
        throw new IllegalStateException("Required view not found, id=2131372654, type=".concat(ViewGroup.class.getSimpleName()));
    }
}
