package com.suite.lark.platform.feature.forward.doubao.assembly.dependency;

import com.ss.android.lark.forwardv3.dependency.IExternalForwardExecutor;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.suite.lark.platform.feature.forward.doubao.assembly.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import mpc.b;
import mpc.c;
import mpc.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.suite.lark.platform.feature.forward.doubao.assembly.dependency.ForwardNewDependency$LarkToDoubaoExternalForwardExecutor$execute$1", f = "ForwardNewDependency.kt", i = {}, l = {320}, m = "invokeSuspend", n = {}, s = {})
public final class ForwardNewDependency$LarkToDoubaoExternalForwardExecutor$execute$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IExternalForwardExecutor.a $callback;
    final /* synthetic */ e $doubaoProtocol;
    final /* synthetic */ List<String> $larkMsgIds;
    final /* synthetic */ String $note;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ ForwardNewDependency.LarkToDoubaoExternalForwardExecutor this$0;

    public static final class a implements b {
        public final /* synthetic */ IExternalForwardExecutor.a a;

        @Override // mpc.b
        public final void onSuccess() {
            this.a.onSuccess(MapsKt.emptyMap());
        }

        public a(IExternalForwardExecutor.a r1) {
            this.a = r1;
        }

        @Override // mpc.b
        public final void onFailure(int r1, String r2) {
            Intrinsics.checkNotNullParameter(r2, "errorMessage");
            this.a.onFailure(r2);
        }
    }

    public ForwardNewDependency$LarkToDoubaoExternalForwardExecutor$execute$1(e r1, List<String> r2, String r3, ForwardNewDependency.LarkToDoubaoExternalForwardExecutor r4, IExternalForwardExecutor.a r5, Continuation<? super ForwardNewDependency$LarkToDoubaoExternalForwardExecutor$execute$1> r6) {
        this.$doubaoProtocol = r1;
        this.$larkMsgIds = r2;
        this.$note = r3;
        this.this$0 = r4;
        this.$callback = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ForwardNewDependency$LarkToDoubaoExternalForwardExecutor$execute$1(this.$doubaoProtocol, this.$larkMsgIds, this.$note, this.this$0, this.$callback, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L10;
        String r2 = (String) this.L$3;
        String r3 = (String) this.L$2;
        List<String> r4 = (List) this.L$1;
        e r5 = (e) this.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L31
        String r7 = r2;
        String r6 = r3;
        e r8 = r5;
    L8:
        List<String> r9 = r4;
        boolean r10 = ((Boolean) r13).booleanValue();     // Catch: Throwable -> L31
        ForwardNewDependency.LarkToDoubaoExternalForwardExecutor r14 = this.this$0;     // Catch: Throwable -> L31
        String r11 = r14.d;     // Catch: Throwable -> L31
        boolean r12 = r14.e;     // Catch: Throwable -> L31
        String r15 = r14.f;     // Catch: Throwable -> L31
        if (r12 == false) goto L28;
        boolean r16 = true;
    L29:
        r8.c0(new c(r9, r6, r7, r10, r11, r16, r15), new a(this.$callback));     // Catch: Throwable -> L31
    L38:
        return Unit.INSTANCE;
    L28:
        r16 = false;
        goto L29
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r13);
        e r17 = this.$doubaoProtocol;     // Catch: Throwable -> L31
        r4 = this.$larkMsgIds;     // Catch: Throwable -> L31
        String r18 = this.$note;     // Catch: Throwable -> L31
        String r19 = this.this$0.b;     // Catch: Throwable -> L31
        if ((!StringsKt.isBlank(r19)) == true) goto L16;
        r19 = null;
    L16:
        if (r19 != null) goto L18;
        r19 = d.a();     // Catch: Throwable -> L31
    L18:
        String r20 = this.this$0.d;     // Catch: Throwable -> L31
        this.L$0 = r17;     // Catch: Throwable -> L31
        this.L$1 = r4;     // Catch: Throwable -> L31
        this.L$2 = r18;     // Catch: Throwable -> L31
        this.L$3 = r19;     // Catch: Throwable -> L31
        this.label = 1;     // Catch: Throwable -> L31
        if (StringsKt.isBlank(r20) == false) goto L21;
        Object r21 = Boxing.boxBoolean(false);     // Catch: Throwable -> L31
    L22:
        if (r21 != r0) goto L24;
        return r0;
    L24:
        r7 = r19;
        r8 = r17;
        r13 = r21;
        r6 = r18;
        goto L8
    L21:
        r21 = BuildersKt.withContext(Dispatchers.getIO(), new ForwardNewDependency$LarkToDoubaoExternalForwardExecutor$isSourceGroupChat$2(r20, null), this);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        String r22 = "forward to doubao execute failed";
        Log.e("ForwardNewDependency", "forward to doubao execute failed", th);
        IExternalForwardExecutor.a r23 = this.$callback;
        String r110 = th.getMessage();
        if (r110 == null) goto L36;
        r22 = r110;
    L36:
        r23.onFailure(r22);
        goto L38
    }
}
