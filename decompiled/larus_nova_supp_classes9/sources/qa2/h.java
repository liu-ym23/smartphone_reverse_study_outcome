package qa2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.g3;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.t;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.CleanStrategy;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.ConflictStrategy;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.DiscardReason;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.NativePSTopViewType;
import com.bytedance.android.livesdk.interactivity.api.q;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.PSTopContainer;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.MatchHotMsgView;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.HotMsgType;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.MatchLogHelper;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h extends f52.j<g3> {
    public long n;
    public MatchHotMsgView o;
    public boolean p;
    public final ViewGroup q;
    public final a r;

    @Override // f52.c
    public final void a(DiscardReason r3) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("MatchHotPSTopView onDiscard. id=" + this.a + " reason=" + r3);
    }

    @Override // f52.c
    public final void h(f52.b r13) {
        Intrinsics.checkNotNullParameter(r13, "container");
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("MatchHotPSTopView onShow. id=" + this.a);
        this.r.a(this);
        this.q.removeAllViews();
        List<? extends py.k> r2 = null;
        boolean r3 = false;
        MatchHotMsgView r0 = new MatchHotMsgView(this.q.getContext(), null, 0);
        this.o = r0;
        this.q.addView(r0, 1, 1);
        r0.setOnClickListener(g.a);
        r0.setManagerCallBack(new f(this, r13));
        r0.setRunning(true);
        r0.c((g3) this.m);
        PriorityBlockingQueue<g3> r14 = r0.z;
        if (r14 != null) goto L5;
    L43:
        com.bytedance.android.livesdk.interactivity.api.h r15 = q.g();
        if (r15 == null) goto L50;
        m<t> r16 = r15.getMatchChatInfo();
        if (r16 == null) goto L50;
        t r17 = (t) r16.getValue();
        if (r17 == null) goto L50;
        r2 = r17.aggregateIcon;
    L50:
        if (r2 != null) goto L52;
    L59:
        StringBuilder r18 = new StringBuilder("MatchHotMsgView image load failed. webpIcons is null or iconIndex is outOfIndex. iconIndex is ");
        r18.append(r0.a);
        r18.append(". icons is null ? ans: ");
        if (r2 != null) goto L62;
        r3 = true;
    L62:
        r18.append(r3);
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b(r18.toString());
        pa2.a r19 = r0.h;
        if (r19 == null) goto L70;
        r19.a();
        return;
    L70:
        return;
    L52:
        if (r0.a >= r2.size()) goto L59;
        long r7 = r0.a;
        if (r7 < 0) goto L59;
        ImageLoader.bindGifImage(r0.c, (py.k) ListProtector.get(r2, (int) r7), new ra2.q(r0, 0));
        HSImageView r110 = r0.b;
        if (r110 == null) goto L68;
        PipelineDraweeControllerBuilder r1 = Fresco.newDraweeControllerBuilder();
        Context r4 = r0.getContext();
        Intrinsics.checkNotNullParameter(r4, "context");
        Resources r5 = r4.getResources();
        r110.setController(r1.setUri(UriProtector.parse("android.resource://" + r5.getResourcePackageName(2131820669) + "/" + r5.getResourceTypeName(2131820669) + "/" + r5.getResourceEntryName(2131820669))).setControllerListener(new ra2.q(r0, 1)).build());
        return;
    L68:
        return;
    L5:
        if ((!r14.isEmpty()) != true) goto L43;
        if (r0.y == true) goto L19;
        r0.y = true;
        Typeface r111 = Typeface.createFromAsset(r0.getContext().getAssets(), "font/ttlive_base_gift_combo_font.ttf");     // Catch: Exception -> L17
        TextView r6 = r0.j;     // Catch: Exception -> L17
        if (r6 == null) goto L13;
        r6.setTypeface(r111);     // Catch: Exception -> L17
    L13:
        TextView r8 = r0.i;     // Catch: Exception -> L17
        if (r8 == null) goto L19;
        r8.setTypeface(r111);     // Catch: Exception -> L17
    L17:
        e = move-exception;
        r0.y = false;
        String r112 = "load font asset exception: " + e.getMessage();
        Intrinsics.checkNotNullParameter(r112, "info");
        ALogger.e("MatchMsgTAG", r112);
    L19:
        PriorityBlockingQueue<g3> r113 = r0.z;
        if (r113 == null) goto L22;
        g3 r114 = r113.poll();
    L23:
        if (r114 != null) goto L27;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("error! fetch data from datasource failed!!!");
        pa2.a r9 = r0.h;
        if (r9 == null) goto L27;
        r9.a();
    L27:
        r0.A = r114;
        if (r114 == null) goto L30;
        long r10 = r114.getIconIndex();
    L31:
        r0.a = r10;
        TextView r11 = r0.k;
        if (r11 == null) goto L37;
        if (r114 == null) goto L35;
        String r20 = r114.getContent();
    L36:
        r11.setText(r20);
        goto L37
    L35:
        r20 = null;
    L37:
        TextView r21 = r0.i;
        if (r21 == null) goto L43;
        if (r114 == null) goto L41;
        Long r115 = Long.valueOf(r114.getCount());
    L42:
        r21.setText(String.valueOf(r115));
        goto L43
    L41:
        r115 = null;
        goto L42
    L30:
        r10 = 0;
        goto L31
    L22:
        r114 = null;
        goto L23
    }

    @Override // f52.c
    public final CleanStrategy i(f52.b r3) {
        Intrinsics.checkNotNullParameter(r3, "container");
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("MatchHotPSTopView onShowFinish. id=" + this.a);
        n(r3);
        return CleanStrategy.NONE;
    }

    @Override // f52.j, f52.c
    public final boolean j(f52.c r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        if ((r5 instanceof h) == true) goto L5;
    L7:
        return false;
    L5:
        if (((g3) this.m).getTriggerTimestamp() != ((g3) ((h) r5).m).getTriggerTimestamp()) goto L7;
        return true;
    }

    public final void n(f52.b r13) {
        this.r.b(this);
        if (this.p == false) goto L9;
        this.q.setPadding(0, s1.f(4.0f), 0, 0);
        int r0 = MatchLogHelper.a;
        HotMsgType r2 = HotMsgType.AggregateMsg;
        DataCenter r3 = r13.getDataCenter();
        MatchHotMsgView r5 = this.o;
        if (this.n == 0) goto L7;
        long r6 = System.currentTimeMillis() - this.n;
        this.n = 0;
    L8:
        MatchLogHelper.b(r2, r3, false, r5, r6);
        goto L9
    L7:
        r6 = 0;
    L9:
        MatchHotMsgView r1 = this.o;
        if (r1 == null) goto L15;
        r1.h = null;
        r1.F = false;
        r1.I = r1.G;
        r1.A = null;
        r1.z = null;
        r1.removeCallbacks(r1.m);
        r1.removeCallbacks(r1.l);
        r1.removeCallbacks(r1.n);
        r1.removeCallbacks(r1.o);
        r1.removeCallbacks(r1.p);
        MatchHotMsgView.b(r1.B);
        MatchHotMsgView.b(r1.C);
        MatchHotMsgView.b(r1.E);
        MatchHotMsgView.b(r1.D);
        ViewGroup r4 = r1.d;
        if (r4 == null) goto L14;
        r4.clearAnimation();
    L14:
        r1.setVisibility(8);
        this.q.removeView(r1);
        this.o = null;
    L15:
        ok1.c.a(0, r13.getDataCenter());
    }

    @Override // f52.c
    public final CleanStrategy b(f52.b r2, f52.c r3) {
        Intrinsics.checkNotNullParameter(r2, "container");
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("MatchHotPSTopView onInterrupt. id=" + this.a);
        n(r2);
        return CleanStrategy.NONE;
    }

    @Override // f52.j, f52.c
    public final void e(f52.c r2, PSTopContainer r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "container");
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("onAssemble");
        if ((r2 instanceof h) == true) goto L5;
        r2 = null;
    L5:
        h r4 = (h) r2;
        if (r4 == null) goto L14;
        g3 r5 = (g3) r4.m;
        if (r5 == null) goto L16;
        MatchHotMsgView r6 = this.o;
        if (r6 == null) goto L15;
        r6.d(r5);
        return;
    L15:
        return;
    L16:
        return;
    }

    public h(ViewGroup r18, g3 r19, j r20) {
        Intrinsics.checkNotNullParameter(r18, "rootView");
        Intrinsics.checkNotNullParameter(r19, "msg");
        Intrinsics.checkNotNullParameter(r20, "listener");
        super(String.valueOf(r19.getMessageId()), NativePSTopViewType.MatchDynamicHotMsg, r19.getTriggerTimestamp(), Integer.MAX_VALUE, 0, 0, 0, ConflictStrategy.DISCARD, ConflictStrategy.QUEUE, ConflictStrategy.INTERRUPT, true, null, r19, 2048);
        this.q = r18;
        this.r = r20;
    }
}
