package sa2;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.test.c;
import f52.d;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements d {
    public f52.b a;
    public final CompositeDisposable b;
    public final String c;

    public static final class a {
    }

    /* JADX INFO: renamed from: sa2.b$b, reason: collision with other inner class name */
    public static final class C0279b<T> implements Consumer {
        public final /* synthetic */ f52.b a;

        public C0279b(f52.b r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            this.a.a(new sa2.a((c) r3));
        }
    }

    static {
    }

    @Override // f52.d
    public final void onUnload() {
        ALogger.i("TestPSTopViewManager", "onUnload");
        this.b.clear();
    }

    public b() {
        this.b = new CompositeDisposable();
        this.c = "TestPSTopViewManager";
    }

    @Override // f52.d
    public final String getId() {
        return this.c;
    }

    @Override // f52.d
    public final void j(f52.b r3) {
        Intrinsics.checkNotNullParameter(r3, "container");
        ALogger.i("TestPSTopViewManager", "onLoad");
        this.a = r3;
        RxUtilKt.c(xs2.b.a().b(c.class).subscribe(new C0279b(r3)), this.b);
    }
}
