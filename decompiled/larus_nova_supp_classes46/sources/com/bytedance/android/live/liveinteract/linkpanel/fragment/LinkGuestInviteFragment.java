package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.linkpanel.contract.AudioTalkDialogContract$View;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.livesdk.config.t61;
import com.bytedance.android.livesdk.config.u61;
import com.bytedance.android.livesdk.widget.LinkNoScrollViewPager;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/fragment/LinkGuestInviteFragment;", "Lcom/bytedance/android/live/liveinteract/linkpanel/contract/AudioTalkDialogContract$View;", "<init>", "()V", "a", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkGuestInviteFragment extends AudioTalkDialogContract$View {
    public static final /* synthetic */ int p = 0;
    public View g;
    public ViewGroup h;
    public LinkNoScrollViewPager i;
    public AnonymousClass1 j;
    public LinkInviteContainerFragment k;
    public String l;
    public DataCenter m;
    public DataContext n;
    public int o;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ LinkGuestInviteFragment a;
        public final /* synthetic */ Ref.IntRef b;

        public b(LinkGuestInviteFragment r1, Ref.IntRef r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            if (((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService() == null) goto L10;
            int r5 = this.b.element;
            rj0.l.n2.getClass();
            rj0.l r0 = rj0.l.a.a();
            if (r0 == null) goto L7;
            r0.j3(r5);
        L7:
            IVoiceChatGuestService.Companion.getClass();
            IVoiceChatGuestService r1 = IVoiceChatGuestService.a.a();
            if (r1 == null) goto L10;
            r1.updatePosition(r5);
        L10:
            this.a.d.dismiss();
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ LinkGuestInviteFragment a;

        public c(LinkGuestInviteFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            LinkGuestInviteFragment r7 = this.a;
            int r0 = r7.aa0(r7.o);
            rj0.l.n2.getClass();
            rj0.l r1 = rj0.l.a.a();
            if (r1 == null) goto L5;
            r1.j3(r0);
        L5:
            com.bytedance.live.datacontext.j r2 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
            if (r2 == null) goto L14;
            com.bytedance.android.livesdk.chatroom.viewmodel.e r3 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r2.getValue();
            if (r3 == null) goto L14;
            com.bytedance.android.livesdk.chatroom.viewmodel.j r4 = r3.t();
            if (r4 == null) goto L14;
            if (r4.a != 12) goto L14;
        L15:
            rj0.l r5 = rj0.l.a.a();
            if (r5 == null) goto L21;
            r5.j3(r7.o);
        L21:
            r7.d.dismiss();
            return;
        L14:
            if (com.bytedance.android.live.liveinteract.linkpanel.util.o.C() == true) goto L15;
            rj0.l r8 = rj0.l.a.a();
            if (r8 == null) goto L21;
            r8.j3(((long) r7.o) + 1);
            goto L21
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final float T90() {
        return 432.0f;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final String W90() {
        return "";
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final ViewGroup X90() {
        ViewGroup r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L5:
        return r0;
    }

    public LinkGuestInviteFragment() {
        this.l = "";
        this.o = -1;
    }

    public final void onDestroy() {
        super.onDestroy();
        t61 r0 = com.bytedance.android.live.liveinteract.linkpanel.util.z.a();
        if (r0 != null) goto L5;
        return;
    L5:
        if (u61.c(r0) != true) goto L12;
        LinkNoScrollViewPager r1 = this.i;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L9:
        r1.setAdapter(null);
        this.k = null;
        this.d = null;
        this.j = null;
        return;
    }

    public final int aa0(int r6) {
        int r0 = com.bytedance.android.live.liveinteract.linkpanel.util.o.c();
        int r1 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurUILayout();
        Room r2 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService() == null) goto L8;
        if (yg0.h.i(r1) != true) goto L8;
        return r6;
    L8:
        if (r0 == 8) goto L17;
        if (r0 == 5) goto L13;
        return r6;
    L13:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.h(r2) == false) goto L15;
        return r6;
    L15:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.F(r1) == true) goto L17;
        return r6;
    L17:
        return r6 + 1;
    }

    /* JADX WARN: Type inference failed for: r11v6, types: [com.bytedance.android.live.liveinteract.linkpanel.fragment.LinkGuestInviteFragment$onCreateView$1] */
    public final View onCreateView(LayoutInflater r11, ViewGroup r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r11, "inflater");
        View r14 = r11.inflate(2131565505, r12, false);
        this.g = r14;
        if (r14 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        this.i = r14.findViewById(2131392847);
        int r15 = LinkInviteContainerFragment.n;
        yf0.g r16 = this.d;
        DataCenter r17 = this.m;
        int r1 = this.o;
        String r2 = this.l;
        LinkInviteContainerFragment r3 = new LinkInviteContainerFragment();
        r3.i = r17;
        r3.d = r16;
        r3.k = r1;
        r3.l = r2;
        this.k = r3;
        final FragmentManager r18 = getChildFragmentManager();
        this.j = new AnonymousClass1(this, r18);
        LinkNoScrollViewPager r19 = this.i;
        if (r19 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L8:
        r19.setAdapter(this.j);
        LinkNoScrollViewPager r110 = this.i;
        if (r110 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L11:
        r110.setCurrentItem(0);
        com.bytedance.live.datacontext.m r111 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r111 == null) goto L16;
        IRoom r112 = (IRoom) r111.getValue();
        if (r112 == null) goto L16;
        com.bytedance.android.livesdk.chatroom.interact.model.d0.h(r112);
    L16:
        Ref.IntRef r113 = new Ref.IntRef();
        r113.element = aa0(this.o);
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.D() == true) goto L19;
    L24:
        int r114 = r113.element + 1;
    L25:
        List r4 = null;
        View r5 = LayoutInflater.from(getContext()).inflate(2131565484, null);
        if (r5 == null) goto L93;
        this.h = (ViewGroup) r5;
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.m() == true) goto L30;
        com.bytedance.live.datacontext.j r115 = com.bytedance.android.live.liveinteract.api.utils.m.g(this.n).getVideoTalkRoomSubScene();
        if (r115 == null) goto L70;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r116 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r115.getValue();
        if (r116 == null) goto L70;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r117 = r116.t();
        if (r117 == null) goto L70;
        List r118 = r117.b;
        if (r118 == null) goto L70;
        if (r118.contains(4) == false) goto L68;
        r4 = r118;
    L68:
        if (r4 == null) goto L70;
        boolean r119 = true;
    L72:
        if (this.o == (-1)) goto L84;
        if (r119 == true) goto L84;
        ViewGroup r120 = this.h;
        if (r120 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L77:
        ((TextView) r120.findViewById(2131391659)).setVisibility(0);
        ViewGroup r121 = this.h;
        if (r121 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L80:
        ((TextView) r121.findViewById(2131391659)).setText(com.bytedance.android.live.core.utils.s1.C(2131918050, new Object[]{String.valueOf(r114)}));
        ViewGroup r122 = this.h;
        if (r122 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L83:
        ((TextView) r122.findViewById(2131391659)).setOnClickListener(new c(this));
    L88:
        View r123 = this.g;
        if (r123 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L91:
        return r123;
    L84:
        ViewGroup r124 = this.h;
        if (r124 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L87:
        ((TextView) r124.findViewById(2131391659)).setVisibility(8);
    L70:
        r119 = false;
        goto L72
    L30:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.A0.getValue()).booleanValue() == true) goto L32;
    L34:
        boolean r6 = false;
    L36:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.d() != 29) goto L38;
        boolean r7 = true;
    L40:
        if (this.o == (-1)) goto L53;
        if (r6 == true) goto L53;
        if (r7 == true) goto L53;
        ViewGroup r8 = this.h;
        if (r8 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L46:
        ((TextView) r8.findViewById(2131391659)).setVisibility(0);
        ViewGroup r9 = this.h;
        if (r9 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L49:
        ((TextView) r9.findViewById(2131391659)).setText(com.bytedance.android.live.core.utils.s1.C(2131918050, new Object[]{String.valueOf(r114)}));
        ViewGroup r125 = this.h;
        if (r125 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L52:
        ((TextView) r125.findViewById(2131391659)).setOnClickListener(new b(this, r113));
    L53:
        ViewGroup r126 = this.h;
        if (r126 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("topBarView");
    L56:
        ((TextView) r126.findViewById(2131391659)).setVisibility(8);
        goto L88
    L38:
        r7 = false;
        goto L40
    L32:
        if (vm2.d.E0() == false) goto L34;
        r6 = true;
        goto L36
    L93:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L19:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.c() != 12) goto L21;
        boolean r127 = true;
    L22:
        if (r127 == true) goto L24;
        r114 = r113.element;
        goto L25
    L21:
        r127 = false;
        goto L22
    }
}
