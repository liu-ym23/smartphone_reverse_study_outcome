package com.bytedance.android.live.liveinteract.revenue.guestlink.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.message.guestlink.LinkmicGuestLinkUserRole;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.revenue.guestlink.GuestLinkWidget;
import com.bytedance.android.live.liveinteract.revenue.guestlink.ui.GiftMarqueeContainer;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.gson.JsonObject;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/guestlink/dialog/BaseGuestLinkMainPageDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseGuestLinkMainPageDialog extends LiveDialogFragment {
    public vi0.a A;
    public final Map<String, Boolean> B;
    public com.bytedance.android.live.base.model.message.guestlink.a C;
    public lb6.g D;
    public final CompositeDisposable E;
    public com.bytedance.android.live.liveinteract.revenue.guestlink.ui.c F;
    public final ui0.b G;
    public final com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.c H;
    public final j1 I;
    public final DataCenter J;
    public View d;
    public View e;
    public View f;
    public View g;
    public TextView h;
    public HSImageView i;
    public HSImageView j;
    public HSImageView k;
    public View l;
    public TextView m;
    public TextView n;
    public View o;
    public HSImageView p;
    public Button q;
    public Button r;
    public View s;
    public TextView t;
    public View u;
    public View v;
    public HSImageView w;
    public HSImageView x;
    public j22.c y;
    public j22.c z;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ BaseGuestLinkMainPageDialog a;

        public b(BaseGuestLinkMainPageDialog r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            ALogger.d("BaseGuestLinkMainPageDialog", "renderChannelInfo");
            BaseGuestLinkMainPageDialog r0 = this.a;
            r0.Z90((com.bytedance.android.live.base.model.message.guestlink.a) r3);
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r3) {
            ALogger.e("BaseGuestLinkMainPageDialog", "renderChannelInfo", (Throwable) r3);
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ BaseGuestLinkMainPageDialog a;

        public d(BaseGuestLinkMainPageDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            ALogger.i("BaseGuestLinkMainPageDialog", "onClick ll_audience_container");
            com.bytedance.android.live.base.model.message.guestlink.a r0 = this.a.T90();
            if (r0 == null) goto L13;
            ALogger.i("BaseGuestLinkMainPageDialog", "openByStanderListPanel, channelId: " + r0.getChannelId());
            int r6 = tb6.a.a;
            tb6.a.e(this.a instanceof GuestLinkMainPageDialogForLinker, r0, "watchingpage", null);
            int r7 = com.bytedance.android.live.liveinteract.revenue.guestlink.a.a;
            Context r8 = this.a.requireContext();
            HashMap r1 = new HashMap();
            r1.put("channel_id", String.valueOf(r0.getChannelId()));
            Unit r2 = Unit.INSTANCE;
            Intrinsics.checkNotNullParameter(r8, "context");
            String r3 = vm2.i.e().getBystanderListSchema();
            String r4 = "";
            if (r3 != null) goto L7;
            r3 = "";
        L7:
            String r9 = vm2.i.e().getBystanderListUrl();
            if (r9 == null) goto L11;
            r4 = r9;
        L11:
            com.bytedance.android.live.liveinteract.revenue.guestlink.a.a(r8, r3, r4, r1);
            return;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ BaseGuestLinkMainPageDialog a;
        public final /* synthetic */ IBaseUser b;

        public e(BaseGuestLinkMainPageDialog r1, IBaseUser r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            ALogger.i("BaseGuestLinkMainPageDialog", "onClick Avatar");
            BaseGuestLinkMainPageDialog.S90(this.a, this.b);
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ BaseGuestLinkMainPageDialog a;
        public final /* synthetic */ IBaseUser b;

        public f(BaseGuestLinkMainPageDialog r1, IBaseUser r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            ALogger.i("BaseGuestLinkMainPageDialog", "onClick Avatar");
            BaseGuestLinkMainPageDialog.S90(this.a, this.b);
        }
    }

    static {
    }

    public void X90(String r1, Boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "interactId");
    }

    public void Y90(String[] r1, boolean[] r2, int[] r3) {
    }

    public final com.bytedance.android.live.base.model.message.guestlink.a T90() {
        lb6.g r0 = this.D;
        if (r0 == null) goto L11;
        sb6.a r1 = r0.getLinkState();
        if (r1 == null) goto L12;
        com.bytedance.android.live.base.model.message.guestlink.a r2 = r1.f;
        if ((r2 instanceof pb6.a) == false) goto L10;
        return null;
    L10:
        return r2;
    L12:
        return null;
    L11:
        return null;
    }

    public void ca0() {
        View r0 = this.g;
        if (r0 == null) goto L6;
        r0.setVisibility(4);
        return;
    }

    public void initView() {
        View r0 = this.d;
        HSImageView r1 = null;
        if (r0 == null) goto L5;
        View r2 = r0.findViewById(2131378928);
    L6:
        this.e = r2;
        View r3 = this.d;
        if (r3 == null) goto L9;
        View r4 = r3.findViewById(2131382465);
    L10:
        this.f = r4;
        View r5 = this.d;
        if (r5 == null) goto L13;
        View r6 = r5.findViewById(2131392034);
    L14:
        this.g = r6;
        View r7 = this.d;
        if (r7 == null) goto L17;
        TextView r8 = (TextView) r7.findViewById(2131391592);
    L18:
        this.h = r8;
        View r9 = this.d;
        if (r9 == null) goto L21;
        HSImageView r10 = (HSImageView) r9.findViewById(2131376011);
    L22:
        this.i = r10;
        View r11 = this.d;
        if (r11 == null) goto L25;
        HSImageView r12 = (HSImageView) r11.findViewById(2131376012);
    L26:
        this.j = r12;
        View r13 = this.d;
        if (r13 == null) goto L29;
        HSImageView r14 = (HSImageView) r13.findViewById(2131376013);
    L30:
        this.k = r14;
        View r15 = this.d;
        if (r15 == null) goto L33;
        View r16 = r15.findViewById(2131376033);
    L34:
        this.s = r16;
        View r17 = this.d;
        if (r17 == null) goto L37;
        View r18 = r17.findViewById(2131365017);
    L38:
        this.l = r18;
        View r19 = this.d;
        if (r19 == null) goto L41;
        TextView r20 = (TextView) r19.findViewById(2131391606);
    L42:
        this.t = r20;
        View r21 = this.d;
        if (r21 == null) goto L45;
        TextView r22 = (TextView) r21.findViewById(2131365045);
    L46:
        this.m = r22;
        View r23 = this.d;
        if (r23 == null) goto L49;
        TextView r24 = (TextView) r23.findViewById(2131365050);
    L50:
        this.n = r24;
        View r25 = this.d;
        if (r25 == null) goto L53;
        View r26 = r25.findViewById(2131365012);
    L54:
        this.o = r26;
        View r27 = this.d;
        if (r27 == null) goto L57;
        HSImageView r28 = (HSImageView) r27.findViewById(2131365022);
    L58:
        this.p = r28;
        View r29 = this.d;
        if (r29 == null) goto L61;
        Button r30 = (Button) r29.findViewById(2131364988);
    L62:
        this.q = r30;
        View r31 = this.d;
        if (r31 == null) goto L65;
        Button r32 = (Button) r31.findViewById(2131364989);
    L66:
        this.r = r32;
        View r33 = this.d;
        if (r33 == null) goto L71;
        View r34 = r33.findViewById(2131367787);
        if (r34 == null) goto L71;
        HSImageView r35 = (HSImageView) r34.findViewById(2131389896);
    L72:
        this.w = r35;
        View r36 = this.d;
        if (r36 == null) goto L77;
        View r37 = r36.findViewById(2131367789);
        if (r37 == null) goto L77;
        r1 = (HSImageView) r37.findViewById(2131389896);
    L77:
        this.x = r1;
        this.y = new j22.c(this.w);
        this.z = new j22.c(this.x);
        return;
    L71:
        r35 = null;
        goto L72
    L65:
        r32 = null;
        goto L66
    L61:
        r30 = null;
        goto L62
    L57:
        r28 = null;
        goto L58
    L53:
        r26 = null;
        goto L54
    L49:
        r24 = null;
        goto L50
    L45:
        r22 = null;
        goto L46
    L41:
        r20 = null;
        goto L42
    L37:
        r18 = null;
        goto L38
    L33:
        r16 = null;
        goto L34
    L29:
        r14 = null;
        goto L30
    L25:
        r12 = null;
        goto L26
    L21:
        r10 = null;
        goto L22
    L17:
        r8 = null;
        goto L18
    L13:
        r6 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        ui0.b r0 = this.G;
        r0.getClass();
        ALogger.i("LiveRoomAudioManger", "onDestroy");
        if (je0.d.r() == false) goto L8;
        ALogger.i("LiveRoomAudioManger", "onDestroy, user: anchor");
        rj0.k.m2.getClass();
        rj0.k r1 = rj0.k.a.a();
        if (r1 == null) goto L12;
        r1.lm(false);
    L12:
        if (r0.a == false) goto L14;
        r0.a(false, "LiveRoomAudioManger#onDestroy");
    L14:
        vi0.b.b();
        ui0.a r2 = r0.b;
        if (r2 == null) goto L24;
        r2.a = false;
        ALogger.i("LivePlayerMediaManager", "onDestroy");
        ILivePlayerClient r3 = r2.b;
        if (r3 == null) goto L23;
        IRoomEventHub r4 = r3.getEventHub();
        if (r4 == null) goto L23;
        MutableLiveData r5 = r4.getPlayerMute();
        if (r5 == null) goto L23;
        ALogger.i("LivePlayerMediaManager", "remove playerMuteObserver");
        r5.removeObserver(r2.c);
    L23:
        r2.b = null;
    L24:
        r0.b = null;
        ALogger.i("BaseGuestLinkMainPageDialog", "sendHidePageEventToLynx");
        ih0.b r6 = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicService(this.J);
        if (r6 == null) goto L28;
        JsonObject r7 = new JsonObject();
        r7.addProperty("type", "guest_link_call_page_hide");
        Unit r8 = Unit.INSTANCE;
        r6.Dk("guest_link", "guest_link_event", r7, false);
        return;
    L28:
        return;
    L8:
        if (hd0.c.f().h() == true) goto L10;
        ALogger.i("LiveRoomAudioManger", "onDestroy, user: audience");
        goto L12
    L10:
        ALogger.i("LiveRoomAudioManger", "onDestroy, user: guest");
        goto L12
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.E.clear();
        lb6.g r0 = this.D;
        if (r0 == null) goto L5;
        r0.b(this.H);
    L5:
        com.bytedance.android.live.liveinteract.revenue.guestlink.ui.c r1 = this.F;
        if (r1 == null) goto L8;
        r1.c();
    L8:
        this.F = null;
    }

    public static com.bytedance.android.live.base.model.message.guestlink.k U90(com.bytedance.android.live.base.model.message.guestlink.a r5) {
        Intrinsics.checkNotNullParameter(r5, "channelInfo");
        List r6 = r5.getLinkedUsers();
        Object r0 = null;
        if (r6 == null) goto L23;
        Iterator r7 = r6.iterator();
    L6:
        if (r7.hasNext() == false) goto L17;
        Object r1 = r7.next();
        com.bytedance.android.live.base.model.message.guestlink.k r2 = (com.bytedance.android.live.base.model.message.guestlink.k) r1;
        if (r2.getUserRole() != LinkmicGuestLinkUserRole.LinkmicGuestLinkUserRole_Inviter.getValue()) goto L10;
    L13:
        boolean r3 = true;
    L14:
        if (r3 == false) goto L6;
        r0 = r1;
        goto L17
    L10:
        if (r2.getUserRole() == LinkmicGuestLinkUserRole.LinkmicGuestLinkUserRole_MatchMaking.getValue()) goto L13;
        r3 = false;
    L17:
        return (com.bytedance.android.live.base.model.message.guestlink.k) r0;
    L23:
        return null;
    }

    public static com.bytedance.android.live.base.model.message.guestlink.k V90(com.bytedance.android.live.base.model.message.guestlink.a r3) {
        Intrinsics.checkNotNullParameter(r3, "channelInfo");
        List r0 = r3.getLinkedUsers();
        if (r0 == null) goto L5;
        int r1 = r0.size();
    L7:
        if (r1 >= 2) goto L9;
        return null;
    L9:
        List r4 = r3.getLinkedUsers();
        if (r4 != null) goto L12;
        return null;
    L12:
        return (com.bytedance.android.live.base.model.message.guestlink.k) ListProtector.get(r4, 1);
    L5:
        r1 = 0;
        goto L7
    }

    public static boolean W90(com.bytedance.android.live.base.model.message.guestlink.k r6) {
        if (r6 != null) goto L4;
    L8:
        return false;
    L4:
        if (r6.getLinkType() != 1) goto L8;
        if (r6.isBackground() == 1) goto L8;
        return true;
    }

    public void Z90(com.bytedance.android.live.base.model.message.guestlink.a r9) {
        Intrinsics.checkNotNullParameter(r9, "channelInfo");
        com.bytedance.android.live.base.model.message.guestlink.a r0 = T90();
        if (r0 == null) goto L7;
        List r1 = r0.getLinkedUsers();
        if (r1 == null) goto L7;
        int r2 = r1.size();
    L8:
        List r3 = r9.getLinkedUsers();
        if (r3 == null) goto L11;
        int r4 = r3.size();
    L12:
        if (r4 >= r2) goto L15;
        return;
    L15:
        if ((r9 instanceof pb6.a) == false) goto L17;
        return;
    L17:
        da0(r9.getChannelBackground());
        ALogger.d("BaseGuestLinkMainPageDialog", "renderChannelInfo: channelInfo: " + r9);
        View r5 = null;
        if (W90(U90(r9)) == false) goto L29;
        View r6 = this.d;
        if (r6 == null) goto L22;
        View r7 = r6.findViewById(2131367788);
    L23:
        this.u = r7;
        View r8 = this.d;
        if (r8 == null) goto L28;
        View r10 = r8.findViewById(2131367787);
        if (r10 == null) goto L28;
        r10.setVisibility(8);
    L28:
        ca0();
    L39:
        if (W90(V90(r9)) == false) goto L49;
        View r11 = this.d;
        if (r11 == null) goto L43;
        r5 = r11.findViewById(2131367790);
    L43:
        this.v = r5;
        View r12 = this.d;
        if (r12 == null) goto L48;
        View r13 = r12.findViewById(2131367789);
        if (r13 == null) goto L48;
        r13.setVisibility(8);
    L48:
        ca0();
    L57:
        View r14 = this.u;
        if (r14 == null) goto L60;
        r14.setVisibility(0);
    L60:
        View r15 = this.v;
        if (r15 == null) goto L63;
        r15.setVisibility(0);
    L63:
        View r16 = this.d;
        if (r16 == null) goto L68;
        TextView r17 = (TextView) r16.findViewById(2131390174);
        if (r17 == null) goto L68;
        r17.setText(s1.C(2131917268, new Object[]{Long.valueOf(r9.getChannelUserCount())}));
    L68:
        List r18 = r9.getChannelUsers();
        View r19 = this.d;
        if (r19 == null) goto L73;
        View r20 = r19.findViewById(2131378611);
        if (r20 == null) goto L73;
        r20.setVisibility(0);
    L73:
        HSImageView r21 = this.i;
        if (r21 == null) goto L76;
        r21.setVisibility(8);
    L76:
        HSImageView r22 = this.j;
        if (r22 == null) goto L79;
        r22.setVisibility(8);
    L79:
        HSImageView r23 = this.k;
        if (r23 == null) goto L82;
        r23.setVisibility(8);
    L82:
        if (r18 == null) goto L92;
        IBaseUser r24 = (IBaseUser) CollectionsKt.getOrNull(r18, 0);
        if (r24 == null) goto L92;
        HSImageView r25 = this.i;
        if (r25 == null) goto L88;
        r25.setVisibility(0);
    L88:
        HSImageView r26 = this.i;
        py.k r27 = r24.getAvatarMedium();
        Intrinsics.checkNotNull(r27);
        r24.getIdString();
        if (r26 == null) goto L92;
        ImageUtil.loadRoundImage(r26, r27);
    L92:
        if (r18 == null) goto L102;
        IBaseUser r28 = (IBaseUser) CollectionsKt.getOrNull(r18, 1);
        if (r28 == null) goto L102;
        HSImageView r29 = this.j;
        if (r29 == null) goto L98;
        r29.setVisibility(0);
    L98:
        HSImageView r30 = this.j;
        py.k r31 = r28.getAvatarMedium();
        Intrinsics.checkNotNull(r31);
        r28.getIdString();
        if (r30 == null) goto L102;
        ImageUtil.loadRoundImage(r30, r31);
    L102:
        if (r18 == null) goto L112;
        IBaseUser r32 = (IBaseUser) CollectionsKt.getOrNull(r18, 2);
        if (r32 == null) goto L112;
        HSImageView r33 = this.k;
        if (r33 == null) goto L108;
        r33.setVisibility(0);
    L108:
        HSImageView r34 = this.k;
        py.k r35 = r32.getAvatarMedium();
        Intrinsics.checkNotNull(r35);
        r32.getIdString();
        if (r34 == null) goto L112;
        ImageUtil.loadRoundImage(r34, r35);
    L112:
        com.bytedance.android.live.base.model.message.guestlink.k r36 = U90(r9);
        View r37 = this.u;
        if (r37 == null) goto L121;
        ba0(r36, (ViewGroup) r37, 2131249213, W90(r36));
        com.bytedance.android.live.base.model.message.guestlink.k r38 = V90(r9);
        View r39 = this.v;
        if (r39 == null) goto L119;
        ba0(r38, (ViewGroup) r39, 2131249214, W90(r38));
        return;
    L119:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L121:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L49:
        View r40 = this.d;
        if (r40 == null) goto L52;
        r5 = r40.findViewById(2131367789);
    L52:
        this.v = r5;
        View r41 = this.d;
        if (r41 == null) goto L57;
        View r42 = r41.findViewById(2131367790);
        if (r42 == null) goto L57;
        r42.setVisibility(8);
        goto L57
    L22:
        r7 = null;
        goto L23
    L29:
        View r43 = this.d;
        if (r43 == null) goto L32;
        View r44 = r43.findViewById(2131367787);
    L33:
        this.u = r44;
        View r45 = this.d;
        if (r45 == null) goto L39;
        View r46 = r45.findViewById(2131367788);
        if (r46 == null) goto L39;
        r46.setVisibility(8);
        goto L39
    L32:
        r44 = null;
        goto L33
    L11:
        r4 = 0;
    L7:
        r2 = 0;
        goto L8
    }

    public final void aa0(long r10) {
        if (r10 >= 0) goto L14;
        TextView r11 = this.h;
        if (r11 == null) goto L7;
        r11.setText(s1.B(2131917287));
    L7:
        TextView r12 = this.h;
        if (r12 == null) goto L10;
        r12.setTextColor(ColorProtector.parseColor("#FFFFFF"));
    L10:
        TextView r13 = this.h;
        if (r13 == null) goto L29;
        r13.setTextSize(11.0f);
        return;
    L29:
        return;
    L14:
        TextView r0 = this.h;
        if (r0 == null) goto L17;
        StringCompanionObject r3 = StringCompanionObject.INSTANCE;
        long r5 = 60;
        r0.setText(String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r10 / r5), Long.valueOf(r10 % r5)}, 2)));
    L17:
        TextView r1 = this.h;
        if (r1 == null) goto L21;
        r1.setTextSize(14.0f);
    L21:
        if (r10 >= 60) goto L25;
        TextView r14 = this.h;
        if (r14 == null) goto L30;
        r14.setTextColor(ColorProtector.parseColor("#FE2C55"));
        return;
    L30:
        return;
    L25:
        TextView r15 = this.h;
        if (r15 == null) goto L32;
        r15.setTextColor(ColorProtector.parseColor("#FFFFFF"));
        return;
    }

    public final void da0(IVoiceLiveTheme r4) {
        View r0 = this.d;
        if (r0 == null) goto L5;
        HSImageView r1 = r0.findViewById(2131379449);
    L6:
        if (r1 == null) goto L8;
        r1.post(new com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.d(this, r1));
    L8:
        if (r4 != null) goto L14;
        if (r1 == null) goto L11;
        r1.setController(null);
    L11:
        if (r1 == null) goto L22;
        r1.setBackground(s1.m(2131249210));
        return;
    L22:
        return;
    L14:
        if (r1 == null) goto L16;
        r1.setController(null);
    L16:
        py.k r5 = r4.getSingleStaticBackground();
        if (r5 != null) goto L19;
        r5 = (py.k) vh7.f.c(py.k.class);
    L19:
        if (r1 == null) goto L23;
        r1.setController(Fresco.newDraweeControllerBuilder().setFirstAvailableImageRequests(a1.b(r5, -1)).setOldController(r1.getController()).build());
        return;
    L23:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L8;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L9;
        WindowManager.LayoutParams r0 = r5.getAttributes();
        r0.width = -1;
        r0.height = -1;
        r5.setAttributes(r0);
        r5.setBackgroundDrawable(new ColorDrawable(0));
        r5.setGravity(80);
        return;
    L9:
        return;
    }

    public void onCreate(Bundle r5) {
        super.onCreate(r5);
        ui0.b r6 = this.G;
        r6.getClass();
        ALogger.i("LiveRoomAudioManger", "onCreate");
        if (je0.d.r() == false) goto L8;
        ALogger.i("LiveRoomAudioManger", "onCreate, user: anchor");
        rj0.k.m2.getClass();
        rj0.k r7 = rj0.k.a.a();
        if (r7 == null) goto L11;
        r7.lm(true);
    L11:
        vi0.b.b();
        return;
    L8:
        if (hd0.c.f().h() == true) goto L10;
        ALogger.i("LiveRoomAudioManger", "onCreate, user: audience");
        r6.a(true, "onCreate");
        goto L11
    L10:
        ALogger.i("LiveRoomAudioManger", "onCreate, user: guest");
        goto L11
    }

    public BaseGuestLinkMainPageDialog(GuestLinkWidget r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "outerScopeProvider");
        this.I = r2;
        this.J = r3;
        this.B = new LinkedHashMap();
        this.E = new CompositeDisposable();
        this.G = new ui0.b(this);
        this.H = new com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.c(this);
    }

    public static final void S90(BaseGuestLinkMainPageDialog r1, IBaseUser r2) {
        r1.getClass();
        if (Intrinsics.areEqual(r2.getIdString(), gh0.a.c()) == true) goto L7;
        ALogger.i("BaseGuestLinkMainPageDialog", "showProfile");
        xs2.b.a().post(new UserProfileEvent(r2).setClickUserPosition("guest_link").setReportSource("guest_link").setReportType("data_card_guest_link"));
        return;
    }

    public void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        initView();
        Map r6 = vm2.i.e().getSeatRatioConfig();
        if (r6 == null) goto L7;
        Integer r7 = (Integer) r6.get("width");
        if (r7 == null) goto L7;
        float r8 = r7.intValue();
    L8:
        if (r6 == null) goto L12;
        Integer r9 = (Integer) r6.get("height");
        if (r9 == null) goto L12;
        float r10 = r9.intValue();
    L13:
        Ref.FloatRef r0 = new Ref.FloatRef();
        r0.element = 0.75f;
        if (r10 != 0.0f) goto L16;
    L18:
        View r11 = this.e;
        if (r11 == null) goto L21;
        r11.post(new com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.b(this, r0));
    L21:
        View r12 = this.f;
        if (r12 == null) goto L24;
        r12.post(new com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.a(r12, this, r0));
    L24:
        com.bytedance.android.live.base.model.message.guestlink.a r13 = T90();
        if (r13 == null) goto L27;
        Z90(r13);
    L27:
        lb6.g r14 = this.D;
        if (r14 == null) goto L36;
        sb6.a r15 = r14.getLinkState();
        if (r15 == null) goto L36;
        PublishSubject r16 = r15.e;
        if (r16 == null) goto L36;
        Disposable r17 = r16.subscribe(new b(this), c.a);
        if (r17 == null) goto L36;
        RxUtilKt.c(r17, this.E);
    L36:
        lb6.g r18 = this.D;
        if (r18 == null) goto L39;
        r18.d(this.H, false);
    L39:
        View r19 = this.d;
        if (r19 == null) goto L44;
        View r20 = r19.findViewById(2131378611);
        if (r20 == null) goto L44;
        r20.setOnClickListener(new d(this));
    L44:
        View r21 = this.d;
        if (r21 == null) goto L50;
        GiftMarqueeContainer r22 = (GiftMarqueeContainer) r21.findViewById(2131373741);
        if (r22 == null) goto L51;
        com.bytedance.android.live.liveinteract.revenue.guestlink.ui.c r23 = new com.bytedance.android.live.liveinteract.revenue.guestlink.ui.c(r22, this.I);
        this.F = r23;
        r23.b();
        return;
    L51:
        return;
    L50:
        return;
    L16:
        if (r8 == 0.0f) goto L18;
        r0.element = (r8 * 2) / r10;
    L12:
        r10 = 480.0f;
    L7:
        r8 = 360.0f;
        goto L8
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131566047, r3, false);
        this.d = r5;
        return r5;
    }

    public final void ba0(com.bytedance.android.live.base.model.message.guestlink.k r7, ViewGroup r8, int r9, boolean r10) {
        if (r7 == null) goto L37;
        IBaseUser r11 = r7.getUser();
        if (r11 == null) goto L50;
        if (r10 == false) goto L8;
        r8.setOnClickListener(new f(this, r11));
    L11:
        TextView r12 = (TextView) r8.findViewById(2131391677);
        if (r12 == null) goto L14;
        r12.setText(r11.getNickName());
    L14:
        ViewGroup r13 = (ViewGroup) r8.findViewById(2131378795);
        boolean r14 = true;
        int r1 = 0;
        if (r13 == null) goto L29;
        r13.setVisibility(0);
        String r15 = r7.getScoreStr();
        if (r15 != null) goto L19;
    L26:
        TextView r16 = (TextView) r8.findViewById(2131391111);
        if (r16 == null) goto L29;
        r16.setText(r7.getScoreStr());
        goto L29
    L19:
        if (r15.length() != 0) goto L21;
        boolean r17 = true;
    L22:
        if (r17 != true) goto L26;
        TextView r18 = (TextView) r8.findViewById(2131391111);
        if (r18 == null) goto L29;
        r18.setText("0");
        goto L29
    L21:
        r17 = false;
    L29:
        TextView r19 = (TextView) r8.findViewById(2131391678);
        Intrinsics.checkNotNullParameter(r7, "$this$isInviter");
        if (r7.getUserRole() == LinkmicGuestLinkUserRole.LinkmicGuestLinkUserRole_Inviter.getValue()) goto L33;
        r14 = false;
    L33:
        if (r14 == true) goto L36;
        r1 = 8;
    L36:
        r19.setVisibility(r1);
        r8.setBackground(null);
        return;
    L8:
        HSImageView r110 = r8.findViewById(2131376717);
        if (r110 == null) goto L11;
        py.k r4 = r11.getAvatarMedium();
        Intrinsics.checkNotNull(r4);
        r11.getIdString();
        ImageUtil.loadRoundImage(r110, r4);
        r110.setOnClickListener(new e(this, r11));
        goto L11
    L50:
        return;
    L37:
        HSImageView r20 = r8.findViewById(2131376717);
        if (r20 == null) goto L40;
        r20.setTag(null);
        a1.m(r20, 2131250763);
    L40:
        TextView r21 = (TextView) r8.findViewById(2131391677);
        if (r21 == null) goto L43;
        r21.setText(s1.B(2131917296));
    L43:
        ViewGroup r22 = (ViewGroup) r8.findViewById(2131378795);
        if (r22 == null) goto L48;
        r22.setVisibility(4);
        TextView r23 = (TextView) r8.findViewById(2131391111);
        if (r23 == null) goto L48;
        r23.setText("0");
    L48:
        r8.setBackgroundResource(r9);
    }

    public final void ea0(com.bytedance.android.live.base.model.message.guestlink.k r7, j22.c r8, HSImageView r9, int r10) {
        if (W90(r7) == false) goto L6;
        return;
    L6:
        if (j22.c.c(r10, true) <= 0) goto L8;
        boolean r11 = true;
    L9:
        Boolean r2 = Boolean.valueOf(r11);
        Map<String, Boolean> r3 = this.B;
        if (r7 == null) goto L12;
        String r5 = r7.getLinkmicIdStr();
    L13:
        Intrinsics.checkNotNull(r5);
        if (Intrinsics.areEqual(r2, (Boolean) ((LinkedHashMap) r3).get(r5)) == false) goto L16;
        return;
    L16:
        if (r11 == false) goto L22;
        if (r9 == null) goto L19;
        r9.setVisibility(0);
    L19:
        String r12 = vm2.d.a0().unkownMediaAnim;
        if (r8 == null) goto L28;
        r8.d(r12);
    L28:
        Map<String, Boolean> r13 = this.B;
        String r14 = r7.getLinkmicIdStr();
        Intrinsics.checkNotNull(r14);
        r13.put(r14, Boolean.valueOf(r11));
        return;
    L22:
        if (r8 == null) goto L24;
        r8.d = true;
    L24:
        if (r9 == null) goto L28;
        if (r9.isAnimating() == true) goto L28;
        r9.setController(null);
        r9.setVisibility(4);
        goto L28
    L12:
        r5 = null;
        goto L13
    L8:
        r11 = false;
        goto L9
    }
}
