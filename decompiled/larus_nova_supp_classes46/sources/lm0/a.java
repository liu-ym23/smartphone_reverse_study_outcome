package lm0;

import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class a implements u71.b {
    public Disposable a;
    public final CompositeDisposable b;
    public g71.b c;
    public final DataCenter d;
    public final Long e;
    public final int f;

    /* JADX INFO: renamed from: lm0.a$a, reason: collision with other inner class name */
    public static final class C0232a {
    }

    static {
    }

    public void a() {
        Disposable r0 = this.a;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.b.clear();
    }

    public final void reset() {
        Disposable r0 = this.a;
        if (r0 != null) goto L5;
    L10:
        this.b.clear();
        return;
    L5:
        if ((!r0.isDisposed()) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        r0.dispose();
        goto L10
    }

    public final void c(gm0.a r2) {
        Intrinsics.checkNotNullParameter(r2, "commonCardObserver");
        this.c = r2;
    }

    public final void d(int r5) {
        i r0 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r0 == null) goto L6;
        com.bytedance.android.live.room.api.messagewindow.monitor.c r1 = new com.bytedance.android.live.room.api.messagewindow.monitor.c("livesdk_common_card_trigger");
        r1.b("card_type", Integer.valueOf(r5));
        r1.b("trigger_name", b().getDesc());
        r1.b("trigger_value", this.e);
        Unit r2 = Unit.INSTANCE;
        r0.b(r1.a());
    L6:
        g71.b r3 = this.c;
        if (r3 == null) goto L10;
        r3.a(Integer.valueOf(r5));
        return;
    }

    public a(DataCenter r1, Long r2, int r3) {
        this.d = r1;
        this.e = r2;
        this.f = r3;
        this.b = new CompositeDisposable();
    }
}
