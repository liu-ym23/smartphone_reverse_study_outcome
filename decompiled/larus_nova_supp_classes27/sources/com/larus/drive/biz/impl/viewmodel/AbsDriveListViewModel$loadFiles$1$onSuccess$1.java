package com.larus.drive.biz.impl.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.utils.logger.FLogger;
import java.util.List;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel$loadFiles$1$onSuccess$1", f = "AbsDriveListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AbsDriveListViewModel$loadFiles$1$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<DriveFileItem> $driveFileList;
    final /* synthetic */ String $loadMoreLabel;
    int label;
    final /* synthetic */ AbsDriveListViewModel this$0;

    /* JADX INFO: renamed from: com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel$loadFiles$1$onSuccess$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel$loadFiles$1$onSuccess$1$1", f = "AbsDriveListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r4);
            FLogger.a.i(this.this$0.getTag(), "auto loadMore immediately after first loading, fetch size[" + this.this$0.getFileListFetchLength() + "], true size[" + this.$driveFileList.size() + ']');
            AbsDriveListViewModel.loadMoreFiles$default(this.this$0, false, 1, null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public AbsDriveListViewModel$loadFiles$1$onSuccess$1(AbsDriveListViewModel r1, List<DriveFileItem> r2, String r3, Continuation<? super AbsDriveListViewModel$loadFiles$1$onSuccess$1> r4) {
        this.this$0 = r1;
        this.$driveFileList = r2;
        this.$loadMoreLabel = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AbsDriveListViewModel$loadFiles$1$onSuccess$1(this.this$0, this.$driveFileList, this.$loadMoreLabel, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L27;
        ResultKt.throwOnFailure(r9);
        AbsDriveListViewModel.access$setReturnToTopWhenFileListUpdate$p(this.this$0, true);
        List r10 = AbsDriveListViewModel.access$filterOnlyFolderIfRequired(this.this$0, this.$driveFileList);
        MutableLiveData r1 = AbsDriveListViewModel.access$get_hasMore$p(this.this$0);
        int r4 = 0;
        if (r10.size() >= this.$driveFileList.size()) goto L8;
        Boolean r2 = Boxing.boxBoolean(false);
    L12:
        r1.setValue(r2);
        AbsDriveListViewModel.access$get_files$p(this.this$0).setValue(AbsDriveListViewModel.access$removeExcludedFolder(this.this$0, r10));
        AbsDriveListViewModel r11 = this.this$0;
        if (Intrinsics.areEqual(AbsDriveListViewModel.access$get_hasMore$p(r11).getValue(), Boxing.boxBoolean(true)) == false) goto L15;
        String r0 = this.$loadMoreLabel;
    L16:
        AbsDriveListViewModel.access$setLoadMoreFileListLabel$p(r11, r0);
        FLogger.a.i(this.this$0.getTag(), "loadFiles: loaded " + this.$driveFileList.size() + " items");
        AbsDriveListViewModel.access$saveLocalInitialData(this.this$0, this.$driveFileList);
        AbsDriveListViewModel.access$get_isLoading$p(this.this$0).setValue(Boxing.boxBoolean(false));
        List r12 = (List) AbsDriveListViewModel.access$get_files$p(this.this$0).getValue();
        if (r12 == null) goto L20;
        r4 = r12.size();
    L20:
        if (r4 >= this.this$0.getFileListFetchLength()) goto L25;
        if (this.$loadMoreLabel == null) goto L25;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), null, null, new AnonymousClass1(this.this$0, this.$driveFileList, null), 3, null);
    L25:
        return Unit.INSTANCE;
    L15:
        r0 = null;
        goto L16
    L8:
        if (this.$loadMoreLabel == null) goto L10;
        boolean r3 = true;
    L11:
        r2 = Boxing.boxBoolean(r3);
        goto L12
    L10:
        r3 = false;
        goto L11
    L27:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
