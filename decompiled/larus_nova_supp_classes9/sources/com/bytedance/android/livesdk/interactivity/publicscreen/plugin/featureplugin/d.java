package com.bytedance.android.livesdk.interactivity.publicscreen.plugin.featureplugin;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.PublicScreenContext;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.k;
import com.bytedance.android.livesdk.interactivity.api.l;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.plugin.FeaturePluginType;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import u22.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements k {
    public final FeaturePluginType a;
    public Disposable b;
    public final PublicScreenContext c;
    public final DataCenter d;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            h r8 = (h) r7;
            final long r4 = r8.a;
            final long r2 = r8.b;
            Function1<f<?>, Boolean> r9 = new FloatMessageExitPlugin$onLoad$1$needExit$1(this, r2, r4);
            l r0 = (l) this.a.c.getMessageLogicFacade().getValue();
            if (r0 == null) goto L6;
            r0.C(r9);
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r3) {
            ALogger.e("FloatMessageExit", "error:" + ((Throwable) r3));
        }
    }

    @Override // v42.a
    public final void onDestroy() {
    }

    @Override // v42.a
    public final void onInit() {
    }

    @Override // v42.a
    public final void onLoad() {
        Disposable r0 = this.b;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.b = RxBusAbility.INSTANCE.getRxBus(this.d).b(h.class).subscribe(new a(this), b.a);
    }

    @Override // v42.a
    public final void onUnload() {
        Disposable r0 = this.b;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.k, v42.a
    public FeaturePluginType getType() {
        return this.a;
    }

    public d(PublicScreenContext r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "publicScreenContext");
        Intrinsics.checkNotNullParameter(r3, "dc");
        this.c = r2;
        this.d = r3;
        this.a = FeaturePluginType.FloatMessageExit;
    }
}
