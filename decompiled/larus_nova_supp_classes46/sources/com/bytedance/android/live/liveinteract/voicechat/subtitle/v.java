package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v implements Runnable {
    public final /* synthetic */ u a;

    public v(u r1) {
        this.a = r1;
    }

    public final void a() {
        u r0 = this.a;
        LinearLayoutManager r1 = r0.a;
        LinkmicSubtitleAdapter r2 = r0.b;
        if (r1 == null) goto L106;
        if (r2 == null) goto L107;
        int r3 = w.a;
        SubtitleRecyclerView r4 = r0.h;
        Intrinsics.checkNotNullParameter(r1, "layoutManager");
        Intrinsics.checkNotNullParameter(r4, "recyclerView");
        Intrinsics.checkNotNullParameter(r2, "adapter");
        boolean r7 = true;
        String r9 = null;
        if (r1.getChildCount() == 0) goto L25;
        View r6 = r1.getChildAt(r1.getChildCount() - 1);
        if (r6 == null) goto L25;
        int r10 = r1.getPosition(r6);
        if (r10 >= (r2.getItemCount() - 1)) goto L25;
        AppCompatTextView r11 = (SubtitleTextView) r6.findViewById(2131387625);
        if (Intrinsics.areEqual(((nj0.g) ListProtector.get(r2.a, r10)).b, ((nj0.g) ListProtector.get(r2.a, r10 + 1)).b) == false) goto L25;
        if ((r6.getHeight() - r11.getHeight()) <= q.a) goto L25;
        if ((r6 instanceof ConstraintLayout) == true) goto L19;
        r6 = null;
    L19:
        ConstraintLayout r8 = (ConstraintLayout) r6;
        if (r8 == null) goto L24;
        ViewGroup.LayoutParams r12 = r8.getLayoutParams();
        if (r12 == null) goto L24;
        r12.height = r11.getHeight();
    L24:
        r4.requestLayout();
        boolean r5 = true;
    L26:
        if (r5 == true) goto L115;
        RecyclerView r13 = this.a.h;
        Intrinsics.checkNotNullParameter(r1, "layoutManager");
        Intrinsics.checkNotNullParameter(r13, "recyclerView");
        Intrinsics.checkNotNullParameter(r2, "adapter");
        if (r1.getChildCount() == 0) goto L41;
        View r14 = r1.getChildAt(r1.getChildCount() - 1);
        if (r14 == null) goto L41;
        int r15 = r1.getPosition(r14);
        if (r15 >= (r2.getItemCount() - 1)) goto L37;
    L35:
        boolean r16 = true;
    L42:
        if (r16 == false) goto L108;
        h0<Boolean> r17 = this.a.c;
        Boolean r18 = Boolean.FALSE;
        if (Intrinsics.areEqual(r17.a(r18), r18) == false) goto L109;
        u r19 = this.a;
        r19.c.b(Boolean.TRUE);
        int r20 = r1.getChildCount();
        if (r20 == 0) goto L56;
        int r21 = 0;
    L49:
        if (r21 >= r20) goto L56;
        View r110 = r1.getChildAt(r21);
        if (r110 == null) goto L55;
        if (r110.getBottom() <= q.a) goto L55;
    L57:
        if (r110 == null) goto L110;
        int r22 = r1.getPosition(r110);
        SubtitleRecyclerView r23 = r19.h;
        if (r23 == null) goto L61;
        RecyclerView.ViewHolder r24 = r23.findViewHolderForAdapterPosition(r22);
    L63:
        if ((r24 instanceof LinkmicSubtitleViewHolder) == true) goto L65;
        r24 = null;
    L65:
        LinkmicSubtitleViewHolder r25 = (LinkmicSubtitleViewHolder) r24;
        RecyclerView r26 = r19.h;
        if (r26 == null) goto L89;
        int r27 = u.l;
        LinearLayoutManager r28 = r19.a;
        LinkmicSubtitleAdapter r111 = r19.b;
        if (r28 == null) goto L88;
        if (r26 == null) goto L88;
        if (r111 == null) goto L88;
        int r112 = w.a;
        Intrinsics.checkNotNullParameter(r28, "layoutManager");
        Intrinsics.checkNotNullParameter(r26, "recyclerView");
        Intrinsics.checkNotNullParameter(r111, "adapter");
        if (r28.getChildCount() == 0) goto L87;
        View r29 = r28.getChildAt(r28.getChildCount() - 1);
        if (r29 == null) goto L88;
        int r30 = r28.getPosition(r29);
        ALogger.d("hjl-test", "lastViewIndex=" + r30 + ", adapterItemCount=" + r111.getItemCount());
        if (r30 >= (r111.getItemCount() - 1)) goto L80;
        r27 = r29.getBottom();
        goto L88
    L80:
        if (r30 != (r111.getItemCount() - 1)) goto L88;
        if ((r29.getBottom() - r26.getHeight()) > q.a) goto L85;
        r7 = false;
    L85:
        if (r7 == true) goto L88;
    L87:
        r27 = 0;
    L88:
        ALogger.d("hjl-test", "getScrollY=" + r27);
        r26.smoothScrollBy(0, r27, null);
    L89:
        LinkmicSubtitleAdapter r31 = r19.b;
        if (r31 == null) goto L111;
        CopyOnWriteArrayList<nj0.g> r32 = r31.a;
        if (r32 == null) goto L112;
        nj0.g r33 = (nj0.g) CollectionsKt.last(r32);
        if (r33 == null) goto L113;
        TextView r34 = r19.i;
        if (r34 == null) goto L114;
        IBaseUser r35 = r33.a;
        if (r35 == null) goto L100;
        r9 = r35.getRealNickName();
    L100:
        r34.setText(r9);
        return;
    L114:
        return;
    L113:
        return;
    L112:
        return;
    L111:
        return;
    L61:
        r24 = null;
        goto L63
    L110:
        return;
    L55:
        r21 = r21 + 1;
    L56:
        r110 = null;
        goto L57
    L109:
        return;
    L108:
        return;
    L37:
        if (r15 != (r2.getItemCount() - 1)) goto L41;
        if ((r14.getBottom() - r13.getHeight()) > q.a) goto L35;
    L41:
        r16 = false;
        goto L42
    L115:
        return;
    L25:
        r5 = false;
        goto L26
    L107:
        return;
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
