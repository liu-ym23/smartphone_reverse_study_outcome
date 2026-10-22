package lwb;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmEndWindowLoadingLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final /* synthetic */ int f = 0;
    public final View a;
    public final ConstraintLayout b;
    public final FrameLayout c;
    public final MmEndWindowLoadingLayout d;
    public final AppCompatImageView e;

    /* JADX INFO: renamed from: lwb.a$a, reason: collision with other inner class name */
    public static final class C0165a {
    }

    static {
    }

    public a(View r3) {
        Intrinsics.checkNotNullParameter(r3, "root");
        this.a = r3;
        ConstraintLayout r0 = r3.findViewById(2131380188);
        if (r0 == null) goto L19;
        this.b = r0;
        View r1 = r3.findViewById(2131393138);
        if (r1 == null) goto L17;
        this.c = (FrameLayout) r1;
        Object r2 = r3.findViewById(2131378982);
        if (r2 == null) goto L15;
        this.d = (MmEndWindowLoadingLayout) r2;
        AppCompatImageView r4 = r3.findViewById(2131389095);
        if (r4 == null) goto L13;
        this.e = r4;
        return;
    L13:
        throw new IllegalStateException("Required view not found, id=2131389095, type=AppCompatImageView");
    L15:
        throw new IllegalStateException("Required view not found, id=2131378982, type=MmEndWindowLoadingLayout");
    L17:
        throw new IllegalStateException("Required view not found, id=2131393138, type=".concat(FrameLayout.class.getSimpleName()));
    L19:
        throw new IllegalStateException("Required view not found, id=2131380188, type=ConstraintLayout");
    }
}
