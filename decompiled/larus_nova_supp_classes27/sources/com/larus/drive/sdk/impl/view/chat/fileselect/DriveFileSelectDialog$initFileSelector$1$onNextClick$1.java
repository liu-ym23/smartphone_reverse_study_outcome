package com.larus.drive.sdk.impl.view.chat.fileselect;

import com.larus.platform.api.FlowDriveFileType;
import com.larus.platform.api.fileselect.IChatFileSelectionStore;
import java.util.List;
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
@DebugMetadata(c = "com.larus.drive.sdk.impl.view.chat.fileselect.DriveFileSelectDialog$initFileSelector$1$onNextClick$1", f = "DriveFileSelectDialog.kt", i = {}, l = {526, 527}, m = "invokeSuspend", n = {}, s = {})
public final class DriveFileSelectDialog$initFileSelector$1$onNextClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<com.larus.platform.api.u> $selectedList;
    final /* synthetic */ String $tag;
    int label;
    final /* synthetic */ DriveFileSelectDialog this$0;
    final /* synthetic */ DriveFileSelectDialog$initFileSelector$1 this$1;

    /* JADX INFO: renamed from: com.larus.drive.sdk.impl.view.chat.fileselect.DriveFileSelectDialog$initFileSelector$1$onNextClick$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.drive.sdk.impl.view.chat.fileselect.DriveFileSelectDialog$initFileSelector$1$onNextClick$1$1", f = "DriveFileSelectDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DriveFileSelectDialog.c $resolved;
        final /* synthetic */ String $tag;
        int label;
        final /* synthetic */ DriveFileSelectDialog$initFileSelector$1 this$0;
        final /* synthetic */ DriveFileSelectDialog this$1;

        public AnonymousClass1(DriveFileSelectDialog.c r1, DriveFileSelectDialog$initFileSelector$1 r2, String r3, DriveFileSelectDialog r4, Continuation<? super AnonymousClass1> r5) {
            this.$resolved = r1;
            this.this$0 = r2;
            this.$tag = r3;
            this.this$1 = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.$resolved, this.this$0, this.$tag, this.this$1, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r4);
            DriveFileSelectDialog.c r5 = this.$resolved;
            IChatFileSelectionStore.a r0 = r5.b;
            if (r0 == null) goto L8;
            DriveFileSelectDialog r1 = this.this$1;
            FlowDriveFileType r6 = r5.c;
            int r2 = DriveFileSelectDialog.t;
            r1.ba0(r0, r6);
            return Unit.INSTANCE;
        L8:
            this.this$0.c(this.$tag, r5.a);
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DriveFileSelectDialog$initFileSelector$1$onNextClick$1(DriveFileSelectDialog r1, List<com.larus.platform.api.u> r2, DriveFileSelectDialog$initFileSelector$1 r3, String r4, Continuation<? super DriveFileSelectDialog$initFileSelector$1$onNextClick$1> r5) {
        this.this$0 = r1;
        this.$selectedList = r2;
        this.this$1 = r3;
        this.$tag = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DriveFileSelectDialog$initFileSelector$1$onNextClick$1(this.this$0, this.$selectedList, this.this$1, this.$tag, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r10);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
    L13:
        DriveFileSelectDialog.c r4 = (DriveFileSelectDialog.c) r10;
        MainCoroutineDispatcher r11 = Dispatchers.getMain();
        AnonymousClass1 r2 = new AnonymousClass1(r4, this.this$1, this.$tag, this.this$0, null);
        this.label = 2;
        if (BuildersKt.withContext(r11, r2, this) != r0) goto L17;
        return r0;
    L10:
        ResultKt.throwOnFailure(r10);
        DriveFileSelectDialog r12 = this.this$0;
        List<com.larus.platform.api.u> r3 = this.$selectedList;
        this.label = 1;
        r10 = DriveFileSelectDialog.T90(r12, r3, this);
        if (r10 != r0) goto L13;
        return r0;
    }
}
