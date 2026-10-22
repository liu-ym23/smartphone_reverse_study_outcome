package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officewebview.bridge.Status;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.MmEndWindowWebHelper$updateTitle$1", f = "MmEndWindowWebHelper.kt", i = {}, l = {444}, m = "invokeSuspend", n = {}, s = {})
final class MmEndWindowWebHelper$updateTitle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ xwb.j $callback;
    final /* synthetic */ String $newTitle;
    int label;
    final /* synthetic */ MmEndWindowWebHelper this$0;

    public MmEndWindowWebHelper$updateTitle$1(MmEndWindowWebHelper r1, String r2, xwb.j r3, Continuation<? super MmEndWindowWebHelper$updateTitle$1> r4) {
        this.this$0 = r1;
        this.$newTitle = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MmEndWindowWebHelper$updateTitle$1(this.this$0, this.$newTitle, this.$callback, r5);
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
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
        Object r9 = ((Result) r8).unbox-impl();
    L11:
        MmEndWindowWebHelper r2 = this.this$0;
        String r3 = this.$newTitle;
        xwb.j r4 = this.$callback;
        if (Result.isSuccess-impl(r9) == false) goto L14;
        String r5 = (String) r9;
        r2.h = r3;
        int r6 = bwb.b.a;
        bwb.b.f(MmUiLogScene.WEB, "updateTitle", "success, newTitle=" + r3, r2.f());
        r4.a(Status.SUCCESS, new JSONObject().put("titleName", r3));
    L14:
        MmEndWindowWebHelper r7 = this.this$0;
        xwb.j r10 = this.$callback;
        Throwable r11 = Result.exceptionOrNull-impl(r9);
        if (r11 == null) goto L22;
        int r12 = bwb.b.a;
        bwb.b.d(MmUiLogScene.WEB, "updateTitle", "error=" + r11.getMessage(), r7.f());
        if (com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.c.a() == false) goto L19;
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.f(2131892864);
    L20:
        r10.a(Status.FAILURE, "{\"error\":\"" + r11.getMessage() + "\"}");
        goto L22
    L19:
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.a(2131892883);
    L22:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        w r13 = this.this$0.e;
        String r14 = this.$newTitle;
        this.label = 1;
        r9 = r13.o(r14, this);
        if (r9 != r0) goto L11;
        return r0;
    }
}
