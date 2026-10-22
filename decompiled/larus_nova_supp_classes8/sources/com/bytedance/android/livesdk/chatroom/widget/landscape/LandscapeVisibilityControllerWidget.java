package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import b30.f0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.x1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.media.api.IMediaReplayService;
import com.bytedance.android.live.room.IMicRoomService;
import com.bytedance.android.live.room.api.IVisibilityControlBrickService;
import com.bytedance.android.live.room.api.IVisibilityControlService;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.LandscapeRootViewChangeManager;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.utils.i3;
import com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner.ActivityTopBannerWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.m50;
import com.bytedance.android.livesdk.config.os;
import com.bytedance.android.livesdk.interactivity.api.like.datacontext.DiggContext;
import com.bytedance.android.livesdk.landscape.ILandscapeSpiltManager;
import com.bytedance.android.livesdk.utils.landscape.LandscapePhoneInfoShowUtils;
import com.bytedance.android.livesdk.utils.u4;
import com.bytedance.android.livesdk.widgetdescriptor.data.LandscapeInteractionModel;
import com.bytedance.android.livesdkapi.depend.live.IRoomRecordService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.info.WidgetInfo;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import zg1.e3;
import zg1.o2;
import zg1.o3;
import zg1.w0;
import zg1.y0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0002\u000b\fJ\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\tJ\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\n¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/landscape/LandscapeVisibilityControllerWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/livesdk/chatroom/widget/landscape/u;", "Ldo1/b;", "event", "", "onEvent", "Lzg1/e3;", "Lzg1/w0;", "a", "b", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeVisibilityControllerWidget extends LiveRecyclableWidget implements Observer<KVData>, u {
    public static final List<ToolbarButton> G = null;
    public final Lazy A;
    public boolean B;
    public boolean C;
    public final View D;
    public final r E;
    public final h80.d<LandscapeRootViewChangeManager> F;
    public final long a;
    public final Set<Integer> b;
    public final Map<Integer, Float> c;
    public final int[] d;
    public final int[] e;
    public final Set<Integer> f;
    public boolean g;
    public boolean h;
    public final SparseArray<View> i;
    public final SparseArray<View> j;
    public final SparseArray<View> k;
    public final SparseArray<View> l;
    public final SparseArray<View> m;
    public final SparseArray<Integer> n;
    public final List<View> o;
    public Observable<Unit> p;
    public Disposable q;
    public Room r;
    public boolean s;
    public int t;
    public long u;
    public boolean v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public long z;

    public static final class a {
    }

    public static final class b {
        public final boolean a;
        public final boolean b;
        public final boolean c;
        public final boolean d;
        public final boolean e;

        public b() {
            this(false, false, false, false, 31);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L16;
            b r4 = (b) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L12;
            return false;
        L12:
            if (this.d == r4.d) goto L14;
            return false;
        L14:
            if (this.e == r4.e) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v3, types: [int] */
        /* JADX WARN: Type inference failed for: r2v5, types: [int] */
        /* JADX WARN: Type inference failed for: r2v7 */
        /* JADX WARN: Type inference failed for: r2v8 */
        /* JADX WARN: Type inference failed for: r2v9 */
        public final int hashCode() {
            boolean r0 = this.a;
            ?? r1 = 1;
            ?? r2 = r0;
            if (r0 == false) goto L5;
            r2 = 1;
        L5:
            int r3 = r2 * 31;
            boolean r4 = this.b;
            ?? r5 = r4;
            if (r4 == false) goto L8;
            r5 = 1;
        L8:
            int r6 = (r3 + r5) * 31;
            boolean r7 = this.c;
            ?? r8 = r7;
            if (r7 == false) goto L11;
            r8 = 1;
        L11:
            int r9 = (r6 + r8) * 31;
            boolean r10 = this.d;
            ?? r11 = r10;
            if (r10 == false) goto L14;
            r11 = 1;
        L14:
            int r12 = (r9 + r11) * 31;
            boolean r13 = this.e;
            if (r13 == true) goto L19;
            r1 = r13;
        L19:
            return r12 + r1;
        }

        public final String toString() {
            return "Config(keepGift=" + this.a + ", keepLock=" + this.b + ", triggerDueToKeyboard=" + this.c + ", keepInteract=" + this.d + ", onlyKeepGift=" + this.e + ")";
        }

        public b(boolean r3, boolean r4, boolean r5, boolean r6, int r7) {
            if ((r7 & 1) == 0) goto L6;
            r3 = false;
        L6:
            if ((r7 & 2) == 0) goto L9;
            r4 = false;
        L9:
            if ((r7 & 4) == 0) goto L12;
            r5 = false;
        L12:
            if ((r7 & 8) == 0) goto L14;
            boolean r0 = r3;
        L16:
            if ((r7 & 16) == 0) goto L18;
            r6 = false;
        L18:
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = r0;
            this.e = r6;
            return;
        L14:
            r0 = false;
            goto L16
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ LandscapeVisibilityControllerWidget a;

        public c(LandscapeVisibilityControllerWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r10) {
            Boolean r11 = (Boolean) r10;
            if (r11 == null) goto L19;
            boolean r12 = r11.booleanValue();
            LandscapeVisibilityControllerWidget r0 = this.a;
            r0.C = r12;
            com.bytedance.android.livesdk.sharedpref.e r1 = com.bytedance.android.livesdk.sharedpref.b.G0;
            Boolean r2 = Boolean.valueOf(r12);
            r1.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r1, r2);
            r0.Nq(!r12, new b(false, true, false, false, 29));
            if (r0.C == false) goto L16;
            if (z.o(((Widget) r0).dataCenter).isMediaRoom() == false) goto L9;
            r0.h = true;
        L10:
            ALogger.d("visibilityControlTag", "isLock changed, change to " + r0.C);
            IVisibilityControlBrickService r13 = jc1.k.f(IVisibilityControlBrickService.class);
            if (r13 == null) goto L16;
            IVisibilityControlService r14 = r13.provideVisibilityControlService(((Widget) r0).dataCenter);
            if (r14 == null) goto L16;
            r14.setVisibilityStatus(false);
            goto L16
        L9:
            r0.g = true;
        L16:
            if (z.o(((Widget) this.a).dataCenter).isMediaRoom() == true) goto L20;
            this.a.Kq();
            return;
        L20:
            return;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ LandscapeVisibilityControllerWidget a;

        public d(LandscapeVisibilityControllerWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Boolean r2 = (Boolean) r1;
            if (r2 != null) goto L5;
            return;
        L5:
            if (r2.booleanValue() == false) goto L7;
            this.a.qb();
            return;
        L7:
            this.a.Hj();
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ LandscapeVisibilityControllerWidget a;

        public e(LandscapeVisibilityControllerWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (Intrinsics.areEqual((Boolean) r2, Boolean.TRUE) == false) goto L6;
            this.a.setVisibility(false);
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ LandscapeVisibilityControllerWidget a;

        public f(LandscapeVisibilityControllerWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            LandscapeVisibilityControllerWidget r0 = this.a;
            r0.onEvent((e3) r2);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ LandscapeVisibilityControllerWidget a;

        public g(LandscapeVisibilityControllerWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            LandscapeVisibilityControllerWidget r0 = this.a;
            r0.onEvent((w0) r2);
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ LandscapeVisibilityControllerWidget a;

        public h(LandscapeVisibilityControllerWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r10) {
            zt2.a r11 = (zt2.a) r10;
            LandscapeVisibilityControllerWidget r0 = this.a;
            if (r11 == null) goto L5;
            List<ToolbarButton> r2 = LandscapeVisibilityControllerWidget.G;
            r0.getClass();
            boolean r12 = r11.a;
        L6:
            r0.v = r12;
            if (r12 == false) goto L9;
            r0.Nq(false, new b(false, false, false, !r0.C, 15));
            return;
        L9:
            r0.setVisibility(false);
            return;
        L5:
            r12 = true;
            goto L6
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ LandscapeVisibilityControllerWidget a;

        public i(LandscapeVisibilityControllerWidget r1) {
            this.a = r1;
        }

        public final void accept(do1.b r2) {
            LandscapeVisibilityControllerWidget.wq(this.a, r2);
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            accept((do1.b) r1);
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ LandscapeVisibilityControllerWidget a;

        public j(LandscapeVisibilityControllerWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r11) {
            o2 r12 = (o2) r11;
            LandscapeVisibilityControllerWidget r0 = this.a;
            List<ToolbarButton> r1 = LandscapeVisibilityControllerWidget.G;
            r0.getClass();
            if (r12 != null) goto L6;
            return;
        L6:
            if (r12.a == false) goto L14;
            if (r0.Iq() == false) goto L10;
            LandscapeVisibilityControllerWidget.Sq(r0, 8, 6);
        L10:
            r0.Lq(false, new b(false, false, false, false, 31));
            r0.B = false;
            View r13 = r0.D.findViewById(2131381282);
            if (r13 == null) goto L20;
            UtilityKotlinExtentionsKt.t(r13);
            return;
        L20:
            return;
        L14:
            if (r0.Iq() == false) goto L16;
            LandscapeVisibilityControllerWidget.Sq(r0, 0, 6);
            r0.Tq(r0.C);
        L16:
            r0.B = true;
            r0.Lq(true, new b(false, false, false, false, 31));
            View r14 = r0.D.findViewById(2131381282);
            if (r14 == null) goto L22;
            UtilityKotlinExtentionsKt.w(r14);
            return;
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ LandscapeVisibilityControllerWidget a;

        public k(LandscapeVisibilityControllerWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r9) {
            UserProfileEvent r10 = (UserProfileEvent) r9;
            LandscapeVisibilityControllerWidget r0 = this.a;
            List<ToolbarButton> r1 = LandscapeVisibilityControllerWidget.G;
            r0.getClass();
            if (r10 == null) goto L7;
            r0.Nq(false, new b(!r0.C, false, false, false, 30));
            return;
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ LandscapeVisibilityControllerWidget a;

        public l(LandscapeVisibilityControllerWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r9) {
            o3 r10 = (o3) r9;
            LandscapeVisibilityControllerWidget r0 = this.a;
            List<ToolbarButton> r1 = LandscapeVisibilityControllerWidget.G;
            r0.getClass();
            if (r10 == null) goto L7;
            r0.Nq(false, new b(!r0.C, false, false, false, 30));
            return;
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ LandscapeVisibilityControllerWidget a;

        public m(LandscapeVisibilityControllerWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r9) {
            f0 r10 = (f0) r9;
            LandscapeVisibilityControllerWidget r0 = this.a;
            List<ToolbarButton> r1 = LandscapeVisibilityControllerWidget.G;
            r0.getClass();
            if (r10 == null) goto L7;
            r0.Nq(false, new b(!r0.C, false, false, false, 30));
            return;
        }
    }

    public static final class n<T> implements Observer {
        public final /* synthetic */ LandscapeVisibilityControllerWidget a;

        public n(LandscapeVisibilityControllerWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (Intrinsics.areEqual((Boolean) r2, Boolean.TRUE) == true) goto L5;
        L11:
            r r3 = this.a.E;
            if (r3 == null) goto L20;
            View r4 = r3.b;
            if (r4 == null) goto L21;
            r4.setAlpha(1.0f);
            return;
        L21:
            return;
        L20:
            return;
        L5:
            if (com.bytedance.android.livesdk.f.d().c == true) goto L11;
            r r5 = this.a.E;
            if (r5 == null) goto L17;
            View r6 = r5.b;
            if (r6 == null) goto L18;
            r6.setAlpha(0.4f);
            return;
        L18:
            return;
        }
    }

    public static final class o<T> implements Consumer {
        public final /* synthetic */ LandscapeVisibilityControllerWidget a;

        public o(LandscapeVisibilityControllerWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            Unit r9 = (Unit) r8;
            ALogger.d("visibilityControlTag", "Landscape's timer trigger, now do subscribe");
            LandscapeVisibilityControllerWidget r10 = this.a;
            r10.Nq(false, new b(!r10.C, false, false, false, 30));
            RoomContext r11 = RoomContext.a.c(RoomContext.Companion, ((Widget) this.a).dataCenter, 0, 2);
            if (r11 == null) goto L8;
            com.bytedance.live.datacontext.k r12 = r11.getLandscapePlayerControlInit();
            if (r12 == null) goto L9;
            r12.post(Boolean.TRUE);
            return;
        L9:
            return;
        }
    }

    public static final class p<T> implements Consumer {
        public static final p a = null;

        static {
            a = new p();
        }

        public p() {
        }

        public final void accept(Object r2) {
            throw new RuntimeException((Throwable) r2);
        }
    }

    public final LandscapeInteractionModel Cq() {
        return (LandscapeInteractionModel) this.A.getValue();
    }

    public final String getSpm() {
        return "a100.a100.a273";
    }

    public final /* synthetic */ void onAbilityClear() {
        IAbility.-CC.$default$onAbilityClear(this);
    }

    public final void onInit(Object[] r1) {
    }

    static {
        G = CollectionsKt.listOf(new ToolbarButton[]{ToolbarButton.FAST_GIFT, ToolbarButton.AIRDROP_GIFT});
    }

    public final void Bq() {
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        int r1 = ((Number) r0.next()).intValue();
        View r2 = Eq(this.i, r1);
        if (r2 == null) goto L4;
        UtilityKotlinExtentionsKt.t(r2);
        goto L4
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.landscape.u
    public final void Hj() {
        if (this.B == true) goto L5;
        return;
    L5:
        if (this.g == true) goto L7;
        return;
    L7:
        if (this.h == false) goto L12;
        Kq();
        return;
    }

    public final boolean Iq() {
        boolean r0 = this.s;
        Room r1 = this.r;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L6:
        return com.bytedance.android.livesdk.utils.landscape.e.b(r0, r1);
    }

    public final void Kq() {
        IVisibilityControlService r0 = jc1.k.n(IVisibilityControlBrickService.class).provideVisibilityControlService(((Widget) this).dataCenter);
        if (r0 == null) goto L6;
        Observable<Unit> r1 = r0.startVisibilityTimer();
        if (r1 == null) goto L6;
    L7:
        this.p = r1;
        Disposable r2 = this.q;
        if (r2 == null) goto L10;
        r2.dispose();
    L10:
        Observable<Unit> r3 = this.p;
        if (r3 == null) goto L13;
        Disposable r4 = r3.subscribe(new o(this), p.a);
    L14:
        this.q = r4;
        return;
    L13:
        r4 = null;
    L6:
        r1 = Observable.timer(5000, TimeUnit.MILLISECONDS).map(t.a).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        goto L7
    }

    public final void Qq() {
        if (((Boolean) l42.a.g.getValue()).booleanValue() == false) goto L25;
        View r0 = this.D.findViewById(2131377137);
        if (r0 == null) goto L7;
        r0.setVisibility(8);
    L7:
        View r1 = this.D.findViewById(2131377130);
        if (r1 == null) goto L10;
        r1.setVisibility(8);
    L10:
        View r2 = this.D.findViewById(2131377138);
        if (r2 == null) goto L13;
        r2.setVisibility(8);
    L13:
        Gq(8);
        Fq(new b(false, false, false, false, 31), false);
        View r3 = this.D.findViewById(2131377119);
        if (r3 == null) goto L16;
        r3.setVisibility(8);
    L16:
        Room r4 = this.r;
        if (r4 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L20:
        if (r4.isMediaRoom() == false) goto L26;
        View r5 = this.D.findViewById(2131386364);
        if (r5 == null) goto L27;
        r5.setVisibility(8);
        return;
    L27:
        return;
    L26:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.landscape.u
    public final void db() {
        Room r0 = this.r;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L6:
        if (r0.isMediaRoom() == false) goto L11;
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L10;
        r1.put("data_is_hiding_landscape_buttons", Boolean.valueOf(this.h));
    L10:
        Mq(!this.h, new b(false, false, false, false, 31));
        Cq().getLandscapeInteractionInfo().setValue(Aq(this.h, false, false));
        return;
    L11:
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L14;
        r2.put("data_is_hiding_landscape_buttons", Boolean.valueOf(this.g));
    L14:
        Lq(!this.g, new b(!this.C, false, false, false, 30));
        Cq().getLandscapeInteractionInfo().setValue(Aq(this.g, false, false));
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.landscape.u
    public final void qb() {
        Disposable r0 = this.q;
        if (r0 != null) goto L5;
    L10:
        IVisibilityControlBrickService r1 = jc1.k.f(IVisibilityControlBrickService.class);
        if (r1 == null) goto L16;
        IVisibilityControlService r2 = r1.provideVisibilityControlService(((Widget) this).dataCenter);
        if (r2 == null) goto L17;
        r2.stopVisibilityTimer();
        return;
    L17:
        return;
    L16:
        return;
    L5:
        if (r0.isDisposed() == false) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        r0.dispose();
        goto L10
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.landscape.u
    public final void zj() {
        if (this.g == false) goto L5;
        return;
    L5:
        Nq(true, new b(!this.C, false, false, false, 30));
    }

    public final boolean Jq() {
        DataCenter r0 = getDataCenter();
        if (r0 == null) goto L13;
        IAbilityCenter r1 = a0.a(r0);
        if (r1 == null) goto L13;
        IRoomRecordService r2 = r1.getAbility(IRoomRecordService.class);
        if (r2 == null) goto L13;
        if (r2.isRecording() != true) goto L13;
        if (com.bytedance.android.livesdk.service.l.d().e().isClearScreen() == false) goto L13;
        return true;
    L13:
        return false;
    }

    public final void onPause() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
        qb();
    }

    public final void onUnload() {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        ho1.a.q(getComponentContext(), u.class);
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.put("data_is_hiding_landscape_buttons", Boolean.FALSE);
    L5:
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L9;
        r1.removeObserver(this);
    L9:
        if (this.u == 0) goto L11;
        this.z += System.currentTimeMillis() - this.u;
        this.u = 0;
    L11:
        DataCenter r2 = ((Widget) this).dataCenter;
        Room r3 = this.r;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L14:
        com.bytedance.android.livesdk.castscreen.utils.f.b("landscape_room_interaction_show", r2, r3, new LandscapeVisibilityControllerWidget$logLandScapeShowPv$1(this));
        this.z = 0;
    }

    public final void Gq(int r4) {
        if (((Boolean) l42.a.g.getValue()).booleanValue() == true) goto L7;
        if (r4 != 0) goto L7;
        ((Widget) this).dataCenter.put("data_landscape_left_bottom_banner_visible", Boolean.TRUE);
    L7:
        if (r4 != 8) goto L10;
        ((Widget) this).dataCenter.put("data_landscape_left_bottom_banner_visible", Boolean.FALSE);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.landscape.u
    public final void Lm(boolean r1) {
        this.B = r1;
    }

    public final void Pq(int r3) {
        DiggContext.a r0 = DiggContext.Companion;
        DataCenter r1 = ((Widget) this).dataCenter;
        r0.getClass();
        DiggContext r2 = DiggContext.a.a(r1);
        if (r2 == null) goto L10;
        com.bytedance.live.datacontext.n r4 = r2.getDiggWidget();
        if (r4 == null) goto L11;
        u32.k r5 = (u32.k) r4.getValue();
        if (r5 == null) goto L12;
        r5.A9(r3);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void Tq(boolean r4) {
        FrameLayout r0 = (FrameLayout) this.D.findViewById(2131387099);
        if (r0 == null) goto L21;
        Room r1 = this.r;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L7:
        RoomAuthStatus r2 = r1.getRoomAuthStatus();
        int r3 = 8;
        if (r2 == null) goto L12;
        if (r2.isEnableLandscapeChat() == true) goto L12;
    L19:
        r0.setVisibility(r3);
        return;
    L12:
        if (((Boolean) l42.a.g.getValue()).booleanValue() == true) goto L19;
        if (Jq() == true) goto L19;
        if (r4 == true) goto L19;
        r3 = 0;
        goto L19
    }

    public final void onChanged(Object r11) {
        KVData r12 = (KVData) r11;
        if (isViewValid() == false) goto L95;
        String r0 = null;
        if (r12 == null) goto L7;
        String r1 = r12.getKey();
    L8:
        boolean r2 = true;
        if (r1 != null) goto L11;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == true) goto L120;
        if (r12 == null) goto L19;
        r0 = r12.getKey();
    L19:
        if (r0 != null) goto L22;
        return;
    L22:
        switch(r0.hashCode()) {
            case -2059899161: goto L92;
            case -1978218576: goto L89;
            case 114183855: goto L86;
            case 294674590: goto L71;
            case 518467862: goto L68;
            case 581896896: goto L60;
            case 966223177: goto L57;
            case 1060055221: goto L54;
            case 1510387652: goto L51;
            case 1722450802: goto L48;
            case 1804595966: goto L39;
            case 1871873441: goto L28;
            case 2143307222: goto L25;
            default: goto L122;
        };
    L122:
        return;
    L25:
        if (r0.equals("cmd_wanna_follow_anchor") == false) goto L96;
        Hj();
        return;
    L96:
        return;
    L28:
        if (r0.equals("data_room_comment_status") == true) goto L30;
        return;
    L30:
        if (Iq() == false) goto L99;
        Room r13 = this.r;
        if (r13 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L35:
        if (com.bytedance.android.livesdk.utils.landscape.e.a(r13) == false) goto L37;
        Sq(this, 0, 4);
        return;
    L37:
        Sq(this, 8, 4);
        return;
    L99:
        return;
    L39:
        if (r0.equals("cmd_video_is_seeking") == false) goto L102;
        Boolean r14 = (Boolean) r12.getData();
        if (r14 != null) goto L44;
        r14 = Boolean.FALSE;
    L44:
        if (r14.booleanValue() == false) goto L46;
        qb();
        return;
    L46:
        Hj();
        return;
    L102:
        return;
    L48:
        if (r0.equals("cmd_show_user_profile") == false) goto L105;
    L93:
        Nq(false, new b(!this.C, false, false, false, 30));
        return;
    L105:
        return;
    L51:
        if (r0.equals("cmd_show_record_finished_dialog") == true) goto L93;
        return;
    L54:
        if (r0.equals("data_keyboard_status") == false) goto L107;
    L72:
        Boolean r15 = (Boolean) r12.getData();
        if (r15 != null) goto L75;
        r15 = Boolean.TRUE;
    L75:
        boolean r16 = r15.booleanValue();
        if (r16 == false) goto L78;
        qb();
    L79:
        if (r16 == false) goto L81;
    L83:
        r2 = false;
    L84:
        Nq(r2, new b(false, false, true, false, 27));
        return;
    L81:
        if (this.v == false) goto L83;
    L78:
        Hj();
        goto L79
    L107:
        return;
    L57:
        if (r0.equals("cmd_start_replay") == false) goto L108;
        Sq(this, 8, 4);
        return;
    L108:
        return;
    L60:
        if (r0.equals("cmd_change_landscape_visibility") == false) goto L110;
        Boolean r17 = (Boolean) r12.getData();
        if (r17 != null) goto L64;
        r17 = Boolean.FALSE;
    L64:
        boolean r18 = r17.booleanValue();
        if (r18 == this.g) goto L111;
        setVisibility(r18);
        return;
    L111:
        return;
    L110:
        return;
    L68:
        if (r0.equals("cmd_on_money_not_enough") == true) goto L93;
        return;
    L71:
        if (r0.equals("data_keyboard_status_douyin") == true) goto L72;
        return;
    L86:
        if (r0.equals("cmd_show_fans_club_dialog") == true) goto L93;
        return;
    L89:
        if (r0.equals("cmd_show_lucky_box_dialog") == false) goto L117;
        setVisibility(false);
        return;
    L117:
        return;
    L92:
        if (r0.equals("cmd_show_landscape_rank_info_dialog") == true) goto L93;
        return;
    L120:
        return;
    L11:
        if (r1.length() == 0) goto L14;
        r3 = false;
        goto L15
    L7:
        r1 = null;
        goto L8
    }

    public final void onEvent(e3 r14) {
        Intrinsics.checkNotNullParameter(r14, "event");
        if (com.bytedance.android.livesdk.utils.landscape.d.c(((Widget) this).dataCenter) == false) goto L5;
        return;
    L5:
        Kq();
        if (r14.b == false) goto L8;
        int r0 = 8;
    L9:
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L12;
        boolean r4 = ((Boolean) r3.get("data_predictor_entrance_can_show", Boolean.FALSE)).booleanValue();
    L14:
        if (r0 != 0) goto L42;
        if (r4 == false) goto L19;
        View r5 = this.D.findViewById(2131377137);
        if (r5 == null) goto L48;
        r5.setVisibility(8);
    L48:
        Room r6 = this.r;
        if (r6 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L52:
        if (r6.isMediaRoom() == true) goto L56;
        View r1 = this.D.findViewById(2131377138);
        if (r1 == null) goto L59;
        r1.setVisibility(r0);
    L59:
        Fq(new b(false, false, false, false, 31), false);
        Gq(r0);
        View r2 = this.D.findViewById(2131377119);
        if (r2 == null) goto L62;
        r2.setVisibility(r0);
    L62:
        Room r7 = this.r;
        if (r7 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L66:
        if (r7.isMediaRoom() == false) goto L70;
        View r8 = this.D.findViewById(2131386364);
        if (r8 == null) goto L70;
        r8.setVisibility(r0);
    L70:
        xs2.b r9 = xs2.b.a();
        if (r14.b == false) goto L73;
        int r10 = 3;
    L74:
        r9.post(new HorizontalPlayEvent(r10));
        Pq(r0);
        if (Iq() == false) goto L77;
        Rq(r0, true, r14.a);
        Tq(this.C);
        return;
    L77:
        Room r11 = this.r;
        if (r11 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L81:
        if (r11.isMediaRoom() == true) goto L85;
        Cq().getToolbarLandscapeBlock().setValue(Boolean.valueOf(r14.b));
        return;
    L85:
        return;
    L73:
        r10 = 4;
        goto L74
    L56:
        View r12 = this.D.findViewById(2131377138);
        if (r12 == null) goto L59;
        r12.setVisibility(8);
        goto L59
    L19:
        View r13 = this.D.findViewById(2131377130);
        if (r13 == null) goto L22;
        r13.setVisibility(8);
    L22:
        DataCenter r15 = ((Widget) this).dataCenter;
        if (r15 == null) goto L27;
        Integer r16 = (Integer) r15.get("data_activity_banner_number", 0);
        if (r16 == null) goto L27;
        int r17 = r16.intValue();
    L28:
        if (r17 <= 0) goto L39;
        Room r18 = this.r;
        if (r18 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L32:
        RoomAuthStatus r19 = r18.getRoomAuthStatus();
        if (r19 == null) goto L39;
        if (r19.enableBanner() != true) goto L39;
        View r20 = this.D.findViewById(2131377137);
        if (r20 == null) goto L48;
        r20.setVisibility(r0);
    L39:
        View r21 = this.D.findViewById(2131377137);
        if (r21 == null) goto L48;
        r21.setVisibility(8);
    L27:
        r17 = 0;
        goto L28
    L42:
        View r22 = this.D.findViewById(2131377137);
        if (r22 == null) goto L45;
        r22.setVisibility(r0);
    L45:
        View r23 = this.D.findViewById(2131377130);
        if (r23 == null) goto L48;
        r23.setVisibility(r0);
        goto L48
    L12:
        r4 = false;
        goto L14
    L8:
        r0 = 0;
        goto L9
    }

    public final void onLoad(Object[] r9) {
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        DataCenter r10 = ((Widget) this).dataCenter;
        if (r10 == null) goto L122;
        Room r11 = (Room) r10.get("data_room");
        if (r11 == null) goto L124;
        this.r = r11;
        DataCenter r12 = ((Widget) this).dataCenter;
        if (r12 == null) goto L12;
        Boolean r13 = (Boolean) r12.get("data_is_anchor");
        if (r13 == null) goto L12;
        boolean r14 = r13.booleanValue();
    L13:
        this.s = r14;
        if (jc1.k.f(IMicRoomService.class) != null) goto L17;
        this.b.add(2131377127);
    L17:
        if (tb1.c.a == false) goto L23;
        Room r15 = this.r;
        if (r15 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L22:
        if (r15.isMediaRoom() == true) goto L23;
    L24:
        Room r16 = this.r;
        if (r16 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L28:
        if (r16.isMediaRoom() == false) goto L30;
        this.b.add(2131377118);
    L30:
        this.j.clear();
        this.l.clear();
        this.m.clear();
        this.k.clear();
        this.i.clear();
        ViewStub r17 = (ViewStub) this.D.findViewById(2131377119);
        if (r17 == null) goto L33;
        r17.inflate();
    L33:
        Iterator<T> r18 = this.b.iterator();
    L35:
        if (r18.hasNext() == false) goto L37;
        int r2 = ((Number) r18.next()).intValue();
        this.i.put(r2, this.D.findViewById(r2));
        goto L35
    L37:
        int[] r19 = this.d;
        ArrayList r3 = new ArrayList();
        int r4 = r19.length;
        int r5 = 0;
    L38:
        boolean r6 = true;
        if (r5 >= r4) goto L49;
        int r7 = r19[r5];
        if (com.bytedance.android.livesdk.utils.landscape.d.c(((Widget) this).dataCenter) == true) goto L43;
    L45:
        r6 = false;
    L46:
        if (r6 == true) goto L48;
        r3.add(Integer.valueOf(r7));
    L48:
        r5 = r5 + 1;
        goto L38
    L43:
        if (r7 != 2131377138) goto L45;
    L49:
        Iterator r20 = r3.iterator();
    L51:
        if (r20.hasNext() == false) goto L53;
        int r8 = ((Number) r20.next()).intValue();
        this.j.put(r8, this.D.findViewById(r8));
        goto L51
    L53:
        int[] r21 = this.e;
        int r22 = r21.length;
        int r23 = 0;
    L54:
        if (r23 >= r22) goto L56;
        int r24 = r21[r23];
        this.l.put(r24, this.D.findViewById(r24));
        r23 = r23 + 1;
        goto L54
    L56:
        Iterator<T> r25 = this.f.iterator();
    L58:
        if (r25.hasNext() == false) goto L60;
        int r26 = ((Number) r25.next()).intValue();
        this.k.put(r26, this.D.findViewById(r26));
        goto L58
    L60:
        Iterator r27 = ((LinkedHashMap) this.c).entrySet().iterator();
    L62:
        if (r27.hasNext() == false) goto L65;
        int r28 = ((Number) ((Map.Entry) r27.next()).getKey()).intValue();
        this.m.put(r28, this.D.findViewById(r28));
        goto L62
    L65:
        if (Iq() == false) goto L67;
        Sq(this, 0, 4);
    L80:
        Bq();
        Qq();
        L7(e3.class, new f(this));
        L7(w0.class, new g(this));
        L7(zt2.a.class, new h(this));
        L7(do1.b.class, new i(this));
        ((ObservableSubscribeProxy) RxBusAbility.INSTANCE.getRxBus(a0.p(((Widget) this).dataCenter)).b(o2.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new j(this));
        L7(UserProfileEvent.class, new k(this));
        L7(o3.class, new l(this));
        L7(f0.class, new m(this));
        DataCenter r29 = ((Widget) this).dataCenter;
        if (r29 == null) goto L83;
        r29.put("data_is_hiding_landscape_buttons", Boolean.FALSE);
    L83:
        DataCenter r30 = ((Widget) this).dataCenter;
        if (r30 == null) goto L110;
        DataCenter r31 = r30.observeForever("data_keyboard_status", this);
        if (r31 == null) goto L110;
        DataCenter r32 = r31.observeForever("data_keyboard_status_douyin", this);
        if (r32 == null) goto L110;
        DataCenter r33 = r32.observe("cmd_wanna_follow_anchor", this);
        if (r33 == null) goto L110;
        DataCenter r34 = r33.observe("cmd_on_money_not_enough", this);
        if (r34 == null) goto L110;
        DataCenter r35 = r34.observe("cmd_show_fans_club_dialog", this);
        if (r35 == null) goto L110;
        DataCenter r36 = r35.observe("cmd_show_landscape_rank_info_dialog", this);
        if (r36 == null) goto L110;
        DataCenter r37 = r36.observe("cmd_show_user_profile", this);
        if (r37 == null) goto L110;
        DataCenter r38 = r37.observe("cmd_video_is_seeking", this);
        if (r38 == null) goto L110;
        DataCenter r39 = r38.observe("cmd_show_lucky_box_dialog", this);
        if (r39 == null) goto L110;
        DataCenter r40 = r39.observe("data_room_comment_status", this);
        if (r40 == null) goto L110;
        DataCenter r41 = r40.observe("cmd_start_replay", this);
        if (r41 == null) goto L110;
        DataCenter r42 = r41.observe("cmd_show_record_finished_dialog", this);
        if (r42 == null) goto L110;
        r42.observe("cmd_change_landscape_visibility", this);
    L110:
        int r43 = com.bytedance.android.livesdk.utils.landscape.d.a;
        com.bytedance.android.livesdk.f.d().a.observe(this, new n(this));
        Cq().isLocked().observe(this, new c(this));
        Cq().isInRefreshing().observe(this, new d(this));
        Cq().isInZoomState().observe(this, new e(this));
        this.u = System.currentTimeMillis();
        this.t++;
        if (ho1.a.o(getComponentContext()) == false) goto L123;
        ho1.a.p(getComponentContext(), u.class, this);
        return;
    L123:
        return;
    L67:
        View r44 = this.D.findViewById(2131380026);
        if (r44 == null) goto L80;
        Room r0 = this.r;
        if (r0 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L72:
        RoomAuthStatus r1 = r0.getRoomAuthStatus();
        if (r1 == null) goto L77;
        if (r1.isEnableLandscapeChat() == true) goto L77;
    L79:
        r44.setVisibility(8);
    L77:
        if (((Boolean) l42.a.g.getValue()).booleanValue() == true) goto L79;
        Jq();
    L23:
        this.f.remove(2131378457);
        this.f.remove(2131377121);
        this.b.add(2131378457);
        this.b.add(2131377121);
    L12:
        r14 = false;
        goto L13
    L124:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.landscape.u
    public final void setVisibility(boolean r8) {
        Nq(r8, new b(false, false, false, false, 31));
    }

    public final void xq(boolean r8) {
        Iterator r0 = ((LinkedHashMap) this.c).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L21;
        Map.Entry r1 = (Map.Entry) r0.next();
        int r2 = ((Number) r1.getKey()).intValue();
        float r3 = ((Number) r1.getValue()).floatValue();
        int[] r4 = new int[2];
        View r5 = Eq(this.m, r2);
        if (r5 == null) goto L8;
        r5.getLocationInWindow(r4);
    L8:
        int r6 = 0;
        if (this.n.get(r2) != null) goto L15;
        int r7 = x1.h();
        int r9 = r4[1];
        View r10 = Eq(this.m, r2);
        if (r10 == null) goto L13;
        int r11 = r10.getHeight();
    L14:
        int r12 = r7 - (r9 + r11);
        this.n.put(r2, Integer.valueOf(r12 - s1.f(r3)));
        goto L15
    L13:
        r11 = 0;
    L15:
        View r13 = Eq(this.m, r2);
        if (r8 == false) goto L20;
        Integer r14 = this.n.get(r2);
        if (r14 == null) goto L20;
        r6 = r14.intValue();
    L20:
        translateY(r13, r6);
        goto L4
    }

    public final void onEvent(w0 r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if (m50.a.getValue().e() == true) goto L5;
        View r0 = this.D.findViewById(2131387103);
        if (r0 != null) goto L13;
        return;
    L13:
        if (r3.a == false) goto L15;
        UtilityKotlinExtentionsKt.w(r0);
        return;
    L15:
        UtilityKotlinExtentionsKt.u(r0);
        return;
    L5:
        if (r3.a == false) goto L7;
        int r4 = 0;
    L8:
        Rq(r4, true, false);
        return;
    L7:
        r4 = 8;
        goto L8
    }

    private final void onEvent(do1.b r2) {
        if (((Boolean) this.w.getValue()).booleanValue() == true) goto L6;
        Cq().getToolbarHideOrShowWithAnim().setValue(Boolean.TRUE);
        return;
    }

    public static final /* synthetic */ void wq(LandscapeVisibilityControllerWidget r0, do1.b r1) {
        r0.onEvent(r1);
    }

    public final View Eq(SparseArray<View> r2, int r3) {
        if (r2 == null) goto L4;
        View r0 = r2.get(r3);
    L5:
        if (r0 != null) goto L9;
        r0 = this.D.findViewById(r3);
        if (r2 == null) goto L9;
        r2.put(r3, r0);
    L9:
        return r0;
    L4:
        r0 = null;
        goto L5
    }

    public final void Fq(b r4, boolean r5) {
        if (((Boolean) l42.a.g.getValue()).booleanValue() == false) goto L15;
        View r6 = this.D.findViewById(2131362176);
        if (r6 == null) goto L7;
        r6.setVisibility(8);
    L7:
        View r7 = this.D.findViewById(2131377137);
        if (r7 == null) goto L10;
        r7.setVisibility(8);
    L10:
        View r8 = this.D.findViewById(2131377138);
        if (r8 == null) goto L30;
        r8.setVisibility(8);
        return;
    L30:
        return;
    L15:
        if (r4.c == false) goto L19;
        if (r5 == true) goto L19;
        return;
    L19:
        if (i3.a(this.s) != 0) goto L21;
        boolean r9 = true;
    L22:
        if (r9 == false) goto L26;
        View r10 = this.D.findViewById(2131362176);
        if (r10 == null) goto L31;
        r10.setVisibility(0);
        return;
    L31:
        return;
    L26:
        View r11 = this.D.findViewById(2131362176);
        if (r11 == null) goto L33;
        r11.setVisibility(8);
        return;
    L33:
        return;
    L21:
        r9 = false;
        goto L22
    }

    public final <T> void L7(Class<T> r2, Consumer<T> r3) {
        ((ObservableSubscribeProxy) xs2.b.a().b(r2).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r3);
    }

    public final void Lq(boolean r10, b r11) {
        if (isViewValid() == true) goto L6;
        return;
    L6:
        if (r10 == false) goto L8;
        this.u = System.currentTimeMillis();
        this.t++;
    L8:
        if (r10 == true) goto L13;
        if (this.u == 0) goto L13;
        this.z += System.currentTimeMillis() - this.u;
        this.u = 0;
    L13:
        if (((Boolean) this.y.getValue()).booleanValue() == true) goto L15;
    L19:
        this.g = r10;
        IVisibilityControlBrickService r1 = jc1.k.f(IVisibilityControlBrickService.class);
        if (r1 == null) goto L24;
        IVisibilityControlService r2 = r1.provideVisibilityControlService(((Widget) this).dataCenter);
        if (r2 == null) goto L24;
        r2.setVisibilityStatus(r10);
    L24:
        if (r10 == true) goto L26;
    L28:
        int[] r3 = this.d;
        ArrayList r4 = new ArrayList();
        int r5 = r3.length;
        int r6 = 0;
        int r7 = 0;
    L30:
        if (r7 >= r5) goto L39;
        int r8 = r3[r7];
        if (com.bytedance.android.livesdk.utils.landscape.d.c(((Widget) this).dataCenter) == false) goto L35;
        if (r8 != 2131377138) goto L35;
        boolean r9 = true;
    L36:
        if (r9 == true) goto L38;
        r4.add(Integer.valueOf(r8));
    L38:
        r7 = r7 + 1;
    L35:
        r9 = false;
        goto L36
    L39:
        Iterator r12 = r4.iterator();
    L40:
        int r13 = 8;
        if (r12.hasNext() == false) goto L47;
        View r14 = Eq(this.j, ((Number) r12.next()).intValue());
        if (r14 == null) goto L40;
        if (r10 == false) goto L46;
        r13 = 0;
    L46:
        r14.setVisibility(r13);
        goto L40
    L47:
        if (r10 == true) goto L50;
        r6 = 8;
    L50:
        Wq(r6, r11);
        Qq();
        yq(!r10, r11);
        xq(!r10);
        zq(!r10, r11);
        Pq(r6);
        DataCenter r15 = ((Widget) this).dataCenter;
        if (r15 == null) goto L53;
        boolean r16 = ((Boolean) r15.get("data_is_portrait", Boolean.TRUE)).booleanValue();
    L54:
        if (r16 == true) goto L57;
        int r17 = com.bytedance.android.livesdk.utils.landscape.d.a;
        if ((true ^ r16) == true) goto L57;
    L62:
        View r0 = this.D.findViewById(2131377138);
        if (r0 == null) goto L65;
        r0.setVisibility(8);
    L65:
        Fq(r11, r10);
        if (r11.b == true) goto L68;
        return;
    L68:
        if (((Boolean) this.x.getValue()).booleanValue() == false) goto L81;
        ((Widget) this).dataCenter.put("data_landscape_right_card_visible_from_lock", Boolean.valueOf(r10));
        return;
    L81:
        return;
    L57:
        Room r18 = this.r;
        if (r18 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L61:
        if (r18.isMediaRoom() == false) goto L65;
    L53:
        r16 = true;
        goto L54
    L26:
        if (this.C == false) goto L28;
        return;
    L15:
        if (r11.b == true) goto L19;
        if (this.g != r10) goto L19;
    }

    public final void Mq(boolean r6, b r7) {
        this.h = r6;
        ALogger.d("visibilityControlTag", "设置Landscape中view的显隐，同步控制LiveVisibilityControl中的visible值为" + r6);
        IVisibilityControlBrickService r0 = jc1.k.f(IVisibilityControlBrickService.class);
        if (r0 == null) goto L7;
        IVisibilityControlService r1 = r0.provideVisibilityControlService(((Widget) this).dataCenter);
        if (r1 == null) goto L7;
        r1.setVisibilityStatus(r6);
    L7:
        int r2 = 0;
        if (r6 == true) goto L26;
        View r3 = this.D.findViewById(2131386363);
        if (r3 == null) goto L12;
        r3.setVisibility(8);
    L12:
        View r4 = this.D.findViewById(2131386364);
        if (r4 == null) goto L15;
        r4.setVisibility(8);
    L15:
        View r5 = this.D.findViewById(2131377138);
        if (r5 == null) goto L18;
        r5.setVisibility(8);
    L18:
        View r8 = this.D.findViewById(2131377137);
        if (r8 == null) goto L21;
        r8.setVisibility(8);
    L21:
        View r9 = this.D.findViewById(2131377130);
        if (r9 == null) goto L24;
        r9.setVisibility(8);
    L24:
        Fq(r7, r6);
    L33:
        if (r6 == true) goto L35;
    L37:
        yq(!r6, r7);
        xq(!r6);
        zq(!r6, r7);
        if (r6 == true) goto L41;
        r2 = 8;
    L41:
        Pq(r2);
        if (Iq() == false) goto L44;
        Tq(this.C);
    L44:
        Fq(r7, r6);
        return;
    L35:
        if (this.C == false) goto L37;
        return;
    L26:
        if (this.C == true) goto L33;
        View r10 = this.D.findViewById(2131386363);
        if (r10 == null) goto L30;
        r10.setVisibility(0);
    L30:
        View r11 = this.D.findViewById(2131386364);
        if (r11 == null) goto L33;
        r11.setVisibility(0);
        goto L33
    }

    public final void Nq(boolean r4, b r5) {
        if (isAlive() == true) goto L5;
        return;
    L5:
        Bq();
        if (Jq() == false) goto L8;
        return;
    L8:
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L11;
        r0.put("data_is_hiding_landscape_buttons", Boolean.valueOf(!r4));
    L11:
        Cq().getLandscapeInteractionInfo().setValue(Aq(r4, r5.b, r5.c));
        Room r1 = this.r;
        if (r1 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L15:
        if (r1.isMediaRoom() == false) goto L17;
        Mq(r4, r5);
    L18:
        Hj();
        Fq(r5, r4);
        return;
    L17:
        Lq(r4, r5);
        goto L18
    }

    public final void Wq(int r8, b r9) {
        int r0 = 0;
        if (r8 != 8) goto L36;
        ((ArrayList) this.o).clear();
        View r10 = this.D.findViewById(2131362082);
        if (r10 == null) goto L7;
        LinearLayout r11 = (LinearLayout) r10;
    L8:
        if (r11 == null) goto L10;
        int r12 = r11.getChildCount();
    L11:
        if (r0 >= r12) goto L69;
        View r4 = ((LinearLayout) this.D.findViewById(2131362082)).getChildAt(r0);
        if (r4.getVisibility() == 8) goto L35;
        Object r5 = r4.getTag();
        if (r9.a == false) goto L22;
        if (CollectionsKt.contains(G, r5) == true) goto L35;
        if (r5 == ToolbarButton.GIFT) goto L35;
    L22:
        if (r9.d == true) goto L24;
    L26:
        ((ArrayList) this.o).add(r4);
        ToolbarButton r6 = ToolbarButton.INTERACTION;
        if (r5 != r6) goto L30;
        y3.m(((Widget) this).dataCenter).b(r6, new pp1.f(8));
        goto L35
    L30:
        if ((r5 instanceof ToolbarButton) == true) goto L32;
        r5 = null;
    L32:
        ToolbarButton r7 = (ToolbarButton) r5;
        if (r7 == null) goto L35;
        y3.m(((Widget) this).dataCenter).c(r7.extended());
        goto L35
    L24:
        if (r5 != ToolbarButton.INTERACTION) goto L26;
    L35:
        r0 = r0 + 1;
        goto L11
    L69:
        return;
    L10:
        r12 = 0;
        goto L11
    L7:
        r11 = null;
        goto L8
    L36:
        Iterator<T> r13 = this.o.iterator();
    L38:
        if (r13.hasNext() == false) goto L92;
        View r2 = (View) r13.next();
        if (r2 == null) goto L42;
        Object r3 = r2.getTag();
    L44:
        if ((r3 instanceof ToolbarButton) == true) goto L46;
        r3 = null;
    L46:
        ToolbarButton r14 = (ToolbarButton) r3;
        if (r14 == null) goto L38;
        c0 r15 = y3.m(((Widget) this).dataCenter);
        if ((r15 instanceof x3) == true) goto L51;
        r15 = null;
    L51:
        x3 r16 = (x3) r15;
        if (r16 == null) goto L54;
        c0.b r17 = r16.t(r14);
    L55:
        if (r17 == null) goto L57;
        boolean r18 = true;
    L58:
        if (r18 == true) goto L61;
        r14 = null;
    L61:
        if (r14 == null) goto L38;
        ToolbarButton r19 = ToolbarButton.INTERACTION;
        if (r14 == r19) goto L64;
        ToolbarButton r20 = ToolbarButton.COMMERCE;
        if (r14 == r20) goto L67;
        y3.m(((Widget) this).dataCenter).c(r14.extended());
        goto L38
    L67:
        y3.m(((Widget) this).dataCenter).b(r20, new pp1.f(r8));
        goto L38
    L64:
        y3.m(((Widget) this).dataCenter).b(r19, new pp1.f(r8));
        goto L38
    L57:
        r18 = false;
        goto L58
    L54:
        r17 = null;
        goto L55
    L42:
        r3 = null;
        goto L44
    }

    public final void translateY(View r3, int r4) {
        if (r3 == null) goto L11;
        ViewPropertyAnimator r5 = r3.animate();
        if (r5 == null) goto L12;
        ViewPropertyAnimator r6 = r5.setDuration(this.a);
        if (r6 == null) goto L13;
        ViewPropertyAnimator r7 = r6.translationY(r4);
        if (r7 == null) goto L14;
        r7.start();
        return;
    L14:
        return;
    L13:
        return;
    L12:
        return;
    }

    public final void yq(boolean r10, b r11) {
        int[] r0 = this.e;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L25;
        int r4 = r0[r3];
        Wq(0, r11);
        if (r4 == 2131384185) goto L9;
        if (r4 == 2131364502) goto L9;
        int r5 = s1.f(100.0f);
    L20:
        View r6 = Eq(this.l, r4);
        if (r10 == true) goto L24;
        r5 = 0;
    L24:
        translateY(r6, r5);
        r3 = r3 + 1;
    L9:
        Integer r7 = os.a.getValue();
        if (r7 != null) goto L13;
    L15:
        View r8 = this.D.findViewById(2131364502);
    L16:
        if (r8 == null) goto L18;
        int r9 = r8.getHeight();
    L19:
        r5 = r9 + s1.f(84.0f);
        goto L20
    L18:
        r9 = 0;
        goto L19
    L13:
        if (r7.intValue() != 1) goto L15;
        r8 = this.D.findViewById(2131384185);
        goto L16
    L25:
        if (r10 == true) goto L27;
        Cq().getToolbarHideOrShowWithAnim().setValue(Boolean.TRUE);
        return;
    L27:
        if (((Boolean) this.w.getValue()).booleanValue() == false) goto L30;
        Cq().getToolbarHideOrShowWithAnim().setValue(Boolean.FALSE);
        return;
    L30:
        if (r11.e == false) goto L33;
        Cq().getToolbarHideOrShowWithAnim().setValue(Boolean.TRUE);
    L33:
        if (r11.a == true) goto L41;
        Cq().getToolbarHideOrShowWithAnim().setValue(Boolean.FALSE);
        return;
    }

    public final void zq(boolean r14, b r15) {
        WidgetInfo r0 = getWidgetInfo(ActivityTopBannerWidget.class);
        if (r0 == null) goto L5;
        int r1 = r0.getContentViewHeight();
    L6:
        Room r2 = this.r;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L10:
        if (r2.isMediaRoom() == false) goto L12;
        int r3 = UtilityKotlinExtentionsKt.i(100);
    L13:
        int r4 = r3 + r1;
        Room r5 = this.r;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L17:
        if (r5.isMediaRoom() == true) goto L25;
        Room r6 = this.r;
        if (r6 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L22:
        if (r6.isMergeVSRoom() == true) goto L25;
        boolean r7 = false;
    L27:
        if (LandscapePhoneInfoShowUtils.a(Boolean.valueOf(r7)) == false) goto L29;
        r4 = r4 + UtilityKotlinExtentionsKt.i(20);
    L29:
        Set<Integer> r8 = this.f;
        ArrayList r9 = new ArrayList();
        Iterator<T> r10 = r8.iterator();
    L31:
        if (r10.hasNext() == false) goto L66;
        Object r11 = r10.next();
        int r12 = ((Number) r11).intValue();
        com.bytedance.android.livesdk.sharedpref.e r13 = l42.a.g;
        if (((Boolean) r13.getValue()).booleanValue() == false) goto L36;
        if (r12 != 2131377137) goto L36;
    L62:
        boolean r16 = true;
    L64:
        if (r16 == true) goto L31;
        r9.add(r11);
    L36:
        if (((Boolean) r13.getValue()).booleanValue() == false) goto L39;
        if (r12 == 2131362176) goto L62;
    L39:
        if (((Boolean) r13.getValue()).booleanValue() == false) goto L43;
        if (r12 == 2131377138) goto L62;
    L43:
        if (Jq() == false) goto L47;
        if (r12 == 2131377136) goto L62;
    L47:
        if (Jq() == false) goto L59;
        if (r12 != 2131389820) goto L51;
    L56:
        boolean r17 = true;
    L57:
        if (r17 == true) goto L62;
    L51:
        if (r12 == 2131389821) goto L56;
        if (r12 == 2131389817) goto L56;
        r17 = false;
    L59:
        if (VrUtils.u(((Widget) this).dataCenter, false) == true) goto L61;
    L63:
        r16 = false;
        goto L64
    L61:
        if (r12 != 2131374770) goto L63;
    L66:
        Iterator r18 = r9.iterator();
    L67:
        int r19 = 8;
        if (r18.hasNext() == false) goto L109;
        int r20 = ((Number) r18.next()).intValue();
        if (r15.c == false) goto L73;
        if (r20 != 2131362176) goto L73;
        if (r14 == false) goto L73;
    L96:
        if (r15.c == false) goto L103;
        if (r14 == false) goto L103;
        if (Iq() == false) goto L103;
        View r21 = Eq(this.k, r20);
        if (r21 == null) goto L67;
        r21.setTranslationY(-r4);
    L103:
        View r22 = Eq(this.k, r20);
        if (r14 == false) goto L106;
        int r23 = -r4;
    L107:
        translateY(r22, r23);
        goto L67
    L106:
        r23 = 0;
    L73:
        if (r20 == 2131377137) goto L77;
        View r24 = Eq(this.k, r20);
        if (r24 == null) goto L96;
        r24.setVisibility(0);
        goto L96
    L77:
        View r25 = Eq(this.k, r20);
        if (r25 == null) goto L96;
        Room r110 = this.r;
        if (r110 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L82:
        RoomAuthStatus r111 = r110.getRoomAuthStatus();
        if (r111 != null) goto L85;
    L94:
        r25.setVisibility(r19);
        goto L96
    L85:
        if (r111.enableBanner() != true) goto L94;
        DataCenter r112 = ((Widget) this).dataCenter;
        if (r112 == null) goto L91;
        Integer r113 = (Integer) r112.get("data_activity_banner_number", 0);
        if (r113 == null) goto L91;
        int r114 = r113.intValue();
    L92:
        if (r114 <= 0) goto L94;
        r19 = 0;
    L91:
        r114 = 0;
        goto L92
    L109:
        if (isViewValid() == false) goto L139;
        DataCenter r115 = ((Widget) this).dataCenter;
        if (r115 != null) goto L113;
        return;
    L113:
        if (((Boolean) r115.get("data_predictor_entrance_can_show", Boolean.FALSE)).booleanValue() == true) goto L117;
        View r116 = this.D.findViewById(2131377130);
        if (r116 == null) goto L141;
        r116.setVisibility(8);
        return;
    L141:
        return;
    L117:
        View r117 = this.D.findViewById(2131377137);
        if (r117 == null) goto L120;
        r117.setVisibility(8);
    L120:
        View r118 = this.D.findViewById(2131362176);
        if (r118 == null) goto L143;
        r118.setVisibility(8);
        return;
    L143:
        return;
    L139:
        return;
    L25:
        r7 = true;
        goto L27
    L12:
        r3 = UtilityKotlinExtentionsKt.i(92);
        goto L13
    L5:
        r1 = 0;
        goto L6
    }

    public LandscapeVisibilityControllerWidget(View r5, r r6, h80.d<LandscapeRootViewChangeManager> r7) {
        Intrinsics.checkNotNullParameter(r5, "rootView");
        Intrinsics.checkNotNullParameter(r7, "landscapeRootViewChangeManagerGetter");
        this.D = r5;
        this.E = r6;
        this.F = r7;
        this.a = 200;
        this.b = SetsKt.mutableSetOf(new Integer[]{2131378275, 2131374044});
        this.c = new LinkedHashMap();
        this.d = new int[]{2131377138, 2131377137, 2131377130, 2131362176, 2131377119, 2131385188};
        this.e = new int[]{2131377118, 2131384185, 2131364502, 2131385188, 2131383296};
        this.f = SetsKt.mutableSetOf(new Integer[]{2131389183, 2131377131, 2131392032, 2131389243, 2131389178, 2131377138, 2131377136, 2131378727, 2131377137, 2131377130, 2131362176, 2131378457, 2131389813, 2131389816, 2131389818, 2131389819, 2131389820, 2131389821, 2131389817, 2131374770, 2131377128, 2131388843});
        this.g = true;
        this.h = true;
        this.i = new SparseArray();
        this.j = new SparseArray();
        this.k = new SparseArray();
        this.l = new SparseArray();
        this.m = new SparseArray();
        this.n = new SparseArray();
        this.o = new ArrayList();
        this.v = true;
        this.w = LazyKt.lazy(LandscapeVisibilityControllerWidget$hideRightToolbarEnable$2.INSTANCE);
        this.x = LazyKt.lazy(LandscapeVisibilityControllerWidget$hideRightCardWhenLockedEnable$2.INSTANCE);
        this.y = LazyKt.lazy(LandscapeVisibilityControllerWidget$hideInteractionOpt$2.INSTANCE);
        this.A = LazyKt.lazy(new LandscapeVisibilityControllerWidget$interactionModel$2(this));
        this.B = true;
    }

    public static /* synthetic */ void Sq(LandscapeVisibilityControllerWidget r1, int r2, int r3) {
        if ((r3 & 2) == 0) goto L5;
        boolean r4 = true;
    L6:
        r1.Rq(r2, r4, false);
        return;
    L5:
        r4 = false;
        goto L6
    }

    public final LandscapeInteractionModel.b Aq(boolean r8, boolean r9, boolean r10) {
        float r3 = UtilityKotlinExtentionsKt.h(60.0f);
        WidgetInfo r0 = getWidgetInfo(ActivityTopBannerWidget.class);
        if (r0 == null) goto L5;
        int r1 = r0.getContentViewHeight();
    L6:
        Room r2 = this.r;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L10:
        if (r2.isMediaRoom() == false) goto L12;
        float r4 = UtilityKotlinExtentionsKt.h(100.0f);
    L14:
        return new LandscapeInteractionModel.b(r8, r3, r4 + r1, r9, r10);
    L12:
        r4 = UtilityKotlinExtentionsKt.h(92.0f);
        goto L14
    L5:
        r1 = 0;
        goto L6
    }

    public final void Rq(int r11, boolean r12, boolean r13) {
        r r4 = this.E;
        if (r4 != null) goto L5;
        return;
    L5:
        View r3 = this.D.findViewById(2131387103);
        if (r3 != null) goto L8;
        return;
    L8:
        IMediaReplayService r0 = jc1.k.f(IMediaReplayService.class);
        int r1 = r3.getVisibility();
        Room r2 = this.r;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L12:
        if (com.bytedance.android.livesdk.utils.landscape.e.a(r2) == true) goto L14;
    L23:
        r11 = 8;
    L24:
        if (r1 != r11) goto L28;
        if (r13 == true) goto L28;
        return;
    L28:
        if (r13 == false) goto L30;
        r12 = false;
    L30:
        if (r11 != 0) goto L32;
        boolean r14 = true;
    L33:
        Cq().getSplitAreaShow().setValue(Boolean.valueOf(r14));
        h80.d<LandscapeRootViewChangeManager> r5 = this.F;
        if (r5 == null) goto L41;
        LandscapeRootViewChangeManager r6 = (LandscapeRootViewChangeManager) r5.get();
        if (r6 == null) goto L41;
        r6.j = r14;
        if (r14 == true) goto L40;
        r6.b();
        goto L41
    L40:
        r6.d(2131381282, 0, 0);
        r6.e(0, 0);
    L41:
        float r7 = UtilityKotlinExtentionsKt.h(200.0f);
        if (r12 == false) goto L54;
        if (r14 == false) goto L53;
        int r8 = com.bytedance.android.livesdk.utils.landscape.d.a;
        View r9 = r4.k;
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        if (r10 == null) goto L52;
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r10;
        int r16 = r9.getWidth();
        int r17 = (r4.a.getWidth() - r16) / 2;
        r15.width = -1;
        r15.leftMargin = r17;
        r15.rightMargin = r17;
        r9.setLayoutParams(r15);
        int r18 = (int) r7;
        if (DigHoleScreenUtil.isDigHole(((Widget) this).context) == false) goto L49;
        int r19 = UIUtils.getStatusBarHeight(((Widget) this).context);
    L50:
        u4.c(new LandscapeVisibilityControllerWidget$updateSpiltAreaVisibility$1(this, r3, r7, r4, r17, r19, r18, r11)).c();
    L61:
        xs2.b.a().post(new y0(r14, r12));
        r.f(r14);
        return;
    L49:
        r19 = 0;
        goto L50
    L52:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L53:
        u4.c(new LandscapeVisibilityControllerWidget$updateSpiltAreaVisibility$3(this, r7, r3, r4, r11)).c();
        goto L61
    L54:
        r3.setVisibility(r11);
        if (DigHoleScreenUtil.isDigHole(((Widget) this).context) == false) goto L57;
        int r110 = UIUtils.getStatusBarHeight(((Widget) this).context);
    L58:
        if (r14 == false) goto L60;
        r4.d(r110, (int) r7);
        r4.c(ILandscapeSpiltManager.State.SHOW);
        goto L61
    L60:
        r4.d(r110, 0);
        r4.c(ILandscapeSpiltManager.State.HIDE);
        goto L61
    L57:
        r110 = 0;
        goto L58
    L32:
        r14 = false;
        goto L33
    L14:
        if (((Boolean) l42.a.g.getValue()).booleanValue() == true) goto L23;
        if (Jq() == true) goto L23;
        if (r0 == null) goto L24;
        Room r20 = this.r;
        if (r20 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("room");
    L22:
        if (r0.isReplaySync(r20.id) != true) goto L24;
        goto L23
    }
}
