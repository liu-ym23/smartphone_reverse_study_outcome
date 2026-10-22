package x62;

import android.widget.TextView;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import io.reactivex.Observable;
import io.reactivex.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends Observable<CharSequence> {
    public final a a;
    public Observer<? super CharSequence> b;
    public final TextView c;

    public c(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "textView");
        this.c = r2;
        a r0 = new a(r2);
        this.a = r0;
        r2.addTextChangedListener(r0);
    }

    public final void subscribeActual(Observer<? super CharSequence> r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.b = r2;
        a r0 = this.a;
        r0.b = r2;
        r2.onSubscribe(r0);
        MainThreadPostUtils.e(new b(this));
    }
}
