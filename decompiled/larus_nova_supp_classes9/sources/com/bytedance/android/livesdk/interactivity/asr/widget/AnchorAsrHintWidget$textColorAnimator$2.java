package com.bytedance.android.livesdk.interactivity.asr.widget;

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
public final class AnchorAsrHintWidget$textColorAnimator$2 extends Lambda implements Function0<q4.b> {
    final /* synthetic */ AnchorAsrHintWidget this$0;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.asr.widget.AnchorAsrHintWidget$textColorAnimator$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/utils/q4;", BuildConfig.FLAVOR, "invoke", "(Lcom/bytedance/android/livesdk/utils/q4;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function1<q4, Unit> {
        final /* synthetic */ AnchorAsrHintWidget$textColorAnimator$2 this$0;

        public AnonymousClass1(AnchorAsrHintWidget$textColorAnimator$2 r1) {
            this.this$0 = r1;
            super(1);
        }

        public final void invoke(q4 r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            r2.b(new C00981(this));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((q4) r1);
            return Unit.INSTANCE;
        }
    }

    public AnchorAsrHintWidget$textColorAnimator$2(AnchorAsrHintWidget r1) {
        this.this$0 = r1;
        super(0);
    }

    public final q4.b invoke() {
        return u4.c(new AnonymousClass1(this));
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m539invoke() {
        return invoke();
    }
}
