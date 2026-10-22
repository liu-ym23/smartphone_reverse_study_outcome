package ig0;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ch0.e;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.SeatAnimManager;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.n;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.o;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.p;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.w;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.LinkSucAnimationView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.SeatAnimationView;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.seatanim.SeatAnimEngineWrapper;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.livesdk.chatroom.ui.d6;
import com.bytedance.android.livesdk.chatroom.ui.e6;
import com.bytedance.android.livesdk.message.model.za;
import com.bytedance.android.livesdkapi.depend.model.live.linker.IMatchEffect;
import com.bytedance.live.datacontext.j;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import vh7.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class b extends jg0.a<MultiLinkGuestViewBinder.a> implements e6, LinkSucAnimationView.a, ke0.a {
    public MultiLinkGuestViewBinder.a e;
    public SeatAnimationView f;
    public int g;
    public final hg0.a h;
    public final int i;
    public final SeatAnimEngineWrapper j;
    public final o k;

    public static final class a implements Runnable {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        public final void a() {
            b r0 = this.a;
            hg0.a r1 = r0.h;
            View r2 = null;
            if (r1 == null) goto L7;
            g r3 = r1.ph(r0.g);
            if (r3 == null) goto L7;
            View r4 = r3.m(2131389564);
        L8:
            ImageView r5 = (ImageView) r4;
            if (r5 == null) goto L11;
            this.a.t().setGuestAvatar(r5);
        L11:
            b r6 = this.a;
            hg0.a r7 = r6.h;
            if (r7 == null) goto L16;
            g r8 = r7.ph(r6.g);
            if (r8 == null) goto L16;
            r2 = r8.m(2131389585);
        L16:
            TextView r9 = (TextView) r2;
            if (r9 == null) goto L20;
            this.a.t().setGuestName(r9);
            return;
        L20:
            return;
        L7:
            r4 = null;
            goto L8
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

    /* JADX INFO: renamed from: ig0.b$b, reason: collision with other inner class name */
    public static final class RunnableC0220b implements Runnable {
        public final /* synthetic */ b a;

        public RunnableC0220b(b r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            SeatAnimationView r0 = this.a.t();     // Catch: Throwable -> L14
            if (r0 == null) goto L5;
            r0.setLinkSucCallback(this.a);     // Catch: Throwable -> L14
        L5:
            SeatAnimationView r1 = this.a.t();     // Catch: Throwable -> L14
            if (r1 == null) goto L8;
            r1.setEmojiCallback(this.a);     // Catch: Throwable -> L14
        L8:
            b r2 = this.a;     // Catch: Throwable -> L14
            if (r2.k == null) goto L17;
            SeatAnimationView r3 = r2.t();     // Catch: Throwable -> L14
            if (r3 == null) goto L21;
            r3.setTaskChain(this.a.k);     // Catch: Throwable -> L14
            return;
        L21:
            return;
        L17:
            return;
        L14:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L22;
            throw th;
        }
    }

    @Override // jg0.c, jg0.f
    public final void j(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    @Override // jg0.c
    public int o() {
        return 2131566613;
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.LinkSucAnimationView.a
    public final void g() {
        hg0.a r0 = this.h;
        if (r0 == null) goto L8;
        g r1 = r0.ph(this.g);
        if (r1 == null) goto L9;
        r1.g();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.LinkSucAnimationView.a
    public final void h() {
        hg0.a r0 = this.h;
        if (r0 == null) goto L8;
        g r1 = r0.ph(this.g);
        if (r1 == null) goto L9;
        r1.h();
        return;
    L9:
        return;
    }

    @Override // jg0.c
    public String p() {
        return VerticalNitaInflate.Tag.MultiLinkMicSeatAnimLayer.name();
    }

    public void r() {
        SeatAnimationView r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("animationView");
    L5:
        r0.post(new a(this));
    }

    public boolean s() {
        MultiLinkGuestViewBinder.a r0 = this.e;
        if (r0 == null) goto L13;
        e r1 = r0.k;
        if (r1 == null) goto L14;
        ILinkPlayerInfoBridge r2 = r1.a;
        if (r2 != null) goto L9;
        return true;
    L9:
        if (r2.isEnlarged() != true) goto L16;
        return false;
    L16:
        return true;
    L14:
        return true;
    L13:
        return true;
    }

    public final SeatAnimationView t() {
        SeatAnimationView r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("animationView");
    L5:
        return r0;
    }

    @Override // jg0.c, jg0.f
    public void a(Context r16) {
        Intrinsics.checkNotNullParameter(r16, "context");
        super.a(r16);
        j r0 = m.d().getVideoTalkRoomSubScene();
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r1 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r0.getValue();
        if (r1 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r2 = r1.t();
        if (r2 == null) goto L9;
        List r4 = r2.b;
    L10:
        j r3 = m.d().getVideoTalkRoomSubScene();
        if (r3 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r5 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r3.getValue();
        if (r5 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r6 = r5.t();
        if (r6 == null) goto L17;
        Integer r7 = Integer.valueOf(r6.c);
    L18:
        Boolean r8 = m.i().isAnchor();
        if (r8 == null) goto L21;
        boolean r9 = r8.booleanValue();
    L22:
        MicSeatScene r10 = this.b;
        MicSeatScene r11 = MicSeatScene.AUDIO_LINK_LARGE;
        if (r10 != r11) goto L25;
        boolean r12 = true;
    L26:
        this.f = (SeatAnimationView) q().findViewById(2131385655);
        Integer r13 = je0.d.h();
        if (r13 != null) goto L30;
    L32:
        boolean r14 = r9;
    L33:
        MicSeatScene r15 = this.b;
        if (r15 != MicSeatScene.AUDIO_LINK) goto L36;
    L58:
        SeatAnimationView r17 = this.f;
        if (r17 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("animationView");
    L61:
        r17.post(new c(this, r14, r12, r4, r7));
    L62:
        SeatAnimationView r18 = this.f;
        if (r18 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("animationView");
    L65:
        if (r18 == null) goto L68;
        r18.post(new RunnableC0220b(this));
        return;
    L68:
        return;
    L36:
        if (r15 == MicSeatScene.AUDIO_LINK_ANCHOR) goto L58;
        if (r15 == r11) goto L58;
        if (r15 == MicSeatScene.AUDIO_LINK_C_POSITION) goto L58;
        if (r15 == MicSeatScene.AUDIO_LINK_C_POSITION_V2) goto L58;
        if (r15 == MicSeatScene.AUDIO_LINK_HAMLET_AVATAR_C_POSITION) goto L58;
        if (r15 == MicSeatScene.AUDIO_LINK_HEAD_RADIO) goto L58;
        SeatAnimationView r19 = this.f;
        if (r19 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("animationView");
    L50:
        r19.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
        if (this.b != r11) goto L53;
        int r110 = s1.j(2131169257);
    L54:
        SeatAnimationView r20 = this.f;
        if (r20 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("animationView");
    L57:
        r20.c(this.i, this.b, r12, r14, r110, r110);
        goto L62
    L53:
        r110 = 0;
        goto L54
    L30:
        if (r13.intValue() != 24) goto L32;
        r14 = false;
        goto L33
    L25:
        r12 = false;
        goto L26
    L21:
        r9 = false;
    L17:
        r7 = null;
    L9:
        r4 = null;
        goto L10
    }

    @Override // ke0.a
    public final void b(w r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        SeatAnimEngineWrapper r1 = this.j;
        if (r1 == null) goto L22;
        SeatAnimManager r2 = r1.a;
        if (r2 == null) goto L23;
        Intrinsics.checkNotNullParameter(r3, "event");
        if ((r3 instanceof com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.b) == false) goto L17;
        com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.b r4 = (com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.b) r3;
        String r0 = r4.c;
        Map<String, SeatAnimationView> r5 = r2.a;
        LinkedHashMap r6 = (LinkedHashMap) r5;
        SeatAnimationView r7 = (SeatAnimationView) r6.get(r0.toString());
        if (r7 == null) goto L12;
        r7.b(r4);
        return;
    L12:
        if (r4.b == false) goto L25;
        Function0<Unit> r8 = r4.i;
        if (r8 == null) goto L26;
        Unit r9 = (Unit) r8.invoke();
        return;
    L26:
        return;
    L25:
        return;
    L17:
        if ((r3 instanceof n) == false) goto L28;
        n r10 = (n) r3;
        String r11 = r10.a.c();
        Map<String, SeatAnimationView> r12 = r2.a;
        LinkedHashMap r13 = (LinkedHashMap) r12;
        SeatAnimationView r14 = (SeatAnimationView) r13.get(r11.toString());
        if (r14 == null) goto L29;
        r14.b(r10);
        return;
    L29:
        return;
    L28:
        return;
    L23:
        return;
    }

    public void c(d6 r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        hg0.a r0 = this.h;
        if (r0 == null) goto L8;
        g r1 = r0.ph(this.g);
        if (r1 == null) goto L9;
        r1.c(r3);
        return;
    L9:
        return;
    }

    @Override // jg0.f
    public final void d(Object r19, int r20) {
        MultiLinkGuestViewBinder.a r2 = (MultiLinkGuestViewBinder.a) r19;
        Intrinsics.checkNotNullParameter(r2, "itemData");
        this.g = r20;
        this.e = r2;
        i<ILinkPlayerInfoBridge> r3 = ((IInteractService) k.n(IInteractService.class)).getLinkUserInfoCenter();
        SeatAnimationView r4 = this.f;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("animationView");
    L5:
        r4.setEnableShowKtvSeatAnimation(s());
        IBaseUser r5 = r2.k.a.getUser();
        if (r5 == null) goto L96;
        r();
        SeatAnimationView r6 = this.f;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("animationView");
    L11:
        r6.post(new d(this, r20));
        SeatAnimEngineWrapper r1 = this.j;
        if (r1 == null) goto L20;
        String r7 = r5.getIdString();
        SeatAnimationView r8 = this.f;
        if (r8 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("animationView");
    L16:
        Intrinsics.checkNotNullParameter(r7, "userId");
        Intrinsics.checkNotNullParameter(r8, "view");
        SeatAnimManager r9 = r1.a;
        if (r9 == null) goto L20;
        r9.e(r7, r8);
    L20:
        if ((r3 instanceof y) == false) goto L83;
        y r10 = (y) r3;
        String r11 = r5.getIdString();
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "userId");
        if (((ArrayList) r10.y).contains(r11) == true) goto L83;
        SeatAnimEngineWrapper r12 = this.j;
        if (r12 == null) goto L78;
        String r13 = r5.getIdString();
        int r14 = p.a;
        ILinkPlayerInfoBridge r15 = r2.k.a;
        Intrinsics.checkNotNullParameter(r15, "guestInfo");
        IBaseUser r16 = r15.getUser();
        Intrinsics.checkNotNull(r16);
        String r17 = r16.getIdString();
        int r18 = r15.getApplyType();
        IBaseUser r110 = r15.getUser();
        if (r110 == null) goto L28;
        String r111 = r110.getRealNickName();
    L29:
        IBaseUser r112 = r15.getUser();
        if (r112 == null) goto L32;
        py.k r113 = r112.getAvatarThumbKt();
    L33:
        int r21 = r15.getApplyType();
        LinkApplyType r114 = LinkApplyType.MATCH;
        MultiLinkGuestViewBinder.a r115 = r2;
        if (r21 == r114.getValue()) goto L36;
    L38:
        IMatchEffect r22 = r15.getMatchEffect();
    L39:
        com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.i r116 = new com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.i(r17, new com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.j(r18, r111, r113, r22));
        SeatAnimationView r23 = this.f;
        if (r23 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("animationView");
    L42:
        Intrinsics.checkNotNullParameter(r13, "userId");
        Intrinsics.checkNotNullParameter(r116, "event");
        SeatAnimManager r24 = r12.a;
        if (r24 == null) goto L79;
        Intrinsics.checkNotNullParameter(r13, "userId");
        Intrinsics.checkNotNullParameter(r116, "event");
        com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.j r25 = r116.b;
        if (r25 != null) goto L47;
    L50:
        za r26 = null;
        r116.b = null;
        if (r23 == null) goto L55;
        LinkSucAnimationView.a r27 = r23.getLinkSucAnimCallback();
        if (r27 == null) goto L60;
        r27.h();
    L60:
        com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.j r28 = r116.b;
        if (r28 != null) goto L63;
    L73:
        if (r23 == null) goto L75;
        Intrinsics.checkNotNullParameter(r116, "event");
        r23.post(new com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.i(r23, r116));
    L80:
        String r29 = r5.getIdString();
        Intrinsics.checkNotNullParameter(r29, "userId");
        y r30 = r10;
        if (((ArrayList) r30.y).contains(r29) == true) goto L84;
        ((ArrayList) r30.y).add(r29);
    L84:
        SeatAnimEngineWrapper r31 = this.j;
        if (r31 == null) goto L94;
        ch0.c r32 = r115.p;
        if (r32 == null) goto L89;
        za r33 = r32.a;
    L90:
        SeatAnimManager r34 = r31.a;
        if (r34 == null) goto L95;
        r34.d(r33);
        return;
    L95:
        return;
    L89:
        r33 = r26;
        goto L90
    L94:
        return;
    L75:
        Map<String, SeatAnimationView> r35 = r24.a;
        LinkedHashMap r36 = (LinkedHashMap) r35;
        SeatAnimationView r37 = (SeatAnimationView) r36.get(r13.toString());
        if (r37 == null) goto L80;
        Intrinsics.checkNotNullParameter(r116, "event");
        r37.post(new com.bytedance.android.live.liveinteract.chatroom.chatroom.ui.i(r37, r116));
        goto L80
    L63:
        if (r28.d != null) goto L73;
        if (r23 == null) goto L68;
        LinkSucAnimationView.a r38 = r23.getLinkSucAnimCallback();
        if (r38 == null) goto L73;
        r38.h();
        goto L73
    L68:
        Map<String, SeatAnimationView> r39 = r24.a;
        LinkedHashMap r40 = (LinkedHashMap) r39;
        SeatAnimationView r41 = (SeatAnimationView) r40.get(r116.a.toString());
        if (r41 == null) goto L73;
        LinkSucAnimationView.a r42 = r41.getLinkSucAnimCallback();
        if (r42 == null) goto L73;
        r42.h();
        goto L73
    L55:
        Map<String, SeatAnimationView> r43 = r24.a;
        LinkedHashMap r44 = (LinkedHashMap) r43;
        SeatAnimationView r45 = (SeatAnimationView) r44.get(r116.a.toString());
        if (r45 == null) goto L60;
        LinkSucAnimationView.a r46 = r45.getLinkSucAnimCallback();
        if (r46 == null) goto L60;
        r46.h();
        goto L60
    L47:
        if (r25.a != r114.getValue()) goto L50;
        r26 = null;
    L79:
        r26 = null;
        goto L80
    L36:
        if (r15.getMatchEffect() != null) goto L38;
        r22 = (IMatchEffect) f.c(IMatchEffect.class);
        py.k r47 = qy.a.c();
        ArrayList r48 = new ArrayList();
        r48.add("https://lf1-webcastcdn-tos.huoshanstatic.com/obj/live-android/live_interact_fast_match_link_enter_guide.webp");
        r47.setUrls(r48);
        r22.setMatchEffect(r47);
        goto L39
    L32:
        r113 = null;
        goto L33
    L28:
        r111 = null;
        goto L29
    L78:
        r115 = r2;
        r10 = r10;
    L83:
        r115 = r2;
        r26 = null;
        goto L84
    }

    @Override // jg0.f
    public /* bridge */ /* synthetic */ void k(Object r1, int r2, Bundle r3) {
        u((MultiLinkGuestViewBinder.a) r1, r2, r3);
    }

    public void u(MultiLinkGuestViewBinder.a r4, int r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "itemData");
        Intrinsics.checkNotNullParameter(r6, "payload");
        Iterator<String> r7 = r6.keySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L35;
        String r0 = r7.next();
        if (r0 == null) goto L4;
        int r1 = r0.hashCode();
        if (r1 != (-715388833)) goto L11;
        if (r0.equals("payload_key_is_c_position_update") == false) goto L4;
    L31:
        SeatAnimationView r2 = this.f;
        if (r2 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("animationView");
    L34:
        r2.post(new d(this, r5));
        goto L4
    L11:
        if (r1 != (-703589172)) goto L13;
        if (r0.equals("payload_key_user_position") == false) goto L4;
    L13:
        if (r1 != 577182853) goto L4;
        if (r0.equals("payload_key_ktv_business_update") == false) goto L4;
        SeatAnimEngineWrapper r3 = this.j;
        if (r3 == null) goto L4;
        ch0.c r8 = r4.p;
        if (r8 == null) goto L22;
        za r9 = r8.a;
    L23:
        SeatAnimManager r10 = r3.a;
        if (r10 == null) goto L4;
        r10.d(r9);
        goto L4
    L22:
        r9 = null;
        goto L23
    }

    public b(hg0.a r2, int r3, SeatAnimEngineWrapper r4, MicSeatScene r5, xg0.a r6) {
        Intrinsics.checkNotNullParameter(r5, "scene");
        super(r5, r6);
        this.h = r2;
        this.i = r3;
        this.j = r4;
        this.k = null;
    }
}
