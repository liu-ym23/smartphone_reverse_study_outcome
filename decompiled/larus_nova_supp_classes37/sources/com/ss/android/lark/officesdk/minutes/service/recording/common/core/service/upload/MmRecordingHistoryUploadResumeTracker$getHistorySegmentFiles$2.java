package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload;

import com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.MmRecordFileHelper;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.vfs.VFSFile;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/vfs/VFSFile;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingHistoryUploadResumeTracker$getHistorySegmentFiles$2", f = "MmRecordingHistoryUploadResumeTracker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingHistoryUploadResumeTracker$getHistorySegmentFiles$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends VFSFile>>, Object> {
    final /* synthetic */ String $meetingId;
    final /* synthetic */ String $userId;
    int label;

    public MmRecordingHistoryUploadResumeTracker$getHistorySegmentFiles$2(String r1, String r2, Continuation<? super MmRecordingHistoryUploadResumeTracker$getHistorySegmentFiles$2> r3) {
        this.$userId = r1;
        this.$meetingId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmRecordingHistoryUploadResumeTracker$getHistorySegmentFiles$2(this.$userId, this.$meetingId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<VFSFile>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.ArrayList] */
    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L22;
        ResultKt.throwOnFailure(r8);
        MmRecordFileHelper r9 = MmRecordFileHelper.a;
        String r0 = this.$userId;
        String r1 = this.$meetingId;
        r9.getClass();
        File[] r10 = MmRecordFileHelper.f(r0, r1).listFiles();
        if (r10 == null) goto L18;
        ?? r2 = new ArrayList();
        int r3 = r10.length;
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L19;
        File r5 = r10[r4];
        if (Intrinsics.areEqual(FilesKt.getExtension(r5), "ogg") == false) goto L11;
    L14:
        boolean r6 = true;
    L15:
        if (r6 == false) goto L17;
        r2.add(r5);
    L17:
        r4 = r4 + 1;
        goto L7
    L11:
        if (Intrinsics.areEqual(FilesKt.getExtension(r5), "pcm") == true) goto L14;
        r6 = false;
    L19:
        lvb.a.e("MmHistoryUploadResumeTracker", "[getHistorySegmentFiles] meetingId=" + this.$meetingId + ", segmentCount=" + r2.size());
        return r2;
    L18:
        r2 = CollectionsKt.emptyList();
        goto L19
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
