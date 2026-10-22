package com.larus.drive.sdk.impl.view.chat.fileselect;

import com.larus.drive.sdk.api.file.DriveFileItem;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.view.chat.fileselect.DriveFileSelectDialog$warmUpDriveFileSize$1", f = "DriveFileSelectDialog.kt", i = {}, l = {759, 760}, m = "invokeSuspend", n = {}, s = {})
final class DriveFileSelectDialog$warmUpDriveFileSize$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DriveFileItem $file;
    int label;
    final /* synthetic */ DriveFileSelectDialog this$0;

    /* JADX INFO: renamed from: com.larus.drive.sdk.impl.view.chat.fileselect.DriveFileSelectDialog$warmUpDriveFileSize$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.drive.sdk.impl.view.chat.fileselect.DriveFileSelectDialog$warmUpDriveFileSize$1$1", f = "DriveFileSelectDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DriveFileItem $file;
        int label;
        final /* synthetic */ DriveFileSelectDialog this$0;

        public AnonymousClass1(DriveFileSelectDialog r1, DriveFileItem r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$file = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$file, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r2);
            if (Intrinsics.areEqual(this.this$0.p.remove(this.$file.b), Boxing.boxBoolean(true)) == false) goto L8;
            DriveFileSelectDialog.U90(this.this$0, this.$file);
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DriveFileSelectDialog$warmUpDriveFileSize$1(DriveFileSelectDialog r1, DriveFileItem r2, Continuation<? super DriveFileSelectDialog$warmUpDriveFileSize$1> r3) {
        this.this$0 = r1;
        this.$file = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DriveFileSelectDialog$warmUpDriveFileSize$1(this.this$0, this.$file, r4);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r7);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L13:
        MainCoroutineDispatcher r8 = Dispatchers.getMain();
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0, this.$file, null);
        this.label = 2;
        if (BuildersKt.withContext(r8, r2, this) != r0) goto L17;
        return r0;
    L10:
        ResultKt.throwOnFailure(r7);
        DriveFileSelectDialog r9 = this.this$0;
        DriveFileItem r3 = this.$file;
        this.label = 1;
        if (DriveFileSelectDialog.S90(r9, r3, this) != r0) goto L13;
        return r0;
    }
}
