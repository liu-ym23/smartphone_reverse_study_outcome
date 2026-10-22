package ut0;

import android.view.View;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import io.reactivex.Observable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface a {
    void a(View r1, ProfileCustomSkin.Panel r2, Function0<Unit> r3);

    void b(Function0<Unit> r1);

    void clear();

    void enterWaitFor(Observable<Object> r1);
}
