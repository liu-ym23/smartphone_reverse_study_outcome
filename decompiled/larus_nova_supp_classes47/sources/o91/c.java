package o91;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.room.navi.userinfo_p.flipper.UserInfoFlipperLayout;
import com.bytedance.android.live.room.navi.userinfo_p.flipper.business.list.UserTabList;
import com.bytedance.android.live.room.navi.userinfo_p.viewmodel.ElementMiddleVM;
import com.bytedance.android.live.room.navi.userinfo_p.viewmodel.UserInfoVM;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.m;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import s91.f;
import t91.e;
import t91.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c implements o91.a {
    public final UserInfoFlipperLayout b;
    public final UserInfoFlipperLayout c;
    public p91.a d;
    public p91.b e;
    public final UserTabList f;
    public final UserTabList g;
    public final ArrayList<s91.b<f>> h;
    public final ArrayList<s91.b<f>> i;
    public final boolean j;
    public final CompositeDisposable k;
    public final Context l;
    public final DataCenter m;
    public final DataContext n;
    public final ViewGroup o;

    public static final class a {
    }

    static {
    }

    public final IRoom a() {
        String r2 = null;
        IRoom r0 = (IRoom) this.m.get("data_room", null);
        if (r0 != null) goto L14;
        StringBuilder r1 = new StringBuilder("cur room is null.room id :");
        DataContext r3 = this.n;
        if (r3 == null) goto L13;
        Intrinsics.checkNotNullParameter(r3, "$this$getRoomDataCtxExt");
        o r4 = z51.a.g(r3);
        if (r4 == null) goto L13;
        m r5 = r4.getRoom();
        if (r5 == null) goto L13;
        IRoom r6 = (IRoom) r5.getValue();
        if (r6 == null) goto L13;
        r2 = r6.getIdStr();
    L13:
        r1.append(r2);
        ALogger.e("UserInfoWidgetAbility", r1.toString());
    L14:
        return r0;
    }

    public final void d() {
        Iterator<T> r0 = this.h.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((s91.b) r0.next()).reset();
        goto L4
    L6:
        this.h.clear();
        Iterator<T> r1 = this.i.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        ((s91.b) r1.next()).reset();
        goto L8
    L10:
        this.i.clear();
    }

    public final void c() {
        d();
        this.k.clear();
    }

    public final void b(int r10) {
        ALogger.d("UserInfoTabManager", "initFlipperData,the anchor yan type is " + r10);
        DataCenter r0 = this.m;
        IRoom r1 = a();
        Map<Class<? extends b.n>, Integer> r2 = x91.a.a;
        Intrinsics.checkNotNullParameter(r0, "dataCenter");
        a0.l(r0, true);
        List r3 = CollectionsKt.listOf(new e[]{new t91.c(), new t91.f(), new t91.d(), new g(), new t91.b(), new t91.a(r1)});
        this.f.clear();
        p91.a r4 = this.d;
        if (r4 == null) goto L5;
        r4.notifyDataSetChange();
    L5:
        this.g.clear();
        p91.b r5 = this.e;
        if (r5 == null) goto L9;
        r5.notifyDataSetChange();
    L9:
        if (this.j == true) goto L11;
        this.f.add(new u91.a(b.j.b));
    L11:
        UserTabList r6 = this.f;
        DataCenter r7 = this.m;
        a();
        r6.addAll(x91.a.d(r3, r10, 1, r7));
        UserTabList r8 = this.g;
        DataCenter r9 = this.m;
        a();
        r8.addAll(x91.a.d(r3, r10, 2, r9));
        p91.a r12 = this.d;
        if (r12 == null) goto L14;
        r12.notifyDataSetChange();
    L14:
        p91.b r13 = this.e;
        if (r13 == null) goto L17;
        r13.notifyDataSetChange();
    L17:
        UserInfoFlipperLayout r14 = this.b;
        r14.b = true;
        if (r14.g() == true) goto L20;
        r14.e = null;
        r14.j(0, true);
    L20:
        UserInfoFlipperLayout r15 = this.c;
        r15.b = true;
        if (r15.g() == true) goto L23;
        r15.e = null;
        r15.j(0, true);
    L23:
        d();
        this.h.addAll(x91.a.b(r10, 1, this.l, this.m, this.n, a()));
        this.i.addAll(x91.a.b(r10, 2, this.l, this.m, this.n, a()));
        d r16 = new d(this, this.b, this.f, this.d);
        Iterator<s91.b<f>> r17 = this.h.iterator();
    L25:
        if (r17.hasNext() == false) goto L27;
        s91.b<f> r18 = r17.next();
        r18.b(r16);
        r18.a();
        goto L25
    L27:
        d r19 = new d(this, this.c, this.g, this.e);
        Iterator<s91.b<f>> r110 = this.i.iterator();
    L29:
        if (r110.hasNext() == false) goto L32;
        s91.b<f> r20 = r110.next();
        r20.b(r19);
        r20.a();
        goto L29
    L32:
        if (this.j == false) goto L34;
        return;
    L34:
        if (this.g.isEmpty() == true) goto L36;
        return;
    L36:
        if ((!this.f.isEmpty()) == false) goto L49;
        UserInfoVM.Companion.getClass();
        aa1.a r111 = UserInfoVM.b.b();
        if (r111 == null) goto L50;
        ElementMiddleVM r112 = r111.getMiddleVm();
        if (r112 == null) goto L51;
        k<Unit> r113 = r112.getChangeHeightWhenEmpty();
        if (r113 == null) goto L52;
        r113.post(Unit.INSTANCE);
        return;
    L52:
        return;
    L51:
        return;
    L50:
        return;
    }

    public final void e(int r7) {
        v91.b r0 = new v91.b(this.j, this.b, this.c);
        int r4 = 0;
        UserInfoFlipperLayout[] r2 = {this.b, this.c};
        Intrinsics.checkNotNullParameter(r2, "flippers");
    L3:
        if (r4 >= 2) goto L5;
        r2[r4].setTabFlipSynchronizer(r0);
        r4 = r4 + 1;
        goto L3
    L5:
        this.d = new p91.a(this.f, this.m, this.n);
        this.e = new p91.b(this.g, this.m, this.n);
        this.b.setAdapter(this.d);
        this.c.setAdapter(this.e);
        b(r7);
    }

    public c(Context r2, DataCenter r3, DataContext r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r5, "userNameLayout");
        this.l = r2;
        this.m = r3;
        this.n = r4;
        this.o = r5;
        this.b = (UserInfoFlipperLayout) r5.findViewById(2131372611);
        this.c = (UserInfoFlipperLayout) r5.findViewById(2131385692);
        this.f = new UserTabList();
        this.g = new UserTabList();
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = a0.d(r3, false);
        this.k = new CompositeDisposable();
    }
}
