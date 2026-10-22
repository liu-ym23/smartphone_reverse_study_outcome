package da1;

import com.bytedance.android.live.base.model.live.RoomViewStats;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.revenue.core.util.h;
import com.bytedance.android.live.room.api.IPlatformAudienceRankService;
import com.bytedance.android.live.room.api.rank.IAudienceWidget;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.o0;
import com.bytedance.android.livesdk.chatroom.presenter.n;
import com.bytedance.android.livesdk.chatroom.r;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.interactivity.api.settings.config.u;
import com.bytedance.android.livesdk.message.model.lk;
import com.bytedance.android.livesdk.message.model.mk;
import com.bytedance.android.livesdk.s7;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kc0.j;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import r52.b4;
import vh7.f;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c extends da1.a implements l {
    public boolean e;
    public long f;
    public long g;
    public n<IAudienceWidget> h;
    public final CompositeDisposable i;
    public long j;
    public long k;
    public boolean l;
    public final b m;

    public static final class a {
    }

    public static final class b implements l {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        public final void onMessage(tlc.d r10) {
            c r0 = this.a;
            if (((q46.b) r0).a == null) goto L75;
            if (r10 != null) goto L7;
            return;
        L7:
            if (r0.e == true) goto L9;
            return;
        L9:
            if (((u) b4.a.getValue()).b() == false) goto L88;
            String r1 = r10.getMessageMethod();
            if (r1 == null) goto L89;
            int r2 = r1.hashCode();
            int r3 = 0;
            mk r5 = null;
            if (r2 == 654092662) goto L46;
            if (r2 == 955576685) goto L20;
            return;
        L20:
            if (r1.equals("WebcastRoomRankMessage") == false) goto L77;
            c r4 = this.a;
            if ((r10 instanceof lk) == true) goto L24;
            r10 = null;
        L24:
            lk r12 = (lk) r10;
            if (((q46.b) r4).a == null) goto L78;
            if (r12 == null) goto L91;
            ArrayList r6 = new ArrayList();
            List r13 = r12.getRanks();
            if (r13 != null) goto L31;
        L42:
            IAudienceWidget r14 = (IAudienceWidget) ((q46.b) r4).a;
            if (r14 == null) goto L79;
            r14.ii(r6);
            return;
        L79:
            return;
        L31:
            if ((!r13.isEmpty()) == true) goto L34;
            r13 = null;
        L34:
            if (r13 == null) goto L42;
            Iterator r15 = r13.iterator();
        L37:
            if (r15.hasNext() == false) goto L42;
            Object r7 = r15.next();
            int r8 = r3 + 1;
            if (r3 >= 0) goto L41;
            CollectionsKt.throwIndexOverflow();
        L41:
            lk.b r9 = (lk.b) r7;
            r6.add(new x71.a(r9.getUser(), r8, r9.getProfileHidden(), null));
            r3 = r8;
            goto L37
        L91:
            return;
        L78:
            return;
        L77:
            return;
        L46:
            if (r1.equals("WebcastRoomStatsMessage") == false) goto L81;
            c r16 = this.a;
            if ((r10 instanceof mk) == true) goto L50;
            r10 = null;
        L50:
            mk r17 = (mk) r10;
            if (r17 != null) goto L53;
            r16.getClass();
            return;
        L53:
            if (((q46.b) r16).a != null) goto L55;
            return;
        L55:
            if (r17.getDisplayVersion() < r16.k) goto L92;
            ALogger.i("LiveWatchPresenterKt", "handleNewCountMessage  RoomStatsMessage : " + r17.getDisplayMiddle());
            if (r17.getDisplayVersion() <= r16.k) goto L61;
            r16.k = r17.getDisplayVersion();
            r16.h0(r17);
            return;
        L61:
            if (r17.getIncremental() == true) goto L63;
            r16.h0(r17);
            return;
        L63:
            if (r17.getDisplayValue() <= r16.j) goto L65;
            r3 = 1;
        L65:
            if (r3 == 0) goto L67;
            r5 = r17;
        L67:
            if (r5 == null) goto L84;
            r16.j = r5.getDisplayValue();
            r16.h0(r5);
            return;
        L84:
            return;
        L92:
            return;
        L81:
            return;
        L89:
            return;
        L88:
            return;
        }
    }

    static {
    }

    public c() {
        this.i = new CompositeDisposable();
        this.m = new b(this);
    }

    public final void detachView() {
        super.detachView();
        this.f = 0;
        this.g = 0;
        vlc.d r2 = ((n) this).d;
        if (r2 == null) goto L5;
        r2.removeMessageListener(this);
    L5:
        n<IAudienceWidget> r3 = this.h;
        if (r3 == null) goto L8;
        r3.detachView();
    L8:
        this.i.dispose();
        this.j = 0;
        this.k = 0;
        this.l = false;
        this.h = null;
    }

    public final /* bridge */ /* synthetic */ void c0(IWidget r1) {
        g0((IAudienceWidget) r1);
    }

    public final void g0(IAudienceWidget r8) {
        super.c0(r8);
        vlc.d r0 = ((n) this).d;
        if (r0 == null) goto L6;
        r0.addMessageListener("WebcastRoomRankMessage", this);
        r0.addMessageListener("WebcastRoomStatsMessage", this);
    L6:
        if (this.e == true) goto L8;
    L27:
        IPlatformAudienceRankService r1 = (IPlatformAudienceRankService) k.f(IPlatformAudienceRankService.class);
        if (r1 == null) goto L30;
        n<IAudienceWidget> r2 = r1.getPlatformWatchUserPresenter();
    L31:
        this.h = r2;
        if (r2 == null) goto L35;
        r2.c0(r8);
        return;
    L35:
        return;
    L30:
        r2 = null;
        goto L31
    L8:
        if (((u) b4.a.getValue()).b() == false) goto L27;
        MiddlewareRoomContext.a r3 = MiddlewareRoomContext.Companion;
        MiddlewareRoomContext r4 = MiddlewareRoomContext.a.c(r3, ((n) this).c, 0, 2);
        if (r4 == null) goto L14;
        Disposable r5 = o0.c(r4, CollectionsKt.mutableListOf(new String[]{"WebcastRoomRankMessage", "WebcastRoomStatsMessage"}), this.m);
        if (r5 == null) goto L14;
        this.i.add(r5);
    L14:
        MiddlewareRoomContext r6 = MiddlewareRoomContext.a.c(r3, ((n) this).c, 0, 2);
        if (r6 == null) goto L27;
        com.bytedance.live.datacontext.n r7 = r6.getRtcRoomInfo();
        if (r7 == null) goto L27;
        dh1.a r9 = (dh1.a) r7.getValue();
        if (r9 == null) goto L21;
        long r10 = r9.a;
    L23:
        if (r10 <= 0) goto L25;
        boolean r12 = true;
    L26:
        this.l = r12;
        this.i.add(r7.a().subscribe(new e(this)));
        goto L27
    L25:
        r12 = false;
        goto L26
    L21:
        r10 = 0;
        goto L23
    }

    public final void h0(mk r8) {
        IAudienceWidget r1 = (IAudienceWidget) ((q46.b) this).a;
        if (r1 == null) goto L6;
        r1.sn(r8.is_hidden(), r8.getDisplayValue(), r8.getDisplayMiddle(), r8.getDisplayLong());
        return;
    }

    public final void i0(mk r5) {
        DataCenter r0 = ((n) this).c;
        if (r0 == null) goto L13;
        IRoom r1 = a0.n(r0);
        if (r1 == null) goto L13;
        long r2 = r1.getRoomId();
        IRoomContextService r3 = k.f(IRoomContextService.class);
        if (r3 == null) goto L13;
        r r4 = r3.getRoomExpService(((n) this).c, r2);
        if (r4 == null) goto L13;
        com.bytedance.live.datacontext.n r6 = r4.u();
        if (r6 == null) goto L13;
        r6.setValue(r5);
    L13:
        DataCenter r7 = ((n) this).c;
        if (r7 == null) goto L16;
        r7.put("data_member_count", Integer.valueOf((int) r5.getTotal()));
    L16:
        boolean r8 = h.a;
        h.d(j.class).updateAudienceMemberCount(r5.getTotal());
        int r9 = com.bytedance.android.live.room.util.b.a;
        DataCenter r10 = ((n) this).c;
        long r12 = r5.getTotal();
        Intrinsics.checkNotNullParameter(r10, "dataCenter");
        w71.a r13 = z51.a.b(r10);
        if (r13 == null) goto L20;
        r13.updateRoomPCU(r12);
    L20:
        if (((Boolean) s7.a.getValue()).booleanValue() == false) goto L26;
        IPlatformAudienceRankService r14 = (IPlatformAudienceRankService) k.f(IPlatformAudienceRankService.class);
        if (r14 != null) goto L24;
    L25:
        h0(r5);
    L31:
        DataCenter r15 = ((n) this).c;
        if (r15 == null) goto L41;
        IRoom r16 = a0.n(r15);
        if (r16 == null) goto L42;
        long r17 = r16.getRoomId();
        IRoomContextService r18 = k.f(IRoomContextService.class);
        if (r18 == null) goto L43;
        r r19 = r18.getRoomExpService(((n) this).c, r17);
        if (r19 == null) goto L44;
        r19.F(r5.getTotal());
        return;
    L44:
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L24:
        if (r14.interceptAudienceCountRefresh() == true) goto L31;
    L26:
        IPlatformAudienceRankService r20 = (IPlatformAudienceRankService) k.f(IPlatformAudienceRankService.class);
        if (r20 != null) goto L29;
    L30:
        h0(r5);
        goto L31
    L29:
        if (r20.interceptAudienceCountRefresh() == true) goto L31;
        goto L30
    }

    public final void j0(mk r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (((q46.b) this).a != null) goto L6;
        return;
    L6:
        if (r6.getDisplayVersion() >= this.g) goto L9;
        return;
    L9:
        if (this.l == true) goto L11;
    L15:
        ALogger.i("LiveWatchPresenterKt", "handleNewCountMessage  RoomStatsMessage : " + r6.getDisplayMiddle());
        if (r6.getDisplayVersion() <= this.g) goto L19;
        this.g = r6.getDisplayVersion();
        i0(r6);
        return;
    L19:
        if (r6.getIncremental() == true) goto L21;
        i0(r6);
        return;
    L21:
        if (r6.getDisplayValue() <= this.f) goto L23;
        boolean r0 = true;
    L24:
        if (r0 == true) goto L27;
        r6 = null;
    L27:
        if (r6 == null) goto L34;
        this.f = r6.getDisplayValue();
        i0(r6);
        return;
    L34:
        return;
    L23:
        r0 = false;
        goto L24
    L11:
        if (this.e == false) goto L15;
        if (((u) b4.a.getValue()).b() == false) goto L15;
    }

    public final void onMessage(tlc.d r5) {
        if (((q46.b) this).a == null) goto L32;
        if (r5 == null) goto L36;
        String r0 = r5.getMessageMethod();
        if (r0 == null) goto L37;
        int r1 = r0.hashCode();
        Long r3 = null;
        if (r1 == 654092662) goto L26;
        if (r1 == 955576685) goto L15;
        return;
    L15:
        if (r0.equals("WebcastRoomRankMessage") == true) goto L17;
        return;
    L17:
        if ((r5 instanceof lk) == true) goto L19;
        r5 = null;
    L19:
        lk r6 = (lk) r5;
        DataCenter r2 = ((n) this).c;
        if (r2 == null) goto L24;
        IRoom r4 = a0.n(r2);
        if (r4 == null) goto L24;
        r3 = Long.valueOf(r4.getRoomId());
    L24:
        l0(r6, r3);
        return;
    L26:
        if (r0.equals("WebcastRoomStatsMessage") == true) goto L28;
        return;
    L28:
        if ((r5 instanceof mk) == true) goto L30;
        r5 = null;
    L30:
        j0((mk) r5);
        return;
    L37:
        return;
    L36:
        return;
    }

    public final void k0(RoomViewStats r5, Long r6) {
        if (r6 == null) goto L25;
        r6.longValue();
        IRoomContextService r0 = k.f(IRoomContextService.class);
        if (r0 == null) goto L10;
        r r1 = r0.getRoomExpService(((n) this).c, r6.longValue());
        if (r1 == null) goto L10;
        com.bytedance.live.datacontext.n r2 = r1.u();
        if (r2 == null) goto L10;
        mk r3 = (mk) r2.getValue();
    L11:
        if (r3 == null) goto L13;
        j0(r3);
        ALogger.i("LiveWatchPresenterKt", "  handleEnterData   RoomStatsMessage : " + r3.getDisplayMiddle());
    L15:
        IRoomContextService r7 = k.f(IRoomContextService.class);
        if (r7 == null) goto L26;
        r r8 = r7.getRoomExpService(((n) this).c, r6.longValue());
        if (r8 == null) goto L27;
        com.bytedance.live.datacontext.n r9 = r8.p();
        if (r9 == null) goto L28;
        lk r10 = (lk) r9.getValue();
        if (r10 == null) goto L29;
        l0(r10, r6);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L13:
        if (r5 == null) goto L15;
        mk r4 = (mk) f.c(mk.class);
        r4.set_hidden(r5.isHidden());
        r4.setDisplayVersion(r5.getDisplayVersion());
        r4.setDisplayMiddle(r5.getDisplayMiddle());
        r4.setDisplayLong(r5.getDisplayLong());
        r4.setIncremental(r5.getIncremental());
        j0(r4);
    L10:
        r3 = null;
        goto L11
    }

    public final void l0(lk r8, Long r9) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (((q46.b) this).a != null) goto L7;
        return;
    L7:
        if (this.l == true) goto L9;
    L13:
        ArrayList r0 = new ArrayList();
        List r1 = r8.getRanks();
        if (r1 != null) goto L16;
    L27:
        if (r9 == null) goto L35;
        long r2 = r9.longValue();
        IRoomContextService r10 = k.f(IRoomContextService.class);
        if (r10 == null) goto L35;
        r r12 = r10.getRoomExpService(((n) this).c, r2);
        if (r12 == null) goto L35;
        com.bytedance.live.datacontext.n r13 = r12.p();
        if (r13 == null) goto L35;
        r13.setValue(r8);
    L35:
        IAudienceWidget r14 = (IAudienceWidget) ((q46.b) this).a;
        if (r14 == null) goto L43;
        r14.ii(r0);
        return;
    L43:
        return;
    L16:
        if ((!r1.isEmpty()) == true) goto L19;
        r1 = null;
    L19:
        if (r1 == null) goto L27;
        Iterator r3 = r1.iterator();
        int r4 = 0;
    L22:
        if (r3.hasNext() == false) goto L27;
        Object r5 = r3.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L26;
        CollectionsKt.throwIndexOverflow();
    L26:
        lk.b r7 = (lk.b) r5;
        r0.add(new x71.a(r7.getUser(), r6, r7.getProfileHidden(), r7.getScoreStr()));
        r4 = r6;
        goto L22
    L9:
        if (this.e == false) goto L13;
        if (((u) b4.a.getValue()).b() == false) goto L13;
    }
}
