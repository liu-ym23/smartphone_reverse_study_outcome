package com.bytedance.android.livesdk.gift.platform.business.effect.giftview;

import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lwy0/e;", "it", BuildConfig.FLAVOR, "invoke", "(Lwy0/e;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class GestureGiftGuideView$showLynxView$3 extends Lambda implements Function1<wy0.e, Unit> {
    final /* synthetic */ GestureGiftGuideView this$0;

    public static final class a extends com.bytedance.ies.web.jsbridge2.g<Object, Object> {
        public final /* synthetic */ GestureGiftGuideView$showLynxView$3 a;

        public a(GestureGiftGuideView$showLynxView$3 r1) {
            this.a = r1;
        }

        public final Object invoke(Object r2, CallContext r3) {
            Intrinsics.checkNotNullParameter(r2, "params");
            Intrinsics.checkNotNullParameter(r3, "context");
            this.a.this$0.a();
            ViewParent r4 = this.a.this$0.getParent();
            if ((r4 instanceof ViewGroup) == true) goto L5;
            r4 = null;
        L5:
            ViewGroup r5 = (ViewGroup) r4;
            if (r5 == null) goto L8;
            r5.removeView(this.a.this$0);
        L8:
            return null;
        }
    }

    public GestureGiftGuideView$showLynxView$3(GestureGiftGuideView r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(wy0.e r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        r3.registerMethod("close", new a(this));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((wy0.e) r1);
        return Unit.INSTANCE;
    }
}
