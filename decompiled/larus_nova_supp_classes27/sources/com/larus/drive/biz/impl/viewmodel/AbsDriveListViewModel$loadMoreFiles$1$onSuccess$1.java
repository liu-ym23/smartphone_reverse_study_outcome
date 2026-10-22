package com.larus.drive.biz.impl.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.larus.drive.biz.impl.adapter.DriveFileListAdapterFooterState;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel$loadMoreFiles$1$onSuccess$1", f = "AbsDriveListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AbsDriveListViewModel$loadMoreFiles$1$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<DriveFileItem> $driveFileList;
    final /* synthetic */ String $loadMoreLabel;
    int label;
    final /* synthetic */ AbsDriveListViewModel this$0;

    /* JADX INFO: renamed from: com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel$loadMoreFiles$1$onSuccess$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel$loadMoreFiles$1$onSuccess$1$1", f = "AbsDriveListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<DriveFileItem> $driveFileList;
        int label;
        final /* synthetic */ AbsDriveListViewModel this$0;

        public AnonymousClass1(AbsDriveListViewModel r1, List<DriveFileItem> r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$driveFileList = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$driveFileList, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r5);
            FLogger r6 = FLogger.a;
            String r0 = this.this$0.getTag();
            StringBuilder r1 = new StringBuilder("auto loadMore immediately after loading more, fetch size[");
            r1.append(this.this$0.getFileListFetchLength());
            r1.append("], true size[");
            r1.append(this.$driveFileList.size());
            r1.append("], currentTotalSize[");
            List r2 = (List) AbsDriveListViewModel.access$get_files$p(this.this$0).getValue();
            if (r2 == null) goto L7;
            Integer r3 = Boxing.boxInt(r2.size());
        L8:
            r1.append(r3);
            r1.append(']');
            r6.i(r0, r1.toString());
            AbsDriveListViewModel.loadMoreFiles$default(this.this$0, false, 1, null);
            return Unit.INSTANCE;
        L7:
            r3 = null;
            goto L8
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public AbsDriveListViewModel$loadMoreFiles$1$onSuccess$1(AbsDriveListViewModel r1, List<DriveFileItem> r2, String r3, Continuation<? super AbsDriveListViewModel$loadMoreFiles$1$onSuccess$1> r4) {
        this.this$0 = r1;
        this.$driveFileList = r2;
        this.$loadMoreLabel = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AbsDriveListViewModel$loadMoreFiles$1$onSuccess$1(this.this$0, this.$driveFileList, this.$loadMoreLabel, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L30;
        ResultKt.throwOnFailure(r10);
        List r11 = (List) AbsDriveListViewModel.access$get_files$p(this.this$0).getValue();
        if (r11 != null) goto L7;
        r11 = CollectionsKt.emptyList();
    L7:
        int r1 = 0;
        AbsDriveListViewModel.access$setReturnToTopWhenFileListUpdate$p(this.this$0, false);
        List r0 = AbsDriveListViewModel.access$filterOnlyFolderIfRequired(this.this$0, this.$driveFileList);
        MutableLiveData r2 = AbsDriveListViewModel.access$get_hasMore$p(this.this$0);
        if (r0.size() >= this.$driveFileList.size()) goto L11;
        Boolean r3 = Boxing.boxBoolean(false);
    L15:
        r2.setValue(r3);
        AbsDriveListViewModel.access$get_files$p(this.this$0).setValue(CollectionsKt.plus(r11, AbsDriveListViewModel.access$removeExcludedFolder(this.this$0, r0)));
        AbsDriveListViewModel r12 = this.this$0;
        if (Intrinsics.areEqual(AbsDriveListViewModel.access$get_hasMore$p(r12).getValue(), Boxing.boxBoolean(true)) == false) goto L18;
        String r4 = this.$loadMoreLabel;
    L19:
        AbsDriveListViewModel.access$setLoadMoreFileListLabel$p(r12, r4);
        FLogger.a.i(this.this$0.getTag(), "loadMoreFiles: loaded " + this.$driveFileList.size() + " items");
        AbsDriveListViewModel.access$get_loadMoreState$p(this.this$0).setValue(DriveFileListAdapterFooterState.IDLE);
        if (Intrinsics.areEqual(AbsDriveListViewModel.access$get_hasMore$p(this.this$0).getValue(), Boxing.boxBoolean(true)) == false) goto L28;
        List r13 = (List) AbsDriveListViewModel.access$get_files$p(this.this$0).getValue();
        if (r13 == null) goto L25;
        r1 = r13.size();
    L25:
        if (r1 >= this.this$0.getFileListFetchLength()) goto L28;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), null, null, new AnonymousClass1(this.this$0, this.$driveFileList, null), 3, null);
    L28:
        return Unit.INSTANCE;
    L18:
        r4 = null;
        goto L19
    L11:
        if (this.$loadMoreLabel == null) goto L13;
        boolean r5 = true;
    L14:
        r3 = Boxing.boxBoolean(r5);
        goto L15
    L13:
        r5 = false;
        goto L14
    L30:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
