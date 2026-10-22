package sy1;

import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ View a;

    public c(View r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Unit r3 = (Unit) r2;
        if (this.a.getVisibility() == 0) goto L5;
        return;
    L5:
        if (this.a.getTranslationY() == 0.0f) goto L9;
        UtilityKotlinExtentionsKt.t(this.a);
        return;
    }
}
