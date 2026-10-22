package v19;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.larus.bmhome.bot.m4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b6 implements View.OnClickListener {
    public final int a;
    public final View.OnClickListener b;
    public final Handler c;
    public final a6 d;
    public int e;

    /* JADX WARN: Type inference failed for: r2v2, types: [v19.a6] */
    public b6(m4 r2) {
        Intrinsics.checkNotNullParameter(r2, "origin");
        this.a = 2;
        this.b = r2;
        this.c = new Handler(Looper.getMainLooper());
        this.d = new a6(this);
        this.e = 1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        int r0 = this.e;
        if (r0 < this.a) goto L5;
        this.c.removeCallbacks(this.d);
        this.e = 1;
        this.b.onClick(r4);
        return;
    L5:
        this.e = r0 + 1;
        this.c.removeCallbacks(this.d);
        this.c.postDelayed(this.d, 500);
    }
}
