package com.bytedance.android.live.profit.fansclub.widget.entrance.mviview;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profit.fansclub.widget.entrance.mvistate.EntranceAnimState;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.facebook.drawee.drawable.ScalingUtils;
import eu0.m0;
import eu0.n0;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class SingleLiveFansClubMVIView extends FansClubMVIView<m0, n0> {
    @Override // com.bytedance.android.live.profit.fansclub.widget.entrance.mviview.FansClubMVIView
    public final String q() {
        return "/revenue/entrance/ttlive_user_single_live_fans_club_show_anim.webp";
    }

    @Override // com.bytedance.android.live.profit.fansclub.widget.entrance.mviview.FansClubMVIView
    public final boolean r() {
        return true;
    }

    public final void a(com.bytedance.android.anya.dsl.f<m0> r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$bindToParent");
        SingleLiveFansClubMVIView$bindToParent$1 r0 = SingleLiveFansClubMVIView$bindToParent$1.INSTANCE;
        List r5 = r4.a;
        ArrayList r6 = (ArrayList) r5;
        r6.add(new com.bytedance.android.anya.dsl.j(this, r0));
    }

    public final boolean d(com.bytedance.android.anya.a0 r4) {
        Intrinsics.checkNotNullParameter(r4, "e");
        if ((r4 instanceof eu0.o) == false) goto L6;
        Intrinsics.checkNotNullParameter("/revenue/entrance/ttlive_user_join_fan_club_guid_animator.webp", "animPath");
        return true;
    L6:
        if ((r4 instanceof eu0.p) == false) goto L8;
        Intrinsics.checkNotNullParameter("/revenue/entrance/ttlive_user_fansclub_icon_active_guide.webp", "animPath");
        return true;
    L8:
        return false;
    }

    public final void b(com.bytedance.android.anya.k r9, MVIState r10) {
        n0 r12 = (n0) r10;
        Intrinsics.checkNotNullParameter(r9, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r12, "state");
        r0<n0, Boolean> r0 = r12.getShow();
        Object r1 = r9.c.a(r0);
        int r2 = 0;
        if (r1 == null) goto L9;
        r9.b.a.invoke(r0);
        boolean r3 = ((Boolean) r1).booleanValue();
        ViewGroup r4 = this.r;
        if (r3 == false) goto L7;
        int r5 = 0;
    L8:
        r4.setVisibility(r5);
        goto L9
    L7:
        r5 = 8;
    L9:
        com.bytedance.android.anya.internal.r r6 = r12.b;
        KProperty[] r7 = n0.h;
        KProperty r8 = r7[1];
        r6.getClass();
        Object r13 = r9.c.a(r6);
        if (r13 == null) goto L14;
        r9.b.a.invoke(r6);
        int r14 = ((Number) r13).intValue();
        HSImageView r15 = this.n;
        r15.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_INSIDE);
        if (r14 == 0) goto L14;
        Intrinsics.checkNotNullParameter(r15, "$this$bindImage");
        ImageLoader.bindDrawableResource(r15, r14);
    L14:
        com.bytedance.android.anya.internal.r r16 = r12.c;
        KProperty r17 = r7[2];
        r16.getClass();
        Object r18 = r9.c.a(r16);
        if (r18 == null) goto L21;
        r9.b.a.invoke(r16);
        boolean r19 = ((Boolean) r18).booleanValue();
        HSImageView r20 = this.n;
        if (r19 == false) goto L19;
        int r22 = 0;
    L20:
        r20.setVisibility(r22);
        goto L21
    L19:
        r22 = 8;
    L21:
        com.bytedance.android.anya.internal.r r23 = r12.d;
        KProperty r24 = r7[3];
        r23.getClass();
        Object r25 = r9.c.a(r23);
        if (r25 == null) goto L26;
        r9.b.a.invoke(r23);
        int r26 = ((Number) r25).intValue();
        if (r26 == 0) goto L26;
        this.m.setBackground(s1.m(r26));
    L26:
        com.bytedance.android.anya.internal.r r27 = r12.e;
        KProperty r28 = r7[4];
        r27.getClass();
        Object r29 = r9.c.a(r27);
        if (r29 == null) goto L33;
        r9.b.a.invoke(r27);
        boolean r30 = ((Boolean) r29).booleanValue();
        TextView r32 = this.o;
        if (r30 == true) goto L32;
        r2 = 8;
    L32:
        r32.setVisibility(r2);
    L33:
        com.bytedance.android.anya.internal.r r33 = r12.f;
        KProperty r34 = r7[5];
        r33.getClass();
        Object r35 = r9.c.a(r33);
        if (r35 == null) goto L36;
        r9.b.a.invoke(r33);
        int r36 = ((Number) r35).intValue();
        this.o.setText(String.valueOf(r36));
    L36:
        com.bytedance.android.anya.internal.r r110 = r12.g;
        KProperty r37 = r7[6];
        r110.getClass();
        Object r38 = r9.c.a(r110);
        if (r38 == null) goto L43;
        r9.b.a.invoke(r110);
        if (q.a[((EntranceAnimState) r38).ordinal()] == 1) goto L41;
        p();
        return;
    L41:
        t(true);
        return;
    }

    public SingleLiveFansClubMVIView(Context r2, DataCenter r3, ViewGroup r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r4, "containerView");
        if (r5 == false) goto L5;
        int r6 = 2131567563;
    L6:
        super(r2, r3, r4, r6);
        return;
    L5:
        r6 = 2131567562;
        goto L6
    }
}
