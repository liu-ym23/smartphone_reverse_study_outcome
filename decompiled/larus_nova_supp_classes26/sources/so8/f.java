package so8;

import android.animation.AnimatorSet;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f {
    public AnimatorSet a;
    public final Handler b;
    public FrameLayout c;
    public ViewGroup d;

    public static final class a {
    }

    static {
    }

    public f() {
        this.b = new Handler(Looper.getMainLooper());
    }
}
