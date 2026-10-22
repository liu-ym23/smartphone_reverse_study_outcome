package t39;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.larus.dora.impl.guide.service.GuideSession$setStateListener$1;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface l {
    Unit a();

    void b(GuideSession$setStateListener$1 r1);

    Object c(Continuation<? super Boolean> r1);

    Object d(Fragment r1, View r2, Continuation<? super Unit> r3);

    Object e(Fragment r1, View r2, Continuation<? super Unit> r3);

    int f();
}
