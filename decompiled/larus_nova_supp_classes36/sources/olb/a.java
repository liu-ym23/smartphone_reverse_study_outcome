package olb;

import android.os.Looper;
import android.view.View;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.ui.RotateLoadingView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final View a;
    public final c b;
    public final b c;

    /* JADX INFO: renamed from: olb.a$a, reason: collision with other inner class name */
    public static final class C0306a {
    }

    static {
    }

    public final void a() {
        Log.i("LazyLoadingHelper", "hideLoading");
        d.a(this.b);
        d.a(this.c);
        b r0 = this.c;
        if (Looper.getMainLooper() != Looper.myLooper()) goto L5;
        r0.run();
        return;
    L5:
        d.a.post(r0);
    }

    public a(RotateLoadingView r2) {
        Intrinsics.checkNotNullParameter(r2, "loadingView");
        this.a = r2;
        r2.setVisibility(8);
        this.b = new c(this);
        this.c = new b(this);
    }
}
