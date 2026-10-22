package v19;

import android.view.View;
import android.view.ViewTreeObserver;
import com.bytedance.services.apm.api.EnsureManager;
import kotlin.Result;
import kotlin.Unit;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h7 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ i<Unit> b;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        i<Unit> r0 = this.b;     // Catch: Exception -> L5
        Result.Companion r1 = Result.Companion;     // Catch: Exception -> L5
        r0.resumeWith(Result.constructor-impl(Unit.INSTANCE));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        EnsureManager.ensureNotReachHere("View.awaitNextLayout: " + e.getMessage());
    }

    public h7(View r1, j r2) {
        this.a = r1;
        this.b = r2;
    }
}
