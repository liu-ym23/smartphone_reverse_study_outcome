package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t extends DynamicFactor<Integer> {
    public Disposable b;
    public final DataCenter c;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ t a;

        public b(t r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (((Boolean) r2).booleanValue() == false) goto L5;
            this.a.update(1);
            return;
        L5:
            this.a.update(0);
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        return 0;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "live_room_ps_width";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
        InteractionWidgetsPosContext r0 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, this.c, 0, 2);
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m r1 = r0.isPublicScreenWidthHalfMode();
        if (r1 == null) goto L9;
        Observable r2 = r1.a();
        if (r2 == null) goto L9;
        Disposable r3 = r2.subscribe(new b(this));
    L10:
        this.b = r3;
        return;
    L9:
        r3 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
        Disposable r0 = this.b;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public t(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.c = r2;
    }
}
