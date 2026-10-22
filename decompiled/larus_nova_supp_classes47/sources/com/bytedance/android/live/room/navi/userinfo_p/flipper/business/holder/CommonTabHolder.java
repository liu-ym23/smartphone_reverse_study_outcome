package com.bytedance.android.live.room.navi.userinfo_p.flipper.business.holder;

import am2.x;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.room.navi.userinfo.model.TabLabelType;
import com.bytedance.android.live.room.navi.userinfo_p.UserInfoContextExtKt;
import com.bytedance.android.live.room.navi.userinfo_p.flipper.core.BaseTabFlipper;
import com.bytedance.android.live.room.y;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.AnchorTabLabel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class CommonTabHolder implements w91.f {
    public static final /* synthetic */ int g = 0;
    public int a;
    public final vlc.d b;
    public final CompositeDisposable c;
    public IRoom d;
    public final DataCenter e;
    public final View f;

    public static final class a {
        @JvmStatic
        public static View a(boolean r1, int r2, DataCenter r3, ViewGroup r4) {
            Intrinsics.checkNotNullParameter(r3, "dataCenter");
            Intrinsics.checkNotNullParameter(r4, "parent");
            if (r1 == true) goto L5;
            int r5 = 2131567909;
        L10:
            return LayoutInflater.from(r4.getContext()).inflate(r5, r4, false);
        L5:
            if (r2 != 1) goto L7;
            r5 = 2131567907;
            goto L10
        L7:
            r5 = 2131567908;
            goto L10
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ CommonTabHolder a;
        public final /* synthetic */ String b;

        public static final class a implements Runnable {
            public final /* synthetic */ b a;

            public a(b r1) {
                this.a = r1;
            }

            public final void a() {
                j0 r0 = j0.l();
                Pair[] r2 = new Pair[2];
                r2[0] = TuplesKt.to("tag_type", this.a.b);
                CommonTabHolder r3 = this.a.a;
                Intrinsics.checkNotNullParameter(r3, "$this$getAdapterPos");
                ViewParent r5 = r3.a().getParent();
            L3:
                if (r5 == null) goto L8;
                if ((r5 instanceof BaseTabFlipper) == true) goto L6;
                r5 = r5.getParent();
                goto L3
            L6:
                int r4 = ((BaseTabFlipper) r5).f(r3.a());
            L9:
                r2[1] = TuplesKt.to("tag_order", String.valueOf(r4 + 1));
                Map<String, String> r6 = MapsKt.mutableMapOf(r2);
                this.a.a.i(r6);
                Unit r7 = Unit.INSTANCE;
                r0.sendLog("livesdk_tag_show", r6, new Object[]{x.class, IRoom.class});
                return;
            L8:
                r4 = -1;
                goto L9
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public b(CommonTabHolder r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.f.post(new a(this));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // w91.f
    public boolean d(w91.e r1) {
        return false;
    }

    public void i(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
    }

    public abstract void k(u91.a r1);

    public void l() {
    }

    public void n() {
    }

    @Override // w91.f
    public q91.a c() {
        return new q91.a();
    }

    @Override // w91.f
    public boolean f() {
        return a0.d(this.e, false);
    }

    @Override // w91.f
    public w91.a g() {
        return new r91.a();
    }

    public void p() {
        this.c.clear();
    }

    public final void m() {
        l();
        o81.a r0 = com.bytedance.android.live.room.navi.userinfo_p.viewmodel.a.a(this.e);
        if (r0 == null) goto L5;
        j(UserInfoContextExtKt.b(r0.getOnWidgetLoad(), new CommonTabHolder$onInitHolder$$inlined$run$lambda$1(this)));
        j(UserInfoContextExtKt.b(r0.getOnWidgetViewPrepared(), new CommonTabHolder$onInitHolder$$inlined$run$lambda$2(this)));
        j(UserInfoContextExtKt.b(r0.getOnWidgetRoomEnter(), new CommonTabHolder$onInitHolder$$inlined$run$lambda$3(this)));
        j(UserInfoContextExtKt.b(r0.getOnWidgetUnload(), new CommonTabHolder$onInitHolder$$inlined$run$lambda$4(this)));
        return;
    L5:
        ALogger.e("CommonTabHolder", "UserInfoWidgetLifecycleContext获取为null");
    }

    @Override // w91.f
    public final View a() {
        return this.f;
    }

    @Override // w91.f
    public int b() {
        return this.a;
    }

    @Override // w91.f
    public void e(int r1) {
        this.a = r1;
    }

    public final void h(Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r4, "map");
        IRoom r0 = this.d;
        if (r0 == null) goto L11;
        AnchorTabLabel r1 = r0.getAnchorTabLabel();
        if (r1 == null) goto L12;
        int r2 = Integer.valueOf(r1.getType()).intValue();
        if (r2 != TabLabelType.QualityGeek.value) goto L9;
        r4.put("EVENT_ORIGIN_FEATURE", "TEMAI");
    L9:
        r4.put("tag_name", String.valueOf(r2));
        return;
    L12:
        return;
    }

    public final void j(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$autoBind");
        this.c.add(r2);
    }

    public void o(IRoom r1) {
        this.d = r1;
    }

    public final void q(String r4) {
        Intrinsics.checkNotNullParameter(r4, "tagType");
        int r0 = y.a;
        y.a(this.e, this.c, "sendTagShowLog", new b(this, r4));
    }

    public CommonTabHolder(IRoom r2, DataCenter r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "itemView");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.b = (vlc.d) r3.get("data_message_manager", null);
        this.c = new CompositeDisposable();
    }
}
