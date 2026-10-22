package com.bytedance.android.livesdk.gift.platform.format.panel.statemachine;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import ca0.w;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.format.service.FormatGiftListService;
import com.bytedance.android.livesdk.gift.platform.format.service.l;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import com.bytedance.bdlocation.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a implements o {
    public final CompositeDisposable e;
    public final Context f;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.a$a, reason: collision with other inner class name */
    public static final class C0076a {
    }

    public static final class b extends w {
        public final /* synthetic */ a a;
        public final /* synthetic */ GiftStateMachineConfig.Event b;
        public final /* synthetic */ long c;

        public final void a() {
            a r0 = this.a;
            Observable r1 = ca0.d.a.a(com.bytedance.android.live.revenue.core.util.f.a(ca0.d.class), this.a.getContext(), ((GiftStateMachineConfig.Event.q) this.b).b.c(), String.valueOf(this.c), 0, null, null, null, IAssetsManager.DownloadAssetsSource.SOURCE_JSB_PRELOADING);
            r0.getClass();
            if (r1 == null) goto L8;
            Disposable r2 = r1.subscribe(com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.b.a, c.a);
            if (r2 == null) goto L9;
            r0.e.add(r2);
            return;
        L9:
            return;
        }

        public final void b(List<? extends w1> r20) {
            Intrinsics.checkNotNullParameter(r20, "giftPages");
            Intrinsics.checkNotNullParameter(r20, "giftPages");
            Iterator<T> r1 = r20.iterator();
        L4:
            if (r1.hasNext() == false) goto L17;
            List<h1> r2 = ((w1) r1.next()).getGifts();
            if (r2 == null) goto L4;
            Iterator<T> r3 = r2.iterator();
        L9:
            if (r3.hasNext() == false) goto L4;
            h1 r4 = (h1) r3.next();
            if (r4.getId() != ((GiftStateMachineConfig.Event.q) this.b).b.c()) goto L9;
            a r5 = this.a;
            Observable<p2> r6 = com.bytedance.android.live.revenue.core.util.f.a(l.class).g(this.a.getContext(), new com.bytedance.android.livesdk.gift.platform.format.service.a(r4.getId(), r4.getDiamondCount(), 1, String.valueOf(this.c), BuildConfig.FLAVOR, BuildConfig.FLAVOR, 0, BuildConfig.FLAVOR, null));
            r5.getClass();
            if (r6 == null) goto L9;
            Disposable r7 = r6.subscribe(com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.b.a, c.a);
            if (r7 == null) goto L9;
            r5.e.add(r7);
            goto L9
        }

        public b(a r1, GiftStateMachineConfig.Event r2, long r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
        a();
        this.e.dispose();
        this.e.clear();
    }

    public final Context getContext() {
        return this.f;
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super((LifecycleOwner) r2);
        this.f = r2;
        this.e = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.a
    public final void d(GiftStateMachineConfig.Event r11) {
        Intrinsics.checkNotNullParameter(r11, "event");
        if ((r11 instanceof GiftStateMachineConfig.Event.q) == false) goto L29;
        GiftStateMachineConfig.Event.q r0 = (GiftStateMachineConfig.Event.q) r11;
        long r2 = r0.b.c();
        AbsPanel<?> r1 = r0.b;
        com.bytedance.android.livesdk.gift.platform.core.utils.h.G(r2, r1.h instanceof h1, r0.g, r1.f, r1.c, r1.b, com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.m());
        q12.a r3 = q12.b.a;
        Object r4 = null;
        if (r3 == null) goto L7;
        Object r5 = m.e.d(r3, FormatGiftPanelDialogViewModel.class);
    L8:
        FormatGiftPanelDialogViewModel r6 = (FormatGiftPanelDialogViewModel) r5;
        if (r6 == null) goto L11;
        StateMachine<GiftStateMachineConfig.a, GiftStateMachineConfig.Event, GiftStateMachineConfig.f> r7 = r6.f;
    L12:
        if (r7 == null) goto L14;
        StateMachine.a r8 = StateMachine.c;
        r7.d(r11, null);
    L14:
        i12.e r9 = i12.o.a();
        if (r9 == null) goto L17;
        Object r10 = m.e.d(r9, com.bytedance.android.livesdk.gift.platform.format.service.m.class);
    L18:
        com.bytedance.android.livesdk.gift.platform.format.service.m r13 = (com.bytedance.android.livesdk.gift.platform.format.service.m) r10;
        if (r13 == null) goto L21;
        long r14 = r13.getToUserId();
    L22:
        i12.e r15 = i12.o.a();
        if (r15 == null) goto L25;
        r4 = m.e.d(r15, FormatGiftListService.class);
    L25:
        FormatGiftListService r16 = (FormatGiftListService) r4;
        if (r16 == null) goto L31;
        r16.a(new b(this, r11, r14));
        return;
    L31:
        return;
    L21:
        r14 = 0;
        goto L22
    L17:
        r10 = null;
        goto L18
    L11:
        r7 = null;
        goto L12
    L7:
        r5 = null;
        goto L8
    L29:
        boolean r17 = r11 instanceof GiftStateMachineConfig.Event.g;
    }
}
