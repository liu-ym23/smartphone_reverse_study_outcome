package com.bytedance.ai.applet.app;

import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.ai.applet.app.view.AppletActionSheetDialog;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$;
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.app.AppletEightScreenActivity$observePinMenuStatus$2", f = "AppletEightScreenActivity.kt", i = {}, l = {388}, m = "invokeSuspend", n = {}, s = {})
final class AppletEightScreenActivity$observePinMenuStatus$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppletApplication $app;
    final /* synthetic */ AppletActionSheetDialog $dialog;
    int label;
    final /* synthetic */ AppletEightScreenActivity this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ AppletEightScreenActivity a;
        public final /* synthetic */ AppletActionSheetDialog b;
        public final /* synthetic */ AppletApplication c;

        public a(AppletEightScreenActivity r1, AppletActionSheetDialog r10, AppletApplication r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }

        public final Object emit(Object r10, Continuation r11) {
            ((Boolean) r10).booleanValue();
            AppCompatDialog r12 = this.a.v;
            AppCompatDialog r13 = this.b;
            if (r12 == r13) goto L5;
        L8:
            Job r14 = this.a.w;
            if (r14 == null) goto L11;
            Job.DefaultImpls.cancel$default(r14, null, 1, null);
        L11:
            this.a.w = null;
            return Unit.INSTANCE;
        L5:
            if (r13.isShowing() == false) goto L8;
            AppletActionSheetDialog r15 = this.b;
            List<com.bytedance.ai.applet.app.view.m> r16 = CollectionsKt.toList(this.c.n.a.values());
            List<com.bytedance.ai.applet.app.view.m> r0 = AppletEightScreenActivity.c2(this.a, this.c);
            r15.getClass();
            Intrinsics.checkNotNullParameter(r16, "firstRowMenuItems");
            Intrinsics.checkNotNullParameter(r0, "secondRowMenuItems");
            r15.d.submit(r16);
            r15.e.submit(r0);
            r15.J0();
            return Unit.INSTANCE;
        }
    }

    public AppletEightScreenActivity$observePinMenuStatus$2(AppletApplication r1, AppletEightScreenActivity r10, AppletActionSheetDialog r11, Continuation<? super AppletEightScreenActivity$observePinMenuStatus$2> r12) {
        this.$app = r1;
        this.this$0 = r10;
        this.$dialog = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AppletEightScreenActivity$observePinMenuStatus$2(this.$app, this.this$0, this.$dialog, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        AppletApplication r11 = this.$app;
        b1 r12 = r11.i;
        a r13 = new a(this.this$0, this.$dialog, r11);
        this.label = 1;
        Object r14 = r12.collect(new FlowKt__TransformKt$filterNotNull$.inlined.unsafeTransform.1.2(r13), this);
        if (r14 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        r14 = Unit.INSTANCE;
    L12:
        if (r14 != r0) goto L15;
        return r0;
    }
}
