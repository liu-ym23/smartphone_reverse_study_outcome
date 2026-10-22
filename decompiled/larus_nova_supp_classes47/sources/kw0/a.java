package kw0;

import am2.x;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2;
import com.bytedance.android.livesdk.revenue.log.d;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import j40.f4;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import jw0.g;
import jw0.h;
import kotlin.jvm.internal.Intrinsics;
import yo2.e;
import zr2.k;
import zv0.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends k implements j {
    public View b;
    public final CompositeDisposable c;
    public e d;
    public final View.OnClickListener e;

    /* JADX INFO: renamed from: kw0.a$a, reason: collision with other inner class name */
    public static final class C0263a {
    }

    static {
    }

    @Override // zv0.j
    public final void load() {
    }

    public a() {
        this.e = null;
        this.c = new CompositeDisposable();
    }

    @Override // zv0.j
    public final View.OnClickListener getBehavior() {
        return this.e;
    }

    public final void onClick(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        String r0 = g.a().toString();
        if (TextUtils.isEmpty(r0) == true) goto L5;
        ((zz0.g) f.a(zz0.g.class)).S2(r4.getContext(), r0);
    L5:
        int r5 = h.a;
        HashMap r6 = new HashMap();
        r6.put("request_page", "shortcut");
        r6.put("charge_reason", "exchange_diamond");
        HashMap<Class<?>, d<?>> r1 = com.bytedance.android.live.recharge.utils.f.a;
        com.bytedance.android.live.recharge.utils.f.d("livesdk_exchange_entrance_click", r6, new Class[]{IRoom.class, x.class});
    }

    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.c.clear();
        e r4 = this.d;
        if (r4 == null) goto L6;
        r4.d();
        return;
    }

    public final void p4(View r10, DataCenter r12) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r12, "dataCenter");
        this.b = r10;
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.room.b.class).F2();
        int r13 = com.bytedance.android.livesdk.revenue.room.d.a;
        yz0.k r14 = (yz0.k) f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r14 == null) goto L5;
        boolean r15 = r14.isAnchor();
    L7:
        if (g2.b(Boolean.valueOf(r15)) == false) goto L9;
        g2.a(this.b);
    L9:
        View r16 = this.b;
        if (r16 == null) goto L12;
        View r17 = r16.findViewById(2131374718);
    L14:
        if ((r17 instanceof HSImageView) == true) goto L16;
        r17 = null;
    L16:
        HSImageView r18 = (HSImageView) r17;
        if (r18 == null) goto L19;
        r18.setActualImageResource(2131251850);
    L19:
        com.bytedance.android.livesdk.sharedpref.e r19 = f4.r;
        if (((Boolean) r19.getValue()).booleanValue() == true) goto L25;
        View r4 = this.b;
        if (r4 == null) goto L25;
        e r3 = new e(r4.getContext());
        ((yo2.d) r3).d = null;
        ((yo2.d) r3).e = 2131566789;
        ((yo2.d) r3).l = true;
        r3.a();
        this.d = r3;
        r3.i(r4, 1, 0, 0, -s1.f(4.0f));
        this.c.add(Observable.timer(5, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), c.a));
        com.bytedance.android.livesdk.sharedpref.f.d(r19, Boolean.TRUE);
    L25:
        int r110 = h.a;
        HashMap r111 = new HashMap();
        r111.put("request_page", "shortcut");
        r111.put("charge_reason", "exchange_diamond");
        HashMap<Class<?>, d<?>> r0 = com.bytedance.android.live.recharge.utils.f.a;
        com.bytedance.android.live.recharge.utils.f.d("livesdk_exchange_entrance_show", r111, new Class[]{IRoom.class, x.class});
        return;
    L12:
        r17 = null;
        goto L14
    L5:
        r15 = false;
        goto L7
    }
}
