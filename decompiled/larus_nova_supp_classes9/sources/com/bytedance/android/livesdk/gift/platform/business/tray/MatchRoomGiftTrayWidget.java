package com.bytedance.android.livesdk.gift.platform.business.tray;

import android.view.View;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/tray/MatchRoomGiftTrayWidget;", "Lcom/bytedance/android/livesdk/gift/platform/business/tray/GiftTrayWidget;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MatchRoomGiftTrayWidget extends GiftTrayWidget {
    public boolean s;
    public final Lazy t;
    public final a u;
    public final b v;
    public final i12.e w;

    public static final class a<T> implements Observer {
        public final /* synthetic */ MatchRoomGiftTrayWidget a;

        public a(MatchRoomGiftTrayWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            KVData r4 = (KVData) r3;
            MatchRoomGiftTrayWidget r0 = this.a;
            if (r4 == null) goto L5;
            Boolean r5 = (Boolean) r4.getData();
        L6:
            r0.s = Intrinsics.areEqual(r5, Boolean.TRUE);
            this.a.Eq();
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ MatchRoomGiftTrayWidget a;

        public static final class a implements IAssetsManager.b {
            public final /* synthetic */ long a;
            public final /* synthetic */ IAssetsManager b;

            @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager.b
            public final void a() {
                this.b.l0(this);
            }

            @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager.b
            public final void b(List<? extends com.bytedance.android.live.core.resources.e> r5) {
                Intrinsics.checkNotNullParameter(r5, "assetsModels");
                this.b.j4(this.a, null, 2);
                this.b.l0(this);
            }

            public a(long r1, IAssetsManager r3) {
                this.a = r1;
                this.b = r3;
            }
        }

        public b(MatchRoomGiftTrayWidget r1) {
            this.a = r1;
        }

        public final void a() {
            IAssetsManager r0 = (IAssetsManager) this.a.t.getValue();
            if (r0 == null) goto L14;
            Iterator r8 = ((List) com.bytedance.android.livesdk.gift.platform.business.b.b.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[0])).iterator();
        L6:
            if (r8.hasNext() == false) goto L21;
            long r4 = ((Number) r8.next()).longValue();
            IAssetsManager r1 = (IAssetsManager) this.a.t.getValue();
            if (r1 == null) goto L10;
            com.bytedance.android.live.core.resources.e r2 = r1.G1(r4);
        L11:
            if (r2 == null) goto L12;
            r0.j4(r4, null, 2);
            goto L6
        L12:
            r0.T(new a(r4, r0));
            r0.d4(2, false, r4, "matchroom");
            goto L6
        L10:
            r2 = null;
            goto L11
        L21:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray.GiftTrayWidget
    public final int getLayoutId() {
        return 2131568013;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray.GiftTrayWidget
    public final String nc() {
        return "MatchRoomGiftTrayWidget";
    }

    public final void Eq() {
        boolean r0 = this.s;
        if (r0 == true) goto L7;
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L7;
        r1.put("cmd_clear_gift_message", new Object());
    L7:
        View r2 = ((Widget) this).contentView;
        if (r2 == null) goto L13;
        if (r0 == false) goto L11;
        int r3 = 0;
    L12:
        r2.setVisibility(r3);
        goto L13
    L11:
        r3 = 8;
    L13:
        boolean r4 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class).setNeedShowGiftEffectSwitch(r0);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray.GiftTrayWidget
    public final void onUnload() {
        ((Widget) this).dataCenter.removeObserver("match_is_public_interact_tab", this.u);
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.h.N.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[38])).booleanValue() == false) goto L7;
        View r0 = ((Widget) this).contentView;
        if (r0 == null) goto L7;
        r0.removeCallbacks(this.v);
    L7:
        super.onUnload();
    }

    public MatchRoomGiftTrayWidget(i12.e r1) {
        this.w = r1;
        this.s = true;
        this.t = LazyKt.lazy(MatchRoomGiftTrayWidget$assetManager$2.INSTANCE);
        this.u = new a(this);
        this.v = new b(this);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray.GiftTrayWidget
    public final void onLoad(Object[] r7) {
        super.onLoad(r7);
        ((Widget) this).dataCenter.observe("match_is_public_interact_tab", this.u);
        Long r1 = null;
        if (((Boolean) com.bytedance.android.livesdk.gift.platform.core.h.N.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[38])).booleanValue() == false) goto L7;
        View r8 = ((Widget) this).contentView;
        if (r8 == null) goto L7;
        r8.postDelayed(this.v, ((long) RangesKt.random(new IntRange(2, 5), Random.Default)) * 1000);
    L7:
        DataCenter r9 = ((Widget) this).dataCenter;
        if (r9 == null) goto L10;
        r1 = (Long) r9.get("multi_selected_tab_id", 0L);
    L10:
        if (r1 != null) goto L13;
    L15:
        boolean r10 = false;
    L16:
        this.s = r10;
        Eq();
        return;
    L13:
        if (r1.longValue() != 0) goto L15;
        r10 = true;
        goto L16
    }
}
