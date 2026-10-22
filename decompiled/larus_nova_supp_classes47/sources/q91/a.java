package q91;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.bytedance.android.live.room.navi.userinfo_p.flipper.core.f;
import kotlin.jvm.internal.Intrinsics;
import w91.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements c {

    /* JADX INFO: renamed from: q91.a$a, reason: collision with other inner class name */
    public static final class C0301a {
    }

    static {
    }

    public a() {
    }

    @Override // w91.c
    public final void a() {
    }

    @Override // w91.c
    public final void b() {
    }

    @Override // w91.c
    public final Animation c() {
        TranslateAnimation r9 = new TranslateAnimation(0, 0.0f, 0, 0.0f, 1, 0.0f, 2, -1.0f);
        r9.setDuration(300);
        r9.setFillAfter(true);
        return r9;
    }

    @Override // w91.c
    public final Animation d() {
        TranslateAnimation r9 = new TranslateAnimation(0, 0.0f, 0, 0.0f, 2, 1.0f, 1, 0.0f);
        r9.setDuration(300);
        r9.setFillAfter(true);
        return r9;
    }

    public final void e(View r3, f r4) {
        Intrinsics.checkNotNullParameter(r3, "enterView");
        Intrinsics.checkNotNullParameter(r4, "listener");
        Intrinsics.checkNotNullParameter(r3, "enterView");
        Intrinsics.checkNotNullParameter(r4, "listener");
    }
}
