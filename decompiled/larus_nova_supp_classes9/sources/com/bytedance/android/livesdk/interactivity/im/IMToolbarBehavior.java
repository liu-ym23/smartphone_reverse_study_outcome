package com.bytedance.android.livesdk.interactivity.im;

import am2.x;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.platform.depend.im.IHostIMService;
import com.bytedance.android.livehostapi.platform.depend.im.LiveEnterChatParams;
import com.bytedance.android.livesdk.chatroom.utils.SkinLoadResultType;
import com.bytedance.android.livesdk.chatroom.utils.SkinLoader;
import com.bytedance.android.livesdk.chatroom.utils.a4;
import com.bytedance.android.livesdk.chatroom.utils.y2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.ic;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.im.ConsultInfo;
import com.bytedance.android.livesdkapi.depend.model.live.im.IMIndustryServiceInfo;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ResKeyEnum;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import ev1.q;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pp1.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/im/IMToolbarBehavior;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "Lc82/b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class IMToolbarBehavior implements c0.b, c82.b, Observer<KVData> {
    public static final /* synthetic */ int m = 0;
    public DataCenter a;
    public View b;
    public Context c;
    public TextView d;
    public View e;
    public HSImageView f;
    public RelativeLayout g;
    public Room h;
    public IMIndustryServiceInfo i;
    public final Lazy j;
    public boolean k;
    public final BitmapDrawable l;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ IMToolbarBehavior a;
        public final /* synthetic */ int b;

        public b(IMToolbarBehavior r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.c(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements a4 {
        public final /* synthetic */ IMToolbarBehavior a;

        public final void a(Disposable r1) {
        }

        public c(IMToolbarBehavior r1) {
            this.a = r1;
        }

        public final void b(SkinLoadResultType r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "result");
            if (r1 != SkinLoadResultType.SUCCESS) goto L8;
            HSImageView r3 = this.a.f;
            if (r3 == null) goto L9;
            r3.setBackgroundResource(0);
            return;
        L9:
            return;
        }
    }

    static {
    }

    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    public final /* synthetic */ void Mr(s r1) {
    }

    public final /* synthetic */ void Y6() {
    }

    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    public final /* synthetic */ void onHide(boolean r1) {
    }

    public final /* synthetic */ void setAlpha(float r1) {
    }

    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public IMToolbarBehavior(BitmapDrawable r2) {
        Intrinsics.checkNotNullParameter(r2, "iconDrawable");
        this.l = r2;
        this.j = LazyKt.lazy(new IMToolbarBehavior$moreBehavior$2(this));
    }

    public final void SY(s r4) {
        SkinLoader.c.getClass();
        if (SkinLoader.a.b() == false) goto L22;
        HSImageView r0 = this.f;
        if (r0 == null) goto L23;
        Room r1 = this.h;
        if (r1 == null) goto L20;
        IMIndustryServiceInfo r2 = r1.getImIndustryServiceInfo();
        if (r2 == null) goto L20;
        ConsultInfo r3 = r2.get_consultInfo();
        if (r3 == null) goto L14;
        int r5 = r3.get_roles();
    L16:
        if (r5 != 2) goto L18;
        ResKeyEnum r6 = ResKeyEnum.IM_MANAGER;
    L19:
        SkinLoader.a.e(r4).c(y2.a(r6, this.l), r0, new c(this));
        return;
    L18:
        r6 = ResKeyEnum.IM_AUDIENCE;
        goto L19
    L14:
        r5 = 0;
    L20:
        b("updateUnread failed null data " + this.h);
        return;
    L23:
        return;
    }

    public final void b(String r3) {
        f2.b(2131922361, 0);
        b82.a.a(r3, null);
    }

    public final void c(int r7) {
        if (this.k == true) goto L6;
        return;
    L6:
        if (r7 <= 99) goto L8;
        String r0 = "99+";
    L9:
        Room r1 = this.h;
        if (r1 == null) goto L45;
        IMIndustryServiceInfo r2 = r1.getImIndustryServiceInfo();
        if (r2 == null) goto L45;
        int r3 = b82.a.a;
        String r4 = "try update unread , count : " + r7;
        Intrinsics.checkNotNullParameter(r4, "msg");
        ALogger.d("TTLIVE_IM_INDUSTRY", r4);
        ConsultInfo r5 = r2.get_consultInfo();
        int r6 = 0;
        if (r5 == null) goto L17;
        int r8 = r5.get_roles();
    L19:
        if (r8 == 2) goto L32;
        TextView r9 = this.d;
        if (r9 == null) goto L23;
        r9.setVisibility(8);
    L23:
        TextView r10 = this.d;
        if (r10 == null) goto L26;
        r10.setText(BuildConfig.FLAVOR);
    L26:
        View r11 = this.e;
        if (r11 == null) goto L47;
        if (r7 > 0) goto L31;
        r6 = 4;
    L31:
        r11.setVisibility(r6);
        return;
    L47:
        return;
    L32:
        View r13 = this.e;
        if (r13 == null) goto L35;
        r13.setVisibility(8);
    L35:
        TextView r14 = this.d;
        if (r14 == null) goto L38;
        r14.setText(r0);
    L38:
        TextView r15 = this.d;
        if (r15 == null) goto L49;
        if (r7 > 0) goto L43;
        r6 = 4;
    L43:
        r15.setVisibility(r6);
        return;
    L49:
        return;
    L17:
        r8 = 0;
    L45:
        b("updateUnread failed null data " + this.h);
        return;
    L8:
        r0 = String.valueOf(r7);
        goto L9
    }

    public final void dv(e r3) {
        Intrinsics.checkNotNullParameter(r3, "command");
        if ((r3 instanceof g) == false) goto L9;
        int r0 = b82.a.a;
        StringBuilder r1 = new StringBuilder("try fold toolbar behavior : ");
        g r4 = (g) r3;
        r1.append(r4.a);
        b82.a.b(r1.toString());
        if (r4.a == false) goto L7;
        y3.f(this.a).p(ToolbarButton.LIVE_IM_ENTRANCE_MORE.extended(), (IMToolbarMoreBehavior) this.j.getValue());
        return;
    L7:
        y3.f(this.a).f(ToolbarButton.LIVE_IM_ENTRANCE_MORE.extended(), (IMToolbarMoreBehavior) this.j.getValue());
        return;
    }

    public final void onChanged(Object r2) {
        KVData r3 = (KVData) r2;
        if (r3 == null) goto L5;
        String r4 = r3.getKey();
    L7:
        if (Intrinsics.areEqual(r4, "cmd_end_live") == false) goto L10;
        f2.b(2131922360, 0);
        return;
    L10:
        return;
    L5:
        r4 = null;
        goto L7
    }

    public final void onClick(View r15) {
        Room r16 = this.h;
        if (r16 == null) goto L94;
        IMIndustryServiceInfo r17 = r16.getImIndustryServiceInfo();
        if (r17 == null) goto L94;
        ConsultInfo r0 = r17.getConsultInfo();
        if (r0 == null) goto L10;
        Integer r1 = Integer.valueOf(r0.get_roles());
    L11:
        int r2 = 0;
        String r4 = BuildConfig.FLAVOR;
        String r5 = "0";
        if (r1 != null) goto L15;
    L48:
        if (r1 != null) goto L51;
    L92:
        b("open client im error, error role : " + r17);
        return;
    L51:
        if (r1.intValue() != 2) goto L92;
        IHostBusiness r3 = k.f(IHostBusiness.class);
        if (r3 == null) goto L90;
        IHostIMService r8 = r3.getHostIMService();
        if (r8 == null) goto L90;
        Room r6 = this.h;
        if (r6 == null) goto L62;
        String r7 = r6.getOwnerUserIdString();
        if (r7 == null) goto L62;
        String r9 = r7;
    L63:
        ConsultInfo r10 = r17.get_consultInfo();
        if (r10 == null) goto L66;
        int r11 = r10.get_roles();
    L67:
        ConsultInfo r18 = r17.get_consultInfo();
        if (r18 == null) goto L73;
        String r19 = r18.get_info();
        if (r19 == null) goto L73;
        String r13 = r19;
    L74:
        DataCenter r110 = this.a;
        if (r110 != null) goto L77;
    L79:
        Room r111 = this.h;
        if (r111 == null) goto L88;
        IMIndustryServiceInfo r112 = r111.imIndustryServiceInfo;
        if (r112 == null) goto L88;
        ConsultInfo r113 = r112.get_consultInfo();
        if (r113 == null) goto L88;
        if (r113.get_roles() != 2) goto L88;
        String r114 = "manager";
    L89:
        HashMap r14 = new HashMap(u.l().c(x.class).getMap());
        r14.put("entrance_form", "live_im_icon");
        r14.put("user_role", r114);
        r14.put("enter_from", "live_im");
        r14.put("enter_method", "live_im_icon");
        r8.startConsultConList(r9, r11, r13, r14, new AnonymousClass2(this));
    L91:
        int r115 = com.bytedance.android.livesdk.interactivity.im.a.a;
        com.bytedance.android.livesdk.interactivity.im.a.a(this.a);
        return;
    L88:
        r114 = "audience";
        goto L89
    L77:
        if (z.e(r110, false) != true) goto L79;
        r114 = "anchor";
    L73:
        r13 = BuildConfig.FLAVOR;
        goto L74
    L66:
        r11 = 0;
    L62:
        r9 = "0";
    L90:
        b("open client im error " + r17);
        goto L91
    L15:
        if (r1.intValue() != 1) goto L48;
        Context r20 = this.c;
        if (r20 != null) goto L20;
        b("open  anchor im error: null context");
        return;
    L20:
        IHostBusiness r21 = k.f(IHostBusiness.class);
        if (r21 == null) goto L47;
        IHostIMService r23 = r21.getHostIMService();
        if (r23 == null) goto L47;
        LiveEnterChatParams r24 = new LiveEnterChatParams();
        Room r25 = this.h;
        if (r25 == null) goto L28;
        String r26 = r25.getOwnerUserIdString();
        if (r26 == null) goto L28;
    L29:
        r24.setSpUid(r26);
        IUserService r27 = f72.b.a();
        if (r27 == null) goto L37;
        f r28 = r27.user();
        if (r28 == null) goto L37;
        String r29 = r28.n();
        if (r29 == null) goto L37;
        r5 = r29;
    L37:
        r24.setCUid(r5);
        ConsultInfo r30 = r17.get_consultInfo();
        if (r30 == null) goto L40;
        r2 = r30.get_roles();
    L40:
        r24.setRole(r2);
        ConsultInfo r116 = r17.get_consultInfo();
        if (r116 == null) goto L46;
        String r117 = r116.get_info();
        if (r117 == null) goto L46;
        r4 = r117;
    L46:
        r24.setLiveExtra(r4);
        r24.setEnterFromForMob("live_im");
        r24.setEnterMethodForMob("live_im_icon");
        int r118 = b82.a.a;
        b82.a.b("createLiveEnterChatParams,  ret: " + r24);
        r23.startChat(r20, r24, new AnonymousClass1(this));
    L28:
        r26 = "0";
    L47:
        int r119 = com.bytedance.android.livesdk.interactivity.im.a.a;
        com.bytedance.android.livesdk.interactivity.im.a.a(this.a);
        return;
    L10:
        r1 = null;
    L94:
        b("open failed null data " + this.h);
    }

    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.k = false;
        IHostBusiness r4 = k.f(IHostBusiness.class);
        if (r4 == null) goto L7;
        IHostIMService r5 = r4.getHostIMService();
        if (r5 == null) goto L7;
        r5.liveRoomClose();
    L7:
        Map<String, WeakReference<c82.b>> r6 = c82.c.a;
        ((HashMap) c82.c.a).clear();
        c82.c.b = 0;
    }

    @Override // c82.b
    public final void a(long r3, int r5) {
        int r0 = b82.a.a;
        b82.a.b("on Count Update :spUid " + r3 + ",  count " + r5);
        if (MainThreadPostUtils.a() == false) goto L5;
        c(r5);
        return;
    L5:
        MainThreadPostUtils.b(new b(this, r5));
    }

    public final void p4(View r5, DataCenter r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        this.k = true;
        this.a = r6;
        this.c = r5.getContext();
        this.b = r5;
        final ConsultInfo r1 = null;
        Object r0 = r6.get("data_room", null);
        if ((r0 instanceof Room) == true) goto L5;
        r0 = null;
    L5:
        this.h = (Room) r0;
        this.d = (TextView) r5.findViewById(2131390764);
        if (((Boolean) ic.a.getValue()).booleanValue() == false) goto L10;
        ViewGroup r2 = (ViewGroup) r5.findViewById(2131389070);
        if (r2 == null) goto L10;
        r2.setClipChildren(false);
    L10:
        this.f = r5.findViewById(2131374718);
        this.e = r5.findViewById(2131374928);
        HSImageView r3 = this.f;
        if (r3 == null) goto L13;
        r3.setBackgroundDrawable(this.l);
    L13:
        this.g = (RelativeLayout) r5.findViewById(2131389071);
        TextView r7 = this.d;
        if (r7 == null) goto L16;
        r7.setVisibility(4);
    L16:
        Room r8 = this.h;
        if (r8 == null) goto L19;
        IMIndustryServiceInfo r9 = r8.imIndustryServiceInfo;
    L20:
        this.i = r9;
        int r10 = g2.a;
        if (g2.b(Boolean.valueOf(z.e(r6, false))) == false) goto L24;
        g2.a(this.g);
    L24:
        if (((Boolean) q.d.getValue()).booleanValue() == false) goto L28;
        RelativeLayout r11 = this.g;
        if (r11 == null) goto L28;
        r11.setBackgroundResource(2131250015);
    L28:
        Map<String, WeakReference<c82.b>> r13 = c82.c.a;
        c82.c.a(this);
        IMIndustryServiceInfo r14 = this.i;
        if (r14 == null) goto L31;
        r1 = r14.get_consultInfo();
    L31:
        if (r1 == null) goto L42;
        IHostBusiness r15 = k.f(IHostBusiness.class);
        if (r15 == null) goto L42;
        IHostIMService r16 = r15.getHostIMService();
        if (r16 == null) goto L42;
        Room r17 = this.h;
        if (r17 == null) goto L40;
        String r18 = r17.getOwnerUserIdString();
        if (r18 == null) goto L40;
    L41:
        r16.getConsultMsgUnreadCount(r18, r1.get_roles(), new IMToolbarBehavior$initIM$1(this, r1));
    L40:
        r18 = "0";
    L42:
        DataCenter r19 = this.a;
        if (r19 == null) goto L45;
        r19.observe("cmd_end_live", this);
    L45:
        int r20 = com.bytedance.android.livesdk.interactivity.im.a.a;
        com.bytedance.android.livesdk.interactivity.im.a.b(this.a);
        return;
    L19:
        r9 = null;
        goto L20
    }
}
