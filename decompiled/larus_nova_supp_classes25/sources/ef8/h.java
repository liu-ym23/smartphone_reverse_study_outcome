package ef8;

import android.view.View;
import android.view.ViewTreeObserver;
import com.larus.audio.AudioServiceDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class h implements Function0 {
    public final /* synthetic */ o a;
    public final /* synthetic */ ji8.f b;

    public /* synthetic */ h(o r1, ji8.f r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        o r0 = this.a;
        ji8.f r1 = this.b;
        View r2 = r0.d;
        if (r2 == null) goto L7;
        ViewTreeObserver r3 = r2.getViewTreeObserver();
        if (r3 == null) goto L7;
        r3.removeOnScrollChangedListener(r0.t);
    L7:
        AudioServiceDelegate.a.r0().k(r1);
        r0.b.m().requestDisallowInterceptTouchEvent(false);
        return Unit.INSTANCE;
    }
}
