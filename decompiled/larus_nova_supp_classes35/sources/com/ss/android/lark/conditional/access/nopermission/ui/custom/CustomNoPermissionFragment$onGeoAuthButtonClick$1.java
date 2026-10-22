package com.ss.android.lark.conditional.access.nopermission.ui.custom;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.apm.impl.protector.RunnableProtector;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.conditional.access.nopermission.ui.custom.CustomNoPermissionFragment$onGeoAuthButtonClick$1", f = "CustomNoPermissionFragment.kt", i = {}, l = {1769}, m = "invokeSuspend", n = {}, s = {})
public final class CustomNoPermissionFragment$onGeoAuthButtonClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ scb.b $factorService;
    final /* synthetic */ u8b.b $loadingView;
    final /* synthetic */ ConstraintLayout $rootView;
    final /* synthetic */ long $startMs;
    int label;
    final /* synthetic */ CustomNoPermissionFragment this$0;

    public static final class a implements Runnable {
        public final /* synthetic */ CustomNoPermissionFragment a;
        public final /* synthetic */ u8b.b b;
        public final /* synthetic */ Object c;
        public final /* synthetic */ long d;

        public a(CustomNoPermissionFragment r1, u8b.b r2, Object r3, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        L17:
            return;
        L3:
            if (this.a.isAdded() == false) goto L13;
            u8b.b r0 = this.b;     // Catch: Throwable -> L10
            if (r0 == null) goto L8;
            r0.endLoading();     // Catch: Throwable -> L10
        L8:
            CustomNoPermissionFragment r5 = this.a;     // Catch: Throwable -> L10
            Object r2 = this.c;     // Catch: Throwable -> L10
            long r3 = this.d;     // Catch: Throwable -> L10
            int r1 = CustomNoPermissionFragment.u;     // Catch: Throwable -> L10
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r5.getViewLifecycleOwner()), null, null, new CustomNoPermissionFragment$handleGeoAuthResult$1(r2, r3, r5, null), 3, null);     // Catch: Throwable -> L10
            return;
        }
    }

    public CustomNoPermissionFragment$onGeoAuthButtonClick$1(scb.b r1, CustomNoPermissionFragment r2, Context r3, long r4, ConstraintLayout r6, u8b.b r7, Continuation<? super CustomNoPermissionFragment$onGeoAuthButtonClick$1> r8) {
        this.$factorService = r1;
        this.this$0 = r2;
        this.$context = r3;
        this.$startMs = r4;
        this.$rootView = r6;
        this.$loadingView = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new CustomNoPermissionFragment$onGeoAuthButtonClick$1(this.$factorService, this.this$0, this.$context, this.$startMs, this.$rootView, this.$loadingView, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r8);
        Object r9 = ((Result) r8).unbox-impl();
    L6:
        Object r4 = r9;
        if (this.this$0.isAdded() == false) goto L15;
        long r5 = System.currentTimeMillis() - this.$startMs;
        this.$rootView.post(new a(this.this$0, this.$loadingView, r4, r5));
        return Unit.INSTANCE;
    L15:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
        scb.b r10 = this.$factorService;
        this.this$0.getActivity();
        this.label = 1;
        r9 = r10.a();
        if (r9 != r0) goto L6;
        return r0;
    }
}
