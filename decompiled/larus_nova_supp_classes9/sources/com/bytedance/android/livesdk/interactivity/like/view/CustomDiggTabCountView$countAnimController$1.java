package com.bytedance.android.livesdk.interactivity.like.view;

import com.bytedance.android.livesdk.utils.q4;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/utils/q4;", BuildConfig.FLAVOR, "invoke", "(Lcom/bytedance/android/livesdk/utils/q4;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class CustomDiggTabCountView$countAnimController$1 extends Lambda implements Function1<q4, Unit> {
    final /* synthetic */ CustomDiggTabCountView this$0;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.like.view.CustomDiggTabCountView$countAnimController$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/utils/q4;", BuildConfig.FLAVOR, "invoke", "(Lcom/bytedance/android/livesdk/utils/q4;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass3 extends Lambda implements Function1<q4, Unit> {
        final /* synthetic */ CustomDiggTabCountView$countAnimController$1 this$0;

        public AnonymousClass3(CustomDiggTabCountView$countAnimController$1 r1) {
            this.this$0 = r1;
            super(1);
        }

        public final void invoke(q4 r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            r2.c(new AnonymousClass1(this));
            r2.b(new AnonymousClass2(this));
            r2.b(new C01783(this));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((q4) r1);
            return Unit.INSTANCE;
        }
    }

    public CustomDiggTabCountView$countAnimController$1(CustomDiggTabCountView r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(q4 r2) {
        Intrinsics.checkNotNullParameter(r2, "$receiver");
        r2.e = new AnonymousClass1(this);
        r2.f = new AnonymousClass2(this);
        r2.d(new AnonymousClass3(this));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((q4) r1);
        return Unit.INSTANCE;
    }
}
