package com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.presenter;

import b30.y;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.UserEvent;
import com.bytedance.android.live.browser.jsbridge.event.RoomBannerBarEvent;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.chatroom.model.BannerInRoomCollection;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.presenter.ActivityTopRightBannerPresenter;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.ActivityTopBannerViewIntent;
import com.bytedance.android.livesdk.utils.c0;
import com.bytedance.android.livesdk.utils.o6;
import com.bytedance.android.livesdk.utils.p4;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import to1.h;
import to1.i;
import zg1.m3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class TopRightBannerPresenter extends ro1.a {
    public c e;
    public final String f;
    public IRoom g;
    public boolean h;
    public final ActivityTopRightBannerPresenter.IView i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final d n;

    public static final class a<T> implements Predicate {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final boolean test(Object r2) {
            UserEvent r3 = (UserEvent) r2;
            Intrinsics.checkNotNullParameter(r3, "userEvent");
            if (r3.getStatus() != IBaseUser.Status.Login) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ TopRightBannerPresenter a;

        public b(TopRightBannerPresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            this.a.c(new ActivityTopBannerViewIntent.f((UserEvent) r3));
        }
    }

    public static final class c extends com.bytedance.android.live.core.tetris.task.a {
        public final void run() {
            b(true);
        }

        public c() {
            super("activity_top_right_banner_load");
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ TopRightBannerPresenter a;

        public d(TopRightBannerPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            KVData r7 = (KVData) r6;
            String r0 = null;
            if (r7 == null) goto L5;
            String r1 = r7.getKey();
        L6:
            if (r1 != null) goto L9;
        L34:
            StringBuilder r2 = new StringBuilder("mKVChange");
            if (r7 == null) goto L37;
            r0 = r7.getKey();
        L37:
            r2.append(r0);
            ALogger.i("tag_banner_TOP", r2.toString());
            return;
        L9:
            switch(r1.hashCode()) {
                case -1357019912: goto L29;
                case 1060055221: goto L26;
                case 1099626493: goto L23;
                case 1718710183: goto L12;
                default: goto L34;
            };
        L12:
            if (r1.equals("data_predictor_banner_can_show") == false) goto L34;
            if (this.a.g() == true) goto L16;
            this.a.a(new com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.b(false));
            DataCenter r3 = ((p4) this.a).d;
            if (r3 == null) goto L34;
            r3.put("data_predictor_entrance_can_show", Boolean.TRUE);
            goto L34
        L16:
            if (this.a.f() == false) goto L18;
            this.a.a(new com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.b(true));
            goto L34
        L18:
            this.a.a(new com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.b(false));
            goto L34
        L23:
            if (r1.equals("cmd_send_H5_roomStatusChange") == false) goto L34;
            this.a.a(new com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.f("H5_roomStatusChange", (JSONObject) r7.getData()));
            goto L34
        L26:
            if (r1.equals("data_keyboard_status") == false) goto L34;
        L30:
            TopRightBannerPresenter r4 = this.a;
            Boolean r5 = (Boolean) r7.getData();
            if (r5 != null) goto L33;
            r5 = Boolean.FALSE;
        L33:
            r4.a(new com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.a.g(r5.booleanValue()));
            goto L34
        L29:
            if (r1.equals("data_pre_show_keyboard") == false) goto L34;
        L5:
            r1 = null;
            goto L6
        }
    }

    public final void e() {
        DataCenter r0 = ((p4) this).d;
        IRoom r1 = null;
        if (r0 == null) goto L5;
        r1 = (IRoom) r0.get("data_room", null);
    L5:
        this.g = r1;
        DataCenter r2 = ((p4) this).d;
        if (r2 == null) goto L10;
        Boolean r3 = (Boolean) r2.get("data_is_anchor", Boolean.FALSE);
        if (r3 == null) goto L10;
        boolean r4 = r3.booleanValue();
    L11:
        this.h = r4;
        new ActivityTopRightBannerPresenter(this.g).g0(this.i);
        d(RoomBannerBarEvent.class, new TopRightBannerPresenter$attachToView$1(this));
        d(y.class, new TopRightBannerPresenter$attachToView$2(this));
        Disposable r5 = com.bytedance.android.livesdk.c.a().m().onBackpressureLatest().filter(a.a).subscribe(new b(this));
        if (r5 == null) goto L14;
        ((p4) this).b.add(r5);
    L14:
        DataCenter r6 = ((p4) this).d;
        if (r6 == null) goto L23;
        DataCenter r7 = r6.observe("data_pre_show_keyboard", this.n);
        if (r7 == null) goto L23;
        DataCenter r8 = r7.observe("data_keyboard_status", this.n);
        if (r8 == null) goto L23;
        DataCenter r9 = r8.observe("cmd_send_H5_roomStatusChange", this.n);
        if (r9 == null) goto L23;
        r9.observe("data_predictor_banner_can_show", this.n);
    L23:
        this.e = new c();
        o r10 = o3.f();
        if (r10 == null) goto L29;
        j r11 = r10.B2();
        if (r11 == null) goto L30;
        r11.c(new TopRightBannerPresenter$attachToView$6(this));
        return;
    L30:
        return;
    L29:
        return;
    L10:
        r4 = false;
        goto L11
    }

    public final boolean g() {
        DataCenter r0 = ((p4) this).d;
        if (r0 == null) goto L7;
        Boolean r1 = (Boolean) r0.get("data_predictor_banner_can_show", Boolean.TRUE);
        if (r1 == null) goto L7;
        return r1.booleanValue();
    L7:
        return true;
    }

    public final void h() {
        ((p4) this).b.clear();
        ((p4) this).d = null;
        ((p4) this).c = null;
        h r1 = (h) this.j.getValue();
        ((z40.a) r1).a = null;
        ((z40.a) r1).b = null;
        ((z40.a) r1).c = null;
        i r2 = (i) this.k.getValue();
        ((z40.a) r2).a = null;
        ((z40.a) r2).b = null;
        ((z40.a) r2).c = null;
        to1.a r3 = (to1.a) this.l.getValue();
        ((z40.a) r3).a = null;
        ((z40.a) r3).b = null;
        ((z40.a) r3).c = null;
        this.e = null;
    }

    public final boolean f() {
        if (v.a() == false) goto L19;
        int r0 = c0.a;
        o r1 = z51.a.h(null, 3);
        if (r1 == null) goto L13;
        m r2 = r1.getRoom();
        if (r2 == null) goto L13;
        IRoom r3 = (IRoom) r2.getValue();
        if (r3 == null) goto L13;
        IRoomAuthStatus r4 = r3.getRoomAuthStatus();
        if (r4 == null) goto L13;
        r4.enableBanner();
    L13:
        g();
        DataCenter r5 = ((p4) this).d;
        if (r5 == null) goto L19;
        Integer r6 = (Integer) r5.get("data_activity_banner_number", 0);
        if (r6 == null) goto L19;
        r6.intValue();
    L19:
        if (g() == false) goto L39;
        DataCenter r7 = ((p4) this).d;
        if (r7 == null) goto L25;
        Integer r8 = (Integer) r7.get("data_activity_banner_number", 0);
        if (r8 == null) goto L25;
        int r9 = r8.intValue();
    L26:
        if (r9 <= 0) goto L40;
        o r10 = z51.a.h(null, 3);
        if (r10 == null) goto L41;
        m r11 = r10.getRoom();
        if (r11 == null) goto L42;
        IRoom r12 = (IRoom) r11.getValue();
        if (r12 == null) goto L43;
        IRoomAuthStatus r13 = r12.getRoomAuthStatus();
        if (r13 != null) goto L36;
        return false;
    L36:
        if (r13.enableBanner() != true) goto L45;
        return true;
    L45:
        return false;
    L43:
        return false;
    L42:
        return false;
    L41:
        return false;
    L40:
        return false;
    L25:
        r9 = 0;
        goto L26
    L39:
        return false;
    }

    public TopRightBannerPresenter(ActivityTopRightBannerPresenter.IView r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.f = "is_enable_banner_reload";
        this.i = r2;
        this.j = LazyKt.lazy(TopRightBannerPresenter$mBannerFetchCase$2.INSTANCE);
        this.k = LazyKt.lazy(TopRightBannerPresenter$mUrlCase$2.INSTANCE);
        this.l = LazyKt.lazy(TopRightBannerPresenter$mEventJsCase$2.INSTANCE);
        this.m = LazyKt.lazy(TopRightBannerPresenter$mLiveViewState$2.INSTANCE);
        this.n = new d(this);
    }

    public final void i(BannerInRoomCollection.BannerInfo r4) {
        j(true);
        DataCenter r0 = ((p4) this).d;
        if (r0 == null) goto L10;
        if (r4 == null) goto L8;
        List r1 = r4.getBannerList();
        if (r1 == null) goto L8;
        Integer r2 = Integer.valueOf(r1.size());
    L9:
        r0.put("data_activity_banner_number", r2);
    L8:
        r2 = null;
    L10:
        int r3 = o6.a;
        DataCenter r5 = ((p4) this).d;
        if (r4 == null) goto L15;
        List r6 = r4.getBannerList();
        if (r6 == null) goto L15;
        int r7 = r6.size();
    L16:
        o6.a(r5, r7);
        return;
    L15:
        r7 = 0;
        goto L16
    }

    public final void j(boolean r4) {
        DataCenter r0 = ((p4) this).d;
        if (r0 == null) goto L6;
        r0.put("data_activity_top_right_banner_show", new m3(1, r4));
        return;
    }
}
