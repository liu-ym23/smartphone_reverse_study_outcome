package com.bytedance.android.livesdk.chatroom.ui.framework;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.chatroom.model.EnterRoomExtra;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import hh1.v0;
import hh1.w0;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i implements c {
    public d a;
    public final PropertyOwner b;
    public final fo1.b c;

    public static final class a implements w0 {
        public final /* synthetic */ i a;

        public a(i r1) {
            this.a = r1;
        }

        public final void O6(List<ILinkPlayerInfoBridge> r3) {
            Iterator<T> r0 = this.a.c.l.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((w0) r0.next()).O6(r3);
            goto L4
        }

        public final void Mc(IBaseUser r3, boolean r4) {
            Iterator<T> r0 = this.a.c.l.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((w0) r0.next()).Mc(r3, r4);
            goto L4
        }

        public final void Wk(String r3, boolean r4) {
            Iterator<T> r0 = this.a.c.l.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((w0) r0.next()).Wk(r3, r4);
            goto L4
        }

        public final void f9(String r3, boolean r4) {
            Iterator<T> r0 = this.a.c.l.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((w0) r0.next()).f9(r3, r4);
            goto L4
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final /* bridge */ /* synthetic */ Object Ep() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final com.bytedance.android.live.core.arch.mvvm.d<Boolean> Qi() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final boolean R7() {
        return true;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final List<DialogInterface.OnKeyListener> S5() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final boolean dg() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final com.bytedance.android.live.pushstream.d getLiveStream() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final v0 getLiveVideoClientFactory() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final /* bridge */ /* synthetic */ Object ng() {
        return null;
    }

    public final /* synthetic */ void onAbilityClear() {
        IAbility.-CC.$default$onAbilityClear(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final List<View.OnTouchListener> u6() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final d Gg() {
        d r0 = this.a;
        if (r0 != null) goto L6;
        d r1 = ho1.a.i(this.c.d);
        this.a = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final w0 J1() {
        fo1.b r0 = this.c;
        w0 r1 = r0.m;
        if (r1 != null) goto L6;
        a r2 = new a(this);
        r0.m = r2;
        return r2;
    L6:
        return r1;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final boolean V9() {
        fo1.b r0 = this.c;
        if (r0.r == true) goto L5;
    L7:
        return false;
    L5:
        if (r0.a == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final Bundle Wl() {
        return this.c.a();
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final FragmentManager ea() {
        return this.c.q.getParentFragmentManager();
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final com.bytedance.android.live.room.l ef() {
        com.bytedance.android.live.room.l r0 = this.c.s;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("roomLogger");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final FragmentManager getChildFragmentManager() {
        return this.c.q.getChildFragmentManager();
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final Fragment getFragment() {
        return this.c.q;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final LiveMode getLiveMode() {
        return this.c.i;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final Room getRoom() {
        return this.c.c();
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final boolean hq() {
        return this.c.e;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final boolean isNestedOutside() {
        return this.c.u;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final boolean isPortrait() {
        return this.c.a;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final EnterRoomExtra k3() {
        return this.c.h;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final boolean o5() {
        fo1.b r0 = this.c;
        if (r0.r == true) goto L5;
    L7:
        return false;
    L5:
        if ((!r0.a) == false) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final FragmentActivity p0() {
        return this.c.q.getActivity();
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final com.bytedance.android.live.room.h.b uq() {
        return this.c.k;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final com.bytedance.android.livesdk.chatroom.ui.framework.utils.e wl() {
        return this.c.p;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final PropertyOwner Ce() {
        return this.b;
    }

    public i(fo1.b r2) {
        Intrinsics.checkNotNullParameter(r2, "interactionContext");
        this.c = r2;
        PropertyOwner<Boolean> r3 = r2.B;
        r3.getClass();
        this.b = r3;
    }
}
