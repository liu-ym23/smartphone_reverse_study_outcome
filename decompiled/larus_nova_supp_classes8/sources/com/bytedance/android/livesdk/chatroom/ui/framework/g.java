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
public final class g implements c {
    public d a;
    public final PropertyOwner b;
    public final PropertyOwner c;
    public final eo1.b d;

    public static final class a implements w0 {
        public final /* synthetic */ g a;

        public a(g r1) {
            this.a = r1;
        }

        public final void O6(List<ILinkPlayerInfoBridge> r3) {
            Iterator<T> r0 = this.a.d.l.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((w0) r0.next()).O6(r3);
            goto L4
        }

        public final void Mc(IBaseUser r3, boolean r4) {
            Iterator<T> r0 = this.a.d.l.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((w0) r0.next()).Mc(r3, r4);
            goto L4
        }

        public final void Wk(String r3, boolean r4) {
            Iterator<T> r0 = this.a.d.l.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((w0) r0.next()).Wk(r3, r4);
            goto L4
        }

        public final void f9(String r3, boolean r4) {
            Iterator<T> r0 = this.a.d.l.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((w0) r0.next()).f9(r3, r4);
            goto L4
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final boolean R7() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final boolean V9() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final com.bytedance.android.live.room.l ef() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final boolean isNestedOutside() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final boolean o5() {
        return false;
    }

    public final /* synthetic */ void onAbilityClear() {
        IAbility.-CC.$default$onAbilityClear(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final com.bytedance.android.livesdk.chatroom.ui.framework.utils.e wl() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final Object Ep() {
        return this.d.v;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final d Gg() {
        d r0 = this.a;
        if (r0 != null) goto L6;
        d r1 = ho1.a.i(this.d.d);
        this.a = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final w0 J1() {
        eo1.b r0 = this.d;
        w0 r1 = r0.m;
        if (r1 != null) goto L6;
        a r2 = new a(this);
        r0.m = r2;
        return r2;
    L6:
        return r1;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final List<DialogInterface.OnKeyListener> S5() {
        return this.d.x;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final Bundle Wl() {
        return this.d.a();
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final boolean dg() {
        return this.d.a;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final FragmentManager ea() {
        return this.d.q.getParentFragmentManager();
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final FragmentManager getChildFragmentManager() {
        return this.d.q.getChildFragmentManager();
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final Fragment getFragment() {
        return this.d.q;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final LiveMode getLiveMode() {
        return this.d.i;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final com.bytedance.android.live.pushstream.d getLiveStream() {
        return this.d.t;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final v0 getLiveVideoClientFactory() {
        return this.d.u;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final Room getRoom() {
        return this.d.c();
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final boolean hq() {
        return this.d.e;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final boolean isPortrait() {
        return this.d.a;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final EnterRoomExtra k3() {
        return this.d.h;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final Object ng() {
        return this.d.s;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final FragmentActivity p0() {
        return this.d.q.getActivity();
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final List<View.OnTouchListener> u6() {
        return this.d.w;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final com.bytedance.android.live.room.h.b uq() {
        return this.d.k;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final PropertyOwner Ce() {
        return this.c;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.c
    public final com.bytedance.android.live.core.arch.mvvm.d<Boolean> Qi() {
        return this.b;
    }

    public g(eo1.b r2) {
        Intrinsics.checkNotNullParameter(r2, "interactionContext");
        this.d = r2;
        PropertyOwner<Boolean> r0 = r2.z;
        r0.getClass();
        this.b = r0;
        PropertyOwner<Boolean> r3 = r2.A;
        r3.getClass();
        this.c = r3;
    }
}
