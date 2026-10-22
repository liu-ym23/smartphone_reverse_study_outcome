package np1;

import android.view.View;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z0;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements b {
    public final int b;
    public String c;
    public final List<np1.a> d;
    public boolean e;
    public final CompositeDisposable f;
    public final PropertyOwner<h80.c<View>> g;
    public final PropertyOwner h;
    public final PropertyOwner<h80.c<View>> i;
    public final c j;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public a(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.invoke(z0.b((h80.c) r2));
        }
    }

    @Override // np1.b
    public int getType() {
        return this.b;
    }

    public g(c r4) {
        Intrinsics.checkNotNullParameter(r4, "panelContext");
        this.j = r4;
        this.b = 1;
        this.c = "";
        this.d = new ArrayList();
        CompositeDisposable r0 = new CompositeDisposable();
        this.f = r0;
        h80.c r2 = h80.c.b;
        PropertyOwner<h80.c<View>> r1 = new PropertyOwner(r2);
        this.g = r1;
        this.h = r1;
        this.i = new PropertyOwner(r2);
        r4.getCd().add(r0);
    }

    public final void a(Function1<? super View, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "block");
        RxUtilKt.c(this.h.subscribe(new a(r3)), this.f);
    }

    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }
}
