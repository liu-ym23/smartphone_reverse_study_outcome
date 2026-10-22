package com.ss.android.lark.profile_office.userprofile.dialog;

import androidx.compose.material3.SheetState;
import androidx.compose.material3.SheetValue;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.focus.FocusRequester;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.dialog.EditAliasDialogKt$EditAliasDialog$1$1", f = "EditAliasDialog.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {})
public final class EditAliasDialogKt$EditAliasDialog$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ SheetState $sheetState;
    int label;

    public EditAliasDialogKt$EditAliasDialog$1$1(FocusRequester r1, SheetState r2, Continuation<? super EditAliasDialogKt$EditAliasDialog$1$1> r3) {
        this.$focusRequester = r1;
        this.$sheetState = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new EditAliasDialogKt$EditAliasDialog$1$1(this.$focusRequester, this.$sheetState, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        FocusRequester.requestFocus-3ESFkO8$default(this.$focusRequester, 0, 1, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        final SheetState r2 = this.$sheetState;
        final Flow r5 = SnapshotStateKt.snapshotFlow(new AnonymousClass1(r2));
        Flow<SheetValue> r3 = new EditAliasDialogKt$EditAliasDialog$1$1$invokeSuspend$$inlined$filter$1(r5);
        this.label = 1;
        if (e.s(r3, this) != r0) goto L11;
        return r0;
    }
}
