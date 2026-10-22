package qa2;

import android.view.ViewGroup;
import com.bytedance.android.live.base.model.message.g3;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.CleanStrategy;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.ConflictStrategy;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.DiscardReason;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.NativePSTopViewType;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.ConfrontMsgView;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.GroupMsgView;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.HotMsgType;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.MatchLogHelper;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.concurrent.PriorityBlockingQueue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends f52.j<g3> {
    public ConfrontMsgView n;
    public long o;
    public boolean p;
    public final ViewGroup q;
    public final a r;

    @Override // f52.c
    public final void a(DiscardReason r3) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("MatchConfrontPSTopView onDiscard. id=" + this.a + " reason=" + r3);
    }

    @Override // f52.c
    public final void h(f52.b r5) {
        Intrinsics.checkNotNullParameter(r5, "container");
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("MatchConfrontPSTopView onShow. id=" + this.a);
        this.r.a(this);
        this.q.removeAllViews();
        ConfrontMsgView r0 = this.n;
        if (r0 == null) goto L5;
        r0.c();
    L5:
        g3 r3 = null;
        ConfrontMsgView r1 = new ConfrontMsgView(this.q.getContext(), null, 0);
        this.n = r1;
        this.q.addView(r1, 1, 1);
        r1.setOnClickListener(c.a);
        r1.setManagerCallBack(new b(this, r5));
        PriorityBlockingQueue<g3> r6 = ra2.b.a;
        if (r6 == null) goto L8;
        g3 r7 = r6.poll();
    L9:
        PriorityBlockingQueue<g3> r2 = ra2.b.b;
        if (r2 == null) goto L12;
        r3 = r2.poll();
    L12:
        ra2.b.c = r7;
        ra2.b.d = r3;
        GroupMsgView r4 = r1.b;
        if (r4 == null) goto L15;
        r4.j(r7);
    L15:
        GroupMsgView r8 = r1.c;
        if (r8 == null) goto L18;
        r8.j(r3);
    L18:
        r1.b();
        GroupMsgView r9 = r1.b;
        if (r9 == null) goto L21;
        r9.k();
    L21:
        GroupMsgView r10 = r1.c;
        if (r10 == null) goto L25;
        r10.k();
        return;
    L25:
        return;
    L8:
        r7 = null;
        goto L9
    }

    @Override // f52.c
    public final CleanStrategy i(f52.b r3) {
        Intrinsics.checkNotNullParameter(r3, "container");
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("MatchConfrontPSTopView onShowFinish. id=" + this.a);
        n(r3);
        return CleanStrategy.NONE;
    }

    public final void n(f52.b r13) {
        this.r.b(this);
        if (this.p == false) goto L9;
        this.q.setPadding(0, s1.f(4.0f), 0, 0);
        int r0 = MatchLogHelper.a;
        HotMsgType r2 = HotMsgType.ConfrontMsg;
        DataCenter r3 = r13.getDataCenter();
        if (this.o == 0) goto L7;
        long r6 = System.currentTimeMillis() - this.o;
        this.o = 0;
    L8:
        MatchLogHelper.c(r2, r3, false, null, r6, 8);
        goto L9
    L7:
        r6 = 0;
    L9:
        ConfrontMsgView r1 = this.n;
        if (r1 == null) goto L12;
        r1.c();
        r1.setVisibility(8);
        this.q.removeView(r1);
        this.n = null;
    L12:
        ok1.c.a(0, r13.getDataCenter());
        ra2.b.a = null;
        ra2.b.b = null;
        ra2.b.c = null;
        ra2.b.d = null;
    }

    @Override // f52.c
    public final CleanStrategy b(f52.b r2, f52.c r3) {
        Intrinsics.checkNotNullParameter(r2, "container");
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("MatchConfrontPSTopView onInterrupt. id=" + this.a);
        n(r2);
        return CleanStrategy.NONE;
    }

    public d(ViewGroup r18, g3 r19, i r20) {
        Intrinsics.checkNotNullParameter(r18, "rootView");
        Intrinsics.checkNotNullParameter(r19, "msg");
        Intrinsics.checkNotNullParameter(r20, "listener");
        super(String.valueOf(r19.getMessageId()), NativePSTopViewType.Confront, 0, Integer.MAX_VALUE, 0, 0, 0, ConflictStrategy.DISCARD, ConflictStrategy.QUEUE, ConflictStrategy.INTERRUPT, false, null, r19, 2048);
        this.q = r18;
        this.r = r20;
    }
}
