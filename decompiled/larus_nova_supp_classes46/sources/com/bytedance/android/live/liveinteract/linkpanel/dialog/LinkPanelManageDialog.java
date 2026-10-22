package com.bytedance.android.live.liveinteract.linkpanel.dialog;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View;
import com.bytedance.android.live.liveinteract.linkpanel.fragment.AudioTalkSettingFragment;
import com.bytedance.android.live.liveinteract.linkpanel.fragment.LinkGuestInviteFragment;
import com.bytedance.android.live.liveinteract.linkpanel.fragment.LinkManagePanel;
import com.bytedance.android.live.liveinteract.linkpanel.fragment.MultiLinkIntegrationPlayMethodFragment;
import com.bytedance.android.live.liveinteract.linkpanel.fragment.SettingLynxContainerFragment;
import com.bytedance.android.live.liveinteract.linkpanel.fragment.VideoTalkSettingFragment;
import com.bytedance.android.live.liveinteract.linkpanel.util.r;
import com.bytedance.android.live.liveinteract.linkpanel.util.s;
import com.bytedance.android.live.liveinteract.linkpanel.util.t;
import com.bytedance.android.live.liveinteract.linkpanel.util.u;
import com.bytedance.android.live.liveinteract.linkpanel.util.z;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.model.k1;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.config.t61;
import com.bytedance.android.livesdk.config.u61;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class LinkPanelManageDialog extends LiveDialogFragment implements yf0.g {
    public static final /* synthetic */ int v = 0;
    public int d;
    public Runnable e;
    public ViewGroup f;
    public ViewGroup g;
    public ViewGroup h;
    public TextView i;
    public com.bytedance.android.live.liveinteract.linkpanel.presenter.g j;
    public DataCenter k;
    public LifecycleOwner l;
    public final List<Runnable> m;
    public final Stack<InteractDialogFragmentBaseContract$View> n;
    public a o;
    public ValueAnimator p;
    public View q;
    public View r;
    public View s;
    public boolean t;
    public Animation u;

    public static final class a {
        public final DataCenter a;
        public final LifecycleOwner b;
        public final Runnable c;
        public IRoom d;
        public int e;
        public int f;
        public String g;
        public IRoom h;
        public boolean i;
        public boolean j;
        public boolean k;
        public List<k1> l;
        public String m;
        public int n;

        public final LinkPanelManageDialog a(int r3) {
            LinkPanelManageDialog r0 = new LinkPanelManageDialog();
            r0.o = this;
            r0.l = this.b;
            r0.k = this.a;
            r0.d = r3;
            r0.e = this.c;
            return r0;
        }

        public a(DataCenter r1, LifecycleOwner r2, Runnable r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public final boolean onBackPressed() {
        if (this.n.isEmpty() == false) goto L5;
        return false;
    L5:
        if (this.n.peek().U90() == null) goto L9;
        this.n.peek().U90().performClick();
        return true;
    L9:
        if (this.n.size() == 1) goto L11;
        return false;
    L11:
        if (this.t == true) goto L21;
    L18:
        return true;
    L21:
        dismiss();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L18;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L18
    }

    public final void onDestroyView() {
        ViewGroup r0 = this.g;
        if (r0 == null) goto L5;
        r0.removeAllViews();
        this.g = null;
    L5:
        ViewGroup r1 = this.h;
        if (r1 == null) goto L8;
        r1.removeAllViews();
        this.h = null;
    L8:
        super.onDestroyView();
        ValueAnimator r2 = this.p;
        if (r2 == null) goto L11;
        r2.cancel();
    L11:
        this.n.removeAllElements();
        if (z.a() == null) goto L22;
        t61 r3 = z.a();
        if (r3 == null) goto L16;
        boolean r4 = u61.c(r3);
    L17:
        if (r4 == true) goto L19;
        return;
    L19:
        if (getHost() == null) goto L24;
        getChildFragmentManager().getFragments().clear();
        return;
    L24:
        return;
    L16:
        r4 = false;
        goto L17
    }

    @Override // yf0.g
    public final int s9() {
        return this.n.size();
    }

    public LinkPanelManageDialog() {
        this.d = 0;
        this.m = new ArrayList();
        this.n = new Stack();
        this.t = true;
    }

    public final void T90() {
        Dialog r0 = getDialog();
        Context r1 = getContext();
        if (r0 == null) goto L15;
        if (r1 == null) goto L18;
        View r2 = getDialog().getCurrentFocus();
        if (r2 != null) goto L9;
        return;
    L9:
        InputMethodManager r3 = (InputMethodManager) r1.getSystemService("input_method");
        if (r3 != null) goto L12;
        return;
    L12:
        if (r3.isActive() == false) goto L17;
        r3.hideSoftInputFromWindow(r2.getWindowToken(), 0);
        return;
    L17:
        return;
    L18:
        return;
    }

    @Override // yf0.g
    public final void dismiss() {
        T90();
        super.dismiss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L12;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final IRoom getCurrentRoom() {
        o r0 = m.i();
        if (r0 != null) goto L5;
    L9:
        IRoom r1 = null;
    L10:
        HashMap r2 = new HashMap();
        if (r1 != null) goto L13;
        r2.put("dataCenter", this.k);
        r2.put("roomContext", r0);
        r2.put("getRoomFromRoomContext", "null");
        r1 = m.i().getCurrentRoom();
    L13:
        if (r1 != null) goto L16;
        r2.put("getRoomFromService", "null");
        return vh7.f.c(IRoom.class);
    L16:
        return r1;
    L5:
        if (r0.getRoom() == null) goto L9;
        if (r0.getRoom().getValue() == null) goto L9;
        r1 = (IRoom) r0.getRoom().getValue();
        goto L10
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.A(getCurrentRoom()) == false) goto L12;
        ih0.c r0 = u.a;
        ALogger.i("MultiLinkSettingPanelReuseManager", "releaseSettingPanelContainerCard call");
        ih0.c r1 = u.a;
        if (r1 == null) goto L7;
        r1.J();
    L7:
        ih0.c r2 = u.a;
        if (r2 == null) goto L10;
        r2.release();
    L10:
        u.a = null;
    L12:
        if (z.a() == null) goto L21;
        t61 r3 = z.a();
        if (r3 == null) goto L16;
        boolean r4 = u61.c(r3);
    L17:
        if (r4 == false) goto L21;
        Runnable r5 = this.e;
        if (r5 == null) goto L21;
        r5.run();
        this.e = null;
        goto L21
    L16:
        r4 = false;
    L21:
        this.j.a.clear();
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        if (Lists.isEmpty(this.m) == true) goto L8;
        Iterator r0 = ((ArrayList) this.m).iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        ((Runnable) r0.next()).run();
    L8:
        ((ArrayList) this.m).clear();
    }

    @Override // yf0.g
    public final void v0() {
        if (getDialog() != null) goto L5;
        return;
    L5:
        if (this.n.isEmpty() == true) goto L10;
        this.t = true;
        S90(new d(this));
        return;
    }

    @Override // yf0.g
    public final LifecycleOwner getLifecycleOwner() {
        return this.l;
    }

    @Override // yf0.g
    public final void Rh(final InteractDialogFragmentBaseContract$View r2) {
        if (getDialog() == null) goto L6;
        this.t = true;
        S90(new h(this, r2));
        return;
    }

    public final void S90(Runnable r2) {
        if (isResumed() == false) goto L5;
        r2.run();
        return;
    L5:
        ((ArrayList) this.m).add(r2);
    }

    public final void U90(Fragment r2) {
        if (r2 == null) goto L9;
        if (this.n.empty() == false) goto L6;
        return;
    L6:
        if (this.n.peek().getView() == null) goto L15;
        this.n.peek().getView().setVisibility(8);
        this.n.peek().Z90();
        return;
    L15:
        return;
    L9:
        if (this.n.empty() == false) goto L11;
        return;
    L11:
        if (this.n.peek().getView() == null) goto L18;
        this.n.peek().getView().setVisibility(0);
        this.n.peek().Y90();
        return;
    }

    public final void onActivityCreated(Bundle r5) {
        super.onActivityCreated(r5);
        Window r6 = getDialog().getWindow();
        if (r6 == null) goto L13;
        View r0 = r6.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r1 = ThreadMethodProxy.currentThread();
        if (r1 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");
    L9:
        r0.setPadding(0, 0, 0, 0);
        r6.setLayout(-1, -1);
        r6.setGravity(80);
        r6.setBackgroundDrawable(new ColorDrawable(0));
        r6.setSoftInputMode(48);
        int r2 = c1.a;
        int r3 = s1.f(375.0f);
        if (e5.n() == false) goto L14;
        r6.setGravity(5);
        r6.setLayout(r3, -1);
        return;
    L14:
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954719);
        this.j = new com.bytedance.android.live.liveinteract.linkpanel.presenter.g();
        AnimationUtils.loadAnimation(getContext(), 2130772675);
        this.u = AnimationUtils.loadAnimation(getContext(), 2130772676);
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.setCanceledOnTouchOutside(true);
        return r3;
    }

    public final void onViewCreated(View r9, Bundle r10) {
        super.onViewCreated(r9, r10);
        getChildFragmentManager().addOnBackStackChangedListener(new f(this));
        if (this.n.empty() == false) goto L29;
        int r11 = this.d;
        DataContext r0 = null;
        if (r11 != 7) goto L7;
        DataCenter r12 = this.k;
        a r13 = this.o;
        int r5 = r13.e;
        String r6 = r13.g;
        int r14 = r13.f;
        int r7 = LinkManagePanel.w;
        Intrinsics.checkNotNullParameter(this, "dialog");
        Intrinsics.checkNotNullParameter(r12, "dataCenter");
        Intrinsics.checkNotNullParameter(r6, "requestPage");
        LinkManagePanel r2 = new LinkManagePanel();
        r2.d = this;
        r2.p = r12;
        r2.n = r5;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r2.o = r6;
        r2.r = r14;
        r2.m = ((Boolean) r12.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        DataContext r15 = com.bytedance.live.datacontext.d.d(o.class);
        if ((r15 instanceof DataContext) == false) goto L28;
        r0 = r15;
    L28:
        r2.q = r0;
        Rh(r2);
        goto L29
    L7:
        if (r11 == 17) goto L19;
        switch(r11) {
            case 24: goto L16;
            case 25: goto L14;
            case 26: goto L11;
            default: goto L29;
        };
    L14:
        int r16 = MultiLinkIntegrationPlayMethodFragment.q;
        a r17 = this.o;
        Rh(MultiLinkIntegrationPlayMethodFragment.a.a(this, r17.h, this.k, r17.l, r17.m, r17.n, false));
        goto L29
    L11:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.A(getCurrentRoom()) == false) goto L13;
        DataCenter r1 = this.k;
        IRoom r3 = this.o.h;
        DataContext r4 = com.bytedance.live.datacontext.d.d(o.class);
        a r18 = this.o;
        String r8 = r18.g;
        int r19 = r18.f;
        SettingLynxContainerFragment.r.getClass();
        Rh(SettingLynxContainerFragment.a.a(this, r1, r3, r4, r8, r19, false));
        goto L29
    L13:
        int r20 = AudioTalkSettingFragment.w;
        Rh(AudioTalkSettingFragment.a.a(this, this.o.h, com.bytedance.live.datacontext.d.d(o.class), this.k, this.o.g));
        goto L29
    L16:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.A(getCurrentRoom()) == false) goto L18;
        DataCenter r21 = this.k;
        a r22 = this.o;
        IRoom r23 = r22.h;
        int r24 = r22.f;
        SettingLynxContainerFragment.r.getClass();
        Rh(SettingLynxContainerFragment.a.a(this, r21, r23, null, null, r24, false));
        goto L29
    L18:
        int r25 = VideoTalkSettingFragment.z;
        a r26 = this.o;
        Rh(VideoTalkSettingFragment.a.a(this, r26.h, r26.i, r26.j, r26.f, this.k, r26.k, false));
        goto L29
    L19:
        DataCenter r27 = this.k;
        a r110 = this.o;
        String r28 = r110.g;
        int r111 = r110.f;
        int r29 = LinkGuestInviteFragment.p;
        Intrinsics.checkNotNullParameter(this, "dialog");
        Intrinsics.checkNotNullParameter(r27, "dataCenter");
        Intrinsics.checkNotNullParameter(r28, "requestPage");
        LinkGuestInviteFragment r30 = new LinkGuestInviteFragment();
        r30.d = this;
        r30.m = r27;
        Intrinsics.checkNotNullParameter(r28, "<set-?>");
        r30.l = r28;
        r30.o = r111;
        DataContext r31 = com.bytedance.live.datacontext.d.d(o.class);
        if ((r31 instanceof DataContext) == false) goto L23;
        r0 = r31;
    L23:
        r30.n = r0;
        Rh(r30);
    L29:
        com.bytedance.android.livesdk.sharedpref.e r32 = b6.t;
        String r112 = getString(2131919437);
        r32.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r32, r112);
        setBottomSheetSlideProcessor(new g());
        Context r33 = getContext();
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.A(getCurrentRoom()) == false) goto L38;
        if (r33 == null) goto L39;
        a r113 = this.o;
        if (r113 == null) goto L40;
        ih0.c r34 = u.a;
        DataCenter r35 = this.k;
        int r114 = r113.f;
        Intrinsics.checkNotNullParameter(r33, "context");
        IInteractService r36 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r36 == null) goto L41;
        r36.composeMultiLinkDisposableCall(Observable.fromCallable(new r(r33, r35, r114)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(s.a, t.a));
        return;
    L41:
        return;
    L40:
        return;
    L39:
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = LayoutInflater.from(getContext()).inflate(2131566054, r3, false);
        this.q = r5;
        this.i = (TextView) r5.findViewById(2131391606);
        this.g = (ViewGroup) this.q.findViewById(2131377533);
        this.h = (ViewGroup) this.q.findViewById(2131377602);
        this.f = (ViewGroup) this.q.findViewById(2131373275);
        this.r = this.q.findViewById(2131392587);
        View r6 = this.q.findViewById(2131381758);
        this.s = r6;
        r6.setAlpha(0.0f);
        this.s.setOnClickListener(new e(this));
        return this.q;
    }
}
