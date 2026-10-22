package com.larus.bmhome.chat.component.share;

import androidx.collection.LruCache;
import by7.e;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common_ui.view.FileExportType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.share.FileExportTypeChooseDialog$onViewCreated$4$3", f = "FileExportTypeChooseDialog.kt", i = {}, l = {307, 309, 311}, m = "invokeSuspend", n = {}, s = {})
public final class FileExportTypeChooseDialog$onViewCreated$4$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FileExportTypeChooseDialog this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.share.FileExportTypeChooseDialog$onViewCreated$4$3$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.share.FileExportTypeChooseDialog$onViewCreated$4$3$2", f = "FileExportTypeChooseDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ FileExportTypeChooseDialog this$0;

        public AnonymousClass2(FileExportTypeChooseDialog r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
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
            int r3 = FileExportTypeChooseDialog.w;
            FileExportTypeChooseDialog.a.a(this.this$0);
            Function0<Unit> r4 = this.this$0.t;
            if (r4 == null) goto L8;
            r4.invoke();
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public FileExportTypeChooseDialog$onViewCreated$4$3(FileExportTypeChooseDialog r1, Continuation<? super FileExportTypeChooseDialog$onViewCreated$4$3> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new FileExportTypeChooseDialog$onViewCreated$4$3(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r23) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L11;
        if (r2 == 1) goto L10;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        ResultKt.throwOnFailure(r23);
    L23:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r23);
    L19:
        MainCoroutineDispatcher r3 = Dispatchers.getMain();
        AnonymousClass2 r4 = new AnonymousClass2(this.this$0, null);
        this.label = 3;
        if (BuildersKt.withContext(r3, r4, this) != r1) goto L23;
        return r1;
    L11:
        ResultKt.throwOnFailure(r23);
        LruCache r5 = ko8.a.a;
        String r10 = this.this$0.f.toFileTypeStr();
        int r6 = this.this$0.m.size();
        FileExportTypeChooseDialog r7 = this.this$0;
        String r8 = r7.i;
        long r9 = r7.j;
        String r12 = r7.l;
        String r13 = CollectionsKt.joinToString$default(r7.m, null, null, null, 0, null, new k1(), 31, null);
        FileExportTypeChooseDialog r11 = this.this$0;
        String r14 = r11.o;
        String r15 = r11.r;
        e r16 = r11.V90();
        ko8.a.b(r8, "check_file", r9, r10, Boxing.boxInt(r6), r12, r13, r14, r15, r16, null, 1024);
        FileExportTypeChooseDialog r17 = this.this$0;
        if (r17.f != FileExportType.txt) goto L16;
        this.label = 1;
        if (FileExportTypeChooseDialog.S90(r17, this) != r1) goto L19;
        return r1;
    L16:
        this.label = 2;
        if (FileExportTypeChooseDialog.U90(r17, this) != r1) goto L19;
        return r1;
    }
}
