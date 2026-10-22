package com.bytedance.android.livesdk.interactivity.barrage.utils.shoot;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import com.bytedance.android.livesdk.interactivity.barrage.widget.BarrageWidgetContext;
import com.bytedance.android.livesdk.interactivity.common.combinedtext.CombinedTextRenderView;
import com.bytedance.android.livesdk.interactivity.common.combinedtext.DisplayImageListView;
import com.bytedance.android.livesdk.interactivity.common.combinedtext.DisplayTextView;
import com.bytedance.android.livesdk.interactivity.zdanmaku.widget.CarnivalDanmakuPresenter;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m extends r22.a<q72.d> {
    public final PriorityQueue<q72.d> c;
    public final String d;
    public final float e;
    public final CombinedTextRenderView.a f;
    public final r22.b<q72.d> g;
    public final BarrageWidgetContext h;

    @Override // r22.a
    public final q72.d j() {
        return this.c.poll();
    }

    @Override // r22.a
    public final r22.b<q72.d> f() {
        return this.g;
    }

    @Override // r22.a
    public final Queue<q72.d> h() {
        return this.c;
    }

    @Override // r22.a
    public final void e(q72.d r2) {
        q72.d r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "danmaku");
        this.c.add(r3);
        k();
    }

    public m(CarnivalDanmakuPresenter.c r4, BarrageWidgetContext r5) {
        Intrinsics.checkNotNullParameter(r4, "danmakuReceiver");
        super(r4);
        this.g = r4;
        this.h = r5;
        this.c = new PriorityQueue(16, l.a);
        this.d = "#ffffff";
        this.e = 18.0f;
        this.f = new CombinedTextRenderView.a(new DisplayTextView.a(UtilityKotlinExtentionsKt.m(15), false, false, 2046), new DisplayImageListView.a(UtilityKotlinExtentionsKt.i(20), UtilityKotlinExtentionsKt.i(20)));
    }

    @Override // r22.a
    public final void b(q72.d r10, final r22.a.b<q72.d> r11) {
        final q72.d r13 = r10;
        Intrinsics.checkNotNullParameter(r13, "data");
        Intrinsics.checkNotNullParameter(r11, "notifier");
        com.bytedance.android.livesdk.interactivity.api.barrage.data.a r0 = r13.f;
        boolean r3 = true;
        if (r0 == null) goto L10;
        py.i r1 = r0.a();
        if (r1 == null) goto L10;
        py.k r4 = vh7.f.c(py.k.class);
        r4.setUri(r1.getUri());
        List r2 = r1.getUrlList();
        if (r2 != null) goto L9;
        r2 = CollectionsKt.emptyList();
    L9:
        r4.setUrls(r2);
        int r5 = a3.d;
        a3.a.a(null, r4, new k(r13, r11), 0.0f);
    L12:
        if (r13.g != null) goto L14;
        return;
    L14:
        if (r13.getContext() == null) goto L57;
        com.bytedance.android.livesdk.interactivity.api.barrage.data.a r6 = r13.f;
        if (r6 == null) goto L20;
        String r7 = r6.b();
        if (r7 == null) goto L20;
    L21:
        final String r8 = r7;
        final Ref.FloatRef r9 = new Ref.FloatRef();
        com.bytedance.android.livesdk.interactivity.api.barrage.data.a r14 = r13.f;
        if (r14 == null) goto L24;
        float r15 = r14.c();
    L25:
        r9.element = r15;
        if (r15 > 0.0f) goto L28;
        r9.element = this.e;
    L28:
        float r16 = r9.element;
        BarrageWidgetContext r17 = this.h;
        if (r17 == null) goto L35;
        com.bytedance.live.datacontext.m<Float> r18 = r17.getScaleRate();
        if (r18 == null) goto L35;
        Float r19 = (Float) r18.getValue();
        if (r19 == null) goto L35;
        float r20 = r19.floatValue();
    L36:
        r9.element = r16 * r20;
        final CombinedTextRenderView r21 = new CombinedTextRenderView(r13.getContext(), null, 6, 0);
        DisplayTextView.a r23 = this.f.a;
        r23.g = r8;
        r23.a = UtilityKotlinExtentionsKt.m(r9.element);
        List r24 = r13.g.b();
        if (r24 == null) goto L44;
        Iterator r25 = r24.iterator();
    L40:
        if (r25.hasNext() == false) goto L44;
        if (((com.bytedance.android.live.base.model.message.f) r25.next()).j() == false) goto L40;
    L45:
        if (r3 == false) goto L47;
        r21.setOnImageRenderEndCallback(new GeneralCarnivalDanmakuShooter$asyncProcess$$inlined$let$lambda$2(r21, this, r8, r9, r13, r11));
        r21.a(r13.g, this.f);
        return;
    L47:
        r21.a(r13.g, this.f);
        r13.e = r21;
        if (r13.d == false) goto L56;
        r11.a(r13);
        return;
    L56:
        return;
    L44:
        r3 = false;
    L35:
        r20 = 1.0f;
        goto L36
    L24:
        r15 = 0.0f;
    L20:
        r7 = this.d;
        goto L21
    L57:
        return;
    L10:
        r13.d = true;
        goto L12
    }
}
