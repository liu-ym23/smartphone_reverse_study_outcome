package com.larus.drive.sdk.impl.view.chat.fileselect;

import com.larus.common_ui.widget.ChatFileSelectorView;
import com.larus.drive.sdk.impl.databinding.LarusDialogDriveFileSelectBinding;
import java.util.LinkedHashMap;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.view.chat.fileselect.DriveFileSelectDialog$initFileSelector$2", f = "DriveFileSelectDialog.kt", i = {}, l = {558}, m = "invokeSuspend", n = {}, s = {})
final class DriveFileSelectDialog$initFileSelector$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DriveFileSelectDialog this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ DriveFileSelectDialog a;

        public a(DriveFileSelectDialog r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            LinkedHashMap r3 = (LinkedHashMap) r1;
            LarusDialogDriveFileSelectBinding r4 = this.a.f;
            if (r4 == null) goto L8;
            ChatFileSelectorView r5 = r4.g;
            if (r5 == null) goto L8;
            r5.setSelectedList(CollectionsKt.toList(r3.values()));
        L8:
            return Unit.INSTANCE;
        }
    }

    public DriveFileSelectDialog$initFileSelector$2(DriveFileSelectDialog r1, Continuation<? super DriveFileSelectDialog$initFileSelector$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DriveFileSelectDialog$initFileSelector$2(this.this$0, r3);
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
        StateFlowImpl r6 = this.this$0.n.getState();
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
