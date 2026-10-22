package com.bytedance.android.livesdk.gift.vs.panel.statemachine;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.gift.model.e3;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.sendGift.GiftTransaction;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftSource;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftStrategy;
import com.bytedance.android.livesdk.gift.platform.core.model.b0;
import com.bytedance.android.livesdk.gift.platform.core.model.c0;
import com.bytedance.android.livesdk.gift.platform.core.model.n;
import com.bytedance.android.livesdk.gift.platform.core.model.t;
import com.bytedance.android.livesdk.gift.platform.core.model.y;
import com.bytedance.android.livesdk.gift.platform.core.utils.h;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.i;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a {
    public GiftTransaction e;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.vs.panel.statemachine.a$a, reason: collision with other inner class name */
    public static final class C0080a {
    }

    public static final class b extends c0 {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.core.model.r
        public final void b(t r2, y r3) {
            Intrinsics.checkNotNullParameter(r2, "info");
            Intrinsics.checkNotNullParameter(r3, "response");
            if ((r3 instanceof y.c.a) == false) goto L8;
            this.a.getClass();
            AbsPanel<?> r4 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.d();
            if (r4 == null) goto L9;
            com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.g(r4));
            return;
        L9:
            return;
        }
    }

    static {
    }

    public final StateMachine<GiftStateMachineConfig.a, GiftStateMachineConfig.Event, GiftStateMachineConfig.f> f() {
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L9;
        i<Map<String, com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a>> r1 = r0.getGiftViewModelMap();
        if (r1 == null) goto L9;
        Map r2 = (Map) r1.getValue();
        if (r2 == null) goto L9;
        com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a r3 = (com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a) r2.get("GiftDialogViewModel");
    L11:
        if ((r3 instanceof GiftDialogViewModelNew) == true) goto L13;
        r3 = null;
    L13:
        GiftDialogViewModelNew r4 = (GiftDialogViewModelNew) r3;
        if (r4 != null) goto L16;
        return null;
    L16:
        return r4.f;
    L9:
        r3 = null;
        goto L11
    }

    public a(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        super(r2);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a
    public final void d(GiftStateMachineConfig.Event r63) {
        Intrinsics.checkNotNullParameter(r63, "event");
        List<IBaseUser> r4 = null;
        if ((r63 instanceof GiftStateMachineConfig.Event.q) == false) goto L44;
        GiftStateMachineConfig.Event.q r2 = (GiftStateMachineConfig.Event.q) r63;
        int r5 = r2.c;
        long r6 = r2.b.c();
        AbsPanel<?> r7 = r2.b;
        h.G(r6, r7.h instanceof h1, r2.g, r7.f, r7.c, r7.b, com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.r());
        StateMachine<GiftStateMachineConfig.a, GiftStateMachineConfig.Event, GiftStateMachineConfig.f> r8 = f();
        if (r8 == null) goto L7;
        StateMachine.a r9 = StateMachine.c;
        r8.d(r63, null);
    L7:
        GiftTransaction r1 = this.e;
        if (r1 != null) goto L10;
    L16:
        boolean r28 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.s();
        if (r28 == false) goto L19;
        r4 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.o();
    L19:
        List<IBaseUser> r29 = r4;
        GiftTransaction r3 = this.e;
        if (r3 == null) goto L22;
        r3.finish();
    L22:
        long r10 = r2.b.c();
        SendGiftSource r11 = SendGiftSource.GiftDialog;
        IBaseUser r13 = com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.r();
        Long r14 = Long.valueOf(com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.e(com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.r()));
        int r15 = r2.d;
        int r16 = r2.f;
        SendGiftStrategy r21 = SendGiftStrategy.REQUEST_AFTER_RESPONSE;
        T r17 = r2.b.h;
        boolean r18 = r17 instanceof l2;
        if (r18 == false) goto L28;
        if (r17 == 0) goto L27;
        long r19 = ((l2) r17).isAwemeFreeGift();
    L29:
        long r25 = r19;
        AbsPanel<?> r20 = r2.b;
        ArrayList<e3> r110 = r20.b;
        long r111 = r20.g;
        n r112 = r2.h;
        T r23 = r20.h;
        if ((r23 instanceof l2) == false) goto L35;
        if (r23 == 0) goto L34;
        String r24 = ((l2) r23).getRefId();
    L36:
        GiftTransaction r26 = com.bytedance.android.livesdk.gift.platform.business.dialog.v2.d.p(new b0(r10, r11, r13, r14, r15, 0, null, null, null, null, r16, null, r110, false, r21, 0, r18, r24, r25, null, r28, r29, false, 0, null, null, null, r112, null, null, null, null, 0, r111, null, null, false, null, null, null, null, null, null, false, null, null, null, null, 0, null, null, -137851936, 8388599));
        this.e = r26;
        if (r26 == null) goto L39;
        r26.h(new b(this));
    L39:
        GiftTransaction r27 = this.e;
        if (r27 == null) goto L77;
        r27.d(r2.c);
        return;
    L77:
        return;
    L34:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IProp");
    L35:
        r24 = BuildConfig.FLAVOR;
        goto L36
    L27:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.IProp");
    L28:
        r19 = 0;
        goto L29
    L10:
        if (r1.b == true) goto L16;
        if (r1 == null) goto L16;
        b0 r30 = r1.x;
        if (r30 == null) goto L16;
        if (r30.q == 1) goto L39;
    L44:
        if ((r63 instanceof GiftStateMachineConfig.Event.r) == false) goto L71;
        StateMachine<GiftStateMachineConfig.a, GiftStateMachineConfig.Event, GiftStateMachineConfig.f> r31 = f();
        if (r31 == null) goto L48;
        StateMachine.a r33 = StateMachine.c;
        r31.d(r63, null);
    L48:
        GiftTransaction r34 = this.e;
        if (r34 == null) goto L63;
        if (r34.b == true) goto L63;
        if (r34 == null) goto L63;
        b0 r35 = r34.x;
        if (r35 == null) goto L63;
        int r36 = r35.q;
        GiftStateMachineConfig.Event.r r37 = (GiftStateMachineConfig.Event.r) r63;
        r37.getClass();
        if (r36 != 0) goto L63;
        GiftTransaction r38 = this.e;
        if (r38 == null) goto L78;
        r37.getClass();
        r38.d(0);
        return;
    L78:
        return;
    L63:
        if (com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.s() == false) goto L65;
        com.bytedance.android.livesdk.gift.vs.panel.statemachine.helper.b.o();
    L65:
        GiftTransaction r39 = this.e;
        if (r39 == null) goto L68;
        r39.finish();
    L68:
        ((GiftStateMachineConfig.Event.r) r63).getClass();
        throw null;
    L71:
        if ((r63 instanceof GiftStateMachineConfig.Event.g) == false) goto L79;
        GiftTransaction r40 = this.e;
        if (r40 == null) goto L75;
        r40.finish();
    L75:
        this.e = null;
        return;
    }
}
