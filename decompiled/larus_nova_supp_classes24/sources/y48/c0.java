package y48;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleCoroutineScope;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface c0 extends n {
    void b(View r1);

    View c(Context r1, FrameLayout r2);

    boolean d(CoroutineScope r1, View r2, byte[] r3);

    void f(LifecycleCoroutineScope r1, View r2);

    void g(View r1, FrameLayout r2);
}
