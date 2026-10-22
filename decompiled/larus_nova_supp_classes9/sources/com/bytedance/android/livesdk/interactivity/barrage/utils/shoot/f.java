package com.bytedance.android.livesdk.interactivity.barrage.utils.shoot;

import android.graphics.Bitmap;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.interactivity.barrage.widget.BarrageWidgetContext;
import com.bytedance.android.livesdk.interactivity.common.utils.LimitQueue;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class f extends r22.a<q72.c> {
    public final Deque<q72.c> c;
    public final r22.b<q72.c> d;
    public final BarrageWidgetContext e;

    public static final class a implements IHostFrescoHelper.GetBitmapCallBack {
        public final /* synthetic */ f a;
        public final /* synthetic */ q72.c b;

        public final void fail(IHostFrescoHelper.BitmapDataSource r2) {
            this.a.a.a(this.b);
        }

        public final void onNewResultImpl(Bitmap r3) {
            if (r3 != null) goto L4;
            return;
        L4:
            if (r3.isRecycled() == true) goto L21;
            Bitmap r4 = r3.copy(Bitmap.Config.ARGB_8888, true);
            if (r4 != null) goto L9;
            return;
        L9:
            if (r4.isRecycled() == true) goto L22;
            q72.c r0 = this.b;
            if ((r0 instanceof q72.c) == true) goto L14;
            q72.c r1 = null;
        L15:
            if (r1 == null) goto L17;
            r1.f = r4;
        L17:
            this.a.a.a(r0);
            return;
        L14:
            r1 = r0;
            goto L15
        L22:
            return;
        }

        public a(f r1, q72.c r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Override // r22.a
    public final q72.c j() {
        return this.c.pollFirst();
    }

    @Override // r22.a
    public r22.b<q72.c> f() {
        return this.d;
    }

    @Override // r22.a
    public final Queue<q72.c> h() {
        return this.c;
    }

    @Override // r22.a
    public final void e(q72.c r2) {
        q72.c r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "danmaku");
        this.c.add(r3);
        k();
    }

    public f(r22.b<q72.c> r2, BarrageWidgetContext r3) {
        Intrinsics.checkNotNullParameter(r2, "danmakuReceiver");
        super(r2);
        this.d = r2;
        this.e = r3;
        fc2.a r4 = (fc2.a) ec2.k.a.getValue();
        if (r4.controlEnable.booleanValue() == false) goto L5;
        Deque<q72.c> r5 = new LimitQueue(r4.eggShooterThreshold);
    L6:
        this.c = r5;
        return;
    L5:
        r5 = new LinkedList();
        goto L6
    }

    @Override // r22.a
    public /* bridge */ /* synthetic */ void b(q72.c r1, r22.a.b<q72.c> r2) {
        l(r1, r2);
    }

    public void l(q72.c r7, r22.a.b<q72.c> r8) {
        Intrinsics.checkNotNullParameter(r7, "data");
        Intrinsics.checkNotNullParameter(r8, "notifier");
        boolean r9 = false;
        if (r7 == null) goto L5;
        int r0 = r7.j;
    L6:
        BarrageWidgetContext r1 = this.e;
        if (r1 == null) goto L15;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.interactivity.api.barrage.data.d> r2 = r1.getChatCarnivalMessage();
        if (r2 == null) goto L15;
        com.bytedance.android.livesdk.interactivity.api.barrage.data.d r3 = (com.bytedance.android.livesdk.interactivity.api.barrage.data.d) r2.getValue();
        if (r3 == null) goto L15;
        List<com.bytedance.android.livesdk.interactivity.api.barrage.data.i> r4 = r3.r();
        if (r4 == null) goto L15;
        int r5 = r4.size();
    L16:
        if (r0 < r5) goto L18;
        return;
    L18:
        BarrageWidgetContext r6 = this.e;
        if (r6 == null) goto L33;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.interactivity.api.barrage.data.d> r10 = r6.getChatCarnivalMessage();
        if (r10 == null) goto L34;
        com.bytedance.android.livesdk.interactivity.api.barrage.data.d r11 = (com.bytedance.android.livesdk.interactivity.api.barrage.data.d) r10.getValue();
        if (r11 == null) goto L35;
        List<com.bytedance.android.livesdk.interactivity.api.barrage.data.i> r13 = r11.r();
        if (r13 == null) goto L36;
        com.bytedance.android.livesdk.interactivity.api.barrage.data.i r14 = (com.bytedance.android.livesdk.interactivity.api.barrage.data.i) CollectionsKt.getOrNull(r13, r0);
        if (r14 == null) goto L37;
        long r15 = r14.e();
        int r16 = com.bytedance.android.livesdk.interactivity.api.barrage.data.i.a;
        if (r15 != 1) goto L31;
        r9 = true;
    L31:
        r7.b = r9;
        m(r7, r14.a(), UtilityKotlinExtentionsKt.i((int) r14.c()), UtilityKotlinExtentionsKt.i((int) r14.b()));
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L15:
        r5 = 0;
        goto L16
    L5:
        r0 = 0;
        goto L6
    }

    public final void m(q72.c r2, py.k r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "data");
        if (r2.b == false) goto L5;
        r2.d = a1.e(r3, true);
        q72.g r6 = new q72.g(r4, r5);
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r2.e = r6;
        r2.b = true;
        this.a.a(r2);
        return;
    L5:
        r2.b = false;
        jc1.k.n(IHostFrescoHelper.class).loadFirstAvailableImageBitmap(r3, new a(this, r2));
    }
}
