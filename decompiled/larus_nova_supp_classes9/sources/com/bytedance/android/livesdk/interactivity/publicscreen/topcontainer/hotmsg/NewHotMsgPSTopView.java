package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.hotmsg;

import android.widget.FrameLayout;
import com.bytedance.android.live.base.model.message.i;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.CleanStrategy;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.ConflictStrategy;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.DiscardReason;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.NativePSTopViewType;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.PSTopContainer;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.u4;
import com.bytedance.android.livesdkapi.message.HighlightAreaPriorityConfig;
import f52.j;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class NewHotMsgPSTopView extends j<i> {
    public HighlightAreaPriorityConfig n;
    public q4.b o;
    public q4.b p;
    public boolean q;
    public final NewHotMsgView r;

    @Override // f52.j, f52.c
    public final HighlightAreaPriorityConfig c() {
        return this.n;
    }

    @Override // f52.c
    public final void a(DiscardReason r3) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        n("onDiscard. reason=" + r3);
        this.r.e();
    }

    @Override // f52.c
    public final void h(final f52.b r4) {
        Intrinsics.checkNotNullParameter(r4, "container");
        n("onShow. id=" + this.a);
        if (this.r.getParent() != null) goto L5;
        r4.b(this, this.r, new FrameLayout.LayoutParams(-1, -1));
    L5:
        this.r.g((i) this.m);
        this.r.setFinishAction(new NewHotMsgPSTopView$onShow$1(this, r4));
        UtilityKotlinExtentionsKt.u(this.r);
        q4.b r0 = u4.c(new NewHotMsgPSTopView$onShow$2(this, r4));
        r0.c();
        this.o = r0;
        o r5 = r4.getRoomContext();
        if (r5 == null) goto L9;
        r5.M2(Boolean.TRUE);
        return;
    }

    @Override // f52.c
    public final CleanStrategy i(f52.b r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        n("onShowFinish. id=" + this.a);
        this.o = null;
        this.p = null;
        return CleanStrategy.NONE;
    }

    @Override // f52.j, f52.c
    public final boolean j(f52.c r6) {
        Intrinsics.checkNotNullParameter(r6, "view");
        if ((r6 instanceof NewHotMsgPSTopView) == true) goto L5;
    L12:
        boolean r0 = false;
    L13:
        n("can assemble:" + r0 + ", view.id = " + r6.getId() + ",cur id = " + this.a + ", switchDuration = " + ((i) this.m).b);
        return r0;
    L5:
        if (Intrinsics.areEqual(r6.getId(), this.a) == false) goto L12;
        Long r1 = ((i) this.m).b;
        if (r1 == null) goto L12;
        if (r1.longValue() != 0) goto L12;
        r0 = true;
        goto L13
    }

    public final void n(String r2) {
        ALogger.i("NewHotMsgViewManager", r2);
    }

    public NewHotMsgPSTopView(i r18, NewHotMsgView r19) {
        Intrinsics.checkNotNullParameter(r18, "hotWord");
        Intrinsics.checkNotNullParameter(r19, "hotMsgView");
        super(String.valueOf(r18.a), NativePSTopViewType.NewHotMsg, 0, Integer.MAX_VALUE, 0, 0, 0, ConflictStrategy.DISCARD, ConflictStrategy.QUEUE, ConflictStrategy.INTERRUPT, true, null, r18, 2048);
        this.r = r19;
    }

    @Override // f52.c
    public final CleanStrategy b(f52.b r2, f52.c r3) {
        Intrinsics.checkNotNullParameter(r2, "container");
        n("onInterrupt. id=" + this.a);
        this.q = true;
        q4.b r4 = this.o;
        if (r4 == null) goto L5;
        r4.a();
        this.o = null;
    L5:
        q4.b r5 = this.p;
        if (r5 == null) goto L8;
        r5.a();
        this.p = null;
    L8:
        this.r.e();
        o r6 = r2.getRoomContext();
        if (r6 == null) goto L12;
        r6.M2(Boolean.FALSE);
    L12:
        return CleanStrategy.NONE;
    }

    @Override // f52.j, f52.c
    public final void e(f52.c r2, PSTopContainer r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "container");
        n("onAssemble. id=" + this.a + " newId=" + r2.getId());
        if ((r2 instanceof NewHotMsgPSTopView) == false) goto L10;
        NewHotMsgView r4 = this.r;
        i r5 = (i) ((NewHotMsgPSTopView) r2).m;
        if (r5 == null) goto L7;
        ((ArrayList) r4.b).add(r5);
    L8:
        NewHotMsgView.c("appendWaitingList: " + ((ArrayList) r4.b).size());
        return;
    L7:
        r4.getClass();
        goto L8
    }
}
