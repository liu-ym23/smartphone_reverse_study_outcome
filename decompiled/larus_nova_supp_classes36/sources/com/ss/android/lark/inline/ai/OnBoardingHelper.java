package com.ss.android.lark.inline.ai;

import androidx.lifecycle.LifecycleOwnerKt;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;
import wlb.e;
import wlb.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class OnBoardingHelper {
    public final e a;
    public final nsb.b b;

    /* JADX INFO: renamed from: com.ss.android.lark.inline.ai.OnBoardingHelper$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.inline.ai.OnBoardingHelper$1", f = "OnBoardingHelper.kt", i = {}, l = {26}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ nsb.b $myAIApi;
        int label;
        final /* synthetic */ OnBoardingHelper this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.inline.ai.OnBoardingHelper$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ OnBoardingHelper a;

            public a(OnBoardingHelper r1) {
                this.a = r1;
            }

            public final Object emit(Object r2, Continuation r3) {
                boolean r4 = ((Boolean) r2).booleanValue();
                Log.i("InlineAISdkImpl", "needOnBoarding.collect it = " + r4);
                this.a.a.n(r4);
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(nsb.b r1, OnBoardingHelper r2, Continuation<? super AnonymousClass1> r3) {
            this.$myAIApi = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$myAIApi, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            i1<Boolean> r6 = this.$myAIApi.d();
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public static final class a {
    }

    static {
    }

    public OnBoardingHelper(h r7, e r8, nsb.b r9) {
        Intrinsics.checkNotNullParameter(r7, "config");
        Intrinsics.checkNotNullParameter(r8, "callback");
        this.a = r8;
        this.b = r9;
        if (r9 != null) goto L5;
        Log.i("InlineAISdkImpl", "MyAIApi unavailable, skip onboarding observer and report false");
        r8.n(false);
        return;
    L5:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r7.getActivity()), null, null, new AnonymousClass1(r9, this, null), 3, null);
    }
}
