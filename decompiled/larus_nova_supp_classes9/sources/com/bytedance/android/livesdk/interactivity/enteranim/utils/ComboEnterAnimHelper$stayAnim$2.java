package com.bytedance.android.livesdk.interactivity.enteranim.utils;

import com.bytedance.android.live.base.model.message.u0;
import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.z;
import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.android.livesdk.utils.u4;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/utils/q4$b;", "invoke", "()Lcom/bytedance/android/livesdk/utils/q4$b;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class ComboEnterAnimHelper$stayAnim$2 extends Lambda implements Function0<q4.b> {
    final /* synthetic */ b this$0;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.enteranim.utils.ComboEnterAnimHelper$stayAnim$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/utils/q4;", BuildConfig.FLAVOR, "invoke", "(Lcom/bytedance/android/livesdk/utils/q4;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function1<q4, Unit> {
        final /* synthetic */ ComboEnterAnimHelper$stayAnim$2 this$0;

        public AnonymousClass1(ComboEnterAnimHelper$stayAnim$2 r1) {
            this.this$0 = r1;
            super(1);
        }

        public final void invoke(q4 r4) {
            Intrinsics.checkNotNullParameter(r4, "$receiver");
            u0 r0 = ((z) this.this$0.this$0.k).c;
            if (r0 == null) goto L5;
            final long r1 = r0.getStayTime();
        L6:
            r4.b(new C01591(this, r1));
            return;
        L5:
            r1 = 2000;
            goto L6
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((q4) r1);
            return Unit.INSTANCE;
        }
    }

    public ComboEnterAnimHelper$stayAnim$2(b r1) {
        this.this$0 = r1;
        super(0);
    }

    public final q4.b invoke() {
        return u4.b(false, new AnonymousClass1(this));
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m670invoke() {
        return invoke();
    }
}
