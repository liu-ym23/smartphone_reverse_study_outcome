package com.bytedance.android.livesdk.interactivity.medialink.dialog;

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
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.medialink.dialog.contract.MediaInteractDialogFragmentBaseContract$View;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Lists;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class MediaLinkDialog extends LiveDialogFragment implements t82.f {
    public static final /* synthetic */ int t = 0;
    public int d;
    public MediaInteractDialogFragmentBaseContract$View e;
    public ViewGroup f;
    public ViewGroup g;
    public ViewGroup h;
    public TextView i;
    public u82.i j;
    public LifecycleOwner k;
    public final List<Runnable> l;
    public final Stack<MediaInteractDialogFragmentBaseContract$View> m;
    public ValueAnimator n;
    public View o;
    public View p;
    public View q;
    public boolean r;
    public Animation s;

    public final Room T90() {
        RoomContext.a r0 = RoomContext.Companion;
        r0.getClass();
        Room r4 = null;
        RoomContext r1 = RoomContext.a.c(r0, null, 0, 3);
        if (r1 != null) goto L5;
    L7:
        HashMap r2 = new HashMap();
        boolean r3 = true;
        if (r4 != null) goto L10;
        r2.put("roomContext", r1);
        r2.put("getRoomFromRoomContext", "null");
        r4 = jc1.k.f(IRoomService.class).getCurrentRoom();
        boolean r5 = true;
    L11:
        if (r4 != null) goto L13;
        r2.put("getRoomFromService", "null");
        r4 = new Room();
    L14:
        if (r3 == false) goto L16;
        com.bytedance.android.live.liveinteract.api.utils.g.s("MediaLinkDialog.getCurrentRoom", r2);
    L16:
        return r4;
    L13:
        r3 = r5;
        goto L14
    L10:
        r5 = false;
        goto L11
    L5:
        if (r1.getRoom() == null) goto L7;
        r4 = (Room) r1.getRoom().getValue();
        goto L7
    }

    public final boolean onBackPressed() {
        if (this.m.isEmpty() == false) goto L5;
        return false;
    L5:
        if (this.m.peek().U90() == null) goto L9;
        this.m.peek().U90().performClick();
        return true;
    L9:
        if (this.m.size() == 1) goto L11;
        return false;
    L11:
        if (this.r == true) goto L21;
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
    L5:
        ViewGroup r1 = this.h;
        if (r1 == null) goto L8;
        r1.removeAllViews();
    L8:
        super.onDestroyView();
        ValueAnimator r2 = this.n;
        if (r2 == null) goto L11;
        r2.cancel();
    L11:
        this.m.removeAllElements();
    }

    public MediaLinkDialog() {
        this.d = 0;
        this.l = new ArrayList();
        this.m = new Stack();
        this.r = true;
    }

    public final void U90() {
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

    @Override // t82.f
    public final void dismiss() {
        U90();
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

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        this.j.a.clear();
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        if (Lists.isEmpty(this.l) == true) goto L8;
        Iterator r0 = ((ArrayList) this.l).iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        ((Runnable) r0.next()).run();
    L8:
        ((ArrayList) this.l).clear();
    }

    @Override // t82.f
    public final void v0() {
        if (getDialog() != null) goto L5;
        return;
    L5:
        if (this.m.isEmpty() == true) goto L10;
        this.r = true;
        S90(new o(this));
        return;
    }

    @Override // t82.f
    public final LifecycleOwner getLifecycleOwner() {
        return this.k;
    }

    @Override // t82.f
    public final void F4(final boolean r2) {
        this.r = r2;
        setCancelable(r2);
        setBottomSheetSlideProcessor(new i(r2));
    }

    public final void S90(Runnable r2) {
        if (isResumed() == false) goto L5;
        r2.run();
        return;
    L5:
        ((ArrayList) this.l).add(r2);
    }

    public final void V90(Fragment r2) {
        if (r2 == null) goto L9;
        if (this.m.empty() == false) goto L6;
        return;
    L6:
        if (this.m.peek().getView() == null) goto L15;
        this.m.peek().getView().setVisibility(8);
        return;
    L15:
        return;
    L9:
        if (this.m.empty() == false) goto L11;
        return;
    L11:
        if (this.m.peek().getView() == null) goto L18;
        this.m.peek().getView().setVisibility(0);
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
        this.j = new u82.i();
        AnimationUtils.loadAnimation(getContext(), 2130772675);
        this.s = AnimationUtils.loadAnimation(getContext(), 2130772676);
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.setCanceledOnTouchOutside(true);
        return r3;
    }

    @Override // t82.f
    public final void v20(final MediaInteractDialogFragmentBaseContract$View r2) {
        if (getDialog() == null) goto L8;
        if (r2 == null) goto L9;
        this.r = true;
        S90(new m(this, r2));
        return;
    L9:
        return;
    }

    public final void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        getChildFragmentManager().addOnBackStackChangedListener(new j(this));
        if (this.m.empty() == false) goto L11;
        MediaInteractDialogFragmentBaseContract$View r3 = this.e;
        if (r3 == null) goto L8;
        v20(r3);
        goto L11
    L8:
        if (this.d != 10) goto L11;
        MediaAnchorInteractContainerFragment r4 = new MediaAnchorInteractContainerFragment();
        r4.d = this;
        v20(r4);
    L11:
        setBottomSheetSlideProcessor(new k());
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = LayoutInflater.from(getContext()).inflate(2131566073, r3, false);
        this.o = r5;
        this.i = (TextView) r5.findViewById(2131391606);
        this.g = (ViewGroup) this.o.findViewById(2131377533);
        this.h = (ViewGroup) this.o.findViewById(2131377602);
        this.f = (ViewGroup) this.o.findViewById(2131373275);
        this.p = this.o.findViewById(2131392587);
        View r6 = this.o.findViewById(2131381758);
        this.q = r6;
        r6.setAlpha(0.0f);
        this.q.setOnClickListener(new l(this));
        return this.o;
    }
}
