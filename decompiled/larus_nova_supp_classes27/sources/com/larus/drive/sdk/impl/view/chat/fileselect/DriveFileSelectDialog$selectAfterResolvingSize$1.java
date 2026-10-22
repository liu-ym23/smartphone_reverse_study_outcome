package com.larus.drive.sdk.impl.view.chat.fileselect;

import com.larus.drive.sdk.api.file.DriveFileItem;
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
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.view.chat.fileselect.DriveFileSelectDialog$selectAfterResolvingSize$1", f = "DriveFileSelectDialog.kt", i = {}, l = {775, 777}, m = "invokeSuspend", n = {}, s = {})
final class DriveFileSelectDialog$selectAfterResolvingSize$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DriveFileItem $file;
    int label;
    final /* synthetic */ DriveFileSelectDialog this$0;

    /* JADX INFO: renamed from: com.larus.drive.sdk.impl.view.chat.fileselect.DriveFileSelectDialog$selectAfterResolvingSize$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.drive.sdk.impl.view.chat.fileselect.DriveFileSelectDialog$selectAfterResolvingSize$1$1", f = "DriveFileSelectDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DriveFileItem $file;
        final /* synthetic */ DriveFileItem $resolvedFile;
        int label;
        final /* synthetic */ DriveFileSelectDialog this$0;

        public AnonymousClass1(DriveFileSelectDialog r1, DriveFileItem r2, DriveFileItem r3, Continuation<? super AnonymousClass1> r4) {
            this.this$0 = r1;
            this.$file = r2;
            this.$resolvedFile = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.this$0, this.$file, this.$resolvedFile, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            this.this$0.p.remove(this.$file.b);
            DriveFileSelectDialog.U90(this.this$0, this.$resolvedFile);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DriveFileSelectDialog$selectAfterResolvingSize$1(DriveFileSelectDialog r1, DriveFileItem r2, Continuation<? super DriveFileSelectDialog$selectAfterResolvingSize$1> r3) {
        this.this$0 = r1;
        this.$file = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DriveFileSelectDialog$selectAfterResolvingSize$1(this.this$0, this.$file, r4);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r8);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
    L13:
        long r3 = ((Number) r8).longValue();
        DriveFileSelectDialog r9 = this.this$0;
        DriveFileItem r2 = this.$file;
        int r5 = DriveFileSelectDialog.t;
        r9.getClass();
        DriveFileItem r10 = DriveFileSelectDialog.ea0(r2, r3);
        MainCoroutineDispatcher r4 = Dispatchers.getMain();
        AnonymousClass1 r6 = new AnonymousClass1(this.this$0, this.$file, r10, null);
        this.label = 2;
        if (BuildersKt.withContext(r4, r6, this) != r0) goto L17;
        return r0;
    L10:
        ResultKt.throwOnFailure(r8);
        DriveFileSelectDialog r11 = this.this$0;
        DriveFileItem r7 = this.$file;
        this.label = 1;
        r8 = DriveFileSelectDialog.S90(r11, r7, this);
        if (r8 != r0) goto L13;
        return r0;
    }
}
