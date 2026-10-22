package com.bytedance.android.livesdk.interactivity.comment.record.view;

import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/utils/q4;", BuildConfig.FLAVOR, "invoke", "(Lcom/bytedance/android/livesdk/utils/q4;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class LiveHighlightRecordController$createLeftBallExpandAnimator$1 extends Lambda implements Function1<q4, Unit> {
    final /* synthetic */ float $currentRedDotAlpha;
    final /* synthetic */ LiveHighlightRecordController this$0;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.comment.record.view.LiveHighlightRecordController$createLeftBallExpandAnimator$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/utils/q4;", BuildConfig.FLAVOR, "invoke", "(Lcom/bytedance/android/livesdk/utils/q4;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function1<q4, Unit> {
        final /* synthetic */ LiveHighlightRecordController$createLeftBallExpandAnimator$1 this$0;

        public AnonymousClass1(LiveHighlightRecordController$createLeftBallExpandAnimator$1 r1) {
            this.this$0 = r1;
            super(1);
        }

        public final void invoke(q4 r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            r2.b(new C01351(this));
            r2.b(new AnonymousClass2(this));
            r2.b(new AnonymousClass3(this));
            r2.b(new AnonymousClass4(this));
            r2.b(new AnonymousClass5(this));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((q4) r1);
            return Unit.INSTANCE;
        }
    }

    public LiveHighlightRecordController$createLeftBallExpandAnimator$1(LiveHighlightRecordController r1, float r2) {
        this.this$0 = r1;
        this.$currentRedDotAlpha = r2;
        super(1);
    }

    public final void invoke(q4 r2) {
        Intrinsics.checkNotNullParameter(r2, "$receiver");
        r2.d(new AnonymousClass1(this));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((q4) r1);
        return Unit.INSTANCE;
    }
}
