package y81;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class b implements u81.d {
    public static final /* synthetic */ int i = 0;
    public final Integer a;
    public final CompositeDisposable b;
    public boolean c;
    public String d;
    public tlc.d e;
    public final DataCenter f;
    public final View g;
    public final View h;

    public static final class a {
        @JvmStatic
        public static View a(ViewGroup r3) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            return LayoutInflater.from(r3.getContext()).inflate(2131566666, r3, false);
        }
    }

    static {
    }

    @Override // u81.d
    public final void d() {
        this.c = true;
    }

    public final void h() {
        if (this.g.getVisibility() != 0) goto L6;
        xs2.b.a().post(new zg1.s0(0, 1));
        return;
    }

    public final void j() {
        RxBusAbility.INSTANCE.getRxBus(this.f).post(new zg1.n());
    }

    @Override // u81.d
    public void onDestroy() {
        this.b.clear();
    }

    @Override // u81.d
    public final View a() {
        return this.g;
    }

    @Override // u81.d
    public Integer b() {
        return this.a;
    }

    @Override // u81.d
    public final String getIconUrl() {
        return this.d;
    }

    public final void i(int r4) {
        if (this.g.getVisibility() != 0) goto L6;
        xs2.b.a().post(new zg1.s0(r4, 0));
        return;
    }

    public b(DataCenter r2, View r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "itemView");
        Intrinsics.checkNotNullParameter(r4, "parentView");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.a = 0;
        this.b = new CompositeDisposable();
        this.c = true;
        this.d = "";
    }
}
