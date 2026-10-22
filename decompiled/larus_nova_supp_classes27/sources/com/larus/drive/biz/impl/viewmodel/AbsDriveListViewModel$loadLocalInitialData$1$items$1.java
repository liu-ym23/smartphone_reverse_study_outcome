package com.larus.drive.biz.impl.viewmodel;

import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.biz.impl.database.DriveDatabase;
import com.larus.drive.sdk.api.file.DriveFileItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/larus/drive/sdk/api/file/DriveFileItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel$loadLocalInitialData$1$items$1", f = "AbsDriveListViewModel.kt", i = {}, l = {314, 333}, m = "invokeSuspend", n = {}, s = {})
public final class AbsDriveListViewModel$loadLocalInitialData$1$items$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends DriveFileItem>>, Object> {
    int label;
    final /* synthetic */ AbsDriveListViewModel this$0;

    public AbsDriveListViewModel$loadLocalInitialData$1$items$1(AbsDriveListViewModel r1, Continuation<? super AbsDriveListViewModel$loadLocalInitialData$1$items$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AbsDriveListViewModel$loadLocalInitialData$1$items$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<DriveFileItem>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        ResultKt.throwOnFailure(r21);
        Object r3 = r21;
    L27:
        Iterable r4 = (Iterable) r3;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r6 = r4.iterator();
    L29:
        if (r6.hasNext() == false) goto L42;
        l79.a r7 = (l79.a) r6.next();
        DriveFileType.a r8 = DriveFileType.Companion;
        String r9 = r7.i;
        r8.getClass();
        DriveFileType r10 = DriveFileType.a.a(r9);
        if (r10 != null) goto L33;
        r10 = DriveFileType.UNKNOWN;
    L33:
        DriveFileType r17 = r10;
        String r11 = r7.d;
        String r12 = r7.a;
        String r13 = r7.b;
        String r14 = r7.e;
        long r15 = r7.f;
        long r16 = r7.g;
        int r18 = r17.getIconResId();
        String r20 = r7.h;
        int r22 = r7.j;
        r5.add(new DriveFileItem(r11, r12, r13, r7.k, r14, r15, r16, r18, r20, r17, r22, r7.l));
        goto L29
    L42:
        return r5;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r21);
        Object r23 = r21;
    L15:
        Iterable r24 = (Iterable) r23;
        ArrayList r25 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r24, 10));
        Iterator r26 = r24.iterator();
    L17:
        if (r26.hasNext() == false) goto L43;
        l79.b r27 = (l79.b) r26.next();
        DriveFileType.a r28 = DriveFileType.Companion;
        String r30 = r27.i;
        r28.getClass();
        DriveFileType r31 = DriveFileType.a.a(r30);
        if (r31 != null) goto L21;
        r31 = DriveFileType.UNKNOWN;
    L21:
        DriveFileType r110 = r31;
        String r32 = r27.d;
        String r33 = r27.a;
        String r34 = r27.b;
        String r111 = r27.e;
        long r112 = r27.f;
        long r113 = r27.g;
        int r114 = r110.getIconResId();
        String r35 = r27.h;
        int r36 = r27.j;
        Iterator r210 = r26;
        r25.add(new DriveFileItem(r32, r33, r34, r27.k, r111, r112, r113, r114, r35, r110, r36, r27.l));
        r26 = r210;
        goto L17
    L43:
        return r25;
    L10:
        ResultKt.throwOnFailure(r21);
        DriveDatabase r37 = DriveDatabase.a.a();
        AbsDriveListViewModel r38 = this.this$0;
        if ((r38 instanceof DriveRecentListViewModel) == false) goto L23;
        l79.h r40 = r37.d();
        this.label = 1;
        r23 = r40.a(this);
        if (r23 != r1) goto L15;
        return r1;
    L23:
        if ((r38 instanceof DriveMineListViewModel) == false) goto L35;
        l79.c r41 = r37.c();
        this.label = 2;
        r3 = r41.a(this);
        if (r3 != r1) goto L27;
        return r1;
    L35:
        return CollectionsKt.emptyList();
    }
}
