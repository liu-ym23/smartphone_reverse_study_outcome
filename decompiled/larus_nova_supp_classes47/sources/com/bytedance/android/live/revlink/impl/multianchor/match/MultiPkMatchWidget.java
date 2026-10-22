package com.bytedance.android.live.revlink.impl.multianchor.match;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.k0;
import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import com.bytedance.android.live.revenue.common.v;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.android.live.revenue.platform.hybrid.impl.ui.HybridDialogImpl;
import com.bytedance.android.live.revlink.aio.impl.AutoMatchService;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.revlink.impl.model.BizType;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.pk.MultiAnchorRandomLinkMatchingDialog;
import com.bytedance.android.live.revlink.impl.multianchor.utils.AnchorLinkOptUtils;
import com.bytedance.android.live.revlink.impl.multianchor.utils.w;
import com.bytedance.android.live.revlink.impl.multianchor.utils.x;
import com.bytedance.android.live.revlink.impl.multianchor.utils.y;
import com.bytedance.android.live.revlink.impl.pk.service.RingDrawable;
import com.bytedance.android.live.revlink.impl.pk.service.ToolBarPic;
import com.bytedance.android.live.revlink.impl.pk.utils.AutoMatchSource;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkAutoMatchDataContext;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.p;
import com.bytedance.android.livesdk.link.model.IBattleLinkerInviteMessageExtra;
import com.bytedance.android.livesdk.link.model.b0;
import com.bytedance.android.livesdk.link.model.c0;
import com.bytedance.android.livesdk.link.model.e0;
import com.bytedance.android.livesdk.link.model.h0;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.j6;
import com.bytedance.android.livesdk.link.model.j8;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.android.livesdk.link.model.r4;
import com.bytedance.android.livesdk.link.model.v3;
import com.bytedance.android.livesdk.link.model.w1;
import com.bytedance.android.livesdk.link.model.w3;
import com.bytedance.android.livesdk.p8;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/match/MultiPkMatchWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Lcom/bytedance/android/live/revlink/impl/multianchor/match/a;", "Lcom/bytedance/android/live/revlink/impl/multianchor/match/g$b;", "<init>", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiPkMatchWidget extends LiveWidget implements com.bytedance.android.live.revlink.impl.multianchor.match.a, com.bytedance.android.live.revlink.impl.multianchor.match.g.b {
    public final CompositeDisposable a;
    public Disposable b;
    public Disposable c;
    public Disposable d;
    public int e;
    public boolean f;
    public com.bytedance.android.live.revlink.impl.multianchor.match.g g;
    public MultiPkMatchContext h;
    public final String i;
    public zy0.d j;
    public boolean k;
    public final com.bytedance.android.live.revenuelink.connect.f l;
    public MultiAnchorRandomLinkMatchingDialog m;
    public final b n;
    public final c o;
    public final a p;

    public static final class a<T> implements Observer {
        public final /* synthetic */ MultiPkMatchWidget a;

        public a(MultiPkMatchWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            if ((((ey.f) r1) instanceof ey.f.d) == false) goto L8;
            com.bytedance.android.live.revlink.impl.multianchor.match.g r2 = this.a.g;
            if (r2 == null) goto L9;
            r2.e();
            return;
        L9:
            return;
        }
    }

    public static final class b extends com.bytedance.android.live.revenuelink.connect.d {
        public final /* synthetic */ MultiPkMatchWidget a;

        public b(MultiPkMatchWidget r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void Cn(d11.g r1, Throwable r2, long r3, ey.l r5) {
            Intrinsics.checkNotNullParameter(r1, "params");
            Intrinsics.checkNotNullParameter(r1, "params");
            com.bytedance.android.live.revlink.impl.multianchor.match.g r4 = this.a.g;
            if (r4 == null) goto L6;
            r4.e();
            return;
        }

        @Override // com.bytedance.android.live.revenuelink.connect.d, com.bytedance.android.live.revenuelink.connect.m
        public final void rp(d11.d r1, Throwable r2, long r3, ey.l.b r5) {
            Intrinsics.checkNotNullParameter(r1, "params");
            Intrinsics.checkNotNullParameter(r1, "params");
            int r4 = r1.e;
            if (r4 != 4) goto L5;
        L8:
            boolean r6 = true;
        L9:
            if (r6 == true) goto L11;
        L13:
            com.bytedance.android.live.revlink.impl.multianchor.match.g r7 = this.a.g;
            if (r7 == null) goto L17;
            r7.e();
            return;
        L17:
            return;
        L11:
            if (r1.n != 2) goto L13;
            this.a.k = false;
            goto L13
        L5:
            if (r4 == 6) goto L8;
            r6 = false;
            goto L9
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ MultiPkMatchWidget a;

        public c(MultiPkMatchWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            if (Intrinsics.areEqual((q11.b) r3, q11.b.a.b) == false) goto L6;
            this.a.ni(1, "newPkDisabled");
            this.a.wq();
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ MultiPkMatchWidget a;

        public d(MultiPkMatchWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r12) {
            zg1.d r13 = (zg1.d) sh6.c.b((sh6.b) r12);
            if (r13 == null) goto L48;
            StringBuilder r0 = new StringBuilder();
            r0.append(r13);
            r0.append(' ');
            r0.append(this.a.xq());
            AnchorLinkOptUtils r3 = null;
            jy0.b.c("ttlive_anchor_link_match", r0.toString(), null, 4);
            if ((this.a.xq() instanceof com.bytedance.android.live.revlink.impl.multianchor.match.c.e) == false) goto L10;
            com.bytedance.android.live.revlink.impl.multianchor.match.g r1 = this.a.g;
            if (r1 == null) goto L10;
            r1.e();
        L10:
            boolean r2 = false;
            if (r13.b == false) goto L13;
        L15:
            boolean r4 = false;
        L16:
            if (r4 == true) goto L18;
            return;
        L18:
            if (this.a.xq().a == false) goto L44;
            k21.a r5 = com.bytedance.android.live.revlink.impl.global.b.E();
            if (r5 == null) goto L27;
            com.bytedance.android.live.revlink.impl.multianchor.match.c r6 = this.a.xq();
            Disposable r7 = this.a.c;
            if (r7 == null) goto L24;
            Boolean r8 = Boolean.valueOf(r7.isDisposed());
        L25:
            Intrinsics.checkNotNullParameter(r6, "matchStatus");
            LinkedHashMap r9 = new LinkedHashMap();
            r9.put("match_status", r6.toString());
            r9.put("match_type", Integer.valueOf(r6.b));
            r9.put("avatar_running", String.valueOf(r8));
            r5.b(r9);
            r5.f(r9);
            int r10 = v.a;
            v.h("ttlive_anchor_link_match", "multi_match_not_stop: " + r9);
            r5.n("multi_match_not_stop", r9);
            goto L27
        L24:
            r8 = null;
        L27:
            if (r13.a != 7) goto L29;
            boolean r14 = true;
        L30:
            if (r14 == false) goto L45;
            com.bytedance.android.live.revlink.impl.global.c r15 = com.bytedance.android.live.revlink.impl.global.b.k();
            if (r15 == null) goto L34;
            r3 = r15.vk();
        L34:
            if (r3 != null) goto L36;
            return;
        L36:
            if (r3.c() == true) goto L38;
        L40:
            if (r2 != true) goto L47;
            this.a.ni(1, "linkFinished");
            this.a.wq();
            return;
        L47:
            return;
        L38:
            if (r3.b().T2() == false) goto L40;
            r2 = true;
            goto L40
        L45:
            return;
        L29:
            r14 = false;
            goto L30
        L44:
            return;
        L13:
            if (r13.c == true) goto L15;
            r4 = true;
            goto L16
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ MultiPkMatchWidget a;

        public e(MultiPkMatchWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            this.a.f = false;
            com.bytedance.android.live.revlink.impl.pk.service.i r4 = com.bytedance.android.live.revlink.impl.global.b.h0();
            if (r4 == null) goto L6;
            r4.f3();
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ MultiPkMatchWidget a;

        public f(MultiPkMatchWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            Long r8 = (Long) r7;
            MultiPkMatchContext r9 = this.a.h;
            long r0 = 0;
            if (r9 == null) goto L9;
            com.bytedance.live.datacontext.m<Long> r10 = r9.getCountDownTime();
            if (r10 == null) goto L9;
            Long r12 = (Long) r10.getValue();
            if (r12 == null) goto L9;
            long r2 = r12.longValue();
        L10:
            long r3 = r2 - 1;
            if (r3 < 0) goto L14;
            r0 = r3;
        L14:
            long r4 = 59;
            if (1 <= r0) goto L18;
        L25:
            com.bytedance.android.live.revlink.impl.pk.service.i r13 = com.bytedance.android.live.revlink.impl.global.b.h0();
            if (r13 == null) goto L28;
            r13.setText("");
        L28:
            com.bytedance.android.live.revlink.impl.pk.service.i r14 = com.bytedance.android.live.revlink.impl.global.b.h0();
            if (r14 == null) goto L31;
            r14.Z2(this.a.i);
        L31:
            MultiPkMatchContext r15 = this.a.h;
            if (r15 == null) goto L37;
            com.bytedance.live.datacontext.m<Long> r16 = r15.getCountDownTime();
            if (r16 == null) goto L38;
            r16.setValue(Long.valueOf(r0));
            return;
        L38:
            return;
        L37:
            return;
        L18:
            if (r4 < r0) goto L25;
            com.bytedance.android.live.revlink.impl.pk.service.i r17 = com.bytedance.android.live.revlink.impl.global.b.h0();
            if (r17 == null) goto L22;
            r17.setText(String.valueOf(r0));
        L22:
            com.bytedance.android.live.revlink.impl.pk.service.i r18 = com.bytedance.android.live.revlink.impl.global.b.h0();
            if (r18 == null) goto L31;
            r18.i3();
        L9:
            r2 = 0;
            goto L10
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ MultiPkMatchWidget a;
        public final /* synthetic */ List b;

        public g(MultiPkMatchWidget r1, List r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Long r4 = (Long) r3;
            MultiPkMatchWidget r5 = this.a;
            int r0 = r5.e + 1;
            r5.e = r0;
            List r6 = this.b;
            if (r6 == null) goto L12;
            h0 r7 = (h0) ListProtector.get(r6, r0 % r6.size());
            if (r7 == null) goto L13;
            py.k r8 = r7.getAvatar();
            if (r8 == null) goto L14;
            com.bytedance.android.live.revlink.impl.pk.service.i r1 = com.bytedance.android.live.revlink.impl.global.b.h0();
            if (r1 == null) goto L15;
            r1.e3(r8);
            return;
        L15:
            return;
        L14:
            return;
        L13:
            return;
        }
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.match.a
    public final long Bj() {
        com.bytedance.android.live.revlink.impl.multianchor.match.g r0 = this.g;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.g;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.match.a
    public final b0 Dl() {
        MultiPkMatchContext r0 = this.h;
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.n<b0> r1 = r0.getSelfAutoMatchInfo();
        if (r1 == null) goto L7;
        return (b0) r1.getValue();
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.match.a
    public final void Wd() {
        b51.b r0 = b51.b.c0;
        r0.getClass();
        ReadOnlyProperty r1 = b51.b.D;
        KProperty[] r2 = b51.b.a;
        if (((Boolean) r1.getValue(r0, r2[28])).booleanValue() == false) goto L41;
        String r3 = (String) b51.b.F.getValue(r0, r2[30]);
        if (r3.length() <= 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L41;
        final x0 r5 = new x0(r3);
        x0 r6 = r5.d("url");
        com.bytedance.android.livesdk.revenue.service.room.c r7 = x11.c.a;
        if (r7 == null) goto L16;
        com.bytedance.android.livesdk.revenue.room.a r8 = r7.getRoomContext();
        if (r8 == null) goto L16;
        IRoom r9 = r8.getCommonRoom();
        if (r9 == null) goto L16;
        Long r10 = Long.valueOf(r9.getRoomId());
    L17:
        r6.b("room_id", String.valueOf(r10));
        IBaseUser r12 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).b();     // Catch: Exception -> L48
        if (r12 == null) goto L26;
        py.k r13 = r12.getAvatarThumbKt();     // Catch: Exception -> L48
        if (r13 == null) goto L26;
        List r14 = r13.getUrls();     // Catch: Exception -> L48
        if (r14 == null) goto L26;
        String r15 = (String) ListProtector.get(r14, 0);     // Catch: Exception -> L48
        if (r15 == null) goto L26;
    L27:
        r6.b("business_type", r41.b.a());
        r6.b("group", r41.b.a());
        r6.b("anchor_avatar", r15);
        MultiPkMatchContext r16 = this.h;
        if (r16 == null) goto L32;
        com.bytedance.live.datacontext.m<Long> r17 = r16.getCountDownTime();
        if (r17 == null) goto L32;
        Long r18 = (Long) r17.getValue();
    L33:
        r6.b("init_left_time", String.valueOf(r18));
        r6.b("match_type", String.valueOf(xq().b));
        yz0.g r19 = (yz0.g) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.g.class);
        if (r19 == null) goto L51;
        Context r20 = r19.getContext();
        if (r20 == null) goto L52;
        cy0.e.a.getClass();
        cy0.j r22 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r23 = com.bytedance.android.scope.m.b(r22).a(Reflection.getOrCreateKotlinClass(vy0.b.class));
        Intrinsics.checkNotNull(r23);
        HybridDialogImpl r24 = ((vy0.b) ((f80.a) r23)).U0(r20, r5.c(), null);
        this.j = r24;
        if (r24 == null) goto L53;
        r24.j0(new MultiPkMatchWidget$startMultiLinkMatchingDialog$$inlined$let$lambda$1(this, r5));
        return;
    L53:
        return;
    L52:
        return;
    L51:
        return;
    L32:
        r18 = null;
    L26:
        r15 = "";
    L16:
        r10 = null;
        goto L17
    L7:
        r4 = false;
    L41:
        MultiAnchorRandomLinkMatchingDialog r25 = this.m;
        if (r25 != null) goto L44;
    L46:
        MultiAnchorRandomLinkMatchingDialog r26 = new MultiAnchorRandomLinkMatchingDialog();
        this.m = r26;
        p8.a(r26, ((Widget) this).context);
        return;
    L44:
        if (r25.isShowing() != true) goto L46;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.match.a
    public final boolean Yj() {
        com.bytedance.android.live.revlink.impl.multianchor.match.g r0 = this.g;
        if (r0 == null) goto L5;
        boolean r1 = r0.l();
    L6:
        if (r1 == true) goto L8;
        return false;
    L8:
        if (x.d(xq().b) == false) goto L12;
        return true;
    L12:
        return false;
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.match.a
    public final Map<String, String> bb() {
        HashMap r0 = new HashMap();
        p0.a r1 = p0.Companion;
        MultiPkMatchContext r2 = this.h;
        if (r2 == null) goto L7;
        com.bytedance.live.datacontext.n<String> r3 = r2.getBattleAttachedInfo();
        if (r3 == null) goto L7;
        String r4 = (String) r3.getValue();
    L8:
        p0 r5 = e21.c.c(r1, r4);
        if (r5 == null) goto L12;
        String r6 = r5.getTraceID();
        if (r6 == null) goto L12;
    L13:
        r0.put("request_id", r6);
        com.bytedance.android.live.revlink.impl.multianchor.match.g r7 = this.g;
        if (r7 != null) goto L16;
    L18:
        String r8 = DataType.FALSE;
    L19:
        r0.put("if_strategy_invite", r8);
        return r0;
    L16:
        if (r7.i != true) goto L18;
        r8 = DataType.TRUE;
    L12:
        r6 = "";
    L7:
        r4 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.match.a
    public final ArrayList<com.bytedance.android.live.revlink.impl.multianchor.match.g.b> getListeners() {
        com.bytedance.android.live.revlink.impl.multianchor.match.g r0 = this.g;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.match.a
    public final long hj() {
        com.bytedance.android.live.revlink.impl.multianchor.match.g r0 = this.g;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.h;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.match.a
    public final boolean isMatching() {
        com.bytedance.android.live.revlink.impl.multianchor.match.g r0 = this.g;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.l();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.match.a
    public final boolean po() {
        com.bytedance.android.live.revlink.impl.multianchor.match.g r0 = this.g;
        if (r0 == null) goto L5;
        boolean r1 = r0.l();
    L6:
        if (r1 == false) goto L10;
        if (x.b(xq().b) == false) goto L10;
    L11:
        return true;
    L10:
        if ((xq() instanceof com.bytedance.android.live.revlink.impl.multianchor.match.c.e) == true) goto L11;
        return false;
    L5:
        r1 = false;
        goto L6
    }

    public final void wq() {
        jy0.b.f("ttlive_anchor_link_match", "clearMatchingStatus", null, 4);
        Disposable r0 = this.b;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        Disposable r1 = this.c;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        Disposable r2 = this.d;
        if (r2 == null) goto L11;
        r2.dispose();
    L11:
        com.bytedance.android.live.revlink.impl.pk.service.i r3 = com.bytedance.android.live.revlink.impl.global.b.h0();
        if (r3 == null) goto L14;
        r3.n3(!y.c());
    L14:
        com.bytedance.android.live.revlink.impl.service.internal.a r4 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r4 == null) goto L17;
        int r5 = r4.getCurrentMode();
    L19:
        if (gd0.v.a(r5, 64) == false) goto L24;
        com.bytedance.android.live.revlink.impl.pk.service.i r6 = com.bytedance.android.live.revlink.impl.global.b.h0();
        if (r6 == null) goto L24;
        r6.onMultiAnchorStateChange(2);
    L24:
        if (this.f == false) goto L29;
        com.bytedance.android.live.revlink.impl.pk.service.i r7 = com.bytedance.android.live.revlink.impl.global.b.h0();
        if (r7 == null) goto L28;
        r7.f3();
    L28:
        this.f = false;
    L29:
        com.bytedance.android.live.revlink.impl.service.internal.a r8 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r8 != null) goto L32;
    L36:
        this.k = false;
        return;
    L32:
        if (r8.k0(4) != true) goto L36;
        com.bytedance.android.live.revlink.impl.pk.service.i r9 = com.bytedance.android.live.revlink.impl.global.b.h0();
        if (r9 == null) goto L36;
        r9.W2(5);
        goto L36
    L17:
        r5 = 0;
        goto L19
    }

    public final com.bytedance.android.live.revlink.impl.multianchor.match.c xq() {
        MultiPkMatchContext r0 = this.h;
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.revlink.impl.multianchor.match.c> r1 = r0.getMatchStatus();
        if (r1 == null) goto L9;
        com.bytedance.android.live.revlink.impl.multianchor.match.c r2 = (com.bytedance.android.live.revlink.impl.multianchor.match.c) r1.getValue();
        if (r2 == null) goto L9;
        return r2;
    L9:
        return new com.bytedance.android.live.revlink.impl.multianchor.match.c.C0146c();
    }

    public MultiPkMatchWidget() {
        this.a = new CompositeDisposable();
        this.i = "https://" + k0.a + "/obj/live-android/ttlive_anim_pk_random_point.webp";
        this.l = com.bytedance.android.live.revlink.impl.global.b.a();
        this.n = new b(this);
        this.o = new c(this);
        this.p = new a(this);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.match.a
    public final void Bd() {
        Long r1 = null;
        if (xq().c == false) goto L6;
        jy0.b.f("ttlive_anchor_link_match", "speedUpMatch: already speedingUp, " + xq(), null, 4);
        return;
    L6:
        com.bytedance.android.live.revlink.impl.multianchor.match.g r0 = this.g;
        if (r0 != null) goto L9;
        return;
    L9:
        if (r41.b.a == false) goto L11;
        JSONObject r2 = new JSONObject();
        cy0.e.a.getClass();
        cy0.j r3 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r4 = com.bytedance.android.scope.m.b(r3).a(Reflection.getOrCreateKotlinClass(vy0.b.class));
        Intrinsics.checkNotNull(r4);
        ((vy0.b) ((f80.a) r4)).sendEventToAllJsBridges("H5_didTapSpeedUp", r2);
    L11:
        r0.o(new com.bytedance.android.live.revlink.impl.multianchor.match.c.b(r0.h().b, r0.h().e));
        i97.a r5 = i97.a.a;
        r0.h = System.currentTimeMillis();
        long r6 = ((Number) r0.j.getCountDownTime().getValue()).longValue();
        b0 r7 = (b0) r0.j.getSelfAutoMatchInfo().getValue();
        if (r7 == null) goto L23;
        Long r8 = Long.valueOf(r7.getAccelerateLimit());
        if (r8.longValue() <= 0) goto L16;
        boolean r9 = true;
    L17:
        if (r9 == false) goto L19;
        r1 = r8;
    L19:
        if (r1 == null) goto L24;
        long r10 = r1.longValue();
        r0.d(Math.max(r6 + r10, r10), "speedUp");
        return;
    L24:
        return;
    L16:
        r9 = false;
        goto L17
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.match.g.b
    public final void Eb() {
        if ((xq() instanceof com.bytedance.android.live.revlink.impl.multianchor.match.c.e) == false) goto L5;
        return;
    L5:
        wq();
    }

    public final void onCreate() {
        super.onCreate();
        Pair r0 = com.bytedance.live.datacontext.d.a(MultiPkMatchWidget$onCreate$pair$1.INSTANCE);
        MultiPkMatchContext r3 = (MultiPkMatchContext) r0.getFirst();
        r3.getService().d(this);
        com.bytedance.live.datacontext.b.a(r3, Reflection.getOrCreateKotlinClass(MultiPkMatchContext.class));
        this.a.add((Disposable) r0.getSecond());
        this.h = r3;
        com.bytedance.android.live.revenue.core.util.j.a r1 = com.bytedance.android.live.revenue.core.util.j.C0;
        com.bytedance.android.live.revlink.impl.multianchor.match.g r2 = new com.bytedance.android.live.revlink.impl.multianchor.match.g(r3, (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(r1.a(), com.bytedance.android.livesdk.revenue.service.room.c.class), com.bytedance.android.live.revlink.impl.global.b.k(), (yz0.f) com.bytedance.android.live.revenue.core.util.f.d(r1.a(), yz0.f.class), com.bytedance.android.live.revlink.impl.global.b.i());
        this.g = r2;
        Intrinsics.checkNotNullParameter(this, "listener");
        r2.f.add(this);
        com.bytedance.android.live.revlink.impl.multianchor.match.g r4 = this.g;
        if (r4 == null) goto L32;
        yz0.f r5 = r4.m;
        if (r5 == null) goto L11;
        com.bytedance.android.live.revenue.common.message.a r6 = com.bytedance.android.live.revenue.common.message.a.g;
        Lazy r7 = CommonMessageTypeKt.a;
        Intrinsics.checkNotNullParameter(r6, "$this$LINK_MIC_BATTLE_MULTI_MATCH");
        Observable r8 = yz0.h.a.a(r5, (yh6.b) CommonMessageTypeKt.m.getValue(), false, 6);
        if (r8 == null) goto L11;
        final MultiPkMatchManager$attach$1 r9 = new MultiPkMatchManager$attach$1(r4);
        Disposable r10 = r8.subscribe(new i(r9));
        if (r10 == null) goto L11;
        r4.c(r10);
    L11:
        yz0.f r12 = r4.m;
        if (r12 == null) goto L18;
        com.bytedance.android.live.revenue.common.message.a r13 = com.bytedance.android.live.revenue.common.message.a.g;
        Lazy r14 = CommonMessageTypeKt.a;
        Intrinsics.checkNotNullParameter(r13, "$this$BATTLE_AUTO_MATCH");
        Observable r15 = yz0.h.a.a(r12, (yh6.b) CommonMessageTypeKt.u.getValue(), false, 6);
        if (r15 == null) goto L18;
        final MultiPkMatchManager$attach$2 r16 = new MultiPkMatchManager$attach$2(r4);
        Disposable r17 = r15.subscribe(new i(r16));
        if (r17 == null) goto L18;
        r4.c(r17);
    L18:
        yz0.f r18 = r4.m;
        if (r18 == null) goto L25;
        Observable r19 = yz0.h.a.a(r18, CommonMessageTypeKt.a(com.bytedance.android.live.revenue.common.message.a.g), false, 6);
        if (r19 == null) goto L25;
        final MultiPkMatchManager$attach$3 r20 = new MultiPkMatchManager$attach$3(r4);
        Disposable r22 = r19.subscribe(new i(r20));
        if (r22 == null) goto L25;
        r4.c(r22);
    L25:
        yz0.f r23 = r4.m;
        if (r23 == null) goto L32;
        com.bytedance.android.live.revenue.common.message.a r24 = com.bytedance.android.live.revenue.common.message.a.g;
        Lazy r25 = CommonMessageTypeKt.a;
        Intrinsics.checkNotNullParameter(r24, "$this$BATTLE_NOTIFY_POINT");
        Observable r26 = yz0.h.a.a(r23, (yh6.b) CommonMessageTypeKt.v.getValue(), false, 6);
        if (r26 == null) goto L32;
        final MultiPkMatchManager$attach$4 r27 = new MultiPkMatchManager$attach$4(r4);
        Disposable r28 = r26.subscribe(new i(r27));
        if (r28 == null) goto L32;
        r4.c(r28);
    L32:
        com.bytedance.android.live.revenuelink.connect.f r29 = this.l;
        if (r29 == null) goto L35;
        r29.addLinkOutListener(7, this.n);
    L35:
        com.bytedance.android.live.revenuelink.connect.f r30 = this.l;
        if (r30 == null) goto L40;
        LiveData<ey.f> r32 = r30.connectState();
        if (r32 == null) goto L40;
        r32.observeForever(this.p);
    L40:
        ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo470getPkService().m(this.o);
        ld.a r33 = ld.d.a();
        if (r33 == null) goto L50;
        NextLiveData r34 = r33.so();
        if (r34 == null) goto L51;
        Observable r35 = ld.c.a(r34);
        if (r35 == null) goto L52;
        Disposable r36 = r35.subscribe(new d(this));
        if (r36 == null) goto L53;
        this.a.add(r36);
        return;
    L53:
        return;
    L52:
        return;
    L51:
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.live.revlink.impl.multianchor.match.g r0 = this.g;
        if (r0 == null) goto L13;
        r0.f.clear();
        r0.b.dispose();
        Disposable r1 = r0.c;
        if (r1 == null) goto L7;
        r1.dispose();
    L7:
        Disposable r2 = r0.d;
        if (r2 == null) goto L10;
        r2.dispose();
    L10:
        Disposable r3 = r0.e;
        if (r3 == null) goto L13;
        r3.dispose();
    L13:
        this.a.dispose();
        com.bytedance.android.live.revenuelink.connect.f r4 = this.l;
        if (r4 == null) goto L16;
        r4.removeLinkOutListener(7, this.n);
    L16:
        com.bytedance.android.live.revenuelink.connect.f r5 = this.l;
        if (r5 == null) goto L21;
        LiveData<ey.f> r6 = r5.connectState();
        if (r6 == null) goto L21;
        r6.removeObserver(this.p);
    L21:
        wq();
        p11.h r7 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo470getPkService();
        if (r7 == null) goto L25;
        r7.i(this.o);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.match.a
    public final boolean Qd() {
        return this.k;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.match.g.b
    public final void Ag(w1 r7) {
        Intrinsics.checkNotNullParameter(r7, "message");
        jy0.b.f("ttlive_anchor_link_match", "MatchWidget onPassiveMatchStart", null, 4);
        r4 r0 = (r4) vh7.f.c(r4.class);
        List r8 = r7.getPreviewUsers();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        w1.c r3 = (w1.c) r9.next();
        h0 r4 = vh7.f.c(h0.class);
        r4.setNickName(r3.getNickName());
        r4.setAvatar(r3.getAvatar());
        r1.add(r4);
        goto L4
    L6:
        r0.setPreviewUserList(r1);
        yq(r0);
        y8(null);
        com.bytedance.android.live.revlink.impl.multianchor.service.c r10 = com.bytedance.android.live.revlink.impl.global.b.y();
        if (r10 == null) goto L11;
        r10.Ob();
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.match.a
    public final void Jo(j8 r5) {
        Intrinsics.checkNotNullParameter(r5, "autoMatchInfo");
        jy0.b.f("ttlive_anchor_link_match", "update self " + e0.b(r5) + " status=" + xq(), null, 4);
        MultiPkMatchContext r0 = this.h;
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.n<b0> r1 = r0.getSelfAutoMatchInfo();
        if (r1 == null) goto L9;
        r1.setValue(r5);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.match.g.b
    public final void no(w1 r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        jy0.b.f("ttlive_anchor_link_match", "MatchWidget onPassiveMatchEnd", null, 4);
        wq();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.match.g.b
    public final void rh(boolean r3) {
        if (r3 == true) goto L4;
    L19:
        wq();
        return;
    L4:
        if (xq().b != 9) goto L7;
        ToastUtil.a(2131920523, 1);
    L13:
        com.bytedance.android.live.revlink.impl.multianchor.match.f r4 = com.bytedance.android.live.revlink.impl.global.b.H();
        if (r4 == null) goto L16;
        r4.g(xq().b, xq().c);
    L16:
        com.bytedance.android.live.revlink.impl.multianchor.match.f r5 = com.bytedance.android.live.revlink.impl.global.b.H();
        if (r5 == null) goto L19;
        r5.h(xq().b, AutoMatchSource.MaxWaitTimeOut);
        goto L19
    L7:
        if (xq().b != 10) goto L10;
        ToastUtil.a(2131920550, 1);
        goto L13
    L10:
        if (xq().b != 11) goto L12;
        ToastUtil.a(2131920583, 1);
        goto L13
    L12:
        ToastUtil.a(2131921528, 1);
        goto L13
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.match.a
    public final void y8(String r3) {
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L12;
    L21:
        com.bytedance.android.live.revlink.impl.pk.service.i r2 = com.bytedance.android.live.revlink.impl.global.b.h0();
        if (r2 == null) goto L24;
        r2.J2(r3);
    L24:
        this.f = true;
        ((SingleSubscribeProxy) Single.timer(5, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).as(autoDispose())).subscribe(new e(this));
        return;
    L12:
        if (xq().c == false) goto L15;
        r3 = s1.B(2131920611);
        goto L21
    L15:
        if (x.d(xq().b) == false) goto L18;
        r3 = s1.B(2131920623);
        goto L21
    L18:
        if (x.b(xq().b) == false) goto L20;
        r3 = s1.B(2131920578);
        goto L21
    L20:
        r3 = s1.B(2131920606);
        goto L21
    L5:
        if (r3.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final void yq(r4 r9) {
        MultiPkMatchContext r0 = this.h;
        if (r0 == null) goto L7;
        b0 r1 = r0.currentAutoMatchInfo();
        if (r1 == null) goto L7;
        long r2 = r1.getWaitSec();
    L8:
        jy0.b.f("ttlive_anchor_link_match", "MatchWidget startMatchCountDown waitSec=" + r2, null, 4);
        if (r2 < 60) goto L16;
        com.bytedance.android.live.revlink.impl.pk.service.i r3 = com.bytedance.android.live.revlink.impl.global.b.h0();
        if (r3 == null) goto L13;
        r3.setText("");
    L13:
        com.bytedance.android.live.revlink.impl.pk.service.i r4 = com.bytedance.android.live.revlink.impl.global.b.h0();
        if (r4 == null) goto L19;
        r4.Z2(this.i);
    L19:
        MultiPkMatchContext r5 = this.h;
        if (r5 == null) goto L24;
        com.bytedance.live.datacontext.m<Long> r6 = r5.getCountDownTime();
        if (r6 == null) goto L24;
        r6.setValue(Long.valueOf(r2));
    L24:
        com.bytedance.android.live.revlink.impl.pk.service.i r7 = com.bytedance.android.live.revlink.impl.global.b.h0();
        if (r7 == null) goto L27;
        r7.P2(RingDrawable.ttlive_ic_pk_random_normal_circle);
    L27:
        Disposable r8 = this.b;
        if (r8 == null) goto L30;
        r8.dispose();
    L30:
        this.b = du2.a.d(1, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new f(this));
        Disposable r10 = this.c;
        if (r10 == null) goto L33;
        r10.dispose();
    L33:
        List r12 = r9.getPreviewUserList();
        if (r12 != null) goto L36;
    L39:
        boolean r13 = true;
    L40:
        if (r13 == false) goto L43;
        jy0.b.f("ttlive_anchor_link_match", "previewUserList is empty", null, 4);
        return;
    L43:
        List r14 = r9.getPreviewUserList();
        if (r14 == null) goto L52;
        h0 r15 = (h0) ListProtector.get(r14, 0);
        if (r15 == null) goto L52;
        py.k r16 = r15.getAvatar();
        if (r16 == null) goto L52;
        com.bytedance.android.live.revlink.impl.pk.service.i r17 = com.bytedance.android.live.revlink.impl.global.b.h0();
        if (r17 == null) goto L52;
        r17.e3(r16);
    L52:
        this.c = du2.a.d(2300, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new g(this, r14));
        return;
    L36:
        if (r12.isEmpty() == true) goto L39;
        r13 = false;
        goto L40
    L16:
        com.bytedance.android.live.revlink.impl.pk.service.i r18 = com.bytedance.android.live.revlink.impl.global.b.h0();
        if (r18 == null) goto L19;
        r18.setText(String.valueOf(r2));
    L7:
        r2 = 30;
        goto L8
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.match.g.b
    public final void Q9(r4 r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "matchModel");
        if (r3 == false) goto L6;
        yq(r2);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.match.a
    public final void fl(int r12, i6 r13) {
        Intrinsics.checkNotNullParameter(r13, "linkerMessage");
        AnchorLinkOptUtils r8 = null;
        jy0.b.c("ttlive_anchor_link_match", "onReceiveMatchInvite, matchType=" + r12 + ' ' + xq(), null, 4);
        MultiPkMatchContext r0 = this.h;
        boolean r9 = false;
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.k<com.bytedance.android.live.revlink.impl.multianchor.match.d> r1 = r0.getMatchSuccessEvent();
        if (r1 == null) goto L7;
        r1.post(new com.bytedance.android.live.revlink.impl.multianchor.match.d(false));
    L7:
        IBattleLinkerInviteMessageExtra r2 = j6.a(r13);
        if (r2 != null) goto L10;
    L14:
        com.bytedance.android.live.revlink.impl.multianchor.match.f r3 = com.bytedance.android.live.revlink.impl.global.b.H();
        if (r3 == null) goto L18;
        com.bytedance.android.live.revlink.impl.multianchor.match.f.f(r3, r12, "invitee", xq().c, false, false, e21.c.a(r13), 24);
    L18:
        if (x.d(r12) == false) goto L21;
        ToastUtil.a(2131920642, 0);
    L26:
        ni(1, "matchInvited");
        com.bytedance.android.live.revlink.impl.global.c r4 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r4 == null) goto L29;
        r8 = r4.vk();
    L29:
        if (r8 != null) goto L31;
        return;
    L31:
        if (r8.c() == true) goto L33;
    L35:
        if (r9 != true) goto L40;
        if (r12 == 10) goto L41;
        wq();
        return;
    L41:
        return;
    L40:
        return;
    L33:
        if (r8.b().T2() == false) goto L35;
        r9 = true;
        goto L35
    L21:
        if (r12 != 9) goto L23;
        ToastUtil.b("匹配成功，开启主播连线", 0);
        goto L26
    L23:
        if (r12 != 10) goto L25;
        ToastUtil.b("已为你成功匹配1位主播，继续为你匹配中", 0);
        goto L26
    L25:
        ToastUtil.a(2131920614, 0);
        goto L26
    L10:
        if (((int) r2.getInviteType()) != 13) goto L14;
        com.bytedance.android.live.revlink.impl.multianchor.match.f r5 = com.bytedance.android.live.revlink.impl.global.b.H();
        if (r5 == null) goto L18;
        com.bytedance.android.live.revlink.impl.multianchor.match.f.f(r5, r12, "inviter", xq().c, false, true, e21.c.a(r13), 8);
        goto L18
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.match.a
    public final void ni(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        com.bytedance.android.live.revlink.impl.multianchor.match.g r0 = this.g;
        if (r0 == null) goto L6;
        com.bytedance.android.live.revlink.impl.multianchor.match.g.p(r0, r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.match.g.b
    public final void z1(int r3, int r4) {
        boolean r1 = false;
        if (r3 != AutoMatchService.AutoMatchEvent.START.ordinal()) goto L11;
        com.bytedance.android.live.revlink.impl.multianchor.match.g r5 = this.g;
        if (r5 == null) goto L7;
        r5.o(new com.bytedance.android.live.revlink.impl.multianchor.match.c.a(r4, 0));
    L7:
        com.bytedance.android.live.revlink.impl.pk.service.i r6 = com.bytedance.android.live.revlink.impl.global.b.h0();
        if (r6 == null) goto L55;
        r6.P2(RingDrawable.ttlive_ic_pk_random_normal_circle);
        return;
    L55:
        return;
    L11:
        if (r3 == AutoMatchService.AutoMatchEvent.MATCHED.ordinal()) goto L13;
    L18:
        com.bytedance.android.live.revlink.impl.multianchor.match.g r7 = this.g;
        if (r7 == null) goto L21;
        com.bytedance.android.live.revlink.impl.multianchor.match.c r8 = r7.h();
    L23:
        if ((r8 instanceof com.bytedance.android.live.revlink.impl.multianchor.match.c.e) == false) goto L25;
        return;
    L25:
        com.bytedance.android.live.revlink.impl.multianchor.match.g r9 = this.g;
        if (r9 == null) goto L28;
        r9.o(new com.bytedance.android.live.revlink.impl.multianchor.match.c.C0146c());
    L28:
        com.bytedance.android.live.revlink.impl.pk.service.i r10 = com.bytedance.android.live.revlink.impl.global.b.h0();
        if (r10 == null) goto L32;
        r10.n3(!y.b());
    L32:
        if (y.b() == false) goto L57;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r12 = com.bytedance.android.live.revlink.impl.global.b.m();
        if (r12 != null) goto L36;
    L38:
        boolean r13 = false;
    L39:
        if (r13 == true) goto L50;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r14 = com.bytedance.android.live.revlink.impl.global.b.m();
        if (r14 != null) goto L43;
    L45:
        if (r1 == true) goto L50;
        com.bytedance.android.live.revlink.impl.pk.service.i r15 = com.bytedance.android.live.revlink.impl.global.b.h0();
        if (r15 == null) goto L58;
        r15.onMultiAnchorStateChange(2);
        return;
    L58:
        return;
    L43:
        if (r14.e() != true) goto L45;
        r1 = true;
    L50:
        com.bytedance.android.live.revlink.impl.pk.service.i r16 = com.bytedance.android.live.revlink.impl.global.b.h0();
        if (r16 == null) goto L60;
        r16.S2(ToolBarPic.PK_CLOSE_BROADCAST);
        return;
    L60:
        return;
    L36:
        if (r12.g() != true) goto L38;
        r13 = true;
        goto L39
    L57:
        return;
    L21:
        r8 = null;
        goto L23
    L13:
        if (r4 != 10) goto L18;
        com.bytedance.android.live.revlink.impl.multianchor.match.g r17 = this.g;
        if (r17 == null) goto L54;
        r17.o(new com.bytedance.android.live.revlink.impl.multianchor.match.c.e(xq().e));
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.match.g.b
    public final void Dc(af2.e r47, int r48, List<String> r49) {
        Intrinsics.checkNotNullParameter(r47, "matchModel");
        if (r48 == 10) goto L5;
        wq();
    L5:
        ni(1, "matchSuccess");
        IRoom r1 = r47.getRivalRoom();
        if (r1 == null) goto L8;
        IBaseUser r2 = r1.getOwner();
    L10:
        if (r2 == null) goto L14;
        IRoom r9 = r47.getRivalRoom();
        if (r9 == null) goto L14;
        Intrinsics.checkNotNullParameter(r9, "$this$getInviteeScene");
        Map r3 = IRoomKt_androidKt.getLinkMapKt(r9);
        if (r3 != null) goto L18;
    L20:
        Map r4 = IRoomKt_androidKt.getLinkMapKt(r9);
        if (r4 != null) goto L23;
    L25:
        int r8 = 0;
    L27:
        if (com.bytedance.android.live.revlink.impl.global.b.h() == null) goto L33;
        com.bytedance.android.live.revlink.impl.control.d r5 = com.bytedance.android.live.revlink.impl.global.b.f();
        if (r5 == null) goto L31;
        String r17 = r5.getRequestId();
    L32:
        v3 r6 = e21.b.a("", r17, null, "", "", "");
    L34:
        jy0.b.f("ttlive_anchor_link_match", "matchInvite matchType=" + r48 + " inviteeUserIds=" + r49 + " inviteeScene=" + r8, null, 4);
        com.bytedance.android.live.revlink.impl.multianchor.service.a r7 = com.bytedance.android.live.revlink.impl.global.b.t();
        if (r7 == null) goto L37;
        com.bytedance.android.live.revenuelink.connect.n r10 = r7.getLinkOutManagerFn();
    L38:
        if (r10 == null) goto L90;
        String r24 = r47.getBattleAttachedInfo();
        long r16 = 0;
        if (r48 == 9) goto L66;
        if (r48 == 10) goto L66;
        yz0.k r12 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r12 == null) goto L46;
        IRoom r13 = r12.getRoom();
    L47:
        if (r13 == null) goto L49;
        r16 = r13.getId();
    L49:
        long r20 = r9.getRoomId();
        IBaseUser r14 = r9.getOwner();
        if (r14 == null) goto L52;
        String r22 = iz.a.a(r14);
    L53:
        IBaseUser r15 = r9.getOwner();
        if (r15 == null) goto L56;
        Intrinsics.checkNotNullParameter(r15, "$this$secUidExt");
        String r23 = r15.getCastSecUid();
    L57:
        int r25 = BizType.AnchorLink.ordinal();
        w31.c r18 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r18 == null) goto L60;
        int r39 = r18.d();
    L62:
        if (r6 == null) goto L64;
        String r44 = w3.a(r6);
    L65:
        d11.d r19 = new d11.d(7, r16, r20, 0, r48, r22, r23, r9, r25, "", 300, "", 0, 2, 0, r8, r49, null, null, r24, r39, 0, 0, null, r44, null, null, null, 518389760);
    L89:
        r10.d(r19, null);
        goto L90
    L64:
        r44 = "";
        goto L65
    L60:
        r39 = 0;
        goto L62
    L56:
        r23 = null;
        goto L57
    L52:
        r22 = null;
        goto L53
    L46:
        r13 = null;
    L66:
        int r26 = r8;
        yz0.k r27 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r27 == null) goto L69;
        IRoom r110 = r27.getRoom();
    L70:
        if (r110 == null) goto L72;
        r16 = r110.getId();
    L72:
        long r28 = r9.getRoomId();
        IBaseUser r29 = r9.getOwner();
        if (r29 == null) goto L75;
        String r30 = iz.a.a(r29);
    L76:
        IBaseUser r32 = r9.getOwner();
        if (r32 == null) goto L79;
        Intrinsics.checkNotNullParameter(r32, "$this$secUidExt");
        String r111 = r32.getCastSecUid();
    L80:
        int r112 = BizType.AnchorLink.ordinal();
        w31.c r33 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r33 == null) goto L83;
        int r210 = r33.d();
    L85:
        if (r6 == null) goto L87;
        String r37 = w3.a(r6);
    L88:
        r19 = new d11.d(7, r16, r28, 0, r48, r30, r111, r9, r112, "", 300, "", 0, 0, 0, r26, r49, null, null, r24, r210, 0, 0, null, r37, null, null, null, 518389760);
        goto L89
    L87:
        r37 = "";
        goto L88
    L83:
        r210 = 0;
        goto L85
    L79:
        r111 = null;
        goto L80
    L75:
        r30 = null;
        goto L76
    L69:
        r110 = null;
    L90:
        boolean r34 = true;
        this.k = true;
        Disposable r35 = this.d;
        if (r35 == null) goto L93;
        r35.dispose();
    L93:
        this.d = Observable.timer(20, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new n(this));
    L95:
        if (r48 != 6) goto L98;
        ToastUtil.a(2131920642, 0);
    L104:
        MultiPkMatchContext r36 = this.h;
        if (r36 == null) goto L110;
        com.bytedance.live.datacontext.k<com.bytedance.android.live.revlink.impl.multianchor.match.d> r38 = r36.getMatchSuccessEvent();
        if (r38 == null) goto L111;
        r38.post(new com.bytedance.android.live.revlink.impl.multianchor.match.d(r34));
        return;
    L111:
        return;
    L110:
        return;
    L98:
        if (r48 != 9) goto L101;
        ToastUtil.b("匹配成功，开启主播连线", 0);
        goto L104
    L101:
        if (r48 != 10) goto L103;
        ToastUtil.b("已为你成功匹配1位主播，继续为你匹配中", 0);
        goto L104
    L103:
        ToastUtil.a(2131920614, 0);
        goto L104
    L37:
        r10 = null;
        goto L38
    L31:
        r17 = null;
        goto L32
    L33:
        r6 = null;
        goto L34
    L23:
        if (r4.containsKey(String.valueOf(7)) != true) goto L25;
        r8 = 7;
        goto L27
    L18:
        if (r3.containsKey(String.valueOf(1)) != true) goto L20;
        r8 = 1;
    L14:
        r34 = true;
        goto L95
    L8:
        r2 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.match.g.b
    public final void r4(long r4, long r6, h0 r8) {
        Intrinsics.checkNotNullParameter(r8, "previewUser");
        long r5 = r4 - r6;
        if (r5 >= 0) goto L5;
        r5 = 0;
    L5:
        long r7 = 59;
        if (1 <= r5) goto L9;
    L16:
        com.bytedance.android.live.revlink.impl.pk.service.i r9 = com.bytedance.android.live.revlink.impl.global.b.h0();
        if (r9 == null) goto L19;
        r9.setText("");
    L19:
        com.bytedance.android.live.revlink.impl.pk.service.i r10 = com.bytedance.android.live.revlink.impl.global.b.h0();
        if (r10 == null) goto L22;
        r10.Z2(this.i);
    L22:
        com.bytedance.android.live.revlink.impl.pk.service.i r12 = com.bytedance.android.live.revlink.impl.global.b.h0();
        if (r12 == null) goto L25;
        r12.e3(r8.getAvatar());
    L25:
        MultiPkMatchContext r13 = this.h;
        if (r13 == null) goto L31;
        com.bytedance.live.datacontext.m<Long> r14 = r13.getCountDownTime();
        if (r14 == null) goto L32;
        r14.setValue(Long.valueOf(r5));
        return;
    L32:
        return;
    L31:
        return;
    L9:
        if (r7 < r5) goto L16;
        com.bytedance.android.live.revlink.impl.pk.service.i r15 = com.bytedance.android.live.revlink.impl.global.b.h0();
        if (r15 == null) goto L13;
        r15.setText(String.valueOf(r5));
    L13:
        com.bytedance.android.live.revlink.impl.pk.service.i r16 = com.bytedance.android.live.revlink.impl.global.b.h0();
        if (r16 == null) goto L22;
        r16.i3();
        goto L22
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.match.a
    public final void Ib(af2.a r20, int r22, final boolean r23, int r24, String r25, final Function1<? super p, Unit> r26) {
        Intrinsics.checkNotNullParameter(r20, "matchInfo");
        Intrinsics.checkNotNullParameter(r25, "activityType");
        b0 r8 = (b0) r20;
        MultiPkMatchContext r1 = this.h;
        if (r1 == null) goto L7;
        com.bytedance.live.datacontext.n<b0> r2 = r1.getSelfAutoMatchInfo();
        if (r2 == null) goto L7;
        r2.setValue(r8);
    L7:
        i11.b r3 = com.bytedance.android.live.revlink.impl.global.b.e();
        if (r3 == null) goto L14;
        List<com.bytedance.android.livesdk.link.model.p> r4 = r3.a();
        if (r4 == null) goto L14;
        if ((!r4.isEmpty()) != true) goto L14;
        boolean r5 = true;
    L15:
        List<IBaseUser> r9 = null;
        if (r5 == true) goto L18;
    L38:
        w r6 = com.bytedance.android.live.revlink.impl.global.b.D();
        if (r6 == null) goto L41;
        boolean r7 = r6.g();
    L42:
        if (r7 == false) goto L46;
        jy0.b.c("ttlive_anchor_link_match", "startMatch intercepted, PkWithAudience", null, 4);
        int r10 = ToastUtil.a;
        ToastUtil.b(s1.B(2131920601), 0);
        return;
    L46:
        if (y.c() == false) goto L56;
        i11.b r12 = y.a();
        if (r12 == null) goto L52;
        List<com.bytedance.android.livesdk.link.model.p> r13 = r12.getOnlineUserList();
        if (r13 == null) goto L52;
        int r14 = r13.size();
    L54:
        if (r14 < 3) goto L56;
        boolean r15 = true;
    L57:
        if (r15 == false) goto L60;
        jy0.b.c("ttlive_anchor_link_match", "startMatch intercepted, isLinkerCountOverLimit", null, 4);
        int r16 = ToastUtil.a;
        ToastUtil.b(s1.B(2131920605), 0);
        return;
    L60:
        dq2.p r17 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).getInteractAudienceService();
        if (r17 != null) goto L63;
    L64:
        dq2.w r18 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).M1();
        if (r18 == null) goto L67;
        int r19 = r18.w();
    L68:
        if (r19 <= 0) goto L71;
    L69:
        int r27 = ToastUtil.a;
        ToastUtil.b(s1.B(2131920625), 0);
        return;
    L71:
        com.bytedance.android.live.revlink.impl.service.internal.a r28 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r28 == null) goto L75;
        r28.m();
    L75:
        if (x.b(r22) == true) goto L79;
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.e r29 = com.bytedance.android.live.revlink.impl.global.b.l();
        if (r29 == null) goto L79;
        r29.b(null);
    L79:
        com.bytedance.android.live.revlink.impl.multianchor.match.g r30 = this.g;
        if (r30 == null) goto L123;
        Function1<p, Unit> r110 = new MultiPkMatchWidget$startMatch$1(this, r23, r26);
        Intrinsics.checkNotNullParameter(r8, "matchInfo");
        long r111 = 0;
        if (r41.b.a == false) goto L99;
        IRoomBase r32 = r30.a;
        if (r32 == null) goto L86;
        IRoomKtKt.getId(r32);
    L86:
        long r33 = r22;
        long r34 = 2;
        boolean r35 = r30.h().c;
        if (r30.h().c == false) goto L89;
        r111 = 1;
    L89:
        JSONObject r36 = new JSONObject();
        r36.put("match_type", r33);
        r36.put("game_id", "");
        r36.put("sub_type", r34);
        b0 r37 = (b0) r30.j.getSelfAutoMatchInfo().getValue();
        if (r37 == null) goto L92;
        long r38 = r37.getDefaultWaitLimit();
    L93:
        r36.put("default_limit_time", r38);
        b0 r39 = (b0) r30.j.getSelfAutoMatchInfo().getValue();
        if (r39 == null) goto L96;
        long r40 = r39.getAccelerateLimit();
    L97:
        r36.put("accelerate_limit_time", r40);
        r36.put("invite_limit_time", 10);
        r36.put("wait_time_level", r111);
        cy0.e.a.getClass();
        cy0.j r42 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r43 = com.bytedance.android.scope.m.b(r42).a(Reflection.getOrCreateKotlinClass(vy0.b.class));
        Intrinsics.checkNotNull(r43);
        ((vy0.b) ((f80.a) r43)).sendEventToAllJsBridges("H5_startAutoMatch", r36);
        return;
    L96:
        r40 = 15;
        goto L97
    L92:
        r38 = 60;
        goto L93
    L99:
        if (r30.l() == false) goto L101;
        jy0.b.c("ttlive_anchor_link_match", "startRandomMatch intercepted, already matching", null, 4);
        return;
    L101:
        jy0.b.f("ttlive_anchor_link_match", "startRandomMatch matchType=" + r22 + ' ' + e0.b(r8), null, 4);
        Disposable r44 = r30.d;
        if (r44 == null) goto L104;
        r44.dispose();
    L104:
        Disposable r45 = r30.c;
        if (r45 == null) goto L107;
        r45.dispose();
    L107:
        com.bytedance.revenue.platform.api.core.rx.l r46 = com.bytedance.revenue.platform.api.core.rx.l.a;
        int r47 = com.bytedance.revenue.platform.api.core.rx.p.a;
        r30.c = Observable.interval(3000, 3000, TimeUnit.MILLISECONDS, Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(r30, r22, r24));
        c0 r48 = r8.getConfig();
        if (r48 != null) goto L110;
    L112:
        boolean r49 = false;
    L113:
        if (r49 == false) goto L115;
        long r50 = r8.getWaitSec();
        long r52 = r8.getAccelerateLimit();
    L116:
        r30.d(r50 + r52, "startMatchSpeedUp");
        IRoomBase r53 = r30.a;
        if (r53 == null) goto L119;
        long r54 = IRoomKtKt.getId(r53);
    L120:
        r30.f(r54, r22, true, r24, r49, r8, r110);
        return;
    L119:
        r54 = 0;
        goto L120
    L115:
        r50 = r8.getWaitSec();
        r52 = r8.getDefaultWaitLimit();
        goto L116
    L110:
        if (((int) r48.getPkAutoMatchIndex()) != PkAutoMatchDataContext.PKAutoMatchType.AUTO_MATCH_TYPE_SLOW.getValue()) goto L112;
        r49 = true;
        goto L113
    L123:
        return;
    L67:
        r19 = 0;
        goto L68
    L63:
        if (r17.a() == true) goto L69;
    L52:
        r14 = 0;
    L56:
        r15 = false;
        goto L57
    L41:
        r7 = false;
        goto L42
    L18:
        if ((xq() instanceof com.bytedance.android.live.revlink.impl.multianchor.match.c.e) == true) goto L38;
        jy0.b.c("ttlive_anchor_link_match", "startMatch intercepted, LinkerInvitingRival", null, 4);
        if (x.b(r22) == false) goto L22;
        int r55 = ToastUtil.a;
        ToastUtil.b(s1.B(2131922646), 0);
    L23:
        k21.a r56 = com.bytedance.android.live.revlink.impl.global.b.E();
        if (r56 == null) goto L122;
        LinkedHashMap r57 = new LinkedHashMap();
        com.bytedance.android.live.revlink.impl.global.c r58 = r56.d;
        if (r58 == null) goto L28;
        com.bytedance.android.live.revlink.impl.pk.service.b r59 = r58.Ud();
    L29:
        if (r59 == null) goto L36;
        i11.b r60 = r59.getLinkUserCenter();
        if (r60 == null) goto L36;
        r57.put("pk_waiting_list", i11.a.c(r60.a()));
        List<IBaseUser> r62 = r60.getInviteeList();
        if ((true ^ r62.isEmpty()) == false) goto L35;
        r9 = r62;
    L35:
        r57.put("pk_invitee_list", String.valueOf(r9));
    L36:
        r56.b(r57);
        r56.f(r57);
        int r63 = v.a;
        v.h("ttlive_anchor_link_match", "intercept_multi_match_when_inviting: " + r57);
        return;
    L28:
        r59 = null;
        goto L29
    L122:
        return;
    L22:
        int r64 = ToastUtil.a;
        ToastUtil.b(s1.B(2131920604), 0);
    L14:
        r5 = false;
        goto L15
    }
}
