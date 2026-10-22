package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.MmSubtitleScrollMode;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class m implements Runnable {
    public final /* synthetic */ MmSubtitleFragment a;
    public final /* synthetic */ int b;
    public final /* synthetic */ com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.l c;
    public final /* synthetic */ com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h d;
    public final /* synthetic */ mwb.i e;

    public static final class a implements Runnable {
        public final /* synthetic */ mwb.i a;
        public final /* synthetic */ MmSubtitleFragment b;

        public a(mwb.i r1, MmSubtitleFragment r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            boolean r0 = !this.a.b.canScrollVertically(1);
            int r1 = 0;
            if (r0 == false) goto L8;
            this.b.ga0().dispatchEvent(new y.c(MmSubtitleScrollMode.FOLLOW));
            w r2 = this.b.v;
            if (r2 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("stackFromEndController");
            r2 = null;
        L7:
            r2.e(false, "goToSubtitleReachBottom");
        L8:
            UDShadowLayout r3 = this.a.d;
            if (r0 == false) goto L11;
            r1 = 8;
        L11:
            r3.setVisibility(r1);
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

    public m(MmSubtitleFragment r1, int r2, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.l r3, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h r4, mwb.i r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void a() {
        MmSubtitleFragment r1 = this.a;
        if (r1.m != null) goto L5;
        return;
    L5:
        if (r1.o == null) goto L74;
        int r2 = this.b;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.l r3 = this.c;
        if ((r3 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.l.b) == false) goto L11;
        String r4 = "relativeTime=" + ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.l.b) r3).a;
    L13:
        mwb.i r5 = r1.m;
        if (r5 == null) goto L53;
        final RecyclerView r6 = r5.b;
        LinearLayoutManager r7 = r1.o;
        if (r7 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        r7 = null;
    L19:
        int r8 = r7.findFirstVisibleItemPosition();
        LinearLayoutManager r9 = r1.o;
        if (r9 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        r9 = null;
    L22:
        int r10 = r9.findLastVisibleItemPosition();
        if (r8 == (-1)) goto L31;
        if (r10 == (-1)) goto L31;
        if (r8 > r2) goto L28;
        if (r2 > r10) goto L28;
        boolean r11 = true;
    L29:
        if (r11 == false) goto L31;
        boolean r12 = true;
    L33:
        if (r12 == false) goto L35;
        int r13 = bwb.b.a;
        bwb.b.f(MmUiLogScene.SUBTITLE, "goToSubtitle", "target visible, skip scroll, targetPosition=" + r2 + ", firstVisible=" + r8 + ", lastVisible=" + r10 + ", request=" + r4, r1.U90());
        goto L53
    L35:
        int r14 = RangesKt.coerceAtLeast((r6.getHeight() - r6.getPaddingTop()) - r6.getPaddingBottom(), 0);
        Iterator r15 = SequencesKt.mapNotNull(CollectionsKt.asSequence(RangesKt.until(0, r6.getChildCount())), new MmSubtitleFragment$calculateSubtitleCenterOffset$visibleItemHeight$1(r6)).iterator();
    L37:
        if (r15.hasNext() == false) goto L44;
        Object r16 = r15.next();
        if (((View) r16).getHeight() <= 0) goto L41;
        boolean r17 = true;
    L42:
        if (r17 == false) goto L37;
    L45:
        View r18 = (View) r16;
        if (r18 == null) goto L48;
        int r19 = r18.getHeight();
    L49:
        int r20 = r6.getPaddingTop() + RangesKt.coerceAtLeast((r14 - r19) / 2, 0);
        int r21 = bwb.b.a;
        bwb.b.f(MmUiLogScene.SUBTITLE, "goToSubtitle", "scroll to center, targetPosition=" + r2 + ", firstVisible=" + r8 + ", lastVisible=" + r10 + ", offset=" + r20 + ", request=" + r4, r1.U90());
        LinearLayoutManager r22 = r1.o;
        if (r22 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        r22 = null;
    L52:
        r22.scrollToPositionWithOffset(r2, r20);
        goto L53
    L48:
        r19 = 0;
        goto L49
    L41:
        r17 = false;
        goto L42
    L44:
        r16 = null;
    L28:
        r11 = false;
    L31:
        r12 = false;
    L53:
        MmSubtitleAdapter r23 = this.a.n;
        if (r23 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("subtitleAdapter");
        MmSubtitleAdapter r24 = null;
    L57:
        long r25 = this.d.a;
        Long r26 = r24.l;
        r24.l = Long.valueOf(r25);
        r24.z2(r26);
        r24.z2(Long.valueOf(r25));
        RecyclerView r27 = r24.k;
        if (r27 == null) goto L64;
        f r28 = r24.n;
        if (r28 == null) goto L63;
        r27.removeCallbacks(r28);
    L63:
        f r29 = new f(r24, r25);
        r27.postDelayed(r29, 1200);
        r24.n = r29;
    L64:
        mwb.i r30 = this.e;
        r30.b.post(new a(r30, this.a));
        return;
    L56:
        r24 = r23;
        goto L57
    L11:
        if ((r3 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.l.a) == false) goto L67;
        StringBuilder r31 = new StringBuilder("absTime=");
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.l.a r32 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.l.a) r3;
        r31.append(r32.a);
        r31.append(",useNearest=");
        r31.append(r32.b);
        r4 = r31.toString();
        goto L13
    L67:
        throw new NoWhenBranchMatchedException();
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
