package com.bytedance.android.live.profit.redpacket;

import android.view.View;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"loadAnnieCard", "", "invoke", "com/bytedance/android/live/profit/redpacket/RedpacketClientIconModel$getViewForState$1$1"}, k = 3, mv = {1, 4, 3})
final class RedpacketClientIconModel$getViewForState$$inlined$apply$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ h1 $state$inlined;
    final /* synthetic */ xr2.g $this_apply;
    final /* synthetic */ long $timestamp;
    final /* synthetic */ b1 this$0;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ RedpacketClientIconModel$getViewForState$$inlined$apply$lambda$1 a;

        public a(RedpacketClientIconModel$getViewForState$$inlined$apply$lambda$1 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.this$0.onClick();
        }
    }

    public RedpacketClientIconModel$getViewForState$$inlined$apply$lambda$1(xr2.g r1, long r2, b1 r4, h1 r5) {
        this.$this_apply = r1;
        this.$timestamp = r2;
        this.this$0 = r4;
        this.$state$inlined = r5;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m213invoke() {
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a r3 = null;
        com.bytedance.android.live.revenue.common.x0 r0 = new com.bytedance.android.live.revenue.common.x0((String) i1.n.getValue(null, i1.a[11]));
        r0.d("url").b("timestamp", String.valueOf(this.$timestamp));
        b1 r1 = this.this$0;
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a r2 = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).q8(this.this$0.getContext(), r0.c(), RedpacketClientIconModel$getViewForState$1$1$1.INSTANCE);
        if (r2 == null) goto L14;
        b1 r4 = this.this$0;
        String r5 = ((h1.b) this.$state$inlined).b;
        boolean r6 = b1.m;
        r4.getClass();
        xy0.a<?> r7 = r2.g();
        if (r7 == null) goto L7;
        r7.updateGlobalProps(MapsKt.mapOf(TuplesKt.to("data_from_native", r5)));
    L7:
        this.$this_apply.setContentView(r2.c);
        View r8 = this.$this_apply.getContentView();
        if (r8 == null) goto L10;
        r8.setOnClickListener(new a(this));
    L10:
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a.b r9 = r2.d;
        if (r9 == null) goto L13;
        r9.load(null, null);
    L13:
        Unit r10 = Unit.INSTANCE;
        r3 = r2;
    L14:
        r1.f = r3;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m213invoke();
        return Unit.INSTANCE;
    }
}
