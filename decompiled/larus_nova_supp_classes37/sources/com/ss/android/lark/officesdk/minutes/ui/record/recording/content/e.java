package com.ss.android.lark.officesdk.minutes.ui.record.recording.content;

import android.view.View;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e implements Runnable {
    public final /* synthetic */ MmRecordingContentController a;
    public final /* synthetic */ String b;

    public static final class a implements Runnable {
        public final /* synthetic */ MmRecordingContentController a;
        public final /* synthetic */ String b;

        public a(MmRecordingContentController r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            if (this.a.a.b().isAttachedToWindow() == true) goto L6;
            this.a.k = false;
            int r1 = bwb.b.a;
            bwb.b.f(MmUiLogScene.CONTENT, "scheduleRelayoutFix", "skip detached pager(second post), reason=" + this.b, this.a.c());
            return;
        L6:
            MmRecordingContentController r2 = this.a;
            r2.k = false;
            String r3 = this.b;
            if (r2.j == false) goto L68;
            ViewPager2 r4 = r2.a.b();
            if (r4.getScrollState() == 0) goto L13;
            int r5 = bwb.b.a;
            bwb.b.f(MmUiLogScene.CONTENT, "tryFixPagerMisalignment", "skip non-idle, reason=" + r3 + ", state=" + r4.getScrollState(), r2.c());
            return;
        L13:
            if (r4.getWidth() > 0) goto L15;
        L58:
            int r6 = bwb.b.a;
            bwb.b.f(MmUiLogScene.CONTENT, "tryFixPagerMisalignment", "skip invalid size, reason=" + r3 + ", width=" + r4.getWidth() + ", height=" + r4.getHeight(), r2.c());
            r2.j = false;
            return;
        L15:
            if (r4.getHeight() <= 0) goto L58;
            RecyclerView r7 = r4.getChildAt(0);
            Integer r8 = null;
            if ((r7 instanceof RecyclerView) == false) goto L20;
            RecyclerView r9 = r7;
        L21:
            if (r9 != null) goto L23;
            int r10 = bwb.b.a;
            bwb.b.h(MmUiLogScene.CONTENT, "tryFixPagerMisalignment", "skip recyclerView null, reason=" + r3, r2.c());
            r2.j = false;
            return;
        L23:
            int r11 = r4.getCurrentItem();
            RecyclerView.ViewHolder r12 = r9.findViewHolderForAdapterPosition(r11);
            if (r12 == null) goto L28;
            View r13 = r12.itemView;
            if (r13 == null) goto L28;
            r8 = Integer.valueOf(r13.getLeft());
        L28:
            int r14 = r9.getPaddingLeft();
            int r15 = r9.getWidth() - r9.getPaddingRight();
            Iterator r16 = ViewGroupKt.getChildren(r9).iterator();
        L30:
            if (r16.hasNext() == false) goto L47;
            View r17 = (View) r16.next();
            RecyclerView.ViewHolder r18 = r9.getChildViewHolder(r17);
            if (r18.getBindingAdapterPosition() != (-1)) goto L34;
        L44:
            boolean r19 = false;
        L45:
            if (r19 == false) goto L30;
            boolean r20 = true;
        L48:
            if (r8 != null) goto L50;
        L51:
            if (r20 == false) goto L53;
        L52:
            boolean r110 = true;
        L54:
            int r21 = bwb.b.a;
            bwb.b.f(MmUiLogScene.CONTENT, "tryFixPagerMisalignment", "reason=" + r3 + ", currentItem=" + r11 + ", currentLeft=" + r8 + ", hasAdjacentVisiblePage=" + r20 + ", isMisaligned=" + r110, r2.c());
            r2.j = false;
            if (r110 == false) goto L69;
            r4.setCurrentItem(r11, false);
            return;
        L69:
            return;
        L53:
            r110 = false;
            goto L54
        L50:
            if (r8.intValue() != 0) goto L52;
        L34:
            if (r18.getBindingAdapterPosition() == r11) goto L44;
            if (r17.getVisibility() != 0) goto L44;
            if (r17.getWidth() <= 0) goto L44;
            if (r17.getRight() <= r14) goto L44;
            if (r17.getLeft() >= r15) goto L44;
            r19 = true;
            goto L45
        L47:
            r20 = false;
            goto L48
        L20:
            r9 = null;
            goto L21
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

    public e(MmRecordingContentController r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        if (this.a.a.b().isAttachedToWindow() == true) goto L6;
        this.a.k = false;
        int r0 = bwb.b.a;
        bwb.b.f(MmUiLogScene.CONTENT, "scheduleRelayoutFix", "skip detached pager(first post), reason=" + this.b, this.a.c());
        return;
    L6:
        this.a.a.b().post(new a(this.a, this.b));
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
