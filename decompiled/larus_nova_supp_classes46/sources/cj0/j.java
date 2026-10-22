package cj0;

import com.bytedance.android.live.liveinteract.revenue.paid.viewmodel.PaidLinkMicContext;
import com.bytedance.android.live.liveinteract.revenue.paid.widget.BasePaidLinkMicWidget;
import com.bytedance.android.live.liveinteract.revenue.paid.widget.PaidLinkMicAudioWidget;
import com.bytedance.android.live.liveinteract.revenue.paid.widget.PaidLinkMicInteractWidget;
import com.bytedance.android.live.liveinteract.revenue.paid.widget.PaidLinkMicVideoWidget;
import com.bytedance.android.live.liveinteract.revenuebase.PaidWidgetType;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import tf0.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j implements com.bytedance.android.live.liveinteract.revenuebase.c {
    public j() {
    }

    public static c d() {
        PaidLinkMicContext r0 = PaidLinkMicContext.Companion.getContext();
        if (r0 == null) goto L7;
        com.bytedance.live.datacontext.j<c> r1 = r0.m308getWidget();
        if (r1 == null) goto L7;
        return (c) r1.getValue();
    L7:
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.revenuebase.c
    public final void b() {
        rj0.l.n2.getClass();
        rj0.l r0 = rj0.l.a.a();
        if (r0 == null) goto L6;
        o r1 = r0.windowManager();
        if (r1 == null) goto L6;
    L10:
        c r2 = PaidLinkMicContext.Companion.a();
        if (r2 != null) goto L13;
        return;
    L13:
        if (r2.isPaidLinkOn() != true) goto L18;
        if (r1 == null) goto L19;
        r1.s();
        return;
    L19:
        return;
    L18:
        return;
    L6:
        rj0.k.m2.getClass();
        rj0.k r3 = rj0.k.a.a();
        if (r3 == null) goto L9;
        r1 = r3.windowManager();
        goto L10
    L9:
        r1 = null;
        goto L10
    }

    @Override // cj0.b
    public final NextLiveData<k> c() {
        c r0 = d();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPaidLinkMicStateObservable();
    }

    @Override // cj0.b
    public final k currentPaidLinkMicState() {
        c r0 = d();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.currentPaidLinkMicState();
    }

    @Override // cj0.b
    public final boolean isIncreasePriceOn() {
        c r0 = d();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isIncreasePriceOn() != true) goto L7;
        return true;
    }

    @Override // cj0.b
    public final boolean isPaidLinkOn() {
        c r0 = d();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isPaidLinkOn();
    }

    @Override // cj0.b
    public final boolean needIntercepted() {
        c r0 = d();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.needIntercepted();
    }

    @Override // com.bytedance.android.live.liveinteract.revenuebase.c
    public final BasePaidLinkMicWidget a(PaidWidgetType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        int r3 = i.a[r2.ordinal()];
        if (r3 == 1) goto L13;
        if (r3 == 2) goto L15;
        if (r3 != 3) goto L10;
        return new PaidLinkMicAudioWidget();
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return new PaidLinkMicVideoWidget();
    L13:
        return new PaidLinkMicInteractWidget();
    }
}
