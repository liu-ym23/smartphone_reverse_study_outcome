package com.bytedance.android.live.liveinteract.plantform.datamerge;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkAudioFirstUserViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkAudioFirstUserVirtualAvatarViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkFirstUserViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkLastEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkPCLandscapeViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.s0;
import com.bytedance.android.live.liveinteract.utils.MultiLinkLoadWidgetUtils;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.interact.model.e0;
import com.bytedance.android.livesdk.config.bb0;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFrequencyOptConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class a {
    public boolean a;
    public final BehaviorSubject<List<tf0.e>> b;
    public final CompositeDisposable c;
    public IRoom d;
    public final DataCenter e;
    public final boolean f;
    public com.bytedance.android.live.liveinteract.plantform.commonwindow.m g;
    public k h;
    public final int i;

    public void b() {
    }

    public abstract MultiLinkNormalEmptyViewBinder.a g(int r1);

    public abstract MultiLinkLastEmptyViewBinder.a h(int r1);

    public void l(List<tf0.e> r1, List<ch0.e> r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r1, "windowList");
        Intrinsics.checkNotNullParameter(r2, "linkedUserMergeDataList");
        Intrinsics.checkNotNullParameter(r4, "anchorId");
    }

    public abstract void u();

    public void d() {
        this.c.clear();
        this.a = false;
    }

    public final boolean e() {
        if (this.i == 0) goto L5;
    L15:
        InteractiveSongContext.a r0 = InteractiveSongContext.Companion;
        if (r0.f() == false) goto L25;
        InteractiveSongContext r1 = r0.getContext();
        if (r1 == null) goto L26;
        com.bytedance.live.datacontext.m<Boolean> r2 = r1.getShowOrderSingStage();
        if (r2 != null) goto L22;
        return false;
    L22:
        if (((Boolean) r2.getValue()).booleanValue() != true) goto L28;
        return true;
    L28:
        return false;
    L26:
        return false;
    L25:
        return false;
    L5:
        if (MultiLinkLoadWidgetUtils.g() == false) goto L15;
        MiddlewareRoomContext r3 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, this.e, 0, 2);
        if (r3 == null) goto L11;
        com.bytedance.live.datacontext.n r4 = r3.isRoomVisible();
        if (r4 == null) goto L11;
        Boolean r5 = (Boolean) r4.getValue();
    L13:
        if (Intrinsics.areEqual(r5, Boolean.FALSE) == false) goto L15;
        return false;
    L11:
        r5 = null;
        goto L13
    }

    public final boolean j() {
        if (this.i == 0) goto L6;
        return true;
    L6:
        if (MultiLinkLoadWidgetUtils.g() == false) goto L17;
        MiddlewareRoomContext r0 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, this.e, 0, 2);
        if (r0 == null) goto L12;
        com.bytedance.live.datacontext.n r1 = r0.isRoomVisible();
        if (r1 == null) goto L12;
        Boolean r2 = (Boolean) r1.getValue();
    L14:
        if (Intrinsics.areEqual(r2, Boolean.FALSE) == false) goto L17;
        return true;
    L12:
        r2 = null;
    L17:
        if (this.f == true) goto L27;
        rj0.l.n2.getClass();
        rj0.l r3 = rj0.l.a.a();
        if (r3 != null) goto L21;
    L22:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r4 = IVoiceChatGuestService.a.a();
        if (r4 != null) goto L25;
        return true;
    L25:
        if (r4.isEngineOn() == true) goto L27;
        return true;
    L21:
        if (r3.isEngineOn() != true) goto L22;
    L27:
        return false;
    }

    public final boolean k() {
        if (this.i == 0) goto L6;
        return false;
    L6:
        if (MultiLinkLoadWidgetUtils.g() == false) goto L16;
        MiddlewareRoomContext r0 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, this.e, 0, 2);
        if (r0 == null) goto L12;
        com.bytedance.live.datacontext.n r1 = r0.isRoomVisible();
        if (r1 == null) goto L12;
        Boolean r2 = (Boolean) r1.getValue();
    L14:
        if (Intrinsics.areEqual(r2, Boolean.FALSE) == false) goto L16;
        return false;
    L12:
        r2 = null;
    L16:
        Integer r3 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r3 != null) goto L20;
        return false;
    L20:
        if (2 != r3.intValue()) goto L23;
        return true;
    L23:
        return false;
    }

    public static int c(List r4) {
        Intrinsics.checkNotNullParameter(r4, "windowList");
        Iterator r5 = r4.iterator();
        int r0 = 0;
    L4:
        if (r5.hasNext() == false) goto L18;
        Object r1 = r5.next();
        int r2 = r0 + 1;
        if (r0 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        tf0.e r3 = (tf0.e) r1;
        if ((r3 instanceof MultiLinkGuestViewBinder.a) == true) goto L11;
        tf0.e r6 = null;
    L13:
        if (((MultiLinkGuestViewBinder.a) r6) == null) goto L17;
        if (((MultiLinkGuestViewBinder.a) r3).k.a.isEnlarged() == false) goto L17;
        return r0;
    L17:
        r0 = r2;
        goto L4
    L11:
        r6 = r3;
        goto L13
    L18:
        return -1;
    }

    public final void a(List<tf0.e> r9) {
        if (this.g.getUiLayout() != 109) goto L5;
    L8:
        int r0 = 8;
    L10:
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L19;
        MiddlewareRoomContext r1 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, this.e, 0, 2);
        if (r1 == null) goto L16;
        com.bytedance.live.datacontext.n r2 = r1.isRoomVisible();
        if (r2 == null) goto L16;
        Boolean r3 = (Boolean) r2.getValue();
    L18:
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L19;
    L27:
        boolean r4 = true;
    L29:
        ArrayList r10 = (ArrayList) r9;
        int r5 = r10.size();
        if (r4 == false) goto L41;
        if (r5 == 1) goto L33;
    L34:
        if (2 > r5) goto L52;
        if (r0 < r5) goto L49;
    L37:
        if (r5 != 1) goto L39;
        MultiLinkNormalEmptyViewBinder.a r6 = g(r5);
    L40:
        r10.add(r6);
        return;
    L39:
        r6 = h(r5);
        goto L40
    L49:
        return;
    L52:
        return;
    L33:
        if (((Boolean) vm2.d.a4.getValue(null, vm2.d.a[258(0x102, float:3.62E-43)])).booleanValue() == true) goto L37;
    L41:
        if (1 > r5) goto L53;
        if (r0 < r5) goto L51;
        if (r5 != 1) goto L46;
        MultiLinkNormalEmptyViewBinder.a r7 = g(r5);
    L47:
        r10.add(r7);
        return;
    L46:
        r7 = h(r5);
        goto L47
    L51:
        return;
    L53:
        return;
    L16:
        r3 = null;
    L19:
        IRoom r8 = this.d;
        if (r8 == null) goto L24;
        z5 r11 = r8.getLinkerDetail();
        if (r11 == null) goto L24;
        String r12 = r11.getFunctionType2();
    L26:
        if (Intrinsics.areEqual(r12, "new_audience") == true) goto L27;
        r4 = false;
    L24:
        r12 = null;
        goto L26
    L5:
        if (this.g.getUiLayout() == 111) goto L8;
        r0 = 6;
        goto L10
    }

    public final int f(String r6) {
        Intrinsics.checkNotNullParameter(r6, "userId");
        List r0 = (List) this.b.getValue();
        int r1 = -1;
        if (r0 == null) goto L16;
        Iterator r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L16;
        tf0.e r3 = (tf0.e) r2.next();
        if ((r3 instanceof MultiLinkGuestViewBinder.a) == false) goto L6;
        IBaseUser r4 = ((MultiLinkGuestViewBinder.a) r3).k.a.getUser();
        if (r4 == null) goto L12;
        String r5 = r4.getIdString();
    L14:
        if (Intrinsics.areEqual(r5, r6) == false) goto L6;
        r1 = r0.indexOf(r3);
        goto L6
    L12:
        r5 = null;
    L16:
        return r1;
    }

    public final void p(List<tf0.e> r9) {
        Intrinsics.checkNotNullParameter(r9, "windowList");
        int r0 = this.g.getUiLayout();
        if (r0 == 110) goto L6;
        if (r0 == 109) goto L6;
        if (r0 == 111) goto L6;
    L7:
        Object r7 = null;
        if (r0 == 112) goto L10;
        if (r0 == 110) goto L32;
        if (r0 == 109) goto L32;
        if (r0 == 111) goto L32;
        return;
    L32:
        if ((!r9.isEmpty()) == false) goto L51;
        Object r1 = ListProtector.get(r9, 0);
        if ((r1 instanceof MultiLinkGuestViewBinder.a) == false) goto L38;
        r7 = r1;
    L38:
        if (((MultiLinkGuestViewBinder.a) r7) == null) goto L52;
        Object r2 = ListProtector.remove(r9, 0);
        if (r2 == null) goto L43;
        MultiLinkGuestViewBinder.a r3 = (MultiLinkGuestViewBinder.a) r2;
        ListProtector.add(r9, 0, new MultiLinkFirstUserViewBinder.a(r3.k, r3.l));
        return;
    L43:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder.GuestItemData");
    L52:
        return;
    L51:
        return;
    L10:
        if ((!r9.isEmpty()) == false) goto L44;
        int r4 = c(r9);
        if (r4 >= 0) goto L14;
        return;
    L14:
        if (r4 >= ((ArrayList) r9).size()) goto L46;
        Object r5 = ListProtector.get(r9, r4);
        if ((r5 instanceof MultiLinkGuestViewBinder.a) == false) goto L19;
        r7 = r5;
    L19:
        MultiLinkGuestViewBinder.a r8 = (MultiLinkGuestViewBinder.a) r7;
        if (r8 != null) goto L22;
        return;
    L22:
        if (r8.k.a.isEnlarged() == false) goto L48;
        Object r6 = ListProtector.remove(r9, r4);
        if (r6 == null) goto L27;
        MultiLinkGuestViewBinder.a r10 = (MultiLinkGuestViewBinder.a) r6;
        ListProtector.add(r9, 0, new MultiLinkFirstUserViewBinder.a(r10.k, r10.l));
        return;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder.GuestItemData");
    L48:
        return;
    L46:
        return;
    L44:
        return;
    L6:
        q(r9, 0);
        a(r9);
        goto L7
    }

    public static void q(List r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "windowList");
        Iterator r0 = r3.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L8;
        if ((((tf0.e) r0.next()) instanceof MultiLinkNormalEmptyViewBinder.a) == false) goto L4;
        r1 = r1 + 1;
        goto L4
    L8:
        Iterator r5 = CollectionsKt.asReversedMutable(r3).iterator();
    L10:
        if (r5.hasNext() == false) goto L15;
        if ((((tf0.e) r5.next()) instanceof MultiLinkNormalEmptyViewBinder.a) == false) goto L10;
        if (r1 <= r4) goto L10;
        r5.remove();
        r1 = r1 - 1;
        goto L10
    }

    public final void n(String r10, List<tf0.e> r11) {
        Intrinsics.checkNotNullParameter(r10, "anchorId");
        Intrinsics.checkNotNullParameter(r11, "windowList");
        int r0 = this.g.getUiLayout();
        if (r0 == 7) goto L6;
        if (r0 == 25) goto L6;
        if (r0 == 29) goto L6;
    L7:
        Object r7 = null;
        if (r0 == 6) goto L47;
        if (r0 == 9) goto L47;
        if (r0 == 1) goto L14;
        if (r0 == 7) goto L34;
        if (r0 == 25) goto L34;
        if (r0 == 29) goto L34;
        return;
    L34:
        if ((!r11.isEmpty()) == false) goto L70;
        Object r12 = ListProtector.get(r11, 0);
        if ((r12 instanceof MultiLinkGuestViewBinder.a) == false) goto L40;
        r7 = r12;
    L40:
        if (((MultiLinkGuestViewBinder.a) r7) == null) goto L71;
        Object r13 = ListProtector.remove(r11, 0);
        if (r13 == null) goto L45;
        MultiLinkGuestViewBinder.a r14 = (MultiLinkGuestViewBinder.a) r13;
        ListProtector.add(r11, 0, new MultiLinkFirstUserViewBinder.a(r14.k, r14.l));
        return;
    L45:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder.GuestItemData");
    L71:
        return;
    L70:
        return;
    L14:
        if ((!r11.isEmpty()) == false) goto L65;
        Object r1 = ListProtector.get(r11, 0);
        if ((r1 instanceof MultiLinkGuestViewBinder.a) == true) goto L18;
        r1 = null;
    L18:
        MultiLinkGuestViewBinder.a r2 = (MultiLinkGuestViewBinder.a) r1;
        if (r2 == null) goto L66;
        IBaseUser r3 = r2.k.a.getUser();
        if (r3 == null) goto L24;
        r7 = r3.getIdString();
    L24:
        if (Intrinsics.areEqual(r7, r10) == false) goto L67;
        Object r15 = ListProtector.remove(r11, 0);
        if (r15 == null) goto L29;
        MultiLinkGuestViewBinder.a r16 = (MultiLinkGuestViewBinder.a) r15;
        ListProtector.add(r11, 0, new MultiLinkFirstUserViewBinder.a(r16.k, r16.l));
        return;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder.GuestItemData");
    L67:
        return;
    L66:
        return;
    L65:
        return;
    L47:
        if ((!r11.isEmpty()) == false) goto L73;
        int r17 = c(r11);
        if (r17 >= 0) goto L51;
        return;
    L51:
        if (r17 >= ((ArrayList) r11).size()) goto L75;
        Object r4 = ListProtector.get(r11, r17);
        if ((r4 instanceof MultiLinkGuestViewBinder.a) == false) goto L56;
        r7 = r4;
    L56:
        MultiLinkGuestViewBinder.a r8 = (MultiLinkGuestViewBinder.a) r7;
        if (r8 != null) goto L59;
        return;
    L59:
        if (r8.k.a.isEnlarged() == false) goto L77;
        Object r18 = ListProtector.remove(r11, r17);
        if (r18 == null) goto L64;
        MultiLinkGuestViewBinder.a r19 = (MultiLinkGuestViewBinder.a) r18;
        ListProtector.add(r11, 0, new MultiLinkFirstUserViewBinder.a(r19.k, r19.l));
        return;
    L64:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder.GuestItemData");
    L77:
        return;
    L75:
        return;
    L73:
        return;
    L6:
        q(r11, 0);
        a(r11);
        goto L7
    }

    public final void o(String r6, List<tf0.e> r7) {
        Intrinsics.checkNotNullParameter(r6, "anchorId");
        Intrinsics.checkNotNullParameter(r7, "windowList");
        int r0 = c1.a;
        if (c1.a(Integer.valueOf(this.g.m()), Integer.valueOf(this.g.getUiLayout())) == true) goto L6;
        return;
    L6:
        if (r7.isEmpty() == false) goto L8;
        int r2 = 0;
    L16:
        String r4 = null;
        if (((Boolean) vm2.d.b4.getValue(null, vm2.d.a[259(0x103, float:3.63E-43)])).booleanValue() == false) goto L20;
        if (r2 != 1) goto L20;
        q(r7, 1);
    L22:
        if ((!r7.isEmpty()) == false) goto L38;
        Object r1 = ListProtector.get(r7, 0);
        if ((r1 instanceof MultiLinkGuestViewBinder.a) == true) goto L26;
        r1 = null;
    L26:
        MultiLinkGuestViewBinder.a r3 = (MultiLinkGuestViewBinder.a) r1;
        if (r3 == null) goto L46;
        IBaseUser r5 = r3.k.a.getUser();
        if (r5 == null) goto L32;
        r4 = r5.getIdString();
    L32:
        if (Intrinsics.areEqual(r4, r6) == false) goto L47;
        Object r8 = ListProtector.remove(r7, 0);
        if (r8 == null) goto L37;
        ListProtector.add(r7, 0, new MultiLinkPCLandscapeViewBinder.a(((MultiLinkGuestViewBinder.a) r8).k));
        return;
    L37:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder.GuestItemData");
    L47:
        return;
    L46:
        return;
    L38:
        return;
    L20:
        q(r7, 0);
        goto L22
    L8:
        Iterator<T> r9 = r7.iterator();
        r2 = 0;
    L10:
        if (r9.hasNext() == false) goto L16;
        if ((((tf0.e) r9.next()) instanceof MultiLinkGuestViewBinder.a) == false) goto L10;
        r2 = r2 + 1;
        if (r2 >= 0) goto L10;
        CollectionsKt.throwCountOverflow();
        goto L10
    }

    public void v(IVoiceLiveTheme r2, List<tf0.e> r3) {
        Intrinsics.checkNotNullParameter(r3, "windowList");
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        ((tf0.e) r4.next()).c = r2;
        goto L4
    }

    public final void w(k r2, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r3) {
        Intrinsics.checkNotNullParameter(r2, "windowConfig");
        Intrinsics.checkNotNullParameter(r3, "layoutConfig");
        this.h = r2;
        this.g = r3;
        u();
    }

    public static void t(List r5, List r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "windowList");
        Intrinsics.checkNotNullParameter(r6, "linkedUserMergeDataList");
        Iterator r8 = r6.iterator();
    L4:
        if (r8.hasNext() == false) goto L10;
        ch0.e r0 = (ch0.e) r8.next();
        int r1 = r0.a.getUserPosition();
        if (r1 < 0) goto L4;
        if (r7 <= r1) goto L4;
        MultiLinkGuestViewBinder.a r2 = new MultiLinkGuestViewBinder.a(r0, null, 62);
        r2.a = r1;
        ListProtector.set(r5, r1, r2);
        goto L4
    }

    public final void m(String r22, List<tf0.e> r23, ch0.l r24) {
        Intrinsics.checkNotNullParameter(r22, "anchorId");
        Intrinsics.checkNotNullParameter(r23, "windowList");
        Intrinsics.checkNotNullParameter(r24, "voiceAnchorGuideInfo");
        int r4 = this.g.getUiLayout();
        Object r9 = null;
        if (e0.b(r4) == true) goto L65;
        if (r4 == 30) goto L65;
        if (r4 != 26) goto L35;
        if ((!r23.isEmpty()) == false) goto L138;
        Object r1 = ListProtector.get(r23, 0);
        if ((r1 instanceof MultiLinkGuestViewBinder.a) == true) goto L15;
        r1 = null;
    L15:
        if (((MultiLinkGuestViewBinder.a) r1) == null) goto L22;
        Object r2 = ListProtector.remove(r23, 0);
        if (r2 == null) goto L20;
        MultiLinkGuestViewBinder.a r3 = (MultiLinkGuestViewBinder.a) r2;
        MultiLinkAudioFirstUserViewBinder.a r5 = new MultiLinkAudioFirstUserViewBinder.a(r3.k, r3.l, r24);
        r5.b = r3.b;
        ListProtector.add(r23, 0, r5);
        goto L22
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder.GuestItemData");
    L22:
        if (((ArrayList) r23).size() < 2) goto L139;
        Object r6 = ListProtector.get(r23, 1);
        if ((r6 instanceof MultiLinkGuestViewBinder.a) == false) goto L28;
        r9 = r6;
    L28:
        if (((MultiLinkGuestViewBinder.a) r9) == null) goto L140;
        Object r7 = ListProtector.remove(r23, 1);
        if (r7 == null) goto L33;
        MultiLinkGuestViewBinder.a r8 = (MultiLinkGuestViewBinder.a) r7;
        MultiLinkAudioFirstUserViewBinder.a r10 = new MultiLinkAudioFirstUserViewBinder.a(r8.k, r8.l, r24);
        r10.b = r8.b;
        ListProtector.add(r23, 1, r10);
        return;
    L33:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder.GuestItemData");
    L140:
        return;
    L139:
        return;
    L138:
        return;
    L35:
        if (r4 != 28) goto L37;
        boolean r11 = true;
    L38:
        if (r11 == true) goto L40;
        return;
    L40:
        if ((!r23.isEmpty()) == false) goto L50;
        if ((ListProtector.get(r23, 0) instanceof MultiLinkGuestViewBinder.a) == false) goto L50;
        Object r12 = ListProtector.remove(r23, 0);
        if ((r12 instanceof MultiLinkGuestViewBinder.a) == true) goto L46;
        r12 = null;
    L46:
        MultiLinkGuestViewBinder.a r13 = (MultiLinkGuestViewBinder.a) r12;
        if (r13 == null) goto L50;
        MultiLinkAudioFirstUserViewBinder.a r14 = new MultiLinkAudioFirstUserViewBinder.a(r13.k, r13.l, r24);
        r14.b = r13.b;
        ListProtector.add(r23, 0, r14);
    L50:
        if (((Boolean) vm2.d.X1.getValue(null, vm2.d.a[151(0x97, float:2.12E-43)])).booleanValue() == true) goto L52;
        return;
    L52:
        if ((!r23.isEmpty()) == false) goto L144;
        Object r15 = ListProtector.get(r23, 0);
        if ((r15 instanceof MultiLinkNormalEmptyViewBinder.a) == false) goto L58;
        r9 = r15;
    L58:
        if (((MultiLinkNormalEmptyViewBinder.a) r9) == null) goto L145;
        Object r16 = ListProtector.remove(r23, 0);
        if (r16 == null) goto L63;
        MultiLinkNormalEmptyViewBinder.a r17 = (MultiLinkNormalEmptyViewBinder.a) r16;
        com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.c.a r18 = new com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.c.a(r17.b(), r17.c(), r17.a(), r17.g(), r17.e(), r17.h(), r17.f(), r17.d(), r17.i());
        r18.b = r17.b;
        ListProtector.add(r23, 0, r18);
        return;
    L63:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder.EmptyItemData");
    L145:
        return;
    L144:
        return;
    L37:
        r11 = false;
    L65:
        if ((!r23.isEmpty()) == false) goto L147;
        int r19 = c(r23);
        if (r19 >= 0) goto L69;
    L101:
        Object r20 = ListProtector.get(r23, 0);
        if ((r20 instanceof MultiLinkGuestViewBinder.a) == true) goto L104;
        r20 = null;
    L104:
        MultiLinkGuestViewBinder.a r21 = (MultiLinkGuestViewBinder.a) r20;
        if (r21 == null) goto L124;
        IBaseUser r25 = r21.k.a.getUser();
        if (r25 == null) goto L109;
        String r26 = r25.getIdString();
    L111:
        if (Intrinsics.areEqual(r26, r22) == false) goto L124;
        Object r27 = ListProtector.remove(r23, 0);
        if (r27 == null) goto L122;
        MultiLinkGuestViewBinder.a r28 = (MultiLinkGuestViewBinder.a) r27;
        if (s0.g(this.d) == false) goto L120;
        if (r4 != 27) goto L120;
        if (e() == false) goto L120;
        MultiLinkAudioFirstUserVirtualAvatarViewBinder.a r29 = new MultiLinkAudioFirstUserVirtualAvatarViewBinder.a(r28.k, r28.l, r24);
        r29.b = r28.b;
        ListProtector.add(r23, 0, r29);
    L120:
        MultiLinkAudioFirstUserViewBinder.a r30 = new MultiLinkAudioFirstUserViewBinder.a(r28.k, r28.l, r24);
        r30.b = r28.b;
        ListProtector.add(r23, 0, r30);
        goto L124
    L122:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder.GuestItemData");
    L109:
        r26 = null;
    L124:
        if (((Boolean) vm2.d.W1.getValue(null, vm2.d.a[150(0x96, float:2.1E-43)])).booleanValue() == true) goto L126;
        return;
    L126:
        if (this.g.getUiLayout() != 21) goto L149;
        Object r31 = ListProtector.get(r23, 0);
        if ((r31 instanceof MultiLinkNormalEmptyViewBinder.a) == false) goto L132;
        r9 = r31;
    L132:
        if (((MultiLinkNormalEmptyViewBinder.a) r9) == null) goto L150;
        Object r32 = ListProtector.remove(r23, 0);
        if (r32 == null) goto L137;
        MultiLinkNormalEmptyViewBinder.a r33 = (MultiLinkNormalEmptyViewBinder.a) r32;
        ListProtector.add(r23, 0, new com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.b.a(r33.b(), r33.c(), r33.a(), r33.g(), r33.e(), r33.h(), r33.f(), r33.d(), r33.i()));
        return;
    L137:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder.EmptyItemData");
    L150:
        return;
    L149:
        return;
    L69:
        if (r19 >= ((ArrayList) r23).size()) goto L101;
        Object r34 = ListProtector.get(r23, r19);
        if ((r34 instanceof MultiLinkGuestViewBinder.a) == true) goto L73;
        r34 = null;
    L73:
        MultiLinkGuestViewBinder.a r35 = (MultiLinkGuestViewBinder.a) r34;
        if (r35 == null) goto L124;
        if (r35.k.a.isEnlarged() == false) goto L124;
        if (s0.g(this.d) == false) goto L96;
        if (r4 != 27) goto L96;
        if (e() == false) goto L96;
        tf0.e r36 = (tf0.e) ListProtector.get(r23, r19);
        if (r19 == 0) goto L85;
    L92:
        if (r36 == null) goto L95;
        MultiLinkGuestViewBinder.a r37 = (MultiLinkGuestViewBinder.a) r36;
        MultiLinkAudioFirstUserVirtualAvatarViewBinder.a r38 = new MultiLinkAudioFirstUserVirtualAvatarViewBinder.a(r37.k, r37.l, r24);
        r38.b = r36.b;
        ListProtector.remove(r23, r19);
        ListProtector.add(r23, 0, r38);
        goto L124
    L95:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder.GuestItemData");
    L85:
        if ((ListProtector.get(r23, r19) instanceof MultiLinkAudioFirstUserVirtualAvatarViewBinder.a) == false) goto L92;
        if ((r36 instanceof MultiLinkAudioFirstUserVirtualAvatarViewBinder.a) == true) goto L89;
        r36 = null;
    L89:
        MultiLinkAudioFirstUserVirtualAvatarViewBinder.a r39 = (MultiLinkAudioFirstUserVirtualAvatarViewBinder.a) r36;
        if (r39 == null) goto L124;
        Intrinsics.checkNotNullParameter(r24, "<set-?>");
        r39.s = r24;
    L96:
        Object r40 = ListProtector.remove(r23, r19);
        if (r40 == null) goto L100;
        MultiLinkGuestViewBinder.a r41 = (MultiLinkGuestViewBinder.a) r40;
        MultiLinkAudioFirstUserViewBinder.a r42 = new MultiLinkAudioFirstUserViewBinder.a(r41.k, r41.l, r24);
        r42.b = r41.b;
        ListProtector.add(r23, 0, r42);
        goto L124
    L100:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder.GuestItemData");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void r(List<tf0.e> r8, List<ch0.e> r9, int r10) {
        Iterator<ch0.e> r11 = r9.iterator();     // Catch: Throwable -> L28
        ILinkPlayerInfoBridge r1 = null;
        Object[] r2 = 0;
        Object[] r3 = 0;
        MultiLinkGuestViewBinder.a r4 = null;
    L5:
        if (r11.hasNext() == false) goto L22;
        ch0.e r5 = r11.next();     // Catch: Throwable -> L28
        int r6 = r5.a.getUserPosition();     // Catch: Throwable -> L28
        if (r6 < 0) goto L5;
        if (r10 <= r6) goto L5;
        IBaseUser r7 = r5.a.getUser();     // Catch: Throwable -> L28
        if (r7 == null) goto L13;
        String r12 = r7.getIdString();     // Catch: Throwable -> L28
    L14:
        IRoom r13 = this.d;     // Catch: Throwable -> L28
        if (r13 == null) goto L17;
        String r14 = r13.getOwnerUserIdString();     // Catch: Throwable -> L28
    L18:
        boolean r15 = Intrinsics.areEqual(r12, r14);     // Catch: Throwable -> L28
        int r16 = 62;
        if (r15 == true) goto L20;
        MultiLinkGuestViewBinder.a r17 = new MultiLinkGuestViewBinder.a(r5, r3 == true ? 1 : 0, r16);     // Catch: Throwable -> L28
        r17.a = 1;     // Catch: Throwable -> L28
        ListProtector.set(r8, r6, r17);     // Catch: Throwable -> L28
        goto L5
    L20:
        r4 = new MultiLinkGuestViewBinder.a(r5, r2 == true ? 1 : 0, r16);     // Catch: Throwable -> L28
        goto L5
    L17:
        r14 = null;
        goto L18
    L13:
        r12 = null;
        goto L14
    L22:
        if (r4 == null) goto L44;
        r4.a = 0;     // Catch: Throwable -> L28
        ListProtector.add(r8, 0, r4);     // Catch: Throwable -> L28
        ch0.e r18 = r4.k;     // Catch: Throwable -> L28
        if (r18 == null) goto L26;
        r1 = r18.a;     // Catch: Throwable -> L28
    L26:
        ALogger.i("WindowListHelper", "[PCLandscape] add anchorGuestItem, linkPlayerInfo=" + r1);     // Catch: Throwable -> L28
        return;
    L44:
        return;
    L28:
        th = move-exception;
        ALogger.e("WindowListHelper", "sortBySeiPositionForGuestOnVideoChorusWindow exception: " + th.getMessage());
    }

    public final void s(List<tf0.e> r10, List<ch0.e> r11, int r12) {
        Iterator<ch0.e> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L40;
        ch0.e r0 = r13.next();
        boolean r1 = r0.a.isLinkRoomUser();
        int r2 = r0.a.getUserPosition();
        int r3 = this.g.getUiLayout();
        int r5 = -1;
        if (r3 == 51) goto L17;
        if (r3 == 67) goto L13;
        switch(r3) {
            case 56: goto L11;
            case 57: goto L11;
            case 58: goto L11;
            default: goto L36;
        };
    L11:
        if (r1 == false) goto L35;
    L32:
        r2 = r2 + 6;
    L35:
        r5 = r2;
    L36:
        if (r5 < 0) goto L4;
        if (r12 <= r5) goto L4;
        MultiLinkGuestViewBinder.a r4 = new MultiLinkGuestViewBinder.a(r0, null, 62);
        r4.a = r5;
        ListProtector.set(r10, r5, r4);
        goto L4
    L13:
        if (r1 == false) goto L35;
        r2 = r2 + 9;
        goto L35
    L17:
        if (r1 == true) goto L25;
        if (r2 == 0) goto L35;
        if (r2 == 1) goto L35;
        if (r2 == 2) goto L34;
        if (r2 == 3) goto L34;
        if (r2 == 4) goto L33;
        if (r2 == 5) goto L33;
    L31:
        r2 = -1;
    L33:
        r2 = r2 + 4;
    L34:
        r2 = r2 + 2;
        goto L35
    L25:
        if (r2 == 0) goto L34;
        if (r2 == 1) goto L34;
        if (r2 == 2) goto L33;
        if (r2 == 3) goto L33;
        if (r2 == 4) goto L32;
        if (r2 == 5) goto L32;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void i(String r17, List<tf0.e> r18, List<ch0.e> r19, int r20) {
        Intrinsics.checkNotNullParameter(r17, "anchorId");
        Intrinsics.checkNotNullParameter(r18, "windowList");
        Intrinsics.checkNotNullParameter(r19, "linkedUserMergeDataList");
        if (j() == false) goto L188;
        if (o.o(Integer.valueOf(this.g.getUiLayout())) == false) goto L7;
        r(r18, r19, r20);
        return;
    L7:
        MultiLinkFrequencyOptConfig r4 = com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.a;
        Integer r5 = Integer.valueOf(this.g.getUiLayout());
        if (r5 != null) goto L11;
    L13:
        boolean r6 = false;
    L14:
        int r8 = 62;
        ILinkPlayerInfoBridge r9 = null;
        Object[] r10 = 0;
        Object[] r11 = 0;
        Object[] r12 = 0;
        Object[] r13 = 0;
        Object[] r14 = 0;
        Object[] r15 = 0;
        Object[] r16 = 0;
        Object[] r21 = 0;
        Object[] r22 = 0;
        Object[] r23 = 0;
        Object[] r24 = 0;
        Object[] r25 = 0;
        Object[] r26 = 0;
        if (r6 == false) goto L47;
        Iterator<ch0.e> r2 = r19.iterator();
    L18:
        if (r2.hasNext() == false) goto L284;
        ch0.e r7 = r2.next();
        int r110 = r7.a.getUserPosition();
        if (r110 < 0) goto L18;
        if (r20 <= r110) goto L18;
        ch0.j r111 = r7.c;
        if (r111 == null) goto L26;
        int r112 = r111.d;
    L27:
        if (r112 == 0) goto L46;
        if (r112 != (-2)) goto L31;
        if (r110 == 0) goto L46;
    L31:
        if (r112 < 0) goto L35;
        if (r20 <= r112) goto L35;
        MultiLinkGuestViewBinder.a r113 = new MultiLinkGuestViewBinder.a(r7, r24 == true ? 1 : 0, r8);
        r113.a = r112;
        ListProtector.set(r18, r112, r113);
    L35:
        if (r112 != (-2)) goto L18;
        if (MultiLinkLoadWidgetUtils.l() == true) goto L39;
    L41:
        boolean r114 = false;
    L42:
        if (r114 == false) goto L18;
        if ((ListProtector.get(r18, r110) instanceof MultiLinkNormalEmptyViewBinder.a) == false) goto L18;
        ListProtector.set(r18, r110, new MultiLinkGuestViewBinder.a(r7, r25 == true ? 1 : 0, r8));
        goto L18
    L39:
        if (vm2.h.W().enableFloatWindowSeiMergeDataOpt() == false) goto L41;
        r114 = true;
    L46:
        MultiLinkGuestViewBinder.a r115 = new MultiLinkGuestViewBinder.a(r7, r26 == true ? 1 : 0, r8);
        r115.a = 0;
        ListProtector.set(r18, 0, r115);
        ALogger.i("WindowListHelper", "[FloatWindow] add floatWindowAnchorOrEnlargeGuestItem, linkPlayerInfo=" + r115.k.a);
        goto L18
    L26:
        r112 = -2;
        goto L27
    L284:
        return;
    L47:
        int r116 = -1;
        int r117 = 6;
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.f(Integer.valueOf(this.g.m()), Integer.valueOf(this.g.getUiLayout())) == false) goto L83;
        Iterator<ch0.e> r3 = r19.iterator();
    L51:
        if (r3.hasNext() == false) goto L285;
        ch0.e r27 = r3.next();
        int r118 = r27.a.getUserPosition();
        if (r118 < 0) goto L51;
        if (r20 <= r118) goto L51;
        ch0.j r119 = r27.c;
        if (r119 == null) goto L59;
        int r120 = r119.d;
    L60:
        if (r120 == (-1)) goto L81;
        if (r120 == 6) goto L81;
        if (r120 < 0) goto L67;
        if (r20 <= r120) goto L67;
        MultiLinkGuestViewBinder.a r121 = new MultiLinkGuestViewBinder.a(r27, r16 == true ? 1 : 0, r8);
        int r122 = r120 + 1;
        r121.a = r122;
        ListProtector.set(r18, r122, r121);
    L67:
        if (r120 != (-2)) goto L70;
        if (r118 != 0) goto L70;
        MultiLinkGuestViewBinder.a r123 = new MultiLinkGuestViewBinder.a(r27, r21 == true ? 1 : 0, r8);
        r123.a = 0;
        ListProtector.set(r18, 0, r123);
        ALogger.i("WindowListHelper", "[FloatWindow] add floatWindowAnchorOrEnlargeGuestItem, linkPlayerInfo=" + r123.k.a);
    L70:
        if (r120 != (-2)) goto L51;
        if (MultiLinkLoadWidgetUtils.l() == true) goto L74;
    L76:
        boolean r124 = false;
    L77:
        if (r124 == false) goto L51;
        if ((ListProtector.get(r18, r118) instanceof MultiLinkNormalEmptyViewBinder.a) == false) goto L51;
        ListProtector.set(r18, r118, new MultiLinkGuestViewBinder.a(r27, r22 == true ? 1 : 0, r8));
        goto L51
    L74:
        if (vm2.h.W().enableFloatWindowSeiMergeDataOpt() == false) goto L76;
        r124 = true;
    L81:
        MultiLinkGuestViewBinder.a r125 = new MultiLinkGuestViewBinder.a(r27, r23 == true ? 1 : 0, r8);
        r125.a = 0;
        ListProtector.set(r18, 0, r125);
        ALogger.i("WindowListHelper", "[FloatWindow] add floatWindowAnchorOrEnlargeGuestItem, linkPlayerInfo=" + r125.k.a);
        goto L51
    L59:
        r120 = -2;
        goto L60
    L285:
        return;
    L83:
        if (com.bytedance.android.live.liveinteract.plantform.commonwindow.utils.f.m(Integer.valueOf(this.g.m()), Integer.valueOf(this.g.getUiLayout())) == false) goto L118;
        Iterator<ch0.e> r28 = r19.iterator();
    L86:
        if (r28.hasNext() == false) goto L286;
        ch0.e r29 = r28.next();
        int r30 = r29.a.getUserPosition();
        if (r30 < 0) goto L86;
        if (r20 <= r30) goto L86;
        ch0.j r126 = r29.c;
        if (r126 == null) goto L94;
        int r127 = r126.d;
    L95:
        if (r127 != r116) goto L97;
    L116:
        MultiLinkGuestViewBinder.a r31 = new MultiLinkGuestViewBinder.a(r29, r13 == true ? 1 : 0, r8);
        r31.a = 0;
        ListProtector.set(r18, 0, r31);
        ALogger.i("WindowListHelper", "[FloatWindow] add floatWindowAnchorOrEnlargeGuestItem, linkPlayerInfo=" + r31.k.a);
    L117:
        r116 = -1;
        r117 = 6;
        goto L86
    L97:
        if (this.g.getUiLayout() != 110) goto L100;
        if (r127 == r117) goto L116;
    L100:
        if (this.g.getUiLayout() != 109) goto L103;
        if (r127 == 8) goto L116;
    L103:
        if (this.g.getUiLayout() != 111) goto L106;
        if (r127 == 8) goto L116;
    L106:
        if (this.g.getUiLayout() != 112) goto L109;
        if (r127 == 8) goto L116;
    L109:
        if (r127 < 0) goto L113;
        if (r20 <= r127) goto L113;
        MultiLinkGuestViewBinder.a r32 = new MultiLinkGuestViewBinder.a(r29, r15 == true ? 1 : 0, r8);
        int r128 = r127 + 1;
        r32.a = r128;
        ListProtector.set(r18, r128, r32);
    L113:
        if (r127 != (-2)) goto L117;
        if (r30 != 0) goto L117;
        MultiLinkGuestViewBinder.a r33 = new MultiLinkGuestViewBinder.a(r29, r14 == true ? 1 : 0, r8);
        r33.a = 0;
        ListProtector.set(r18, 0, r33);
        ALogger.i("WindowListHelper", "[FloatWindow] add floatWindowAnchorOrEnlargeGuestItem, linkPlayerInfo=" + r33.k.a);
        goto L117
    L94:
        r127 = -2;
        goto L95
    L286:
        return;
    L118:
        int r34 = c1.a;
        if (c1.a(Integer.valueOf(this.g.m()), Integer.valueOf(this.g.getUiLayout())) == false) goto L155;
        Iterator<ch0.e> r35 = r19.iterator();
        MultiLinkGuestViewBinder.a r36 = null;
    L122:
        if (r35.hasNext() == false) goto L149;
        ch0.e r37 = r35.next();
        int r38 = r37.a.getUserPosition();
        if (r38 < 0) goto L122;
        if (r20 <= r38) goto L122;
        ch0.j r39 = r37.c;
        if (r39 == null) goto L130;
        int r40 = r39.d;
    L132:
        if (r40 != (-1)) goto L144;
        IBaseUser r129 = r37.a.getUser();
        if (r129 == null) goto L136;
        String r130 = r129.getIdString();
    L137:
        IRoom r131 = this.d;
        if (r131 == null) goto L140;
        String r132 = r131.getOwnerUserIdString();
    L142:
        if (Intrinsics.areEqual(r130, r132) == false) goto L144;
        r36 = new MultiLinkGuestViewBinder.a(r37, r11 == true ? 1 : 0, r8);
        goto L122
    L140:
        r132 = null;
        goto L142
    L136:
        r130 = null;
    L144:
        if (r40 < 0) goto L122;
        if (r20 <= r40) goto L122;
        MultiLinkGuestViewBinder.a r133 = new MultiLinkGuestViewBinder.a(r37, r12 == true ? 1 : 0, r8);
        r133.a = r40;
        ListProtector.set(r18, r40, r133);
        goto L122
    L130:
        r40 = -1;
        goto L132
    L149:
        if (r36 == null) goto L278;
        r36.a = 0;
        ListProtector.add(r18, 0, r36);
        ch0.e r1 = r36.k;
        if (r1 == null) goto L153;
        r9 = r1.a;
    L153:
        ALogger.i("WindowListHelper", "[PCLandscape] add anchorGuestItem, linkPlayerInfo=" + r9);
        return;
    L278:
        return;
    L155:
        if (aj0.b.c(this.g.getUiLayout()) == true) goto L157;
    L159:
        IRoom r41 = this.d;
        if (r41 != null) goto L162;
    L164:
        Iterator<ch0.e> r42 = r19.iterator();
    L166:
        if (r42.hasNext() == false) goto L287;
        ch0.e r43 = r42.next();
        int r44 = r43.a.getUserPosition();
        if (r44 < 0) goto L166;
        if (r20 <= r44) goto L166;
        if (((Boolean) vm2.d.V1.getValue(null, vm2.d.a[149(0x95, float:2.09E-43)])).booleanValue() == false) goto L174;
        int r45 = r43.a.getUserPosition();
    L175:
        ch0.j r46 = r43.c;
        if (r46 == null) goto L178;
        Integer r47 = Integer.valueOf(r46.d);
    L179:
        if (r47 != null) goto L181;
    L183:
        if (r45 < 0) goto L166;
        if (r20 <= r45) goto L166;
        MultiLinkGuestViewBinder.a r48 = new MultiLinkGuestViewBinder.a(r43, r10 == true ? 1 : 0, r8);
        r48.a = r45;
        ListProtector.set(r18, r45, r48);
        goto L166
    L181:
        if (r47.intValue() < 0) goto L183;
        r45 = r47.intValue();
        goto L183
    L178:
        r47 = null;
        goto L179
    L174:
        r45 = -1;
        goto L175
    L287:
        return;
    L162:
        if (r41.isLiveTypeAudio() != true) goto L164;
        t(r18, r19, r20);
        return;
    L157:
        if (((Boolean) bb0.a.getValue()).booleanValue() == true) goto L159;
        s(r18, r19, r20);
        return;
    L11:
        if (r5.intValue() != 29) goto L13;
        r6 = true;
        goto L14
    L188:
        if (aj0.b.c(this.g.getUiLayout()) == false) goto L193;
        if (((Boolean) bb0.a.getValue()).booleanValue() == true) goto L193;
        s(r18, r19, r20);
        return;
    L193:
        if (o.o(Integer.valueOf(this.g.getUiLayout())) == false) goto L195;
        r(r18, r19, r20);
        return;
    L195:
        t(r18, r19, r20);
    }

    public a(IRoom r2, DataCenter r3, boolean r4, com.bytedance.android.live.liveinteract.plantform.commonwindow.m r5, k r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "layoutConfig");
        Intrinsics.checkNotNullParameter(r6, "windowConfig");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.i = r7;
        this.b = BehaviorSubject.createDefault(CollectionsKt.emptyList());
        this.c = new CompositeDisposable();
    }
}
