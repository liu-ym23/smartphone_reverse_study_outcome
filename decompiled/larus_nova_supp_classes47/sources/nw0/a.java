package nw0;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.incentive.exchange.j;
import com.bytedance.android.live.recharge.util.i;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.livesdk.revenue.toolbar.RevToolbarButton;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import java.util.List;
import jw0.g;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import pa0.o;
import yo2.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements zv0.b {
    public e a;
    public final CompositeDisposable b;
    public boolean c;
    public DataCenter d;
    public final View e;
    public final List<View> f;
    public final TextView g;
    public final Function1<Integer, Unit> h;
    public final int i;
    public Context j;

    /* JADX INFO: renamed from: nw0.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0279a implements View.OnClickListener {
        public final /* synthetic */ a a;

        public ViewOnClickListenerC0279a(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            if (j.b() == true) goto L5;
            ToastUtil.a(2131917416, 0);
            gx0.b.a(false);
        L11:
            com.bytedance.tools.kcp.spongepreference.runtime.a r6 = i.b;
            KProperty[] r1 = i.a;
            if (((Boolean) r6.getValue(null, r1[0])).booleanValue() == true) goto L15;
            r6.setValue(null, r1[0], Boolean.TRUE);
            zr2.i r7 = new zr2.i(false, false);
            vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.e.class).b9(this.a.d).a(RevToolbarButton.Gift, r7);
            return;
        L15:
            return;
        L5:
            a r8 = this.a;
            r8.getClass();
            String r2 = g.a().toString();
            if (TextUtils.isEmpty(r2) == true) goto L10;
            Context r9 = r8.j;
            if (r9 == null) goto L10;
            ((zz0.g) f.a(zz0.g.class)).S2(r9, r2);
        L10:
            gx0.b.a(true);
            goto L11
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // zv0.b
    public final void onUnload() {
        e r0 = this.a;
        if (r0 == null) goto L5;
        r0.d();
    L5:
        this.j = null;
        this.b.clear();
        this.a = null;
    }

    public final Context getContext() {
        return this.j;
    }

    @Override // zv0.b
    public final void setDataCenter(DataCenter r1) {
        this.d = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(View r2, List<? extends View> r3, TextView r4, Function1<? super Integer, Unit> r5, int r6, Context r7) {
        Intrinsics.checkNotNullParameter(r3, "actionViews");
        Intrinsics.checkNotNullParameter(r4, "updateView");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.i = r6;
        this.j = r7;
        this.b = new CompositeDisposable();
        Iterator r8 = r3.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        ((View) r8.next()).setOnClickListener(new ViewOnClickListenerC0279a(this));
        goto L4
    L6:
        RxUtilKt.c(com.bytedance.android.live.revenue.common.reactive.j.a(o.b, true).subscribe(new nw0.b(this)), this.b);
    }
}
