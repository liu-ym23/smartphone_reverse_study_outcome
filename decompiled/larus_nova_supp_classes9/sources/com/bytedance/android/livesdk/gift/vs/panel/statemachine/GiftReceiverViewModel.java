package com.bytedance.android.livesdk.gift.vs.panel.statemachine;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.gift.model.w0;
import com.bytedance.android.livesdk.gift.model.x0;
import com.bytedance.android.livesdk.gift.model.y0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.GiftReceiverRepoService;
import com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.GiftReceiverStateHelperKt;
import com.bytedance.android.livesdk.message.model.x7;
import com.bytedance.android.scope.m;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import i12.o;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import vh7.i;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class GiftReceiverViewModel extends com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a implements l {
    public static final /* synthetic */ int h = 0;
    public final CompositeDisposable e;
    public final vlc.d f;
    public final StateMachine<com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.a, GiftStateMachineConfig.Event, GiftStateMachineConfig.f> g;

    public static final class a {
    }

    static {
    }

    public final com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.a f() {
        return (com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.a) this.g.b();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a
    public final void a() {
        super.a();
        vlc.d r0 = this.f;
        if (r0 == null) goto L5;
        r0.removeMessageListener(this);
    L5:
        this.e.clear();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a
    public final void d(GiftStateMachineConfig.Event r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        StateMachine<com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.a, GiftStateMachineConfig.Event, GiftStateMachineConfig.f> r0 = this.g;
        StateMachine.a r1 = StateMachine.c;
        r0.d(r3, null);
    }

    public final void onMessage(tlc.d r7) {
        if ((r7 instanceof x7) == false) goto L51;
        w0 r8 = ((x7) r7).getInfo();
        if (r8 == null) goto L27;
        i12.e r1 = o.b();
        if (r1 == null) goto L9;
        Object r2 = m.e.d(r1, GiftReceiverRepoService.class);
    L10:
        GiftReceiverRepoService r3 = (GiftReceiverRepoService) r2;
        if (r3 == null) goto L13;
        w0 r4 = r3.s();
    L14:
        if (r4 == null) goto L25;
        KProperty[] r5 = x0.a;
        Intrinsics.checkNotNullParameter(r4, "$this$nowTimeDiff");
        i r6 = x0.b;
        KProperty r9 = x0.a[0];
        w0 r10 = r4;
        if ((r10 instanceof FlexModelBase) == true) goto L18;
        r10 = null;
    L18:
        FlexModelBase r11 = (FlexModelBase) r10;
        if (r11 == null) goto L21;
        Object r13 = r11.get(r6.a);
    L22:
        Long r14 = (Long) r13;
        if (r14 == null) goto L25;
        long r15 = r14.longValue();
    L26:
        x0.a(r8, Long.valueOf(r15));
        goto L27
    L21:
        r13 = null;
    L25:
        r15 = 0;
        goto L26
    L13:
        r4 = null;
        goto L14
    L9:
        r2 = null;
    L27:
        StringBuilder r16 = new StringBuilder("groupShowUsers size = ");
        if (r8 == null) goto L32;
        List<y0> r17 = r8.getGroupShowUsers();
        if (r17 == null) goto L32;
        Integer r18 = Integer.valueOf(r17.size());
    L33:
        r16.append(r18);
        jy0.b.d("GiftReceiverViewModel", r16.toString());
        if (((Number) nz1.b.d.getValue(null, nz1.b.a[2])).intValue() != 1) goto L39;
        if (r8 == null) goto L39;
        if (r8.getGroupShowScene() != 2) goto L39;
        return;
    L39:
        StateMachine<com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.a, GiftStateMachineConfig.Event, GiftStateMachineConfig.f> r19 = this.g;
        if (r8 == null) goto L47;
        List<y0> r20 = r8.getGroupShowUsers();
        if (r20 == null) goto L47;
        List<y0> r21 = r20;
        ArrayList r23 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r21, 10));
        Iterator<T> r24 = r21.iterator();
    L45:
        if (r24.hasNext() == false) goto L48;
        r23.add(((y0) r24.next()).getGroupShowUser());
    L48:
        GiftStateMachineConfig.Event.e0 r25 = new GiftStateMachineConfig.Event.e0(r8, r23);
        StateMachine.a r26 = StateMachine.c;
        r19.d(r25, null);
        return;
    L47:
        r23 = new ArrayList();
    L32:
        r18 = null;
        goto L33
    }

    public GiftReceiverViewModel(LifecycleOwner r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        super(r2);
        this.e = new CompositeDisposable();
        this.f = (vlc.d) r3.get("data_message_manager");
        this.g = GiftReceiverStateHelperKt.a(new GiftReceiverViewModel$receiverStateMachine$1(this));
    }
}
