package com.ss.android.lark.compose.groupinfo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.groupinfo.FlowGroupInfoActivity$onCreate$2$1$1$1$1", f = "FlowGroupInfoActivity.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
public final class FlowGroupInfoActivity$onCreate$2$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ActivityResultLauncher<String> $pickLauncher;
    final /* synthetic */ ActivityResultLauncher<Intent> $pickSDKLauncher;
    final /* synthetic */ Lazy<GroupInfoViewModel> $viewModel$delegate;
    int label;
    final /* synthetic */ FlowGroupInfoActivity this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ Context a;
        public final /* synthetic */ FlowGroupInfoActivity b;
        public final /* synthetic */ ActivityResultLauncher<String> c;
        public final /* synthetic */ ActivityResultLauncher<Intent> d;

        /* JADX INFO: renamed from: com.ss.android.lark.compose.groupinfo.FlowGroupInfoActivity$onCreate$2$1$1$1$1$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0148a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[GroupInfoToast.values().length];
                r0[GroupInfoToast.SAVE_SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[GroupInfoToast.EDIT_NOT_ALLOWED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        public a(Context r1, FlowGroupInfoActivity r2, ActivityResultLauncher<String> r3, ActivityResultLauncher<Intent> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final Object emit(Object r3, Continuation r4) {
            b r5 = (b) r3;
            if ((r5 instanceof b.d) == false) goto L14;
            Context r6 = this.a;
            GroupInfoToast r7 = ((b.d) r5).a;
            int r8 = C0148a.a[r7.ordinal()];
            if (r8 != 1) goto L7;
            int r9 = 2131892146;
        L12:
            FlowToast.c(r6, r9);
        L28:
            return Unit.INSTANCE;
        L7:
            if (r8 != 2) goto L10;
            r9 = 2131890111;
            goto L12
        L10:
            throw new NoWhenBranchMatchedException();
        L14:
            if ((r5 instanceof b.c) == false) goto L17;
            com.ss.android.lark.compose.util.a.a(this.a, ((b.c) r5).a);
            goto L28
        L17:
            if ((r5 instanceof b.a) == false) goto L25;
            Context r10 = this.a;
            if ((r10 instanceof Activity) == false) goto L21;
            Activity r11 = (Activity) r10;
        L22:
            if (r11 == null) goto L28;
            r11.finish();
            goto L28
        L21:
            r11 = null;
            goto L22
        L25:
            if ((r5 instanceof b.C0149b) == false) goto L30;
            c.b("FlowGroupInfoActivity pickAvatar");
            ((rza.a) this.b.b.getValue()).w0(this.a, this.c, this.d);
            goto L28
        L30:
            throw new NoWhenBranchMatchedException();
        }
    }

    public FlowGroupInfoActivity$onCreate$2$1$1$1$1(Lazy<GroupInfoViewModel> r1, Context r2, FlowGroupInfoActivity r3, ActivityResultLauncher<String> r4, ActivityResultLauncher<Intent> r5, Continuation<? super FlowGroupInfoActivity$onCreate$2$1$1$1$1> r6) {
        this.$viewModel$delegate = r1;
        this.$context = r2;
        this.this$0 = r3;
        this.$pickLauncher = r4;
        this.$pickSDKLauncher = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new FlowGroupInfoActivity$onCreate$2$1$1$1$1(this.$viewModel$delegate, this.$context, this.this$0, this.$pickLauncher, this.$pickSDKLauncher, r9);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r8);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        Lazy<GroupInfoViewModel> r9 = this.$viewModel$delegate;
        int r2 = FlowGroupInfoActivity.c;
        d1<b> r10 = ((GroupInfoViewModel) r9.getValue()).getEffect();
        a r3 = new a(this.$context, this.this$0, this.$pickLauncher, this.$pickSDKLauncher);
        this.label = 1;
        if (r10.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
