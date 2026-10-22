package v81;

import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.livesdk.config.f31;
import com.bytedance.android.livesdk.config.setting.j;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import u81.f;
import zg1.s0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b extends v81.a {
    public static final long e = 0;
    public Disposable b;
    public Disposable c;
    public Disposable d;

    public static final class a {
    }

    /* JADX INFO: renamed from: v81.b$b, reason: collision with other inner class name */
    public static final class C0334b<T> implements Consumer {
        public final /* synthetic */ b a;

        public C0334b(b r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            String r3 = (String) r2;
            Iterator r4 = ((ArrayList) this.a.a).iterator();
        L4:
            if (r4.hasNext() == false) goto L8;
            f.a r0 = (f.a) r4.next();
            if (r0 == null) goto L4;
            r0.a();
            goto L4
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ b a;

        public c(b r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            s0 r4 = (s0) r3;
            int r0 = r4.a;
            if (r0 == 0) goto L11;
            if (r0 != 1) goto L21;
            Disposable r5 = this.a.d;
            if (r5 == null) goto L18;
            r5.dispose();
            return;
        L18:
            return;
        L21:
            return;
        L11:
            if (r4.b != 0) goto L16;
            b r6 = this.a;
            Disposable r1 = r6.d;
            if (r1 == null) goto L15;
            r1.dispose();
        L15:
            r6.d = Observable.just("").observeOn(AndroidSchedulers.mainThread()).subscribe(new v81.c(r6));
            return;
        L16:
            this.a.e();
        }
    }

    public static final class d implements Action {
        public final /* synthetic */ b a;

        public d(b r1) {
            this.a = r1;
        }

        public final void run() {
            b r0 = this.a;
            Disposable r1 = r0.c;
            if (r1 == null) goto L5;
            r1.dispose();
        L5:
            Disposable r2 = r0.d;
            if (r2 == null) goto L8;
            r2.dispose();
        L8:
            Disposable r3 = r0.b;
            if (r3 == null) goto L12;
            r3.dispose();
            return;
        }
    }

    static {
        int r0 = j.a;
        e = ((f31) LiveInfraSettingKeys.LIVE_FLOW_STIMULATE_CONFIG.getValue()).loopTimeInterval;
    }

    public final void e() {
        Disposable r0 = this.d;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.d = Observable.just("").delay(e, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new C0334b(this));
    }

    public final Disposable f() {
        Disposable r0 = this.c;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Disposable r1 = this.d;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        Disposable r2 = this.b;
        if (r2 == null) goto L11;
        r2.dispose();
    L11:
        e();
        this.c = xs2.b.a().b(s0.class).subscribe(new c(this));
        Disposable r3 = Disposables.fromAction(new d(this));
        this.b = r3;
        return r3;
    }

    public b() {
    }
}
