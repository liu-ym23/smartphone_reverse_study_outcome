package com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file;

import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.vfs.VFSFile;
import java.io.File;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.MmRecordFileHelper$listRecordingPartFileNames$2", f = "MmRecordFileHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordFileHelper$listRecordingPartFileNames$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends String>>, Object> {
    final /* synthetic */ String $recordingId;
    final /* synthetic */ String $userId;
    int label;

    public MmRecordFileHelper$listRecordingPartFileNames$2(String r1, String r2, Continuation<? super MmRecordFileHelper$listRecordingPartFileNames$2> r3) {
        this.$userId = r1;
        this.$recordingId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmRecordFileHelper$listRecordingPartFileNames$2(this.$userId, this.$recordingId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<String>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L26;
        ResultKt.throwOnFailure(r6);
        MmRecordFileHelper r7 = MmRecordFileHelper.a;
        String r0 = this.$userId;
        String r1 = this.$recordingId;
        r7.getClass();
        VFSFile r8 = MmRecordFileHelper.f(r0, r1);
        if (r8.exists() == false) goto L24;
        if (r8.isDirectory() == false) goto L24;
        File[] r9 = r8.listFiles();
        if (r9 == null) goto L22;
        ArrayList r2 = new ArrayList();
        int r3 = r9.length;
        int r4 = 0;
    L12:
        if (r4 >= r3) goto L17;
        File r5 = r9[r4];
        if (r5.isFile() == false) goto L16;
        r2.add(r5);
    L16:
        r4 = r4 + 1;
        goto L12
    L17:
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r11 = r2.iterator();
    L19:
        if (r11.hasNext() == false) goto L31;
        r10.add(((VFSFile) r11.next()).getName());
        goto L19
    L31:
        return r10;
    L22:
        return CollectionsKt.emptyList();
    L24:
        return CollectionsKt.emptyList();
    L26:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
