package com.bytedance.android.livesdk.interactivity.im;

import am2.x;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c82.b;
import c82.c;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.platform.depend.im.IHostIMService;
import com.bytedance.android.livehostapi.platform.depend.im.LiveEnterChatParams;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdk.utils.b1;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.im.ConsultInfo;
import com.bytedance.android.livesdkapi.depend.model.live.im.IMIndustryServiceInfo;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/im/IMToolbarMoreBehavior;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "Lc82/b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class IMToolbarMoreBehavior implements c0.b, b, Observer<KVData> {
    public static final /* synthetic */ int l = 0;
    public DataCenter a;
    public View b;
    public Context c;
    public View d;
    public HSImageView e;
    public TextView f;
    public RelativeLayout g;
    public Room h;
    public IMIndustryServiceInfo i;
    public boolean j;
    public String k;

    public static final class a {
    }

    static {
    }

    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    public final /* synthetic */ void Mr(s r1) {
    }

    public final /* synthetic */ void SY(s r1) {
    }

    public final /* synthetic */ void Y6() {
    }

    public final /* synthetic */ void dv(e r1) {
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

    public IMToolbarMoreBehavior(BitmapDrawable r2) {
        Intrinsics.checkNotNullParameter(r2, "iconDrawable");
    }

    public final void b(String r3) {
        f2.b(2131922361, 0);
        b82.a.a(r3, null);
        DataCenter r4 = this.a;
        if (r4 == null) goto L6;
        r4.put("cmd_live_toolbarmore_dialog_dismiss", Boolean.TRUE);
        return;
    }

    public final void c(int r3) {
        if (this.j == true) goto L5;
        return;
    L5:
        View r0 = this.d;
        if (r0 == null) goto L11;
        if (r3 <= 0) goto L9;
        int r1 = 0;
    L10:
        r0.setVisibility(r1);
        goto L11
    L9:
        r1 = 4;
    L11:
        DataCenter r2 = this.a;
        if (r2 == null) goto L15;
        r2.put("data_live_im_entrance_folded_unread", Integer.valueOf(r3));
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
        if (r16 == null) goto L97;
        IMIndustryServiceInfo r17 = r16.getImIndustryServiceInfo();
        if (r17 == null) goto L97;
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
    L93:
        DataCenter r18 = this.a;
        if (r18 == null) goto L99;
        r18.put("cmd_live_toolbarmore_dialog_dismiss", Boolean.TRUE);
        return;
    L99:
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
        ConsultInfo r19 = r17.get_consultInfo();
        if (r19 == null) goto L73;
        String r110 = r19.get_info();
        if (r110 == null) goto L73;
        String r13 = r110;
    L74:
        DataCenter r111 = this.a;
        if (r111 != null) goto L77;
    L79:
        Room r112 = this.h;
        if (r112 == null) goto L88;
        IMIndustryServiceInfo r113 = r112.imIndustryServiceInfo;
        if (r113 == null) goto L88;
        ConsultInfo r114 = r113.get_consultInfo();
        if (r114 == null) goto L88;
        if (r114.get_roles() != 2) goto L88;
        String r115 = "manager";
    L89:
        HashMap r14 = new HashMap(u.l().c(x.class).getMap());
        r14.put("entrance_form", "live_im_icon");
        r14.put("user_role", r115);
        r14.put("enter_from", "live_im");
        r14.put("enter_method", "live_im_icon");
        r8.startConsultConList(r9, r11, r13, r14, new AnonymousClass2(this));
    L91:
        int r116 = com.bytedance.android.livesdk.interactivity.im.a.a;
        com.bytedance.android.livesdk.interactivity.im.a.a(this.a);
    L88:
        r115 = "audience";
        goto L89
    L77:
        if (z.e(r111, false) != true) goto L79;
        r115 = "anchor";
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
        ConsultInfo r117 = r17.get_consultInfo();
        if (r117 == null) goto L46;
        String r118 = r117.get_info();
        if (r118 == null) goto L46;
        r4 = r118;
    L46:
        r24.setLiveExtra(r4);
        r24.setEnterFromForMob("live_im");
        r24.setEnterMethodForMob("live_im_icon");
        r23.startChat(r20, r24, new AnonymousClass1(this));
    L28:
        r26 = "0";
    L47:
        int r119 = com.bytedance.android.livesdk.interactivity.im.a.a;
        com.bytedance.android.livesdk.interactivity.im.a.a(this.a);
        goto L93
    L10:
        r1 = null;
    L97:
        b("open failed null data " + this.h);
    }

    public final void R9(View r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        this.j = false;
        IHostBusiness r0 = k.f(IHostBusiness.class);
        if (r0 == null) goto L7;
        IHostIMService r1 = r0.getHostIMService();
        if (r1 == null) goto L7;
        r1.liveRoomClose();
    L7:
        String r2 = this.k;
        if (r2 == null) goto L10;
        Map<String, WeakReference<b>> r5 = c.a;
        ((HashMap) c.a).remove(r2);
    L10:
        r4.put("data_live_im_entrance_folded_unread", 0);
    }

    @Override // c82.b
    public final void a(long r1, int r3) {
        c(r3);
    }

    public final void p4(View r4, DataCenter r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        this.j = true;
        this.a = r5;
        this.c = r4.getContext();
        this.b = r4;
        ConsultInfo r1 = null;
        Object r6 = r5.get("data_room", null);
        if ((r6 instanceof Room) == true) goto L5;
        r6 = null;
    L5:
        this.h = (Room) r6;
        this.d = r4.findViewById(2131374928);
        this.e = r4.findViewById(2131374718);
        this.f = (TextView) r4.findViewById(2131380593);
        this.g = (RelativeLayout) r4.findViewById(2131389071);
        View r7 = this.d;
        if (r7 == null) goto L8;
        r7.setVisibility(4);
    L8:
        Room r8 = this.h;
        if (r8 == null) goto L11;
        IMIndustryServiceInfo r9 = r8.imIndustryServiceInfo;
    L12:
        this.i = r9;
        TextView r10 = this.f;
        if (r10 == null) goto L15;
        r10.setText(s1.B(2131917397));
    L15:
        Map<String, WeakReference<b>> r11 = c.a;
        this.k = c.a(this);
        IMIndustryServiceInfo r13 = this.i;
        if (r13 == null) goto L18;
        r1 = r13.get_consultInfo();
    L18:
        if (r1 == null) goto L52;
        IHostBusiness r14 = k.f(IHostBusiness.class);
        if (r14 == null) goto L30;
        IHostIMService r15 = r14.getHostIMService();
        if (r15 == null) goto L30;
        Room r16 = this.h;
        if (r16 == null) goto L27;
        String r17 = r16.getOwnerUserIdString();
        if (r17 == null) goto L27;
    L28:
        r15.getConsultMsgUnreadCount(r17, r1.get_roles(), new IMToolbarMoreBehavior$initIM$1(this));
    L27:
        r17 = "0";
    L30:
        if (r1.get_roles() != 2) goto L32;
        int r18 = 2131251883;
    L33:
        HSImageView r19 = this.e;
        if (r19 == null) goto L36;
        r19.setBackgroundResource(r18);
    L36:
        IRoomService r20 = k.n(IRoomService.class);
        if (r20.isAudienceNewMorePanel(this.a) == false) goto L49;
        HSImageView r21 = this.e;
        if (r21 == null) goto L49;
        Drawable r23 = r21.getBackground();
        if (r23 == null) goto L49;
        Drawable r24 = r23.mutate();
        if (r24 == null) goto L49;
        if (r20.isAudienceNewMorePanelLightTheme(this.a) == false) goto L47;
        int r25 = (int) 4279638051L;
    L48:
        r24.setColorFilter(r25, PorterDuff.Mode.SRC_ATOP);
        goto L49
    L47:
        r25 = -1;
    L49:
        DataCenter r26 = this.a;
        if (r26 == null) goto L52;
        int r27 = b1.a;
        b1.b(z.e(r26, false), new IMToolbarMoreBehavior$initIM$$inlined$let$lambda$1(this));
        goto L52
    L32:
        r18 = 2131251884;
    L52:
        DataCenter r28 = this.a;
        if (r28 == null) goto L56;
        r28.observe("cmd_end_live", this);
    L56:
        if (y3.m(this.a).n(ToolbarButton.LIVE_IM_ENTRANCE_MORE) == false) goto L58;
        int r29 = com.bytedance.android.livesdk.interactivity.im.a.a;
        com.bytedance.android.livesdk.interactivity.im.a.b(this.a);
        return;
    L58:
        int r30 = b82.a.a;
        Intrinsics.checkNotNullParameter("im entrance folded more showing failed", "msg");
        ALogger.d("TTLIVE_IM_INDUSTRY", "im entrance folded more showing failed");
        return;
    L11:
        r9 = null;
        goto L12
    }
}
