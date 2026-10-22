package s30;

import com.bytedance.android.live.schema.api.WebcastRedirectReportInfo;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e<T> implements ObservableOnSubscribe {
    public final /* synthetic */ b a;
    public final /* synthetic */ WebcastRedirectReportInfo b;

    public e(b r1, WebcastRedirectReportInfo r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(ObservableEmitter<com.bytedance.android.live.browser.schema.core.c> r5) {
        Intrinsics.checkNotNullParameter(r5, "emitter");
        Object r0 = this.a.b;
        monitor-enter(r0);
        com.bytedance.android.live.browser.schema.core.c r1 = this.a.a;     // Catch: Throwable -> L15
        com.bytedance.android.live.browser.schema.core.c r2 = null;
        if (r1 == null) goto L10;
        if (r1.b.a() == false) goto L9;
        r1 = null;
    L9:
        r2 = r1;
    L10:
        monitor-exit(r0);
        if (r2 == null) goto L13;
        this.b.a("ugsettings_source", "0");
        com.bytedance.android.live.schema.api.utils.a.a("UGSettingsInterceptor", "hit from cache");
        r5.onNext(r2);
    L13:
        r5.onComplete();
        return;
    L15:
        th = move-exception;
        throw th;
    }
}
