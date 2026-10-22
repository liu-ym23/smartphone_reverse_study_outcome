package nl0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import cqa.e;
import cqa.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends FrameLayout implements e {
    public final LiveDoubleColorBallAnimationView a;

    /* JADX INFO: renamed from: nl0.a$a, reason: collision with other inner class name */
    public static final class C0244a {
    }

    static {
    }

    public final boolean a() {
        return false;
    }

    public final void d(float r1, int r2, int r3) {
    }

    public final void e(h r2, RefreshState r3, RefreshState r4) {
        Intrinsics.checkNotNullParameter(r2, "refreshLayout");
        Intrinsics.checkNotNullParameter(r3, "oldState");
        Intrinsics.checkNotNullParameter(r4, "newState");
    }

    public final void g(SmartRefreshLayout.j r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "kernel");
    }

    public View getView() {
        return this;
    }

    public final void i(h r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "refreshLayout");
    }

    public void setPrimaryColors(int... r2) {
        Intrinsics.checkNotNullParameter(r2, "colors");
    }

    public dqa.b getSpinnerStyle() {
        return dqa.b.d;
    }

    public a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        LiveDoubleColorBallAnimationView r4 = LayoutInflater.from(r3).inflate(2131566644, this, true).findViewById(2131370123);
        this.a = r4;
        if (r4 == null) goto L6;
        r4.setVisibility(0);
        return;
    }

    public final int j(SmartRefreshLayout r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "refreshLayout");
        LiveDoubleColorBallAnimationView r3 = this.a;
        if (r3 == null) goto L7;
        r3.c();
        return 10;
    L7:
        return 10;
    }

    public final void f(h r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "refreshLayout");
        LiveDoubleColorBallAnimationView r4 = this.a;
        if (r4 == null) goto L6;
        r4.b();
        return;
    }

    public final void b(boolean r1, float r2, int r3, int r4, int r5) {
        if (r1 == false) goto L7;
        LiveDoubleColorBallAnimationView r6 = this.a;
        if (r6 == null) goto L8;
        r6.setProgress(r2);
        return;
    L8:
        return;
    }
}
