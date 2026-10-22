package com.larus.bmhome.chat.deepresearch.component;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class w implements View.OnLayoutChangeListener {
    public final /* synthetic */ DeepReSearchContentComponent a;

    public w(DeepReSearchContentComponent r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener(this);
        DeepReSearchContentComponent r10 = this.a;
        Map<String, Long> r11 = DeepReSearchContentComponent.M;
        r10.getClass();
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L20
        RecyclerView r13 = r10.B3();     // Catch: Throwable -> L20
        if (r13 == null) goto L28;
        LinearLayoutManager r14 = r13.getLayoutManager();     // Catch: Throwable -> L20
        if ((r14 instanceof LinearLayoutManager) == false) goto L9;
        LinearLayoutManager r15 = r14;     // Catch: Throwable -> L20
    L10:
        if (r15 == null) goto L29;
        RecyclerView.Adapter r16 = r13.getAdapter();     // Catch: Throwable -> L20
        if (r16 == null) goto L30;
        int r17 = r16.getItemCount();     // Catch: Throwable -> L20
        if (r17 == 0) goto L31;
        final Context r18 = r13.getContext();     // Catch: Throwable -> L20
        final long r19 = 120;
        LinearSmoothScroller r20 = new DeepReSearchContentComponent$smoothScrollToBottom$1$scroller$1(r19, r18);     // Catch: Throwable -> L20
        r20.setTargetPosition(r17 - 1);     // Catch: Throwable -> L20
        r15.startSmoothScroll(r20);     // Catch: Throwable -> L20
        Object r21 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        Throwable r22 = Result.exceptionOrNull-impl(r21);
        if (r22 == null) goto L32;
        FLogger.a.i("DeepSearchContent", r22.toString());
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L9:
        r15 = null;
        goto L10
    L28:
        return;
    L20:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r21 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    }
}
