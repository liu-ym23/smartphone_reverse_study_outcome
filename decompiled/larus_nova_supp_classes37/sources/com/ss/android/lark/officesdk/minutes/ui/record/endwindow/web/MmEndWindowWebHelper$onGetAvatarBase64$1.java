package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officewebview.bridge.Status;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.MmEndWindowWebHelper$onGetAvatarBase64$1", f = "MmEndWindowWebHelper.kt", i = {}, l = {661}, m = "invokeSuspend", n = {}, s = {})
final class MmEndWindowWebHelper$onGetAvatarBase64$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $avatarSize;
    final /* synthetic */ xwb.j $callback;
    final /* synthetic */ MmGetAvatarBase64Param $getAvatarParam;
    int label;
    final /* synthetic */ MmEndWindowWebHelper this$0;

    public MmEndWindowWebHelper$onGetAvatarBase64$1(MmGetAvatarBase64Param r1, int r2, MmEndWindowWebHelper r3, xwb.j r4, Continuation<? super MmEndWindowWebHelper$onGetAvatarBase64$1> r5) {
        this.$getAvatarParam = r1;
        this.$avatarSize = r2;
        this.this$0 = r3;
        this.$callback = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MmEndWindowWebHelper$onGetAvatarBase64$1(this.$getAvatarParam, this.$avatarSize, this.this$0, this.$callback, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r4 = true;
        if (r2 == 0) goto L9;
        if (r2 != 1) goto L8;
        ResultKt.throwOnFailure(r10);     // Catch: Exception -> L19
    L13:
        String r11 = (String) r10;     // Catch: Exception -> L19
        int r3 = bwb.b.a;     // Catch: Exception -> L19
        MmUiLogScene r5 = MmUiLogScene.WEB;     // Catch: Exception -> L19
        StringBuilder r6 = new StringBuilder("success, param=");     // Catch: Exception -> L19
        r6.append(this.$getAvatarParam);     // Catch: Exception -> L19
        r6.append(", avatarSize=");     // Catch: Exception -> L19
        r6.append(this.$avatarSize);     // Catch: Exception -> L19
        r6.append(", hasAvatar=");     // Catch: Exception -> L19
        if (r11.length() > 0) goto L17;
        r4 = false;
    L17:
        r6.append(r4);     // Catch: Exception -> L19
        bwb.b.f(r5, "onGetAvatarBase64", r6.toString(), this.this$0.f());     // Catch: Exception -> L19
        this.$callback.a(Status.SUCCESS, r11);     // Catch: Exception -> L19
    L22:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
        CoroutineDispatcher r12 = Dispatchers.getIO();     // Catch: Exception -> L19
        MmEndWindowWebHelper$onGetAvatarBase64$1$base64Result$1 r7 = new MmEndWindowWebHelper$onGetAvatarBase64$1$base64Result$1(this.$getAvatarParam, this.this$0, this.$avatarSize, null);     // Catch: Exception -> L19
        this.label = 1;     // Catch: Exception -> L19
        r10 = BuildersKt.withContext(r12, r7, this);     // Catch: Exception -> L19
        if (r10 != r1) goto L13;
        return r1;
    L19:
        e = move-exception;
        int r0 = bwb.b.a;
        bwb.b.d(MmUiLogScene.WEB, "onGetAvatarBase64", "error=" + e.getMessage(), this.this$0.f());
        this.$callback.a(Status.FAILURE, "{\"error\":\"" + e.getMessage() + "\"}");
        goto L22
    }
}
