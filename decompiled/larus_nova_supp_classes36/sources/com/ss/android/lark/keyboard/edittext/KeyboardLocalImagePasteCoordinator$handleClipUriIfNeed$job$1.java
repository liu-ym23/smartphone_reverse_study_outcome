package com.ss.android.lark.keyboard.edittext;

import android.database.Cursor;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.photopicker.entity.Photo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.edittext.KeyboardLocalImagePasteCoordinator$handleClipUriIfNeed$job$1", f = "KeyboardLocalImagePasteCoordinator.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
final class KeyboardLocalImagePasteCoordinator$handleClipUriIfNeed$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Cursor $cursor;
    final /* synthetic */ FlowKeyboardFunctionEditText.b $onPasteImageListener;
    int label;
    final /* synthetic */ d this$0;

    public KeyboardLocalImagePasteCoordinator$handleClipUriIfNeed$job$1(d r1, Cursor r2, FlowKeyboardFunctionEditText.b r3, Continuation<? super KeyboardLocalImagePasteCoordinator$handleClipUriIfNeed$job$1> r4) {
        this.this$0 = r1;
        this.$cursor = r2;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new KeyboardLocalImagePasteCoordinator$handleClipUriIfNeed$job$1(this.this$0, this.$cursor, null, r5);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        Photo r8 = (Photo) r7;
        this.$cursor.close();
        if (r8 != null) goto L16;
        Log.i("KeyboardLocalImagePasteCoordinator", "query image, find null, method return");
        return Unit.INSTANCE;
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        d r9 = this.this$0;
        ExecutorCoroutineDispatcher r2 = r9.c;
        KeyboardLocalImagePasteCoordinator$handleClipUriIfNeed$job$1$photo$1 r3 = new KeyboardLocalImagePasteCoordinator$handleClipUriIfNeed$job$1$photo$1(r9, this.$cursor, null);
        this.label = 1;
        r7 = BuildersKt.withContext(r2, r3, this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
