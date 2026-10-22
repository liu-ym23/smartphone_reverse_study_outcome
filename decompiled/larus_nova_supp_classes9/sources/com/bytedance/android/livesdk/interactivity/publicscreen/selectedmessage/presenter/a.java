package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter;

import android.os.Handler;
import com.bytedance.android.live.base.model.message.u3;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.selectedmessage.SelectedMsgABHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.api.settings.config.f0;
import com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.strategy.SelectedMsgBuffer;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends q46.b<InterfaceC0191a> implements fa2.c {
    public boolean b;
    public final SelectedMsgBuffer c;
    public final f0 d;
    public final List<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> e;
    public final com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.strategy.a f;
    public final lc2.b g;
    public final e52.a h;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter.a$a, reason: collision with other inner class name */
    public interface InterfaceC0191a extends q46.a {
        void DI(int r1, long r2);

        void fc(int r1, int r2);

        void pa(int r1);
    }

    @Override // fa2.c
    public final void B(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        if (this.b == true) goto L5;
        return;
    L5:
        this.c.b(r2);
    }

    @Override // fa2.c
    public final void K(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        if (this.b == true) goto L5;
        return;
    L5:
        this.g.a(r2);
    }

    public final void c0(List<? extends com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r5) {
        int r0 = ((ArrayList) this.e).size();
        f0 r1 = this.d;
        if (r0 < r1.listMaxSizeWhenShow) goto L8;
        int r2 = RangesKt.coerceAtMost(r1.dropNumWhenMessageListFull, r5.size());
        ((ArrayList) this.e).subList(0, r2).clear();
        q46.a r3 = ((q46.b) this).a;
        if (r3 == null) goto L7;
        ((InterfaceC0191a) r3).pa(r2);
    L7:
        ga2.d.b(r2, "list full");
    L8:
        int r4 = ((ArrayList) this.e).size();
        Iterator<T> r6 = r5.iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        com.bytedance.android.livesdk.interactivity.api.entity.f r7 = (com.bytedance.android.livesdk.interactivity.api.entity.f) r6.next();
        ((ArrayList) this.e).add(r7);
        goto L10
    L12:
        InterfaceC0191a r8 = (InterfaceC0191a) ((q46.b) this).a;
        if (r8 == null) goto L17;
        r8.fc(r4, r5.size());
        return;
    }

    @Override // fa2.c
    public final void s(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        if (this.b == true) goto L5;
        return;
    L5:
        u3 r1 = r5.b;
        if ((r1 instanceof u3) == true) goto L8;
        r1 = null;
    L8:
        u3 r2 = r1;
        if (r2 != null) goto L11;
    L17:
        SelectedMsgBuffer r3 = this.c;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r5, "message");
        ((PriorityQueue) r3.c).add(r5);
        Iterator r0 = ((ArrayList) r3.a).iterator();
    L19:
        if (r0.hasNext() == false) goto L21;
        ((SelectedMsgBuffer.a) r0.next()).b(r5, ((PriorityQueue) r3.c).size());
        goto L19
    L21:
        return;
    L11:
        if (r2.getOrInitPublicAreaCommon().getIndividualPriority() >= 0) goto L17;
        if (this.b == false) goto L23;
        this.g.a(r5);
        this.g.b();
        return;
    }

    @Override // fa2.c
    public final void y(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        if (this.b == true) goto L5;
        return;
    L5:
        c0(CollectionsKt.listOf(r2));
    }

    public a(e52.a r4, Handler r5, DataCenter r6, SelectedMsgViewManager r7) {
        Intrinsics.checkNotNullParameter(r4, "mTextMessageConfig");
        Intrinsics.checkNotNullParameter(r5, "mMainHandler");
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        Intrinsics.checkNotNullParameter(r7, "selectedDataSource");
        this.h = r4;
        this.b = true;
        SelectedMsgBuffer r0 = new SelectedMsgBuffer(r7);
        this.c = r0;
        this.d = SelectedMsgABHelper.b();
        this.e = new ArrayList();
        c r8 = new c(this);
        com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.strategy.a r1 = new com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.strategy.a(r6, PublicScreenABHelper.d(a0.d(r6, false)), r8);
        this.f = r1;
        d r9 = new d(this);
        List<lc2.d> r2 = lc2.c.a;
        this.g = new lc2.b(r4, r5, new PSSelectedMsgPresenter$asyncMsgProcessorAdapter$1(this));
        b r10 = new b();
        Intrinsics.checkNotNullParameter(r10, "listener");
        ((ArrayList) r0.a).add(r10);
        r1.b(r9);
    }
}
