package com.bytedance.android.live.liveinteract.chatroom.chatroom.interact;

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
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.interact.audience.fragment.InteractAudienceContainerFragment;
import com.bytedance.android.live.liveinteract.interact.audience.fragment.v2.InteractAudienceContainerFragmentV2;
import com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View;
import com.bytedance.android.live.liveinteract.linkpanel.fragment.MultiLinkIntegrationPlayMethodFragment;
import com.bytedance.android.live.liveinteract.plantform.dialog.AudienceTypeFragment;
import com.bytedance.android.live.liveinteract.plantform.dialog.AudienceTypeWithPreApplyFragment;
import com.bytedance.android.live.liveinteract.videotalk.fragment.VideoRoomPreApplyFragment;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Lists;
import com.bytedance.crash.d;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import fe0.b;
import fe0.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import vh7.f;
import yf0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class LinkDialog extends LiveDialogFragment implements g {
    public static final /* synthetic */ int v = 0;
    public int d;
    public InteractDialogFragmentBaseContract$View e;
    public ViewGroup f;
    public ViewGroup g;
    public ViewGroup h;
    public TextView i;
    public ie0.a j;
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

        public final LinkDialog a() {
            LinkDialog r0 = new LinkDialog();
            r0.o = this;
            r0.l = this.b;
            r0.k = this.a;
            return r0;
        }

        public final LinkDialog b(int r3) {
            LinkDialog r0 = new LinkDialog();
            r0.o = this;
            r0.l = this.b;
            r0.k = this.a;
            r0.d = r3;
            return r0;
        }

        public a(DataCenter r1, LifecycleOwner r2) {
            this.a = r1;
            this.b = r2;
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
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L18;
        d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L18
    }

    public final void onDestroyView() {
        ViewGroup r0 = this.g;
        if (r0 == null) goto L5;
        r0.removeAllViews();
    L5:
        ViewGroup r1 = this.h;
        if (r1 == null) goto L8;
        r1.removeAllViews();
    L8:
        super.onDestroyView();
        ValueAnimator r2 = this.p;
        if (r2 == null) goto L11;
        r2.cancel();
    L11:
        this.n.removeAllElements();
    }

    @Override // yf0.g
    public final int s9() {
        return this.n.size();
    }

    public LinkDialog() {
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
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L12;
        d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
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
        S90(new c(this));
        return;
    }

    @Override // yf0.g
    public final LifecycleOwner getLifecycleOwner() {
        return this.l;
    }

    @Override // yf0.g
    public final void Rh(final InteractDialogFragmentBaseContract$View r2) {
        if (getDialog() == null) goto L8;
        if (r2 == null) goto L9;
        this.t = true;
        S90(new fe0.d(this, r2));
        return;
    L9:
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
        if (r6 == null) goto L11;
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
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(1, 2131954719);
        this.j = new ie0.a();
        AnimationUtils.loadAnimation(getContext(), 2130772675);
        this.u = AnimationUtils.loadAnimation(getContext(), 2130772676);
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.setCanceledOnTouchOutside(true);
        return r3;
    }

    public final void onViewCreated(View r8, Bundle r9) {
        super.onViewCreated(r8, r9);
        getChildFragmentManager().addOnBackStackChangedListener(new fe0.a(this));
        if (this.n.empty() == false) goto L35;
        InteractDialogFragmentBaseContract$View r10 = this.e;
        if (r10 == null) goto L7;
        Rh(r10);
        goto L35
    L7:
        int r11 = this.d;
        if (r11 != 0) goto L10;
        DataCenter r12 = this.k;
        AudienceTypeFragment r13 = new AudienceTypeFragment();
        r13.g = r12;
        r13.d = this;
        Rh(r13);
        goto L35
    L10:
        if (r11 != 15) goto L12;
        Rh(InteractAudienceContainerFragmentV2.aa0(this, this.k));
        goto L35
    L12:
        if (r11 != 23) goto L14;
        int r14 = AudienceTypeWithPreApplyFragment.k;
        DataCenter r15 = this.k;
        Room r16 = m.i().getCurrentRoom();
        HashMap r0 = new HashMap();
        boolean r1 = true;
        if (r16 != null) goto L26;
        r0.put("dataCenter", this.k);
        r0.put("getRoomFromRoomContext", "null");
        r16 = m.i().getCurrentRoom();
        boolean r3 = true;
    L27:
        if (r16 != null) goto L29;
        r0.put("getRoomFromService", "null");
        r16 = (IRoom) f.c(IRoom.class);
    L30:
        if (r1 == false) goto L32;
        com.bytedance.android.live.liveinteract.api.utils.g.s("LinkDialog.getCurrentRoom", r0);
    L32:
        AudienceTypeWithPreApplyFragment r2 = new AudienceTypeWithPreApplyFragment();
        AudienceTypeFragment r4 = new AudienceTypeFragment();
        r4.g = r15;
        r4.d = this;
        r2.g = r4;
        VideoRoomPreApplyFragment r5 = new VideoRoomPreApplyFragment();
        r5.d = this;
        r2.h = r5;
        r2.i = r15;
        r2.j = r16;
        Rh(r2);
        goto L35
    L29:
        r1 = r3;
        goto L30
    L26:
        r3 = false;
        goto L27
    L14:
        if (r11 != 25) goto L16;
        int r17 = MultiLinkIntegrationPlayMethodFragment.q;
        this.o.getClass();
        DataCenter r6 = this.k;
        this.o.getClass();
        this.o.getClass();
        this.o.getClass();
        Rh(MultiLinkIntegrationPlayMethodFragment.a.a(this, null, r6, null, null, 0, false));
        goto L35
    L16:
        if (r11 != 8) goto L18;
        Rh(InteractAudienceContainerFragment.aa0(this, this.k));
        goto L35
    L18:
        if (r11 != 9) goto L35;
        DataCenter r18 = this.k;
        AudienceTypeFragment r19 = new AudienceTypeFragment();
        r19.g = r18;
        r19.d = this;
        Rh(r19);
    L35:
        e r20 = b6.t;
        String r21 = getString(2131919437);
        r20.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r20, r21);
        setBottomSheetSlideProcessor(new b());
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
        this.s.setOnClickListener(new fe0.e(this));
        return this.q;
    }
}
