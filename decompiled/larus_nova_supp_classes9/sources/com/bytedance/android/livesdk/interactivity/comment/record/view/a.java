package com.bytedance.android.livesdk.interactivity.comment.record.view;

import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.viewmodule.record.RecordDragParentView;
import com.bytedance.android.livesdk.interactivity.comment.record.viewmodel.HighlightRecordContext;
import com.bytedance.android.livesdk.utils.u4;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ LiveHighlightRecordTetris a;

    public a(LiveHighlightRecordTetris r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        Boolean r8 = (Boolean) r7;
        LiveHighlightRecordTetris r9 = this.a;
        LiveHighlightRecordController r0 = r9.r;
        if (r0 == null) goto L16;
        r0.a();
        RecordDragParentView r1 = r0.l;
        View r2 = r1.a;
        if (r2 == null) goto L7;
        r1.removeView(r2);
    L7:
        r1.a = null;
        UtilityKotlinExtentionsKt.t(r0.l);
        r0.b = 0;
        UtilityKotlinExtentionsKt.w(r0.l);
        r0.m.setDragParentView(r0.l);
        HighlightRecordContext r3 = r0.k;
        if (r3 == null) goto L14;
        DataCenter r4 = r3.getDataCenter();
        if (r4 == null) goto L14;
        if (gb2.a.c(r4, true) != true) goto L14;
        r0.l.b(r0.m);
    L15:
        u4.a(r0.i);
        u4.a(r0.j);
    L14:
        RecordDragParentView r5 = r0.l;
        View r6 = r0.m;
        FrameLayout.LayoutParams r10 = new FrameLayout.LayoutParams(-2, -2);
        r10.gravity = 80;
        r10.leftMargin = (s1.y() / 2) - UtilityKotlinExtentionsKt.i(20);
        Unit r11 = Unit.INSTANCE;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "dragView");
        Intrinsics.checkNotNullParameter(r10, "layoutParams");
        r5.addView(r6, r10);
        r5.a = r6;
    L16:
        WeakHandler r13 = r9.w;
        if (r13 == null) goto L24;
        Message r14 = r13.obtainMessage(r9.v, Long.valueOf(SystemClock.uptimeMillis()));
        if (r14 == null) goto L25;
        WeakHandler r15 = r9.w;
        if (r15 == null) goto L26;
        r15.sendMessageDelayed(r14, 10);
        return;
    L26:
        return;
    L25:
        return;
    }
}
