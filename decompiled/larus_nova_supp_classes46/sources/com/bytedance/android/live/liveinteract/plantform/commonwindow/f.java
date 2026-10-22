package com.bytedance.android.live.liveinteract.plantform.commonwindow;

import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkFirstUserViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkPCLandscapeViewBinder;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;
import uf2.m1;
import uf2.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements Runnable {
    public final /* synthetic */ CommonLinkSeatWindowView a;
    public final /* synthetic */ z.a b;
    public final /* synthetic */ String c;
    public final /* synthetic */ int d;
    public final /* synthetic */ m.d e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ boolean g;
    public final /* synthetic */ boolean h;

    public f(CommonLinkSeatWindowView r1, z.a r2, String r3, int r4, m.d r5, boolean r6, boolean r7, boolean r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }

    public final void a() {
        z.a r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(this.c, tc0.c.h().f()) == false) goto L7;
        CommonLinkSeatWindowView.Y5(this.a, r0);
    L7:
        LinkMicRecyclerView r1 = this.a.getRecyclerView();
        Integer r2 = null;
        if (r1 == null) goto L10;
        RecyclerView.ViewHolder r3 = r1.findViewHolderForAdapterPosition(this.d);
    L11:
        int r4 = 0;
        if (r3 != null) goto L22;
        ConstraintLayout.LayoutParams r5 = this.a.getCurRvLayoutParams();
        if (r5 == null) goto L16;
        int r6 = ((ViewGroup.MarginLayoutParams) r5).width;
    L17:
        ConstraintLayout.LayoutParams r7 = this.a.getCurRvLayoutParams();
        if (r7 == null) goto L20;
        r4 = ((ViewGroup.MarginLayoutParams) r7).height;
    L20:
        float r8 = this.a.getLayoutConfig().s(r6, r4);
        double r9 = this.e.e();
        m.c r10 = this.a.getLayoutConfig().d();
        Intrinsics.checkNotNull(r10);
        double r11 = r9 / ((double) r10.c());
        this.e.f();
        m.c r12 = this.a.getLayoutConfig().d();
        Intrinsics.checkNotNull(r12);
        r12.b();
        float r13 = ((int) (((double) r6) * r11)) / r6;
        r4 = (int) r8;
    L44:
        if (this.f == false) goto L46;
        boolean r14 = this.g;
    L46:
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r15 = ILiveWrappedLivePusher.a.b();
        if (r15 == null) goto L51;
        m1.b r16 = r15.newVideoMixerDescription(null);
        if (r16 == null) goto L51;
        CommonLinkSeatWindowView r17 = this.a;
        boolean r18 = this.h;
        int r19 = CommonLinkSeatWindowView.D;
        r17.getClass();
        CommonLinkSeatWindowView.Z5(r18, r13, r4);
        r16.e();
        r16.b();
        r16.c();
        r16.f();
        r16.i();
        r16.g();
        this.e.getClass();
        r16.h();
    L52:
        int r20 = com.bytedance.android.live.liveinteract.linkcast.a.a;
        boolean r21 = this.h;
        m r22 = this.a.getLayoutConfig();
        if (r22 == null) goto L55;
        Integer r23 = Integer.valueOf(r22.getUiLayout());
    L56:
        com.bytedance.android.live.liveinteract.linkcast.a.C0037a.b(r16, r21, r23.intValue());
        int r24 = pi0.a.a;
        DataCenter r25 = this.a.getMDataCenter();
        boolean r26 = this.h;
        m r27 = this.a.getLayoutConfig();
        if (r27 == null) goto L59;
        r2 = Integer.valueOf(r27.getUiLayout());
    L59:
        pi0.a.b(r25, r16, r26, r2.intValue());
        CommonLinkSeatWindowView r28 = this.a;
        z.a r29 = this.b;
        String r30 = this.c;
        int r31 = this.d;
        int r32 = CommonLinkSeatWindowView.D;
        r28.b6(r29, r16, r30, r31);
        return;
    L55:
        r23 = null;
    L51:
        r16 = null;
        goto L52
    L16:
        r6 = 0;
        goto L17
    L22:
        if ((r3 instanceof MultiLinkGuestViewBinder.ItemViewHolder) == false) goto L24;
    L29:
        float r33 = r3.itemView.getX();
        RecyclerView r34 = this.a.getRecyclerView();
        if (r34 == null) goto L32;
        float r35 = r34.getWidth();
    L33:
        r13 = r33 / r35;
        r3.itemView.getY();
        RecyclerView r36 = this.a.getRecyclerView();
        if (r36 == null) goto L36;
        r36.getHeight();
    L36:
        r3.itemView.getX();
        r3.itemView.getWidth();
        RecyclerView r37 = this.a.getRecyclerView();
        if (r37 == null) goto L39;
        r37.getWidth();
    L39:
        r3.itemView.getY();
        r3.itemView.getHeight();
        RecyclerView r38 = this.a.getRecyclerView();
        if (r38 == null) goto L42;
        r38.getHeight();
    L42:
        r4 = r3.itemView.getHeight();
        goto L44
    L32:
        r35 = 1.0f;
        goto L33
    L24:
        if ((r3 instanceof MultiLinkPCLandscapeViewBinder.ItemViewHolder) == true) goto L29;
        if ((r3 instanceof MultiLinkFirstUserViewBinder.ItemViewHolder) == true) goto L29;
        r13 = 0.0f;
        goto L44
    L10:
        r3 = null;
        goto L11
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
