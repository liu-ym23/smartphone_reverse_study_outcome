package com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file;

import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.vfs.VFSFile;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.MmRecordFileHelper$deleteRecordingPartDir$2", f = "MmRecordFileHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordFileHelper$deleteRecordingPartDir$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $recordingId;
    final /* synthetic */ String $userId;
    int label;

    public MmRecordFileHelper$deleteRecordingPartDir$2(String r1, String r2, Continuation<? super MmRecordFileHelper$deleteRecordingPartDir$2> r3) {
        this.$userId = r1;
        this.$recordingId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmRecordFileHelper$deleteRecordingPartDir$2(this.$userId, this.$recordingId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.util.ArrayList] */
    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L26;
        ResultKt.throwOnFailure(r9);
        boolean r10 = false;
        MmRecordFileHelper r2 = MmRecordFileHelper.a;     // Catch: Throwable -> L21
        String r3 = this.$userId;     // Catch: Throwable -> L21
        String r4 = this.$recordingId;     // Catch: Throwable -> L21
        r2.getClass();     // Catch: Throwable -> L21
        VFSFile r5 = MmRecordFileHelper.f(r3, r4);     // Catch: Throwable -> L21
        boolean r6 = true;
        if (r5.exists() == true) goto L9;
        lvb.a.e("MmRecordFileHelper", "[deleteRecordingPartDir] skip, dir not exists, recordingId=" + this.$recordingId);     // Catch: Throwable -> L21
        return Boxing.boxBoolean(true);
    L9:
        File[] r1 = r5.listFiles();     // Catch: Throwable -> L21
        if (r1 == null) goto L14;
        Object r7 = new ArrayList(r1.length);     // Catch: Throwable -> L21
        int r8 = r1.length;     // Catch: Throwable -> L21
        int r11 = 0;
    L12:
        if (r11 >= r8) goto L15;
        r7.add(r1[r11].getName());     // Catch: Throwable -> L21
        r11 = r11 + 1;     // Catch: Throwable -> L21
    L15:
        boolean r12 = FilesKt.deleteRecursively(r5);     // Catch: Throwable -> L21
        StringBuilder r13 = new StringBuilder();     // Catch: Throwable -> L21
        r13.append("[deleteRecordingPartDir] recordingId=");     // Catch: Throwable -> L21
        r13.append(this.$recordingId);     // Catch: Throwable -> L21
        r13.append(", deleted=");     // Catch: Throwable -> L21
        if (r12 == true) goto L19;
        r6 = false;
    L19:
        r13.append(r6);     // Catch: Throwable -> L21
        r13.append(", files=");     // Catch: Throwable -> L21
        r13.append(r7);     // Catch: Throwable -> L21
        lvb.a.e("MmRecordFileHelper", r13.toString());     // Catch: Throwable -> L21
        r10 = r12;
    L24:
        return Boxing.boxBoolean(r10);
    L14:
        r7 = CollectionsKt.emptyList();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        lvb.a.b("MmRecordFileHelper", "[deleteRecordingPartDir] error, userId=" + this.$userId + ", recordingId=" + this.$recordingId + ", error=" + th);
        goto L24
    L26:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
