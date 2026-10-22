package com.bytedance.android.live.room.navi.userinfo_p.presenter;

import am2.x;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.RoomOwner;
import com.bytedance.android.live.base.model.user.f0;
import com.bytedance.android.live.base.model.user.z;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.p4;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.room.navi.userinfo.cert.RoomImageLayoutController;
import com.bytedance.android.live.room.navi.userinfo.model.AnchorTabType;
import com.bytedance.android.live.room.navi.userinfo.model.TabLabelType;
import com.bytedance.android.live.room.navi.userinfo.util.LiveRoomUserInfoUtils;
import com.bytedance.android.live.room.navi.userinfo_p.viewmodel.ElementBasicVM;
import com.bytedance.android.live.room.navi.userinfo_p.viewmodel.ElementMiddleVM;
import com.bytedance.android.live.room.navi.userinfo_p.viewmodel.UserInfoVM;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.IBaseDiggService;
import com.bytedance.android.livesdk.interactivity.api.settings.config.u;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.r;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.y;
import com.bytedance.android.livesdk.log.filter.t;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.o0;
import com.bytedance.android.livesdk.message.model.qm;
import com.bytedance.android.livesdk.message.model.yd;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.AnchorTabLabel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomStats;
import com.bytedance.android.livesdkapi.depend.model.live.ProfileViewData;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAvator;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.logsdk.format.Spm;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.k;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.alog.middleware.ALogService;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import r52.b4;
import u32.n;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/presenter/UserInfoTabPresenter;", "Lcom/bytedance/android/live/room/navi/userinfo_p/presenter/BaseElementPresenter;", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserInfoTabPresenter extends BaseElementPresenter {
    public final a A;
    public int B;
    public final ViewGroup C;
    public final TextView D;
    public final String f;
    public View g;
    public TextView h;
    public TextView i;
    public TextView j;
    public ViewGroup k;
    public TextView l;
    public u32.d m;
    public com.bytedance.android.live.room.navi.userinfo.cert.d<?> n;
    public long o;
    public long p;
    public String q;
    public final int r;
    public final x s;
    public Disposable t;
    public qm u;
    public yd v;
    public Disposable w;
    public Disposable x;
    public boolean y;
    public final d z;

    public static final class a implements com.ss.ugc.live.sdk.platform.bytelink.dispatch.c {
        public a(UserInfoTabPresenter r1) {
        }
    }

    public static final class b implements u32.d.a {
        public final /* synthetic */ UserInfoTabPresenter a;
        public final /* synthetic */ String b;
        public final /* synthetic */ n c;

        public final View a() {
            UserInfoTabPresenter r0 = this.a;
            if (r0.B != 11) goto L7;
            ViewGroup r1 = r0.k;
            if (r1 == null) goto L7;
            return r1;
        L7:
            return null;
        }

        public final View b() {
            if (this.a.g() == false) goto L10;
            TextView r0 = this.a.h;
            if (r0 == null) goto L10;
            if (r0 == null) goto L10;
            if (r0.getVisibility() != 0) goto L10;
            return this.a.h;
        L10:
            return null;
        }

        public final List<Pair<String, String>> d() {
            UserInfoTabPresenter r0 = this.a;
            if (r0.B != 10) goto L20;
            Pair[] r1 = new Pair[2];
            Context r2 = r0.e.getContext();
            String r3 = "";
            if (r2 == null) goto L8;
            String r4 = r2.getString(2131911609);
            if (r4 == null) goto L8;
        L9:
            this.a.getClass();
            r1[0] = new Pair(r4, "");
            Context r5 = this.a.e.getContext();
            if (r5 == null) goto L13;
            String r6 = r5.getString(2131911610);
            if (r6 == null) goto L13;
        L14:
            String r7 = this.a.q;
            if (r7 == null) goto L18;
            r3 = r7;
        L18:
            r1[1] = new Pair(r6, r3);
            return CollectionsKt.mutableListOf(r1);
        L13:
            r6 = "";
        L8:
            r4 = "";
            goto L9
        L20:
            return null;
        }

        public final View f() {
            if (this.a.g() == false) goto L5;
            return null;
        L5:
            UserInfoTabPresenter r0 = this.a;
            if (r0.B != 9) goto L13;
            ViewGroup r1 = r0.k;
            if (r1 == null) goto L21;
            if (r1 != null) goto L11;
            return null;
        L11:
            if (r1.getVisibility() == 0) goto L24;
            return null;
        L24:
            return this.a.k;
        L21:
            return null;
        L13:
            View r2 = r0.g;
            if (r2 == null) goto L20;
            if (r2 == null) goto L20;
            if (r2.getVisibility() != 0) goto L20;
            return this.a.g;
        L20:
            return this.a.j;
        }

        public final View g() {
            if (this.a.g() == false) goto L10;
            TextView r0 = this.a.i;
            if (r0 == null) goto L10;
            if (r0 == null) goto L10;
            if (r0.getVisibility() != 0) goto L10;
            return this.a.i;
        L10:
            return null;
        }

        public final String c() {
            return this.b;
        }

        public final n e() {
            return this.c;
        }

        public final void setContentDescription(String r4) {
            Intrinsics.checkNotNullParameter(r4, "contentDescription");
            IRoom r0 = this.a.e.getRoom();
            if (r0 == null) goto L8;
            IBaseUser r1 = r0.getOwner();
            if (r1 == null) goto L8;
            String r2 = r1.getNickName();
            if (r2 == null) goto L8;
        L9:
            this.a.getClass();
            UserInfoTabPresenter.x(r2 + r4);
            return;
        L8:
            r2 = "";
            goto L9
        }

        public b(UserInfoTabPresenter r1, String r2, com.bytedance.android.live.room.navi.userinfo_p.presenter.d r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class c implements Runnable {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public static void a() {
            HashMap r0 = new HashMap();
            r0.put("tag_order", DataType.TRUE);
            r0.put("tag_type", "live_wave");
            j0.l().sendLog("livesdk_tag_show", r0, new Object[]{x.class, IRoom.class});
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

    public static final class d implements l {
        public final /* synthetic */ UserInfoTabPresenter a;

        public d(UserInfoTabPresenter r1) {
            this.a = r1;
        }

        public final void onMessage(tlc.d r4) {
            if ((r4 instanceof o0) == true) goto L5;
            tlc.d r0 = null;
        L6:
            o0 r1 = (o0) r0;
            if (r1 != null) goto L10;
            return;
        L10:
            if (this.a.c == true) goto L12;
            return;
        L12:
            if (((u) b4.a.getValue()).a() == false) goto L32;
            String r2 = r1.getMessageMethod();
            if (r2 != null) goto L18;
            return;
        L18:
            if (r2.hashCode() == (-414786051)) goto L21;
            return;
        L21:
            if (r2.equals("WebcastLikeMessage") == false) goto L30;
            yd r5 = (yd) r4;
            if (r5 != null) goto L25;
            return;
        L25:
            u32.d r3 = this.a.m;
            if (r3 == null) goto L31;
            r3.g(r5.getTotal());
            return;
        L31:
            return;
        L30:
            return;
        L32:
            return;
        L5:
            r0 = r4;
            goto L6
        }
    }

    public final com.bytedance.android.live.room.navi.userinfo_p.presenter.d l() {
        Context r0 = this.C.getContext();
        if (r0 != null) goto L5;
        return null;
    L5:
        IRoom r2 = b();
        boolean r3 = false;
        if (r2 == null) goto L24;
        RoomAvator r4 = gb2.b.c(r2);
        if (r4 == null) goto L24;
        List r5 = r4.getProfileViewData();
        if (r5 == null) goto L24;
        Iterator r6 = r5.iterator();
    L13:
        if (r6.hasNext() == false) goto L22;
        Object r7 = r6.next();
        ProfileViewData r8 = (ProfileViewData) r7;
        if (r8 != null) goto L17;
    L19:
        boolean r9 = false;
    L20:
        if (r9 == false) goto L13;
    L23:
        ProfileViewData r10 = (ProfileViewData) r7;
    L25:
        int r12 = n81.a.a;
        StringBuilder r13 = new StringBuilder("load widget appointment data is null: ");
        if (r10 != null) goto L28;
        r3 = true;
    L28:
        r13.append(r3);
        n81.a.b(r13.toString());
        TextView r14 = new TextView(r0);
        r14.setVisibility(8);
        r14.setTextSize(1, 8.0f);
        r14.setTextColor(-1);
        r14.setMaxLines(1);
        r14.setSingleLine(true);
        if (r10 == null) goto L31;
        Text r1 = r10.getSubTitle();
    L32:
        if (r1 == null) goto L35;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        r.g.d(r1, null, new y(0.0f), new com.bytedance.android.live.room.navi.userinfo_p.presenter.c(this, r14));
    L35:
        return new com.bytedance.android.live.room.navi.userinfo_p.presenter.d(this, r14, r10);
    L31:
        r1 = null;
        goto L32
    L17:
        if (r8.getSource() != 2) goto L19;
        r9 = true;
        goto L20
    L22:
        r7 = null;
    L24:
        r10 = null;
        goto L25
    }

    public final boolean o() {
        return !((ArrayList) AnchorTabType.b).contains(Integer.valueOf(this.B));
    }

    public final void r() {
        UserInfoVM.Companion.getClass();
        aa1.a r0 = UserInfoVM.b.b();
        if (r0 == null) goto L10;
        ElementMiddleVM r1 = r0.getMiddleVm();
        if (r1 == null) goto L11;
        k<Unit> r2 = r1.getRenderEmpty();
        if (r2 == null) goto L12;
        r2.post(Unit.INSTANCE);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void t() {
        StringBuilder r0 = new StringBuilder("renderTicket: ");
        DataCenter r1 = a();
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L6:
        r0.append(r2);
        ALogger.i("renderTicket", r0.toString());
        DataCenter r3 = a();
        if (r3 == null) goto L9;
        r3.observeForever("data_current_room_ticket_count", this);
    L9:
        IRoom r4 = b();
        String r5 = null;
        Long r6 = null;
        r6 = null;
        r6 = null;
        String r7 = null;
        if (r4 == null) goto L12;
        IRoomStats r8 = r4.getStats();
    L13:
        String r9 = "";
        if (r8 != null) goto L67;
        Spm.Companion.getClass();
        Spm r10 = Spm.a.a("a100.c100.d100");
        IRoom r12 = b();
        if (r12 == null) goto L48;
        r5 = r12.getOwnerUserIdString();
    L48:
        Spm r13 = r10.anchorId(String.valueOf(r5));
        IRoom r14 = b();
        if (r14 == null) goto L54;
        String r15 = r14.getIdStr();
        if (r15 == null) goto L54;
        r9 = r15;
    L54:
        sw2.a.b(r13.roomId(r9).aliasAppend("render_ticket_failed").reason("room or datacenter is null").i(), this.f);
    L56:
        if (c() == false) goto L63;
        View r16 = this.g;
        if (r16 == null) goto L60;
        r16.setTag(2131389806, "live_wave");
    L60:
        TextView r17 = this.h;
        if (r17 == null) goto L68;
        r17.setTag(2131389806, "live_wave");
        return;
    L68:
        return;
    L63:
        TextView r18 = this.j;
        if (r18 == null) goto L70;
        r18.setTag(2131389806, "live_wave");
        return;
    L70:
        return;
    L67:
        DataCenter r19 = a();     // Catch: Exception -> L30
        if (r19 == null) goto L19;
        Object r20 = r19.get("data_current_room_ticket_count");     // Catch: Exception -> L30
    L20:
        if (r20 == null) goto L24;
        DataCenter r22 = a();     // Catch: Exception -> L30
        if (r22 == null) goto L44;
        r6 = (Long) r22.get("data_current_room_ticket_count", 0L);     // Catch: Exception -> L30
    L44:
        y(r6);
        goto L56
    L24:
        IRoom r23 = b();     // Catch: Exception -> L30
        if (r23 == null) goto L44;
        IRoomStats r24 = r23.getStats();     // Catch: Exception -> L30
        if (r24 == null) goto L44;
        r6 = Long.valueOf(r24.getTicket());     // Catch: Exception -> L30
        goto L44
    L19:
        r20 = null;
    L30:
        e = move-exception;
        Spm.Companion.getClass();
        Spm r25 = Spm.a.a("a100.c100.d100");
        IRoom r26 = b();
        if (r26 == null) goto L34;
        r7 = r26.getOwnerUserIdString();
    L34:
        Spm r27 = r25.anchorId(String.valueOf(r7));
        IRoom r28 = b();
        if (r28 == null) goto L38;
        String r29 = r28.getIdStr();
        if (r29 == null) goto L38;
    L39:
        Spm r30 = r27.roomId(r29).aliasAppend("render_ticket_failed");
        String r32 = e.getMessage();
        if (r32 == null) goto L43;
        r9 = r32;
    L43:
        sw2.a.b(r30.reason(r9).i(), this.f);
        r6 = 0L;
    L38:
        r29 = "";
        goto L39
    L12:
        r8 = null;
        goto L13
    L5:
        r2 = 0;
        goto L6
    }

    public final void u() {
        String r0 = this.f;
        StringBuilder r1 = new StringBuilder("reportTicketShow:");
        DataCenter r2 = a();
        if (r2 == null) goto L5;
        int r3 = r2.hashCode();
    L6:
        r1.append(r3);
        ALogger.i(r0, r1.toString());
        int r4 = com.bytedance.android.live.room.y.a;
        com.bytedance.android.live.room.y.a(a(), this.a, "reportTicketShow", c.a);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.presenter.BaseElementPresenter
    public final void e() {
        super.e();
        this.p = 0;
        this.o = 0;
        Disposable r0 = this.t;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.t = null;
        Disposable r1 = this.w;
        if (r1 != null) goto L8;
    L12:
        this.w = null;
        Disposable r2 = this.x;
        if (r2 != null) goto L15;
    L19:
        this.x = null;
        this.u = null;
        this.v = null;
        this.y = false;
        return;
    L15:
        if (r2.isDisposed() == true) goto L19;
        Disposable r3 = this.x;
        if (r3 == null) goto L19;
        r3.dispose();
        goto L19
    L8:
        if (r1.isDisposed() == true) goto L12;
        Disposable r4 = this.w;
        if (r4 == null) goto L12;
        r4.dispose();
        goto L12
    }

    public final void n() {
        if (o() == false) goto L6;
    L9:
        u32.d r0 = this.m;
        if (r0 == null) goto L13;
        r0.g(-1);
        return;
    L13:
        return;
    L6:
        if (this.e.a() == false) goto L9;
        v(-1);
        goto L9
    }

    public static final void h(UserInfoTabPresenter r8) {
        if (r8.e.a() == false) goto L45;
        IRoom r0 = r8.b();
        f0 r1 = null;
        if (r0 == null) goto L14;
        IBaseUser r2 = r0.getOwner();
        if (r2 == null) goto L14;
        com.bytedance.android.live.base.model.user.x r3 = r2.getIndustryCertification();
        if (r3 == null) goto L14;
        z r4 = r3.getRoom();
        if (r4 == null) goto L14;
        f0 r5 = r4.getMRoomOwner();
    L16:
        if ((r5 instanceof RoomOwner) == false) goto L19;
        r1 = r5;
    L19:
        RoomOwner r6 = (RoomOwner) r1;
        if (r6 != null) goto L22;
        return;
    L22:
        if (r6.getType() != 106) goto L46;
        t r7 = j0.l().c(x.class);
        if ((r7 instanceof t) == false) goto L44;
        t r9 = r7;
        String r10 = (String) r9.getMap().get("enter_from_merge");
        String r12 = (String) r9.getMap().get("enter_method");
        if (r10 != null) goto L29;
        r10 = "";
    L29:
        if (r12 != null) goto L31;
        r12 = "";
    L31:
        HashMap r13 = new HashMap();
        IRoom r14 = r8.b();
        if (r14 == null) goto L35;
        String r15 = String.valueOf(r14.getId());
        if (r15 == null) goto L35;
    L36:
        r13.put("room_id", r15);
        r13.put("EVENT_ORIGIN_FEATUR", "TEMAI");
        r13.put("enter_from_merge", r10);
        r13.put("enter_method", r12);
        IRoom r16 = r8.b();
        if (r16 == null) goto L40;
        String r17 = r16.getOwnerUserIdString();
        if (r17 == null) goto L40;
    L41:
        r13.put("anchor_id", r17);
        r13.put("_param_live_platform", "live");
        r13.put("action_type", r8.e.getDataCenter().get("log_action_type", ""));
        r13.put("is_flagship_room", DataType.TRUE);
        r13.put("is_flash", DataType.FALSE);
        j0.l().sendLog("livesdk_flagship_label_show", r13, new Object[0]);
        return;
    L40:
        r17 = "";
    L35:
        r15 = "";
        goto L36
    L44:
        return;
    L46:
        return;
    L14:
        r5 = null;
        goto L16
    }

    public static void x(String r1) {
        UserInfoVM.Companion.getClass();
        aa1.a r0 = UserInfoVM.b.b();
        if (r0 == null) goto L10;
        ElementBasicVM r2 = r0.getBasicVm();
        if (r2 == null) goto L11;
        com.bytedance.live.datacontext.n<String> r3 = r2.getContainerContentDescription();
        if (r3 == null) goto L12;
        r3.setValue(r1);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void j(View r6) {
        if (r6 == null) goto L22;
        IRoom r0 = b();
        if (r0 == null) goto L6;
        AnchorTabLabel r1 = r0.getAnchorTabLabel();
    L7:
        if (r1 == null) goto L23;
        int r2 = r1.getType();
        if (r2 != TabLabelType.POI.value) goto L11;
        String r3 = "poi";
    L13:
        if (r2 != TabLabelType.QualityGeek.value) goto L15;
        r6.setTag(2131389802, "TEMAI");
    L15:
        r6.setTag(2131389806, r3);
        r6.setTag(2131389805, Integer.valueOf(r2));
        String r4 = r1.getContent();
        if (r4 != null) goto L18;
        r4 = "";
    L18:
        r6.setTag(2131389803, r4);
        Map r5 = r1.getTrackParams();
        if (r5 == null) goto L24;
        r6.setTag(2131389807, r5);
        return;
    L24:
        return;
    L11:
        r3 = "brand_flagship";
        goto L13
    L23:
        return;
    L6:
        r1 = null;
        goto L7
    }

    public final int k(Integer r8) {
        int r0 = 1;
        if (r8 == null) goto L92;
        r8.intValue();
        if (r8.intValue() != 4) goto L11;
        if (this.c == false) goto L11;
        ALogService.wSafely(this.f, "filter server anchor tab type; current user is anchor, but type is " + r8);
        return 1;
    L11:
        if (((ArrayList) AnchorTabType.a).contains(r8) == false) goto L24;
        IRoom r2 = b();
        if (r2 == null) goto L24;
        IRoomAuthStatus r3 = r2.getRoomAuthStatus();
        if (r3 == null) goto L24;
        if (r3.getEnableDigg() == true) goto L24;
        ALogService.wSafely(this.f, "filter server anchor tab type; current room does't support dig");
        if (this.c == true) goto L96;
        return 4;
    L96:
        return 1;
    L24:
        if (((ArrayList) AnchorTabType.c).contains(r8) == false) goto L30;
        if (this.c == false) goto L97;
        return 5;
    L97:
        return 3;
    L30:
        if (r8.intValue() != (-1)) goto L37;
        ALogger.i(this.f, "filter server anchor tab type; current room is using local_fallback strategy");
        if (this.c == true) goto L98;
        return 3;
    L98:
        return 1;
    L37:
        if (r8.intValue() == 0) goto L39;
        Integer r4 = (Integer) g81.f.a.getValue();
        if (r8.intValue() == 8) goto L47;
        if (r8.intValue() == 9) goto L47;
    L80:
        if (r8.intValue() > 11) goto L86;
        if (r8.intValue() < 0) goto L86;
        return r8.intValue();
    L86:
        if (this.c == true) goto L90;
        r0 = 3;
    L90:
        return r0;
    L47:
        if (this.c == false) goto L54;
        ALogService.wSafely(this.f, "filter server anchor tab type; the room doesn't has certification info");
        if (this.c == true) goto L100;
        return 3;
    L100:
        return 1;
    L54:
        if (r8.intValue() != 8) goto L63;
        if (r4 == null) goto L63;
        if (r4.intValue() != 0) goto L63;
        if (this.c == false) goto L101;
        return 5;
    L101:
        return 3;
    L63:
        if (r4 != null) goto L66;
    L67:
        IRoom r5 = b();
        if (r5 != null) goto L70;
    L72:
        boolean r6 = false;
    L73:
        if (r6 == true) goto L80;
        if (this.c == true) goto L102;
        return 3;
    L102:
        return 1;
    L70:
        if (r5.getAnchorTabLabel() == null) goto L72;
        r6 = true;
        goto L73
    L66:
        if (r4.intValue() == 0) goto L80;
    L39:
        if (this.c == false) goto L99;
        return 5;
    L99:
        return 3;
    L92:
        if (this.c == true) goto L104;
        return 3;
    L104:
        return 1;
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.presenter.BaseElementPresenter
    public final void onMessage(tlc.d r4) {
        if ((r4 instanceof o0) == true) goto L5;
        tlc.d r0 = null;
    L6:
        o0 r1 = (o0) r0;
        if (r1 != null) goto L9;
        return;
    L9:
        MessageType r2 = r1.getMessageType();
        if (r2 != MessageType.UPDATE_FAN_TICKET_MESSAGE) goto L23;
        if (r4 == null) goto L21;
        qm r5 = (qm) r4;
        this.u = r5;
        if (this.y == true) goto L15;
    L19:
        z(r5);
        return;
    L15:
        if (this.c == false) goto L19;
        if (((u) b4.a.getValue()).a() == false) goto L19;
        return;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.UpdateFanTicketMessage");
    L23:
        if (r2 == MessageType.LIKE_MESSAGE) goto L25;
        return;
    L25:
        if (((Boolean) com.bytedance.android.live.misc.e.a.getValue()).booleanValue() == false) goto L41;
        if (r4 == null) goto L38;
        yd r6 = (yd) r4;
        this.v = r6;
        if (this.y == true) goto L30;
    L34:
        u32.d r3 = this.m;
        if (r3 == null) goto L42;
        r3.g(r6.getTotal());
        return;
    L42:
        return;
    L30:
        if (this.c == false) goto L34;
        if (((u) b4.a.getValue()).a() == false) goto L34;
        return;
    L38:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.LikeMessage");
    L41:
        return;
    L5:
        r0 = r4;
        goto L6
    }

    public final void p(Integer r12) {
        if (r12 == null) goto L134;
        r12.intValue();
        Spm.Companion.getClass();
        Spm r1 = Spm.a.a("a100.c100.d100");
        IRoom r2 = b();
        String r3 = "";
        if (r2 == null) goto L7;
        String r4 = r2.getOwnerUserIdString();
        if (r4 == null) goto L7;
    L8:
        Spm r5 = r1.anchorId(r4);
        IRoom r6 = b();
        if (r6 == null) goto L12;
        String r7 = r6.getIdStr();
        if (r7 == null) goto L12;
    L13:
        sw2.a.b(r5.roomId(r7).aliasAppend("render_anchor_tab").addArg("type", r12).i(), this.f);
        this.B = r12.intValue();
        ALogger.d(this.f, " renderAnchorTabType  current type : " + this.B);
        IRoom r8 = b();
        if (r8 == null) goto L23;
        RoomAvator r9 = gb2.b.c(r8);
        if (r9 == null) goto L23;
        List r10 = r9.getSecondLabel();
        if (r10 == null) goto L23;
        List r13 = r10;
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r15 = r13.iterator();
    L21:
        if (r15.hasNext() == false) goto L24;
        r14.add(Integer.valueOf((int) ((Number) r15.next()).longValue()));
    L24:
        o r16 = z51.a.h(a(), 2);
        if (r16 == null) goto L31;
        com.bytedance.live.datacontext.n r17 = r16.getTemplateContext();
        if (r17 == null) goto L31;
        z70.b r18 = (z70.b) r17.getValue();
        if (r18 == null) goto L31;
        boolean r19 = r18.j("anchor_avatar");
    L33:
        if (r19 == false) goto L63;
        if (r14.contains(4) != true) goto L50;
        if (r14.contains(3) != true) goto L40;
        t();
        m("flip", false);
        return;
    L40:
        if (r14.contains(5) != true) goto L45;
        int r110 = n81.a.a;
        if (n81.a.a(a()) == false) goto L44;
        n81.a.b("appointment、cert、digg flip");
        s(true);
        return;
    L44:
        n81.a.b("cert、digg flip");
        s(false);
        return;
    L45:
        int r111 = n81.a.a;
        if (n81.a.a(a()) == false) goto L48;
        n81.a.b("appointment、digg flip");
        q(true);
        return;
    L48:
        n81.a.b("digg flip");
        q(false);
        return;
    L50:
        if (r14.contains(3) != true) goto L53;
        t();
        u();
        return;
    L53:
        if (r14.contains(0) != true) goto L56;
        r();
        return;
    L56:
        if (r14.contains(5) != true) goto L61;
        int r112 = n81.a.a;
        if (n81.a.a(a()) == false) goto L60;
        n81.a.b("appointment、cert、digg flip");
        s(true);
        return;
    L60:
        n81.a.b("cert、digg flip");
        s(false);
        return;
    L61:
        r();
        return;
    L63:
        if (r12.intValue() != 0) goto L66;
        return;
    L66:
        if (r12.intValue() != 1) goto L69;
        t();
        u();
        return;
    L69:
        if (r12.intValue() != 3) goto L72;
        q(false);
        return;
    L72:
        if (r12.intValue() != 4) goto L75;
        r();
        return;
    L75:
        if (r12.intValue() != 5) goto L78;
        t();
        m("flip", false);
        return;
    L78:
        if (r12.intValue() != 8) goto L129;
        Integer r113 = (Integer) g81.f.a.getValue();
        if (r113 != null) goto L83;
        return;
    L83:
        if (r113.intValue() == 1) goto L85;
        return;
    L85:
        if (this.c == false) goto L87;
    L116:
        Spm.Companion.getClass();
        Spm r114 = Spm.a.a("a100.c100.d100");
        IRoom r0 = b();
        if (r0 == null) goto L120;
        String r20 = r0.getOwnerUserIdString();
        if (r20 == null) goto L120;
    L121:
        Spm r115 = r114.anchorId(r20);
        IRoom r22 = b();
        if (r22 == null) goto L127;
        String r23 = r22.getIdStr();
        if (r23 == null) goto L127;
        r3 = r23;
    L127:
        sw2.a.b(r115.roomId(r3).aliasAppend("render_cert_failed").result(-1).addArg("is_anchor", Boolean.valueOf(this.c)).addArg("is_portrait", Boolean.valueOf(this.d)).reason("anchor or portrait is not compliance with rules").w(), this.f);
        return;
    L120:
        r20 = "";
        goto L121
    L87:
        if (this.d == false) goto L116;
        IRoom r116 = b();
        if (r116 == null) goto L94;
        AnchorTabLabel r117 = r116.getAnchorTabLabel();
        if (r117 == null) goto L94;
        py.k r118 = r117.getLabel();
    L95:
        IRoom r24 = b();
        if (r24 == null) goto L98;
        com.bytedance.android.live.room.navi.userinfo_p.utils.b.a(r24);
    L98:
        if (r118 != null) goto L111;
        Spm.Companion.getClass();
        Spm r119 = Spm.a.a("a100.c100.d100");
        IRoom r25 = b();
        if (r25 == null) goto L103;
        String r26 = r25.getOwnerUserIdString();
        if (r26 == null) goto L103;
    L104:
        Spm r120 = r119.anchorId(r26);
        IRoom r27 = b();
        if (r27 == null) goto L110;
        String r28 = r27.getIdStr();
        if (r28 == null) goto L110;
        r3 = r28;
    L110:
        sw2.a.b(r120.roomId(r3).aliasAppend("render_cert_failed").result(-1).reason("cert info is null").w(), this.f);
        return;
    L103:
        r26 = "";
        goto L104
    L111:
        RoomImageLayoutController r29 = new RoomImageLayoutController(new i(this));
        this.n = r29;
        r29.d();
        com.bytedance.android.live.room.navi.userinfo.cert.d<?> r30 = this.n;
        if (r30 == null) goto L115;
        ((RoomImageLayoutController) r30).e(r118);
        j(this.k);
        return;
    L115:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.room.navi.userinfo.cert.RoomImageLayoutController");
    L94:
        r118 = null;
        goto L95
    L129:
        if (r12.intValue() != 9) goto L131;
        s(false);
        return;
    L131:
        r();
        return;
    L31:
        r19 = false;
    L23:
        r14 = new ArrayList();
    L12:
        r7 = "";
    L7:
        r4 = "";
        goto L8
    }

    public final void q(boolean r2) {
        if (r2 == false) goto L4;
        m("flip_appointment_digg", r2);
        return;
    L4:
        m("new", false);
    }

    public final void s(boolean r9) {
        IRoom r0 = b();
        com.bytedance.android.live.room.navi.userinfo_p.presenter.d r1 = null;
        if (r0 == null) goto L5;
        AnchorTabLabel r2 = r0.getAnchorTabLabel();
    L6:
        o r3 = z51.a.h(a(), 2);
        if (r3 == null) goto L13;
        com.bytedance.live.datacontext.n r4 = r3.getTemplateContext();
        if (r4 == null) goto L13;
        z70.b r5 = (z70.b) r4.getValue();
        if (r5 == null) goto L13;
        boolean r6 = r5.j("anchor_avatar");
    L14:
        if (r6 == false) goto L21;
        IRoom r7 = b();
        if (r7 == null) goto L20;
        RoomAvator r8 = gb2.b.c(r7);
        if (r8 == null) goto L20;
        r2 = r8.getSecondTabLabel();
    L20:
        r2 = null;
    L21:
        if (r2 == null) goto L29;
        h r10 = new h(this);
        j(this.k);
        e91.a r12 = new f91.a().a(this.e, Integer.valueOf(r2.getStyle()), r10);
        this.n = r12;
        if (r12 == null) goto L26;
        r12.c();
    L26:
        com.bytedance.android.live.room.navi.userinfo.cert.d<?> r13 = this.n;
        if (r13 == null) goto L29;
        r13.a(r2);
    L29:
        String r14 = "flip_active";
        if (r6 == false) goto L43;
        if (r9 == false) goto L33;
        r14 = "flip_appointment_cert_digg";
    L33:
        if (r9 == false) goto L35;
        r1 = l();
    L35:
        this.m = jc1.k.n(IBaseDiggService.class).provideDiggCountFlipperLayoutController(new e(this, r14, r1));
        DataCenter r15 = a();
        if (r15 == null) goto L45;
        u32.d r16 = this.m;
        if (r16 == null) goto L40;
        r16.a(r15);
    L40:
        u32.d r17 = this.m;
        if (r17 == null) goto L46;
        r17.b();
        return;
    L46:
        return;
    L45:
        return;
    L43:
        m("flip_active", false);
        return;
    L13:
        r6 = false;
        goto L14
    L5:
        r2 = null;
        goto L6
    }

    public final void v(long r8) {
        String r4 = null;
        if (c() == false) goto L30;
        CharSequence r6 = "";
        if (this.B != 10) goto L7;
        this.q = com.bytedance.android.live.core.utils.x.a(r8);
    L11:
        IRoom r9 = this.e.getRoom();
        if (r9 == null) goto L17;
        IBaseUser r10 = r9.getOwner();
        if (r10 == null) goto L17;
        String r12 = r10.getNickName();
        if (r12 == null) goto L17;
    L18:
        TextView r13 = this.i;
        if (r13 == null) goto L22;
        CharSequence r14 = r13.getText();
        if (r14 == null) goto L22;
    L23:
        TextView r0 = this.h;
        if (r0 == null) goto L29;
        CharSequence r1 = r0.getText();
        if (r1 == null) goto L29;
        r6 = r1;
    L29:
        x(r12 + r14 + r6);
        return;
    L22:
        r14 = "";
    L17:
        r12 = "";
        goto L18
    L7:
        UIUtils.setText(this.h, com.bytedance.android.live.core.utils.x.a(r8));
        TextView r15 = this.i;
        Context r16 = this.e.getContext();
        if (r16 == null) goto L10;
        r4 = r16.getString(2131911610, new Object[]{""});
    L10:
        UIUtils.setText(r15, r4);
        goto L11
    L30:
        TextView r2 = this.j;
        if (r2 == null) goto L38;
        Context r5 = this.e.getContext();
        if (r5 == null) goto L35;
        r4 = r5.getString(2131911610, new Object[]{com.bytedance.android.live.core.utils.x.a(r8)});
    L35:
        r2.setText(r4);
        return;
    }

    public final void y(Long r6) {
        if (r6 == null) goto L8;
        r6.longValue();
        if (this.p <= r6.longValue()) goto L6;
        return;
    L6:
        this.p = r6.longValue();
        v(r6.longValue());
        return;
    }

    public final void z(qm r6) {
        if (o() == false) goto L5;
        return;
    L5:
        if (r6 != null) goto L8;
        return;
    L8:
        if (this.e.a() == true) goto L11;
        return;
    L11:
        if (r6.E() == false) goto L20;
        Long r0 = r6.getCount();
        long r1 = 0;
        if (r0 == null) goto L15;
        long r3 = r0.longValue();
    L16:
        this.p = r3;
        Long r7 = r6.getCount();
        if (r7 == null) goto L19;
        r1 = r7.longValue();
    L19:
        v(r1);
        return;
    L15:
        r3 = 0;
        goto L16
    L20:
        y(r6.getCount());
    }

    public final void m(String r3, boolean r4) {
        if (r4 == false) goto L4;
        com.bytedance.android.live.room.navi.userinfo_p.presenter.d r5 = l();
    L5:
        this.m = jc1.k.n(IBaseDiggService.class).provideDiggCountFlipperLayoutController(new b(this, r3, r5));
        DataCenter r6 = a();
        if (r6 == null) goto L14;
        u32.d r7 = this.m;
        if (r7 == null) goto L10;
        r7.a(r6);
    L10:
        u32.d r8 = this.m;
        if (r8 == null) goto L15;
        r8.b();
        return;
    L15:
        return;
    L14:
        return;
    L4:
        r5 = null;
        goto L5
    }

    public UserInfoTabPresenter(m91.c r2, ViewGroup r3, TextView r4) {
        Intrinsics.checkNotNullParameter(r2, "userInfoAbility");
        Intrinsics.checkNotNullParameter(r3, "mUserNameLayout");
        Intrinsics.checkNotNullParameter(r4, "mNameAreaTempAnimSubTitleView");
        super(r2);
        this.C = r3;
        this.D = r4;
        this.f = "UserInfoMiddlePresenter";
        this.r = 500;
        this.s = new x();
        this.z = new d(this);
        this.A = new a(this);
    }

    public static final void i(final UserInfoTabPresenter r3, TextView r4, SpannableString r5) {
        r3.getClass();
        int r0 = n81.a.a;
        n81.a.b("onAppointmentTextLoad, text = " + r5);
        if (((Boolean) p4.a.getValue()).booleanValue() == true) goto L6;
        n81.a.b("no change width");
        return;
    L6:
        if (r3.t == null) goto L8;
        n81.a.b("onAppointmentTextLoadSuccess appointmentHideAction != null");
        return;
    L8:
        TextPaint r6 = r4.getPaint();
        int r1 = 0;
        if (r6 == null) goto L12;
        r1 = (int) r6.measureText(r5, 0, r5.length());
    L12:
        final int r7 = ((Number) r3.e.b().getMiddleVm().getUserNameLayoutMaxWidthPx().getValue()).intValue();
        final int r8 = ((Number) r3.e.b().getMiddleVm().getUserNameLayoutCurWidthPx().getValue()).intValue();
        n81.a.b("textLength = " + r1 + ", oldMiddleMaxWidth = " + r7 + ", oldMiddleWidth = " + r8);
        if (r1 <= r8) goto L15;
        n81.a.b("change middle width");
        r3.e.b().getMiddleVm().getUserNameLayoutMaxWidthPx().setValue(Integer.valueOf(r1));
        r3.e.b().getMiddleVm().getUserNameLayoutCurWidthPx().setValue(Integer.valueOf(r1));
        int r2 = com.bytedance.revenue.platform.api.core.rx.h.a;
        r3.t = com.bytedance.revenue.platform.api.core.rx.h.a(new UserInfoTabPresenter$onAppointmentTextLoadSuccess$1(r3, r7, r8));
        return;
    L15:
        int r9 = com.bytedance.revenue.platform.api.core.rx.h.a;
        r3.t = com.bytedance.revenue.platform.api.core.rx.h.a(UserInfoTabPresenter$onAppointmentTextLoadSuccess$2.INSTANCE);
    }

    public final Disposable w(String r3, int r4, long r5) {
        TextView r0 = this.D;
        if (r0 != null) goto L5;
        return null;
    L5:
        r0.setText(r3);
        r0.setTextColor(r4);
        if (this.c == false) goto L8;
        r0.setTextSize(10.0f);
    L9:
        u32.d r6 = this.m;
        if (r6 == null) goto L12;
        View r7 = r6.d();
    L13:
        if (r7 == null) goto L17;
        u32.d r8 = this.m;
        if (r8 == null) goto L23;
        View r9 = r8.d();
    L24:
        if (r9 != null) goto L27;
        return null;
    L27:
        return LiveRoomUserInfoUtils.a(r0, r9, r5, new UserInfoTabPresenter$showTempSubTitleAnim$1(this));
    L23:
        r9 = null;
        goto L24
    L17:
        r9 = this.g;
        if (r9 != null) goto L24;
        r9 = this.j;
        if (r9 == null) goto L23;
    L12:
        r7 = null;
        goto L13
    L8:
        r0.setTextSize(8.0f);
        goto L9
    }
}
