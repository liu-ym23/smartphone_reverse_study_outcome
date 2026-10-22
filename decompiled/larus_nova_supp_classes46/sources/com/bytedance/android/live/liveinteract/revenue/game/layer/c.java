package com.bytedance.android.live.liveinteract.revenue.game.layer;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ch0.e;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.revenue.game.LinkMicGameContext;
import com.bytedance.android.livesdk.message.model.rm;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tf0.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends jg0.b<MultiLinkGuestViewBinder.a> {
    public View d;
    public TextView e;
    public boolean f;
    public boolean g;
    public MultiLinkGuestViewBinder.a h;
    public final com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.a i;

    public static final class a implements Runnable {
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ TextView b;

        public a(ViewGroup r1, TextView r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            int r0 = this.a.getWidth();
            ViewGroup.LayoutParams r1 = this.b.getLayoutParams();
            if (r1 == null) goto L11;
            int r2 = ((ViewGroup.MarginLayoutParams) r1).getMarginStart();
            ViewGroup.LayoutParams r3 = this.b.getLayoutParams();
            if (r3 == null) goto L9;
            int r4 = r2 + ((ViewGroup.MarginLayoutParams) r3).getMarginEnd();
            ALogger.d("MultiLinkGameGuestBusinessLayer", "parentWidth:" + r0 + ", margins: " + r4);
            this.b.setMaxWidth(r0 - r4);
            return;
        L9:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        L11:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
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

    @Override // jg0.b
    public final int b() {
        return 2131566267;
    }

    @Override // jg0.f
    public final void onDetach() {
    }

    public final void g() {
        StringBuilder r0 = new StringBuilder("ensureVisibility user: ");
        MultiLinkGuestViewBinder.a r1 = this.h;
        if (r1 == null) goto L11;
        e r2 = r1.k;
        if (r2 == null) goto L11;
        ILinkPlayerInfoBridge r3 = r2.a;
        if (r3 == null) goto L11;
        IBaseUser r4 = r3.getUser();
        if (r4 == null) goto L11;
        String r5 = r4.getNickName();
    L12:
        r0.append(r5);
        r0.append(", isShowingScore:");
        r0.append(this.f);
        r0.append(", isWatchingGame: ");
        r0.append(this.g);
        ALogger.d("MultiLinkGameGuestBusinessLayer", r0.toString());
        if (this.f == false) goto L16;
        UIUtils.setViewVisibility(this.d, 8);
        UIUtils.setViewVisibility(this.e, 0);
        return;
    L16:
        if (this.g == false) goto L18;
        UIUtils.setViewVisibility(this.d, 8);
        UIUtils.setViewVisibility(this.e, 0);
        return;
    L18:
        UIUtils.setViewVisibility(this.d, 0);
        UIUtils.setViewVisibility(this.e, 8);
        return;
    L11:
        r5 = null;
        goto L12
    }

    public final void h() {
        LinkMicGameContext.a r0 = LinkMicGameContext.Companion;
        LinkMicGameContext r1 = r0.getContext();
        CharSequence r2 = null;
        if (r1 == null) goto L5;
        List<rm.b> r3 = r1.getGameScores();
    L7:
        if (r0.e() == false) goto L41;
        if (r3 == null) goto L41;
        if ((!r3.isEmpty()) == false) goto L41;
        Iterator<T> r4 = r3.iterator();
    L13:
        if (r4.hasNext() == false) goto L27;
        Object r5 = r4.next();
        String r6 = ((rm.b) r5).joinUid;
        MultiLinkGuestViewBinder.a r7 = this.h;
        if (r7 == null) goto L23;
        e r8 = r7.k;
        if (r8 == null) goto L23;
        ILinkPlayerInfoBridge r9 = r8.a;
        if (r9 == null) goto L23;
        IBaseUser r10 = r9.getUser();
        if (r10 == null) goto L23;
        String r11 = r10.getIdString();
    L25:
        if (Intrinsics.areEqual(r6, r11) == false) goto L13;
    L28:
        rm.b r12 = (rm.b) r5;
        if (r12 != null) goto L31;
    L37:
        TextView r13 = this.e;
        if (r13 == null) goto L40;
        r13.setText("观战中");
    L40:
        this.f = false;
        this.g = true;
    L42:
        StringBuilder r14 = new StringBuilder("updateGameScore user: ");
        MultiLinkGuestViewBinder.a r15 = this.h;
        if (r15 == null) goto L51;
        e r16 = r15.k;
        if (r16 == null) goto L51;
        ILinkPlayerInfoBridge r17 = r16.a;
        if (r17 == null) goto L51;
        IBaseUser r18 = r17.getUser();
        if (r18 == null) goto L51;
        String r19 = r18.getNickName();
    L52:
        r14.append(r19);
        r14.append(", isShowingScore:");
        r14.append(this.f);
        r14.append(", isWatchingGame: ");
        r14.append(this.g);
        r14.append(", score: ");
        TextView r20 = this.e;
        if (r20 == null) goto L55;
        r2 = r20.getText();
    L55:
        r14.append(r2);
        ALogger.d("MultiLinkGameGuestBusinessLayer", r14.toString());
        g();
        return;
    L51:
        r19 = null;
        goto L52
    L31:
        if (r12.joinGame == false) goto L37;
        TextView r21 = this.e;
        if (r21 == null) goto L36;
        r21.setText("积分 " + r12.score);
    L36:
        this.f = true;
        this.g = false;
    L23:
        r11 = null;
        goto L25
    L27:
        r5 = null;
    L41:
        this.f = false;
        this.g = false;
        goto L42
    L5:
        r3 = null;
        goto L7
    }

    @Override // jg0.b, jg0.f
    public final void a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super.a(r3);
        this.d = this.i.m(2131389577);
        ViewGroup r4 = this.a;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("root");
    L5:
        if (r4 == null) goto L7;
        TextView r5 = (TextView) r4.findViewById(2131389579);
    L8:
        this.e = r5;
        ViewGroup r6 = this.a;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("root");
    L11:
        TextView r0 = this.e;
        if (r6 == null) goto L16;
        if (r0 == null) goto L17;
        r6.post(new a(r6, r0));
        return;
    L17:
        return;
    L16:
        return;
    L7:
        r5 = null;
        goto L8
    }

    @Override // jg0.f
    public final void d(Object r1, int r2) {
        MultiLinkGuestViewBinder.a r3 = (MultiLinkGuestViewBinder.a) r1;
        Intrinsics.checkNotNullParameter(r3, "itemData");
        this.h = r3;
        StringBuilder r4 = new StringBuilder("onBind user: ");
        MultiLinkGuestViewBinder.a r5 = this.h;
        if (r5 == null) goto L11;
        e r6 = r5.k;
        if (r6 == null) goto L11;
        ILinkPlayerInfoBridge r7 = r6.a;
        if (r7 == null) goto L11;
        IBaseUser r8 = r7.getUser();
        if (r8 == null) goto L11;
        String r9 = r8.getNickName();
    L12:
        r4.append(r9);
        ALogger.d("MultiLinkGameGuestBusinessLayer", r4.toString());
        if (LinkMicGameContext.Companion.e() == true) goto L15;
    L18:
        UIUtils.setViewVisibility(this.e, 8);
        return;
    L15:
        if (this.b != 0) goto L18;
        h();
        return;
    L11:
        r9 = null;
        goto L12
    }

    public c(MicSeatScene r2, com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.a r3, xg0.a r4) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "basicLayer");
        Intrinsics.checkNotNullParameter(r4, "linkSeatAbilityProvider");
        super(r4);
        this.i = r3;
    }

    @Override // jg0.b, jg0.d
    public final void e(int r1, p r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        if (Intrinsics.areEqual(r2, ti0.a.b) == false) goto L16;
        StringBuilder r4 = new StringBuilder("UpdateGameScore user: ");
        MultiLinkGuestViewBinder.a r5 = this.h;
        if (r5 == null) goto L13;
        e r6 = r5.k;
        if (r6 == null) goto L13;
        ILinkPlayerInfoBridge r7 = r6.a;
        if (r7 == null) goto L13;
        IBaseUser r8 = r7.getUser();
        if (r8 == null) goto L13;
        String r9 = r8.getNickName();
    L14:
        r4.append(r9);
        ALogger.d("MultiLinkGameGuestBusinessLayer", r4.toString());
        h();
        return;
    L13:
        r9 = null;
        goto L14
    }

    @Override // jg0.f
    public final void k(Object r1, int r2, Bundle r3) {
        MultiLinkGuestViewBinder.a r4 = (MultiLinkGuestViewBinder.a) r1;
        Intrinsics.checkNotNullParameter(r4, "itemData");
        Intrinsics.checkNotNullParameter(r3, "payload");
        this.h = r4;
        StringBuilder r5 = new StringBuilder("onBindPayload user: ");
        MultiLinkGuestViewBinder.a r6 = this.h;
        if (r6 == null) goto L11;
        e r7 = r6.k;
        if (r7 == null) goto L11;
        ILinkPlayerInfoBridge r8 = r7.a;
        if (r8 == null) goto L11;
        IBaseUser r9 = r8.getUser();
        if (r9 == null) goto L11;
        String r10 = r9.getNickName();
    L12:
        r5.append(r10);
        ALogger.d("MultiLinkGameGuestBusinessLayer", r5.toString());
        if (LinkMicGameContext.Companion.e() == true) goto L15;
        return;
    L15:
        if (this.b != 0) goto L20;
        g();
        return;
    L20:
        return;
    L11:
        r10 = null;
        goto L12
    }
}
