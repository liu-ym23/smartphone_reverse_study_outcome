package b41;

import android.view.View;
import com.bytedance.android.live.revenue.common.player.vendor.link.RevSeiFrame;
import com.bytedance.android.livesdk.model.n0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomSpecificSceneTypeInfo;
import com.bytedance.android.livesdkapi.view.IRenderView;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public IRoom a;
    public com.bytedance.android.live.revenue.common.player.vendor.link.a b;
    public RevSeiFrame c;
    public IRenderView d;
    public final c41.a e;
    public final boolean f;

    public final void a(com.bytedance.android.live.revenue.common.player.vendor.link.a r9) {
        com.bytedance.android.live.revenue.common.player.vendor.link.a r0 = this.b;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r9 != null) goto L10;
    L12:
        boolean r3 = false;
    L14:
        if (r2 == true) goto L68;
        if (r3 == false) goto L68;
        boolean r5 = this.f;
        if (r5 == false) goto L30;
        int r6 = e41.b.a;
        if (e41.b.a(this.a, r5) == false) goto L27;
        RevSeiFrame r7 = this.c;
        if (r7 == null) goto L27;
        n0 r8 = r7.g();
        if (r8 == null) goto L27;
        if (r8.f() < r8.e()) goto L27;
        boolean r10 = true;
    L28:
        if (r10 == false) goto L30;
        boolean r12 = true;
    L32:
        if (this.f == false) goto L43;
        IRoom r13 = this.a;
        if (r13 == null) goto L40;
        IRoomSpecificSceneTypeInfo r14 = r13.getSceneTypeInfo();
        if (r14 == null) goto L40;
        if (r14.isLandscapeVerticalRoom() != 1) goto L40;
        boolean r15 = true;
    L41:
        if (r15 == false) goto L43;
        boolean r16 = true;
    L45:
        if (this.f == false) goto L54;
        RevSeiFrame r17 = this.c;
        if (r17 != null) goto L49;
    L51:
        boolean r18 = false;
    L52:
        if (r18 == false) goto L54;
        r1 = true;
        goto L54
    L49:
        if (((Boolean) r17.p.getValue()).booleanValue() != true) goto L51;
        r18 = true;
    L54:
        if (r12 == true) goto L57;
        if (r16 == true) goto L57;
        if (r1 == true) goto L57;
    L67:
        this.e.c.setValue(Unit.INSTANCE);
    L57:
        RevSeiFrame r4 = this.c;
        if (r4 == null) goto L60;
        n0 r19 = r4.g();
    L61:
        if (r19 == null) goto L67;
        float r20 = RangesKt.coerceAtLeast(1.0f / (r19.b() / r19.f()), 1.0f / (r19.a() / r19.e()));
        IRenderView r22 = this.d;
        if (r22 == null) goto L67;
        View r23 = r22.getSelfView();
        if (r23 == null) goto L67;
        r23.setScaleX(r20);
        r23.setScaleY(r20);
        goto L67
    L60:
        r19 = null;
    L40:
        r15 = false;
    L43:
        r16 = false;
    L27:
        r10 = false;
    L30:
        r12 = false;
    L68:
        if (r2 == false) goto L76;
        if (r3 == true) goto L76;
        IRenderView r24 = this.d;
        if (r24 == null) goto L75;
        View r25 = r24.getSelfView();
        if (r25 == null) goto L75;
        r25.setScaleX(1.0f);
        r25.setScaleY(1.0f);
    L75:
        this.e.c.setValue(Unit.INSTANCE);
    L76:
        this.b = r9;
        return;
    L10:
        if ((r9 instanceof com.bytedance.android.live.revenue.common.player.vendor.link.a.C0083a) == false) goto L12;
        r3 = true;
        goto L14
    L5:
        if ((r0 instanceof com.bytedance.android.live.revenue.common.player.vendor.link.a.C0083a) == false) goto L7;
        r2 = true;
        goto L8
    }

    public b(c41.a r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        this.e = r2;
        this.f = r3;
    }
}
