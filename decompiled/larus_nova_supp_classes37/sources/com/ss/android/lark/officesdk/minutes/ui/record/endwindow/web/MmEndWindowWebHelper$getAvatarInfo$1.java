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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.MmEndWindowWebHelper$getAvatarInfo$1", f = "MmEndWindowWebHelper.kt", i = {}, l = {568}, m = "invokeSuspend", n = {}, s = {})
final class MmEndWindowWebHelper$getAvatarInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $avatarSize;
    final /* synthetic */ xwb.j $callback;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmEndWindowWebHelper this$0;

    public MmEndWindowWebHelper$getAvatarInfo$1(MmEndWindowWebHelper r1, int r2, xwb.j r3, Continuation<? super MmEndWindowWebHelper$getAvatarInfo$1> r4) {
        this.this$0 = r1;
        this.$avatarSize = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        MmEndWindowWebHelper$getAvatarInfo$1 r0 = new MmEndWindowWebHelper$getAvatarInfo$1(this.this$0, this.$avatarSize, this.$callback, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L15
    L13:
        Object r8 = Result.constructor-impl((JSONArray) r7);     // Catch: Throwable -> L15
    L17:
        xwb.j r2 = this.$callback;
        if (Result.isSuccess-impl(r8) == false) goto L20;
        JSONObject r3 = new JSONObject();
        r3.put("avatarList", (JSONArray) r8);
        r2.a(Status.SUCCESS, r3.toString());
    L20:
        xwb.j r4 = this.$callback;
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L24;
        int r5 = bwb.b.a;
        bwb.b.d(MmUiLogScene.WEB, "getAvatarInfo", "error=" + r9.getMessage(), null);
        r4.a(Status.FAILURE, "{\"error\":\"" + r9.getMessage() + "\"}");
    L24:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
        CoroutineScope r10 = (CoroutineScope) this.L$0;
        MmEndWindowWebHelper r11 = this.this$0;
        int r6 = this.$avatarSize;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L15
        CoroutineDispatcher r13 = Dispatchers.getIO();     // Catch: Throwable -> L15
        MmEndWindowWebHelper$getAvatarInfo$1$1$1 r14 = new MmEndWindowWebHelper$getAvatarInfo$1$1$1(r11, r6, null);     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r7 = BuildersKt.withContext(r13, r14, this);     // Catch: Throwable -> L15
        if (r7 != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }
}
