package yha;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.window.WindowOpenSource;
import com.obric.assistant.util.n1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class v implements wga.b {
    public final /* synthetic */ t a;

    public final void onScreenRotationChanged(int r1, int r2) {
    }

    public final void onWindowDismissed() {
    }

    public final void onWindowPreDismissed() {
    }

    public final void onWindowPreOpenClear() {
    }

    public final void onWindowPreStashed() {
    }

    public final void onWindowStashed() {
    }

    public v(t r1) {
        this.a = r1;
    }

    public final void onWindowOpened(WindowOpenSource r6) {
        Intrinsics.checkNotNullParameter(r6, "source");
        t r0 = this.a;
        long r1 = r0.r;
        r0.b("windowOpened:" + r6);
        if (r6 == WindowOpenSource.OPEN) goto L5;
        return;
    L5:
        if (r1 != Long.MAX_VALUE) goto L7;
        return;
    L7:
        if (r1 != this.a.d) goto L17;
        FLogger.a.i("ObricPageAutoIncreaseHelper", "onWindowOpened consume pending auto increase height, msgCreateTime = " + r1);
        t r7 = this.a;
        r7.w();
        RecyclerView r2 = r7.f();
        if (r2 == null) goto L19;
        FLogger.a.i("ObricPageAutoIncreaseHelper", "refreshCurrentHeightForAutoIncrease, reason = windowOpened");
        n1 r8 = r7.f;
        if (r8 == null) goto L18;
        r8.b(r2);
        return;
    L18:
        return;
    L19:
        return;
    }

    public final void onWindowPreOpened(WindowOpenSource r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
    }
}
