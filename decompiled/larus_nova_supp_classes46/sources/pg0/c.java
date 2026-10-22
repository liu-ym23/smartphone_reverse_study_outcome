package pg0;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.RequestSongMicSeatView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong.l;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.MultiLinkCommonGuestMicSeatBasicLayer;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.g;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.pre.VerticalNitaInflate;
import com.bytedance.android.livesdk.utils.g0;
import com.bytedance.android.livesdkapi.depend.message.IMicrophoneItem;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.UIUtils;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends e {
    public View k;
    public FrameLayout l;
    public final l m;
    public final g n;

    @Override // jg0.c
    public final int o() {
        return 2131566603;
    }

    @Override // jg0.c, jg0.f
    public final void onDetach() {
        RequestSongMicSeatView r0 = this.m.a;
        if (r0 == null) goto L6;
        r0.n();
        return;
    }

    @Override // jg0.c
    public final String p() {
        return VerticalNitaInflate.Tag.MultiLinkDynamicFloatWindowFirstUserStatusLayer.name();
    }

    @Override // pg0.e, jg0.c, jg0.f
    public final void a(Context r11) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super.a(r11);
        this.k = this.n.m(2131372617);
        View r0 = this.n.m(2131372012);
        String r2 = null;
        if ((r0 instanceof FrameLayout) == true) goto L5;
        r0 = null;
    L5:
        this.l = (FrameLayout) r0;
        l r3 = this.m;
        MicSeatScene r5 = this.b;
        int r6 = n();
        MultiLinkGuestViewBinder.a r1 = this.d;
        if (r1 == null) goto L14;
        ch0.e r4 = r1.k;
        if (r4 == null) goto L14;
        ILinkPlayerInfoBridge r7 = r4.a;
        if (r7 == null) goto L14;
        IBaseUser r8 = r7.getUser();
        if (r8 == null) goto L14;
        String r9 = r8.getIdString();
    L15:
        Room r10 = m.i().getCurrentRoom();
        if (r10 == null) goto L18;
        r2 = r10.getOwnerUserIdString();
    L18:
        r3.a(r11, r5, r6, Intrinsics.areEqual(r9, r2), this.f, this.c);
        B(this.l, this.f);
        B(this.l, this.g);
        View r12 = this.m.a;
        if (r12 == null) goto L22;
        B(this.l, r12);
        return;
    L22:
        return;
    L14:
        r9 = null;
        goto L15
    }

    @Override // pg0.e
    public final void w(long r9) {
        MultiLinkGuestViewBinder.a r0 = this.d;
        if (r0 == null) goto L44;
        ch0.e r1 = r0.k;
        if (r1 == null) goto L45;
        ILinkPlayerInfoBridge r2 = r1.a;
        if (r2 != null) goto L10;
        return;
    L10:
        if (s() == false) goto L12;
    L36:
        View r10 = this.i;
        if (r10 == null) goto L46;
        r10.setVisibility(8);
        return;
    L46:
        return;
    L12:
        if (n() != 0) goto L36;
        long r3 = r2.getExpectLeaveTime();
        long r4 = r2.getJoinChannelTime();
        if (r3 != 0) goto L17;
    L32:
        View r11 = this.i;
        if (r11 == null) goto L43;
        r11.setVisibility(8);
        return;
    L43:
        return;
    L17:
        if (n() != 0) goto L32;
        long r5 = (r3 - r4) * ((long) 1000);
        if (r9 > 0) goto L24;
        View r12 = this.i;
        if (r12 == null) goto L40;
        r12.setVisibility(8);
        return;
    L40:
        return;
    L24:
        View r6 = this.k;
        if (r6 == null) goto L27;
        int r7 = r6.getWidth() - s1.f(20.0f);
    L28:
        UIUtils.updateLayout(this.i, (int) ((((long) r7) * r9) / r5), -3);
        View r13 = this.i;
        if (r13 == null) goto L42;
        r13.setVisibility(0);
        return;
    L42:
        return;
    L27:
        r7 = 0;
        goto L28
    L45:
        return;
    }

    public final void B(ViewGroup r3, View r4) {
        if (r4 == null) goto L4;
        ViewParent r0 = r4.getParent();
    L6:
        if ((r0 instanceof ViewGroup) == false) goto L8;
        ((ViewGroup) r0).removeView(r4);
    L8:
        if (r3 == null) goto L11;
        r3.addView(r4);
        return;
    L11:
        return;
    L4:
        r0 = null;
        goto L6
    }

    @Override // pg0.e, jg0.f
    public final /* bridge */ /* synthetic */ void d(Object r1, int r2) {
        t((MultiLinkGuestViewBinder.a) r1, r2);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // pg0.e
    public final void t(MultiLinkGuestViewBinder.a r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "itemData");
        super.t(r6, r7);
        HashMap r0 = g0.a;
        Object r1 = null;
        g0.c r2 = g0.b.a("get_enlarge_userbar_translation", null);
        if (r2 == null) goto L20;
        float r3 = 0.0f;
        r2.a = Float.valueOf(0.0f);
        Boolean r4 = Boolean.valueOf(r2.b());
        if (r4.booleanValue() == true) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L20;
        r4.booleanValue();
        AppCompatTextView r5 = this.g;
        if (r5 == null) goto L20;
        Object r8 = r2.a;
        if ((r8 instanceof Float) == false) goto L15;
        r1 = r8;
    L15:
        Float r9 = (Float) r1;
        if (r9 == null) goto L18;
        r3 = r9.floatValue();
    L18:
        r5.setTranslationY(r3);
    L20:
        if (r6.d != 0) goto L28;
        l r10 = this.m;
        ILinkPlayerInfoBridge r11 = r6.k.a;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "guestInfo");
        RequestSongMicSeatView r12 = r10.a;
        if (r12 == null) goto L24;
        r12.p();
    L24:
        RequestSongMicSeatView r13 = r10.a;
        if (r13 == null) goto L29;
        r13.l(r11, r7);
        return;
    L29:
        return;
    }

    public c(MultiLinkCommonGuestMicSeatBasicLayer r2, MicSeatScene r3, xg0.a r4) {
        Intrinsics.checkNotNullParameter(r2, "basicLayer");
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, "linkSeatAbilityProvider");
        super(r3, r4);
        this.n = r2;
        this.m = new l();
    }

    @Override // pg0.e, jg0.f
    public final /* bridge */ /* synthetic */ void k(Object r1, int r2, Bundle r3) {
        u((MultiLinkGuestViewBinder.a) r1, r2, r3);
    }

    @Override // pg0.e
    public final void u(MultiLinkGuestViewBinder.a r6, int r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r6, "itemData");
        Intrinsics.checkNotNullParameter(r8, "payload");
        super.u(r6, r7, r8);
        l r9 = this.m;
        ILinkPlayerInfoBridge r1 = r6.k.a;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r1, "guestInfo");
        Intrinsics.checkNotNullParameter(r8, "payload");
        RequestSongMicSeatView r10 = r9.a;
        if (r10 == null) goto L5;
        r10.setMCurPositionInfo(r1);
    L5:
        Iterator<String> r11 = r8.keySet().iterator();
    L7:
        if (r11.hasNext() == false) goto L81;
        String r12 = r11.next();
        if (r12 == null) goto L7;
        int r0 = r12.hashCode();
        Object r2 = null;
        if (r0 != (-1236292194)) goto L14;
        if (r12.equals("payload_key_interact_song_golden_mic_info_update") == false) goto L7;
        Object r13 = r6.k.d.get("EXT_KEY_UPDATE_INTERACT_SONG_GOLDEN_MIC_INFO");
        if ((r13 instanceof pf0.a) == false) goto L67;
        r2 = r13;
    L67:
        pf0.a r3 = (pf0.a) r2;
        if (r3 == null) goto L7;
        MultiLinkGuestViewBinder.a r14 = this.d;
        if (r14 == null) goto L78;
        ch0.e r15 = r14.k;
        if (r15 == null) goto L78;
        ILinkPlayerInfoBridge r16 = r15.a;
        if (r16 == null) goto L78;
        RequestSongMicSeatView r4 = this.m.a;
        if (r4 == null) goto L78;
        r4.setMCurPositionInfo(r16);
    L78:
        Intrinsics.checkNotNullParameter(r3, "info");
        l r5 = this.m;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r3, "info");
        RequestSongMicSeatView r17 = r5.a;
        if (r17 == null) goto L7;
        r17.z(r3);
        goto L7
    L14:
        if (r0 != 236305799) goto L16;
        if (r12.equals("payload_key_feedview_interact_song_golden_mic_online_state") == false) goto L7;
        Object r18 = r6.k.d.get("EXT_KEY_UPDATE_FEED_VIEW_INTERACT_SONG_UPDATE");
        if ((r18 instanceof IMicrophoneItem) == true) goto L43;
        r18 = null;
    L43:
        IMicrophoneItem r19 = (IMicrophoneItem) r18;
        if (r19 == null) goto L7;
        IBaseUser r20 = r6.k.a.getUser();
        if (r20 == null) goto L48;
        String r21 = r20.getIdString();
    L49:
        IRoom r22 = r6.h;
        if (r22 == null) goto L52;
        r2 = r22.getAnchorId();
    L52:
        boolean r23 = Intrinsics.areEqual(r21, r2);
        l r24 = this.m;
        int r25 = r19.getMicroPhoneNum();
        ILinkPlayerInfoBridge r26 = r6.k.a;
        wg0.a r27 = r6.n;
        if (r27 == null) goto L57;
        boolean r28 = true;
        if (r27.a != true) goto L57;
    L58:
        RequestSongMicSeatView r29 = r24.a;
        if (r29 == null) goto L7;
        r29.t(r25, r26, r23, r28);
    L57:
        r28 = false;
        goto L58
    L48:
        r21 = null;
        goto L49
    L16:
        if (r0 != 1416202744) goto L7;
        if (r12.equals("payload_key_interact_song_golden_mic_display_state") == false) goto L7;
        Object r30 = r6.k.d.get("EXT_KEY_UPDATE_INTERACT_SONG_SHOW_GOLDEN_MIC");
        if ((r30 instanceof Boolean) == false) goto L24;
        r2 = r30;
    L24:
        Boolean r31 = (Boolean) r2;
        if (r31 == null) goto L7;
        boolean r32 = r31.booleanValue();
        MultiLinkGuestViewBinder.a r33 = this.d;
        if (r33 == null) goto L35;
        ch0.e r34 = r33.k;
        if (r34 == null) goto L35;
        ILinkPlayerInfoBridge r35 = r34.a;
        if (r35 == null) goto L35;
        RequestSongMicSeatView r36 = this.m.a;
        if (r36 == null) goto L35;
        r36.setMCurPositionInfo(r35);
    L35:
        RequestSongMicSeatView r37 = this.m.a;
        if (r37 == null) goto L7;
        r37.y(r32);
        goto L7
    }
}
