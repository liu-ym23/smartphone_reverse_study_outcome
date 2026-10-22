package com.larus.drive.sdk.impl.view.chat.fileselect;

import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.platform.api.fileselect.IChatFileSelectionStore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
@DebugMetadata(c = "com.larus.drive.sdk.impl.view.chat.fileselect.DriveFileSelectDialog$pickerCallback$2$1$syncSelectedFiles$1", f = "DriveFileSelectDialog.kt", i = {0, 0}, l = {151, 154}, m = "invokeSuspend", n = {"destination$iv$iv", "file"}, s = {"L$1", "L$3"})
final class DriveFileSelectDialog$pickerCallback$2$1$syncSelectedFiles$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Set<String> $expectedTokens;
    final /* synthetic */ List<DriveFileItem> $fileList;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ DriveFileSelectDialog this$0;
    final /* synthetic */ DriveFileSelectDialog$pickerCallback$2$1 this$1;

    /* JADX INFO: renamed from: com.larus.drive.sdk.impl.view.chat.fileselect.DriveFileSelectDialog$pickerCallback$2$1$syncSelectedFiles$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.drive.sdk.impl.view.chat.fileselect.DriveFileSelectDialog$pickerCallback$2$1$syncSelectedFiles$1$1", f = "DriveFileSelectDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Set<String> $expectedTokens;
        final /* synthetic */ List<Pair<DriveFileItem, Long>> $resolvedFiles;
        int label;
        final /* synthetic */ DriveFileSelectDialog$pickerCallback$2$1 this$0;
        final /* synthetic */ DriveFileSelectDialog this$1;

        public AnonymousClass1(DriveFileSelectDialog$pickerCallback$2$1 r1, Set<String> r2, List<Pair<DriveFileItem, Long>> r3, DriveFileSelectDialog r4, Continuation<? super AnonymousClass1> r5) {
            this.this$0 = r1;
            this.$expectedTokens = r2;
            this.$resolvedFiles = r3;
            this.this$1 = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.this$0, this.$expectedTokens, this.$resolvedFiles, this.this$1, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L30;
            ResultKt.throwOnFailure(r8);
            List<DriveFileItem> r9 = this.this$0.a;
            ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
            Iterator<T> r10 = r9.iterator();
        L6:
            if (r10.hasNext() == false) goto L9;
            r0.add(((DriveFileItem) r10.next()).b);
            goto L6
        L9:
            if (Intrinsics.areEqual(CollectionsKt.toSet(r0), this.$expectedTokens) == false) goto L11;
            List<Pair<DriveFileItem, Long>> r11 = this.$resolvedFiles;
            DriveFileSelectDialog r1 = this.this$1;
            Iterator<T> r12 = r11.iterator();
        L14:
            if (r12.hasNext() == false) goto L28;
            Pair r2 = (Pair) r12.next();
            DriveFileItem r3 = (DriveFileItem) r2.component1();
            long r4 = ((Number) r2.component2()).longValue();
            int r5 = DriveFileSelectDialog.t;
            r1.getClass();
            com.larus.platform.api.u r6 = r1.aa0(DriveFileSelectDialog.ea0(r3, r4), Boxing.boxLong(r4));
            IChatFileSelectionStore.a.a r7 = r1.da0(r6, r4);
            if (r7 != null) goto L17;
            IChatFileSelectionStore.b.b r13 = r1.n.c(r6, IChatFileSelectionStore.Source.DRIVE);
            if ((r13 instanceof IChatFileSelectionStore.b.b) == false) goto L14;
            w79.b r14 = r1.r;
            if (r14 == null) goto L26;
            r14.deselectItem(CollectionsKt.listOf(r3));
        L26:
            r1.ba0(r13.a, r6.f);
            goto L14
        L17:
            r1.n.a(r3.b, IChatFileSelectionStore.Source.DRIVE);
            w79.b r15 = r1.r;
            if (r15 == null) goto L20;
            r15.deselectItem(CollectionsKt.listOf(r3));
        L20:
            r1.ba0(r7, r6.f);
            goto L14
        L28:
            return Unit.INSTANCE;
        L11:
            return Unit.INSTANCE;
        L30:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DriveFileSelectDialog$pickerCallback$2$1$syncSelectedFiles$1(List<DriveFileItem> r1, DriveFileSelectDialog r2, DriveFileSelectDialog$pickerCallback$2$1 r3, Set<String> r4, Continuation<? super DriveFileSelectDialog$pickerCallback$2$1$syncSelectedFiles$1> r5) {
        this.$fileList = r1;
        this.this$0 = r2;
        this.this$1 = r3;
        this.$expectedTokens = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DriveFileSelectDialog$pickerCallback$2$1$syncSelectedFiles$1(this.$fileList, this.this$0, this.this$1, this.$expectedTokens, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0071 -> B:21:0x00a0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x008c -> B:20:0x0094). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r110) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        ResultKt.throwOnFailure(r110);
    L26:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Collection r3 = (Collection) this.L$4;
        DriveFileItem r5 = (DriveFileItem) this.L$3;
        Iterator r6 = (Iterator) this.L$2;
        Collection r7 = (Collection) this.L$1;
        DriveFileSelectDialog r8 = (DriveFileSelectDialog) this.L$0;
        ResultKt.throwOnFailure(r110);
        Object r9 = r110;
        DriveFileSelectDialog r10 = r8;
        Collection r11 = r7;
        Iterator r12 = r6;
        DriveFileSelectDialog$pickerCallback$2$1$syncSelectedFiles$1 r13 = this;
    L20:
        long r14 = ((Number) r9).longValue();
        Iterator r17 = r12;
        DriveFileItem r15 = r5;
        DriveFileSelectDialog$pickerCallback$2$1$syncSelectedFiles$1 r16 = r13;
        Iterator r18 = r17;
    L21:
        r3.add(TuplesKt.to(r15, Boxing.boxLong(r14)));
        r3 = r11;
        DriveFileSelectDialog r20 = r10;
    L12:
        if (r18.hasNext() == false) goto L22;
        r15 = (DriveFileItem) r18.next();
        int r21 = DriveFileSelectDialog.t;
        r20.getClass();
        if (DriveFileSelectDialog.X90(r15) == false) goto L16;
        r14 = r15.e();
        r10 = r20;
        r11 = r3;
        goto L21
    L16:
        r16.L$0 = r20;
        r16.L$1 = r3;
        r16.L$2 = r18;
        r16.L$3 = r15;
        r16.L$4 = r3;
        r16.label = 1;
        r9 = DriveFileSelectDialog.S90(r20, r15, r16);
        if (r9 != r1) goto L19;
        return r1;
    L19:
        r10 = r20;
        r11 = r3;
        Iterator r111 = r18;
        r13 = r16;
        r5 = r15;
        r12 = r111;
        goto L20
    L22:
        List r112 = (List) r3;
        MainCoroutineDispatcher r4 = Dispatchers.getMain();
        AnonymousClass1 r22 = new AnonymousClass1(r16.this$1, r16.$expectedTokens, r112, r16.this$0, null);
        r16.L$0 = null;
        r16.L$1 = null;
        r16.L$2 = null;
        r16.L$3 = null;
        r16.L$4 = null;
        r16.label = 2;
        if (BuildersKt.withContext(r4, r22, r16) != r1) goto L26;
        return r1;
    L10:
        ResultKt.throwOnFailure(r110);
        List<DriveFileItem> r23 = this.$fileList;
        DriveFileSelectDialog r24 = this.this$0;
        ArrayList r25 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10));
        r20 = r24;
        r16 = this;
        r18 = r23.iterator();
        r3 = r25;
        goto L12
    }
}
